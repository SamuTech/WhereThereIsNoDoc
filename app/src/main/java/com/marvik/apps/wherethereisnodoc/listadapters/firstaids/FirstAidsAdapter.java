package com.marvik.apps.wherethereisnodoc.listadapters.firstaids;

import android.content.Context;
import android.view.View;
import android.widget.TextView;

import com.marvik.apps.coreutils.listadapters.ListsBaseAdapter;
import com.marvik.apps.wherethereisnodoc.R;
import com.marvik.apps.wherethereisnodoc.datamodels.firstaids.SimpleFirstAidInfo;

import java.util.List;

/**
 * Created by victor on 1/10/2016.
 */
public class FirstAidsAdapter extends ListsBaseAdapter {

    private TextView mTvTitle;
    private TextView mTvDescription;
    private List<SimpleFirstAidInfo> firstAids;

    public FirstAidsAdapter(Context context, int layout, List<?> listItems) {
        super(context, layout, listItems);
        this.firstAids = (List<SimpleFirstAidInfo>) listItems;
    }

    @Override
    public void initListViews(View view) {
        mTvTitle = (TextView) view.findViewById(R.id.list_firstaids_textView_item_title);
        mTvDescription = (TextView) view.findViewById(R.id.list_firstaids_textView_item_descriptions);
    }

    @Override
    public void createCustomListView(int position) {
        mTvTitle.setText(getFirstAids().get(position).getFirstAidItemTitle());
        mTvDescription.setText(getFirstAids().get(position).getFirstAidItemDescription());
    }

    public List<SimpleFirstAidInfo> getFirstAids() {
        return firstAids;
    }
}
