package unlv.erc.emergo.controller;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;

import org.osmdroid.DefaultResourceProxyImpl;

import unlv.erc.emergo.R;


public class CustomResourceProxy extends DefaultResourceProxyImpl {

    private final Context mContext;
    public CustomResourceProxy(Context pContext) {
        super(pContext);
        mContext = pContext;
    }

    @Override
    public Bitmap getBitmap(final bitmap pResId) {
        switch (pResId){
            case person:
                //your image goes here!!!
                return BitmapFactory.decodeResource(mContext.getResources(), R.drawable.circular_progress_bar);
        }
        return super.getBitmap(pResId);
    }

    @Override
    public Drawable getDrawable(final bitmap pResId) {
        switch (pResId){
            case person:
                return mContext.getResources().getDrawable(R.drawable.circular_progress_bar);
        }
        return super.getDrawable(pResId);
    }
}
