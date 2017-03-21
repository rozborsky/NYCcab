<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:include page="header.jsp" />

<div class="row">
    <div class="col-9" id="map-canvas"></div>
    <div class="col-3">
        <form:form  action="/NYCcab/" method="get" commandName="rideValues">
            <form:radiobutton id="isStart" path="start" value="true" label="start"/>
            <form:radiobutton id="isStart" path="start" value="false" label="finish" />
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
        </c:choose>

    </div>
</div>
<jsp:include page="footer.jsp" />