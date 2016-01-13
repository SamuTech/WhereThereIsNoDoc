package com.marvik.apps.wherethereisnodoc.fragments.firstaids;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.marvik.apps.coreutils.fragments.FragmentWrapper;
import com.marvik.apps.wherethereisnodoc.R;
import com.marvik.apps.wherethereisnodoc.datamodels.firstaids.SimpleFirstAidInfo;
import com.marvik.apps.wherethereisnodoc.intents.Intents;
import com.marvik.apps.wherethereisnodoc.listadapters.firstaids.FirstAidsAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by victor on 1/10/2016.
 */
public class FirstAidsFragment extends FragmentWrapper {

    //first aid id of the selected ailment
    private int firstAidId;

    //list to hold fragment infos
    private List<SimpleFirstAidInfo> simpleFirstAidInfoList;

    //listview that contains fragment infos
    private ListView mLvFirstAid;

    /**
     * Called when the fragment is created
     *
     * @param savedInstanceState
     */
    @Override
    public void onCreateFragment(@Nullable Bundle savedInstanceState) {

    }

    /**
     * Used for setting the title of the Activity
     *
     * @return activity title
     */
    @Nullable
    @Override
    public String getActivityTitle() {
        return getTransactionsManager().getFirstAidsCRUD().getAilment(getFirstAidId());
    }

    /**
     * Callback used to receive any bundle passed to the fragment when this fragment was created
     */
    @Override
    public void receiveBundle() {

        if (getArguments() != null) {
            int firstAidId = getArguments().getInt(Intents.Extras.EXTRA_FIRST_AID_ID);
            setFirstAidId(firstAidId);
            createFirstAidInfos();
        }
    }

