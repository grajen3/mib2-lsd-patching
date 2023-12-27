/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.phone;

import de.vw.mib.asl.api.phone.callback.PhoneConnectedUpdate;
import de.vw.mib.asl.framework.api.diagnosis.config.Adaptation;
import de.vw.mib.asl.framework.api.dsiproxy.DSIProxy;
import de.vw.mib.asl.framework.api.dsiproxy.DSIProxyFactory;
import de.vw.mib.asl.framework.api.framework.ASLFrameworkFactory;
import de.vw.mib.asl.framework.api.framework.speller.ASLAPISpellerBinding;
import de.vw.mib.asl.framework.internal.framework.AbstractASLHsmTarget;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.phone.ASLPhoneData;
import de.vw.mib.asl.internal.phone.HsmPhonePhoneAvailability$AssociatedAvailabilityListener;
import de.vw.mib.asl.internal.phone.HsmPhonePhoneAvailability$NadAvailabilityListener;
import de.vw.mib.asl.internal.phone.HsmPhonePhoneAvailability$PrimaryAvailabilityListener;
import de.vw.mib.asl.internal.phone.api.impl.PhoneServiceImpl;
import de.vw.mib.asl.internal.phone.selection.phone.transformer.PhoneSelectionPhonePhoneSelectionCollector;
import de.vw.mib.asl.internal.phone.util.PhoneUtil;
import de.vw.mib.asl.internal.phone.util.TripleMobileEquipment;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.GenericEventException;
import de.vw.mib.genericevents.GenericEvents;
import de.vw.mib.util.Util;
import generated.de.vw.mib.asl.internal.ListManager;
import generated.de.vw.mib.asl.internal.phone.bluetooth.transformer.PhoneBluetoothSelectedbondingDeviceCollector;
import java.util.ArrayList;
import java.util.Iterator;
import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.bluetooth.DSIBluetooth;
import org.dsi.ifc.bluetooth.ReconnectInfo;
import org.dsi.ifc.organizer.DSIAdbSetup;
import org.dsi.ifc.telephoneng.ActivationStateStruct;
import org.dsi.ifc.telephoneng.DSIMobileEquipmentListener;
import org.dsi.ifc.telephoneng.LockStateStruct;
import org.dsi.ifc.telephoneng.PhoneInformation;

