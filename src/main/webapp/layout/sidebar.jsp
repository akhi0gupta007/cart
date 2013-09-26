<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<html>
<head>
<style type="text/css">
.sidebarmenu ul {
	margin: 0;
	padding: 50;
	list-style-type: none;
	font: bold 13px Verdana;
	width: 180px; /* Main Menu Item widths */
	border-bottom: 1px solid #ccc;
}

.sidebarmenu ul li {
	position: relative;
}

/* Top level menu links style */
.sidebarmenu ul li a {
	display: block;
	overflow: auto; /*force hasLayout in IE7 */
	color: white;
	text-decoration: none;
	padding: 6px;
	border-bottom: 1px solid #778;
	border-right: 1px solid #778;
}

.sidebarmenu ul li a:link,.sidebarmenu ul li a:visited,.sidebarmenu ul li a:active
	{
	background-color: #012D58; /*background of tabs (default state)*/
}

.sidebarmenu ul li a:visited {
	color: white;
}

.sidebarmenu ul li a:hover {
	background-color: black;
}

/*Sub level menu items */
.sidebarmenu ul li ul {
	position: absolute;
	width: 170px; /*Sub Menu Items width */
	top: 0;
	visibility: hidden;
}

.sidebarmenu a.subfolderstyle {
	background: url(${request.contextPath}/images/right.gif) no-repeat 97%
		50%;
}

/* Holly Hack for IE \*/
* html .sidebarmenu ul li {
	float: left;
	height: 1%;
}

* html .sidebarmenu ul li a {
	height: 1%;
}
/* End */
</style>


</head>
<body>
	<div id="buddies">
		<div class="title">
			<div class="a">
				<ul id="sidebarmenu">
					<c:choose>

						<c:when test="${cats != null}">
							<li><h2>Browse Categories</h2></li>
							<li><br /></li>
							<li><br /></li>
							<c:forEach items="${cats}" var="elm">
								<li><a href="/cart/home/catalog?cat=${elm.key} ">
										${elm.value} </a></li>
							</c:forEach>
						</c:when>

					</c:choose>


				</ul>
			</div>

			<p>
	<%-- 			<strong>LATEST TWEETS</strong>
			</p>
			<a class="twitter-timeline" href="https://twitter.com/twitterapi"
				data-widget-id="YOUR-WIDGET-ID-HERE">Tweets by @twitterapi</a> <br>
			<br>
			<script>
				!function(d, s, id) {
					var js, fjs = d.getElementsByTagName(s)[0];
					if (!d.getElementById(id)) {
						js = d.createElement(s);
						js.id = id;
						js.src = "//platform.twitter.com/widgets.js";
						fjs.parentNode.insertBefore(js, fjs);
					}
				}(document, "script", "twitter-wjs");
			</script> --%>


		</div>
	</div>
</body>
</html>