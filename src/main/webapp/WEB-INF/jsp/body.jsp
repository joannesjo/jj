<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 09-12-2017
  Time: 14:29
  To change this template use File | Settings | File Templates.
--%>

<div class="row">
    <div class="container-fluid col-9 pr-0">
        <table class="table table-dark table-striped table-hover">
            <thead>
            <tr>
                <th>Firstname</th>
                <th>Lastname</th>
                <th>Email</th>
            </tr>
            </thead>
            <tbody>
            <%for (int i=0;i<10;i++)
            {

            %>
            <tr>
                <td>John</td>
                <td>Doe</td>
                <td>john@example.com</td>
            </tr>
            <%}%>
            </tbody>
        </table>
    </div>
    <jsp:include page='/WEB-INF/jsp/filters.jsp'></jsp:include>

