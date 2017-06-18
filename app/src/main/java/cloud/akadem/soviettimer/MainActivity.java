package cloud.akadem.soviettimer;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends Activity {
    public static final String EXTRA_TIME_PERIOD = "cloud.akadem.soviettimer.EXTRA_TIME_PERIOD";
    private int timePeriod = 10;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        updateTimePeriodTextView();
    }

    public void startTimer(View view) {
        Intent intent = new Intent(this, TimerActivity.class);
        intent.putExtra(EXTRA_TIME_PERIOD, Integer.toString(timePeriod));
        startActivity(intent);
    }

    public void increaseTimePeriod(View view) {
        timePeriod++;
        updateTimePeriodTextView();
    }

    public void decreaseTimePeriod(View view) {
        timePeriod--;
        updateTimePeriodTextView();
    }

    private void updateTimePeriodTextView() {
        TextView textView = (TextView) findViewById(R.id.textView);
        textView.setText(Integer.toString(timePeriod));
    }
}
