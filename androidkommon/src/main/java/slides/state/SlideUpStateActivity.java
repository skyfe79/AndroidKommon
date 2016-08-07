package slides.state;

import kr.pe.burt.android.lib.androidkommon.R;
import statecomponents.AndroidStateActivity;

/**
 * Created by burt on 2016. 8. 7..
 */
public abstract class SlideUpStateActivity extends AndroidStateActivity {

    @Override
    protected void onBeforeMakeRootView() {
        overridePendingTransition(R.anim.start_slide_up_enter, R.anim.start_slide_up_exit);
    }

    @Override
    public void finish() {
        super.finish();
        overridePendingTransition(R.anim.end_slide_up_enter, R.anim.end_slide_up_exit);
    }
}
