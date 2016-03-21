package com.example.ameet.gpacalculator;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

/**
 * Created by Ameet on 11/10/2015.
 */
public class ClassArrayAdapter extends ArrayAdapter<Class> {

    ArrayList<Class> classList;
    Context context;
    int layoutResourceId;

    public ClassArrayAdapter(Context context,int layoutResourceId,ArrayList<Class>classList)
    {
        super(context,layoutResourceId);
        this.context=context;
        this.classList=classList;
        this.layoutResourceId=layoutResourceId;

    }
//    @Override
//    public Class getItem(int position)
//    {
//        return super.getItem();
//    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent)
    {
        Class cl = getItem(position);
        if (convertView == null) {
            Log.e("b0ss","pls");
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.list_item, parent, false);
        }
        TextView listClassText = (TextView)convertView.findViewById(R.id.itemClassText);
        TextView gradeText=(TextView)convertView.findViewById(R.id.itemGradeText);
        listClassText.setText(cl.getClassName());
        gradeText.setText(cl.getGrade());

        return convertView;

    }

}
