<%--
  Created by IntelliJ IDEA.
  User: PC
  Date: 11/12/2020
  Time: 2:41 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
<link href="./src/main/resources/style.css" rel="stylesheet" type="text/css">
<body>
<div class="d-flex justify-content-center align-items-center container">
    <div class="row" style="width: 500px">
    <form method="post" action="/details">
        <h1 style="margin: 80px 0px 50px 110px"> My details </h1>
        <div class="form-group">
            <label style="padding: 10px 10px 10px 0px">
                <b>Username</b>
            </label>
            <input name="username" type="text" class="form-control" id="inputUsername" value=${username} disabled>
        </div>
        <div class="form-group">
            <label for="inputName" style="padding: 10px 10px 10px 0px">
                <b>Name</b>
            </label>
            <input name="name" type="text" class="form-control" id="inputName" value=${name} placeholder="Name">
        </div>
        <div class="form-group">
            <label for="inputAddress" style="padding: 10px 10px 10px 0px">
                <b>Address</b>
            </label>
            <input name="address" type="text" class="form-control" id="inputAddress"
                <% String address = (String) request.getAttribute("address"); %>
                   value='<%= address %>'
                   placeholder="Address">
        </div>
        <div class="form-group">
            <label style="padding: 10px 10px 10px 0px">
                <b>Birthdate </b>
            </label>
            <input name="birthdate" type="date" id="inputBirthdate"
                <% String birthdate = (String) request.getAttribute("birthdate"); %>
                   value='<%= birthdate %>'
                   min="1950-01-01" max="2020-01-01">
        </div>

        <div class="d-flex justify-content-center align-items-center container" style="margin: 20px 0px 0px 0px">
            <div class="column">

                <button type="submit" class="btn btn-primary" value="logout"
                        onclick="form.action='/logout'; form.method='get'"
                        style="margin: 0px 10px 0px 0px; width:70px">Logout</button>

                <button type="submit" class="btn btn-primary" value="save" style="margin: 0px 10px 0px 0px; width:70px">Save</button>

            </div>
        </div>

    </form>
</div>
</div>
</body>
</html>