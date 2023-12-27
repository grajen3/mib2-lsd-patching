/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.mqbab2.navsd.functions;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.functions.BAPFunctionListener;
import de.vw.mib.bap.functions.Property;
import de.vw.mib.bap.functions.PropertyListener;
import de.vw.mib.bap.mqbab2.common.api.navigation.NavigationService;
import de.vw.mib.bap.mqbab2.common.api.navigation.datatypes.NavigationOnlineNavigationState;
import de.vw.mib.bap.mqbab2.common.api.stages.BAPStage;
import de.vw.mib.bap.mqbab2.common.api.stages.BAPStageInitializer;
import de.vw.mib.bap.mqbab2.common.api.stages.Function;
import de.vw.mib.bap.mqbab2.generated.navsd.serializer.OnlineNavigationState_Status;
import de.vw.mib.bap.mqbab2.navsd.api.ASLNavSDConstants;

public final class OnlineNavigationState
extends Function
implements Property,
ASLNavSDConstants {
    static /* synthetic */ Class class$de$vw$mib$bap$mqbab2$generated$navsd$serializer$OnlineNavigationState_Status;

    @Override
    public BAPEntity init(BAPStageInitializer bAPStageInitializer) {
        return this.computeBapOnlineNavigationStatus();
    }

    protected OnlineNavigationState_Status dequeueBAPEntity() {
        return (OnlineNavigationState_Status)this.context.dequeueBAPEntity(this, class$de$vw$mib$bap$mqbab2$generated$navsd$serializer$OnlineNavigationState_Status == null ? (class$de$vw$mib$bap$mqbab2$generated$navsd$serializer$OnlineNavigationState_Status = OnlineNavigationState.class$("de.vw.mib.bap.mqbab2.generated.navsd.serializer.OnlineNavigationState_Status")) : class$de$vw$mib$bap$mqbab2$generated$navsd$serializer$OnlineNavigationState_Status);
    }

    @Override
    public void setFunctionData(BAPStage bAPStage, Object object) {
    }

    @Override
    public int getFunctionId() {
        return 48;
    }

    @Override
    public void initialize(boolean bl) {
    }

    @Override
    public void uninitialize() {
    }

    @Override
    public void process(int n) {
        this.getDelegate().getPropertyListener(this).statusProperty(this.computeBapOnlineNavigationStatus(), this);
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

    private OnlineNavigationState_Status computeBapOnlineNavigationStatus() {
        OnlineNavigationState_Status onlineNavigationState_Status = this.dequeueBAPEntity();
        NavigationService navigationService = this.getNavigationService();
        NavigationOnlineNavigationState navigationOnlineNavigationState = navigationService.getOnlineNavigationState();
        onlineNavigationState_Status.state = navigationOnlineNavigationState.getOnlineNavigationStateState();
        onlineNavigationState_Status.progress = navigationOnlineNavigationState.getOnlineNavigationStateProgress();
        onlineNavigationState_Status.onlineNavigationSystem = navigationService.getOnlineNavigationSystem();
        return onlineNavigationState_Status;
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

