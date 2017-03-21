<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<jsp:include page="header.jsp" />



<div class="row">
    <div class="col-10" id="map-canvas"></div>
    <div class="col-2">
        <form:form  action="/NYCcab/" method="get" commandName="rideValues">

            <form:select path="hour">
               <form:options items="${hours}" />
            </form:select>

            <form:input type="hidden" id = "pickupLatitude" path="pickupLatitude"/>
            <form:input type="hidden" id = "pickupLongtitude" path="pickupLongtitude"/>
            <form:input type="hidden" id = "dropoffLatitude" path="dropoffLatitude"/>
            <form:input type="hidden" id = "dropoffLongtitude" path="dropoffLongtitude"/>



            <input type="submit" value="go">
        </form:form>
    </div>
</div>
<jsp:include page="footer.jsp" />