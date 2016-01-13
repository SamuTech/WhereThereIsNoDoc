package com.marvik.apps.wherethereisnodoc.datasync.tests;

import android.content.Context;

import com.marvik.apps.wherethereisnodoc.database.tables.Tables;
import com.marvik.apps.wherethereisnodoc.database.transactionsmanager.manager.TransactionsManager;
import com.marvik.apps.wherethereisnodoc.datamodels.firstaids.FirstAidsInfo;
import com.marvik.apps.wherethereisnodoc.datasync.queries.Queries;
import com.marvik.apps.wherethereisnodoc.datasync.urls.URLs;
import com.marvik.apps.wherethereisnodoc.webservices.firstaids.FirstAidWebServices;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by victor on 1/10/2016.
 */
public class TestSyncExecutor {


    private Context context;

    public TestSyncExecutor(Context context) {
        this.context = context;

    }

    public Context getContext() {
        return context;
    }


    public void syncFirstAids(TransactionsManager transactionsManager) {
        FirstAidWebServices firstAidWebServices = null;

        try {
            firstAidWebServices = new FirstAidWebServices(getContext(), URLs.FirstAids.FIRST_AIDS_WEBSERVICES_URL, Queries.FirstAids.ALL_FIRST_AIDS);
            JSONObject[] firstAids = firstAidWebServices.getFirstAidsJSON(firstAidWebServices.getTestFirstAidsJSON(transactionsManager.getUtils()));

            for (JSONObject firstAid : firstAids) {

                FirstAidsInfo firstAidsInfo = firstAidWebServices.getFirstAidIn(firstAid);

                //Check if the id exists - insert only if the id does not exist
                if (!transactionsManager.getUtils().getDatabaseUtilities().isExists(Tables.FirstAids.CONTENT_URI,
                        new String[]{Tables.FirstAids.ID_FIRSTAID},
                        new String[]{"" + firstAidsInfo.firstaidId})) {

                    transactionsManager.getFirstAidsCRUD().insertFirstAids(firstAidsInfo);
                }

            }


        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
