/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.phone.bluetooth;

import de.vw.mib.asl.framework.internal.framework.AbstractASLHsmTarget;
import de.vw.mib.asl.internal.phone.ASLPhoneData;
import de.vw.mib.asl.internal.phone.bluetooth.ConnectedDeviceASL;
import de.vw.mib.asl.internal.phone.bluetooth.HsmPhoneBluetoothInquiry;
import de.vw.mib.asl.internal.phone.bluetooth.HsmPhoneBluetoothServiceConnect;
import de.vw.mib.asl.internal.phone.bluetooth.transformer.PhoneBluetoothBondingProfileSelectionCollector;
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

public class StateBluetoothInquiryInquiry
extends AbstractHsmState {
    private static final int INQUIRY_MAX_RESPONSES;
    private static final int INQUIRY_MULTIPLIER;
    private final HsmPhoneBluetoothInquiry target;
    private boolean enterWaitStatePending;
    private boolean pendingSelectBondingProfile = false;
    private String requestServiceDiscoveryDeviceAddress = "";

    public StateBluetoothInquiryInquiry(HsmPhoneBluetoothInquiry hsmPhoneBluetoothInquiry, GenericEvents genericEvents, Hsm hsm, String string, HsmState hsmState) {
        super(hsm, string, hsmState);
        this.target = hsmPhoneBluetoothInquiry;
    }

    @Override
    public HsmState handle(EventGeneric eventGeneric) {
        HsmState hsmState = null;
        block0 : switch (eventGeneric.getReceiverEventId()) {
            case 3: {
                if (this.pendingSelectBondingProfile) {
                    if (this.enterWaitStatePending) {
                        this.trans(this.target.stateWaitForWaitstateEntered);
                    } else {
                        this.target.sendHMIEvent(148);
                    }
                }
                if (!Util.isNullOrEmpty(this.requestServiceDiscoveryDeviceAddress)) {
                    this.requestGetServices(this.requestServiceDiscoveryDeviceAddress);
                    PhoneUtil.sendBluetoothInquiryRunning(this.target, true);
                }
                this.enterWaitStatePending = false;
                this.pendingSelectBondingProfile = false;
                this.requestServiceDiscoveryDeviceAddress = "";
                break;
            }
            case 1073742721: {
                this.target.currentlySelectedDeviceIndex = eventGeneric.getInt(0);
                DiscoveredDevice discoveredDevice = (DiscoveredDevice)ListManager.getGenericASLList(1142).getRowItem(this.target.currentlySelectedDeviceIndex);
                Object[] objectArray = PhoneUtil.getProfilesFromServiceList(discoveredDevice.serviceTypes, discoveredDevice.deviceAddress, ASLPhoneData.getInstance().deviceTypeSearchFilter);
                ASLPhoneData.getInstance().selectedDeviceMAC = discoveredDevice.deviceAddress;
                ASLPhoneData.getInstance().selectedDeviceName = discoveredDevice.deviceName;
                String string = Util.isNullOrEmpty(discoveredDevice.deviceName) ? discoveredDevice.deviceAddress : discoveredDevice.deviceName;
                PhoneBluetoothSelectedbondingDeviceCollector phoneBluetoothSelectedbondingDeviceCollector = new PhoneBluetoothSelectedbondingDeviceCollector();
                phoneBluetoothSelectedbondingDeviceCollector.phone_bluetooth_selected_device_support_hfp = Util.isBitSet(2, discoveredDevice.getServiceTypes());
                phoneBluetoothSelectedbondingDeviceCollector.phone_bluetooth_selected_device_support_map1 = Util.isBitSet(8192, discoveredDevice.getServiceTypes());
                phoneBluetoothSelectedbondingDeviceCollector.phone_bluetooth_selected_device_support_map2 = Util.isBitSet(16384, discoveredDevice.getServiceTypes());
                phoneBluetoothSelectedbondingDeviceCollector.phone_bluetooth_selected_device_support_simap = Util.isBitSet(4, discoveredDevice.getServiceTypes());
                ConnectedDeviceASL connectedDeviceASL = (ConnectedDeviceASL)HsmPhoneBluetoothServiceConnect.connectedDevicesASLMap.get(0);
                ConnectedDeviceASL connectedDeviceASL2 = (ConnectedDeviceASL)HsmPhoneBluetoothServiceConnect.connectedDevicesASLMap.get(3);
                phoneBluetoothSelectedbondingDeviceCollector.phone_bluetooth_selected_device_connected_simap = connectedDeviceASL != null ? connectedDeviceASL.currentlyConnectedMAC == ASLPhoneData.getInstance().selectedDeviceMAC && connectedDeviceASL.currentlyConnectedService == 4 : (connectedDeviceASL2 != null ? connectedDeviceASL2.currentlyConnectedMAC == ASLPhoneData.getInstance().selectedDeviceMAC && connectedDeviceASL2.currentlyConnectedService == 4 : false);
                phoneBluetoothSelectedbondingDeviceCollector.phone_bluetooth_selected_device_simap_temporary_available = PhoneUtil.isSimapTemporarilyAvailable();
                ListManager.getGenericASLList(1143).updateList(new PhoneBluetoothSelectedbondingDeviceCollector[]{phoneBluetoothSelectedbondingDeviceCollector});
                AbstractASLHsmTarget.writeStringToDatapool(1120, string);
                ListManager.getGenericASLList(1141).updateList(objectArray);
                if (objectArray.length == 1) {
                    int n = ((PhoneBluetoothBondingProfileSelectionCollector)objectArray[0]).profileDSI;
                    PhoneUtil.setConnectionPossibleDPValues(n);
                    ASLPhoneData.getInstance().selectedDSIService = n;
                }
                AbstractASLHsmTarget.writeBooleanToDatapool(243537152, true);
                break;
            }
            case 1073742720: {
                PhoneBluetoothBondingProfileSelectionCollector[] phoneBluetoothBondingProfileSelectionCollectorArray = (PhoneBluetoothBondingProfileSelectionCollector[])ListManager.getGenericASLList(1141).getDSIObjects();
                for (int i2 = phoneBluetoothBondingProfileSelectionCollectorArray.length - 1; i2 >= 0; --i2) {
                    if (phoneBluetoothBondingProfileSelectionCollectorArray[i2].profileDSI != 4) continue;
                    this.selectBondingProfile(i2);
                    break block0;
                }
                break;
            }
            case 1073742719: {
                int n = eventGeneric.getInt(0);
                this.selectBondingProfile(n);
                break;
            }
            case 1073742712: {
                this.enterWaitStatePending = false;
                if (this.target.isTraceEnabled()) {
                    this.target.trace("ENTER_CONNECT_WAITSTATE handled in StateBluetoothInquiryInquiry");
                }
                this.target.sendHMIEvent(148);
                break;
            }
            case 1073744401: {
                int n;
                ASLPhoneData.getInstance().deviceTypeSearchFilter = n = eventGeneric.getInt(0);
                this.startSearchingDevices();
                break;
            }
            case 1073742718: {
                this.startSearchingDevices();
                break;
            }
            case 1073742703: {
                if (this.target.isSearching) {
                    this.target.dsiBluetooth.abortInquiry();
                    this.trans(this.target.stateAbortPending);
                }
                this.target.isSearching = false;
                AbstractASLHsmTarget.writeBooleanToDatapool(1138, this.target.isSearching);
                break;
            }
            case 1073742716: {
                this.requestGetServices(ASLPhoneData.getInstance().selectedDeviceMAC);
                PhoneUtil.sendBluetoothInquiryRunning(this.target, true);
                break;
            }
            case 1073742717: {
                int n = eventGeneric.getInt(0);
                DiscoveredDevice discoveredDevice = (DiscoveredDevice)ListManager.getGenericASLList(1142).getRowItem(n);
                if (!this.target.isStateActive(this.target.stateAbortPending)) {
                    this.requestGetServices(discoveredDevice.deviceAddress);
                    PhoneUtil.sendBluetoothInquiryRunning(this.target, true);
                    break;
                }
                this.requestServiceDiscoveryDeviceAddress = discoveredDevice.deviceAddress;
                break;
            }
            default: {
                hsmState = this.myParent;
            }
        }
        return hsmState;
    }

    private void requestGetServices(String string) {
        ASLPhoneData.getInstance().addressOfOngoingConnectionRequest = string;
        this.target.dsiBluetooth.requestGetServices(string);
    }

    private void selectBondingProfile(int n) {
        PhoneBluetoothBondingProfileSelectionCollector phoneBluetoothBondingProfileSelectionCollector = (PhoneBluetoothBondingProfileSelectionCollector)ListManager.getGenericASLList(1141).getRowItem(n);
        ASLPhoneData.getInstance().selectedDSIService = phoneBluetoothBondingProfileSelectionCollector.profileDSI;
        PhoneUtil.setConnectionPossibleDPValues(phoneBluetoothBondingProfileSelectionCollector.profileDSI);
        boolean bl = this.enterWaitStatePending = !phoneBluetoothBondingProfileSelectionCollector.connected && Util.isBitSet(ASLPhoneData.getInstance().selectedDSIService, ASLPhoneData.getInstance().supportedProfiles);
        if (!this.target.isStateActive(this.target.stateAbortPending)) {
            if (this.enterWaitStatePending) {
                this.trans(this.target.stateWaitForWaitstateEntered);
            } else {
                this.target.sendHMIEvent(148);
            }
        } else {
            this.pendingSelectBondingProfile = true;
        }
    }

    private void startSearchingDevices() {
        this.target.deviceFound = false;
        PhoneUtil.resetDiscoveredDevices();
        ListManager.getGenericASLList(1142).updateList(new DiscoveredDevice[0]);
        this.target.dsiBluetooth.requestInquiry(48, 0, 2);
        PhoneUtil.sendBluetoothInquiryRunning(this.target, true);
        AbstractASLHsmTarget.writeBooleanToDatapool(1138, true);
        this.target.isSearching = true;
    }

    public void dsiBluetoothUpdateDiscoveredDevices(DiscoveredDevice discoveredDevice, int n) {
        Object[] objectArray = PhoneUtil.updateDiscoveredDevices(discoveredDevice);
        if (objectArray.length > 0) {
            ListManager.getGenericASLList(1142).updateList(objectArray);
            this.target.sendHMIEvent(151);
            this.target.deviceFound = true;
        }
    }
}

