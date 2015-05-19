package com.horizontalstackview.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.horizontalstackview.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class StackViewAdapter extends BaseAdapter {

    private Context mContext;
    private List<String> mPhotos;

    public StackViewAdapter(Context context, List<String> photos) {
        mContext = context;
        mPhotos = photos;
    }

    /*********************************************************************/
    /**************************** BaseAdapter ****************************/
    /*********************************************************************/

    @Override
    public int getCount() {
        if(mPhotos == null){
            return 0;
        } else {
            return mPhotos.size();
        }
    }

    @Override
    public String getItem(int position) {
        return mPhotos.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(final int position, View view, ViewGroup parent) {
        final ViewHolder viewHolder;
        if (view == null) {
            LayoutInflater vi = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = vi.inflate(R.layout.stack_view_item, null, false);
            viewHolder = new ViewHolder();
            viewHolder.mPhotoView = (ImageView) view.findViewById(R.id.slider_item_image);
            viewHolder.mCounter = (TextView) view.findViewById(R.id.slider_item_count);
            view.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) view.getTag();
        }

        Picasso.with(mContext).load(mPhotos.get(position)).fit().centerCrop().into(viewHolder.mPhotoView);
        viewHolder.mCounter.setText((position+1)+"/"+getCount());
        return view;
    }

    private static final class ViewHolder {
        private static ImageView mPhotoView;
        private static TextView mCounter;
    }
}