package codingbo.viewstudy;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.SeekBar;

import codingbo.viewstudy.myLayout.BricksLayout;
import codingbo.viewstudy.touchConflict.LayoutActivity;
import codingbo.viewstudy.touchConflict.ScrollActivity;
import codingbo.viewstudy.windowFloat.FloatService;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    private BricksLayout mBricksLayout;
    private SeekBar mSeekBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        float density = getResources().getDisplayMetrics().density;
        Log.d(TAG, "density: " + density);

        int dpi = getResources().getDisplayMetrics().densityDpi;
        Log.d(TAG, "dpi: " + dpi);

        float scaledDensity = getResources().getDisplayMetrics().scaledDensity;
        Log.d(TAG, "scaledDensity: " + scaledDensity);

        int heightPixels = getResources().getDisplayMetrics().heightPixels;
        Log.d(TAG, "heightPixels: " + heightPixels);
        int widthPixels = getResources().getDisplayMetrics().widthPixels;
        Log.d(TAG, "widthPixels: " + widthPixels);
        float xdpi = getResources().getDisplayMetrics().xdpi;
        Log.d(TAG, "xdpi: " + xdpi);
        float ydpi = getResources().getDisplayMetrics().ydpi;
        Log.d(TAG, "ydpi: " + ydpi);

        mSeekBar = findViewById(R.id.seekBar);
        mSeekBar.setMax(100);
        mSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                Log.d(TAG, "onProgressChanged: " + progress);
                
                mBricksLayout.setItemGap(progress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        mBricksLayout = findViewById(R.id.bricksLayout);

    }

    private void goActivity(Class aClass) {
        startActivity(new Intent(this, aClass));
    }

    public void thumb(View view) {
        goActivity(ThumbUpActivity.class);
    }

    public void view3d(View view) {
        goActivity(View3dActivity.class);
    }

    public void touch(View view) {
//        goActivity(LayoutActivity.class);
        goActivity(ScrollActivity.class);
    }

    public void floatView(View view) {
        goActivity(FloatViewActivity.class);
    }

    public void floatView2(View view) {

        Intent intent = new Intent(this, FloatContainerActivity.class);
        startActivity(intent);

    }

    public void showMore(View view) {
        goActivity(ShowMoreActivity.class);
    }
}
