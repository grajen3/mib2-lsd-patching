/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.mqbab2.telephone2.functions;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.functions.BAPFunctionListener;
import de.vw.mib.bap.functions.Property;
import de.vw.mib.bap.functions.PropertyListener;
import de.vw.mib.bap.mqbab2.common.api.phone.PhoneService;
import de.vw.mib.bap.mqbab2.common.api.phone.PhoneServiceListener;
import de.vw.mib.bap.mqbab2.common.api.stages.BAPStage;
import de.vw.mib.bap.mqbab2.common.api.stages.BAPStageInitializer;
import de.vw.mib.bap.mqbab2.common.api.stages.Function;
import de.vw.mib.bap.mqbab2.generated.telephone2.serializer.PhoneModuleState_Status;
import de.vw.mib.bap.mqbab2.telephone2.api.ASLTelephone2Constants;

public final class PhoneModuleState
extends Function
implements Property,
ASLTelephone2Constants,
PhoneServiceListener {
    protected static final int[] PHONE_LISTENER_IDS = new int[]{1081, 3852, 337};
    static /* synthetic */ Class class$de$vw$mib$bap$mqbab2$generated$telephone2$serializer$PhoneModuleState_Status;

    @Override
    public BAPEntity init(BAPStageInitializer bAPStageInitializer) {
        this.getPhoneService().addPhoneServiceListener(this, PHONE_LISTENER_IDS);
        return null;
    }

    protected PhoneModuleState_Status dequeueBAPEntity() {
        return (PhoneModuleState_Status)this.context.dequeueBAPEntity(this, class$de$vw$mib$bap$mqbab2$generated$telephone2$serializer$PhoneModuleState_Status == null ? (class$de$vw$mib$bap$mqbab2$generated$telephone2$serializer$PhoneModuleState_Status = PhoneModuleState.class$("de.vw.mib.bap.mqbab2.generated.telephone2.serializer.PhoneModuleState_Status")) : class$de$vw$mib$bap$mqbab2$generated$telephone2$serializer$PhoneModuleState_Status);
    }

    @Override
    public void setFunctionData(BAPStage bAPStage, Object object) {
    }

    @Override
    public int getFunctionId() {
        return 23;
    }

    @Override
    public void initialize(boolean bl) {
    }

    @Override
    public void uninitialize() {
        this.getPhoneService().removePhoneServiceListener(this, PHONE_LISTENER_IDS);
    }

    @Override
    public void process(int n) {
        this.getDelegate().getPropertyListener(this).statusProperty(this.computePhoneModuleStateStatus(), this);
    }

    @Override
    public void getProperty(BAPEntity bAPEntity, PropertyListener propertyListener) {
        propertyListener.requestError(65, this);
    }

    @Override
    public void setGetProperty(BAPEntity bAPEntity, PropertyListener propertyListener) {
        propertyListener.requestError(65, this);
    }

    @Override
    public void ackProperty(BAPEntity bAPEntity, PropertyListener propertyListener) {
        propertyListener.requestError(65, this);
    }

    @Override
    public void indicationError(int n, BAPFunctionListener bAPFunctionListener) {
    }

    @Override
    public void requestAcknowledge() {
    }

    @Override
    public void errorAcknowledge() {
    }

    private PhoneModuleState_Status computePhoneModuleStateStatus() {
        PhoneModuleState_Status phoneModuleState_Status = this.dequeueBAPEntity();
        phoneModuleState_Status.moduleState = this.getBapPhoneModuleState();
        phoneModuleState_Status.moduleSupportedServices = this.getBapPhoneModuleSupportedServices();
        phoneModuleState_Status.moduleActiveServices = this.getBapPhoneModuleActiveServices();
        phoneModuleState_Status.simstate = this.getBapPhoneModuleSimState();
        return phoneModuleState_Status;
    }

    private int getBapPhoneModuleState() {
        int n;
        PhoneService phoneService = this.getPhoneService();
        if (phoneService.isInternalPhoneAvailable()) {
            switch (phoneService.getNetworkAccessDeviceState()) {
                case 1: {
                    n = 6;
                    break;
                }
                case 2: {
                    n = 2;
                    break;
                }
                case 3: 
                case 4: {
                    n = 1;
                    break;
                }
                case 5: {
                    n = 5;
                    break;
                }
                case 6: {
                    n = 1;
                    break;
                }
                case 7: {
                    n = 4;
                    break;
                }
                case 8: {
                    n = 3;
                    break;
                }
                default: {
                    n = 0;
                    break;
                }
            }
        } else {
            n = 0;
        }
        return n;
    }

    private int getBapPhoneModuleSupportedServices() {
        int n = this.getPhoneService().isInternalPhoneAvailable() ? 2 : 0;
        return n;
    }

    private int getBapPhoneModuleActiveServices() {
        int n = this.getPhoneService().isInternalPhoneAvailable() ? 2 : 0;
        return n;
    }

    private int getBapPhoneModuleSimState() {
        int n;
        PhoneService phoneService = this.getPhoneService();
        if (phoneService.isInternalPhoneAvailable() && phoneService.getNetworkAccessDeviceState() == 2) {
            switch (phoneService.getSimCardState()) {
                case 0: {
                    n = 1;
                    break;
                }
                case 1: {
                    n = 0;
                    break;
                }
                case 2: {
                    n = 2;
                    break;
                }
                default: {
                    n = 0;
                    break;
                }
            }
        } else {
            n = 0;
        }
        return n;
    }

    @Override
    public void processHMIEvent(int n) {
    }

    @Override
    public void updatePhoneData(PhoneService phoneService, int n) {
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

