/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.api.ocu.ecall;

import de.vw.mib.asl.api.ocu.ecall.ECallService;
import de.vw.mib.asl.api.ocu.ecall.ECallServiceProvider$Version1_0;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.log4mib.Logger;
import de.vw.mib.log4mib.LoggerFactory;
import org.osgi.framework.ServiceReference;

public class ECallServiceProvider {
    private static Object _eCallInterfaceProxy = null;
    private static String ECALL_INTERFACE_PROXY_CLASS_NAME = "de.vw.mib.asl.internal.ocu.ecall.api.ECallServiceProxyMarshaller";
    public static final ECallServiceProvider$Version1_0 ECALL_SERVICE_VERSION_1_0 = new ECallServiceProvider$Version1_0();
    static /* synthetic */ Class class$de$vw$mib$log4mib$LoggerFactory;

    private static Object createECallInterfaceProxy() {
        Object object;
        try {
            object = Class.forName(ECALL_INTERFACE_PROXY_CLASS_NAME).newInstance();
        }
        catch (Exception exception) {
            ECallServiceProvider.createLogger().error(1, "Could not create BAP-OCU-ECall interface proxy", exception);
            object = null;
        }
        return object;
    }

    private static Object getECallServiceProxy() {
        if (_eCallInterfaceProxy == null) {
            _eCallInterfaceProxy = ECallServiceProvider.createECallInterfaceProxy();
        }
        return _eCallInterfaceProxy;
    }

    private static Logger createLogger() {
        Logger logger = null;
        LoggerFactory loggerFactory = (LoggerFactory)ECallServiceProvider.getService(class$de$vw$mib$log4mib$LoggerFactory == null ? (class$de$vw$mib$log4mib$LoggerFactory = ECallServiceProvider.class$("de.vw.mib.log4mib.LoggerFactory")) : class$de$vw$mib$log4mib$LoggerFactory);
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

    public static ECallService getECallService(ECallServiceProvider$Version1_0 version1_0) {
        return (ECallService)ECallServiceProvider.getECallServiceProxy();
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

