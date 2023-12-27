/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.smartphoneintegration.target;

import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.smartphoneintegration.common.DeviceASLExtended;
import de.vw.mib.asl.internal.smartphoneintegration.common.FeatureSupport;
import de.vw.mib.asl.internal.smartphoneintegration.common.SingleFeatureSupport;
import de.vw.mib.asl.internal.smartphoneintegration.common.SmartPhoneIntegrationGlobalProperyAccessor;
import de.vw.mib.asl.internal.smartphoneintegration.common.SmartPhoneIntegrationHelper;
import de.vw.mib.asl.internal.smartphoneintegration.common.TimerUtil;
import de.vw.mib.asl.internal.smartphoneintegration.target.ASLHandler;
import de.vw.mib.asl.internal.smartphoneintegration.target.HsmTarget;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.hmi.utils.Preconditions;
import de.vw.mib.log4mib.LogMessage;
import org.dsi.ifc.smartphoneintegration.Device;

public class DSIHandler {
    private final String classname;
    private final HsmTarget target;

    public DSIHandler(HsmTarget hsmTarget) {
        this.classname = "SmartPhoneIntegration.DSIHandler";
        Preconditions.checkNotNull(hsmTarget, "HsmTarget must not be null!");
        this.target = hsmTarget;
    }

    private SmartPhoneIntegrationGlobalProperyAccessor getGlobalProperties() {
        return SmartPhoneIntegrationGlobalProperyAccessor.getInstance();
    }

    public void updateHmiDeviceList(Device[] deviceArray) {
        if (deviceArray != null) {
            this.getGlobalProperties().getHmiDevicelist().clear();
            int n = 2;
            if (deviceArray.length < n) {
                n = deviceArray.length;
            }
            for (int i2 = 0; i2 < n; ++i2) {
                this.getGlobalProperties().getHmiDevicelist().add(deviceArray[i2]);
            }
            this.getGlobalProperties().getModelDevicelist().updateDeviceList();
            if (this.target.isTraceEnabled()) {
                LogMessage logMessage = this.target.trace();
                logMessage.append("SmartPhoneIntegration.DSIHandler").append(".updateHmiDevicelist(").append(this.getGlobalProperties().getHmiDevicelist().toString()).log();
            }
        }
    }

    public int updateCurrentConnectedDevice(int n) {
        if (this.getGlobalProperties().getDsiDevicelistASLExtended().length == 0) {
            if (this.target.isTraceEnabled()) {
                this.target.trace().append("######################## WARNING #######################").log();
                this.target.trace().append("SmartPhoneIntegration.DSIHandler").append(".updateCurrentConnectedDevice list getDsiDevice() length 0 current conn device could not be set --> use preConnecteddevice as currentconnecteddevice").log();
                this.target.trace().append("######################## WARNING #######################").log();
            }
            this.getGlobalProperties().setCurrentConnectedDeviceASLExtended(new DeviceASLExtended(this.getGlobalProperties().getPreConnectedDevice()));
        }
        boolean bl = false;
        for (int i2 = 0; i2 < this.getGlobalProperties().getDsiDevicelistASLExtended().length; ++i2) {
            if (this.getGlobalProperties().getDsiDevicelistASLExtended()[i2].getDsiDevice() == null) {
                if (this.target.isTraceEnabled()) {
                    this.target.trace().append("SmartPhoneIntegration.DSIHandler").append(".updateCurrentConnectedDevice list getDsiDevice() is null").log();
                }
            } else if (this.target.isTraceEnabled()) {
                this.target.trace().append("SmartPhoneIntegration.DSIHandler").append(".updateCurrentConnectedDevice list getDsiDevice() is NOT null: ").append(this.getGlobalProperties().getDsiDevicelistASLExtended()[i2].getDeviceID()).log();
            }
            if (this.getGlobalProperties().getDsiDevicelistASLExtended()[i2].getDeviceID() == n) {
                this.getGlobalProperties().setCurrentConnectedDeviceASLExtended(this.getGlobalProperties().getDsiDevicelistASLExtended()[i2]);
                bl = true;
                if (!this.target.isTraceEnabled()) continue;
                this.target.trace().append("SmartPhoneIntegration.DSIHandler").append(".updateCurrentConnectedDevice.setconnecteddevice(").append(n).append(", ").append(this.getGlobalProperties().getDsiDevicelistASLExtended()[i2]).append(" )").log();
                continue;
            }
            if (!this.target.isTraceEnabled()) continue;
            this.target.trace().append("SmartPhoneIntegration.DSIHandler").append(".updateCurrentConnectedDevice.setconnecteddevice(failed").append(" )").log();
        }
        if (!bl) {
            if (this.target.isTraceEnabled()) {
                this.target.trace().append("SmartPhoneIntegration.DSIHandler").append(".updateCurrentConnectedDevice DEV NOT FOUND IN DSI LIST --> use preConnecteddevice as currentconnecteddevice").append(" )").log();
            }
            this.getGlobalProperties().setCurrentConnectedDeviceASLExtended(new DeviceASLExtended(this.getGlobalProperties().getPreConnectedDevice()));
        }
        ServiceManager.aslPropertyManager.valueChangedInteger(1097280512, this.getGlobalProperties().getListIndex(this.getGlobalProperties().getCurrentConnectedDevice()));
        ServiceManager.aslPropertyManager.valueChangedInteger(1114057728, this.getGlobalProperties().getCurrentConnectedDevice().getLastConnectionMethod());
        this.getGlobalProperties().updateCurrentConnectionMethodForAppAdapter();
        EventGeneric eventGeneric = ServiceManager.mGenericEventFactory.newEvent(1024744704);
        eventGeneric.setString(0, this.getGlobalProperties().getCurrentConnectedDevice().getDeviceName());
        ServiceManager.eventMain.getEventDispatcher().sendSafe(eventGeneric);
        return 0;
    }

