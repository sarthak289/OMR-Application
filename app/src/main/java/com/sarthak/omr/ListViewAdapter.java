package com.sarthak.omr;

import android.content.Context;
import android.text.Layout;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.HashMap;

public class ListViewAdapter extends BaseAdapter{
    private HashMap<Integer, Integer> hashMap;
    private Integer[] hashKeys;
    private LayoutInflater inflater;
    private Context context;
    public ListViewAdapter(Context context, HashMap<Integer, Integer> hashMap){
        this.context = context;
        this.hashMap = hashMap;
        hashKeys = hashMap.keySet().toArray(new Integer[hashMap.size()]);
        inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return hashMap.size();
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
        View view = inflater.inflate(R.layout.list_view_element, null);
        TextView resultQuestionNumTv = view.findViewById(R.id.result_question_num_tv);
        TextView resultAnswerTv = view.findViewById(R.id.result_answer_tv);
        resultQuestionNumTv.setText(""+(hashKeys[position]+1));
        resultAnswerTv.setText(""+hashMap.get(position));
        return view;
    }
}
