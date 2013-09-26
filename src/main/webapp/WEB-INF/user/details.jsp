<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
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
	background-image: url(<s:url value ="/resources" />/images/
		close.png);
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
<script type="text/javascript">
	$(document).ready(function() {
		$("img[rel]").overlay();
		path = "${request.contextPath}"
	});
</script>
</head>
<body style="background-color: #E643DB;">
	<div class="body">
		<h3 align="center">${products.product_name}</h3>
		<br>

		<div id="image" style="float: right;">
			<img src="<s:url value="/resources" />/images/p/${products.image}"
				alt="image" width="230" height="220" /> <br> <br> <br>
			<a id="${products.brand_code} " action="remoteCart"
				onclick="jQuery.ajax({type:'POST', url:'/cart/home/remoteCart/${products.product_code}',success:function(data,textStatus){addedCart();},error:function(XMLHttpRequest,textStatus,errorThrown){}});return false;"
				href="/codebee/sales/remoteCart/1"> <img rel="#mies1"
				src="<s:url value="/resources" />/images/cart.gif ">
			</a>
		</div>

		<div style="float: left">
			<table style="float: left;">
				<tr>
					<td class="bold">Description:</td>
					<td>${products.description}</td>

				</tr>

				<tr>
					<td class="bold">Selling Price:</td>
					<td>${products.price}</td>

				</tr>
				<tr>
					<td class="bold">Net Weight:</td>
					<td>${products.net_weight}</td>
				</tr>
				<tr>
					<td class="bold">Product Code:</td>
					<td>${products.product_code}</td>
				</tr>
				<tr>
					<td class="bold">Company:</td>
					<td>${products.company}</td>
				</tr>
				<tr>
					<td class="bold">Stock :</td>
					<td>${product.total_stock_qty}</td>

				</tr>

			</table>
		</div>

	</div>





	<div class="simple_overlay" id="mies1">
		<!-- large image -->

		<div class="cart">
			<h2 align="center">Shopping Cart</h2>
			<br> <br>
			<form action="/cart/home/review" method="post"
				id="review">
				<table id="cart">



				</table>
				<br> <br> <a href='javascript:void(0)' class="classname"
					id='order' onclick="order()">Place Order</a>
			</form>

			<script type="text/javascript">
				function order() {
					$('#review').submit();
				}
			</script>
		</div>


	</div>

	</div>

</body>
</html>