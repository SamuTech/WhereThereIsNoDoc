package com.marvik.apps.wherethereisnodoc.database.transactionsmanager.dataqueries;

import android.content.Context;
import android.database.Cursor;

import com.marvik.apps.wherethereisnodoc.database.tables.Tables;
import com.marvik.apps.wherethereisnodoc.database.transactionsmanager.TransactionsManager;
import com.marvik.apps.wherethereisnodoc.database.transactionsmanager.crud.firstaids.FirstAidsCRUD;
import com.marvik.apps.wherethereisnodoc.datamodels.firstaids.FirstAidsInfo;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by victor on 1/11/2016.
 */
public class DataQueries {

    private TransactionsManager transactionsManager;

    private FirstAidsCRUD firstAidsCRUD;

    private Context context;

    public DataQueries(Context context) {
        this.context = context;
        transactionsManager = new TransactionsManager(context);
    }

    public Context getContext() {
        return context;
    }

    public FirstAidsCRUD getFirstAidsCRUD() {
        return firstAidsCRUD;
    }

    public TransactionsManager getTransactionsManager() {
        return transactionsManager;
    }

    public List<FirstAidsInfo> getAllFistAids() {
        List<FirstAidsInfo> firstAidsInfos = new ArrayList<>();
        Cursor cursor = getTransactionsManager().getFirstAidsCRUD().query(null, null, null, null);

       // Toast.makeText(getContext(),"Cursor Size:" + cursor.getCount(),Toast.LENGTH_SHORT).show();

        if (cursor != null) {
            for (cursor.moveToFirst(); !cursor.isAfterLast(); cursor.moveToNext()) {

                int firstaidId = cursor.getInt(cursor.getColumnIndex(Tables.FirstAids.ID_FIRSTAID));
                String ailment = cursor.getString(cursor.getColumnIndex(Tables.FirstAids.AILMENT));
                String ailmentInformation = cursor.getString(cursor.getColumnIndex(Tables.FirstAids.AILMENT_INFORMATION));
                String ailmentCauses = cursor.getString(cursor.getColumnIndex(Tables.FirstAids.AILMENT_CAUSES));

                String ailmentPrevention = cursor.getString(cursor.getColumnIndex(Tables.FirstAids.AILMENT_PREVENTION));
                String ailmentSigns = cursor.getString(cursor.getColumnIndex(Tables.FirstAids.AILMENT_SIGNS));
                String ailmentSymptoms = cursor.getString(cursor.getColumnIndex(Tables.FirstAids.AILMENT_SYMPTOMS));
                String ailmentCautions = cursor.getString(cursor.getColumnIndex(Tables.FirstAids.AILMENT_CAUTIONS));
                String ailmentMedication = cursor.getString(cursor.getColumnIndex(Tables.FirstAids.AILMENT_MEDICATION));
                String ailmentTreatment = cursor.getString(cursor.getColumnIndex(Tables.FirstAids.AILMENT_TREATMENT));
                String ailmentTreatmentPrecautions = cursor.getString(cursor.getColumnIndex(Tables.FirstAids.AILMENT_TREATMENT_PRECAUTIONS));
                String ailmentTreatmentPosition = cursor.getString(cursor.getColumnIndex(Tables.FirstAids.AILMENT_TREATMENT_POSITION));
                String ailmentShortNotes = cursor.getString(cursor.getColumnIndex(Tables.FirstAids.AILMENT_SHORT_NOTES));


                firstAidsInfos.add(new FirstAidsInfo(firstaidId, ailment, ailmentInformation, ailmentCauses,
                        ailmentPrevention, ailmentSigns, ailmentSymptoms,
                        ailmentCautions, ailmentMedication, ailmentTreatment,
                        ailmentTreatmentPrecautions, ailmentTreatmentPosition, ailmentShortNotes));
            }
        }
        if (cursor != null) {
            if (!cursor.isClosed()) {
                cursor.close();
            }
        }

        return firstAidsInfos;
    }
}
