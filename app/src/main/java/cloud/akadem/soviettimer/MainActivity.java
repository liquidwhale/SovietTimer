package cloud.akadem.soviettimer;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity {
    private int intervals[] = {10,10};
    private TextView textView1;
    private TextView textView2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button minusButton1 = (Button) findViewById(R.id.minusButton1);
        Button plusButton1 = (Button) findViewById(R.id.plusButton1);
        textView1 =  (TextView) findViewById(R.id.textView1);

        Button minusButton2 = (Button) findViewById(R.id.minusButton2);
        Button plusButton2 = (Button) findViewById(R.id.plusButton2);
        textView2 =  (TextView) findViewById(R.id.textView2);

        updateTimePeriodTextView(textView1, intervals[0]);
        updateTimePeriodTextView(textView2, intervals[1]);

        minusButton1.setOnClickListener(new View.OnClickListener() {
            public void onClick (View v1){
                intervals[0] = decreaseTimePeriod(textView1, intervals[0]);
            }
        });

        plusButton1.setOnClickListener(new View.OnClickListener() {
            public void onClick (View v1){
                intervals[0] = increaseTimePeriod(textView1, intervals[0]);
            }
        });

        minusButton2.setOnClickListener(new View.OnClickListener() {
            public void onClick (View v1){
                intervals[1] = decreaseTimePeriod(textView2, intervals[1]);
            }
        });

        plusButton2.setOnClickListener(new View.OnClickListener() {
            public void onClick (View v1){
                intervals[1] = increaseTimePeriod(textView2, intervals[1]);
            }
        });
    }

    public void startTimer(View view) {
        Intent intent = new Intent(this, TimerActivity.class);
        intent.putExtra("intervals", intervals);
        startActivity(intent);
    }

    public int increaseTimePeriod(View view, int k) {
        k++;
        updateTimePeriodTextView(view, k);
        return k;
    }

    public int decreaseTimePeriod(View view, int k) {
        k--;
        updateTimePeriodTextView(view, k);
        return k;
    }

    private void updateTimePeriodTextView(View view, int k) {
        TextView textView = (TextView) view;
        textView.setText(Integer.toString(k));
    }
}
