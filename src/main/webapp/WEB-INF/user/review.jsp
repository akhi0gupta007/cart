<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<style type="text/css">
table {
	font: 11px/24px Verdana, Arial, Helvetica, sans-serif;
	width: 100%;
}

th {
	padding: 0 0.5em;
	text-align: left;
}

tr.yellow td {
	background: #FFC;
}

td {
	padding: 0 0.5em;
}

td.width {
	width: 100%;
}

td.adjacent {
	text-align: center;
}

/* the overlayed element */
.simple_overlay {
	/* must be initially hidden */
	display: none;
	/* place overlay on top of other elements */
	z-index: 10000;
	/* styling */
	background-color: #ffffff;
	width: 675px;
	min-height: 500px;
	border: 1px solid #666;
	/* CSS3 styling for latest browsers */
	-moz-box-shadow: 0 0 90px 5px #000;
	-webkit-box-shadow: 0 0 90px #000;
}

/* close button positioned on upper right corner */
.simple_overlay .close {
	background-image: url(<                                       s :  
		                               
		    url value =          
		               
		            "/resources"/ >/ images/ close.png);
	position: absolute;
	right: -15px;
	top: -15px;
	cursor: pointer;
	height: 35px;
	width: 35px;
}
/* styling for elements inside overlay */
.cart {
	top: 15px;
	padding: 20px;
	font-size: 11px;
	color: #331921;
	margin-left: auto;
	margin-right: auto;
}

.cart p {
	border-color: blue;
	border-width: thin;
	border-style: dashed;
}

.cart h2 {
	color: #4f574f;
	font-size: 20px;
}

.cart table {
	border: 1px;
}

.cart td {
	text-align: center;
	padding: 5px;
}

.cart th {
	font-weight: bold;
	background-color: #9dafb8;
}

.cart items {
	
}
</style>
<script type="text/javascript"
	src="<s:url value="/resources" />/js/jquery-1.7.2.min.js"></script>

<script type="text/javascript"
	src="<s:url value="/resources" />/js/script1.js"></script>


<script type="text/javascript"
	src="<s:url value="/resources" />/js/jquery-ui-1.8.9.custom.min.js"></script>

<script type="text/javascript"
	src="<s:url value="/resources" />/js/overlay.js"></script>
</head>
<body style="background-color: #E643DB;">
	<div class="body">

		<b>Review your Order before processing</b>

		<c:if test="${order != null }">
			<table>
				<tr>
					<th>Product Name</th>
					<th>Quantity</th>
					<th>Total</th>
				</tr>

				<c:forEach items="${order.bag}" var="elm">
					<tr>
						<td>${elm.key.product_name }</td>

						<c:forEach items="${elm.value }" var="val">
							<td>${val }</td>
						</c:forEach>

					</tr>
				</c:forEach>

				<tr></tr>

				<tr>
					<td>Gross Total:</td>
					<td>${order.total }</td>
				</tr>
				<tr>
					<td></td>
					<td></td>
				</tr>
			</table>
			<p align="right">
				<img src="<s:url value="/resources" />/images/order.png" alt="image"
					width="200" height="35" />

			</p>
			<br />
			<br />
		</c:if>


	</div>

</body>
</html>