/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.smartphoneintegration.target;

import de.vw.mib.asl.api.speechengine.messenger.indicator.IndicatorStateConsumer;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.smartphoneintegration.common.DeviceASLExtended;
import de.vw.mib.asl.internal.smartphoneintegration.common.FeatureSupport;
import de.vw.mib.asl.internal.smartphoneintegration.common.SmartPhoneIntegrationGlobalProperyAccessor;
import de.vw.mib.asl.internal.smartphoneintegration.common.SmartPhoneIntegrationHelper;
import de.vw.mib.asl.internal.smartphoneintegration.common.TimerUtil;
import de.vw.mib.asl.internal.smartphoneintegration.target.ASLHandler$1;
import de.vw.mib.asl.internal.smartphoneintegration.target.ASLHandler$1TechnologySupport;
import de.vw.mib.asl.internal.smartphoneintegration.target.ASLHandler$2;
import de.vw.mib.asl.internal.smartphoneintegration.target.ASLHandler$3;
import de.vw.mib.asl.internal.smartphoneintegration.target.HsmTarget;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.has.HAS;
import de.vw.mib.has.HASContext;
import de.vw.mib.has.HASEngineAPI;
import de.vw.mib.has.HASFactory;
import generated.de.vw.mib.has.containers.AppConnectDeviceContainer;
import generated.de.vw.mib.has.contexts.appconnect.AppConnectProperties;
import org.dsi.ifc.smartphoneintegration.Device;
import org.osgi.util.tracker.ServiceTracker;
import org.osgi.util.tracker.ServiceTrackerCustomizer;

public class ASLHandler {
    public String classname = "SmartPhoneIntegration.ASLHandler";
    private HsmTarget target;
    HASEngineAPI engineHAS;
    HASContext context;
    AppConnectProperties hasProperties;
    HASFactory factory;
    AppConnectDeviceContainer appConnectDeviceContainer;
    IndicatorStateConsumer indicatorStateConsumer = new ASLHandler$1(this);
    static /* synthetic */ Class class$de$vw$mib$asl$api$speechengine$SpeechEngine;

    public ASLHandler(HsmTarget hsmTarget) {
        this.target = hsmTarget;
        this.engineHAS = HAS.getInstance().getEngine();
        this.context = this.engineHAS.getRegistry().getContextByName("AppConnect");
        this.context.setServicesImpl(new ASLHandler$2(this));
        this.hasProperties = (AppConnectProperties)this.context.getPropertiesImpl();
        this.factory = HAS.getInstance().getFactory();
        this.appConnectDeviceContainer = (AppConnectDeviceContainer)this.factory.createContainer(64);
        this.updateExlapServerData(true);
        ServiceTracker serviceTracker = new ServiceTracker(ServiceManager.bundleContext, (class$de$vw$mib$asl$api$speechengine$SpeechEngine == null ? (class$de$vw$mib$asl$api$speechengine$SpeechEngine = ASLHandler.class$("de.vw.mib.asl.api.speechengine.SpeechEngine")) : class$de$vw$mib$asl$api$speechengine$SpeechEngine).getName(), (ServiceTrackerCustomizer)new ASLHandler$3(this));
        serviceTracker.open();
    }

    private SmartPhoneIntegrationGlobalProperyAccessor getGlobalProperties() {
        return SmartPhoneIntegrationGlobalProperyAccessor.getInstance();
    }

    private HsmTarget getTarget() {
        return this.target;
    }

