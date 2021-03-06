package org.acme;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.TimeUnit;

import javax.transaction.Transactional;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.QueryParam;

import org.eclipse.microprofile.faulttolerance.Fallback;
import org.eclipse.microprofile.faulttolerance.Retry;
import org.eclipse.microprofile.faulttolerance.Timeout;
import org.eclipse.microprofile.faulttolerance.exceptions.FaultToleranceDefinitionException;

@Path("/developer")
public class DeveloperResource {

    private boolean misbehave = false;
    private boolean sleep = false;

    @GET
    @Path("/misbehave")
    public String misbehave() {
        misbehave = true;
        return "I am misbehaving";
    }

    @GET
    @Path("/behave")
    public String behave() {
        misbehave = false;
        return "I am back";
    }

    @GET
    @Path("/sleep")
    public String sleep() {
        sleep = true;
        return "I am sleeping";
    }

    @GET
    @Path("/awake")
    public String awake() {
        sleep = false;
        return "Neo, awake";
    }


}