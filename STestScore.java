package p.zahra.testtbl.Stu.GetSets;

/**
 * Created by viv on 02/03/2018.
 */

public class STestScore {
    String id;
    String testid;
    String examdate;
    String score;
    String educode;
    String tid;

    public String getTid() {
        return tid;
    }

    public void setTid(String tid) {
        this.tid = tid;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setTestid(String testid) {
        this.testid = testid;
    }

    public void setExamdate(String examdate) {
        this.examdate = examdate;
    }

    public void setScore(String score) {
        this.score = score;
    }

    public void setEducode(String educode) {
        this.educode = educode;
    }

    public String getId() {
        return id;
    }

    public String getTestid() {
        return testid;
    }

    public String getExamdate() {
        return examdate;
    }

    public String getScore() {
        return score;
    }

    public String getEducode() {
        return educode;
    }
}
