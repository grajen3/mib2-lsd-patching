/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.framework.internal.entertainmentmanager.api.impl;

import de.vw.mib.asl.framework.api.entertainmentmanager.EntertainmentManagerService;
import de.vw.mib.asl.framework.api.entertainmentmanager.EntertainmentManagerUpdates;
import de.vw.mib.asl.framework.api.framework.ASLFrameworkFactory;
import de.vw.mib.asl.framework.api.framework.component.ASLComponentRegistry;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.genericevents.EventGeneric;

public final class EntertainmentManagerServiceImpl
implements EntertainmentManagerService {
    private static EntertainmentManagerServiceImpl instance = null;
    static /* synthetic */ Class class$de$vw$mib$asl$framework$api$entertainmentmanager$EntertainmentManagerService;

    private EntertainmentManagerServiceImpl() {
    }

    @Override
    public void addListener(EntertainmentManagerUpdates entertainmentManagerUpdates) {
        EventGeneric eventGeneric = ServiceManager.mGenericEventFactory.newEvent(272503040, 272503040, -1551499008);
        eventGeneric.setObject(0, entertainmentManagerUpdates);
        ServiceManager.eventMain.getEventDispatcher().sendSafe(eventGeneric);
    }

    @Override
    public void requestContext(int n) {
        EventGeneric eventGeneric = ServiceManager.mGenericEventFactory.newEvent(272503040, 272503040, -648276736);
        eventGeneric.setInt(0, n);
        ServiceManager.eventMain.getEventDispatcher().sendSafe(eventGeneric);
    }

    @Override
    public void requestBand(int n) {
        EventGeneric eventGeneric = ServiceManager.mGenericEventFactory.newEvent(272503040, 272503040, -916712192);
        eventGeneric.setInt(1, 1);
        eventGeneric.setInt(0, n);
        ServiceManager.eventMain.getEventDispatcher().sendSafe(eventGeneric);
    }

    public static EntertainmentManagerServiceImpl getInstance() {
        if (instance == null) {
            instance = new EntertainmentManagerServiceImpl();
        }
        return instance;
    }

    public void register() {
        ASLComponentRegistry aSLComponentRegistry = ASLFrameworkFactory.getASLFrameworkAPI().getServices().getASLComponentRegistry();
        if (aSLComponentRegistry.getAPIInstance(class$de$vw$mib$asl$framework$api$entertainmentmanager$EntertainmentManagerService == null ? (class$de$vw$mib$asl$framework$api$entertainmentmanager$EntertainmentManagerService = EntertainmentManagerServiceImpl.class$("de.vw.mib.asl.framework.api.entertainmentmanager.EntertainmentManagerService")) : class$de$vw$mib$asl$framework$api$entertainmentmanager$EntertainmentManagerService) == null) {
            aSLComponentRegistry.registerAPI(class$de$vw$mib$asl$framework$api$entertainmentmanager$EntertainmentManagerService == null ? (class$de$vw$mib$asl$framework$api$entertainmentmanager$EntertainmentManagerService = EntertainmentManagerServiceImpl.class$("de.vw.mib.asl.framework.api.entertainmentmanager.EntertainmentManagerService")) : class$de$vw$mib$asl$framework$api$entertainmentmanager$EntertainmentManagerService, this);
        }
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

