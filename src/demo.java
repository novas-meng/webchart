import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.title.TextTitle;
import org.jfree.data.time.Month;
import org.jfree.data.time.TimeSeries;
import org.jfree.data.time.TimeSeriesCollection;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.io.IOException;

public class demo extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public demo() {
        super();
    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("in doget");

        doResponse(request,response);
    }


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("in dopost");
        doResponse(request, response);
    }

    private void doResponse(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String _time = request.getParameter("time");
        String _data = request.getParameter("data");
        System.out.println("time:" + _time);
        System.out.println("data:" + _data);


        TimeSeries timeSeries = new TimeSeries("���۹�blog������ͳ��", Month.class);
        //ʱ���������ݼ���  
        TimeSeriesCollection lineDataset = new TimeSeriesCollection();

        //�������ݼ���  
        timeSeries.add(new Month(1, 2007), 11200);
        timeSeries.add(new Month(2, 2007), 9000);
        timeSeries.add(new Month(3, 2007), 6200);
        timeSeries.add(new Month(4, 2007), 8200);
        timeSeries.add(new Month(5, 2007), 8200);
        timeSeries.add(new Month(6, 2007), 12200);
        timeSeries.add(new Month(7, 2007), 13200);
        timeSeries.add(new Month(8, 2007), 8300);
        timeSeries.add(new Month(9, 2007), 12400);
        timeSeries.add(new Month(10, 2007), 12500);
        timeSeries.add(new Month(11, 2007), 13600);
        timeSeries.add(new Month(12, 2007), 2500);

        lineDataset.addSeries(timeSeries);
        JFreeChart chart = ChartFactory.createTimeSeriesChart("������ͳ��ʱ����", "�·�", "������", lineDataset, true, true, true);

        //�����ӱ���  
        TextTitle subtitle = new TextTitle("2007���", new Font("����", Font.BOLD, 12));
        chart.addSubtitle(subtitle);
        //����������  
        chart.setTitle(new TextTitle("���۹�blog������ͳ��", new Font("����", Font.ITALIC, 15)));
        chart.setAntiAlias(true);  
          
          
        /*�������ã������������룩*/
        XYPlot plot = (XYPlot) chart.getPlot();
        ValueAxis valueAxis = plot.getDomainAxis();
        // ����x�����������  
        valueAxis.setTickLabelFont(new Font("����", Font.ITALIC, 12));
        // ����X��ı�������  
        valueAxis.setLabelFont(new Font("����", Font.ITALIC, 12));
        NumberAxis numberAxis = (NumberAxis) plot.getRangeAxis();
        // ����y���ϵ�����  
        numberAxis.setTickLabelFont(new Font("����", Font.PLAIN, 13));
        // ����y���ϵı�������  
        numberAxis.setLabelFont(new Font("����", Font.PLAIN, 13));
        // ���õײ�������  
        chart.getLegend().setItemFont(new Font("����", Font.PLAIN, 12));


        //��ͼ�����������ķ�ʽ���ظ��ͻ���   
        ChartUtilities.writeChartAsPNG(response.getOutputStream(), chart, 500, 300);
    }
}  