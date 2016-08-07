package statecomponents;

import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import components.AndroidActivity;
import kr.pe.burt.android.lib.androidkommon.R;
import mehdi.sakout.dynamicbox.DynamicBox;

/**
 * Created by burt on 2016. 8. 7..
 */
public abstract class AndroidStateActivity extends AndroidActivity {

    protected DynamicBox stateViewGroup = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        onBeforeMakeRootView();
        setContentView(getLayoutResourceId());

    }

    @Override
    protected void onStart() {
        super.onStart();
        setupStateViewGroup();
    }

    /**
     * Return activity's layout file id
     */
    protected abstract int getLayoutResourceId();

    protected void onBeforeMakeRootView() {}

    /**
     * Return id of the state viewgroup which can be changed content dynamicallyreturn
     * if return -1, root view group will be the state view group
     */
    protected View getStateViewGroup() {
        return null;
    }

    private void setupStateViewGroup() {

        View sv = getStateViewGroup();
        if(getStateViewGroup() == null) {
            stateViewGroup = new DynamicBox(this, getLayoutResourceId());
        } else {
            stateViewGroup = new DynamicBox(this, sv);
        }

        setupLoadingView();
        setupInternetConnectionErrorView();
        setupEmptyView();
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
