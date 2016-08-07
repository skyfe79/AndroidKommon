package components.support;

import android.view.LayoutInflater;

import com.trello.rxlifecycle.components.support.RxAppCompatDialogFragment;

/**
 * Created by burt on 2016. 8. 7..
 */
public class AndroidAppCompatDialogFragment extends RxAppCompatDialogFragment {

    protected LayoutInflater getLayoutInflater() {
        return getActivity().getLayoutInflater();
    }

}
