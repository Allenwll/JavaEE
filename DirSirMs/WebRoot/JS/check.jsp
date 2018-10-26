<%@ page contentType="text/html; charset=utf-8" language="java" import="java.sql.*" errorPage="" %>
//判断用户的输入是否合法
function checkreg(){        
	if (myform.username.value==""){
		alert("请输入用户名！");myform.username.focus();return;
	}
	if (myform.truename.value==""){
		alert("请输入真实姓名！");myform.truename.focus();return;
	}
	if (myform.pwd.value==""){
		alert("请输入密码！");myform.pwd.focus();return;
	}     
	if (myform.pwd.value.length < 6 ){
		alert("密码至少为6位，请重新输入！");myform.pwd.focus();return;
	}		
	if (myform.pwd1.value==""){
		alert("请确认密码！");myform.pwd1.focus();return;
	}
	if (myform.pwd.value!=myform.pwd1.value){
		alert("您两次输入的密码不一致，请重新输入！");myform.pwd.focus();return;
	}
	if(myform.cardno.value==""){
		alert("请证件号码！");myform.cardno.focus();return;
	}		
	if (myform.email.value==""){
		alert("请输入Email地址！");myform.email.focus();return;
	}
	var i=myform.email.value.indexOf("@");
	var j=myform.email.value.indexOf(".");
	if((i<0)||(i-j>0)||(j<0)){
		alert("您输入的Email地址不正确，请重新输入！");myform.email.value="";myform.email.focus();return;
	}
	myform.submit();		
}  
function check_modi(){
	if (myform.truename.value==""){
		alert("请输入真实姓名！");myform.truename.focus();return;
	}
	if (myform.oldpwd.value==""){
		alert("请输入原密码！");myform.oldpwd.focus();return;
	}
	if(myform.holdpwd.value!=myform.oldpwd.value){
		alert("您输入的原密码不正确，请重新输入！");myform.oldpwd.value="";myform.oldpwd.focus();return;
	}
	if (myform.pwd.value==""){
		alert("请输入新密码！");myform.pwd.focus();return;
	}
	if (myform.pwd.value.length < 6){
		alert("新密码至少为6位，请重新输入！");myform.pwd.focus();return;
	}		
	if (myform.pwd1.value==""){
		alert("请确认新密码！");myform.pwd1.focus();return;
	}
	if (myform.pwd.value!=myform.pwd1.value){
		alert("您两次输入的密码不一致，请重新输入！");myform.pwd.focus();return;
	}
	if(myform.cardno.value==""){
		alert("请输入证件号码！");myform.cardno.focus();return;
	}		
	if (myform.email.value==""){
		alert("请输入Email地址！");myform.email.focus();return;
	}
	var i=myform.email.value.indexOf("@");
	var j=myform.email.value.indexOf(".");
	if((i<0)||(i-j>0)||(j<0)){
		alert("您输入的Email地址不正确，请重新输入！");myform.email.value="";myform.email.focus();return;
	}
	myform.submit();		
}
function checkU(myform){
	if(myform.username.value==""){
		alert("请输入用户名!");myform.username.focus();return;
	}
	if(myform.password.value==""){
		alert("请输入密码!");myform.password.focus();return;
	}
	myform.submit();
}

function checkM(myform){
	if(myform.manager.value==""){
		alert("请输入管理员名!");
		myform.manager.focus();return;
	}
	if(myform.PWD.value==""){
		alert("请输入密码!");myform.PWD.focus();return;
	}
	myform.submit();
}

function CheckAll(elementsA,elementsB){
	for( var i=0;i < elementsA.length;i++){
		elementsA[i].checked = true;
	}
	if(elementsB.checked == false){
		for(var j=0;j < elementsA.length ; j++){
			elementsA[j].checked = false;
		}
	}
}
//判断用户是否选择了要删除的记录，如果是，则提示“是否删除”；否则提示“请选择要删除的记录”
function checkdel(delid,formname){
	var flag = false;
	for( var i=0; i < delid.length;i++){
		if(delid[i].checked){
			flag = true;
			break;
		}
	}
	if(!flag){
		alert("请选择要删除的记录！");
		return false;
	}else{
		if(confirm("商品分类下还可能存在其他内容,确定要删除吗？")){
			formname.submit();
		}
	}
}

function checkNum(form1){

	if(isNaN(form1.num1.value) || form1.num1.value.indexOf('.',0)!=-1){
		alert("请不要输入非法字符 ");
		form1.num1.focus();
		return;
	}
	if(form1.num1.value==""){
		alert("请输入修改的数量");
		form1.num1.focus();
		return;
	}
	if(form1.num1.value <= 0){
		alert("请输入大于0的值");
		form1.num1.focus();
		return;
	}
	form1.submit();
}