package top.codingbo.instagramstudy;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.bilibili.boxing.Boxing;
import com.bilibili.boxing.model.config.BoxingConfig;

import top.codingbo.instagramstudy.photo.picker.PhotoPicker3Activity;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void openPicker(View view) {
//        startActivity(new Intent(this, PhotoPickerActivity.class));

        BoxingConfig config =
                // Mode：Mode.SINGLE_IMG, Mode.MULTI_IMG, Mode.VIDEO
                new BoxingConfig(BoxingConfig.Mode.SINGLE_IMG)
//                .needCamera(cameraRes)
                        .needGif()
                        // 支持gif，相机，设置最大选图数
                        .withMaxCount(9);
//        // 启动缩略图界面, 依赖boxing-impl.
//        Boxing.of(config).withIntent(this, BoxingActivity.class).start(this);

        Boxing.of(config).withIntent(this, PhotoPicker3Activity.class).start(this);
    }
}
