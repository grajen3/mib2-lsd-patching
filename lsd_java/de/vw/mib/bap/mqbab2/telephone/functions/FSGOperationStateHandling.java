/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.mqbab2.telephone.functions;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.functions.BAPFunctionListener;
import de.vw.mib.bap.functions.FSGOperationState;
import de.vw.mib.bap.functions.Property;
import de.vw.mib.bap.functions.PropertyListener;
import de.vw.mib.bap.mqbab2.common.api.phone.PhoneService;
import de.vw.mib.bap.mqbab2.common.api.phone.PhoneServiceListener;
import de.vw.mib.bap.mqbab2.common.api.stages.BAPStage;
import de.vw.mib.bap.mqbab2.common.api.stages.BAPStageInitializer;
import de.vw.mib.bap.mqbab2.common.api.stages.Function;
import de.vw.mib.bap.mqbab2.common.api.system.SystemService;
import de.vw.mib.bap.mqbab2.common.api.system.SystemServiceListener;
import de.vw.mib.bap.mqbab2.common.api.valetparking.ValetParkingService;
import de.vw.mib.bap.mqbab2.common.api.valetparking.ValetParkingServiceListener;
import de.vw.mib.bap.mqbab2.generated.telephone.serializer.FSG_OperationState_Status;
import de.vw.mib.bap.mqbab2.telephone.api.ASLTelephoneConstants;

