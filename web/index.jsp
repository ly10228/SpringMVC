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

  <a href="testInterceptor">Test Interceptor</a>
  <br/>

  <form action="upload" method="post" enctype="multipart/form-data">
      上传文件:<input type="file" name="uploadFile"/>
      <br/>
      文件描述:<input type="text" name="desc"/>
      <br/>
      <input type="submit" value="上传"/>
  </form>
  <br/>

  <a href="download">点我下载图片</a>
  <br/>

  <a href="testJson">Test Json</a>
  <br/>
  <br/>

  <a href="listAllEmp">List All Emps</a>
  <br/>
  <br/>

  <a href="testRedirectView">Test RedirectView</a>
  <br/>
  <a href="testViewController">Test ViewController</a>
  <br/>
  <a href="testView"> Test View</a>
  <br/>
  <a href="testModel">Test Model</a>
  <br/>
  <a href="testMap">Test Map</a>
  <br/>
  <a href="testModelAndView">Test ModelAndView</a>
  <br/>

  <%--testModelAndViewtestModelAndViewtestModelAndViewtestModelAndViewtestModelAndViewtestModelAndViewtestModelAndViewtestModelAndViewtestModelAndViewtestModelAndViewtestModelAndViewtestModelAndViewtestModelAndViewtestModelAndViewtestModelAndViewtestModelAndView--%>

  <a href="mvc/testServletAPI">Test Servlet API</a>
  <br/>

  <form action="mvc/testPOJO" method="post">
    用户名称: <input type="text" name="userName"/>
    <br/>
    用户密码: <input type="password" name="passWord"/>
    <br/>
    用户邮箱: <input type="text" name="email"/>
    <br/>
    用户性别: 男 <input type="radio" name="gender" value="1"/>
    女<input type="radio" name="gender" value="0"/>
    <br/>
    <!-- 支持级联的方式 -->
    用户省份: <input type="text" name="address.province" />
    <br/>
    用户城市: <input type="text" name="address.city"/>
    <br/>
    <input type="submit" value="注册"/>
  </form>

  <a href="mvc/testCookieValue"> Test CookieValue</a>
  <br/>

  <a href="mvc/testRequestHeader">Test RequestHeader</a>
  <br/>
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
