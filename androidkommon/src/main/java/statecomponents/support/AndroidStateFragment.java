package statecomponents.support;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import components.support.AndroidFragment;
import kr.pe.burt.android.lib.androidkommon.R;
import mehdi.sakout.dynamicbox.DynamicBox;

/**
 * Created by burt on 2016. 8. 7..
 */
public abstract class AndroidStateFragment extends AndroidFragment {

    protected DynamicBox stateViewGroup = null;

    @Override
    protected View onCreateContentView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(getLayoutResourceId(), container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setupStateViewGroup();
    }


    /**
     * Return activity's layout file id
     */
    protected abstract int getLayoutResourceId();

    /**
     * Return id of the state viewgroup which can be changed content dynamicallyreturn
     * if return -1, root view group will be the state view group
     */
    protected View getStateViewGroup() {
        return null;
    }

    private void setupStateViewGroup() {

        View sv = getStateViewGroup();
        if(sv == null) {
            stateViewGroup = new DynamicBox(getActivity(), getLayoutResourceId());
        } else {
            stateViewGroup = new DynamicBox(getActivity(), sv);
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
