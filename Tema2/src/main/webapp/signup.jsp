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
    <div class="column">

        <h1 style="text-align: center; margin-top:10%"> SignUp </h1>

        <div class="row" style="width: 500px">
            <form method="post" action="/signup">
                <div class="form-group">
                    <label style="padding: 10px 10px 10px 0px">
                        <b>Username *</b>
                    </label>
                    <input name="username" type="text" class="form-control" id="inputUsername" placeholder="Username">
                </div>
                <div class="form-group">
                    <label for="inputPass" style="padding: 10px 10px 10px 0px">
                        <b>Password *</b>
                    </label>
                    <input name="password1" type="password" class="form-control" id="inputPass" placeholder="Password">
                </div>
                <div class="form-group">
                    <label for="inputConfPass" style="padding: 10px 10px 10px 0px">
                        <b>Repeat password *</b>
                    </label>
                    <input name="password2" type="password" class="form-control" id="inputConfPass"
                           placeholder="Repeat password">
                </div>

                <div class="form-group">
                    <label style="padding: 10px 10px 10px 0px">
                        <b>Name</b>
                    </label>
                    <input name="name" type="text" class="form-control" id="inputName" placeholder="Name">
                </div>

                <div class="form-group">
                    <label style="padding: 10px 10px 10px 0px">
                        <b>Address</b>
                    </label>
                    <input name="address" type="text" class="form-control" id="inputAddress" placeholder="Address">
                </div>

                <div class="form-group">
                    <label style="padding: 10px 10px 10px 0px">
                        <b>Birthdate </b>
                    </label>
                    <input name="birthdate" type="date" id="inputBirthdate"
                           min="1950-01-01" max="2021-01-01">
                </div>

                <div itemref="message" style="color: red; padding: 10px 10px 10px 0px">${message}</div>

                <div class="d-flex justify-content-center align-items-center container"
                     style="margin: 20px 0px 0px 0px">
                    <div class="column">
                        <div class="form-group">
                            <button type="submit"
                                    formaction="/logout" formmethod="get"
                                    name="exit" class="btn btn-primary" style="margin: 0px 10px 0px 0px; width:70px">
                                Exit
                            </button>

                            <button formaction="/signup" formmethod="post"
                                    class="btn btn-primary"
                                    style="margin: 0px 10px 0px 0px; width:70px">
                                Save
                            </button>
                        </div>
                    </div>
                </div>
            </form>
        </div>
    </div>
</div>
</body>
</html>
