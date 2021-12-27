package com.example.myspinner;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class CustomAdepter extends BaseAdapter {
    private String[] countryname;
    private int[] flags;
    private Context context;
    private LayoutInflater inflater;


    public CustomAdepter(Context context, String[] countryname, int[] flags) {

        this.countryname = countryname;
        this.flags =  flags;
        this.context = context;
    }

    @Override
    public int getCount() {
        return countryname.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView==null){
            inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView =inflater.inflate(R.layout.sample_layout,parent,false);

        }

        ImageView imageView = convertView.findViewById(R.id.sampleImg_id);
        TextView titleView1 = convertView.findViewById(R.id.sampleTitleview_id);
        TextView textView  = convertView.findViewById(R.id.sampleTextview_id);

        imageView.setImageResource(flags[position]);
        titleView1.setText(countryname[position]);

        return convertView;
    }
}
