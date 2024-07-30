package lesson_17.api;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
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

    public Boolean isListEqual(List<String> headersList) {
        boolean result = false;
        List<String> list = List.of(getHost(), getForwardedProto(), getForwardedPort(), getContentType(), getUserAgent(),
                getAcceptEncoding());

        for(String one : headersList){
            result = (list.contains(one));
            if (!result) break;
        }
        return result;
    }
}



