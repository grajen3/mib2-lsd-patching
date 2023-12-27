/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.travellink;

import de.vw.mib.asl.api.navigation.ASLNavigationFactory;
import de.vw.mib.asl.api.navigation.ASLNavigationServices;
import de.vw.mib.asl.api.navigation.map.ASLNavigationMapConfiguration;
import de.vw.mib.asl.api.navigation.map.ASLNavigationServiceMainMap;
import de.vw.mib.asl.api.system.UnitChangeListener;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.travellink.ASLNavigationServicesListener;
import de.vw.mib.asl.internal.travellink.ApiNavigation;
import de.vw.mib.asl.internal.travellink.DataPool;
import de.vw.mib.asl.internal.travellink.RequestQueue;
import de.vw.mib.asl.internal.travellink.TravelLinkDateUtility;
import de.vw.mib.asl.internal.travellink.TravelLinkPersistable;
import de.vw.mib.asl.internal.travellink.TravelLinkSessionManager;
import de.vw.mib.asl.internal.travellink.TravelLinkTrace;
import de.vw.mib.asl.internal.travellink.TravelLinkUtil;
import de.vw.mib.asl.internal.travellink.UnitChangeListenerImpl;
import de.vw.mib.asl.internal.travellink.comparator.ComparatorFuelList;
import de.vw.mib.asl.internal.travellink.comparator.ComparatorMovieShowTimes;
import de.vw.mib.asl.internal.travellink.comparator.ComparatorMovieTheaterForOneMovie;
import de.vw.mib.asl.internal.travellink.comparator.ComparatorMovieTheatersList;
import de.vw.mib.asl.internal.travellink.comparator.ComparatorMovies;
import de.vw.mib.asl.internal.travellink.comparator.ComparatorSportsGamesFinishedTime;
import de.vw.mib.asl.internal.travellink.comparator.ComparatorSportsGamesStartingTime;
import de.vw.mib.asl.internal.travellink.comparator.ComparatorSportsGamesStatus;
import de.vw.mib.asl.internal.travellink.comparator.ComparatorString;
import de.vw.mib.asl.internal.travellink.dsi.DsiProxy;
import de.vw.mib.asl.internal.travellink.fuel.DSITravelLinkFuelAdapter;
import de.vw.mib.asl.internal.travellink.fuel.Fuel;
import de.vw.mib.asl.internal.travellink.fuel.FuelDetailsNavigator;
import de.vw.mib.asl.internal.travellink.fuel.GuiControllerFuel;
import de.vw.mib.asl.internal.travellink.fuel.TargetFuel;
import de.vw.mib.asl.internal.travellink.fuel.TravelLinkFreeSpeller;
import de.vw.mib.asl.internal.travellink.main.DSITravelLinkMainAdapter;
import de.vw.mib.asl.internal.travellink.main.GuiControllerMain;
import de.vw.mib.asl.internal.travellink.main.Main;
import de.vw.mib.asl.internal.travellink.main.TargetMain;
import de.vw.mib.asl.internal.travellink.movies.DSITravelLinkMoviesAdapter;
import de.vw.mib.asl.internal.travellink.movies.GuiControllerMovieTheaters;
import de.vw.mib.asl.internal.travellink.movies.GuiControllerMovies;
import de.vw.mib.asl.internal.travellink.movies.MovieTheaterDetailsNavigator;
import de.vw.mib.asl.internal.travellink.movies.MovieTheaters;
import de.vw.mib.asl.internal.travellink.movies.Movies;
import de.vw.mib.asl.internal.travellink.movies.MoviesDetailsNavigator;
import de.vw.mib.asl.internal.travellink.movies.TargetMovies;
import de.vw.mib.asl.internal.travellink.ski.DSITravelLinkSkiAdapter;
import de.vw.mib.asl.internal.travellink.ski.GuiControllerSki;
import de.vw.mib.asl.internal.travellink.ski.Ski;
import de.vw.mib.asl.internal.travellink.ski.TargetSki;
import de.vw.mib.asl.internal.travellink.sports.DSITravelLinkSportsAdapter;
import de.vw.mib.asl.internal.travellink.sports.GuiControllerSports;
import de.vw.mib.asl.internal.travellink.sports.Sports;
import de.vw.mib.asl.internal.travellink.sports.TargetSports;
import de.vw.mib.asl.internal.travellink.traffic.DSITravelLinkTrafficAdapter;
import de.vw.mib.asl.internal.travellink.traffic.GuiControllerTraffic;
import de.vw.mib.asl.internal.travellink.traffic.TargetTraffic;
import de.vw.mib.asl.internal.travellink.traffic.Traffic;
import de.vw.mib.asl.internal.travellink.weather.DSITravelLinkWeatherAdapter;
import de.vw.mib.asl.internal.travellink.weather.GuiControllerWeather;
import de.vw.mib.asl.internal.travellink.weather.TargetWeather;
import de.vw.mib.asl.internal.travellink.weather.Weather;
import de.vw.mib.asl.internal.travellink.weatherGraphical.DSITravelLinkWeatherGraphicalAdapter;
import de.vw.mib.asl.internal.travellink.weatherGraphical.GuiControllerWeatherGraphical;
import de.vw.mib.asl.internal.travellink.weatherGraphical.WeatherGraphical;
import de.vw.mib.genericevents.GenericEvents;
import de.vw.mib.genericevents.hsm.HsmState;
import org.dsi.ifc.travellink.DSITravelLinkCommon;

