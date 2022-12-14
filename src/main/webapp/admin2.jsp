<%@page import="com.model.dao.UserSqlDAO"%>
<%@page import="com.model.Users"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="x" uri="http://java.sun.com/jsp/jstl/xml" %>

<% String filename = application.getRealPath("/WEB-INF/users.xml");%>       
<jsp:useBean id="userDAO" class="com.model.dao.UserDAO" scope="application">
    <jsp:setProperty name="userDAO" property="fileName" value="<%=filename%>"/>
</jsp:useBean>
<%
    request.setAttribute("email", null);
    request.removeAttribute("email");
%>
<% 
     UserSqlDAO userSqlDAO = (UserSqlDAO) session.getAttribute("userSqlDAO"); 
     Users users = new Users();
     users.addAll(userSqlDAO.getUsers());
%>

<c:import url="/xsl/users.xsl" var="xslt"/>
<c:set var="xml">
    <%out.print(userDAO.marshal(users));%>
</c:set> 

<x:transform xml="${xml}" xslt="${xslt}"></x:transform>