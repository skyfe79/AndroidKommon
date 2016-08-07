package statecomponents.support;

import android.os.Bundle;
import android.view.View;

import components.support.AndroidAppCompatActivity;
import kr.pe.burt.android.lib.androidkommon.R;
import mehdi.sakout.dynamicbox.DynamicBox;

/**
 * Created by burt on 2016. 8. 7..
 */
public abstract class AndroidStateAppCompatActivity extends AndroidAppCompatActivity {

    protected DynamicBox stateViewGroup = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        onBeforeMakeRootView();
        setContentView(getLayoutResourceId());
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
    protected int getStateViewGroupId() {
        return -1;
    }

    private void setupStateViewGroup() {

        int stateViewGroupId = getStateViewGroupId();

        if(stateViewGroupId == -1) {
            stateViewGroup = new DynamicBox(this, getLayoutResourceId());
        } else {
            stateViewGroup = new DynamicBox(this, stateViewGroupId);
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
        stateViewGroup.showCustomView("state_internet_connection_error_view");
    }

    protected void showContentView() {
        if(stateViewGroup == null)
            return;
        stateViewGroup.hideAll();
    }
}
