package com.marvik.apps.coreutils.fragments;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import com.marvik.apps.wherethereisnodoc.R;
import com.marvik.apps.wherethereisnodoc.database.transactionsmanager.manager.TransactionsManager;
import com.marvik.apps.wherethereisnodoc.utilities.Utilities;

/**
 * Created by victor on 8/24/2015.
 */
public abstract class FragmentWrapper extends Fragment {

    private View wrapper;
    private RelativeLayout rlParentContainer;

    private OnCreateFragment onCreateFragment;

    private Utilities utilities;
    private TransactionsManager transactionsManager;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initLibraries();
        onCreateFragment(savedInstanceState);
        receiveBundle();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        wrapper = getActivity().getLayoutInflater().inflate(R.layout.fragment_wrapper, container, false);
        initViews(wrapper);
        getContainer().addView(initFragmentViews(onCreateFragmentView(inflater, container, savedInstanceState)));
        consumeBundle();
        attachViewsData();
        return wrapper;
    }


    @Override
    public void onResume() {
        super.onResume();
        onResumeFragment();
        performPartialSync();
        onCreateFragment.setActivityTitle(getActivityTitle());
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        onCreateFragment = (OnCreateFragment) getActivity();
        onAttachFragment();
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        onCreateFragment = (OnCreateFragment) getActivity();
        onAttachFragment();
    }

    @Override
    public void onPause() {
        super.onPause();
        onPauseFragment();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        onDestroyFragment();
    }

    private void initLibraries() {
        initAll();
    }

    private void initViews(@NonNull View view) {
        rlParentContainer = (RelativeLayout) view.findViewById(R.id.fragment_wrapper_relativeLayout_wrapper);
    }

    public RelativeLayout getContainer() {
        return rlParentContainer;
    }


    /**
     * Called when the fragment is created
     *
     * @param savedInstanceState
     */
    public abstract void onCreateFragment(@Nullable Bundle savedInstanceState);

    /**
     * Used for setting the title of the Activity
     *
     * @return activity title
     */
    @Nullable
    public abstract String getActivityTitle();

    /**
     * Callback used to receive any bundle passed to the fragment when this fragment was created
     */
    public abstract void receiveBundle();

    /**
     * Used for creating a custom view for the fragment
     *
     * @param inflater
     * @param container
     * @param savedInstanceState
     */
    @Nullable
    public abstract View onCreateFragmentView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState);

    /**
     * Initializes the child views for the fragment being created.
     */

    public abstract View initFragmentViews(View view);

    /**
     * Callback used to hold methods that consume all the contents of the bundle passed to the fragment
     */
    public abstract void consumeBundle();

    /**
     * Callback called to attach data to all the views in the fragment
     */
    public abstract void attachViewsData();

    /**
     * Called when a fragment is first attached to its context.
     * {#onCreate(Bundle)} will be called after this.
     */
    public abstract void onAttachFragment();

    /**
     * Called when the fragment is visible to the user and actively running.
     * This is generally
     * tied to {Activity#onResume() Activity.onResume} of the containing
     * Activity's lifecycle.
     */
    public abstract void onResumeFragment();

    /**
     * Called to provide implementation to initiate the syncing of the contents of the current fragment
     */
    public abstract void performPartialSync();

    /**
     * Called when only the contents of the current fragment are synced
     */
    public abstract void onPerformPartialSync();

    /**
     * Called when the Fragment is no longer resumed.  This is generally
     * tied to  Activity#onPause() Activity.onPause} of the containing
     * Activity's lifecycle.
     */
    public abstract void onPauseFragment();

    /**
     * Called when the fragment is no longer in use.  This is called
     * after onStop()} and before onDetach()}.
     */
    public abstract void onDestroyFragment();

    /**
     * Returns the layout resource id for the layout used to populate the view for this fragment
     *
     * @return the layout resource id
     */
    public abstract int getParentLayout();


    private Utilities utils;

    public Utilities getUtilities() {
        return utils;
    }

    public TransactionsManager getTransactionsManager() {
        return transactionsManager;
    }

    private void initAll() {
        utils = new Utilities(getActivity());
        transactionsManager = new TransactionsManager(getActivity());

    }

    public interface OnCreateFragment {
        void setActivityTitle(String activityTitle);
    }
}
