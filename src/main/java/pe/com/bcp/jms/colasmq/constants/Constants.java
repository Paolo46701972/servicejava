package pe.com.bcp.jms.colasmq.constants;

public enum Constants {
    ;

    //Colas MQ
    public static final String QUEUE_REQUEST = "JMS.REQUEST";
    public static final String QUEUE_RESPONSE = "JMS.RESPONSE";

    
    //Indices
    public static final Integer INDEX_RESPONSE = 18;
    public static final Integer SIZE_PLOT = 427;
    public static final Integer START_COD_ENTERPRISE = 15;
    public static final Integer TYPE_OPER = 6;
    public static final Integer DATE_HOUR = 14;
    public static final Integer CHANNEL = 2;
    public static final Integer NUMBER_OPER = 8;

    //Tipo de trama
    public static final String REQUEST = "REQUEST";
    public static final String RESPONSE = "RESPONSE";

    //Target
    public static final String TARGET_PLOT_START = "<Data>";
    public static final String TARGET_PLOT_END = "</Data>";

    //Format Date
    public static final String DATE_FORMAT_1 = "yyyyMMddHHmmss";
    public static final String DATE_FORMAT_2 = "yyyy-MM-dd HH:mm:ss";
    public static final String DATE_FORMAT_3 = "MM/dd/yy HH:mm:ss";
    public static final String DATE_FORMAT_4 = "MM/dd/yy";

    //Regex
    public static final String COMMA = ",";
    public static final String SLASH_SLASH_PLUS = "\\+";
    public static final String VOID_STRING = " ";

}
