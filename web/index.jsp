<%--
  Created by IntelliJ IDEA.
  User: dell
  Date: 2020/1/11
  Time: 11:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>SpringMVC</title>
  </head>
  <br>
  <!--
    相对路径: 不以/开头的路径 . 相对于当前路径来发送请求.
    绝对路径: 以/开头的路径 . 直接在 http://localhost:8888 后面拼接请求.
    -->
  <a href="hello">Hello SpringMVC</a>
  <br/>
  <a href="mvc/testRequestMapping">Test RequestMapping</a>
  </br>

  <%--模拟post请求--%>
  <form action="mvc/testRequestMappingMethod" method="post">
    <input type="submit" value="POST"/>
  </form>
  <br/>

  <%--模拟get请求--%>
  <a href="mvc/testRequestMappingMethod">Test RequestMapping</a>
  <br/>


   <%-- 映射请求参数   以及  请求头信息--%>
  <a href="mvc/testRequestMappingParamsAndHeaders?username=tom&age=22">Test RequestMapping Params  Headers</a>
  <br/>


  <%--带参数的URL--%>
  <a href="mvc/testPathVariable/Admin/1001">Test PathVaribale</a>
  <br/>

  <%--Rest增删改查--%>
  <!-- 修改一个订单 -->
  <form action="mvc/order" method="post">
    <input type="hidden" name="_method" value="PUT"/>
    <input type="submit" value="REST PUT"/>
  </form>
  <br/>
  <!-- 添加一个新的订单 -->
  <form action="mvc/order" method="post">
    <input type="submit" value="REST POST"/>
  </form>
  <br/>
  <!-- 删除id为1001的订单 -->
  <form action="mvc/order/1001" method="post">
    <!-- 隐藏域· -->
    <input type="hidden" name="_method" value="DELETE"/>
    <input type="submit" value="REST DELETE"/>
  </form>
  <br/>
  <!-- 查询id为1001的订单 -->
  <a href="mvc/order/1001">REST GET</a>
  <br/>


  <%--testRequestParam--%>
  <a href="mvc/testRequestParam?username=Tom&age=22">Test RequestParam</a>
  <br/>
  </body>
</html>