    /*
     * Enabled aggressive block sorting
     */
    public void handleDsiApiUpdateDiscoveredDevices(Device[] deviceArray) {
        block28: {
            block24: {
                block26: {
                    block30: {
                        Device device;
                        block31: {
                            DeviceASLExtended deviceASLExtended;
                            block32: {
                                block33: {
                                    SingleFeatureSupport singleFeatureSupport;
                                    DeviceASLExtended[] deviceASLExtendedArray;
                                    block29: {
                                        block27: {
                                            block25: {
                                                deviceArray = SmartPhoneIntegrationHelper.filterDSIDeviceList(deviceArray, this.getGlobalProperties().getFeatureSupport());
                                                if (this.target.isTraceEnabled()) {
                                                    this.target.trace().append("SmartPhoneIntegration.DSIHandler").append(".handleDsiApiupdateDiscoveredDevices begin(connectionstate: ").append(this.getGlobalProperties().getCurrentConnectionState()).append(" )").log();
                                                }
                                                ServiceManager.eventDispatcher.createAndSubmitHMIEvent(1164389376);
                                                if (deviceArray == null) break block24;
                                                this.updateHmiDeviceList(deviceArray);
                                                int n = this.getGlobalProperties().getCurrentConnectionState();
                                                super.getClass();
                                                if (n == 5) break block25;
                                                int n2 = this.getGlobalProperties().getCurrentConnectionState();
                                                super.getClass();
                                                if (n2 != 0) break block26;
                                            }
                                            if (this.getGlobalProperties().isCarPlayConnectionConfirmPopupActive()) break block26;
                                            if (SmartPhoneIntegrationHelper.checkLastNewDeviceRemoved(this.getGlobalProperties().getLastNewDevice(), deviceArray)) {
                                                int n = this.getGlobalProperties().getCurrentConnectionState();
                                                super.getClass();
                                                if (n == 0) {
                                                    ServiceManager.eventDispatcher.createAndSubmitHMIEvent(963062784);
                                                    if (this.target.isTraceEnabled()) {
                                                        this.target.trace().append("SmartPhoneIntegration.DSIHandler").append(".last new device was removed and popups will be closed").log();
                                                    }
                                                }
                                            }
                                            deviceASLExtendedArray = SmartPhoneIntegrationHelper.findAllNewDevices(this.getGlobalProperties().getDsiDevicelistASLExtended(), deviceArray);
                                            device = SmartPhoneIntegrationHelper.findFirstNewDevice(this.getGlobalProperties().getDsiDevicelistASLExtended(), deviceArray);
                                            this.getGlobalProperties().setLastNewDevice(device);
                                            this.getGlobalProperties().setDsiDevicelist(deviceArray);
                                            this.handleConnectingPopupAbortCheck();
                                            if (this.target.isTraceEnabled()) {
                                                this.target.trace().append("SmartPhoneIntegration.DSIHandler").append(".handleDsiApiupdateDiscoveredDevices(").append(this.getGlobalProperties().getHmiDevicelist().toString()).log();
                                            }
                                            if (deviceArray.length != 0) break block27;
                                            if (this.target.isTraceEnabled()) {
                                                this.target.trace().append("SmartPhoneIntegration.DSIHandler").append(".handleDsiApiupdateDiscoveredDevices( empty list )").log();
                                            }
                                            ServiceManager.eventDispatcher.createAndSubmitHMIEvent(963062784);
                                            break block28;
                                        }
                                        Device device2 = this.getGlobalProperties().getClampSOffDisconnectedDevice();
                                        if (device2 == null) break block29;
                                        if (SmartPhoneIntegrationHelper.listContainsDeviceWithAddress(this.getGlobalProperties().getDsiDevicelistASLExtended(), device2.getDeviceAddress())) {
                                            if (this.target.isTraceEnabled()) {
                                                this.target.trace().append("SmartPhoneIntegration.DSIHandler").append(" - reconnect triggered by first updateDiscoveredDevices after clampS ON").log();
                                            }
                                            this.getGlobalProperties().resetDsiConnectionState();
                                            this.target.getDSISmartphoneIntegration().connectDevice(device2.getDeviceID(), 8);
                                            break block28;
                                        } else if (this.target.isTraceEnabled()) {
                                            this.target.trace().append("SmartPhoneIntegration.DSIHandler").append(" - no reconnect after clamp S on - device missing").log();
                                        }
                                        break block28;
                                    }
                                    int n = this.getGlobalProperties().getCurrentConnectionState();
                                    super.getClass();
                                    if (n != 0) break block30;
                                    if (this.target.isTraceEnabled()) {
                                        this.target.trace().append("SmartPhoneIntegration.DSIHandler").append(".handleDsiApiupdateDiscoveredDevices( getCurrentConnectionState()==CONST_CONNECTIONSTATE_IDLE)").log();
                                    }
                                    deviceASLExtended = null;
                                    deviceASLExtended = SmartPhoneIntegrationHelper.findFirstCommonDeviceByAdress(this.target.getPersistence().getLastConnectedDevicesList(), deviceASLExtendedArray);
                                    if (deviceASLExtended == null) break block31;
                                    if (this.getGlobalProperties().isInternalHFPorOCUCallActive()) break block32;
                                    if (deviceASLExtended.isBlacklisted()) break block33;
                                    FeatureSupport featureSupport = this.getGlobalProperties().getFeatureSupport();
                                    SingleFeatureSupport singleFeatureSupport2 = singleFeatureSupport = SmartPhoneIntegrationHelper.isAppleDevice(deviceASLExtended) ? featureSupport.getCarlifeIOS() : featureSupport.getCarlifeAndroid();
                                    if (deviceASLExtended.getLastConnectionMethod() == 4 && featureSupport.getCarplay().isSupported() || deviceASLExtended.getLastConnectionMethod() == 8 && featureSupport.getGal().isSupported() || deviceASLExtended.getLastConnectionMethod() == 1 && featureSupport.getMirrorlink().isSupported() || deviceASLExtended.getLastConnectionMethod() == 32 && singleFeatureSupport.isSupported()) {
                                        this.handleUpdateDiscoveredDevicesLastConnectedDeviceIsNotBlackListed(deviceASLExtended);
                                        break block28;
                                    } else if (this.target.isTraceEnabled()) {
                                        this.target.trace().append("SmartPhoneIntegration.DSIHandler").append(".handleDsiApiupdateDiscoveredDevices( last connected device method is not coded(CP Diag,SWaP, GAL Diag,SWaP, ML Diag,SWaP, CL Diag,SWaP ").append(deviceASLExtended.getLastConnectionMethod()).append(new StringBuffer().append(featureSupport.getCarplay().isCoded()).append(",").append(featureSupport.getCarplay().isSwap()).append(",  ").toString()).append(new StringBuffer().append(featureSupport.getGal().isCoded()).append(",").append(featureSupport.getGal().isSwap()).append(",  ").toString()).append(new StringBuffer().append(featureSupport.getMirrorlink().isCoded()).append(",").append(featureSupport.getMirrorlink().isSwap()).toString()).append(new StringBuffer().append(singleFeatureSupport.isCoded()).append(",").append(singleFeatureSupport.isSwap()).toString()).append(" )").log();
                                    }
                                    break block28;
                                }
                                this.handleUpdateDiscoveredDevicesLastConnectedDeviceIsBlackListed(deviceASLExtended);
                                break block28;
                            }
                            if (!deviceASLExtended.isBlacklisted()) {
                                if (this.target.isTraceEnabled()) {
                                    this.target.trace().append("SmartPhoneIntegration.DSIHandler").append(".handleDsiApiupdateDiscoveredDevices( HFP CALL is active NO AUTOCONNECT with ").append(deviceASLExtended.getDeviceName()).append(" )").log();
                                }
                                this.getGlobalProperties().handleConnectionRequestDuringOCUOrHfpCall(deviceASLExtended.getDsiDevice(), deviceASLExtended.getLastConnectionMethod(), false);
                                ServiceManager.eventDispatcher.createAndSubmitHMIEvent(1114057728);
                                break block28;
                            } else if (this.target.isTraceEnabled()) {
                                this.target.trace().append("SmartPhoneIntegration.DSIHandler").append(".handleDsiApiupdateDiscoveredDevices( HFP CALL is active AND Device is Blacklisted NO AUTOCONNECT with ").append(deviceASLExtended.getDeviceName()).append(" )").log();
                            }
                            break block28;
                        }
                        if (device != null) {
                            if (this.target.isTraceEnabled()) {
                                this.target.trace().append("SmartPhoneIntegration.DSIHandler").append(".handleDsiApiupdateDiscoveredDevices( newPluggedDevice found )").log();
                            }
                            this.target.getASLHandler().connectionHandlingNewDevice(new DeviceASLExtended(device), false, true);
                        }
                        break block28;
                    }
                    if (this.target.isTraceEnabled()) {
                        this.target.trace().append("SmartPhoneIntegration.DSIHandler").append(".handleDsiApiupdateDiscoveredDevices( getCurrentConnectionState() != CONST_CONNECTIONSTATE_IDLE )").log();
                    }
                    this.informDSIAboutUnusedCarPlayDevice();
                    break block28;
                }
                this.getGlobalProperties().setDsiDevicelist(deviceArray);
                if (this.target.isTraceEnabled()) {
                    this.target.trace().append("SmartPhoneIntegration.DSIHandler").append(".handleDsiApiupdateDiscoveredDevices( connection request is still running, no reaction of devicelist update )").log();
                    if (this.getGlobalProperties().isCarPlayConnectionConfirmPopupActive()) {
                        this.target.trace().append("SmartPhoneIntegration.DSIHandler").append(".handleDsiApiupdateDiscoveredDevices( isCarPlayConnectionConfirmPopupActive = true )").log();
                    }
                }
                break block28;
            }
            if (this.target.isTraceEnabled()) {
                this.target.trace().append("SmartPhoneIntegration.DSIHandler").append(".handleDsiApiupdateDiscoveredDevices( empty device list (NULL) )").log();
            }
        }
        this.getGlobalProperties().resetClampSOffDisconnectedDevice();
    }

