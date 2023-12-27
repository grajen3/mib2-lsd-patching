/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.mqbpq.navsd.functions;

import de.vw.mib.bap.mqbpq.common.api.stages.BAPStage;
import de.vw.mib.bap.mqbpq.generated.navsd.NavSDBindingFactory;
import de.vw.mib.bap.mqbpq.navsd.functions.CompassInfoNarNoNavi;
import de.vw.mib.bap.mqbpq.navsd.functions.FSGOperationStateHandlingNarNoNavi;
import de.vw.mib.bap.mqbpq.navsd.functions.FunctionListNarNoNavi;

public final class NavSDBindingFactoryNarNoNavi
implements NavSDBindingFactory {
    @Override
    public BAPStage createNewFunctionListStage() {
        return new FunctionListNarNoNavi();
    }

    @Override
    public BAPStage createNewFSGOperationStateStage() {
        return new FSGOperationStateHandlingNarNoNavi();
    }

    @Override
    public BAPStage createNewCompassInfoStage() {
        return new CompassInfoNarNoNavi();
    }

    @Override
    public BAPStage createNewRouteGuidanceStatusStage() {
        return null;
    }

    @Override
    public BAPStage createNewDistanceToNextManeuverStage() {
        return null;
    }

    @Override
    public BAPStage createNewCurrentPositionInfoStage() {
        return null;
    }

    @Override
    public BAPStage createNewTurnToInfoStage() {
        return null;
    }

    @Override
    public BAPStage createNewDistanceTimeToDestinationStage() {
        return null;
    }

    @Override
    public BAPStage createNewManeuverDescriptorStage() {
        return null;
    }
}

