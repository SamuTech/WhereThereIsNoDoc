package com.marvik.apps.wherethereisnodoc.datamodels.firstaids;

/**
 * Created by victor on 1/12/2016.
 */
public class SimpleFirstAidInfo {

    private String firstAidItemTitle;
    private String firstAidItemDescription;

    public SimpleFirstAidInfo(String firstAidItemTitle, String firstAidItemDescription) {
        this.firstAidItemTitle = firstAidItemTitle;
        this.firstAidItemDescription = firstAidItemDescription;
    }

    public String getFirstAidItemTitle() {
        return firstAidItemTitle;
    }

    public void setFirstAidItemTitle(String firstAidItemTitle) {
        this.firstAidItemTitle = firstAidItemTitle;
    }

    public String getFirstAidItemDescription() {
        return firstAidItemDescription;
    }

    public void setFirstAidItemDescription(String firstAidItemDescription) {
        this.firstAidItemDescription = firstAidItemDescription;
    }
}
