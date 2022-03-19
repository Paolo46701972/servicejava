package pe.com.bcp.jms.colasmq.bean;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Mensaje {
	private String nombreInstancia;
	private String[] datoLogs;
	private String horaEjecucionLogs;
	private String codRevisionEstado;
	private String resErrorRevEstado;
	private String estadoInstancia;
	private String reinicio;
	private String horaReinicio;
	private String estadoFinal;
	private String resultadoReinicio;
	private Float disponibilidadInstancia;
}
