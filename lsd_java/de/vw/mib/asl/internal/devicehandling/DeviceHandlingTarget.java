/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.devicehandling;

import de.vw.mib.asl.api.devicehandling.ASLDeviceHandlingFactory;
import de.vw.mib.asl.api.devicehandling.Medium;
import de.vw.mib.asl.api.devicehandling.clients.MediaListObserver;
import de.vw.mib.asl.framework.api.diagnosis.config.Adaptation;
import de.vw.mib.asl.framework.api.diagnosis.config.Coding;
import de.vw.mib.asl.framework.api.dsiproxy.DSIProxy;
import de.vw.mib.asl.framework.api.dsiproxy.DSIProxyFactory;
import de.vw.mib.asl.framework.internal.framework.AbstractASLTarget;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.devicehandling.ClientRegistry;
import de.vw.mib.asl.internal.devicehandling.DeviceCoding;
import de.vw.mib.asl.internal.devicehandling.DevicesImpl;
import de.vw.mib.asl.internal.devicehandling.VdropTester;
import de.vw.mib.asl.internal.devicehandling.api.impl.ASLDeviceHandlingAPIImpl;
import de.vw.mib.asl.internal.devicehandling.otherclients.EjectionTarget;
import de.vw.mib.asl.internal.devicehandling.otherclients.MediaListTracer;
import de.vw.mib.asl.internal.devicehandling.otherclients.ScreenShotMountPoints;
import de.vw.mib.asl.internal.devicehandling.otherclients.SwdlClient;
import de.vw.mib.asl.internal.devicehandling.otherclients.SystemMediaClient;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.GenericEvents;
import java.util.Collection;
import java.util.Iterator;
import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.media.DSIMediaBase;
import org.dsi.ifc.media.DeviceInfo;
import org.dsi.ifc.media.MediaInfo;