public final class TLinkServiceManager {
    private static TLinkServiceManager serviceManager = null;
    public static GenericEvents genericEvents;
    public static String taskId;
    private final DataPool datapool;
    private DSITravelLinkCommon dsiTravelLinkCommon;
    private ASLNavigationServiceMainMap navigationServiceMainMap = null;
    private ASLNavigationServices aslNavigationServices = null;
    public static final int STATE_NOT_SET;
    private static int sdarsTunnerState;
    private static int audioSubscriptionState;
    private int currentViewId = 0;
    private HsmState stateTopMain;
    private static boolean isTravelLinkReady;
    private final GuiControllerMain guiControllerMain = new GuiControllerMain();
    private final GuiControllerFuel guiControllerFuel = new GuiControllerFuel();
    private final GuiControllerMovies guiControllerMovies = new GuiControllerMovies();
    private final GuiControllerMovieTheaters guiControllerMovieTheaters = new GuiControllerMovieTheaters();
    private final GuiControllerWeather guiControllerWeather = new GuiControllerWeather();
    private final GuiControllerWeatherGraphical guiControllerWeatherGraphical = new GuiControllerWeatherGraphical();
    private final GuiControllerSki guiControllerSki = new GuiControllerSki();
    private final GuiControllerSports guiControllerSports = new GuiControllerSports();
    private final GuiControllerTraffic guiControllerTraffic = new GuiControllerTraffic();
    private final TargetFuel targetFuel;
    private final TargetMovies targetMovies;
    private final TargetSki targetSki;
    private final TargetSports targetSports;
    private final TargetTraffic targetTraffic;
    private final TargetWeather targetWeather;
    private TargetMain targetMain;
    private final DSITravelLinkMainAdapter dsiTravelLinkMainAdapter = new DSITravelLinkMainAdapter();
    private final DSITravelLinkFuelAdapter dsiTravelLinkFuelAdapter = new DSITravelLinkFuelAdapter();
    private final DSITravelLinkMoviesAdapter dsiTravelLinkMoviesAdapter = new DSITravelLinkMoviesAdapter();
    private final DSITravelLinkSkiAdapter dsiTravelLinkSkiAdapter = new DSITravelLinkSkiAdapter();
    private final DSITravelLinkSportsAdapter dsiTravelLinkSportsAdapter = new DSITravelLinkSportsAdapter();
    private final DSITravelLinkTrafficAdapter dsiTravelLinkTrafficAdapter = new DSITravelLinkTrafficAdapter();
    private final DSITravelLinkWeatherAdapter dsiTravelLinkWeatherAdapter = new DSITravelLinkWeatherAdapter();
    private final DSITravelLinkWeatherGraphicalAdapter dsiTravelLinkWeatherGraphicalAdapter = new DSITravelLinkWeatherGraphicalAdapter();
    private final Main main = new Main();
    private final Movies movies = new Movies();
    private final MovieTheaters movieTheaters = new MovieTheaters();
    private final Fuel fuel = new Fuel();
    private final Ski ski = new Ski();
    private final Sports sports = new Sports();
    private final Traffic traffic = new Traffic();
    private final Weather weather = new Weather();
    private final WeatherGraphical weatherGraphical = new WeatherGraphical();
    private final TravelLinkPersistable travelLinkPersistable;
    private final TravelLinkSessionManager travelLinkSessionManager;
    private final RequestQueue requestQueue;
    private final TravelLinkFreeSpeller freeSpeller;
    private final DsiProxy dsiProxy;
    private final TravelLinkDateUtility travelLinkDateUtility;
    private final FuelDetailsNavigator fuelDetailsNavigator;
    private final MovieTheaterDetailsNavigator movieTheaterDetailsNavigator;
    private final MoviesDetailsNavigator moviesDetailsNavigator;
    private final ApiNavigation apiNavigation;
    private final ASLNavigationMapConfiguration aslNavigationMapConfigurationFullView;
    private final ASLNavigationMapConfiguration aslNavigationMapConfigurationSplitView;
    private final ASLNavigationMapConfiguration aslNavigationMapConfigurationTrafficMap;
    private final ASLNavigationMapConfiguration aslNavigationMapConfigurationWeatherMapSplitView;
    private final TravelLinkTrace travelLinkTrace;
    private final TravelLinkUtil travelLinkUtil;
    private final UnitChangeListener unitChangeListener;
    private final ASLNavigationServicesListener aslNavServiceListener;

