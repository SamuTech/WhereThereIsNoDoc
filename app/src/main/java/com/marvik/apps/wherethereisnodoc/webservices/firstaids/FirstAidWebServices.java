package com.marvik.apps.wherethereisnodoc.webservices.firstaids;

import android.content.Context;

import com.marvik.apps.coreutils.utils.Utils;
import com.marvik.apps.coreutils.webservices.WebServicesProvider;
import com.marvik.apps.wherethereisnodoc.datamodels.firstaids.FirstAidsInfo;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by victor on 1/10/2016.
 */
public class FirstAidWebServices extends WebServicesProvider {

    public FirstAidWebServices(Context context, String url, String query) {
        super(context, url, query);
    }

    public String getTestFirstAidsJSON(Utils utils) {
        return utils.readAssetsStringStream("json/firstaids/firstaids.json");
    }

    public JSONObject[] getFirstAidsJSON(String firstAidJson) throws JSONException {
        JSONArray jsonArray = new JSONArray(firstAidJson);
        JSONObject[] jsonObjects = new JSONObject[jsonArray.length()];
        for (int i = 0; i < jsonArray.length(); i++) {
            jsonObjects[i] = jsonArray.getJSONObject(i);
        }
        return jsonObjects;
    }

    public FirstAidsInfo getFirstAidIn(JSONObject firstAidJsonObject) throws JSONException {



        int firstaidId = firstAidJsonObject.getInt("id_firstaid");
        String ailment = firstAidJsonObject.getString("ailment");
        String ailmentInformation = firstAidJsonObject.getString("ailment_information");
        String ailmentCauses = firstAidJsonObject.getString("ailment_causes");
        String ailmentPrevention = firstAidJsonObject.getString("ailment_prevention");
        String ailmentSigns = firstAidJsonObject.getString("ailment_signs");
        String ailmentSymptoms = firstAidJsonObject.getString("ailment_symptoms");
        String ailmentCautions = firstAidJsonObject.getString("ailment_cautions");
        String ailmentMedication = firstAidJsonObject.getString("ailment_medication");
        String ailmentTreatment = firstAidJsonObject.getString("ailment_treatment");
        String ailmentTreatmentPrecautions = firstAidJsonObject.getString("ailment_treatment_precautions");
        String ailmentTreatmentPosition = firstAidJsonObject.getString("ailment_treatment_position");
        String ailmentShortNotes = firstAidJsonObject.getString("ailment_short_notes");

        return new FirstAidsInfo(firstaidId, ailment, ailmentInformation, ailmentCauses,
                ailmentPrevention, ailmentSigns, ailmentSymptoms,
                ailmentCautions, ailmentMedication, ailmentTreatment,
                ailmentTreatmentPrecautions, ailmentTreatmentPosition, ailmentShortNotes);
    }
}
