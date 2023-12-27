/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.mqbab2.telephone2.functions;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.functions.BAPFunctionListener;
import de.vw.mib.bap.functions.Property;
import de.vw.mib.bap.functions.PropertyListener;
import de.vw.mib.bap.mqbab2.common.api.stages.BAPStage;
import de.vw.mib.bap.mqbab2.common.api.stages.BAPStageInitializer;
import de.vw.mib.bap.mqbab2.common.api.stages.Function;
import de.vw.mib.bap.mqbab2.generated.telephone2.serializer.MobileServiceSupport_Status;
import de.vw.mib.bap.mqbab2.telephone2.api.ASLTelephone2Constants;

public final class MobileServiceSupport
extends Function
implements Property,
ASLTelephone2Constants {
    static /* synthetic */ Class class$de$vw$mib$bap$mqbab2$generated$telephone2$serializer$MobileServiceSupport_Status;

    @Override
    public BAPEntity init(BAPStageInitializer bAPStageInitializer) {
        return this.computeMobileServiceSupportStatus();
    }

    protected MobileServiceSupport_Status dequeueBAPEntity() {
        return (MobileServiceSupport_Status)this.context.dequeueBAPEntity(this, class$de$vw$mib$bap$mqbab2$generated$telephone2$serializer$MobileServiceSupport_Status == null ? (class$de$vw$mib$bap$mqbab2$generated$telephone2$serializer$MobileServiceSupport_Status = MobileServiceSupport.class$("de.vw.mib.bap.mqbab2.generated.telephone2.serializer.MobileServiceSupport_Status")) : class$de$vw$mib$bap$mqbab2$generated$telephone2$serializer$MobileServiceSupport_Status);
    }

    @Override
    public void setFunctionData(BAPStage bAPStage, Object object) {
    }

    @Override
    public int getFunctionId() {
        return 16;
    }

    @Override
    public void initialize(boolean bl) {
    }

    @Override
    public void uninitialize() {
    }

    @Override
    public void process(int n) {
        this.setMobileServiceSupportStatus(this.computeMobileServiceSupportStatus());
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

    private void setMobileServiceSupportStatus(MobileServiceSupport_Status mobileServiceSupport_Status) {
        mobileServiceSupport_Status.fctList.fctGetAllSupported = false;
        mobileServiceSupport_Status.fctList.fctBapConfigSupported = true;
        mobileServiceSupport_Status.fctList.fctFunctionListSupported = true;
        mobileServiceSupport_Status.fctList.fctHeartbeatSupported = true;
        mobileServiceSupport_Status.fctList.fctFsg_SetupSupported = true;
        mobileServiceSupport_Status.fctList.fctFsg_OperationStateSupported = true;
        mobileServiceSupport_Status.fctList.fctMobileServiceSupportSupported = true;
        mobileServiceSupport_Status.fctList.fctRegisterState2Supported = true;
        mobileServiceSupport_Status.fctList.fctLockState2Supported = true;
        mobileServiceSupport_Status.fctList.fctNetworkProvider2Supported = true;
        mobileServiceSupport_Status.fctList.fctSignalQuality2Supported = true;
        mobileServiceSupport_Status.fctList.fctDataConnectionIndication2Supported = true;
        mobileServiceSupport_Status.fctList.fctEmailStateSupported = true;
        mobileServiceSupport_Status.fctList.fctPhoneModuleStateSupported = true;
        mobileServiceSupport_Status.fctList.fctConnectionStateSupported = true;
        mobileServiceSupport_Status.fctList.fctAutomaticCallForwardingSupported = true;
    }

    private MobileServiceSupport_Status computeMobileServiceSupportStatus() {
        MobileServiceSupport_Status mobileServiceSupport_Status = this.dequeueBAPEntity();
        this.setMobileServiceSupportStatus(mobileServiceSupport_Status);
        return mobileServiceSupport_Status;
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

