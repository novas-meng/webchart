<%@ page contentType="text/html;charset=gb2312" pageEncoding="GB2312"%>
<%@ page import="com.novas.chart.LineXYChart"%>
<%@ page import = "java.io.PrintWriter" %>
<%
  LineXYChart xyChart=new LineXYChart();
  String fileName=xyChart.getLineXYChart(session,new PrintWriter(out));
  String graphURL = request.getContextPath() + "/DisplayChart?filename=" + fileName;
  System.out.println(fileName);
  System.out.println(graphURL);
%>
<html>
</head>
<title> JFreeChart使用例子</title>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
</head>
<body>
<p>fasfafaffafaffa</p>
<img src="<%= graphURL %>" width=500 height=300 border=0 usemap="<%= fileName %>">
</body>
</html>