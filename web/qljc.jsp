<%@ page contentType="text/html;charset=gb2312" pageEncoding="GB2312"%>
<%@ page import="com.novas.chart.LineXYChart"%>
<%@ page import = "java.io.PrintWriter" %>
<%@ page import="java.lang.reflect.Array" %>
<%
  LineXYChart xyChart=new LineXYChart();
  String fileName=xyChart.getLineXYChart(session,new PrintWriter(out));
  String graphURL = request.getContextPath() + "/DisplayChart?filename=" + fileName;
  System.out.println(fileName);
  graphURL="http://localhost:8080"+graphURL;
  System.out.println(graphURL);

%>



<%--
  Created by IntelliJ IDEA.
  User: novas
  Date: 2016/3/17
  Time: 23:03
  To change this template use File | Settings | File Templates.

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
--%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="zh-cn" lang="zh-cn" dir="ltr" >
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=gb2312">
  <base href="http://smc.hit.edu.cn/qthdata/index.php/sample-sites" />
  <meta http-equiv="content-type" content="text/html; charset=utf-8" />
  <meta name="author" content="Super User" />
  <meta name="generator" content="Joomla! - Open Source Content Management" />
  <title>��������</title>
  <link href="/qthdata/templates/beez_20/favicon.ico" rel="shortcut icon" type="image/vnd.microsoft.icon" />
  <link href="http://smc.hit.edu.cn/qthdata/index.php/component/search/?Itemid=238&amp;format=opensearch" rel="search" title="���� ��ظ��ٹ�·�ֱ�������ƽ̨" type="application/opensearchdescription+xml" />
  <link rel="stylesheet" href="/qthdata/templates/system/css/system.css" type="text/css" />
  <link rel="stylesheet" href="/qthdata/templates/beez_20/css/position.css" type="text/css" media="screen,projection"  />
  <link rel="stylesheet" href="/qthdata/templates/beez_20/css/layout.css" type="text/css" media="screen,projection"  />
  <link rel="stylesheet" href="/qthdata/templates/beez_20/css/print.css" type="text/css" media="print"  />
  <link rel="stylesheet" href="/qthdata/templates/beez_20/css/general.css" type="text/css" />
  <link rel="stylesheet" href="/qthdata/templates/beez_20/css/nature.css" type="text/css" />
  <script src="/qthdata/media/system/js/mootools-core.js" type="text/javascript"></script>
  <script src="/qthdata/media/system/js/core.js" type="text/javascript"></script>
  <script src="/qthdata/media/system/js/caption.js" type="text/javascript"></script>
  <script src="/qthdata/media/system/js/mootools-more.js" type="text/javascript"></script>
  <script src="/qthdata/templates/beez_20/javascript/md_stylechanger.js" type="text/javascript"></script>
  <script src="/qthdata/templates/beez_20/javascript/hide.js" type="text/javascript"></script>
  <script type="text/javascript">
    window.addEvent('load', function() {
      new JCaption('img.caption');
    });
  </script>


  <!--[if lte IE 6]>
  <link href="/qthdata/templates/beez_20/css/ieonly.css" rel="stylesheet" type="text/css" />
  <![endif]-->

  <!--[if IE 7]>
  <link href="/qthdata/templates/beez_20/css/ie7only.css" rel="stylesheet" type="text/css" />
  <![endif]-->

  <script type="text/javascript">
    var big ='72%';
    var small='53%';
    var altopen='�ѹر�';
    var altclose='�ѹر�';
    var bildauf='/qthdata/templates/beez_20/images/plus.png';
    var bildzu='/qthdata/templates/beez_20/images/minus.png';
    var rightopen='��������';
    var rightclose='�ر�������';
    var fontSizeTitle='�����С��';
    var bigger='�Ŵ�';
    var reset='����';
    var smaller='��С';
    var biggerTitle='���ӳߴ�';
    var resetTitle='�ָ�Ĭ����ʽ';
    var smallerTitle='��С�ߴ�';
  </script>

</head>

