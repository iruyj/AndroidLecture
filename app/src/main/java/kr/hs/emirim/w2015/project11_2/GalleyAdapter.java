package kr.hs.emirim.w2015.project11_2;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Gallery;
import android.widget.ImageView;

public class GalleyAdapter extends BaseAdapter {
    Context context;
    int[] postIds = {R.drawable.mov1,R.drawable.mov2,R.drawable.mov3,R.drawable.mov4,R.drawable.mov5,
                     R.drawable.mov6,R.drawable.mov7,R.drawable.mov8,R.drawable.mov9,R.drawable.mov10};
    ImageView imgvLarge;

    public GalleyAdapter(Context context, ImageView imvL){
        this.context = context;
        this.imgvLarge = imvL;
    }
    @Override
    public int getCount() {
        return postIds.length;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int pos, View view, ViewGroup viewGroup) {
        ImageView imgv = new ImageView(context);
        imgv.setLayoutParams(new Gallery.LayoutParams(200,300));
        imgv.setImageResource(postIds[pos]);
        imgv.setScaleType(ImageView.ScaleType.FIT_CENTER);

        final int post= pos;
        imgv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imgvLarge.setImageResource(postIds[post]);
            }
        });

        return imgv;
    }
}
