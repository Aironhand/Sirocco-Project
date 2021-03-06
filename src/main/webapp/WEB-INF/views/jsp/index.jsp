<%-- 
    Document   : index
    Created on : 25.11.2015, 11:40:23
    Author     : Aironhand
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8" />
	<!--[if lt IE 9]><script src="http://html5shiv.googlecode.com/svn/trunk/html5.js"></script><![endif]-->
	<title>Кафедра Компьютерных технологий</title>
	<meta name="keywords" content="" />
	<meta name="description" content="" />
	<!-- <link href='https://fonts.googleapis.com/css?family=Marmelad&subset=latinc,cyrillic;' rel='stylesheet' type='text/css'>
	<link href='https://fonts.googleapis.com/css?family=Didact+Gothic&subset=latin,cyrillic;' rel='stylesheet' type='text/css'> -->
	<link rel="stylesheet" href="http://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.4.0/css/font-awesome.min.css"/>
	<link rel="stylesheet" type="text/css" href="@{/resources/css/orbit.css}"/>
        
        <link href="<c:url value="/resources/css/style.css"/>" rel="stylesheet">
       	<script type="text/javascript" src="js/jquery-1.4.1.min.js"></script>
	<script type="text/javascript" src="js/jquery.orbit.js"></script>
	<script src="https://cdn.rawgit.com/konvajs/konva/0.10.0/konva.min.js"></script>
	<script type="text/javascript" src="js/main.js"></script>

<!-- arcticModal -->
<script src="arcticmodal/jquery.arcticmodal-0.3.min.js"></script>
<link rel="stylesheet" href="arcticmodal/jquery.arcticmodal-0.3.css"/>

<!-- arcticModal theme -->
<link rel="stylesheet" href="arcticmodal/themes/simple.css" />
</head>
<script>
	$(document).ready(function(){
	
		$(".toAnchHead").click(function(){		
			$('html,body').animate({
			   scrollTop: 0}, 2000);
			return false; 
		});
		$('anchLink.a[href^="#"]').click(function(){
			var el = $(this).attr('href');
			var elName = el.substr(1,el.length);
			$('html,body').animate({
			   scrollTop: $("[name='"+elName+"'").offset().top}, 2000);
			return false; 
		});
		$(".mnClose").click(function(){
			$(".info-block").addClass("hideNews");
			
		});
		
		$(".bbtn").click(function(){
			$("body,html").animate({
			   scrollTop:$("body,html").scrollTop()+1900}, 2000);
			
			$(".info-block").removeClass("hideNews");
					
		});
		
		$(".bb1").click(function(){
			$(".info-content").css({"display":"none"});
			$(".about-cathedra").css({"display":"block"});
			
			$(".control-btn").each(function(arg1,arg2){
				$(this).removeClass("control-btn-active");
			});
			$(".mn1").addClass("control-btn-active");
			
		});
		
		
		$(".bb2").click(function(){
			$(".info-content").css({"display":"none"});
			$(".teachers").css({"display":"block"});
			
			$(".control-btn").each(function(arg1,arg2){
				$(this).removeClass("control-btn-active");
			});
			$(".mn2").addClass("control-btn-active");
			
		});
		
		$(".bb3").click(function(){
			$(".info-content").css({"display":"none"});
			$(".abiturient").css({"display":"block"});
			
			$(".control-btn").each(function(arg1,arg2){
				$(this).removeClass("control-btn-active");
			});
			$(".mn3").addClass("control-btn-active");
			
		});
		
		$(".bb4").click(function(){
			$(".info-content").css({"display":"none"});
			$(".student").css({"display":"block"});
			
			$(".control-btn").each(function(arg1,arg2){
				$(this).removeClass("control-btn-active");
			});
			$(".mn4").addClass("control-btn-active");
			
		});
		
		$(".bb5").click(function(){
			$(".info-content").css({"display":"none"});
			$(".sciens").css({"display":"block"});
			
			$(".control-btn").each(function(arg1,arg2){
				$(this).removeClass("control-btn-active");
			});
			$(".mn5").addClass("control-btn-active");
			
		});
		
		$(".np1").click(function(){
			$(".teachers").css({"display":"block"});
			$(this).css({"display":"none"});
			$(".control-btn").each(function(arg1,arg2){
				$(this).removeClass("control-btn-active");
			});
			$(".mn2").addClass("control-btn-active");
			$(".info-section").animate({
			   scrollTop:$(".info-section").scrollTop()+595}, 2000);
		});
		
		
		$(".np2").click(function(){
			$(".abiturient").css({"display":"block"});
			$(this).css({"display":"none"});
			$(".control-btn").each(function(arg1,arg2){
				$(this).removeClass("control-btn-active");
			});
			$(".mn3").addClass("control-btn-active");
			$(".info-section").animate({
			   scrollTop:$(".info-section").scrollTop()+595}, 2000);
		});
		
		$(".np3").click(function(){
			$(".student").css({"display":"block"});
			$(this).css({"display":"none"});
			$(".control-btn").each(function(arg1,arg2){
				$(this).removeClass("control-btn-active");
			});
			$(".mn4").addClass("control-btn-active");
			$(".info-section").animate({
			   scrollTop:$(".info-section").scrollTop()+595}, 2000);
		});
		
		$(".np4").click(function(){
			$(".sciens").css({"display":"block"});
			$(this).css({"display":"none"});
			$(".control-btn").each(function(arg1,arg2){
				$(this).removeClass("control-btn-active");
			});
			$(".mn5").addClass("control-btn-active");
			$(".info-section").animate({
			   scrollTop:$(".info-section").scrollTop()+595}, 2000);
		});
		
		$(".mn1").click(function(){
			$(".info-content").css({"display":"none"});
			$(".next-part").css({"display":"block"});
			$(".about-cathedra").css({"display":"block"});
			$(".control-btn").each(function(arg1,arg2){
				$(this).removeClass("control-btn-active");
			});
			$(this).addClass("control-btn-active");
			$(".info-section").animate({
			   scrollTop:0}, 1000);
		});
		
		$(".mn2").click(function(){
			$(".info-content").css({"display":"none"});
			$(".next-part").css({"display":"block"});
			$(".teachers").css({"display":"block"});
				$(".control-btn").each(function(arg1,arg2){
				$(this).removeClass("control-btn-active");
			});
			$(this).addClass("control-btn-active");
			$(".info-section").animate({
			   scrollTop:0}, 1000);
		});
		
		$(".mn3").click(function(){
			$(".info-content").css({"display":"none"});
			$(".next-part").css({"display":"block"});
			$(".abiturient").css({"display":"block"});
				$(".control-btn").each(function(arg1,arg2){
				$(this).removeClass("control-btn-active");
			});
			$(this).addClass("control-btn-active");
			$(".info-section").animate({
			   scrollTop:0}, 1000);
		});
		
		$(".mn4").click(function(){
			$(".info-content").css({"display":"none"});
			$(".next-part").css({"display":"block"});
			$(".student").css({"display":"block"});
				$(".control-btn").each(function(arg1,arg2){
				$(this).removeClass("control-btn-active");
			});
			$(this).addClass("control-btn-active");
			$(".info-section").animate({
			   scrollTop:0}, 1000);
		});
		
		$(".mn5").click(function(){
			$(".info-content").css({"display":"none"});
			$(".next-part").css({"display":"block"});
			$(".sciens").css({"display":"block"});
				$(".control-btn").each(function(arg1,arg2){
				$(this).removeClass("control-btn-active");
			});
			$(this).addClass("control-btn-active");
			$(".info-section").animate({
			   scrollTop:0}, 1000);
		});
	});
