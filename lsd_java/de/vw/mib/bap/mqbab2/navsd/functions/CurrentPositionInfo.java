/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.mqbab2.navsd.functions;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.functions.BAPFunctionListener;
import de.vw.mib.bap.functions.Property;
import de.vw.mib.bap.functions.PropertyListener;
import de.vw.mib.bap.mqbab2.common.api.navigation.NavigationService;
import de.vw.mib.bap.mqbab2.common.api.navigation.NavigationServiceListener;
import de.vw.mib.bap.mqbab2.common.api.stages.BAPStage;
import de.vw.mib.bap.mqbab2.common.api.stages.BAPStageInitializer;
import de.vw.mib.bap.mqbab2.common.api.stages.Function;
import de.vw.mib.bap.mqbab2.generated.navsd.serializer.CurrentPositionInfo_Status;
import de.vw.mib.bap.mqbab2.navsd.api.ASLNavSDConstants;

public class CurrentPositionInfo
extends Function
implements Property,
ASLNavSDConstants,
NavigationServiceListener {
    protected static final int[] NAVIGATION_LISTENER_IDS = new int[]{738, 733};
    static /* synthetic */ Class class$de$vw$mib$bap$mqbab2$generated$navsd$serializer$CurrentPositionInfo_Status;

    @Override
    public BAPEntity init(BAPStageInitializer bAPStageInitializer) {
        this.getNavigationService().addNavigationServiceListener(this, NAVIGATION_LISTENER_IDS);
        return null;
    }

    protected CurrentPositionInfo_Status dequeueBAPEntity() {
        return (CurrentPositionInfo_Status)this.context.dequeueBAPEntity(this, class$de$vw$mib$bap$mqbab2$generated$navsd$serializer$CurrentPositionInfo_Status == null ? (class$de$vw$mib$bap$mqbab2$generated$navsd$serializer$CurrentPositionInfo_Status = CurrentPositionInfo.class$("de.vw.mib.bap.mqbab2.generated.navsd.serializer.CurrentPositionInfo_Status")) : class$de$vw$mib$bap$mqbab2$generated$navsd$serializer$CurrentPositionInfo_Status);
    }

    @Override
    public void setFunctionData(BAPStage bAPStage, Object object) {
    }

    @Override
    public int getFunctionId() {
        return 19;
    }

    private void setCurrentPositionInfoStatusData(CurrentPositionInfo_Status currentPositionInfo_Status) {
        NavigationService navigationService = this.getNavigationService();
        String string = navigationService.getCurrentPositionInfo();
        if (string == null || navigationService.getNavigationStatus() != 0) {
            currentPositionInfo_Status.positionInfo.setContent("");
        } else {
            currentPositionInfo_Status.positionInfo.setContent(string);
        }
    }

    private void sendCurrentPositionInfoStatus(CurrentPositionInfo_Status currentPositionInfo_Status) {
        this.getDelegate().getPropertyListener(this).statusProperty(currentPositionInfo_Status, this);
    }

    @Override
    public void getProperty(BAPEntity bAPEntity, PropertyListener propertyListener) {
        propertyListener.requestError(65, this);
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
        this.getNavigationService().removeNavigationServiceListener(this, NAVIGATION_LISTENER_IDS);
    }

    @Override
    public void indicationError(int n, BAPFunctionListener bAPFunctionListener) {
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
    public void process(int n) {
        this.sendCurrentPositionInfoStatus(this.computeCurrentPositionInfoStatus());
    }

    protected CurrentPositionInfo_Status computeCurrentPositionInfoStatus() {
        CurrentPositionInfo_Status currentPositionInfo_Status = this.dequeueBAPEntity();
        this.setCurrentPositionInfoStatusData(currentPositionInfo_Status);
        return currentPositionInfo_Status;
    }

    @Override
    public void processHMIEvent(int n) {
    }

    @Override
    public void updateNavigationData(NavigationService navigationService, int n) {
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

