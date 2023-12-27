/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.mqbab2.common.api.navigation;

import de.vw.mib.asl.api.navigation.ASLNavigationFactory;
import de.vw.mib.asl.api.navigation.INavServiceStateListener;
import de.vw.mib.asl.api.navigation.NavigationServiceException;
import de.vw.mib.asl.api.navigation.map.instrumentcluster.ICMapListener;
import de.vw.mib.asl.api.navigation.map.instrumentcluster.ICMapService;
import de.vw.mib.asl.internal.list.ASLList;
import de.vw.mib.bap.mqbab2.common.api.APIFactoryInterface;
import de.vw.mib.bap.mqbab2.common.api.asl.HMIRelevantASLDataPoolAdapter;
import de.vw.mib.bap.mqbab2.common.api.navigation.NavigationService;
import de.vw.mib.bap.mqbab2.common.api.navigation.NavigationServiceListener;
import de.vw.mib.bap.mqbab2.common.api.navigation.datatypes.NavigationCurrentAltitude;
import de.vw.mib.bap.mqbab2.common.api.navigation.datatypes.NavigationDestinationInfo;
import de.vw.mib.bap.mqbab2.common.api.navigation.datatypes.NavigationDistanceToDestination;
import de.vw.mib.bap.mqbab2.common.api.navigation.datatypes.NavigationDistanceToNextManeuver;
import de.vw.mib.bap.mqbab2.common.api.navigation.datatypes.NavigationMapScale;
import de.vw.mib.bap.mqbab2.common.api.navigation.datatypes.NavigationOnlineNavigationState;
import de.vw.mib.bap.mqbab2.common.api.navigation.datatypes.NavigationRemainingTravelTime;
import de.vw.mib.bap.mqbab2.common.api.navigation.datatypes.NavigationStopoverInfo;
import de.vw.mib.bap.mqbab2.common.api.navigation.datatypes.NavigationSupportedMapOrientations;
import de.vw.mib.bap.mqbab2.common.api.navigation.datatypes.NavigationSupportedMapTypes;
import de.vw.mib.bap.mqbab2.common.api.navigation.datatypes.NavigationSupportedMapViews;
import de.vw.mib.bap.mqbab2.common.api.navigation.datatypes.NavigationTimeToDestination;
import de.vw.mib.bap.mqbab2.common.api.navigation.datatypes.NavigationTurnToInfo;
import de.vw.mib.bap.mqbab2.common.api.navigation.datatypes.iterator.asl.FavoriteDestinationsASLDataPoolIterator;
import de.vw.mib.bap.mqbab2.common.api.navigation.datatypes.iterator.asl.FavoriteDestinationsWindowedASLDataPoolIterator;
import de.vw.mib.bap.mqbab2.common.api.navigation.datatypes.iterator.asl.FavoriteDestinationsWindowedCachedASLDataPoolIterator;
import de.vw.mib.bap.mqbab2.common.api.navigation.datatypes.iterator.asl.LaneGuidanceASLDataPoolIterator;
import de.vw.mib.bap.mqbab2.common.api.navigation.datatypes.iterator.asl.LastDestinationsASLDataPoolIterator;
import de.vw.mib.bap.mqbab2.common.api.navigation.datatypes.iterator.asl.LastDestinationsWindowedASLDataPoolIterator;
import de.vw.mib.bap.mqbab2.common.api.navigation.datatypes.iterator.asl.LastDestinationsWindowedCachedASLDataPoolIterator;
import de.vw.mib.bap.mqbab2.common.api.navigation.datatypes.iterator.asl.ManeuverDescriptorASLDataPoolIterator;
import de.vw.mib.bap.mqbab2.common.api.navigation.datatypes.iterator.asl.TMCInfosASLDataPoolIterator;
import de.vw.mib.datapool.ASLDatapool;
import de.vw.mib.genericevents.EventGeneric;
import generated.de.vw.mib.asl.internal.ListManager;
import java.util.Iterator;
import java.util.List;

