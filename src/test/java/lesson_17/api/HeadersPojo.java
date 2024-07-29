package lesson_17.api;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;
import java.util.function.Predicate;

@JsonIgnoreProperties(ignoreUnknown = true)
public class HeadersPojo {
    private String host;
    @JsonProperty("x-forwarded-proto")
    public String forwardedProto;
    @JsonProperty("x-forwarded-port")
    public String forwardedPort;
    @JsonProperty("content-type")
    public String contentType;
    @JsonProperty("user-agent")
    public String userAgent;
    @JsonProperty("accept-encoding")
    public String acceptEncoding;

    public HeadersPojo() {
    }

    public HeadersPojo(String host, String forwardedProto, String forwardedPort, String contentType, String userAgent, String acceptEncoding) {
        this.host = host;
        this.forwardedProto = forwardedProto;
        this.forwardedPort = forwardedPort;
        this.contentType = contentType;
        this.userAgent = userAgent;
        this.acceptEncoding = acceptEncoding;
    }

    public String getHost() {
        return host;
    }

    public String getForwardedProto() {
        return forwardedProto;
    }

    public String getForwardedPort() {
        return forwardedPort;
    }


    public String getContentType() {
        return contentType;
    }

    public String getUserAgent() {
        return userAgent;
    }

    public String getAcceptEncoding() {
        return acceptEncoding;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public void setForwardedProto(String forwardedProto) {
        this.forwardedProto = forwardedProto;
    }

    public void setForwardedPort(String forwardedPort) {
        this.forwardedPort = forwardedPort;
    }


    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    public void setUserAgent(String userAgent) {
        this.userAgent = userAgent;
    }

    public void setAcceptEncoding(String acceptEncoding) {
        this.acceptEncoding = acceptEncoding;
    }

    public Boolean isTrueListCon(List<String> listX) {
        boolean result = false;
        List<String> list = List.of(getHost(), getForwardedProto(), getForwardedPort(), getContentType(), getUserAgent(),
                getAcceptEncoding());

        for(String one : listX){
            result = (list.contains(one));
        }
        return result;
    }
}



