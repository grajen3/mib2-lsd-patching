/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.online.coreImpl.coreservice;

import de.vw.mib.asl.internal.online.coreImpl.coreservice.control.CoreServiceController;
import de.vw.mib.asl.internal.online.coreImpl.coreservice.control.CoreServiceNotifier;
import de.vw.mib.asl.internal.online.coreImpl.coreservice.impl.CoreServiceAdapterListenerImpl;
import de.vw.mib.asl.internal.online.coreImpl.coreservice.impl.CoreServiceAdapterUpdateListenerImpl;
import de.vw.mib.asl.internal.online.coreImpl.coreservice.impl.CoreServiceExternalListenerImpl;
import de.vw.mib.asl.internal.online.coreImpl.coreservice.persistence.CoreServicePersistence;
import de.vw.mib.asl.internal.online.coreImpl.coreservice.services.CoreServiceFactoryResetHandling;
import de.vw.mib.asl.internal.online.coreImpl.coreservice.services.CoreServiceImageHandler;
import de.vw.mib.asl.internal.online.coreImpl.coreservice.services.CoreServicePrivacyModeHandling;
import de.vw.mib.asl.internal.online.coreImpl.coreservice.services.CoreServiceStatusBarHandling;
import de.vw.mib.asl.internal.online.coreImpl.coreservice.services.CoreServiceStatusHandling;
import de.vw.mib.asl.internal.online.coreImpl.coreservice.services.CoreServiceUrlHandler;
import de.vw.mib.asl.internal.online.coreImpl.coreservice.services.OnlineAuthenticationImpl;
import de.vw.mib.asl.internal.online.coreImpl.coreservice.services.OnlineStatusServiceImpl;
import de.vw.mib.asl.internal.online.coreInterfaces.adapter.CoreServiceAdapterListener;
import de.vw.mib.asl.internal.online.coreInterfaces.adapter.CoreServiceAdapterUpdateListener;
import de.vw.mib.asl.internal.online.coreInterfaces.external.CoreServiceExternalListener;

public final class CoreServiceImplFactory {
    private static CoreServiceController _controller;
    private static CoreServiceNotifier _notifier;
    private static CoreServiceUrlHandler _serviceHandler;
    private static CoreServiceStatusHandling _statusHandler;
    private static CoreServiceImageHandler _logoHandler;
    private static CoreServicePersistence _persistence;
    private static CoreServiceStatusBarHandling _statusBarHandler;
    private static CoreServicePrivacyModeHandling _privacyModeHandler;
    private static CoreServiceFactoryResetHandling _factoryResetHandler;
    private static OnlineStatusServiceImpl _serviceStatus;
    private static OnlineAuthenticationImpl _authentication;

    public static CoreServicePersistence getPersistence() {
        if (_persistence == null) {
            _persistence = new CoreServicePersistence();
        }
        return _persistence;
    }

    public static CoreServiceController getCoreServiceController() {
        if (_controller == null) {
            _controller = new CoreServiceController();
        }
        return _controller;
    }

    public static CoreServiceAdapterListener getAdapterListener() {
        return new CoreServiceAdapterListenerImpl();
    }

    public static CoreServiceAdapterUpdateListener getAdapterUpdateListener() {
        return new CoreServiceAdapterUpdateListenerImpl();
    }

    public static CoreServiceExternalListener getExternalListener() {
        return new CoreServiceExternalListenerImpl();
    }

    public static CoreServiceNotifier getCoreServiceNotifier() {
        if (_notifier == null) {
            _notifier = new CoreServiceNotifier();
        }
        return _notifier;
    }

    public static CoreServiceUrlHandler getURLHandler() {
        if (_serviceHandler == null) {
            _serviceHandler = new CoreServiceUrlHandler();
        }
        return _serviceHandler;
    }

    public static CoreServiceStatusHandling getStatusHandler() {
        if (_statusHandler == null) {
            _statusHandler = new CoreServiceStatusHandling();
        }
        return _statusHandler;
    }

    public static CoreServiceImageHandler getLogoHandler() {
        if (_logoHandler == null) {
            _logoHandler = new CoreServiceImageHandler();
        }
        return _logoHandler;
    }

    public static CoreServiceStatusBarHandling getStatusBarHandler() {
        if (_statusBarHandler == null) {
            _statusBarHandler = new CoreServiceStatusBarHandling();
        }
        return _statusBarHandler;
    }

    public static CoreServicePrivacyModeHandling getPrivacyModeHandler() {
        if (_privacyModeHandler == null) {
            _privacyModeHandler = new CoreServicePrivacyModeHandling();
        }
        return _privacyModeHandler;
    }

    public static CoreServiceFactoryResetHandling getFactoryResetHandler() {
        if (_factoryResetHandler == null) {
            _factoryResetHandler = new CoreServiceFactoryResetHandling();
        }
        return _factoryResetHandler;
    }

    public static OnlineStatusServiceImpl getServiceStatus() {
        if (_serviceStatus == null) {
            _serviceStatus = new OnlineStatusServiceImpl();
        }
        return _serviceStatus;
    }

    public static OnlineAuthenticationImpl getAuthentication() {
        if (_authentication == null) {
            _authentication = new OnlineAuthenticationImpl();
        }
        return _authentication;
    }
}