public class NavigationASLDataAdapter
extends HMIRelevantASLDataPoolAdapter
implements NavigationService,
NavigationDestinationInfo,
NavigationCurrentAltitude,
NavigationTimeToDestination,
NavigationDistanceToDestination,
NavigationStopoverInfo,
NavigationDistanceToNextManeuver,
NavigationSupportedMapViews,
NavigationMapScale,
NavigationSupportedMapTypes,
NavigationSupportedMapOrientations,
NavigationOnlineNavigationState,
NavigationRemainingTravelTime,
NavigationTurnToInfo,
ICMapListener,
INavServiceStateListener {
    private APIFactoryInterface apiFactory;
    private static final int[] NAVIGATION_ASL_PROPERTY_IDS_TO_LISTEN_TO = new int[]{733, 738, 732, 735, 727, 734, 3937, 963062784, 3792, 731, 736, 730, 3793, 3794, 3790, 737153024, 737, 729, 2388, 2389, 485494784, 502272000};
    private static final int[] NAVIGATION_ASL_LIST_ITEM_IDS_TO_LISTEN_TO = new int[]{3799, 3801, 750, 749, 3800, 741, 742, 3796, 3798, 3795, 3797, 3802, 740, 753930240, 744, 745, 751, 743, 748};
    private static final int[] NAVIGATION_HMI_EVENT_IDS_TO_LISTEN_TO = new int[]{75, 74, 76, 73};
    private ICMapService icMapService;
    static /* synthetic */ Class class$de$vw$mib$bap$mqbab2$common$api$navigation$NavigationService;

    public NavigationASLDataAdapter(APIFactoryInterface aPIFactoryInterface, ASLDatapool aSLDatapool) {
        super(aSLDatapool);
        this.apiFactory = aPIFactoryInterface;
        this.apiFactory.getHMIEventService().addHMIEventListener(this, NAVIGATION_HMI_EVENT_IDS_TO_LISTEN_TO);
        ASLNavigationFactory.getNavigationApi().registerNavServiceStateListener(this);
        this.getICMapService();
    }

    protected APIFactoryInterface getAPIFactory() {
        return this.apiFactory;
    }

    public static Class getServiceClass() {
        return class$de$vw$mib$bap$mqbab2$common$api$navigation$NavigationService == null ? (class$de$vw$mib$bap$mqbab2$common$api$navigation$NavigationService = NavigationASLDataAdapter.class$("de.vw.mib.bap.mqbab2.common.api.navigation.NavigationService")) : class$de$vw$mib$bap$mqbab2$common$api$navigation$NavigationService;
    }

    private ICMapService getICMapService() {
        if (this.getNavigationServiceState() == 100 && this.icMapService == null) {
            try {
                this.icMapService = ASLNavigationFactory.getNavigationApi().getICMapService(this);
            }
            catch (NavigationServiceException navigationServiceException) {
                // empty catch block
            }
        }
        return this.icMapService;
    }

    @Override
    public int getDestinationInfoLatitude() {
        ASLList aSLList = ListManager.getASLList(3799);
        Object object = aSLList.getRowItem(0);
        return aSLList.getListTransformer().getInt(0, object);
    }

    @Override
    public int getDestinationInfoLongitude() {
        ASLList aSLList = ListManager.getASLList(3799);
        Object object = aSLList.getRowItem(0);
        return aSLList.getListTransformer().getInt(1, object);
    }

    @Override
    public int getDestinationInfoPoiType() {
        ASLList aSLList = ListManager.getASLList(3799);
        Object object = aSLList.getRowItem(0);
        return aSLList.getListTransformer().getInt(8, object);
    }

    @Override
    public String getDestinationInfoPoiDescription() {
        ASLList aSLList = ListManager.getASLList(3799);
        Object object = aSLList.getRowItem(0);
        return aSLList.getListTransformer().getString(7, object);
    }

    @Override
    public String getDestinationInfoStreet() {
        ASLList aSLList = ListManager.getASLList(3799);
        Object object = aSLList.getRowItem(0);
        return aSLList.getListTransformer().getString(2, object);
    }

    @Override
    public String getDestinationInfoTown() {
        ASLList aSLList = ListManager.getASLList(3799);
        Object object = aSLList.getRowItem(0);
        return aSLList.getListTransformer().getString(3, object);
    }

    @Override
    public String getDestinationInfoState() {
        ASLList aSLList = ListManager.getASLList(3799);
        Object object = aSLList.getRowItem(0);
        return aSLList.getListTransformer().getString(4, object);
    }

    @Override
    public String getDestinationInfoPostalCode() {
        ASLList aSLList = ListManager.getASLList(3799);
        Object object = aSLList.getRowItem(0);
        return aSLList.getListTransformer().getString(5, object);
    }

    @Override
    public String getDestinationInfoCountry() {
        ASLList aSLList = ListManager.getASLList(3799);
        Object object = aSLList.getRowItem(0);
        return aSLList.getListTransformer().getString(6, object);
    }

    @Override
    public NavigationDestinationInfo getNavigationDestinationInfo() {
        return this;
    }

    @Override
    public int getCurrentAltitude() {
        ASLList aSLList = ListManager.getASLList(3801);
        Object object = aSLList.getRowItem(0);
        return aSLList.getListTransformer().getInt(0, object);
    }

    @Override
    public int getCurrentAltitudeUnit() {
        ASLList aSLList = ListManager.getASLList(3801);
        Object object = aSLList.getRowItem(0);
        return aSLList.getListTransformer().getInt(1, object);
    }

    @Override
    public NavigationCurrentAltitude getNavigationCurrentAltitude() {
        return this;
    }

    @Override
    public final int getNavigationStatus() {
        return this.getDataPool().getInteger(733, 0);
    }

    @Override
    public final String getCurrentPositionInfo() {
        return this.getDataPool().getString(738, "");
    }

    @Override
    public final int getRouteGuidanceState() {
        return this.getDataPool().getInteger(732, 0);
    }

    @Override
    public final int getNavigationOperationState() {
        return this.getDataPool().getInteger(735, 0);
    }

    @Override
    public final int getFavoriteDestinationsNumberOfEntries() {
        return this.getDataPool().getInteger(727, -1);
    }

    @Override
    public final boolean isGPSSignalAvailable() {
        return this.getDataPool().getBoolean(734, true);
    }

    @Override
    public final boolean isNavigationDemoModeActive() {
        return this.getDataPool().getBoolean(3937, false);
    }

    @Override
    public final boolean isGALRouteGuidanceActive() {
        return this.getDataPool().getBoolean(963062784, false);
    }

    @Override
    public final int getActiveMapType() {
        return this.getDataPool().getInteger(3792, 0);
    }

    @Override
    public int getTimeToDestinationMinutes() {
        ASLList aSLList = ListManager.getASLList(750);
        Object object = aSLList.getRowItem(0);
        return aSLList.getListTransformer().getInt(2, object);
    }

    @Override
    public int getTimeToDestinationHours() {
        ASLList aSLList = ListManager.getASLList(750);
        Object object = aSLList.getRowItem(0);
        return aSLList.getListTransformer().getInt(3, object);
    }

    @Override
    public int getTimeToDestinationDays() {
        ASLList aSLList = ListManager.getASLList(750);
        Object object = aSLList.getRowItem(0);
        return aSLList.getListTransformer().getInt(4, object);
    }

    @Override
    public int getTimeToDestinationMonths() {
        ASLList aSLList = ListManager.getASLList(750);
        Object object = aSLList.getRowItem(0);
        return aSLList.getListTransformer().getInt(5, object);
    }

    @Override
    public int getTimeToDestinationYears() {
        ASLList aSLList = ListManager.getASLList(750);
        Object object = aSLList.getRowItem(0);
        return aSLList.getListTransformer().getInt(6, object);
    }

    @Override
    public NavigationTimeToDestination getTimeToDestination() {
        return this;
    }

    @Override
    public int getDistanceToDestinationDistance() {
        ASLList aSLList = ListManager.getASLList(749);
        Object object = aSLList.getRowItem(0);
        return aSLList.getListTransformer().getInt(0, object);
    }

    @Override
    public int getDistanceToDestinationType() {
        ASLList aSLList = ListManager.getASLList(749);
        Object object = aSLList.getRowItem(0);
        return aSLList.getListTransformer().getInt(2, object);
    }

    @Override
    public int getDistanceToDestinationDistanceUnit() {
        ASLList aSLList = ListManager.getASLList(749);
        Object object = aSLList.getRowItem(0);
        return aSLList.getListTransformer().getInt(1, object);
    }

    @Override
    public NavigationDistanceToDestination getDistanceToDestination() {
        return this;
    }

    @Override
    public Iterator getManeuverDescriptor() {
        return new ManeuverDescriptorASLDataPoolIterator();
    }

    @Override
    public int getTotalNumberOfStopovers() {
        ASLList aSLList = ListManager.getASLList(3800);
        Object object = aSLList.getRowItem(0);
        return aSLList.getListTransformer().getInt(0, object);
    }

    @Override
    public int getCurrentStopover() {
        ASLList aSLList = ListManager.getASLList(3800);
        Object object = aSLList.getRowItem(0);
        return aSLList.getListTransformer().getInt(1, object);
    }

    @Override
    public NavigationStopoverInfo getStopoverInfo() {
        return this;
    }

    @Override
    public int getDistanceToNextManeuverDistance() {
        ASLList aSLList = ListManager.getASLList(741);
        Object object = aSLList.getRowItem(0);
        return aSLList.getListTransformer().getInt(0, object);
    }

    @Override
    public int getDistanceToNextManeuverDistanceUnit() {
        ASLList aSLList = ListManager.getASLList(741);
        Object object = aSLList.getRowItem(0);
        return aSLList.getListTransformer().getInt(1, object);
    }

    @Override
    public int getDistanceToNextManeuverBargraphOnOff() {
        ASLList aSLList = ListManager.getASLList(741);
        Object object = aSLList.getRowItem(0);
        return aSLList.getListTransformer().getInt(2, object);
    }

    @Override
    public int getDistanceToNextManeuverBargraph() {
        ASLList aSLList = ListManager.getASLList(741);
        Object object = aSLList.getRowItem(0);
        return aSLList.getListTransformer().getInt(3, object);
    }

    @Override
    public NavigationDistanceToNextManeuver getDistanceToNextManeuver() {
        return this;
    }

    @Override
    public int getVoiceGuidanceStatus() {
        return this.getDataPool().getInteger(736, 0);
    }

    @Override
    public int getGuidanceAnnouncementActive() {
        return this.getDataPool().getInteger(730, 0);
    }

    @Override
    public Iterator getLaneGuidance() {
        return new LaneGuidanceASLDataPoolIterator();
    }

    @Override
    public boolean isSetupLaneGuidanceActive() {
        return this.getDataPool().getBoolean(731, true);
    }

    @Override
    public final int getActiveMapView() {
        return this.getDataPool().getInteger(3793, 0);
    }

    @Override
    public boolean isStandardMapSupported() {
        ASLList aSLList = ListManager.getASLList(3796);
        Object object = aSLList.getRowItem(0);
        return aSLList.getListTransformer().getBoolean(0, object);
    }

    @Override
    public boolean isGoogleEarthMapSupported() {
        ASLList aSLList = ListManager.getASLList(3796);
        Object object = aSLList.getRowItem(0);
        return aSLList.getListTransformer().getBoolean(1, object);
    }

    @Override
    public boolean isTrafficMapSupported() {
        ASLList aSLList = ListManager.getASLList(3796);
        Object object = aSLList.getRowItem(0);
        return aSLList.getListTransformer().getBoolean(2, object);
    }

    @Override
    public NavigationSupportedMapViews getSupportedMapViews() {
        return this;
    }

    @Override
    public int getMapScaleScale() {
        ASLList aSLList = ListManager.getASLList(3798);
        Object object = aSLList.getRowItem(0);
        return aSLList.getListTransformer().getInt(0, object);
    }

    @Override
    public int getMapScaleScaleUnit() {
        ASLList aSLList = ListManager.getASLList(3798);
        Object object = aSLList.getRowItem(0);
        return aSLList.getListTransformer().getInt(1, object);
    }

    @Override
    public NavigationMapScale getMapScale() {
        return this;
    }

    @Override
    public boolean isSupportedMapTypesDestinationMapSupported() {
        ASLList aSLList = ListManager.getASLList(3795);
        Object object = aSLList.getRowItem(0);
        return aSLList.getListTransformer().getBoolean(0, object);
    }

    @Override
    public boolean isSupportedMapTypesPosition2DMapSupported() {
        ASLList aSLList = ListManager.getASLList(3795);
        Object object = aSLList.getRowItem(0);
        return aSLList.getListTransformer().getBoolean(1, object);
    }

    @Override
    public boolean isSupportedMapTypesPosition3DMapSupported() {
        ASLList aSLList = ListManager.getASLList(3795);
        Object object = aSLList.getRowItem(0);
        return aSLList.getListTransformer().getBoolean(2, object);
    }

    @Override
    public boolean isSupportedMapTypesOverviewMapSupported() {
        ASLList aSLList = ListManager.getASLList(3795);
        Object object = aSLList.getRowItem(0);
        return aSLList.getListTransformer().getBoolean(3, object);
    }

    @Override
    public NavigationSupportedMapTypes getSupportedMapTypes() {
        return this;
    }

    @Override
    public final int getActiveMapOrientation() {
        return this.getDataPool().getInteger(3794, 0);
    }

    @Override
    public boolean isSupportedMapOrientationsAutomaticOrientationSupported() {
        ASLList aSLList = ListManager.getASLList(3797);
        Object object = aSLList.getRowItem(0);
        return aSLList.getListTransformer().getBoolean(0, object);
    }

    @Override
    public boolean isSupportedMapOrientationsNorthOrientationSupported() {
        ASLList aSLList = ListManager.getASLList(3797);
        Object object = aSLList.getRowItem(0);
        return aSLList.getListTransformer().getBoolean(1, object);
    }

    @Override
    public boolean isSupportedMapOrientationsDirectionOfTravelSupported() {
        ASLList aSLList = ListManager.getASLList(3797);
        Object object = aSLList.getRowItem(0);
        return aSLList.getListTransformer().getBoolean(2, object);
    }

    @Override
    public boolean isSupportedMapOrientationsMapOrientationModifiable() {
        ASLList aSLList = ListManager.getASLList(3797);
        Object object = aSLList.getRowItem(0);
        return aSLList.getListTransformer().getBoolean(3, object);
    }

    @Override
    public NavigationSupportedMapOrientations getSupportedMapOrientations() {
        return this;
    }

    @Override
    public final int getOnlineNavigationSystem() {
        return this.getDataPool().getInteger(3790, 0);
    }

    @Override
    public int getOnlineNavigationStateState() {
        ASLList aSLList = ListManager.getASLList(3802);
        Object object = aSLList.getRowItem(0);
        return aSLList.getListTransformer().getInt(0, object);
    }

    @Override
    public int getOnlineNavigationStateProgress() {
        ASLList aSLList = ListManager.getASLList(3802);
        Object object = aSLList.getRowItem(0);
        return aSLList.getListTransformer().getInt(1, object);
    }

    @Override
    public NavigationOnlineNavigationState getOnlineNavigationState() {
        return this;
    }

    @Override
    public int getNumberOfElementsInFavoriteDestinations() {
        return ListManager.getASLList(740).getSize();
    }

    @Override
    public Iterator getFavoriteDestinations() {
        return new FavoriteDestinationsASLDataPoolIterator();
    }

    @Override
    public Iterator getWindowedFavoriteDestinations(int[] nArray) {
        return new FavoriteDestinationsWindowedASLDataPoolIterator(nArray);
    }

    @Override
    public Iterator getWindowedCachedFavoriteDestinations(int[] nArray) {
        return new FavoriteDestinationsWindowedCachedASLDataPoolIterator(nArray);
    }

    @Override
    public final int getTimeToDestinationTimeInfo() {
        return this.getDataPool().getInteger(737153024, 0);
    }

    @Override
    public int getRemainingTravelTimeHours() {
        ASLList aSLList = ListManager.getASLList(753930240);
        Object object = aSLList.getRowItem(0);
        return aSLList.getListTransformer().getInt(2, object);
    }

    @Override
    public int getRemainingTravelTimeMinutes() {
        ASLList aSLList = ListManager.getASLList(753930240);
        Object object = aSLList.getRowItem(0);
        return aSLList.getListTransformer().getInt(1, object);
    }

    @Override
    public NavigationRemainingTravelTime getRemainingTravelTime() {
        return this;
    }

    @Override
    public String getTurnToInfoStreet() {
        ASLList aSLList = ListManager.getASLList(744);
        Object object = aSLList.getRowItem(0);
        return aSLList.getListTransformer().getString(0, object);
    }

    @Override
    public String getTurnToInfoSignPost() {
        ASLList aSLList = ListManager.getASLList(744);
        Object object = aSLList.getRowItem(0);
        return aSLList.getListTransformer().getString(1, object);
    }

    @Override
    public NavigationTurnToInfo getTurnToInfo() {
        return this;
    }

    @Override
    public final boolean getSuggestAlternativeRouteCalculation() {
        return this.getDataPool().getBoolean(737, false);
    }

    @Override
    public int getNumberOfElementsInLastDestinations() {
        return ListManager.getASLList(745).getSize();
    }

    @Override
    public Iterator getLastDestinations() {
        return new LastDestinationsASLDataPoolIterator();
    }

    @Override
    public Iterator getWindowedLastDestinations(int[] nArray) {
        return new LastDestinationsWindowedASLDataPoolIterator(nArray);
    }

    @Override
    public Iterator getWindowedCachedLastDestinations(int[] nArray) {
        return new LastDestinationsWindowedCachedASLDataPoolIterator(nArray);
    }

    @Override
    public final int getCompassInfoAngle() {
        return NavigationASLDataAdapter.getIntegerListValue(748, 1);
    }

    @Override
    public final int getTMCSymbol() {
        return this.getDataPool().getInteger(729, 0);
    }

    @Override
    public Iterator getTMCInfos() {
        return new TMCInfosASLDataPoolIterator();
    }

    @Override
    public boolean isTMCSignalAvailable() {
        return this.getDataPool().getBoolean(2388, false);
    }

    @Override
    public boolean isVISCSignalAvailable() {
        return this.getDataPool().getBoolean(2389, false);
    }

    @Override
    public int getNavigationServiceState() {
        return ASLNavigationFactory.getNavigationApi().getNavigationServiceState();
    }

    @Override
    public void navServiceStateChanged() {
        if (this.getNavigationServiceState() == 100) {
            this.getICMapService();
        }
        this._notifyServiceDelegates(128);
    }

    @Override
    public void switchMapToAbt() {
        this._notifyServiceDelegates(0x1000080);
    }

    @Override
    public void switchMapToKombi() {
        this._notifyServiceDelegates(0x2000080);
    }

    @Override
    public int getKombiMapStatus() {
        return this.getDataPool().getInteger(485494784, 0);
    }

    @Override
    public void updateKombiMapStatus(int n) {
    }

    @Override
    public int getKombiMapVisibility() {
        return this.getDataPool().getInteger(502272000, 0);
    }

    @Override
    public void updateKombiMapVisibility(int n) {
    }

    @Override
    public int getMapSwitchState() {
        ICMapService iCMapService = this.getICMapService();
        if (iCMapService != null) {
            return iCMapService.getMapSwitchState();
        }
        return 0;
    }

    @Override
    public void updateICMapServiceState(int n) {
    }

    @Override
    public void updateMapSwitchState(int n) {
        this._notifyServiceDelegates(0x5000080);
    }

    @Override
    public boolean isMapTemporarilyInABT() {
        ICMapService iCMapService = this.getICMapService();
        if (iCMapService != null) {
            return this.getICMapService().isMapTemporarilyInABT();
        }
        return false;
    }

    @Override
    public int getMapVisibilityInAbt() {
        ICMapService iCMapService = this.getICMapService();
        if (iCMapService != null) {
            if (iCMapService.getMapVisibilityForFPKSwitch()) {
                return 1;
            }
            return 0;
        }
        return 1;
    }

    @Override
    public void updateNavigationMapInAbtVisibility(int n) {
        this._notifyServiceDelegates(0x6000080);
    }

    @Override
    public void setMapSwitchState(int n) {
        ICMapService iCMapService = this.getICMapService();
        if (iCMapService != null) {
            iCMapService.setMapSwitchState(n);
        }
    }

    @Override
    public void setVoiceGuidanceStatus(int n) {
        EventGeneric eventGeneric = this.getAPIFactory().getEventFactory().newEvent();
        eventGeneric.setInt(0, n);
        this.getAPIFactory().getGenericEventsService().getServiceRegister().triggerObserver(-1040121792, eventGeneric);
    }

    @Override
    public void repeatLastNavAnnouncement() {
        this.getAPIFactory().getGenericEventsService().getServiceRegister().triggerObserver(-1090453440);
    }

    @Override
    public void stopCurrentNavAnnouncement() {
        this.getAPIFactory().getGenericEventsService().getServiceRegister().triggerObserver(-1073676224);
    }

    @Override
    public void startRouteGuidance(int n, long l) {
        EventGeneric eventGeneric = this.getAPIFactory().getEventFactory().newEvent();
        eventGeneric.setInt(0, n);
        eventGeneric.setLong(1, l);
        this.getAPIFactory().getGenericEventsService().getServiceRegister().triggerObserver(-922681280, eventGeneric);
        this.getAPIFactory().getSpeechService().performingBAPAction(3);
    }

    @Override
    public void stopRouteGuidance() {
        this.getAPIFactory().getGenericEventsService().getServiceRegister().triggerObserver(-905904064);
        this.getAPIFactory().getSpeechService().performingBAPAction(3);
    }

    @Override
    public void setxUrgentTMCMessageToRead() {
        this.getAPIFactory().getGenericEventsService().getServiceRegister().triggerObserver(-1056899008);
    }

    @Override
    public void setAlternativeRouteCalcSetting(boolean bl) {
        EventGeneric eventGeneric = this.getAPIFactory().getEventFactory().newEvent();
        eventGeneric.setBoolean(0, bl);
        this.getAPIFactory().getGenericEventsService().getServiceRegister().triggerObserver(-1107230656, eventGeneric);
    }

    @Override
    public void setActiveMapOrientation(int n) {
        EventGeneric eventGeneric = this.getAPIFactory().getEventFactory().newEvent();
        eventGeneric.setInt(0, n);
        this.getAPIFactory().getGenericEventsService().getServiceRegister().triggerObserver(-1291190208, eventGeneric);
    }

    @Override
    public void setMapScaleSteps(int n) {
        EventGeneric eventGeneric = this.getAPIFactory().getEventFactory().newEvent();
        eventGeneric.setInt(0, n);
        this.getAPIFactory().getGenericEventsService().getServiceRegister().triggerObserver(-1274412992, eventGeneric);
    }

    @Override
    public void setMapScaleSteps(int n, int n2) {
        EventGeneric eventGeneric = this.getAPIFactory().getEventFactory().newEvent();
        eventGeneric.setInt(0, n);
        eventGeneric.setInt(1, n2);
        this.getAPIFactory().getGenericEventsService().getServiceRegister().triggerObserver(-1274412992, eventGeneric);
    }

    @Override
    public void setActiveMapType(int n) {
        EventGeneric eventGeneric = this.getAPIFactory().getEventFactory().newEvent();
        eventGeneric.setInt(0, n);
        this.getAPIFactory().getGenericEventsService().getServiceRegister().triggerObserver(-1324744640, eventGeneric);
    }

    @Override
    public void setActiveMapView(int n) {
        EventGeneric eventGeneric = this.getAPIFactory().getEventFactory().newEvent();
        eventGeneric.setInt(0, n);
        this.getAPIFactory().getGenericEventsService().getServiceRegister().triggerObserver(-1307967424, eventGeneric);
    }

    @Override
    public void datapoolValueChanged(int n) {
        this._notifyServiceDelegates(n);
    }

    private void _notifyServiceDelegates(int n) {
        List list = this.getRegisteredServiceDelegates(n);
        if (list != null) {
            Iterator iterator = list.iterator();
            while (iterator.hasNext()) {
                NavigationServiceListener navigationServiceListener = (NavigationServiceListener)iterator.next();
                navigationServiceListener.updateNavigationData(this, n);
            }
        }
    }

    @Override
    protected int[] getPropertyIds() {
        return NAVIGATION_ASL_PROPERTY_IDS_TO_LISTEN_TO;
    }

    @Override
    protected int[] getListIds() {
        return NAVIGATION_ASL_LIST_ITEM_IDS_TO_LISTEN_TO;
    }

    @Override
    protected void listValueChanged(int n) {
        this._notifyServiceDelegates(n);
    }

    @Override
    public void addNavigationServiceListener(NavigationServiceListener navigationServiceListener, int[] nArray) {
        this.registerServiceListener((Object)navigationServiceListener, nArray);
    }

    @Override
    public void removeNavigationServiceListener(NavigationServiceListener navigationServiceListener, int[] nArray) {
        this.removeServiceListener(navigationServiceListener, nArray);
    }

    @Override
    public int getMapScaleAutozoom() {
        ASLList aSLList = ListManager.getASLList(3798);
        Object object = aSLList.getRowItem(0);
        return aSLList.getListTransformer().getInt(2, object);
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

