package p.zahra.testtbl.Prof;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import p.zahra.testtbl.R;
import p.zahra.testtbl.Stu.GetSets.STestScore;
import p.zahra.testtbl.Stu.GetSets.TestScore;
import p.zahra.testtbl.Stu.adapters.sOldTestAdapter;

/**
 * Created by viv on 02/03/2018.
 */

public class ALlScoreAdapter extends RecyclerView.Adapter<ALlScoreAdapter.viewholder> {
    Context contexttinfo;

    List<TestScore> data;
    public ALlScoreAdapter(Context contexttinfo, List<TestScore> data) {
        this.contexttinfo=contexttinfo;
        this.data=data;
    }


    @Override
    public viewholder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(contexttinfo).inflate(R.layout.item_pscore,parent,false);
        return new viewholder(v);
    }

    @Override
    public void onBindViewHolder(viewholder holder, int position) {
        final TestScore getset=data.get(position);
        holder.testid.setText(getset.getTestid());
        holder.score.setText(getset.getScore());
        holder.sid.setText(getset.getSid());
        //  Glide.with(context).load("//http://192.168.1.137/myprojects/img/"+getset.getUrlimg()).into(holder.imageview);
        //filme library Glide ro bebinam
    }

    @Override
    public int getItemCount() {
        return data.size();
    }
    public class viewholder extends RecyclerView.ViewHolder {
        //ImageView imageview;
        TextView testid,score,date,sid;
        public viewholder(View itemView) {
            super(itemView);
            sid=(TextView) itemView.findViewById(R.id.sid);
            date=(TextView) itemView.findViewById(R.id.date);
            score=(TextView) itemView.findViewById(R.id.score);
            testid=(TextView) itemView.findViewById(R.id.testid);
        }
    }
}
