/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.map.dsi.factories.impl.zoomengine;

import de.vw.mib.asl.api.navigation.util.ASLNavigationUtilFactory;
import de.vw.mib.asl.api.navigation.util.IExtLogger;
import de.vw.mib.asl.framework.api.dsiproxy.DSIProxy;
import de.vw.mib.asl.framework.api.dsiproxy.DSIProxyFactory;
import de.vw.mib.asl.framework.internal.framework.AbstractASLHsmTarget;
import de.vw.mib.asl.internal.navigation.AbstractResettableTarget;
import de.vw.mib.asl.internal.navigation.map.dsi.DSIMapViewerZoomEngineVW;
import de.vw.mib.asl.internal.navigation.map.dsi.factories.impl.zoomengine.DSIMapViewerZoomEngineTarget$1;
import de.vw.mib.asl.internal.navigation.map.dsi.factories.impl.zoomengine.DSIMapViewerZoomEngineTargetData;
import de.vw.mib.asl.internal.navigation.map.dsi.factories.impl.zoomengine.DSIMapViewerZoomEngineTargetDatapool;
import de.vw.mib.asl.internal.navigation.map.dsi.factories.impl.zoomengine.DSIMapViewerZoomEngineVWImpl;
import de.vw.mib.genericevents.AbstractTarget;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.GenericEvents;
import java.util.HashMap;
import java.util.Iterator;
import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.map.DSIMapViewerZoomEngine;
import org.dsi.ifc.map.DSIMapViewerZoomEngineListener;

