package sos.com.sosserver;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.firebase.client.Query;


/**
 * Created by SampleText on 15-11-2015.
 */
public class MyAdapter extends FirebaseListAdapter<Ambulance> {


    public MyAdapter(Query ref, Activity activity, int layout) {
        super(ref, Ambulance.class, layout, activity);
    }

    @Override
    protected void populateView(View v, Ambulance ambulance) {
        TextView textView = (TextView)v.findViewById(R.id.textView);
        textView.setText(ambulance.getTime());


    }

    @Override
    public View getView(int i,View view,ViewGroup viewGroup) {
        if (view == null)
            view=getInflator().inflate(getLayout(),viewGroup,false);
        populateView(view, getModels().get((getModels().size() - i - 1)));
        return view;
    }

    @Override
    public Object getItem(int i) {
        return getModels().get(getModels().size()-i-1);
    }
}
