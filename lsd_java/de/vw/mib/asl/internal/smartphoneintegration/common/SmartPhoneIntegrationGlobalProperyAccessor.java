/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.smartphoneintegration.common;

import de.vw.mib.asl.api.smartphoneintegration.ASLSmartphoneIntegrationAppConnectAppAdapter;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.smartphoneintegration.common.DeviceASLExtended;
import de.vw.mib.asl.internal.smartphoneintegration.common.FeatureSupport;
import de.vw.mib.asl.internal.smartphoneintegration.common.SmartPhoneIntegrationDisplaySize;
import de.vw.mib.asl.internal.smartphoneintegration.common.SmartPhoneIntegrationHelper;
import de.vw.mib.asl.internal.smartphoneintegration.common.TimerUtil;
import de.vw.mib.asl.internal.smartphoneintegration.model.DeviceList;
import de.vw.mib.asl.internal.smartphoneintegration.target.HsmTarget;
import java.util.ArrayList;
import org.dsi.ifc.smartphoneintegration.Device;

public final class SmartPhoneIntegrationGlobalProperyAccessor {
    private static SmartPhoneIntegrationGlobalProperyAccessor instance = null;
    private DeviceASLExtended currentConnectedDeviceASLExtended;
    private DeviceASLExtended currentSelectedDeviceASLExtended;
    private DeviceASLExtended currentOCUDisconnectedDevice;
    Device[] tempDsiDevicelist;
    Device preConnectedDevice;
    DeviceASLExtended[] dsi_devicelist_AslExtended;
    ArrayList hmi_devicelist = new ArrayList();
    private final DeviceList model_devicelist = new DeviceList();
    private final String classname;
    private Device lastNewDevice;
    private Device clampSOffDisconnectedDevice = null;
    private Device carplayDeviceInVerification;
    private HsmTarget target;
    private int currentConnectionState = 0;
    public final int CONST_CONNECTIONSTATE_IDLE;
    public final int CONST_CONNECTIONSTATE_CONNECTING;
    public final int CONST_CONNECTIONSTATE_CONNECTING_INITIAL_WITH_PREFERED_METHOD;
    public final int CONST_CONNECTIONSTATE_CONNECTING_LAST_DEVICE;
    public final int CONST_CONNECTIONSTATE_CONNECTING_SWITCH_DEVICE;
    public final int CONST_CONNECTIONSTATE_CONNECTED;
    public final int CONST_CONNECTIONMETHOD_IGNORE;
    public final int CONST_NO_CONNECTIONMETHOD_SUPPORTED;
    public boolean CONST_UPDATE_DISCOVERED_DEVICES_LOWPASS_ACTIVE = true;
    private boolean isConnectionSwitchActive = false;
    private boolean mirrorlinkFactoryReset = false;
    private boolean isEntertainmentActive = false;
    private boolean isInternalHFPCallActive = false;
    private boolean isInternalOCUCallActive = false;
    private boolean isConnectionRequestDuringActivePhoneCall = false;
    private boolean isConnectionRequestDuringActivePhoneCallConfirmPopup = false;
    private Device isConnectionRequestDuringActivePhoneCallDevice;
    private int isConnectionRequestDuringActivePhoneCallConnectionMethod = -1;
    final FeatureSupport featureSupport = new FeatureSupport();
    private boolean isCarPlayConnectionConfirmPopupActive = false;
    private boolean isBusResetActive = false;
    private int dsiConnectionState = -1;
    private SmartPhoneIntegrationDisplaySize displaySize = null;
    private final ArrayList adapterList;
    private boolean swapStateWasAlreadyUpdated;

