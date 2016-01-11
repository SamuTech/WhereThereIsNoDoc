package com.marvik.apps.wherethereisnodoc.database.tables;

import android.net.Uri;

import com.marvik.apps.wherethereisnodoc.database.dataprovider.DataProvider;

/**
 * Created by victor on 1/10/2016.
 */
public class Tables {

    public static final String[] TABLES_SQL = {
            FirstAids.SQL,
    };

    public static class FirstAids {

        public static final String TABLE_NAME = "firstaids";

        public static final Uri CONTENT_URI = Uri.parse("content://"+DataProvider.AUTHORITY + "/" + TABLE_NAME);

        public static final String ID_FIRSTAID = "id_firstaid";
        public static final String AILMENT = "ailment";
        public static final String AILMENT_INFORMATION = "ailment_information";
        public static final String AILMENT_CAUSES = "ailment_causes";
        public static final String AILMENT_PREVENTION = "ailment_prevention";
        public static final String AILMENT_SIGNS = "ailment_signs";
        public static final String AILMENT_SYMPTOMS = "ailment_symptoms";
        public static final String AILMENT_CAUTIONS = "ailment_cautions";
        public static final String AILMENT_MEDICATION = "ailment_medication";

        public static final String AILMENT_TREATMENT = "ailment_treatment";
        public static final String AILMENT_TREATMENT_PRECAUTIONS = "ailment_treatment_precautions";
        public static final String AILMENT_TREATMENT_POSITION = "ailment_treatment_position";
        public static final String AILMENT_SHORT_NOTES = "ailment_short_notes";


        public static final String SQL = "CREATE TABLE IF NOT EXISTS " + TABLE_NAME
                + " (" + AILMENT + " text NOT NULL,"
                + AILMENT_INFORMATION + " text,"
                + AILMENT_CAUSES + " text,"
                + AILMENT_PREVENTION + " text,"
                + AILMENT_SIGNS + " text,"
                + AILMENT_SYMPTOMS + " text,"
                + AILMENT_CAUTIONS + " text,"
                + AILMENT_MEDICATION + " text,"
                + AILMENT_TREATMENT + " text,"
                + AILMENT_TREATMENT_PRECAUTIONS + " text,"
                + AILMENT_TREATMENT_POSITION + " text,"
                + AILMENT_SHORT_NOTES + " text,"
                + ID_FIRSTAID + " integer primary key autoincrement);";
    }
}
