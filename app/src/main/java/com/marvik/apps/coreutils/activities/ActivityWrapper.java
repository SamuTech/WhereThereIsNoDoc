package com.marvik.apps.coreutils.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

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
    public Utilities getUtils() {
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
        mActivityTitle.setText(activityTitle);
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

    private void initAll() {
        utils = new Utilities(ActivityWrapper.this);
        attachActionBar();
    }

    private View customActionBar;
    private ImageView mDrawerHandle;
    private TextView mActivityTitle;

    private void attachActionBar() {


    }


    public View getDrawerHandle() {
        return mDrawerHandle;
    }

    @Override
    public void onClick(View v) {

    }


}
