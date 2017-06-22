package cloud.akadem.soviettimer;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.widget.TextView;

public class TimerActivity extends Activity {
    CountDownTimer timer;
    TextView countDownTextView;
    String state = "prepairing";
    int values[];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timer);

        countDownTextView = (TextView) findViewById(R.id.textView2);

        // Get the Intent that started this activity and extract the string
        Intent intent = getIntent();
        values = intent.getIntArrayExtra("values");
    }

    @Override
    protected void onStart() {
        super.onStart();
        handlePeriod();
    }

    public void handlePeriod() {
        int time = 0;

        switch (state) {
            case "prepairing":
                time = values[0];
                state = "work";
                break;
            case "work":
                time = values[1];
                state = "rest";
                break;
            case "rest":
                time = values[2];
                state = "work";
                values[3]--;
                break;
        }

        countDownTextView.setText(Integer.toString(time));

        timer = new CountDownTimer(time * 1000 + 100, 1000) {
                @Override
                public void onTick(long millisUntilFinished) {
                    int n = (int) millisUntilFinished;
                    countDownTextView.setText("" + n / 1000);
                }

                @Override
                public void onFinish() {
                    if (values[3] != 0) {
                        handlePeriod();
                    } else {
                        countDownTextView.setText("Done");
                    }
                }
            };

        timer.start();
    }
}
