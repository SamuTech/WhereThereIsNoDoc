package com.marvik.apps.coreutils.activities;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.marvik.apps.wherethereisnodoc.R;
import com.marvik.apps.wherethereisnodoc.utilities.Utilities;

/**
 * Created by victor on 8/24/2015.
 */
public abstract class ActivityWrapper extends AppCompatActivity implements View.OnClickListener,
        com.marvik.apps.coreutils.fragments.FragmentWrapper.OnCreateFragment {

    private Utilities utils;

    /**
     * Utils#getUtilities
     *
     * @return an instance of the utils class
     */
    public Utilities getUtilities() {
        return utils;
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initAll();
        onCreateActivity(savedInstanceState);

    }

    @Override
    protected void onResume() {
        super.onResume();
        onResumeActivity();
    }

    @Override
    protected void onPause() {
        super.onPause();
        onPauseActivity();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        onDestroyActivity();
    }

    @Override
    public void setActivityTitle(String activityTitle) {
        if(activityTitle == null){
            setTitle(getUtilities().getString(R.string.app_name));
            return;
        }
        setTitle(activityTitle);
    }

    @Override
    public void onBackPressed() {
        detachFragment();
    }

    /**
     * Performs initialization of all loaders
     * Called when the activity is created
     *
     * @param savedInstanceState
     */
    protected abstract void onCreateActivity(Bundle savedInstanceState);

    /**
     * Called when the activity is resumed
     */
    protected abstract void onResumeActivity();

    /**
     * Called when the activity is paused
     */
    protected abstract void onPauseActivity();

    /**
     * Called when the activity is destroyed
     */
    protected abstract void onDestroyActivity();

    /**
     *
     */
    public abstract int getFragmentsContainerId();


    private void initAll() {
        utils = new Utilities(ActivityWrapper.this);
    }

    public void attachFragment(@NonNull Fragment fragment, boolean addToBackStack) {
        if (addToBackStack)
            getFragmentManager().beginTransaction().replace(getFragmentsContainerId(), fragment).addToBackStack(getPackageName()).commit();
        else
            getFragmentManager().beginTransaction().replace(getFragmentsContainerId(), fragment).commit();

    }

    private void clearBackStack() {
        if (getFragmentManager().getBackStackEntryCount() > 1) {
            getFragmentManager().popBackStackImmediate();
        }

    }

    private void clearBackStackAll() {
        int backStacks = getFragmentManager().getBackStackEntryCount();
        for (int i = backStacks; i < 0; i--) {
            getFragmentManager().popBackStack();
        }
    }

    private void detachFragment() {
        if (getFragmentManager().getBackStackEntryCount() > 1)
            getFragmentManager().popBackStack();
        else finish();
    }
}
