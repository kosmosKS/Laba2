package com.example.myapplication;


import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.List;

public class DishesAdapter extends BaseAdapter {
    public DishesAdapter(Context mContext, List<Dishes> mDishesList) {
        this.mContext = mContext;
        this.mDishesList = mDishesList;
    }

    private Context mContext;
    private List<Dishes> mDishesList;

    @Override
    public int getCount() {
        return mDishesList.size();
    }

    @Override
    public Object getItem(int i) {
        return mDishesList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return mDishesList.get(i).getId();
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View v =View.inflate(mContext,R.layout.item_dish,null);

        return null;
    }
}
