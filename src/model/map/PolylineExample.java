
package model.map;

import com.teamdev.jxmaps.ControlPosition;

import com.teamdev.jxmaps.LatLng;
import com.teamdev.jxmaps.Map;
import com.teamdev.jxmaps.MapOptions;
import com.teamdev.jxmaps.MapReadyHandler;
import com.teamdev.jxmaps.MapStatus;
import com.teamdev.jxmaps.MapTypeControlOptions;
import com.teamdev.jxmaps.Polyline;
import com.teamdev.jxmaps.PolylineOptions;
import com.teamdev.jxmaps.swing.MapView;

import javax.swing.*;
import java.awt.*;

/**
 * This example demonstrates how to draw polylines on the map.
 *
 * @author Vitaly Eremenko
 */
public class PolylineExample extends MapView {
    public PolylineExample() {
        // Setting of a ready handler to MapView object. onMapReady will be called when map initialization is done and
        // the map object is ready to use. Current implementation of onMapReady customizes the map object.
        setOnMapReadyHandler(new MapReadyHandler() {
            @Override
            public void onMapReady(MapStatus status) {
                // Check if the map is loaded correctly
                if (status == MapStatus.MAP_STATUS_OK) {
                    // Getting the associated map object
                    final Map map = getMap();
                    // Creating a map options object
                    MapOptions mapOptions = new MapOptions();
                    // Creating a map type control options object
                    MapTypeControlOptions controlOptions = new MapTypeControlOptions();
                    // Changing position of the map type control
                    controlOptions.setPosition(ControlPosition.TOP_RIGHT);
                    // Setting map type control options
                    mapOptions.setMapTypeControlOptions(controlOptions);
                    // Setting map options
                    map.setOptions(mapOptions);
                    // Setting the map center
                    map.setCenter(new LatLng(38.889931, -77.009003));
                    // Setting initial zoom value
                    map.setZoom(11.0);
                    // Creating a path (array of coordinates) that represents a polyline
                    LatLng[] path = {new LatLng(38.989931, -77.909003),
                            new LatLng(38.989931, -77.609003),
                            new LatLng(39.089931, -77.109003),
                            new LatLng(38.009931, -76.909003),
                            new LatLng(39.009931, -75.909003)
                            };
                    // Creating a new polyline object
                    Polyline polyline = new Polyline(map);
                    // Initializing the polyline with created path
                    polyline.setPath(path);
                    // Creating a polyline options object
                    PolylineOptions options = new PolylineOptions();
                    // Setting geodesic property value
                    options.setGeodesic(true);
                    // Setting stroke color value
                    options.setStrokeColor("#FF0000");
                    // Setting stroke opacity value
                    options.setStrokeOpacity(1.0);
                    // Setting stroke weight value
                    options.setStrokeWeight(2.0);
                    // Applying options to the polyline
                    polyline.setOptions(options);
                    
                    
                }
            }
        });
    }

    public static void main(String[] args) {
        final PolylineExample sample = new PolylineExample();

        JFrame frame = new JFrame("Mapa");

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.add(sample, BorderLayout.CENTER);
        frame.setSize(1500, 1500);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

}