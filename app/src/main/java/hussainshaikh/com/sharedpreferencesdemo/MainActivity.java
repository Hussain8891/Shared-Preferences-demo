package hussainshaikh.com.sharedpreferencesdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView textView;

    private int counter = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = (TextView) findViewById(R.id.text_display);
        Loaddatd();
    }

    public void BtnClick(View view) {
        counter++;
        textView.setText(String.valueOf(counter));

    }
    //SharedPreferences for Saving data in phone Android
    public void Savedata(){
        SharedPreferences sharedPreferences = getSharedPreferences("saveData",MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt("dataValu",counter);
        editor.apply();


    }
    public void Loaddatd(){
        SharedPreferences sharedPreferences = getSharedPreferences("saveData",MODE_PRIVATE);
        counter = sharedPreferences.getInt("dataValu",MODE_PRIVATE);
        textView.setText(String.valueOf(counter));
    }

    @Override
    protected void onPause() {
        super.onPause();
        Savedata();
    }

    public void BtnClickLossdata(View view) {
        counter--;
        textView.setText(String.valueOf(counter));

    }
}