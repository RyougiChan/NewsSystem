<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
    <html>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title></title>
        <link type="text/css" rel="stylesheet" href="../../css/global.css" />
        <style>
        	#submitBtn {
        		width: 108px; height: 48px;
        	}
            .inputBtn {
                width: 100px; height: 40px; background: red; color: white; border: none; margin: 04px;
            }
        </style>
    </head>
    <body>
        <div id="form">
            <h1>添加商品</h1>
            <form action="/ShoppingOnline/GoodsServlet" method="POST">
                <div id="gName">
                    <span>商品名称 <input type="text" name="gName"/><b> *</b></span>
                </div>
                <div id="gPrice">
                    <span>商品价格 <input type="number" name="gPrice"/><b> *</b></span>
                </div>
                <div id="gPic">
                    商品图片 <input class="inputFile" type="file" name="gPic"/>
                </div>
                <div id="gRecommend">
                    是否推荐 <input type="radio" name="gRecommend" value="true" />是
                    <input type="radio" name="gRecommend" value="false" checked />否
                </div>
                <div id="gValid">
                    是否有效 <input type="radio" name="gValid" value="true" checked />是
                    <input type="radio" name="gValid" value="false" />否
                </div>
                <div id="gType">
                    商品类别 
                    <select name="gType" id="gTypeBox">
                    	<c:forEach items="${applicationScope.categories}" var="category">
                    		<option value="${category.cId}">${category.cType}</option>
                    	</c:forEach>
                    </select>
                </div>
                <div id="gDescAbstract">
                    商品描述 <textarea name="gDescAbstract" id="gDescAbstractBox" cols="100" rows="5"></textarea>
                </div>
                <div id="gDescDetail">
                    详细介绍 <textarea name="gDescDetail" id="gDescDetailBox" cols="100" rows="10"></textarea>
                </div>
                <div id="submitBtn"><input id="inputBtn" class="inputBtn" type="submit" value="添加" /></div>
            </form>
        </div>
        <script type="text/javascript" src="../script/global.js"></script>
        <script type="text/javascript" src="../script/addGoods.js"></script>
    </body>
    </html>