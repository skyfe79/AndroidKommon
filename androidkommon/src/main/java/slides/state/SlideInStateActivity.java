package slides.state;

import android.os.Bundle;

import kr.pe.burt.android.lib.androidkommon.R;
import statecomponents.AndroidStateActivity;

/**
 * Created by burt on 2016. 8. 7..
 */
public abstract class SlideInStateActivity extends AndroidStateActivity {

    @Override
    protected void onBeforeMakeRootView() {
        overridePendingTransition(R.anim.start_slide_in_enter, R.anim.start_slide_in_exit);
    }

    @Override
    public void finish() {
        super.finish();
        overridePendingTransition(R.anim.end_slide_in_enter, R.anim.end_slide_in_exit);
    }


}
