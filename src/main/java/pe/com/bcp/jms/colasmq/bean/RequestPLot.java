package pe.com.bcp.jms.colasmq.bean;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RequestPLot
{
    private String message;
    private String identifier;

    @Override
    public String toString() {
        return "{\"message\": \"" + message + "\", \"identifier\":\"" + identifier + "\"}";
    }
}
