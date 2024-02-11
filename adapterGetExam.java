package p.zahra.testtbl.Stu.adapters;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.support.annotation.IdRes;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import junit.framework.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import p.zahra.testtbl.R;
import p.zahra.testtbl.Stu.Activities.Exam;
import p.zahra.testtbl.Stu.Activities.ExamAnswerClass;
import p.zahra.testtbl.Stu.GetSets.GetsetExam;

/**
 * Created by Lenovo Z on 06/02/2018.
 */


    public class adapterGetExam extends RecyclerView.Adapter<adapterGetExam.viewholder>{
        Context context;
        List<GetsetExam> examdata;
        List<String> TestAnswers;
    public static int count=0;
        public adapterGetExam(Context context, List<GetsetExam> examdata) {
            this.context=context;
            this.examdata=examdata;
            TestAnswers=new ArrayList<>();
        }


        @Override
        public adapterGetExam.viewholder onCreateViewHolder(ViewGroup parent, int viewType) {
            View v= LayoutInflater.from(context).inflate(R.layout.item_exam,parent,false);
            return new adapterGetExam.viewholder(v);
        }

    @Override
    public void onBindViewHolder(final viewholder holder, final int position) {
        final GetsetExam getsetexam=examdata.get(position);
        holder.questionexam.setText(getsetexam.getQuestion());
        holder.ch1exam.setText(getsetexam.getChoice1());
        holder.ch2exam.setText(getsetexam.getChoice2());
        holder.ch3exam.setText(getsetexam.getChoice3());
        holder.ch4exam.setText(getsetexam.getChoice4());
        holder.answer=getsetexam.getAnswer();
        if(holder.ch1exam.isChecked()){
            if(holder.answer=="1"){
                count++;
            }
        }
        if(holder.ch2exam.isChecked()){
            if(holder.answer=="2"){
                count++;
            }
        }
        if(holder.ch3exam.isChecked()){
            if(holder.answer=="3"){
                count++;
            }
        }
        if(holder.ch4exam.isChecked()){
            if(holder.answer=="1"){
                count++;
            }
        }
        holder.radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {
                HashMap<String,String> hashMap=new HashMap<>();
                hashMap.put("Testid",getsetexam.getTestid()+"");
                hashMap.put("quize", getsetexam.getQid()+"");
                switch (holder.radioGroup.getCheckedRadioButtonId()){
                    case R.id.ch1exam:
                       // TestAnswers.add(position, "1");
                        hashMap.put("answer", "1");

                        //  Toast.makeText(context,R.id.ch1exam+"",Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.ch2exam:
                        hashMap.put("answer", "2");
                       // TestAnswers.add(position, "2");
                        break;
                    case R.id.ch3exam:
                        hashMap.put("answer", "3");
                       // TestAnswers.add(position, "3");
                        break;
                    case R.id.ch4exam:
                        hashMap.put("answer", "4");
                      //  Toast.makeText(context,hashMap.get("answer"),Toast.LENGTH_SHORT).show();
                        //TestAnswers.add(position, "4");
                        break;
                }

                ExamAnswerClass examAnswerClass=new ExamAnswerClass(context,hashMap);
            }
        });
   //   Toast.makeText(context,count,Toast.LENGTH_SHORT).show();
     /*   holder.radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(RadioGroup arg0, int arg1) {

                switch (holder.radioGroup.getCheckedRadioButtonId()) {

                    case 1: {

                       if (holder.answer=="1"){
                     count++;

                       }


                    }
                    break;
                    case 2: {

                if(holder.answer=="2")
                 {
                   count++;
                     }

                    }
                    break;
                    case 3: {
                        if(holder.answer=="3")
                        {
                            count++;
                        }


                    }
                    break;
                    case 4: {
                        if(holder.answer=="4")
                        {
                            count++;
                        }


                    }
                    break;
                    default:
                        break;

                }
            }
        });*/

    }

        @Override
        public int getItemCount() {
            return examdata.size();
        }
        public class viewholder extends RecyclerView.ViewHolder {
            //ImageView imageview;
           TextView questionexam;
            RadioGroup radioGroup;
            RadioButton ch1exam,ch2exam,ch3exam,ch4exam;
            String answer;
            public viewholder(View itemView) {
                super(itemView);
                //  imageview=(ImageView) itemView.findViewById(R.id.img);
                questionexam=(TextView) itemView.findViewById(R.id.questionexam);
                radioGroup=(RadioGroup) itemView.findViewById(R.id.radiogroup);
                ch1exam=(RadioButton) itemView.findViewById(R.id.ch1exam);
                ch2exam=(RadioButton) itemView.findViewById(R.id.ch2exam);
                ch3exam=(RadioButton) itemView.findViewById(R.id.ch3exam);
                ch4exam=(RadioButton) itemView.findViewById(R.id.ch4exam);


            }
        }

        public List<String> getTestAnswers(){
            return TestAnswers;
        }

    public List<GetsetExam> getExamdata(){
        return examdata;
    }




    }