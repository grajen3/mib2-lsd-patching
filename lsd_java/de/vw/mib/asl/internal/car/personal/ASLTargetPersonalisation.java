/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.car.personal;

import de.vw.mib.asl.api.car.ASLCarFactory;
import de.vw.mib.asl.api.car.logger.CarLogger;
import de.vw.mib.asl.api.car.speller.Speller;
import de.vw.mib.asl.api.system.ASLSystemFactory;
import de.vw.mib.asl.api.system.factoryreset.FactoryResetComponents;
import de.vw.mib.asl.api.system.factoryreset.FactoryResetListener;
import de.vw.mib.asl.api.system.factoryreset.FactoryResetService;
import de.vw.mib.asl.framework.api.dsiproxy.DSIProxy;
import de.vw.mib.asl.framework.api.dsiproxy.DSIProxyFactory;
import de.vw.mib.asl.framework.api.dsiproxy.DSIServiceStateListener;
import de.vw.mib.asl.framework.internal.framework.AbstractASLTarget;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.car.ASLCarContainer;
import de.vw.mib.asl.internal.car.personal.ASLTargetPersonalisation$1;
import de.vw.mib.asl.internal.car.personal.ASLTargetPersonalisation$PersonalConfig;
import de.vw.mib.asl.internal.car.personal.ASLTargetPersonalisation$ResetPSOParticipant;
import de.vw.mib.asl.internal.car.personal.ASLTargetPersonalisation$UserProfileOnOff;
import de.vw.mib.asl.internal.car.personal.DriverListDSIDelegater;
import de.vw.mib.asl.internal.car.personal.DriverListElement;
import de.vw.mib.asl.internal.car.personal.DriverListHMIDelegater;
import de.vw.mib.asl.internal.car.personal.api.PersonalizationServiceDataSource;
import de.vw.mib.asl.internal.car.personal.api.PersonalizationServiceImpl;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.GenericEvents;
import de.vw.mib.timer.Timer;
import generated.de.vw.mib.asl.internal.ListManager;
import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.carcomfort.DSICarComfort;
import org.dsi.ifc.carcomfort.DSICarComfortListener;
import org.dsi.ifc.carcomfort.DoorLockingConfiguration;
import org.dsi.ifc.carcomfort.DoorLockingUserListRA1;
import org.dsi.ifc.carcomfort.DoorLockingUserListUpdateInfo;
import org.dsi.ifc.carcomfort.DoorLockingUserProfileOnOff;
import org.dsi.ifc.carcomfort.DoorLockingViewOptions;
import org.dsi.ifc.generalvehiclestates.DSIGeneralVehicleStates;

