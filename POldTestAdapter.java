package p.zahra.testtbl.Prof;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
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
import p.zahra.testtbl.Stu.GetSets.TestScore;

/**
 * Created by viv on 02/03/2018.
 */


public class POldTestAdapter extends RecyclerView.Adapter<POldTestAdapter.viewholder>{
    Context contexttinfo;

    List<GetsetTestInfo> data;
    public POldTestAdapter(Context contexttinfo, List<GetsetTestInfo> data) {
        this.contexttinfo=contexttinfo;
        this.data=data;
    }


    @Override
    public viewholder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(contexttinfo).inflate(R.layout.item_poldtest,parent,false);
        return new viewholder(v);
    }

    @Override
    public void onBindViewHolder(viewholder holder, int position) {
        final GetsetTestInfo getset=data.get(position);
        holder.rcoursecode.setText(getset.getRccode());
        holder.rtestname.setText(getset.getRtname());
        holder.rtxtDate.setText(getset.getRdate());
        holder.rtxtTime1.setText(getset.getRtime1());holder.rtxtTime1.setVisibility(View.GONE);
        holder.runiversityname.setText(getset.getRuniname());
        holder.redufieldcode.setText(getset.getReducode());
        holder.rtimetaking.setText(getset.getRtimetake());holder.rtimetaking.setVisibility(View.GONE);
        holder.rteacherid.setText(getset.getRteachid());holder.rteacherid.setVisibility(View.GONE);
        holder.rprofname.setText(getset.getRprofessname());holder.rprofname.setVisibility(View.GONE);
        holder.startexam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(contexttinfo, TestScores.class);
                intent.putExtra("Examid",getset.getId());
                contexttinfo.startActivity(intent);
            }
        });
        //  Glide.with(context).load("//http://192.168.1.137/myprojects/img/"+getset.getUrlimg()).into(holder.imageview);
        //filme library Glide ro bebinam
    }

    @Override
    public int getItemCount() {
        return data.size();
    }
    public class viewholder extends RecyclerView.ViewHolder {
        //ImageView imageview;
        TextView rcoursecode,rtestname,rtimetaking,rteacherid,rprofname,rtxtDate, rtxtTime1,runiversityname,redufieldcode
                ,txtrteacherid,txtrprofname,txtrin_time1,txtrtimetaking;
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
            txtrteacherid=(TextView)itemView.findViewById(R.id.txtrteacherid);
            txtrteacherid.setVisibility(View.GONE);
            txtrprofname=(TextView)itemView.findViewById(R.id.txtrprofname);txtrprofname.setVisibility(View.GONE);
            txtrin_time1=(TextView)itemView.findViewById(R.id.txtrin_time1);
            txtrin_time1.setVisibility(View.GONE);
            txtrtimetaking=(TextView)itemView.findViewById(R.id.txtrtimetaking);txtrtimetaking.setVisibility(View.GONE);

        }
    }
}