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
import de.vw.mib.bap.mqbab2.generated.navsd.serializer.TrafficBlock_Indication_Status;
import de.vw.mib.bap.mqbab2.navsd.api.ASLNavSDConstants;

public final class TrafficBlockIndication
extends Function
implements Property,
ASLNavSDConstants,
NavigationServiceListener {
    protected static final int[] NAVIGATION_LISTENER_IDS = new int[]{729};
    static /* synthetic */ Class class$de$vw$mib$bap$mqbab2$generated$navsd$serializer$TrafficBlock_Indication_Status;

    @Override
    public BAPEntity init(BAPStageInitializer bAPStageInitializer) {
        this.getNavigationService().addNavigationServiceListener(this, NAVIGATION_LISTENER_IDS);
        return this.dequeueBAPEntity();
    }

    protected TrafficBlock_Indication_Status dequeueBAPEntity() {
        return (TrafficBlock_Indication_Status)this.context.dequeueBAPEntity(this, class$de$vw$mib$bap$mqbab2$generated$navsd$serializer$TrafficBlock_Indication_Status == null ? (class$de$vw$mib$bap$mqbab2$generated$navsd$serializer$TrafficBlock_Indication_Status = TrafficBlockIndication.class$("de.vw.mib.bap.mqbab2.generated.navsd.serializer.TrafficBlock_Indication_Status")) : class$de$vw$mib$bap$mqbab2$generated$navsd$serializer$TrafficBlock_Indication_Status);
    }

    @Override
    public void setFunctionData(BAPStage bAPStage, Object object) {
    }

    @Override
    public int getFunctionId() {
        return 40;
    }

    @Override
    public void process(int n) {
        int n2 = this.getNavigationService().getTMCSymbol();
        TrafficBlock_Indication_Status trafficBlock_Indication_Status = this.dequeueBAPEntity();
        trafficBlock_Indication_Status.tmc_Symbol = n2;
        this.getDelegate().getPropertyListener(this).statusProperty(trafficBlock_Indication_Status, this);
    }

    @Override
    public void getProperty(BAPEntity bAPEntity, PropertyListener propertyListener) {
        propertyListener.requestError(66, this);
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
        propertyListener.requestError(66, this);
    }

    @Override
    public void ackProperty(BAPEntity bAPEntity, PropertyListener propertyListener) {
        propertyListener.requestError(65, this);
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

