package com.example.adam.myapplication;

import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import butterknife.BindColor;
import butterknife.BindString;
import butterknife.BindView;
import butterknife.BindViews;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {


    //Views

    @BindView(R.id.textView1) TextView text1;
    @BindView(R.id.textView2) TextView text2;
    @BindView(R.id.textView3) TextView text3;
    @BindView(R.id.textView4) TextView text4;
    @BindView(R.id.textView5) TextView text5;
    @BindView(R.id.textView6) TextView text6;
    @BindView(R.id.textView7) TextView text7;

    @BindViews({R.id.textView5,R.id.textView6}) List<TextView> textViews;

    @BindView(R.id.button1) Button button1;
    @BindView(R.id.button2) Button button2;
    @BindView(R.id.button3) Button button3;
    @BindView(R.id.button4) Button button4;

    @BindView(R.id.spinner) Spinner spinner1;
    @BindViews({R.id.progressBar1, R.id.progressBar2})
    List<ProgressBar> progressBars;

    @BindColor(R.color.redColor) int redColor;
    @BindColor(R.color.yellowColor) int yellowColor;

    @BindString(R.string.example_string1) String string1;
    @BindString(R.string.example_string2) String string2;



    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        button1.setTextColor(redColor);
        //Apply Setter
        ButterKnife.apply(text2, ENABLED,false);

    }

    //Action
    static final ButterKnife.Action<TextView> SETTEXT = new ButterKnife.Action<TextView>() {
        @Override
        public void apply(@NonNull TextView view, int index) {
            view.setText("ACTION");
        }
    };

    //SETTER
    static final ButterKnife.Setter<TextView, Boolean> ENABLED = new ButterKnife.Setter<TextView, Boolean>() {
        @Override
        public void set(@NonNull TextView view, Boolean value, int index) {
            view.setEnabled(value);
        }
    };

    //Listener Binding
    @OnClick(R.id.button1)
    public void click(Button button)
    {
        Toast.makeText(this,"button clicked",Toast.LENGTH_SHORT).show();
        button.setText(string2);
    }

    @OnClick({R.id.button2,R.id.button3})
    public void progressBarClick()
    {
        progressBars.get(0).setBackgroundColor(yellowColor);
        progressBars.get(1).setBackgroundColor(redColor);
        Toast.makeText(this,"button clicked 2",Toast.LENGTH_SHORT).show();
    }

    //Listener to apply Action
    @OnClick(R.id.button4)
    public void clickToApply()
    {
        ButterKnife.apply(textViews,SETTEXT);
    }



}
