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
import de.vw.mib.bap.mqbab2.generated.telephone.serializer.LockState_Status;
import de.vw.mib.bap.mqbab2.telephone.api.ASLTelephoneConstants;

public final class LockState
extends Function
implements Property,
ASLTelephoneConstants,
PhoneServiceListener {
    protected static final int[] PHONE_LISTENER_IDS = new int[]{1082, 1081, 337, 1118, 3852};
    static /* synthetic */ Class class$de$vw$mib$bap$mqbab2$generated$telephone$serializer$LockState_Status;

    @Override
    public BAPEntity init(BAPStageInitializer bAPStageInitializer) {
        this.getPhoneService().addPhoneServiceListener(this, PHONE_LISTENER_IDS);
        return this.computeLockState_Status();
    }

    protected LockState_Status dequeueBAPEntity() {
        return (LockState_Status)this.context.dequeueBAPEntity(this, class$de$vw$mib$bap$mqbab2$generated$telephone$serializer$LockState_Status == null ? (class$de$vw$mib$bap$mqbab2$generated$telephone$serializer$LockState_Status = LockState.class$("de.vw.mib.bap.mqbab2.generated.telephone.serializer.LockState_Status")) : class$de$vw$mib$bap$mqbab2$generated$telephone$serializer$LockState_Status);
    }

    @Override
    public void setFunctionData(BAPStage bAPStage, Object object) {
    }

    @Override
    public int getFunctionId() {
        return 19;
    }

    private void setLockStateStatusData(LockState_Status lockState_Status) {
        PhoneService phoneService = this.getPhoneService();
        block0 : switch (phoneService.getPhoneLockState()) {
            case 2: {
                lockState_Status.lockState = 0;
                break;
            }
            case 3: {
                lockState_Status.lockState = 1;
                break;
            }
            case 4: {
                lockState_Status.lockState = 2;
                break;
            }
            case 5: {
                lockState_Status.lockState = 3;
                break;
            }
            case 6: {
                lockState_Status.lockState = 4;
                break;
            }
            case 7: {
                lockState_Status.lockState = 5;
                break;
            }
            case 8: {
                lockState_Status.lockState = 6;
                break;
            }
            case 11: 
            case 12: {
                lockState_Status.lockState = 11;
                break;
            }
            case 9: {
                lockState_Status.lockState = 14;
                break;
            }
            case 10: {
                lockState_Status.lockState = 15;
                break;
            }
            case 1: {
                lockState_Status.lockState = 12;
                break;
            }
            default: {
                if (phoneService.isInternalPhoneAvailable() && phoneService.getNetworkAccessDeviceState() == 2 && phoneService.getCurrentPhoneProfile() == 0) {
                    switch (phoneService.getSimCardState()) {
                        case 0: {
                            lockState_Status.lockState = 8;
                            break block0;
                        }
                        case 1: {
                            lockState_Status.lockState = 12;
                            break block0;
                        }
                    }
                    lockState_Status.lockState = 0;
                    break;
                }
                lockState_Status.lockState = 0;
            }
        }
    }

    private void sendLockStateStatus(LockState_Status lockState_Status) {
        this.getDelegate().getPropertyListener(this).statusProperty(lockState_Status, this);
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
        this.sendLockStateStatus(this.computeLockState_Status());
    }

    private LockState_Status computeLockState_Status() {
        LockState_Status lockState_Status = this.dequeueBAPEntity();
        this.setLockStateStatusData(lockState_Status);
        return lockState_Status;
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

