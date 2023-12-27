/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.phone.targets.abstracts;

import de.vw.mib.asl.framework.api.dsiproxy.DSIProxy;
import de.vw.mib.asl.framework.api.dsiproxy.DSIProxyFactory;
import de.vw.mib.asl.internal.phone.ASLPhoneData;
import de.vw.mib.asl.internal.phone.targets.abstracts.AbstractASLHsmPhoneTarget;
import de.vw.mib.genericevents.GenericEvents;
import de.vw.mib.util.Util;
import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.telephoneng.DSIMobileEquipment;
import org.dsi.ifc.telephoneng.DSIMobileEquipmentTopology;
import org.dsi.ifc.telephoneng.DSIMobileEquipmentTopologyListener;

public abstract class AbstractHsmTripleMobileEquipment
extends AbstractASLHsmPhoneTarget
implements DSIMobileEquipmentTopologyListener {
    private DSIMobileEquipmentTopology dsiTopology;
    private int primaryInstanceId = -1;
    private int associatedInstanceId = -1;
    public DSIMobileEquipment dsiPrimary;
    public DSIMobileEquipment dsiAssociated;
    private DSIListener dsiTopologyListener;
    private DSIListener dsiMobileEquipmentListener;
    protected DSIListener dsiAssociatedListener = null;
    private boolean alreadyRegistered = false;
    static /* synthetic */ Class class$org$dsi$ifc$telephoneng$DSIMobileEquipmentTopology;
    static /* synthetic */ Class class$org$dsi$ifc$telephoneng$DSIMobileEquipmentListener;
    static /* synthetic */ Class class$org$dsi$ifc$telephoneng$DSIMobileEquipmentTopologyListener;
    static /* synthetic */ Class class$org$dsi$ifc$telephoneng$DSIMobileEquipment;

    public AbstractHsmTripleMobileEquipment(GenericEvents genericEvents, String string) {
        super(genericEvents, string);
    }

    protected void init() {
        if (!this.alreadyRegistered) {
            DSIProxy dSIProxy = DSIProxyFactory.getDSIProxyAPI().getDSIProxy();
            this.dsiTopology = (DSIMobileEquipmentTopology)dSIProxy.getService(this, class$org$dsi$ifc$telephoneng$DSIMobileEquipmentTopology == null ? (class$org$dsi$ifc$telephoneng$DSIMobileEquipmentTopology = AbstractHsmTripleMobileEquipment.class$("org.dsi.ifc.telephoneng.DSIMobileEquipmentTopology")) : class$org$dsi$ifc$telephoneng$DSIMobileEquipmentTopology);
            this.dsiTopologyListener = this;
            this.dsiMobileEquipmentListener = dSIProxy.getAdapterFactory().createDSIListenerMethodAdapter(this.getHsm(), class$org$dsi$ifc$telephoneng$DSIMobileEquipmentListener == null ? (class$org$dsi$ifc$telephoneng$DSIMobileEquipmentListener = AbstractHsmTripleMobileEquipment.class$("org.dsi.ifc.telephoneng.DSIMobileEquipmentListener")) : class$org$dsi$ifc$telephoneng$DSIMobileEquipmentListener);
            dSIProxy.addResponseListener(this, class$org$dsi$ifc$telephoneng$DSIMobileEquipmentTopologyListener == null ? (class$org$dsi$ifc$telephoneng$DSIMobileEquipmentTopologyListener = AbstractHsmTripleMobileEquipment.class$("org.dsi.ifc.telephoneng.DSIMobileEquipmentTopologyListener")) : class$org$dsi$ifc$telephoneng$DSIMobileEquipmentTopologyListener, this.dsiTopologyListener);
        }
        this.alreadyRegistered = true;
    }

    protected void setNotification() {
        this.dsiTopology.setNotification(this.dsiTopologyListener);
    }

    protected abstract int[] getMobileEquipmentNotification() {
    }

    protected int[] getMobileEquipmentNadOnlyNotification() {
        return ASLPhoneData.EMPTY_NOTIFICATION;
    }

    protected int[] getMobileEquipmentHfpOnlyNotification() {
        return ASLPhoneData.EMPTY_NOTIFICATION;
    }

    private void registerMobileEquipment(int n) {
        DSIProxy dSIProxy = DSIProxyFactory.getDSIProxyAPI().getDSIProxy();
        this.info().append("AbstractHsmTripleMobileEquipment: Switching primary    from ").append(this.primaryInstanceId).append(" to ").append(n).append(".").log();
        this.primaryInstanceId = n;
        this.dsiPrimary = (DSIMobileEquipment)dSIProxy.getService(this, class$org$dsi$ifc$telephoneng$DSIMobileEquipment == null ? (class$org$dsi$ifc$telephoneng$DSIMobileEquipment = AbstractHsmTripleMobileEquipment.class$("org.dsi.ifc.telephoneng.DSIMobileEquipment")) : class$org$dsi$ifc$telephoneng$DSIMobileEquipment, n);
        dSIProxy.addResponseListener(this, class$org$dsi$ifc$telephoneng$DSIMobileEquipmentListener == null ? (class$org$dsi$ifc$telephoneng$DSIMobileEquipmentListener = AbstractHsmTripleMobileEquipment.class$("org.dsi.ifc.telephoneng.DSIMobileEquipmentListener")) : class$org$dsi$ifc$telephoneng$DSIMobileEquipmentListener, n, this.dsiMobileEquipmentListener);
        boolean bl = false;
        if (this.getMobileEquipmentNotification() != null && !Util.isNullOrEmpty(this.getMobileEquipmentNotification())) {
            this.dsiPrimary.setNotification(this.getMobileEquipmentNotification(), this.dsiMobileEquipmentListener);
            bl = true;
        }
        if (this.getMobileEquipmentHfpOnlyNotification() != null && !Util.isNullOrEmpty(this.getMobileEquipmentHfpOnlyNotification())) {
            this.dsiPrimary.setNotification(this.getMobileEquipmentHfpOnlyNotification(), this.dsiMobileEquipmentListener);
            bl = true;
        }
        if (!bl) {
            this.dsiPrimary.setNotification(this.dsiMobileEquipmentListener);
        }
    }

    private void registerAssociated(int n) {
        if (this.dsiAssociatedListener == null) {
            return;
        }
        DSIProxy dSIProxy = DSIProxyFactory.getDSIProxyAPI().getDSIProxy();
        this.info().append("AbstractHsmTripleMobileEquipment: Switching associated from ").append(this.associatedInstanceId).append(" to ").append(n).append(".").log();
        this.associatedInstanceId = n;
        this.dsiAssociated = (DSIMobileEquipment)dSIProxy.getService(this, class$org$dsi$ifc$telephoneng$DSIMobileEquipment == null ? (class$org$dsi$ifc$telephoneng$DSIMobileEquipment = AbstractHsmTripleMobileEquipment.class$("org.dsi.ifc.telephoneng.DSIMobileEquipment")) : class$org$dsi$ifc$telephoneng$DSIMobileEquipment, n);
        dSIProxy.addResponseListener(this, class$org$dsi$ifc$telephoneng$DSIMobileEquipmentListener == null ? (class$org$dsi$ifc$telephoneng$DSIMobileEquipmentListener = AbstractHsmTripleMobileEquipment.class$("org.dsi.ifc.telephoneng.DSIMobileEquipmentListener")) : class$org$dsi$ifc$telephoneng$DSIMobileEquipmentListener, n, this.dsiAssociatedListener);
        boolean bl = false;
        if (this.getMobileEquipmentNotification() != null && !Util.isNullOrEmpty(this.getMobileEquipmentNotification())) {
            this.dsiAssociated.setNotification(this.getMobileEquipmentNotification(), this.dsiMobileEquipmentListener);
            bl = true;
        }
        if (this.getMobileEquipmentHfpOnlyNotification() != null && !Util.isNullOrEmpty(this.getMobileEquipmentHfpOnlyNotification())) {
            this.dsiAssociated.setNotification(this.getMobileEquipmentHfpOnlyNotification(), this.dsiMobileEquipmentListener);
            bl = true;
        }
        if (!bl) {
            this.dsiAssociated.setNotification(this.dsiMobileEquipmentListener);
        }
    }

    @Override
    public void asyncException(int n, String string, int n2) {
    }

    @Override
    public void responseChangeTopology(int n) {
    }

    @Override
    public void updateTopology(int[] nArray, int n) {
        if (n == 1 && nArray[0] >= 0) {
            int n2 = nArray[0];
            if (n2 != this.primaryInstanceId) {
                this.registerMobileEquipment(n2);
            }
            if ((n2 = nArray[1]) != this.associatedInstanceId) {
                this.registerAssociated(n2);
            }
        }
    }

    @Override
    public void updateUsage(int[] nArray, int n) {
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

