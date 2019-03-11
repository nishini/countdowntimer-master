package lk.ac.kln.countdowntimer;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private int counter=99;
    private static final String CURRENT_COUNTER = "counter";
    private boolean wasRunning = false;
    private boolean running = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (savedInstanceState != null) {

        counter = savedInstanceState.getInt(CURRENT_COUNTER);
    }
        countDown();
    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState){
        super.onSaveInstanceState(savedInstanceState);
        savedInstanceState.putInt(CURRENT_COUNTER, counter);
    }
    private void countDown(){
        final TextView textView= findViewById(R.id.textView);
        final Handler handler = new Handler();
        handler.post(new Runnable() {
            @Override
            public void run() {
                if (counter == 0){
                    counter = 99;
                }

                textView.setText(Integer.toString(counter));
                counter --;
                handler.postDelayed(this,1000);
            }
        });

    }
    @Override
    public void onStop(){
        super.onStop();
        wasRunning = true;
    }
}
