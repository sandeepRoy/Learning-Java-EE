package cdilifecycles.cdilifecycles;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;

import java.util.logging.Level;
import java.util.logging.Logger;

@ApplicationScoped
@Path("/demo")
public class DemoLifecycle {
    @Inject
    private DemoBean demoBean;

    @GET
    @Path("/show")
    public void showData() {
        System.out.println(demoBean.showData());
    }

    @GET
    @Path("/post-construct")
    @PostConstruct
    public void postConstruct() {
        System.out.println("Post Construct Method Called");
    }

    @GET
    @Path("/pre-destroy")
    @PreDestroy
    public void preDestroy() {
        System.out.println("Pre Destroy Method Called");
    }
}
