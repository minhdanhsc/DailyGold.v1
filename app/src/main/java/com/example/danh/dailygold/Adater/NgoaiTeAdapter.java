package com.example.danh.dailygold.Adater;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.danh.dailygold.Model.NgoaiTe;
import com.example.danh.dailygold.R;

import java.util.List;

public class NgoaiTeAdapter extends BaseAdapter {

    // khai bao mac dinh
    private Context context;
    private int layout;
    private List<NgoaiTe> ngoaiTeList;
    // ham khoi tao

    public NgoaiTeAdapter(Context context, int layout, List<NgoaiTe> ngoaiTeList) {
        this.context = context;
        this.layout = layout;
        this.ngoaiTeList = ngoaiTeList;
    }



    @Override
    public int getCount() {
        return ngoaiTeList.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    // viet ham viewHolder
    private class ViewHolder {
        TextView tvName, tvPrice;
    }
    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        ViewHolder holder;

        if (view == null) {
            holder = new ViewHolder();
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(layout,null);
            holder.tvName   = (TextView) view.findViewById(R.id.tv_name_ngoaite);
            holder.tvPrice  = (TextView) view.findViewById(R.id.tv_price_ngoate);
            view.setTag(holder);
        } else {
            holder = (ViewHolder) view.getTag();
        }

        NgoaiTe ngoaiTe = ngoaiTeList.get(i);
        holder.tvName.setText(ngoaiTe.getmName());
        holder.tvPrice.setText(ngoaiTe.getmPrice());
        return view;
    }
}
