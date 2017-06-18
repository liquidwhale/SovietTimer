package cloud.akadem.soviettimer;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity {
    public static final String EXTRA_TIME_PERIOD = "cloud.akadem.soviettimer.EXTRA_TIME_PERIOD";
    private int timePeriod1 = 10;
    private int timePeriod2 = 10;
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
        updateTimePeriodTextView(textView1, timePeriod1);
        updateTimePeriodTextView(textView2, timePeriod2);
        minusButton1.setOnClickListener(new View.OnClickListener() {
            public void onClick (View v1){
                decreaseTimePeriod(textView1, Integer.parseInt(textView1.getText().toString()));
            }
        });
        plusButton1.setOnClickListener(new View.OnClickListener() {
            public void onClick (View v1){
                increaseTimePeriod(textView1, Integer.parseInt(textView1.getText().toString()));
            }
        });
        minusButton2.setOnClickListener(new View.OnClickListener() {
            public void onClick (View v1){
                decreaseTimePeriod(textView2, Integer.parseInt(textView2.getText().toString()));
            }
        });
        plusButton2.setOnClickListener(new View.OnClickListener() {
            public void onClick (View v1){
                increaseTimePeriod(textView2, Integer.parseInt(textView2.getText().toString()));
            }
        });
    }

    public void startTimer(View view) {
        Intent intent = new Intent(this, TimerActivity.class);
        //intent.putExtra(EXTRA_TIME_PERIOD, Integer.toString(timePeriod));
        array[0] = timePeriod1;
        array[1] = timePeriod2;
        intent.putExtra("numbers", array);
        startActivity(intent);
    }

    public void increaseTimePeriod(View view, int k) {
        k++;
        updateTimePeriodTextView(view, k);
    }

    public void decreaseTimePeriod(View view, int k) {
        k--;
        updateTimePeriodTextView(view, k);
    }

    private void updateTimePeriodTextView(View view, int k) {
        TextView textView = (TextView) view;
        textView.setText(Integer.toString(k));
    }


}
