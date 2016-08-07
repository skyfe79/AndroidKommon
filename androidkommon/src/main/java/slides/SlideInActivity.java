package slides;

import android.os.Bundle;

import components.AndroidActivity;
import kr.pe.burt.android.lib.androidkommon.R;

/**
 * Created by burt on 2016. 8. 7..
 */
public class SlideInActivity extends AndroidActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        overridePendingTransition(R.anim.start_slide_in_enter, R.anim.start_slide_in_exit);
    }

    @Override
    public void finish() {
        super.finish();
        overridePendingTransition(R.anim.end_slide_in_enter, R.anim.end_slide_in_exit);
    }
}
