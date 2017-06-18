package cloud.akadem.soviettimer;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity {
    public static final String EXTRA_TIME_PERIOD = "cloud.akadem.soviettimer.EXTRA_TIME_PERIOD";
    private int array[] = {10,10};
//    private View v1 = findViewById(R.id.textView1);
//    private View v2 = findViewById(R.id.textView2);
    Button minusButton1;
    Button plusButton1;// = (Button) findViewById(R.id.plusButton1);
    private TextView textView1;// =  (TextView) findViewById(R.id.textView1);
    Button minusButton2;// = (Button) findViewById(R.id.minusButton2);
    Button plusButton2;// = (Button) findViewById(R.id.plusButton2);
    private TextView textView2;// =  (TextView) findViewById(R.id.textView2);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        minusButton1 = (Button) findViewById(R.id.minusButton1);
        plusButton1 = (Button) findViewById(R.id.plusButton1);
        final TextView textView1 =  (TextView) findViewById(R.id.textView1);
        minusButton2 = (Button) findViewById(R.id.minusButton2);
        plusButton2 = (Button) findViewById(R.id.plusButton2);
        final TextView textView2 =  (TextView) findViewById(R.id.textView2);
        updateTimePeriodTextView(textView1, array[0]);
        updateTimePeriodTextView(textView2, array[1]);
        minusButton1.setOnClickListener(new View.OnClickListener() {
            public void onClick (View v1){
                array[0] = decreaseTimePeriod(textView1, array[0]);
            }
        });
        plusButton1.setOnClickListener(new View.OnClickListener() {
            public void onClick (View v1){
                array[0] = increaseTimePeriod(textView1, array[0]);
            }
        });
        minusButton2.setOnClickListener(new View.OnClickListener() {
            public void onClick (View v1){
                array[1] = decreaseTimePeriod(textView2, array[1]);
            }
        });
        plusButton2.setOnClickListener(new View.OnClickListener() {
            public void onClick (View v1){
                array[1] = increaseTimePeriod(textView2, array[1]);
            }
        });
    }

    public void startTimer(View view) {
        Intent intent = new Intent(this, TimerActivity.class);
        //intent.putExtra(EXTRA_TIME_PERIOD, Integer.toString(timePeriod));
        intent.putExtra("numbers", array);
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
