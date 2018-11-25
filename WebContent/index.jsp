<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
  <script>
     //定义了城市的二维数组，里面的顺序跟省份的顺序是相同的。通过selectedIndex获得省份的下标值来得到相应的城市数组
     var city=[
     ["包含","等于"],
     ["大于","大于等于","小于","小于等于"]
     ];
 
     function getCity(){
         //获得一属性下拉框的对象
         var sltProvince=document.form1.one;
         //获得二属性下拉框的对象
         var sltCity=document.form1.two;
         
         //得到对应一属性的属性数组
         var provinceCity=city[sltProvince.selectedIndex - 1];
 
         //清空二属性下拉框，仅留提示选项
         sltCity.length=1;
 
         //将二属性数组中的值填充到二属性下拉框中
         for(var i=0;i<provinceCity.length;i++){
			 //Option(选项描述，选项值) 等价于 <option value="选项值" >选项描述</option>;
             sltCity[i+1]=new Option(provinceCity[i],provinceCity[i]);
         }
     }
 </script>
</head>
<body>

 <FORM METHOD=POST ACTION="findInfo" name="form1" style="margin-left:390px">
 属性
         <SELECT NAME="one" onChange="getCity()">
             <OPTION VALUE="0">请选择...</OPTION>
             <OPTION VALUE="name">姓名 </OPTION>
             <OPTION VALUE="age">年龄</OPTION>
         </SELECT>
         <SELECT NAME="two">
             <OPTION VALUE="0">请选择... </OPTION>
         </SELECT>
         <input type="text" name="condition"/>
<input type="submit" value="提交">





</FORM>
<a href="javaEE_lab_1/downloadInfo.action?filename=one.txt">下载结果</a>


<table  border="2" width="400px" bgcolor="#ffffff" align="center">
	<tr>
		<th>学号</th>
		<th>姓名</th>
		<th>年龄</th>
	</tr>
	
	<c:forEach items="${list_show}" var="user">
    <tr>
		 <td>${user.id}</td>
		 <td>${user.name}</td>
		 <td>${user.age}</td>
    </tr>
    </c:forEach>
	
	
<%-- 	<c:if test="${i==1}">
	<tr>
		<th> ${student0.id} </th>
		<th> ${student0.name} </th>
		<th> ${student0.age} </th>
		
	</tr>
	<tr>
		<th colspan=3>共1条数据</th>
	</tr>
	</c:if>	
	
	<c:if test="${i==2}">
	<tr>
		<th> ${student1.id} </th>
		<th> ${student1.name} </th>
		<th> ${student1.age} </th>
	</tr>
	<tr>
		<th colspan=3>共1条数据</th>
	</tr>
	
	</c:if>	
	<c:if test="${i==3}">
	<tr>
		<th> ${student0.id} </th>
		<th> ${student0.name} </th>
		<th> ${student0.age} </th>
	</tr>
	<tr>
		<th> ${student1.id} </th>
		<th> ${student1.name} </th>
		<th> ${student1.age} </th>
	</tr>
	<tr>
		<th colspan=3>共2条数据</th>
	</tr>
</c:if>	

<c:if test="${i==0}">
	
	<tr>
		<th colspan=3>共0条数据</th>
	</tr>
	</c:if>	 --%>
	
	
</table>



</body>
</html>