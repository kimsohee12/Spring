<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
   <head>
      <title>Forty by HTML5 UP</title>
      <meta charset="UTF-8" />
      <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
      <link rel="stylesheet" href="resources/assets/css/main.css" />
   </head>
   <body style="text-align: center;">
      <!-- Wrapper -->
         <div id="wrapper">
            <!-- Menu -->
               <nav id="Update">   
                  <table>
                     <caption><h2>회원관리페이지</h2></caption>
                     <tr>
                        <td>Email</td>
                        <td>Tel</td>
                        <td>Address</td>                     
                     </tr>
                     <!-- 2.모든 회원의 이메일(email),전화번호(tel),주소(address)를 출력하시오. -->
                     <c:forEach items="${list }" var="wm">
                     <tr>
                        <td>${wm.email }</td>
                        <td>${wm.tel }</td>
                        <td>${wm.address }</td>
                        <td><a href = "member/delete/${wm.email }">삭제</a></td>
                     </tr>
                     </c:forEach>
                  </table>
               </nav>      
               <a href="index.jsp" class="button next scrolly">되돌아가기</a>   
         </div>
      <!-- Scripts -->
         <script src="resources/assets/js/jquery.min.js"></script>
         <script src="resources/assets/js/jquery.scrolly.min.js"></script>
         <script src="resources/assets/js/jquery.scrollex.min.js"></script>
         <script src="resources/assets/js/skel.min.js"></script>
         <script src="resources/assets/js/util.js"></script>
         <!--[if lte IE 8]><script src="assets/js/ie/respond.min.js"></script><![endif]-->
         <script src="resources/assets/js/main.js"></script>
   </body>
</html>
