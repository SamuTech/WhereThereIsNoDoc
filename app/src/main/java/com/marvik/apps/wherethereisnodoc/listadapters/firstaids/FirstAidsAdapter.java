package com.marvik.apps.wherethereisnodoc.listadapters.firstaids;

import android.content.Context;
import android.view.View;
import android.widget.TextView;

import com.marvik.apps.coreutils.listadapters.ListsBaseAdapter;
import com.marvik.apps.wherethereisnodoc.R;
import com.marvik.apps.wherethereisnodoc.datamodels.firstaids.FirstAidsInfo;

import java.util.List;

/**
 * Created by victor on 1/10/2016.
 */
public class FirstAidsAdapter extends ListsBaseAdapter {

    private TextView mTvTitle;
    private TextView mTvDescription;
    private List<FirstAidsInfo> firstAids;

    public FirstAidsAdapter(Context context, int layout,  List<? super Object> listItems) {
        super( context,layout, listItems);
        this.firstAids = firstAids;
    }

    @Override
    public void initListViews(View view) {
        mTvTitle = (TextView) view.findViewById(R.id.list_firstaids_textView_item_title);
        mTvDescription = (TextView) view.findViewById(R.id.list_firstaids_textView_item_descriptions);
    }

    @Override
    public void createCustomListView(int position) {
        mTvTitle.setText(getFirstAids().get(position).ailment);
    }

    public List<FirstAidsInfo> getFirstAids() {
        return firstAids;
    }
}
