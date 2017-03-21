<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:choose>
    <c:when test="${listTrips.size() == 0}">
       it wasn't trips in ${rideValues.getHour()} o'clock from places with coordinates
       ${rideValues.getPickupLongtitude()} - ${rideValues.getPickupLatitude()}
    </c:when>
    <c:otherwise>
        it was ${listTrips.size()}trips in ${rideValues.getHour()} o'clock from places with coordinates
        ${rideValues.getPickupLongtitude()} - ${rideValues.getPickupLongtitude()}
    </c:otherwise>
</c:choose>