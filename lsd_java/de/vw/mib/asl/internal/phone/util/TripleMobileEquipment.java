/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.phone.util;

import de.vw.mib.asl.framework.api.dsiproxy.DSIProxy;
import de.vw.mib.asl.framework.api.dsiproxy.DSIProxyFactory;
import de.vw.mib.asl.internal.phone.ASLPhoneData;
import de.vw.mib.asl.internal.phone.targets.abstracts.AbstractASLPhoneTarget;
import de.vw.mib.asl.internal.phone.util.DSIMobileEquipmentListenerDelegate;
import de.vw.mib.asl.internal.phone.util.TripleMobileEquipment$TopologyUsage;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.GenericEvents;
import de.vw.mib.log4mib.LogMessage;
import de.vw.mib.util.Util;
import edu.emory.mathcs.backport.java.util.Arrays;
import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.telephoneng.DSIMobileEquipment;
import org.dsi.ifc.telephoneng.DSIMobileEquipmentListener;
import org.dsi.ifc.telephoneng.DSIMobileEquipmentTopology;
import org.dsi.ifc.telephoneng.DSIMobileEquipmentTopologyListener;

public abstract class TripleMobileEquipment
extends AbstractASLPhoneTarget
implements DSIMobileEquipmentTopologyListener {
    private DSIMobileEquipmentTopology dsiTopology;
    private DSIMobileEquipment[] dsiMobileEquipment;
    private DSIMobileEquipmentListenerDelegate[] dsiMobileEquipmentListener;
    private TripleMobileEquipment$TopologyUsage topologyUsage;
    private int[] slots;
    private boolean poweredOn = false;
    private DSIMobileEquipmentListener primaryListener = null;
    private DSIMobileEquipmentListener associatedListener = null;
    private DSIMobileEquipmentListener nadListener = null;
    static /* synthetic */ Class class$org$dsi$ifc$telephoneng$DSIMobileEquipmentTopology;
    static /* synthetic */ Class class$org$dsi$ifc$telephoneng$DSIMobileEquipment;
    static /* synthetic */ Class class$org$dsi$ifc$telephoneng$DSIMobileEquipmentListener;

    public TripleMobileEquipment$TopologyUsage getTopologyUsage() {
        return this.topologyUsage;
    }

    public TripleMobileEquipment(GenericEvents genericEvents, String string) {
        super(genericEvents, string);
    }

    private void registerTopology() {
        this.trace("TripleMobileEquipment.registerTopology()");
        DSIProxy dSIProxy = DSIProxyFactory.getDSIProxyAPI().getDSIProxy();
        this.dsiTopology = (DSIMobileEquipmentTopology)dSIProxy.getService(this, class$org$dsi$ifc$telephoneng$DSIMobileEquipmentTopology == null ? (class$org$dsi$ifc$telephoneng$DSIMobileEquipmentTopology = TripleMobileEquipment.class$("org.dsi.ifc.telephoneng.DSIMobileEquipmentTopology")) : class$org$dsi$ifc$telephoneng$DSIMobileEquipmentTopology);
        this.dsiTopology.setNotification(2, (DSIListener)this);
    }

    private void registerMobileEquipments() {
        int n;
        this.trace(new StringBuffer().append("TripleMobileEquipment.registerMobileEquipments()").append(this).toString());
        if (this.dsiMobileEquipment != null) {
            this.error("registerMobileEquipments called twice! Probable cause: multiple updateUsage()");
            return;
        }
        DSIProxy dSIProxy = DSIProxyFactory.getDSIProxyAPI().getDSIProxy();
        this.dsiMobileEquipment = new DSIMobileEquipment[TripleMobileEquipment$TopologyUsage.access$000(this.topologyUsage).length];
        this.dsiMobileEquipmentListener = new DSIMobileEquipmentListenerDelegate[TripleMobileEquipment$TopologyUsage.access$000(this.topologyUsage).length];
        for (n = 0; n < TripleMobileEquipment$TopologyUsage.access$000(this.topologyUsage).length; ++n) {
            this.dsiMobileEquipmentListener[n] = new DSIMobileEquipmentListenerDelegate();
            if (TripleMobileEquipment$TopologyUsage.access$000(this.topologyUsage)[n] < 0) continue;
            this.dsiMobileEquipment[n] = (DSIMobileEquipment)dSIProxy.getService(this, class$org$dsi$ifc$telephoneng$DSIMobileEquipment == null ? TripleMobileEquipment.class$("org.dsi.ifc.telephoneng.DSIMobileEquipment") : class$org$dsi$ifc$telephoneng$DSIMobileEquipment, n);
            dSIProxy.addResponseListener(this, class$org$dsi$ifc$telephoneng$DSIMobileEquipmentListener == null ? TripleMobileEquipment.class$("org.dsi.ifc.telephoneng.DSIMobileEquipmentListener") : class$org$dsi$ifc$telephoneng$DSIMobileEquipmentListener, n, this.dsiMobileEquipmentListener[n]);
        }
        n = this.topologyUsage.getNad();
        if (n != -1 && this.getNadListener() != null) {
            dSIProxy.addResponseListener(this, class$org$dsi$ifc$telephoneng$DSIMobileEquipmentListener == null ? (class$org$dsi$ifc$telephoneng$DSIMobileEquipmentListener = TripleMobileEquipment.class$("org.dsi.ifc.telephoneng.DSIMobileEquipmentListener")) : class$org$dsi$ifc$telephoneng$DSIMobileEquipmentListener, n, this.getNadListener());
        }
    }

    protected abstract int[] getMobileEquipmentNotification() {
    }

    protected int[] getMobileEquipmentNadOnlyNotification() {
        return ASLPhoneData.EMPTY_NOTIFICATION;
    }

    protected int[] getMobileEquipmentHfpOnlyNotification() {
        return ASLPhoneData.EMPTY_NOTIFICATION;
    }

    protected DSIMobileEquipmentListener createPrimaryListener() {
        return null;
    }

    protected DSIMobileEquipmentListener createAssociatedListener() {
        return null;
    }

    protected DSIMobileEquipmentListener createNadListener() {
        return null;
    }

    public final DSIMobileEquipmentListener getPrimaryListener() {
        if (this.primaryListener == null) {
            this.primaryListener = this.createPrimaryListener();
        }
        return this.primaryListener;
    }

    public final DSIMobileEquipmentListener getAssociatedListener() {
        if (this.associatedListener == null) {
            this.associatedListener = this.createAssociatedListener();
        }
        return this.associatedListener;
    }

    public final DSIMobileEquipmentListener getNadListener() {
        if (this.nadListener == null) {
            this.nadListener = this.createNadListener();
        }
        return this.nadListener;
    }

    public DSIMobileEquipment getPrimary() {
        return this.dsiMobileEquipment[this.slots[0]];
    }

    public DSIMobileEquipment getAssociated() {
        return this.dsiMobileEquipment[this.slots[1]];
    }

    public DSIMobileEquipment getNad() {
        return this.dsiMobileEquipment[this.topologyUsage.getNad()];
    }

    public DSIMobileEquipment[] usedDsiMobileEquipments() {
        return this.getTopologyUsage().filterUsed(this.dsiMobileEquipment);
    }

    @Override
    public final void gotEvent(EventGeneric eventGeneric) {
        switch (eventGeneric.getReceiverEventId()) {
            case 106: {
                this.registerTopology();
                break;
            }
            case 107: {
                this.poweredOn = false;
            }
            default: {
                this.handleEvent(eventGeneric);
            }
        }
    }

    protected abstract void handleEvent(EventGeneric eventGeneric) {
    }

    protected abstract void powerOn() {
    }

    @Override
    public void asyncException(int n, String string, int n2) {
    }

    @Override
    public void updateUsage(int[] nArray, int n) {
        if (n != 1) {
            return;
        }
        this.topologyUsage = new TripleMobileEquipment$TopologyUsage(nArray);
        if (this.isTraceEnabled()) {
            this.trace().append("topologyUsage updateUsage: ").append(Arrays.toString(nArray)).log();
            this.trace().append("FirstNad is ").append(this.topologyUsage.getNad()).log();
        }
        this.dsiTopology.setNotification(1, (DSIListener)this);
        this.registerMobileEquipments();
    }

    @Override
    public void responseChangeTopology(int n) {
    }

    protected boolean isNadPrimary() {
        if (this.slots == null || this.topologyUsage == null) {
            this.warn().append(this).append("isNadPrimary() called, but not ready! slots = ").append(this.slots).append(", topologyUsage = ").append(this.topologyUsage).log();
        }
        return this.slots[0] == this.topologyUsage.getNad();
    }

    protected boolean isNadSecondary() {
        return this.slots[1] == this.topologyUsage.getNad();
    }

    protected boolean isNadInTopology() {
        return this.isNadPrimary() || this.isNadSecondary();
    }

    protected void pendingTopologyChange(int[] nArray, int[] nArray2) {
    }

    @Override
    public void updateTopology(int[] nArray, int n) {
        if (n == 1 && nArray != null && nArray.length != 0 && nArray[0] >= 0 && !Arrays.equals(nArray, this.slots)) {
            if (this.isTraceEnabled()) {
                this.trace().append(this).append(".updatetopology( ), setting slots...").log();
            }
            boolean[] blArray = new boolean[nArray.length];
            if (this.slots != null && nArray.length == this.slots.length) {
                for (int i2 = 0; i2 < nArray.length; ++i2) {
                    if (nArray[i2] == this.slots[i2]) continue;
                    if (nArray[i2] >= 0 && nArray[i2] < blArray.length) {
                        blArray[nArray[i2]] = true;
                    }
                    if (this.slots[i2] < 0 || this.slots[i2] >= blArray.length) continue;
                    blArray[this.slots[i2]] = true;
                }
            } else {
                Arrays.fill(blArray, true);
            }
            if (this.isTraceEnabled()) {
                LogMessage logMessage = this.trace().append(this).append(".updatetopology( ) changes on instances: ");
                for (int i3 = 0; i3 < blArray.length; ++i3) {
                    if (!blArray[i3]) continue;
                    logMessage.append(i3).append(", ");
                }
                logMessage.log();
            }
            try {
                this.pendingTopologyChange(this.slots, nArray);
            }
            catch (Exception exception) {
                this.error(exception);
            }
            this.slots = nArray;
            this.setSlotListeners();
            this.setMobileEquipmentNotifiers(blArray);
            if (!this.poweredOn) {
                this.poweredOn = true;
                this.powerOn();
            }
            if (ASLPhoneData.getInstance().nadMode == 0) {
                ASLPhoneData.getInstance().nadMode = this.isNadInTopology() ? 1 : 2;
            }
        }
    }

    private void setMobileEquipmentNotifiers(boolean[] blArray) {
        if (this.dsiMobileEquipmentListener == null) {
            return;
        }
        int[] nArray = this.getMobileEquipmentNotification();
        int[] nArray2 = this.getMobileEquipmentHfpOnlyNotification();
        int[] nArray3 = this.getMobileEquipmentNadOnlyNotification();
        int n = this.topologyUsage.getNad();
        for (int i2 = 0; i2 < this.dsiMobileEquipmentListener.length; ++i2) {
            if (this.dsiMobileEquipment[i2] == null || !blArray[i2]) continue;
            if (nArray == null && (i2 != n && nArray2 == null || i2 == n && nArray3 == null)) {
                if (this.dsiMobileEquipmentListener[i2] != null) {
                    this.dsiMobileEquipment[i2].setNotification(this.dsiMobileEquipmentListener[i2]);
                }
                if (i2 != n || this.getNadListener() == null) continue;
                this.dsiMobileEquipment[i2].setNotification(this.getNadListener());
                continue;
            }
            if (!Util.isNullOrEmpty(nArray)) {
                if (this.dsiMobileEquipmentListener[i2] != null) {
                    this.dsiMobileEquipment[i2].setNotification(nArray, (DSIListener)this.dsiMobileEquipmentListener[i2]);
                }
                if (i2 == n && this.getNadListener() != null) {
                    this.dsiMobileEquipment[i2].setNotification(nArray, (DSIListener)this.getNadListener());
                }
            }
            if (i2 != n && !Util.isNullOrEmpty(nArray2) && this.dsiMobileEquipmentListener[i2] != null) {
                this.dsiMobileEquipment[i2].setNotification(nArray2, (DSIListener)this.dsiMobileEquipmentListener[i2]);
                continue;
            }
            if (i2 != n || Util.isNullOrEmpty(nArray3)) continue;
            if (this.dsiMobileEquipmentListener[i2] != null) {
                this.dsiMobileEquipment[i2].setNotification(nArray3, (DSIListener)this.dsiMobileEquipmentListener[i2]);
            }
            if (this.getNadListener() == null) continue;
            this.dsiMobileEquipment[i2].setNotification(nArray3, (DSIListener)this.getNadListener());
        }
    }

    private void setSlotListeners() {
        if (this.slots == null) {
            return;
        }
        if (this.dsiMobileEquipmentListener == null) {
            return;
        }
        for (int i2 = 0; i2 < this.dsiMobileEquipmentListener.length; ++i2) {
            if (this.dsiMobileEquipmentListener[i2] == null) continue;
            this.dsiMobileEquipmentListener[i2].receiver = null;
        }
        if (this.slots[0] >= 0) {
            this.dsiMobileEquipmentListener[this.slots[0]].receiver = this.getPrimaryListener();
        }
        if (this.slots[1] >= 0) {
            this.dsiMobileEquipmentListener[this.slots[1]].receiver = this.getAssociatedListener();
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

