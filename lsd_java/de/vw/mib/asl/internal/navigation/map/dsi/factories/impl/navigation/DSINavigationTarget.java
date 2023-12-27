/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.map.dsi.factories.impl.navigation;

import de.vw.mib.asl.api.navigation.util.ASLNavigationUtilFactory;
import de.vw.mib.asl.api.navigation.util.IExtLogger;
import de.vw.mib.asl.framework.api.dsiproxy.DSIProxy;
import de.vw.mib.asl.framework.api.dsiproxy.DSIProxyFactory;
import de.vw.mib.asl.framework.internal.framework.AbstractASLHsmTarget;
import de.vw.mib.asl.internal.navigation.AbstractResettableTarget;
import de.vw.mib.asl.internal.navigation.map.dsi.DSINavigationVW;
import de.vw.mib.asl.internal.navigation.map.dsi.factories.impl.navigation.DSINavigationDatapool;
import de.vw.mib.asl.internal.navigation.map.dsi.factories.impl.navigation.DSINavigationTarget$1;
import de.vw.mib.asl.internal.navigation.map.dsi.factories.impl.navigation.DSINavigationTargetData;
import de.vw.mib.asl.internal.navigation.map.dsi.factories.impl.navigation.DSINavigationVWImpl;
import de.vw.mib.genericevents.AbstractTarget;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.GenericEvents;
import java.util.HashMap;
import java.util.Iterator;
import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.navigation.DSINavigation;
import org.dsi.ifc.navigation.DSINavigationListener;