<body>
<div id="all">
  <div id="back">
    <div id="header">
      <div class="logoheader">
        <h1 id="logo">
          <a href="http://localhost:8080/webchart/demo.csv" target="_self">�ҵ��ĵ�</a>
          <a href="http://localhost:8080/webchart/demo.zip" >download</a>
          <img src="/qthdata/images/joomla_black.gif"  alt="��ظ��ٹ�·�ֱ�������ƽ̨" />
                                                                                                                        <span class="header1">
                                        Disaster Monitoring Data Platform for Qinghai-Tibet Highway                                        </span></h1>
      </div><!-- end logoheader -->
      <ul class="skiplinks">
        <li><a href="#main" class="u2">��ת������</a></li>
        <li><a href="#nav" class="u2">��ת���������͵�¼</a></li>
      </ul>
      <h2 class="unseen">���������������</h2>
      <h3 class="unseen">����</h3>

      <ul class="menu">
        <li class="item-464"><a href="/qthdata/" >��ҳ</a></li><li class="item-444 active"><a href="/qthdata/index.php/sample-sites" >��������</a></li></ul>

      <div id="line">
        <div id="fontsize"></div>
        <h3 class="unseen">����</h3>
        <form action="/qthdata/index.php/sample-sites" method="post">
          <div class="search">
            <label for="mod-search-searchword">����...</label><input name="searchword" id="mod-search-searchword" maxlength="10"  class="inputbox" type="text" size="20" value="����..."  onblur="if (this.value=='') this.value='����...';" onfocus="if (this.value=='����...') this.value='';" />	<input type="hidden" name="task" value="search" />
            <input type="hidden" name="option" value="com_search" />
            <input type="hidden" name="Itemid" value="238" />
          </div>
        </form>

      </div> <!-- end line -->


    </div><!-- end header -->
    <div id="contentarea">
      <div id="breadcrumbs">


        <div class="breadcrumbs">
          <span class="showHere">��ǰλ�ã�</span><a href="/qthdata/" class="pathway">Home</a> <img src="/qthdata/templates/beez_20/images/system/arrow.png" alt=""  /> <span>��������</span></div>


      </div>



      <div class="left1 leftbigger" id="nav">
        <div class="moduletable_menu">
          <h3><span
                  class="backh"><span class="backh2"><span class="backh3">User Menu</span></span></span></h3>

          <ul class="menu">
            <li class="item-201"><a href="/qthdata/index.php/your-profile" >Your Profile</a></li></ul>
        </div>


        <div id="area-3" class="tabouter"><ul class="tabs"><li class="tab"><a href="#" id="link_22" class="linkopen" onclick="tabshow('module_22');return false">��������</a></li></ul><div tabindex="-1" class="tabcontent tabopen" id="module_22">
          <ul class="menu">
            <li class="item-243"><a href="/qthdata/index.php/road-bed-data" >·���������</a></li>
            <li class="item-234"><a href="/qthdata/index.php/bridge-data" >novas�������</a></li>
            <li class="item-242"><a href="/qthdata/index.php/tunnel-data" >novasnovas</a></li>
            <li class="item-244"><a href="/qthdata/index.php/the-other-data" >�����������</a></li>
          </ul>
        </div></div>
        <p><%= graphURL %></p>


      </div><!-- end navi -->

      <div id="wrapper2" >

        <div id="main">



          <div id="system-message-container">
          </div>
          <div class="item-page">

            <h2>
              <a href="javascript:void(0);" onclick="test() ">novasnovasnovas</a>
              <a href="/qthdata/index.php/sample-sites">
                ��������</a>
            </h2>

            <img src="<%= graphURL %>" width=500 height=300 border=0 usemap="<%= fileName %>">
            <form action="form_action.asp" method="get">
              <p>First name: <input type="text" name="fname" /></p>
              <p>Last name: <input type="text" name="lname" /></p>
              <script type="text/javascript">
                function test()
                {
                  alert("����js�����ķ���");
                }
                var big ='72%';
                var small='53%';
                var altopen='�ѹر�';
                var altclose='�ѹر�';
                var bildauf='/qthdata/templates/beez_20/images/plus.png';
                var bildzu='/qthdata/templates/beez_20/images/minus.png';
                var rightopen='��������';
                var rightclose='�ر�������';
                var fontSizeTitle='�����С��';
                var bigger='�Ŵ�';
                var reset='����';
                var smaller='��С';
                var biggerTitle='���ӳߴ�';
                var resetTitle='�ָ�Ĭ����ʽ';
                var smallerTitle='��С�ߴ�';
              </script>
              <select>
                <option value =<%= graphURL %>>reset</option>
                <option value ="2">Saab</option>
                <option value="3">Opel</option>
                <option value="4">Audi</option>
              </select>
              <input type="submit" value="Submit" />
            </form>




            <p>�������İ�����ع�·����ظ��ٹ�·��������·����·�桢����������ȹ������ϲɼ��Ļ�������Ӧ���ݣ���Բ�ͬ�Ĺ���������¶ȡ����Ρ�Ӧ�䡢�񶯼��ٶȵȡ�</p>
            <p>���˵��ṩ�����ݲ�ѯ����ڣ�ѡ����Ӧ�˵����Բ�ѯ����������������ݡ�</p>
            <p>ע����������ֻ����ض��û����š�</p>

          </div>


        </div><!-- end main -->

      </div><!-- end wrapper -->



      <div class="wrap"></div>

    </div> <!-- end contentarea -->

  </div><!-- back -->

</div><!-- all -->

<div id="footer-outer">

  <div id="footer-sub">


    <div id="footer">


      <p>
        Powered by <a href="http://www.hit.edu.cn">HIT</a>
      </p>


    </div><!-- end footer -->

  </div>

</div>

</body>
</html>

--%>