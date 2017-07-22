/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


var google = new Cesium.GoogleEarthImageryProvider({
    url : '//earth.localdomain',
    channel : 1008
});
var viewer = new Cesium.Viewer('map',{

    timeline :false,
    animation :false,
    baseLayerPicker : false,
    navigationInstructionsInitiallyVisible:false,
    scene3DOnly:false,
    fullscreenButton :false,
    infoBox : true,
    scenemodePicker: true,
    selectionIndicator:true,
    globe :false
   
});


var scene = viewer.scene;

viewer.scene.skyAtmosphere = new Cesium.SkyAtmosphere();
var options = { fill : Cesium.Color.fromRandom(),
                stroke : Cesium.Color.BLUE
                };


 var pickedEntities = new Cesium.EntityCollection();
 var pickColor = Cesium.Color.WHITE;
 function makeProperty(entity, color) {
        var colorProperty = new Cesium.CallbackProperty(function(time, result) {
            if (pickedEntities.contains(entity)) {
                return pickColor.clone(result);
            }
            return color.clone(result);
        }, false);

        entity.polygon.material = new Cesium.ColorMaterialProperty(colorProperty);
 }



    

    var handler = new Cesium.ScreenSpaceEventHandler(scene.canvas);
    handler.setInputAction(function(movement) {
        // get an array of all primitives at the mouse position
        var pickedObjects = scene.drillPick(movement.endPosition);
        if (Cesium.defined(pickedObjects)) {
            //Update the collection of picked entities.
            pickedEntities.removeAll();
            for (var i = 0; i < pickedObjects.length; ++i) {
                var entity = pickedObjects[i].id;
                pickedEntities.add(entity);
                 var cartesian = viewer.camera.pickEllipsoid(movement.endPosition, ellipsoid);
          if (cartesian) {
            var cartographic = ellipsoid.cartesianToCartographic(cartesian);
            var longitudeString = Cesium.Math.toDegrees(cartographic.longitude).toFixed(2);
            var latitudeString = Cesium.Math.toDegrees(cartographic.latitude).toFixed(2);

            entity.position = cartesian;
            entity.label.show = true;
            entity.label.text = '(' + longitudeString + ', ' + latitudeString + ')';
        } else {
            entity.label.show = false;
        }
                
            }
        }

       //-------------------------------------------------------
         


      ///----------------------------------------------------------

    }, Cesium.ScreenSpaceEventType.MOUSE_MOVE);


// Mouse over the globe to see the cartographic position
   /* var ellipsoid = scene.globe.ellipsoid;
     var entity = viewer.entities.add({
        label : {
            show : false
        }
    });
    var handler2 = new Cesium.ScreenSpaceEventHandler(scene.canvas);
    handler2.setInputAction(function(movement) {
        var cartesian = viewer.camera.pickEllipsoid(movement.endPosition, ellipsoid);
        if (cartesian) {
            var cartographic = ellipsoid.cartesianToCartographic(cartesian);
            var longitudeString = Cesium.Math.toDegrees(cartographic.longitude).toFixed(2);
            var latitudeString = Cesium.Math.toDegrees(cartographic.latitude).toFixed(2);

            entity.position = cartesian;
            entity.label.show = true;
            entity.label.text = '(' + longitudeString + ', ' + latitudeString + ')';
        } else {
            entity.label.show = false;
        }
    }, Cesium.ScreenSpaceEventType.MOUSE_MOVE);
});*/















var countries = Cesium.GeoJsonDataSource.load('http://localhost/gaia/assets/data/geojson/countries.geo.json');
var entities = countries.values;


countries.then(function(dataSource) {
       // viewer.dataSources.add(dataSource);

        //Get the array of entities
        var entities = dataSource.entities.values;
        
        var colorHash = {};
        for (var i = 0; i < entities.length; i++) {
            var entity = entities[i];
            var name = entity.name;
            
            /*var color = colorHash[name];
            if (!color) {
                color = Cesium.Color.fromRandom({
                    alpha : 1.0
                });
                colorHash[name] = color;
            }*/
            var color = Cesium.Color.GRAY;
            entity.polygon.material = color;
            
            //Outline each polygon in black.
            entity.polygon.outlineColor = Cesium.Color.BLACK;
            entity.label = new Cesium.LabelGraphics({
                           text: name,
                           scale: 2,
                           show:true
           });
           entity.show = true;
           makeProperty(entity,color);
           entity.label.text = entity.name;
           entity.label.show = true;
           viewer.entities.add(entity);
           entity.description = '<iframe class= "frame" id="frame" src="http://en.wikipedia.org/wiki/'+name+'"></iframe>';












 }
    }).otherwise(function(error){
        //Display any errrors encountered while loading.
        window.alert(error);
    });
    
   /* var scene = viewer.scene;
   var handler;


   var ellipsoid = scene.globe.ellipsoid;
    var entity = viewer.entities.add({
        label : {
            show : false
        }
    });

    // Mouse over the globe to see the cartographic position
   handler = new Cesium.ScreenSpaceEventHandler(scene.canvas);
    handler.setInputAction(function(movement) {
        var cartesian = viewer.camera.pickEllipsoid(movement.endPosition, ellipsoid);
        if (cartesian) {
            var cartographic = ellipsoid.cartesianToCartographic(cartesian);
            var longitudeString = Cesium.Math.toDegrees(cartographic.longitude).toFixed(2);
            var latitudeString = Cesium.Math.toDegrees(cartographic.latitude).toFixed(2);

            entity.position = cartesian;
            entity.label.show = true;
            entity.label.text = '(' + longitudeString + ', ' + latitudeString + ')';
        } else {
            entity.label.show = false;
        }
    }, Cesium.ScreenSpaceEventType.MOUSE_MOVE);

viewer.zoomTo(viewer.entities);

handler = new Cesium.ScreenSpaceEventHandler(scene.canvas);
    handler.setInputAction(function(movement) {
        var pickedObject = scene.pick(movement.endPosition);
        if (Cesium.defined(pickedObject) && (pickedObject.id === entity)) {
            //entity.polygon.scale = 2.0;
            entity.polygon.material = Cesium.Color.YELLOW;
        } else {
            //entity.polygon.scale = 1.0;
            entity.polygon.material = Cesium.Color.WHITE;
        }
    }, Cesium.ScreenSpaceEventType.MOUSE_MOVE);


*/
   