    private void handleConnectingPopupAbortCheck() {
        DeviceASLExtended deviceASLExtended = this.getGlobalProperties().getCurrentSelectedDevice();
        if (null == deviceASLExtended || !SmartPhoneIntegrationHelper.listContainsDeviceWithAddress(this.getGlobalProperties().getDsiDevicelistASLExtended(), deviceASLExtended.getDeviceAddress())) {
            if (this.target.isTraceEnabled()) {
                this.target.trace().append("SmartPhoneIntegration.DSIHandler").append(". selected device is not available after devicelist update. Close connecting popup").log();
            }
            ServiceManager.eventDispatcher.createAndSubmitHMIEvent(1147612160);
        }
    }

    private void informDSIAboutUnusedCarPlayDevice() {
        DeviceASLExtended[] deviceASLExtendedArray = this.getGlobalProperties().getDsiDevicelistASLExtended();
        if (deviceASLExtendedArray.length > 1) {
            for (int i2 = 0; i2 < deviceASLExtendedArray.length; ++i2) {
                if (deviceASLExtendedArray[i2].getConnectionMethod() != 4) continue;
                int n = this.getGlobalProperties().getCurrentConnectionState();
                super.getClass();
                if (n != 5 || this.getGlobalProperties().getCurrentConnectedDevice().getDeviceAddress().equals(deviceASLExtendedArray[i2].getDeviceAddress())) {
                    int n2 = this.getGlobalProperties().getCurrentConnectionState();
                    super.getClass();
                    if (n2 != 1 || this.getGlobalProperties().getCurrentSelectedDevice().getDeviceAddress().equals(deviceASLExtendedArray[i2].getDeviceAddress())) continue;
                }
                if (this.target.isTraceEnabled()) {
                    this.target.trace().append("SmartPhoneIntegration.DSIHandler").append(".informDSIAboutUnusedCarPlayDevice(new pluged device is carplay verified and must be available for media->send disconnect to inform southside for roleswitch").log();
                }
                this.target.getDSISmartphoneIntegration().disconnectDevice(deviceASLExtendedArray[i2].getDeviceID());
                if (!this.target.isTraceEnabled()) continue;
                this.target.trace().append("SmartPhoneIntegration.DSIHandler").append(".disconnect by informDSIAboutUnusedCarPlayDevice) ").log();
            }
        }
    }

