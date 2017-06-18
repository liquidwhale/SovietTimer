package cloud.akadem.soviettimer;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.widget.TextView;

public class TimerActivity extends Activity {
    CountDownTimer timer;
    TextView countDownTextView;
//    String[] timePeriods = new String[] {"8", "5"};
    int timePeriods[];
    int periodCount = 0;
    int maxPeriodCount = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timer);

        countDownTextView = (TextView) findViewById(R.id.textView2);

        // Get the Intent that started this activity and extract the string
        Intent intent = getIntent();
        timePeriods = intent.getIntArrayExtra("numbers");
        maxPeriodCount = timePeriods.length;
    }

    @Override
    protected void onStart() {
        super.onStart();

        handlePeriod(timePeriods[periodCount]);
    }

    public void handlePeriod(int timePeriod) {
        countDownTextView.setText(Integer.toString(timePeriod));

        timer = new CountDownTimer(timePeriod * 1000 + 100, 1000) {
                @Override
                public void onTick(long millisUntilFinished) {
                    int n = (int) millisUntilFinished;
                    countDownTextView.setText("" + n/1000);
                }

                @Override
                public void onFinish() {
                    countDownTextView.setText("Done");
                    periodCount++;
                    if (periodCount < maxPeriodCount) {
                        handlePeriod(timePeriods[periodCount]);
                    }
                }
            };

        timer.start();
    }
}