    private TLinkServiceManager() {
        this.targetFuel = new TargetFuel(genericEvents);
        this.targetMovies = new TargetMovies(genericEvents);
        this.targetSki = new TargetSki(genericEvents);
        this.targetSports = new TargetSports(genericEvents);
        this.targetTraffic = new TargetTraffic(genericEvents);
        this.targetWeather = new TargetWeather(genericEvents);
        this.travelLinkSessionManager = new TravelLinkSessionManager();
        this.requestQueue = new RequestQueue();
        this.freeSpeller = new TravelLinkFreeSpeller();
        this.dsiProxy = new DsiProxy();
        this.datapool = new DataPool();
        this.travelLinkPersistable = new TravelLinkPersistable();
        this.travelLinkDateUtility = new TravelLinkDateUtility();
        this.fuelDetailsNavigator = new FuelDetailsNavigator();
        this.movieTheaterDetailsNavigator = new MovieTheaterDetailsNavigator();
        this.moviesDetailsNavigator = new MoviesDetailsNavigator();
        this.apiNavigation = new ApiNavigation();
        this.aslNavigationMapConfigurationFullView = new ASLNavigationMapConfiguration();
        this.aslNavigationMapConfigurationSplitView = new ASLNavigationMapConfiguration();
        int n = 200;
        this.aslNavigationMapConfigurationSplitView.setMapMode(2);
        this.aslNavigationMapConfigurationSplitView.setZoomLevel(200);
        this.aslNavigationMapConfigurationSplitView.setOrientation(2);
        this.aslNavigationMapConfigurationSplitView.setViewType(0);
        this.aslNavigationMapConfigurationSplitView.setFlagStyleType(25);
        this.aslNavigationMapConfigurationSplitView.setPerspective(-1);
        this.aslNavigationMapConfigurationSplitView.setCarPosition(null);
        this.aslNavigationMapConfigurationWeatherMapSplitView = new ASLNavigationMapConfiguration();
        this.aslNavigationMapConfigurationWeatherMapSplitView.setMapMode(2);
        this.aslNavigationMapConfigurationWeatherMapSplitView.setZoomLevel(200);
        this.aslNavigationMapConfigurationWeatherMapSplitView.setOrientation(2);
        this.aslNavigationMapConfigurationWeatherMapSplitView.setViewType(0);
        this.aslNavigationMapConfigurationWeatherMapSplitView.setFlagStyleType(29);
        this.aslNavigationMapConfigurationTrafficMap = new ASLNavigationMapConfiguration();
        this.travelLinkTrace = new TravelLinkTrace();
        this.travelLinkUtil = new TravelLinkUtil();
        this.unitChangeListener = new UnitChangeListenerImpl();
        this.aslNavServiceListener = new ASLNavigationServicesListener();
        this.startAndRegisterHsmTargets();
        isTravelLinkReady = false;
    }

