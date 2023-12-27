/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.mqbab2.telephone.functions;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.functions.BAPFunctionListener;
import de.vw.mib.bap.functions.Property;
import de.vw.mib.bap.functions.PropertyListener;
import de.vw.mib.bap.mqbab2.common.api.phone.PhoneService;
import de.vw.mib.bap.mqbab2.common.api.phone.PhoneServiceListener;
import de.vw.mib.bap.mqbab2.common.api.stages.BAPStage;
import de.vw.mib.bap.mqbab2.common.api.stages.BAPStageInitializer;
import de.vw.mib.bap.mqbab2.common.api.stages.Function;
import de.vw.mib.bap.mqbab2.common.api.system.SystemService;
import de.vw.mib.bap.mqbab2.common.api.system.SystemServiceListener;
import de.vw.mib.bap.mqbab2.generated.telephone.serializer.FSG_OperationState_Status;
import de.vw.mib.bap.mqbab2.generated.telephone.serializer.FSG_Setup_Status;
import de.vw.mib.bap.mqbab2.telephone.api.ASLTelephoneConstants;

public final class FSGSetup
extends Function
implements Property,
ASLTelephoneConstants,
SystemServiceListener,
PhoneServiceListener {
    private boolean mobileOn = false;
    protected static final int[] SYSTEM_LISTENER_IDS = new int[]{1680};
    protected static final int[] PHONE_LISTENER_IDS = new int[]{2906, -545057536, 1081, 3852, 2908, 1089, 1118, 336, 337, 4032};
    static /* synthetic */ Class class$de$vw$mib$bap$mqbab2$generated$telephone$serializer$FSG_Setup_Status;

    @Override
    public BAPEntity init(BAPStageInitializer bAPStageInitializer) {
        this.getSystemService().addSystemServiceListener(this, SYSTEM_LISTENER_IDS);
        this.getPhoneService().addPhoneServiceListener(this, PHONE_LISTENER_IDS);
        return this.computeFSGSetupStatus();
    }

    protected void setCurrentFsgSetupState(FSG_Setup_Status fSG_Setup_Status) {
        int[] nArray = new int[]{43};
        this.context.updateStages(this, nArray, fSG_Setup_Status);
    }

    protected FSG_Setup_Status dequeueBAPEntity() {
        return (FSG_Setup_Status)this.context.dequeueBAPEntity(this, class$de$vw$mib$bap$mqbab2$generated$telephone$serializer$FSG_Setup_Status == null ? (class$de$vw$mib$bap$mqbab2$generated$telephone$serializer$FSG_Setup_Status = FSGSetup.class$("de.vw.mib.bap.mqbab2.generated.telephone.serializer.FSG_Setup_Status")) : class$de$vw$mib$bap$mqbab2$generated$telephone$serializer$FSG_Setup_Status);
    }

    @Override
    public void setFunctionData(BAPStage bAPStage, Object object) {
        switch (bAPStage.getFunctionId()) {
            case 15: {
                this.setFsgOperationState((FSG_OperationState_Status)object);
                break;
            }
        }
    }

    @Override
    public int getFunctionId() {
        return 14;
    }

    private void setFSGSetupStateMobileConnectionType(FSG_Setup_Status fSG_Setup_Status) {
        int n;
        PhoneService phoneService = this.getPhoneService();
        fSG_Setup_Status.mobileConnectionType = this.mobileOn && this.getSystemService().getPhoneDomainAvailable() == 1 ? ((n = phoneService.getCurrentPhoneProfile()) != 0 ? (phoneService.getPhoneActivationState() != 5 ? 0 : (n == 2 ? 3 : (n == 1 ? 4 : 0))) : (phoneService.getSimCardReaderType() == 0 && phoneService.getSimCardState() != 0 ? 1 : 0)) : 0;
    }

    private boolean isInternalSimcardReaderAvailble() {
        PhoneService phoneService = this.getPhoneService();
        boolean bl = phoneService.isInternalPhoneAvailable() && phoneService.getNetworkAccessDeviceState() == 2;
        boolean bl2 = !phoneService.isNetworkingInternalSimDataModeOnly() || phoneService.getSimCardState() != 2;
        return bl && bl2;
    }

    private void setFSGSetupStatePhoneCharacteristics(FSG_Setup_Status fSG_Setup_Status) {
        if (this.getSystemService().getPhoneDomainAvailable() == 1) {
            PhoneService phoneService = this.getPhoneService();
            fSG_Setup_Status.phoneCharacteristics.internalSimcardReader = this.isInternalSimcardReaderAvailble();
            if (phoneService.getBluetoothState() != 1) {
                fSG_Setup_Status.phoneCharacteristics.hfpConnectionToMobilePossible = phoneService.isExternalPhoneAvailable();
                fSG_Setup_Status.phoneCharacteristics.rsapConnectionToMobilePossible = fSG_Setup_Status.phoneCharacteristics.hfpConnectionToMobilePossible && phoneService.isRemoteSimAccessProfileSupported();
            } else {
                fSG_Setup_Status.phoneCharacteristics.hfpConnectionToMobilePossible = false;
                fSG_Setup_Status.phoneCharacteristics.rsapConnectionToMobilePossible = false;
            }
        } else {
            fSG_Setup_Status.phoneCharacteristics.internalSimcardReader = false;
            fSG_Setup_Status.phoneCharacteristics.hfpConnectionToMobilePossible = false;
            fSG_Setup_Status.phoneCharacteristics.rsapConnectionToMobilePossible = false;
        }
        fSG_Setup_Status.phoneCharacteristics.cableConnectionToMobilePossible = false;
    }

    private void sendFSGSetup(FSG_Setup_Status fSG_Setup_Status) {
        if (this.getDelegate().getPropertyListener(this).statusProperty(fSG_Setup_Status, this)) {
            this.setCurrentFsgSetupState(fSG_Setup_Status);
        }
    }

    public void setFsgOperationState(FSG_OperationState_Status fSG_OperationState_Status) {
        boolean bl = fSG_OperationState_Status.tel_State == 15 || fSG_OperationState_Status.tel_State == 7;
        if (this.mobileOn != bl) {
            this.mobileOn = bl;
            this.process(-1);
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
        this.sendFSGSetup(this.computeFSGSetupStatus());
    }

    private FSG_Setup_Status computeFSGSetupStatus() {
        FSG_Setup_Status fSG_Setup_Status = this.dequeueBAPEntity();
        this.setFSGSetupStatePhoneCharacteristics(fSG_Setup_Status);
        this.setFSGSetupStateMobileConnectionType(fSG_Setup_Status);
        return fSG_Setup_Status;
    }

    @Override
    public void processHMIEvent(int n) {
    }

    @Override
    public void updatePhoneData(PhoneService phoneService, int n) {
        this.process(-1);
    }

    @Override
    public void updateSystemData(SystemService systemService, int n) {
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
}