    private SmartPhoneIntegrationGlobalProperyAccessor() {
        this.classname = "SmartPhoneIntegration.GlobalProperyAccessor";
        this.CONST_CONNECTIONSTATE_IDLE = 0;
        this.CONST_CONNECTIONSTATE_CONNECTING = 1;
        this.CONST_CONNECTIONSTATE_CONNECTING_INITIAL_WITH_PREFERED_METHOD = 2;
        this.CONST_CONNECTIONSTATE_CONNECTING_LAST_DEVICE = 3;
        this.CONST_CONNECTIONSTATE_CONNECTING_SWITCH_DEVICE = 4;
        this.CONST_CONNECTIONSTATE_CONNECTED = 5;
        this.CONST_CONNECTIONMETHOD_IGNORE = -1;
        this.CONST_NO_CONNECTIONMETHOD_SUPPORTED = -1;
        this.currentConnectedDeviceASLExtended = new DeviceASLExtended();
        this.currentSelectedDeviceASLExtended = new DeviceASLExtended();
        this.lastNewDevice = new Device();
        this.isConnectionRequestDuringActivePhoneCallDevice = new Device();
        this.adapterList = new ArrayList();
    }

    public static SmartPhoneIntegrationGlobalProperyAccessor getInstance() {
        if (instance == null) {
            instance = new SmartPhoneIntegrationGlobalProperyAccessor();
            return instance;
        }
        return instance;
    }

    public void setTarget(HsmTarget hsmTarget) {
        this.target = hsmTarget;
        this.initializeDisplaySize();
    }

    public void initializeDisplaySize() {
        this.displaySize = new SmartPhoneIntegrationDisplaySize(this.target);
    }

    private HsmTarget getTarget() {
        return this.target;
    }

    public DeviceASLExtended[] getDsiDevicelistASLExtended() {
        return this.dsi_devicelist_AslExtended;
    }

    public void setDsiDevicelist(Device[] deviceArray) {
        if (this.isTraceEnabled()) {
            this.getTarget().trace().append("SmartPhoneIntegration.GlobalProperyAccessor").append(".setDsiDevicelist( )").log();
        }
        DeviceASLExtended[] deviceASLExtendedArray = this.dsi_devicelist_AslExtended = deviceArray == null ? new DeviceASLExtended[]{} : new DeviceASLExtended[deviceArray.length];
        if (deviceArray != null) {
            for (int i2 = 0; i2 < deviceArray.length; ++i2) {
                this.dsi_devicelist_AslExtended[i2] = new DeviceASLExtended(deviceArray[i2]);
                if (this.dsi_devicelist_AslExtended[i2].getDeviceID() == this.getCurrentConnectedDevice().getDeviceID()) {
                    ServiceManager.aslPropertyManager.valueChangedInteger(1097280512, this.getListIndex(this.getCurrentConnectedDevice()));
                    if (!this.isTraceEnabled()) continue;
                    this.getTarget().trace().append("SmartPhoneIntegration.GlobalProperyAccessor").append(".setDsiDevicelist( index conn dev:").append(i2).log();
                    continue;
                }
                if (!this.isTraceEnabled()) continue;
                this.getTarget().trace().append("SmartPhoneIntegration.GlobalProperyAccessor").append(".setDsiDevicelist( index conn dev no compare:").append(i2).log();
            }
        } else if (this.isTraceEnabled()) {
            this.getTarget().trace().append("SmartPhoneIntegration.GlobalProperyAccessor").append(".setDsiDevicelist( devicelist is null !!!!!!)").log();
        }
    }

    public ArrayList getHmiDevicelist() {
        return this.hmi_devicelist;
    }

    public DeviceList getModelDevicelist() {
        return this.model_devicelist;
    }

    public DeviceASLExtended getCurrentConnectedDevice() {
        return this.currentConnectedDeviceASLExtended;
    }

    public void setCurrentConnectedDeviceASLExtended(DeviceASLExtended deviceASLExtended) {
        if (this.isTraceEnabled()) {
            this.getTarget().trace().append("SmartPhoneIntegration.GlobalProperyAccessor").append(".setCurrentConnectedDeviceASLExtended( ID:").append(deviceASLExtended.getDeviceID()).append(" Name: ").append(deviceASLExtended.getDeviceName()).append(" Adress: ").append(deviceASLExtended.getDeviceAddress()).append(" )").append(" LastConnectionMode: ").append(deviceASLExtended.getLastConnectionMethod()).log();
        }
        this.currentConnectedDeviceASLExtended = deviceASLExtended;
        this.getTarget().getASLHandler().updateExlapServerData(true);
        this.updateCurrentConnectedDeviceNameForAppAdapter();
    }

