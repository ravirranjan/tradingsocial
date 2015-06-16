$(document).ready(function($){


	var $form_modal = $('.modal'),
	$form_login = $form_modal.find('#trading-social-login'),
	$form_signup = $form_modal.find('#trading-social-signup'),
	$form_forget_password = $form_modal.find('#forget_password'),
	$form_modal_tab = $('.header-switcher'),
	$tab_login = $form_modal_tab.children('li').eq(0).children('a'),
	$tab_signup = $form_modal_tab.children('li').eq(1).children('a'),
	$forget_password_tab = $form_modal.find('#forgot-password-link'),
	$signin_tab = $form_modal.find('.signin-tab'),
	$signup_tab = $form_modal.find('.signup-tab'),
	$forgotpass_header = $form_modal.find('.forgot-pass-header'),
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
			$form_modal_tab.addClass('is-selected');
			( $(event.target).is('.trading-social-signup') ) ? signup_selected() : login_selected();
		}

	});

	$form_modal_tab.on('click', function(event) {
		event.preventDefault();
		( $(event.target).is( $tab_login ) ) ? login_selected() : signup_selected();
	});

	$forget_password_tab.on('click', function(event) {
		event.preventDefault();
		forget_password();
	});

	$signin_tab.on('click', function(event) {
		event.preventDefault();
		login_selected();
	});

	$signup_tab.on('click', function(event) {
		event.preventDefault();
		signup_selected();
	});


	function login_selected(){
		$form_modal_tab.addClass('is-selected');
		$form_login.addClass('is-selected');
		$form_signup.removeClass('is-selected');
		$tab_login.addClass('selected');
		$tab_signup.removeClass('selected');
		$form_forget_password.removeClass('is-selected');
		$forgotpass_header.removeClass('is-selected');

	}

	function signup_selected(){
		$form_modal_tab.addClass('is-selected');
		$form_login.removeClass('is-selected');
		$form_signup.addClass('is-selected');
		$tab_login.removeClass('selected');
		$tab_signup.addClass('selected');
		$form_forget_password.removeClass('is-selected');
		$forgotpass_header.removeClass('is-selected');
	}

	function forget_password(){
		$form_login.removeClass('is-selected');
		$form_signup.removeClass('is-selected');
		$tab_signup.removeClass('selected');
		$tab_login.removeClass('selected');
		$form_modal_tab.removeClass('is-selected');
		$form_forget_password.addClass('is-selected');
		$forgotpass_header.addClass('is-selected');
		
	}

	$('[data-toggle="popover"]').popover({
		html: true,
		placement: 'bottom',
		trigger: 'hover',
		content: function () {
			return '<img src="'+$(this).data('img') + '" />';
		}
	});
});