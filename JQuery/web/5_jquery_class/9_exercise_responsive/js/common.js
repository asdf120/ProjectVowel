(function(win, $){
	var $html = $("html");
	
	// 미리 크기로 변수를 지정한다.
	var deviceSize = {
		pc:1009,
		tablet:801,
		mobile:800
	};

	function scrollShowHide(status) {
		$html.css({"overflow-y":status});
		return $html.width();    
	}

	var sc_w1 = scrollShowHide("hidden"),
					sc_w2 = scrollShowHide("scroll"),
					sc_w3 = sc_w1 - sc_w2;

	if(sc_w3 > 0) {
					deviceSize.pc = deviceSize.pc -  sc_w3;
					deviceSize.tablet = deviceSize.tablet -  sc_w3;
					deviceSize.mobile = deviceSize.mobile -  sc_w3;
	}
	//console.log(deviceSize.pc);

	$(win).on("resize", function() {
		// 브라우저의 창 너비가 변하면 창의 너비를  w_size에 저장한다.
		var w_size = $(win).width();
		
		// 브라우저의 창 너비가 데스크톱의 너비보다 크거나 같으면 실행한다.
		if(w_size >= deviceSize.pc 
		&& !$("html").hasClass("pc")) {
			$html.removeClass("mobile tablet").addClass("pc");
			scrollShowHide("scroll");
			
		// 태블릿 사이즈의 경우	
		} else if(w_size < deviceSize.pc 
		&& w_size >= deviceSize.tablet 
		&& !$("html").hasClass("tablet")) {
			$html.removeClass("mobile pc").addClass("tablet");
			scrollShowHide("scroll");
			
		// 모바일 사이즈인 경우	
		} else if(w_size <= deviceSize.mobile 
		&& !$html.hasClass("mobile")) {
			$html.removeClass("pc tablet").addClass("mobile");
			var menu_pos = parseInt($(".mobile-menu-wrap").css("left"));
			if(menu_pos >= 0) {
							scrollShowHide("hidden");
						}
		}
	});


	

}(window, jQuery));
