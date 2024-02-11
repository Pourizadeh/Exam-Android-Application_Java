package p.zahra.testtbl.Stu.adapters;

import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import p.zahra.testtbl.R;
import p.zahra.testtbl.Stu.Activities.Exam;
import p.zahra.testtbl.Stu.GetSets.GetsetTestInfo;

import static p.zahra.testtbl.R.id.rcoursecode;


/**
 * Created by Lenovo Z on 15/01/2018.
 */

public class adapterGetTestInfo extends RecyclerView.Adapter<adapterGetTestInfo.viewholder>{
    Context contexttinfo;

    List<GetsetTestInfo> data;
    public adapterGetTestInfo(Context contexttinfo, List<GetsetTestInfo> data) {
        this.contexttinfo=contexttinfo;
        this.data=data;
    }


    @Override
    public adapterGetTestInfo.viewholder onCreateViewHolder(ViewGroup parent, int viewType) {
       View v= LayoutInflater.from(contexttinfo).inflate(R.layout.items_testinfo,parent,false);
        return new viewholder(v);
    }

    @Override
    public void onBindViewHolder(adapterGetTestInfo.viewholder holder, int position) {
final GetsetTestInfo getset=data.get(position);
        holder.rcoursecode.setText(getset.getRccode());
        holder.rtestname.setText(getset.getRtname());
        holder.rtxtDate.setText(getset.getRdate());
        holder.rtxtTime1.setText(getset.getRtime1());
        holder.rtimetaking.setText(getset.getRtimetake());
        holder.rteacherid.setText(getset.getRteachid());
        holder.rprofname.setText(getset.getRprofessname());
        holder.runiversityname.setText(getset.getRuniname());
        holder.redufieldcode.setText(getset.getReducode());
        holder.startexam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //check noe time is < than exam time
                //txtDate.setText(dayOfMonth + "-" + (monthOfYear + 1) + "-" + year);
                SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
                Calendar calendar = Calendar.getInstance();
                Date date = null; Date dnow=null;
                try {
                    date = formatter.parse(getset.getRdate());
                    String date2 = formatter.format(calendar.getTime());
                    dnow = formatter.parse(date2);
                    //        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy HH:mm");
                    // Date now=new Date();
//                    String Datetime=getset.getRdate()+""+getset.getRtime1();
//                    Date d=sdf.parse(Datetime);
//                    Toast.makeText(contexttinfo,System.currentTimeMillis()+"",Toast.LENGTH_SHORT).show();
//
//                    long mills = d.getTime() - System.currentTimeMillis();
//                    Toast.makeText(contexttinfo,mills+"",Toast.LENGTH_SHORT).show();

                    if (date.compareTo(dnow) > 0 || (date.compareTo(dnow) == 0)) {
                        Intent i = new Intent(contexttinfo, Exam.class);
                        i.putExtra("Examid", getset.getId() + "");
                        i.putExtra("ExamDuration", Integer.parseInt(getset.getRtimetake()));
                        contexttinfo.startActivity(i);

                    } else {
                        Toast.makeText(contexttinfo, "زمان آزمون گذشته است.", Toast.LENGTH_SHORT).show();
                    }

                } catch (ParseException e) {
                    e.printStackTrace();
                }


            }
        });
        //  Glide.with(context).load("//http://192.168.1.137/myprojects/img/"+getset.getUrlimg()).into(holder.imageview);
        //filme library Glide ro bebinam
    }

    @Override
    public int getItemCount() {
        return data.size();
    }
    public class viewholder extends ViewHolder{
//ImageView imageview;
TextView rcoursecode,rtestname,rtimetaking,rteacherid,rprofname,rtxtDate, rtxtTime1,runiversityname,
        redufieldcode;
       Button startexam;
        public viewholder(View itemView) {
            super(itemView);
          //  imageview=(ImageView) itemView.findViewById(R.id.img);
            rcoursecode=(TextView) itemView.findViewById(R.id.rcoursecode);
            rtestname=(TextView) itemView.findViewById(R.id.rtestname);
            rtxtDate=(TextView) itemView.findViewById(R.id.rin_date);
            rtxtTime1=(TextView) itemView.findViewById(R.id.rin_time1);
            rtimetaking=(TextView) itemView.findViewById(R.id.rtimetaking);
            rteacherid=(TextView) itemView.findViewById(R.id.rteacherid);
            rprofname=(TextView) itemView.findViewById(R.id.rprofname);
            runiversityname=(TextView) itemView.findViewById(R.id.runiversityname);
            redufieldcode=(TextView)itemView.findViewById(R.id.reducode);
            startexam=(Button)itemView.findViewById(R.id.startexam) ;




        }
    }
}