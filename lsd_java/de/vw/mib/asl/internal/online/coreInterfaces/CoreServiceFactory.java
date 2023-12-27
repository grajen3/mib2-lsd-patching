/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.online.coreInterfaces;

import de.vw.mib.asl.internal.online.coreInterfaces.adapter.CoreServiceAdapterRegistration;
import de.vw.mib.asl.internal.online.coreInterfaces.external.CoreServiceExternalRegistration;
import de.vw.mib.asl.internal.online.coreInterfaces.external.CoreServiceExternalUpdateListener;
import de.vw.mib.asl.internal.online.coreInterfaces.service.CoreService;

public final class CoreServiceFactory {
    private static CoreServiceAdapterRegistration _registration;
    private static CoreService _coreService;
    private static CoreServiceExternalRegistration _external;
    private static CoreServiceExternalUpdateListener _updateListener;
    static /* synthetic */ Class class$de$vw$mib$asl$internal$online$coreInterfaces$service$CoreService;
    static /* synthetic */ Class class$de$vw$mib$asl$internal$online$coreInterfaces$adapter$CoreServiceAdapterRegistration;
    static /* synthetic */ Class class$de$vw$mib$asl$internal$online$coreInterfaces$external$CoreServiceExternalRegistration;
    static /* synthetic */ Class class$de$vw$mib$asl$internal$online$coreInterfaces$external$CoreServiceExternalUpdateListener;

    public static CoreService getCoreService() {
        if (_coreService == null) {
            String string = (class$de$vw$mib$asl$internal$online$coreInterfaces$service$CoreService == null ? (class$de$vw$mib$asl$internal$online$coreInterfaces$service$CoreService = CoreServiceFactory.class$("de.vw.mib.asl.internal.online.coreInterfaces.service.CoreService")) : class$de$vw$mib$asl$internal$online$coreInterfaces$service$CoreService).getName();
            int n = string.lastIndexOf(46);
            string = new StringBuffer().append("de.vw.mib.asl.internal.online.coreImpl.coreservice.impl").append(string.substring(n)).append("Impl").toString();
            _coreService = (CoreService)CoreServiceFactory.createInstance(class$de$vw$mib$asl$internal$online$coreInterfaces$service$CoreService == null ? (class$de$vw$mib$asl$internal$online$coreInterfaces$service$CoreService = CoreServiceFactory.class$("de.vw.mib.asl.internal.online.coreInterfaces.service.CoreService")) : class$de$vw$mib$asl$internal$online$coreInterfaces$service$CoreService, string);
        }
        return _coreService;
    }

    public static CoreServiceAdapterRegistration getAdapterRegister() {
        if (_registration == null) {
            String string = (class$de$vw$mib$asl$internal$online$coreInterfaces$adapter$CoreServiceAdapterRegistration == null ? (class$de$vw$mib$asl$internal$online$coreInterfaces$adapter$CoreServiceAdapterRegistration = CoreServiceFactory.class$("de.vw.mib.asl.internal.online.coreInterfaces.adapter.CoreServiceAdapterRegistration")) : class$de$vw$mib$asl$internal$online$coreInterfaces$adapter$CoreServiceAdapterRegistration).getName();
            int n = string.lastIndexOf(46);
            string = new StringBuffer().append("de.vw.mib.asl.internal.online.coreImpl.coreservice.impl").append(string.substring(n)).append("Impl").toString();
            _registration = (CoreServiceAdapterRegistration)CoreServiceFactory.createInstance(class$de$vw$mib$asl$internal$online$coreInterfaces$adapter$CoreServiceAdapterRegistration == null ? (class$de$vw$mib$asl$internal$online$coreInterfaces$adapter$CoreServiceAdapterRegistration = CoreServiceFactory.class$("de.vw.mib.asl.internal.online.coreInterfaces.adapter.CoreServiceAdapterRegistration")) : class$de$vw$mib$asl$internal$online$coreInterfaces$adapter$CoreServiceAdapterRegistration, string);
        }
        return _registration;
    }

    public static CoreServiceExternalRegistration getExternalRegister() {
        if (_external == null) {
            String string = (class$de$vw$mib$asl$internal$online$coreInterfaces$external$CoreServiceExternalRegistration == null ? (class$de$vw$mib$asl$internal$online$coreInterfaces$external$CoreServiceExternalRegistration = CoreServiceFactory.class$("de.vw.mib.asl.internal.online.coreInterfaces.external.CoreServiceExternalRegistration")) : class$de$vw$mib$asl$internal$online$coreInterfaces$external$CoreServiceExternalRegistration).getName();
            int n = string.lastIndexOf(46);
            string = new StringBuffer().append("de.vw.mib.asl.internal.online.coreImpl.coreservice.impl").append(string.substring(n)).append("Impl").toString();
            _external = (CoreServiceExternalRegistration)CoreServiceFactory.createInstance(class$de$vw$mib$asl$internal$online$coreInterfaces$external$CoreServiceExternalRegistration == null ? (class$de$vw$mib$asl$internal$online$coreInterfaces$external$CoreServiceExternalRegistration = CoreServiceFactory.class$("de.vw.mib.asl.internal.online.coreInterfaces.external.CoreServiceExternalRegistration")) : class$de$vw$mib$asl$internal$online$coreInterfaces$external$CoreServiceExternalRegistration, string);
        }
        return _external;
    }

    public static CoreServiceExternalUpdateListener getExternalUpdateListener() {
        if (_updateListener == null) {
            String string = (class$de$vw$mib$asl$internal$online$coreInterfaces$external$CoreServiceExternalUpdateListener == null ? (class$de$vw$mib$asl$internal$online$coreInterfaces$external$CoreServiceExternalUpdateListener = CoreServiceFactory.class$("de.vw.mib.asl.internal.online.coreInterfaces.external.CoreServiceExternalUpdateListener")) : class$de$vw$mib$asl$internal$online$coreInterfaces$external$CoreServiceExternalUpdateListener).getName();
            int n = string.lastIndexOf(46);
            string = new StringBuffer().append("de.vw.mib.asl.internal.online.coreImpl.coreservice.impl").append(string.substring(n)).append("Impl").toString();
            _updateListener = (CoreServiceExternalUpdateListener)CoreServiceFactory.createInstance(class$de$vw$mib$asl$internal$online$coreInterfaces$external$CoreServiceExternalUpdateListener == null ? (class$de$vw$mib$asl$internal$online$coreInterfaces$external$CoreServiceExternalUpdateListener = CoreServiceFactory.class$("de.vw.mib.asl.internal.online.coreInterfaces.external.CoreServiceExternalUpdateListener")) : class$de$vw$mib$asl$internal$online$coreInterfaces$external$CoreServiceExternalUpdateListener, string);
        }
        return _updateListener;
    }

    private static Object createInstance(Class clazz, String string) {
        Object object = null;
        try {
            Class clazz2 = Class.forName(string);
            object = clazz2.newInstance();
        }
        catch (Exception exception) {
            object = null;
        }
        return object;
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

