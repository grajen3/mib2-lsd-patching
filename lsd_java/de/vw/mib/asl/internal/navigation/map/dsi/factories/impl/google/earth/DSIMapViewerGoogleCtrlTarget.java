/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.map.dsi.factories.impl.google.earth;

import de.vw.mib.asl.api.navigation.map.ASLNavigationMapFactory;
import de.vw.mib.asl.api.navigation.util.ASLNavigationUtilFactory;
import de.vw.mib.asl.api.navigation.util.IExtLogger;
import de.vw.mib.asl.api.online.ASLOnlineCoreServices;
import de.vw.mib.asl.api.online.ASLOnlineFactory;
import de.vw.mib.asl.framework.api.dsiproxy.DSIProxy;
import de.vw.mib.asl.framework.api.dsiproxy.DSIProxyFactory;
import de.vw.mib.asl.framework.internal.framework.AbstractASLHsmTarget;
import de.vw.mib.asl.internal.navigation.AbstractResettableTarget;
import de.vw.mib.asl.internal.navigation.map.dsi.DSIMapViewerGoogleCtrlVW;
import de.vw.mib.asl.internal.navigation.map.dsi.factories.impl.google.earth.DSIMapViewerGoogleCtrlDataPool;
import de.vw.mib.asl.internal.navigation.map.dsi.factories.impl.google.earth.DSIMapViewerGoogleCtrlTarget$1;
import de.vw.mib.asl.internal.navigation.map.dsi.factories.impl.google.earth.DSIMapViewerGoogleCtrlTargetData;
import de.vw.mib.asl.internal.navigation.map.dsi.factories.impl.google.earth.DSIMapViewerGoogleCtrlVWImpl;
import de.vw.mib.genericevents.AbstractTarget;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.GenericEvents;
import java.util.HashMap;
import java.util.Iterator;
import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.map.DSIMapViewerGoogleCtrl;
import org.dsi.ifc.map.DSIMapViewerGoogleCtrlListener;