    /**
     * Used for creating a custom view for the fragment
     *
     * @param inflater
     * @param container
     * @param savedInstanceState
     */
    @Nullable
    @Override
    public View onCreateFragmentView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        return getActivity().getLayoutInflater().inflate(getParentLayout(), container, false);
    }

    /**
     * Initializes the child views for the fragment being created.
     *
     * @param view
     */
    @Override
    public View initFragmentViews(View view) {
        mLvFirstAid = (ListView) view.findViewById(R.id.fragment_firstaids_listView_first_aid_infos);
        mLvFirstAid.setAdapter(new FirstAidsAdapter(getActivity(), R.layout.list_firstaids, simpleFirstAidInfoList));
        return view;
    }

    /**
     * Callback used to hold methods that consume all the contents of the bundle passed to the fragment
     */
    @Override
    public void consumeBundle() {

    }

    /**
     * Callback called to attach data to all the views in the fragment
     */
    @Override
    public void attachViewsData() {

    }

    /**
     * Called when a fragment is first attached to its context.
     * {#onCreate(Bundle)} will be called after this.
     */
    @Override
    public void onAttachFragment() {

    }

    /**
     * Called when the fragment is visible to the user and actively running.
     * This is generally
     * tied to {Activity#onResume() Activity.onResume} of the containing
     * Activity's lifecycle.
     */
    @Override
    public void onResumeFragment() {

    }

    /**
     * Called to provide implementation to initiate the syncing of the contents of the current fragment
     */
    @Override
    public void performPartialSync() {

    }

    /**
     * Called when only the contents of the current fragment are synced
     */
    @Override
    public void onPerformPartialSync() {

    }

    /**
     * Called when the Fragment is no longer resumed.  This is generally
     * tied to  Activity#onPause() Activity.onPause} of the containing
     * Activity's lifecycle.
     */
    @Override
    public void onPauseFragment() {

    }

    /**
     * Called when the fragment is no longer in use.  This is called
     * after onStop()} and before onDetach()}.
     */
    @Override
    public void onDestroyFragment() {

    }

    /**
     * Returns the layout resource id for the layout used to populate the view for this fragment
     *
     * @return the layout resource id
     */
    @Override
    public int getParentLayout() {
        return R.layout.fragment_firstaids;
    }


    public void setFirstAidId(int firstAidId) {
        this.firstAidId = firstAidId;
    }

    public int getFirstAidId() {
        return firstAidId;
    }

    private void createFirstAidInfos() {

        simpleFirstAidInfoList = new ArrayList<>();

        int firstaidId = getFirstAidId();
        String ailment = getTransactionsManager().getFirstAidsCRUD().getAilment(firstaidId);
        String ailmentInformation = getTransactionsManager().getFirstAidsCRUD().getAilmentInformation(firstaidId);
        String ailmentCauses = getTransactionsManager().getFirstAidsCRUD().getAilmentCauses(firstaidId);
        String ailmentPrevention = getTransactionsManager().getFirstAidsCRUD().getAilmentPrevention(firstaidId);
        String ailmentSigns = getTransactionsManager().getFirstAidsCRUD().getAilmentSigns(firstaidId);
        String ailmentSymptoms = getTransactionsManager().getFirstAidsCRUD().getAilmentSymptoms(firstaidId);
        String ailmentCautions = getTransactionsManager().getFirstAidsCRUD().getAilmentCautions(firstaidId);
        String ailmentMedication = getTransactionsManager().getFirstAidsCRUD().getAilmentMedication(firstaidId);
        String ailmentTreatment = getTransactionsManager().getFirstAidsCRUD().getAilmentTreatment(firstaidId);
        String ailmentTreatmentPrecautions = getTransactionsManager().getFirstAidsCRUD().getAilmentTreatmentPrecautions(firstaidId);
        String ailmentTreatmentPosition = getTransactionsManager().getFirstAidsCRUD().getAilmentTreatmentPosition(firstaidId);
        String ailmentShortNotes = getTransactionsManager().getFirstAidsCRUD().getAilmentShortNotes(firstaidId);


        /*
        * This is nolonger needed since the ailment is added as the title for the activity
        *if (!ailment.equals("")) {
          *  simpleFirstAidInfoList.add(new SimpleFirstAidInfo("Ailment", ailment));
        *}
        *
        * */
        if (ailmentInformation.equals("")) {
            simpleFirstAidInfoList.add(new SimpleFirstAidInfo("Do you know " , ailmentInformation));
        }
        if (!ailmentCauses.equals("")) {
            simpleFirstAidInfoList.add(new SimpleFirstAidInfo("Causes", ailmentCauses));
        }
        if (!ailmentPrevention.equals("")) {
            simpleFirstAidInfoList.add(new SimpleFirstAidInfo("Prevention", ailmentPrevention));
        }
        if (!ailmentSigns.equals("")) {
            simpleFirstAidInfoList.add(new SimpleFirstAidInfo("Signs", ailmentSigns));
        }
        if (!ailmentSymptoms.equals("")) {
            simpleFirstAidInfoList.add(new SimpleFirstAidInfo("Symptoms", ailmentSymptoms));
        }
        if (!ailmentCautions.equals("")) {
            simpleFirstAidInfoList.add(new SimpleFirstAidInfo("Cautions", ailmentCautions));
        }
        if (!ailmentMedication.equals("")) {
            simpleFirstAidInfoList.add(new SimpleFirstAidInfo("Medication", ailmentMedication));
        }
        if (!ailmentTreatment.equals("")) {
            simpleFirstAidInfoList.add(new SimpleFirstAidInfo("Treatment", ailmentTreatment));
        }
        if (!ailmentTreatmentPrecautions.equals("")) {
            simpleFirstAidInfoList.add(new SimpleFirstAidInfo("Precautions", ailmentTreatmentPrecautions));
        }
        if (!ailmentTreatmentPosition.equals("")) {
            simpleFirstAidInfoList.add(new SimpleFirstAidInfo("Treatment Position", ailmentTreatmentPosition));
        }
        if (!ailmentShortNotes.equals("")) {
            simpleFirstAidInfoList.add(new SimpleFirstAidInfo("Remember", ailmentShortNotes));
        }
    }
}
