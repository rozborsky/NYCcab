<script
    src="https://maps.googleapis.com/maps/api/js?key=AIzaSyDBt6ZE4qu7OWI9O3Ay6taGmML1_wOV8Vs&sensor=false">
</script>

<script>
    var map;
    var marker;
    var startTime;

    function initialize() {
        document.getElementById('latitude').value='';

        var mapOptions = {
            zoom: 10,
            center: new google.maps.LatLng(40.71, -74)
        };
        map = new google.maps.Map(document.getElementById('map-canvas'), mapOptions);
        map.addListener('click', function(event) {
            addMarker(event.latLng);
        });
    }

    var image = new google.maps.MarkerImage('layer.png',
          new google.maps.Size(100, 32),
          new google.maps.Point(0,0),
          new google.maps.Point(0, 32));

    function addMarker(location) {
        if(marker != null) {
            marker.setMap(null);
        }

        marker = new google.maps.Marker({
            position: location,
            icon: image,
            map: map,

        });
        document.getElementById('longitude').value=marker.getPosition().lng().toFixed(3);
        document.getElementById('latitude').value=marker.getPosition().lat().toFixed(3);
    }
    google.maps.event.addDomListener(window, 'load', initialize);


</script>