    public static TLinkServiceManager getServiceManager() {
        if (serviceManager == null) {
            serviceManager = new TLinkServiceManager();
        }
        return serviceManager;
    }

    public void startAndRegisterHsmTargets() {
        try {
            this.targetFuel.startHsmAndRegisterTarget(genericEvents, genericEvents.getEventDispatcher().getNextTargetId(), taskId, this.targetFuel.getStateTopFuel());
            this.targetMovies.startHsmAndRegisterTarget(genericEvents, genericEvents.getEventDispatcher().getNextTargetId(), taskId, this.targetMovies.getStateTopMovies());
            this.targetSki.startHsmAndRegisterTarget(genericEvents, genericEvents.getEventDispatcher().getNextTargetId(), taskId, this.targetSki.getStateTopSki());
            this.targetSports.startHsmAndRegisterTarget(genericEvents, genericEvents.getEventDispatcher().getNextTargetId(), taskId, this.targetSports.getStateTopSports());
            this.targetTraffic.startHsmAndRegisterTarget(genericEvents, genericEvents.getEventDispatcher().getNextTargetId(), taskId, this.targetTraffic.getStateTopTraffic());
            this.targetWeather.startHsmAndRegisterTarget(genericEvents, genericEvents.getEventDispatcher().getNextTargetId(), taskId, this.targetWeather.getStateTopWeather());
        }
        catch (Exception exception) {
            if (ServiceManager.logger2.isTraceEnabled(2)) {
                ServiceManager.logger2.error(2, "COULD NOT START TRAVEL LINK TARGETS.", exception);
            }
            ServiceManager.errorHandler.handleError(exception);
        }
    }

    public DataPool getDatapool() {
        return this.datapool;
    }

    public GuiControllerMain getGuiControllerMain() {
        return this.guiControllerMain;
    }

    public GuiControllerFuel getGuiControllerFuel() {
        return this.guiControllerFuel;
    }

    public GuiControllerMovies getGuiControllerMovies() {
        return this.guiControllerMovies;
    }

    public GuiControllerMovieTheaters getGuiControllerMovieTheaters() {
        return this.guiControllerMovieTheaters;
    }

    public GuiControllerWeather getGuiControllerWeather() {
        return this.guiControllerWeather;
    }

    public GuiControllerWeatherGraphical getGuiControllerWeatherGraphical() {
        return this.guiControllerWeatherGraphical;
    }

    public GuiControllerSki getGuiControllerSki() {
        return this.guiControllerSki;
    }

    public GuiControllerSports getGuiControllerSports() {
        return this.guiControllerSports;
    }

    public GuiControllerTraffic getGuiControllerTraffic() {
        return this.guiControllerTraffic;
    }

    public DSITravelLinkCommon getDSITravelLinkCommon() {
        return this.dsiTravelLinkCommon;
    }

