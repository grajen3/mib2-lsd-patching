/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.api.ocu.eni;

import de.vw.mib.asl.api.ocu.eni.ENIService;
import de.vw.mib.asl.api.ocu.eni.ENIServiceProvider$Version1_0;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.log4mib.Logger;
import de.vw.mib.log4mib.LoggerFactory;
import org.osgi.framework.ServiceReference;

public class ENIServiceProvider {
    private static Object _eniServiceProxy = null;
    private static String ENI_SERVICE_PROXY_CLASS_NAME = "de.vw.mib.asl.internal.ocu.eni.api.ENIServiceProxyMarshaller";
    public static final ENIServiceProvider$Version1_0 ENI_SERVICE_VERSION_1_0 = new ENIServiceProvider$Version1_0();
    static /* synthetic */ Class class$de$vw$mib$log4mib$LoggerFactory;

    private static Object createEniServiceProxy() {
        Object object;
        try {
            object = Class.forName(ENI_SERVICE_PROXY_CLASS_NAME).newInstance();
        }
        catch (Exception exception) {
            ENIServiceProvider.createLogger().error(1, "Could not create BAP-OCU-ENI interface proxy", exception);
            object = null;
        }
        return object;
    }

    private static Object getENIServiceProxy() {
        if (_eniServiceProxy == null) {
            _eniServiceProxy = ENIServiceProvider.createEniServiceProxy();
        }
        return _eniServiceProxy;
    }

    private static Logger createLogger() {
        Logger logger = null;
        LoggerFactory loggerFactory = (LoggerFactory)ENIServiceProvider.getService(class$de$vw$mib$log4mib$LoggerFactory == null ? (class$de$vw$mib$log4mib$LoggerFactory = ENIServiceProvider.class$("de.vw.mib.log4mib.LoggerFactory")) : class$de$vw$mib$log4mib$LoggerFactory);
        if (loggerFactory != null) {
            logger = loggerFactory.getLogger(2);
        }
        return logger;
    }

    private static Object getService(Class clazz) {
        ServiceReference serviceReference = ServiceManager.bundleContext.getServiceReference(clazz.getName());
        Object object = serviceReference != null ? ServiceManager.bundleContext.getService(serviceReference) : null;
        return object;
    }

    public static ENIService getENIService(ENIServiceProvider$Version1_0 version1_0) {
        return (ENIService)ENIServiceProvider.getENIServiceProxy();
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

