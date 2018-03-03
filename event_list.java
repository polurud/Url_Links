package androidjsoupparser.inducesmile.com.url_links;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by HP on 3/3/2018.
 */

class Event_list extends ArrayAdapter<EventUrl> {

    private Activity context;
    private List<EventUrl> eventlist;
    public Event_list(Activity context, List<EventUrl> eventlist){

        super(context, R.layout.list_layout,eventlist);
        this.context = context;
        this.eventlist = eventlist;

    }

    public View getView(int position, View counterView,
                        ViewGroup parent)
    {
        LayoutInflater inflator = context.getLayoutInflater();
        View listViewItem = inflator.inflate(R.layout.list_layout, null, true);
        TextView textviewEvent = (TextView) listViewItem.findViewById(R.id.textViewEvent);
        TextView textviewTitle = (TextView) listViewItem.findViewById(R.id.textViewTitle);
        TextView textviewDate = (TextView) listViewItem.findViewById(R.id.textViewDate);

        EventUrl eventi = eventlist.get(position);
        textviewEvent.setText(eventi.getDescription());
        textviewTitle.setText(eventi.getTitle());
        textviewEvent.setText(eventi.getDate());
        textviewEvent.setText(eventi.getUrl());
        textviewTitle.setText(eventi.getStart());
        textviewEvent.setText(eventi.getEnd());
        textviewEvent.setText(eventi.getLocation());
        return listViewItem;

    }


}