    public void setCurrentConnectedDeviceAslExtended(int n) {
        ServiceManager.aslPropertyManager.valueChangedInteger(1097280512, n);
        this.currentConnectedDeviceASLExtended = this.dsi_devicelist_AslExtended[n];
        this.getTarget().getASLHandler().updateExlapServerData(true);
        this.updateCurrentConnectedDeviceNameForAppAdapter();
    }

    public int getCurrentConnectedDevice_ListIndex() {
        return this.getListIndex(this.currentConnectedDeviceASLExtended);
    }

    public int getCurrentConnectionState() {
        return this.currentConnectionState;
    }

    public void setCurrentConnectionState(int n) {
        this.currentConnectionState = n;
        if (this.isTraceEnabled()) {
            this.getTarget().trace().append("SmartPhoneIntegration.GlobalProperyAccessor").append(".setCurrentConnectionState( state:").append(n).append(" )").log();
        }
        this.getTarget().getASLHandler().updateExlapServerData(true);
        if (this.currentConnectionState != 5 && this.currentConnectionState != 0) {
            this.getTarget().getASLHandler().setDeviceListAccessibility(false);
        } else {
            this.getTarget().getASLHandler().setDeviceListAccessibility(true);
        }
        if (this.currentConnectionState == 1) {
            TimerUtil.startTimer(this.target, -1400504064, -928055296);
            if (this.isTraceEnabled()) {
                this.getTarget().trace().append("SmartPhoneIntegration.GlobalProperyAccessor").append(".setCurrentConnectionState( (re)start timer EV_SMARTPHONEINTEGRATION_CONNECTION_STATE_RESET_TIMER").append(" )").log();
            }
        } else {
            if (this.isTraceEnabled()) {
                this.getTarget().trace().append("SmartPhoneIntegration.GlobalProperyAccessor").append(".setCurrentConnectionState( stop timer EV_SMARTPHONEINTEGRATION_CONNECTION_STATE_RESET_TIMER").append(" )").log();
            }
            TimerUtil.stopTimer(this.target, -1400504064);
        }
    }

    public int getCurrentSelectedDevice_PreferedConnectionMethod() {
        return this.currentSelectedDeviceASLExtended.getLastConnectionMethod();
    }

    public DeviceASLExtended getCurrentSelectedDevice() {
        return this.currentSelectedDeviceASLExtended;
    }

    public void setCurrentSelectedDevice(DeviceASLExtended deviceASLExtended) {
        if (this.isTraceEnabled()) {
            this.getTarget().trace().append("SmartPhoneIntegration.GlobalProperyAccessor").append(".setCurrentSelectedDevice( device:").append(deviceASLExtended.toString()).append(" )").log();
        }
        this.currentSelectedDeviceASLExtended = deviceASLExtended;
    }

    public void setCurrentSelectedDevice(int n) {
        if (this.isTraceEnabled()) {
            this.getTarget().trace().append("SmartPhoneIntegration.GlobalProperyAccessor").append(new StringBuffer().append(".setCurrentSelectedDevice( device[").append(n).append("] :").toString()).append(this.dsi_devicelist_AslExtended[n].toString()).append(" )").log();
        }
        this.currentSelectedDeviceASLExtended = this.dsi_devicelist_AslExtended[n];
    }

    public void resetCurrentSelectedAndConnectedDevice() {
        this.currentSelectedDeviceASLExtended = new DeviceASLExtended();
        this.currentConnectedDeviceASLExtended = new DeviceASLExtended();
        ServiceManager.aslPropertyManager.valueChangedInteger(1097280512, -1);
        this.updateCurrentConnectedDeviceNameForAppAdapter();
        this.resetCurrentConnectionMethodForAppAdapter();
    }

