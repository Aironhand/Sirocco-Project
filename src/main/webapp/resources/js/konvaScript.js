function writeMessage(message) {
      text.setText(message);
      layer.draw();
    }
	var mapScale = 0.3;
    var width = 715;
    var height = 400;

	
	
    var stage = new Konva.Stage({
        container: 'phys-map',
        width: width,
        height: height
    });
	
	 var text = new Konva.Text({
      x: 70,
      y: 10,
      fontFamily: 'Calibri',
      fontSize: 24,
      text: '',
      fill: 'black'
    });

	var layer = new Konva.Layer();
	
	  var layer2 = new Konva.Layer({
		x:50,
		y:5,
        draggable: true
	  });
    var rectX = stage.getWidth() / 2 - 50;
    var rectY = stage.getHeight() / 2 - 25;

	var imageObj = new Image();
    imageObj.onload = function() {

      var yoda = new Konva.Image({
        x: 50,
        y: 50,
        image: imageObj,
        width: 2000,
        height: 1119,
		name:'map'
      });
	  
	    layer2.add(yoda);
		
	 var coords = [ 
		{'x':'320','y':'75','w':'130','h':'70'}, 
		{'x':'450','y':'75','w':'190','h':'70'}, 
		{'x':'320','y':'140','w':'320','h':'365'},
		{'x':'320','y':'505','w':'100','h':'110'},
		{'x':'420','y':'505','w':'120','h':'60'},
		{'x':'540','y':'505','w':'100','h':'60'},
		];
	 
	  for(var i = 0; i < coords.length; i++) { 
		//alert(coords[i].x+" "+coords[i].y+" "+coords[i].w+" "+coords[i].h);
	   var box2 = new Konva.Rect({
        x: coords[i].x,
        y: coords[i].y,
        width: coords[i].w,
        height: coords[i].h,
        //fill: '#00D2FF',
        //stroke: 'black',
        strokeWidth: 4,
		name:'name'+i
    });	
	  
	
	layer2.add(box2);
	}
	
	$(document).ready(function(){
		layer2.scale({ x :mapScale, y : mapScale});
		layer2.draw();
	});
	
	$("#scale").change(function(){
		mapScale = $(this).val();
		layer2.scale({ x :mapScale, y : mapScale});
		layer2.draw();
	});

		   layer2.on('mouseover', function(evt) {
      var shape = evt.target;
	if (shape.getName()!='map')
	  shape.setAttrs({
			fill: '#00D2FF'
		});
		layer2.draw();
      writeMessage('Mouseover on '+shape.getName());

    });
	
	  layer2.on('mouseout', function(evt) {
      var shape = evt.target;
	  shape.setAttrs({
			fill: ''
		});
		layer2.draw();
    });	  
      stage.add(layer2);
	}
	 imageObj.src = '/resources/img/map.png';
 

    // add cursor styling
    layer2.on('mouseover', function() {
        document.body.style.cursor = 'pointer';
    });
    layer2.on('mouseout', function() {
        document.body.style.cursor = 'default';
    });

	layer.add(text);
    stage.add(layer);