    public void handleAslApiSelectDeviceList(int n, int n2) {
        if (this.getTarget().isTraceEnabled()) {
            this.getTarget().trace().append(this.classname).append(".handleAslApiSelectDeviceList(").append(n).append(", ").append(n2).append(")").log();
            this.getTarget().trace().append(this.classname).append(".handleAslApiSelectDeviceList( DIAG/SWAP states: ").append(this.getGlobalProperties().getFeatureSupport().toString()).append(")").log();
        }
        if (this.getGlobalProperties().getDsiDevicelistASLExtended() != null && n >= 0 && n < this.getGlobalProperties().getDsiDevicelistASLExtended().length) {
            int n3 = -1;
            this.getGlobalProperties().setCurrentSelectedDevice(n);
            this.getGlobalProperties().getCurrentSelectedDevice().setSelectedConnectionMethod(n2);
            if (this.getTarget().isTraceEnabled()) {
                this.getTarget().trace().append(this.classname).append(".setSelectedConnectionMethod(").append(n2).append(")").log();
            }
            int n4 = this.getGlobalProperties().getCurrentConnectionState();
            super.getClass();
            if (n4 == 5 && this.getGlobalProperties().getCurrentConnectedDevice() != null) {
                n3 = this.getGlobalProperties().getListIndex(this.getGlobalProperties().getCurrentConnectedDevice());
            }
            if (this.getTarget().isTraceEnabled()) {
                this.getTarget().trace().append(this.classname).append(".handleAslApiSelectDeviceList( connectionstate: ").append(this.getGlobalProperties().getCurrentConnectionState()).append(" , conn device index , listindex=").append(n3).append(" , ").append(new StringBuffer().append(n).append(")").toString()).log();
            }
            int n5 = this.getGlobalProperties().getCurrentConnectionState();
            super.getClass();
            if (n5 == 5) {
                if (this.getGlobalProperties().getCurrentConnectedDevice() != null && this.getGlobalProperties().getCurrentSelectedDevice() != null) {
                    this.getTarget().getDSISmartphoneIntegration().disconnectDevice(this.getGlobalProperties().getCurrentConnectedDevice().getDeviceID());
                    this.target.getASLHandler().setDeviceListAccessibility(false);
                    if (this.getTarget().isTraceEnabled()) {
                        this.getTarget().trace().append(this.classname).append(".disconnect by device was selected while another device is currently connected) ").log();
                    }
                }
                this.getGlobalProperties().setConnectionSwitchActive(true);
            } else {
                this.handleAslApiSelectDeviceListConnecting();
            }
        } else if (this.getTarget().isTraceEnabled()) {
            this.getTarget().trace().append(this.classname).append(new StringBuffer().append(".handleAslApiSelectDeviceList( listindex out of range: ").append(n).append(" )").toString()).log();
        }
    }

    public void handleAslApiSelectDeviceListConnecting() {
        this.connectionHandlingNewDevice(this.getGlobalProperties().getCurrentSelectedDevice(), true, false);
        if (this.getTarget().isTraceEnabled()) {
            this.getTarget().trace().append(this.classname).append(".handleAslApiSelectDeviceListConnecting( ").append(this.getGlobalProperties().getListIndex(this.getGlobalProperties().getCurrentSelectedDevice())).append(", Listlength: ").append(this.getGlobalProperties().getDsiDevicelistASLExtended().length).append("->lastconnecteddevice == null").log();
        }
    }

    public void connectionHandlingNewDevice(DeviceASLExtended deviceASLExtended, boolean bl, boolean bl2) {
        if (this.getTarget().isTraceEnabled()) {
            this.getTarget().trace().append(this.classname).append(".connectionHandlingNewDevice( ").append(deviceASLExtended.getDeviceName()).append(" , userconfirm:  ").append(bl).append(" , autoconnect:  ").append(bl2).append(")").log();
        }
        if (deviceASLExtended.getSelectedConnectionMethod() == -1) {
            if (SmartPhoneIntegrationHelper.isConnectionMethodSupported(deviceASLExtended.getConnectionMethod(), 2)) {
                this.connectionHandlingNewDeviceCarPlayVerified(deviceASLExtended, bl);
            } else if (SmartPhoneIntegrationHelper.isConnectionMethodSupported(deviceASLExtended.getConnectionMethod(), 4)) {
                this.connectionHandlingNewDeviceCarPlayVerified(deviceASLExtended, bl);
            }
        } else if (SmartPhoneIntegrationHelper.isAppleDevice(deviceASLExtended)) {
            if (deviceASLExtended.getSelectedConnectionMethod() == 32) {
                this.connectionHandlingNewDeviceCarLifeIOS(deviceASLExtended);
            } else if (SmartPhoneIntegrationHelper.isConnectionMethodSupported(deviceASLExtended.getConnectionMethod(), 4)) {
                this.connectionHandlingNewDeviceCarPlayVerified(deviceASLExtended, bl);
            } else if (SmartPhoneIntegrationHelper.isConnectionMethodSupported(deviceASLExtended.getConnectionMethod(), 2)) {
                this.connectionHandlingNewDeviceCarplayVerification(deviceASLExtended, bl);
            }
        } else {
            this.connectionHandlingNewDeviceNotCarplay(deviceASLExtended, bl2);
        }
    }

