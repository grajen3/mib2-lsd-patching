/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.mqbab2.navsd.functions;

import de.vw.mib.bap.mqbab2.common.api.stages.BAPStage;
import de.vw.mib.bap.mqbab2.generated.navsd.NavSDBindingFactory;
import de.vw.mib.bap.mqbab2.navsd.functions.ASGcapabilities;
import de.vw.mib.bap.mqbab2.navsd.functions.ActiveRgType;
import de.vw.mib.bap.mqbab2.navsd.functions.AddressList;
import de.vw.mib.bap.mqbab2.navsd.functions.Altitude;
import de.vw.mib.bap.mqbab2.navsd.functions.Calibration;
import de.vw.mib.bap.mqbab2.navsd.functions.CompassInfo;
import de.vw.mib.bap.mqbab2.navsd.functions.CurrentPositionInfo;
import de.vw.mib.bap.mqbab2.navsd.functions.DestinationInfo;
import de.vw.mib.bap.mqbab2.navsd.functions.DistanceToDestination;
import de.vw.mib.bap.mqbab2.navsd.functions.DistanceToNextManeuver;
import de.vw.mib.bap.mqbab2.navsd.functions.ExitView;
import de.vw.mib.bap.mqbab2.navsd.functions.FSGOperationStateHandling;
import de.vw.mib.bap.mqbab2.navsd.functions.FSGSetup;
import de.vw.mib.bap.mqbab2.navsd.functions.FavoriteDestList;
import de.vw.mib.bap.mqbab2.navsd.functions.FunctionList;
import de.vw.mib.bap.mqbab2.navsd.functions.FunctionSynchronisation;
import de.vw.mib.bap.mqbab2.navsd.functions.GetNextListPos;
import de.vw.mib.bap.mqbab2.navsd.functions.InfoStates;
import de.vw.mib.bap.mqbab2.navsd.functions.LaneGuidance;
import de.vw.mib.bap.mqbab2.navsd.functions.LastDestList;
import de.vw.mib.bap.mqbab2.navsd.functions.MagnetFieldZone;
import de.vw.mib.bap.mqbab2.navsd.functions.ManeuverDescriptor;
import de.vw.mib.bap.mqbab2.navsd.functions.MapColorAndType;
import de.vw.mib.bap.mqbab2.navsd.functions.MapPresentation;
import de.vw.mib.bap.mqbab2.navsd.functions.MapScale;
import de.vw.mib.bap.mqbab2.navsd.functions.MapViewAndOrientation;
import de.vw.mib.bap.mqbab2.navsd.functions.NavBook;
import de.vw.mib.bap.mqbab2.navsd.functions.NbSpeller;
import de.vw.mib.bap.mqbab2.navsd.functions.OnlineNavigationState;
import de.vw.mib.bap.mqbab2.navsd.functions.POIList;
import de.vw.mib.bap.mqbab2.navsd.functions.POISearch;
import de.vw.mib.bap.mqbab2.navsd.functions.PreferredDestList;
import de.vw.mib.bap.mqbab2.navsd.functions.RGActDeact;
import de.vw.mib.bap.mqbab2.navsd.functions.RGStatus;
import de.vw.mib.bap.mqbab2.navsd.functions.RepeatLastNavAnnouncement;
import de.vw.mib.bap.mqbab2.navsd.functions.SemidynamicRouteGuidance;
import de.vw.mib.bap.mqbab2.navsd.functions.TMCinfo;
import de.vw.mib.bap.mqbab2.navsd.functions.TimeToDestination;
import de.vw.mib.bap.mqbab2.navsd.functions.TrafficBlockIndication;
import de.vw.mib.bap.mqbab2.navsd.functions.TurnToInfo;
import de.vw.mib.bap.mqbab2.navsd.functions.VoiceGuidance;

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
    public BAPStage createNewRGStatusStage() {
        return new RGStatus();
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
    public BAPStage createNewDistanceToDestinationStage() {
        return new DistanceToDestination();
    }

    @Override
    public BAPStage createNewTimeToDestinationStage() {
        return new TimeToDestination();
    }

    @Override
    public BAPStage createNewManeuverDescriptorStage() {
        return new ManeuverDescriptor();
    }

    @Override
    public BAPStage createNewLaneGuidanceStage() {
        return new LaneGuidance();
    }

    @Override
    public BAPStage createNewTMCinfoStage() {
        return new TMCinfo();
    }

    @Override
    public BAPStage createNewMagnetFieldZoneStage() {
        return new MagnetFieldZone();
    }

    @Override
    public BAPStage createNewCalibrationStage() {
        return new Calibration();
    }

    @Override
    public BAPStage createNewASGcapabilitiesStage() {
        return new ASGcapabilities();
    }

    @Override
    public BAPStage createNewLastDestListStage() {
        return new LastDestList();
    }

    @Override
    public BAPStage createNewFavoriteDestListStage() {
        return new FavoriteDestList();
    }

    @Override
    public BAPStage createNewPreferredDestListStage() {
        return new PreferredDestList();
    }

    @Override
    public BAPStage createNewNavBookStage() {
        return new NavBook();
    }

    @Override
    public BAPStage createNewAddressListStage() {
        return new AddressList();
    }

    @Override
    public BAPStage createNewRGActDeactStage() {
        return new RGActDeact();
    }

    @Override
    public BAPStage createNewRepeatLastNavAnnouncementStage() {
        return new RepeatLastNavAnnouncement();
    }

    @Override
    public BAPStage createNewVoiceGuidanceStage() {
        return new VoiceGuidance();
    }

    @Override
    public BAPStage createNewFunctionSynchronisationStage() {
        return new FunctionSynchronisation();
    }

    @Override
    public BAPStage createNewInfoStatesStage() {
        return new InfoStates();
    }

    @Override
    public BAPStage createNewActiveRgTypeStage() {
        return new ActiveRgType();
    }

    @Override
    public BAPStage createNewTrafficBlockIndicationStage() {
        return new TrafficBlockIndication();
    }

    @Override
    public BAPStage createNewGetNextListPosStage() {
        return new GetNextListPos();
    }

    @Override
    public BAPStage createNewNbSpellerStage() {
        return new NbSpeller();
    }

    public BAPStage createNewMapColorStage() {
        return new MapColorAndType();
    }

    public BAPStage createNewMapViewStage() {
        return new MapViewAndOrientation();
    }

    @Override
    public BAPStage createNewMapScaleStage() {
        return new MapScale();
    }

    @Override
    public BAPStage createNewDestinationInfoStage() {
        return new DestinationInfo();
    }

    @Override
    public BAPStage createNewAltitudeStage() {
        return new Altitude();
    }

    @Override
    public BAPStage createNewOnlineNavigationStateStage() {
        return new OnlineNavigationState();
    }

    @Override
    public BAPStage createNewMapColorAndTypeStage() {
        return new MapColorAndType();
    }

    @Override
    public BAPStage createNewMapViewAndOrientationStage() {
        return new MapViewAndOrientation();
    }

    @Override
    public BAPStage createNewExitviewStage() {
        return new ExitView();
    }

    @Override
    public BAPStage createNewSemidynamicRouteGuidanceStage() {
        return new SemidynamicRouteGuidance();
    }

    @Override
    public BAPStage createNewPOISearchStage() {
        return new POISearch();
    }

    @Override
    public BAPStage createNewPOIListStage() {
        return new POIList();
    }

    @Override
    public BAPStage createNewFSGSetupStage() {
        return new FSGSetup();
    }

    @Override
    public BAPStage createNewMapPresentationStage() {
        return new MapPresentation();
    }
}

