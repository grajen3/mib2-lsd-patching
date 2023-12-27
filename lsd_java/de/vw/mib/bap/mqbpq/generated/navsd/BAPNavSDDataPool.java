/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.mqbpq.generated.navsd;

import de.vw.mib.bap.mqbpq.common.HsmContextDelegate;
import de.vw.mib.bap.mqbpq.common.api.adapter.AbstractBAPDataPool;
import de.vw.mib.bap.mqbpq.generated.navsd.NavSDBindingFactory;

public class BAPNavSDDataPool
extends AbstractBAPDataPool {
    private NavSDBindingFactory _factory;

    public BAPNavSDDataPool(HsmContextDelegate hsmContextDelegate) {
        super(hsmContextDelegate);
    }

    public NavSDBindingFactory getFactory() {
        return this._factory;
    }

    public void setFactory(NavSDBindingFactory navSDBindingFactory) {
        this._factory = navSDBindingFactory;
    }

    @Override
    public final void initialize() {
        this.initializeInternal(this._factory);
        super.initialize();
        this._factory = null;
    }

    public final void reinitialize(NavSDBindingFactory navSDBindingFactory) {
        super.uninitialize();
        this.initializeInternal(navSDBindingFactory);
        super.initialize();
        this._factory = null;
    }

    private void initializeInternal(NavSDBindingFactory navSDBindingFactory) {
        this.addStage(navSDBindingFactory.createNewFunctionListStage(), 3, 1, "FunctionList");
        this.addStage(navSDBindingFactory.createNewFSGOperationStateStage(), 0, 1, "FSGOperationState");
        this.addStage(navSDBindingFactory.createNewCompassInfoStage(), 3, 1, "CompassInfo");
        this.addStage(navSDBindingFactory.createNewRouteGuidanceStatusStage(), 0, 1, "RouteGuidanceStatus");
        this.addStage(navSDBindingFactory.createNewDistanceToNextManeuverStage(), 3, 1, "DistanceToNextManeuver");
        this.addStage(navSDBindingFactory.createNewCurrentPositionInfoStage(), 3, 1, "CurrentPositionInfo");
        this.addStage(navSDBindingFactory.createNewTurnToInfoStage(), 3, 1, "TurnToInfo");
        this.addStage(navSDBindingFactory.createNewDistanceTimeToDestinationStage(), 3, 1, "DistanceTimeToDestination");
        this.addStage(navSDBindingFactory.createNewManeuverDescriptorStage(), 3, 2, "ManeuverDescriptor");
    }
}

