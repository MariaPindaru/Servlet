<%--
  Created by IntelliJ IDEA.
  User: PC
  Date: 11/12/2020
  Time: 2:18 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
      integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
<body>
<div class="d-flex justify-content-center align-items-center container">
    <div class="row" style="width: 500px">
    <form method="post" action="/changePassword">
        <h1 style="margin: 80px 0px 50px 30px">Forgot Password</h1>
        <div class="form-group">
            <label style="padding: 10px 10px 10px 0px">
                <b>Username *</b>
            </label>
            <input name="username" type="text" class="form-control"
                  value=${username} disabled>
        </div>
        <div class="form-group">
            <label for="inputPass" style="padding: 10px 10px 10px 0px">
                <b>Password *</b>
            </label>
            <input name="password1" type="password" class="form-control" id="inputPass" placeholder="Password">
        </div>
        <div class="form-group">
            <label for="inputConfPass" style="padding: 10px 10px 10px 0px">
                <b>Confirm password *</b>
            </label>
            <input name="password2" type="password" class="form-control" id="inputConfPass" placeholder="Repeat password">
        </div>

        <div style="color: red; padding: 10px 10px 10px 0px">${message}</div>

        <div class="d-flex justify-content-center align-items-center container" style="margin: 20px 0px 0px 0px">
            <div class="column">

                <button type="submit"  onclick="form.action='/logout'; form.method='get'"
                class="btn btn-primary" style="margin: 0px 10px 0px 0px; width:70px">Exit</button>

                <button type="submit" class="btn btn-primary" style="margin: 0px 10px 0px 0px; width:70px">Save</button>

            </div>
        </div>

    </form>
</div>
</div>
</body>
</html>