package com.marvik.apps.wherethereisnodoc.utilities;

import android.content.Context;

import com.marvik.apps.coreutils.utils.Utils;
import com.marvik.apps.wherethereisnodoc.database.transactionsmanager.TransactionsManager;
import com.marvik.apps.wherethereisnodoc.database.transactionsmanager.dataqueries.DataQueries;
import com.marvik.apps.wherethereisnodoc.webservices.manager.WebServicesManager;

/**
 * Created by victor on 1/11/2016.
 */
public class Utilities extends Utils {

    private TransactionsManager transactionsManager;

    private WebServicesManager webServicesManager;

    private DataQueries dataQueries;

    private Context context;

    public Utilities(Context context) {
        super(context);
        this.context = context;

        initAll();

    }

    public TransactionsManager getTransactionsManager() {
        return transactionsManager;
    }

    public Utils getUtils() {
        return this;
    }

    public WebServicesManager getWebServicesManager() {
        return webServicesManager;
    }

    public DataQueries getDataQueries() {
        return dataQueries;
    }

    public Context getContext() {
        return context;
    }

    private void initAll() {
        webServicesManager = new WebServicesManager(getContext());
        transactionsManager = new TransactionsManager(getContext());
        dataQueries = new DataQueries(getContext());
    }
}
