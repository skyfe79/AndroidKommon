package components;

import android.view.LayoutInflater;

import com.trello.rxlifecycle.components.RxFragment;

/**
 * Created by burt on 2016. 8. 7..
 */
public class AndroidFragment extends RxFragment {

    protected LayoutInflater getLayoutInflater() {
        return getActivity().getLayoutInflater();
    }

}
