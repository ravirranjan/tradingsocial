$(document).ready(function($){


	var $form_modal = $('.modal'),
	$form_login = $form_modal.find('#trading-social-login'),
	$form_signup = $form_modal.find('#trading-social-signup'),
	$form_modal_tab = $('.header-switcher'),
	$tab_login = $form_modal_tab.children('li').eq(0).children('a'),
	$tab_signup = $form_modal_tab.children('li').eq(1).children('a'),
	$main_nav = $('.main-nav');

	//open modal

	$main_nav.on('click', function(event){
		$('#login-modal').modal("show");
		if( $(event.target).is($main_nav) ) {
			// on mobile open the submenu
			$(this).children('ul').toggleClass('is-visible');
		} else {
			//show modal layer
			$form_modal.addClass('is-visible');	
			//show the selected form
			( $(event.target).is('.trading-social-signup') ) ? signup_selected() : login_selected();
		}

	});

	$form_modal_tab.on('click', function(event) {
		event.preventDefault();
		( $(event.target).is( $tab_login ) ) ? login_selected() : signup_selected();
	});

	function login_selected(){
		$form_login.addClass('is-selected');
		$form_signup.removeClass('is-selected');
		$tab_login.addClass('selected');
		$tab_signup.removeClass('selected');
	}

	function signup_selected(){
		$form_login.removeClass('is-selected');
		$form_signup.addClass('is-selected');
		$tab_login.removeClass('selected');
		$tab_signup.addClass('selected');
	}
});