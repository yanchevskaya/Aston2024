package lesson_17.api;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class EchoPojo {

    private String foo1;
    private String foo2;

    public EchoPojo() {
    }

    public EchoPojo(String foo1, String foo2) {
        this.foo1 = foo1;
        this.foo2 = foo2;
    }

    public String getFoo1() {
        return foo1;
    }

    public String getFoo2() {
        return foo2;
    }

    public void setFoo1(String foo1) {
        this.foo1 = foo1;
    }

    public void setFoo2(String foo2) {
        this.foo2 = foo2;
    }
}
