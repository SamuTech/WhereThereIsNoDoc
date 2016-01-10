package com.marvik.apps.wherethereisnodoc.activities;

import android.os.Bundle;

import com.marvik.apps.coreutils.activities.ActivityWrapper;
import com.marvik.apps.wherethereisnodoc.R;

/**
 * Created by victor on 1/10/2016.
 */
public class MainActivity extends ActivityWrapper {

    /**
     * Performs initialization of all loaders
     * Called when the activity is created
     *
     * @param savedInstanceState
     */
    @Override
    protected void onCreateActivity(Bundle savedInstanceState) {
        setContentView(R.layout.activity_main);
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

    private int getContainerParentLayoutResId(){
        return R.id.activity_main_frameLayout_parent_container;
    }
}