    public void resetCurrentConnectedDeviceOnly() {
        this.currentConnectedDeviceASLExtended = new DeviceASLExtended();
        ServiceManager.aslPropertyManager.valueChangedInteger(1097280512, -1);
        this.updateCurrentConnectedDeviceNameForAppAdapter();
        this.resetCurrentConnectionMethodForAppAdapter();
    }

    public boolean isConnectionSwitchActive() {
        return this.isConnectionSwitchActive;
    }

    public void setConnectionSwitchActive(boolean bl) {
        if (this.isTraceEnabled()) {
            this.getTarget().trace().append("SmartPhoneIntegration.GlobalProperyAccessor").append(".setConnectionSwitchActive( ").append(bl).append(" )").log();
        }
        this.isConnectionSwitchActive = bl;
    }

    public boolean isMirrorlinkFactoryReset() {
        return this.mirrorlinkFactoryReset;
    }

    public void setMirrorlinkFactoryReset(boolean bl) {
        this.mirrorlinkFactoryReset = bl;
    }

    public boolean isEntertainmentActive() {
        return this.isEntertainmentActive;
    }

    public void setEntertainmentActive(boolean bl) {
        this.isEntertainmentActive = bl;
        this.getTarget().getASLHandler().updateExlapServerData(true);
    }

    public Device getLastNewDevice() {
        return this.lastNewDevice;
    }

    public void setLastNewDevice(Device device) {
        this.lastNewDevice = device;
    }

    public boolean isInternalHFPorOCUCallActive() {
        if (this.isTraceEnabled()) {
            this.getTarget().trace().append("SmartPhoneIntegration.GlobalProperyAccessor").append(".isInternalHFPorOCUCallActive() returns ").append(this.isInternalHFPCallActive).append(",").append(this.isInternalOCUCallActive).append(" => ").append(this.isInternalHFPCallActive || this.isInternalOCUCallActive).log();
        }
        return this.isInternalHFPCallActive || this.isInternalOCUCallActive;
    }

    public boolean isInternalHFPCallActive() {
        return this.isInternalHFPCallActive;
    }

    public void setInternalHFPCallActive(boolean bl) {
        this.isInternalHFPCallActive = bl;
    }

    public void printAllGlobalProperties() {
        if (this.isTraceEnabled()) {
            this.getTarget().trace().append("SmartPhoneIntegration.GlobalProperyAccessor").append(".printGlobalProperties( ").append(", dsi_devicelist_AslExtended: ").append(this.dsi_devicelist_AslExtended.toString()).append(", currentConnectionState: ").append(this.currentConnectionState).append(", currentConnectedDeviceASLExtended: ").append(this.currentConnectedDeviceASLExtended.getDeviceName()).append(", currentSelectedDeviceASLExtended: ").append(this.currentSelectedDeviceASLExtended.getDeviceName()).append(", last new device: ").append(this.lastNewDevice.getDeviceName()).append(" )").log();
        }
    }

    public void handleConnectionRequestDuringOCUOrHfpCall(Device device, int n, boolean bl) {
        if (this.isTraceEnabled()) {
            this.getTarget().trace().append("SmartPhoneIntegration.GlobalProperyAccessor").append(".handleConnectionRequestDuringOCUOrHfpCall( ").append(device.getDeviceName()).append(", method=").append(n).log();
        }
        this.isConnectionRequestDuringActivePhoneCallDevice = device;
        this.isConnectionRequestDuringActivePhoneCallConnectionMethod = n;
        this.isConnectionRequestDuringActivePhoneCall = true;
        this.isConnectionRequestDuringActivePhoneCallConfirmPopup = bl;
        if (this.currentConnectionState == 5 && this.currentConnectedDeviceASLExtended != null) {
            if (this.isTraceEnabled()) {
                this.getTarget().trace().append("SmartPhoneIntegration.GlobalProperyAccessor").append(".handleConnectionRequestDuringOCUOrHfpCall( disconnect current connected device)").log();
            }
            this.getTarget().getDSISmartphoneIntegration().disconnectDevice(this.currentConnectedDeviceASLExtended.getDeviceID());
        }
    }

