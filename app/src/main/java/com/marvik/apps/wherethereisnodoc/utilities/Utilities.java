package com.marvik.apps.wherethereisnodoc.utilities;

import android.content.Context;

import com.marvik.apps.coreutils.utils.Utils;
import com.marvik.apps.wherethereisnodoc.datasync.tests.TestSyncExecutor;
import com.marvik.apps.wherethereisnodoc.webservices.manager.WebServicesManager;

/**
 * Created by victor on 1/11/2016.
 */
public class Utilities extends Utils {

    private TestSyncExecutor testSyncExecutor;

    private WebServicesManager webServicesManager;

    private Context context;

    public Utilities(Context context) {
        super(context);
        this.context = context;

        initAll();

    }

    public Utils getUtils() {
        return this;
    }

    public WebServicesManager getWebServicesManager() {
        return webServicesManager;
    }

    public Context getContext() {
        return context;
    }

    public TestSyncExecutor getTestSyncExecutor() {
        return testSyncExecutor;
    }

    private void initAll() {
        testSyncExecutor = new TestSyncExecutor(getContext());
        webServicesManager = new WebServicesManager(getContext());
    }
}
