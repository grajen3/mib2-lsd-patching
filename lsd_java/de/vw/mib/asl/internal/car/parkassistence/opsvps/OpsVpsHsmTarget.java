/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.car.parkassistence.opsvps;

import de.vw.mib.asl.api.system.ASLSystemFactory;
import de.vw.mib.asl.api.system.factoryreset.FactoryResetComponents;
import de.vw.mib.asl.api.system.factoryreset.FactoryResetListener;
import de.vw.mib.asl.api.system.factoryreset.FactoryResetService;
import de.vw.mib.asl.framework.api.diagnosis.AdaptionResponse;
import de.vw.mib.asl.framework.api.dsiproxy.DSIProxy;
import de.vw.mib.asl.framework.api.dsiproxy.DSIServiceStateListener;
import de.vw.mib.asl.framework.api.framework.ASLFrameworkFactory;
import de.vw.mib.asl.framework.internal.framework.AbstractASLHsmTarget;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.car.ASLCarContainer;
import de.vw.mib.asl.internal.car.parkassistence.opsvps.OpsVpsMapTable;
import de.vw.mib.asl.internal.car.parkassistence.opsvps.ResetParkingParticipant;
import de.vw.mib.asl.internal.car.parkassistence.opsvps.states.StatePopupOff;
import de.vw.mib.asl.internal.car.parkassistence.opsvps.states.StatePopupOn;
import de.vw.mib.asl.internal.car.parkassistence.opsvps.states.StatePopupOnOffroad;
import de.vw.mib.asl.internal.car.parkassistence.opsvps.states.StatePopupOnOps;
import de.vw.mib.asl.internal.car.parkassistence.opsvps.states.StatePopupOnOpsAuto;
import de.vw.mib.asl.internal.car.parkassistence.opsvps.states.StatePopupOnOpsVps;
import de.vw.mib.asl.internal.car.parkassistence.opsvps.states.StatePopupOnVps;
import de.vw.mib.asl.internal.car.parkassistence.opsvps.states.StatePopupSettings;
import de.vw.mib.asl.internal.car.parkassistence.opsvps.states.StateWaitConfirmationToClose;
import de.vw.mib.asl.internal.car.parkassistence.opsvps.states.StateWaitConfirmationToShow;
import de.vw.mib.genericevents.GenericEvents;
import de.vw.mib.genericevents.hsm.HsmState;
import generated.de.vw.mib.asl.internal.ListManager;
import generated.de.vw.mib.asl.internal.car.parkassistence.transformer.CarParkAssistenceDisplayContentCollector;
import org.dsi.ifc.audio.DSISound;
import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.carcomfort.DSICarComfort;
import org.dsi.ifc.cardriverassistance.DSICarDriverAssistance;
import org.dsi.ifc.cardriverassistance.DSICarDriverAssistanceListener;
import org.dsi.ifc.carparkingsystem.DSICarParkingSystem;
import org.dsi.ifc.carparkingsystem.DSICarParkingSystemListener;
import org.dsi.ifc.carparkingsystem.DisplayContent;
import org.dsi.ifc.generalvehiclestates.DSIGeneralVehicleStates;
import org.dsi.ifc.powermanagement.DSIPowerManagement;