    public void requestConnectionOnFinishedOCUOrHfpCall() {
        if (this.isTraceEnabled()) {
            this.getTarget().trace().append("SmartPhoneIntegration.GlobalProperyAccessor").append(".requestConnectionOnFinishedHfpCall( ").append(new StringBuffer().append(this.isConnectionRequestDuringActivePhoneCall).append(" )").toString()).log();
        }
        if (this.isConnectionRequestDuringActivePhoneCallDevice != null && SmartPhoneIntegrationHelper.listContainsDeviceWithAddress(this.dsi_devicelist_AslExtended, this.isConnectionRequestDuringActivePhoneCallDevice.getDeviceAddress())) {
            if (this.isConnectionRequestDuringActivePhoneCallConfirmPopup) {
                this.getTarget().getASLHandler().requestNewDeviceDetectedPopup();
            } else {
                this.resetDsiConnectionState();
                this.getTarget().getASLHandler().connectDevice(this.isConnectionRequestDuringActivePhoneCallDevice, this.isConnectionRequestDuringActivePhoneCallConnectionMethod, 1);
            }
        }
        this.isConnectionRequestDuringActivePhoneCallDevice = null;
        this.isConnectionRequestDuringActivePhoneCallConnectionMethod = -1;
        this.isConnectionRequestDuringActivePhoneCall = false;
        this.isConnectionRequestDuringActivePhoneCallConfirmPopup = false;
    }

    public FeatureSupport getFeatureSupport() {
        return this.featureSupport;
    }

    public Device getCarplayDeviceInVerification() {
        return this.carplayDeviceInVerification;
    }

    public void setCarplayDeviceInVerification(Device device) {
        this.carplayDeviceInVerification = device;
    }

    public boolean isCarPlayConnectionConfirmPopupActive() {
        return this.isCarPlayConnectionConfirmPopupActive;
    }

    public void setCarPlayConnectionConfirmPopupActive(boolean bl) {
        if (this.isTraceEnabled()) {
            this.getTarget().trace().append("SmartPhoneIntegration.GlobalProperyAccessor").append(".setCarPlayConnectionConfirmPopupActive( ").append(new StringBuffer().append(bl).append(" )").toString()).log();
        }
        this.isCarPlayConnectionConfirmPopupActive = bl;
    }

    public Device[] getTempDsiDevicelist() {
        return this.tempDsiDevicelist;
    }

    public void setTempDsiDevicelist(Device[] deviceArray) {
        this.tempDsiDevicelist = deviceArray;
    }

    public Device getPreConnectedDevice() {
        return this.preConnectedDevice;
    }

    public void setPreConnectedDevice(Device device) {
        this.preConnectedDevice = device;
    }

    public int getDsiConnectionState() {
        return this.dsiConnectionState;
    }

    public void setDsiConnectionState(int n) {
        this.dsiConnectionState = n;
    }

    public void resetDsiConnectionState() {
        this.setDsiConnectionState(-1);
    }

    public boolean isBusResetActive() {
        return this.isBusResetActive;
    }

    public void setBusResetActive(boolean bl) {
        this.isBusResetActive = bl;
    }

    public boolean isInternalOCUCallActive() {
        return this.isInternalOCUCallActive;
    }

    public void setInternalOCUCallActive(boolean bl) {
        if (this.isTraceEnabled()) {
            this.getTarget().trace().append("SmartPhoneIntegration.GlobalProperyAccessor").append(".setInternalOCUCallActive( state: ").append(bl).append(" )").log();
        }
        this.isInternalOCUCallActive = bl;
    }

