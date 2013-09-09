<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<p align="right">
	<c:choose>
		<c:when test="${sessionScope.customer.userId != null}">
	You are :<b> ${sessionScope.customer.userId} </b>|	<b><a href="/cart/home/logout">Logout</a></b><br />
		
			  <b>My Cart</b> <img src="<s:url value="/resources" />/images/cart.jpg" rel="#mies1" width="50" height="50"/>
		</c:when>
		<c:otherwise>
			<a href="">Login</a>
		</c:otherwise>
	</c:choose>



</p>
