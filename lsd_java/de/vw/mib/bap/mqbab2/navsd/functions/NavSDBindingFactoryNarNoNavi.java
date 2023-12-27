/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.mqbab2.navsd.functions;

import de.vw.mib.bap.mqbab2.common.api.stages.BAPStage;
import de.vw.mib.bap.mqbab2.generated.navsd.NavSDBindingFactory;
import de.vw.mib.bap.mqbab2.navsd.functions.CompassInfoNarNoNavi;
import de.vw.mib.bap.mqbab2.navsd.functions.FSGOperationStateHandlingNarNoNavi;
import de.vw.mib.bap.mqbab2.navsd.functions.FunctionListNarNoNavi;

public class NavSDBindingFactoryNarNoNavi
implements NavSDBindingFactory {
    @Override
    public BAPStage createNewRGStatusStage() {
        return null;
    }

    @Override
    public BAPStage createNewDistanceToDestinationStage() {
        return null;
    }

    @Override
    public BAPStage createNewTimeToDestinationStage() {
        return null;
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
    public BAPStage createNewFunctionListStage() {
        return new FunctionListNarNoNavi();
    }

    @Override
    public BAPStage createNewCurrentPositionInfoStage() {
        return null;
    }

    @Override
    public BAPStage createNewManeuverDescriptorStage() {
        return null;
    }

    @Override
    public BAPStage createNewASGcapabilitiesStage() {
        return null;
    }

    @Override
    public BAPStage createNewActiveRgTypeStage() {
        return null;
    }

    @Override
    public BAPStage createNewAddressListStage() {
        return null;
    }

    @Override
    public BAPStage createNewCalibrationStage() {
        return null;
    }

    @Override
    public BAPStage createNewDistanceToNextManeuverStage() {
        return null;
    }

    @Override
    public BAPStage createNewFavoriteDestListStage() {
        return null;
    }

    @Override
    public BAPStage createNewFunctionSynchronisationStage() {
        return null;
    }

    @Override
    public BAPStage createNewGetNextListPosStage() {
        return null;
    }

    @Override
    public BAPStage createNewInfoStatesStage() {
        return null;
    }

    @Override
    public BAPStage createNewLaneGuidanceStage() {
        return null;
    }

    @Override
    public BAPStage createNewMagnetFieldZoneStage() {
        return null;
    }

    @Override
    public BAPStage createNewNavBookStage() {
        return null;
    }

    @Override
    public BAPStage createNewNbSpellerStage() {
        return null;
    }

    @Override
    public BAPStage createNewRGActDeactStage() {
        return null;
    }

    @Override
    public BAPStage createNewRepeatLastNavAnnouncementStage() {
        return null;
    }

    @Override
    public BAPStage createNewTMCinfoStage() {
        return null;
    }

    @Override
    public BAPStage createNewTrafficBlockIndicationStage() {
        return null;
    }

    @Override
    public BAPStage createNewTurnToInfoStage() {
        return null;
    }

    @Override
    public BAPStage createNewVoiceGuidanceStage() {
        return null;
    }

    @Override
    public BAPStage createNewLastDestListStage() {
        return null;
    }

    @Override
    public BAPStage createNewPreferredDestListStage() {
        return null;
    }

    public BAPStage createNewCalibrationStageStage() {
        return null;
    }

    @Override
    public BAPStage createNewMapColorAndTypeStage() {
        return null;
    }

    @Override
    public BAPStage createNewMapViewAndOrientationStage() {
        return null;
    }

    @Override
    public BAPStage createNewMapScaleStage() {
        return null;
    }

    @Override
    public BAPStage createNewDestinationInfoStage() {
        return null;
    }

    @Override
    public BAPStage createNewAltitudeStage() {
        return null;
    }

    @Override
    public BAPStage createNewOnlineNavigationStateStage() {
        return null;
    }

    @Override
    public BAPStage createNewExitviewStage() {
        return null;
    }

    @Override
    public BAPStage createNewSemidynamicRouteGuidanceStage() {
        return null;
    }

    @Override
    public BAPStage createNewPOISearchStage() {
        return null;
    }

    @Override
    public BAPStage createNewPOIListStage() {
        return null;
    }

    @Override
    public BAPStage createNewFSGSetupStage() {
        return null;
    }

    @Override
    public BAPStage createNewMapPresentationStage() {
        return null;
    }
}

