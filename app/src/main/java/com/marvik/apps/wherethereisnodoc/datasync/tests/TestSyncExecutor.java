package com.marvik.apps.wherethereisnodoc.datasync.tests;

import android.content.Context;

import com.marvik.apps.coreutils.utils.Utils;
import com.marvik.apps.wherethereisnodoc.database.tables.Tables;
import com.marvik.apps.wherethereisnodoc.database.transactionsmanager.crud.firstaids.FirstAidsCRUD;
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


    public void syncFirstAids(Utils utils) {
        FirstAidWebServices firstAidWebServices = null;
        FirstAidsCRUD firstAidsCRUD = null;
        try {
            firstAidsCRUD = new FirstAidsCRUD(getContext());
            firstAidWebServices = new FirstAidWebServices(getContext(), URLs.FirstAids.FIRST_AIDS_WEBSERVICES_URL, Queries.FirstAids.ALL_FIRST_AIDS);
            JSONObject[] firstAids = firstAidWebServices.getFirstAidsJSON(firstAidWebServices.getTestFirstAidsJSON(utils));

            for (JSONObject firstAid : firstAids) {

                FirstAidsInfo firstAidsInfo = firstAidWebServices.getFirstAidIn(firstAid);

                //Check if the id exists - insert only if the id does not exist
                if (!utils.getDatabaseUtilities().isExists(Tables.FirstAids.CONTENT_URI,
                        new String[]{Tables.FirstAids.ID_FIRSTAID},
                        new String[]{"" + firstAidsInfo.firstaidId})) {

                    firstAidsCRUD.insertFirstAids(firstAidsInfo);
                }

            }


        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
