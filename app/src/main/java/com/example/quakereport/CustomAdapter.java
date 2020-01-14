package com.example.quakereport;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import java.text.DecimalFormat;
import android.widget.ArrayAdapter;
import java.util.Date;
import android.widget.TextView;

import androidx.core.content.ContextCompat;

import java.text.SimpleDateFormat;

import java.util.ArrayList;

public class CustomAdapter extends ArrayAdapter<Earthquake> {

    public CustomAdapter(Context a, ArrayList<Earthquake> b)
    {
        super(a,0,b);
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent)
    {
        View listview =  convertView;
        if(listview==null)
        {
            listview = LayoutInflater.from(getContext()).inflate(R.layout.listview2,parent,false);
        }
        Earthquake a = getItem(position);

        TextView b = (TextView) listview.findViewById(R.id.mag);

        GradientDrawable magnitudeCircle = (GradientDrawable) b.getBackground();

        int color2 = getcolor(a.getmag());
        magnitudeCircle.setColor(color2);

        DecimalFormat formatter = new DecimalFormat("0.0");
        String output = formatter.format(a.getmag());
        b.setText(output);

        TextView c = (TextView) listview.findViewById(R.id.place1);
        c.setText(a.getplace2());

        TextView c2 = (TextView) listview.findViewById(R.id.place2);
        c2.setText(a.getplace3());

        TextView d = (TextView) listview.findViewById(R.id.date);

       long timeInMilliseconds = Long.parseLong(a.getdate()) ;

        Date dateObject = new Date(timeInMilliseconds);
        SimpleDateFormat dateFormatter = new SimpleDateFormat("MMM DD, yyyy");
        String dateToDisplay = dateFormatter.format(dateObject);

        d.setText(dateToDisplay);

        TextView e = (TextView) listview.findViewById(R.id.time);
        SimpleDateFormat timeFormat = new SimpleDateFormat("h:mm a");
        String time2 =  timeFormat.format(dateObject);
        e.setText(time2) ;
        return listview;
    }
    public int getcolor(double a)
    {
        int c=R.color.magnitude1;
        int b = (int)a;

        switch(b)
        {
            case 1:
                c=R.color.magnitude1;
                break;
            case 2:
                c= R.color.magnitude2;
                break;
            case 3:
                c= R.color.magnitude3;
                break;
            case 4:
                c= R.color.magnitude4;
                break;
            case 5:
               c=R.color.magnitude5;
                break;
            case 6:
                c=R.color.magnitude6;
                break;
            case 7:
                c=R.color.magnitude7;
            break;
            case 8:
                c=R.color.magnitude8;
            break;
            case 9:
                c= R.color.magnitude9;
            break;
            case 10:
                c=R.color.magnitude10plus;
            break;
        }
        return ContextCompat.getColor(getContext(), c);
    }
}
