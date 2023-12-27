/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib;

import de.vw.mib.MIBMain$1;
import de.vw.mib.extstartup.spi.ExtendedStartupSPI;
import de.vw.mib.log4mib.Logger;
import de.vw.mib.log4mib.classifier.StartupClassifier;
import de.vw.mib.log4mib.internal.MainLogger;
import de.vw.mib.osgi.MIBOsgi;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import org.osgi.framework.BundleException;

public final class MIBMain
implements StartupClassifier {
    public static final String BUNDLES_PROPERTIES;
    public static final String BUNDLES_PROPERTIES_FROM_JXE;
    public static final String DEFAULT_BUNDLES_PROPERTIES;
    public static final String DEFAULT_LOGGING_PROPERTY_FILE_NAME;
    public static final String EXTENDED_STARTUP_CLASS_PROPERTY;
    public static final String LOGGING_PROPERTIES;
    public static final String MAIN_THREAD_PRIORITY;
    public static final String STARTUPFLAG;
    public static final String STARTUPORDER;
    private static Logger logger;
    static /* synthetic */ Class class$de$vw$mib$MIBMain;

    public static void main(String[] stringArray) {
        Thread thread = new Thread(new MIBMain$1());
        thread.setName("MAIN_THREAD");
        String string = System.getProperty("de.vw.mib.main.thread.prio");
        if (string == null) {
            thread.setPriority(6);
        } else {
            thread.setPriority(Integer.parseInt(string));
        }
        thread.start();
    }

    public static void shutdown() {
        logger.info(1, "Shutting down MIB ...");
        MIBOsgi mIBOsgi = MIBOsgi.getInstance();
        mIBOsgi.stopBundles();
    }

    public static void start() {
        MainLogger.initLogger();
        logger = MainLogger.getLoggerFactory().getLogger(16384);
        logger.info(1, "Launching MIB ...");
        ExtendedStartupSPI extendedStartupSPI = MIBMain.createExtendedStartupSPI();
        Properties properties = MIBMain.loadBundlesProperties();
        if (properties == null) {
            logger.fatal(1, "Starting MIB aborted!");
            return;
        }
        String string = System.getProperty("de.vw.mib.startup.order");
        String string2 = System.getProperty("de.vw.mib.startup.flag");
        MIBOsgi mIBOsgi = MIBOsgi.getInstance();
        try {
            if (string == null) {
                logger.info(1, "Starting HMI with default startup order");
                mIBOsgi.init(extendedStartupSPI, properties);
            } else if (string2 == null) {
                logger.info(1).append("Starting HMI with startup order: ").append(string).log();
                mIBOsgi.init(extendedStartupSPI, properties, string);
            } else {
                logger.info(1).append("Starting HMI with startup order: ").append(string).append(" - ").append(string2).log();
                mIBOsgi.init(extendedStartupSPI, properties, string, string2);
            }
        }
        catch (BundleException bundleException) {
            logger.error(1).append("Error while loading bundles properties!").attachThrowable(bundleException).log();
        }
        try {
            mIBOsgi.startSPIBundles();
        }
        catch (BundleException bundleException) {
            logger.error(1).append("Error while starting SPI bundles!").attachThrowable(bundleException).log();
        }
        try {
            mIBOsgi.startAutostartBundles();
        }
        catch (BundleException bundleException) {
            logger.error(1).append("Error while starting autostart bundles!").attachThrowable(bundleException).log();
        }
    }

    private static ExtendedStartupSPI createExtendedStartupSPI() {
        String string = System.getProperty("extendedStartupSPI.class");
        if (string == null) {
            logger.normal(1, "No Extended-Startup-SPI class specified!");
            return null;
        }
        logger.normal(1).append("Loading Extended-Startup-SPI class: '").append(string).append("' ...").log();
        try {
            Class clazz = Class.forName(string);
            return (ExtendedStartupSPI)clazz.newInstance();
        }
        catch (ClassNotFoundException classNotFoundException) {
            logger.error(1).append("Extended-Startup-SPI class not found!").attachThrowable(classNotFoundException).log();
        }
        catch (IllegalAccessException illegalAccessException) {
            logger.error(1).append("Illegal access of Extended-Startup-SPI class").attachThrowable(illegalAccessException).log();
        }
        catch (InstantiationException instantiationException) {
            logger.error(1).append("Extended-Startup-SPI class can't be instantiated").attachThrowable(instantiationException).log();
        }
        return null;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private static Properties loadBundlesProperties() {
        Properties properties = new Properties();
        String string = System.getProperty("bundles.properties");
        InputStream inputStream = null;
        if ("jxe".equals(string)) {
            inputStream = (class$de$vw$mib$MIBMain == null ? (class$de$vw$mib$MIBMain = MIBMain.class$("de.vw.mib.MIBMain")) : class$de$vw$mib$MIBMain).getResourceAsStream("/bundles.properties");
            logger.normal(1, "Loading bundles properties from jxe ...");
        } else {
            if (string == null || string.length() == 0) {
                string = "config/bundles.properties";
            }
            logger.normal(1).append("Loading bundles properties from '").append(string).append("' ...").log();
            try {
                inputStream = new FileInputStream(string);
            }
            catch (FileNotFoundException fileNotFoundException) {
                inputStream = (class$de$vw$mib$MIBMain == null ? (class$de$vw$mib$MIBMain = MIBMain.class$("de.vw.mib.MIBMain")) : class$de$vw$mib$MIBMain).getResourceAsStream("/bundles.properties");
            }
        }
        if (inputStream == null) {
            logger.error(1, "Bundles properties not found!");
            return null;
        }
        try {
            properties.load(inputStream);
        }
        catch (IOException iOException) {
            logger.error(1).append("Error while loading bundles properties!").attachThrowable(iOException).log();
        }
        finally {
            try {
                if (inputStream != null) {
                    inputStream.close();
                }
            }
            catch (IOException iOException) {}
        }
        return properties;
    }

    private MIBMain() {
    }

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError().initCause(classNotFoundException);
        }
    }
}

