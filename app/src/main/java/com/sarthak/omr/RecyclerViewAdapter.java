package com.sarthak.omr;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.HashMap;

import static com.sarthak.omr.DialogDisplayActivity.optionsType;
import static com.sarthak.omr.DialogDisplayActivity.questions;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder>{
    HashMap<Integer, Character> questionNum = new HashMap<>();
    private int VIEW_TYPE_FOOTER = 200;
    private int VIEW_TYPE_CELL = 201;
    private Character options[];

    public RecyclerViewAdapter(){
        for(int i=0;i<questions;i++){
            questionNum.put(i, '-');
        }
        if(optionsType.equals("alphabetic")){
            options = new Character[]{'a', 'b', 'c', 'd'};
        }
        else{
            options = new Character[]{'1', '2', '3', '4'};
        }
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = null;
        if(viewType == VIEW_TYPE_CELL){
            view = inflater.inflate(R.layout.recycler_view_element, parent, false);
        }
        else{
            view = inflater.inflate(R.layout.button_layout, parent, false);
        }
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final MyViewHolder holder, final int position) {
        if(position==questionNum.size()){
            holder.submitButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(v.getContext(), ResultDisplayActivity.class);
                    intent.putExtra("result", questionNum);
                    v.getContext().startActivity(intent);
                }
            });
        }
        else{

            if(optionsType.equals("numeric")){
                holder.rb1.setText("1");
                holder.rb2.setText("2");
                holder.rb3.setText("3");
                holder.rb4.setText("4");
            }

            holder.questionNumTv.setText(""+ (position+1));
            setRadioButton(holder, questionNum.get(position));
            holder.rb1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    questionNum.put(position, options[0]);
                    setRadioButton(holder, questionNum.get(position));
                }
            });
            holder.rb2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    questionNum.put(position, options[1]);
                    setRadioButton(holder, questionNum.get(position));
                }
            });
            holder.rb3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    questionNum.put(position, options[2]);
                    setRadioButton(holder, questionNum.get(position));
                }
            });
            holder.rb4.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    questionNum.put(position, options[3]);
                    setRadioButton(holder, questionNum.get(position));
                }
            });
            holder.clearResponseBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    questionNum.put(position, '-');
                    setRadioButton(holder, questionNum.get(position));
                }
            });
        }
    }

    @Override
    public int getItemViewType(int position) {
        return (position == questionNum.size()) ? VIEW_TYPE_FOOTER : VIEW_TYPE_CELL;
    }

    private void setRadioButton(MyViewHolder holder, Character character) {
        RadioButton rb1 = holder.rb1;
        RadioButton rb2 = holder.rb2;
        RadioButton rb3 = holder.rb3;
        RadioButton rb4 = holder.rb4;
        holder.radioGroup.clearCheck();
        if(character==options[0]) rb1.setChecked(true);
        if(character==options[1]) rb2.setChecked(true);
        if(character==options[2]) rb3.setChecked(true);
        if(character==options[3]) rb4.setChecked(true);
    }

    @Override
    public int getItemCount() {
        return questionNum.size()+1;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{

        TextView questionNumTv;
        RadioGroup radioGroup;
        RadioButton rb1, rb2, rb3, rb4;
        Button clearResponseBtn, submitButton;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            questionNumTv = itemView.findViewById(R.id.question_num_tv);
            radioGroup = itemView.findViewById(R.id.radio_group);
            rb1 = itemView.findViewById(R.id.radio_btn_a);
            rb2 = itemView.findViewById(R.id.radio_btn_b);
            rb3 = itemView.findViewById(R.id.radio_btn_c);
            rb4 = itemView.findViewById(R.id.radio_btn_d);
            clearResponseBtn = itemView.findViewById(R.id.clear_response_btn);
            submitButton = itemView.findViewById(R.id.submit_btn);
        }
    }
}
