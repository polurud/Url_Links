package androidjsoupparser.inducesmile.com.url_links;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.os.AsyncTask;
import android.util.Log;
import java.lang.*;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.*;
import java.util.HashSet;
import java.util.List;

import static androidjsoupparser.inducesmile.com.url_links.Load_Urlevents.loadevent;
import static java.lang.System.*;

import androidjsoupparser.inducesmile.com.url_links.Load_Urlevents;

public class MainActivity extends AppCompatActivity {

    ListView listViewEvents;

    List<EventUrl>eventlist;
//    public static  int i = 1;
//    public static  int offset = 0;
    public static ArrayList<String> urls;

//    public static Document doc, doc1;
//    public static ArrayList<String> arr_linkText;
//    public static ArrayList<String> arr_titleText;
//    public static  ArrayList<String> arr_dayText;
//    public static  ArrayList<String> arr_timestartText;
//    public static ArrayList<String> arr_timeendText;
//    public static ArrayList<String> arr_summaryText ;
//    public static ArrayList<String> arr_location ;
     public  DatabaseReference rootRef, demoRef;
     public static ArrayList<EventUrl> listOfEvents;

//    public  String Url = "https://news.dartmouth.edu/events";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        rootRef = FirebaseDatabase.getInstance().getReference("Events");
        loadevent();
        listOfEvents = new ArrayList<>();
//        urls = new ArrayList<>();
//        arr_linkText = new ArrayList<>();
//       arr_titleText = new ArrayList<>();
//        arr_dayText = new ArrayList<>();
//        arr_timestartText = new ArrayList<>();
//         arr_timeendText = new ArrayList<>();
//        arr_summaryText  = new ArrayList<>();
//         arr_location  = new ArrayList<>();

        setContentView(R.layout.activity_main);


//        //loads first 6 pages
//            while(offset<51)
//            {
//                Url = "https://news.dartmouth.edu/events?"+"offset="+Integer.toString(offset)+"&audience_ids=3";
//                Log.d("show",Url);
//                urls.add(Url);
//                offset +=10;
//            }
//        JsoupAsyncTask jsoupAsyncTask = new JsoupAsyncTask();
//        jsoupAsyncTask.execute();

        listViewEvents = (ListView) findViewById(R.id.listViewEvents);

    }

    @Override
    protected void onStart() {
        super.onStart();
        rootRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
//                eventlist = new ArrayList<>();
                for(DataSnapshot eventSnapshot: dataSnapshot.getChildren())
                {
                    Map<String,Object> singleRun =  (Map<String, Object>) eventSnapshot.getValue();
//                    eventlist.clear();
//                    Log.d("Data.....", String.valueOf(singleRun.size()));
//                    Log.d("KeySet.....", singleRun.keySet().toString());
//                    Log.d("Errorrr.....", singleRun.values().toString());


                    EventUrl eventurl = new EventUrl();
//                    Log.d("Errorrr.....", String.valueOf(singleRun.get("Description")));



                    eventurl.setDescription(singleRun.get("Description").toString());
                    eventurl.setStart(singleRun.get("Start").toString());
                    eventurl.setTitle(singleRun.get("Title").toString());
                    eventurl.setEnd(singleRun.get("End").toString());
                    eventurl.setDate(singleRun.get("Date").toString());
                    eventurl.setUrl(singleRun.get("Url").toString());
                    eventurl.setLocation(singleRun.get("Location").toString());

                    listOfEvents.add(eventurl);

//                    EventUrl event1 = eventSnapshot.getValue(EventUrl.class);
//                    eventlist.add(event1);

//                    listOfEvents.add(singleRun.get("Description"));
                }
//                Event_list adapter = new Event_list(MainActivity.this, eventlist);
//                listViewEvents.setAdapter(adapter);
                Log.d("Data.....", String.valueOf(listOfEvents.size()));
                Log.d("Data.....First Value", String.valueOf(listOfEvents.get(0)));
            }
            @Override
            public void onCancelled(DatabaseError databaseError) {
            }
        });


    }

    //parse and store url in Firebase
