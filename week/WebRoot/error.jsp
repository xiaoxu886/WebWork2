<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <!DOCTYPE html>
    <html>

    <head>
        <meta charset="utf-8">
        <title>出错了</title>

        <link href="css/error.css" rel ="stylesheet"/>
        <!-- <script language ="JavaScript" src="js/error.js">
        </script> -->

        <script>

        window.setInterval(changeLeaveTime,1000);

        function changeLeaveTime(){
            var time = parseInt(document.getElementById("leaveTime").innerText);
            time =time-1;
            if(time ==0){
                window.location.href = "login.html";
            }else{
                document.getElementById("leaveTime").innerText = time;
            }
        }
        </script>


    </head>

    <body>

            <div id="errorDiv">
                <div id ="errorHint">
                    <p id ="errorInfo">${info}</p>

                <p>
                    <span id ="leaveTime">10</span>秒后自动返回到登录页面
                </p>
                <p>不能跳转，请<a href ="login.html">点击这里</a></p>
                </div>
            </div>
    </body>