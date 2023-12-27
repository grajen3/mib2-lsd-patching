/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.travellink.main;

import de.vw.mib.asl.api.system.ASLSystemFactory;
import de.vw.mib.asl.api.system.factoryreset.AbstractFactoryResetParticipant;
import de.vw.mib.asl.api.system.factoryreset.FactoryResetComponents;
import de.vw.mib.asl.api.system.factoryreset.FactoryResetService;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.travellink.ApiNavigationException;
import de.vw.mib.asl.internal.travellink.TLinkServiceManager;
import de.vw.mib.asl.internal.travellink.TravelLinkPersistable;
import de.vw.mib.asl.internal.travellink.api.impl.ASLTravelLinkAPIImpl;
import de.vw.mib.asl.internal.travellink.list.GenericPropertyTraces;
import de.vw.mib.asl.internal.travellink.list.GenericPropertyUtility;
import de.vw.mib.asl.internal.travellink.main.StateTopMain$1;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.hsm.AbstractHsmState;
import de.vw.mib.genericevents.hsm.Hsm;
import de.vw.mib.genericevents.hsm.HsmState;
import generated.de.vw.mib.asl.internal.ListManager;
import org.dsi.ifc.travellink.GenericPropertyContainer;

public final class StateTopMain
extends AbstractHsmState {
    private boolean powerOnAlreadyReceived = false;
    private int lastViewId = -1;
    public static boolean isMoviesContextActive = false;
    private boolean isTravelLinkContextActive = false;
    public static boolean isFreeSpellerText = false;
    private final AbstractFactoryResetParticipant travelLinkFactoryResetParticipant = new StateTopMain$1(this);

    public StateTopMain(Hsm hsm, String string, HsmState hsmState) {
        super(hsm, string, hsmState);
    }

    @Override
    public HsmState handle(EventGeneric eventGeneric) {
        if (ServiceManager.logger2.isTraceEnabled(2)) {
            ServiceManager.logger2.trace(2).append("StateTopMain : Event ID = ").append(this.getEventName(eventGeneric.getReceiverEventId())).log();
        }
        switch (eventGeneric.getReceiverEventId()) {
            case 1076041872: {
                TLinkServiceManager.getServiceManager().getDsiTravelLinkMainAdapter().requestAllSubscriptionStates();
                if (ServiceManager.logger2.isTraceEnabled(2)) {
                    ServiceManager.logger2.trace(2).append(" Travellink Context entered ").log();
                }
                TLinkServiceManager.getServiceManager().getGuiControllerMain().updateNavigationCodingInformation();
                TLinkServiceManager.getServiceManager().getDsiTravelLinkSportsAdapter().requestFavoriteTeams();
                this.isTravelLinkContextActive = true;
                break;
            }
            case 1076041873: {
                if (ServiceManager.logger2.isTraceEnabled(2)) {
                    ServiceManager.logger2.trace(2).append(" Travellink Context left ").log();
                }
                TLinkServiceManager.getServiceManager().getDsiTravelLinkMainAdapter().requestStopAllUpdates();
                TLinkServiceManager.getServiceManager().getDsiTravelLinkSportsAdapter().requestStopUpdatesForRankedListEventList();
                TLinkServiceManager.getServiceManager().getRequestQueue().cleanRequestQueue();
                TLinkServiceManager.getServiceManager().getDatapool().clear();
                TLinkServiceManager.getServiceManager().getFuelDetailsNavigator().clear();
                TLinkServiceManager.getServiceManager().getMovieTheaterDetailsNavigator().clear();
                TLinkServiceManager.getServiceManager().getMoviesDetailsNavigator().clear();
                TLinkServiceManager.getServiceManager().getWeather().setSessionIdForRequestWeatherForecast(-1);
                this.isTravelLinkContextActive = false;
                try {
                    if (TLinkServiceManager.getServiceManager().getApiNavigation().isMapLocked()) {
                        throw new ApiNavigationException("StateTopMain - LEFT - Map is locked.");
                    }
                }
                catch (ApiNavigationException apiNavigationException) {
                    ServiceManager.errorHandler.handleError(apiNavigationException);
                }
                break;
            }
            case 1076041874: {
                TLinkServiceManager.getServiceManager().getDsiTravelLinkSkiAdapter().requestSkiResortListForOneState(eventGeneric);
                break;
            }
            case 1076041884: {
                TLinkServiceManager.getServiceManager().getDsiTravelLinkWeatherAdapter().requestWeatherSelectStationList(eventGeneric);
                break;
            }
            case 2: {
                if (this.powerOnAlreadyReceived) break;
                this.powerOnAlreadyReceived = true;
                if (ServiceManager.logger2.isTraceEnabled(2)) {
                    ServiceManager.logger2.trace(2).append(" StateTopMain - HSM_ENTRY event received").log();
                }
                ServiceManager.persistence.registerSharedPersistable(TLinkServiceManager.getServiceManager().getTravelLinkPersistable());
                ServiceManager.persistence.loadPersistable(5023, 0, TLinkServiceManager.getServiceManager().getTravelLinkPersistable());
                this.initGui();
                TLinkServiceManager.getServiceManager().getTargetMain().registerObservers();
                Object[] objectArray = new GenericPropertyContainer[4];
                for (int i2 = 0; i2 < objectArray.length; ++i2) {
                    objectArray[i2] = new GenericPropertyContainer();
                }
                ListManager.getGenericASLList(-1421925632).updateList(objectArray);
                TLinkServiceManager.setTravelLinkReady(true);
                if (TLinkServiceManager.getSdarsTunnerState() != -1) {
                    ASLTravelLinkAPIImpl aSLTravelLinkAPIImpl = new ASLTravelLinkAPIImpl();
                    aSLTravelLinkAPIImpl.updateSdarsTunerState(TLinkServiceManager.getSdarsTunnerState());
                }
                if (TLinkServiceManager.getAudioSubscriptionState() != -1) {
                    ASLTravelLinkAPIImpl aSLTravelLinkAPIImpl = new ASLTravelLinkAPIImpl();
                    aSLTravelLinkAPIImpl.updateAudioSubscription(TLinkServiceManager.getAudioSubscriptionState());
                }
                FactoryResetService factoryResetService = ASLSystemFactory.getSystemApi().getFactoryResetService();
                factoryResetService.addParticipant(this.travelLinkFactoryResetParticipant, FactoryResetComponents.NAVIGATION);
                break;
            }
            case 3: {
                break;
            }
            case 4: {
                break;
            }
            case 100001: {
                break;
            }
            case 100002: {
                break;
            }
            case 100003: {
                break;
            }
            case 100005: {
                break;
            }
            case 100006: {
                break;
            }
            case 100007: {
                break;
            }
            case 3400026: {
                if (ServiceManager.logger2.isTraceEnabled(2)) {
                    ServiceManager.logger2.trace(2).append("StateTopMain - EVENT_SERVICE_INIT - Navigation is initialised successfull.").log();
                }
                TLinkServiceManager.getServiceManager().getApiNavigation().createServiceMainMap();
                TLinkServiceManager.getServiceManager().getGuiControllerTraffic().refreshTrafficMap(false);
                TLinkServiceManager.getServiceManager().getTraffic().showTrafficMiniMap();
                break;
            }
            case 4300068: {
                int n = TLinkServiceManager.getServiceManager().getCurrentViewId();
                if (n != 17 && n != 7 && n != 2) break;
                TLinkServiceManager.getServiceManager().getApiNavigation().ddsRotate(eventGeneric);
                break;
            }
            case 1076041854: {
                if (ServiceManager.logger2.isTraceEnabled(2)) {
                    ServiceManager.logger2.trace(2).append(" SET_VIEW_ENTERED event received ").log();
                }
                this.processEventSetViewEntered(eventGeneric);
                break;
            }
            case 1076041896: {
                if (ServiceManager.logger2.isTraceEnabled(2)) {
                    ServiceManager.logger2.trace(2).append(" SET_VIEW_LEFT event received ").log();
                }
                this.processEventSetViewLeft(eventGeneric);
                break;
            }
            case 1076041826: {
                if (ServiceManager.logger2.isTraceEnabled(64)) {
                    ServiceManager.logger2.trace(64).append(" SET_SELECTED_WEATHER_TAB event received ").log();
                }
                int n = eventGeneric.getInt(0);
                TLinkServiceManager.getServiceManager().getTravelLinkPersistable().setWeatherTabularViewSelection(n);
                TLinkServiceManager.getServiceManager().getGuiControllerWeather().updateSelectedWeatherTab(n);
                break;
            }
            case 1076041832: {
                break;
            }
            case 1076041831: {
                break;
            }
            case 1073744751: {
                break;
            }
            case 1073744753: {
                break;
            }
            case 1073744749: {
                break;
            }
            case 1073744752: {
                TLinkServiceManager.getServiceManager().getSki().requestToDeleteFavoriteSkiResort(eventGeneric);
                break;
            }
            case 1076041897: {
                TLinkServiceManager.getServiceManager().getSki().requestToDeleteFavoriteSkiResort();
                break;
            }
            case 1073744754: {
                TLinkServiceManager.getServiceManager().getGuiControllerSports().updateTeamNameToPopup(eventGeneric);
                break;
            }
            case 1076041906: {
                TLinkServiceManager.getServiceManager().getDsiTravelLinkSportsAdapter().requestSportDeleteFavoriteTeam();
                break;
            }
            case 1073744750: {
                TLinkServiceManager.getServiceManager().getGuiControllerWeather().updateWeatherStationNameToPopup(eventGeneric);
                break;
            }
            case 1076041907: {
                TLinkServiceManager.getServiceManager().getDsiTravelLinkWeatherAdapter().requestToDeleteFavoriteWeatherStation();
                break;
            }
            case 1076041862: {
                if (TLinkServiceManager.getServiceManager().getCurrentViewId() == 7) {
                    if (isMoviesContextActive) {
                        TLinkServiceManager.getServiceManager().getMoviesDetailsNavigator().requestNextMovieTheaterDetails();
                        break;
                    }
                    TLinkServiceManager.getServiceManager().getMovieTheaterDetailsNavigator().requestNextMovieTheaterDetails();
                    break;
                }
                if (TLinkServiceManager.getServiceManager().getCurrentViewId() != 2) break;
                TLinkServiceManager.getServiceManager().getFuelDetailsNavigator().requestNextFuelStationDetails();
                break;
            }
            case 1076041863: {
                if (TLinkServiceManager.getServiceManager().getCurrentViewId() == 7) {
                    if (isMoviesContextActive) {
                        TLinkServiceManager.getServiceManager().getMoviesDetailsNavigator().requestPreviousMovieTheaterDetails();
                        break;
                    }
                    TLinkServiceManager.getServiceManager().getMovieTheaterDetailsNavigator().requestPreviousMovieTheaterDetails();
                    break;
                }
                if (TLinkServiceManager.getServiceManager().getCurrentViewId() != 2) break;
                TLinkServiceManager.getServiceManager().getFuelDetailsNavigator().requestPreviousFuelStationDetails();
                break;
            }
            case 1076041900: {
                break;
            }
            case 1076041901: {
                break;
            }
            case 1076041898: {
                TLinkServiceManager.getServiceManager().getFuel().setPreferredFuelType(eventGeneric);
                break;
            }
            case 1076041828: {
                TLinkServiceManager.getServiceManager().getFuel().setFuelStationListSortOrder(eventGeneric);
                break;
            }
            case 1076041847: {
                TLinkServiceManager.getServiceManager().getFuel().setFuelStationSearchArea(eventGeneric);
                TLinkServiceManager.getServiceManager().getGuiControllerFuel().updateNavigationAddressWithSelectedSearchArea();
                break;
            }
            case 1076041848: {
                TLinkServiceManager.getServiceManager().getMovies().setMovieTheatersSearchArea(eventGeneric);
                TLinkServiceManager.getServiceManager().getGuiControllerMovieTheaters().updateNavigationAddressWithSelectedSearchArea();
                break;
            }
            case 1076041849: {
                TLinkServiceManager.getServiceManager().getMovies().setMoviesSearchArea(eventGeneric);
                TLinkServiceManager.getServiceManager().getMovies().requestMovieTheatersForOneMovie(55);
                TLinkServiceManager.getServiceManager().getGuiControllerMovies().updateNavigationAddressWithSelectedSearchArea();
                break;
            }
            case 1076041834: {
                int n = eventGeneric.getInt(0);
                if (ServiceManager.logger2.isTraceEnabled(16)) {
                    ServiceManager.logger2.trace(16).append("Entered Ski condition view on selecting the resort from resort list").log();
                }
                TLinkServiceManager.getServiceManager().getSki().requestSkiResortInfo(n);
                break;
            }
            case 1076041830: {
                TLinkServiceManager.getServiceManager().getDsiTravelLinkWeatherAdapter().requestToSelectedWeatherStationFromFavoriteList(eventGeneric);
                break;
            }
            case 1076041886: {
                TLinkServiceManager.getServiceManager().getGuiControllerSports().updateSetupSportsFavoriteHeadlineTeamList(eventGeneric);
                break;
            }
            case 1076041887: {
                TLinkServiceManager.getServiceManager().getDsiTravelLinkSportsAdapter().requestSportAddOrDeleteFavoriteTeam(eventGeneric);
                break;
            }
            case 1076041871: {
                int n = eventGeneric.getInt(0);
                TLinkServiceManager.getServiceManager().getSports().playChannelWithChannelType(n);
                if (!ServiceManager.logger2.isTraceEnabled(32)) break;
                ServiceManager.logger2.trace(32).append("Tune channel event received").log();
                break;
            }
            case 1076041835: {
                break;
            }
            case 1076041869: {
                int n = eventGeneric.getInt(0);
                if (ServiceManager.logger2.isTraceEnabled(32)) {
                    ServiceManager.logger2.trace(32).append(" List option \"Final\",\"Live\",\"Scheduled\" has changed: ").append(n).log();
                }
                TLinkServiceManager.getServiceManager().getSports().requestAndUpdateGameListWithTimeFrame(n);
                break;
            }
            case 1076041870: {
                TLinkServiceManager.getServiceManager().getSports().requestandUpdateSelectedSportDetails(eventGeneric);
                break;
            }
            case 1076041853: {
                int n = eventGeneric.getInt(0);
                TLinkServiceManager.getServiceManager().getFuelDetailsNavigator().setCurrentArrayIndex(n);
                TLinkServiceManager.getServiceManager().getFuel().requestFuelStationDetailsForListIndex(n);
                break;
            }
            case 1076041839: {
                if (ServiceManager.logger2.isTraceEnabled(32)) {
                    ServiceManager.logger2.trace(32).append(" SET_SELECTED_LEAGUE_ID event received ").log();
                }
                TLinkServiceManager.getServiceManager().getSports().requestAndUpdateSelectedId(eventGeneric);
                break;
            }
            case 1076041864: {
                TLinkServiceManager.getServiceManager().getMovies().setSelectedMovie(eventGeneric);
                TLinkServiceManager.getServiceManager().getMovies().requestMovieDetails();
                TLinkServiceManager.getServiceManager().getMovies().requestMovieTheatersForOneMovie(55);
                TLinkServiceManager.getServiceManager().getGuiControllerMovies().updateNavigationAddressWithSelectedSearchArea();
                break;
            }
            case 1076041857: {
                if (isMoviesContextActive) {
                    TLinkServiceManager.getServiceManager().getMovies().setSelectedMovieAndTheaterDetails(eventGeneric);
                    break;
                }
                TLinkServiceManager.getServiceManager().getMovieTheaters().setSelectedMovieTheater(eventGeneric);
                TLinkServiceManager.getServiceManager().getMovieTheaters().requestTheaterShowTimes();
                break;
            }
            case 1076041858: {
                TLinkServiceManager.getServiceManager().getMovieTheaters().setSelectedMovieTheaterMovieShowTimes(eventGeneric);
                break;
            }
            case 1076041842: {
                int n = TLinkServiceManager.getServiceManager().getWeather().getSetupEntry();
                if (n == 2) {
                    TLinkServiceManager.getServiceManager().getDsiTravelLinkSkiAdapter().requestResortList(eventGeneric);
                    if (ServiceManager.logger2.isTraceEnabled(16)) {
                        ServiceManager.logger2.trace(16).append("Entered state list for ski ").log();
                    }
                } else if (n == 1) {
                    TLinkServiceManager.getServiceManager().getDsiTravelLinkWeatherAdapter().requestWeatherStationList(eventGeneric);
                    if (ServiceManager.logger2.isTraceEnabled(64)) {
                        ServiceManager.logger2.trace(64).append("Entered state list for weather ").log();
                    }
                }
                if (!ServiceManager.logger2.isTraceEnabled(16)) break;
                ServiceManager.logger2.trace(16).append("Entered state list for ski ").log();
                break;
            }
            case 1076041843: {
                TLinkServiceManager.getServiceManager().getDsiTravelLinkWeatherAdapter().requestToSelectedWeatherStation(eventGeneric);
                break;
            }
            case 1076041844: {
                TLinkServiceManager.getServiceManager().getDsiTravelLinkSkiAdapter().requestSkiCondition(eventGeneric);
                break;
            }
            case 1076041841: {
                break;
            }
            case 1073744783: {
                TLinkServiceManager.getServiceManager().getWeatherGraphical().setSelectedWeatherMap(eventGeneric);
                break;
            }
            case 1076041885: {
                isFreeSpellerText = true;
                break;
            }
            case 1076041829: {
                TLinkServiceManager.getServiceManager().getMovies().setMovieTheatersResultListSortOrder(eventGeneric);
                break;
            }
            case 1076041856: {
                TLinkServiceManager.getServiceManager().getMovies().setMovieTheatersShowTimesListSortOrder(eventGeneric);
                break;
            }
            case 1076041833: {
                long l = -1L;
                boolean bl = true;
                TLinkServiceManager.getServiceManager().getSki().setNearestSkiResortPopupShown(true);
                TLinkServiceManager.getServiceManager().getDsiTravelLinkSkiAdapter().requestSkiCondition(-1L, true);
                TLinkServiceManager.getServiceManager().getSki().checkAndUpdateNearAvailableResortToGui();
                break;
            }
            case 1076041860: {
                String string = eventGeneric.getString(0);
                TLinkServiceManager.getServiceManager().getFreeSpeller().addChar(string);
                break;
            }
            case 1076041859: {
                TLinkServiceManager.getServiceManager().getFreeSpeller().deleteChar();
                break;
            }
            case 1076041861: {
                int n = eventGeneric.getInt(0);
                TLinkServiceManager.getServiceManager().getFreeSpeller().setCursorPosition(n);
                break;
            }
            case 1076041836: {
                ServiceManager.aslPropertyManager.valueChangedInteger(-2076237056, 0);
                ServiceManager.aslPropertyManager.valueChangedString(-2076237056, "Western");
                break;
            }
            case 1076041837: {
                break;
            }
            case 1076041827: {
                int n = -1;
                if (ServiceManager.logger2.isTraceEnabled(64)) {
                    ServiceManager.logger2.trace(64).append("Entered weather tabular view ").log();
                }
                boolean bl = true;
                TLinkServiceManager.getServiceManager().getWeather().setNearestWeatherStationPopupShown(true);
                TLinkServiceManager.getServiceManager().getDsiTravelLinkWeatherAdapter().requestWeatherForecast(n, true, true);
                TLinkServiceManager.getServiceManager().getWeather().checkAndUpdateNearAvailableStationToGui();
                break;
            }
            case 1073744784: {
                TLinkServiceManager.getServiceManager().getApiNavigation().showCCP();
                break;
            }
            case 1076041879: {
                TLinkServiceManager.getServiceManager().getWeatherGraphical().clickInMap(eventGeneric);
                break;
            }
            case 1076041855: {
                TLinkServiceManager.getServiceManager().getApiNavigation().setMapContent(eventGeneric);
                break;
            }
            case 1076041846: {
                TLinkServiceManager.getServiceManager().getSki().requestToAddFavoriteSkiResort(eventGeneric);
                break;
            }
            case 1076041845: {
                TLinkServiceManager.getServiceManager().getDsiTravelLinkWeatherAdapter().requestToAddFavoriteWeatherStation(eventGeneric);
                break;
            }
            case 1076041865: {
                TLinkServiceManager.getServiceManager().getMovies().setSelectedListSortOrderForMoviesResult(eventGeneric);
                break;
            }
            case 1076041866: {
                TLinkServiceManager.getServiceManager().getSports().requestChangeLeagueLevel(1);
                break;
            }
            case 1076041867: {
                TLinkServiceManager.getServiceManager().getSports().requestChangeLeagueLevel(0);
                break;
            }
            case 1076041868: {
                TLinkServiceManager.getServiceManager().getSports().requestChangeLeagueLevel(TLinkServiceManager.getServiceManager().getSports().getFolderLevelChangeLeague() - 1);
                break;
            }
            case 3400015: {
                if (!ServiceManager.logger2.isTraceEnabled(64)) break;
                ServiceManager.logger2.trace(64).append("Map layer visible ").log();
                break;
            }
            case 3400014: {
                if (!ServiceManager.logger2.isTraceEnabled(64)) break;
                ServiceManager.logger2.trace(64).append("StateTopMain - EVENT_MAP_LAYER_AVAILABLE_UPDATE - Map layer available.").log();
                break;
            }
            case 3400020: {
                this.processEventMapZoomListUpdate(eventGeneric);
                break;
            }
            case 3400017: {
                TLinkServiceManager.getServiceManager().getApiNavigation().setMapLocked(true);
                if (this.isTravelLinkContextActive) {
                    TLinkServiceManager.getServiceManager().getApiNavigation().setInitialMapSettings();
                    TLinkServiceManager.getServiceManager().getTraffic().setTrafficMapScreenShotConfiguration();
                    break;
                }
                TLinkServiceManager.getServiceManager().getTraffic().unlockMapViewer();
                break;
            }
            case 3400013: {
                if (ServiceManager.logger2.isTraceEnabled(64)) {
                    ServiceManager.logger2.trace(64).append("StateTopMain - EVENT_MAP_GOTO_LOCATION_MAP_READY - Map is ready to show").log();
                }
                TLinkServiceManager.getServiceManager().getWeatherGraphical().setWeatherMapModeToFreeMapAndDefaultPerspective();
                TLinkServiceManager.getServiceManager().getTraffic().eventHandlingTrafficMapAvailable();
                TLinkServiceManager.getServiceManager().getGuiControllerWeatherGraphical().showMap();
                break;
            }
            case 3400021: {
                if (!ServiceManager.logger2.isTraceEnabled(64)) break;
                ServiceManager.logger2.trace(64).append("Zoom out done").log();
                break;
            }
            case 3400018: {
                if (!ServiceManager.logger2.isTraceEnabled(64)) break;
                ServiceManager.logger2.trace(64).append("Zoom in done").log();
                break;
            }
            case 3400019: {
                TLinkServiceManager.getServiceManager().getGuiControllerWeatherGraphical().updateZoomLevel(eventGeneric);
                break;
            }
            case 3400011: {
                TLinkServiceManager.getServiceManager().getWeatherGraphical().updateMapPointInfo(eventGeneric);
                break;
            }
            case 3400016: {
                int n = TLinkServiceManager.getServiceManager().getCurrentViewId();
                if (n != 17) break;
                TLinkServiceManager.getServiceManager().getWeatherGraphical().updateMapPosition(eventGeneric);
                break;
            }
            case 3400024: {
                TLinkServiceManager.getServiceManager().getApiNavigation().setServiceReady(true);
                TLinkServiceManager.getServiceManager().getApiNavigation().setServiceError(false);
                TLinkServiceManager.getServiceManager().getGuiControllerWeatherGraphical().updateNavigationLoadingStatus(false);
                TLinkServiceManager.getServiceManager().getGuiControllerMain().updateNavigationStatusOnServiceReady();
                if (TLinkServiceManager.getServiceManager().getApiNavigation().isMapLockedRequested() || 17 != TLinkServiceManager.getServiceManager().getCurrentViewId()) break;
                TLinkServiceManager.getServiceManager().getApiNavigation().setMapLockedRequested(true);
                TLinkServiceManager.getServiceManager().getApiNavigation().lockMapViewer();
                break;
            }
            case 3400025: {
                TLinkServiceManager.getServiceManager().getApiNavigation().setServiceReady(false);
                TLinkServiceManager.getServiceManager().getGuiControllerWeatherGraphical().updateNavigationLoadingStatus(true);
                break;
            }
            case 3400022: {
                TLinkServiceManager.getServiceManager().getApiNavigation().setServiceError(true);
                ServiceManager.logger2.trace(64).append("Navigation status changed with event (EVENT_SERVICE_ERROR) ").log();
                TLinkServiceManager.getServiceManager().getMain().updateNavigationStatus(eventGeneric);
                break;
            }
            case 1076041875: {
                TLinkServiceManager.getServiceManager().getApiNavigation().zoomIn();
                break;
            }
            case 1076041876: {
                TLinkServiceManager.getServiceManager().getApiNavigation().zoomOut();
                break;
            }
            case 1076041881: {
                TLinkServiceManager.getServiceManager().getApiNavigation().showRouteOverview();
                break;
            }
            case 1076041882: {
                TLinkServiceManager.getServiceManager().getApiNavigation().showUsaMap();
                break;
            }
            case 1076041880: {
                if (this.lastViewId == 2) {
                    TLinkServiceManager.getServiceManager().getFuel().startGuidance();
                    break;
                }
                if (this.lastViewId != 7) break;
                if (isMoviesContextActive) {
                    TLinkServiceManager.getServiceManager().getMovies().startGuidance();
                    break;
                }
                TLinkServiceManager.getServiceManager().getMovieTheaters().startGuidance();
                break;
            }
            case 1076041883: {
                if (this.lastViewId == 2) {
                    TLinkServiceManager.getServiceManager().getFuel().storeContact();
                    break;
                }
                if (this.lastViewId != 7) break;
                if (isMoviesContextActive) {
                    TLinkServiceManager.getServiceManager().getMovies().storeContact();
                    break;
                }
                TLinkServiceManager.getServiceManager().getMovieTheaters().storeContact();
                break;
            }
            case 1076041877: {
                TLinkServiceManager.getServiceManager().getWeatherGraphical().setTwoFingureZoom(true);
                TLinkServiceManager.getServiceManager().getApiNavigation().pinchWithTwoFingure(eventGeneric);
                break;
            }
            case 1076041878: {
                break;
            }
            case 1076041892: {
                TLinkServiceManager.getServiceManager().getDsiTravelLinkSkiAdapter().checkAndRequestSkiCondition();
                break;
            }
            case 1076041899: {
                TLinkServiceManager.getServiceManager().getSports().setSportsEntry(1);
                TLinkServiceManager.getServiceManager().getTravelLinkPersistable().setListTimeFrameForHeadToHeadGames(1);
                TLinkServiceManager.getServiceManager().getSports().requestAndUpdateGameListForMiniViewEntryToFavoriteList(1);
                if (!ServiceManager.logger2.isTraceEnabled(32)) break;
                ServiceManager.logger2.trace(32).append("Enter sport view through mini view").log();
                break;
            }
            case 1076041893: {
                TLinkServiceManager.getServiceManager().getSports().setSportsEntry(2);
                TLinkServiceManager.getServiceManager().getDsiTravelLinkSportsAdapter().requestFavoriteTeams();
                TLinkServiceManager.getServiceManager().getSports().requestAndUpdateGameListWithAllGameType();
                if (!ServiceManager.logger2.isTraceEnabled(32)) break;
                ServiceManager.logger2.trace(32).append("Enter sport view through sports button in the footer").log();
                break;
            }
            case 1076041891: {
                long l = TLinkServiceManager.getServiceManager().getWeather().getNearByWeatherStationId();
                if (l <= -1L) break;
                TLinkServiceManager.getServiceManager().getWeather().setSelectedWeatherStationId(l);
                TLinkServiceManager.getServiceManager().getDsiTravelLinkWeatherAdapter().requestWeatherForecast(l, false, false);
                break;
            }
            case 1076041890: {
                TLinkServiceManager.getServiceManager().getDsiTravelLinkWeatherAdapter().checkAndRequestWeatherForecast();
                break;
            }
            case 1076041889: {
                break;
            }
            case 1076041888: {
                TLinkServiceManager.getServiceManager().getSports().playChannel(eventGeneric);
                break;
            }
            case 100008: {
                TLinkServiceManager.getServiceManager().getGuiControllerSports().updateSportMainWithReceivedFavorites();
                break;
            }
            case 100010: {
                TLinkServiceManager.getServiceManager().getGuiControllerTraffic().refreshTrafficMap(true);
                break;
            }
            case 100011: {
                TLinkServiceManager.getServiceManager().getTraffic().setTrafficMapAvailable();
                break;
            }
            case 1076041904: {
                TLinkServiceManager.getServiceManager().getMain().updateVisibleMainViewWidgetInAreaOne(eventGeneric);
                break;
            }
            case 1076041905: {
                TLinkServiceManager.getServiceManager().getMain().updateVisibleMainViewWidgetInAreaTwo(eventGeneric);
                break;
            }
            case 1076041908: {
                TLinkServiceManager.getServiceManager().getTraffic().eventHandlingPrepareTrafficMapScreenShot();
                break;
            }
            case 1076041909: {
                TLinkServiceManager.getServiceManager().getTraffic().eventHandlingScreenShotTrafficeMapCreated();
                break;
            }
            case 100009: {
                TLinkServiceManager.getServiceManager().getRequestQueue().startPendingRequests(30);
                break;
            }
            case 4300048: {
                TLinkServiceManager.getServiceManager().getTravelLinkUtil().setDistanceUnit(eventGeneric);
                TLinkServiceManager.getServiceManager().getMain().onUnitChange();
                break;
            }
        }
        return null;
    }

    private String getEventName(int n) {
        switch (n) {
            case 1076041872: {
                return "ASLTravelLinkServiceConstants.ENTERED";
            }
            case 1076041873: {
                return "ASLTravelLinkServiceConstants.LEFT";
            }
            case 1076041874: {
                return "ASLTravelLinkServiceConstants.SET_SELECTED_SKI_STATE";
            }
            case 1076041884: {
                return "ASLTravelLinkServiceConstants.SET_SELECTED_WEATHER_STATE";
            }
            case 2: {
                return "IdEventGeneric.HSM_ENTRY";
            }
            case 3: {
                return "IdEventGeneric.HSM_START";
            }
            case 4: {
                return "IdEventGeneric.HSM_EXIT";
            }
            case 100001: {
                return "TravelLinkEvents.EV_TRAVEL_LINK_TIMER_FOR_TEST_CASES";
            }
            case 100002: {
                return "TravelLinkEvents.EV_TRAVEL_LINK_TIMER_FOR_TEST_CASES1";
            }
            case 100003: {
                return "TravelLinkEvents.EV_TRAVEL_LINK_TIMER_FOR_TEST_CASES2";
            }
            case 100005: {
                return "TravelLinkEvents.EV_TRAVEL_LINK_TIMER_FOR_TEST_CASES4";
            }
            case 100006: {
                return "TravelLinkEvents.EV_TRAVEL_LINK_TIMER_FOR_TEST_CASES5";
            }
            case 100007: {
                return "TravelLinkEvents.EV_TRAVEL_LINK_TIMER_FOR_TEST_CASES6";
            }
            case 3400026: {
                return "ASLNavigationServiceMainMap.EVENT_SERVICE_INIT";
            }
            case 4300068: {
                return "ASLSystemServiceIds.DDS_MENU_ROTATED";
            }
            case 1076041854: {
                return "ASLTravelLinkServiceConstants.SET_VIEW_ENTERED";
            }
            case 1076041896: {
                return "ASLTravelLinkServiceConstants.SET_VIEW_LEFT";
            }
            case 1076041826: {
                return "ASLTravelLinkServiceConstants.SET_SELECTED_WEATHER_TAB";
            }
            case 1076041832: {
                return "ASLTravelLinkServiceConstants.CANCEL_SETTING_SKI_RESORT_LOCATION_TO_CCP";
            }
            case 1076041831: {
                return "ASLTravelLinkServiceConstants.CANCEL_SETTING_WEATHER_LOCATION_TO_CCP";
            }
            case 1073744751: {
                return "ASLTravelLinkServiceConstants.DELETE_ALL_FAVORITE_SKI_RESORTS";
            }
            case 1073744753: {
                return "ASLTravelLinkServiceConstants.DELETE_ALL_FAVORITE_TEAMS";
            }
            case 1073744749: {
                return "ASLTravelLinkServiceConstants.DELETE_ALL_WEATHER_FAVORITE_CITIES";
            }
            case 1073744752: {
                return "ASLTravelLinkServiceConstants.DELETE_FAVORITE_SKI_RESORT";
            }
            case 1076041897: {
                return "ASLTravelLinkServiceConstants.DELETE_FAVORITE_SKI_RESORT_CONFIRMED";
            }
            case 1073744754: {
                return "ASLTravelLinkServiceConstants.DELETE_FAVORITE_TEAM";
            }
            case 1076041906: {
                return "ASLTravelLinkServiceConstants.DELETE_FAVORITE_TEAM_CONFIRMED";
            }
            case 1073744750: {
                return "ASLTravelLinkServiceConstants.DELETE_WEATHER_FAVORITE_CITY";
            }
            case 1076041907: {
                return "ASLTravelLinkServiceConstants.DELETE_WEATHER_FAVORITE_CITY_CONFIRMED";
            }
            case 1076041862: {
                return "ASLTravelLinkServiceConstants.NEXT_RESULT";
            }
            case 1076041863: {
                return "ASLTravelLinkServiceConstants.PREVIOUS_RESULT";
            }
            case 1076041900: {
                return "ASLTravelLinkServiceConstants.MAIN_FUEL_DETAILS_SELECTED";
            }
            case 1076041901: {
                return "ASLTravelLinkServiceConstants.MAIN_FUEL_SELECTED";
            }
            case 1076041898: {
                return "ASLTravelLinkServiceConstants.SET_DYNAMIC_FUEL_TYPE";
            }
            case 1076041828: {
                return "ASLTravelLinkServiceConstants.SET_FUEL_RESULT_LIST_SORT_ORDER";
            }
            case 1076041847: {
                return "ASLTravelLinkServiceConstants.SET_FUEL_SEARCH_AREA";
            }
            case 1076041848: {
                return "ASLTravelLinkServiceConstants.SET_MOVIE_THEATERS_SEARCH_AREA";
            }
            case 1076041849: {
                return "ASLTravelLinkServiceConstants.SET_MOVIE_SEARCH_AREA";
            }
            case 1076041834: {
                return "ASLTravelLinkServiceConstants.SET_SELECTED_SKI_RESORT_FROM_FAVORITE_SKI_RESORT_LIST";
            }
            case 1076041830: {
                return "ASLTravelLinkServiceConstants.SET_SELECTED_WEATHER_STATION_FROM_FAVORITE_CITY_LIST";
            }
            case 1076041886: {
                return "ASLTravelLinkServiceConstants.SET_SETUP_SPORTS_SELECTTEAM_GROUNDLEVEL";
            }
            case 1076041887: {
                return "ASLTravelLinkServiceConstants.SET_SETUP_SPORTS_SELECTTEAM_LEVEL1";
            }
            case 1076041871: {
                return "ASLTravelLinkServiceConstants.SET_SPORTS_HEAD_TO_HEAD_CHANNEL";
            }
            case 1076041835: {
                return "ASLTravelLinkServiceConstants.SET_SELECTED_FAVORITE_TEAM_ITEM";
            }
            case 1076041869: {
                return "ASLTravelLinkServiceConstants.SET_SPORT_RESULT_LIST_SORT_ORDER";
            }
            case 1076041870: {
                return "ASLTravelLinkServiceConstants.SET_SELECTED_SPORT_EVENT";
            }
            case 1076041853: {
                return "ASLTravelLinkServiceConstants.SET_SELECTED_FUEL_RESULT_ID";
            }
            case 1076041839: {
                return "ASLTravelLinkServiceConstants.SET_SELECTED_LEAGUE_ID";
            }
            case 1076041864: {
                return "ASLTravelLinkServiceConstants.SET_SELECTED_MOVIE";
            }
            case 1076041857: {
                return "ASLTravelLinkServiceConstants.SET_SELECTED_MOVIE_THEATER_RESULT_ID";
            }
            case 1076041858: {
                return "ASLTravelLinkServiceConstants.SET_SELECTED_MOVIE_THEATER_RESULT_SHOW_TIMES_ID";
            }
            case 1076041842: {
                return "ASLTravelLinkServiceConstants.SET_SELECTED_STATE_ID";
            }
            case 1076041843: {
                return "ASLTravelLinkServiceConstants.SET_SELECTED_WEATHER_STATION_FROM_SELECT_STATION_LIST";
            }
            case 1076041844: {
                return "ASLTravelLinkServiceConstants.SET_SELECTED_SKI_RESORT_FROM_SELECT_RESORT_LIST";
            }
            case 1076041841: {
                return "ASLTravelLinkServiceConstants.SET_SELECTED_WEATHER_MAP_CLICK_RESULT_LIST_ID";
            }
            case 1073744783: {
                return "ASLTravelLinkServiceConstants.SET_SELECTED_WEATHER_MAP";
            }
            case 1076041885: {
                return "ASLTravelLinkServiceConstants.SPELLER_BUTTON_OK";
            }
            case 1076041829: {
                return "ASLTravelLinkServiceConstants.SET_MOVIE_THEATER_RESULT_LIST_SORT_ORDER";
            }
            case 1076041856: {
                return "ASLTravelLinkServiceConstants.SET_MOVIE_THEATER_RESULTS_SHOW_TIMES_SORT_ORDER";
            }
            case 1076041833: {
                return "ASLTravelLinkServiceConstants.SET_SKI_RESORT_LOCATION_TO_CCP";
            }
            case 1076041860: {
                return "ASLTravelLinkServiceConstants.SET_SPELLER_FREE_CHAR";
            }
            case 1076041859: {
                return "ASLTravelLinkServiceConstants.DELETE_SPELLER_FREE_CHAR";
            }
            case 1076041861: {
                return "ASLTravelLinkServiceConstants.SET_SPELLER_FREE_CURSOR_POS";
            }
            case 1076041836: {
                return "ASLTravelLinkServiceConstants.SETUP_SPORTS_ADD_NEW_FAVORITE_GOTO_ROOT";
            }
            case 1076041837: {
                return "ASLTravelLinkServiceConstants.SETUP_SPORTS_ADD_NEW_FAVORITE_LEVEL_UP";
            }
            case 1076041827: {
                return "ASLTravelLinkServiceConstants.SET_WEATHER_LOCATION_TO_CCP";
            }
            case 1073744784: {
                return "ASLTravelLinkServiceConstants.ZOOM_TO_CCP";
            }
            case 1076041879: {
                return "ASLTravelLinkServiceConstants.SET_CLICK_IN_MAIN_MAP";
            }
            case 1076041855: {
                return "ASLTravelLinkServiceConstants.SET_MAP_CONTENT";
            }
            case 1076041846: {
                return "ASLTravelLinkServiceConstants.ADD_SELECTED_SKI_RESORT_TO_FAVORITE_LIST";
            }
            case 1076041845: {
                return "ASLTravelLinkServiceConstants.ADD_SELECTED_WEATHER_STATION_TO_FAVORITE_LIST";
            }
            case 1076041865: {
                return "ASLTravelLinkServiceConstants.SET_MOVIES_RESULT_LIST_SORT_ORDER";
            }
            case 1076041866: {
                return "ASLTravelLinkServiceConstants.SPORTS_CHANGE_LEAGUE_GOTO_LEAGUE_OVERVIEW";
            }
            case 1076041867: {
                return "ASLTravelLinkServiceConstants.SPORTS_CHANGE_LEAGUE_GOTO_ROOT";
            }
            case 1076041868: {
                return "ASLTravelLinkServiceConstants.SPORTS_CHANGE_LEAGUE_LEVEL_UP";
            }
            case 3400015: {
                return "ASLNavigationServiceMainMap.EVENT_MAP_LAYER_VISIBLE_UPDATE";
            }
            case 3400014: {
                return "ASLNavigationServiceMainMap.EVENT_MAP_LAYER_AVAILABLE_UPDATE";
            }
            case 3400020: {
                return "ASLNavigationServiceMainMap.EVENT_MAP_ZOOM_LIST_UPDATE";
            }
            case 3400017: {
                return "ASLNavigationServiceMainMap.EVENT_MAP_LOCKED";
            }
            case 3400013: {
                return "ASLNavigationServiceMainMap.EVENT_MAP_GOTO_LOCATION_MAP_READY";
            }
            case 3400021: {
                return "ASLNavigationServiceMainMap.EVENT_MAP_ZOOM_OUT_DONE";
            }
            case 3400018: {
                return "ASLNavigationServiceMainMap.EVENT_MAP_ZOOM_IN_DONE";
            }
            case 3400019: {
                return "ASLNavigationServiceMainMap.EVENT_MAP_ZOOM_LEVEL_UPDATE";
            }
            case 3400011: {
                return "ASLNavigationServiceMainMap.EVENT_MAP_CLICK_IN_MAP_RESULT";
            }
            case 3400016: {
                return "ASLNavigationServiceMainMap.EVENT_MAP_POSITION_UPDATE";
            }
            case 3400024: {
                return "ASLNavigationServiceMainMap.EVENT_SERVICE_READY";
            }
            case 3400025: {
                return "ASLNavigationServiceMainMap.EVENT_SERVICE_NOT_READY";
            }
            case 3400022: {
                return "ASLNavigationServiceMainMap.EVENT_SERVICE_ERROR";
            }
            case 1076041875: {
                return "ASLTravelLinkServiceConstants.ZOOM_IN";
            }
            case 1076041876: {
                return "ASLTravelLinkServiceConstants.ZOOM_OUT";
            }
            case 1076041881: {
                return "ASLTravelLinkServiceConstants.ZOOM_TO_OVERALL";
            }
            case 1076041882: {
                return "ASLTravelLinkServiceConstants.ZOOM_TO_WHOLE_USA";
            }
            case 1076041880: {
                return "ASLTravelLinkServiceConstants.START_ROUTE_GUIDANCE";
            }
            case 1076041883: {
                return "ASLTravelLinkServiceConstants.STORE_FROM_DETAILS";
            }
            case 1076041877: {
                return "ASLTravelLinkServiceConstants.TWO_FINGER_ZOOMED";
            }
            case 1076041878: {
                return "ASLTravelLinkServiceConstants.SET_CLICK_IN_DETAIL_SCREEN_MAP";
            }
            case 1076041892: {
                return "ASLTravelLinkServiceConstants.MAIN_SKI_SELECTED";
            }
            case 1076041899: {
                return "ASLTravelLinkServiceConstants.MAIN_SPORTS_FAVORITES_SELECTED";
            }
            case 1076041893: {
                return "ASLTravelLinkServiceConstants.MAIN_SPORTS_SELECTED";
            }
            case 1076041891: {
                return "ASLTravelLinkServiceConstants.MAIN_WEATHER_CURRENT_SELECTED";
            }
            case 1076041890: {
                return "ASLTravelLinkServiceConstants.MAIN_WEATHER_SELECTED";
            }
            case 1076041889: {
                return "ASLTravelLinkServiceConstants.MAIN_WEATHERMAPS_SELECTED";
            }
            case 1076041888: {
                return "ASLTravelLinkServiceConstants.SET_SPORTS_LIVEBROADCAST";
            }
            case 100008: {
                return "TravelLinkEvents.EV_TRAVEL_LINK_TIMER_FOR_MAINVIEW_UPDATE";
            }
            case 100010: {
                return "TravelLinkEvents.EV_TRAVEL_LINK_TIMER_FOR_REFRESHTRAFFICMAP";
            }
            case 100011: {
                return "TravelLinkEvents.EV_TRAVEL_LINK_TIMER_MAP_GOTO_LOCATION_MAP_READY_DELAY";
            }
            case 1076041904: {
                return "ASLTravelLinkServiceConstants.SET_DESKTOP_WIDGET_AREA1SELECTED_INDEX";
            }
            case 1076041905: {
                return "ASLTravelLinkServiceConstants.SET_DESKTOP_WIDGET_AREA2SELECTED_INDEX";
            }
            case 1076041908: {
                return "ASLTravelLinkServiceConstants.PREPARE_TRAFFIC_MAP_SCREENSHOT";
            }
            case 1076041909: {
                return "ASLTravelLinkServiceConstants.SCREENSHOT_TRAFFIC_MAP_CREATED";
            }
            case 100009: {
                return "TravelLinkEvents.EV_TRAVEL_LINK_TIMER_FOR_REQUESTTYPE_TL_FUEL_GAS_STATION_DETAILS";
            }
            case 4300048: {
                return "ASLSystemServiceIds.DISTANCEUNIT_CHANGED";
            }
        }
        return String.valueOf(n);
    }

    private void processEventSetViewEntered(EventGeneric eventGeneric) {
        try {
            int n = eventGeneric.getInt(0);
            TLinkServiceManager.getServiceManager().setCurrentViewId(n);
            if (ServiceManager.logger2.isTraceEnabled(2)) {
                ServiceManager.logger2.trace(2).append("Entered view: ").append(n).log();
            }
            switch (n) {
                case 55: {
                    isMoviesContextActive = false;
                    if (this.lastViewId != 0) break;
                    TLinkServiceManager.getServiceManager().getTravelLinkPersistable().setListSortOrderForMovieTheaterShowTimes(1);
                    TLinkServiceManager.getServiceManager().getGuiControllerMovies().setMovieTheaterShowTimesListSortOrder(1);
                    GenericPropertyContainer genericPropertyContainer = TLinkServiceManager.getServiceManager().getMovieTheaters().getClosestTheaterForMovieTheaters();
                    TLinkServiceManager.getServiceManager().getMovieTheaters().setSelectedTheaterForMovieTheaters(genericPropertyContainer);
                    break;
                }
                case 53: {
                    TLinkServiceManager.getServiceManager().getDsiTravelLinkWeatherAdapter().requestStateList();
                    break;
                }
                case 51: {
                    if (ServiceManager.logger2.isTraceEnabled(32)) {
                        ServiceManager.logger2.trace(32).append("Entered Setup sports ground level ").append(n).log();
                    }
                    TLinkServiceManager.getServiceManager().getDsiTravelLinkSportsAdapter().requestSportLeagueForFavorites();
                    TLinkServiceManager.getServiceManager().getDsiTravelLinkSportsAdapter().requestFavoriteTeams();
                    break;
                }
                case 52: {
                    if (!ServiceManager.logger2.isTraceEnabled(32)) break;
                    ServiceManager.logger2.trace(32).append("Entered Setup sports select team level 1 ").append(n).log();
                    break;
                }
                case 0: {
                    if (ServiceManager.logger2.isTraceEnabled(64)) {
                        ServiceManager.logger2.trace(64).append("Entered Main view ").log();
                    }
                    TLinkServiceManager.getServiceManager().getDsiTravelLinkSportsAdapter().requestStopUpdatesForRankedListEventList();
                    TLinkServiceManager.getServiceManager().getMain().requestNearByData();
                    TLinkServiceManager.getServiceManager().getTraffic().showTrafficMiniMap();
                    TLinkServiceManager.getServiceManager().getSports().setSportsEntry(0);
                    TLinkServiceManager.getServiceManager().getDatapool().clear(31);
                    TLinkServiceManager.getServiceManager().getDatapool().clear(35);
                    TLinkServiceManager.getServiceManager().getDatapool().clear(47);
                    TLinkServiceManager.getServiceManager().getDatapool().clear(29);
                    TLinkServiceManager.getServiceManager().getFuelDetailsNavigator().clear();
                    TLinkServiceManager.getServiceManager().getMovieTheaterDetailsNavigator().clear();
                    TLinkServiceManager.getServiceManager().getMoviesDetailsNavigator().clear();
                    break;
                }
                case 16: {
                    if (!ServiceManager.logger2.isTraceEnabled(64)) break;
                    ServiceManager.logger2.trace(64).append("Entered weather tabular view ").log();
                    break;
                }
                case 13: {
                    break;
                }
                case 1: {
                    TLinkServiceManager.getServiceManager().getDsiTravelLinkFuelAdapter().requestFuelTypes();
                    break;
                }
                case 24: {
                    int n2 = TLinkServiceManager.getServiceManager().getWeather().getSetupEntry();
                    if (n2 == 2) {
                        TLinkServiceManager.getServiceManager().getDsiTravelLinkSkiAdapter().requestStateList();
                        if (!ServiceManager.logger2.isTraceEnabled(16)) break;
                        ServiceManager.logger2.trace(16).append("Entered state list for ski ").log();
                        break;
                    }
                    if (n2 != 1) break;
                    TLinkServiceManager.getServiceManager().getDsiTravelLinkWeatherAdapter().requestStateList();
                    if (!ServiceManager.logger2.isTraceEnabled(64)) break;
                    ServiceManager.logger2.trace(64).append("Entered state list for weather ").log();
                    break;
                }
                case 25: {
                    break;
                }
                case 12: {
                    TLinkServiceManager.getServiceManager().getDsiTravelLinkSkiAdapter().requestFavoriteSkiResorts();
                    TLinkServiceManager.getServiceManager().getWeather().setSetupEntry(2);
                    if (!ServiceManager.logger2.isTraceEnabled(16)) break;
                    ServiceManager.logger2.trace(16).append("Entered favorite ski resort list ").log();
                    break;
                }
                case 2: {
                    TLinkServiceManager.getServiceManager().getApiNavigation().lockMapViewer();
                    TLinkServiceManager.getServiceManager().getFuelDetailsNavigator().setFuelStationIdArray();
                    if (this.lastViewId != 19 || !isFreeSpellerText) break;
                    isFreeSpellerText = false;
                    TLinkServiceManager.getServiceManager().getFuel().storeContact();
                    break;
                }
                case 3: {
                    ListManager.getGenericASLList(-1757469952).updateList(new GenericPropertyContainer[0]);
                    TLinkServiceManager.getServiceManager().getFreeSpeller().clear();
                    TLinkServiceManager.getServiceManager().getFuel().updateSelectedFuelStation();
                    TLinkServiceManager.getServiceManager().getGuiControllerFuel().updateNavigationAddressWithSelectedSearchArea();
                    break;
                }
                case 10: {
                    if (ServiceManager.logger2.isTraceEnabled(4)) {
                        ServiceManager.logger2.trace(4).append(" Entered view SET_VIEW_ENTERED__STATE__C10_FUEL_RESULTS").log();
                    }
                    ListManager.getGenericASLList(-1673583872).updateList(new GenericPropertyContainer[0]);
                    if (this.lastViewId == 3 || this.lastViewId == 19) {
                        TLinkServiceManager.getServiceManager().getDsiTravelLinkFuelAdapter().requestFuelStations(TLinkServiceManager.getServiceManager().getFreeSpeller().getEnteredText(), TLinkServiceManager.getServiceManager().getTravelLinkPersistable().getFuelStationSearchArea(), 29);
                    } else if (this.lastViewId == 0) {
                        TLinkServiceManager.getServiceManager().getDsiTravelLinkFuelAdapter().requestFuelStations("", 0, 29);
                    }
                    TLinkServiceManager.getServiceManager().getFreeSpeller().clear();
                    isFreeSpellerText = false;
                    break;
                }
                case 14: {
                    if (ServiceManager.logger2.isTraceEnabled(32)) {
                        ServiceManager.logger2.trace(32).append("Entered Sports Change league view ").log();
                    }
                    TLinkServiceManager.getServiceManager().getDsiTravelLinkSportsAdapter().requestStopUpdatesForRankedListEventList();
                    TLinkServiceManager.getServiceManager().getSports().requestSportChangeLeague();
                    TLinkServiceManager.getServiceManager().getSports().setSportsEntry(0);
                    break;
                }
                case 31: {
                    if (ServiceManager.logger2.isTraceEnabled(32)) {
                        ServiceManager.logger2.trace(32).append("Entered Sports Live broadcast list view ").log();
                    }
                    TLinkServiceManager.getServiceManager().getSports().prepareAndUpdateRadioText(true);
                    break;
                }
                case 32: {
                    if (ServiceManager.logger2.isTraceEnabled(32)) {
                        ServiceManager.logger2.trace(32).append("Entered Favorite Head to Head Game list view ").log();
                    }
                    TLinkServiceManager.getServiceManager().getDsiTravelLinkSportsAdapter().requestFavoriteTeams();
                    if (this.lastViewId == 0) break;
                    TLinkServiceManager.getServiceManager().getSports().requestAndUpdateGameListWithAllGameType();
                    break;
                }
                case 33: {
                    if (ServiceManager.logger2.isTraceEnabled(32)) {
                        ServiceManager.logger2.trace(32).append("Entered head to head game list view ").log();
                    }
                    TLinkServiceManager.getServiceManager().getSports().requestAndUpdateGameListWithAllGameType();
                    break;
                }
                case 45: {
                    if (ServiceManager.logger2.isTraceEnabled(32)) {
                        ServiceManager.logger2.trace(32).append("Entered ranked list view ").log();
                    }
                    TLinkServiceManager.getServiceManager().getSports().updateRankedListEventListHeadline();
                    if (this.lastViewId != 14) break;
                    TLinkServiceManager.getServiceManager().getSports().requestAndUpdateGameListWithAllGameType();
                    break;
                }
                case 46: {
                    if (ServiceManager.logger2.isTraceEnabled(32)) {
                        ServiceManager.logger2.trace(32).append("Entered ranked list no events view ").log();
                    }
                    TLinkServiceManager.getServiceManager().getSports().updateRankedListEventListHeadline();
                    if (this.lastViewId != 14) break;
                    TLinkServiceManager.getServiceManager().getSports().requestAndUpdateGameListWithAllGameType();
                    break;
                }
                case 47: {
                    if (ServiceManager.logger2.isTraceEnabled(32)) {
                        ServiceManager.logger2.trace(32).append("Entered ranked list out of season view ").log();
                    }
                    TLinkServiceManager.getServiceManager().getSports().updateRankedListEventListHeadline();
                    if (this.lastViewId != 14) break;
                    TLinkServiceManager.getServiceManager().getSports().requestAndUpdateGameListWithAllGameType();
                    break;
                }
                case 34: {
                    break;
                }
                case 17: {
                    if (ServiceManager.logger2.isTraceEnabled(64)) {
                        ServiceManager.logger2.trace(64).append("Entered Weather maps. Trying to lock the view.").log();
                    }
                    TLinkServiceManager.getServiceManager().getWeatherGraphical().setViewEnteredWeatherMapsActions();
                    break;
                }
                case 18: {
                    TLinkServiceManager.getServiceManager().getApiNavigation().lockMapViewer();
                    if (!ServiceManager.logger2.isTraceEnabled(64)) break;
                    ServiceManager.logger2.trace(64).append("Entered Weather Info Map view. Map lock called").log();
                    break;
                }
                case 21: {
                    TLinkServiceManager.getServiceManager().getApiNavigation().lockMapViewer();
                    if (!ServiceManager.logger2.isTraceEnabled(32)) break;
                    ServiceManager.logger2.trace(32).append("Entered Storm Info view.  Map lock called ").log();
                    break;
                }
                case 29: {
                    break;
                }
                case 41: {
                    if (ServiceManager.logger2.isTraceEnabled(32)) {
                        ServiceManager.logger2.trace(32).append("Entered Sports ranked list event info ").log();
                    }
                    TLinkServiceManager.getServiceManager().getSports().requestRankingInfo();
                    break;
                }
                case 23: {
                    TLinkServiceManager.getServiceManager().getDsiTravelLinkWeatherAdapter().requestFavoriteCityList();
                    TLinkServiceManager.getServiceManager().getWeather().setSetupEntry(1);
                    break;
                }
                case 26: {
                    TLinkServiceManager.getServiceManager().getDsiTravelLinkSkiAdapter().requestFavoriteSkiResorts();
                    TLinkServiceManager.getServiceManager().getWeather().setSetupEntry(2);
                    if (!ServiceManager.logger2.isTraceEnabled(16)) break;
                    ServiceManager.logger2.trace(16).append("Entered favorite ski resort list ").log();
                    break;
                }
                case 28: {
                    if (ServiceManager.logger2.isTraceEnabled(32)) {
                        ServiceManager.logger2.trace(32).append("Entered Setup Sports Favorite team list view ").log();
                    }
                    TLinkServiceManager.getServiceManager().getDsiTravelLinkSportsAdapter().requestFavoriteTeams();
                    break;
                }
                case 27: {
                    if (!ServiceManager.logger2.isTraceEnabled(32)) break;
                    ServiceManager.logger2.trace(32).append("Entered Setup Sports list view  ").log();
                    break;
                }
                case 15: {
                    if (ServiceManager.logger2.isTraceEnabled(32)) {
                        ServiceManager.logger2.trace(32).append("Entered Sports News view ").log();
                    }
                    TLinkServiceManager.getServiceManager().getSports().requestSportsNews();
                    break;
                }
                case 42: {
                    if (!ServiceManager.logger2.isTraceEnabled(32)) break;
                    ServiceManager.logger2.trace(32).append("Entered Head to Head game details ").log();
                    break;
                }
                case 39: {
                    if (!ServiceManager.logger2.isTraceEnabled(32)) break;
                    ServiceManager.logger2.trace(32).append("Entered Sports ranked list event rankings view ").log();
                    break;
                }
                case 19: {
                    TLinkServiceManager.getServiceManager().getFreeSpeller().clear();
                    if (this.lastViewId == 2) {
                        GenericPropertyContainer genericPropertyContainer = TLinkServiceManager.getServiceManager().getFuel().getSelectedFuelStationWithDetails();
                        if (null != genericPropertyContainer) {
                            String string = GenericPropertyUtility.getString(-2019490048, 0, genericPropertyContainer);
                            TLinkServiceManager.getServiceManager().getFreeSpeller().addChar(string);
                            break;
                        }
                        TLinkServiceManager.getServiceManager().getFreeSpeller().clear();
                        break;
                    }
                    if (this.lastViewId != 7) break;
                    if (isMoviesContextActive) {
                        GenericPropertyContainer genericPropertyContainer = TLinkServiceManager.getServiceManager().getMovies().getSelectedMovieTheater();
                        this.setTheaterName(genericPropertyContainer);
                        break;
                    }
                    GenericPropertyContainer genericPropertyContainer = TLinkServiceManager.getServiceManager().getMovieTheaters().getSelectedTheaterForMovieTheaters();
                    this.setTheaterName(genericPropertyContainer);
                    break;
                }
                case 36: {
                    isMoviesContextActive = true;
                    TLinkServiceManager.getServiceManager().getFreeSpeller().clear();
                    break;
                }
                case 35: {
                    isMoviesContextActive = true;
                    TLinkServiceManager.getServiceManager().getDsiTravelLinkMoviesAdapter().requestAllMovies(TLinkServiceManager.getServiceManager().getFreeSpeller().getEnteredText());
                    TLinkServiceManager.getServiceManager().getFreeSpeller().clear();
                    isFreeSpellerText = false;
                    break;
                }
                case 6: {
                    isMoviesContextActive = false;
                    if (ServiceManager.logger2.isTraceEnabled(8)) {
                        ServiceManager.logger2.trace(8).append(" Entered view SET_VIEW_ENTERED__STATE__C6_MOVIETHEATERS_RESULTS").log();
                    }
                    if (this.lastViewId == 5 || this.lastViewId == 19) {
                        TLinkServiceManager.getServiceManager().getDsiTravelLinkMoviesAdapter().requestMovieTheaters(-1, TLinkServiceManager.getServiceManager().getTravelLinkPersistable().getMovieTheatersSearchArea(), TLinkServiceManager.getServiceManager().getFreeSpeller().getEnteredText(), 35);
                    }
                    TLinkServiceManager.getServiceManager().getFreeSpeller().clear();
                    isFreeSpellerText = false;
                    break;
                }
                case 37: {
                    if (ServiceManager.logger2.isTraceEnabled(8)) {
                        ServiceManager.logger2.trace(8).append("StateTopMain - Entered view SET_VIEW_ENTERED__STATE__C37_MOVIES_INFO").log();
                    }
                    TLinkServiceManager.getServiceManager().getMovies().updateSelectedMovie();
                    break;
                }
                case 4: {
                    if (ServiceManager.logger2.isTraceEnabled(8)) {
                        ServiceManager.logger2.trace(8).append("StateTopMain - Entered view SET_VIEW_ENTERED__STATE__C4_MOVIES_SELECTMOVIE_VIEW").log();
                    }
                    isMoviesContextActive = true;
                    TLinkServiceManager.getServiceManager().getFreeSpeller().clear();
                    TLinkServiceManager.getServiceManager().getMovies().updateSelectedMovieTheater();
                    TLinkServiceManager.getServiceManager().getMovies().updateSelectedMovie();
                    break;
                }
                case 5: {
                    if (ServiceManager.logger2.isTraceEnabled(8)) {
                        ServiceManager.logger2.trace(8).append("StateTopMain - Entered view SET_VIEW_ENTERED__STATE__C5_MOVIETHEATERS").log();
                    }
                    isMoviesContextActive = false;
                    TLinkServiceManager.getServiceManager().getMovieTheaters().updateSelectedMovieTheater();
                    TLinkServiceManager.getServiceManager().getGuiControllerMovieTheaters().prepareAndUpdateSelectedMovieDetails(null);
                    TLinkServiceManager.getServiceManager().getGuiControllerMovieTheaters().updateNavigationAddressWithSelectedSearchArea();
                    break;
                }
                case 7: {
                    TLinkServiceManager.getServiceManager().getApiNavigation().lockMapViewer();
                    if (ServiceManager.logger2.isTraceEnabled(8)) {
                        ServiceManager.logger2.trace(8).append("StateTopMain - Entered view SET_VIEW_ENTERED__STATE__C7_MOVIETHEATERS_RESULTS_SHOWTIMES_DETAILS").log();
                    }
                    if (this.lastViewId != 19 || !isFreeSpellerText) break;
                    isFreeSpellerText = false;
                    if (isMoviesContextActive) {
                        TLinkServiceManager.getServiceManager().getMovies().storeContact();
                        break;
                    }
                    TLinkServiceManager.getServiceManager().getMovieTheaters().storeContact();
                    break;
                }
                case 38: {
                    if (ServiceManager.logger2.isTraceEnabled(8)) {
                        ServiceManager.logger2.trace(8).append("StateTopMain - Entered view SET_VIEW_ENTERED__STATE__C38_MOVIES_RESULTS").log();
                    }
                    isMoviesContextActive = true;
                    if (this.lastViewId == 36 || this.lastViewId == 19) {
                        TLinkServiceManager.getServiceManager().getMovies().requestMovieTheatersForOneMovie(31);
                    }
                    TLinkServiceManager.getServiceManager().getFreeSpeller().clear();
                    isFreeSpellerText = false;
                    break;
                }
                case 30: {
                    TLinkServiceManager.getServiceManager().getDsiTravelLinkWeatherAdapter().requestFavoriteCityList();
                    TLinkServiceManager.getServiceManager().getWeather().setSetupEntry(1);
                    break;
                }
                case 8: {
                    TLinkServiceManager.getServiceManager().getDsiTravelLinkWeatherAdapter().requestStateList();
                    break;
                }
                case 44: {
                    TLinkServiceManager.getServiceManager().getDsiTravelLinkSkiAdapter().requestStateList();
                    break;
                }
            }
            this.lastViewId = n;
        }
        catch (Exception exception) {
            if (ServiceManager.logger2.isTraceEnabled(2)) {
                ServiceManager.logger2.trace(2).append("Exception on processing view entered event").attachThrowable(exception);
            }
            ServiceManager.errorHandler.handleError(exception);
        }
    }

    private void setTheaterName(GenericPropertyContainer genericPropertyContainer) {
        if (null != genericPropertyContainer) {
            String string = GenericPropertyUtility.getString(126288128, 0, genericPropertyContainer);
            TLinkServiceManager.getServiceManager().getFreeSpeller().addChar(string);
        } else {
            TLinkServiceManager.getServiceManager().getFreeSpeller().clear();
        }
    }

    private void processEventSetViewLeft(EventGeneric eventGeneric) {
        try {
            int n = eventGeneric.getInt(0);
            if (ServiceManager.logger2.isTraceEnabled(2)) {
                ServiceManager.logger2.trace(2).append("Left view: ").append(n).log();
            }
            switch (n) {
                case 0: {
                    if (ServiceManager.logger2.isTraceEnabled(64)) {
                        ServiceManager.logger2.trace(64).append("Exit Main view ").log();
                    }
                    TLinkServiceManager.getServiceManager().getTraffic().setMapLockedRequested(false);
                    TLinkServiceManager.getServiceManager().getTargetMain().stopTimer(-1434058496);
                    TLinkServiceManager.getServiceManager().getTargetMain().stopTimer(-1417281280);
                    TLinkServiceManager.getServiceManager().getTraffic().unlockMapViewer();
                    TLinkServiceManager.getServiceManager().getDsiTravelLinkMainAdapter().requestStopUpdatesForMainView();
                    break;
                }
                case 17: {
                    TLinkServiceManager.getServiceManager().getApiNavigation().unlockMapViewer();
                    TLinkServiceManager.getServiceManager().getApiNavigation().setMapLockedRequested(false);
                    break;
                }
                case 2: {
                    TLinkServiceManager.getServiceManager().getApiNavigation().unlockMapViewer();
                    TLinkServiceManager.getServiceManager().getRequestQueue().setRequestIsBlocked(30, false);
                    TLinkServiceManager.getServiceManager().getRequestQueue().deleteRequestToAppParameter(30);
                    break;
                }
                case 7: {
                    TLinkServiceManager.getServiceManager().getApiNavigation().unlockMapViewer();
                    break;
                }
                case 23: {
                    TLinkServiceManager.getServiceManager().getWeather().setNearestWeatherStationPopupShown(false);
                    break;
                }
                case 12: {
                    TLinkServiceManager.getServiceManager().getSki().setNearestSkiResortPopupShown(false);
                    break;
                }
                case 13: {
                    TLinkServiceManager.getServiceManager().getDsiTravelLinkMainAdapter().requestStopUpdatesForSkiView();
                    break;
                }
                case 15: {
                    TLinkServiceManager.getServiceManager().getDsiTravelLinkSportsAdapter().requestStopUpdatesForSportsNews();
                    break;
                }
                case 31: {
                    TLinkServiceManager.getServiceManager().getSports().prepareAndUpdateRadioText(false);
                    break;
                }
                case 32: {
                    TLinkServiceManager.getServiceManager().getDsiTravelLinkSportsAdapter().requestStopUpdatesForHeadToHeadGameList();
                    break;
                }
                case 33: {
                    TLinkServiceManager.getServiceManager().getDsiTravelLinkSportsAdapter().requestStopUpdatesForHeadToHeadGameList();
                    break;
                }
                case 34: {
                    break;
                }
                case 39: {
                    TLinkServiceManager.getServiceManager().getSports().clearSportsRankedListsEventsRankingHeadline();
                    TLinkServiceManager.getServiceManager().getDsiTravelLinkSportsAdapter().requestStopUpdatesForRankedListEventRankings();
                    break;
                }
                case 40: {
                    TLinkServiceManager.getServiceManager().getSports().clearSportsRankedListsEventsRankingHeadline();
                    TLinkServiceManager.getServiceManager().getDsiTravelLinkSportsAdapter().requestStopUpdatesForRankedListEventRankingsFinal();
                    break;
                }
                case 41: {
                    TLinkServiceManager.getServiceManager().getSports().clearSportsRankedListsEventsRankingHeadline();
                    TLinkServiceManager.getServiceManager().getDsiTravelLinkSportsAdapter().requestStopUpdatesForRankedListEventInfo();
                    break;
                }
                case 45: {
                    TLinkServiceManager.getServiceManager().getSports().clearRankedListEventListHeadline();
                    break;
                }
                case 46: {
                    TLinkServiceManager.getServiceManager().getSports().clearRankedListEventListHeadline();
                    break;
                }
                case 47: {
                    TLinkServiceManager.getServiceManager().getSports().clearRankedListEventListHeadline();
                    break;
                }
                case 18: {
                    TLinkServiceManager.getServiceManager().getApiNavigation().unlockMapViewer();
                    if (!ServiceManager.logger2.isTraceEnabled(64)) break;
                    ServiceManager.logger2.trace(64).append("Entered Weather station or Ski resort details view. Map unlock called").log();
                    break;
                }
                case 21: {
                    TLinkServiceManager.getServiceManager().getApiNavigation().unlockMapViewer();
                    if (!ServiceManager.logger2.isTraceEnabled(64)) break;
                    ServiceManager.logger2.trace(64).append("Entered Storm details view. Map unlock called").log();
                    break;
                }
            }
            this.lastViewId = n;
        }
        catch (Exception exception) {
            if (ServiceManager.logger2.isTraceEnabled(2)) {
                ServiceManager.logger2.trace(2).append("Exception on processing view entered event").attachThrowable(exception);
            }
            ServiceManager.errorHandler.handleError(exception);
        }
    }

    public void dsiTravelLinkCommonUpdateFromApp(int n, GenericPropertyContainer[] genericPropertyContainerArray, int n2, int n3, int n4) {
        try {
            int n5;
            if (ServiceManager.logger2.isTraceEnabled(2)) {
                n5 = 0;
                if (null != genericPropertyContainerArray) {
                    n5 = genericPropertyContainerArray.length;
                }
                ServiceManager.logger2.info(2).append(new StringBuffer().append("StateTopMain: dsiTravelLinkCommonUpdateFromApp() requestType = ").append(TLinkServiceManager.getServiceManager().getTravelLinkTrace().getRequestTypeAsString(n)).append(" ,  sessionId = ").toString()).append(n3).append(" , status = ").append(n2).append(" , properties.length = ").append(n5).append(" , properties info is given below").log();
                GenericPropertyTraces.printData(genericPropertyContainerArray);
            }
            if (!TLinkServiceManager.getServiceManager().getSessionManager().isSessionIdValid(n, n3)) {
                if (ServiceManager.logger2.isTraceEnabled(2)) {
                    ServiceManager.logger2.error(2).append("StateTopMain : dsiTravelLinkCommonUpdateFromApp : Session ID does not match to the request type!").log();
                }
                return;
            }
            n5 = n3 / 100;
            TLinkServiceManager.getServiceManager().getRequestQueue().stopTimer(n5);
            if (n4 == 1 && genericPropertyContainerArray != null && n >= 0 && n < 60) {
                int n6 = TLinkServiceManager.getServiceManager().getSessionManager().getCurrentSessionIdForRequest(n5);
                if (n6 != n3) {
                    if (ServiceManager.logger2.isTraceEnabled(2)) {
                        ServiceManager.logger2.error(2).append("StateTopMain : dsiTravelLinkCommonUpdateFromApp: currentHmiSessionId != sessionId - ").append(n6).append(" != ").append(n3).log();
                    }
                    return;
                }
                if (n5 < 0 || n5 >= 60) {
                    if (ServiceManager.logger2.isTraceEnabled(2)) {
                        ServiceManager.logger2.error(2).append("StateTopMain : dsiTravelLinkCommonUpdateFromApp: subRequestType = ").append(n5).log();
                    }
                    return;
                }
                genericPropertyContainerArray = GenericPropertyUtility.checkAndCreateGPC(genericPropertyContainerArray, n5);
                switch (n5) {
                    case 18: 
                    case 19: 
                    case 20: 
                    case 21: 
                    case 22: 
                    case 43: 
                    case 44: {
                        TLinkServiceManager.getServiceManager().getWeather().processAndUpdate(n5, genericPropertyContainerArray, n2, n3);
                        break;
                    }
                    case 39: {
                        TLinkServiceManager.getServiceManager().getWeatherGraphical().processAndUpdate(n5, genericPropertyContainerArray, n2, n3);
                        break;
                    }
                    case 0: 
                    case 1: 
                    case 58: {
                        TLinkServiceManager.getServiceManager().getMain().processAndUpdate(n5, genericPropertyContainerArray, n2, n3);
                        break;
                    }
                    case 24: 
                    case 25: 
                    case 26: 
                    case 27: 
                    case 28: 
                    case 47: 
                    case 48: {
                        TLinkServiceManager.getServiceManager().getSki().processAndUpdate(n5, genericPropertyContainerArray, n2, n3);
                        break;
                    }
                    case 5: 
                    case 6: 
                    case 7: 
                    case 8: 
                    case 11: 
                    case 12: 
                    case 14: 
                    case 15: 
                    case 37: 
                    case 38: 
                    case 45: 
                    case 46: 
                    case 52: 
                    case 53: {
                        TLinkServiceManager.getServiceManager().getSports().processAndUpdate(n5, genericPropertyContainerArray, n2, n3);
                        break;
                    }
                    case 29: 
                    case 30: 
                    case 49: 
                    case 51: 
                    case 56: {
                        TLinkServiceManager.getServiceManager().getFuel().processAndUpdate(n5, genericPropertyContainerArray, n2, n3);
                        break;
                    }
                    case 31: 
                    case 32: 
                    case 33: 
                    case 35: 
                    case 36: 
                    case 50: 
                    case 54: 
                    case 55: {
                        TLinkServiceManager.getServiceManager().getMovies().processAndUpdate(n5, genericPropertyContainerArray, n2, n3);
                        break;
                    }
                    default: {
                        if (ServiceManager.logger2.isTraceEnabled(2)) {
                            ServiceManager.logger2.trace(2).append(new StringBuffer().append("updateFromApp : Unhandled request. Check whether the request type ---> ").append(n5).append(" has to be implemented ? ").toString()).log();
                            break;
                        } else {
                            break;
                        }
                    }
                }
            } else {
                if (n4 != 1 && ServiceManager.logger2.isTraceEnabled(2)) {
                    ServiceManager.logger2.trace(2).append("StateTopMain : dsiTravelLinkCommonUpdateFromApp: Valid flag from the application = ").append(n4).log();
                }
                if (genericPropertyContainerArray == null && ServiceManager.logger2.isTraceEnabled(2)) {
                    ServiceManager.logger2.error(2).append("StateTopMain : dsiTravelLinkCommonUpdateFromApp : GenericPropertyContainer array from the application is null").log();
                }
                if ((n < 0 || n >= 60) && ServiceManager.logger2.isTraceEnabled(2)) {
                    ServiceManager.logger2.error(2).append("StateTopMain : dsiTravelLinkCommonUpdateFromApp : Error requestType --> ").append(n).log();
                }
            }
            TLinkServiceManager.getServiceManager().getRequestQueue().startPendingRequests(n5);
        }
        catch (Exception exception) {
            ServiceManager.errorHandler.handleError(exception);
        }
    }

    public boolean checkValidData(int n, GenericPropertyContainer[] genericPropertyContainerArray) {
        return false;
    }

    private void initGui() {
        TLinkServiceManager tLinkServiceManager = TLinkServiceManager.getServiceManager();
        TravelLinkPersistable travelLinkPersistable = tLinkServiceManager.getTravelLinkPersistable();
        TLinkServiceManager.getServiceManager().getGuiControllerMovies().prepareAndUpdateMovieTheaterShowTimes(new GenericPropertyContainer[0]);
        TLinkServiceManager.getServiceManager().getGuiControllerSports().updateFavoriteGamesForMainViewCollector(null);
        TLinkServiceManager.getServiceManager().getGuiControllerMovies().updateSelectedMovieTheater(null);
        TLinkServiceManager.getServiceManager().getGuiControllerFuel().prepareAndUpdateFuelStationAddress(null);
        TLinkServiceManager.getServiceManager().getGuiControllerFuel().prepareAndUpdateFuelClosestStation(null, true);
        TLinkServiceManager.getServiceManager().getGuiControllerFuel().prepareAndUpdateFuelTypeList(null);
        TLinkServiceManager.getServiceManager().getGuiControllerWeather().updateWeatherForecast(null);
        int n = travelLinkPersistable.getFuelStationListSortOrder();
        tLinkServiceManager.getGuiControllerFuel().setFuelStationListSortOrder(n);
        n = travelLinkPersistable.getFuelStationSearchArea();
        tLinkServiceManager.getGuiControllerFuel().setFuelStationSearchArea(n);
        n = travelLinkPersistable.getWeatherTabularViewSelection();
        tLinkServiceManager.getGuiControllerWeather().updateSelectedWeatherTab(n);
        n = travelLinkPersistable.getListSortOrderForMoviesResult();
        tLinkServiceManager.getGuiControllerMovies().setListSortOrderForMoviesResult(n);
        n = travelLinkPersistable.getListSortOrderForMovieTheaterShowTimes();
        tLinkServiceManager.getGuiControllerMovies().setMovieTheaterShowTimesListSortOrder(n);
        n = travelLinkPersistable.getListSortOrderForMovieTheaterResult();
        tLinkServiceManager.getGuiControllerMovieTheaters().setMovieTheatersResultListSortOrder(n);
        n = travelLinkPersistable.getMovieTheatersSearchArea();
        tLinkServiceManager.getGuiControllerMovies().setMovieTheatersSearchArea(n);
        n = travelLinkPersistable.getMoviesSearchArea();
        tLinkServiceManager.getGuiControllerMovies().setMoviesSearchArea(n);
        n = travelLinkPersistable.getSelectedWeatherMap();
        tLinkServiceManager.getGuiControllerWeatherGraphical().setSelectedWeatherMap(n);
        tLinkServiceManager.getWeatherGraphical().setSelectedWeatherMap(n);
        n = travelLinkPersistable.getListTimeframeForHeadToHeadGames();
        tLinkServiceManager.getGuiControllerSports().setTimeFrame(n);
        n = travelLinkPersistable.getSportsSelectedChangeLeagueType();
        tLinkServiceManager.getGuiControllerSports().updateSelectedLeagueType(n);
        n = travelLinkPersistable.getSportsSelectedChangeLeagueSportsId();
        String string = travelLinkPersistable.getSportsSelectedChangeLeagueName();
        tLinkServiceManager.getGuiControllerSports().updateSportsHeadline(n, string);
        int n2 = TLinkServiceManager.getServiceManager().getSports().getOldDsiSportId(n);
        TLinkServiceManager.getServiceManager().getGuiControllerSports().updateSelectedLeaguesWithDsiSportsId(n2);
        int n3 = TLinkServiceManager.getServiceManager().getTravelLinkPersistable().getMainViewVisibleWidgetInAreaOne();
        TLinkServiceManager.getServiceManager().getGuiControllerMain().updateVisibleMainViewWidgetInAreaOne(n3);
        int n4 = TLinkServiceManager.getServiceManager().getTravelLinkPersistable().getMainViewVisibleWidgetInAreaTwo();
        TLinkServiceManager.getServiceManager().getGuiControllerMain().updateVisibleMainViewWidgetInAreaTwo(n4);
        TLinkServiceManager.getServiceManager().getWeatherGraphical().setCcpButtonEnabled(false);
        ServiceManager.aslPropertyManager.valueChangedInteger(-499178752, 1);
    }

    private void processEventMapZoomListUpdate(EventGeneric eventGeneric) {
        try {
            if (ServiceManager.logger2.isTraceEnabled(64)) {
                int[] nArray;
                ServiceManager.logger2.trace(64).append("StateTopMain - EVENT_MAP_ZOOM_LIST_UPDATE - Zoom list available.").log();
                Object object = eventGeneric.getObject(0);
                if (null != object && null != (nArray = (int[])object)) {
                    for (int i2 = 0; i2 < nArray.length; ++i2) {
                        ServiceManager.logger2.trace(64).append("Zoom level ").append(i2).append(" from update list = ").append(nArray[i2]).log();
                    }
                }
            }
        }
        catch (Exception exception) {
            ServiceManager.errorHandler.handleError(exception);
        }
    }

    void resetTravelLinkToFactorySettings() {
        if (ServiceManager.logger2.isTraceEnabled(2)) {
            ServiceManager.logger2.trace(2).append("Factory reset request from FW").log();
        }
        TLinkServiceManager.getServiceManager().getMain().resetVisibleMainViewWidget();
        TLinkServiceManager.getServiceManager().getDsiTravelLinkMainAdapter().requestResetFactorySettings();
        TLinkServiceManager.getServiceManager().getSports().setSetupSportsNumberOfFavoriteTeams(0);
        ServiceManager.aslPropertyManager.valueChangedBoolean(-683728128, true);
        TLinkServiceManager.getServiceManager().getWeatherGraphical().setSelectedGraphicalWeatherMap(0);
        TLinkServiceManager.getServiceManager().getSki().setSkiStationId(-1L);
        TLinkServiceManager.getServiceManager().getWeather().setSelectedWeatherStationId(-1L);
    }
}

