package com.marvik.apps.wherethereisnodoc.webservices.manager;

import android.content.Context;

import com.marvik.apps.wherethereisnodoc.database.transactionsmanager.manager.TransactionsManager;
import com.marvik.apps.wherethereisnodoc.datasync.queries.Queries;
import com.marvik.apps.wherethereisnodoc.datasync.urls.URLs;
import com.marvik.apps.wherethereisnodoc.webservices.firstaids.FirstAidWebServices;

/**
 * Created by victor on 1/11/2016.
 */
public class WebServicesManager {



    private FirstAidWebServices firstAidWebServices;

    private Context context;

    public WebServicesManager(Context context) {
        this.context = context;

        initAll();
    }

    public Context getContext() {
        return context;
    }

    public FirstAidWebServices getFirstAidWebServices() {
        return firstAidWebServices;
    }

    private void initAll() {

        firstAidWebServices = new FirstAidWebServices(getContext(),URLs.FirstAids.FIRST_AIDS_WEBSERVICES_URL, Queries.FirstAids.ALL_FIRST_AIDS);

    }

    public void testSyncFirstAids(TransactionsManager transactionsManager) {
        transactionsManager.getUtils().getTestSyncExecutor().syncFirstAids(transactionsManager);
    }
}
