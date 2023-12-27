/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.phone.bluetooth;

import de.vw.mib.asl.framework.internal.framework.AbstractASLHsmTarget;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.phone.ASLPhoneData;
import de.vw.mib.asl.internal.phone.bluetooth.AbstractHsmBluetoothServiceConnectState;
import de.vw.mib.asl.internal.phone.bluetooth.ConnectedDevice;
import de.vw.mib.asl.internal.phone.bluetooth.ConnectedDeviceASL;
import de.vw.mib.asl.internal.phone.bluetooth.HsmPhoneBluetoothServiceConnect;
import de.vw.mib.asl.internal.phone.util.PhoneUtil;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.GenericEvents;
import de.vw.mib.genericevents.hsm.Hsm;
import de.vw.mib.genericevents.hsm.HsmState;
import de.vw.mib.util.Util;
import java.util.Iterator;
import org.dsi.ifc.bluetooth.MasterRoleRequestStruct;

public class StateBluetoothServiceConnectInit
extends AbstractHsmBluetoothServiceConnectState {
    private final HsmPhoneBluetoothServiceConnect target;

    public StateBluetoothServiceConnectInit(HsmPhoneBluetoothServiceConnect hsmPhoneBluetoothServiceConnect, GenericEvents genericEvents, Hsm hsm, String string, HsmState hsmState) {
        super(hsm, string, hsmState);
        this.target = hsmPhoneBluetoothServiceConnect;
    }

    @Override
    public HsmState handle(EventGeneric eventGeneric) {
        HsmState hsmState = null;
        switch (eventGeneric.getReceiverEventId()) {
            case 3: {
                this.target.init();
                this.target.setNotification();
                this.trans(this.target.stateServiceConnect);
                AbstractASLHsmTarget.writeBooleanToDatapool(1134, false);
                break;
            }
            case 1073742712: {
                this.target.warn("ENTER_CONNECT_WAITSTATE handled in StateBluetoothServiceConnectInit");
                break;
            }
            case 100100: {
                super.getClass();
                String string = eventGeneric.getString(0);
                super.getClass();
                String string2 = eventGeneric.getString(1);
                super.getClass();
                int n = eventGeneric.getInt(2);
                PhoneUtil.setBTBondingError(n, string2, string, 3);
                this.target.sendHMIEvent(133);
                if (!this.target.isTraceEnabled()) break;
                this.target.trace().append("send event BLUETOOTH_CONNECTION_FAILED from PHONE_CONNECT_ERROR_TIMER").log();
                break;
            }
            case 3600022: {
                this.target.stopTimer(75956480);
                break;
            }
            case 3000003: {
                this.target.currentIpodNames = (String[])eventGeneric.getObject(0);
                break;
            }
            case 3600032: {
                String string = eventGeneric.getString(0);
                boolean bl = eventGeneric.getBoolean(1);
                boolean bl2 = eventGeneric.getBoolean(2);
                this.disconnectBT(string, bl2, bl);
                break;
            }
            case 3200001: {
                this.target.currentMirrorlinkDevice = eventGeneric.getString(1);
                if (Util.isNullOrEmpty(this.target.currentMirrorlinkDevice)) break;
                this.disconnectBT(this.target.currentMirrorlinkDevice, false, true);
                break;
            }
            case 3600001: {
                this.disconnectBT(null, false, true);
                break;
            }
            case 1073744623: {
                AbstractASLHsmTarget.writeBooleanToDatapool(3930, eventGeneric.getBoolean(0) && (this.target.requestedDeviceServiceType == 2 && this.target.requestedDeviceRole != 2 || this.target.requestedDeviceServiceType == 4));
                break;
            }
            default: {
                hsmState = this.myParent;
            }
        }
        return hsmState;
    }

    private void disconnectBT(String string, boolean bl, boolean bl2) {
        Iterator iterator = ASLPhoneData.getInstance().trustedBTDevices.values().iterator();
        while (iterator.hasNext()) {
            ConnectedDevice connectedDevice = (ConnectedDevice)iterator.next();
            if (!Util.isNullOrEmpty(string) && !string.equalsIgnoreCase(connectedDevice.device.getDeviceAddress())) continue;
            if (bl2 && PhoneUtil.contains(connectedDevice.connectedServices, 256)) {
                this.target.dsiBluetooth.requestDisconnectService(connectedDevice.device.deviceAddress, 256);
            }
            if (bl && PhoneUtil.contains(connectedDevice.connectedServices, 2)) {
                this.target.dsiBluetooth.requestDisconnectService(connectedDevice.device.deviceAddress, 2);
            }
            if (!bl || !PhoneUtil.contains(connectedDevice.connectedServices, 4)) continue;
            this.target.dsiBluetooth.requestDisconnectService(connectedDevice.device.deviceAddress, 4);
        }
    }

    public void dsiBluetoothUpdateMasterRoleRequestError(MasterRoleRequestStruct masterRoleRequestStruct, int n) {
        if (masterRoleRequestStruct.requested) {
            PhoneUtil.setBTBondingError(0, masterRoleRequestStruct.btDeviceAddress, masterRoleRequestStruct.btDeviceName, 1);
            this.target.sendHMIEvent(137);
        }
    }

    @Override
    public HsmState dsiBluetoothResponseConnectService(String string, String string2, int n, int n2, int n3) {
        ASLPhoneData.getInstance().isConnectRequested = false;
        this.target.requestedDeviceServiceType = 1;
        PhoneUtil.sendBluetoothInquiryRunning(this.target, false);
        if (n == 2 || n == 4 || n == 32) {
            ASLPhoneData.getInstance().isAddressbookConnecting = false;
        }
        if (n3 == 2) {
            this.target.triggerObserver(-1393674752, null);
            this.target.send(ServiceManager.mGenericEventFactory.newEvent(this.target.getTargetId(), 5259, -1762773504));
        } else if (n3 == 0) {
            if (Util.isBitSet(256, n)) {
                AbstractASLHsmTarget.writeStringToDatapool(1122, string2);
            } else if (Util.isBitSet(32, n)) {
                AbstractASLHsmTarget.writeStringToDatapool(3602, string2);
            } else if (Util.isBitSet(8192, n) || Util.isBitSet(16384, n)) {
                AbstractASLHsmTarget.writeStringToDatapool(1123, string2);
            }
            if (!Util.isBitSet(2, n) && !Util.isBitSet(4, n)) {
                PhoneUtil.reportDeviceConnected(this.target);
                if (this.target.isTraceEnabled()) {
                    this.target.trace().append("send event BLUETOOTH_DEVICE_CONNECTED from responseConnectService").log();
                }
            }
        } else {
            if (n3 == 13) {
                this.target.limitExceededDeviceAddress = string;
                this.target.limitExceededRole = n2;
                this.target.limitExceededServiceType = n;
                if (n2 == 1 && ASLPhoneData.getInstance().connectedBTDevicesASL.containsKey(0)) {
                    ConnectedDeviceASL connectedDeviceASL = (ConnectedDeviceASL)ASLPhoneData.getInstance().connectedBTDevicesASL.get(0);
                    this.target.dsiBluetooth.requestDisconnectService(connectedDeviceASL.currentlyConnectedMAC, Util.unsetBit(2, ((ConnectedDevice)ASLPhoneData.getInstance().trustedBTDevices.get((Object)connectedDeviceASL.currentlyConnectedMAC)).device.activeServiceTypes));
                    this.target.limitExceededReconnect = true;
                    ASLPhoneData.getInstance().isConnectRequested = true;
                } else if (n2 == 2 && ASLPhoneData.getInstance().connectedBTDevicesASL.containsKey(3)) {
                    ConnectedDeviceASL connectedDeviceASL = (ConnectedDeviceASL)ASLPhoneData.getInstance().connectedBTDevicesASL.get(3);
                    this.target.dsiBluetooth.requestDisconnectService(connectedDeviceASL.currentlyConnectedMAC, ((ConnectedDevice)ASLPhoneData.getInstance().trustedBTDevices.get((Object)connectedDeviceASL.currentlyConnectedMAC)).device.activeServiceTypes);
                    this.target.limitExceededReconnect = true;
                    ASLPhoneData.getInstance().isConnectRequested = true;
                } else {
                    this.target.limitExceededReconnect = false;
                    PhoneUtil.setBTBondingError(n, string, string2, PhoneUtil.convertBTErrorCodesDSI2ASL(n3));
                    this.target.sendHMIEvent(133);
                }
            } else {
                PhoneUtil.setBTBondingError(n, string, string2, PhoneUtil.convertBTErrorCodesDSI2ASL(n3));
                this.target.sendHMIEvent(133);
            }
            this.target.send(ServiceManager.mGenericEventFactory.newEvent(this.target.getTargetId(), 5259, -1762773504));
        }
        this.target.triggerObserver(-1393674752, null);
        return null;
    }

    public void dsiBluetoothResponseDisconnectService(String string, int n, int n2) {
        if (n2 == 0) {
            this.target.sendHMIEvent(181);
            if (Util.isBitSet(256, n)) {
                AbstractASLHsmTarget.writeStringToDatapool(1122, "");
            }
            if (Util.isBitSet(8192, n) || Util.isBitSet(16384, n)) {
                AbstractASLHsmTarget.writeStringToDatapool(1123, "");
            }
            if (Util.isBitSet(32, n)) {
                AbstractASLHsmTarget.writeStringToDatapool(3602, "");
            }
            if (this.target.limitExceededReconnect) {
                ASLPhoneData.getInstance().addressOfOngoingConnectionRequest = this.target.limitExceededDeviceAddress;
                ASLPhoneData.getInstance().requestedService = this.target.limitExceededServiceType;
                this.target.dsiBluetooth.requestConnectService(this.target.limitExceededDeviceAddress, this.target.limitExceededServiceType, this.target.limitExceededRole);
            }
        } else {
            if (this.target.limitExceededReconnect) {
                PhoneUtil.setBTBondingError(n, string, "", PhoneUtil.convertBTErrorCodesDSI2ASL(3));
                this.target.sendHMIEvent(133);
                ASLPhoneData.getInstance().isConnectRequested = false;
            }
            this.target.sendHMIEvent(180);
        }
        this.target.limitExceededDeviceAddress = "";
        this.target.limitExceededRole = -1;
        this.target.limitExceededServiceType = -1;
        this.target.limitExceededReconnect = false;
    }

    public void dsiBluetoothResponsePasskeyResponse(String string, String string2, int n) {
        EventGeneric eventGeneric = ServiceManager.mGenericEventFactory.newEvent(5259, 5258, -1796327936);
        eventGeneric.setString(0, string);
        eventGeneric.setString(1, string2);
        eventGeneric.setInt(2, n);
        this.target.send(eventGeneric);
    }

    public void dsiBluetoothAsyncException(int n, String string, int n2) {
        if (n2 == 1001) {
            this.target.asyncRequestConnectService();
        } else if (n2 == 1009) {
            this.dsiBluetoothResponsePasskeyResponse(this.target.btDeviceAddress, this.target.btDeviceName, 5);
            this.trans(this.target.stateServiceConnect);
        } else if (n2 == 1004) {
            if (this.target.limitExceededReconnect) {
                PhoneUtil.setBTBondingError(this.target.limitExceededServiceType, this.target.limitExceededDeviceAddress, "", PhoneUtil.convertBTErrorCodesDSI2ASL(3));
                this.target.sendHMIEvent(133);
            }
            this.target.sendHMIEvent(180);
            this.target.limitExceededDeviceAddress = "";
            this.target.limitExceededRole = -1;
            this.target.limitExceededServiceType = -1;
            this.target.limitExceededReconnect = false;
        } else {
            PhoneUtil.setBTBondingError(0, this.target.btDeviceAddress, this.target.btDeviceName, 1);
            this.target.sendHMIEvent(133);
            this.target.sendHMIEvent(130);
            this.trans(this.target.stateServiceConnect);
        }
    }
}