public class ASLTargetPersonalisation
extends AbstractASLTarget
implements CarLogger,
FactoryResetListener,
DSIServiceStateListener {
    private static final int USERPROFILECONTROL_NO_ACTION;
    private DSICarComfort dsiCarComfort;
    private DSICarComfortListener dsiCarComfortListener;
    private boolean isProfileSwitching = false;
    Timer timer;
    private DriverListHMIDelegater driverListHMIDelegater;
    private ASLTargetPersonalisation$UserProfileOnOff userProfileOnOff;
    private ASLTargetPersonalisation$PersonalConfig personalConfig;
    private boolean isSpeedTooHigh;
    private int currentUserReference;
    private boolean initAppDone;
    private int currentUserControl;
    private int requestedActiveUser;
    private int editProfilePos = -1;
    private DriverListDSIDelegater listDelegator;
    private Speller psoSpeller;
    private FactoryResetService resetService;
    private ASLTargetPersonalisation$ResetPSOParticipant resetParticipant;
    private boolean resetIsDirty;
    private PersonalizationServiceDataSource psoApiService;
    private int renameRequester = -1;
    static /* synthetic */ Class class$org$dsi$ifc$carcomfort$DSICarComfort;
    static /* synthetic */ Class class$org$dsi$ifc$carcomfort$DSICarComfortListener;
    static /* synthetic */ Class class$org$dsi$ifc$generalvehiclestates$DSIGeneralVehicleStates;
    static /* synthetic */ Class class$org$dsi$ifc$generalvehiclestates$DSIGeneralVehicleStatesListener;

    public ASLTargetPersonalisation(GenericEvents genericEvents, String string) {
        super(genericEvents, string);
        if (this.isTraceEnabled()) {
            this.trace().append("Pers.ctor").log();
        }
    }

    @Override
    public int getDefaultTargetId() {
        return -2075192832;
    }

    @Override
    public int getSubClassifier() {
        return 1;
    }

    @Override
    public void gotEvent(EventGeneric eventGeneric) {
        int n = eventGeneric.getReceiverEventId();
        switch (n) {
            case 106: {
                if (this.isTraceEnabled()) {
                    this.trace().append("Pers.POWER_ON").log();
                }
                this.initDSI();
                this.requestDSIPersonalCoding();
                break;
            }
            case 1073745130: {
                this.assignKeyNow();
                break;
            }
            case 1073745158: {
                this.assignKeyTemporary();
                break;
            }
            case 0x40000CCC: {
                this.activateDeactivateSystem();
                break;
            }
            case 1073745105: {
                this.setActiveDriver(eventGeneric);
                break;
            }
            case 1073745102: {
                this.resetDriver();
                break;
            }
            case 1073745101: {
                this.requestFactoryReset();
                break;
            }
            case 1073745103: {
                this.copyDriver(eventGeneric);
                break;
            }
            case 1073745129: {
                this.setAssignKeyMode(eventGeneric);
                break;
            }
            case 1073745104: {
                this.editProfilePos = eventGeneric.getInt(0);
                break;
            }
            case 1073745131: {
                this.abortATNE();
                break;
            }
            case 1073745240: {
                this.spellerInit(eventGeneric);
                break;
            }
            case 1073745112: {
                this.spellerSetName();
                break;
            }
            case 1073745106: {
                if (!this.isTraceEnabled()) break;
                this.trace().append("Pers.SPELLER_CLOSE").log();
                break;
            }
            case 1073745183: {
                if (this.isTraceEnabled()) {
                    this.trace().append("Pers.SPELLER_SET_CHAR").log();
                }
                this.psoSpeller.addCharacter(eventGeneric.getString(0), eventGeneric.getInt(3), eventGeneric.getInt(1), eventGeneric.getInt(2));
                break;
            }
            case 1073745107: {
                if (this.isTraceEnabled()) {
                    this.trace().append("Pers.SPELLER_DELETE_CHAR").log();
                }
                this.psoSpeller.deleteCharacter();
                break;
            }
            case 1073745111: {
                if (this.isTraceEnabled()) {
                    this.trace().append("Pers.SPELLER_DISCARD").log();
                }
                this.psoSpeller.deleteAllCharacters();
                break;
            }
            case 0x40000D04: {
                ASLTargetPersonalisation.writeBooleanToDatapool(1127358464, eventGeneric.getBoolean(0));
                break;
            }
            case 1073745109: {
                this.psoSpeller.setCursorPosition(eventGeneric.getInt(0));
                break;
            }
            case 1073744866: {
                int n2 = eventGeneric.getInt(0);
                if (n2 != 0 && n2 != 10) break;
                if (this.isTraceEnabled()) {
                    this.trace().append("Pers.RESET_TO_FACTORY_SETTING for Personalization").log();
                }
                if (this.isProfileSwitching) break;
                this.requestFactoryReset();
                break;
            }
        }
    }

    private void requestFactoryReset() {
        if (this.resetService.getFactoryResetState() == 0) {
            this.resetService.reset(FactoryResetComponents.PERSONALIZATION, 0);
        } else {
            this.resetIsDirty = true;
        }
    }

    private void activateDeactivateSystem() {
        if (this.isTraceEnabled()) {
            this.trace().append("Pers.TOGGLE_MDM_SYSTEM_ACTIVE").log();
        }
        this.dsiCarComfort.setDoorLockingUserProfileOnOff(new DoorLockingUserProfileOnOff(!this.userProfileOnOff.handling, this.userProfileOnOff.autoKeyAssignment, this.userProfileOnOff.temporaryKeyAssignment));
    }

    private void setActiveDriver(EventGeneric eventGeneric) {
        int n = eventGeneric.getInt(0);
        this.dsiCarComfort.startDoorLockingUserProfileControl(4, n);
        this.requestedActiveUser = n;
        this.currentUserControl = 4;
    }

    private void setAssignKeyMode(EventGeneric eventGeneric) {
        int n;
        if (this.isTraceEnabled()) {
            this.trace().append("Pers.SET_ASSIGN_KEY_MODE").log();
        }
        boolean bl = (n = eventGeneric.getInt(0)) == 0;
        this.dsiCarComfort.setDoorLockingUserProfileOnOff(new DoorLockingUserProfileOnOff(this.userProfileOnOff.handling, bl, this.userProfileOnOff.temporaryKeyAssignment));
    }

    private void assignKeyNow() {
        if (this.isTraceEnabled()) {
            this.trace().append("Pers.Assign Key Now").log();
        }
        if (this.personalConfig.isKeyDetectionInstalled) {
            ASLTargetPersonalisation.writeIntegerToDatapool(10513, 1);
        } else {
            ASLTargetPersonalisation.writeIntegerToDatapool(10513, 4);
        }
        this.dsiCarComfort.startDoorLockingUserProfileControl(5, this.currentUserReference);
        this.currentUserControl = 5;
    }

    private void assignKeyTemporary() {
        if (this.isTraceEnabled()) {
            this.trace().append("Pers.TempAssignKey").log();
        }
        ASLTargetPersonalisation.writeIntegerToDatapool(10513, 4);
        this.dsiCarComfort.setDoorLockingUserProfileOnOff(new DoorLockingUserProfileOnOff(this.userProfileOnOff.handling, this.userProfileOnOff.autoKeyAssignment, true));
        this.currentUserControl = 5;
    }

    void resetAll() {
        this.dsiCarComfort.startDoorLockingUserProfileControl(1, 0);
        this.currentUserControl = 1;
        ASLTargetPersonalisation.writeIntegerToDatapool(10514, 1);
    }

    private void resetDriver() {
        this.dsiCarComfort.startDoorLockingUserProfileControl(2, 0);
        this.currentUserControl = 2;
        ASLTargetPersonalisation.writeIntegerToDatapool(10515, 1);
    }

    private void copyDriver(EventGeneric eventGeneric) {
        int n = eventGeneric.getInt(1);
        this.dsiCarComfort.startDoorLockingUserProfileControl(3, n);
        this.currentUserControl = 3;
        ASLTargetPersonalisation.writeIntegerToDatapool(10517, 1);
    }

    private void spellerInit(EventGeneric eventGeneric) {
        if (this.isTraceEnabled()) {
            this.trace().append("Pers.SPELLER_INIT").log();
        }
        this.psoSpeller.setEnteredText(eventGeneric.getString(0));
        this.renameRequester = eventGeneric.getInt(1);
    }

    private void spellerSetName() {
        if (this.isTraceEnabled()) {
            this.trace().append("Pers.SPELLER_SET_NAME").log();
        }
        String string = this.psoSpeller.getEnteredText();
        if (this.renameRequester == 1) {
            this.driverListHMIDelegater.renameUserProfile(string);
        } else if (this.editProfilePos != -1) {
            this.driverListHMIDelegater.renameUserProfile(this.editProfilePos, string);
        }
    }

    private void abortATNE() {
        if (this.isTraceEnabled()) {
            this.trace().append("Pers.Abort ATNE").log();
        }
        this.dsiCarComfort.abortDoorLockingUserProfileControl();
    }

    private void initApp() {
        if (this.initAppDone) {
            return;
        }
        this.initAppDone = true;
        this.userProfileOnOff = new ASLTargetPersonalisation$UserProfileOnOff(this);
        boolean bl = false;
        this.userProfileOnOff.autoKeyAssignment = !bl;
        this.personalConfig = new ASLTargetPersonalisation$PersonalConfig(this);
        this.psoSpeller = ASLCarFactory.getCarApi().createSpeller(0, 10455);
        this.initDriverList();
        this.psoApiService = PersonalizationServiceImpl.getInternalInstance();
        this.listDelegator = new DriverListDSIDelegater(this.dsiCarComfort, this);
        this.driverListHMIDelegater = new DriverListHMIDelegater(this.listDelegator, this.psoApiService);
        this.registerOnModelEvents();
        this.registerDSIListeners();
        this.resetService = ASLSystemFactory.getSystemApi().getFactoryResetService();
        this.resetParticipant = new ASLTargetPersonalisation$ResetPSOParticipant(this);
        this.resetService.addParticipant(this.resetParticipant, FactoryResetComponents.PERSONALIZATION);
        this.resetService.addListener(this);
    }

    private void initDSI() {
        DSIProxy dSIProxy = DSIProxyFactory.getDSIProxyAPI().getDSIProxy();
        this.dsiCarComfort = (DSICarComfort)dSIProxy.getService(this, class$org$dsi$ifc$carcomfort$DSICarComfort == null ? (class$org$dsi$ifc$carcomfort$DSICarComfort = ASLTargetPersonalisation.class$("org.dsi.ifc.carcomfort.DSICarComfort")) : class$org$dsi$ifc$carcomfort$DSICarComfort);
        this.dsiCarComfortListener = (DSICarComfortListener)dSIProxy.getAdapterFactory().createDSIListenerMethodAdapter(this, class$org$dsi$ifc$carcomfort$DSICarComfortListener == null ? (class$org$dsi$ifc$carcomfort$DSICarComfortListener = ASLTargetPersonalisation.class$("org.dsi.ifc.carcomfort.DSICarComfortListener")) : class$org$dsi$ifc$carcomfort$DSICarComfortListener);
    }

    private void initDriverList() {
        DoorLockingUserListRA1[] doorLockingUserListRA1Array = new DoorLockingUserListRA1[]{new DoorLockingUserListRA1(0, 0, "Gigi"), new DoorLockingUserListRA1(1, 2, "Chichi"), new DoorLockingUserListRA1(2, 3, "Coco"), new DoorLockingUserListRA1(3, 16, "Guest"), new DoorLockingUserListRA1(4, 0, "Extra")};
        Object[] objectArray = new DriverListElement[]{new DriverListElement(null, doorLockingUserListRA1Array[0]), new DriverListElement(null, doorLockingUserListRA1Array[1]), new DriverListElement(null, doorLockingUserListRA1Array[2]), new DriverListElement(null, doorLockingUserListRA1Array[3]), new DriverListElement(null, doorLockingUserListRA1Array[4])};
        ListManager.getGenericASLList(10449).updateList(objectArray);
    }

    private void registerDSIListeners() {
        if (this.isTraceEnabled()) {
            this.trace().append("Pers.registerDSIListeners").log();
        }
        this.dsiCarComfort.setNotification(new int[]{60, 57, 58, 59, 82}, (DSIListener)this.dsiCarComfortListener);
        DSIProxy dSIProxy = DSIProxyFactory.getDSIProxyAPI().getDSIProxy();
        dSIProxy.addResponseListener(this, class$org$dsi$ifc$carcomfort$DSICarComfortListener == null ? (class$org$dsi$ifc$carcomfort$DSICarComfortListener = ASLTargetPersonalisation.class$("org.dsi.ifc.carcomfort.DSICarComfortListener")) : class$org$dsi$ifc$carcomfort$DSICarComfortListener, this.dsiCarComfortListener);
        dSIProxy.addServiceStateListener(class$org$dsi$ifc$generalvehiclestates$DSIGeneralVehicleStates == null ? (class$org$dsi$ifc$generalvehiclestates$DSIGeneralVehicleStates = ASLTargetPersonalisation.class$("org.dsi.ifc.generalvehiclestates.DSIGeneralVehicleStates")) : class$org$dsi$ifc$generalvehiclestates$DSIGeneralVehicleStates, this);
    }

    private void registerOnModelEvents() {
        this.addObservers(new int[]{-770965440, -821297088, -854851520, -838074304, -787742656, -871628736, -385089472, -368312256, 101515328, -351535040, -804519872, -502595520, 1477247040, -670302144, 0x40D0040, -720633792, -754188224, -687079360, 520945728});
    }

    private void requestDSIPersonalCoding() {
        this.dsiCarComfort.setNotification(5, (DSIListener)this.dsiCarComfortListener);
    }

    public void dsiCarComfortUpdateDoorLockingUserProfileOnOff(DoorLockingUserProfileOnOff doorLockingUserProfileOnOff, int n) {
        if (this.userProfileOnOff.handling != doorLockingUserProfileOnOff.handling) {
            if (this.isTraceEnabled()) {
                this.trace().append("Pers.DoorLockingUserProfileOnOff handling ").append(doorLockingUserProfileOnOff.handling).log();
            }
            this.userProfileOnOff.handling = doorLockingUserProfileOnOff.handling;
            ASLTargetPersonalisation.writeBooleanToDatapool(10447, this.userProfileOnOff.handling);
            this.psoApiService.setActive(doorLockingUserProfileOnOff.handling);
        }
        if (this.userProfileOnOff.autoKeyAssignment != doorLockingUserProfileOnOff.autoKeyAssignment) {
            if (this.isTraceEnabled()) {
                this.trace().append("Pers.DoorLockingUserProfileOnOff autoKeyAssignment ").append(doorLockingUserProfileOnOff.autoKeyAssignment).log();
            }
            this.userProfileOnOff.autoKeyAssignment = doorLockingUserProfileOnOff.autoKeyAssignment;
            int n2 = this.userProfileOnOff.autoKeyAssignment ? 0 : 1;
            ASLTargetPersonalisation.writeIntegerToDatapool(10510, n2);
        }
        if (this.userProfileOnOff.temporaryKeyAssignment != doorLockingUserProfileOnOff.temporaryKeyAssignment) {
            if (this.isTraceEnabled()) {
                this.trace().append("Pers.DoorLockingUserProfileOnOff temporaryKeyAssignment ").append(doorLockingUserProfileOnOff.temporaryKeyAssignment).log();
            }
            this.userProfileOnOff.temporaryKeyAssignment = doorLockingUserProfileOnOff.temporaryKeyAssignment;
        }
        if (doorLockingUserProfileOnOff.temporaryKeyAssignment && this.currentUserControl == 5) {
            this.dsiCarComfort.startDoorLockingUserProfileControl(5, this.currentUserReference);
        }
    }

    public void dsiCarComfortUpdateDoorLockingUserListUpdateInfo(DoorLockingUserListUpdateInfo doorLockingUserListUpdateInfo, int n) {
        if (this.isTraceEnabled()) {
            this.trace().append("Pers.updateDoorLockingUserListUpdateInfo() listUpdateInfo:").append(doorLockingUserListUpdateInfo.arrayContent).append(", ").append(n).log();
        }
        this.driverListHMIDelegater.updateDoorLockingUserListUpdateInfo(doorLockingUserListUpdateInfo);
    }

    public void dsiCarComfortUpdateDoorLockingUserListTotalNumberOfElements(int n, int n2) {
        if (this.isTraceEnabled()) {
            this.trace().append("Pers.updateDoorLockingUserListTotalNumberOfElements() numberOfElements:").append(n).append(", ").append(n2).log();
        }
        this.driverListHMIDelegater.updateDoorLockingUserListTotalNumberOfElements(n);
    }

    public void dsiCarComfortResponseDoorLockingUserListRA1(DoorLockingUserListUpdateInfo doorLockingUserListUpdateInfo, DoorLockingUserListRA1[] doorLockingUserListRA1Array) {
        if (this.isTraceEnabled()) {
            this.trace().append("Pers.responseDoorLockingUserListRA1() arrayHeader:").append(doorLockingUserListUpdateInfo.arrayContent).append(", ").append(doorLockingUserListRA1Array).log();
        }
        this.driverListHMIDelegater.responseDoorLockingUserListRA1(doorLockingUserListUpdateInfo, doorLockingUserListRA1Array);
    }

    public void dsiCarComfortResponseDoorLockingUserListRAF(DoorLockingUserListUpdateInfo doorLockingUserListUpdateInfo, int[] nArray) {
        if (this.isTraceEnabled()) {
            this.trace().append("Pers.responseDoorLockingUserListRAF() arrayHeader:").append(doorLockingUserListUpdateInfo.arrayContent).append(", ").append(nArray).log();
        }
    }

    public void dsiCarComfortUpdateDoorLockingActiveUser(int n, int n2) {
        if (this.isTraceEnabled()) {
            this.trace().append("Pers.updateDoorLockingActiveUser() userReference:").append(n).append(", ").append(n2).log();
        }
        this.currentUserReference = n;
        this.driverListHMIDelegater.updateDoorLockingActiveUser(n);
        if (this.requestedActiveUser == this.currentUserReference && this.currentUserControl == 4 && this.personalConfig.isAtneInstalled && !this.isSpeedTooHigh) {
            ASLTargetPersonalisation.writeIntegerToDatapool(10516, 1);
        }
    }

    public void dsiCarComfortAcknowledgeDoorLockingUserProfileControl(int n, boolean bl) {
        if (this.isTraceEnabled()) {
            this.trace().append("Pers.acknowledgeDoorLockingUserProfileControl() target:").append(n).append(", ").append(bl).log();
        }
        switch (this.currentUserControl) {
            case 2: {
                ASLTargetPersonalisation.writeIntegerToDatapool(10515, 0);
                break;
            }
            case 1: {
                ASLTargetPersonalisation.writeIntegerToDatapool(10514, 0);
                this.resetParticipant.resetDone();
                break;
            }
            case 3: {
                ASLTargetPersonalisation.writeIntegerToDatapool(10517, 0);
                break;
            }
            case 4: {
                if (this.personalConfig.isAtneInstalled) {
                    ASLTargetPersonalisation.writeIntegerToDatapool(10516, 0);
                }
                if (this.requestedActiveUser != n) {
                    this.warn().append("Personal.targetProfile not requsted my HMI:").append(n).log();
                    return;
                }
                if (this.userProfileOnOff.autoKeyAssignment || !this.personalConfig.isExtendedKeymapping || !this.personalConfig.isTemporaryKeyAssignmentInstalled || !this.userProfileOnOff.handling) break;
                if (this.isTraceEnabled()) {
                    this.trace().append("Pers.showPopup KEY_ASSIGN: ").append(10023).log();
                }
                this.sendHMIEvent(10023);
                break;
            }
            case 5: {
                if (n == this.currentUserReference) {
                    int n2 = bl ? 2 : 3;
                    ASLTargetPersonalisation.writeIntegerToDatapool(10513, n2);
                    break;
                }
                ASLTargetPersonalisation.writeIntegerToDatapool(10513, 3);
                break;
            }
        }
        this.currentUserControl = -1;
    }

    public void dsiCarComfortUpdateDoorLockingViewOptions(DoorLockingViewOptions doorLockingViewOptions, int n) {
        if (doorLockingViewOptions == null) {
            return;
        }
        if (doorLockingViewOptions.userProfileOnOff.getState() == 0) {
            this.warn("Personalization is not configured. ASL target will not start.");
            return;
        }
        this.initApp();
        this.updatePsoService(doorLockingViewOptions);
        if (doorLockingViewOptions.configuration.profilesTransmittableElements != null) {
            this.listDelegator.setTotalNumerOfElements(doorLockingViewOptions.configuration.profilesTransmittableElements.ra1);
            this.listDelegator.setTotalNumerOfElementsRAF(doorLockingViewOptions.configuration.profilesTransmittableElements.raF);
        } else {
            this.listDelegator.setTotalNumerOfElements(4);
            this.listDelegator.setTotalNumerOfElementsRAF(4);
        }
        this.evalDSIConfig(doorLockingViewOptions.configuration);
    }

    public void timerCallback() {
        ASLTargetPersonalisation.writeBooleanToDatapool(10882, false);
        this.isProfileSwitching = false;
    }

    public void dsiCarComfortUpdateDoorLockingUserProfileControlProcessing(boolean bl, int n, boolean bl2, int n2) {
        if (1 == n2 && !bl) {
            try {
                if (this.timer.isStarted()) {
                    this.timer.stop();
                }
            }
            catch (Exception exception) {
                // empty catch block
            }
            if (bl2) {
                ASLTargetPersonalisation.writeBooleanToDatapool(10882, true);
                this.isProfileSwitching = true;
                this.timer = ServiceManager.timerManager.createTimer("timer1", 0, false, new ASLTargetPersonalisation$1(this), Timer.TIMER_THREAD_INVOKER);
                this.timer.start();
                this.sendHMIEvent(10029);
            } else {
                ASLTargetPersonalisation.writeBooleanToDatapool(10882, false);
                this.isProfileSwitching = false;
            }
        }
    }

    public void updatePsoService(DoorLockingViewOptions doorLockingViewOptions) {
        int n = 0;
        if (doorLockingViewOptions.userProfileControl.getState() == 0) {
            n = 1;
        } else if (doorLockingViewOptions.userProfileControl.getState() == 1) {
            n = 2;
        } else if (doorLockingViewOptions.userProfileControl.getState() == 2) {
            n = 3;
        }
        this.psoApiService.setResetState(n);
    }

    private void evalDSIConfig(DoorLockingConfiguration doorLockingConfiguration) {
        this.personalConfig.isExtendedKeymapping = doorLockingConfiguration.isExtendedKeyMapping();
        this.personalConfig.isAtneInstalled = doorLockingConfiguration.isAtne();
        this.personalConfig.isTemporaryKeyAssignmentInstalled = doorLockingConfiguration.isTemporaryKeyAssignment();
        this.personalConfig.isKeyDetectionInstalled = doorLockingConfiguration.isKeyDetection();
        ASLTargetPersonalisation.writeBooleanToDatapool(10512, this.personalConfig.isAtneInstalled);
        ASLTargetPersonalisation.writeBooleanToDatapool(10518, this.personalConfig.isKeyDetectionInstalled);
        ASLTargetPersonalisation.writeBooleanToDatapool(10533, this.personalConfig.isExtendedKeymapping);
    }

    public void dsiGeneralVehicleStatesUpdateCarVelocityThreshold(boolean bl, int n) {
        this.isSpeedTooHigh = bl;
    }

    @Override
    public void onFactoryResetStateChanged(int n) {
        if (n == 0 && this.resetIsDirty) {
            this.resetIsDirty = false;
            this.resetAll();
        }
    }

    @Override
    public void registered(String string, int n) {
        try {
            if ((class$org$dsi$ifc$generalvehiclestates$DSIGeneralVehicleStates == null ? (class$org$dsi$ifc$generalvehiclestates$DSIGeneralVehicleStates = ASLTargetPersonalisation.class$("org.dsi.ifc.generalvehiclestates.DSIGeneralVehicleStates")) : class$org$dsi$ifc$generalvehiclestates$DSIGeneralVehicleStates).getName().equals(string)) {
                DSIGeneralVehicleStates dSIGeneralVehicleStates = (DSIGeneralVehicleStates)ASLCarContainer.getInstance().getDSIProxy().getService(this, class$org$dsi$ifc$generalvehiclestates$DSIGeneralVehicleStates == null ? (class$org$dsi$ifc$generalvehiclestates$DSIGeneralVehicleStates = ASLTargetPersonalisation.class$("org.dsi.ifc.generalvehiclestates.DSIGeneralVehicleStates")) : class$org$dsi$ifc$generalvehiclestates$DSIGeneralVehicleStates);
                dSIGeneralVehicleStates.setNotification(new int[]{7}, ASLCarContainer.getInstance().getAdapterFactory().createDSIListenerMethodAdapter(this, class$org$dsi$ifc$generalvehiclestates$DSIGeneralVehicleStatesListener == null ? (class$org$dsi$ifc$generalvehiclestates$DSIGeneralVehicleStatesListener = ASLTargetPersonalisation.class$("org.dsi.ifc.generalvehiclestates.DSIGeneralVehicleStatesListener")) : class$org$dsi$ifc$generalvehiclestates$DSIGeneralVehicleStatesListener));
            }
        }
        catch (Throwable throwable) {
            this.warn("Could not connect to DSIGeneralVehicleStates");
        }
    }

    @Override
    public void unregistered(String string, int n) {
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

