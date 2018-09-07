package com.mei1.knowlegebase.web;

import javax.ws.rs.POST;
import javax.ws.rs.Path;

import org.springframework.stereotype.Controller;

import com.mei1.knowlegebase.common.web.Result;

@Controller
@Path("users")
public class UserController {

    @POST
    @Path("login")
    public Result<String> login() {
        return Result.ok("success");
    }

}
