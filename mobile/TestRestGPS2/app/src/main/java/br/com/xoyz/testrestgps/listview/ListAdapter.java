package br.com.xoyz.testrestgps.listview;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import br.com.xoyz.testrestgps.entity.Check;
import br.com.xoyz.testrestgps.R;

/**
 * Created by lelag on 30/07/2017.
 */

public class ListAdapter  extends BaseAdapter {

    /**
     * this is our own collection of data, can be anything we want it to be as long as we get the
     * abstract methods implemented using this data and work on this data (see getter) you should
     * be fine
     */
    private List<Check> mData;

    /**
     * some context can be useful for getting colors and other resources for layout
     */
    private Context mContext;

    public ListAdapter(final Context context, final List<Check> mData) {
        this.mData = mData;
        this.mContext = context;
    }

    public List<Check> getData() {
        return mData;
    }

    public void showError(String msg){
        AlertDialog alertDialog = new AlertDialog.Builder(mContext).create();
        alertDialog.setTitle("Error");
        alertDialog.setMessage(msg);
        alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
        alertDialog.show();
    }

    @Override
    public int getCount() {
        return mData != null ? mData.size() : 0;
    }

    @Override
    public Object getItem(int i) {
        return mData != null ? mData.get(i) : null;
    }

    @Override
    public long getItemId(int i) {
        // just returning position as id here, could be the id of your model object instead
        return i;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        // this is where we'll be creating our view, anything that needs to update according to
        // your model object will need a view to visualize the state of that propery

        // the viewholder pattern for performance
        ViewHolder viewHolder;
        if (convertView == null) {

            // inflate the layout, see how we can use this context reference?
            LayoutInflater inflater = ((Activity) mContext).getLayoutInflater();
            convertView = inflater.inflate(R.layout.list_item, parent, false);

            // we'll set up the ViewHolder
            viewHolder = new ViewHolder();
            viewHolder.title = (TextView) convertView.findViewById(R.id.title);
            viewHolder.description = (TextView) convertView.findViewById(R.id.description);


            // store the holder with the view.
            convertView.setTag(viewHolder);

        } else {
            // we've just avoided calling findViewById() on resource every time
            // just use the viewHolder instead
            viewHolder = (ViewHolder) convertView.getTag();
        }

        // object item based on the position
        Check obj = mData.get(position);

        // assign values if the object is not null
        if (mData != null) {
            // get the TextView from the ViewHolder and then set the text (item name) and other values
            viewHolder.title.setText(obj.getAddress());
            viewHolder.description.setText(obj.getArrival());

        }
        return convertView;

    }

    static class ViewHolder {
        TextView title;
        TextView description;

    }
}
