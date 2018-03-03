//package androidjsoupparser.inducesmile.com.url_links;
//
//import android.support.v7.app.AppCompatActivity;
//import android.os.Bundle;
//import android.widget.ArrayAdapter;
//import android.widget.ListView;
//
//import com.google.firebase.database.DataSnapshot;
//import com.google.firebase.database.DatabaseError;
//import com.google.firebase.database.DatabaseReference;
//import com.google.firebase.database.FirebaseDatabase;
//import com.google.firebase.database.ValueEventListener;
//
//import java.util.ArrayList;
//
//public class Retrieve extends AppCompatActivity {
//    ListView listView;
//    FirebaseDatabase database;
//    DatabaseReference ref;
//    ArrayList<EventUrl> list;
//    ArrayAdapter<EventUrl> adapter;
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_retrieve);
//        listView = (ListView)findViewById(R.id.listView);
//        database = FirebaseDatabase.getInstance();
//        ref= database.getReference("Events");
//        list = new ArrayList<>();
//        adapter = new ArrayAdapter<EventUrl>(this.R.layout.list_layout, )
//        ref.addValueEventListener(new ValueEventListener() {
//            @Override
//            public void onDataChange(DataSnapshot dataSnapshot) {
//                for(DataSnapshot ds: dataSnapshot.getChildren())
//                {
//
//                }
//            }
//
//            @Override
//            public void onCancelled(DatabaseError databaseError) {
//
//            }
//        })
//    }
//}
