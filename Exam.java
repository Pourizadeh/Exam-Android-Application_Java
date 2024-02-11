package p.zahra.testtbl.Stu.Activities;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.SystemClock;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;
import android.view.Window;
import android.widget.TextView;
import android.widget.Toast;

import java.util.HashMap;
import java.util.List;

import p.zahra.testtbl.AppPreferencesHelper;
import p.zahra.testtbl.R;
import p.zahra.testtbl.Stu.Classes.ExamClass;
import p.zahra.testtbl.Stu.Classes.FinalizeTestClass;
import p.zahra.testtbl.Stu.GetSets.GetsetExam;
import p.zahra.testtbl.Stu.adapters.adapterGetExam;

import static p.zahra.testtbl.Stu.adapters.adapterGetExam.count;

/**
 * Created by Lenovo Z on 03/02/2018.
 */

public class Exam extends AppCompatActivity {

    RecyclerView recyclerexam;
    adapterGetExam adapter;
    GetsetExam getsetExam;
    FloatingActionButton Send;
    TextView Timer;int examDuration;
    String Examid="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.exam);
        Bundle b = this.getIntent().getExtras();
        examDuration=0;
        if (b != null){
            Examid = b.getString("Examid");
            examDuration=b.getInt("ExamDuration");
        }

        Send=(FloatingActionButton) findViewById(R.id.SendTest);

        Timer=(TextView) findViewById(R.id.timer);
        ExamClass examClass=new ExamClass(this,Examid);
        recyclerexam=(RecyclerView)findViewById(R.id.rcyexam);
        recyclerexam.setLayoutManager(new StaggeredGridLayoutManager(1,StaggeredGridLayoutManager.VERTICAL) );
        examClass.getexam(new ExamClass.onpostexam() {
            @Override
            public void onpostexam(List<GetsetExam> examdata) {
//                if (examdata.size()==0){
//                    finish();
//                }
                adapter =new adapterGetExam(Exam.this,examdata);
                recyclerexam.setAdapter(adapter);

                new CountDownTimer(examDuration*60000, 1000) {

                    public void onTick(long millisUntilFinished) {
                        int secs = (int) (millisUntilFinished / 1000);
                        int mins = secs / 60;
                        secs = secs % 60;
                        int milliseconds = (int) (millisUntilFinished % 1000);
                        Timer.setText("" + mins + ":"
                                + String.format("%02d", secs));
                        // Timer.setText(millisUntilFinished/1000+":" + millisUntilFinished / 1000);
                        //here you can have your logic to set text to edittext
                    }

                    public void onFinish() {
                        FinalizeTestClass finalizeTestClass=new FinalizeTestClass(Exam.this,Examid);
//
//                        Toast.makeText(getApplicationContext(),"زمان آزمون به پایان رسید",Toast.LENGTH_SHORT).show();
//                        finish();
                    }

                }.start();
            }

        });




        final AppPreferencesHelper appPreferencesHelper=new AppPreferencesHelper(this);
        Send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FinalizeTestClass finalizeTestClass=new FinalizeTestClass(Exam.this,Examid);
                ///Toast.makeText(getApplicationContext(),"Answer Sent",Toast.LENGTH_SHORT).show();
              //  finish();
//                for (GetsetExam e:adapter.getExamdata()) {
//                    HashMap<String,String> hashMap=new HashMap<>();
//                    hashMap.put("Testid",adapter.getExamdata().get(1).getTestid()+"");
//                    hashMap.put("answer", adapter.getTestAnswers().get(adapter.getExamdata().indexOf(e)));
//                    hashMap.put("quize", e.getQid()+"");
//                    hashMap.put("email",appPreferencesHelper.getCurrentEmail());
//                    ExamAnswerClass examAnswerClass=new ExamAnswerClass(Exam.this,hashMap);
//
//                }
            }
        });

    }

    @Override
    public void onBackPressed() {
       // super.onBackPressed();

        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(
                this);
        alertDialogBuilder.setTitle("Exit Exam");

        // set dialog message
        alertDialogBuilder
                .setMessage("Click yes to exit!")
                .setCancelable(false)
                .setPositiveButton("Yes",new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog,int id) {
                        // if this button is clicked, close
                        // current activity
                        dialog.cancel();
                        Exam.this.finish();
                    }
                })
                .setNegativeButton("No",new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog,int id) {
                        // if this button is clicked, just close
                        // the dialog box and do nothing
                        dialog.cancel();
                    }
                });
        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();



//
//       Dialog dialog = new Dialog(this);
//        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
//
//        //dialog.setContentView(R.layout.dialog_v2);
//        final TextView rejdialogButton = (TextView) dialog.findViewById(R.id.btn_accept);
//        final TextView rejbtncancle = (TextView) dialog.findViewById(R.id.btn_cancle);
//        final TextView rejtitle = (TextView) dialog.findViewById(R.id.title);
//        final TextView rejtext = (TextView) dialog.findViewById(R.id.text);
//        rejtitle.setText("انصراف");rejtext.setText("آیا از انجام این کار انصراف می دهید؟");
//        rejdialogButton.setText("انصراف");rejbtncancle.setText("بازگشت");
//        rejdialogButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Current_request="rejectjob";
//                Token();
//                Reject_dialog.dismiss();
//            }
//        });
//        rejbtncancle.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Reject_dialog.dismiss();
//            }
//        });

    }


    //    private Runnable updateTimerThread = new Runnable() {
//        public void run() {
//            timeInMilliseconds = SystemClock.uptimeMillis() - startTime;
//            updatedTime = timeSwapBuff + timeInMilliseconds;
//            int secs = (int) (updatedTime / 1000);
//
//            int mins = secs / 60;
//
//            secs = secs % 60;
//
//            int milliseconds = (int) (updatedTime % 1000);
//            timerValue.setText("" + mins + ":"
//                    + String.format("%02d", secs) + ":"
//                    + String.format("%03d", milliseconds));
//            customHandler.postDelayed(this, 0);
//        }
//    };
}
