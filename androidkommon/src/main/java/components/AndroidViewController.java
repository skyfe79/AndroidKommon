package components;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.widget.FrameLayout;

/**
 * Created by burt on 2016. 8. 7..
 */
public abstract class AndroidViewController extends FrameLayout {

    public AndroidViewController(Context context) {
        super(context);
        loadView(context);
    }

    public AndroidViewController(Context context, AttributeSet attrs) {
        super(context, attrs);
        loadView(context);
    }

    public AndroidViewController(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        loadView(context);
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public AndroidViewController(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        loadView(context);
    }

    protected void loadView(Context context) {
        LayoutInflater inflater = getLayoutInflater();
        inflater.inflate(getLayoutResourceId(), this);
    }

    @Override
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        viewDidAppear();
    }

    @Override
    protected void onDetachedFromWindow() {
        viewDidDisappear();
        super.onDetachedFromWindow();
    }



    protected void viewDidAppear() {
        Log.d("TAG", "viewDidAppear");
    }

    protected void viewDidDisappear() {
        Log.d("TAG", "viewDidDisappear");
    }

    protected abstract int getLayoutResourceId();

    protected LayoutInflater getLayoutInflater() {
        LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        return inflater;
    }
}