package com.alyndroid.architecturepatternstutorialshomework.ui;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.alyndroid.architecturepatternstutorialshomework.data.DataBase;

public class NumberViewModel extends ViewModel {

    MutableLiveData<Integer> mulResultMutableLiveData = new MutableLiveData<>();

    public void getMulResult(){
        int mulResult = getDivisionNumbersFromDB();
        mulResultMutableLiveData.setValue(mulResult);
    }

    public int getDivisionNumbersFromDB() {
        DataBase db = new DataBase();
        return db.getNumbers().getFirstNum() * db.getNumbers().getSecondNum();
    }
}
