package slides.support;

import android.os.Bundle;

import components.support.AndroidAppCompatActivity;
import kr.pe.burt.android.lib.androidkommon.R;

/**
 * Created by burt on 2016. 8. 7..
 */
public class SlideUpAppCompatActivity extends AndroidAppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        overridePendingTransition(R.anim.start_slide_up_enter, R.anim.start_slide_up_exit);
    }

    @Override
    public void finish() {
        super.finish();
        overridePendingTransition(R.anim.end_slide_up_enter, R.anim.end_slide_up_exit);
    }
}
