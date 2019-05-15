//window.onload=function(){
//	var btn=document.getElementById("btnId");
//    btn.onmouseleave=function(){
//    	alert("happy");
//    }
//}
//提取工具类方法：根据id查找标签并绑定单击事件的方法

function $(id,fun){
	var btn = document.getElementById(id);
	//将传入的函数引用交给btn的onclick属性
	btn.onclick = fun;
	
}