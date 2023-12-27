/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechnavigation.common;

import de.vw.mib.asl.framework.api.framework.ASLFrameworkFactory;
import de.vw.mib.log4mib.Logger;
import de.vw.mib.log4mib.LoggerFactory;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;

public final class AppLogger {
    private static Logger logger;
    static /* synthetic */ Class class$de$vw$mib$log4mib$LoggerFactory;

    public static void error(String string) {
        AppLogger.getLogger().error(16384, string);
    }

    public static void error(Object object, String string) {
        AppLogger.error(new StringBuffer().append(AppLogger.getSimpleName(object)).append(string).toString());
    }

    public static void info(String string) {
        if (AppLogger.getLogger().isTraceEnabled(16384)) {
            AppLogger.getLogger().info(16384, string);
        }
    }

    public static void info(Object object, String string) {
        AppLogger.info(new StringBuffer().append(AppLogger.getSimpleName(object)).append(string).toString());
    }

    public static void warn(String string) {
        if (AppLogger.getLogger().isTraceEnabled(16384)) {
            AppLogger.getLogger().warn(16384, string);
        }
    }

    public static void warn(Object object, String string) {
        AppLogger.warn(new StringBuffer().append(AppLogger.getSimpleName(object)).append(string).toString());
    }

    public static void trace(String string) {
        if (AppLogger.getLogger().isTraceEnabled(16384)) {
            AppLogger.getLogger().trace(16384, string);
        }
    }

    public static void trace(Object object, String string) {
        AppLogger.trace(new StringBuffer().append(AppLogger.getSimpleName(object)).append(string).toString());
    }

    public static boolean isLoggingEnabled() {
        return AppLogger.getLogger().isTraceEnabled(16384);
    }

    private static Logger getLogger() {
        if (logger == null) {
            LoggerFactory loggerFactory = (LoggerFactory)AppLogger.retrieveService(class$de$vw$mib$log4mib$LoggerFactory == null ? (class$de$vw$mib$log4mib$LoggerFactory = AppLogger.class$("de.vw.mib.log4mib.LoggerFactory")) : class$de$vw$mib$log4mib$LoggerFactory);
            logger = loggerFactory.getLogger(4096);
        }
        return logger;
    }

    private static Object retrieveService(Class clazz) {
        BundleContext bundleContext = ASLFrameworkFactory.getASLFrameworkAPI().getServices().getBundleContext();
        ServiceReference serviceReference = bundleContext.getServiceReference(clazz.getName());
        return bundleContext.getService(serviceReference);
    }

    private static String getSimpleName(Object object) {
        String string = object.getClass().getName();
        int n = string.lastIndexOf(46);
        if (n != -1) {
            string = string.substring(n + 1);
        }
        return string;
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

