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

<div class="d-flex align-items-center justify-content-center">
    <div class="column">
        <h1 style="text-align: center; margin-top:30%"> Login Page </h1>

        <div class="row" style="width: 500px">
            <form>
                <div class="form-group">
                    <label style="padding: 10px 10px 10px 0px"><b>Username *</b></label>
                    <input name="username" type="text" class="form-control" id="inputUsername"
                           placeholder="Enter username">
                </div>
                <div class="form-group">
                    <label for="inputPass" style="padding: 10px 10px 10px 0px"><b>Password *</b></label>
                    <input name="password" type="password" class="form-control" id="inputPass"
                           placeholder="Password">
                </div>

                <div style="color: red; padding: 10px 10px 10px 0px">${message}</div>

                <div class="d-flex justify-content-center align-items-center container"
                     style="margin: 20px 0px 0px 0px">
                    <div class="form-group">
                        <div class="column">
                            <div class="row">
                                <button  formaction="/login" formmethod="post"  class="btn btn-primary">Login</button>
                            </div>
                            <div class="row" style="margin: 5px 0px 0px 40px">
                                <a href="/signup.jsp">Sign up</a>
                            </div>
                            <div class="row" style="margin: 5px 0px 0px 5px">
                                <button style="background: transparent; text-decoration: underline;
                            color: cornflowerblue;
                             text-decoration-color: cornflowerblue; border: none"
                                        formaction="/forgotPassword" formmethod="post">
                                    Forgot password?
                                </button>
                            </div>
                        </div>
                    </div>
                </div>
            </form>
        </div>
    </div>
</div>
</body>
</html>