    public void setCurrentOCUDisconnectedDevice(DeviceASLExtended deviceASLExtended) {
        if (this.isTraceEnabled()) {
            this.getTarget().trace().append("SmartPhoneIntegration.GlobalProperyAccessor").append(".setCurrentOCUDisconnectedDevice( device:").append(deviceASLExtended.toString()).append(" )").log();
        }
        this.currentOCUDisconnectedDevice = deviceASLExtended;
    }

    public DeviceASLExtended getLastOCUDisconnectedDevice() {
        return this.currentOCUDisconnectedDevice;
    }

    public double getPixelDimensionWidth() {
        if (this.displaySize != null) {
            return this.displaySize.getDisplayWidth();
        }
        return 0.0;
    }

    public double getPixelDimensionHeight() {
        if (this.displaySize != null) {
            return this.displaySize.getDisplayHeight();
        }
        return 0.0;
    }

    public Device getClampSOffDisconnectedDevice() {
        return this.clampSOffDisconnectedDevice;
    }

    public void setClampSOffDisconnectedDevice(Device device) {
        this.clampSOffDisconnectedDevice = device;
    }

    public void resetClampSOffDisconnectedDevice() {
        this.clampSOffDisconnectedDevice = null;
    }

    public ASLSmartphoneIntegrationAppConnectAppAdapter getAppAdapterInterface(int n) {
        ASLSmartphoneIntegrationAppConnectAppAdapter aSLSmartphoneIntegrationAppConnectAppAdapter = (ASLSmartphoneIntegrationAppConnectAppAdapter)this.adapterList.get(n);
        return aSLSmartphoneIntegrationAppConnectAppAdapter;
    }

    public ArrayList getAdapterList() {
        return this.adapterList;
    }

    private boolean isTraceEnabled() {
        if (this.getTarget() != null) {
            return this.getTarget().isTraceEnabled();
        }
        return false;
    }

    public void setAppAdapterInterface(ASLSmartphoneIntegrationAppConnectAppAdapter aSLSmartphoneIntegrationAppConnectAppAdapter) {
        if (this.isTraceEnabled()) {
            this.getTarget().trace().append("SmartPhoneIntegration.GlobalProperyAccessor").append(".setAppAdapterInterface(adapter ").append(aSLSmartphoneIntegrationAppConnectAppAdapter != null ? "is ok" : "is null").append(")").log();
        }
        if (aSLSmartphoneIntegrationAppConnectAppAdapter != null && this.adapterList != null) {
            this.adapterList.add(aSLSmartphoneIntegrationAppConnectAppAdapter);
            this.updateCurrentConnectedDeviceNameForAppAdapter();
            this.updateCurrentConnectionMethodForAppAdapter();
            this.updateSWapStateChangeForAppAdapter(this.featureSupport, this.swapStateWasAlreadyUpdated);
        }
        if (this.isTraceEnabled()) {
            this.getTarget().trace().append("SmartPhoneIntegration.GlobalProperyAccessor").append(".setAppAdapterInterface(number of registrated adapters ").append(this.adapterList.size()).append(")").log();
        }
    }

    private void updateCurrentConnectedDeviceNameForAppAdapter() {
        for (int i2 = 0; i2 < this.adapterList.size(); ++i2) {
            if (this.getAppAdapterInterface(i2) != null) {
                this.getAppAdapterInterface(i2).updateDevicename(this.getCurrentConnectedDevice().getDeviceName());
                if (!this.isTraceEnabled()) continue;
                this.getTarget().trace().append("SmartPhoneIntegration.GlobalProperyAccessor").append(".updateCurrentConnectedDeviceNameForAppAdapter(").append(i2 + 1).append(" of ").append(this.adapterList.size()).append(")").log();
                continue;
            }
            if (!this.isTraceEnabled()) continue;
            this.getTarget().trace().append("SmartPhoneIntegration.GlobalProperyAccessor").append(".updateCurrentConnectedDeviceNameForAppAdapter(not registered)").log();
        }
    }