    private void handleUpdateDiscoveredDevicesLastConnectedDeviceIsBlackListed(DeviceASLExtended deviceASLExtended) {
        if (this.target.isTraceEnabled()) {
            this.target.trace().append("SmartPhoneIntegration.DSIHandler").append(".handleDsiApiupdateDiscoveredDevices( device BLACKLISTED) -> check method to send disconnect to dsi ").append(deviceASLExtended.getDeviceName()).append(" )").log();
        }
        if (deviceASLExtended != null && deviceASLExtended.getConnectionMethod() == 4) {
            if (this.target.isTraceEnabled()) {
                this.target.trace().append("SmartPhoneIntegration.DSIHandler").append(".handleDsiApiupdateDiscoveredDevices( device BLACKLISTED) -> send disconnect to dsi ").append(deviceASLExtended.getDeviceName()).append(" )").log();
            }
            this.target.getDSISmartphoneIntegration().disconnectDevice(deviceASLExtended.getDeviceID());
            if (this.target.isTraceEnabled()) {
                this.target.trace().append("SmartPhoneIntegration.DSIHandler").append(".disconnect by handleUpdateDiscoveredDevicesLastConnectedDeviceIsBlackListed) ").log();
            }
        }
    }

    private void handleUpdateDiscoveredDevicesLastConnectedDeviceIsNotBlackListed(DeviceASLExtended deviceASLExtended) {
        this.getGlobalProperties().resetDsiConnectionState();
        ASLHandler aSLHandler = this.target.getASLHandler();
        Device device = deviceASLExtended.getDsiDevice();
        int n = deviceASLExtended.getLastConnectionMethod();
        super.getClass();
        aSLHandler.connectDevice(device, n, 3);
        if (this.target.isTraceEnabled()) {
            this.target.trace().append("SmartPhoneIntegration.DSIHandler").append(".handleDsiApiupdateDiscoveredDevices( conn. with last connected device( devicename:").append(deviceASLExtended.getDeviceName()).append(", connectionmode:  DSI=").append(new StringBuffer().append(deviceASLExtended.getLastConnectionMethod()).append("Model=").toString()).append(SmartPhoneIntegrationHelper.convertConnectionMethod(deviceASLExtended.getLastConnectionMethod())).append("))").log();
        }
    }

