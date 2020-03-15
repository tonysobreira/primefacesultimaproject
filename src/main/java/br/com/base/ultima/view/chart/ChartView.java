/*
 * Copyright 2009-2015 PrimeTek.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package br.com.base.ultima.view.chart;

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.annotation.PostConstruct;
//import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import org.omnifaces.cdi.ViewScoped;
import org.primefaces.model.chart.Axis;
import org.primefaces.model.chart.AxisType;
import org.primefaces.model.chart.BarChartModel;
import org.primefaces.model.chart.BarChartSeries;
import org.primefaces.model.chart.BubbleChartModel;
import org.primefaces.model.chart.BubbleChartSeries;
import org.primefaces.model.chart.CartesianChartModel;
import org.primefaces.model.chart.CategoryAxis;
import org.primefaces.model.chart.ChartSeries;
import org.primefaces.model.chart.DateAxis;
import org.primefaces.model.chart.DonutChartModel;
import org.primefaces.model.chart.LineChartModel;
import org.primefaces.model.chart.LineChartSeries;
import org.primefaces.model.chart.LinearAxis;
import org.primefaces.model.chart.PieChartModel;

@Named
@ViewScoped
//@SessionScoped
public class ChartView implements Serializable {
	private static final long serialVersionUID = 1L;

	private LineChartModel lineModel;
	private BarChartModel barModel;
	private LineChartModel areaModel;
	private BubbleChartModel bubbleModel;
	private LineChartModel zoomModel;
	private PieChartModel pieModel;
	private DonutChartModel donutModel;
	private CartesianChartModel combinedModel;
	private LineChartModel multiAxisModel;

	@PostConstruct
	public void init() {
		createLineModel();
		createBarModel();
		createAreaModel();
		createBubbleModel();
		createZoomModel();
		createPieModel();
		createDonutModel();
		createCombinedModel();
		createMultiAxisModel();
	}

	public LineChartModel getLineModel() {
		return lineModel;
	}

	public BarChartModel getBarModel() {
		return barModel;
	}

	public LineChartModel getAreaModel() {
		return areaModel;
	}

	public BubbleChartModel getBubbleModel() {
		return bubbleModel;
	}

	public LineChartModel getZoomModel() {
		return zoomModel;
	}

	public PieChartModel getPieModel() {
		return pieModel;
	}

	public DonutChartModel getDonutModel() {
		return donutModel;
	}

	public CartesianChartModel getCombinedModel() {
		return combinedModel;
	}

	public LineChartModel getMultiAxisModel() {
		return multiAxisModel;
	}

	private void createLineModel() {
		lineModel = initLinearModel();
		lineModel.setTitle("Linear Chart");
		lineModel.setLegendPosition("e");
		lineModel.setExtender("skinChart"); // 调用页面JavaScript函数
		lineModel.setAnimate(true);
		Axis yAxis = lineModel.getAxis(AxisType.Y);
		yAxis.setMin(0);
		yAxis.setMax(10);
		yAxis.setTickCount(6);
	}

	private LineChartModel initLinearModel() {
		LineChartModel model = new LineChartModel();

		LineChartSeries series1 = new LineChartSeries();
//        series1.setLabel("AUDI A3");
		series1.setLabel("Series 1");

		series1.set(1, 2);
		series1.set(2, 1);
		series1.set(3, 3);
		series1.set(4, 6);
		series1.set(5, 8);

		LineChartSeries series2 = new LineChartSeries();
//        series2.setLabel("BMW i8");
		series2.setLabel("Series 2");

		series2.set(1, 6);
		series2.set(2, 3);
		series2.set(3, 2);
		series2.set(4, 7);
		series2.set(5, 9);

//        LineChartSeries series3 = new LineChartSeries();
//        series3.setLabel("Mercedes A200");
//
//        series3.set(1, 4);
//        series3.set(2, 6);
//        series3.set(3, 9);
//        series3.set(4, 3);
//        series3.set(5, 2);
		model.addSeries(series1);
		model.addSeries(series2);
//        model.addSeries(series3);

		return model;
	}

	private BarChartModel initBarModel() {
		BarChartModel model = new BarChartModel();

		ChartSeries boys = new ChartSeries();
		boys.setLabel("Boys");
		boys.set("2004", 120);
		boys.set("2005", 100);
		boys.set("2006", 44);
		boys.set("2007", 150);
		boys.set("2008", 25);

		ChartSeries girls = new ChartSeries();
		girls.setLabel("Girls");
		girls.set("2004", 52);
		girls.set("2005", 60);
		girls.set("2006", 110);
		girls.set("2007", 135);
		girls.set("2008", 120);

		model.addSeries(boys);
		model.addSeries(girls);

		return model;
	}

	private void createBarModel() {
		barModel = initBarModel();

		barModel.setTitle("Bar Chart");
		barModel.setLegendPosition("ne");
		barModel.setExtender("skinBar"); // 调用页面JavaScript函数

		Axis xAxis = barModel.getAxis(AxisType.X);
		xAxis.setLabel("Gender");

		Axis yAxis = barModel.getAxis(AxisType.Y);
		yAxis.setLabel("Births");
		yAxis.setMin(0);
		yAxis.setMax(200);
	}

	private void createAreaModel() {
		areaModel = new LineChartModel();

		LineChartSeries boys = new LineChartSeries();
		boys.setFill(true);
		boys.setLabel("Boys");
		boys.set("2004", 120);
		boys.set("2005", 100);
		boys.set("2006", 44);
		boys.set("2007", 150);
		boys.set("2008", 25);

		LineChartSeries girls = new LineChartSeries();
		girls.setFill(true);
		girls.setLabel("Girls");
		girls.set("2004", 52);
		girls.set("2005", 60);
		girls.set("2006", 110);
		girls.set("2007", 90);
		girls.set("2008", 120);

		areaModel.addSeries(boys);
		areaModel.addSeries(girls);

		areaModel.setTitle("Area Chart");
		areaModel.setLegendPosition("ne");
		areaModel.setExtender("skinArea"); // 调用页面JavaScript函数
		areaModel.setStacked(true);
		areaModel.setShowPointLabels(true);

		Axis xAxis = new CategoryAxis("Years");
		areaModel.getAxes().put(AxisType.X, xAxis);
		Axis yAxis = areaModel.getAxis(AxisType.Y);
		yAxis.setLabel("Births");
		yAxis.setMin(0);
		yAxis.setMax(300);
	}

	private BubbleChartModel initBubbleModel() {
		BubbleChartModel model = new BubbleChartModel();

		model.add(new BubbleChartSeries("Acura", 70, 183, 55));
		model.add(new BubbleChartSeries("Alfa Romeo", 45, 92, 36));
		model.add(new BubbleChartSeries("AM General", 24, 104, 40));
		model.add(new BubbleChartSeries("Bugatti", 50, 123, 60));
		model.add(new BubbleChartSeries("BMW", 15, 89, 25));
		model.add(new BubbleChartSeries("Audi", 40, 180, 80));
		model.add(new BubbleChartSeries("Aston Martin", 70, 70, 48));

		return model;
	}

	private void createBubbleModel() {
		bubbleModel = initBubbleModel();
		bubbleModel.setTitle("Bubble Chart");
		bubbleModel.setExtender("skinBubble"); // 调用页面JavaScript函数
		bubbleModel.getAxis(AxisType.X).setLabel("Price");
		Axis yAxis = bubbleModel.getAxis(AxisType.Y);
		yAxis.setLabel("Labels");
		yAxis.setMin(0);
		yAxis.setMax(250);
	}

	private LineChartModel initZoomModel() {
		LineChartModel model = new LineChartModel();

		LineChartSeries series1 = new LineChartSeries();
		series1.setLabel("Series 1");

		series1.set("2014-01-01", 51);
		series1.set("2014-01-06", 22);
		series1.set("2014-01-12", 65);
		series1.set("2014-01-18", 74);
		series1.set("2014-01-24", 24);
		series1.set("2014-01-30", 51);

		LineChartSeries series2 = new LineChartSeries();
		series2.setLabel("Series 2");

		series2.set("2014-01-01", 32);
		series2.set("2014-01-06", 73);
		series2.set("2014-01-12", 24);
		series2.set("2014-01-18", 12);
		series2.set("2014-01-24", 74);
		series2.set("2014-01-30", 62);

		model.addSeries(series1);
		model.addSeries(series2);

		return model;
	}

	private void createZoomModel() {
		zoomModel = initZoomModel();

		zoomModel.setTitle("Zoom for Details");
		zoomModel.setZoom(true);
		// zoomModel.setLegendPosition("e");
		zoomModel.setExtender("skinZoom"); // 调用页面JavaScript函数
		zoomModel.getAxis(AxisType.Y).setLabel("Values");
		DateAxis axis = new DateAxis("Dates");
		axis.setTickAngle(-50);
		axis.setMax("2014-02-01");
		axis.setTickFormat("%b %#d, %y");

		zoomModel.getAxes().put(AxisType.X, axis);
	}

	private void createPieModel() {
		pieModel = new PieChartModel();

		pieModel.set("Brand 1", 540);
		pieModel.set("Brand 2", 325);
		pieModel.set("Brand 3", 702);
		pieModel.set("Brand 4", 421);

		pieModel.setTitle("Simple Pie");
		pieModel.setLegendPosition("w");
		pieModel.setExtender("skinPie"); // 调用页面JavaScript函数
	}

	private DonutChartModel initDonutModel() {
		DonutChartModel model = new DonutChartModel();

		Map<String, Number> circle1 = new LinkedHashMap<String, Number>();
		circle1.put("Brand 1", 150);
		circle1.put("Brand 2", 400);
		circle1.put("Brand 3", 200);
		circle1.put("Brand 4", 10);
		model.addCircle(circle1);

		Map<String, Number> circle2 = new LinkedHashMap<String, Number>();
		circle2.put("Brand 1", 540);
		circle2.put("Brand 2", 125);
		circle2.put("Brand 3", 702);
		circle2.put("Brand 4", 421);
		model.addCircle(circle2);

		Map<String, Number> circle3 = new LinkedHashMap<String, Number>();
		circle3.put("Brand 1", 40);
		circle3.put("Brand 2", 325);
		circle3.put("Brand 3", 402);
		circle3.put("Brand 4", 421);
		model.addCircle(circle3);

		return model;
	}

	private void createDonutModel() {
		donutModel = initDonutModel();
		donutModel.setTitle("Donut Chart");
		donutModel.setLegendPosition("w");
		donutModel.setExtender("skinDonut"); // 调用页面JavaScript函数
		donutModel.setDatatipFormat("%s - %d");
	}

	private void createCombinedModel() {
		combinedModel = new BarChartModel();

		BarChartSeries boys = new BarChartSeries();
		boys.setLabel("Boys");

		boys.set("2004", 120);
		boys.set("2005", 100);
		boys.set("2006", 44);
		boys.set("2007", 150);
		boys.set("2008", 25);

		LineChartSeries girls = new LineChartSeries();
		girls.setLabel("Girls");

		girls.set("2004", 52);
		girls.set("2005", 60);
		girls.set("2006", 110);
		girls.set("2007", 135);
		girls.set("2008", 120);

		combinedModel.addSeries(boys);
		combinedModel.addSeries(girls);

		combinedModel.setTitle("Bar and Line");
		combinedModel.setLegendPosition("ne");
		combinedModel.setExtender("skinBarAndLine"); // 调用页面JavaScript函数
		combinedModel.setMouseoverHighlight(false);
		combinedModel.setShowDatatip(false);
		combinedModel.setShowPointLabels(true);
		Axis yAxis = combinedModel.getAxis(AxisType.Y);
		yAxis.setMin(0);
		yAxis.setMax(200);
	}

	private void createMultiAxisModel() {
		multiAxisModel = new LineChartModel();

		BarChartSeries boys = new BarChartSeries();
		boys.setLabel("Boys");

		boys.set("2004", 120);
		boys.set("2005", 100);
		boys.set("2006", 44);
		boys.set("2007", 150);
		boys.set("2008", 25);

		LineChartSeries girls = new LineChartSeries();
		girls.setLabel("Girls");
		girls.setXaxis(AxisType.X2);
		girls.setYaxis(AxisType.Y2);

		girls.set("A", 52);
		girls.set("B", 60);
		girls.set("C", 110);
		girls.set("D", 135);
		girls.set("E", 120);

		multiAxisModel.addSeries(boys);
		multiAxisModel.addSeries(girls);

		multiAxisModel.setTitle("Multi Axis Chart");
		multiAxisModel.setMouseoverHighlight(false);
		multiAxisModel.setExtender("skinMultiAxis"); // 调用页面JavaScript函数

		multiAxisModel.getAxes().put(AxisType.X, new CategoryAxis("Years"));
		multiAxisModel.getAxes().put(AxisType.X2, new CategoryAxis("Period"));

		Axis yAxis = multiAxisModel.getAxis(AxisType.Y);
		yAxis.setLabel("Birth");
		yAxis.setMin(0);
		yAxis.setMax(200);

		Axis y2Axis = new LinearAxis("Number");
		y2Axis.setMin(0);
		y2Axis.setMax(200);

		multiAxisModel.getAxes().put(AxisType.Y2, y2Axis);
	}
}
