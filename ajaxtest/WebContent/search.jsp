<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style type="text/css">
	#mydiv{position:absolute;
		left:50%;
		top:50%;
		margin-left:-200px;
		margin-top:-50px;
	}
	
	.mouseOver{
		background:#708090;
		color:#FFFAFA;
	}
	
	.mouseOut{
		background:#FFFAFA;
		color:000000;
	}
</style>
<script type="text/javascript">

	var xmlHttp;
	
	function getMoreContents(){
		//获取用户输入的内容
		var content=document.getElementById("keyword");
		//alert(content.value);
		if(content.value==""){
			clearContent();
			return;
		}
		//向服务器发送用户输入的内容，因为我们采用的是ajax异步发送数据    使用xmlhttp对象
		xmlHttp=createXmlHttp();
		//要给服务器发送数据
		var url="search?keyword="+escape(content.value);//escape消除中文的影响
		xmlHttp.open("GET",url,true);//true标识javascript脚本会在send（）方法之后会继续执行，而不会等待来自服务器的响应
		//xmlHttp绑定回调方法，这个回调方法会在xmlHttp状态改变的时候被调用
		//xmlHttp 的状态 0~4  ，我们只关心4状态（complete）
		//当完成之后，再调用回调方法才有意义
		xmlHttp.onreadystatechange=callback;
		xmlHttp.send(url);
	}

	//获得xmlHttp对象方法   不同浏览器获取该对象的方法不同，考虑到浏览器的兼容性
	function createXmlHttp(){
		//大多数浏览器
		var xmlHttp;
		if(window.XMLHttpRequest){
			xmlHttp=new XMLHttpRequest();
		}
		//考虑浏览器的兼容性
		if(window.ActiveXObject){
			xmlHttp = new ActiveXObject("Microsoft.XMLHTTP");
			if(!xmlHttp){
				xmlHttp = new ActiveXObject("Msxml2.XMLHTTP");
			}
		}
		return xmlHttp;
	}

	//回调函数
	function callback(){
		if(xmlHttp.readyState==4){
			if(xmlHttp.status==200){
				var result=xmlHttp.responseText;//交互成功获取的响应数据是文本格式
				//解析获得的数据
				var json=eval("("+result+")");
				//获得数据之后，就可以动态的显示这些数据，把数据中展示在输入框的下面
				setContent(json);
			}
		}
	}

	//设置关联数据的展示，将服务器返回的信息展示在输入框下面
	function setContent(contents){
		setLocation();
		
		var size = contents.length;//数据的长度
		clearContent();
		for(var i=0;i<size;i++){
			var nextNode=contents[i];//代表json格式数据的第i个元素
			var tr=document.createElement("tr");
			var td=document.createElement("td");
			td.setAttribute("border","0");
			td.setAttribute("bgcolor","#FFFAFA");
			td.onmouseover=function(){
				this.className='mouseOver';	
			};
			td.onmouseout=function(){
				this.className='mouseOut'
			};
			td.onclick=function(){
				//选择数据
			};
			var text=document.createTextNode(nextNode);
			td.appendChild(text);
			tr.appendChild(td);
			
			document.getElementById("content_table_body").appendChild(tr);
		}
	}

	//清空数据
	function clearContent(){
		var contenttablebody=document.getElementById("content_table_body");
		var size=contenttablebody.childNodes.length;
		for(var i=size-1;i>=0;i--){
			contenttablebody.removeChild(contenttablebody.childNodes[i]);
		}
		document.getElementById("popdiv").style.border="none";
	}

	function keywordBlur(){
		clearContent();
	}

	function setLocation(){
		var content=document.getElementById("keyword");
		var width=content.offsetWidth;
		var left=content["offsetLeft"];
		var top=content["offsetTop"]+content.offsetHeight;
		//获得显示数据的div
		var popdiv=document.getElementById("popdiv");
		popdiv.style.border="black 1px solid";
		popdiv.style.left=left+"px";
		popdiv.style.top=top+"px";
		popdiv.style.width=width+"px";

		var contenttable=document.getElementById("content_table");
		contenttable.style.width=width+"px";
	}
</script>
</head>
<body>
<div id="mydiv">
	<input type="text" size="50" id="keyword" onkeyup="getMoreContents()" onblur="keywordBlur()" onfocus="getMoreContents()"/>
	<input type="button" value="百度一下" width="50px"/>
	
	<div id="popdiv">
		<table id="content_table" bgcolor="#FFFAFA" border="0" cellspacing="0" cellpadding="0">
			<tbody id="content_table_body">
				
				
			</tbody>
		</table>
	</div>
</div>
</body>
</html>