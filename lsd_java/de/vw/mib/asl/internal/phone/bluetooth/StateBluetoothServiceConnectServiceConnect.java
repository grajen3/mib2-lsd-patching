/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.phone.bluetooth;

import de.vw.mib.asl.api.phone.ASLPhoneFactory;
import de.vw.mib.asl.framework.internal.framework.AbstractASLHsmTarget;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.phone.ASLPhoneData;
import de.vw.mib.asl.internal.phone.bluetooth.AbstractHsmBluetoothServiceConnectState;
import de.vw.mib.asl.internal.phone.bluetooth.ConnectedDevice;
import de.vw.mib.asl.internal.phone.bluetooth.ConnectedDeviceASL;
import de.vw.mib.asl.internal.phone.bluetooth.HsmPhoneBluetoothServiceConnect;
import de.vw.mib.asl.internal.phone.selection.phone.transformer.PhoneSelectionPhonePhoneSelectionCollector;
import de.vw.mib.asl.internal.phone.util.PhoneUtil;
import de.vw.mib.collections.ints.IntObjectOptHashMap;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.GenericEvents;
import de.vw.mib.genericevents.hsm.Hsm;
import de.vw.mib.genericevents.hsm.HsmState;
import de.vw.mib.util.Util;
import generated.de.vw.mib.asl.internal.ListManager;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import org.dsi.ifc.bluetooth.RequestIncomingService;
import org.dsi.ifc.bluetooth.TrustedDevice;

