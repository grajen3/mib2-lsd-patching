/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.mqbab2.telephone.functions.carplay;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.functions.BAPFunctionListener;
import de.vw.mib.bap.functions.Property;
import de.vw.mib.bap.functions.PropertyListener;
import de.vw.mib.bap.mqbab2.common.api.stages.BAPStage;
import de.vw.mib.bap.mqbab2.common.api.stages.BAPStageInitializer;
import de.vw.mib.bap.mqbab2.common.api.stages.Function;
import de.vw.mib.bap.mqbab2.generated.telephone.serializer.RegisterState_Status;
import de.vw.mib.bap.mqbab2.telephone.api.ASLTelephoneConstants;

public final class RegisterStateCarPlay
extends Function
implements Property,
ASLTelephoneConstants {
    static /* synthetic */ Class class$de$vw$mib$bap$mqbab2$generated$telephone$serializer$RegisterState_Status;

    @Override
    public BAPEntity init(BAPStageInitializer bAPStageInitializer) {
        return this.computeRegisterStateStatus();
    }

    protected void setNetworkProviderName(String string) {
        int[] nArray = new int[]{20};
        this.context.updateStages(this, nArray, string);
    }

    protected RegisterState_Status dequeueBAPEntity() {
        return (RegisterState_Status)this.context.dequeueBAPEntity(this, class$de$vw$mib$bap$mqbab2$generated$telephone$serializer$RegisterState_Status == null ? (class$de$vw$mib$bap$mqbab2$generated$telephone$serializer$RegisterState_Status = RegisterStateCarPlay.class$("de.vw.mib.bap.mqbab2.generated.telephone.serializer.RegisterState_Status")) : class$de$vw$mib$bap$mqbab2$generated$telephone$serializer$RegisterState_Status);
    }

    @Override
    public void setFunctionData(BAPStage bAPStage, Object object) {
        switch (bAPStage.getFunctionId()) {
            case 20: {
                this.setNetworkProviderSend((String)object);
                break;
            }
        }
    }

    @Override
    public int getFunctionId() {
        return 18;
    }

    private void sendRegisterState(RegisterState_Status registerState_Status) {
        this.getDelegate().getPropertyListener(this).statusProperty(registerState_Status, this);
    }

    private void setRegistrationState(RegisterState_Status registerState_Status) {
        registerState_Status.registerState = 1;
    }

    private void setNetworkType(RegisterState_Status registerState_Status) {
        registerState_Status.networkType = 0;
    }

    private void setPacketDataNetworkType(RegisterState_Status registerState_Status) {
        registerState_Status.packetDataNetworkType = 0;
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
        this.sendRegisterState(this.computeRegisterStateStatus());
    }

    private RegisterState_Status computeRegisterStateStatus() {
        RegisterState_Status registerState_Status = this.dequeueBAPEntity();
        this.setRegistrationState(registerState_Status);
        this.setNetworkType(registerState_Status);
        this.setPacketDataNetworkType(registerState_Status);
        return registerState_Status;
    }

    protected void setNetworkProviderSend(String string) {
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

