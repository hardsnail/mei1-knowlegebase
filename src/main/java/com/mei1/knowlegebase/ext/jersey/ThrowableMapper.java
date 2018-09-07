package com.mei1.knowlegebase.ext.jersey;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import com.mei1.knowlegebase.common.web.Result;
import com.mei1.knowlegebase.constant.ErrorCodeConstant;

@Provider
public class ThrowableMapper implements ExceptionMapper<Throwable> {

    @Override
    public Response toResponse(Throwable exception) {
        OutputStream os = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(os);
        exception.printStackTrace(ps);
        Result<String> result = Result.failure(ErrorCodeConstant.UNKNOWN_ERROR);
        result.setMessage(os.toString());
        return Response.accepted().status(Status.ACCEPTED).entity(result).build();
    }

}
