<%@ page import="JavaBeanWeb.ChartGraphics"%>
<%@ page import="JavaBeanWeb.GetData"%>
<jsp:useBean id="cg" class="JavaBeanWeb.ChartGraphics" />
<jsp:useBean id="gd" class="JavaBeanWeb.GetData" />
<%!int height[] = new int[5];%>
<%
	height = gd.getHightArray();
	cg.graphicsGeneration(height[0], height[1], height[2], height[3],
			height[4]);
%>
<html>
<body>
<img src="c:\temp\chart.jpg"></img>
</body>
</html>
