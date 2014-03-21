package com.don.budgetdemo;

import org.achartengine.GraphicalView;
import org.achartengine.chart.AbstractChart;
import org.achartengine.chart.PieChart;
import org.achartengine.model.CategorySeries;
import org.achartengine.model.SeriesSelection;
import org.achartengine.renderer.DefaultRenderer;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;

public class MainActivity extends Activity {
	private LinearLayout llContent;
	private GraphicalView mView;
	private AbstractChart mChart;

	double[] values;
	CategorySeries categorySeries;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		llContent = (LinearLayout) findViewById(R.id.ll_content);

		values = new double[] { 12, 14, 11, 10, 19 };
		int[] colors = new int[] { Color.BLUE, Color.GREEN, Color.MAGENTA,
				Color.YELLOW, Color.CYAN };
		String[] category = { "a", "b", "c", "d", "e" };
		String chartTitle = "我的图表标题";

		final DefaultRenderer renderer = ChartUtil.getDefaultRenderer(values,
				colors, category, chartTitle);
		renderer.setShowLabels(false);
		categorySeries = ChartUtil.getCategorySeries(values, category);
		mChart = new PieChart(categorySeries, renderer);
		mView = new GraphicalView(this, mChart);
		llContent.addView(mView);
		mView.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View view) {
				// TODO Auto-generated method stub
				// 获取当前点击的SeriesSelection
				SeriesSelection seriesSelection = mView
						.getCurrentSeriesAndPoint();
				if (seriesSelection != null) {
					int pointIndex = seriesSelection.getPointIndex();
					for (int i = 0; i < renderer.getSeriesRendererCount(); i++) {
						if (i == pointIndex) {
							if (renderer.getSeriesRendererAt(i).isHighlighted()) {
								renderer.getSeriesRendererAt(i).setHighlighted(
										false);
							} else {
								renderer.getSeriesRendererAt(i).setHighlighted(
										true);
							}
						} else {
							renderer.getSeriesRendererAt(i).setHighlighted(
									false);
						}
					}
					// 重画图表
					mView.repaint();
				}
			}
		});
	}

	/**
	 * 
	 * @param view
	 */
	public void btnTest(View view) {
		
		 int mYear=2014;
		 int mMonth=12;
		 int mDay=2;
		 final MyDateSetListener dateSetListener = new MyDateSetListener(mYear, mMonth, mDay);
	
		Dialog dialog = new DatePickerDialog(MainActivity.this, DatePickerDialog.THEME_HOLO_DARK, dateSetListener, mYear, mMonth, mDay);
		dialog.setOnCancelListener(new OnCancelListener() {
			
			@Override
			public void onCancel(DialogInterface dialog) {
				// TODO Auto-generated method stub
				Log.i("test", "mYear:");
				Log.i("test", "mMonth:");
				Log.i("test", "mDay:");
				Log.i("test", dateSetListener.toString());
				
			}
		});
		dialog.show();

	}

}
