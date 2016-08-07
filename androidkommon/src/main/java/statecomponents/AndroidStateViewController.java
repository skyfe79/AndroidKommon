package statecomponents;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;

import kr.pe.burt.android.lib.androidkommon.R;
import mehdi.sakout.dynamicbox.DynamicBox;

/**
 * Created by burt on 2016. 8. 7..
 */
public abstract class AndroidStateViewController extends FrameLayout {

    protected DynamicBox stateViewGroup = null;

    public AndroidStateViewController(Context context) {
        super(context);
        loadView(context);
    }

    public AndroidStateViewController(Context context, AttributeSet attrs) {
        super(context, attrs);
        loadView(context);
    }

    public AndroidStateViewController(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        loadView(context);
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public AndroidStateViewController(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
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
        setupStateViewGroup();
        viewDidAppear();
    }

    @Override
    protected void onDetachedFromWindow() {
        viewDidDisappear();
        super.onDetachedFromWindow();
    }


    private void setupStateViewGroup() {

        View sv = getStateViewGroup();
        if(sv == null) {
            stateViewGroup = new DynamicBox(getContext(), getLayoutResourceId());
        } else {
            stateViewGroup = new DynamicBox(getContext(), sv);
        }

        setupLoadingView();
        setupInternetConnectionErrorView();
        setupEmptyView();
    }


    protected void viewDidAppear() {
        Log.d("TAG", "viewDidAppear");
    }

    protected void viewDidDisappear() {
        Log.d("TAG", "viewDidDisappear");
    }

    protected abstract int getLayoutResourceId();

    protected abstract View getStateViewGroup();

    protected LayoutInflater getLayoutInflater() {
        LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        return inflater;
    }

    private void setupLoadingView() {
        View loadingView = getLayoutInflater().inflate(getLoadingViewLayoutId(), null, false);
        stateViewGroup.addCustomView(loadingView, "state_loading_view");
    }

    private void setupInternetConnectionErrorView() {
        View errorView = getLayoutInflater().inflate(getInternetConntectionErrorLayoutId(), null, false);
        stateViewGroup.addCustomView(errorView, "state_internet_connection_error_view");
    }

    private void setupEmptyView() {
        View errorView = getLayoutInflater().inflate(getEmptyViewLayoutId(), null, false);
        stateViewGroup.addCustomView(errorView, "state_empty_view");
    }

    protected int getLoadingViewLayoutId() {
        return R.layout.view_loading_layout;
    }

    protected int getInternetConntectionErrorLayoutId() {
        return R.layout.view_internet_connection_error_layout;
    }

    protected int getEmptyViewLayoutId() {
        return R.layout.view_empty_layout;
    }

    protected void showLoadingView() {
        if(stateViewGroup == null)
            return;
        stateViewGroup.showCustomView("state_loading_view");
    }

    protected void showInternetConnectionErrorView() {
        if(stateViewGroup == null)
            return;
        stateViewGroup.showCustomView("state_internet_connection_error_view");
    }

    protected void showEmptyView() {
        if(stateViewGroup == null)
            return;
        stateViewGroup.showCustomView("state_empty_view");
    }

    protected void showContentView() {
        if(stateViewGroup == null)
            return;
        stateViewGroup.hideAll();
    }
}
