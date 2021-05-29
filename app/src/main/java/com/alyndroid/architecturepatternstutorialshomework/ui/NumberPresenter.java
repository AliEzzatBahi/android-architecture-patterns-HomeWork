package com.alyndroid.architecturepatternstutorialshomework.ui;

import com.alyndroid.architecturepatternstutorialshomework.data.DataBase;

public class NumberPresenter {
    NumberView view;
    DataBase db;

    public NumberPresenter(NumberView view) {
        this.view = view;
    }

    public int getDivisionNumbersFromDB() {
        db = new DataBase();
        return db.getNumbers().getFirstNum() / db.getNumbers().getSecondNum();
    }

    public void getNumberDivision(){
        view.onGetNumberDivision(getDivisionNumbersFromDB());
    }
}
