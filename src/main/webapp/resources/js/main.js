	function isInTriangle(x1,y1,x2,y2,x3,y3,x0,y0){
				var test1 = (x1 - x0) * (y2 - y1) - (x2 - x1) * (y1 - y0);
				var test2 = (x2 - x0) * (y3 - y2) - (x3 - x2) * (y2 - y0);	
				var test3 = (x3 - x0) * (y1 - y3) - (x1 - x3) * (y3 - y0);
				
				if (test1>0&&test2>0&&test3>0)
					return true;
					
				if (test1<0&&test2<0&&test3<0)
					return true;
					
				if (test1==0||test2==0||test3==0)
					return true;
				if (test1<0||test2<0||test3<0)
					return false;
			}
			
	function sliderJS (obj, sl) { // slider function
		 var ul = $(sl).find("ul"); // находим блок
		 var bl = $(sl).find("li.slider"+obj); // находим любой из элементов блока
		 var step = $(bl).width(); // ширина объекта
		 $(ul).animate({marginLeft: "-"+step*obj}, 500); // 500 это скорость перемотки
	}
		
		
			$(window).load(function() {
				$('#featured').orbit({
					'bullets': true,
					'timer' : true,
					'animation' : 'horizontal-slide'
				});
					
				
				$('.bbtn').mousemove(function(e){
					var pos = $(this).offset();
					var elem_left = pos.left;
					var elem_top = pos.top;
					// положение курсора внутри элемента
					var Xinner = e.pageX - elem_left;
					var Yinner = e.pageY - elem_top;
					//top
					if (isInTriangle(0,0,200,0,100,100,Xinner,Yinner)!=false) 
						 $(this).removeClass("rotateRight")
								.removeClass("rotateLeft")
								.removeClass("rotateBottom")
							    .addClass("rotateTop");
					
					
					if (isInTriangle(0,0,0,200,100,100,Xinner,Yinner)!=false) 
						 $(this).removeClass("rotateRight")
								.removeClass("rotateTop")
								.removeClass("rotateBottom")
							    .addClass("rotateLeft");
				
				//right
					if (isInTriangle(200,0,200,200,100,100,Xinner,Yinner)!=false) 
						 $(this).removeClass("rotateLeft")
								.removeClass("rotateTop")
								.removeClass("rotateBottom")
							    .addClass("rotateRight");
							
					if (isInTriangle(0,200,100,100,200,200,Xinner,Yinner)!=false) 
						 $(this).removeClass("rotateLeft")
								.removeClass("rotateTop")
								.removeClass("rotateRight")
							    .addClass("rotateBottom");
					//$('.header').html("x="+Xinner+" y="+Yinner);
					
				});
				
				$('.bbtn').mouseleave(function(e){
					$(this).removeClass("rotateRight")
							   .removeClass("rotateTop")
							   .removeClass("rotateBottom")
							   .removeClass("rotateLeft");
				});
				
				
				$('.bbtn-social').mousemove(function(e){
					var pos = $(this).offset();
					var elem_left = pos.left;
					var elem_top = pos.top;
					// положение курсора внутри элемента
					var Xinner = e.pageX - elem_left;
					var Yinner = e.pageY - elem_top;
					//top
					if (isInTriangle(0,0,100,0,50,50,Xinner,Yinner)!=false) 
						 $(this).removeClass("rotateRight")
								.removeClass("rotateLeft")
								.removeClass("rotateBottom")
							    .addClass("rotateTop");
					
					
					if (isInTriangle(0,0,0,100,50,50,Xinner,Yinner)!=false) 
						 $(this).removeClass("rotateRight")
								.removeClass("rotateTop")
								.removeClass("rotateBottom")
							    .addClass("rotateLeft");
				
				//right
					if (isInTriangle(100,0,100,100,50,50,Xinner,Yinner)!=false) 
						 $(this).removeClass("rotateLeft")
								.removeClass("rotateTop")
								.removeClass("rotateBottom")
							    .addClass("rotateRight");
							
					if (isInTriangle(0,100,50,50,100,100,Xinner,Yinner)!=false) 
						 $(this).removeClass("rotateLeft")
								.removeClass("rotateTop")
								.removeClass("rotateRight")
							    .addClass("rotateBottom");
					//$('.header').html("x="+Xinner+" y="+Yinner);
					
				});
				
				$('.bbtn-social').mouseleave(function(e){
					$(this).removeClass("rotateRight")
							   .removeClass("rotateTop")
							   .removeClass("rotateBottom")
							   .removeClass("rotateLeft");
				});
								
				

			});
			
			
			$(document).ready(function() {
			 $(".slider").each(function () { // обрабатываем каждый слайдер

			  var obj = $(this);
			  $(obj).append("<div class='nav'></div>");
			  $(obj).find("li").each(function () {
			   $(obj).find(".nav").append("<span rel='"+$(this).index()+"'></span>"); // добавляем блок навигации
			   $(this).addClass("slider"+$(this).index());
			  });
			  $(obj).find("span").first().addClass("on"); // делаем активным первый элемент меню
			 });
			 
	
			
		$(".slider .nav span").click(function() { // slider click navigate
			var sl = $(this).closest(".slider"); // находим, в каком блоке был клик
			 $(sl).find("span").removeClass("on"); // убираем активный элемент
			 $(this).addClass("on"); // делаем активным текущий
			 var obj = $(this).attr("rel"); // узнаем его номер
			 sliderJS(obj, sl); // слайдим
			 return false;
		});
		
		$('.photo-btn').click(function(){
			 $('.show-modal').arcticmodal();
		});
	
});