public final class DeviceHandlingTarget
extends AbstractASLTarget {
    private static final int EV_DIAG_RECEIVE_CODING_DATA;
    private static final int EV_DIAG_RECEIVE_ADAPT_DATA;
    private DSIListener dsiMediaBaseListener;
    private final DevicesImpl devices;
    private final ClientRegistry clientRegistry;
    private static ClientRegistry sClientRegistry;
    private final DeviceCoding deviceCoding = new DeviceCoding();
    private boolean started = false;
    private static final int[] OBSERVERS;
    private DSIMediaBase dsiMediaBase;
    private boolean notificationsSet = false;
    private static final int[] ATTR_MEDIA_BASE_EARLY;
    private static final int[] ATTR_MEDIA_BASE_LATE;
    static /* synthetic */ Class class$org$dsi$ifc$media$DSIMediaBase;
    static /* synthetic */ Class class$org$dsi$ifc$media$DSIMediaBaseListener;

    public DeviceHandlingTarget(GenericEvents genericEvents, String string) {
        super(genericEvents, string);
        this.devices = new DevicesImpl(this.deviceCoding);
        ASLDeviceHandlingAPIImpl.getInstance().setDevices(this.devices);
        this.clientRegistry = new ClientRegistry(this.devices);
        ASLDeviceHandlingFactory.getDeviceHandlingApi().registerArray(new MediaListObserver[]{new MediaListTracer(), this.startupEjectionTarget(), new SwdlClient(), new SystemMediaClient(), new ScreenShotMountPoints()});
        sClientRegistry = this.clientRegistry;
    }

    @Override
    public int getDefaultTargetId() {
        return 1957630720;
    }

    private MediaListObserver startupEjectionTarget() {
        EjectionTarget ejectionTarget = new EjectionTarget(ServiceManager.eventMain, "hsmtask", this);
        EventGeneric eventGeneric = ServiceManager.mGenericEventFactory.newEvent(1957630720, 1974407936, 106);
        this.sendSafe(eventGeneric);
        return ejectionTarget;
    }

    @Override
    public void gotEvent(EventGeneric eventGeneric) {
        switch (eventGeneric.getReceiverEventId()) {
            case 106: {
                this.registerMediaBaseDSI();
                this.addPendingClients();
                this.addObservers(OBSERVERS);
                ServiceManager.adaptionApi.requestConfigManagerPersCoding(this.getTargetId(), -1585053440);
                ServiceManager.adaptionApi.requestConfigManagerPersAdaptation(this.getTargetId(), -1568276224);
                if (!this.isTraceEnabled()) break;
                this.trace("DeviceHandlingTarget.gotEvent(): POWER_ON");
                break;
            }
            case 107: {
                this.unregisterMediaBaseDSI();
                this.notificationsSet = false;
                this.removeObservers(OBSERVERS);
                this.devices.deInitialize();
                this.stopDependentTargets();
                if (this.isTraceEnabled()) {
                    this.trace("DeviceHandlingTarget.gotEvent(): POWER_OFF");
                }
                this.started = false;
                break;
            }
            case 3099998: {
                this.addPendingClients();
                break;
            }
            case 4300062: {
                break;
            }
            case 1200004: {
                if (this.isNamespaceKey(eventGeneric, -687821311, 1L)) {
                    ServiceManager.adaptionApi.requestConfigManagerPersCoding(this.getTargetId(), -1585053440);
                }
                if (!this.isNamespaceKey(eventGeneric, -536825343, 0)) break;
                ServiceManager.adaptionApi.requestConfigManagerPersAdaptation(this.getTargetId(), -1568276224);
                break;
            }
            case 100001: {
                this.trace("DeviceHandlingTarget.gotEvent(): EV_DIAG_RECEIVE_CODING_DATA");
                if (eventGeneric.getResult() != 0 || eventGeneric.getInt(2) != -687821311 || eventGeneric.getLong(3) != 1L) break;
                this.deviceCoding.receiveCoding((Coding)eventGeneric.getObject(1));
                this.devices.updateDeviceList();
                this.trigger();
                break;
            }
            case 100002: {
                this.trace("DeviceHandlingTarget.gotEvent(): EV_DIAG_RECEIVE_ADAPT_DATA");
                if (eventGeneric.getResult() != 0 || eventGeneric.getInt(2) != -536825343 || eventGeneric.getLong(3) != 0) break;
                this.deviceCoding.receiveAdaptation((Adaptation)eventGeneric.getObject(1));
                this.devices.updateDeviceList();
                this.trigger();
                break;
            }
            case 3003003: {
                String string = eventGeneric.getString(0);
                new VdropTester(this).handleTestVdrop(string);
                break;
            }
            case 3003004: {
                this.dsiMediaBaseUpdateDeviceList((DeviceInfo[])eventGeneric.getObject(0), 1);
                break;
            }
            case 0x2DD27D: {
                this.dsiMediaBaseUpdateMediaList((MediaInfo[])eventGeneric.getObject(0), 1);
                break;
            }
        }
    }

    private void trigger() {
        if (this.devices.isInitialized()) {
            this.startDependentTargets();
            this.clientRegistry.triggerClients();
        } else if (this.deviceCoding.isInitialized()) {
            this.setNotifications();
        }
    }

    private void startDependentTargets() {
        if (!this.started) {
            this.started = true;
            this.sendSafe(ServiceManager.mGenericEventFactory.newEvent(this.getTargetId(), 313463552, 106));
        }
    }

    private void stopDependentTargets() {
        if (this.started) {
            this.started = false;
            this.sendSafe(ServiceManager.mGenericEventFactory.newEvent(this.getTargetId(), 313463552, 107));
        }
    }

    private void addPendingClients() {
        Collection collection = ASLDeviceHandlingAPIImpl.getInstance().pendingClients;
        if (this.isTraceEnabled()) {
            this.trace("DeviceHandlingTarget.addPendingClients():");
            Iterator iterator = collection.iterator();
            while (iterator.hasNext()) {
                MediaListObserver mediaListObserver = (MediaListObserver)iterator.next();
                this.trace().append("    adding MediaListObserver '").append(mediaListObserver).append('\'').log();
            }
        }
        this.clientRegistry.addAll(collection);
        collection.clear();
    }

    @Override
    public int getClassifier() {
        return 32768;
    }

    @Override
    public int getSubClassifier() {
        return 1;
    }

    private void registerMediaBaseDSI() {
        DSIProxy dSIProxy = DSIProxyFactory.getDSIProxyAPI().getDSIProxy();
        this.dsiMediaBase = (DSIMediaBase)dSIProxy.getService(this, class$org$dsi$ifc$media$DSIMediaBase == null ? (class$org$dsi$ifc$media$DSIMediaBase = DeviceHandlingTarget.class$("org.dsi.ifc.media.DSIMediaBase")) : class$org$dsi$ifc$media$DSIMediaBase);
        this.dsiMediaBaseListener = dSIProxy.getAdapterFactory().createDSIListenerMethodAdapter(this, class$org$dsi$ifc$media$DSIMediaBaseListener == null ? (class$org$dsi$ifc$media$DSIMediaBaseListener = DeviceHandlingTarget.class$("org.dsi.ifc.media.DSIMediaBaseListener")) : class$org$dsi$ifc$media$DSIMediaBaseListener);
        dSIProxy.addResponseListener(this, class$org$dsi$ifc$media$DSIMediaBaseListener == null ? (class$org$dsi$ifc$media$DSIMediaBaseListener = DeviceHandlingTarget.class$("org.dsi.ifc.media.DSIMediaBaseListener")) : class$org$dsi$ifc$media$DSIMediaBaseListener, this.dsiMediaBaseListener);
    }

    private void unregisterMediaBaseDSI() {
        DSIProxyFactory.getDSIProxyAPI().getDSIProxy().removeResponseListener(this, class$org$dsi$ifc$media$DSIMediaBaseListener == null ? (class$org$dsi$ifc$media$DSIMediaBaseListener = DeviceHandlingTarget.class$("org.dsi.ifc.media.DSIMediaBaseListener")) : class$org$dsi$ifc$media$DSIMediaBaseListener, this.dsiMediaBaseListener);
        this.dsiMediaBaseListener = null;
        this.dsiMediaBase = null;
    }

    private void setNotifications() {
        if (this.notificationsSet) {
            return;
        }
        this.notificationsSet = true;
        this.info("Calling setNotification for Media DSIs");
        this.dsiMediaBase.setNotification(ATTR_MEDIA_BASE_EARLY, this.dsiMediaBaseListener);
        this.dsiMediaBase.setNotification(ATTR_MEDIA_BASE_LATE, this.dsiMediaBaseListener);
    }

    public void eject(Medium medium) {
        this.dsiMediaBase.ejectMedium(medium.getCurrentInfo().getDeviceID(), medium.getCurrentInfo().getMediaID());
    }

    public void dsiMediaBaseUpdateDeviceList(DeviceInfo[] deviceInfoArray, int n) {
        if (n != 1) {
            return;
        }
        this.trace("DeviceHandlingTarget.dsiMediaBaseUpdateDeviceList()");
        this.devices.updateDeviceList(deviceInfoArray);
        this.trigger();
        EventGeneric eventGeneric = ServiceManager.mGenericEventFactory.newEvent();
        eventGeneric.setObject(0, deviceInfoArray);
        this.triggerObserver(-1043976960, eventGeneric);
    }

    public void dsiMediaBaseUpdateMediaList(MediaInfo[] mediaInfoArray, int n) {
        if (n != 1) {
            return;
        }
        this.trace("DeviceHandlingTarget.dsiMediaBaseUpdateMediaList()");
        VdropTester.mediaList = mediaInfoArray;
        this.devices.updateMediaList(mediaInfoArray);
        this.trigger();
        EventGeneric eventGeneric = ServiceManager.mGenericEventFactory.newEvent();
        eventGeneric.setObject(0, mediaInfoArray);
        this.triggerObserver(-1060754176, eventGeneric);
    }

    public static boolean deregister(MediaListObserver mediaListObserver) {
        return sClientRegistry.deregister(mediaListObserver);
    }

    private boolean isNamespaceKey(EventGeneric eventGeneric, int n, long l) {
        int n2 = eventGeneric.getInt(2);
        long l2 = eventGeneric.getLong(3);
        return n2 == n && l2 == l;
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
        OBSERVERS = new int[]{-2075192832, 513622272, 2094148864, 2110926080};
        ATTR_MEDIA_BASE_EARLY = new int[]{4};
        ATTR_MEDIA_BASE_LATE = new int[]{3, 2};
    }
}

