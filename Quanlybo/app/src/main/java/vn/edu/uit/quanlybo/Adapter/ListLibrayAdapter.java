package vn.edu.uit.quanlybo.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import vn.edu.uit.quanlybo.Model.Cow;
import vn.edu.uit.quanlybo.Model.Library;
import vn.edu.uit.quanlybo.R;

/**
 * Created by Jackson Nghi on 11/26/2016.
 */

public class ListLibrayAdapter extends ArrayAdapter<Library> {
        int i ;
        String gender;
        ArrayList<String> titleLibrary = new ArrayList<>();

public ListLibrayAdapter(Context context, int resource, List<Library> libraries){
        super(context, resource, libraries);
        }

@Override
public Library getItem(int position) {
        return super.getItem(position);
        }

static class ViewHolder {
    TextView library_title;

}

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Library library = getItem(position);
        ListLibrayAdapter.ViewHolder holder;

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.library_item, parent, false);
            holder = new ListLibrayAdapter.ViewHolder();
            holder.library_title = (TextView)convertView.findViewById(R.id.library_title);

            convertView.setTag(holder);
        }else {
            holder = (ListLibrayAdapter.ViewHolder)convertView.getTag();
            i++;
        }
        holder.library_title.setText(library.getTitle());
        return convertView;
    }
}