    private void connectionHandlingNewDeviceCarLifeIOS(DeviceASLExtended deviceASLExtended) {
        FeatureSupport featureSupport = this.getGlobalProperties().getFeatureSupport();
        if (featureSupport.getCarlifeIOS().isSupported()) {
            this.getGlobalProperties().resetDsiConnectionState();
            Device device = deviceASLExtended.getDsiDevice();
            super.getClass();
            this.connectDevice(device, 32, 1);
        } else if (!this.getGlobalProperties().getFeatureSupport().getCarlifeIOS().isCoded()) {
            this.updateConnectionFailedPopupPropertiesToModel(32);
        } else {
            this.triggerModelPopupSWaPNotSupported(4);
        }
    }

    private void connectionHandlingNewDeviceCarPlayVerified(DeviceASLExtended deviceASLExtended, boolean bl) {
        if (this.getTarget().isTraceEnabled()) {
            this.getTarget().trace().append(this.classname).append(".connectionHandlingNewDevice( CARPLAY-").append(deviceASLExtended.getDeviceName()).append(", connectionmode:  CONNECTIONMETHOD_CARPLAYVERIFIED").append(")").log();
        }
        if (this.getGlobalProperties().getFeatureSupport().getCarplay().isSupported()) {
            if (bl) {
                this.getGlobalProperties().resetDsiConnectionState();
                Device device = deviceASLExtended.getDsiDevice();
                super.getClass();
                this.connectDevice(device, 4, 1);
            } else {
                this.getGlobalProperties().setCurrentSelectedDevice(deviceASLExtended);
                if (!this.getGlobalProperties().isInternalHFPorOCUCallActive()) {
                    this.requestNewDeviceDetectedPopup();
                    if (SmartPhoneIntegrationHelper.numberOfTechnologySupportedDevices(4, this.getGlobalProperties().getDsiDevicelistASLExtended()) > 1) {
                        for (int i2 = 0; i2 < this.getGlobalProperties().getDsiDevicelistASLExtended().length; ++i2) {
                            if (deviceASLExtended.getDeviceAddress().equalsIgnoreCase(this.getGlobalProperties().getDsiDevicelistASLExtended()[i2].getDeviceAddress())) continue;
                            this.target.getDSISmartphoneIntegration().disconnectDevice(this.getGlobalProperties().getDsiDevicelistASLExtended()[i2].getDeviceID());
                        }
                    }
                } else {
                    ServiceManager.eventDispatcher.createAndSubmitHMIEvent(1114057728);
                    this.getGlobalProperties().handleConnectionRequestDuringOCUOrHfpCall(deviceASLExtended.getDsiDevice(), -1, true);
                }
            }
        } else {
            if (this.getTarget().isTraceEnabled()) {
                this.getTarget().trace().append(this.classname).append(".connectionHandlingNewDevice( CARPLAY SWAP/DIAG DISABLED-").append(")").log();
            }
            if (!this.getGlobalProperties().getFeatureSupport().getCarplay().isCoded()) {
                this.updateConnectionFailedPopupPropertiesToModel(2);
            } else {
                this.triggerModelPopupSWaPNotSupported(2);
            }
        }
    }

    public void requestNewDeviceDetectedPopup() {
        int n = 1097280512;
        if (this.getGlobalProperties().getFeatureSupport().getCarlifeIOS().isSupported()) {
            n = 1315384320;
        }
        ServiceManager.eventDispatcher.createAndSubmitHMIEvent(n);
    }

