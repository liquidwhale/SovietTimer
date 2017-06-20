package cloud.akadem.soviettimer;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity {
    private int intervals[] = {2,3, 4, 2};
    private TextView textView1;
    private TextView textView2;
    private TextView textView3;
    private TextView textView4;

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

        Button minusButton3 = (Button) findViewById(R.id.minusButton3);
        Button plusButton3 = (Button) findViewById(R.id.plusButton3);
        textView3 =  (TextView) findViewById(R.id.textView3);

        Button minusButton4 = (Button) findViewById(R.id.minusButton4);
        Button plusButton4 = (Button) findViewById(R.id.plusButton4);
        textView4 =  (TextView) findViewById(R.id.textView4);

        updateTimePeriodTextView(textView1, intervals[0]);
        updateTimePeriodTextView(textView2, intervals[1]);
        updateTimePeriodTextView(textView3, intervals[2]);
        updateTimePeriodTextView(textView4, intervals[3]);

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

        minusButton3.setOnClickListener(new View.OnClickListener() {
            public void onClick (View v1){
                intervals[2] = decreaseTimePeriod(textView3, intervals[2]);
            }
        });

        plusButton3.setOnClickListener(new View.OnClickListener() {
            public void onClick (View v1){
                intervals[2] = increaseTimePeriod(textView3, intervals[2]);
            }
        });

        minusButton4.setOnClickListener(new View.OnClickListener() {
            public void onClick (View v1){
                intervals[3] = decreaseTimePeriod(textView4, intervals[3]);
            }
        });

        plusButton4.setOnClickListener(new View.OnClickListener() {
            public void onClick (View v1){
                intervals[3] = increaseTimePeriod(textView4, intervals[3]);
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