</script>
<body>

<div class="wrapper" name="anchHead">
	
	<header class="header">
		<div class="logo"></div>
		<h1>КОМПЬЮТЕРНЫЕ ТЕХНОЛОГИИ</h1>
		<h2>ФИЗИКО-ТЕХНИЧЕСКИЙ ФАКУЛЬТЕТ</h2>
		<nav>
			<ul>
				<li class="active"><i class="fa fa-home"></i><a href="#">На главную</a></li>
				<li><i class="fa fa-bank"></i><a href="#">О ДонНУ</a></li>
				<li><i class="fa fa-group"></i><a href="#">Поступление</a></li>
				<li><i class="fa fa-graduation-cap"></i><a href="#">Учеба</a></li>
				<li><i class="fa fa-cloud"></i><a href="#">Библиотека</a></li>
				<li><i class="fa fa-globe"></i><a href="#">Международная деятельность</a></li>
				<li><i class="fa fa-area-chart"></i><a href="#">Карьера</a></li>
				<li><i class="fa fa-building"></i><a href="#">Студ городок</a></li>
				<li><i class="fa fa-gamepad"></i><a href="#">Досуг</a></li>
				<input type="text" placeholder="Search..."/>
			</ul>			
		</nav>
	</header><!-- .header-->
	<div class="first-large-section">
		<section class="slides">
			<div id="featured"> 
				<img src="link.jpg" alt="Link" rel="physCaption" />
				<img src="link.jpg" alt="Link" />
				<a href="http://www.zurb.com/playground" target="_blank"><img src="ezio.jpg" alt="Ezio" rel="ezioCaption" /></a>
				<img src="masterchief.jpg" alt="Master Chief" />
				<img src="marcusfenix.jpg"  alt="Marcus Fenix" />
			</div> 
			<span class="orbit-caption" id="ezioCaption">Минифутбол: ДонНУ (физтех) - ДонНТУ, 2015</span>
			<span class="orbit-caption" id="physCaption">Сегодня физтех самый красивый )</span>
		</section>
		
		<section class="main">
			<!-- start left part -->
			<div class="news">
				<!-- start news-post -->
				<div class="news-post">
					<div class="nhead">
						<h1>holiday impression</h1>
						<h4>Written by <a href="#">admin</a>. Posted in <a href="#">Uncategorized</a></h4>
					</div>				
					<div class="nbody">
						<img src="http://donnu.ru/facult/phys/kt/img/logo.png" alt="*"/>
						<p>Lorem Ipsum - это текст-"рыба", часто используемый в печати и вэб-дизайне. Lorem Ipsum является стандартной "рыбой" для текстов на латинице с начала XVI века. В то время некий безымянный печатник создал большую коллекцию размеров и форм шрифтов, используя Lorem Ipsum для распечатки образцов. Lorem Ipsum не только успешно пережил без заметных изменений пять веков, но и перешагнул в электронный дизайн. Его популяризации в новое время послужили публикация листов Letraset с образцами Lorem Ipsum в 60-х годах и, в более недавнее время, программы электронной вёрстки типа Aldus PageMaker, в шаблонах которых используется Lorem Ipsum.</p>
					</div>
					<div class="nfooter">
						<div><i class="fa fa-share-square-o"></i></div>
						<div><i class="fa fa-comment"></i></div>
					</div>
					<div class="ndate">
						<p>19</p>
						<p>apr</p>
						<p>2015</p>
					</div>
				</div>
				<!-- end news-post -->
				
				<!-- start news-post -->
				<div class="news-post">
					<div class="nhead">
						<h1>holiday impression</h1>
						<h4>Written by <a href="#">admin</a>. Posted in <a href="#">Uncategorized</a></h4>
					</div>				
					<div class="nbody">
						<img src="http://donnu.ru/facult/phys/kt/img/logo.png" alt="*"/>
						<p>Lorem Ipsum - это текст-"рыба", часто используемый в печати и вэб-дизайне. Lorem Ipsum является стандартной "рыбой" для текстов на латинице с начала XVI века. В то время некий безымянный печатник создал большую коллекцию размеров и форм шрифтов, используя Lorem Ipsum для распечатки образцов. Lorem Ipsum не только успешно пережил без заметных изменений пять веков, но и перешагнул в электронный дизайн. Его популяризации в новое время послужили публикация листов Letraset с образцами Lorem Ipsum в 60-х годах и, в более недавнее время, программы электронной вёрстки типа Aldus PageMaker, в шаблонах которых используется Lorem Ipsum.</p>
					</div>
					<div class="nfooter">
						<div><i class="fa fa-share-square-o"></i></div>
						<div><i class="fa fa-comment"></i></div>
					</div>
					<div class="ndate">
						<p>19</p>
						<p>apr</p>
						<p>2015</p>
					</div>
				</div>	
				<!-- end news-post -->	
					
				<!-- start news-post -->
				<div class="news-post">
					<div class="nhead">
						<h1>holiday impression</h1>
						<h4>Written by <a href="#">admin</a>. Posted in <a href="#">Uncategorized</a></h4>
					</div>				
					<div class="nbody">
						<img src="http://donnu.ru/facult/phys/kt/img/logo.png" alt="*"/>
						<p>Lorem Ipsum - это текст-"рыба", часто используемый в печати и вэб-дизайне. Lorem Ipsum является стандартной "рыбой" для текстов на латинице с начала XVI века. В то время некий безымянный печатник создал большую коллекцию размеров и форм шрифтов, используя Lorem Ipsum для распечатки образцов. Lorem Ipsum не только успешно пережил без заметных изменений пять веков, но и перешагнул в электронный дизайн. Его популяризации в новое время послужили публикация листов Letraset с образцами Lorem Ipsum в 60-х годах и, в более недавнее время, программы электронной вёрстки типа Aldus PageMaker, в шаблонах которых используется Lorem Ipsum.</p>
					</div>
					<div class="nfooter">
						<div><i class="fa fa-share-square-o"></i></div>
						<div><i class="fa fa-comment"></i></div>
					</div>
					<div class="ndate">
						<p>19</p>
						<p>apr</p>
						<p>2015</p>
					</div>
				</div>	
				<!-- end news-post -->	
				<div class="news-pager">
					<ul>
						<li class="active"><a href="#">1</a></li>
						<li><a href="#">2</a></li>
						<li><a href="#">3</a></li>
						<li><a href="#">4</a></li>
						<li><a href="#">End</a></li>

					</ul>
				</div>
				<div class="lessons-block">
					<h2><i class="fa fa-bell-o"></i></h2>
					<h1 week="Нижняя неделя" date="02.12.2015">Расписание</h1>
					<hr>
					<div class="left">
						<input type="text" name="search" value="" placeholder="Search field..."/>
						<select class="course">
							<option value="1">1 курс</option>
							<option value="2">2 курс</option>
							<option value="3">3 курс</option>
							<option value="4">4 курс</option>
							<option value="5">5 курс</option>
							<option value="6">6 курс</option>
						</select>
						
						<select class="group">
							<option value="gr1">КН-1</option>
							<option value="gr2">КН-2</option>
							<option value="gr3">КН-3</option>
							<option value="gr4">КН-4</option>
							<option value="gr5">КН-5</option>
							<option value="gr6">КЕЭМ</option>
						</select>
						
						<select class="days">
							<option value=" week">Неделя</option>
							<option value="mn">ПН</option>
							<option value="th">ВТ</option>
							<option value="wd">СР</option>
							<option value="ts">ЧТ</option>
							<option value="fr">ПТ</option>
						</select>
						<a class="download" href="">Скачать расписание</a>
					</div>
					<a class="abtn"><i class="fa fa-search"></i></a>		
					<a class="abtn"><i class="fa fa-calendar"></i></a>
                                        </hr>
				</div>
			</div>	
			<!-- end left part -->
			
			<!-- start right part -->
			<div class="buttons">
				
				<div class="bbtn bbtn-blue bb1">
					<i class="fa fa-television"></i>
					<p>О кафедре</p>	
				</div>
				
				<div class="bbtn bbtn-red bb2">
					<i class="fa fa-group"></i>
					<p>Преподавательский состав</p>	
				</div>
				
				<div class="bbtn bbtn-green bb3">
					<i class="fa fa-adn"></i>
					<p>Абитуриенту</p>	
				</div>
				
				<div class="bbtn bbtn-violet bb4">
					<i class="fa fa-android"></i>
					<p>Студенту</p>	
				</div>
				
				<div class="bbtn bbtn-orange bb5">
					<i class="fa fa-graduation-cap"></i>
					<p>Наука</p>	
				</div>
				
				<div class="bbtn-group">
					<a href="https://vk.com/fcl_phys_kkt" target="_blank">
						<div class="bbtn-social bbtn-green ">
							<i class="fa fa-vk"></i>
							<p>ВКОНТАКТЕ</p>	
						</div>
					</a>
					
					<a href="https://vk.com/fcl_phys_kkt" target="_blank">
						<div class="bbtn-social bbtn-red ">
							<i class="fa fa-facebook-official"></i>
							<p>Facebook</p>	
						</div>
					</a>
					
					<a href="https://www.youtube.com/channel/UCD4k-g0KwEdgOYp57y4u8aQ" target="_blank">
						<div class="bbtn-social bbtn-blue2 ">
							<i class="fa fa-youtube"></i>
							<p>YouTube</p>	
						</div>
					</a>
				</div>
				
				<div class="bmap">
					<iframe src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d1334.7145540423978!2d37.79815123677962!3d48.00541905440738!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x40e0905cf3131e5b%3A0xccbbd971aa07d886!2z0KPQvdGW0LLQtdGA0YHQuNGC0LXRgtGB0YzQutCwINCy0YPQuy4sIDI0LCDQlNC-0L3QtdGG0YzQuiwg0JTQvtC90LXRhtGM0LrQsCDQvtCx0LvQsNGB0YLRjA!5e0!3m2!1sru!2sua!4v1421785207719"  frameborder="0" style="border:0"></iframe>
				</div>				
		
				<div class="callback">
					<form action="sendmail.php" method="post">
						<input type="text" name="name" placeholder="Ф.И.О."/>
						<input type="email" name="email" placeholder="Почта"/>
						<textarea placeholder="Сообщение"></textarea>
						<a href="tel:+380623020701" class="phone">+38 (062) 302-07-01</a>
						<a href="" class="send"><i class="fa fa-envelope"></i></a>
					</form>
				</div>
				
			</div>
			<!-- end right part -->
			<div class="info-block hideNews">
				<div class="info-section">
					<div class="info-content about-cathedra">
						<div class="top-title">
							<div class="larg-icon">
								<i class="fa fa-television"></i>
							</div>
							<h1>О Кафедре</h1>
						</div>
						
						<p><b>И. о. заведующего кафедрой:</b> доктор физ.-мат. наук, профессор <a href="">Виктор Константинович Толстых</a> , комната 404. </p>
						<p><b>Заместитель заведующего кафедрой:</b> канд. техн. наук, <a href="">Тимофей Вячеславович Шарий</a> , комната 414.</p>
						<p><b> Методист кафедры:</b> <a href="">Валентина Борисовна Мирющенко</a> , комната 401.</p>
						<p class="p1">
							 Кафедра создана в 1973 году. Сегодня кафедра осуществляет подготовку  по стандартам Российской федерации бакалавров и магистров. <a href="">Профессорско-преподавательский состав кафедры</a> – это высоко квалифицированные специалисты, учёные и педагоги, а также наши лучшие молодые выпускники.
						</p>
						<p class="p1">
							Научные исследования кафедры нацелены на математическое, компьютерное моделирование, автоматизированное управление, идентификацию и оптимизацию различных систем и процессов. На развитие и использование интеллектуальных алгоритмов в управлении. Ведутся исследования и разработки в области <a href="">электронного города и правительства</a>.
						</p>
						
						<p class="p1">
							Кафедра имеет большой собственный парк персональных компьютеров, размещённых в специализированных лабораториях:
						</p>
						
						<ol>
							<li>Компьютерного дизайна и интеллектуальных машин</li>
							<li>Компьютерные сети, Интернет и Интранет </li>
							<li>Лаборатория программного обеспечения систем искусственного интеллекта</li>
							<li>Специального программного обеспечения</li>
							<li>Программного обеспечения общего назначения</li>
							<li>Компьютерные сети и системное администрирование</li>
						</ol>
						<p class="p1">
							Учебные аудитории, среди которых есть и большая наклонная аудитория компьютерных наук (фото), оснащены современными техническими средствами обучения. Везде имеется свободный доступ к Интернет. Для самостоятельной подготовки студентов и оперативных консультаций с преподавателями предлагаются различные формы <a href="">дистанционных консультаций</a> и обучения.
						</p>
						<p class="p1">
							Кафедра осуществляет научное руководство информационными технологиями университета, управляет компьютерными сетями, <a href="">сайтом</a> и корпоративными серверами университета. Организует практики студентов в ведущих информационно-коммуникационных компаниях и предприятиях региона.
						</p>
						<p class="p1">
							Студенты кафедры занимают призовые места в олимпиадах разного профиля и уровня, так в 2011 году команда Донецкого национального университета, в составе которой были студенты кафедры под руководством тренера (доцента кафедры Парамонова А.И.), стала <a href="">серебряным призёром чемпионата мира по спортивному программированию</a>.
						</p>
						<p class="p1">
							Все выпускники кафедры трудоустроены по специальности и занимают ответственные должности от программистов и системных администраторов небольших фирм до руководителей крупных проектов и главных администраторов.
						</p> 
						<p class="p1">
							Кафедра предоставляет дополнительную услугу – подготовку специалистов по заказу фирмы с последующим распределением на условиях договора. 
						</p>
						<div class="next-part np1">Следующий раздел</div>
					</div>
					
					<div class="info-content teachers">
						
						<div class="top-title">
							<div class="larg-icon">
								<i class="fa fa-group"></i>
							</div>
							<h1>ПРОФЕССОРСКО-ПРЕПОДАВАТЕЛЬСКИЙ СОСТАВ КАФЕДРЫ</h1>
						</div>
						
						<p class="p1">						
							• доктор физ.-мат. наук, профессор<a href="">Толстых Виктор Константинович</a>, комната 404,<br/>
							<i class="i">(<b>специализация:</b>: Интернет-технологии на основе интеллектуальных технологий, баз знаний, сервис-ориетированных архитектур; автоматизация, оптимизация и идентификация сложных процессов и систем)</i>
						</p>
					
						
						<p class="p1">	
						 •  канд. техн. наук, <a href="">Шарий Тимофей Вячеславович</a>, комната 414,<br/>
							<i class="i">(<b>специализация:</b>: Цифровая обработка сигналов, работа с мультимедийными данными (звук, изображения, видео); искусственный интеллект (машинное обучение, интеллектуальный анализ данных, нечеткая логика))</i>
						</p>
						
						<p class="p1">	
							•  канд. физ.-мат. наук, доцент <a href="">Володин Николай Александрович</a>, комната 414,<br/>
							<i class="i">(<b>специализация:</b>: )</i>
						</p>
					

						<p class="p1">	
							•  канд. техн. наук, доцент <a href="">Ермоленко Татьяна Владимировна</a>, комната 407,<br/>
							<i class="i">(<b>специализация:</b>: )</i>
						</p>
					

						<p class="p1">	
							•  канд. физ.-мат. наук, доцент <a href="">Курганский Алексей Николаевич</a>, комната 407,<br/>
							<i class="i">(<b>специализация:</b>: )</i>
						</p>
					

						<p class="p1">	
							•  канд. физ.-мат. наук, доцент <a href="">Иванова  Анна Александровна</a> , комната 407,<br/>
							<i class="i">(<b>специализация:</b>: )</i>
						</p>
					

						<p class="p1">	
							•  ст. преп. <a href="">Бодряга Виктор Викторович</a>, комната 411,<br/>
							<i class="i">(<b>специализация:</b>: )</i>
						</p>
					

						<p class="p1">	
							•  ст. преп. <a href="">Бондаренко Виталий Иванович</a>, комната 231,<br/>
							<i class="i">(<b>специализация:</b>: )</i>
						</p>
					
	
						<p class="p1">	
							•  ст. преп. <a href="">Гукай Алексей Евгеньевич</a>, комната 406,<br/>
							<i class="i">(<b>специализация:</b>: )</i>
						</p>
					

						<p class="p1">	
							•  ст. преп. <a href="">Кожемякин Юрий Алексеевич</a>, комната 406,<br/>
							<i class="i">(<b>специализация:</b>: )</i>
						</p>
					
						<p class="p1">	
							•  ст. преп.<a href="">Котенко Владислав Николаевич</a>, комната 420,<br/>
							<i class="i">(<b>специализация:</b>: )</i>
						</p>
					

						<p class="p1">	
							•  ст. преп. <a href="">Колесник Анатолий Васильевич</a>, комната 414,<br/>					
							<i class="i">(<b>специализация:</b>: Разработка android приложений)</i>
						</p>
					
						<p class="p1">							
							•  ст. преп. <a href="">Ломонос Геннадий Трофимович</a>, комната 409а,<br/>
							<i class="i">(<b>специализация:</b>: )</i>
						</p>
					

						<p class="p1">	
							•  зав. лаб, ст. преп. <a href="">Бодряга Вероника Евгеньевна</a>, комната 407,<br/>
							<i class="i">(<b>специализация:</b>: )</i>
						</p>
					
						<p class="p1">	
							•  зав. лаб, ст. преп. <a href="">Котова Ольга Васильевна</a>, комната 405,<br/>
							<i class="i">(<b>специализация:</b>: )</i>
						</p>
					

						<p class="p1">	
							•  зав. лаб, ст. преп. <a href="">Мартыненко Анастасия Михайловна</a>, комната 406,<br/>
							<i class="i">(<b>специализация:</b> )</i>
						</p>
					
						<div class="next-part np2">Следующий раздел</div>
					</div>
					
						<div class="info-content abiturient">
							<div class="top-title">
								<div class="larg-icon">
									<i class="fa fa-adn"></i>
								</div>
								<h1>Абитуриенту</h1>
							</div>
						<p><b>Кого готовит кафедра?</b></p>
						<br/>
						<p class="p1">
							Кафедра готовит бакалавров и магистров в соответствие стандартам Российской федерации по направлению «Информатика и вычислительная техника». Шифр направления бакалавриата – 09.03.01, а магистратуры – 09.04.01.
						</p>
						<br/>
						<br/>
						<p class="p1">
							<i class="i">
								БАКАЛАВР — академическая степень или квалификация. Завершённое высшее образование в странах, которые участвуют в Болонском процессе. Обучение — 4 года. На последнем курсе студенты специализируются по предлагаемым кафедрой различным профилям (программам) углублённого специального образования.
							</i>
						</p>
						<p class="p1">
							<i class="i">
								Диплом бакалавра при поступлении на работу:
								</i>
						</p>
						
						<ol>
							<li><i class="i">даёт право на занятие должности, для которой квалификационными требованиями предусмотрено высшее образование;</i></li>
							<li><i class="i">даёт право продолжить обучение в магистратуре;</i></li>
							<li><i class="i">является документом, которым подтверждается завершение высшего профессионального образования.</i></li>
						</ol>
						
						<p class="p1">
							<i class="i">
								Посмотрите виды профессиональной деятельности, к которым готовятся выпускники нашего бакалавриата с присвоением квалификации «академический бакалавр».
								</i>
						</p>
						<br/>
						<br/>
						<p class="p1">
							Все дисциплины бакалавров можно разбить на две составляющие – это базовые дисциплины (обязательные для всех) и дисциплины профилей (дополнительные специализации по выбору студентов с учётом их успеваемости), которые добавляются на последних курсах обучения. 
						</p>
						<br/>
						<p class="p1">
							Бакалавры нашей кафедры специализируются по следующим профилям:
						</p>
						<ol>
							<li>Программирование информационных систем,</li>
							<li>Администрирование информационных систем,</li>
							<li>Информационные технологии в дизайне.</li>
						</ol>
						<br/>
						<br/>
						<p class="p1">
							<i class="i">
								МАГИСТР — академическая степень, квалификация, приобретаемая в Магистратуре — ступЕнь высшего профессионального образования, следующая после бакалавриата, позволяющая углубить специализацию по определенному профессиональному профилю. Обучение — 2 года. Последний семестр, в виде научно-исследовательской и производственной практики, выделяется для завершения магистерской диссертации.
							</i>
						</p>
						<p class="p1">
							<i class="i">
								Степень магистра предусматривает подготовку студента к творческой работе в масштабах крупных инновационных проектов  по выбранному направлению, даёт право поступления в аспирантуру.
							</i>
						</p>
						<p class="p1">
							<i class="i">
								Для студента, стремящегося получить степень магистра наук, готовится индивидуальный план работы. В нем указывается, объем и сроки обучения, формы аттестации и тема магистерской диссертации, которая выполняется под руководством научного руководителя.
							</i>
						</p>
						<p class="p1">
							<i class="i">
								Посмотрите виды профессиональной деятельности, к которым готовятся выпускники нашей магистратуры. ﻿
							</i>
						</p>
						<br/>
						<br/>
						<p class="p1">
							Магистры учатся два года по программе Интеллектуальные информационные системы.
						</p>
						<p class="p1">
							Все выпускники получают диплом ДонНУ ДНР. При желании, студенты последнего года обучения могут с нашей помощью оформить учёбу в экстернате Донского государственного технического университета (ДГТУ) России. В этом случае, при окончании учёбы в ДонНУ, студент получит два диплома: ДонНУ ДНР и ДГТУ России.
						</p>
						<p class="p1">
							Область профессиональной деятельности выпускников направления «Информатика и вычислительная техника» включает: 
						</p>
						<ol>
							<li>компьютеры, системы и сети; </li>
							<li>автоматизированные системы обработки информации и управления;</li>
							<li>системы автоматизированного проектирования и информационной поддержки изделий;</li>
							<li>программное обеспечение автоматизированных систем.</li>
						</ol>
						<br/>
						<p><b>Как к нам поступить?</b></p>
						<br/>
						<p class="p1">
							Когда начнёт работать вступительная кампания ДонНУ вам надо подать документы на физико-технический факультет на направление подготовки «Информатика и вычислительная техника» (шифр для бакалавриата – 09.03.01, срок обучения 4 года, для магистратуры – 09.04.01, срок обучения 2 года). Официальные правила приёма публикуются на сайте университета. 
						</p>
						<p class="p1">
							Очень хороший вариант познакомиться с нами и подготовится к учёбе на нашей кафедре – это участие в клубе IT-профи.  Для школьников этот клуб ещё и источник дополнительных конкурсных баллов.
						</p>
						<p class="p1">	
							Если вы младший специалист по направлению "Компьютерные науки", "Информатика и вычислительная техника" или им подобные, и сданные вами дисциплины совпадают с нашими дисциплинами первого курса, то вы можете поступить к нам на второй курс бакалавриата. Если имеются различия, то можете поступить к нам на первый курс ускоренной формы бакалавриата (3 года обучения). В последнем случае вам придётся совместно с нами изучить и сдать недостающие дисциплины. Можно ли получить образование заочно? 
						</p>
						<p class="p1">	
							На нашей кафедре заочная форма обучения бакалавров и магистров – только контрактная, бюджетные места здесь не предусмотрены. Заочная форма бакалавриата – 5 лет обучения, магистратуры – 2.Какой конкурс на нашу кафедру?
						</p>
						<p class="p1">	
							Поскольку сейчас абитуриенты могут подавать документы на несколько направлений и в разные ВУЗы, то понятие конкурса, практически, исчезло. Важно количество мест, выделенных Министерством образования и науки ДНР бакалаврам и магистрам нашей кафедры. Мы имеем лицензии:
						</p>
						<br/>
						<ol>
							<li>180 бакалавров дневного отделения;</li>
							<li>105 бакалавров заочного отделения;</li>
							<li>135 магистров дневного отделения;</li>
							<li>30 магистров заочного отделения;</li>
						</ol>

						<p class="p1">
							Количество бюджетных мест ежегодно уточняется Министерством образования и науки ДНР. Обычно – это:
						</p>
						<ol>
							<li>100 мест на бакалавриат(80 мест школьникам + 20 мест для младших специалистов);</li>
							<li>21 место в магистратуру.</li>
						</ol>
						<p class="p1">
							Как видите, мест достаточно много. Точное количество бюджетных мест ежегодно публикуется на сайте приёмной комиссии. А платное образование (по контракту) есть?
						</p>
						<p class="p1">
							При любой форме обучения (нормативной или ускоренной, бакалавриат или магистратура) имеются и бюджетные, и контрактные места. Все абитуриенты бакалавриата и магистратуры, не попавшие на бюджетные места могут учиться по контракту на местах, входящих в общее число лицензированных мест (смотрите выше) для нашей кафедры. Стоимость обучения для бакалавриата и магистратуры ежегодно публикуется на сайте приёмной комиссии. Кем и где могут работать ваши бакалавры  и  магистры ? Будьте с нами. Предлагаем подключиться к группе кафедры к клубу IT-профи ВКонтакте. Там же вы можете задать нам вопросы.
						</p>				
						<div class="next-part np3">Следующий раздел</div>
					</div>
					
						<div class="info-content student">						
							<div class="top-title">
								<div class="larg-icon">
									<i class="fa fa-android"></i>
								</div>
								<h1>Студенту</h1>
							</div>
						
						
						<p class="p1">
							Бакалавры на 2-4 курсах выполняют курсовые работы под руководством научных руководителей. Курсовые работы ориентированы на обучение студентов по международной практике «learning by doing». К концу четвёртого курса все работы «вырастают» в выпускную квалификационную работу, по результатам защиты которой специальная комиссия принимает решение о присвоении студенту квалификации бакалавра.
						</p>
						<p class="p1">
							Смотрите «Общие требования к курсовым работам» и правила их оформления в документах кафедры. Все работы подвергаются автоматической проверке на плагиат, а защиты сопровождаются on-line трансляциями в Интернет.
						</p>
						<p class="p1">
							Студент может выбрать себе научного руководителя, на основе собственных научно-прикладных предпочтений. Рекомендуем это сделать как можно раньше. Лучше всего начинать работать над дипломом с первого курса.
						</p>
						<p class="p1">
							В процессе обучения для студентов организуется практика (компьютерная, производственная, преддипломная). Сегодня кафедра располагает обширной базой практик в ведущих ИТ-компаниий и предприятий республики.  http://csu.com.ua/studio/kkt/images/spacer.gif Именно практическая работа, научная или прикладная, формирует из студента качественного востребованного специалиста!
						</p>	
	
						<div class="next-part np4">Следующий раздел</div>
					</div>
					
						<div class="info-content sciens">					
							<div class="top-title">
								<div class="larg-icon">
									<i class="fa fa-graduation-cap"></i>
								</div>
								<h1>Наука</h1>
							</div>
						
							<p><b>АСПИРАНТУРА</b></p><br/>
							
							<p class="p1"> После магистратуры студенты могут продолжить обучение и подготовку диссертаций в аспирантуре университета.  На кафедре подготовкой аспирантов занимаются:</p>

							<ol>
								<li>профессор, д.ф.-м.н. Толстых В. К. (научное направление),</li>
								<li>доцент, к.ф.-м.н. Володин Н.А. (научное направление – оптимизация и идентификация параметров распределенных систем),</li>
								<li>доцент, к.ф.-м.н. Сапунов С.В., (научное направление – теория автоматов),</li>
								<li>доцент, к.т.н. Ермоленко Т.В. (научное направление – распознавание образов, обработка и распознавание речевых сигналов).</li>
							</ol>
							<br/>
							<p class="p1"> При кафедре действует аспирантура по специальностям:</p>
							<ol>
								<li>05.13.03 "Системы и процессы управления", </li>
								<li>05.13.06 "Информационные технологии", </li>
								<li>05.13.23 "Системы и методы искусственного интеллекта".</li>
							</ol>
							<br/>
							<p><b>УЧЕНЫЙ СОВЕТ</b></p><br/>

							<p class="p1">В университете имеются специализированные советы по защитам диссертаций. Наши аспиранты и соискатели могут защищаться в следующих советах, удовлетворяющих направлениям подготовки студентов и аспирантов кафедры.</p>
							<br/>
							<p><b>НАУЧНЫЕ ПРОЕКТЫ</b></p>

							<p class="p1">Научные исследования кафедры нацелены на математическое, компьютерное моделирование, автоматизированное управление, идентификацию и оптимизацию различных систем и процессов. На развитие и использование интеллектуальных алгоритмов в управлении. Ведутся исследования и разработки в области электронного города и правительства.</p>
													
					</div>
				</div>		
				<div class="info-section-control">
					<a href="#mnClose" class="control-btn selected-item-control mnClose"><i class="fa fa-close"></i></a>
					<a href="#mn1" class="control-btn mn1 control-btn-active"><i class="fa fa-television"></i></a>
					<a href="#mn2" class="control-btn mn2"><i class="fa fa-group"></i></a>
					<a href="#mn3" class="control-btn mn3"><i class="fa fa-adn"></i></a>
					<a href="#mn4" class="control-btn mn4"><i class="fa fa-android"></i></a>
					<a href="#mn5" class="control-btn mn5"><i class="fa fa-graduation-cap"></i></a>
				</div>
			</div>
			
			<div class="bottom-part-1">
				<div id="phys-map">
				
				</div>
				<div class="title-panel">
					<p>Физико-технический факультет</p>
				</div>
				<div class="control-panel">
					<select class="fclt">
						<option value="1">ФизикоТехнический</option>
						<option value="2">Математический</option>
						<option value="3">Филологический</option>
						<option value="4">Факультет иностранных языков</option>
						<option value="5">Химический</option>
						<option value="6">Биологический</option>
						<option value="7">Юридический</option>
						<option value="8">Экономический</option>
						<option value="9">УНИ "Экономическая кбиернетика"</option>
						<option value="10">Исторический</option>
					</select>
					<select class="stage">
						<option value="1">1 этаж</option>
						<option value="2">2 этаж</option>
						<option value="3">3 этаж</option>
						<option value="4">4 этаж</option>
						<option value="5">5 этаж</option>
					</select>
					<select class="auditory">
						<option value="415">415</option>
						<option value="415">416</option>
					</select>
					<input type="text" value="" placeholder="Найти..."/>
					<a class="mbtn"><i class="fa fa-search"></i></a>		
					<input id="scale" type="range" min="0.01" max="1" step="0.01" value="0.3"/>
				</div>
			</div>
			
			<div class="auditory-info">
				<div class="number">
					<p>416</p>
				</div>
				<a class="photo-btn"><i class="fa fa-cube"></i></a>
				<a class="info-btn"><i class="fa fa-file-word-o"></i></a>
				<h1>Лекционная аудитория</h1>
			</div>
			
			<div class="teacher-info">
				<div class="slider">
					<ul>
						<li>
							<img src="uag3A-gg7KU.jpg" alt="">
							<a class="teacher-info-btn"><i class="fa fa-search"></i></a>
							<h3>Шарий Т.В.</h3>
                                                        </img>
						</li>
						
						<li>
							<img src="PNErCEFX8Hg.jpg" alt="">
							<a class="teacher-info-btn"><i class="fa fa-search"></i></a>
							<h3>Григор Е.Е.</h3>
                                                        </img>
						</li>
						
						<li>
							<img src="uag3A-gg7KU.jpg" alt="">
							<a class="teacher-info-btn"><i class="fa fa-search"></i></a>
							<h3>Шарий Т.В.</h3>
                                                        </img>
						</li>
						
						<li>
							<img th:src="@{uag3A-gg7KU.jpg}" alt="">
							<a class="teacher-info-btn"><i class="fa fa-search"></i></a>
							<h3>Шарий Т.В.</h3>
                                                        </img>
						</li>
						
						<li>
							<img src="uag3A-gg7KU.jpg" alt="">
							<a class="teacher-info-btn"><i class="fa fa-search"></i></a>
							<h3>Шарий Т.В.</h3>
                                                        </img>
						</li>
						
						<li>
							<img src="uag3A-gg7KU.jpg" alt="">
							<a class="teacher-info-btn"><i class="fa fa-search"></i></a>
							<h3>Шаdрий Т.В.</h3>
                                                        </img>
						</li>
						
					</ul>
				</div>
			</div>
		</section>	
	</div>
	
	<div class="footer">
		<a class="toAnchHead" href="#anchHead">Вверх</a>
		<p>Built with HTML5 and CSS3 | Copyright © 2015</p>
		<p>Powered by Spring Framework</p>
		
	</div>
	
	
	
</div><!-- .wrapper -->
<!--
<div class="modal-photo-window">
		<div class="photo-content" scrolling="yes">
		
		</div>
</div>
	-->
<div style="display: none;">
    <div class="box-modal show-modal photo-content">
        <div class="box-modal_close arcticmodal-close">закрыть</div>
        	<img src="" alt="*"/>
			<img src="" alt="*"/>
			<img src="" alt="*"/>
			<img src="" alt="*"/>
			<img src="" alt="*"/>
			<img src="" alt="*"/>
    </div>
</div>	
<script type="text/javascript" src="js/konvaScript.js"></script>
</body>
</html>
