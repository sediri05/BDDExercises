package Framework.Utilities;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.w3c.dom.*;


public class Log {
    static Logger log = LogManager.getLogger(Log.class.getName());


    public static void startLog(String message){
        log.info("******************************************************************************");
        log.info("******************************************************************************");
        log.info("*******************************" + message + "*******************************");
        log.info("******************************************************************************");
        log.info("******************************************************************************");
    }

    public static void endLog(String message){
        log.info("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
        log.info("+++++++++++++++++++++++++++++++" + message + "+++++++++++++++++++++++++++++++");
        log.info("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
    }


    public static void info(String message){
        log.info(message);
    }

    public static void warn(String message){
        log.info(message);
    }

    public static void error(String message){
        log.info(message);
    }

    public static void fatal(String message){
        log.info(message);
    }

    public static void debug(String message){
        log.info(message);
    }


}