public class StateBluetoothServiceConnectServiceConnect
extends AbstractHsmBluetoothServiceConnectState {
    private final HsmPhoneBluetoothServiceConnect target;
    private final RequestIncomingService incomingServiceRequest = null;

    public StateBluetoothServiceConnectServiceConnect(HsmPhoneBluetoothServiceConnect hsmPhoneBluetoothServiceConnect, GenericEvents genericEvents, Hsm hsm, String string, HsmState hsmState) {
        super(hsm, string, hsmState);
        this.target = hsmPhoneBluetoothServiceConnect;
    }

    @Override
    public HsmState handle(EventGeneric eventGeneric) {
        HsmState hsmState = null;
        switch (eventGeneric.getReceiverEventId()) {
            case 1073742712: {
                this.target.warn("ENTER_CONNECT_WAITSTATE handled in StateBluetoothServiceConnectServiceConnect");
                break;
            }
            case 1073742704: {
                if (this.incomingServiceRequest == null) break;
                EventGeneric eventGeneric2 = ServiceManager.mGenericEventFactory.newEvent(5259, 5251, -2014431744);
                eventGeneric2.setBoolean(0, true);
                this.target.send(eventGeneric2);
                this.target.dsiBluetooth.requestAcceptIncomingServiceRequest(this.incomingServiceRequest.btDeviceAddress, this.incomingServiceRequest.btServiceType, true);
                this.target.sendHMIEvent(146);
                break;
            }
            case 1073742715: {
                if (this.incomingServiceRequest == null) break;
                EventGeneric eventGeneric3 = ServiceManager.mGenericEventFactory.newEvent(5259, 5251, -2014431744);
                eventGeneric3.setBoolean(0, true);
                this.target.send(eventGeneric3);
                this.target.dsiBluetooth.requestAcceptIncomingServiceRequest(this.incomingServiceRequest.btDeviceAddress, this.incomingServiceRequest.btServiceType, false);
                break;
            }
            case 1073744659: {
                this.connectSelectedProfile(eventGeneric.getInt(0));
                break;
            }
            case 1073742705: {
                ASLPhoneData.getInstance().selectedDSIService = 2;
                this.connectSelectedProfile(0);
                break;
            }
            case 1073742706: {
                ASLPhoneData.getInstance().selectedDSIService = 8192;
                this.connectSelectedProfile(0);
                break;
            }
            case 1073742711: {
                this.target.disconnectService(ASLPhoneData.getInstance().selectedDeviceMAC, ASLPhoneData.getInstance().selectedDSIService);
                break;
            }
            case 1073742709: {
                ConnectedDeviceASL connectedDeviceASL = (ConnectedDeviceASL)this.target.getConnectedDevicesASLMap().get(0);
                ConnectedDeviceASL connectedDeviceASL2 = (ConnectedDeviceASL)this.target.getConnectedDevicesASLMap().get(3);
                if (connectedDeviceASL != null) {
                    this.target.disconnectService(connectedDeviceASL.currentlyConnectedMAC, connectedDeviceASL.currentlyConnectedService);
                    AbstractASLHsmTarget.writeStringToDatapool(1120, connectedDeviceASL.currentlyConnectedName);
                    break;
                }
                if (connectedDeviceASL2 == null) break;
                this.target.disconnectService(connectedDeviceASL2.currentlyConnectedMAC, connectedDeviceASL2.currentlyConnectedService);
                AbstractASLHsmTarget.writeStringToDatapool(1120, connectedDeviceASL2.currentlyConnectedName);
                break;
            }
            case 1073742702: {
                if (!ASLPhoneData.getInstance().isWaitingForPasskeyResponse) {
                    this.target.abortConnectionByPassKeyReject = false;
                    this.target.dsiBluetooth.abortConnectService(ASLPhoneData.getInstance().addressOfOngoingConnectionRequest);
                } else {
                    this.target.abortConnectionByPassKeyReject = true;
                    EventGeneric eventGeneric4 = ServiceManager.mGenericEventFactory.newEvent(5259, 5258, -1779550720);
                    this.target.send(eventGeneric4);
                }
                this.target.sendHMIEvent(133);
                break;
            }
            case 1073742728: {
                ConnectedDeviceASL connectedDeviceASL = (ConnectedDeviceASL)this.target.getConnectedDevicesASLMap().get(ASLPhoneData.getInstance().lastDeviceConnectedPrimary ? 0 : 3);
                this.target.connectService(4, connectedDeviceASL.currentlyConnectedMAC, connectedDeviceASL.currentlyConnectedName, ASLPhoneData.getInstance().lastDeviceConnectedPrimary ? 1 : 2);
                break;
            }
            case 1073742814: {
                int n = eventGeneric.getInt(0);
                PhoneSelectionPhonePhoneSelectionCollector phoneSelectionPhonePhoneSelectionCollector = (PhoneSelectionPhonePhoneSelectionCollector)ListManager.getGenericASLList(1198).getRowItem(n);
                ConnectedDevice connectedDevice = phoneSelectionPhonePhoneSelectionCollector.connectedDevice;
                if ((phoneSelectionPhonePhoneSelectionCollector.deviceType == 1 || phoneSelectionPhonePhoneSelectionCollector.deviceType == 2) && phoneSelectionPhonePhoneSelectionCollector.simMode != 2) {
                    int n2;
                    String string = Util.isNullOrEmpty(connectedDevice.device.deviceName) ? connectedDevice.device.deviceAddress : connectedDevice.device.deviceName;
                    ASLPhoneData.getInstance().selectedDeviceName = connectedDevice.device.deviceName;
                    ASLPhoneData.getInstance().selectedDeviceMAC = connectedDevice.device.deviceAddress;
                    ASLPhoneData.getInstance().selectedDSIService = n2 = PhoneUtil.getLastConnectedTelephonyService(connectedDevice.device);
                    AbstractASLHsmTarget.writeStringToDatapool(1120, string);
                    PhoneUtil.setConnectionPossibleDPValues(n2);
                    this.target.sendHMIEvent(148);
                    this.trans(this.target.stateWaitForWaitstateEntered);
                    break;
                }
                if (phoneSelectionPhonePhoneSelectionCollector.simMode != 2) break;
                EventGeneric eventGeneric5 = ServiceManager.mGenericEventFactory.newEvent(269090880);
                eventGeneric5.setInt(0, 1);
                this.target.send(eventGeneric5);
                break;
            }
            case 1073743866: {
                int n = eventGeneric.getInt(0);
                ConnectedDevice connectedDevice = (ConnectedDevice)ListManager.getGenericASLList(2713).getRowItem(n);
                String string = Util.isNullOrEmpty(connectedDevice.device.deviceName) ? connectedDevice.device.deviceAddress : connectedDevice.device.deviceName;
                ASLPhoneData.getInstance().selectedDeviceName = connectedDevice.device.deviceName;
                ASLPhoneData.getInstance().selectedDeviceMAC = connectedDevice.device.deviceAddress;
                ASLPhoneData.getInstance().selectedDSIService = 256;
                AbstractASLHsmTarget.writeStringToDatapool(1120, string);
                PhoneUtil.setConnectionPossibleDPValues(256);
                this.target.sendHMIEvent(148);
                this.trans(this.target.stateWaitForWaitstateEntered);
                break;
            }
            case 1073744402: {
                int n = eventGeneric.getInt(0);
                ConnectedDevice connectedDevice = (ConnectedDevice)ListManager.getGenericASLList(3603).getRowItem(n);
                String string = Util.isNullOrEmpty(connectedDevice.device.deviceName) ? connectedDevice.device.deviceAddress : connectedDevice.device.deviceName;
                ASLPhoneData.getInstance().selectedDeviceName = connectedDevice.device.deviceName;
                ASLPhoneData.getInstance().selectedDeviceMAC = connectedDevice.device.deviceAddress;
                ASLPhoneData.getInstance().selectedDSIService = 32;
                AbstractASLHsmTarget.writeStringToDatapool(1120, string);
                PhoneUtil.setConnectionPossibleDPValues(32);
                this.target.sendHMIEvent(148);
                this.trans(this.target.stateWaitForWaitstateEntered);
                break;
            }
            case 3600019: {
                this.target.btDeviceAddress = eventGeneric.getString(0);
                this.target.btDeviceName = eventGeneric.getString(1);
                this.trans(this.target.stateServiceConnectPassKeyFirst);
                break;
            }
            case 1075141864: {
                boolean bl = eventGeneric.getInt(0) == 0;
                int n = bl ? 0 : 3;
                IntObjectOptHashMap intObjectOptHashMap = ASLPhoneData.getInstance().connectedBTDevicesASL;
                if (intObjectOptHashMap.containsKey(n)) {
                    ConnectedDeviceASL connectedDeviceASL = (ConnectedDeviceASL)intObjectOptHashMap.get(n);
                    this.target.dsiBluetooth.requestDisconnectService(connectedDeviceASL.currentlyConnectedMAC, ((ConnectedDevice)ASLPhoneData.getInstance().trustedBTDevices.get((Object)connectedDeviceASL.currentlyConnectedMAC)).device.activeServiceTypes);
                    this.target.limitExceededReconnect = true;
                    break;
                }
                if (bl || !intObjectOptHashMap.containsKey(1)) break;
                ConnectedDeviceASL connectedDeviceASL = (ConnectedDeviceASL)intObjectOptHashMap.get(1);
                this.target.dsiBluetooth.requestDisconnectService(connectedDeviceASL.currentlyConnectedMAC, ((ConnectedDevice)ASLPhoneData.getInstance().trustedBTDevices.get((Object)connectedDeviceASL.currentlyConnectedMAC)).device.activeServiceTypes);
                this.target.limitExceededReconnect = true;
                break;
            }
            default: {
                hsmState = this.myParent;
            }
        }
        return hsmState;
    }

    private void connectSelectedProfile(int n) {
        int n2 = PhoneUtil.getDeviceRole(n, ASLPhoneData.getInstance().selectedDSIService);
        int n3 = ASLPhoneData.getInstance().selectedDSIService;
        AbstractASLHsmTarget.writeBooleanToDatapool(1139, true);
        this.target.requestedDeviceServiceType = n3;
        this.target.requestedDeviceRole = n2;
        this.target.connectService(ASLPhoneData.getInstance().selectedDSIService, ASLPhoneData.getInstance().selectedDeviceMAC, ASLPhoneData.getInstance().selectedDeviceName, n2);
    }

    private void addConnectedDeviceASL(TrustedDevice trustedDevice, int n, int n2) {
        ConnectedDeviceASL connectedDeviceASL = new ConnectedDeviceASL();
        connectedDeviceASL.currentlyConnectedService = n;
        connectedDeviceASL.currentlyConnectedMAC = trustedDevice.deviceAddress;
        connectedDeviceASL.currentlyConnectedName = trustedDevice.deviceName;
        this.target.getConnectedDevicesASLMap().put(n2, connectedDeviceASL);
    }

    private void handleTrustedDevices(TrustedDevice[] trustedDeviceArray) {
        Object[] objectArray;
        boolean bl;
        boolean bl2;
        boolean bl3;
        Object object;
        int n;
        Object object2;
        boolean bl4 = false;
        HashMap hashMap = new HashMap(10);
        int n2 = -1;
        int n3 = -1;
        int n4 = -1;
        int n5 = -1;
        boolean bl5 = false;
        ASLPhoneData.getInstance().trustedBTDevicesAddresses.clear();
        HashMap hashMap2 = (HashMap)this.target.getConnectedDevicesTrusted().clone();
        this.target.getConnectedDevicesTrusted().clear();
        TrustedDevice trustedDevice = null;
        int n6 = 0;
        int n7 = 0;
        int n8 = 0;
        int n9 = 0;
        int n10 = 0;
        if (!Util.isNullOrEmpty(trustedDeviceArray)) {
            object2 = (ConnectedDeviceASL)this.target.getConnectedDevicesASLMap().get(0);
            ConnectedDeviceASL connectedDeviceASL = (ConnectedDeviceASL)this.target.getConnectedDevicesASLMap().get(3);
            for (n = 0; n < trustedDeviceArray.length; ++n) {
                ASLPhoneData.getInstance().trustedBTDevicesAddresses.add(trustedDeviceArray[n].getDeviceAddress());
                TrustedDevice trustedDevice2 = trustedDeviceArray[n];
                if (Util.isBitSet(256, trustedDevice2.getActiveServiceTypes()) && !ASLPhoneFactory.getPhoneApi().getPersistence().isBtaDisclaimerAlreadyShownForMacAddress(trustedDevice2.getDeviceAddress())) {
                    this.target.sendHMIEvent(-394062592);
                    ASLPhoneFactory.getPhoneApi().getPersistence().addAlreadyShownBtaDisclaimerMacAddress(trustedDevice2.getDeviceAddress());
                }
                object = new ConnectedDevice();
                ((ConnectedDevice)object).device = trustedDevice2;
                this.target.getConnectedDevicesTrusted().put(trustedDevice2.deviceAddress, object);
                this.updateConnectedDevices(trustedDevice2, (ConnectedDevice)object);
                bl4 = bl4 || trustedDevice2.activeServiceTypes != 0;
                this.addPhone(hashMap, trustedDevice2);
                if (object2 != null && trustedDevice2.deviceAddress.equals(((ConnectedDeviceASL)object2).currentlyConnectedMAC) && !Util.isNullOrEmpty(trustedDevice2.deviceName)) {
                    ((ConnectedDeviceASL)object2).currentlyConnectedName = trustedDevice2.deviceName;
                }
                if (connectedDeviceASL != null && trustedDevice2.deviceAddress.equals(connectedDeviceASL.currentlyConnectedMAC) && !Util.isNullOrEmpty(trustedDevice2.deviceName)) {
                    connectedDeviceASL.currentlyConnectedName = trustedDevice2.deviceName;
                }
                if (Util.isBitSet(8192, trustedDevice2.activeServiceTypes) && Util.isBitSet(4, trustedDevice2.activeServiceTypes)) {
                    bl5 = true;
                }
                if (trustedDevice2.getDeviceAddress().equalsIgnoreCase(this.target.currentMirrorlinkDevice) && Util.isBitSet(256, trustedDevice2.getActiveServiceTypes())) {
                    this.target.disconnectService(trustedDevice2.getDeviceAddress(), 256);
                }
                if (Util.isBitSet(2, trustedDevice2.activeServiceTypes)) {
                    ServiceManager.aslPropertyManager.valueChangedBoolean(1214, true);
                    if (trustedDevice2.getDeviceRole() == 2) {
                        n3 = n;
                        this.addConnectedDeviceASL(trustedDevice2, 2, 3);
                        if (this.target.isTraceEnabled()) {
                            this.target.trace().append("added TYPE_TELEPHONY_ASSO index: ").append(n3).append(": ").append(trustedDevice2.getDeviceName()).log();
                        }
                    } else if (trustedDevice2.getDeviceRole() == 1) {
                        n2 = n;
                        this.addConnectedDeviceASL(trustedDevice2, 2, 0);
                        if (this.target.isTraceEnabled()) {
                            this.target.trace().append("added TYPE_TELEPHONY_PRIO index: ").append(n2).append(": ").append(trustedDevice2.getDeviceName()).log();
                        }
                    } else {
                        this.target.warn().append("Illegal role for telephony device: ").append(trustedDevice2.getDeviceName()).append(", role: ").append(trustedDevice2.getDeviceRole()).log();
                    }
                    AbstractASLHsmTarget.writeBooleanToDatapool(1135, Util.isBitSet(4, ASLPhoneData.getInstance().supportedProfiles) && Util.isBitSet(4, trustedDevice2.getOfferedServiceTypes()));
                }
                if (Util.isBitSet(4, trustedDevice2.activeServiceTypes)) {
                    AbstractASLHsmTarget.writeBooleanToDatapool(1214, false);
                    if (trustedDevice2.getDeviceRole() == 2) {
                        n3 = n;
                        this.addConnectedDeviceASL(trustedDevice2, 4, 3);
                    } else {
                        n2 = n;
                        this.addConnectedDeviceASL(trustedDevice2, 4, 0);
                    }
                }
                if (Util.isBitSet(256, trustedDevice2.activeServiceTypes)) {
                    n4 = n;
                    this.addConnectedDeviceASL(trustedDevice2, 256, 1);
                }
                if (Util.isBitSet(32, trustedDevice2.activeServiceTypes) && !Util.isAnyBitSet(6, trustedDevice2.activeServiceTypes)) {
                    n5 = n;
                    this.addConnectedDeviceASL(trustedDevice2, 32, 2);
                }
                if (!Util.isNullOrEmpty(ASLPhoneData.getInstance().selectedDeviceMAC) && ASLPhoneData.getInstance().selectedDeviceMAC.equals(((ConnectedDevice)object).device.deviceAddress)) {
                    trustedDevice = trustedDevice2;
                }
                if (n6 == 0 && trustedDevice2.getDeviceRole() != 2) {
                    n6 = PhoneUtil.convertServiceTypeDSI2PhoneASL(trustedDevice2.activeServiceTypes);
                }
                if (n7 == 0 && trustedDevice2.getDeviceRole() == 2) {
                    n7 = PhoneUtil.convertServiceTypeDSI2PhoneASL(trustedDevice2.activeServiceTypes);
                }
                if (n8 == 0) {
                    n8 = PhoneUtil.convertServiceTypeDSI2MediaASL(trustedDevice2.activeServiceTypes);
                }
                if (n9 == 0) {
                    n9 = PhoneUtil.convertServiceTypeDSI2PhoneContactsASL(trustedDevice2.activeServiceTypes);
                }
                if (n10 != 0) continue;
                n10 = PhoneUtil.convertServiceTypeDSI2OtherASL(trustedDevice2.activeServiceTypes);
            }
            if (!(object2 == null || n2 != -1 && ((ConnectedDeviceASL)object2).currentlyConnectedMAC.equals(trustedDeviceArray[n2].getDeviceAddress()))) {
                if (this.target.isTraceEnabled()) {
                    this.target.trace().append("Sending ASL_PHONE_CLEAR_PRESETS phonePrioConnectedIndex: ").append(n2).append(", trusted: ").append(n2 == -1 ? "N/A" : trustedDeviceArray[n2].getDeviceAddress()).append(", currently connected: ").append(((ConnectedDeviceASL)object2).currentlyConnectedMAC).log();
                }
                this.target.send(ServiceManager.mGenericEventFactory.newEvent(-2098317824));
            }
        }
        object2 = ServiceManager.mGenericEventFactory.newEvent(-1712441856);
        ((EventGeneric)object2).setBoolean(0, bl5);
        this.target.send((EventGeneric)object2);
        AbstractASLHsmTarget.writeIntegerToDatapool(1118, n6);
        AbstractASLHsmTarget.writeIntegerToDatapool(1115, n8);
        AbstractASLHsmTarget.writeIntegerToDatapool(3978, n9);
        AbstractASLHsmTarget.writeIntegerToDatapool(1116, n10);
        if (!Util.isNullOrEmpty(trustedDeviceArray) && ASLPhoneData.getInstance().isClampSOn) {
            for (int i2 = 0; i2 < trustedDeviceArray.length; ++i2) {
                ConnectedDevice connectedDevice;
                if (hashMap2 == null) continue;
                if (!hashMap2.containsKey(trustedDeviceArray[i2].deviceAddress)) {
                    this.target.sendHMIEvent(138);
                }
                if ((connectedDevice = (ConnectedDevice)hashMap2.get(trustedDeviceArray[i2].getDeviceAddress())) == null) continue;
                if (trustedDeviceArray[i2].getActiveServiceTypes() < connectedDevice.device.getActiveServiceTypes()) {
                    int n11 = connectedDevice.device.getActiveServiceTypes() - trustedDeviceArray[i2].getActiveServiceTypes();
                    if (!(ASLPhoneData.getInstance().isDisconnectRequested || ASLPhoneData.getInstance().isBTFactoryResetRequested || ASLPhoneData.getInstance().isBTSwitchOffRequested || !Util.isBitSet(2, n11) && !Util.isBitSet(4, n11) || this.target.requestedDeviceAddress != trustedDeviceArray[i2].getDeviceAddress())) {
                        this.target.sendHMIEvent(133);
                    }
                }
                if (trustedDeviceArray[i2].getActiveServiceTypes() <= connectedDevice.device.getActiveServiceTypes() || !Util.isBitSet(ASLPhoneData.getInstance().requestedService, trustedDeviceArray[i2].getActiveServiceTypes()) || Util.isBitSet(2, trustedDeviceArray[i2].getActiveServiceTypes()) && ASLPhoneData.getInstance().requestedService == 2 || Util.isBitSet(4, trustedDeviceArray[i2].getActiveServiceTypes()) && ASLPhoneData.getInstance().requestedService == 4) continue;
                PhoneUtil.reportDeviceConnected(this.target);
                this.target.trace("send event BLUETOOTH_DEVICE_CONNECTED from trustedDevices");
            }
        }
        boolean bl6 = bl3 = n2 != -1;
        if (bl3) {
            ASLPhoneData.getInstance().btPhoneConnected = true;
        } else {
            ASLPhoneData.getInstance().btPhoneConnected = false;
            if (this.target.getConnectedDevicesASLMap().remove(0) != null) {
                this.target.trace("removed TYPE_TELEPHONY_PRIO");
            }
        }
        int n12 = n = n3 != -1 ? 1 : 0;
        if (n == 0 && this.target.getConnectedDevicesASLMap().remove(3) != null) {
            this.target.trace("removed TYPE_TELEPHONY_ASSO");
        }
        boolean bl7 = bl2 = n4 != -1;
        if (bl2) {
            AbstractASLHsmTarget.writeStringToDatapool(1122, trustedDeviceArray[n4].deviceName);
        } else {
            this.target.getConnectedDevicesASLMap().remove(1);
            AbstractASLHsmTarget.writeIntegerToDatapool(1115, 0);
            AbstractASLHsmTarget.writeStringToDatapool(1122, "");
        }
        object = ServiceManager.mGenericEventFactory.newEvent();
        ((EventGeneric)object).setBoolean(0, bl3 || n != 0 || bl2);
        this.target.triggerObserver(-1544669696, (EventGeneric)object);
        boolean bl8 = bl = n5 != -1;
        if (bl) {
            AbstractASLHsmTarget.writeStringToDatapool(3602, trustedDeviceArray[n5].deviceName);
            objectArray = ServiceManager.mGenericEventFactory.newEvent();
            objectArray.setString(0, trustedDeviceArray[n5].getDeviceAddress());
            this.target.triggerObserver(-1427229184, (EventGeneric)objectArray);
        } else {
            this.target.getConnectedDevicesASLMap().remove(2);
            AbstractASLHsmTarget.writeStringToDatapool(3602, "");
            objectArray = ServiceManager.mGenericEventFactory.newEvent();
            objectArray.setString(0, "");
            this.target.triggerObserver(-1427229184, (EventGeneric)objectArray);
        }
        AbstractASLHsmTarget.writeBooleanToDatapool(1212, bl3);
        AbstractASLHsmTarget.writeBooleanToDatapool(1243, bl3);
        ASLPhoneData.getInstance().connectedBTDevicesASL = this.target.getConnectedDevicesASLMap();
        ASLPhoneData.getInstance().trustedBTDevices = this.target.getConnectedDevicesTrusted();
        ASLPhoneData.getInstance().adrdlConnected = bl;
        if (trustedDevice != null) {
            ListManager.getGenericASLList(1141).updateList(PhoneUtil.getProfilesFromServiceList(trustedDevice.offeredServiceTypes, trustedDevice.deviceAddress, ASLPhoneData.getInstance().deviceTypePairedDevicesFilter));
        }
        objectArray = new ConnectedDevice[trustedDeviceArray.length];
        Collections.sort(ASLPhoneData.getInstance().trustedBTDevicesAddresses);
        Iterator iterator = ASLPhoneData.getInstance().trustedBTDevicesAddresses.iterator();
        int n13 = 0;
        while (iterator.hasNext()) {
            objectArray[n13] = (ConnectedDevice)this.target.getConnectedDevicesTrusted().get(iterator.next());
            ++n13;
        }
        ASLPhoneData.getInstance().isDisconnectRequested = false;
        PhoneUtil.refreshPhoneSelectionList();
        this.setMediaSelectionList((ConnectedDevice[])objectArray);
        this.setPhonebookSelectionList((ConnectedDevice[])objectArray);
        ListManager.getGenericASLList(1204).updateList(objectArray);
        AbstractASLHsmTarget.writeBooleanToDatapool(1132, bl4);
        AbstractASLHsmTarget.writeBooleanToDatapool(1203, !Util.isNullOrEmpty(trustedDeviceArray));
    }

    private void setMediaSelectionList(ConnectedDevice[] connectedDeviceArray) {
        Object object;
        Iterator iterator = ASLPhoneData.getInstance().trustedBTDevices.values().iterator();
        String string = "";
        while (iterator.hasNext()) {
            object = (ConnectedDevice)iterator.next();
            if (!PhoneUtil.contains(((ConnectedDevice)object).connectedServices, 0x800000) && !PhoneUtil.contains(((ConnectedDevice)object).connectedServices, 256)) continue;
            string = ((ConnectedDevice)object).device.deviceAddress;
        }
        object = new ArrayList();
        for (int i2 = 0; i2 < connectedDeviceArray.length; ++i2) {
            if (!PhoneUtil.isMediaDeviceProfile(connectedDeviceArray[i2].device.getOfferedServiceTypes()) && !connectedDeviceArray[i2].device.deviceAddress.equals(string)) continue;
            ((ArrayList)object).add(connectedDeviceArray[i2]);
        }
        ListManager.getGenericASLList(2713).updateList(((ArrayList)object).toArray(new ConnectedDevice[((ArrayList)object).size()]));
    }

    private void setPhonebookSelectionList(ConnectedDevice[] connectedDeviceArray) {
        Object object;
        Iterator iterator = ASLPhoneData.getInstance().trustedBTDevices.values().iterator();
        String string = "";
        while (iterator.hasNext()) {
            object = (ConnectedDevice)iterator.next();
            if (!PhoneUtil.contains(((ConnectedDevice)object).connectedServices, 32)) continue;
            string = ((ConnectedDevice)object).device.getDeviceAddress();
        }
        object = new ArrayList();
        for (int i2 = 0; i2 < connectedDeviceArray.length; ++i2) {
            if (!PhoneUtil.isPhonebookProfile(connectedDeviceArray[i2].device.getOfferedServiceTypes()) && !connectedDeviceArray[i2].device.deviceAddress.equals(string) || PhoneUtil.isPhoneProfile(connectedDeviceArray[i2].device.getActiveServiceTypes())) continue;
            ((ArrayList)object).add(connectedDeviceArray[i2]);
        }
        ListManager.getGenericASLList(3603).updateList(((ArrayList)object).toArray(new ConnectedDevice[((ArrayList)object).size()]));
    }

    private void addPhone(HashMap hashMap, TrustedDevice trustedDevice) {
        if (PhoneUtil.isPhoneProfile(trustedDevice.offeredServiceTypes)) {
            Iterator iterator = this.target.getConnectedDevicesTrusted().values().iterator();
            boolean bl = false;
            while (iterator.hasNext()) {
                ConnectedDevice connectedDevice = (ConnectedDevice)iterator.next();
                if (!connectedDevice.device.deviceAddress.equals(trustedDevice.deviceAddress)) continue;
                hashMap.put(connectedDevice.device.deviceAddress, connectedDevice);
            }
        }
    }

    private void updateConnectedDevices(TrustedDevice trustedDevice, ConnectedDevice connectedDevice) {
        int n;
        for (n = 1; n <= trustedDevice.activeServiceTypes && n > 0; n <<= 1) {
            if (!Util.isBitSet(n, trustedDevice.activeServiceTypes)) continue;
            connectedDevice.connectedServices[connectedDevice.connectedServiceCount++] = n;
        }
        for (n = 1; n <= trustedDevice.offeredServiceTypes && n > 0; n <<= 1) {
            if (!Util.isBitSet(n, trustedDevice.offeredServiceTypes)) continue;
            ++connectedDevice.availableServiceCount;
        }
    }

    public void dsiBluetoothUpdateTrustedDevices(TrustedDevice[] trustedDeviceArray, int n) {
        this.handleTrustedDevices(trustedDeviceArray);
    }

    public void dsiBluetoothResponseAcceptIncomingServiceRequest(int n) {
        if (n != 0) {
            PhoneUtil.setBTBondingError(this.incomingServiceRequest.btServiceType, this.incomingServiceRequest.btDeviceAddress, this.incomingServiceRequest.btDeviceName, PhoneUtil.convertBTErrorCodesDSI2ASL(n));
            this.target.sendHMIEvent(133);
        }
    }

    @Override
    public HsmState dsiBluetoothResponseConnectService(String string, String string2, int n, int n2, int n3) {
        if (n3 != 2 && n3 != 0) {
            PhoneUtil.setBTBondingError(n, string, string2, PhoneUtil.convertBTErrorCodesDSI2ASL(n3));
            EventGeneric eventGeneric = ServiceManager.mGenericEventFactory.newEvent(5259, 5251, -2014431744);
            eventGeneric.setBoolean(0, false);
            this.target.send(eventGeneric);
        } else if (n3 != 0 || n != 2 && n != 4 || n2 != 2) {
            // empty if block
        }
        ASLPhoneData.getInstance().addressOfOngoingConnectionRequest = "";
        return this.myParent;
    }
}

