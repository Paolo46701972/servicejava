package pe.com.bcp.jms.colasmq.bean;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MessageTransport {
	
	private String identifier;
	private Mensaje message;
}