    private void connectionHandlingNewDeviceCarplayVerification(DeviceASLExtended deviceASLExtended, boolean bl) {
        if (this.getGlobalProperties().getFeatureSupport().getCarplay().isSupported()) {
            if (this.getTarget().isTraceEnabled()) {
                this.getTarget().trace().append(this.classname).append(".connectionHandlingNewDeviceCarplayVerification(").append(deviceASLExtended.getDeviceName()).append(", connectionmode:  CONNECTIONMETHOD_CARPLAY ->conn check").append(")").log();
            }
            this.getGlobalProperties().resetDsiConnectionState();
            if (bl) {
                Device device = deviceASLExtended.getDsiDevice();
                super.getClass();
                this.connectDevice(device, 4, 1);
            } else {
                this.getTarget().getDSISmartphoneIntegration().connectDevice(deviceASLExtended.getDeviceID(), 2);
                this.updateConnectionPopupPropertiesToModel(deviceASLExtended.getDsiDevice(), 2);
            }
        } else {
            if (this.getTarget().isTraceEnabled()) {
                this.getTarget().trace().append(this.classname).append(".connectionHandlingNewDeviceCarplayVerification( CARPLAY SWAP/DIAG DISABLED-").append(")").log();
            }
            if (!this.getGlobalProperties().getFeatureSupport().getCarplay().isCoded()) {
                this.updateConnectionFailedPopupPropertiesToModel(2);
            } else {
                this.triggerModelPopupSWaPNotSupported(2);
            }
        }
    }

    private void connectionHandlingNewDeviceNotCarplay(DeviceASLExtended deviceASLExtended, boolean bl) {
        ASLHandler$1TechnologySupport aSLHandler$1TechnologySupport = new ASLHandler$1TechnologySupport(this);
        ASLHandler$1TechnologySupport aSLHandler$1TechnologySupport2 = new ASLHandler$1TechnologySupport(this);
        ASLHandler$1TechnologySupport aSLHandler$1TechnologySupport3 = new ASLHandler$1TechnologySupport(this);
        int n = deviceASLExtended.getSelectedConnectionMethod();
        FeatureSupport featureSupport = this.getGlobalProperties().getFeatureSupport();
        if (this.getTarget().isTraceEnabled()) {
            this.getTarget().trace().append(this.classname).append(".connectionHandlingNewDeviceNotCarplay( ").append(")").log();
        }
        aSLHandler$1TechnologySupport.setHardwareSupport(SmartPhoneIntegrationHelper.isConnectionMethodSupported(deviceASLExtended.getConnectionMethod(), 8));
        if (aSLHandler$1TechnologySupport.isSupportedByHardware()) {
            aSLHandler$1TechnologySupport.setSoftwareSupport(featureSupport.getGal().isSupported());
        }
        aSLHandler$1TechnologySupport2.setHardwareSupport(SmartPhoneIntegrationHelper.isConnectionMethodSupported(deviceASLExtended.getConnectionMethod(), 1));
        if (aSLHandler$1TechnologySupport2.isSupportedByHardware()) {
            aSLHandler$1TechnologySupport2.setSoftwareSupport(featureSupport.getMirrorlink().isSupported());
        }
        aSLHandler$1TechnologySupport3.setHardwareSupport(SmartPhoneIntegrationHelper.isConnectionMethodSupported(deviceASLExtended.getConnectionMethod(), 32));
        if (aSLHandler$1TechnologySupport3.isSupportedByHardware()) {
            aSLHandler$1TechnologySupport3.setSoftwareSupport(featureSupport.getCarlifeAndroid().isSupported());
        }
        if (bl) {
            if (n == 32) {
                if (this.getTarget().isTraceEnabled()) {
                    this.getTarget().trace().append(this.classname).append(".connectionHandlingNewDeviceNotCarplay( CL AUTOCONNECT OF NEW DEVICES NOT SUPPORTED: ").append(aSLHandler$1TechnologySupport2.isSupportedBySoftware()).append(" ,  ").append(aSLHandler$1TechnologySupport.isSupportedBySoftware()).append(" ,  ").append(aSLHandler$1TechnologySupport3.isSupportedBySoftware()).append(")").log();
                }
            } else if (this.getTarget().isTraceEnabled()) {
                this.getTarget().trace().append(this.classname).append(".connectionHandlingNewDeviceNotCarplay( ML/GAL AUTOCONNECT OF NEW DEVICES NOT SUPPORTED: ").append(aSLHandler$1TechnologySupport2.isSupportedBySoftware()).append(" ,  ").append(aSLHandler$1TechnologySupport.isSupportedBySoftware()).append(" ,  ").append(aSLHandler$1TechnologySupport3.isSupportedBySoftware()).append(")").log();
            }
        } else {
            if (this.getTarget().isTraceEnabled()) {
                this.getTarget().trace().append(this.classname).append(".connectionHandlingNewDeviceNotCarplay on manually selection( GAL/ML/CL -").append(deviceASLExtended.getDeviceName()).append(", connectionmethod:  ").append(n).append("))").log();
            }
            if (n == 8 && !aSLHandler$1TechnologySupport.isSupportedBySoftware() || n == 1 && !aSLHandler$1TechnologySupport2.isSupportedBySoftware() || n == 32 && !aSLHandler$1TechnologySupport3.isSupportedBySoftware()) {
                super.getClass();
                n = -1;
            }
            super.getClass();
            if (n != -1) {
                this.getGlobalProperties().resetDsiConnectionState();
                Device device = deviceASLExtended.getDsiDevice();
                super.getClass();
                this.connectDevice(device, n, 1);
                if (this.getTarget().isTraceEnabled()) {
                    this.getTarget().trace().append(this.classname).append(".connectionHandlingNewDeviceNotCarplay( dsi connect started for new unknown device with prefered technology").log();
                }
            } else {
                if (this.getTarget().isTraceEnabled()) {
                    this.getTarget().trace().append(this.classname).append(".connectionHandlingNewDeviceNotCarplay(").append(" GAL Support - ").append("HW :").append(aSLHandler$1TechnologySupport.isSupportedByHardware()).append(", SW :").append(aSLHandler$1TechnologySupport.isSupportedBySoftware()).append(" ML Support - ").append("HW :").append(aSLHandler$1TechnologySupport2.isSupportedByHardware()).append(", SW :").append(aSLHandler$1TechnologySupport2.isSupportedBySoftware()).append(" CL Support - ").append("HW :").append(aSLHandler$1TechnologySupport3.isSupportedByHardware()).append(", SW :").append(aSLHandler$1TechnologySupport3.isSupportedBySoftware()).log();
                }
                if (featureSupport.getGal().isCoded()) {
                    if (!featureSupport.getGal().isSwap() && !featureSupport.getMirrorlink().isSwap()) {
                        ServiceManager.eventDispatcher.createAndSubmitHMIEvent(895953920);
                    } else if (featureSupport.getGal().isSwap() && !featureSupport.getMirrorlink().isSwap()) {
                        ServiceManager.eventDispatcher.createAndSubmitHMIEvent(895953920);
                    } else if (!featureSupport.getGal().isSwap() && featureSupport.getMirrorlink().isSwap()) {
                        ServiceManager.eventDispatcher.createAndSubmitHMIEvent(895953920);
                    }
                } else {
                    ServiceManager.eventDispatcher.createAndSubmitHMIEvent(895953920);
                }
            }
        }
    }

