
<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.util.List" %>
<%@ page import="model.Memo" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <meta charset="UTF-8">
    <title>My-Memo</title>
    <link rel="stylesheet" type="text/css" href="screen.css">
</head>
<body>
<div id="container">
    <div id="header">
        <p>
            <b>My-Memo</b> – A Simple Web App for Managing Memos
        </p>
    </div>
    <div id="content">
        <h1>Add Memo:</h1>

        <form method="POST" action="memos">
            <input type="text" name="memo" size="30" placeholder="Enter your memo here"/>
            <button type="submit" name="button" value="save">Add</button>
            <c:if test="${!empty requestScope.err}">
            <span style="color: red"><c:out value="${requestScope.err}"/></span>
            </c:if>
            <h1>My Memos:</h1>
            <c:if test="${sessionScope.memos == null || sessionScope.memos.size() == 0}">
            <p>Please add some memos.</p>
            </c:if>
            <c:if test="${sessionScope.memos.size()> 0}"> 
            <table>
                <tr>
                    <th>
                        Memo
                    </th>
                    <th>
                        Saved
                    </th>
                </tr>
                <c:forEach items="${sessionScope.memos}" var="memo" >
                <tr>
                    <td>
                        <c:out value="${memo.description()}"/>
                    </td>
                    <td>
                        <c:out value= "${memo.created}"/>
                    </td>
                </tr>
                </c:forEach>
            </table>
            <br/>
            <button type="submit" name="button" value="reset">Reset list</button>
            </c:if>
        </form>
    </div>
    <div id="footer">
        <p>(C) 2015 Schiesser/Schmollinger, MIT license</p>
    </div>
</div>
</body>
</html>

