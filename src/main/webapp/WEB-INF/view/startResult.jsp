<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:choose>
    <c:when test="${listTrips.size() == 0}">
       it wasn't trips in ${rideValues.getHour()} o'clock from places with coordinates
       ${rideValues.getPickupLongtitude()} - ${rideValues.getPickupLatitude()}
    </c:when>
    <c:otherwise>
        it was ${listTrips.size()} trips in ${rideValues.getHour()} o'clock from places with coordinates
        ${rideValues.getPickupLongtitude()} - ${rideValues.getPickupLatitude()}</br>
        </br>
        to brooklyn - <span id="brooklyn"></span>%</br>
        to staten island - <span id="statenIsland"></span>%</br>
        to queens - <span id="queens"></span>%</br>
        to bronx - <span id="bronx"></span>%</br>
        to manhattan - <span id="manhattan"></span>%</br>
    </c:otherwise>
</c:choose>