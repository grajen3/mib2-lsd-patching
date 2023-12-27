/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.api.online;

import de.vw.mib.asl.api.online.ASLOnlineAPI;
import de.vw.mib.asl.api.online.ASLOnlineCoreServices;
import de.vw.mib.asl.api.online.services.authenticate.OnlineAuthentication;
import de.vw.mib.asl.api.online.services.statusbar.OnlineStatusService;
import de.vw.mib.asl.api.online.services.verification.CarNetPinVerificationService;
import de.vw.mib.asl.framework.api.framework.ASLFactoryBase;

public final class ASLOnlineFactory
extends ASLFactoryBase {
    private static final String ONLINE_CORE_CLASS_NAME;
    private static final String ONLINE_STATUS_CLASS_NAME;
    private static final String CAR_NET_PIN_CLASS_NAME;
    private static final String AUTHENTICATION_CLASS_NAME;
    private static ASLOnlineAPI apiInstance;
    private static ASLOnlineCoreServices _coreServices;
    private static OnlineStatusService _statusService;
    private static CarNetPinVerificationService _carNetPinService;
    private static OnlineAuthentication _authenticationService;
    static /* synthetic */ Class class$de$vw$mib$asl$api$online$ASLOnlineAPI;
    static /* synthetic */ Class class$de$vw$mib$asl$api$online$ASLOnlineCoreServices;
    static /* synthetic */ Class class$de$vw$mib$asl$api$online$services$statusbar$OnlineStatusService;
    static /* synthetic */ Class class$de$vw$mib$asl$api$online$services$verification$CarNetPinVerificationService;
    static /* synthetic */ Class class$de$vw$mib$asl$api$online$services$authenticate$OnlineAuthentication;

    public static ASLOnlineAPI getOnlineApi() {
        if (apiInstance == null) {
            apiInstance = (ASLOnlineAPI)ASLOnlineFactory.createServiceInstance(class$de$vw$mib$asl$api$online$ASLOnlineAPI == null ? (class$de$vw$mib$asl$api$online$ASLOnlineAPI = ASLOnlineFactory.class$("de.vw.mib.asl.api.online.ASLOnlineAPI")) : class$de$vw$mib$asl$api$online$ASLOnlineAPI, "de.vw.mib.asl.internal.online.api.impl.ASLOnlineAPIImpl");
        }
        return apiInstance;
    }

    public static ASLOnlineCoreServices getOnlineCoreServices() {
        if (_coreServices == null) {
            _coreServices = (ASLOnlineCoreServices)ASLOnlineFactory.createServiceInstance(class$de$vw$mib$asl$api$online$ASLOnlineCoreServices == null ? (class$de$vw$mib$asl$api$online$ASLOnlineCoreServices = ASLOnlineFactory.class$("de.vw.mib.asl.api.online.ASLOnlineCoreServices")) : class$de$vw$mib$asl$api$online$ASLOnlineCoreServices, "de.vw.mib.asl.internal.online.coreImpl.ASLOnlineCoreServicesImpl");
        }
        return _coreServices;
    }

    public static OnlineStatusService getOnlineStatusService() {
        if (_statusService == null) {
            _statusService = (OnlineStatusService)ASLOnlineFactory.createServiceInstance(class$de$vw$mib$asl$api$online$services$statusbar$OnlineStatusService == null ? (class$de$vw$mib$asl$api$online$services$statusbar$OnlineStatusService = ASLOnlineFactory.class$("de.vw.mib.asl.api.online.services.statusbar.OnlineStatusService")) : class$de$vw$mib$asl$api$online$services$statusbar$OnlineStatusService, "de.vw.mib.asl.internal.online.coreImpl.services.OnlineStatusServiceImpl");
        }
        return _statusService;
    }

    public static CarNetPinVerificationService getCarNetPinVerificationService() {
        if (_carNetPinService == null) {
            _carNetPinService = (CarNetPinVerificationService)ASLOnlineFactory.createServiceInstance(class$de$vw$mib$asl$api$online$services$verification$CarNetPinVerificationService == null ? (class$de$vw$mib$asl$api$online$services$verification$CarNetPinVerificationService = ASLOnlineFactory.class$("de.vw.mib.asl.api.online.services.verification.CarNetPinVerificationService")) : class$de$vw$mib$asl$api$online$services$verification$CarNetPinVerificationService, "de.vw.mib.asl.internal.online.coreImpl.coreservice.services.CarNetPinVerificationServiceImpl");
        }
        return _carNetPinService;
    }

    public static OnlineAuthentication getAuthenticationService() {
        if (_authenticationService == null) {
            _authenticationService = (OnlineAuthentication)ASLOnlineFactory.createServiceInstance(class$de$vw$mib$asl$api$online$services$authenticate$OnlineAuthentication == null ? (class$de$vw$mib$asl$api$online$services$authenticate$OnlineAuthentication = ASLOnlineFactory.class$("de.vw.mib.asl.api.online.services.authenticate.OnlineAuthentication")) : class$de$vw$mib$asl$api$online$services$authenticate$OnlineAuthentication, "de.vw.mib.asl.internal.online.coreImpl.coreservice.services.OnlineAuthenticationImpl");
        }
        return _authenticationService;
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
        apiInstance = null;
    }
}

