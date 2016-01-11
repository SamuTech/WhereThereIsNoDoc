package com.marvik.apps.wherethereisnodoc.datamodels.firstaids;

/**
 * Created by victor on 1/10/2016.
 */
public class FirstAidsInfo {
    public int firstaidId;
    public String ailment;
    public String ailmentInformation;
    public String ailmentCauses;
    public String ailmentPrevention;
    public String ailmentSigns;
    public String ailmentSymptoms;
    public String ailmentCautions;
    public String ailmentMedication;

    public String ailmentTreatment;
    public String ailmentTreatmentPrecautions;
    public String ailmentTreatmentPosition;
    public String ailmentShortNotes;

    public FirstAidsInfo(int firstaidId, String ailment, String ailmentInformation, String ailmentCauses,
                         String ailmentPrevention, String ailmentSigns, String ailmentSymptoms,
                         String ailmentCautions, String ailmentMedication, String ailmentTreatment,
                         String ailmentTreatmentPrecautions, String ailmentTreatmentPosition, String ailmentShortNotes) {
        this.firstaidId = firstaidId;
        this.ailment = ailment;
        this.ailmentInformation = ailmentInformation;
        this.ailmentCauses = ailmentCauses;
        this.ailmentPrevention = ailmentPrevention;
        this.ailmentSigns = ailmentSigns;
        this.ailmentSymptoms = ailmentSymptoms;
        this.ailmentCautions = ailmentCautions;
        this.ailmentMedication = ailmentMedication;
        this.ailmentTreatment = ailmentTreatment;
        this.ailmentTreatmentPrecautions = ailmentTreatmentPrecautions;
        this.ailmentTreatmentPosition = ailmentTreatmentPosition;
        this.ailmentShortNotes = ailmentShortNotes;
    }

    public int getFirstaidId() {
        return firstaidId;
    }

    public String getAilment() {
        return ailment;
    }

    public String getAilmentInformation() {
        return ailmentInformation;
    }

    public String getAilmentCauses() {
        return ailmentCauses;
    }

    public String getAilmentPrevention() {
        return ailmentPrevention;
    }

    public String getAilmentSigns() {
        return ailmentSigns;
    }

    public String getAilmentSymptoms() {
        return ailmentSymptoms;
    }

    public String getAilmentCautions() {
        return ailmentCautions;
    }

    public String getAilmentMedication() {
        return ailmentMedication;
    }

    public String getAilmentTreatment() {
        return ailmentTreatment;
    }

    public String getAilmentTreatmentPrecautions() {
        return ailmentTreatmentPrecautions;
    }

    public String getAilmentTreatmentPosition() {
        return ailmentTreatmentPosition;
    }

    public String getAilmentShortNotes() {
        return ailmentShortNotes;
    }
}