    public void handleDsiApiUpdateDeviceConnectionState(int n, int n2, int n3) {
        if (this.target.isTraceEnabled()) {
            this.target.trace().append("SmartPhoneIntegration.DSIHandler").append(".handleDsiApiupdateDeviceConnectionState(").append(" deviceID: ").append(n).append(" connectionStatus: ").append(n2).append(", connectionMethod: ").append(n3).log();
        }
        if (n2 != 1) {
            ServiceManager.aslPropertyManager.valueChangedBoolean(1080503296, true);
        }
        if (this.ignoreUpdateDeviceConnectionState(n, n2)) {
            if (this.target.isTraceEnabled()) {
                this.target.trace().append("SmartPhoneIntegration.DSIHandler").append(".handleDsiApiupdateDeviceConnectionState() - ignore update!").log();
            }
            return;
        }
        this.getGlobalProperties().setDsiConnectionState(n2);
        switch (n2) {
            case 2: {
                this.handleDsiApiUpdateDeviceConnectionStateSTARTED(n, n3);
                break;
            }
            case 1: {
                this.handleDsiApiUpdateDeviceConnectionStateCONNECTED(n3);
                break;
            }
            case 0: {
                if (this.target.isTraceEnabled()) {
                    this.target.trace().append("SmartPhoneIntegration.DSIHandler").append(".handleDsiApiupdateDeviceConnectionState(").append(" CONNECTIONSTATE_DISCONNECTED )").log();
                }
                this.handleDsiApiUpdateDeviceConnectionStateDISCONNECTED_STOPPED(n, n3, n2);
                break;
            }
            case 6: {
                this.handleDsiApiUpdateDeviceConnectionStateFAILED_NO_CARPLAY_DEVICE(n, n3);
                break;
            }
            case 5: {
                this.handleDsiApiUpdateDeviceConnectionStateFAILED_NO_MIRRORLINK_DEVICE(n, n3);
                break;
            }
            case 7: {
                this.handleDsiApiUpdateDeviceConnectionStateFAILED_NO_GAL_DEVICE(n, n3);
                break;
            }
            case 10: {
                this.handleDsiApiUpdateDeviceConnectionStateFAILED_NO_CARLIFE_DEVICE(n, n3);
                break;
            }
            case 4: {
                this.handleDsiApiUpdateDeviceConnectionStateFAILED_DEVICE_LOCKED__OTHER_TIMEOUT(n3);
                break;
            }
            case 9: {
                this.handleDsiApiUpdateDeviceConnectionStateFAILED_DEVICE_LOCKED__OTHER_TIMEOUT(n3);
                break;
            }
            case 8: {
                this.handleDsiApiUpdateDeviceConnectionStateFAILED_DEVICE_LOCKED__OTHER_TIMEOUT(n3);
                break;
            }
            case 3: {
                this.updateTechnologyAboutConnectionStopped(n3);
                break;
            }
        }
    }

