package cdilifecycles.cdilifecycles;

import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class DemoBean {
    public String showData() {
        return "Demo Bean";
    }
}
