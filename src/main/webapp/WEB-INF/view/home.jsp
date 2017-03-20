<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<jsp:include page="header.jsp" />



<div class="row">
    <div class="col-10" id="map-canvas"></div>
    <div class="col-2">
        <form:form  action="/NYCcab/" method="get" commandName="rideValues">

            </br>height - y<form:input type="text" id = "pickupLatitude" path="pickupLatitude"/>
            width - x<form:input type="text" id = "pickupLongtitude" path="pickupLongtitude"/>
            </br>height - y<form:input type="text" id = "dropoffLatitude" path="dropoffLatitude"/>
            width - x<form:input type="text" id = "dropoffLongtitude" path="dropoffLongtitude"/>
            <input type="submit" value="go">
        </form:form>

    </div>
</div>
<jsp:include page="footer.jsp" />