/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.phone.bluetooth;

import de.vw.mib.asl.framework.api.dsiproxy.DSIProxy;
import de.vw.mib.asl.framework.api.dsiproxy.DSIProxyFactory;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.framework.internal.framework.dsi.util.RuntimeGeneratedConstants;
import de.vw.mib.asl.internal.phone.ASLPhoneData;
import de.vw.mib.asl.internal.phone.bluetooth.AbstractHsmBluetoothServiceConnectState;
import de.vw.mib.asl.internal.phone.bluetooth.StateBluetoothServiceConnectInit;
import de.vw.mib.asl.internal.phone.bluetooth.StateBluetoothServiceConnectPasskeyFirst;
import de.vw.mib.asl.internal.phone.bluetooth.StateBluetoothServiceConnectServiceConnect;
import de.vw.mib.asl.internal.phone.bluetooth.StateBluetoothServiceConnectWaitForWaitstateEntered;
import de.vw.mib.asl.internal.phone.targets.abstracts.AbstractASLHsmPhoneTarget;
import de.vw.mib.asl.internal.phone.util.PhoneUtil;
import de.vw.mib.collections.ints.IntObjectOptHashMap;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.GenericEvents;
import de.vw.mib.genericevents.hsm.Hsm;
import de.vw.mib.genericevents.hsm.HsmState;
import generated.de.vw.mib.asl.internal.ListManager;
import generated.de.vw.mib.asl.internal.phone.bluetooth.transformer.PhoneBluetoothBondingErrorCollector;
import java.util.HashMap;
import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.bluetooth.DSIBluetooth;

