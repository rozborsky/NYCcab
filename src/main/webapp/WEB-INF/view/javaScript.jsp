<script
    src="https://maps.googleapis.com/maps/api/js?key=AIzaSyDBt6ZE4qu7OWI9O3Ay6taGmML1_wOV8Vs&sensor=false">
</script>

<script>
    var map;
    var startMarker;
    var stopMarker;
    var startTime;

    function initialize() {
        document.getElementById('hour').value=${rideValues.getHour()};

        var mapOptions = {
            zoom: 12,
            center: new google.maps.LatLng(40.71, -74)
        };
        map = new google.maps.Map(document.getElementById('map-canvas'), mapOptions);

        if(${rideValues.isStart()}){
            if(${rideValues.getPickupLatitude()} != 0 && ${rideValues.getPickupLongtitude()} != 0) {
                addStartMarker();
                if(${rideValues.getDropoffLatitude()} != 0 && ${rideValues.getDropoffLongtitude()} != 0) {
                addStopMarker();
                }
            }
            map.addListener('click', function(event) {
                moveStartMarker(event.latLng);
            });
        } else {

        }
    }

function startTrip() {
    alert("start");
}
function finishTrip() {
    alert("stop");
}
    function moveStartMarker(location) {
        if(startMarker != null) {
            startMarker.setMap(null);
        }

        startMarker = new google.maps.Marker({
            position: location,
            map: map,
            label: "START TRIP"
        });

        addStopMarker();
        document.getElementById('pickupLongtitude').value=startMarker.getPosition().lng().toFixed(3);
        document.getElementById('pickupLatitude').value=startMarker.getPosition().lat().toFixed(3);
    }

    function addStartMarker(location) {
        startMarker = new google.maps.Marker({
            position: new google.maps.LatLng(${rideValues.getPickupLatitude()}, ${rideValues.getPickupLongtitude()}),
            map: map,
            label: "START TRIP"
        });

        document.getElementById('pickupLongtitude').value=startMarker.getPosition().lng().toFixed(3);
        document.getElementById('pickupLatitude').value=startMarker.getPosition().lat().toFixed(3);
    }

    function addStopMarker() {
        if(stopMarker != null) {
            stopMarker.setMap(null);
        }
        stopMarker = new google.maps.Circle({
                           strokeColor: '#FF0000',
                           strokeOpacity: 0.3,
                           strokeWeight: 1,
                           fillColor: '#FF0000',
                           fillOpacity: 0.35,
                           map: map,
                           center: new google.maps.LatLng(${rideValues.getDropoffLatitude()}, ${rideValues.getDropoffLongtitude()}),
                           radius: 2000
        });
    }
    google.maps.event.addDomListener(window, 'load', initialize);
</script>