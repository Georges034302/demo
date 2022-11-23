<%-- 
    Document   : square
    Created on : Nov 23, 2022, 1:46:27 PM
    Author     : George
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
         <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
       <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
    </head>
    <body>
        <% int n = Integer.parseInt(request.getParameter("N")); %>
        <%!            
            
            int square(int i) {
                return (int) Math.pow(i, 2);
            }
        %>
        <table class="table table-bordered table-striped">
            <thead class="table-dark"><th>I</th><th>Square(i)</th></thead>
                <% for (int i = 1; i <= n; i++) {%>
        <tr>
            <td><%= i%></td>                            
            <td><%= square(i)%></td>
        </tr>        
        <% }%>
    </table>
</body>
</html>
