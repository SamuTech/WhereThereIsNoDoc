package com.marvik.apps.wherethereisnodoc.activities;

import android.os.Bundle;
import android.view.View;

import com.marvik.apps.coreutils.activities.ActivityWrapper;
import com.marvik.apps.wherethereisnodoc.R;
import com.marvik.apps.wherethereisnodoc.fragments.firstaids.FirstAidsFragment;
import com.marvik.apps.wherethereisnodoc.fragments.firstaidsailments.FirstAidAilmentsFragment;
import com.marvik.apps.wherethereisnodoc.intents.Intents;

/**
 * Created by victor on 1/10/2016.
 */
public class MainActivity extends ActivityWrapper implements FirstAidAilmentsFragment.FirstAidAilmentsItemClickCallbacks {

    /**
     * Performs initialization of all loaders
     * Called when the activity is created
     *
     * @param savedInstanceState
     */
    @Override
    protected void onCreateActivity(Bundle savedInstanceState) {
        setContentView(R.layout.activity_main);

        //attach the ailments fragment
        attachFragment(new FirstAidAilmentsFragment(), true);
    }

    /**
     * Called when the activity is resumed
     */
    @Override
    protected void onResumeActivity() {

    }

    /**
     * Called when the activity is paused
     */
    @Override
    protected void onPauseActivity() {

    }

    /**
     * Called when the activity is destroyed
     */
    @Override
    protected void onDestroyActivity() {

    }

    /**
     *
     */
    @Override
    public int getFragmentsContainerId() {
        return R.id.activity_main_frameLayout_parent_container;
    }

    @Override
    public void onFirstAidAilmentsClick(int firstAidId) {
        FirstAidsFragment firstAidsFragment = new FirstAidsFragment();
        Bundle args = new Bundle();
        args.putInt(Intents.Extras.EXTRA_FIRST_AID_ID, firstAidId);
        firstAidsFragment.setArguments(args);
        attachFragment(firstAidsFragment, true);
    }

    /**
     * Called when a view has been clicked.
     *
     * @param v The view that was clicked.
     */
    @Override
    public void onClick(View v) {

    }
}
