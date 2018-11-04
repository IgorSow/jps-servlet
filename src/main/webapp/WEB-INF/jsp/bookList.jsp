<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="style.css"/>
    <title>BookList</title>
    <style>
        table {
            color: #FAFAE7;
            background-color: #DD9ECD;
            padding: 5px;
            border: 2px solid black;
            font-family: Pacifico;
        }

        body {
            background-color: pink;
        }

    </style>
</head>
<table style="border-collapse: collapse" border="2">
    <p id="head"> List of books: </p>
    <td>Lp</td>
    <td>id</td>
    <td>isbn</td>
    <td>title</td>
    <td>description</td>
    <td>author</td>
    <td>date</td>
    <td>icon</td>

    <c:forEach var="book" items="${books}" varStatus="iterator">
        <tr>
            <td>${iterator.index +1}
            <td><a href="./books?idBook=${book.id}">${book.id}</a></td>
            <td>${book.isbn}</td>
            <td>${fn:toUpperCase(book.title)}</td>
            <td>${fn:toLowerCase(book.descreption)}</td>
            <td><a href="./books?author=${book.author}">${book.author}</a></td>
            <td>${book.date}</td>
            <td><img width="20px" height="20px"
                     src="https://img.freepik.com/free-vector/scary-pumpkin-halloween-lantern-realistic-vector_1441-733.jpg?size=338&ext=jpg"
                     alt="Hello Ketey"></td>
        </tr>
    </c:forEach>
</table>

<c:if test="${authorFilter}">
    <a href="./books">Wszystkie ksiazki </a>
</c:if>
<br>


<img src="https://media1.tenor.com/images/0a14e3e23b004b9225c155a263b287d5/tenor.gif?itemid=7950330" alt="Hello Ketey">

<img src="https://media.tenor.com/images/f6fb15a47330685fbefb1ec9b6107d94/tenor.gif" alt="Hello Ketey">

<body>

</body>
</html>
