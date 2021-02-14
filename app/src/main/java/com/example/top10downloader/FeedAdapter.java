package com.example.top10downloader;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class FeedAdapter extends ArrayAdapter {
    private static final String TAG = "FeedAdapter";
    private final int layoutResource;
    private final LayoutInflater layoutInflater;
    private List<FeedEntry> applications;

    public FeedAdapter(@NonNull Context context, int resource, List<FeedEntry> application) {
        super(context, resource);
        this.layoutResource = resource;
        this.layoutInflater = LayoutInflater.from(context);
        this.applications = application;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        ViewHolder viewHolder;

        if (convertView == null) {
            Log.d(TAG, "getView: called with null convertView");
            convertView = layoutInflater.inflate(layoutResource, parent, false);

            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        } else {
            Log.d(TAG, "getView: provided a convertView");
            viewHolder = (ViewHolder) convertView.getTag();
        }

        /*TextView tvName = convertView.findViewById(R.id.tvName);
        TextView tvArtist = convertView.findViewById(R.id.tvArtist);
        TextView tvSummary = convertView.findViewById(R.id.tvSummary);*/

        FeedEntry currentApp = applications.get(position);

        viewHolder.tvName.setText(currentApp.getName());
        viewHolder.tvArtist.setText(currentApp.getArtist());
        viewHolder.tvSummary.setText(currentApp.getSummary());

        return convertView;
    }

    @Override
    public int getCount() {
        return applications.size();
    }

    private class ViewHolder {
        final TextView tvName;
        final TextView tvArtist;
        final TextView tvSummary;

        ViewHolder(View v) {
            this.tvName = v.findViewById(R.id.tvName);
            this.tvArtist = v.findViewById(R.id.tvArtist);
            this.tvSummary = v.findViewById(R.id.tvSummary);
        }


    }
}


