import java.text.SimpleDateFormat;
import java.util.Date;

public class Logger {

    protected long num = 1;
    private static Logger logger;
    private final String dateTimeInfo;

    public void log(String msg) {
        System.out.println("{[" + dateTimeInfo + "]  " + num++ + "]} " + msg);
    }

    private Logger() {
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd.MM.yyyy hh:mm:ss.ssss");
        this.dateTimeInfo = simpleDateFormat.format(date);
    }

    public static Logger getInstance() {
        return logger != null ? logger : (logger = new Logger());
    }
}