    private void triggerModelPopupSWaPNotSupported(int n) {
        ServiceManager.aslPropertyManager.valueChangedInteger(1181166592, n);
        ServiceManager.eventDispatcher.createAndSubmitHMIEvent(1130834944);
    }

    public void updateConnectionFailedPopupPropertiesToModel(int n) {
        ServiceManager.aslPropertyManager.valueChangedInteger(1214721024, SmartPhoneIntegrationHelper.convertConnectionMethod(n));
        ServiceManager.eventDispatcher.createAndSubmitHMIEvent(929508352);
    }

    public void updateConnectingPopUpPropertiesAndEventsToModel(Device device, int n) {
        if (this.getTarget().isTraceEnabled()) {
            this.getTarget().trace().append(this.classname).append(".updateConnectionProcessPropertiesToModel(").append(device.getDeviceName()).append(" , ").append(n).append(" )").log();
        }
        this.updateConnectionPopupPropertiesToModel(device, n);
        ServiceManager.eventDispatcher.createAndSubmitHMIEvent(879176704);
    }

    public void updateConnectionPopupPropertiesToModel(Device device, int n) {
        ServiceManager.aslPropertyManager.valueChangedString(1147612160, device.getDeviceName());
        ServiceManager.aslPropertyManager.valueChangedInteger(1130834944, SmartPhoneIntegrationHelper.convertConnectionMethod(n));
    }