public final class FSGOperationStateHandling
extends Function
implements FSGOperationState,
Property,
ASLTelephoneConstants,
SystemServiceListener,
PhoneServiceListener,
ValetParkingServiceListener {
    private boolean operationStateSystemDependent = false;
    private int currentOpState = 0;
    private int currentTelState = 0;
    private static final int TEL_STATE_DEPENDING_ON_ACTIVATION_STATE;
    private static final int TEL_STATE_DEPENDING_ON_HFP_CONNECTION_HIGH_TEMP;
    private static final int TEL_STATE_DEPENDING_ON_HFP_CONNECTION_PHONE_MODULE_ON;
    private static final int TEL_STATE_CANT_BE_DETERMINED;
    private static final int TEL_STATE_DEPENDING_ON_NAD_STATE_OFF_AND_BT_ON;
    private static final int TEL_STATE_DEPENDING_ON_NAD_STATE_SWITCHING_ON_AND_BT_ON;
    private static final int[][] BAP_TEL_STATE_MAPPING_TABLE;
    protected static final int[] SYSTEM_LISTENER_IDS;
    protected static final int[] PHONE_LISTENER_IDS;
    protected static final int[] PHONE_LISTENER_HMI_EVENT_IDS;
    protected static final int[] VALET_PARKING_LISTENER_IDS;
    static /* synthetic */ Class class$de$vw$mib$bap$mqbab2$generated$telephone$serializer$FSG_OperationState_Status;

    @Override
    public BAPEntity init(BAPStageInitializer bAPStageInitializer) {
        this.getSystemService().addSystemServiceListener(this, SYSTEM_LISTENER_IDS);
        this.getPhoneService().addPhoneServiceListener(this, PHONE_LISTENER_IDS);
        this.getPhoneService().addHMIEventListener(this, PHONE_LISTENER_HMI_EVENT_IDS);
        this.getValetParkingService().addValetParkingServiceListener(this, VALET_PARKING_LISTENER_IDS);
        return this.computeFSGOperationStateStatus();
    }

    protected FSG_OperationState_Status dequeueBAPEntity() {
        return (FSG_OperationState_Status)this.context.dequeueBAPEntity(this, class$de$vw$mib$bap$mqbab2$generated$telephone$serializer$FSG_OperationState_Status == null ? (class$de$vw$mib$bap$mqbab2$generated$telephone$serializer$FSG_OperationState_Status = FSGOperationStateHandling.class$("de.vw.mib.bap.mqbab2.generated.telephone.serializer.FSG_OperationState_Status")) : class$de$vw$mib$bap$mqbab2$generated$telephone$serializer$FSG_OperationState_Status);
    }

    protected void setFsgOperationState(FSG_OperationState_Status fSG_OperationState_Status) {
        int[] nArray = new int[]{14};
        this.context.updateStages(this, nArray, fSG_OperationState_Status);
    }

    @Override
    public void setFunctionData(BAPStage bAPStage, Object object) {
    }

    @Override
    public int getFunctionId() {
        return 15;
    }

    private int getContextSpecificOperationState() {
        int n;
        switch (this.getSystemService().getPhoneDomainAvailable()) {
            case 1: {
                n = 0;
                break;
            }
            case 0: {
                n = 3;
                break;
            }
            default: {
                n = 15;
            }
        }
        return n;
    }

    private int getBAPTelStateForActivationState() {
        int n;
        int n2 = this.getPhoneService().getPhoneActivationState();
        switch (n2) {
            case 9: {
                n = 20;
                break;
            }
            case 7: {
                n = this.currentTelState;
                break;
            }
            case 1: {
                n = 18;
                break;
            }
            case 12: {
                n = 12;
                break;
            }
            case 2: 
            case 5: {
                n = 15;
                break;
            }
            case 0: {
                n = this.currentTelState;
                break;
            }
            default: {
                n = 5;
            }
        }
        return n;
    }

    private void setTelState(FSG_OperationState_Status fSG_OperationState_Status) {
        PhoneService phoneService = this.getPhoneService();
        int n = phoneService.getNetworkAccessDeviceState();
        int n2 = phoneService.getBluetoothState();
        int n3 = n < BAP_TEL_STATE_MAPPING_TABLE.length && n2 < BAP_TEL_STATE_MAPPING_TABLE[n].length ? BAP_TEL_STATE_MAPPING_TABLE[n][n2] : -4;
        boolean bl = phoneService.getCurrentPhoneProfile() == 2;
        switch (n3) {
            case -1: {
                fSG_OperationState_Status.tel_State = this.getBAPTelStateForActivationState();
                break;
            }
            case -2: {
                if (bl) {
                    fSG_OperationState_Status.tel_State = this.getBAPTelStateForActivationState();
                    break;
                }
                fSG_OperationState_Status.tel_State = 9;
                break;
            }
            case -3: {
                if (bl) {
                    fSG_OperationState_Status.tel_State = this.getBAPTelStateForActivationState();
                    break;
                }
                int n4 = this.getBAPTelStateForActivationState();
                if (n4 != 15) {
                    fSG_OperationState_Status.tel_State = n4;
                    break;
                }
                fSG_OperationState_Status.tel_State = 7;
                break;
            }
            case -5: {
                if (bl) {
                    fSG_OperationState_Status.tel_State = this.getBAPTelStateForActivationState();
                    break;
                }
                fSG_OperationState_Status.tel_State = 18;
                break;
            }
            case -6: {
                if (bl) {
                    fSG_OperationState_Status.tel_State = this.getBAPTelStateForActivationState();
                    break;
                }
                fSG_OperationState_Status.tel_State = 18;
                break;
            }
            default: {
                fSG_OperationState_Status.tel_State = n3;
            }
        }
        if (phoneService.isBluetoothConnectedUserPopUpVisible()) {
            fSG_OperationState_Status.tel_State = 10;
        }
    }

    private void setOperationStateStatus(FSG_OperationState_Status fSG_OperationState_Status) {
        PhoneService phoneService = this.getPhoneService();
        if (this.operationStateSystemDependent) {
            if (!this.getValetParkingService().isValetParkingActive()) {
                if (phoneService.getBluetoothSoftwareDownloadState() == 1) {
                    fSG_OperationState_Status.op_State = 3;
                } else {
                    switch (this.getSystemService().getSystemOnOffState()) {
                        case 0: {
                            fSG_OperationState_Status.op_State = 1;
                            break;
                        }
                        case 1: 
                        case 2: {
                            fSG_OperationState_Status.op_State = this.getContextSpecificOperationState();
                            break;
                        }
                        default: {
                            fSG_OperationState_Status.op_State = 3;
                            break;
                        }
                    }
                }
            } else {
                fSG_OperationState_Status.op_State = 1;
            }
        } else {
            fSG_OperationState_Status.op_State = this.currentOpState;
        }
        this.setTelState(fSG_OperationState_Status);
        fSG_OperationState_Status.privacyMode.privacyModeActive = phoneService.isPhonePrivacyModeActive();
        fSG_OperationState_Status.privacyMode.enhancedPrivacyModeActive = true;
    }

    private void sendOperationStateStatus(FSG_OperationState_Status fSG_OperationState_Status) {
        if (this.getDelegate().getPropertyListener(this).statusProperty(fSG_OperationState_Status, this) || this.currentTelState != fSG_OperationState_Status.tel_State) {
            this.currentOpState = fSG_OperationState_Status.op_State;
            this.currentTelState = fSG_OperationState_Status.tel_State;
            this.setFsgOperationState(fSG_OperationState_Status);
        }
    }

    @Override
    public void getProperty(BAPEntity bAPEntity, PropertyListener propertyListener) {
        propertyListener.requestError(128, this);
    }

    @Override
    public void requestAcknowledge() {
    }

    @Override
    public void errorAcknowledge() {
    }

    @Override
    public void initialize(boolean bl) {
    }

    @Override
    public void uninitialize() {
        this.getSystemService().removeSystemServiceListener(this, SYSTEM_LISTENER_IDS);
        this.getPhoneService().removePhoneServiceListener(this, PHONE_LISTENER_IDS);
        this.getPhoneService().removeHMIEventListener(this, PHONE_LISTENER_HMI_EVENT_IDS);
        this.getValetParkingService().removeValetParkingServiceListener(this, VALET_PARKING_LISTENER_IDS);
    }

    @Override
    public void indicationError(int n, BAPFunctionListener bAPFunctionListener) {
    }

    @Override
    public void setGetProperty(BAPEntity bAPEntity, PropertyListener propertyListener) {
        propertyListener.requestError(128, this);
    }

    @Override
    public void ackProperty(BAPEntity bAPEntity, PropertyListener propertyListener) {
        propertyListener.requestError(65, this);
    }

    @Override
    public void process(int n) {
        this.sendOperationStateStatus(this.computeFSGOperationStateStatus());
    }

    private FSG_OperationState_Status computeFSGOperationStateStatus() {
        FSG_OperationState_Status fSG_OperationState_Status = this.dequeueBAPEntity();
        this.setOperationStateStatus(fSG_OperationState_Status);
        return fSG_OperationState_Status;
    }

    @Override
    public void setHMISystemDependent(boolean bl) {
        if (this.operationStateSystemDependent != bl) {
            this.operationStateSystemDependent = bl;
            this.process(-1);
        }
    }

    @Override
    public boolean isSystemDependent() {
        return this.operationStateSystemDependent;
    }

    @Override
    public void setState(int n) {
        if (this.currentOpState != n) {
            this.currentOpState = n;
            this.process(-1);
        }
    }

    @Override
    public int getState() {
        return this.currentOpState;
    }

    protected void phoneInitUpdate() {
        this.process(-1);
    }

    protected void bluetoothConnectionFailed() {
        this.process(-1);
    }

    protected void bluetoothBondingFailed() {
        this.process(-1);
    }

    @Override
    public void processHMIEvent(int n) {
        switch (n) {
            case 452: {
                this.phoneInitUpdate();
                break;
            }
            case 133: {
                this.bluetoothConnectionFailed();
                break;
            }
            case 130: {
                this.bluetoothBondingFailed();
                break;
            }
        }
    }

    @Override
    public void updatePhoneData(PhoneService phoneService, int n) {
        this.process(-1);
    }

    @Override
    public void updateSystemData(SystemService systemService, int n) {
        this.process(-1);
    }

    @Override
    public void updateValetParkingData(ValetParkingService valetParkingService, int n) {
        this.process(-1);
    }

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError().initCause(classNotFoundException);
        }
    }

    static {
        BAP_TEL_STATE_MAPPING_TABLE = new int[][]{{-1, 5, 5, -1, -1, 5}, {-2, 9, 9, 9, 9, 9}, {-3, 7, 7, 7, 7, 7}, {-5, 5, 5, -1, -1, 5}, {-1, 5, 5, -1, -1, 5}, {-1, 1, 1, -1, -1, 1}, {-1, 0, 0, -1, -1, 0}, {-6, 5, 5, -1, -1, 5}, {-1, 5, 5, -1, -1, 5}};
        SYSTEM_LISTENER_IDS = new int[]{1680, 1632};
        PHONE_LISTENER_IDS = new int[]{1118, 3852, 2906, 2908, 1242, 1089, 1129, 3930};
        PHONE_LISTENER_HMI_EVENT_IDS = new int[]{452, 133, 130};
        VALET_PARKING_LISTENER_IDS = new int[]{1};
    }
}