    public void setDSITravelLinkCommon(DSITravelLinkCommon dSITravelLinkCommon) {
        this.dsiTravelLinkCommon = dSITravelLinkCommon;
    }

    public DSITravelLinkMainAdapter getDsiTravelLinkMainAdapter() {
        return this.dsiTravelLinkMainAdapter;
    }

    public DSITravelLinkMoviesAdapter getDsiTravelLinkMoviesAdapter() {
        return this.dsiTravelLinkMoviesAdapter;
    }

    public DSITravelLinkSkiAdapter getDsiTravelLinkSkiAdapter() {
        return this.dsiTravelLinkSkiAdapter;
    }

    public DSITravelLinkSportsAdapter getDsiTravelLinkSportsAdapter() {
        return this.dsiTravelLinkSportsAdapter;
    }

    public DSITravelLinkTrafficAdapter getDsiTravelLinkTrafficAdapter() {
        return this.dsiTravelLinkTrafficAdapter;
    }

    public DSITravelLinkWeatherAdapter getDsiTravelLinkWeatherAdapter() {
        return this.dsiTravelLinkWeatherAdapter;
    }

    public DSITravelLinkWeatherGraphicalAdapter getDsiTravelLinkWeatherGraphicalAdapter() {
        return this.dsiTravelLinkWeatherGraphicalAdapter;
    }

    public DSITravelLinkFuelAdapter getDsiTravelLinkFuelAdapter() {
        return this.dsiTravelLinkFuelAdapter;
    }

    public TargetMain getTargetMain() {
        return this.targetMain;
    }

    public void setTargetMain(TargetMain targetMain) {
        this.targetMain = targetMain;
    }

    public TargetFuel getTargetFuel() {
        return this.targetFuel;
    }

    public TargetMovies getTargetMovies() {
        return this.targetMovies;
    }

    public TargetSki getTargetSki() {
        return this.targetSki;
    }

    public TargetSports getTargetSports() {
        return this.targetSports;
    }

    public TargetTraffic getTargetTraffic() {
        return this.targetTraffic;
    }

    public TargetWeather getTargetWeather() {
        return this.targetWeather;
    }

    public Main getMain() {
        return this.main;
    }

    public Movies getMovies() {
        return this.movies;
    }

    public MovieTheaters getMovieTheaters() {
        return this.movieTheaters;
    }

    public Fuel getFuel() {
        return this.fuel;
    }

    public Ski getSki() {
        return this.ski;
    }

    public Sports getSports() {
        return this.sports;
    }

    public Weather getWeather() {
        return this.weather;
    }

    public WeatherGraphical getWeatherGraphical() {
        return this.weatherGraphical;
    }

    public Traffic getTraffic() {
        return this.traffic;
    }

    public TravelLinkPersistable getTravelLinkPersistable() {
        return this.travelLinkPersistable;
    }

    public ComparatorFuelList getComparatorFuelList() {
        return ComparatorFuelList.getComparator();
    }

    public ComparatorMovieShowTimes getComparatorMovieShowTimes() {
        return ComparatorMovieShowTimes.getComparator();
    }

    public ComparatorMovieTheatersList getComparatorMovieTheatersResultsList() {
        return ComparatorMovieTheatersList.getComparator();
    }

    public ComparatorMovieTheaterForOneMovie getComparatorTheaterListForOneMovie() {
        return ComparatorMovieTheaterForOneMovie.getComparator();
    }

    public ComparatorMovies getComparatorMovies() {
        return ComparatorMovies.getComparator();
    }

    public ComparatorString getComparatorString(int n) {
        return ComparatorString.getComparator(n);
    }

    public ComparatorSportsGamesStatus getComparatorGamesStatus() {
        return ComparatorSportsGamesStatus.getComparator();
    }

    public ComparatorSportsGamesStartingTime getComparatorSportsGamesList() {
        return ComparatorSportsGamesStartingTime.getComparator();
    }

    public ComparatorSportsGamesFinishedTime getComparatorSportsFinishedGamesList() {
        return ComparatorSportsGamesFinishedTime.getComparator();
    }