    private void handleDsiApiUpdateDeviceConnectionStateDISCONNECTED_STOPPED(int n, int n2, int n3) {
        this.updateTechnologyContextAboutConnectionLost(n2);
        this.getGlobalProperties().resetCurrentConnectedDeviceOnly();
        if (!this.getGlobalProperties().isConnectionSwitchActive()) {
            if (this.target.isTraceEnabled()) {
                this.target.trace().append("SmartPhoneIntegration.DSIHandler").append(".handleDsiApiupdateDeviceConnectionState( no connectionswitch )").log();
            }
            this.getGlobalProperties().resetCurrentSelectedAndConnectedDevice();
            SmartPhoneIntegrationGlobalProperyAccessor smartPhoneIntegrationGlobalProperyAccessor = this.getGlobalProperties();
            super.getClass();
            smartPhoneIntegrationGlobalProperyAccessor.setCurrentConnectionState(0);
            ServiceManager.aslPropertyManager.valueChangedInteger(1114057728, 0);
            ServiceManager.eventDispatcher.createAndSubmitHMIEvent(912731136);
        } else {
            if (this.target.isTraceEnabled()) {
                this.target.trace().append("SmartPhoneIntegration.DSIHandler").append(".handleDsiApiupdateDeviceConnectionState( connectionswitch dev1 to dev2 )").log();
            }
            ServiceManager.aslPropertyManager.valueChangedInteger(1114057728, 0);
            SmartPhoneIntegrationGlobalProperyAccessor smartPhoneIntegrationGlobalProperyAccessor = this.getGlobalProperties();
            super.getClass();
            smartPhoneIntegrationGlobalProperyAccessor.setCurrentConnectionState(4);
            ServiceManager.eventDispatcher.createAndSubmitHMIEvent(1348938752);
            TimerUtil.startTimer(this.target, -1417281280, 3000);
        }
    }

    private void updateTechnologyAboutConnectionStopped(int n) {
        switch (n) {
            case 2: {
                this.target.triggerObserver(789863680, null);
                break;
            }
            case 4: {
                this.target.triggerObserver(789863680, null);
                break;
            }
            case 8: {
                this.target.triggerObserver(823418112, null);
                break;
            }
            case 1: {
                this.target.triggerObserver(907304192, null);
                break;
            }
            case 32: {
                this.target.triggerObserver(-2011931392, null);
                break;
            }
        }
    }

    private void handleDsiApiUpdateDeviceConnectionStateFAILED_DEVICE_LOCKED__OTHER_TIMEOUT(int n) {
        SmartPhoneIntegrationGlobalProperyAccessor smartPhoneIntegrationGlobalProperyAccessor = this.getGlobalProperties();
        super.getClass();
        smartPhoneIntegrationGlobalProperyAccessor.setCurrentConnectionState(0);
        ServiceManager.aslPropertyManager.valueChangedInteger(1114057728, 0);
        ServiceManager.eventDispatcher.createAndSubmitHMIEvent(912731136);
        this.updateTechnologyContextAboutConnectionLost(n);
        this.target.getASLHandler().updateConnectionFailedPopupPropertiesToModel(n);
        this.getGlobalProperties().resetCurrentSelectedAndConnectedDevice();
    }

