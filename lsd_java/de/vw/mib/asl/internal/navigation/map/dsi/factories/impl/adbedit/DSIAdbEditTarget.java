/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.map.dsi.factories.impl.adbedit;

import de.vw.mib.asl.api.navigation.util.ASLNavigationUtilFactory;
import de.vw.mib.asl.api.navigation.util.IExtLogger;
import de.vw.mib.asl.framework.api.dsiproxy.DSIProxy;
import de.vw.mib.asl.framework.api.dsiproxy.DSIProxyFactory;
import de.vw.mib.asl.framework.internal.framework.AbstractASLHsmTarget;
import de.vw.mib.asl.internal.navigation.AbstractResettableTarget;
import de.vw.mib.asl.internal.navigation.map.dsi.DSIAdbEditVW;
import de.vw.mib.asl.internal.navigation.map.dsi.factories.impl.adbedit.DSIAdbEditTarget$1;
import de.vw.mib.asl.internal.navigation.map.dsi.factories.impl.adbedit.DSIAdbEditTargetData;
import de.vw.mib.asl.internal.navigation.map.dsi.factories.impl.adbedit.DSIAdbEditTargetDatapool;
import de.vw.mib.asl.internal.navigation.map.dsi.factories.impl.adbedit.DSIAdbEditVWImpl;
import de.vw.mib.genericevents.AbstractTarget;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.GenericEvents;
import java.util.HashMap;
import java.util.Iterator;
import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.organizer.DSIAdbEdit;
import org.dsi.ifc.organizer.DSIAdbEditListener;

