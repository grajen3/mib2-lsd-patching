/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.phone.bluetooth;

import de.vw.mib.asl.framework.api.dsiproxy.DSIProxy;
import de.vw.mib.asl.framework.api.dsiproxy.DSIProxyFactory;
import de.vw.mib.asl.framework.internal.framework.dsi.util.RuntimeGeneratedConstants;
import de.vw.mib.asl.internal.phone.bluetooth.StateBluetoothInquiryAbortPending;
import de.vw.mib.asl.internal.phone.bluetooth.StateBluetoothInquiryInit;
import de.vw.mib.asl.internal.phone.bluetooth.StateBluetoothInquiryInquiry;
import de.vw.mib.asl.internal.phone.bluetooth.StateBluetoothInquiryWaitForWaitstateEntered;
import de.vw.mib.asl.internal.phone.targets.abstracts.AbstractASLHsmPhoneTarget;
import de.vw.mib.genericevents.GenericEvents;
import de.vw.mib.genericevents.hsm.HsmState;
import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.bluetooth.DSIBluetooth;

public final class HsmPhoneBluetoothInquiry
extends AbstractASLHsmPhoneTarget {
    public static final String[] NEEDED_PHONE_DSIS = new String[]{RuntimeGeneratedConstants.SERVICE_TS_NS[8]};
    protected static final int BT_INQUIRY_RUNNNING_FALSE_TIMER;
    protected static final int EV_BT_INQUIRY_RUNNNING_FALSE_TIMER;
    public static final int EV_BONDING_SCREEN_LEFT_TIMER;
    public static final int EV_BONDING_SCREEN_ENTERED_TIMER;
    protected DSIBluetooth dsiBluetooth;
    protected DSIListener dsiBluetoothListener;
    final HsmState stateInit;
    final HsmState stateInquiry;
    final HsmState stateAbortPending;
    final HsmState stateWaitForWaitstateEntered;
    protected int currentlySelectedDeviceIndex = 0;
    protected boolean deviceFound = false;
    protected boolean isSearching = false;
    private boolean alreadyRegistered = false;
    static /* synthetic */ Class class$org$dsi$ifc$bluetooth$DSIBluetooth;
    static /* synthetic */ Class class$org$dsi$ifc$bluetooth$DSIBluetoothListener;

    public HsmPhoneBluetoothInquiry(GenericEvents genericEvents, String string) {
        super(genericEvents, string);
        this.stateInit = new StateBluetoothInquiryInit(this, genericEvents, this.hsm, "PhoneBluetoothInquiryInit", this.getWorkStateParent());
        this.stateInquiry = new StateBluetoothInquiryInquiry(this, genericEvents, this.hsm, "PhoneBluetoothInquiry", this.stateInit);
        this.stateAbortPending = new StateBluetoothInquiryAbortPending(this, genericEvents, this.hsm, "PhoneBluetoothInquiryAbortPending", this.stateInquiry);
        this.stateWaitForWaitstateEntered = new StateBluetoothInquiryWaitForWaitstateEntered(this, genericEvents, this.hsm, "PhoneBluetoothInquiryWaitForWaitstateEntered", this.stateInit);
    }

    @Override
    public int getDefaultTargetId() {
        return 5257;
    }

    protected void init() {
        if (!this.alreadyRegistered) {
            DSIProxy dSIProxy = DSIProxyFactory.getDSIProxyAPI().getDSIProxy();
            this.dsiBluetooth = (DSIBluetooth)dSIProxy.getService(this, class$org$dsi$ifc$bluetooth$DSIBluetooth == null ? (class$org$dsi$ifc$bluetooth$DSIBluetooth = HsmPhoneBluetoothInquiry.class$("org.dsi.ifc.bluetooth.DSIBluetooth")) : class$org$dsi$ifc$bluetooth$DSIBluetooth);
            this.dsiBluetoothListener = dSIProxy.getAdapterFactory().createDSIListenerMethodAdapter(this.getHsm(), class$org$dsi$ifc$bluetooth$DSIBluetoothListener == null ? (class$org$dsi$ifc$bluetooth$DSIBluetoothListener = HsmPhoneBluetoothInquiry.class$("org.dsi.ifc.bluetooth.DSIBluetoothListener")) : class$org$dsi$ifc$bluetooth$DSIBluetoothListener);
            dSIProxy.addResponseListener(this, class$org$dsi$ifc$bluetooth$DSIBluetoothListener == null ? (class$org$dsi$ifc$bluetooth$DSIBluetoothListener = HsmPhoneBluetoothInquiry.class$("org.dsi.ifc.bluetooth.DSIBluetoothListener")) : class$org$dsi$ifc$bluetooth$DSIBluetoothListener, this.dsiBluetoothListener);
        }
        this.alreadyRegistered = true;
    }

    protected void setNotification() {
        this.dsiBluetooth.setNotification(4, this.dsiBluetoothListener);
    }

    @Override
    protected HsmState getDefaultState() {
        return this.stateInit;
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

