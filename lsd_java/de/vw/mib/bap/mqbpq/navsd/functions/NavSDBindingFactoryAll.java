/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.mqbpq.navsd.functions;

import de.vw.mib.bap.mqbpq.common.api.stages.BAPStage;
import de.vw.mib.bap.mqbpq.generated.navsd.NavSDBindingFactory;
import de.vw.mib.bap.mqbpq.navsd.functions.CompassInfo;
import de.vw.mib.bap.mqbpq.navsd.functions.CurrentPositionInfo;
import de.vw.mib.bap.mqbpq.navsd.functions.DistanceTimeToDestination;
import de.vw.mib.bap.mqbpq.navsd.functions.DistanceToNextManeuver;
import de.vw.mib.bap.mqbpq.navsd.functions.FSGOperationStateHandling;
import de.vw.mib.bap.mqbpq.navsd.functions.FunctionList;
import de.vw.mib.bap.mqbpq.navsd.functions.ManeuverDescriptor;
import de.vw.mib.bap.mqbpq.navsd.functions.RouteGuidanceStatus;
import de.vw.mib.bap.mqbpq.navsd.functions.TurnToInfo;

public class NavSDBindingFactoryAll
implements NavSDBindingFactory {
    @Override
    public BAPStage createNewFunctionListStage() {
        return new FunctionList();
    }

    @Override
    public BAPStage createNewFSGOperationStateStage() {
        return new FSGOperationStateHandling();
    }

    @Override
    public BAPStage createNewCompassInfoStage() {
        return new CompassInfo();
    }

    @Override
    public BAPStage createNewRouteGuidanceStatusStage() {
        return new RouteGuidanceStatus();
    }

    @Override
    public BAPStage createNewDistanceToNextManeuverStage() {
        return new DistanceToNextManeuver();
    }

    @Override
    public BAPStage createNewCurrentPositionInfoStage() {
        return new CurrentPositionInfo();
    }

    @Override
    public BAPStage createNewTurnToInfoStage() {
        return new TurnToInfo();
    }

    @Override
    public BAPStage createNewDistanceTimeToDestinationStage() {
        return new DistanceTimeToDestination();
    }

    @Override
    public BAPStage createNewManeuverDescriptorStage() {
        return new ManeuverDescriptor();
    }
}