public class HsmPhonePhoneAvailability
extends TripleMobileEquipment {
    public static final int EV_ADAPTATION;
    public static final int EV_AUTOMATIC_TOGGLE;
    public static final int EV_CHECKAVAILABILITY;
    public static final int EV_AVAILABILITYLISTENER;
    private DSIBluetooth dsiBluetooth;
    private DSIAdbSetup dsiAdbSetup;
    private DSIListener dsiBluetoothListener;
    private DSIListener dsiAdbSetupListener;
    private boolean pinVerificationInProgress = false;
    public static boolean btIsOnAndPossiblySwitchedOff;
    private ASLAPISpellerBinding spellerHsm;
    private LockStateStruct lockState;
    private ActivationStateStruct activationStatePhone = new ActivationStateStruct();
    private ActivationStateStruct activationStatePhoneAssociated = new ActivationStateStruct();
    private ActivationStateStruct activationStateNad = new ActivationStateStruct();
    private int adbState = 1;
    private boolean suspendPhoneInitUpdate = false;
    private boolean suspendPhoneInitUpdateFromMedia = false;
    private int telPrimaryActivationStateLastSet = -1;
    private int telPhoneModuleStateLastSet = -1;
    private int telAssociatedActivationStateLastSet = -1;
    private boolean validActivationStateSet = false;
    private boolean validBTStateSet = false;
    private boolean nadEnabled = false;
    private boolean isAdaptationUserModeSwitch = false;
    private boolean alreadyRegistered = false;
    private boolean intermediatePhoneInitUpdate = true;
    private boolean domainSetAvailable = false;
    private final ArrayList phoneConnectedUpdates = new ArrayList();
    private boolean simEmpty = true;
    private boolean newSIMInserted = false;
    private String alreadyToggledMacOrSimId = "";
    private boolean phoneFullyOperable = false;
    private String currentReconnectPhoneName = "";
    private String currentPhoneDeviceName = "";
    static /* synthetic */ Class class$org$dsi$ifc$bluetooth$DSIBluetooth;
    static /* synthetic */ Class class$org$dsi$ifc$organizer$DSIAdbSetup;
    static /* synthetic */ Class class$org$dsi$ifc$bluetooth$DSIBluetoothListener;
    static /* synthetic */ Class class$org$dsi$ifc$organizer$DSIAdbSetupListener;

    public HsmPhonePhoneAvailability(GenericEvents genericEvents, String string) {
        super(genericEvents, string);
        btIsOnAndPossiblySwitchedOff = false;
    }

    @Override
    public int getDefaultTargetId() {
        return 5251;
    }

    private void init() {
        this.info("HsmPhonePhoneAvailability.init()");
        if (!this.alreadyRegistered) {
            DSIProxy dSIProxy = DSIProxyFactory.getDSIProxyAPI().getDSIProxy();
            this.dsiBluetooth = (DSIBluetooth)dSIProxy.getService(this, class$org$dsi$ifc$bluetooth$DSIBluetooth == null ? (class$org$dsi$ifc$bluetooth$DSIBluetooth = HsmPhonePhoneAvailability.class$("org.dsi.ifc.bluetooth.DSIBluetooth")) : class$org$dsi$ifc$bluetooth$DSIBluetooth);
            this.dsiAdbSetup = (DSIAdbSetup)dSIProxy.getService(this, class$org$dsi$ifc$organizer$DSIAdbSetup == null ? (class$org$dsi$ifc$organizer$DSIAdbSetup = HsmPhonePhoneAvailability.class$("org.dsi.ifc.organizer.DSIAdbSetup")) : class$org$dsi$ifc$organizer$DSIAdbSetup);
            this.dsiBluetoothListener = dSIProxy.getAdapterFactory().createDSIListenerMethodAdapter(this, class$org$dsi$ifc$bluetooth$DSIBluetoothListener == null ? (class$org$dsi$ifc$bluetooth$DSIBluetoothListener = HsmPhonePhoneAvailability.class$("org.dsi.ifc.bluetooth.DSIBluetoothListener")) : class$org$dsi$ifc$bluetooth$DSIBluetoothListener);
            this.dsiAdbSetupListener = dSIProxy.getAdapterFactory().createDSIListenerMethodAdapter(this, class$org$dsi$ifc$organizer$DSIAdbSetupListener == null ? (class$org$dsi$ifc$organizer$DSIAdbSetupListener = HsmPhonePhoneAvailability.class$("org.dsi.ifc.organizer.DSIAdbSetupListener")) : class$org$dsi$ifc$organizer$DSIAdbSetupListener);
            dSIProxy.addResponseListener(this, class$org$dsi$ifc$bluetooth$DSIBluetoothListener == null ? (class$org$dsi$ifc$bluetooth$DSIBluetoothListener = HsmPhonePhoneAvailability.class$("org.dsi.ifc.bluetooth.DSIBluetoothListener")) : class$org$dsi$ifc$bluetooth$DSIBluetoothListener, this.dsiBluetoothListener);
            this.addObserver(-476299008);
            this.addObserver(362627328);
            this.addObserver(379404544);
            this.addObserver(-2075192832);
            this.addObserver(-771555264);
            this.addObserver(-715385536);
            this.addObserver(-704446400);
            this.spellerHsm = ASLFrameworkFactory.getASLFrameworkAPI().getServices().getASLAPISpellerFactory().createSimpleCursor(1193, -715385536, -771555264, -704446400);
            ListManager.getGenericASLList(1198).updateList(new PhoneSelectionPhonePhoneSelectionCollector[0]);
        }
        this.alreadyRegistered = true;
        PhoneServiceImpl.getInstance().targetReady(this.getDefaultTargetId());
    }

    private void setNotification() {
        this.dsiBluetooth.setNotification(new int[]{3, 10}, this.dsiBluetoothListener);
        this.dsiAdbSetup.setNotification(1, this.dsiAdbSetupListener);
    }

    private void setAssociatedActivationState(int n) {
        if (n != 7 && n != 0) {
            if (n == 2) {
                n = 5;
            }
            if (n != this.telAssociatedActivationStateLastSet) {
                if (!(n != 5 || this.telAssociatedActivationStateLastSet != 1 && this.telAssociatedActivationStateLastSet != 12 && this.telAssociatedActivationStateLastSet != 5 || !PhoneUtil.isPhoneDeviceProfile(ASLPhoneData.getInstance().requestedService) && ASLPhoneData.getInstance().requestedService != 1)) {
                    if (this.isTraceEnabled()) {
                        this.trace().append("send event BLUETOOTH_DEVICE_CONNECTED from associated activationState").log();
                    }
                    ASLPhoneData.getInstance().lastDeviceConnectedPrimary = false;
                    PhoneUtil.reportDeviceConnected(this);
                }
                this.telAssociatedActivationStateLastSet = n;
            }
        }
    }

    private void setPrimaryActivationState(int n) {
        this.info("activationState: ", n);
        if (n != 7 && n != 0) {
            if (n == 2) {
                n = 5;
            }
            if (n != this.telPrimaryActivationStateLastSet) {
                AbstractASLHsmTarget.writeIntegerToDatapool(2906, n);
                AbstractASLHsmTarget.writeIntegerToDatapool(315580672, n);
                AbstractASLHsmTarget.writeIntegerToDatapool(-245209600, n);
                if (n == 12 && this.telPrimaryActivationStateLastSet == 1 || n == 1 && this.telPrimaryActivationStateLastSet == 12 || n == 4 && this.telPrimaryActivationStateLastSet == 1 || n == 4 && this.telPrimaryActivationStateLastSet == 12 || n == 1 && this.telPrimaryActivationStateLastSet == 4 || n == 12 && this.telPrimaryActivationStateLastSet == 4 && n != 5) {
                    this.sendHMIEvent(454);
                } else {
                    if (this.isTraceEnabled()) {
                        this.trace().append("try to send event PHONE_INIT_UPDATE from activationState").log();
                    }
                    this.sendPhoneInitUpdate(true);
                }
                if (!(n != 5 || this.telPrimaryActivationStateLastSet != 1 && this.telPrimaryActivationStateLastSet != 12 && this.telPrimaryActivationStateLastSet != 5 || !PhoneUtil.isPhoneDeviceProfile(ASLPhoneData.getInstance().requestedService) && ASLPhoneData.getInstance().requestedService != 1)) {
                    if (this.isTraceEnabled()) {
                        this.trace().append("send event BLUETOOTH_DEVICE_CONNECTED from activationState").log();
                    }
                    ASLPhoneData.getInstance().lastDeviceConnectedPrimary = true;
                    PhoneUtil.reportDeviceConnected(this);
                }
                this.telPrimaryActivationStateLastSet = n;
            }
        }
    }

    private void handleBluetoothState() {
        HsmPhonePhoneAvailability.writeBooleanToDatapool(1133, ASLPhoneData.getInstance().btState == 0);
        this.sendHMIEvent(156);
        switch (ASLPhoneData.getInstance().btState) {
            case 0: {
                this.sendHMIEvent(142);
                btIsOnAndPossiblySwitchedOff = true;
                break;
            }
            case 1: {
                this.sendHMIEvent(140);
                btIsOnAndPossiblySwitchedOff = false;
                break;
            }
            case 3: {
                btIsOnAndPossiblySwitchedOff = false;
                break;
            }
            case 4: {
                btIsOnAndPossiblySwitchedOff = true;
                break;
            }
        }
    }

    private void handleReconnectIndicator(ReconnectInfo reconnectInfo) {
        String string = "";
        for (int i2 = 0; i2 < reconnectInfo.serviceTypeList.length; ++i2) {
            if (reconnectInfo.serviceTypeList[i2] != 2 && reconnectInfo.serviceTypeList[i2] != 4) continue;
            string = reconnectInfo.deviceNameList[i2];
            break;
        }
        if (this.activationStatePhone.getTelActivationState() == 12) {
            if (this.isTraceEnabled()) {
                this.trace().append("handleReconnectindicator: AS == RECONNECTING -> setting reconnectPhone as phone device name: ").append(string).log();
            }
            PhoneUtil.setDeviceName(string);
        }
        this.currentReconnectPhoneName = string;
    }

    private void handleLockState() {
        int n = ASLPhoneData.getInstance().lockState;
        ASLPhoneData.getInstance().lockState = this.lockState.telLockState;
        HsmPhonePhoneAvailability.writeIntegerToDatapool(3618, this.lockState.telRetryCounter);
        if (this.lockState.telLockState == 1) {
            if (!ASLPhoneData.getInstance().isPukUnlockRequested) {
                this.sendHMIEvent(192);
            } else {
                this.sendHMIEvent(194);
            }
            if (n != 5) {
                this.pinVerificationInProgress = true;
            }
        }
        if (this.pinVerificationInProgress && this.lockState.telLockState != 1) {
            this.pinVerificationInProgress = false;
            if (this.lockState.telLockState != 2) {
                if (!ASLPhoneData.getInstance().isPukUnlockRequested) {
                    this.sendHMIEvent(191);
                } else {
                    this.sendHMIEvent(193);
                }
            }
        }
        if (this.lockState.telLockState == 2) {
            if (ASLPhoneData.getInstance().isSimUnlockedByUserAfterInserting && ASLPhoneData.getInstance().isAutomaticPinEntryCancelled) {
                this.sendHMIEvent(-410839808);
            }
            if (ASLPhoneData.getInstance().isAutomaticPinEntryPending) {
                this.getNad().requestSetAutomaticPinEntryActive(!ASLPhoneData.getInstance().isAutomaticPinEntryCancelled);
                ASLPhoneData.getInstance().isAutomaticPinEntryPending = false;
            }
            ASLPhoneData.getInstance().isAutomaticPinEntryCancelled = false;
            ASLPhoneData.getInstance().isSimUnlockedByUserAfterInserting = false;
        }
        PhoneUtil.refreshPhoneSelectionList();
        PhoneUtil.enablePINSettings();
        PhoneUtil.setNetworkingAvailable();
        if (this.lockState.telLockState == 11) {
            this.sendPhoneInitUpdate(false);
        }
    }

    private static boolean isOn(ActivationStateStruct activationStateStruct) {
        return activationStateStruct != null && (activationStateStruct.telActivationState == 5 || activationStateStruct.telActivationState == 2);
    }

    private void handleActivationState(ActivationStateStruct activationStateStruct) {
        if (activationStateStruct.telActivationState == 5 && ServiceManager.perfService != null) {
            ServiceManager.perfService.performanceLogMsgByID(7);
        }
        if (activationStateStruct.telActivationState == 1) {
            EventGeneric eventGeneric = ServiceManager.mGenericEventFactory.newEvent(-1628555776);
            this.sendSafe(eventGeneric);
        }
        if (activationStateStruct.telMode == 2 || activationStateStruct.telMode == 0) {
            activationStateStruct.telFeat = (short)506;
        }
        if (activationStateStruct.getTelActivationState() == 2 && this.activationStatePhone.getTelActivationState() == activationStateStruct.getTelActivationState() && Util.isBitSet(1, (int)activationStateStruct.getTelFeat()) != Util.isBitSet(1, ASLPhoneData.getInstance().telFeatures)) {
            this.sendSafe(ServiceManager.mGenericEventFactory.newEvent(5251, 1922634752, -1896991232));
        }
        ASLPhoneData.getInstance().telFeatures = activationStateStruct.telFeat;
        HsmPhonePhoneAvailability.writeIntegerToDatapool(1103, activationStateStruct.telFeat);
        ASLPhoneData.getInstance().telMode = activationStateStruct.telMode;
        ASLPhoneData.getInstance().connected = HsmPhonePhoneAvailability.isOn(activationStateStruct) || HsmPhonePhoneAvailability.isOn(this.activationStatePhoneAssociated);
        this.phoneAvailabilityUpdate();
        if (!ASLPhoneData.getInstance().connected) {
            PhoneUtil.releaseAudioConnection(this, true);
            PhoneUtil.releaseAudioConnection(this, false);
        } else {
            this.suspendPhoneInitUpdate = false;
        }
        this.activationStatePhone = activationStateStruct;
        this.enableContactsIfAvailable();
        PhoneUtil.setFreeLine();
        this.setInternalRingtonesAvailable();
    }

    private void phoneAvailabilityUpdate() {
        if (ASLPhoneData.getInstance().connected != this.phoneFullyOperable) {
            this.phoneFullyOperable = ASLPhoneData.getInstance().connected && (!this.isNadPrimary() || ASLPhoneData.getInstance().lockState == 2);
            Iterator iterator = this.phoneConnectedUpdates.iterator();
            while (iterator.hasNext()) {
                PhoneConnectedUpdate phoneConnectedUpdate = (PhoneConnectedUpdate)iterator.next();
                phoneConnectedUpdate.onChange(this.phoneFullyOperable);
            }
        }
    }

    private void handleActivationStateAssociated(ActivationStateStruct activationStateStruct) {
        if (activationStateStruct.telMode == 2 || activationStateStruct.telMode == 0) {
            activationStateStruct.telFeat = (short)506;
        }
        if (activationStateStruct.getTelActivationState() == 2 && this.activationStatePhoneAssociated.getTelActivationState() == activationStateStruct.getTelActivationState() && Util.isBitSet(1, (int)activationStateStruct.getTelFeat()) != Util.isBitSet(1, ASLPhoneData.getInstance().telFeaturesAssociated)) {
            this.sendSafe(ServiceManager.mGenericEventFactory.newEvent(5251, 1922634752, -1896991232));
        }
        ASLPhoneData.getInstance().telFeaturesAssociated = activationStateStruct.telFeat;
        HsmPhonePhoneAvailability.writeIntegerToDatapool(-779938560, activationStateStruct.telFeat);
        ASLPhoneData.getInstance().telModeAssociated = activationStateStruct.telMode;
        if (activationStateStruct.telActivationState == 9) {
            this.sendHMIEvent(562);
        }
        if (activationStateStruct.telMode == 2) {
            if (HsmPhonePhoneAvailability.isPhoneAttached(activationStateStruct)) {
                AbstractASLHsmTarget.writeIntegerToDatapool(209982720, 1);
            } else {
                AbstractASLHsmTarget.writeIntegerToDatapool(209982720, 0);
            }
        } else if (activationStateStruct.telMode == 3) {
            if (HsmPhonePhoneAvailability.isPhoneAttached(activationStateStruct)) {
                AbstractASLHsmTarget.writeIntegerToDatapool(209982720, 3);
            } else {
                AbstractASLHsmTarget.writeIntegerToDatapool(209982720, 0);
            }
        } else {
            AbstractASLHsmTarget.writeIntegerToDatapool(209982720, 0);
        }
        if (!HsmPhonePhoneAvailability.isPhoneAttached(this.activationStatePhoneAssociated) && HsmPhonePhoneAvailability.isPhoneAttached(activationStateStruct)) {
            this.sendPhoneInitUpdate(true);
        }
        this.activationStatePhoneAssociated = activationStateStruct;
        PhoneUtil.setFreeLine();
    }

    private void setInternalRingtonesAvailable() {
        HsmPhonePhoneAvailability.writeBooleanToDatapool(1240, !Util.isBitSet(1, ASLPhoneData.getInstance().telFeatures));
    }

    private void reportIfSIMEjected(int n) {
        if (this.activationStateNad.telPhoneModuleState == 2 && n == 0 && ASLPhoneData.getInstance().telModeNad != 0) {
            this.sendHMIEvent(-679275264);
        }
    }

    private void checkAvailability() {
        Object[] objectArray;
        if (ASLPhoneData.getInstance().btState == 2 || ASLPhoneData.getInstance().btState == 5) {
            this.sendSafe(ServiceManager.mGenericEventFactory.newEvent(5251, 5900, -1913768448));
        }
        if (this.lockState == null || this.activationStatePhone == null) {
            return;
        }
        if (this.activationStateNad != null && ServiceManager.configManagerDiag.isFeatureFlagSet(73)) {
            int n = ASLPhoneData.getInstance().nadEnabledPhone = this.activationStateNad.telPhoneModuleState == 2 ? 1 : 0;
            if (this.activationStateNad.telMode == 4 || this.activationStateNad.telMode == 3) {
                HsmPhonePhoneAvailability.writeIntegerToDatapool(1081, 0);
                HsmPhonePhoneAvailability.writeIntegerToDatapool(1079, 0);
            } else if (this.activationStateNad.telMode == 0) {
                if (HsmPhonePhoneAvailability.isOn(this.activationStateNad)) {
                    HsmPhonePhoneAvailability.writeIntegerToDatapool(1081, 2);
                } else {
                    HsmPhonePhoneAvailability.writeIntegerToDatapool(1081, 1);
                }
            } else if (this.activationStateNad.telMode == 1) {
                if (HsmPhonePhoneAvailability.isOn(this.activationStateNad)) {
                    HsmPhonePhoneAvailability.writeIntegerToDatapool(1079, 2);
                } else {
                    HsmPhonePhoneAvailability.writeIntegerToDatapool(1079, 1);
                }
            }
            boolean bl = this.nadEnabled = this.activationStateNad.getTelPhoneModuleState() == 2;
            if (ASLPhoneData.getInstance().nadEnabledIndependent == 0 && this.nadEnabled || ASLPhoneData.getInstance().nadEnabledIndependent == 1 && !this.nadEnabled || ASLPhoneData.getInstance().nadEnabledIndependent == -1) {
                if (this.isTraceEnabled() && !this.suspendPhoneInitUpdate && !this.suspendPhoneInitUpdateFromMedia) {
                    this.trace().append("try to send event PHONE_INIT_UPDATE from isNADEnabled").log();
                }
                this.sendPhoneInitUpdate(true);
            }
            HsmPhonePhoneAvailability.writeBooleanToDatapool(2909, this.nadEnabled);
            if (this.nadEnabled) {
                this.sendHMIEvent(185);
            } else {
                this.sendHMIEvent(-645720832);
            }
            if (this.telPhoneModuleStateLastSet != this.activationStateNad.getTelPhoneModuleState()) {
                AbstractASLHsmTarget.writeIntegerToDatapool(3852, this.activationStateNad.getTelPhoneModuleState());
                if (this.isTraceEnabled() && !this.suspendPhoneInitUpdate && !this.suspendPhoneInitUpdateFromMedia) {
                    this.trace().append("try to send event PHONE_INIT_UPDATE from activationState - Phone module").log();
                }
                this.sendPhoneInitUpdate(true);
                this.telPhoneModuleStateLastSet = this.activationStateNad.getTelPhoneModuleState();
            }
        } else {
            ASLPhoneData.getInstance().nadEnabledPhone = -1;
            HsmPhonePhoneAvailability.writeIntegerToDatapool(1081, 0);
            HsmPhonePhoneAvailability.writeIntegerToDatapool(1079, 0);
        }
        if (!Util.isNullOrEmpty(objectArray = (PhoneBluetoothSelectedbondingDeviceCollector[])ListManager.getGenericASLList(1143).getDSIObjects())) {
            ((PhoneBluetoothSelectedbondingDeviceCollector)objectArray[0]).phone_bluetooth_selected_device_simap_temporary_available = PhoneUtil.isSimapTemporarilyAvailable();
        }
        ListManager.getGenericASLList(1143).updateList(objectArray);
    }

    private void sendPhoneInitUpdate(boolean bl) {
        if ((bl || this.intermediatePhoneInitUpdate) && !this.suspendPhoneInitUpdate && !this.suspendPhoneInitUpdateFromMedia && this.validActivationStateSet && this.validBTStateSet) {
            if (this.isTraceEnabled()) {
                this.trace().append("actually send PHONE_INIT_UPDATE").log();
            }
            this.sendHMIEvent(452);
            this.sendHMIEvent(332357888);
            this.sendHMIEvent(-245209600);
        } else {
            if (this.isTraceEnabled()) {
                this.trace().append("not sending PHONE_INIT_UPDATE: suspendPhoneInitUpdate: ").append(this.suspendPhoneInitUpdate).append(", validActivationStateSet: ").append(this.validActivationStateSet).append(", validBTStateSet: ").append(this.validBTStateSet).append(", intermediatePhoneInitUpdate").append(this.intermediatePhoneInitUpdate).log();
            }
            if (bl && (this.suspendPhoneInitUpdate || this.suspendPhoneInitUpdateFromMedia)) {
                this.intermediatePhoneInitUpdate = true;
            }
        }
    }

    private void sendBluetoothInitUpdate() {
        if (!this.suspendPhoneInitUpdate && !this.suspendPhoneInitUpdateFromMedia && this.validActivationStateSet && this.validBTStateSet) {
            if (this.isTraceEnabled()) {
                this.trace().append("actually send BLUETOOTH_INIT_UPDATE").log();
            }
            this.sendHMIEvent(479);
        } else if (this.isTraceEnabled()) {
            this.trace().append("not sending BLUETOOTH_INIT_UPDATE: suspendPhoneInitUpdate: ").append(this.suspendPhoneInitUpdate).append(", validActivationStateSet: ").append(this.validActivationStateSet).append(", validBTStateSet: ").append(this.validBTStateSet).log();
        }
    }

    private void enableContactsIfAvailable() {
        boolean bl;
        boolean bl2 = bl = this.adbState == 2 && HsmPhonePhoneAvailability.isOn(this.activationStatePhone);
        if (this.isTraceEnabled()) {
            this.trace().append("Enable contacts: ").append(bl).log();
        }
        AbstractASLHsmTarget.writeBooleanToDatapool(1183, bl);
    }

    @Override
    protected void powerOn() {
        this.init();
        this.setNotification();
        this.triggerObserver(-1611778560, null);
        try {
            ServiceManager.adaptionApi.requestConfigManagerPersAdaptation(this.getTargetId(), -1601830656);
        }
        catch (GenericEventException genericEventException) {
            this.error(genericEventException);
        }
    }

    @Override
    protected void handleEvent(EventGeneric eventGeneric) {
        switch (eventGeneric.getReceiverEventId()) {
            case 6100029: {
                AbstractASLHsmTarget.writeStringToDatapool(-293399296, eventGeneric.getString(0));
                break;
            }
            case 6200003: {
                ASLPhoneData.getInstance().androidAutoShown = false;
                break;
            }
            case 6200002: {
                ASLPhoneData.getInstance().androidAutoShown = true;
                break;
            }
            case 1200004: {
                ServiceManager.adaptionApi.requestConfigManagerPersAdaptation(this.getTargetId(), -1601830656);
                break;
            }
            case 1073742802: 
            case 1073742806: 
            case 1075141845: {
                this.spellerHsm.handleEvent(eventGeneric);
                break;
            }
            case 100000: {
                if (eventGeneric.getResult() != 0 || !this.isNamespaceKey(eventGeneric, -536825343, 0)) break;
                Adaptation adaptation = (Adaptation)eventGeneric.getObject(1);
                this.isAdaptationUserModeSwitch = adaptation.getBoolean(154);
                ASLPhoneData.getInstance().defaultSimCardModeVoice = adaptation.getValue(155) == 0;
                this.info().append("Adaptation default for NAD mode is voice: ").append(ASLPhoneData.getInstance().defaultSimCardModeVoice).log();
                ASLPhoneData.getInstance().isDTMFWithoutActiveCall = adaptation.getBoolean(152);
                AbstractASLHsmTarget.writeBooleanToDatapool(-729606912, this.isAdaptationUserModeSwitch);
                AbstractASLHsmTarget.writeBooleanToDatapool(1932788480, this.isAdaptationUserModeSwitch);
                break;
            }
            case 100002: {
                this.checkAvailability();
                break;
            }
            case 100003: {
                PhoneConnectedUpdate phoneConnectedUpdate = (PhoneConnectedUpdate)eventGeneric.getObject(0);
                this.addPhoneConnectedUpdate(phoneConnectedUpdate);
                break;
            }
            case 100001: {
                this.triggerObserver(302710848, null);
                break;
            }
            case 1073742804: {
                this.spellerHsm.resetSpellerData();
                break;
            }
            case 1073744404: {
                String string = this.spellerHsm.getSpellerData().getEnteredText();
                EventGeneric eventGeneric2 = ServiceManager.mGenericEventFactory.newEvent(5251, 5253, -1829882368);
                eventGeneric2.setString(0, string);
                eventGeneric2.setBoolean(1, true);
                this.send(eventGeneric2);
                break;
            }
            case 1073744405: {
                String string = this.spellerHsm.getSpellerData().getEnteredText();
                EventGeneric eventGeneric3 = ServiceManager.mGenericEventFactory.newEvent(5251, 5253, -1829882368);
                eventGeneric3.setString(0, string);
                eventGeneric3.setBoolean(1, false);
                this.send(eventGeneric3);
                break;
            }
            case 1075141855: {
                this.suspendPhoneInitUpdateFromMedia = true;
                if (this.suspendPhoneInitUpdate) break;
                if (this.isTraceEnabled()) {
                    this.trace().append("setting intermediatePhoneInitUpdate to false from SET_BONDING_SEARCH_FROM_MEDIA_ENTERED").log();
                }
                this.intermediatePhoneInitUpdate = false;
                break;
            }
            case 1075141856: {
                this.suspendPhoneInitUpdateFromMedia = false;
                if (this.isTraceEnabled()) {
                    this.trace().append("try to send event PHONE_INIT_UPDATE from SET_BONDING_SEARCH_FROM_MEDIA_LEFT").log();
                }
                this.sendPhoneInitUpdate(false);
                if (this.suspendPhoneInitUpdate) break;
                if (this.isTraceEnabled()) {
                    this.trace().append("setting intermediatePhoneInitUpdate to true from SET_BONDING_SEARCH_FROM_MEDIA_LEFT").log();
                }
                this.intermediatePhoneInitUpdate = true;
                break;
            }
            case 3600007: {
                this.suspendPhoneInitUpdate = eventGeneric.getBoolean(0);
                if (this.suspendPhoneInitUpdate && !this.suspendPhoneInitUpdateFromMedia) {
                    if (this.isTraceEnabled()) {
                        this.trace().append("setting intermediatePhoneInitUpdate to false from ASL_PHONE_SUSPEND_INIT_VALUES").log();
                    }
                    this.intermediatePhoneInitUpdate = false;
                }
                if (this.suspendPhoneInitUpdate) break;
                if (this.isTraceEnabled()) {
                    this.trace().append("try to send event PHONE_INIT_UPDATE from ASL_PHONE_SUSPEND_INIT_VALUES = false").log();
                }
                this.sendPhoneInitUpdate(false);
                if (this.suspendPhoneInitUpdateFromMedia) break;
                if (this.isTraceEnabled()) {
                    this.trace().append("setting intermediatePhoneInitUpdate to true from ASL_PHONE_SUSPEND_INIT_VALUES").log();
                }
                this.intermediatePhoneInitUpdate = true;
                break;
            }
            case 4300053: {
                ASLPhoneData.getInstance().standbyActive = true;
                this.checkTogglePhoneAutomatically();
                break;
            }
            case 4300054: {
                ASLPhoneData.getInstance().standbyActive = false;
                this.checkTogglePhoneAutomatically();
                break;
            }
            case 4300003: {
                ASLPhoneData.getInstance().isClampSOn = eventGeneric.getBoolean(0);
                if (!this.suspendPhoneInitUpdate || !eventGeneric.getBoolean(0)) break;
                this.suspendPhoneInitUpdate = false;
                this.sendPhoneInitUpdate(true);
                break;
            }
            case 3600044: {
                this.checkTogglePhoneAutomatically();
                break;
            }
        }
    }

    private void addPhoneConnectedUpdate(PhoneConnectedUpdate phoneConnectedUpdate) {
        phoneConnectedUpdate.onChange(this.phoneFullyOperable);
        this.phoneConnectedUpdates.add(phoneConnectedUpdate);
    }

    private boolean isNamespaceKey(EventGeneric eventGeneric, int n, long l) {
        int n2 = eventGeneric.getInt(2);
        long l2 = eventGeneric.getLong(3);
        return n2 == n && l2 == l;
    }

    private void handlePhoneInformation(PhoneInformation phoneInformation) {
        Object object;
        int n = 0;
        if (!Util.isNullOrEmpty(phoneInformation.getSimId())) {
            if (Util.isNullOrEmpty(phoneInformation.getMeBtAddress())) {
                object = ASLPhoneData.persistence.getLastConnectedSimId();
                if (((String)object).equals(phoneInformation.getSimId())) {
                    if (this.simEmpty) {
                        int n2;
                        AbstractASLHsmTarget.writeBooleanToDatapool(-746384128, true);
                        AbstractASLHsmTarget.writeBooleanToDatapool(1916011264, true);
                        this.newSIMInserted = true;
                        int n3 = ASLPhoneData.persistence.getConnectedSimDataOnlyStateDifferentThanAdaptationDefault() ? (ASLPhoneData.getInstance().defaultSimCardModeVoice ? 2 : 1) : (n2 = ASLPhoneData.getInstance().defaultSimCardModeVoice ? 1 : 2);
                        if (ASLPhoneData.getInstance().nadMode != n2) {
                            if (n2 == 1 && (ASLPhoneData.getInstance().carPlayConnected || ASLPhoneData.getInstance().androidAutoConnected)) {
                                this.sendHMIEvent(-461171456);
                            } else {
                                n = n2;
                                this.info("NAD mode changed due to a known SIM being inserted and the last mode being different than the current NAD mode. mode=", PhoneUtil.getNadModeStr(n));
                            }
                        }
                    }
                } else {
                    if (this.simEmpty) {
                        boolean bl = this.newSIMInserted = !ASLPhoneData.getInstance().androidAutoConnected && !ASLPhoneData.getInstance().carPlayConnected;
                        if (!this.newSIMInserted) {
                            this.sendHMIEvent(-461171456);
                        }
                    }
                    ASLPhoneData.persistence.setConnectedSimDataOnlyStateDifferentThanAdaptationDefault(false);
                }
                ASLPhoneData.persistence.setLastConnectedSimId(phoneInformation.getSimId());
                this.simEmpty = false;
            } else {
                this.simEmpty = true;
            }
        } else {
            AbstractASLHsmTarget.writeBooleanToDatapool(-746384128, false);
            AbstractASLHsmTarget.writeBooleanToDatapool(1916011264, false);
            this.newSIMInserted = false;
            this.simEmpty = true;
        }
        if (n != 0) {
            object = ServiceManager.mGenericEventFactory.newEvent();
            ((EventGeneric)object).setBoolean(0, n != 2);
            this.triggerObserver(1510802240, (EventGeneric)object);
        }
        this.checkSendSimInserted();
    }

    private void checkSendSimInserted() {
        if (this.newSIMInserted && this.lockState != null && (this.lockState.getTelLockState() == 2 || this.lockState.getTelLockState() == 3 || this.lockState.getTelLockState() == 5)) {
            this.sendHMIEvent(576);
            this.newSIMInserted = false;
        }
    }

    private void checkTogglePhoneAutomatically() {
        if (this.isTraceEnabled()) {
            this.trace("Stopping timer EV_AUTOMATIC_TOGGLE.");
        }
        this.stopTimer(-1585053440);
        if (this.isTraceEnabled()) {
            this.trace().append("HsmPhonePhoneAvailability.checkTogglePhoneAutomatically() activation states primary: ").append(this.activationStatePhone.getTelActivationState()).append(", associated: ").append(this.activationStatePhoneAssociated.getTelActivationState()).append(", phone module: ").append(this.activationStateNad.getTelPhoneModuleState()).append(", isConnectRequested: ").append(ASLPhoneData.getInstance().isConnectRequested).log();
        }
        if (ServiceManager.configManagerDiag.isFeatureFlagSet(73) && this.activationStatePhone.getTelActivationState() == 4 && HsmPhonePhoneAvailability.isOn(this.activationStatePhoneAssociated) && this.activationStateNad.getTelPhoneModuleState() == 3) {
            if (this.isTraceEnabled()) {
                this.trace("Triggering automatic toggle directly due to not connected primary phone and switched off phone module!");
            }
            this.triggerObserver(302710848, null);
        }
        if (ASLPhoneData.getInstance().isClampSOn && (this.activationStatePhone.getTelActivationState() == 1 || this.activationStatePhone.getTelActivationState() == 4 || this.activationStatePhone.getTelActivationState() == 1 || this.activationStatePhone.getTelActivationState() == 12) && HsmPhonePhoneAvailability.isOn(this.activationStatePhoneAssociated)) {
            if (ASLPhoneData.getInstance().internalSIMConnected) {
                this.startTimer(-1585053440, (long)0, false);
                if (this.isTraceEnabled()) {
                    this.trace("Triggering automatic toggle in 30s due to not connected primary phone and inserted SIM and clamp S on!");
                }
            } else if (ServiceManager.configManagerDiag.isFeatureFlagSet(378) && !ASLPhoneData.getInstance().isConnectRequested) {
                this.startTimer(-1585053440, (long)0, false);
                if (this.isTraceEnabled()) {
                    this.trace("Triggering automatic toggle in 1s due to not connected primary phone, no SIM involved, no connection request and clamp S on!");
                }
            }
        }
    }

    private static boolean isPhoneAttached(ActivationStateStruct activationStateStruct) {
        return activationStateStruct != null && (activationStateStruct.telActivationState == 5 || activationStateStruct.telActivationState == 2 || activationStateStruct.telActivationState == 9);
    }

    public void dsiBluetoothUpdateBTState(int n, int n2) {
        EventGeneric eventGeneric = ServiceManager.mGenericEventFactory.newEvent(-1662110208);
        eventGeneric.setInt(0, n);
        this.sendSafe(eventGeneric);
        this.validBTStateSet = true;
        ASLPhoneData.getInstance().btState = n;
        this.handleBluetoothState();
        AbstractASLHsmTarget.writeIntegerToDatapool(2908, n);
        if (n != 3) {
            if (this.isTraceEnabled() && !this.suspendPhoneInitUpdate && !this.suspendPhoneInitUpdateFromMedia) {
                this.trace().append("try to send event BLUETOOTH_INIT_UPDATE from BTState").log();
            }
            this.sendBluetoothInitUpdate();
        }
        this.checkAvailability();
    }

    public void dsiBluetoothUpdateReconnectIndicator(ReconnectInfo reconnectInfo, int n) {
        this.handleReconnectIndicator(reconnectInfo);
        this.checkAvailability();
    }

    public void dsiAdbSetupUpdateAdbState(int n, int n2) {
        this.adbState = n;
        this.enableContactsIfAvailable();
    }

    @Override
    protected DSIMobileEquipmentListener createPrimaryListener() {
        return new HsmPhonePhoneAvailability$PrimaryAvailabilityListener(this, null);
    }

    @Override
    protected DSIMobileEquipmentListener createAssociatedListener() {
        return new HsmPhonePhoneAvailability$AssociatedAvailabilityListener(this, null);
    }

    @Override
    protected DSIMobileEquipmentListener createNadListener() {
        return new HsmPhonePhoneAvailability$NadAvailabilityListener(this, null);
    }

    @Override
    protected int[] getMobileEquipmentNotification() {
        if (ServiceManager.configManagerDiag.isFeatureFlagSet(73)) {
            return new int[]{4, 20};
        }
        return new int[]{4};
    }

    @Override
    protected int[] getMobileEquipmentNadOnlyNotification() {
        return new int[]{33, 16};
    }

    @Override
    protected int[] getMobileEquipmentHfpOnlyNotification() {
        if (ServiceManager.configManagerDiag.isFeatureFlagSet(73)) {
            return ASLPhoneData.EMPTY_NOTIFICATION;
        }
        return new int[]{20};
    }

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError().initCause(classNotFoundException);
        }
    }

    static /* synthetic */ String access$000(HsmPhonePhoneAvailability hsmPhonePhoneAvailability) {
        return hsmPhonePhoneAvailability.currentReconnectPhoneName;
    }

    static /* synthetic */ String access$100(HsmPhonePhoneAvailability hsmPhonePhoneAvailability) {
        return hsmPhonePhoneAvailability.currentPhoneDeviceName;
    }

    static /* synthetic */ void access$200(HsmPhonePhoneAvailability hsmPhonePhoneAvailability, ActivationStateStruct activationStateStruct) {
        hsmPhonePhoneAvailability.handleActivationState(activationStateStruct);
    }

    static /* synthetic */ boolean access$300(HsmPhonePhoneAvailability hsmPhonePhoneAvailability) {
        return hsmPhonePhoneAvailability.domainSetAvailable;
    }

    static /* synthetic */ boolean access$302(HsmPhonePhoneAvailability hsmPhonePhoneAvailability, boolean bl) {
        hsmPhonePhoneAvailability.domainSetAvailable = bl;
        return hsmPhonePhoneAvailability.domainSetAvailable;
    }

    static /* synthetic */ boolean access$402(HsmPhonePhoneAvailability hsmPhonePhoneAvailability, boolean bl) {
        hsmPhonePhoneAvailability.validActivationStateSet = bl;
        return hsmPhonePhoneAvailability.validActivationStateSet;
    }

    static /* synthetic */ void access$500(HsmPhonePhoneAvailability hsmPhonePhoneAvailability, int n) {
        hsmPhonePhoneAvailability.setPrimaryActivationState(n);
    }

    static /* synthetic */ void access$600(HsmPhonePhoneAvailability hsmPhonePhoneAvailability) {
        hsmPhonePhoneAvailability.checkAvailability();
    }

    static /* synthetic */ void access$700(HsmPhonePhoneAvailability hsmPhonePhoneAvailability) {
        hsmPhonePhoneAvailability.checkTogglePhoneAutomatically();
    }

    static /* synthetic */ boolean access$800(HsmPhonePhoneAvailability hsmPhonePhoneAvailability) {
        return hsmPhonePhoneAvailability.isNadPrimary();
    }

    static /* synthetic */ ActivationStateStruct access$900(HsmPhonePhoneAvailability hsmPhonePhoneAvailability) {
        return hsmPhonePhoneAvailability.activationStatePhone;
    }

    static /* synthetic */ String access$102(HsmPhonePhoneAvailability hsmPhonePhoneAvailability, String string) {
        hsmPhonePhoneAvailability.currentPhoneDeviceName = string;
        return hsmPhonePhoneAvailability.currentPhoneDeviceName;
    }

    static /* synthetic */ void access$1000(HsmPhonePhoneAvailability hsmPhonePhoneAvailability, ActivationStateStruct activationStateStruct) {
        hsmPhonePhoneAvailability.handleActivationStateAssociated(activationStateStruct);
    }

    static /* synthetic */ void access$1100(HsmPhonePhoneAvailability hsmPhonePhoneAvailability, int n) {
        hsmPhonePhoneAvailability.setAssociatedActivationState(n);
    }

    static /* synthetic */ String access$1200(HsmPhonePhoneAvailability hsmPhonePhoneAvailability) {
        return hsmPhonePhoneAvailability.alreadyToggledMacOrSimId;
    }

    static /* synthetic */ String access$1202(HsmPhonePhoneAvailability hsmPhonePhoneAvailability, String string) {
        hsmPhonePhoneAvailability.alreadyToggledMacOrSimId = string;
        return hsmPhonePhoneAvailability.alreadyToggledMacOrSimId;
    }

    static /* synthetic */ boolean access$1300(HsmPhonePhoneAvailability hsmPhonePhoneAvailability) {
        return hsmPhonePhoneAvailability.isNadSecondary();
    }

    static /* synthetic */ void access$1400(HsmPhonePhoneAvailability hsmPhonePhoneAvailability, PhoneInformation phoneInformation) {
        hsmPhonePhoneAvailability.handlePhoneInformation(phoneInformation);
    }

    static /* synthetic */ boolean access$1500(HsmPhonePhoneAvailability hsmPhonePhoneAvailability) {
        return hsmPhonePhoneAvailability.isNadInTopology();
    }

    static /* synthetic */ boolean access$1600(HsmPhonePhoneAvailability hsmPhonePhoneAvailability) {
        return hsmPhonePhoneAvailability.isNadPrimary();
    }

    static /* synthetic */ boolean access$1700(HsmPhonePhoneAvailability hsmPhonePhoneAvailability) {
        return hsmPhonePhoneAvailability.isNadSecondary();
    }

    static /* synthetic */ ActivationStateStruct access$1802(HsmPhonePhoneAvailability hsmPhonePhoneAvailability, ActivationStateStruct activationStateStruct) {
        hsmPhonePhoneAvailability.activationStateNad = activationStateStruct;
        return hsmPhonePhoneAvailability.activationStateNad;
    }

    static /* synthetic */ boolean access$1900(HsmPhonePhoneAvailability hsmPhonePhoneAvailability) {
        return hsmPhonePhoneAvailability.isNadInTopology();
    }

    static /* synthetic */ void access$2000(HsmPhonePhoneAvailability hsmPhonePhoneAvailability, int n) {
        hsmPhonePhoneAvailability.reportIfSIMEjected(n);
    }

    static /* synthetic */ ActivationStateStruct access$1800(HsmPhonePhoneAvailability hsmPhonePhoneAvailability) {
        return hsmPhonePhoneAvailability.activationStateNad;
    }

    static /* synthetic */ LockStateStruct access$2100(HsmPhonePhoneAvailability hsmPhonePhoneAvailability) {
        return hsmPhonePhoneAvailability.lockState;
    }

    static /* synthetic */ LockStateStruct access$2102(HsmPhonePhoneAvailability hsmPhonePhoneAvailability, LockStateStruct lockStateStruct) {
        hsmPhonePhoneAvailability.lockState = lockStateStruct;
        return hsmPhonePhoneAvailability.lockState;
    }

    static /* synthetic */ void access$2200(HsmPhonePhoneAvailability hsmPhonePhoneAvailability) {
        hsmPhonePhoneAvailability.phoneAvailabilityUpdate();
    }

    static /* synthetic */ boolean access$2300(HsmPhonePhoneAvailability hsmPhonePhoneAvailability) {
        return hsmPhonePhoneAvailability.isNadPrimary();
    }

    static /* synthetic */ void access$2400(HsmPhonePhoneAvailability hsmPhonePhoneAvailability) {
        hsmPhonePhoneAvailability.handleLockState();
    }

    static /* synthetic */ boolean access$2500(HsmPhonePhoneAvailability hsmPhonePhoneAvailability) {
        return hsmPhonePhoneAvailability.isNadPrimary();
    }

    static /* synthetic */ boolean access$2600(ActivationStateStruct activationStateStruct) {
        return HsmPhonePhoneAvailability.isPhoneAttached(activationStateStruct);
    }

    static /* synthetic */ void access$2700(HsmPhonePhoneAvailability hsmPhonePhoneAvailability) {
        hsmPhonePhoneAvailability.checkSendSimInserted();
    }

    static /* synthetic */ boolean access$2800(HsmPhonePhoneAvailability hsmPhonePhoneAvailability) {
        return hsmPhonePhoneAvailability.isNadInTopology();
    }
}

