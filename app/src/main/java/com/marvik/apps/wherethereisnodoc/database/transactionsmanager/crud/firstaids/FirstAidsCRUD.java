package com.marvik.apps.wherethereisnodoc.database.transactionsmanager.crud.firstaids;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;

import com.marvik.apps.wherethereisnodoc.database.tables.Tables;
import com.marvik.apps.wherethereisnodoc.database.transactionsmanager.crudoperations.DatabaseCRUDOperations;
import com.marvik.apps.wherethereisnodoc.datamodels.firstaids.FirstAidsInfo;


/**
 * Created by victor on 1/10/2016.
 */
public class FirstAidsCRUD implements DatabaseCRUDOperations {

    private Context context;

    public FirstAidsCRUD(Context context) {
        this.context = context;
    }

    @Override
    public Context getContext() {
        return this.context;
    }

    @Override
    public Uri getUri() {
        return Tables.FirstAids.CONTENT_URI;
    }

    @Override
    public Uri insert(ContentValues values) {
        getContext().getContentResolver().insert(getUri(), values);
        return getUri();
    }

    @Override
    public Cursor query(String[] projection, String selection, String[] selectionArgs, String sortOrder) {
        return getContext().getContentResolver().query(getUri(), projection, selection, selectionArgs, sortOrder);
    }

    @Override
    public int update(ContentValues values, String selection, String[] selectionArgs) {
        return getContext().getContentResolver().update(getUri(), values, selection, selectionArgs);
    }

    @Override
    public int delete(String selection, String[] selectionArgs) {
        return getContext().getContentResolver().delete(getUri(), selection, selectionArgs);
    }

    public void insertFirstAids(FirstAidsInfo firstAidsInfo) {

        ContentValues values = new ContentValues();
        values.put(Tables.FirstAids.AILMENT, firstAidsInfo.getAilment());
        values.put(Tables.FirstAids.AILMENT_INFORMATION, firstAidsInfo.getAilmentInformation());
        values.put(Tables.FirstAids.AILMENT_CAUSES, firstAidsInfo.getAilmentCauses());
        values.put(Tables.FirstAids.AILMENT_PREVENTION, firstAidsInfo.getAilmentPrevention());
        values.put(Tables.FirstAids.AILMENT_SIGNS, firstAidsInfo.getAilmentSigns());
        values.put(Tables.FirstAids.AILMENT_SYMPTOMS, firstAidsInfo.getAilmentSymptoms());
        values.put(Tables.FirstAids.AILMENT_CAUTIONS, firstAidsInfo.getAilmentCautions());
        values.put(Tables.FirstAids.AILMENT_MEDICATION, firstAidsInfo.getAilmentMedication());
        values.put(Tables.FirstAids.AILMENT_TREATMENT, firstAidsInfo.getAilmentTreatment());
        values.put(Tables.FirstAids.AILMENT_TREATMENT_PRECAUTIONS, firstAidsInfo.getAilmentTreatmentPrecautions());
        values.put(Tables.FirstAids.AILMENT_TREATMENT_POSITION, firstAidsInfo.getAilmentTreatmentPosition());
        values.put(Tables.FirstAids.AILMENT_SHORT_NOTES, firstAidsInfo.getAilmentShortNotes());
        values.put(Tables.FirstAids.ID_FIRSTAID, firstAidsInfo.getFirstaidId());


        insert(values);
    }
}