    public void handleAslApiSetInitialConnectionType(int n) {
        if (this.getTarget().isTraceEnabled()) {
            this.getTarget().trace().append(this.classname).append(".handleAslApiSetInitialConnectionType(").append(n).append(" )").log();
        }
        this.getTarget().getPersistence().setInitialConnectionType(n);
        ServiceManager.aslPropertyManager.valueChangedInteger(1164389376, n);
        if (this.getTarget().isTraceEnabled()) {
            this.getTarget().trace().append(this.classname).append(".handleAslApiSetInitialConnectionType(response to model ").append(n).append(" )").log();
        }
    }

    /*
     * Unable to fully structure code
     */
    public void updateExlapServerData(boolean var1_1) {
        this.appConnectDeviceContainer.setAvailable(var1_1);
        var2_2 = this.getGlobalProperties().getCurrentConnectedDevice();
        var3_3 = this.getGlobalProperties().getCurrentConnectionState();
        if (!var1_1 || var2_2 == null) ** GOTO lbl-1000
        super.getClass();
        if (var3_3 == 5) {
            var4_4 = "APP_CONNECT_DEVICE_TYPE__UNKNOWN";
            switch (var2_2.getLastConnectionMethod()) {
                case 2: {
                    this.appConnectDeviceContainer.setType(2);
                    var4_4 = "APP_CONNECT_DEVICE_TYPE__CAR_PLAY";
                    break;
                }
                case 4: {
                    this.appConnectDeviceContainer.setType(2);
                    var4_4 = "APP_CONNECT_DEVICE_TYPE__CAR_PLAY";
                    break;
                }
                case 8: {
                    this.appConnectDeviceContainer.setType(3);
                    var4_4 = "APP_CONNECT_DEVICE_TYPE__CAR_GAL";
                    break;
                }
                case 1: {
                    this.appConnectDeviceContainer.setType(1);
                    var4_4 = "APP_CONNECT_DEVICE_TYPE__MIRROR_LINK";
                    break;
                }
                case 32: {
                    this.appConnectDeviceContainer.setType(4);
                    var4_4 = "APP_CONNECT_DEVICE_TYPE_CARLIFE";
                    break;
                }
                default: {
                    this.appConnectDeviceContainer.setType(4);
                    var4_4 = "APP_CONNECT_DEVICE_TYPE__UNKNOWN";
                }
            }
            if (this.getTarget().isTraceEnabled()) {
                this.getTarget().trace().append(this.classname).append(".updateExlapServerData( setDeviceName:").append(var2_2.getDeviceName()).append(" , setElementId: ").append(var2_2.getDeviceID()).append(" , setType: ").append(var4_4).append(" , setAvailable: ").append(var1_1).append(" , setEntertainmentActive: ").append(this.getGlobalProperties().isEntertainmentActive()).append(" )").log();
            }
            this.appConnectDeviceContainer.setDeviceName(var2_2.getDeviceName());
            this.appConnectDeviceContainer.setElementId(var2_2.getDeviceID());
            this.appConnectDeviceContainer.setEntertainmentActive(this.getGlobalProperties().isEntertainmentActive());
        } else lbl-1000:
        // 2 sources

        {
            if (this.getTarget().isTraceEnabled()) {
                this.getTarget().trace().append(this.classname).append(".updateExlapServerData( setDeviceName:   ").append(" , setElementId: -1").append(" , setType: APP_CONNECT_DEVICE_TYPE__NOT_CONNECTED ").append(" , setAvailable: ").append(var1_1).append(" , setEntertainmentActive: ").append(this.getGlobalProperties().isEntertainmentActive()).append(" )").log();
            }
            this.appConnectDeviceContainer.setType(0);
            this.appConnectDeviceContainer.setEntertainmentActive(this.getGlobalProperties().isEntertainmentActive());
        }
        this.hasProperties.updateAppConnectDevice(this.appConnectDeviceContainer);
    }

    public void setDeviceListAccessibility(boolean bl) {
        if (!bl) {
            TimerUtil.startTimer(this.target, -1467612928, 30000);
        } else {
            TimerUtil.stopTimer(this.target, -1467612928);
        }
        ServiceManager.aslPropertyManager.valueChangedBoolean(1080503296, bl);
    }

