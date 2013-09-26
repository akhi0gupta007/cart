<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<html>
<head>
<link href="<s:url value="/resources" />/css/tabtastic.css"
	rel="stylesheet" type="text/css" />


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
<style type="text/css">
.errors {
	background-color: #FFCCCC;
	border: 1px solid #CC0000;
	width: 400px;
	margin-bottom: 8px;
}

.errors li {
	list-style: none;
}

.msgs {
	background-color: #FFCCCC;
	border: 1px solid #CC0000;
	width: 400px;
	margin-bottom: 8px;
}

.msgs li {
	list-style: none;
}

#protype1 {
	width: 800px;
	padding: 0;
	margin: 0;
}

caption {
	padding: 0 0 5px 0;
	width: 900px;
	font: italic 11px "Trebuchet MS", Verdana, Arial, Helvetica, sans-serif;
	text-align: right;
}

th {
	font: bold 11px "Trebuchet MS", Verdana, Arial, Helvetica, sans-serif;
	color: #4f6b72;
	border-right: 1px solid #C1DAD7;
	border-bottom: 1px solid #C1DAD7;
	border-top: 1px solid #C1DAD7;
	letter-spacing: 2px;
	text-transform: uppercase;
	text-align: left;
	padding: 6px 6px 6px 12px;
	background: #CAE8EA url(${request.contextPath}/images/bullet1.gif)
		no-repeat;
}

th.nobg {
	border-top: 0;
	border-left: 0;
	border-right: 1px solid #C1DAD7;
	background: none;
}

td {
	border-right: 1px solid #C1DAD7;
	border-bottom: 1px solid #C1DAD7;
	background: #fff;
	padding: 6px 6px 6px 12px;
	color: #4f6b72;
}

td.alt {
	background: #F5FAFA;
	color: #797268;
}

th.spec {
	border-left: 1px solid #C1DAD7;
	border-top: 0;
	background: #fff url(${request.contextPath}/images/bullet1.gif)
		no-repeat;
	font: bold 10px "Trebuchet MS", Verdana, Arial, Helvetica, sans-serif;
}

th.specalt {
	border-left: 1px solid #C1DAD7;
	border-top: 0;
	background: #f5fafa url(${request.contextPath}/images/bullet2.gif)
		no-repeat;
	font: bold 10px "Trebuchet MS", Verdana, Arial, Helvetica, sans-serif;
	color: #797268;
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
	background-image: url(<   s :   url value =   "/resources"/ >/ images/ close.png);
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
<script type="text/javascript">
	/* 	var total_items = 0;
	 var total_price = 0;
	 $(document)
	 .ready(
	 function() {

	 $("img[rel]").overlay();
	 path = "${request.contextPath}"
	 //  $('#box').hide();
	 $(".item").draggable({
	 revert : true
	 });
	 $("#cart_items").draggable({
	 axis : "x"
	 });

	 $("#cart_items")
	 .droppable(
	 {
	 accept : ".item",
	 activeClass : "drop-active",
	 hoverClass : "drop-hover",
	 drop : function(event, ui) {
	 var item = ui.draggable.html();
	 var itemid = ui.draggable
	 .attr("id");
	 var html = '<div class="item icart">';
	 html = html
	 + '<div class="divrm">';
	 html = html
	 + '<a onclick="remove(this)" class="remove '
	 + itemid
	 + '">&times;</a>';
	 html = html + '<div/>' + item
	 + '</div>';
	 $("#cart_items").append(html);

	 // update total items
	 total_items++;
	 $("#citem").html(total_items);

	 // update total price
	 var price = parseInt(ui.draggable
	 .find(".price").html()
	 .replace("Rs ", ""));
	 total_price = total_price
	 + price;
	 $("#cprice").html(
	 "Rs " + total_price);

	 // expand cart items
	 if (total_items > 4) {
	 $("#cart_items").animate({
	 width : "+=90"
	 }, 'slow');
	 }
	 }
	 });

	 $("#btn_next").click(function() {
	 $("#cart_items").animate({
	 left : "-=100"
	 }, 100);
	 return false;
	 });
	 $("#btn_prev").click(function() {
	 $("#cart_items").animate({
	 left : "+=100"
	 }, 100);
	 return false;
	 });
	 $("#btn_clear").click(function() {
	 $("#cart_items").fadeOut("2000", function() {
	 $(this).html("").fadeIn("fast").css({
	 left : 0
	 });
	 });
	 $("#citem").html("0");
	 $("#cprice").html("Rs 0");
	 total_items = 0;
	 total_price = 0;
	 return false;
	 });
	 });
	 function remove(el) {
	 $(el).hide();
	 $(el).parent().parent().effect("highlight", {
	 color : "#ff0000"
	 }, 1000);
	 $(el).parent().parent().fadeOut('1000');
	 setTimeout(function() {
	 $(el).parent().parent().remove();
	 // collapse cart items
	 if (total_items > 3) {
	 $("#cart_items").animate({
	 width : "-=90"
	 }, 'slow');
	 }
	 }, 1100);

	 // update total item
	 total_items--;
	 $("#citem").html(total_items);

	 // update totl price
	 var price = parseInt($(el).parent().parent().find(".price").html()
	 .replace("Rs ", ""));
	 total_price = total_price - price;
	 $("#cprice").html("Rs " + total_price);
	 } */
</script>
</head>
<body>
	<div class="body">
		<h1>Product Catalog</h1>


		<div id="item_container">


			<br>
			<c:forEach items="${products}" var="element">

				<div class="item" id="i1">

					<%--           <g:if env="production">
                <img src="/images/products/${next.image}" alt="image" width="100" height="100"/>
            </g:if>
            <g:else>
                <img src="<g:resource dir="images/products" file="${next.image}"/>" width="100" height="100"/>
            </g:else> --%>
					<a href="/cart/home/details/${element.product_code} "><img
						src="<s:url value="/resources" />/images/p/${element.image}"
						alt="image" width="100" height="100" /></a> <label class="title"
						id="${element.product_code}">${element.product_name}</label> <label
						class="price">Rs ${element.price}</label>

				</div>

			</c:forEach>
			<div class="clear"></div>
		</div>


		<div class="simple_overlay" id="mies1">
			<!-- large image -->

			<div class="cart">
				<h2 align="center">Shopping Cart</h2>
				<br> <br>
				<form action="${request.contextPath}/sales/review" method="post"
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