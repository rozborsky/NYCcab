<script
    src="https://maps.googleapis.com/maps/api/js?key=AIzaSyDBt6ZE4qu7OWI9O3Ay6taGmML1_wOV8Vs&sensor=false">
</script>

<script>
    var map;
    var startMarker;
    var stopMarker;
    var startTime;

var f = 0.01;

    function initialize() {
        document.getElementById('latitude').value='';

        var mapOptions = {
            zoom: 10,
            center: new google.maps.LatLng(40.71, -74)
        };
        map = new google.maps.Map(document.getElementById('map-canvas'), mapOptions);
        map.addListener('click', function(event) {
            addStartMarker(event.latLng);
        });
    }

    var image = new google.maps.MarkerImage('layer.png',
          new google.maps.Size(100, 32),
          new google.maps.Point(0,0),
          new google.maps.Point(0, 32));

    function addStartMarker(location) {
        if(startMarker != null) {
            startMarker.setMap(null);
        }

        startMarker = new google.maps.Marker({
            position: location,
            map: map,

        });

        addStopMarker(location);
        document.getElementById('longitude').value=startMarker.getPosition().lng().toFixed(3);
        document.getElementById('latitude').value=startMarker.getPosition().lat().toFixed(3);
    }

    function addStopMarker(location) {
        if(stopMarker != null) {
            stopMarker.setMap(null);
        }
        f +=0.01;
        stopMarker = new google.maps.Circle({
                           strokeColor: '#FF0000',
                           strokeOpacity: 0.3,
                           strokeWeight: 1,
                           fillColor: '#FF0000',
                           fillOpacity: 0.35,
                           map: map,
                           center: new google.maps.LatLng(40.72 + f, -74.1),
                           radius: 2000
        });
    }
    google.maps.event.addDomListener(window, 'load', initialize);
</script>