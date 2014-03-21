package com.don.budgetdemo;

import java.text.NumberFormat;

import org.achartengine.model.CategorySeries;
import org.achartengine.renderer.DefaultRenderer;
import org.achartengine.renderer.SimpleSeriesRenderer;

/**
 * 图表工具集
 * @author  donchan
 *
 */
public class ChartUtil {

	/**
	 * 获取饼图Renderer,颜色、数值、名称 的数组长度需一致
	 * @param values 各饼块 数值
	 * @param colors 各饼块 颜色
	 * @param category 各饼块 名称
	 * @param chartTitle 饼图标题
	 * @return
	 */
	public static DefaultRenderer getDefaultRenderer(double[] values,int[] colors,String[] category,String chartTitle){
		DefaultRenderer renderer = new DefaultRenderer();
	    //设置字体大小、格式
	    renderer.setLabelsTextSize(15);
	    renderer.setLegendTextSize(15);
	    renderer.setMargins(new int[] { 20, 30, 15, 0 });
	    //设置饼块颜色
	    for (int color : colors) {
	      SimpleSeriesRenderer r = new SimpleSeriesRenderer();
	      r.setColor(color);
	      r.setHighlighted(false);
//	      r.setChartValuesFormat(NumberFormat.getPercentInstance());
	      renderer.addSeriesRenderer(r);
	    }
	    //图表放大按钮
	    renderer.setZoomButtonsVisible(false);
	    //设置放大功能
	    renderer.setZoomEnabled(false);
	    //设置图表标题
	    if (chartTitle != null && !chartTitle.equals("")) {
	    	renderer.setChartTitle(chartTitle);
	 	    renderer.setChartTitleTextSize(40);
		}
	    //显示数值
	    renderer.setDisplayValues(true);
	    //是否显示各饼块标题
	    renderer.setShowLabels(true);
	    //饼块是否可点击
	    renderer.setClickEnabled(true);
	    return renderer;
	}
	
	/**
	 * 获取饼图Renderer,数值、名称 的数组长度需一致
	 * @param values 各饼块 数值
	 * @param category 各饼块 名称
	 * @return
	 */
	public static CategorySeries getCategorySeries(double[] values,String[] category){
		 //设置各饼块标题，数值
	    CategorySeries series = new CategorySeries("");
	    for (int i = 0; i < values.length; i++) {
	    	series.add(category[i], values[i]);
		}
	    return series;
	}
	
}
