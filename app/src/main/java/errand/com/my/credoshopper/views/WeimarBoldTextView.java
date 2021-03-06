package errand.com.my.credoshopper.views;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.support.v7.widget.AppCompatTextView;
import android.util.AttributeSet;

import errand.com.my.credoshopper.R;


/**
 * PoppinsBoldTextView by Ekerete, created on 29/01/2018
 **/
public class WeimarBoldTextView extends AppCompatTextView {

//	private static final String TAG = "EditText";

    private Typeface typeface;

    public WeimarBoldTextView(Context context) {
        super(context);
    }

    public WeimarBoldTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        setCustomFont(context, attrs);
    }

    public WeimarBoldTextView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        setCustomFont(context, attrs);
    }

    private void setCustomFont(Context ctx, AttributeSet attrs) {
        TypedArray a = ctx.obtainStyledAttributes(attrs, R.styleable.WeimarBoldTextView);
        String customFont = a.getString(R.styleable.WeimarBoldTextView_WeimarBoldTextView);
        setCustomFont(ctx, customFont);
        a.recycle();
    }

    private boolean setCustomFont(Context ctx, String asset) {
        try {
            if (typeface == null) {
                // Log.i(TAG, "asset:: " + "fonts/" + asset);
                typeface = Typeface.createFromAsset(ctx.getAssets(),
                        "weimar.ttf");
            }

        } catch (Exception e) {
            e.printStackTrace();
            // Log.e(TAG, "Could not get typeface: " + e.getMessage());
            return false;
        }

        setTypeface(typeface);
        return true;
    }
}