    private void handleConnectionNotSupported(int n, int n2) {
        this.target.getPersistence().addDeviceToBlackList(SmartPhoneIntegrationHelper.getDeviceFromId(n));
        SmartPhoneIntegrationGlobalProperyAccessor smartPhoneIntegrationGlobalProperyAccessor = this.getGlobalProperties();
        super.getClass();
        smartPhoneIntegrationGlobalProperyAccessor.setCurrentConnectionState(0);
        ServiceManager.aslPropertyManager.valueChangedInteger(1114057728, 0);
        this.updateTechnologyContextAboutConnectionLost(n2);
        ServiceManager.aslPropertyManager.valueChangedInteger(1214721024, SmartPhoneIntegrationHelper.convertConnectionMethod(n2));
        if (this.getGlobalProperties().getCurrentConnectedDevice() != null && this.getGlobalProperties().getCurrentConnectedDevice().getDeviceID() != -1) {
            ServiceManager.eventDispatcher.createAndSubmitHMIEvent(912731136);
        } else {
            ServiceManager.eventDispatcher.createAndSubmitHMIEvent(895953920);
        }
        this.getGlobalProperties().resetCurrentSelectedAndConnectedDevice();
    }

    private void handleDsiApiUpdateDeviceConnectionStateFAILED_NO_MIRRORLINK_DEVICE(int n, int n2) {
        this.handleConnectionNotSupported(n, n2);
    }

    private void handleDsiApiUpdateDeviceConnectionStateFAILED_NO_GAL_DEVICE(int n, int n2) {
        this.handleConnectionNotSupported(n, n2);
    }

    private void handleDsiApiUpdateDeviceConnectionStateFAILED_NO_CARLIFE_DEVICE(int n, int n2) {
        this.handleConnectionNotSupported(n, n2);
    }

    private void handleDsiApiUpdateDeviceConnectionStateFAILED_NO_CARPLAY_DEVICE(int n, int n2) {
        this.handleConnectionNotSupported(n, n2);
    }

    private void handleDsiApiUpdateDeviceConnectionStateCONNECTED(int n) {
        if (n == 2) {
            n = 4;
        }
        switch (n) {
            case 4: {
                EventGeneric eventGeneric = ServiceManager.mGenericEventFactory.newEvent(1024744704);
                ServiceManager.eventMain.getEventDispatcher().sendSafe(eventGeneric);
                this.target.triggerObserver(554982656, null);
                break;
            }
            case 2: {
                break;
            }
            case 1: {
                this.target.triggerObserver(588537088, null);
                break;
            }
            case 8: {
                this.target.triggerObserver(622091520, null);
                break;
            }
            case 32: {
                this.target.triggerObserver(-2062263040, null);
                break;
            }
        }
    }

    private void handleDsiApiUpdateDeviceConnectionStateSTARTED(int n, int n2) {
        this.getGlobalProperties().setConnectionSwitchActive(false);
        this.updateCurrentConnectedDevice(n);
        SmartPhoneIntegrationGlobalProperyAccessor smartPhoneIntegrationGlobalProperyAccessor = this.getGlobalProperties();
        super.getClass();
        smartPhoneIntegrationGlobalProperyAccessor.setCurrentConnectionState(5);
        if (n2 == 2) {
            n2 = 4;
        }
        switch (n2) {
            case 4: {
                this.triggerModelToGoToContext(845622272, 773086464, 2, n2);
                break;
            }
            case 8: {
                this.triggerModelToGoToContext(862399488, 806640896, 3, n2);
                break;
            }
            case 32: {
                this.triggerModelToGoToContext(1181166592, -2028708608, 4, n2);
                break;
            }
            case 1: {
                this.triggerModelToGoToContext(828845056, 890526976, 1, n2);
                if (!this.getGlobalProperties().isMirrorlinkFactoryReset()) break;
                this.target.triggerObserver(873749760, null);
                this.getGlobalProperties().setMirrorlinkFactoryReset(false);
                break;
            }
        }
    }