    public void handleReconnectOCUDisconnectedDevice(DeviceASLExtended deviceASLExtended) {
        if (this.getTarget().isTraceEnabled()) {
            this.getTarget().trace().append(this.classname).append(".handleReconnectOCUDisconnectedDEvice( ").append(deviceASLExtended.toString()).append(" , lastconn method: ").append(deviceASLExtended.getLastConnectionMethod()).append(" )").log();
        }
        if (SmartPhoneIntegrationHelper.getDeviceFromId(deviceASLExtended.getDeviceID()) != null) {
            this.getGlobalProperties().resetDsiConnectionState();
            this.getTarget().getDSISmartphoneIntegration().connectDevice(this.getGlobalProperties().getLastOCUDisconnectedDevice().getDeviceID(), this.getGlobalProperties().getLastOCUDisconnectedDevice().getLastConnectionMethod());
        }
    }

    public void handleClampSSwitch(EventGeneric eventGeneric) {
        if (this.getTarget().isTraceEnabled()) {
            this.getTarget().trace().append(this.classname).append(new StringBuffer().append(".handle(ASL_SYSTEM_POWERMANAGEMENT_CLAMPSTATE_S) =").append(eventGeneric.getBoolean(0)).toString()).log();
        }
        if (!eventGeneric.getBoolean(0)) {
            if (this.getGlobalProperties().getCurrentConnectedDevice().getLastConnectionMethod() == 8) {
                this.getTarget().getDSISmartphoneIntegration().disconnectDevice(this.getGlobalProperties().getCurrentConnectedDevice().getDeviceID());
                this.getGlobalProperties().setClampSOffDisconnectedDevice(this.getGlobalProperties().getCurrentConnectedDevice().getDsiDevice());
                if (this.getTarget().isTraceEnabled()) {
                    this.getTarget().trace().append(this.classname).append(".disconnect triggered by ASL_SYSTEM_POWERMANAGEMENT_CLAMPSTATE_S_P0_IS_SET_BOOLEAN)").log();
                }
            } else if (this.getTarget().isTraceEnabled()) {
                this.getTarget().trace().append(this.classname).append(".disconnect not triggered by ASL_SYSTEM_POWERMANAGEMENT_CLAMPSTATE_S_P0_IS_SET_BOOLEAN because current techno is not AA)").log();
            }
            this.getGlobalProperties().setDsiDevicelist(null);
        } else {
            Device device;
            if (this.getTarget().isTraceEnabled()) {
                this.getTarget().trace().append(this.classname).append(".reconnect triggered by ASL_SYSTEM_POWERMANAGEMENT_CLAMPSTATE_S_P0_IS_SET_BOOLEAN = true)").log();
            }
            if ((device = this.getGlobalProperties().getClampSOffDisconnectedDevice()) != null && SmartPhoneIntegrationHelper.listContainsDeviceWithAddress(this.getGlobalProperties().getDsiDevicelistASLExtended(), device.getDeviceAddress())) {
                if (this.getTarget().isTraceEnabled()) {
                    this.getTarget().trace().append(this.classname).append(".reconnect triggered by ASL_SYSTEM_POWERMANAGEMENT_CLAMPSTATE_S_P0_IS_SET_BOOLEAN = true)").log();
                }
                this.getGlobalProperties().resetDsiConnectionState();
                this.getTarget().getDSISmartphoneIntegration().connectDevice(device.getDeviceID(), 8);
                this.getGlobalProperties().resetClampSOffDisconnectedDevice();
            }
        }
    }

    public void connectDevice(Device device, int n, int n2) {
        this.getTarget().getDSISmartphoneIntegration().connectDevice(device.getDeviceID(), n);
        this.getGlobalProperties().setCurrentConnectionState(n2);
        this.getGlobalProperties().resetClampSOffDisconnectedDevice();
        this.getGlobalProperties().setPreConnectedDevice(device);
        this.updateConnectingPopUpPropertiesAndEventsToModel(device, n);
    }

    static /* synthetic */ HsmTarget access$000(ASLHandler aSLHandler) {
        return aSLHandler.getTarget();
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

