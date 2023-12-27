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
import de.vw.mib.bap.mqbab2.generated.telephone.serializer.ActiveUser_Status;
import de.vw.mib.bap.mqbab2.telephone.api.ASLTelephoneConstants;

public final class ActiveUserCarPlay
extends Function
implements Property,
ASLTelephoneConstants {
    private static final String APPLE_CAR_PLAY_NAME;
    static /* synthetic */ Class class$de$vw$mib$bap$mqbab2$generated$telephone$serializer$ActiveUser_Status;

    @Override
    public BAPEntity init(BAPStageInitializer bAPStageInitializer) {
        return this.computeActiveUseStatus();
    }

    protected ActiveUser_Status dequeueBAPEntity() {
        return (ActiveUser_Status)this.context.dequeueBAPEntity(this, class$de$vw$mib$bap$mqbab2$generated$telephone$serializer$ActiveUser_Status == null ? (class$de$vw$mib$bap$mqbab2$generated$telephone$serializer$ActiveUser_Status = ActiveUserCarPlay.class$("de.vw.mib.bap.mqbab2.generated.telephone.serializer.ActiveUser_Status")) : class$de$vw$mib$bap$mqbab2$generated$telephone$serializer$ActiveUser_Status);
    }

    @Override
    public void setFunctionData(BAPStage bAPStage, Object object) {
    }

    @Override
    public int getFunctionId() {
        return 17;
    }

    private void sendActiveUserStatus(ActiveUser_Status activeUser_Status) {
        this.getDelegate().getPropertyListener(this).statusProperty(activeUser_Status, this);
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
        this.sendActiveUserStatus(this.computeActiveUseStatus());
    }

    private ActiveUser_Status computeActiveUseStatus() {
        ActiveUser_Status activeUser_Status = this.dequeueBAPEntity();
        activeUser_Status.userName.setContent(this.getBapActiveUserName());
        return activeUser_Status;
    }

    private String getBapActiveUserName() {
        return "Apple CarPlay";
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

