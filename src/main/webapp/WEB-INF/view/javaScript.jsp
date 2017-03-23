<script
    src="https://maps.googleapis.com/maps/api/js?key=AIzaSyDBt6ZE4qu7OWI9O3Ay6taGmML1_wOV8Vs&sensor=false">
</script>

<script>
    var map;
    var startMarker;
    var stopMarker;
    var startTime;
    var isStart;

    function initialize() {
        document.getElementById('hour').value=${rideValues.getHour()};

        document.getElementById('brooklyn').innerHTML = (${districts.get("brooklyn")} * 100).toFixed(1);
        document.getElementById('manhattan').innerHTML = (${districts.get("manhattan")} * 100).toFixed(1);
        document.getElementById('statenIsland').innerHTML = (${districts.get("statenIsland")} * 100).toFixed(1);
        document.getElementById('queens').innerHTML = (${districts.get("queens")} * 100).toFixed(1);
        document.getElementById('bronx').innerHTML = (${districts.get("bronx")} * 100).toFixed(1);

        if(${rideValues.isStart()} == true) {
            isStart = true;
        }

        var mapOptions = {
            zoom: 11,
            center: new google.maps.LatLng(40.71, -74)
        };
        map = new google.maps.Map(document.getElementById('map-canvas'), mapOptions);

        if(${rideValues.getPickupLatitude()} != 0 && ${rideValues.getPickupLongtitude()} != 0 && isStart == true) {
            addStartMarker();
        }
        if(${rideValues.getDropoffLatitude()} != 0 && ${rideValues.getDropoffLongtitude()} != 0 && isStart != true) {
            addStopMarker();
        }
        map.addListener('click', function(event) {
            moveStartMarker(event.latLng);
        });
        addDistrictMarker(40.77, -73.97, ${districts.get("manhattan")});
        addDistrictMarker(40.65, -73.94, ${districts.get("brooklyn")});
        addDistrictMarker(40.57, -74.15, ${districts.get("statenIsland")});
        addDistrictMarker(40.73, -73.79, ${districts.get("queens")});
        addDistrictMarker(40.88, -73.85, ${districts.get("bronx")});
    }

function startTrip() {
    isStart = true;
    alert("start");
}
function finishTrip() {
isStart = false;
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

    function addStopMarker(location) {
        startMarker = new google.maps.Marker({
            position: new google.maps.LatLng(${rideValues.getPickupLatitude()}, ${rideValues.getPickupLongtitude()}),
            map: map,
            label: "FINISH TRIP"
        });

        document.getElementById('pickupLongtitude').value=startMarker.getPosition().lng().toFixed(3);
        document.getElementById('pickupLatitude').value=startMarker.getPosition().lat().toFixed(3);
    }

    function addDistrictMarker(latitude, longtitude, coefficient) {
        districtMarker = new google.maps.Circle({
                           strokeColor: '#FF0000',
                           strokeOpacity: 0.3,
                           strokeWeight: 1,
                           fillColor: '#FF0000',
                           fillOpacity: coefficient,
                           map: map,
                           center: new google.maps.LatLng(latitude, longtitude),
                           radius: 4000,
                           label: "fffffff"
        });
    }



    google.maps.event.addDomListener(window, 'load', initialize);
</script>