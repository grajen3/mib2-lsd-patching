/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.phone.bluetooth;

import de.vw.mib.asl.framework.internal.framework.AbstractASLHsmTarget;
import de.vw.mib.asl.internal.phone.ASLPhoneData;
import de.vw.mib.asl.internal.phone.bluetooth.ConnectedDeviceASL;
import de.vw.mib.asl.internal.phone.bluetooth.HsmPhoneBluetoothInquiry;
import de.vw.mib.asl.internal.phone.bluetooth.HsmPhoneBluetoothServiceConnect;
import de.vw.mib.asl.internal.phone.util.PhoneUtil;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.GenericEvents;
import de.vw.mib.genericevents.hsm.AbstractHsmState;
import de.vw.mib.genericevents.hsm.Hsm;
import de.vw.mib.genericevents.hsm.HsmState;
import de.vw.mib.util.Util;
import generated.de.vw.mib.asl.internal.ListManager;
import generated.de.vw.mib.asl.internal.phone.bluetooth.transformer.PhoneBluetoothSelectedbondingDeviceCollector;
import org.dsi.ifc.bluetooth.DiscoveredDevice;

public class StateBluetoothInquiryInit
extends AbstractHsmState {
    private final HsmPhoneBluetoothInquiry target;
    private int bondingScreenCount = 0;
    private boolean sendSuspend = false;

    public StateBluetoothInquiryInit(HsmPhoneBluetoothInquiry hsmPhoneBluetoothInquiry, GenericEvents genericEvents, Hsm hsm, String string, HsmState hsmState) {
        super(hsm, string, hsmState);
        this.target = hsmPhoneBluetoothInquiry;
    }

    @Override
    public HsmState handle(EventGeneric eventGeneric) {
        HsmState hsmState = null;
        switch (eventGeneric.getReceiverEventId()) {
            case 3: {
                this.target.init();
                this.target.setNotification();
                this.trans(this.target.stateInquiry);
                break;
            }
            case 1073742712: {
                this.target.warn("ENTER_CONNECT_WAITSTATE handled in StateBluetoothInquiryInit");
                break;
            }
            case 100003: {
                if (!this.sendSuspend) break;
                this.target.dsiBluetooth.requestReconnectSuspend(true);
                this.sendSuspend = false;
                break;
            }
            case 100002: {
                if (this.bondingScreenCount != 0) break;
                this.target.dsiBluetooth.requestReconnectSuspend(false);
                break;
            }
            case 1073742722: {
                --this.bondingScreenCount;
                if (this.bondingScreenCount < 0) {
                    this.target.warn("setBondingScreenLeft called more often than Entered! Resetting...");
                    this.bondingScreenCount = 0;
                }
                this.target.retriggerOrStartTimer(-1568276224, (long)0, false);
                break;
            }
            case 1073743791: {
                if (this.bondingScreenCount == 0) {
                    this.sendSuspend = true;
                }
                ++this.bondingScreenCount;
                this.target.retriggerOrStartTimer(-1551499008, (long)0, false);
                break;
            }
            case 100001: {
                PhoneUtil.sendBluetoothInquiryRunning(this.target, false);
                break;
            }
            default: {
                hsmState = this.myParent;
            }
        }
        return hsmState;
    }

    public void dsiBluetoothResponseInquiry(int n, int n2) {
        if ((n2 == 0 || n2 == 2) && this.target.deviceFound) {
            this.target.sendHMIEvent(150);
        } else {
            this.target.sendHMIEvent(149);
        }
        AbstractASLHsmTarget.writeBooleanToDatapool(1138, false);
        this.target.isSearching = false;
        PhoneUtil.sendBluetoothInquiryRunning(this.target, false);
    }

    public void dsiBluetoothResponseGetServices(String string, String string2, int n, int n2) {
        ASLPhoneData.getInstance().addressOfOngoingConnectionRequest = "";
        if (this.target.getTimerServer().isTimerActive(this.target.getTargetId(), -1585053440)) {
            PhoneUtil.sendBluetoothInquiryRunning(this.target, false);
        }
        this.target.retriggerOrStartTimer(-1585053440, (long)0, false);
        this.target.trace("ResponseGetServices: Start timer for BT_INQUIRY_RUNNING(false)");
        if (n2 == 0 && (PhoneUtil.isMediaProfile(n) || PhoneUtil.isPhoneProfile(n) || PhoneUtil.isOtherProfile(n))) {
            Object[] objectArray = (DiscoveredDevice[])ListManager.getGenericASLList(1142).getDSIObjects();
            objectArray[this.target.currentlySelectedDeviceIndex].serviceTypes = n;
            ListManager.getGenericASLList(1142).updateList(objectArray);
            Object[] objectArray2 = PhoneUtil.getProfilesFromServiceList(n, string, ASLPhoneData.getInstance().deviceTypeSearchFilter);
            ListManager.getGenericASLList(1141).updateList(objectArray2);
            PhoneBluetoothSelectedbondingDeviceCollector phoneBluetoothSelectedbondingDeviceCollector = new PhoneBluetoothSelectedbondingDeviceCollector();
            phoneBluetoothSelectedbondingDeviceCollector.phone_bluetooth_selected_device_support_hfp = Util.isBitSet(2, n);
            phoneBluetoothSelectedbondingDeviceCollector.phone_bluetooth_selected_device_support_map1 = Util.isBitSet(8192, n);
            phoneBluetoothSelectedbondingDeviceCollector.phone_bluetooth_selected_device_support_map2 = Util.isBitSet(16384, n);
            phoneBluetoothSelectedbondingDeviceCollector.phone_bluetooth_selected_device_support_simap = Util.isBitSet(4, n);
            ConnectedDeviceASL connectedDeviceASL = (ConnectedDeviceASL)HsmPhoneBluetoothServiceConnect.connectedDevicesASLMap.get(0);
            ConnectedDeviceASL connectedDeviceASL2 = (ConnectedDeviceASL)HsmPhoneBluetoothServiceConnect.connectedDevicesASLMap.get(3);
            phoneBluetoothSelectedbondingDeviceCollector.phone_bluetooth_selected_device_simap_temporary_available = PhoneUtil.isSimapTemporarilyAvailable();
            phoneBluetoothSelectedbondingDeviceCollector.phone_bluetooth_selected_device_connected_simap = connectedDeviceASL != null ? connectedDeviceASL.currentlyConnectedMAC == ASLPhoneData.getInstance().selectedDeviceMAC && connectedDeviceASL.currentlyConnectedService == 4 : (connectedDeviceASL2 != null ? connectedDeviceASL2.currentlyConnectedMAC == ASLPhoneData.getInstance().selectedDeviceMAC && connectedDeviceASL2.currentlyConnectedService == 4 : false);
            ListManager.getGenericASLList(1143).updateList(new PhoneBluetoothSelectedbondingDeviceCollector[]{phoneBluetoothSelectedbondingDeviceCollector});
            PhoneUtil.setBTBondingError(0, string, string2, 0);
            this.target.sendHMIEvent(155);
        } else if (n2 != 0) {
            PhoneUtil.setBTBondingError(n, string, string2, 1);
            this.target.sendHMIEvent(154);
        } else {
            PhoneUtil.setBTBondingError(n, string, string2, 5);
            this.target.sendHMIEvent(154);
        }
    }

    public void dsiBluetoothAsyncException(int n, String string, int n2) {
        switch (n2) {
            case 1006: {
                PhoneUtil.sendBluetoothInquiryRunning(this.target, false);
                break;
            }
            case 1005: {
                PhoneUtil.sendBluetoothInquiryRunning(this.target, false);
                ASLPhoneData.getInstance().addressOfOngoingConnectionRequest = "";
                break;
            }
        }
    }
}

