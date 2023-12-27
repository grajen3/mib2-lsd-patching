/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.onlineservice.registration;

import de.vw.mib.asl.api.navigation.util.ASLNavigationUtilFactory;
import de.vw.mib.asl.api.navigation.util.IExtLogger;
import de.vw.mib.asl.api.online.ASLOnlineCoreServices;
import de.vw.mib.asl.api.online.ASLOnlineFactory;
import de.vw.mib.asl.framework.api.dsiproxy.DSIServiceStateListener;
import de.vw.mib.asl.framework.internal.framework.AbstractASLTarget;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.GenericEvents;
import de.vw.mib.util.StringBuilder;

public class OCSRegistrationTarget
extends AbstractASLTarget
implements DSIServiceStateListener {
    private final IExtLogger logger = ASLNavigationUtilFactory.getNavigationUtilApi().getExtLogger(16384, "OCSRegistrationTarget:");
    private final ASLOnlineCoreServices onlineCoreServices = ASLOnlineFactory.getOnlineCoreServices();
    private boolean wasServiceStateListenerRegistered = false;
    static /* synthetic */ Class class$org$dsi$ifc$online$DSIPoiOnlineSearch;
    static /* synthetic */ Class class$org$dsi$ifc$map$DSIMapViewerGoogleCtrl;
    static /* synthetic */ Class class$org$dsi$ifc$map$DSIMapViewerStreetViewCtrl;

    public OCSRegistrationTarget(GenericEvents genericEvents, int n, String string) {
        super(genericEvents, n, string);
    }

    @Override
    public void gotEvent(EventGeneric eventGeneric) {
        switch (eventGeneric.getReceiverEventId()) {
            case 101003: {
                this.logger.trace("Received event 'NAVI_TARGET_PREPARE_ON'.");
                break;
            }
            case 101001: {
                this.logger.trace(new StringBuffer().append("Received event 'NAVI_TARGET_GO_ON'. Was registrered:").append(this.wasServiceStateListenerRegistered).toString());
                if (this.wasServiceStateListenerRegistered) break;
                ServiceManager.dsiServiceLocator.addServiceStateListener(class$org$dsi$ifc$online$DSIPoiOnlineSearch == null ? (class$org$dsi$ifc$online$DSIPoiOnlineSearch = OCSRegistrationTarget.class$("org.dsi.ifc.online.DSIPoiOnlineSearch")) : class$org$dsi$ifc$online$DSIPoiOnlineSearch, this);
                ServiceManager.dsiServiceLocator.addServiceStateListener(class$org$dsi$ifc$map$DSIMapViewerGoogleCtrl == null ? (class$org$dsi$ifc$map$DSIMapViewerGoogleCtrl = OCSRegistrationTarget.class$("org.dsi.ifc.map.DSIMapViewerGoogleCtrl")) : class$org$dsi$ifc$map$DSIMapViewerGoogleCtrl, this);
                ServiceManager.dsiServiceLocator.addServiceStateListener(class$org$dsi$ifc$map$DSIMapViewerStreetViewCtrl == null ? (class$org$dsi$ifc$map$DSIMapViewerStreetViewCtrl = OCSRegistrationTarget.class$("org.dsi.ifc.map.DSIMapViewerStreetViewCtrl")) : class$org$dsi$ifc$map$DSIMapViewerStreetViewCtrl, this);
                this.wasServiceStateListenerRegistered = true;
                break;
            }
            case 101002: {
                this.logger.trace("Received event 'NAVI_TARGET_PREPARE_OFF'.");
                break;
            }
        }
    }

    @Override
    public void registered(String string, int n) {
    }

    @Override
    public void unregistered(String string, int n) {
    }

    private void trace(String string, boolean bl) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(bl ? "Registered" : "Unregistered");
        stringBuilder.append(" online service '");
        stringBuilder.append(string);
        stringBuilder.append("' in online core services.");
        this.logger.trace(stringBuilder.toString());
    }

    @Override
    public int getDefaultTargetId() {
        return -1001712640;
    }

    @Override
    public int getSubClassifier() {
        return 16384;
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

