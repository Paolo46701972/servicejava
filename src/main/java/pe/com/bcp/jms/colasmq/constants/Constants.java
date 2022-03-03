package pe.com.bcp.jms.colasmq.constants;

public enum Constants {
    ;

    //Colas MQ
    public static final String QUEUE_REQUEST = "JMS.REQUEST";
    public static final String QUEUE_RESPONSE = "JMS.RESPONSE";

    //Codigos de estado
    public static final String[] CODIGOS_ESTADO = {
            "CP0133", "CP0135", "CP0095", "CP0138", "CP0037", "CP0004", "CP0053", "CP0103",
            "CP0080", "CP0000", "CP0010", "CP0006", "CP0141", "CP0140", "CP0142", "CP0139",
            "CP0000", "CP0000", "CP0000", "CP0000", "CP0000", "CP0000", "CP0000", "CP0000",
            "CP0000", "CP0000", "CP0000", "CP0000"};

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
    public static final String WAS = "WAS";

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

    //Inicializacion
    public static final Float ZERO_F = 0F;
    public static final Long ZERO_L = 0L;
    public static final Double ZERO_D = 0D;
    public static final Integer MILLISECOND = 3600000;
    public static final Integer DAY_HOUR = 24;
    public static final Integer PERCENTAGE_TOTAL = 100;

    //Estado instancia
    public static final String STOPPED = "STOPPED";
    public static final String STARTED = "STARTED";

}
