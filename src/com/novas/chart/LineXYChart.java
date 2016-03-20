package com.novas.chart;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartRenderingInfo;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.DateAxis;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.entity.StandardEntityCollection;
import org.jfree.chart.labels.StandardXYToolTipGenerator;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYItemRenderer;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.chart.servlet.ServletUtilities;
import org.jfree.chart.title.LegendTitle;
import org.jfree.chart.title.TextTitle;
import org.jfree.data.time.Day;
import org.jfree.data.time.TimeSeries;
import org.jfree.data.time.TimeSeriesCollection;
import org.jfree.data.xy.XYDataset;
import org.jfree.ui.RectangleInsets;

import javax.servlet.http.HttpSession;
import java.awt.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;

public class LineXYChart
{
    /**
     * ��������ͼƬ���ļ���
     * @param session
     * @param pw
     * @return ����ͼƬ���ļ���
     */
    public String getLineXYChart(HttpSession session, PrintWriter pw)
    {
        XYDataset dataset = this.createDateSet();//�������ݼ�
        String fileName = null;
//����JFreeChart 
        JFreeChart chart = ChartFactory.createTimeSeriesChart(
                "JFreeChartʱ����������ͼ", // title
                "Date", // x-axis label
                "Price", // y-axis label
                dataset, // data
                true, // create legend?
                true, // generate tooltips?
                false // generate URLs?
        );
//����JFreeChart����ʾ����,��ͼ���ⲿ���ֽ��е��� 
        chart.setBackgroundPaint(Color.red);//��������ͼ����ɫ
//���������С����״ 
        Font font = new Font("����", Font.BOLD, 16);
        TextTitle title = new TextTitle("JFreeChartʱ����������ͼ", font);
        chart.setTitle(title);
//������ 
        TextTitle subtitle =
                new TextTitle("������", new Font("����", Font.BOLD, 12));
        chart.addSubtitle(subtitle);
        chart.setTitle(title); //����

//����ͼʾ�����ַ� 
//TimeSeries s1 = new TimeSeries("��ʷ����", Day.class);�������ַ� 
        LegendTitle legengTitle = chart.getLegend();
        legengTitle.setItemFont(font);

        XYPlot plot = (XYPlot) chart.getPlot();//��ȡͼ�εĻ���
        plot.setBackgroundPaint(Color.lightGray);//�������񱳾�ɫ
        plot.setDomainGridlinePaint(Color.green);//������������(Domain��)��ɫ
        plot.setRangeGridlinePaint(Color.white);//�������������ɫ
        plot.setAxisOffset(new RectangleInsets(5.0, 5.0, 5.0, 5.0));//��������ͼ��xy��ľ���
        plot.setDomainCrosshairVisible(true);
        plot.setRangeCrosshairVisible(true);
        XYItemRenderer r = plot.getRenderer();
        if (r instanceof XYLineAndShapeRenderer)
        {
            XYLineAndShapeRenderer renderer = (XYLineAndShapeRenderer) r;
            renderer.setBaseShapesVisible(true);
            renderer.setBaseShapesFilled(true);
            renderer.setShapesVisible(true);//���������Ƿ���ʾ���ݵ�
        }
//����Y�� 
        NumberAxis numAxis = (NumberAxis) plot.getRangeAxis();
        NumberFormat numFormater = NumberFormat.getNumberInstance();
        numFormater.setMinimumFractionDigits(2);
        numAxis.setNumberFormatOverride(numFormater);
//������ʾ��Ϣ 
        StandardXYToolTipGenerator tipGenerator = new StandardXYToolTipGenerator(
                "��ʷ��Ϣ{1} 16:00,{2})", new SimpleDateFormat("MM-dd"),numFormater);
        r.setToolTipGenerator(tipGenerator);
//����X�ᣨ�����ᣩ 
        DateAxis axis = (DateAxis) plot.getDomainAxis();
        axis.setDateFormatOverride(new SimpleDateFormat("MM-dd"));
        ChartRenderingInfo info = new ChartRenderingInfo(
                new StandardEntityCollection());
        try
        {
            fileName = ServletUtilities.saveChartAsPNG(chart, 500, 300, info,
                    session);//����ͼƬ
// Write the image map to the PrintWriter 
            ChartUtilities.writeImageMap(pw, fileName, info, false);
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        pw.flush();
        return fileName;//��������ͼƬ���ļ���
    }
    /**
     * ��������ͼ����������ݼ�
     * @return �������ݼ�
     */
    private XYDataset createDateSet()
    {
        TimeSeriesCollection dataset = new TimeSeriesCollection();//ʱ���������ݼ���
        TimeSeries s1 = new TimeSeries("��ʷ����", Day.class);//����ʱ������Դ��ÿһ��//TimeSeries��ͼ����һ������
//s1.add(new Day(day,month,year),value),������ݵ���Ϣ 
        s1.add(new Day(1, 2, 2006), 123.51);
        s1.add(new Day(2, 2, 2006), 122.1);
        s1.add(new Day(3, 2, 2006), 120.86);
        s1.add(new Day(4, 2, 2006), 122.50);
        s1.add(new Day(5, 2, 2006), 123.12);
        s1.add(new Day(6, 2, 2006), 123.9);
        s1.add(new Day(7, 2, 2006), 124.47);
        s1.add(new Day(8, 2, 2006), 124.08);
        s1.add(new Day(9, 2, 2006), 123.55);
        s1.add(new Day(10, 2, 2006), 122.53);
        dataset.addSeries(s1);
        dataset.setDomainIsPointsInTime(true);
        return dataset;
    }
} 
