package pe.com.bcp.jms.colasmq.bean;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class CamposBean {
	
	private String codigoEstado;
	private String codEmpresa;
	private String tipoOperacion;
	private String fechaHora;
	private String canal;
	private String numOperacion;
}
