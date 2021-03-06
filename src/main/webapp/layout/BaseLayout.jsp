<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title><tiles:insertAttribute name="title" ignore="true" /></title>

<link href="<s:url value="/resources" />/css/site.css" rel="stylesheet"
	type="text/css" />
</head>

<body>
	<div id="page">
		<div id="spinner" class="spinner" style="display: none;"></div>
		<div id="cus">
			<tiles:insertAttribute name="topbar" />
		</div>
		<div id="header">
			<h1>Shopping Cart</h1>
		</div>
		<div id="topbar1">
			<tiles:insertAttribute name="menu" />
		</div>
		<div id="maincontainer">
			<div id="content">
				<tiles:insertAttribute name="body" />
			</div>
			<div id="sidebar">
				<tiles:insertAttribute name="cat" />
			</div>
			<div id="footer">
				<tiles:insertAttribute name="footer" />
			</div>
			<div style="clear: both;"></div>
		</div>
	</div>
</body>
</html>