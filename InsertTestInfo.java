package p.zahra.testtbl.Prof;

import android.content.Intent;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.AppCompatRadioButton;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.Calendar;
import p.zahra.testtbl.R;

import static android.icu.lang.UCharacter.GraphemeClusterBreak.V;

public class InsertTestInfo extends AppCompatActivity  {
    InsertTestInfoClass insertTestInfoClass;
    LinearLayout linearLayout;
    // LinearLayout linL;
    Button btn;
    EditText txt;
    QuestionClass questionClass;
   //String qedt,choice1,choice2,choice3,choice4;
    FloatingActionButton addquestion;
    ImageView btnTimePicker1,btnDatePicker, btnTimePicker2;
    EditText txtDate, txtTime1,txtTime2,universityname;
    private int mYear, mMonth, mDay, mHour, mMinute;
    EditText coursecode,testname,timetaking,teacherid,profname,edteducode;
   String tname,timetake,professname,date,time1,uniname,teducode;
    RelativeLayout relinstinfo;
    RelativeLayout relinsq;
    Button btnins;
    String ccode,teachid;
    public static int Current_Exam_id =-1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.insert_testinfo);
        setTheme(R.style.AppTheme);
        linearLayout =(LinearLayout)findViewById(R.id.linearLayout);
        addquestion=(FloatingActionButton)findViewById(R.id.addquestion);addquestion.setVisibility(View.GONE);
        txt=(EditText)findViewById(R.id.txt);
        btn=(Button)findViewById(R.id.btn);
        btnDatePicker=(ImageView)findViewById(R.id.btn_date);
        btnTimePicker1=(ImageView)findViewById(R.id.btn_time1);
        // btnTimePicker2=(Button)findViewById(R.id.btn_time2);
        relinsq=(RelativeLayout)findViewById(R.id.relinsquestion) ;
        relinstinfo=(RelativeLayout)findViewById(R.id.relinstinfo) ;

        txtDate=(EditText)findViewById(R.id.in_date);
        txtTime1=(EditText)findViewById(R.id.in_time1);
        coursecode=(EditText)findViewById(R.id.coursecode);
        testname=(EditText)findViewById(R.id.testname);
        timetaking=(EditText)findViewById(R.id.timetaking);
        teacherid=(EditText)findViewById(R.id.teacherid);
        profname=(EditText)findViewById(R.id.profname);
       btnins=(Button)findViewById(R.id.btnins);
        universityname=(EditText)findViewById(R.id.universityname);
        edteducode=(EditText)findViewById(R.id.edteducode);
        // txtTime2=(EditText)findViewById(R.id.in_time2);
        BottomNavigationView bottomNavigationViewinsQ=(BottomNavigationView)findViewById(R.id.bottom_navigationinsQ);
       bottomNavigationViewinsQ.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
           @Override
           public boolean onNavigationItemSelected(@NonNull MenuItem item) {
               switch (item.getItemId()) {
                   case R.id.action_step1:
                       //  Intent in=new Intent(getBaseContext(),Profile.class);
                       // startActivity(in);
                       // Intent intent= new Intent(StuFirstPage.this,Profile.class);
                       //startActivity(intent);
                       // rl.setVisibility(View.VISIBLE);
                       // tableRowtwo.setVisibility(View.GONE);
                       // textMusic.setVisibility(View.GONE);
                       relinstinfo.setVisibility(View.VISIBLE);
                       relinsq.setVisibility(View.GONE);
                       addquestion.setVisibility(View.GONE);
                       break;
                   case R.id.action_step2:
                       // tableLayoutone.setVisibility(View.GONE);
                       // tableRowtwo.setVisibility(View.VISIBLE);
                       // textMusic.setVisibility(View.GONE);
                       relinstinfo.setVisibility(View.GONE);
                       relinsq.setVisibility(View.VISIBLE);
                       addquestion.setVisibility(View.VISIBLE);

                       break;

               }
               return false;

           }
       });
       // btnDatePicker.setOnClickListener(this);
    //    btnTimePicker1.setOnClickListener(this);
     //  btnins.setOnClickListener(this);
     //   btn.setOnClickListener(this);
        // btnTimePicker2.setOnClickListener(this);



        btnDatePicker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // Get Current Date
                final Calendar c = Calendar.getInstance();
                mYear = c.get(Calendar.YEAR);
                mMonth = c.get(Calendar.MONTH);
                mDay = c.get(Calendar.DAY_OF_MONTH);


                DatePickerDialog datePickerDialog = new DatePickerDialog(InsertTestInfo.this,
                        new DatePickerDialog.OnDateSetListener() {

                            @Override
                            public void onDateSet(DatePicker view, int year,
                                                  int monthOfYear, int dayOfMonth) {

                                txtDate.setText(dayOfMonth + "-" + (monthOfYear + 1) + "-" + year);
//date=txtDate.getText().toString();
                            }
                        }, mYear, mMonth, mDay);
                datePickerDialog.show();
            }
        });



        btnTimePicker1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Get Current Time
                final Calendar c = Calendar.getInstance();
                mHour = c.get(Calendar.HOUR_OF_DAY);
                mMinute = c.get(Calendar.MINUTE);

                // Launch Time Picker Dialog
                TimePickerDialog timePickerDialog = new TimePickerDialog(InsertTestInfo.this,
                        new TimePickerDialog.OnTimeSetListener() {

                            @Override
                            public void onTimeSet(TimePicker view, int hourOfDay,
                                                  int minute) {

                                txtTime1.setText(hourOfDay + ":" + minute);
                            }
                        }, mHour, mMinute, false);
                //   time1=txtTime1.getText().toString();
                timePickerDialog.show();
            }
        });

        btnins.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ccode = coursecode.getText().toString().trim(); ;
                tname = testname.getText().toString().trim();
                date = txtDate.getText().toString().trim();
                time1= txtTime1.getText().toString().trim();
                timetake = timetaking.getText().toString().trim();
                teachid = teacherid.getText().toString().trim();
                professname = profname.getText().toString().trim();
                uniname = universityname.getText().toString().trim();
                teducode=edteducode.getText().toString().trim();

                insertTestInfoClass = new InsertTestInfoClass(InsertTestInfo.this, ccode,tname,date,time1,timetake,
                        teachid,professname,uniname,teducode);
        /*    if ((userema.isEmpty())) {
                Toast.makeText(Login.this, "Please enter your email", Toast.LENGTH_SHORT).show();
            } else if (userpass.isEmpty()) {
                Toast.makeText(Login.this, "Please enter your password", Toast.LENGTH_SHORT).show();
            } else {
                insertTestInfoClass = new InsertTestInfoClass(InsertTestInfo.this, userema, userpass);

            }*/
            }
        });

        addquestion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                question();
            }
        });
    }


    void question() {
   //    final String i;
       // setTheme(R.style.AppTheme);
        final EditText questionedt = new EditText(getApplicationContext());
        final   EditText ch1edt = new EditText(getApplicationContext());
        final EditText ch2edt = new EditText(getApplicationContext());
        final EditText ch3edt = new EditText(getApplicationContext());
      final  EditText ch4edt = new EditText(getApplicationContext());
        final TextView answer=new TextView((getApplicationContext()));
        final   EditText edtanswer = new EditText(getApplicationContext());
       Button insert = new Button(getApplicationContext());

      // RadioButton  button1 = new RadioButton(getApplicationContext());
      //  RadioButton button2 = new RadioButton(getApplicationContext());
        //  button2.setId();
      //  RadioButton button3 = new RadioButton(getApplicationContext());
       // RadioButton button4 = new RadioButton(getApplicationContext());

       // final RadioGroup group = new RadioGroup(getApplicationContext());
      //  group.addView(button1);
       // group.addView(button2);
       // group.addView(button3);
       // group.addView(button4);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT);

        questionedt.setLayoutParams(layoutParams);
        ch1edt.setLayoutParams(layoutParams);
        ch2edt.setLayoutParams(layoutParams);
        ch3edt.setLayoutParams(layoutParams);
        ch4edt.setLayoutParams(layoutParams);
      //  group.setLayoutParams(layoutParams);
        answer.setLayoutParams(layoutParams);
        edtanswer.setLayoutParams(layoutParams);
        insert.setLayoutParams(layoutParams);
        questionedt.setHint("Question");
        ch1edt.setHint("Choice One");
        ch2edt.setHint("Choice Two");
        ch3edt.setHint("Choice Three");
        ch4edt.setHint("Choice Four");
        edtanswer.setHint("1");
        questionedt.setHintTextColor(Color.GREEN);
        ch1edt.setHintTextColor(Color.GREEN);
        ch2edt.setHintTextColor(Color.GREEN);
        ch3edt.setHintTextColor(Color.GREEN);
        ch4edt.setHintTextColor(Color.GREEN);
       // edtanswer.setHintTextColor(Color.GREEN);
        answer.setText("Type number of correct answer ( 1 to 4 ) : ");
        insert.setText("Insert the Question");
        insert.setBackgroundResource(R.drawable.border);
      //  insert.setId(0);

     /*   ColorStateList colorStateList = new ColorStateList (
                new int [][]{
                        new int []{android.R.attr.state_checked},
                        new int []{android.R.attr.state_checked}
                },
                new int []{
                        R.drawable.border
                        , R.drawable.border
                }

        );

        int[][] states = new int[][] {
                new int[] { android.R.attr.state_focused}, // enabled
                //new int[] {-android.R.attr.state_enabled}, // disabled
                //new int[] {-android.R.attr.state_checked}, // unchecked
                new int[] { android.R.attr.state_window_focused}  // pressed
        };

        int[] colors = new int[] {
                Color.GREEN,
                //Color.BLUE,
                //Color.YELLOW,
                Color.GRAY
        };

        ColorStateList myColorAccentList = new ColorStateList(states, colors);*/
        questionedt.getBackground().mutate().setColorFilter(getResources().getColor(R.color.colorAccent), PorterDuff.Mode.SRC_ATOP);
        ch1edt.getBackground().mutate().setColorFilter(getResources().getColor(R.color.colorAccent), PorterDuff.Mode.SRC_ATOP);
        ch2edt.getBackground().mutate().setColorFilter(getResources().getColor(R.color.colorAccent), PorterDuff.Mode.SRC_ATOP);
        ch3edt.getBackground().mutate().setColorFilter(getResources().getColor(R.color.colorAccent), PorterDuff.Mode.SRC_ATOP);
        ch4edt.getBackground().mutate().setColorFilter(getResources().getColor(R.color.colorAccent), PorterDuff.Mode.SRC_ATOP);
        edtanswer.getBackground().mutate().setColorFilter(getResources().getColor(R.color.colorAccent), PorterDuff.Mode.SRC_ATOP);
        questionedt.setHighlightColor(Color.GREEN);
        ch1edt.setHighlightColor(Color.GREEN);
        ch2edt.setHighlightColor(Color.GREEN);
        ch3edt.setHighlightColor(Color.GREEN);
        ch4edt.setHighlightColor(Color.GREEN);
       // answer.getBackground().mutate().setColorFilter(getResources().getColor(R.color.colorPrimaryDark), PorterDuff.Mode.SRC_ATOP);
        edtanswer.setHighlightColor(Color.GREEN);
       answer.setTextSize(20);
        answer.setTextColor(Color.BLACK);

       //questionedt.setCursorVisible(false);

        // button1.setSupportButtonTintList(colorStateList);
     ////   button2.setSupportButtonTintList(colorStateList);
     //   button3.setSupportButtonTintList(colorStateList);

        //insert.setSupportBackgroundTintList(colorStateList);


        linearLayout.addView(questionedt);
        linearLayout.addView(ch1edt);
        linearLayout.addView(ch2edt);
        linearLayout.addView(ch3edt);
        linearLayout.addView(ch4edt);
        linearLayout.addView(answer);
        linearLayout.addView(edtanswer);
      //  linearLayout.addView(group);
        linearLayout.addView(insert);
        insert.setClickable(true);
     /*   group.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(RadioGroup arg0, int arg1) {
                switch (group.getCheckedRadioButtonId()) {

                    case 1: {

                       final String i = "1";
                       ans=i;
                        Toast.makeText(InsertTestInfo.this, "answer is " + i, Toast.LENGTH_SHORT).show();
                    }
                    break;
                    case 2: {
                      final String  i = "2";
                        ans=i;

                        Toast.makeText(InsertTestInfo.this, "answer is " + i, Toast.LENGTH_SHORT).show();
                    }
                    break;
                    case 3: {
                     final String   i= "3";
                        ans=i;
                        Toast.makeText(InsertTestInfo.this, "answer is " + i, Toast.LENGTH_SHORT).show();
                    }
                    break;
                    case 4: {
                     final String  i = "4";
                        ans=i;
                        Toast.makeText(InsertTestInfo.this, "answer is " + i, Toast.LENGTH_SHORT).show();
                    }
                    break;
                    default:
                        break;

                }
            }
        });  */

    insert.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if (Current_Exam_id!=-1){
                String   qedt = questionedt.getText().toString().trim();
                String choice1 = ch1edt.getText().toString().trim();
                String choice2 = ch2edt.getText().toString().trim();
                String choice3 = ch3edt.getText().toString().trim();
                String choice4 = ch4edt.getText().toString().trim();
                String ans=edtanswer.getText().toString().trim();
                questionClass=new QuestionClass(InsertTestInfo.this,qedt,choice1,choice2,choice3,choice4,ans,teachid,ccode,Current_Exam_id+"");
                // Toast.makeText(getApplicationContext(),"ok",Toast.LENGTH_SHORT).show();

            }else {
                Toast.makeText(getApplicationContext(),"لطفا ابتدا اطلاعات آزمون را وارد کنید.",Toast.LENGTH_SHORT).show();
            }

        }
    });

    }

}