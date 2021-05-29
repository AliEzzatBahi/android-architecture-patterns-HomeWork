package com.alyndroid.architecturepatternstutorialshomework.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.alyndroid.architecturepatternstutorialshomework.R;
import com.alyndroid.architecturepatternstutorialshomework.data.DataBase;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, NumberView {

    Button plusBtn, divBtn, mulBtn;
    TextView plusResultTV, divResultTV, mulResultTV;
    DataBase db;
    NumberPresenter numberPresenter;
    NumberViewModel numberViewModel;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        db = new DataBase();
        numberViewModel = ViewModelProviders.of(this).get(NumberViewModel.class);
        numberViewModel.mulResultMutableLiveData.observe(this, new Observer<Integer>() {
            @Override
            public void onChanged(Integer integer) {
                mulResultTV.setText(integer + "");
            }
        });

        plusResultTV = findViewById(R.id.plus_result_textView);
        divResultTV = findViewById(R.id.div_result_textView);
        mulResultTV = findViewById(R.id.mul_result_textView);

        plusBtn = findViewById(R.id.plus_button);
        divBtn = findViewById(R.id.div_button);
        mulBtn = findViewById(R.id.mul_button);

        plusBtn.setOnClickListener(this);
        divBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numberPresenter.getNumberDivision();
            }
        });
        numberPresenter = new NumberPresenter(this);

        mulBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numberViewModel.getMulResult();
            }
        });
    }

    public int getSumNumbersFromDB() {
        return db.getNumbers().getFirstNum() + db.getNumbers().getSecondNum();
    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.plus_button){
            plusResultTV.setText(getSumNumbersFromDB() + "");
        }
    }

    @Override
    public void onGetNumberDivision(int divResult) {
        divResultTV.setText(divResult + "");
    }
}
