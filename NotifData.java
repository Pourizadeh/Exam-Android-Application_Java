package p.zahra.testtbl;

import android.os.Parcel;
import android.os.Parcelable;



public class NotifData implements Parcelable {

    private String title;
    private String body;
    private String click_action;

    public NotifData() {
    }

    public NotifData(String title,String body,String click_action) {
        this.title = title;
        this.body = body;
        this.click_action = click_action;
    }


    public String getTitle() {
        return title;
    }

    public String getBody() {
        return body;
    }

    public String getClick_action() {
        return click_action;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public void setClick_action(String click_action) {
        this.click_action = click_action;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.title);
        dest.writeString(this.body);
        dest.writeString(this.click_action);
    }

    protected NotifData(Parcel in) {
        this.title = in.readString();
        this.body = in.readString();
        this.click_action = in.readString();
    }

    public static final Creator<NotifData> CREATOR = new Creator<NotifData>() {
        public NotifData createFromParcel(Parcel source) {
            return new NotifData(source);
        }

        public NotifData[] newArray(int size) {
            return new NotifData[size];
        }
    };
}