    private void triggerModelToGoToContext(int n, int n2, int n3, int n4) {
        ServiceManager.aslPropertyManager.valueChangedInteger(1114057728, n3);
        ServiceManager.eventDispatcher.createAndSubmitHMIEvent(n);
        this.target.triggerObserver(n2, null);
        this.getGlobalProperties().setLastConnectionMethod(this.getGlobalProperties().getCurrentConnectedDevice(), n4);
        if (this.target.isTraceEnabled()) {
            this.target.trace().append("SmartPhoneIntegration.DSIHandler").append(new StringBuffer().append("handleDsiApiupdateDeviceConnectionState.setLastconnectionmode( ").append(this.getGlobalProperties().getCurrentConnectedDevice().getLastConnectionMethod()).append(" )").toString()).log();
        }
        this.target.getPersistence().updateLastConnectedDevices(this.getGlobalProperties().getCurrentConnectedDevice());
    }

    private boolean ignoreUpdateDeviceConnectionState(int n, int n2) {
        boolean bl;
        switch (n2) {
            case 0: 
            case 4: 
            case 5: 
            case 6: 
            case 7: 
            case 8: 
            case 9: 
            case 10: {
                bl = true;
                break;
            }
            default: {
                bl = false;
            }
        }
        boolean bl2 = n2 != this.getGlobalProperties().getDsiConnectionState();
        return bl && !bl2;
    }

    public void updateTechnologyContextAboutConnectionLost(int n) {
        switch (n) {
            case 2: {
                this.target.triggerObserver(571759872, null);
                break;
            }
            case 4: {
                this.target.triggerObserver(571759872, null);
                break;
            }
            case 1: {
                this.target.triggerObserver(605314304, null);
                break;
            }
            case 8: {
                this.target.triggerObserver(638868736, null);
                break;
            }
            case 32: {
                this.target.triggerObserver(-2045485824, null);
                break;
            }
        }
    }

    public void handleDsiApiUpdateSWaPStatus(int n) {
        if (this.target.isTraceEnabled()) {
            this.target.trace().append("SmartPhoneIntegration.DSIHandler").append(".handleDsiApiUpdateSWaPStatus(").append(" status: ").append(new StringBuffer().append(n).append(")").toString()).log();
        }
        this.getGlobalProperties().getFeatureSupport().setSWAPState(n);
        boolean bl = SmartPhoneIntegrationHelper.isSWaPSupported(n, 1);
        ServiceManager.aslPropertyManager.valueChangedBoolean(1046948864, bl);
        boolean bl2 = SmartPhoneIntegrationHelper.isSWaPSupported(n, 2);
        ServiceManager.aslPropertyManager.valueChangedBoolean(1030171648, bl2);
        boolean bl3 = SmartPhoneIntegrationHelper.isSWaPSupported(n, 4);
        ServiceManager.aslPropertyManager.valueChangedBoolean(1063726080, bl3);
        boolean bl4 = SmartPhoneIntegrationHelper.isSWaPSupported(n, 8);
        ServiceManager.aslPropertyManager.valueChangedBoolean(1248275456, bl4);
        this.getGlobalProperties().setSwapStateWasAlreadyUpdated(true);
        this.getGlobalProperties().updateSWapStateChangeForAppAdapter(this.getGlobalProperties().getFeatureSupport(), this.getGlobalProperties().isSwapStateWasAlreadyUpdated());
        boolean bl5 = bl || bl2 || bl3 || bl4;
        ServiceManager.configManagerDiag.setFeatureFlagValue("ASL.Configuration.isAppConnectSWAP", bl5);
    }

    public void handleDsiApiUpdateUSBResetActive(boolean bl) {
        if (this.target.isTraceEnabled()) {
            this.target.trace().append("SmartPhoneIntegration.DSIHandler").append(".handleDsiApiUpdateUSBResetActive(").append(" active: ").append(new StringBuffer().append(bl).append(")").toString()).log();
        }
        if (this.getGlobalProperties().isBusResetActive() != bl) {
            this.getGlobalProperties().setBusResetActive(bl);
            if (!bl) {
                TimerUtil.startTimer(this.target, -1450835712, 7000);
                this.target.getASLHandler().setDeviceListAccessibility(false);
            } else {
                TimerUtil.stopTimer(this.target, -1450835712);
            }
        } else if (this.target.isTraceEnabled()) {
            this.target.trace().append("SmartPhoneIntegration.DSIHandler").append(".handleDsiApiUpdateUSBResetActive(").append(" current state: ").append(this.getGlobalProperties().isBusResetActive()).append(" new state: ").append(bl).append(")").log();
        }
    }

    public void handleDsiApiUpdateAppConnectContextRequested(boolean bl) {
        if (null != this.target.getAppConnectRequestHandler()) {
            this.target.getAppConnectRequestHandler().handleAppConnectContextRequested(bl);
        }
    }
}