//    private class JsoupAsyncTask extends AsyncTask<Void, Void, ArrayList<String>> {
//        ArrayList<String> arr_final = new ArrayList<>();
//        @Override
//        protected ArrayList<String> doInBackground(Void... params) {
//            String linkText = "";
//                try {
//                    for(String temp: urls) {
//                        doc = Jsoup.connect(temp).get();
//                        Elements title = doc.select("h2.title");
//                        Elements day = doc.select("h3.event-day");
//                        Elements time = doc.select("h3.event-time");
//                        Elements summary = doc.select("p.summary");
//                        Elements hre = doc.select("h2.title,abs.href");
//                        //parse url text
//                        for (Element link : hre) {
//                            linkText = link.html();
//                            String s1 = linkText.substring(linkText.indexOf('/', 0), linkText.indexOf('>', 0) - 1);
//
//                            String s2 = "https://news.dartmouth.edu" + s1;
//
//
//                            arr_linkText.add(s2);
//                        }
////                parse location from each href
//                        for (int j = 0; j < arr_linkText.size(); j++) {
//                            String newlink = arr_linkText.get(j);
//                            doc1 = Jsoup.connect(newlink).get();
//                            Elements location = doc1.getElementsByAttributeValue("class", "location");
//                            for (Element a : location) {
//                                String lo = a.text();
//                                arr_location.add(lo);
//                                break;
//                            }
//
//                        }
//
//                        //parse event title
//                        for (Element link : title) {
//                            linkText = link.text();
//
//                            arr_titleText.add(linkText);
//                        }
//                        for (Element link : day) {
//                            linkText = link.html();
//                            arr_dayText.add(linkText);
//                        }
//                        //parse start-time
//                        for (Element link : time) {
//                            linkText = link.text();
//                            if (linkText.contains("All")) {
//                                arr_timestartText.add(linkText);
//                            } else {
//                                String s1 = linkText.substring(linkText.indexOf(':') - 1, linkText.indexOf('-', 0));
//                                arr_timestartText.add(s1);
//                            }
//
//                        }
//                        //parse end-time
//                        for (Element link : time) {
//                            linkText = link.text();
//                            if (linkText.contains("All")) {
//                                arr_timeendText.add("");
//                            } else {
//                                String s1 = linkText.substring(linkText.indexOf('-', 0) + 1, linkText.lastIndexOf('m') + 1);
//                                arr_timeendText.add(s1);
//                            }
//                        }
//                        //parse summary
//                        for (Element link : summary) {
//                            linkText = link.text();
//                            arr_summaryText.add(linkText);
//                        }
//
//                        for (int j = 0; j < arr_summaryText.size(); j++) {
//
//                            String url1 = arr_linkText.get(j);
//                            String title1 = arr_titleText.get(j);
//                            String start1 = arr_timestartText.get(j);
//                            String end1 = arr_timeendText.get(j);
//                            String day1 = arr_dayText.get(j);
//                            String summary1 = arr_summaryText.get(j);
//                            String loc1 = arr_location.get(j);
//
//                            String addn = url1 + "::" + title1 + "::" + start1 + "::" + end1 + "::" + day1 + "::" + summary1 + "::" + loc1;
//
//                            if (!arr_final.contains(addn))
//                                arr_final.add(addn);
//                        Log.d("String returning value", addn);
//                        }
//                    }
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//
//
//                return arr_final;
//
//        }
//
//        @Override
//        protected void onPostExecute(ArrayList<String> result) {
//           // DatabaseReference rootRef, demoRef;
//
//            for (String temp_result : result) {
//
//                String str = temp_result;
//                List<String> finalList = Arrays.asList(str.split("::"));
//
//                rootRef = FirebaseDatabase.getInstance().getReference();
//                String x = Integer.toString(i);
//                demoRef = rootRef.child("Events").child(x).child("Url");
//                demoRef.push().setValue(finalList.get(0));
//                demoRef = rootRef.child("Events").child(x).child("Title");
//                demoRef.push().setValue(finalList.get(1));
//                demoRef = rootRef.child("Events").child(x).child("Start");
//                demoRef.push().setValue(finalList.get(2));
//                demoRef = rootRef.child("Events").child(x).child("End");
//                demoRef.push().setValue(finalList.get(3));
//                demoRef = rootRef.child("Events").child(x).child("Date");
//                demoRef.push().setValue(finalList.get(4));
//                demoRef = rootRef.child("Events").child(x).child("Description");
//                demoRef.push().setValue(finalList.get(5));
//                demoRef = rootRef.child("Events").child(x).child("Location");
//                demoRef.push().setValue(finalList.get(6));
//
//                i = i + 1;
//
//
//            }
//        }
//    }

}
