package com.marvik.apps.wherethereisnodoc.database.transactionsmanager;

import android.content.Context;

import com.marvik.apps.coreutils.utils.Utils;
import com.marvik.apps.wherethereisnodoc.database.tables.Tables;
import com.marvik.apps.wherethereisnodoc.database.transactionsmanager.crud.firstaids.FirstAidsCRUD;
import com.marvik.apps.wherethereisnodoc.datamodels.firstaids.FirstAidsInfo;

/**
 * Created by victor on 1/10/2016.
 */
public class TransactionsManager {

    private Utils utils;

    private Context context;

    public TransactionsManager(Context context) {
        this.context = context;

        initAll(context);
    }

    public Utils getUtils() {
        return utils;
    }

    public Context getContext() {
        return context;
    }

    private FirstAidsCRUD firstAidsCRUD;

    private void initAll(Context context) {
        firstAidsCRUD = new FirstAidsCRUD(context);
    }

    public FirstAidsCRUD getFirstAidsCRUD() {
        return firstAidsCRUD;
    }

    public void insertFirstAids(FirstAidsInfo firstAidsInfo) {

        //Check if the id exists - insert only if the id does not exist
        if (!getUtils().getDatabaseUtilities().isExists(Tables.FirstAids.CONTENT_URI,
                new String[]{Tables.FirstAids.ID_FIRSTAID},
                new String[]{"" + firstAidsInfo.firstaidId})) {
            getFirstAidsCRUD().insertFirstAids(firstAidsInfo);
        }

    }
}