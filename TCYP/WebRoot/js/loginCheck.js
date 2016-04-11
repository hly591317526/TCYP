	//如何修改元素的样式。
	//1.在CSS中使用类选择器预置样式；
	//2.通过js修改元素的class属性，给这个元素增加预置元素。元素.className="样式"；className就是元素的class属性。
	//校验账号
	function check_email() {
		//1.获取账号
		var user_name = document.getElementById("email").value;
		//2.校验其格式。
		var reg =  /^([a-zA-Z0-9_\.\-])+\@(([a-zA-Z0-9\-])+\.)+([a-zA-Z0-9]{2,4})+$/;
		var span = document.getElementById("info");
		if (reg.test(user_name)) {
			//匹配成功
			span.innerHTML ="";
			return true;
		} else {
			//匹配失败
			span.innerHTML ="邮箱格式错误！";
			return false;
		}
	}
	function check_psw() {
		//1.获取密码
		var user_psw = document.getElementById("password").value;
		//2.校验其格式。
		var reg = /^\w{3,20}$/;
		var span = document.getElementById("info");
		if (reg.test(user_psw)) {
			//匹配成功
			span.innerHTML ="";
			return true;
		} else {
			//匹配失败
			span.innerHTML = "密码格式错误！";
			return false;
		}
	}