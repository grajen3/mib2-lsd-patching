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
import de.vw.mib.bap.mqbab2.generated.telephone2.serializer.LockState2_Status;
import de.vw.mib.bap.mqbab2.telephone2.api.ASLTelephone2Constants;

public final class LockState
extends Function
implements Property,
ASLTelephone2Constants,
PhoneServiceListener {
    protected static final int[] PHONE_LISTENER_IDS = new int[]{1082, 337, 3852, 1081};
    static /* synthetic */ Class class$de$vw$mib$bap$mqbab2$generated$telephone2$serializer$LockState2_Status;

    @Override
    public BAPEntity init(BAPStageInitializer bAPStageInitializer) {
        this.getPhoneService().addPhoneServiceListener(this, PHONE_LISTENER_IDS);
        return this.computeLockStateStatus();
    }

    protected LockState2_Status dequeueBAPEntity() {
        return (LockState2_Status)this.context.dequeueBAPEntity(this, class$de$vw$mib$bap$mqbab2$generated$telephone2$serializer$LockState2_Status == null ? (class$de$vw$mib$bap$mqbab2$generated$telephone2$serializer$LockState2_Status = LockState.class$("de.vw.mib.bap.mqbab2.generated.telephone2.serializer.LockState2_Status")) : class$de$vw$mib$bap$mqbab2$generated$telephone2$serializer$LockState2_Status);
    }

    @Override
    public void setFunctionData(BAPStage bAPStage, Object object) {
    }

    @Override
    public int getFunctionId() {
        return 18;
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
        this.getDelegate().getPropertyListener(this).statusProperty(this.computeLockStateStatus(), this);
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

    private LockState2_Status computeLockStateStatus() {
        LockState2_Status lockState2_Status = this.dequeueBAPEntity();
        lockState2_Status.lockState = this.getBapLockState();
        return lockState2_Status;
    }

    private int getBapLockState() {
        int n;
        PhoneService phoneService = this.getPhoneService();
        block0 : switch (phoneService.getPhoneLockState()) {
            case 0: {
                if (phoneService.isInternalPhoneAvailable() && phoneService.getNetworkAccessDeviceState() == 2) {
                    switch (phoneService.getSimCardState()) {
                        case 0: {
                            n = 8;
                            break block0;
                        }
                        case 1: {
                            n = 12;
                            break block0;
                        }
                    }
                    n = 0;
                    break;
                }
                n = 0;
                break;
            }
            case 1: {
                n = 12;
                break;
            }
            case 2: {
                n = 0;
                break;
            }
            case 3: {
                n = 1;
                break;
            }
            case 4: {
                n = 2;
                break;
            }
            case 5: {
                n = 3;
                break;
            }
            case 6: {
                n = 4;
                break;
            }
            case 7: {
                n = 5;
                break;
            }
            case 8: {
                n = 6;
                break;
            }
            case 9: {
                n = 14;
                break;
            }
            case 10: {
                n = 15;
                break;
            }
            case 11: 
            case 12: {
                n = 11;
                break;
            }
            default: {
                n = 0;
            }
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

