package in.shadowfax.proswipebutton_app;

import android.os.Bundle;
import android.os.Handler;
//import android.support.v7.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatActivity;

import in.shadowfax.proswipebutton.ProSwipeButton;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final ProSwipeButton proSwipeBtn = findViewById(R.id.proswipebutton_main);
        final ProSwipeButton proSwipeBtnError = findViewById(R.id.proswipebutton_main_error);
        proSwipeBtn.setSwipeDistance(0.5f);

        proSwipeBtn.setOnSwipeListener(new ProSwipeButton.OnSwipeListener() {
            @Override
            public void onSwipeConfirm() {
                // user has swiped the btn. Perform your async operation now
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        proSwipeBtn.showResultIcon(true, false);
                    }
                }, 2000);
            }
        });

        proSwipeBtnError.setOnSwipeListener(new ProSwipeButton.OnSwipeListener() {
            @Override
            public void onSwipeConfirm() {
                // user has swiped the btn. Perform your async operation now
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        proSwipeBtnError.showResultIcon(false, true);
                    }
                }, 2000);
            }
        });
    }
}
