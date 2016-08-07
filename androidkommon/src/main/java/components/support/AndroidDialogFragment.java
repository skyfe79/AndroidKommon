package components.support;

import android.view.LayoutInflater;

import com.trello.rxlifecycle.components.support.RxDialogFragment;

/**
 * Created by burt on 2016. 8. 7..
 */
public class AndroidDialogFragment extends RxDialogFragment {

    protected LayoutInflater getLayoutInflater() {
        return getActivity().getLayoutInflater();
    }

}