public class OpsVpsHsmTarget
extends AbstractASLHsmTarget
implements DSIServiceStateListener,
FactoryResetListener {
    public static final int CONFIG_DATA;
    public HsmState statePopupOff;
    public HsmState stateWaitConfirmationToShow;
    public HsmState stateWaitConfirmationToClose;
    public StatePopupOn statePopupOn;
    public HsmState statePopupOnOpsAuto;
    public HsmState statePopupOnOps;
    public HsmState statePopupOnOpsVps;
    public HsmState statePopupOnVps;
    public HsmState statePopupOnOffroad;
    public HsmState statePopupOnSettings;
    private CarParkAssistenceDisplayContentCollector displayContentCollector;
    private CarParkAssistenceDisplayContentCollector[] displayContentCollectorArray;
    private DSICarParkingSystem dsiOpsVps;
    private DSICarParkingSystemListener dsiOpsVpsListener;
    private DSIPowerManagement dsiPowerManagement;
    public boolean isQueuedUp;
    private DSISound dsiSound;
    private DSICarComfort dsiCarComfort;
    private boolean pdcFailureNotificationDone;
    protected boolean vpsFailureActive;
    protected boolean pdcFailureActive;
    private DSICarDriverAssistance dsiAssist;
    private DSICarDriverAssistanceListener dsiAssistListener;
    private boolean pdcSystemOnOff;
    private boolean isRvcLowCoded;
    private boolean clamp15On;
    private DisplayContent dsiDisplayContentReceived;
    private boolean isAreaViewExist;
    private boolean isEarlyRVC;
    private FactoryResetService resetFactory;
    private ResetParkingParticipant resetParticipant;
    private boolean resetIsDirty;
    boolean opsDSINotificationDone;
    private boolean pdcOffroadStatus;
    private boolean apsNotificationDone;
    private boolean isVPSVideoInfoSpeedTooHigh;
    private boolean isTrunkOpenVPS;
    private boolean isTrunkOpenPDC;
    private boolean isSpeedTooHigh;
    private boolean isLegalScreen;
    private boolean isSpecialCrafter;
    static /* synthetic */ Class class$org$dsi$ifc$powermanagement$DSIPowerManagement;
    static /* synthetic */ Class class$org$dsi$ifc$carparkingsystem$DSICarParkingSystem;
    static /* synthetic */ Class class$org$dsi$ifc$carparkingsystem$DSICarParkingSystemListener;
    static /* synthetic */ Class class$org$dsi$ifc$cardriverassistance$DSICarDriverAssistance;
    static /* synthetic */ Class class$org$dsi$ifc$cardriverassistance$DSICarDriverAssistanceListener;
    static /* synthetic */ Class class$org$dsi$ifc$audio$DSISound;
    static /* synthetic */ Class class$org$dsi$ifc$audio$DSISoundListener;
    static /* synthetic */ Class class$org$dsi$ifc$carcomfort$DSICarComfort;
    static /* synthetic */ Class class$org$dsi$ifc$generalvehiclestates$DSIGeneralVehicleStates;
    static /* synthetic */ Class class$org$dsi$ifc$powermanagement$DSIPowerManagementListener;
    static /* synthetic */ Class class$org$dsi$ifc$carcomfort$DSICarComfortListener;
    static /* synthetic */ Class class$org$dsi$ifc$generalvehiclestates$DSIGeneralVehicleStatesListener;

    public OpsVpsHsmTarget(GenericEvents genericEvents, String string) {
        super(genericEvents, string);
        this.statePopupOff = new StatePopupOff(this, this.hsm, "StatePopupOff", this.getWorkStateParent());
        this.stateWaitConfirmationToShow = new StateWaitConfirmationToShow(this, this.hsm, "StateWaitConfirmationToShow", this.statePopupOff);
        this.stateWaitConfirmationToClose = new StateWaitConfirmationToClose(this, this.hsm, "StateWaitConfirmationToClose", this.statePopupOff);
        this.statePopupOn = new StatePopupOn(this, this.hsm, "StatePopupOn", this.stateWaitConfirmationToShow);
        this.statePopupOnOpsAuto = new StatePopupOnOpsAuto(this, this.hsm, "StatePopupOnOpsAuto", this.statePopupOn);
        this.statePopupOnOps = new StatePopupOnOps(this, this.hsm, "StatePopupOnOps", this.statePopupOn);
        this.statePopupOnOpsVps = new StatePopupOnOpsVps(this, this.hsm, "StatePopupOnOpsVps", this.statePopupOn);
        this.statePopupOnVps = new StatePopupOnVps(this, this.hsm, "StatePopupOnVps", this.statePopupOn);
        this.statePopupOnOffroad = new StatePopupOnOffroad(this, this.hsm, "StatePopupOnOffroad", this.statePopupOn);
        this.statePopupOnSettings = new StatePopupSettings(this, this.hsm, "StatePopupSettings", this.statePopupOn);
        this.displayContentCollector = new CarParkAssistenceDisplayContentCollector();
        this.displayContentCollectorArray = new CarParkAssistenceDisplayContentCollector[]{this.displayContentCollector};
        this.dsiDisplayContentReceived = new DisplayContent();
        this.isEarlyRVC = true;
        if (this.isTraceEnabled()) {
            this.trace().append("OpsVps: ctor").log();
        }
    }

    @Override
    public int getDefaultTargetId() {
        return -2142301696;
    }

    @Override
    public int getSubClassifier() {
        return 1;
    }

    @Override
    protected HsmState getDefaultState() {
        return this.statePopupOff;
    }

    public void registerModelEvents() {
        this.addObservers(new int[]{0xC0C0040, 302776384, 319553600, 352926976, 0x40C0040, 51118144, 786496, 34340928, 84672576, 101449792, 151781440, 17563712, 1460404288, 185335872, 168558656, 135004224, -502529984, 701895424, 718672640, -166985664, -150208448, -32767936, 84738112, -15990720, 852032, 51183680, 34406464, 17629248, -502595520, 923598912, 906821696});
        this.resetFactory = ASLSystemFactory.getSystemApi().getFactoryResetService();
        this.resetParticipant = new ResetParkingParticipant(this);
        this.resetFactory.addParticipant(this.resetParticipant, FactoryResetComponents.CAR_PARKING_ASSISTANCE);
        this.resetFactory.addListener(this);
    }

    public void registerVPSSettingsModelEvents() {
        this.addObservers(new int[]{235667520, 252444736, 269221952, 285999168, -586416064, -569638848});
    }

    public void initDsi() {
        DSIProxy dSIProxy = ASLCarContainer.getInstance().getDSIProxy();
        this.dsiPowerManagement = (DSIPowerManagement)dSIProxy.getService(this, class$org$dsi$ifc$powermanagement$DSIPowerManagement == null ? (class$org$dsi$ifc$powermanagement$DSIPowerManagement = OpsVpsHsmTarget.class$("org.dsi.ifc.powermanagement.DSIPowerManagement")) : class$org$dsi$ifc$powermanagement$DSIPowerManagement);
        this.dsiOpsVps = (DSICarParkingSystem)dSIProxy.getService(this, class$org$dsi$ifc$carparkingsystem$DSICarParkingSystem == null ? (class$org$dsi$ifc$carparkingsystem$DSICarParkingSystem = OpsVpsHsmTarget.class$("org.dsi.ifc.carparkingsystem.DSICarParkingSystem")) : class$org$dsi$ifc$carparkingsystem$DSICarParkingSystem);
        this.dsiOpsVpsListener = (DSICarParkingSystemListener)ASLCarContainer.getInstance().getAdapterFactory().createDSIListenerMethodAdapter(this.getHsm(), class$org$dsi$ifc$carparkingsystem$DSICarParkingSystemListener == null ? (class$org$dsi$ifc$carparkingsystem$DSICarParkingSystemListener = OpsVpsHsmTarget.class$("org.dsi.ifc.carparkingsystem.DSICarParkingSystemListener")) : class$org$dsi$ifc$carparkingsystem$DSICarParkingSystemListener);
        this.dsiAssist = (DSICarDriverAssistance)dSIProxy.getService(this, class$org$dsi$ifc$cardriverassistance$DSICarDriverAssistance == null ? (class$org$dsi$ifc$cardriverassistance$DSICarDriverAssistance = OpsVpsHsmTarget.class$("org.dsi.ifc.cardriverassistance.DSICarDriverAssistance")) : class$org$dsi$ifc$cardriverassistance$DSICarDriverAssistance);
        this.dsiAssistListener = (DSICarDriverAssistanceListener)ASLCarContainer.getInstance().getAdapterFactory().createDSIListenerMethodAdapter(this.getHsm(), class$org$dsi$ifc$cardriverassistance$DSICarDriverAssistanceListener == null ? (class$org$dsi$ifc$cardriverassistance$DSICarDriverAssistanceListener = OpsVpsHsmTarget.class$("org.dsi.ifc.cardriverassistance.DSICarDriverAssistanceListener")) : class$org$dsi$ifc$cardriverassistance$DSICarDriverAssistanceListener);
        this.dsiSound = (DSISound)dSIProxy.getService(this, class$org$dsi$ifc$audio$DSISound == null ? (class$org$dsi$ifc$audio$DSISound = OpsVpsHsmTarget.class$("org.dsi.ifc.audio.DSISound")) : class$org$dsi$ifc$audio$DSISound);
        dSIProxy.addResponseListener(this, class$org$dsi$ifc$audio$DSISoundListener == null ? (class$org$dsi$ifc$audio$DSISoundListener = OpsVpsHsmTarget.class$("org.dsi.ifc.audio.DSISoundListener")) : class$org$dsi$ifc$audio$DSISoundListener, ASLCarContainer.getInstance().getAdapterFactory().createDSIListenerMethodAdapter(this.getHsm(), class$org$dsi$ifc$audio$DSISoundListener == null ? (class$org$dsi$ifc$audio$DSISoundListener = OpsVpsHsmTarget.class$("org.dsi.ifc.audio.DSISoundListener")) : class$org$dsi$ifc$audio$DSISoundListener));
        this.dsiCarComfort = (DSICarComfort)dSIProxy.getService(this, class$org$dsi$ifc$carcomfort$DSICarComfort == null ? (class$org$dsi$ifc$carcomfort$DSICarComfort = OpsVpsHsmTarget.class$("org.dsi.ifc.carcomfort.DSICarComfort")) : class$org$dsi$ifc$carcomfort$DSICarComfort);
        dSIProxy.addServiceStateListener(class$org$dsi$ifc$audio$DSISound == null ? (class$org$dsi$ifc$audio$DSISound = OpsVpsHsmTarget.class$("org.dsi.ifc.audio.DSISound")) : class$org$dsi$ifc$audio$DSISound, this);
        dSIProxy.addServiceStateListener(class$org$dsi$ifc$carcomfort$DSICarComfort == null ? (class$org$dsi$ifc$carcomfort$DSICarComfort = OpsVpsHsmTarget.class$("org.dsi.ifc.carcomfort.DSICarComfort")) : class$org$dsi$ifc$carcomfort$DSICarComfort, this);
        dSIProxy.addServiceStateListener(class$org$dsi$ifc$cardriverassistance$DSICarDriverAssistance == null ? (class$org$dsi$ifc$cardriverassistance$DSICarDriverAssistance = OpsVpsHsmTarget.class$("org.dsi.ifc.cardriverassistance.DSICarDriverAssistance")) : class$org$dsi$ifc$cardriverassistance$DSICarDriverAssistance, this);
        dSIProxy.addServiceStateListener(class$org$dsi$ifc$generalvehiclestates$DSIGeneralVehicleStates == null ? (class$org$dsi$ifc$generalvehiclestates$DSIGeneralVehicleStates = OpsVpsHsmTarget.class$("org.dsi.ifc.generalvehiclestates.DSIGeneralVehicleStates")) : class$org$dsi$ifc$generalvehiclestates$DSIGeneralVehicleStates, this);
    }

    public void registerDSIViewOptionsNotification() {
        this.dsiOpsVps.setNotification(new int[]{1}, (DSIListener)this.dsiOpsVpsListener);
    }

    public void registerOPSVPSCommonNotifications() {
        this.dsiOpsVps.setNotification(new int[]{26}, (DSIListener)this.dsiOpsVpsListener);
        ASLCarContainer.getInstance().getDSIProxy().addResponseListener(this, class$org$dsi$ifc$carparkingsystem$DSICarParkingSystemListener == null ? (class$org$dsi$ifc$carparkingsystem$DSICarParkingSystemListener = OpsVpsHsmTarget.class$("org.dsi.ifc.carparkingsystem.DSICarParkingSystemListener")) : class$org$dsi$ifc$carparkingsystem$DSICarParkingSystemListener, ASLCarContainer.getInstance().getAdapterFactory().createDSIListenerMethodAdapter(this.getHsm(), class$org$dsi$ifc$carparkingsystem$DSICarParkingSystemListener == null ? (class$org$dsi$ifc$carparkingsystem$DSICarParkingSystemListener = OpsVpsHsmTarget.class$("org.dsi.ifc.carparkingsystem.DSICarParkingSystemListener")) : class$org$dsi$ifc$carparkingsystem$DSICarParkingSystemListener));
    }

    public void registerVPSDSINotifications() {
        this.registerFRVCDSINotifications();
    }

    public void registerFRVCDSINotifications() {
        this.registerRVCDSINotifications();
    }

    public void registerRVCDSINotifications() {
        this.dsiOpsVps.setNotification(new int[]{14, 44, 69, 31}, (DSIListener)this.dsiOpsVpsListener);
    }

    public void registerVPSSettingsDSINotifications() {
        this.dsiOpsVps.setNotification(new int[]{15, 16, 17, 66, 67, 68}, (DSIListener)this.dsiOpsVpsListener);
    }

    public void registerOPSDSINotifications() {
        if (!this.opsDSINotificationDone) {
            this.dsiOpsVps.setNotification(new int[]{7, 3, 4, 5, 6, 41, 10, 11, 34, 33, 35, 38, 36, 37, 9, 40, 32, 43, 8, 64, 63, 72, 71}, (DSIListener)this.dsiOpsVpsListener);
            this.opsDSINotificationDone = true;
        }
    }

    public void registerSWADSINotification() {
        this.dsiAssist.setNotification(new int[]{54, 56}, (DSIListener)this.dsiAssistListener);
    }

    public void registerPowerMgr() {
        this.dsiPowerManagement.setNotification(new int[]{4}, ASLCarContainer.getInstance().getAdapterFactory().createDSIListenerMethodAdapter(this.getHsm(), class$org$dsi$ifc$powermanagement$DSIPowerManagementListener == null ? (class$org$dsi$ifc$powermanagement$DSIPowerManagementListener = OpsVpsHsmTarget.class$("org.dsi.ifc.powermanagement.DSIPowerManagementListener")) : class$org$dsi$ifc$powermanagement$DSIPowerManagementListener));
    }

    public void requestConfig() {
        ServiceManager.adaptionApi.requestCoding((AdaptionResponse)((Object)this.statePopupOff));
    }

    public void setVPSColor(int n) {
        this.dsiOpsVps.setVPSColor(n);
    }

    public void setVPSContrast(int n) {
        this.dsiOpsVps.setVPSContrast(n);
    }

    public void setVPSBrightness(int n) {
        this.dsiOpsVps.setVPSBrightness(n);
    }

    public void setVPSSystemOnOff(boolean bl) {
        this.dsiOpsVps.setVPSSystemOnOff(bl);
    }

    public void setHMIState(boolean bl) {
        this.dsiOpsVps.setHMIStateIsReady(bl);
    }

    public void requestLifeMonitoring(boolean bl) {
        this.dsiOpsVps.requestLifeMonitoring(bl);
    }

    public static boolean isContentToCancel(DisplayContent displayContent) {
        return displayContent.popup == 0 && displayContent.screen == 0 && displayContent.view == 0 && displayContent.mode == 0;
    }

    public void showParkingPopup(DisplayContent displayContent) {
        this.dsiOpsVps.showParkingPopup(displayContent);
    }

    public void showParkingPopup(int n, int n2, int n3, int n4) {
        DisplayContent displayContent = new DisplayContent();
        displayContent.popup = this.dsiDisplayContentReceived.popup;
        displayContent.screen = this.dsiDisplayContentReceived.screen;
        displayContent.view = this.dsiDisplayContentReceived.view;
        displayContent.mode = this.dsiDisplayContentReceived.mode;
        if (n != -1) {
            displayContent.popup = OpsVpsMapTable.getDsiValue(0, n);
        }
        if (n2 != -1) {
            displayContent.screen = OpsVpsMapTable.getDsiValue(1, n2);
        }
        if (n3 != -1) {
            displayContent.view = OpsVpsMapTable.getDsiValue(2, n3);
        }
        if (n4 != -1) {
            displayContent.mode = OpsVpsMapTable.getDsiValue(4, n4);
        }
        this.info().append("OpsVps: showParkingPopup p: ").append(displayContent.popup).append(", s: ").append(displayContent.screen).append(", v: ").append(displayContent.view).append(", m:").append(displayContent.mode).log();
        this.dsiOpsVps.showParkingPopup(displayContent);
    }

    public void closeParkingPopupByDevice() {
        this.dsiOpsVps.cancelParkingPopup(this.dsiDisplayContentReceived, 0);
    }

    public void updateModelDisplayContent(DisplayContent displayContent) {
        DisplayContent displayContent2 = new DisplayContent();
        displayContent2.popup = displayContent.popup;
        displayContent2.screen = displayContent.screen;
        displayContent2.view = displayContent.view;
        displayContent2.mode = displayContent.mode;
        this.isLegalScreen = displayContent2.screen == 3;
        this.evaluateDarkScreen();
        if (this.isRvcLowCoded && displayContent.mode == 0 && displayContent.view == 1) {
            displayContent2.mode = 1;
        }
        if (this.pdcOffroadStatus && displayContent.popup == 18) {
            displayContent2.popup = this.isAreaViewExist ? 3 : 2;
        }
        this.displayContentCollector.car_parkassistence_display_content_system = OpsVpsMapTable.getModelValue(0, displayContent2.popup);
        this.displayContentCollector.car_parkassistence_display_content_screen = OpsVpsMapTable.getModelValue(1, displayContent2.screen);
        this.displayContentCollector.car_parkassistence_display_content_view = OpsVpsMapTable.getModelValue(2, displayContent2.view);
        this.displayContentCollector.car_parkassistence_display_content_mode = OpsVpsMapTable.getModelValue(4, displayContent2.mode);
        this.info().append("OpsVps: updateModelDisplayContent ").append(this.displayContentCollector.car_parkassistence_display_content_system).append(this.displayContentCollector.car_parkassistence_display_content_screen).append(this.displayContentCollector.car_parkassistence_display_content_view).append(this.displayContentCollector.car_parkassistence_display_content_mode).log();
        ListManager.getGenericASLList(10560).updateList(this.displayContentCollectorArray);
    }

    public void setPDCMute(boolean bl) {
        this.dsiOpsVps.setPDCMute(bl);
    }

    public void setPDCAutoActivation(boolean bl) {
        this.dsiOpsVps.setPDCAutoActivation(bl);
    }

    public void setLoweringEntertainment(int n, int n2, int n3, int n4) {
        this.dsiSound.setLoweringEntertainment(n, 1, 1, (short)n4);
    }

    public void setPDCVolumeFront(int n) {
        this.dsiOpsVps.setPDCVolumeFront(n);
    }

    public void setPDCVolumeRear(int n) {
        this.dsiOpsVps.setPDCVolumeRear(n);
    }

    public void setPDCFreqFront(int n) {
        this.dsiOpsVps.setPDCFrequenceFront(n);
    }

    public void setPDCFreqRear(int n) {
        this.dsiOpsVps.setPDCFrequenceRear(n);
    }

    public void setBrakeElectricalParking(boolean bl) {
        this.dsiCarComfort.setBrakeElectricalParking(bl);
    }

    @Override
    public void registered(String string, int n) {
        try {
            if ((class$org$dsi$ifc$audio$DSISound == null ? (class$org$dsi$ifc$audio$DSISound = OpsVpsHsmTarget.class$("org.dsi.ifc.audio.DSISound")) : class$org$dsi$ifc$audio$DSISound).getName().equals(string)) {
                this.dsiSound.setNotification(new int[]{13}, ASLCarContainer.getInstance().getAdapterFactory().createDSIListenerMethodAdapter(this.getHsm(), class$org$dsi$ifc$audio$DSISoundListener == null ? (class$org$dsi$ifc$audio$DSISoundListener = OpsVpsHsmTarget.class$("org.dsi.ifc.audio.DSISoundListener")) : class$org$dsi$ifc$audio$DSISoundListener));
                this.dsiSound.getLoweringEntertainment(12, 1, 1);
            } else if ((class$org$dsi$ifc$carcomfort$DSICarComfort == null ? (class$org$dsi$ifc$carcomfort$DSICarComfort = OpsVpsHsmTarget.class$("org.dsi.ifc.carcomfort.DSICarComfort")) : class$org$dsi$ifc$carcomfort$DSICarComfort).getName().equals(string)) {
                this.dsiCarComfort.setNotification(new int[]{46}, ASLCarContainer.getInstance().getAdapterFactory().createDSIListenerMethodAdapter(this.getHsm(), class$org$dsi$ifc$carcomfort$DSICarComfortListener == null ? (class$org$dsi$ifc$carcomfort$DSICarComfortListener = OpsVpsHsmTarget.class$("org.dsi.ifc.carcomfort.DSICarComfortListener")) : class$org$dsi$ifc$carcomfort$DSICarComfortListener));
            } else if ((class$org$dsi$ifc$cardriverassistance$DSICarDriverAssistance == null ? (class$org$dsi$ifc$cardriverassistance$DSICarDriverAssistance = OpsVpsHsmTarget.class$("org.dsi.ifc.cardriverassistance.DSICarDriverAssistance")) : class$org$dsi$ifc$cardriverassistance$DSICarDriverAssistance).getName().equals(string)) {
                this.dsiAssist.setNotification(new int[]{1}, (DSIListener)this.dsiAssistListener);
            } else if ((class$org$dsi$ifc$generalvehiclestates$DSIGeneralVehicleStates == null ? (class$org$dsi$ifc$generalvehiclestates$DSIGeneralVehicleStates = OpsVpsHsmTarget.class$("org.dsi.ifc.generalvehiclestates.DSIGeneralVehicleStates")) : class$org$dsi$ifc$generalvehiclestates$DSIGeneralVehicleStates).getName().equals(string)) {
                DSIGeneralVehicleStates dSIGeneralVehicleStates = (DSIGeneralVehicleStates)ASLCarContainer.getInstance().getDSIProxy().getService(this, class$org$dsi$ifc$generalvehiclestates$DSIGeneralVehicleStates == null ? (class$org$dsi$ifc$generalvehiclestates$DSIGeneralVehicleStates = OpsVpsHsmTarget.class$("org.dsi.ifc.generalvehiclestates.DSIGeneralVehicleStates")) : class$org$dsi$ifc$generalvehiclestates$DSIGeneralVehicleStates);
                dSIGeneralVehicleStates.setNotification(new int[]{6}, ASLCarContainer.getInstance().getAdapterFactory().createDSIListenerMethodAdapter(this.getHsm(), class$org$dsi$ifc$generalvehiclestates$DSIGeneralVehicleStatesListener == null ? (class$org$dsi$ifc$generalvehiclestates$DSIGeneralVehicleStatesListener = OpsVpsHsmTarget.class$("org.dsi.ifc.generalvehiclestates.DSIGeneralVehicleStatesListener")) : class$org$dsi$ifc$generalvehiclestates$DSIGeneralVehicleStatesListener));
            }
        }
        catch (Throwable throwable) {
            this.warn("Could not connect to DSIGeneralVehicleStates");
        }
    }

    @Override
    public void unregistered(String string, int n) {
    }

    public void updatePDCFailure(boolean bl) {
        this.pdcFailureActive = bl;
        this.sendPDCFailureEvent();
        this.updateModelOPSAvailability();
    }

    public void setVPSFailure(boolean bl) {
        this.vpsFailureActive = bl;
        this.sendPDCFailureEvent();
    }

    protected void sendPDCFailureEvent() {
        this.info().append("OpsVps: sendPDCFailureEvent: pdcFailureNotificationDone=").append(this.pdcFailureNotificationDone).log();
        if (this.isEarlyRVC) {
            return;
        }
        if (this.isOPSStandalone()) {
            if (this.pdcFailureActive && !this.pdcFailureNotificationDone) {
                this.info().append("OpsVps: sendPDCFailureEvent: ops standalone: event sent").log();
                this.pdcFailureNotificationDone = true;
                this.sendHMIEvent(10008);
            }
        } else if ((this.pdcFailureActive || this.vpsFailureActive) && !this.pdcFailureNotificationDone) {
            this.info().append("OpsVps: sendPDCFailureEvent: opsvps: event sent").log();
            this.pdcFailureNotificationDone = true;
            this.sendHMIEvent(10008);
        }
    }

    private boolean isOPSStandalone() {
        return StatePopupOff.opsConfig != 0 && !this.isAreaViewExist && !StatePopupOff.isRvc;
    }

    public void setPdcOffroad(boolean bl) {
        this.dsiOpsVps.setPDCOffroadMode(bl);
    }

    public void updateColorValue(int n) {
        this.statePopupOn.updateColor(n);
    }

    public void updateContrastValue(int n) {
        this.statePopupOn.updateContrast(n);
    }

    public void updateBrightnessValue(int n) {
        this.statePopupOn.updateBrightness(n);
    }

    public void setPDCOnOff(boolean bl) {
        this.dsiOpsVps.setPDCSystemOnOff(bl);
    }

    private void updateModelOPSAvailability() {
        if (this.pdcSystemOnOff && !this.pdcFailureActive || this.isAreaViewExist) {
            OpsVpsHsmTarget.writeBooleanToDatapool(10177, true);
        } else {
            OpsVpsHsmTarget.writeBooleanToDatapool(10177, false);
        }
    }

    public void updatePDCSystemOnOff(boolean bl) {
        this.pdcSystemOnOff = bl;
        this.updateModelOPSAvailability();
    }

    public boolean isRvcLowCoded() {
        return this.isRvcLowCoded;
    }

    public void setRvcLowCoded(boolean bl) {
        this.isRvcLowCoded = bl;
        if (bl) {
            String string = ServiceManager.configManagerDiag.getEncodedVehicleType();
            this.isSpecialCrafter = "0605040000".equalsIgnoreCase(string) || "0805040000".equalsIgnoreCase(string) || "0605040007".equalsIgnoreCase(string) || "0805040007".equalsIgnoreCase(string);
            ASLFrameworkFactory.getASLFrameworkAPI().getASLLogger().info(1, new StringBuffer().append("Parking: RVC Low coded! Vehicletype: ").append(string).toString());
        }
    }

    public void setFifthCameraMode(int n) {
        this.dsiOpsVps.setVPSExtCamConfig(n);
    }

    public void setPLESystemActive(boolean bl) {
        this.dsiOpsVps.setPDCVisualisationParkbox(bl);
    }

    public void activateExtCamera(boolean bl) {
        this.dsiOpsVps.setVPSExtCamManActivation(bl);
    }

    public void set3DBVPosition(int n, int n2) {
        this.dsiOpsVps.setVPS3DBirdview(n, n2);
    }

    public void setClamp15(boolean bl) {
        if (!this.clamp15On && bl) {
            this.pdcFailureNotificationDone = false;
        }
        this.clamp15On = bl;
        this.sendPDCFailureEvent();
    }

    public boolean getClamp15() {
        return this.clamp15On;
    }

    public void storeDisplayContent(DisplayContent displayContent) {
        this.dsiDisplayContentReceived.popup = displayContent.getPopup();
        this.dsiDisplayContentReceived.screen = displayContent.getScreen();
        this.dsiDisplayContentReceived.view = displayContent.getView();
        this.dsiDisplayContentReceived.mode = displayContent.getMode();
    }

    public DisplayContent getLastDisplayContent() {
        return new DisplayContent(this.dsiDisplayContentReceived.popup, this.dsiDisplayContentReceived.screen, this.dsiDisplayContentReceived.view, this.dsiDisplayContentReceived.mode);
    }

    public void onRequestToShowClose(DisplayContent displayContent) {
        if (OpsVpsHsmTarget.isContentToCancel(displayContent)) {
            this.triggerObserver(496845056, null);
        } else {
            this.triggerObserver(899498240, null);
        }
    }

    public void setAreaViewExistence(boolean bl) {
        this.isAreaViewExist = bl;
        this.updateModelOPSAvailability();
    }

    public boolean isAreaViewExist() {
        return this.isAreaViewExist;
    }

    public boolean isEarlyRVC() {
        return this.isEarlyRVC;
    }

    public void setEarlyRVC(boolean bl) {
        this.isEarlyRVC = bl;
        this.sendPDCFailureEvent();
    }

    public void closeParkingPopupByModel() {
        this.triggerObserver(496845056, null);
        this.info().append("OpsVps: closeParkingPopupByModel p: ").append(this.dsiDisplayContentReceived.popup).append(", s: ").append(this.dsiDisplayContentReceived.screen).append(", v: ").append(this.dsiDisplayContentReceived.view).append(", m:").append(this.dsiDisplayContentReceived.mode).log();
        this.dsiOpsVps.cancelParkingPopup(this.dsiDisplayContentReceived, 1);
    }

    public void clearNotification(int n) {
        if (n == 8) {
            this.dsiOpsVps.clearNotification(8, (DSIListener)this.dsiOpsVpsListener);
        }
    }

    public void setNotification(int n) {
        if (n == 8) {
            this.dsiOpsVps.setNotification(8, (DSIListener)this.dsiOpsVpsListener);
        }
    }

    public void setManoeuverSystemActive(boolean bl) {
        int n = bl ? 1 : 0;
        this.dsiOpsVps.setPDCManeuverAssistConfig(n);
    }

    public void setManoeuverAssist(boolean bl) {
        this.dsiOpsVps.setPDCManeuverAssist(bl);
    }

    public void doInternalSwitch(DisplayContent displayContent) {
        this.displayContentCollector.car_parkassistence_display_content_system = displayContent.popup;
        this.displayContentCollector.car_parkassistence_display_content_screen = displayContent.screen;
        this.displayContentCollector.car_parkassistence_display_content_view = displayContent.view;
        this.displayContentCollector.car_parkassistence_display_content_mode = displayContent.mode;
        this.info().append("OpsVps: updateModelDisplayContent ").append(this.displayContentCollector.car_parkassistence_display_content_system).append(this.displayContentCollector.car_parkassistence_display_content_screen).append(this.displayContentCollector.car_parkassistence_display_content_view).append(this.displayContentCollector.car_parkassistence_display_content_mode).log();
        ListManager.getGenericASLList(10560).updateList(this.displayContentCollectorArray);
    }

    public void setPDCOffroadStatus(boolean bl) {
        this.pdcOffroadStatus = bl;
    }

    public boolean getPDCOffroadStatus() {
        return this.pdcOffroadStatus;
    }

    public void resetToFactory() {
        this.dsiOpsVps.setPdcSetFactoryDefault();
    }

    @Override
    public void onFactoryResetStateChanged(int n) {
        if (n == 0 && this.resetIsDirty) {
            this.resetIsDirty = false;
            this.resetToFactory();
        }
    }

    public void requestFactoryReset() {
        if (this.resetFactory.getFactoryResetState() == 0) {
            this.resetFactory.reset(FactoryResetComponents.CAR_PARKING_ASSISTANCE, 0);
        } else {
            this.resetIsDirty = true;
        }
    }

    public void resetToFactoryDone(boolean bl) {
        this.resetParticipant.resetDone();
    }

    public void registerAPSnotifications(boolean bl) {
        if (this.apsNotificationDone) {
            return;
        }
        this.apsNotificationDone = true;
        int[] nArray = new int[]{4, 6};
        if (!bl) {
            nArray = new int[]{4, 6, 3, 5};
        }
        this.dsiOpsVps.setNotification(nArray, (DSIListener)this.dsiOpsVpsListener);
    }

    public void setVPSSystemState(boolean bl) {
        this.dsiOpsVps.setVPSSystemState(bl);
    }

    public void setExistAssist(boolean bl) {
        this.dsiAssist.setSWAExitAssist(bl);
    }

    public boolean isVPSVideoInfoSpeedTooHigh() {
        return this.isVPSVideoInfoSpeedTooHigh;
    }

    public void setVPSVideoInfoSpeedTooHigh(boolean bl) {
        this.isVPSVideoInfoSpeedTooHigh = bl;
    }

    public void setDarkScreenTriggersVPS(boolean bl, boolean bl2) {
        this.isTrunkOpenVPS = bl;
        this.isSpeedTooHigh = bl2;
        this.evaluateDarkScreen();
    }

    public void setDarkScreenTriggersPDC(boolean bl) {
        this.isTrunkOpenPDC = bl;
        this.evaluateDarkScreen();
    }

    private void evaluateDarkScreen() {
        boolean bl = false;
        if (this.isTrunkOpenVPS || this.isTrunkOpenPDC) {
            bl = this.isRvcLowCoded && this.isSpecialCrafter ? false : this.isRvcLowCoded;
        } else if (this.isSpeedTooHigh && this.isRvcLowCoded && this.isLegalScreen) {
            this.warn().append("OpsVps: No Darkscreen on speedTooHigh in FMVSS111 ").log();
            bl = false;
        } else {
            bl = this.isSpeedTooHigh;
        }
        ServiceManager.aslPropertyManager.valueChangedBoolean(10184, bl);
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

