package p.zahra.testtbl.Prof;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;

import java.util.List;

import p.zahra.testtbl.R;
import p.zahra.testtbl.Stu.Activities.SOldTests;
import p.zahra.testtbl.Stu.Classes.sAllTestsClass;
import p.zahra.testtbl.Stu.GetSets.STestScore;
import p.zahra.testtbl.Stu.GetSets.TestScore;
import p.zahra.testtbl.Stu.adapters.sOldTestAdapter;

public class TestScores extends AppCompatActivity {
    RecyclerView recyclerView;
    ALlScoreAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_scores);
        Bundle b = this.getIntent().getExtras();
        String testid="";
        if (b != null){
            testid = b.getString("Examid");
        }
        recyclerView=(RecyclerView)findViewById(R.id.rcyold);
        recyclerView.setLayoutManager(new StaggeredGridLayoutManager(1,StaggeredGridLayoutManager.VERTICAL) );
        GetTestScoresClass testScoresClass=new GetTestScoresClass(this,testid);

        testScoresClass.getpost(new GetTestScoresClass.onpost() {
            @Override
            public void onpost(List<TestScore> examdata) {

                adapter =new ALlScoreAdapter(TestScores.this,examdata);
                recyclerView.setAdapter(adapter);

            }
        });


    }
}
