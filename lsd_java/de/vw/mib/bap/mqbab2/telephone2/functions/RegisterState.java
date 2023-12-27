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
import de.vw.mib.bap.mqbab2.generated.telephone2.serializer.RegisterState2_Status;
import de.vw.mib.bap.mqbab2.telephone2.api.ASLTelephone2Constants;

public final class RegisterState
extends Function
implements Property,
ASLTelephone2Constants,
PhoneServiceListener {
    protected static final int[] PHONE_LISTENER_IDS = new int[]{1084, 1086, 1085, 1080};
    static /* synthetic */ Class class$de$vw$mib$bap$mqbab2$generated$telephone2$serializer$RegisterState2_Status;

    @Override
    public BAPEntity init(BAPStageInitializer bAPStageInitializer) {
        this.getPhoneService().addPhoneServiceListener(this, PHONE_LISTENER_IDS);
        return this.computeRegisterStateStatus();
    }

    protected RegisterState2_Status dequeueBAPEntity() {
        return (RegisterState2_Status)this.context.dequeueBAPEntity(this, class$de$vw$mib$bap$mqbab2$generated$telephone2$serializer$RegisterState2_Status == null ? (class$de$vw$mib$bap$mqbab2$generated$telephone2$serializer$RegisterState2_Status = RegisterState.class$("de.vw.mib.bap.mqbab2.generated.telephone2.serializer.RegisterState2_Status")) : class$de$vw$mib$bap$mqbab2$generated$telephone2$serializer$RegisterState2_Status);
    }

    @Override
    public void setFunctionData(BAPStage bAPStage, Object object) {
    }

    @Override
    public int getFunctionId() {
        return 17;
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
        this.getDelegate().getPropertyListener(this).statusProperty(this.computeRegisterStateStatus(), this);
    }

    @Override
    public void getProperty(BAPEntity bAPEntity, PropertyListener propertyListener) {
        propertyListener.requestError(69, this);
    }

    @Override
    public void setGetProperty(BAPEntity bAPEntity, PropertyListener propertyListener) {
        propertyListener.requestError(69, this);
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

    private RegisterState2_Status computeRegisterStateStatus() {
        RegisterState2_Status registerState2_Status = this.dequeueBAPEntity();
        registerState2_Status.registerState = this.getBapRegisterState();
        registerState2_Status.networkType = this.getBapNetworkType();
        registerState2_Status.packetDataNetworkType = this.getBapPacketDataNetworkType();
        return registerState2_Status;
    }

    private int getBapRegisterState() {
        int n;
        switch (this.getPhoneService().getNetworkState()) {
            case 1: {
                n = 1;
                break;
            }
            case 2: {
                n = 4;
                break;
            }
            case 3: {
                n = 2;
                break;
            }
            case 4: 
            case 5: {
                n = 3;
                break;
            }
            default: {
                n = 0;
            }
        }
        return n;
    }

    private int getBapNetworkType() {
        int n;
        switch (this.getPhoneService().getNetworkType()) {
            case 1: {
                n = 1;
                break;
            }
            case 2: {
                n = 2;
                break;
            }
            case 3: {
                n = 4;
                break;
            }
            default: {
                n = 0;
            }
        }
        return n;
    }

    private int getBapPacketDataNetworkType() {
        int n;
        switch (this.getPhoneService().getPhoneDataConnectionType()) {
            case 1: 
            case 2: {
                n = 1;
                break;
            }
            case 3: {
                n = 2;
                break;
            }
            case 4: {
                n = 1;
                break;
            }
            case 5: {
                n = 6;
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

