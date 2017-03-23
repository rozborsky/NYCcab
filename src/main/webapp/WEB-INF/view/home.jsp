<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:include page="header.jsp" />

<div class="row">
    <div class="col-9" id="map-canvas"></div>
    <div class="col-3">
        <div class="col-12" id="header">
           <h1>NYC cab</h1>
        </div>
        <form:form  action="/NYCcab/" method="get" commandName="rideValues">

            <form:radiobutton path="start" value="true" label="start" onclick="startTrip()"/>
            <form:radiobutton path="start" value="false" label="finish" onclick="finishTrip()"/>
            </br>

            <form:select id="hour" path="hour" label="time" >
               <form:options items="${hours}" />
            </form:select>time</br>

            <form:input type="hidden" id = "pickupLatitude" path="pickupLatitude"/>
            <form:input type="hidden" id = "pickupLongtitude" path="pickupLongtitude"/>
            <form:input type="hidden" id = "dropoffLatitude" path="dropoffLatitude"/>
            <form:input type="hidden" id = "dropoffLongtitude" path="dropoffLongtitude"/>

            <input type="submit" value="get coordinates">
        </form:form>

        <c:choose>
            <c:when test="${rideValues.isStart() == true}">
               <jsp:include page="startResult.jsp" />
            </c:when>
            <c:otherwise>
               <jsp:include page="finishResult.jsp" />
            </c:otherwise>
        </c:choose></br>

    </div>
</div>
<jsp:include page="footer.jsp" />