/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.clientapi.impl;

import de.vw.mib.asl.clientapi.ASLClientAPI;
import de.vw.mib.asl.clientapi.ASLClientAPIRegistry;
import de.vw.mib.asl.clientapi.ASLClientAPIService;
import de.vw.mib.asl.clientapi.impl.ASLClientAPIBridge;
import de.vw.mib.asl.clientapi.impl.ASLClientAPIBridge$Services;
import de.vw.mib.asl.clientapi.impl.ASLClientAPIRegistryImpl$1;
import de.vw.mib.asl.clientapi.impl.ServicesImpl;
import de.vw.mib.log4mib.ClassifiedLogger;
import de.vw.mib.log4mib.LogMessage;
import de.vw.mib.log4mib.Logger;
import java.lang.reflect.Constructor;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

class ASLClientAPIRegistryImpl
implements ASLClientAPIRegistry {
    private final Map apis = Collections.synchronizedMap(new HashMap());
    private final ServicesImpl services;
    private final ClassifiedLogger clogger;
    private static final Class[] BRIDGE_CONSTR_PARAMS = new Class[]{Integer.TYPE, class$de$vw$mib$asl$clientapi$impl$ASLClientAPIBridge$Services == null ? (class$de$vw$mib$asl$clientapi$impl$ASLClientAPIBridge$Services = ASLClientAPIRegistryImpl.class$("de.vw.mib.asl.clientapi.impl.ASLClientAPIBridge$Services")) : class$de$vw$mib$asl$clientapi$impl$ASLClientAPIBridge$Services};
    private static final String LOG_SEPARATOR;
    static /* synthetic */ Class class$de$vw$mib$asl$clientapi$ASLClientAPI;
    static /* synthetic */ Class class$de$vw$mib$asl$clientapi$impl$ASLClientAPIBridge$Services;

    ASLClientAPIRegistryImpl(ServicesImpl servicesImpl) {
        this.services = servicesImpl;
        this.clogger = servicesImpl.getClassifiedLogger();
    }

    @Override
    public void registerAPIService(Class clazz, int n, ASLClientAPIService aSLClientAPIService) {
        if (null == clazz) {
            throw new NullPointerException("class");
        }
        if (!(class$de$vw$mib$asl$clientapi$ASLClientAPI == null ? (class$de$vw$mib$asl$clientapi$ASLClientAPI = ASLClientAPIRegistryImpl.class$("de.vw.mib.asl.clientapi.ASLClientAPI")) : class$de$vw$mib$asl$clientapi$ASLClientAPI).isAssignableFrom(clazz)) {
            throw new IllegalArgumentException(new StringBuffer().append("Not an ASLClientAPI class: ").append(clazz.getName()).toString());
        }
        if (0 > n) {
            throw new IllegalArgumentException(new StringBuffer().append("instId=").append(n).toString());
        }
        if (null == aSLClientAPIService) {
            throw new NullPointerException("service");
        }
        LogMessage logMessage = this.clogger.trace();
        if (null != logMessage) {
            logMessage.append("registering API service: ");
            ASLClientAPIRegistryImpl.appendClassInstId(logMessage, clazz, n, false);
            logMessage.log();
        }
        ASLClientAPIBridge aSLClientAPIBridge = this.getAPIBridge(clazz, n);
        aSLClientAPIBridge.bind(aSLClientAPIService);
    }

    @Override
    public ASLClientAPI getAPI(Class clazz, int n) {
        if (null == clazz) {
            throw new NullPointerException("class");
        }
        if (!(class$de$vw$mib$asl$clientapi$ASLClientAPI == null ? (class$de$vw$mib$asl$clientapi$ASLClientAPI = ASLClientAPIRegistryImpl.class$("de.vw.mib.asl.clientapi.ASLClientAPI")) : class$de$vw$mib$asl$clientapi$ASLClientAPI).isAssignableFrom(clazz)) {
            throw new IllegalArgumentException(new StringBuffer().append("Not an ASLClientAPI class: ").append(clazz.getName()).toString());
        }
        if (0 > n) {
            throw new IllegalArgumentException(new StringBuffer().append("instId=").append(n).toString());
        }
        LogMessage logMessage = this.clogger.trace();
        if (null != logMessage) {
            logMessage.append("getAPI: ");
            ASLClientAPIRegistryImpl.appendClassInstId(logMessage, clazz, n, false);
            logMessage.log();
        }
        return this.getAPIBridge(clazz, n);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private ASLClientAPIBridge getAPIBridge(Class clazz, int n) {
        ASLClientAPIBridge aSLClientAPIBridge;
        Object object = ASLClientAPIRegistryImpl.createKey(clazz, n);
        Map map = this.apis;
        synchronized (map) {
            aSLClientAPIBridge = (ASLClientAPIBridge)this.apis.get(object);
            if (null == aSLClientAPIBridge) {
                aSLClientAPIBridge = this.createAPIBridge(clazz, n);
                this.apis.put(object, aSLClientAPIBridge);
            }
        }
        return aSLClientAPIBridge;
    }

    private ASLClientAPIBridge createAPIBridge(Class clazz, int n) {
        try {
            String string = ASLClientAPIRegistryImpl.toBridgeName(clazz);
            Class clazz2 = Class.forName(string);
            Constructor constructor = clazz2.getConstructor(BRIDGE_CONSTR_PARAMS);
            ClassifiedLogger classifiedLogger = this.createAPILogger(clazz, n);
            return (ASLClientAPIBridge)constructor.newInstance(new Object[]{new Integer(n), this.createAPIServices(classifiedLogger)});
        }
        catch (Exception exception) {
            throw new RuntimeException(new StringBuffer().append("Could not create ASLClientAPI bridge class for ").append(clazz.getName()).toString(), exception);
        }
    }

    private ClassifiedLogger createAPILogger(Class clazz, int n) {
        int n2 = ASLClientAPIRegistryImpl.getIntField(clazz, "LOGGER_CLASSIFIER");
        int n3 = ASLClientAPIRegistryImpl.getIntField(clazz, "LOGGER_SUBCLASSIFIER");
        if (0 > n2 || 0 > n3) {
            n2 = 0x1008000;
            n3 = 32;
        }
        String string = ASLClientAPIRegistryImpl.toAPIName(clazz);
        Logger logger = this.services.getLoggerFactory().getLogger(n2);
        return new ASLClientAPIRegistryImpl$1(this, n3, new StringBuffer().append("[ASLClientAPI]:").append(string).append("[").append(n).append("] ").toString(), logger);
    }

    private ASLClientAPIBridge$Services createAPIServices(ClassifiedLogger classifiedLogger) {
        ServicesImpl servicesImpl = ServicesImpl.copy(this.services);
        servicesImpl.clogger = classifiedLogger;
        return servicesImpl;
    }

    private static int getIntField(Class clazz, String string) {
        int n;
        try {
            n = clazz.getField(string).getInt(null);
        }
        catch (Exception exception) {
            n = -1;
        }
        return n;
    }

    private static String toAPIName(Class clazz) {
        String string = clazz.getName();
        int n = string.lastIndexOf(46);
        return string.substring(n + 1);
    }

    private static String toBridgeName(Class clazz) {
        String string = clazz.getName();
        int n = string.lastIndexOf(46);
        return new StringBuffer().append(string.substring(0, n + 1)).append("impl.").append(string.substring(n + 1)).append("Bridge").toString();
    }

    private static Object createKey(Class clazz, int n) {
        return new StringBuffer().append(clazz.getName()).append("/").append(n).toString();
    }

    private static LogMessage appendClass(LogMessage logMessage, Class clazz, boolean bl) {
        if (bl) {
            logMessage.append(", ");
        }
        logMessage.append("class=").append(clazz.getName());
        return logMessage;
    }

    private static LogMessage appendInstId(LogMessage logMessage, int n, boolean bl) {
        if (bl) {
            logMessage.append(", ");
        }
        logMessage.append("instId=").append(n);
        return logMessage;
    }

    private static LogMessage appendClassInstId(LogMessage logMessage, Class clazz, int n, boolean bl) {
        ASLClientAPIRegistryImpl.appendClass(logMessage, clazz, bl);
        ASLClientAPIRegistryImpl.appendInstId(logMessage, n, true);
        return logMessage;
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