public class DSIAdbEditTarget
extends AbstractResettableTarget {
    protected final DSIAdbEditTargetDatapool datapool;
    protected final IExtLogger logger;
    private final DSIProxy proxy = DSIProxyFactory.getDSIProxyAPI().getDSIProxy();
    static /* synthetic */ Class class$org$dsi$ifc$organizer$DSIAdbEdit;
    static /* synthetic */ Class class$org$dsi$ifc$organizer$DSIAdbEditListener;

    public DSIAdbEditTarget(GenericEvents genericEvents, int n, String string) {
        super(genericEvents, n, string);
        this.logger = ASLNavigationUtilFactory.getNavigationUtilApi().getExtLogger(256, "[DSIAdbEditTarget]");
        this.datapool = new DSIAdbEditTargetDatapool();
        this.initServiceStateListener();
    }

    public DSIAdbEditVW createAdbEdit(AbstractTarget abstractTarget, int[] nArray) {
        DSIAdbEditTargetData dSIAdbEditTargetData;
        if (abstractTarget == null) {
            this.logger.error("createAdbEdit( AbstractTarget target, int[] attributes ) - the target can't be null, execution stopped");
            return null;
        }
        Integer n = new Integer(abstractTarget.getTargetId());
        if (this.datapool.getServiceInstances().containsKey(n)) {
            this.logger.makeWarn().append("the target '").append(n).append("' is already registred").log();
            dSIAdbEditTargetData = (DSIAdbEditTargetData)this.datapool.getServiceInstances().get(n);
        } else {
            dSIAdbEditTargetData = this.createTargetData(abstractTarget, nArray);
            this.datapool.getServiceInstances().put(n, dSIAdbEditTargetData);
            if (this.datapool.isServiceAvailable()) {
                this.initAdbEditTarget(dSIAdbEditTargetData);
            }
        }
        return dSIAdbEditTargetData.getDsiAdbEditVW();
    }

    private DSIAdbEditTargetData createTargetData(AbstractTarget abstractTarget, int[] nArray) {
        DSIAdbEditTargetData dSIAdbEditTargetData = new DSIAdbEditTargetData();
        dSIAdbEditTargetData.setTarget(abstractTarget);
        dSIAdbEditTargetData.setAttributes(nArray);
        dSIAdbEditTargetData.setDsiAdbEditVW(new DSIAdbEditVWImpl());
        return dSIAdbEditTargetData;
    }

    @Override
    public void gotEvent(EventGeneric eventGeneric) {
    }

    private void initAdbEditTarget(DSIAdbEditTargetData dSIAdbEditTargetData) {
        this.logger.trace("initAdbEditTarget()");
        this.initAdbEditTargetDSI(dSIAdbEditTargetData);
        this.initAdbEditTargetDSIListener(dSIAdbEditTargetData);
        this.initAdbEditTargetResponseListener(dSIAdbEditTargetData);
        this.initAdbEditTargetAttributes(dSIAdbEditTargetData);
        dSIAdbEditTargetData.getDsiAdbEditVW().setFacadeEnabled(true);
    }

    private void initAdbEditTargetAttributes(DSIAdbEditTargetData dSIAdbEditTargetData) {
        int[] nArray = dSIAdbEditTargetData.getAttributes();
        if (nArray != null && nArray.length > 0) {
            dSIAdbEditTargetData.setAttributes(nArray);
            dSIAdbEditTargetData.getDsiAdbEdit().setNotification(nArray, (DSIListener)dSIAdbEditTargetData.getDsiAdbEditListener());
        }
    }

    private void initAdbEditTargetDSI(DSIAdbEditTargetData dSIAdbEditTargetData) {
        if (dSIAdbEditTargetData.getDsiAdbEdit() == null) {
            AbstractTarget abstractTarget = dSIAdbEditTargetData.getTarget();
            DSIAdbEdit dSIAdbEdit = (DSIAdbEdit)this.proxy.getService(abstractTarget, class$org$dsi$ifc$organizer$DSIAdbEdit == null ? (class$org$dsi$ifc$organizer$DSIAdbEdit = DSIAdbEditTarget.class$("org.dsi.ifc.organizer.DSIAdbEdit")) : class$org$dsi$ifc$organizer$DSIAdbEdit, 2);
            dSIAdbEditTargetData.getDsiAdbEditVW().setDsiAdbEdit(dSIAdbEdit);
            dSIAdbEditTargetData.setDsiAdbEdit(dSIAdbEdit);
        }
    }

    private void initAdbEditTargetDSIListener(DSIAdbEditTargetData dSIAdbEditTargetData) {
        if (dSIAdbEditTargetData.getDsiAdbEditListener() == null) {
            DSIAdbEditListener dSIAdbEditListener;
            AbstractTarget abstractTarget = dSIAdbEditTargetData.getTarget();
            if (abstractTarget instanceof AbstractASLHsmTarget) {
                AbstractASLHsmTarget abstractASLHsmTarget = (AbstractASLHsmTarget)abstractTarget;
                dSIAdbEditListener = (DSIAdbEditListener)this.proxy.getAdapterFactory().createDSIListenerMethodAdapter(abstractASLHsmTarget.getHsm(), class$org$dsi$ifc$organizer$DSIAdbEditListener == null ? (class$org$dsi$ifc$organizer$DSIAdbEditListener = DSIAdbEditTarget.class$("org.dsi.ifc.organizer.DSIAdbEditListener")) : class$org$dsi$ifc$organizer$DSIAdbEditListener);
            } else {
                dSIAdbEditListener = (DSIAdbEditListener)this.proxy.getAdapterFactory().createDSIListenerMethodAdapter(abstractTarget, class$org$dsi$ifc$organizer$DSIAdbEditListener == null ? (class$org$dsi$ifc$organizer$DSIAdbEditListener = DSIAdbEditTarget.class$("org.dsi.ifc.organizer.DSIAdbEditListener")) : class$org$dsi$ifc$organizer$DSIAdbEditListener);
            }
            dSIAdbEditTargetData.setDsiAdbEditListener(dSIAdbEditListener);
        }
    }

    private void initAdbEditTargetResponseListener(DSIAdbEditTargetData dSIAdbEditTargetData) {
        this.proxy.addResponseListener(dSIAdbEditTargetData.getTarget(), class$org$dsi$ifc$organizer$DSIAdbEditListener == null ? (class$org$dsi$ifc$organizer$DSIAdbEditListener = DSIAdbEditTarget.class$("org.dsi.ifc.organizer.DSIAdbEditListener")) : class$org$dsi$ifc$organizer$DSIAdbEditListener, 2, dSIAdbEditTargetData.getDsiAdbEditListener());
    }

    private void initServiceStateListener() {
        DSIAdbEditTarget$1 dSIAdbEditTarget$1 = new DSIAdbEditTarget$1(this);
        this.proxy.addServiceStateListener(class$org$dsi$ifc$organizer$DSIAdbEdit == null ? (class$org$dsi$ifc$organizer$DSIAdbEdit = DSIAdbEditTarget.class$("org.dsi.ifc.organizer.DSIAdbEdit")) : class$org$dsi$ifc$organizer$DSIAdbEdit, 2, dSIAdbEditTarget$1);
    }

    protected void serviceInstancesDisable() {
        this.logger.trace("serviceInstancesDisable()");
        this.datapool.setServiceAvailable(false);
        Iterator iterator = this.datapool.getServiceInstances().values().iterator();
        while (iterator.hasNext()) {
            DSIAdbEditTargetData dSIAdbEditTargetData = (DSIAdbEditTargetData)iterator.next();
            dSIAdbEditTargetData.getDsiAdbEditVW().setFacadeEnabled(false);
        }
    }

    protected void serviceInstancesInit() {
        this.logger.trace("serviceInstancesInit()");
        this.datapool.setServiceAvailable(true);
        Iterator iterator = this.datapool.getServiceInstances().values().iterator();
        while (iterator.hasNext()) {
            DSIAdbEditTargetData dSIAdbEditTargetData = (DSIAdbEditTargetData)iterator.next();
            this.initAdbEditTarget(dSIAdbEditTargetData);
        }
    }

    @Override
    public void reset(HashMap hashMap) {
        if (this.isDsiInHashMap(hashMap, (class$org$dsi$ifc$organizer$DSIAdbEdit == null ? (class$org$dsi$ifc$organizer$DSIAdbEdit = DSIAdbEditTarget.class$("org.dsi.ifc.organizer.DSIAdbEdit")) : class$org$dsi$ifc$organizer$DSIAdbEdit).getName(), 2)) {
            if (this.logger.isTraceEnabled()) {
                this.logger.trace("DSIAdbEdit restarted, registering");
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

