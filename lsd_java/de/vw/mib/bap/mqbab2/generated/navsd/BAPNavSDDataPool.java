/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.mqbab2.generated.navsd;

import de.vw.mib.bap.mqbab2.common.HsmContextDelegate;
import de.vw.mib.bap.mqbab2.common.api.adapter.AbstractBAPDataPool;
import de.vw.mib.bap.mqbab2.generated.navsd.NavSDBindingFactory;

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
        this.addStage(navSDBindingFactory.createNewRGStatusStage(), 0, 1, "RGStatus");
        this.addStage(navSDBindingFactory.createNewDistanceToNextManeuverStage(), 3, 1, "DistanceToNextManeuver");
        this.addStage(navSDBindingFactory.createNewCurrentPositionInfoStage(), 3, 1, "CurrentPositionInfo");
        this.addStage(navSDBindingFactory.createNewTurnToInfoStage(), 3, 1, "TurnToInfo");
        this.addStage(navSDBindingFactory.createNewDistanceToDestinationStage(), 3, 1, "DistanceToDestination");
        this.addStage(navSDBindingFactory.createNewTimeToDestinationStage(), 3, 1, "TimeToDestination");
        this.addStage(navSDBindingFactory.createNewManeuverDescriptorStage(), 3, 1, "ManeuverDescriptor");
        this.addStage(navSDBindingFactory.createNewLaneGuidanceStage(), 3, 2, "LaneGuidance");
        this.addStage(navSDBindingFactory.createNewTMCinfoStage(), 3, 1, "TMCinfo");
        this.addStage(navSDBindingFactory.createNewMagnetFieldZoneStage(), 0, 1, "MagnetFieldZone");
        this.addStage(navSDBindingFactory.createNewCalibrationStage(), 0, 1, "Calibration");
        this.addStage(navSDBindingFactory.createNewASGcapabilitiesStage(), 3, 1, "ASGcapabilities");
        this.addStage(navSDBindingFactory.createNewLastDestListStage(), 3, 2, "LastDestList");
        this.addStage(navSDBindingFactory.createNewFavoriteDestListStage(), 3, 2, "FavoriteDestList");
        this.addStage(navSDBindingFactory.createNewPreferredDestListStage(), 0, 1, "PreferredDestList");
        this.addStage(navSDBindingFactory.createNewNavBookStage(), 3, 2, "NavBook");
        this.addStage(navSDBindingFactory.createNewAddressListStage(), 3, 2, "AddressList");
        this.addStage(navSDBindingFactory.createNewRGActDeactStage(), 0, 3, "RGActDeact");
        this.addStage(navSDBindingFactory.createNewRepeatLastNavAnnouncementStage(), 0, 3, "RepeatLastNavAnnouncement");
        this.addStage(navSDBindingFactory.createNewVoiceGuidanceStage(), 0, 1, "VoiceGuidance");
        this.addStage(navSDBindingFactory.createNewFunctionSynchronisationStage(), 3, 1, "FunctionSynchronisation");
        this.addStage(navSDBindingFactory.createNewInfoStatesStage(), 0, 1, "InfoStates");
        this.addStage(navSDBindingFactory.createNewActiveRgTypeStage(), 0, 1, "ActiveRgType");
        this.addStage(navSDBindingFactory.createNewTrafficBlockIndicationStage(), 0, 1, "TrafficBlockIndication");
        this.addStage(navSDBindingFactory.createNewGetNextListPosStage(), 3, 3, "GetNextListPos");
        this.addStage(navSDBindingFactory.createNewNbSpellerStage(), 3, 3, "NbSpeller");
        this.addStage(navSDBindingFactory.createNewMapColorAndTypeStage(), 3, 1, "MapColorAndType");
        this.addStage(navSDBindingFactory.createNewMapViewAndOrientationStage(), 3, 1, "MapViewAndOrientation");
        this.addStage(navSDBindingFactory.createNewMapScaleStage(), 3, 1, "MapScale");
        this.addStage(navSDBindingFactory.createNewDestinationInfoStage(), 3, 1, "DestinationInfo");
        this.addStage(navSDBindingFactory.createNewAltitudeStage(), 3, 1, "Altitude");
        this.addStage(navSDBindingFactory.createNewOnlineNavigationStateStage(), 3, 1, "OnlineNavigationState");
        this.addStage(navSDBindingFactory.createNewExitviewStage(), 3, 1, "Exitview");
        this.addStage(navSDBindingFactory.createNewSemidynamicRouteGuidanceStage(), 3, 1, "SemidynamicRouteGuidance");
        this.addStage(navSDBindingFactory.createNewPOISearchStage(), 3, 3, "POISearch");
        this.addStage(navSDBindingFactory.createNewPOIListStage(), 3, 2, "POIList");
        this.addStage(navSDBindingFactory.createNewFSGSetupStage(), 3, 1, "FSGSetup");
        this.addStage(navSDBindingFactory.createNewMapPresentationStage(), 0, 1, "MapPresentation");
    }
}

