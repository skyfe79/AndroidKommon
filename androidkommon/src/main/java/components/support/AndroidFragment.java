package components.support;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.trello.rxlifecycle.components.support.RxFragment;

/**
 * Created by burt on 2016. 8. 7..
 */
public abstract class AndroidFragment extends RxFragment {

    protected View contentView = null;

    protected LayoutInflater getLayoutInflater() {
        return getActivity().getLayoutInflater();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        contentView = onCreateContentView(inflater, container, savedInstanceState);
        return contentView;
    }

    protected abstract View onCreateContentView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState);
}
