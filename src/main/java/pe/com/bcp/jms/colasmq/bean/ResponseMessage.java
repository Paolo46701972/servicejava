package pe.com.bcp.jms.colasmq.bean;

import lombok.Getter;
import lombok.Setter;

import java.util.Map;

@Getter
@Setter
public class ResponseMessage {
    private String message;
    private Map<String, Object> body;
    private Integer status;

    public ResponseMessage() {
    }

    public ResponseMessage(String message, Integer status) {
        this.message = message;
        this.status = status;
    }
}