    public void updateCurrentConnectionMethodForAppAdapter() {
        for (int i2 = 0; i2 < this.adapterList.size(); ++i2) {
            if (this.getAppAdapterInterface(i2) != null) {
                this.getAppAdapterInterface(i2).updateConnectionMethod(this.getCurrentConnectedDevice().getLastConnectionMethod());
                if (!this.isTraceEnabled()) continue;
                this.getTarget().trace().append("SmartPhoneIntegration.GlobalProperyAccessor").append(".updateCurrentConnectionMethodForAppAdapter(").append(i2 + 1).append(" of ").append(this.adapterList.size()).append(")").log();
                continue;
            }
            if (!this.isTraceEnabled()) continue;
            this.getTarget().trace().append("SmartPhoneIntegration.GlobalProperyAccessor").append(".updateCurrentConnectionMethodForAppAdapter(not registered)").log();
        }
    }

    public void updateSWapStateChangeForAppAdapter(FeatureSupport featureSupport, boolean bl) {
        for (int i2 = 0; i2 < this.adapterList.size(); ++i2) {
            if (this.getAppAdapterInterface(i2) == null) continue;
            this.getAppAdapterInterface(i2).isSwapStateUpdated(featureSupport.getGal().isSwap(), featureSupport.getMirrorlink().isSwap(), featureSupport.getCarplay().isSwap(), bl);
            if (!this.isTraceEnabled()) continue;
            this.getTarget().trace().append("SmartPhoneIntegration.GlobalProperyAccessor").append(".updateSWapStateChangeForAppAdapter(").append(i2 + 1).append(" of ").append(this.adapterList.size()).append(")").log();
        }
    }

    public void resetCurrentConnectionMethodForAppAdapter() {
        for (int i2 = 0; i2 < this.adapterList.size(); ++i2) {
            if (this.getAppAdapterInterface(i2) != null) {
                this.getAppAdapterInterface(i2).updateConnectionMethod(0);
                continue;
            }
            if (!this.isTraceEnabled()) continue;
            this.getTarget().trace().append("SmartPhoneIntegration.GlobalProperyAccessor").append(".updateCurrentConnectionMethodForAppAdapter(not registered)").log();
        }
    }

    public boolean isSwapStateWasAlreadyUpdated() {
        return this.swapStateWasAlreadyUpdated;
    }

    public void setSwapStateWasAlreadyUpdated(boolean bl) {
        this.swapStateWasAlreadyUpdated = bl;
    }

    public void setLastConnectionMethod(DeviceASLExtended deviceASLExtended, int n) {
        deviceASLExtended.setLastConnectionMethod(n);
        if (this.getTarget() != null && this.getTarget().getASLHandler() != null) {
            this.getTarget().getASLHandler().updateExlapServerData(true);
            for (int i2 = 0; i2 < this.getAdapterList().size(); ++i2) {
                if (this.getAppAdapterInterface(i2) != null) {
                    this.getAppAdapterInterface(i2).updateConnectionMethod(deviceASLExtended.getLastConnectionMethod());
                }
                if (!this.getTarget().isTraceEnabled()) continue;
                if (n == 9) {
                    this.getTarget().trace().append("!!!!!!!!!!!!SmartPhoneIntegration.GlobalProperyAccessor").append(".setLastconnectionmode( 9 )!!!!!!!!!!!!!!!!!!!!!!!!!!! ").log();
                    continue;
                }
                this.getTarget().trace().append("SmartPhoneIntegration.GlobalProperyAccessor").append(new StringBuffer().append(".setLastconnectionmode( ").append(n).append(" )").toString()).log();
            }
        }
    }

    public int getListIndex(DeviceASLExtended deviceASLExtended) {
        if (deviceASLExtended != null && this.getDsiDevicelistASLExtended() != null) {
            DeviceASLExtended[] deviceASLExtendedArray = this.getDsiDevicelistASLExtended();
            for (int i2 = 0; i2 < deviceASLExtendedArray.length; ++i2) {
                if (deviceASLExtended.getDeviceID() != deviceASLExtendedArray[i2].getDeviceID()) continue;
                return i2;
            }
        }
        return -1;
    }
}