public class DSINavigationTarget
extends AbstractResettableTarget {
    final IExtLogger logger = ASLNavigationUtilFactory.getNavigationUtilApi().getExtLogger(256, "[DSINavigationTarget]");
    final DSINavigationDatapool datapool;
    private final DSIProxy proxy = DSIProxyFactory.getDSIProxyAPI().getDSIProxy();
    static /* synthetic */ Class class$org$dsi$ifc$navigation$DSINavigation;
    static /* synthetic */ Class class$org$dsi$ifc$navigation$DSINavigationListener;

    public DSINavigationTarget(GenericEvents genericEvents, int n, String string) {
        super(genericEvents, n, string);
        this.datapool = new DSINavigationDatapool();
        this.init();
    }

    public DSINavigationVW createNavigation(AbstractTarget abstractTarget, int[] nArray) {
        DSINavigationTargetData dSINavigationTargetData;
        if (abstractTarget == null) {
            this.logger.error("createNavigation( AbstractTarget target, int[] attributes ) - the target can't be null, execution stopped");
            return null;
        }
        Integer n = new Integer(abstractTarget.getTargetId());
        if (this.datapool.getServiceInstances().containsKey(n)) {
            this.logger.makeWarn().append("the target '").append(n).append("' is already registred").log();
            dSINavigationTargetData = (DSINavigationTargetData)this.datapool.getServiceInstances().get(n);
        } else {
            dSINavigationTargetData = this.createTargetData(abstractTarget, nArray);
            this.datapool.getServiceInstances().put(n, dSINavigationTargetData);
            if (this.datapool.isServiceAvailable()) {
                this.initDSINavigation(dSINavigationTargetData);
            }
        }
        return dSINavigationTargetData.getDsiNavigationVW();
    }

    private DSINavigationTargetData createTargetData(AbstractTarget abstractTarget, int[] nArray) {
        DSINavigationTargetData dSINavigationTargetData = new DSINavigationTargetData();
        dSINavigationTargetData.setAttributes(nArray);
        dSINavigationTargetData.setTarget(abstractTarget);
        dSINavigationTargetData.setDsiNavigationVW(new DSINavigationVWImpl());
        return dSINavigationTargetData;
    }

    @Override
    public void gotEvent(EventGeneric eventGeneric) {
    }

    private void init() {
        this.initServiceStateListener();
    }

    private void initDSINavigation(DSINavigationTargetData dSINavigationTargetData) {
        this.initDSINavigationDSI(dSINavigationTargetData);
        this.initDSINavigationDSIListener(dSINavigationTargetData);
        this.initDSINavigationResponseListener(dSINavigationTargetData);
        this.initDSINavigationAttributes(dSINavigationTargetData);
        dSINavigationTargetData.getDsiNavigationVW().setFacadeEnabled(true);
    }

    private void initDSINavigationAttributes(DSINavigationTargetData dSINavigationTargetData) {
        int[] nArray = dSINavigationTargetData.getAttributes();
        if (nArray != null && nArray.length > 0) {
            dSINavigationTargetData.getDsiNavigation().setNotification(nArray, (DSIListener)dSINavigationTargetData.getDsiNavigationListener());
        }
    }

    private void initDSINavigationDSI(DSINavigationTargetData dSINavigationTargetData) {
        if (dSINavigationTargetData.getDsiNavigation() == null) {
            AbstractTarget abstractTarget = dSINavigationTargetData.getTarget();
            DSINavigation dSINavigation = (DSINavigation)this.proxy.getService(abstractTarget, class$org$dsi$ifc$navigation$DSINavigation == null ? (class$org$dsi$ifc$navigation$DSINavigation = DSINavigationTarget.class$("org.dsi.ifc.navigation.DSINavigation")) : class$org$dsi$ifc$navigation$DSINavigation);
            dSINavigationTargetData.setDsiNavigation(dSINavigation);
            DSINavigationVWImpl dSINavigationVWImpl = dSINavigationTargetData.getDsiNavigationVW();
            dSINavigationVWImpl.setDsiNavigation(dSINavigation);
        }
    }

    private void initDSINavigationDSIListener(DSINavigationTargetData dSINavigationTargetData) {
        if (dSINavigationTargetData.getDsiNavigationListener() == null) {
            DSINavigationListener dSINavigationListener;
            AbstractTarget abstractTarget = dSINavigationTargetData.getTarget();
            if (abstractTarget instanceof AbstractASLHsmTarget) {
                AbstractASLHsmTarget abstractASLHsmTarget = (AbstractASLHsmTarget)abstractTarget;
                dSINavigationListener = (DSINavigationListener)this.proxy.getAdapterFactory().createDSIListenerMethodAdapter(abstractASLHsmTarget.getHsm(), class$org$dsi$ifc$navigation$DSINavigationListener == null ? (class$org$dsi$ifc$navigation$DSINavigationListener = DSINavigationTarget.class$("org.dsi.ifc.navigation.DSINavigationListener")) : class$org$dsi$ifc$navigation$DSINavigationListener);
            } else {
                dSINavigationListener = (DSINavigationListener)this.proxy.getAdapterFactory().createDSIListenerMethodAdapter(abstractTarget, class$org$dsi$ifc$navigation$DSINavigationListener == null ? (class$org$dsi$ifc$navigation$DSINavigationListener = DSINavigationTarget.class$("org.dsi.ifc.navigation.DSINavigationListener")) : class$org$dsi$ifc$navigation$DSINavigationListener);
            }
            dSINavigationTargetData.setDsiNavigationListener(dSINavigationListener);
        }
    }

    private void initDSINavigationResponseListener(DSINavigationTargetData dSINavigationTargetData) {
        this.proxy.addResponseListener(dSINavigationTargetData.getTarget(), class$org$dsi$ifc$navigation$DSINavigationListener == null ? (class$org$dsi$ifc$navigation$DSINavigationListener = DSINavigationTarget.class$("org.dsi.ifc.navigation.DSINavigationListener")) : class$org$dsi$ifc$navigation$DSINavigationListener, dSINavigationTargetData.getDsiNavigationListener());
    }

    private void initServiceStateListener() {
        DSINavigationTarget$1 dSINavigationTarget$1 = new DSINavigationTarget$1(this);
        this.proxy.addServiceStateListener(class$org$dsi$ifc$navigation$DSINavigation == null ? (class$org$dsi$ifc$navigation$DSINavigation = DSINavigationTarget.class$("org.dsi.ifc.navigation.DSINavigation")) : class$org$dsi$ifc$navigation$DSINavigation, dSINavigationTarget$1);
    }

    protected void serviceInstancesDisable() {
        this.datapool.setServiceAvailable(false);
        Iterator iterator = this.datapool.getServiceInstances().values().iterator();
        while (iterator.hasNext()) {
            DSINavigationTargetData dSINavigationTargetData = (DSINavigationTargetData)iterator.next();
            DSINavigationVWImpl dSINavigationVWImpl = dSINavigationTargetData.getDsiNavigationVW();
            dSINavigationVWImpl.setFacadeEnabled(false);
        }
    }

    protected void serviceInstancesInit() {
        this.datapool.setServiceAvailable(true);
        Iterator iterator = this.datapool.getServiceInstances().values().iterator();
        while (iterator.hasNext()) {
            DSINavigationTargetData dSINavigationTargetData = (DSINavigationTargetData)iterator.next();
            this.initDSINavigation(dSINavigationTargetData);
        }
    }

    @Override
    public void reset(HashMap hashMap) {
        if (this.isDsiInHashMap(hashMap, (class$org$dsi$ifc$navigation$DSINavigation == null ? (class$org$dsi$ifc$navigation$DSINavigation = DSINavigationTarget.class$("org.dsi.ifc.navigation.DSINavigation")) : class$org$dsi$ifc$navigation$DSINavigation).getName(), 0)) {
            if (this.logger.isTraceEnabled()) {
                this.logger.trace("DSINavigation restarted, registering");
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

