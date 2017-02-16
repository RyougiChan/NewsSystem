<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
    <html>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>查询类别</title>
        <link type="text/css" rel="stylesheet" href="../css/global.css" />
    </head>
    <body>
        <form action="/ShoppingOnline/CategoryServlet" method="POST">
            关键字：<input type="text" name="keywords" />
            <input type="submit" value="提交" />
            <input type="hidden" value="queryCategory" name="status" />
        </form>
        <c:if test="${requestScope.categories != null}">
            <table>
                <tr>
                    <td>编号</td>
                    <td>类别</td>
                    <td>热点</td>
                    <td>客服</td>
                </tr>
                <c:forEach items="${requestScope.categories}" var="category" varStatus="num">
                    <tr>
                        <td>${num.count}</td>
                        <td>${category.cType}</td>
                        <td>
                        	<c:choose>
                        		<c:when test="${category.cHot == 'ture'}">
                        			<input value="true" type="checkbox" checked="checked" disabled />
                        		</c:when>
                        		<c:otherwise>
                        			<input value="false" type="checkbox" disabled />
                        		</c:otherwise>
                        	</c:choose>
                        </td>
                        <td>${category.account.uName}</td>
                    </tr>
                </c:forEach>
            </table>    
        </c:if>
    </body>
    </html>