package androidjsoupparser.inducesmile.com.url_links;

/**
 * Created by HP on 3/3/2018.
 */

public class EventUrl {
    private String Title;
    private  String Date;
    private String Start;
    private  String End;
    private String Url;
    private String Description;
    private String Location;

    public EventUrl() {
    }

    public EventUrl(String title, String date, String start, String end, String url, String description, String location) {
        this.Title = title;
        this.Date = date;
        this.Start = start;
        this.End = end;
        this.Url = url;
        this.Description = description;
        this.Location = location;
    }

    public void setTitle(String title) {
        this.Title = title;
    }

    public void setDate(String date) {
        this.Date = date;
    }

    public void setStart(String start) {
        this.Start = start;
    }

    public void setEnd(String end) {
        this.End = end;
    }

    public void setUrl(String url) {
        this.Url = url;
    }

    public void setDescription(String description) {
        this.Description = description;
    }

    public void setLocation(String location) {
        this.Location = location;
    }


    public String getTitle() {
        return Title;
    }

    public String getDate() {
        return Date;
    }

    public String getStart() {
        return Start;
    }

    public String getEnd() {
        return End;
    }

    public String getUrl() {
        return Url;
    }

    public String getDescription() {
        return Description;
    }

    public String getLocation() {
        return Location;
    }
}