public class DSIMapViewerZoomEngineTarget
extends AbstractResettableTarget {
    protected final IExtLogger logger;
    protected final DSIMapViewerZoomEngineTargetDatapool datapool;
    private final DSIProxy proxy = DSIProxyFactory.getDSIProxyAPI().getDSIProxy();
    static /* synthetic */ Class class$org$dsi$ifc$map$DSIMapViewerZoomEngine;
    static /* synthetic */ Class class$org$dsi$ifc$map$DSIMapViewerZoomEngineListener;

    public DSIMapViewerZoomEngineTarget(GenericEvents genericEvents, int n, String string) {
        super(genericEvents, n, string);
        this.logger = ASLNavigationUtilFactory.getNavigationUtilApi().getExtLogger(256, "[DSIMapViewerZoomEngineTargets]");
        this.datapool = new DSIMapViewerZoomEngineTargetDatapool();
        this.initServiceStateListener();
    }

    public DSIMapViewerZoomEngineVW createMapViewerZoomEngine(AbstractTarget abstractTarget, int[] nArray) {
        DSIMapViewerZoomEngineTargetData dSIMapViewerZoomEngineTargetData;
        if (abstractTarget == null) {
            this.logger.error("createMobilityHorizon( AbstractTarget target, int[] attributes ) - the target can't be null, execution stopped");
            return null;
        }
        Integer n = new Integer(abstractTarget.getTargetId());
        if (this.datapool.getServiceInstances().containsKey(n)) {
            this.logger.makeWarn().append("the target '").append(n).append("' is already registred").log();
            dSIMapViewerZoomEngineTargetData = (DSIMapViewerZoomEngineTargetData)this.datapool.getServiceInstances().get(n);
        } else {
            dSIMapViewerZoomEngineTargetData = this.createTargetData(abstractTarget, nArray);
            this.datapool.getServiceInstances().put(n, dSIMapViewerZoomEngineTargetData);
            if (this.datapool.isServiceAvailable()) {
                this.initMapViewerZoomEngine(dSIMapViewerZoomEngineTargetData);
            }
        }
        return dSIMapViewerZoomEngineTargetData.getDsiMapViewerZoomEngineVW();
    }

    private DSIMapViewerZoomEngineTargetData createTargetData(AbstractTarget abstractTarget, int[] nArray) {
        DSIMapViewerZoomEngineTargetData dSIMapViewerZoomEngineTargetData = new DSIMapViewerZoomEngineTargetData();
        dSIMapViewerZoomEngineTargetData.setTarget(abstractTarget);
        dSIMapViewerZoomEngineTargetData.setAttributes(nArray);
        dSIMapViewerZoomEngineTargetData.setDsiMapViewerZoomEngineVW(new DSIMapViewerZoomEngineVWImpl());
        return dSIMapViewerZoomEngineTargetData;
    }

    @Override
    public void gotEvent(EventGeneric eventGeneric) {
    }

    private void initMapViewerZoomEngine(DSIMapViewerZoomEngineTargetData dSIMapViewerZoomEngineTargetData) {
        this.initMapViewerZoomEngineDSI(dSIMapViewerZoomEngineTargetData);
        this.initMapViewerZoomEngineDSIListener(dSIMapViewerZoomEngineTargetData);
        this.initMapViewerZoomEngineResponseListener(dSIMapViewerZoomEngineTargetData);
        this.initMapViewerZoomEngineAttributes(dSIMapViewerZoomEngineTargetData);
        dSIMapViewerZoomEngineTargetData.getDsiMapViewerZoomEngineVW().setFacadeEnabled(true);
    }

    private void initMapViewerZoomEngineAttributes(DSIMapViewerZoomEngineTargetData dSIMapViewerZoomEngineTargetData) {
        if (dSIMapViewerZoomEngineTargetData.getAttributes() != null && dSIMapViewerZoomEngineTargetData.getAttributes().length > 0) {
            dSIMapViewerZoomEngineTargetData.getDsiMapViewerZoomEngine().setNotification(dSIMapViewerZoomEngineTargetData.getAttributes(), (DSIListener)dSIMapViewerZoomEngineTargetData.getDsiMapViewerZoomEngineListener());
        }
    }

    private void initMapViewerZoomEngineDSI(DSIMapViewerZoomEngineTargetData dSIMapViewerZoomEngineTargetData) {
        if (dSIMapViewerZoomEngineTargetData.getDsiMapViewerZoomEngine() == null) {
            DSIMapViewerZoomEngine dSIMapViewerZoomEngine = (DSIMapViewerZoomEngine)this.proxy.getService(dSIMapViewerZoomEngineTargetData.getTarget(), class$org$dsi$ifc$map$DSIMapViewerZoomEngine == null ? (class$org$dsi$ifc$map$DSIMapViewerZoomEngine = DSIMapViewerZoomEngineTarget.class$("org.dsi.ifc.map.DSIMapViewerZoomEngine")) : class$org$dsi$ifc$map$DSIMapViewerZoomEngine);
            dSIMapViewerZoomEngineTargetData.setDsiMapViewerZoomEngine(dSIMapViewerZoomEngine);
            dSIMapViewerZoomEngineTargetData.getDsiMapViewerZoomEngineVW().setMapViewerZoomEngine(dSIMapViewerZoomEngine);
        }
    }

    private void initMapViewerZoomEngineDSIListener(DSIMapViewerZoomEngineTargetData dSIMapViewerZoomEngineTargetData) {
        if (dSIMapViewerZoomEngineTargetData.getDsiMapViewerZoomEngineListener() == null) {
            DSIMapViewerZoomEngineListener dSIMapViewerZoomEngineListener;
            AbstractTarget abstractTarget = dSIMapViewerZoomEngineTargetData.getTarget();
            if (abstractTarget instanceof AbstractASLHsmTarget) {
                AbstractASLHsmTarget abstractASLHsmTarget = (AbstractASLHsmTarget)abstractTarget;
                dSIMapViewerZoomEngineListener = (DSIMapViewerZoomEngineListener)this.proxy.getAdapterFactory().createDSIListenerMethodAdapter(abstractASLHsmTarget.getHsm(), class$org$dsi$ifc$map$DSIMapViewerZoomEngineListener == null ? (class$org$dsi$ifc$map$DSIMapViewerZoomEngineListener = DSIMapViewerZoomEngineTarget.class$("org.dsi.ifc.map.DSIMapViewerZoomEngineListener")) : class$org$dsi$ifc$map$DSIMapViewerZoomEngineListener);
            } else {
                dSIMapViewerZoomEngineListener = (DSIMapViewerZoomEngineListener)this.proxy.getAdapterFactory().createDSIListenerMethodAdapter(abstractTarget, class$org$dsi$ifc$map$DSIMapViewerZoomEngineListener == null ? (class$org$dsi$ifc$map$DSIMapViewerZoomEngineListener = DSIMapViewerZoomEngineTarget.class$("org.dsi.ifc.map.DSIMapViewerZoomEngineListener")) : class$org$dsi$ifc$map$DSIMapViewerZoomEngineListener);
            }
            dSIMapViewerZoomEngineTargetData.setDsiMapViewerZoomEngineListener(dSIMapViewerZoomEngineListener);
        }
    }

    private void initMapViewerZoomEngineResponseListener(DSIMapViewerZoomEngineTargetData dSIMapViewerZoomEngineTargetData) {
        this.proxy.addResponseListener(dSIMapViewerZoomEngineTargetData.getTarget(), class$org$dsi$ifc$map$DSIMapViewerZoomEngineListener == null ? (class$org$dsi$ifc$map$DSIMapViewerZoomEngineListener = DSIMapViewerZoomEngineTarget.class$("org.dsi.ifc.map.DSIMapViewerZoomEngineListener")) : class$org$dsi$ifc$map$DSIMapViewerZoomEngineListener, dSIMapViewerZoomEngineTargetData.getDsiMapViewerZoomEngineListener());
    }

    private void initServiceStateListener() {
        DSIMapViewerZoomEngineTarget$1 dSIMapViewerZoomEngineTarget$1 = new DSIMapViewerZoomEngineTarget$1(this);
        this.proxy.addServiceStateListener(class$org$dsi$ifc$map$DSIMapViewerZoomEngine == null ? (class$org$dsi$ifc$map$DSIMapViewerZoomEngine = DSIMapViewerZoomEngineTarget.class$("org.dsi.ifc.map.DSIMapViewerZoomEngine")) : class$org$dsi$ifc$map$DSIMapViewerZoomEngine, dSIMapViewerZoomEngineTarget$1);
    }

    protected void serviceInstancesDisable() {
        this.logger.trace("serviceInstancesDisable()");
        this.datapool.setServiceAvailable(false);
        Iterator iterator = this.datapool.getServiceInstances().values().iterator();
        while (iterator.hasNext()) {
            DSIMapViewerZoomEngineTargetData dSIMapViewerZoomEngineTargetData = (DSIMapViewerZoomEngineTargetData)iterator.next();
            dSIMapViewerZoomEngineTargetData.getDsiMapViewerZoomEngineVW().setFacadeEnabled(false);
        }
    }

    protected void serviceInstancesInit() {
        this.logger.trace("serviceInstancesInit()");
        this.datapool.setServiceAvailable(true);
        Iterator iterator = this.datapool.getServiceInstances().values().iterator();
        while (iterator.hasNext()) {
            DSIMapViewerZoomEngineTargetData dSIMapViewerZoomEngineTargetData = (DSIMapViewerZoomEngineTargetData)iterator.next();
            this.initMapViewerZoomEngine(dSIMapViewerZoomEngineTargetData);
        }
    }

    @Override
    public void reset(HashMap hashMap) {
        if (this.isDsiInHashMap(hashMap, (class$org$dsi$ifc$map$DSIMapViewerZoomEngine == null ? (class$org$dsi$ifc$map$DSIMapViewerZoomEngine = DSIMapViewerZoomEngineTarget.class$("org.dsi.ifc.map.DSIMapViewerZoomEngine")) : class$org$dsi$ifc$map$DSIMapViewerZoomEngine).getName(), 0)) {
            if (this.logger.isTraceEnabled()) {
                this.logger.trace("DSIMapViewerZoomEngine restarted, registering");
            }
            this.serviceInstancesInit();
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

