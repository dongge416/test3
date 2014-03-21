package com.don.budgetdemo;

import android.app.DatePickerDialog.OnDateSetListener;
import android.widget.DatePicker;
import android.widget.EditText;

public class MyDateSetListener implements OnDateSetListener{
	private int intYear;
	private int intMon;
	private int intDay;
	
	public MyDateSetListener(int etYear, int etMon, int etDay) {
		super();
		this.intYear = etYear;
		this.intMon = etMon;
		this.intDay = etDay;
	}

	@Override
	public void onDateSet(DatePicker arg0, int year, int mon, int day) {
		// TODO Auto-generated method stub
		intYear=year;
		intMon=mon;
		intDay=day;
	}

	@Override
	public String toString() {
		return "MyDateSetListener [intYear=" + intYear + ", intMon=" + intMon
				+ ", intDay=" + intDay + "]";
	}
}