public class DSIMapViewerGoogleCtrlTarget
extends AbstractResettableTarget {
    protected final IExtLogger LOGGER = ASLNavigationUtilFactory.getNavigationUtilApi().getExtLogger(256, "[DSIMapViewerGoogleCtrlTarget]");
    private final ASLOnlineCoreServices onlineCoreServices;
    protected final DSIMapViewerGoogleCtrlDataPool datapool;
    private final DSIProxy proxy = DSIProxyFactory.getDSIProxyAPI().getDSIProxy();
    static /* synthetic */ Class class$org$dsi$ifc$map$DSIMapViewerGoogleCtrlListener;
    static /* synthetic */ Class class$org$dsi$ifc$map$DSIMapViewerGoogleCtrl;

    public DSIMapViewerGoogleCtrlTarget(GenericEvents genericEvents, int n, String string) {
        super(genericEvents, n, string);
        this.datapool = new DSIMapViewerGoogleCtrlDataPool();
        this.onlineCoreServices = ASLOnlineFactory.getOnlineCoreServices();
    }

    public DSIMapViewerGoogleCtrlVW createGoogleCtrl(AbstractTarget abstractTarget, int[] nArray) {
        DSIMapViewerGoogleCtrlTargetData dSIMapViewerGoogleCtrlTargetData;
        if (abstractTarget == null) {
            this.LOGGER.error("createGoogleCtrl( AbstractTarget target, int[] attributes ) - the target can't be null, execution stopped");
            return null;
        }
        Integer n = new Integer(abstractTarget.getTargetId());
        if (this.datapool.getServiceInstances().containsKey(n)) {
            this.LOGGER.makeWarn().append("the target '").append(n).append("' is already registred").log();
            dSIMapViewerGoogleCtrlTargetData = (DSIMapViewerGoogleCtrlTargetData)this.datapool.getServiceInstances().get(n);
        } else {
            dSIMapViewerGoogleCtrlTargetData = this.createTargetData(abstractTarget, nArray);
            this.datapool.getServiceInstances().put(n, dSIMapViewerGoogleCtrlTargetData);
            if (this.datapool.isServiceAvailable()) {
                this.initMapViewerGoogleCtrl(dSIMapViewerGoogleCtrlTargetData);
            }
        }
        return dSIMapViewerGoogleCtrlTargetData.getDsiMapViewerGoogleCtrlVW();
    }

    private DSIMapViewerGoogleCtrlTargetData createTargetData(AbstractTarget abstractTarget, int[] nArray) {
        DSIMapViewerGoogleCtrlTargetData dSIMapViewerGoogleCtrlTargetData = new DSIMapViewerGoogleCtrlTargetData();
        dSIMapViewerGoogleCtrlTargetData.setDsiMapViewerGoogleCtrlVW(new DSIMapViewerGoogleCtrlVWImpl());
        dSIMapViewerGoogleCtrlTargetData.setAttributes(nArray);
        dSIMapViewerGoogleCtrlTargetData.setTarget(abstractTarget);
        return dSIMapViewerGoogleCtrlTargetData;
    }

    @Override
    public void gotEvent(EventGeneric eventGeneric) {
        switch (eventGeneric.getReceiverEventId()) {
            case 106: {
                this.gotEventPowerOn();
                break;
            }
            case 101001: {
                this.gotEventnaviTargetGoOn();
                break;
            }
            default: {
                return;
            }
        }
    }

    private void gotEventnaviTargetGoOn() {
        this.initServiceStateListener();
    }

    private void gotEventPowerOn() {
        this.LOGGER.trace("handleEntry()");
        this.init();
    }

    private void init() {
        this.initASL();
    }

    private void initASL() {
        this.registerService(442774784);
    }

    private void initMapViewerGoogleCtrl(DSIMapViewerGoogleCtrlTargetData dSIMapViewerGoogleCtrlTargetData) {
        this.initMapViewerGoogleCtrlDSI(dSIMapViewerGoogleCtrlTargetData);
        this.initMapViewerGoogleCtrlDSIListener(dSIMapViewerGoogleCtrlTargetData);
        this.initMapViewerGoogleCtrlResponseListener(dSIMapViewerGoogleCtrlTargetData);
        this.initMapViewerGoogleCtrlAttributes(dSIMapViewerGoogleCtrlTargetData);
        dSIMapViewerGoogleCtrlTargetData.getDsiMapViewerGoogleCtrlVW().setFacadeEnabled(true);
    }

    private void initMapViewerGoogleCtrlAttributes(DSIMapViewerGoogleCtrlTargetData dSIMapViewerGoogleCtrlTargetData) {
        int[] nArray = dSIMapViewerGoogleCtrlTargetData.getAttributes();
        if (nArray != null && nArray.length > 0) {
            dSIMapViewerGoogleCtrlTargetData.getDsiMapViewerGoogleCtrl().setNotification(nArray, (DSIListener)dSIMapViewerGoogleCtrlTargetData.getDsiMapViewerGoogleCtrlListener());
        }
    }

    private void initMapViewerGoogleCtrlResponseListener(DSIMapViewerGoogleCtrlTargetData dSIMapViewerGoogleCtrlTargetData) {
        this.proxy.addResponseListener(dSIMapViewerGoogleCtrlTargetData.getTarget(), class$org$dsi$ifc$map$DSIMapViewerGoogleCtrlListener == null ? (class$org$dsi$ifc$map$DSIMapViewerGoogleCtrlListener = DSIMapViewerGoogleCtrlTarget.class$("org.dsi.ifc.map.DSIMapViewerGoogleCtrlListener")) : class$org$dsi$ifc$map$DSIMapViewerGoogleCtrlListener, dSIMapViewerGoogleCtrlTargetData.getDsiMapViewerGoogleCtrlListener());
    }

    private void initMapViewerGoogleCtrlDSIListener(DSIMapViewerGoogleCtrlTargetData dSIMapViewerGoogleCtrlTargetData) {
        if (dSIMapViewerGoogleCtrlTargetData.getDsiMapViewerGoogleCtrlListener() == null) {
            DSIMapViewerGoogleCtrlListener dSIMapViewerGoogleCtrlListener;
            AbstractTarget abstractTarget = dSIMapViewerGoogleCtrlTargetData.getTarget();
            if (abstractTarget instanceof AbstractASLHsmTarget) {
                AbstractASLHsmTarget abstractASLHsmTarget = (AbstractASLHsmTarget)abstractTarget;
                dSIMapViewerGoogleCtrlListener = (DSIMapViewerGoogleCtrlListener)this.proxy.getAdapterFactory().createDSIListenerMethodAdapter(abstractASLHsmTarget.getHsm(), class$org$dsi$ifc$map$DSIMapViewerGoogleCtrlListener == null ? (class$org$dsi$ifc$map$DSIMapViewerGoogleCtrlListener = DSIMapViewerGoogleCtrlTarget.class$("org.dsi.ifc.map.DSIMapViewerGoogleCtrlListener")) : class$org$dsi$ifc$map$DSIMapViewerGoogleCtrlListener);
            } else {
                dSIMapViewerGoogleCtrlListener = (DSIMapViewerGoogleCtrlListener)this.proxy.getAdapterFactory().createDSIListenerMethodAdapter(abstractTarget, class$org$dsi$ifc$map$DSIMapViewerGoogleCtrlListener == null ? (class$org$dsi$ifc$map$DSIMapViewerGoogleCtrlListener = DSIMapViewerGoogleCtrlTarget.class$("org.dsi.ifc.map.DSIMapViewerGoogleCtrlListener")) : class$org$dsi$ifc$map$DSIMapViewerGoogleCtrlListener);
            }
            dSIMapViewerGoogleCtrlTargetData.setDsiMapViewerGoogleCtrlListener(dSIMapViewerGoogleCtrlListener);
        }
    }

    private void initMapViewerGoogleCtrlDSI(DSIMapViewerGoogleCtrlTargetData dSIMapViewerGoogleCtrlTargetData) {
        if (dSIMapViewerGoogleCtrlTargetData.getDsiMapViewerGoogleCtrl() == null) {
            DSIMapViewerGoogleCtrl dSIMapViewerGoogleCtrl = (DSIMapViewerGoogleCtrl)this.proxy.getService(dSIMapViewerGoogleCtrlTargetData.getTarget(), class$org$dsi$ifc$map$DSIMapViewerGoogleCtrl == null ? (class$org$dsi$ifc$map$DSIMapViewerGoogleCtrl = DSIMapViewerGoogleCtrlTarget.class$("org.dsi.ifc.map.DSIMapViewerGoogleCtrl")) : class$org$dsi$ifc$map$DSIMapViewerGoogleCtrl);
            dSIMapViewerGoogleCtrlTargetData.setDsiMapViewerGoogleCtrl(dSIMapViewerGoogleCtrl);
            dSIMapViewerGoogleCtrlTargetData.getDsiMapViewerGoogleCtrlVW().setMapViewerGoogleCtrl(dSIMapViewerGoogleCtrl);
        }
    }

    private void initServiceStateListener() {
        DSIMapViewerGoogleCtrlTarget$1 dSIMapViewerGoogleCtrlTarget$1 = new DSIMapViewerGoogleCtrlTarget$1(this);
        this.proxy.addServiceStateListener(class$org$dsi$ifc$map$DSIMapViewerGoogleCtrl == null ? (class$org$dsi$ifc$map$DSIMapViewerGoogleCtrl = DSIMapViewerGoogleCtrlTarget.class$("org.dsi.ifc.map.DSIMapViewerGoogleCtrl")) : class$org$dsi$ifc$map$DSIMapViewerGoogleCtrl, dSIMapViewerGoogleCtrlTarget$1);
    }

    private void notifyGoogleEarthDataStatusNoData() {
        if (this.LOGGER.isTraceEnabled()) {
            this.LOGGER.warn("notifyGoogleEarthDataStatusNoData() - We have to call this here because the update didn't arrive on startup. This must be fixed in SOP2.");
        }
        AbstractASLHsmTarget.writeIntegerToDatapool(4013, 0);
        ASLNavigationMapFactory.getNavigationMapApi().sendEvGoogleEarthDataStatusChanged(0);
    }

    protected void serviceInstancesDisable() {
        this.datapool.setServiceAvailable(false);
        ASLNavigationMapFactory.getNavigationMapApi().sendEvMapMainServiceAvailableChangedGoogleEarth(false);
        Iterator iterator = this.datapool.getServiceInstances().values().iterator();
        while (iterator.hasNext()) {
            DSIMapViewerGoogleCtrlTargetData dSIMapViewerGoogleCtrlTargetData = (DSIMapViewerGoogleCtrlTargetData)iterator.next();
            dSIMapViewerGoogleCtrlTargetData.getDsiMapViewerGoogleCtrlVW().setFacadeEnabled(false);
        }
    }

    protected void serviceInstancesInit() {
        this.datapool.setServiceAvailable(true);
        this.notifyGoogleEarthDataStatusNoData();
        this.setCopyrightPosition();
        Iterator iterator = this.datapool.getServiceInstances().values().iterator();
        while (iterator.hasNext()) {
            DSIMapViewerGoogleCtrlTargetData dSIMapViewerGoogleCtrlTargetData = (DSIMapViewerGoogleCtrlTargetData)iterator.next();
            this.initMapViewerGoogleCtrl(dSIMapViewerGoogleCtrlTargetData);
        }
        ASLNavigationMapFactory.getNavigationMapApi().sendEvMapMainServiceAvailableChangedGoogleEarth(true);
    }

    private void setCopyrightPosition() {
        this.LOGGER.trace("setCopyrightPosition()");
        DSIMapViewerGoogleCtrl dSIMapViewerGoogleCtrl = (DSIMapViewerGoogleCtrl)this.proxy.getService(this, class$org$dsi$ifc$map$DSIMapViewerGoogleCtrl == null ? (class$org$dsi$ifc$map$DSIMapViewerGoogleCtrl = DSIMapViewerGoogleCtrlTarget.class$("org.dsi.ifc.map.DSIMapViewerGoogleCtrl")) : class$org$dsi$ifc$map$DSIMapViewerGoogleCtrl);
        dSIMapViewerGoogleCtrl.setCopyrightPosition(null, 8, 2);
    }

    @Override
    public void reset(HashMap hashMap) {
        if (this.isDsiInHashMap(hashMap, (class$org$dsi$ifc$map$DSIMapViewerGoogleCtrl == null ? (class$org$dsi$ifc$map$DSIMapViewerGoogleCtrl = DSIMapViewerGoogleCtrlTarget.class$("org.dsi.ifc.map.DSIMapViewerGoogleCtrl")) : class$org$dsi$ifc$map$DSIMapViewerGoogleCtrl).getName(), 0)) {
            if (this.LOGGER.isTraceEnabled()) {
                this.LOGGER.trace("resetting values after DSI restart");
            }
            this.serviceInstancesInit();
        } else if (this.LOGGER.isTraceEnabled()) {
            this.LOGGER.trace("no reset necessary because restarted DSI(s) is/are not used in target");
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