public class HsmPhoneBluetoothServiceConnect
extends AbstractASLHsmPhoneTarget {
    private static final int IPOD_COMPARE_LENGTH;
    public static final String[] NEEDED_PHONE_DSIS;
    protected DSIBluetooth dsiBluetooth;
    protected DSIListener dsiBluetoothListener;
    final AbstractHsmBluetoothServiceConnectState stateInit;
    final AbstractHsmBluetoothServiceConnectState stateWaitForWaitstateEntered;
    final AbstractHsmBluetoothServiceConnectState stateServiceConnect;
    final AbstractHsmBluetoothServiceConnectState stateServiceConnectPassKeyFirst;
    protected String btDeviceAddress;
    protected String btDeviceName;
    protected String requestedDeviceAddress = "";
    private String requestedDeviceName = "";
    protected int requestedDeviceServiceType = 1;
    protected int requestedDeviceRole = 0;
    protected static IntObjectOptHashMap connectedDevicesASLMap;
    protected static HashMap connectedDevicesTrusted;
    protected static final int EV_PHONE_CONNECT_ERROR_TIMER;
    protected final int EV_PHONE_CONNECT_ERROR_TIMER_P0_NAME_STRING;
    protected final int EV_PHONE_CONNECT_ERROR_TIMER_P1_ADDRESS_STRING;
    protected final int EV_PHONE_CONNECT_ERROR_TIMER_P2_SERVICE_INT;
    protected final int PHONE_CONNECT_ERROR_TIMER;
    protected String[] currentIpodNames = new String[0];
    protected String currentMirrorlinkDevice = "";
    protected boolean abortConnectionByPassKeyReject = false;
    private boolean alreadyRegistered = false;
    protected String limitExceededDeviceAddress;
    protected int limitExceededServiceType;
    protected int limitExceededRole;
    protected boolean limitExceededReconnect;
    static /* synthetic */ Class class$org$dsi$ifc$bluetooth$DSIBluetooth;
    static /* synthetic */ Class class$org$dsi$ifc$bluetooth$DSIBluetoothListener;

    public HsmPhoneBluetoothServiceConnect(GenericEvents genericEvents, String string) {
        super(genericEvents, string);
        this.EV_PHONE_CONNECT_ERROR_TIMER_P0_NAME_STRING = 0;
        this.EV_PHONE_CONNECT_ERROR_TIMER_P1_ADDRESS_STRING = 1;
        this.EV_PHONE_CONNECT_ERROR_TIMER_P2_SERVICE_INT = 2;
        this.PHONE_CONNECT_ERROR_TIMER = 549388800;
        this.stateInit = new StateBluetoothServiceConnectInit(this, genericEvents, this.hsm, "PhoneBluetoothServiceConnectTop", this.getWorkStateParent());
        this.stateWaitForWaitstateEntered = new StateBluetoothServiceConnectWaitForWaitstateEntered(this, genericEvents, this.hsm, "PhoneBluetoothWaitForWaitstateEntered", this.stateInit);
        this.stateServiceConnect = new StateBluetoothServiceConnectServiceConnect(this, genericEvents, this.hsm, "PhoneBluetoothServiceConnect", this.stateInit);
        this.stateServiceConnectPassKeyFirst = new StateBluetoothServiceConnectPasskeyFirst(this, genericEvents, this.hsm, "PhoneBluetoothServiceConnectPassKeyFirst", this.stateServiceConnect);
        connectedDevicesTrusted.clear();
        connectedDevicesASLMap.clear();
    }

    @Override
    public int getDefaultTargetId() {
        return 5259;
    }

    protected void init() {
        if (!this.alreadyRegistered) {
            DSIProxy dSIProxy = DSIProxyFactory.getDSIProxyAPI().getDSIProxy();
            this.dsiBluetooth = (DSIBluetooth)dSIProxy.getService(this, class$org$dsi$ifc$bluetooth$DSIBluetooth == null ? (class$org$dsi$ifc$bluetooth$DSIBluetooth = HsmPhoneBluetoothServiceConnect.class$("org.dsi.ifc.bluetooth.DSIBluetooth")) : class$org$dsi$ifc$bluetooth$DSIBluetooth);
            this.dsiBluetoothListener = dSIProxy.getAdapterFactory().createDSIListenerMethodAdapter(this.getHsm(), class$org$dsi$ifc$bluetooth$DSIBluetoothListener == null ? (class$org$dsi$ifc$bluetooth$DSIBluetoothListener = HsmPhoneBluetoothServiceConnect.class$("org.dsi.ifc.bluetooth.DSIBluetoothListener")) : class$org$dsi$ifc$bluetooth$DSIBluetoothListener);
            dSIProxy.addResponseListener(this, class$org$dsi$ifc$bluetooth$DSIBluetoothListener == null ? (class$org$dsi$ifc$bluetooth$DSIBluetoothListener = HsmPhoneBluetoothServiceConnect.class$("org.dsi.ifc.bluetooth.DSIBluetoothListener")) : class$org$dsi$ifc$bluetooth$DSIBluetoothListener, this.dsiBluetoothListener);
            this.addObserver(-1010422528);
            this.addObserver(30683136);
            ListManager.getGenericASLList(2855).updateList(new PhoneBluetoothBondingErrorCollector[]{new PhoneBluetoothBondingErrorCollector()});
        }
        this.alreadyRegistered = true;
    }

    protected void setNotification() {
        this.dsiBluetooth.setNotification(new int[]{12, 6, 14}, this.dsiBluetoothListener);
    }

    protected void connectService(int n, String string, String string2, int n2) {
        Object object;
        if (n == 2 || n == 4 || n == 32) {
            ASLPhoneData.getInstance().isAddressbookConnecting = true;
        }
        this.requestedDeviceAddress = string;
        this.requestedDeviceName = string2;
        this.requestedDeviceServiceType = n;
        HsmPhoneBluetoothServiceConnect.writeStringToDatapool(1120, string2);
        boolean bl = false;
        if (n == 256) {
            object = string2;
            if (((String)object).length() > 40) {
                object = ((String)object).substring(0, 40);
            }
            for (int i2 = 0; i2 < this.currentIpodNames.length; ++i2) {
                String string3 = this.currentIpodNames[i2];
                if (string3.length() > 40) {
                    string3 = string3.substring(0, 40);
                }
                if (!string3.equals(object)) continue;
                bl = true;
            }
            if (this.currentMirrorlinkDevice.equalsIgnoreCase(string)) {
                bl = true;
            }
        }
        if (!bl) {
            object = ServiceManager.mGenericEventFactory.newEvent(5259, 5259, 75956480);
            ((EventGeneric)object).setString(0, string2);
            ((EventGeneric)object).setString(1, string);
            ((EventGeneric)object).setInt(2, n);
            this.startTimer((EventGeneric)object, 0, false, false);
            this.dsiBluetooth.requestConnectService(string, n, n2);
            ASLPhoneData.getInstance().isConnectRequested = true;
            PhoneUtil.sendBluetoothInquiryRunning(this, true);
            ASLPhoneData.getInstance().requestedService = n;
            ASLPhoneData.getInstance().addressOfOngoingConnectionRequest = string;
            if ((n == 2 || n == 4) && n2 != 2) {
                EventGeneric eventGeneric = ServiceManager.mGenericEventFactory.newEvent(5259, 5251, -2014431744);
                eventGeneric.setBoolean(0, true);
                this.send(eventGeneric);
            }
        } else {
            PhoneUtil.setBTBondingError(n, string, string2, 12);
            this.sendHMIEvent(133);
        }
    }

    protected void disconnectService(String string, int n) {
        ASLPhoneData.getInstance().isDisconnectRequested = true;
        this.dsiBluetooth.requestDisconnectService(string, n);
    }

    protected void asyncRequestConnectService() {
        ASLPhoneData.getInstance().isAddressbookConnecting = false;
        ASLPhoneData.getInstance().isConnectRequested = false;
        this.triggerObserver(-1393674752, null);
        this.requestedDeviceServiceType = 1;
        ASLPhoneData.getInstance().addressOfOngoingConnectionRequest = "";
        PhoneUtil.sendBluetoothInquiryRunning(this, false);
        try {
            for (AbstractHsmBluetoothServiceConnectState abstractHsmBluetoothServiceConnectState = (AbstractHsmBluetoothServiceConnectState)this.getHsm().getState(); abstractHsmBluetoothServiceConnectState != null; abstractHsmBluetoothServiceConnectState = (AbstractHsmBluetoothServiceConnectState)abstractHsmBluetoothServiceConnectState.dsiBluetoothResponseConnectService(this.requestedDeviceAddress, this.requestedDeviceName, this.requestedDeviceServiceType, 0, 5)) {
            }
        }
        catch (ClassCastException classCastException) {
            // empty catch block
        }
    }

    @Override
    protected HsmState getDefaultState() {
        return this.stateInit;
    }

    public HsmState getWorkingState(Hsm hsm, HsmState hsmState) {
        return this.stateInit;
    }

    public HashMap getConnectedDevicesTrusted() {
        return connectedDevicesTrusted;
    }

    public IntObjectOptHashMap getConnectedDevicesASLMap() {
        return connectedDevicesASLMap;
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
        NEEDED_PHONE_DSIS = new String[]{RuntimeGeneratedConstants.SERVICE_TS_NS[8]};
        connectedDevicesASLMap = new IntObjectOptHashMap(2);
        connectedDevicesTrusted = new HashMap(10);
    }
}

