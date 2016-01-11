package com.marvik.apps.wherethereisnodoc.listadapters.firstaids.ailments;

import android.content.Context;
import android.view.View;
import android.widget.TextView;

import com.marvik.apps.coreutils.listadapters.ListsBaseAdapter;
import com.marvik.apps.wherethereisnodoc.R;
import com.marvik.apps.wherethereisnodoc.datamodels.firstaids.FirstAidsInfo;

import java.util.List;

/**
 * Created by victor on 1/11/2016.
 */
public class FirstAidsAilmentsAdapter extends ListsBaseAdapter {

    private TextView mTvAilment;
    private List<FirstAidsInfo> firstAidsInfo;

    public FirstAidsAilmentsAdapter(Context context, int layout, List<?> listItems) {
        super(context, layout, listItems);
        this.firstAidsInfo = (List<FirstAidsInfo>) listItems;
    }

    @Override
    public void initListViews(View view) {
        mTvAilment = (TextView) view.findViewById(R.id.list_firstaids_ailments_textView_ailment);
    }

    @Override
    public void createCustomListView(int position) {
        mTvAilment.setText(firstAidsInfo.get(position).ailment);
    }
}
