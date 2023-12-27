/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.picturestore;

import de.vw.mib.asl.framework.api.dsiproxy.DSIProxy;
import de.vw.mib.asl.framework.api.dsiproxy.DSIProxyFactory;
import de.vw.mib.asl.framework.api.framework.ASLFrameworkFactory;
import de.vw.mib.asl.framework.api.persistence.ASLPersistenceFactory;
import de.vw.mib.asl.framework.api.persistence.AslPersistenceSyncApi;
import de.vw.mib.asl.framework.api.persistence2.ProfileOperationParticipant;
import de.vw.mib.asl.internal.picturestore.persistence.PictureStorePersonalization;
import de.vw.mib.genericevents.AbstractTarget;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.GenericEvents;
import de.vw.mib.log4mib.LogMessage;
import de.vw.mib.util.Util;
import java.util.LinkedList;
import org.dsi.ifc.global.ResourceLocator;
import org.dsi.ifc.picturestore.DSIPictureStore;
import org.dsi.ifc.picturestore.DSIPictureStoreListener;

public final class TargetPictureStore
extends AbstractTarget
implements ProfileOperationParticipant {
    private static final String CLASS_NAME = (class$de$vw$mib$asl$internal$picturestore$TargetPictureStore == null ? (class$de$vw$mib$asl$internal$picturestore$TargetPictureStore = TargetPictureStore.class$("de.vw.mib.asl.internal.picturestore.TargetPictureStore")) : class$de$vw$mib$asl$internal$picturestore$TargetPictureStore).getName();
    private PictureStorePersonalization persistence;
    private DSIPictureStore dsiPictureStore;
    private DSIPictureStoreListener dsiPictureStoreListener;
    private boolean statusReady;
    private final LinkedList pendingImportEvents = new LinkedList();
    private final LinkedList pendingDeleteEvents = new LinkedList();
    static /* synthetic */ Class class$de$vw$mib$asl$internal$picturestore$TargetPictureStore;
    static /* synthetic */ Class class$org$dsi$ifc$picturestore$DSIPictureStore;
    static /* synthetic */ Class class$org$dsi$ifc$picturestore$DSIPictureStoreListener;

    public TargetPictureStore(GenericEvents genericEvents, String string) {
        super(genericEvents, string);
    }

    @Override
    public int getDefaultTargetId() {
        return -2134895616;
    }

    private void addImportEvent(EventGeneric eventGeneric) {
        this.pendingImportEvents.add(eventGeneric);
    }

    private EventGeneric getImportEvent() {
        return TargetPictureStore.removeFirst(this.pendingImportEvents);
    }

    private void addDeleteEvent(EventGeneric eventGeneric) {
        this.pendingDeleteEvents.add(eventGeneric);
    }

    private EventGeneric getDeleteEvent() {
        return TargetPictureStore.removeFirst(this.pendingDeleteEvents);
    }

    private static EventGeneric removeFirst(LinkedList linkedList) {
        return linkedList.isEmpty() ? null : (EventGeneric)linkedList.removeFirst();
    }

    private void dropPendingEvents() {
        this.dropPendingEvents(this.pendingDeleteEvents);
        this.dropPendingEvents(this.pendingImportEvents);
    }

    private void dropPendingEvents(LinkedList linkedList) {
        while (!linkedList.isEmpty()) {
            EventGeneric eventGeneric = (EventGeneric)linkedList.removeFirst();
            eventGeneric.setBlocked(false);
            this.getEventFactory().freeEvent(eventGeneric);
        }
    }

    private void setStatus(boolean bl) {
        if (this.statusReady != bl) {
            this.statusReady = bl;
            this.fireStatus();
        }
    }

    private void fireStatus() {
        EventGeneric eventGeneric = this.getEventFactory().newEvent();
        eventGeneric.setBoolean(0, this.statusReady);
        this.triggerObserver(544618496, eventGeneric);
    }

    private void registerDSI() {
        DSIProxy dSIProxy = DSIProxyFactory.getDSIProxyAPI().getDSIProxy();
        this.dsiPictureStore = (DSIPictureStore)dSIProxy.getService(this, class$org$dsi$ifc$picturestore$DSIPictureStore == null ? (class$org$dsi$ifc$picturestore$DSIPictureStore = TargetPictureStore.class$("org.dsi.ifc.picturestore.DSIPictureStore")) : class$org$dsi$ifc$picturestore$DSIPictureStore);
        this.dsiPictureStoreListener = (DSIPictureStoreListener)dSIProxy.getAdapterFactory().createDSIListenerMethodAdapter(this, class$org$dsi$ifc$picturestore$DSIPictureStoreListener == null ? (class$org$dsi$ifc$picturestore$DSIPictureStoreListener = TargetPictureStore.class$("org.dsi.ifc.picturestore.DSIPictureStoreListener")) : class$org$dsi$ifc$picturestore$DSIPictureStoreListener);
        dSIProxy.addResponseListener(this, class$org$dsi$ifc$picturestore$DSIPictureStoreListener == null ? (class$org$dsi$ifc$picturestore$DSIPictureStoreListener = TargetPictureStore.class$("org.dsi.ifc.picturestore.DSIPictureStoreListener")) : class$org$dsi$ifc$picturestore$DSIPictureStoreListener, this.dsiPictureStoreListener);
    }

    private void unregisterDSI() {
        DSIProxy dSIProxy = DSIProxyFactory.getDSIProxyAPI().getDSIProxy();
        dSIProxy.removeResponseListener(this, class$org$dsi$ifc$picturestore$DSIPictureStoreListener == null ? (class$org$dsi$ifc$picturestore$DSIPictureStoreListener = TargetPictureStore.class$("org.dsi.ifc.picturestore.DSIPictureStoreListener")) : class$org$dsi$ifc$picturestore$DSIPictureStoreListener, this.dsiPictureStoreListener);
    }

    @Override
    public int getClassifier() {
        return 32768;
    }

    @Override
    public int getSubClassifier() {
        return 128;
    }

    @Override
    public void gotEvent(EventGeneric eventGeneric) {
        switch (eventGeneric.getReceiverEventId()) {
            case 106: {
                this.registerDSI();
                if (this.persistence == null) {
                    AslPersistenceSyncApi aslPersistenceSyncApi = ASLPersistenceFactory.getPersistenceApi().getPersistenceSyncApi();
                    this.persistence = new PictureStorePersonalization(this.getTextLogger(), ASLFrameworkFactory.getASLFrameworkAPI().getServices(), aslPersistenceSyncApi);
                    aslPersistenceSyncApi.addProfileOperationParticipant(this);
                }
                this.setStatus(true);
                break;
            }
            case 107: {
                this.setStatus(false);
                this.dropPendingEvents();
                this.unregisterDSI();
                break;
            }
            case 3700000: {
                this.handleASLSetConfig(eventGeneric);
                break;
            }
            case 3700001: {
                this.handleASLImportPicture(eventGeneric);
                break;
            }
            case 3700006: {
                this.handleASLDeleteAllPictures(eventGeneric);
                break;
            }
            case 3700007: {
                this.handleASLDeletePictures(eventGeneric);
                break;
            }
        }
    }

    private void handleASLSetConfig(EventGeneric eventGeneric) {
        if (!this.statusReady) {
            throw new IllegalStateException();
        }
        int n = eventGeneric.getInt(0);
        int n2 = eventGeneric.getInt(1);
        int n3 = eventGeneric.getInt(2);
        int n4 = eventGeneric.getInt(3);
        this.dsiPictureStore.setConfigWithFileType(n, n2 * 2, n3, n4, 1);
    }

    private void handleASLImportPicture(EventGeneric eventGeneric) {
        if (!this.statusReady) {
            throw new IllegalStateException();
        }
        int n = eventGeneric.getInt(0);
        ResourceLocator resourceLocator = (ResourceLocator)eventGeneric.getObject(1);
        this.addImportEvent(eventGeneric);
        eventGeneric.setBlocked(true);
        this.dsiPictureStore.importPicture(n, resourceLocator, true);
    }

    private void handleASLDeleteAllPictures(EventGeneric eventGeneric) {
        if (!this.statusReady) {
            throw new IllegalStateException();
        }
        int n = eventGeneric.getInt(0);
        boolean bl = eventGeneric.getBoolean(1);
        this.addDeleteEvent(eventGeneric);
        eventGeneric.setBlocked(true);
        ResourceLocator[] resourceLocatorArray = this.persistence.deleteAllPictures(n);
        this.dsiPictureStore.deletePictures(resourceLocatorArray, bl);
    }

    private void handleASLDeletePictures(EventGeneric eventGeneric) {
        if (!this.statusReady) {
            throw new IllegalStateException();
        }
        Object[] objectArray = (ResourceLocator[])eventGeneric.getObject(0);
        if (Util.isNullOrEmpty(objectArray)) {
            LogMessage logMessage = this.warn();
            logMessage.append(CLASS_NAME).append(".handleASLDeletePictures()  Empty resource locators. Event=").append(eventGeneric.toString()).log();
        } else {
            boolean bl = eventGeneric.getBoolean(1);
            this.addDeleteEvent(eventGeneric);
            eventGeneric.setBlocked(true);
            ResourceLocator[] resourceLocatorArray = this.persistence.deletePictures((ResourceLocator[])objectArray);
            this.dsiPictureStore.deletePictures(resourceLocatorArray, bl);
        }
    }

    public void dsiPictureStoreImportPictureResult(int n, ResourceLocator resourceLocator, ResourceLocator resourceLocator2, int n2) {
        EventGeneric eventGeneric;
        boolean bl;
        boolean bl2 = bl = n2 == 0;
        if (bl) {
            this.persistence.addPicture(resourceLocator2, n);
        }
        if ((eventGeneric = this.getImportEvent()) != null) {
            eventGeneric.setObject(3, resourceLocator2);
            eventGeneric.setBoolean(4, bl);
            eventGeneric.setBlocked(false);
            this.getEventDispatcher().sendBack(eventGeneric);
        } else {
            LogMessage logMessage = this.warn();
            logMessage.append(CLASS_NAME).append(".dsiPictureStoreImportPictureResult()  No response event").log();
        }
    }

    public void dsiPictureStoreDeletedPictures(ResourceLocator[] resourceLocatorArray) {
        EventGeneric eventGeneric = this.getDeleteEvent();
        if (eventGeneric != null) {
            eventGeneric.setObject(0, resourceLocatorArray);
            eventGeneric.setBlocked(false);
            this.getEventDispatcher().sendBack(eventGeneric);
        } else {
            LogMessage logMessage = this.warn();
            logMessage.append(CLASS_NAME).append(".dsiPictureStoreImportPictureResult()  No response event").log();
        }
    }

    @Override
    public void copyProfile(int n, int n2) {
        if (this.isTraceEnabled()) {
            this.trace().append("TargetPictureStore.copyProfile( fromProfileNumber=").append(n).append(", toProfileNumber = ").append(n2).append(" )").log();
        }
        this.persistence.copyProfile(n, n2);
    }

    @Override
    public void resetProfile(int n) {
        if (this.isTraceEnabled()) {
            this.trace().append("TargetPictureStore.resetProfile( profileNumber=").append(n).append(" )").log();
        }
        ResourceLocator[] resourceLocatorArray = this.persistence.resetProfile(n);
        this.pendingDeleteEvents.add(null);
        this.dsiPictureStore.deletePictures(resourceLocatorArray, true);
    }

    @Override
    public void resetAllProfiles() {
        this.trace("TargetPictureStore.resetAllProfiles");
        ResourceLocator[] resourceLocatorArray = this.persistence.resetAllProfiles();
        this.pendingDeleteEvents.add(null);
        this.dsiPictureStore.deletePictures(resourceLocatorArray, true);
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

