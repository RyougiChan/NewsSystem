<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
    <html>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>添加类别</title>
        <link type="text/css" rel="stylesheet" href="../css/global.css" />
    </head>
    <body>
        <form action="/ShoppingOnline/CategoryServlet" method="POST">
            类别名：<input type="text" name="cType" /><br/>
            热点？：<input type="checkbox" name="cHot" /><br/>
            <input type="submit" value="提交" />
            <input type="hidden" value="addCategory" name="status" />
        </form>
    </body>
    </html>