/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.api.ocu;

import de.vw.mib.asl.api.ocu.OCUServiceProvider$Version1_0;
import de.vw.mib.asl.api.ocu.onlineupdatev10.OnlineUpdateServiceProvider;
import de.vw.mib.asl.api.ocu.onlinev10.OnlineNetworkServiceProvider;
import de.vw.mib.asl.api.ocu.voiceservices10.VoiceServiceProvider;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.log4mib.Logger;
import de.vw.mib.log4mib.LoggerFactory;
import org.osgi.framework.ServiceReference;

public final class OCUServiceProvider {
    private OnlineNetworkServiceProvider onlineNetworkService;
    private VoiceServiceProvider voiceService;
    private OnlineUpdateServiceProvider olineUpdateServiceProvider;
    private static String ONLINE_NETWORK_SERVICE_CLASS_NAME = "de.vw.mib.asl.internal.ocu.common.api.onlinev10.OnlineNetworkServiceProvider";
    private static String VOICE_SERVICE_CLASS_NAME = "de.vw.mib.asl.internal.ocu.common.api.voiceservices10.VoiceServiceProvider";
    private static String ONLINE_UPDATE_SERVICE_CLASS_NAME = "de.vw.mib.asl.internal.ocu.common.api.onlineupdatev10.OnlineUpdateServiceProvider";
    private static OCUServiceProvider serviceProvider;
    public static final OCUServiceProvider$Version1_0 NETWORK_SERVICE_VERSION_1_0;
    public static final OCUServiceProvider$Version1_0 VOICE_SERVICE_VERSION_1_0;
    public static final OCUServiceProvider$Version1_0 UPDATE_SERVICE_VERSION_1_0;
    static /* synthetic */ Class class$de$vw$mib$log4mib$LoggerFactory;

    private OCUServiceProvider() {
    }

    private static OnlineNetworkServiceProvider createOnlineNetworkServiceProxy() {
        OnlineNetworkServiceProvider onlineNetworkServiceProvider;
        try {
            onlineNetworkServiceProvider = (OnlineNetworkServiceProvider)Class.forName(ONLINE_NETWORK_SERVICE_CLASS_NAME).newInstance();
        }
        catch (Exception exception) {
            OCUServiceProvider.createLogger().error(1, "Could not create BAP-OCU-OnlineNetworkService interface proxy", exception);
            onlineNetworkServiceProvider = null;
        }
        return onlineNetworkServiceProvider;
    }

    private static VoiceServiceProvider createVoiceServiceProxy() {
        VoiceServiceProvider voiceServiceProvider;
        try {
            voiceServiceProvider = (VoiceServiceProvider)Class.forName(VOICE_SERVICE_CLASS_NAME).newInstance();
        }
        catch (Exception exception) {
            OCUServiceProvider.createLogger().error(1, "Could not create BAP-OCU-VoiceService interface proxy", exception);
            voiceServiceProvider = null;
        }
        return voiceServiceProvider;
    }

    private static OnlineUpdateServiceProvider createOnlineUpdateServiceProxy() {
        OnlineUpdateServiceProvider onlineUpdateServiceProvider;
        try {
            onlineUpdateServiceProvider = (OnlineUpdateServiceProvider)Class.forName(ONLINE_UPDATE_SERVICE_CLASS_NAME).newInstance();
        }
        catch (Exception exception) {
            OCUServiceProvider.createLogger().error(1, "Could not create BAP-OCU-OnlineUpdateService interface proxy", exception);
            onlineUpdateServiceProvider = null;
        }
        return onlineUpdateServiceProvider;
    }

    private static Logger createLogger() {
        Logger logger = null;
        LoggerFactory loggerFactory = (LoggerFactory)OCUServiceProvider.getService(class$de$vw$mib$log4mib$LoggerFactory == null ? (class$de$vw$mib$log4mib$LoggerFactory = OCUServiceProvider.class$("de.vw.mib.log4mib.LoggerFactory")) : class$de$vw$mib$log4mib$LoggerFactory);
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

    public static OCUServiceProvider getServiceProvider() {
        if (serviceProvider == null) {
            serviceProvider = new OCUServiceProvider();
        }
        return serviceProvider;
    }

    public OnlineNetworkServiceProvider getOnlineNetworkService(OCUServiceProvider$Version1_0 version1_0) {
        if (this.onlineNetworkService == null) {
            this.onlineNetworkService = OCUServiceProvider.createOnlineNetworkServiceProxy();
        }
        return this.onlineNetworkService;
    }

    public VoiceServiceProvider getVoiceServiceProvider(OCUServiceProvider$Version1_0 version1_0) {
        if (this.voiceService == null) {
            this.voiceService = OCUServiceProvider.createVoiceServiceProxy();
        }
        return this.voiceService;
    }

    public OnlineUpdateServiceProvider getOnlineUpdateServiceProvider(OCUServiceProvider$Version1_0 version1_0) {
        if (this.olineUpdateServiceProvider == null) {
            this.olineUpdateServiceProvider = OCUServiceProvider.createOnlineUpdateServiceProxy();
        }
        return this.olineUpdateServiceProvider;
    }

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError().initCause(classNotFoundException);
        }
    }

    static {
        NETWORK_SERVICE_VERSION_1_0 = new OCUServiceProvider$Version1_0();
        VOICE_SERVICE_VERSION_1_0 = new OCUServiceProvider$Version1_0();
        UPDATE_SERVICE_VERSION_1_0 = new OCUServiceProvider$Version1_0();
    }
}