    public TravelLinkSessionManager getSessionManager() {
        return this.travelLinkSessionManager;
    }

    public RequestQueue getRequestQueue() {
        return this.requestQueue;
    }

    public TravelLinkFreeSpeller getFreeSpeller() {
        return this.freeSpeller;
    }

    public DsiProxy getDsiProxy() {
        return this.dsiProxy;
    }

    public TravelLinkDateUtility getTravelLinkDateUtility() {
        return this.travelLinkDateUtility;
    }

    public ASLNavigationServiceMainMap getNavigationServiceMainMap() {
        return this.navigationServiceMainMap;
    }

    public void setNavigationServiceMainMap(ASLNavigationServiceMainMap aSLNavigationServiceMainMap) {
        this.navigationServiceMainMap = aSLNavigationServiceMainMap;
    }

    public FuelDetailsNavigator getFuelDetailsNavigator() {
        return this.fuelDetailsNavigator;
    }

    public MovieTheaterDetailsNavigator getMovieTheaterDetailsNavigator() {
        return this.movieTheaterDetailsNavigator;
    }

    public MoviesDetailsNavigator getMoviesDetailsNavigator() {
        return this.moviesDetailsNavigator;
    }

    public ApiNavigation getApiNavigation() {
        return this.apiNavigation;
    }

    public ASLNavigationMapConfiguration getAslNavigationMapConfigurationFullView() {
        return this.aslNavigationMapConfigurationFullView;
    }

    public ASLNavigationMapConfiguration getAslNavigationMapConfigurationSplitView() {
        return this.aslNavigationMapConfigurationSplitView;
    }

    public static void updateSdarsTunerState(int n) {
        sdarsTunnerState = n;
    }

    public static int getSdarsTunnerState() {
        return sdarsTunnerState;
    }

    public static void updateAudioSubscriptionState(int n) {
        audioSubscriptionState = n;
    }

    public static int getAudioSubscriptionState() {
        return audioSubscriptionState;
    }

    public TravelLinkTrace getTravelLinkTrace() {
        return this.travelLinkTrace;
    }

    public int getCurrentViewId() {
        return this.currentViewId;
    }

    public void setCurrentViewId(int n) {
        this.currentViewId = n;
    }

    public TravelLinkUtil getTravelLinkUtil() {
        return this.travelLinkUtil;
    }

    public ASLNavigationMapConfiguration getAslNavigationMapConfigurationTrafficMap() {
        return this.aslNavigationMapConfigurationTrafficMap;
    }

    public ASLNavigationMapConfiguration getAslNavigationMapConfigurationWeatherMapSplitView() {
        return this.aslNavigationMapConfigurationWeatherMapSplitView;
    }

    public UnitChangeListener getUnitChangeListener() {
        return this.unitChangeListener;
    }

    public ASLNavigationServices getAslNavigationServices() {
        if (null == this.aslNavigationServices) {
            this.aslNavigationServices = ASLNavigationFactory.getNavigationApi().getASLNavigationServices(this.aslNavServiceListener);
        }
        return this.aslNavigationServices;
    }

    public void setAslNavigationServices(ASLNavigationServices aSLNavigationServices) {
        this.aslNavigationServices = aSLNavigationServices;
    }

    public ASLNavigationServicesListener getASLNavigationServicesListener() {
        return this.aslNavServiceListener;
    }

    public void setStateTopMain(HsmState hsmState) {
        this.stateTopMain = hsmState;
    }

    public HsmState getStateTopMain() {
        return this.stateTopMain;
    }

    public static boolean isTravelLinkReady() {
        return isTravelLinkReady;
    }

    public static void setTravelLinkReady(boolean bl) {
        isTravelLinkReady = bl;
    }

    static {
        sdarsTunnerState = -1;
        audioSubscriptionState = -1;
        isTravelLinkReady = false;
    }
}

