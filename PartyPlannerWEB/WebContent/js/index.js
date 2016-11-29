function isLoginFailed(tried) {
	if(tried === -1){
		$("#errorMessage").show();
	}
	else{
		$("#errorMessage").hide();
	}
};

function isSearchFailed(failed) {
	if(failed === true){
		$("#eventNotFoundMessage").show();
	}
	else{
		$("#eventNotFoundMessage").hide();
	}
};


$(document).ready(function() {
	$('#session').click(function() {
		if ($('#signin-dropdown').is(":visible")) {
			$('#signin-dropdown').hide()
			$('#session').removeClass('active');
		} else if ($('#register-dropdown').is(":visible")) {
			$('#register-dropdown').hide()
			$('#session').removeClass('active');
		} else {
			$('#signin-dropdown').show()
			$('#session').addClass('active');
		}
		return false;
	});
	$('#signin-dropdown').click(function(e) {
		e.stopPropagation();
	});

	$('.newRegister').click(function() {
		if ($('#register-dropdown').is(":visible")) {
			$('#register-dropdown').hide()
			$('#session').removeClass('active');
		} else {
			if ($('#signin-dropdown').is(":visible")) {
				$('#signin-dropdown').hide()
				$('#session').removeClass('active');
			} else {
			}
			$('#register-dropdown').show()
			$('#session').addClass('active');
		}
		return false;
	});
	$('#register-dropdown').click(function(e) {
		e.stopPropagation();
	});

	$('.newLogin').click(function() {
		if ($('#signin-dropdown').is(":visible")) {
			$('#signin-dropdown').hide()
			$('#session').removeClass('active');
		} else {
			if ($('#register-dropdown').is(":visible")) {
				$('#register-dropdown').hide()
				$('#session').removeClass('active');
			} else {
			}
			$('#signin-dropdown').show()
			$('#session').addClass('active');
		}
		return false;
	});

	$(document).click(function() {
		$('#signin-dropdown').hide();
		$('#register-dropdown').hide();
		$('#session').removeClass('active');
	});
});