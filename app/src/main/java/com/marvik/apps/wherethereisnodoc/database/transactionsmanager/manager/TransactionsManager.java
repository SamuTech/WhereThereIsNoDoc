package com.marvik.apps.wherethereisnodoc.database.transactionsmanager.manager;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;

import com.marvik.apps.wherethereisnodoc.database.tables.Tables;
import com.marvik.apps.wherethereisnodoc.database.transactionsmanager.crudoperations.DatabaseCRUDOperations;
import com.marvik.apps.wherethereisnodoc.datamodels.firstaids.FirstAidsInfo;
import com.marvik.apps.wherethereisnodoc.utilities.Utilities;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by victor on 1/10/2016.
 */
public class TransactionsManager {

    private Utilities utils;

    private Context context;

    public TransactionsManager(Context context) {
        this.context = context;

        initAll(context);
    }

    public Utilities getUtils() {
        return utils;
    }

    public Context getContext() {
        return context;
    }

    private FirstAidsCRUD firstAidsCRUD;

    private void initAll(Context context) {
        utils = new Utilities(context);
        firstAidsCRUD = new FirstAidsCRUD();
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

    public List<FirstAidsInfo> getAllFistAids() {
        List<FirstAidsInfo> firstAidsInfos = new ArrayList<>();
        Cursor cursor = getFirstAidsCRUD().query(null, null, null, null);

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

    public class FirstAidsCRUD implements DatabaseCRUDOperations {


        @Override
        public Context getContext() {
            return context;
        }

        @Override
        public Uri getUri() {
            return Tables.FirstAids.CONTENT_URI;
        }

        @Override
        public Uri insert(ContentValues values) {
            getContext().getContentResolver().insert(getUri(), values);
            getUtils().sendBroadcast(com.marvik.apps.wherethereisnodoc.intents.Intents.Broadcasts.ACTION_NEW_FIRST_AID_ADDED);
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

        public int getFirstAidId(String ailment) {
            String firstAidId = getUtils().getDatabaseUtilities().getColumnsValues(
                    getUri(),
                    new String[]{ailment},
                    new String[]{Tables.FirstAids.AILMENT}, Tables.FirstAids.ID_FIRSTAID);
            return firstAidId == null ? 0 : Integer.parseInt(firstAidId);
        }

        public String getAilment(int firstAidId) {
            return getUtils().getDatabaseUtilities().getColumnsValues(
                    getUri(),
                    new String[]{"" + firstAidId},
                    new String[]{Tables.FirstAids.ID_FIRSTAID}, Tables.FirstAids.AILMENT
            );
        }

        public String getAilmentInformation(int firstAidId) {
            return getUtils().getDatabaseUtilities().getColumnsValues(
                    getUri(),
                    new String[]{"" + firstAidId},
                    new String[]{Tables.FirstAids.ID_FIRSTAID}, Tables.FirstAids.AILMENT_INFORMATION
            );

        }

        public String getAilmentCauses(int firstAidId) {
            return getUtils().getDatabaseUtilities().getColumnsValues(
                    getUri(),
                    new String[]{"" + firstAidId},
                    new String[]{Tables.FirstAids.ID_FIRSTAID}, Tables.FirstAids.AILMENT_CAUSES
            );
        }

        public String getAilmentPrevention(int firstAidId) {
            return getUtils().getDatabaseUtilities().getColumnsValues(
                    getUri(),
                    new String[]{"" + firstAidId},
                    new String[]{Tables.FirstAids.ID_FIRSTAID}, Tables.FirstAids.AILMENT_PREVENTION
            );
        }

        public String getAilmentSigns(int firstAidId) {
            return getUtils().getDatabaseUtilities().getColumnsValues(
                    getUri(),
                    new String[]{"" + firstAidId},
                    new String[]{Tables.FirstAids.ID_FIRSTAID}, Tables.FirstAids.AILMENT_SIGNS
            );
        }

        public String getAilmentSymptoms(int firstAidId) {
            return getUtils().getDatabaseUtilities().getColumnsValues(
                    getUri(),
                    new String[]{"" + firstAidId},
                    new String[]{Tables.FirstAids.ID_FIRSTAID}, Tables.FirstAids.AILMENT_SYMPTOMS
            );
        }

        public String getAilmentCautions(int firstAidId) {
            return getUtils().getDatabaseUtilities().getColumnsValues(
                    getUri(),
                    new String[]{"" + firstAidId},
                    new String[]{Tables.FirstAids.ID_FIRSTAID}, Tables.FirstAids.AILMENT_CAUTIONS
            );
        }

        public String getAilmentMedication(int firstAidId) {
            return getUtils().getDatabaseUtilities().getColumnsValues(
                    getUri(),
                    new String[]{"" + firstAidId},
                    new String[]{Tables.FirstAids.ID_FIRSTAID}, Tables.FirstAids.AILMENT_MEDICATION
            );
        }

        public String getAilmentTreatment(int firstAidId) {
            return getUtils().getDatabaseUtilities().getColumnsValues(
                    getUri(),
                    new String[]{"" + firstAidId},
                    new String[]{Tables.FirstAids.ID_FIRSTAID}, Tables.FirstAids.AILMENT_TREATMENT
            );
        }

        public String getAilmentTreatmentPrecautions(int firstAidId) {
            return getUtils().getDatabaseUtilities().getColumnsValues(
                    getUri(),
                    new String[]{"" + firstAidId},
                    new String[]{Tables.FirstAids.ID_FIRSTAID}, Tables.FirstAids.AILMENT_TREATMENT_PRECAUTIONS
            );
        }

        public String getAilmentTreatmentPosition(int firstAidId) {
            return getUtils().getDatabaseUtilities().getColumnsValues(
                    getUri(),
                    new String[]{"" + firstAidId},
                    new String[]{Tables.FirstAids.ID_FIRSTAID}, Tables.FirstAids.AILMENT_TREATMENT_POSITION
            );
        }

        public String getAilmentShortNotes(int firstAidId) {
            return getUtils().getDatabaseUtilities().getColumnsValues(
                    getUri(),
                    new String[]{"" + firstAidId},
                    new String[]{Tables.FirstAids.ID_FIRSTAID}, Tables.FirstAids.AILMENT_SHORT_NOTES
            );
        }
    }

}