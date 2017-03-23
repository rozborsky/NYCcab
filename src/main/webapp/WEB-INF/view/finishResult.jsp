<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:choose>
    <c:when test="${listTrips.size() == 0}">
       it wasn't trips in ${rideValues.getHour()} o'clock to place with coordinates
       ${rideValues.getDropoffLongtitude()} - ${rideValues.getDropoffLatitude()}
    </c:when>
    <c:otherwise>
        it was ${listTrips.size()} trips in ${rideValues.getHour()} o'clock to places with coordinates
        ${rideValues.getDropoffLongtitude()} - ${rideValues.getDropoffLatitude()}</br>
         </br>
         from brooklyn - <span id="brooklyn"></span>%</br>
         from staten island - <span id="statenIsland"></span>%</br>
         from queens - <span id="queens"></span>%</br>
         from bronx - <span id="bronx"></span>%</br>
         from manhattan - <span id="manhattan"></span>%</br>
    </c:otherwise>
</c:choose>
