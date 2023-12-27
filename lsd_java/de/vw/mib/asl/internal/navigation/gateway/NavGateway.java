/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.gateway;

import de.vw.mib.asl.api.navigation.util.ASLNavigationUtilFactory;
import de.vw.mib.asl.api.navigation.util.IExtLogger;
import de.vw.mib.asl.framework.api.dsiproxy.DSIServiceStateListener;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.framework.internal.framework.dsi.DSIInterceptor;
import de.vw.mib.asl.internal.navigation.caching.HsmCacheHandler;
import de.vw.mib.asl.internal.navigation.gateway.Command;
import de.vw.mib.asl.internal.navigation.gateway.DSINavInterceptor;
import de.vw.mib.asl.internal.navigation.gateway.INavGateway;
import de.vw.mib.asl.internal.navigation.gateway.command.NavGatewayListener;
import de.vw.mib.asl.internal.navigation.util.ExtLoggerHelper;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.GenericEvents;
import de.vw.mib.genericevents.Target;
import de.vw.mib.log4mib.LogMessage;
import java.util.LinkedList;
import org.dsi.ifc.global.NavLocation;
import org.dsi.ifc.global.NavLocationWgs84;
import org.dsi.ifc.global.NavRectangle;
import org.dsi.ifc.global.NavSegmentID;
import org.dsi.ifc.navigation.BapManeuverDescriptor;
import org.dsi.ifc.navigation.BapTurnToInfo;
import org.dsi.ifc.navigation.Brand;
import org.dsi.ifc.navigation.CalculatedRouteListElement;
import org.dsi.ifc.navigation.Category;
import org.dsi.ifc.navigation.CountryInfo;
import org.dsi.ifc.navigation.DSINavigation;
import org.dsi.ifc.navigation.DSINavigationListener;
import org.dsi.ifc.navigation.DirectionToWaypoint;
import org.dsi.ifc.navigation.DistanceToNextManeuver;
import org.dsi.ifc.navigation.LDListElement;
import org.dsi.ifc.navigation.LICityHistoryEntry;
import org.dsi.ifc.navigation.LISpellerData;
import org.dsi.ifc.navigation.LIStateHistoryEntry;
import org.dsi.ifc.navigation.LIStreetHistoryEntry;
import org.dsi.ifc.navigation.LIValueList;
import org.dsi.ifc.navigation.NavDataBase;
import org.dsi.ifc.navigation.NavLaneGuidanceData;
import org.dsi.ifc.navigation.NavNextWayPointInfo;
import org.dsi.ifc.navigation.NavPoiInfo;
import org.dsi.ifc.navigation.NavRmRouteListArrayData;
import org.dsi.ifc.navigation.NavRouteListData;
import org.dsi.ifc.navigation.NavTraceListData;
import org.dsi.ifc.navigation.NavTraceMemoryUtilization;
import org.dsi.ifc.navigation.NavVersionInfo;
import org.dsi.ifc.navigation.PoiExtendedInfo;
import org.dsi.ifc.navigation.PosPosition;
import org.dsi.ifc.navigation.PosTimeInfo;
import org.dsi.ifc.navigation.RRListElement;
import org.dsi.ifc.navigation.RgInfoForNextDestination;
import org.dsi.ifc.navigation.RgRouteCostChangeInformation;
import org.dsi.ifc.navigation.RgTurnToInfo;
import org.dsi.ifc.navigation.Route;
import org.dsi.ifc.navigation.RouteOptions;
import org.dsi.ifc.navigation.RouteProperties;
import org.dsi.ifc.navigation.RrdCalculationInfo;
import org.dsi.ifc.navigation.ThesaurusHistoryEntry;
import org.dsi.ifc.navigation.TourImportStatus;
import org.dsi.ifc.navigation.TryBestMatchResultData;
import org.dsi.ifc.navigation.TryMatchLocationResultData;
import org.dsi.ifc.navigation.TurnListElement;
import org.dsi.ifc.navigation.ValueListStatus;
import org.dsi.ifc.navigation.ViaPointListElement;

public final class NavGateway
implements DSINavigationListener,
Target,
INavGateway,
DSIServiceStateListener {
    private static NavGateway mpInstance = null;
    DSINavigation dsiNavigation;
    Command currentCmd;
    public NavGatewayListener lastListener = null;
    LinkedList cmdQueue = new LinkedList();
    IExtLogger logger;
    private int m_afaMode = 0;
    private int m_afaModeValid = 2;
    private boolean m_afaSpeaking = false;
    private int m_afaSpeakingValid = 2;
    private int m_AudioState = 0;
    private int m_AudioStateValid = 2;
    private String[] m_availableLanguages = new String[0];
    private int m_availableLanguagesValid = 2;
    private BapManeuverDescriptor[] m_bapManeuverDescriptor = new BapManeuverDescriptor[0];
    private int m_bapManeuverDescriptorValid = 2;
    private BapTurnToInfo[] m_bapTurnToInfo = new BapTurnToInfo[0];
    private int m_bapTurnToInfoValid = 2;
    private int[] m_cityIndices = new int[0];
    private int m_cityIndicesValid = 2;
    private CountryInfo[] m_countryInfo = new CountryInfo[0];
    private int m_countryInfoValid = 2;
    private int[] m_countryIndices = new int[0];
    private int m_countryIndicesValid = 2;
    private DistanceToNextManeuver m_distanceToNextManeuver = new DistanceToNextManeuver();
    private int m_distanceToNextManeuverValid = 2;
    private NavLocation m_FlagDestination = ASLNavigationUtilFactory.getNavigationUtilApi().getLocationWrapper().getLocation();
    private int m_FlagDestinationValid = 2;
    private LDListElement[] m_dmLastDestinationsList = new LDListElement[0];
    private int m_dmLastDestinationsListValid = 2;
    private RRListElement[] m_dmRecentRoutesList = new RRListElement[0];
    private int m_dmRecentRoutesListValid = 2;
    private NavDataBase[] m_navDataBases = new NavDataBase[0];
    private int m_navDataBasesValid = 2;
    private NavDataBase m_currentNavDataBase = new NavDataBase();
    private int m_currentNavDataBaseValid = 2;
    private boolean m_etcDemoModeState = false;
    private int m_etcDemoModeStateValid = 2;
    private long m_etcLanguageLoadProgress = 0L;
    private int m_etcLanguageLoadProgressValid = 2;
    private int m_etcLanguageLoadStatus = 0;
    private int m_etcLanguageLoadStatusValid = 2;
    private int m_etcMetricSystem = 0;
    private int m_etcMetricSystemValid = 2;
    private NavVersionInfo m_etcVersionInfo = new NavVersionInfo();
    private int m_etcVersionInfoValid = 2;
    private ThesaurusHistoryEntry[] m_thesaurusHistory = new ThesaurusHistoryEntry[0];
    private int m_thesaurusHistoryValid = 2;
    private String m_language = "";
    private int m_languageValid = 2;
    private LICityHistoryEntry[] m_cityHistory = new LICityHistoryEntry[0];
    private int m_cityHistoryValid = 2;
    private String m_countryAbbreviation = "";
    private int m_countryAbbreviationValid = 2;
    private LIStreetHistoryEntry[] m_streetHistory = new LIStreetHistoryEntry[0];
    private int m_streetHistoryValid = 2;
    private boolean m_lispIsSpellerActive = false;
    private int m_lispIsSpellerActiveValid = 2;
    private String[] m_navMedia = new String[0];
    private int m_navMediaValid = 2;
    private int m_navstateOfOperation = 0;
    private int m_navstateOfOperationValid = 2;
    private ValueListStatus m_poiSubstringSearchStatus = new ValueListStatus();
    private int m_poiSubstringSearchStatusValid = 2;
    private boolean m_rgActive = false;
    private int m_rgActiveValid = 2;
    private CalculatedRouteListElement[] m_rgCalculatedRoutes = new CalculatedRouteListElement[0];
    private int m_rgCalculatedRoutesValid = 2;
    private Route m_rgCurrentRoute = new Route();
    private int m_rgCurrentRouteValid = 2;
    private RouteOptions m_rgCurrentRouteOptions = new RouteOptions();
    private int m_rgCurrentRouteOptionsValid = 2;
    private NavRouteListData[] m_rgDestinationInfo = new NavRouteListData[0];
    private int m_rgDestinationInfoValid = 2;
    private NavRouteListData[] m_rgDetailedStreetList = new NavRouteListData[0];
    private int m_rgDetailedStreetListValid = 2;
    private RgInfoForNextDestination m_rgInfoForNextDestination = new RgInfoForNextDestination();
    private int m_rgInfoForNextDestinationValid = 2;
    private NavLaneGuidanceData[] m_rgLaneGuidance = new NavLaneGuidanceData[0];
    private boolean m_showLaneGuidance = false;
    private int m_rgLaneGuidanceValid = 2;
    private NavPoiInfo[] m_rgPoiInfo = new NavPoiInfo[0];
    private int m_rgPoiInfoValid = 2;
    private long m_calculationHorizon = 0L;
    private int m_calculationHorizonValid = 2;
    private int m_rgRouteCalculationState = 0;
    private int m_rgRouteCalculationStateValid = 2;
    private RgRouteCostChangeInformation m_rgRouteCostChangeInformation = new RgRouteCostChangeInformation();
    private int m_rgRouteCostChangeInformationValid = 2;
    private RouteProperties m_routeProperties = new RouteProperties();
    private int m_routePropertiesValid = 2;
    private NavRouteListData[] m_rgStreetList = new NavRouteListData[0];
    private int m_rgStreetListValid = 2;
    private long m_rgTimeAfaToDestination = 0L;
    private int m_rgTimeAfaToDestinationValid = 2;
    private TurnListElement[] m_rgTurnList = new TurnListElement[0];
    private int m_rgTurnListValid = 2;
    private long m_turnListCalculationHorizon = 0L;
    private int m_turnListCalculationHorizonValid = 2;
    private PosPosition m_soPosPosition = new PosPosition();
    private int m_soPosPositionValid = 2;
    private NavLocation m_soPosPositionDescription = ASLNavigationUtilFactory.getNavigationUtilApi().getLocationWrapper().getLocation();
    private boolean m_SoPosPositionDescriptionInProgressData = true;
    private int m_soPosPositionDescriptionValid = 2;
    static /* synthetic */ Class class$org$dsi$ifc$navigation$DSINavigation;
    static /* synthetic */ Class class$org$dsi$ifc$navigation$DSINavigationListener;

    @Override
    public void lispRequestNVCListResult(int n, String string, int n2) {
    }

    @Override
    public void triggerEventAudioMessageResult(int n) {
    }

    public static NavGateway getInstance() {
        if (mpInstance == null) {
            mpInstance = new NavGateway();
        }
        return mpInstance;
    }

    private NavGateway() {
        Object object;
        this.logger = ASLNavigationUtilFactory.getNavigationUtilApi().getExtLogger(16384, "NavGateway");
        if (System.getProperty("DSINavInterceptor") != null) {
            object = new DSINavInterceptor();
            ServiceManager.dsiServiceLocator.addServiceInterceptor(class$org$dsi$ifc$navigation$DSINavigation == null ? (class$org$dsi$ifc$navigation$DSINavigation = NavGateway.class$("org.dsi.ifc.navigation.DSINavigation")) : class$org$dsi$ifc$navigation$DSINavigation, (DSIInterceptor)object);
            ServiceManager.dsiServiceLocator.addListenerInterceptor(class$org$dsi$ifc$navigation$DSINavigationListener == null ? (class$org$dsi$ifc$navigation$DSINavigationListener = NavGateway.class$("org.dsi.ifc.navigation.DSINavigationListener")) : class$org$dsi$ifc$navigation$DSINavigationListener, (DSIInterceptor)object);
        }
        ServiceManager.dsiServiceLocator.addServiceStateListener(class$org$dsi$ifc$navigation$DSINavigation == null ? (class$org$dsi$ifc$navigation$DSINavigation = NavGateway.class$("org.dsi.ifc.navigation.DSINavigation")) : class$org$dsi$ifc$navigation$DSINavigation, this);
        if (this.logger.isTraceEnabled()) {
            object = this.logger.makeTrace();
            object.append("NavGateway constructed!").log();
        }
    }

    @Override
    public void registered(String string, int n) {
        if (this.logger.isTraceEnabled()) {
            LogMessage logMessage = this.logger.makeTrace();
            logMessage.append("NavGateway registered ").append(string).log();
        }
        if (string.intern() == (class$org$dsi$ifc$navigation$DSINavigation == null ? (class$org$dsi$ifc$navigation$DSINavigation = NavGateway.class$("org.dsi.ifc.navigation.DSINavigation")) : class$org$dsi$ifc$navigation$DSINavigation).getName().intern()) {
            try {
                this.dsiNavigation = (DSINavigation)ServiceManager.dsiServiceLocator.getService(this, class$org$dsi$ifc$navigation$DSINavigation == null ? (class$org$dsi$ifc$navigation$DSINavigation = NavGateway.class$("org.dsi.ifc.navigation.DSINavigation")) : class$org$dsi$ifc$navigation$DSINavigation);
                ServiceManager.dsiServiceLocator.addResponseListener(this, class$org$dsi$ifc$navigation$DSINavigationListener == null ? (class$org$dsi$ifc$navigation$DSINavigationListener = NavGateway.class$("org.dsi.ifc.navigation.DSINavigationListener")) : class$org$dsi$ifc$navigation$DSINavigationListener, this);
            }
            catch (Exception exception) {
                ServiceManager.errorHandler.handleDsiError(exception);
            }
        }
    }

    @Override
    public void unregistered(String string, int n) {
        if (this.logger.isTraceEnabled()) {
            LogMessage logMessage = this.logger.makeTrace();
            logMessage.append("HsmTargetNavigation tries to unregistered from ").append(string).append("...").log();
        }
        if (string.intern() == (class$org$dsi$ifc$navigation$DSINavigation == null ? (class$org$dsi$ifc$navigation$DSINavigation = NavGateway.class$("org.dsi.ifc.navigation.DSINavigation")) : class$org$dsi$ifc$navigation$DSINavigation).getName().intern()) {
            try {
                ServiceManager.dsiServiceLocator.removeResponseListener(this, class$org$dsi$ifc$navigation$DSINavigationListener == null ? (class$org$dsi$ifc$navigation$DSINavigationListener = NavGateway.class$("org.dsi.ifc.navigation.DSINavigationListener")) : class$org$dsi$ifc$navigation$DSINavigationListener, this);
                this.reinitLocalVariables();
            }
            catch (Exception exception) {
                ServiceManager.errorHandler.handleDsiError(exception);
            }
        }
    }

    private void reinitLocalVariables() {
        this.currentCmd = null;
        this.cmdQueue.clear();
    }

    @Override
    public void setNotification() {
        if (this.logger.isTraceEnabled()) {
            LogMessage logMessage = this.logger.makeTrace();
            logMessage.append("NavGateway notifications set!").log();
        }
        this.dsiNavigation.setNotification(this);
    }

    @Override
    public void handleNextCommands() {
        if (this.currentCmd != null) {
            Object object;
            if (Math.abs(ServiceManager.timerManager.getSystemTimeMillis() - this.currentCmd.getTimeStarted()) > this.currentCmd.timeOut) {
                Command command;
                try {
                    object = ServiceManager.logger.warn(16384);
                    object.append("forceFinished running command: ").append(super.getClass().getName());
                    object.append(" timeout : ");
                    object.append(this.currentCmd.timeOut);
                    object.append(" Current Time : ");
                    object.append(ServiceManager.timerManager.getSystemTimeMillis());
                    object.append(" Time started : ");
                    object.append(this.currentCmd.getTimeStarted());
                    object.log();
                    command = this.currentCmd;
                    this.currentCmd = null;
                    command._onFinish();
                }
                catch (Throwable throwable) {
                    ServiceManager.logger.trace(16384, throwable.toString());
                }
                while (!this.cmdQueue.isEmpty()) {
                    this.currentCmd = (Command)this.cmdQueue.getFirst();
                    this.currentCmd.setStartTime();
                    if (Math.abs(ServiceManager.timerManager.getSystemTimeMillis() - this.currentCmd.getTimeStarted()) <= this.currentCmd.timeOut) break;
                    ServiceManager.logger.warn(16384, new StringBuffer().append("forceFinished: ").append(super.getClass().getName()).toString());
                    object = ServiceManager.logger.warn(16384);
                    object.append(new StringBuffer().append(" forceFinished new command: ").append(super.getClass().getName()).toString());
                    object.append("timeout : ");
                    object.append(this.currentCmd.timeOut);
                    object.append(" Current Time : ");
                    object.append(ServiceManager.timerManager.getSystemTimeMillis());
                    object.append(" Time started : ");
                    object.append(this.currentCmd.getTimeStarted());
                    object.log();
                    this.cmdQueue.removeFirst();
                    try {
                        command = this.currentCmd;
                        this.currentCmd = null;
                        command._onFinish();
                    }
                    catch (Throwable throwable) {
                        ServiceManager.logger.error(16384, throwable.toString());
                    }
                }
                this.currentCmd = null;
            } else {
                if (!this.currentCmd.isFinished()) {
                    return;
                }
                if (this.currentCmd.getAnswerSum() == -2) {
                    object = this.currentCmd;
                    this.currentCmd = null;
                    try {
                        ((Command)object)._onFinish();
                    }
                    catch (Throwable throwable) {
                        ServiceManager.logger.error(16384, throwable.toString());
                    }
                }
            }
        }
        if (!this.cmdQueue.isEmpty()) {
            this.currentCmd = (Command)this.cmdQueue.removeFirst();
            this.currentCmd.setStartTime();
            try {
                this.currentCmd.execute(this);
            }
            catch (Throwable throwable) {
                ServiceManager.logger.error(16384, throwable.toString());
            }
        } else {
            this.currentCmd = null;
        }
    }

    @Override
    public void pushCommand(Command command) {
        this.cmdQueue.addLast(command);
        this.handleNextCommands();
    }

    @Override
    public DSINavigation getDsiNavigation() {
        return this.dsiNavigation;
    }

    @Override
    public void gotEvent(EventGeneric eventGeneric) {
    }

    @Override
    public GenericEvents getMainObject() {
        return null;
    }

    @Override
    public int getTargetId() {
        return 1984631808;
    }

    @Override
    public void setTargetId(int n) {
    }

    @Override
    public void createExportFileResult(int n, boolean bl) {
    }

    @Override
    public void dmLastDestinationsGetResult(long l, NavLocation navLocation) {
        if (this.currentCmd != null) {
            this.currentCmd.dmLastDestinationsGetResult(l, navLocation);
        }
    }

    @Override
    public void dmRecentRoutesGetResult(long l, Route route) {
    }

    @Override
    public void dmResult(long l, long l2) {
        if (this.currentCmd != null) {
            this.currentCmd.dmResult(l, l2);
        }
    }

    @Override
    public void ehGetAllBrandsOfCategoryResult(int n, int n2, Brand[] brandArray, int n3) {
    }

    @Override
    public void ehGetAllCategoriesResult(int n, Category[] categoryArray, int n2) {
    }

    @Override
    public void ehResult(int n, int n2) {
    }

    @Override
    public void etcGetCountryAbbreviationResult(String string, long l) {
    }

    @Override
    public void etcSensorDataReplayGuidance(boolean bl) {
    }

    @Override
    public void etcSensorDataReplayRoute(Route route) {
    }

    @Override
    public void importFileResult(int n, boolean bl) {
    }

    @Override
    public void languageSpellableCharactersResult(String string) {
    }

    @Override
    public void liCurrentState(NavLocation navLocation, int[] nArray, int[] nArray2, long l) {
        if (this.currentCmd != null) {
            NavLocation navLocation2 = navLocation;
            int[] nArray3 = nArray;
            int[] nArray4 = nArray2;
            if (navLocation2 == null) {
                navLocation2 = ASLNavigationUtilFactory.getNavigationUtilApi().getLocationWrapper().getLocation();
            }
            if (nArray3 == null) {
                nArray3 = new int[]{};
            }
            if (nArray4 == null) {
                nArray4 = new int[]{};
            }
            this.currentCmd.liCurrentState(navLocation2, nArray3, nArray4, l);
        }
    }

    @Override
    public void liGetLastCityHistoryEntryResult(NavLocation navLocation, boolean bl) {
        if (this.currentCmd != null) {
            this.currentCmd.liGetLastCityHistoryEntryResult(navLocation, bl);
        }
    }

    @Override
    public void liGetLastStreetHistoryEntryResult(NavLocation navLocation, boolean bl) {
        if (this.currentCmd != null) {
            this.currentCmd.liGetLastStreetHistoryEntryResult(navLocation, bl);
        }
    }

    @Override
    public void liGetLocationDescriptionTransformResult(NavLocation navLocation) {
        if (this.currentCmd != null) {
            this.currentCmd.liGetLocationDescriptionTransformResult(navLocation);
        }
    }

    @Override
    public void liGetStateResult(LISpellerData lISpellerData) {
        if (this.currentCmd != null) {
            this.currentCmd.liGetStateResult(lISpellerData);
        }
    }

    @Override
    public void liGetViaPointListResult(int n, ViaPointListElement[] viaPointListElementArray, int n2, int n3) {
    }

    @Override
    public void liLastCityAndStreetHistoryResult(long l) {
        ServiceManager.logger.trace(16384, new StringBuffer().append("liLastCityAndStreetHistoryResult ").append(l).toString());
        if (this.currentCmd != null) {
            ServiceManager.logger.trace(16384, "calling command handler method");
            this.currentCmd.liLastCityAndStreetHistoryResult(l);
        }
    }

    @Override
    public void liResult(long l) {
        if (this.currentCmd != null) {
            this.currentCmd.liResult(l);
        }
    }

    @Override
    public void liSelectViaPointResult(NavLocation navLocation, int n) {
    }

    @Override
    public void liSetCountryForCityAndStreetHistoryResult(int n) {
        ServiceManager.logger.trace(16384, new StringBuffer().append("liSetCountryForCityAndStreetHistoryResult ").append(n).toString());
        if (this.currentCmd != null) {
            ServiceManager.logger.trace(16384, "calling command handler method");
            this.currentCmd.liSetCountryForCityAndStreetHistoryResult(n);
        }
    }

    @Override
    public void liStripLocationResult(NavLocation navLocation) {
        if (this.currentCmd != null) {
            this.currentCmd.liStripLocationResult(navLocation);
        }
    }

    @Override
    public void liThesaurusHistoryAddResult(int n, int n2) {
    }

    @Override
    public void liThesaurusHistoryDeleteAllResult(int n) {
    }

    @Override
    public void liThesaurusHistoryDeleteResult(int n, int n2) {
    }

    @Override
    public void liThesaurusHistoryGetEntryResult(ThesaurusHistoryEntry thesaurusHistoryEntry, int n) {
    }

    @Override
    public void liTryBestMatchResult(TryBestMatchResultData[] tryBestMatchResultDataArray) {
        if (this.currentCmd != null) {
            this.currentCmd.liTryBestMatchResult(tryBestMatchResultDataArray);
        }
    }

    @Override
    public void liValueList(LIValueList lIValueList, long l) {
        if (this.currentCmd != null) {
            this.currentCmd.liValueList(lIValueList, l);
        }
    }

    @Override
    public void liValueListFileStatus(int n, int n2, String string) {
    }

    @Override
    public void liValueListOutputMethod(int n) {
    }

    public void lispUpdateSpellerResult(String string, int n, boolean bl, boolean bl2, String string2, int n2, int n3, boolean bl3, boolean bl4, long l) {
        if (this.currentCmd != null) {
            this.currentCmd.lispUpdateSpellerResult(string, n, bl, bl2, string2, n2, n3, bl3, bl4, l);
        }
    }

    @Override
    public void locationToStreamResult(boolean bl, byte[] byArray) {
        if (this.currentCmd != null) {
            this.currentCmd.locationToStreamResult(bl, byArray);
        }
    }

    @Override
    public void poiValueList(LIValueList lIValueList, long l) {
        if (this.currentCmd != null) {
            this.currentCmd.poiValueList(lIValueList, l);
        }
    }

    @Override
    public void requestCountryInfoResult(CountryInfo countryInfo, int n) {
    }

    @Override
    public void responseAudioTrigger(int n) {
    }

    @Override
    public void rgException(int n) {
    }

    @Override
    public void rgNotPossible(int n) {
    }

    @Override
    public void rgSetRouteGuidanceModeResult() {
    }

    @Override
    public void rgStartGuidanceCalculatedRouteResult(int n) {
    }

    @Override
    public void rmMakeRoutePersistentResult(long l) {
    }

    @Override
    public void rmRouteAddResult(int n, long l) {
        if (this.currentCmd != null) {
            this.currentCmd.rmRouteAddResult(n, l);
        }
    }

    @Override
    public void rmRouteDeleteAllResult(int n) {
    }

    @Override
    public void rmRouteDeleteResult(int n) {
        if (this.currentCmd != null) {
            this.currentCmd.rmRouteDeleteResult(n);
        }
    }

    @Override
    public void rmRouteGetResult(int n, Route route) {
    }

    @Override
    public void rmRouteRenameResult(int n) {
    }

    @Override
    public void setRemainingRangeOfVehicleResult(int n) {
    }

    @Override
    public void setTrailerStatusResult(int n) {
    }

    @Override
    public void setUserDefinedPOIsResult(int n) {
    }

    @Override
    public void setVehicleConsumptionInfoResult(int n) {
    }

    @Override
    public void soPosPositionDescriptionVehicleResult(NavLocation navLocation) {
    }

    @Override
    public void streamToLocationResult(boolean bl, NavLocation navLocation) {
        if (this.currentCmd != null) {
            this.currentCmd.streamToLocationResult(bl, navLocation);
        }
    }

    @Override
    public void trDeleteAllTracesResult(int n, int n2) {
    }

    @Override
    public void trDeleteTraceResult(int n, int n2) {
    }

    @Override
    public void trRenameTraceResult(int n, int n2) {
    }

    @Override
    public void trStartTraceRecordingResult(int n, long l, int n2) {
    }

    @Override
    public void trStopTraceRecordingResult(int n, long l, int n2) {
    }

    @Override
    public void trStoreTraceResult(int n, NavSegmentID navSegmentID, int n2) {
    }

    @Override
    public void translateRouteResult(Route route) {
    }

    @Override
    public int getAfaMode() {
        return this.m_afaMode;
    }

    @Override
    public boolean isAfaModeValid() {
        return this.m_afaModeValid == 1;
    }

    @Override
    public void updateAfaMode(int n, int n2) {
        this.m_afaMode = n;
        this.m_afaModeValid = n2;
    }

    @Override
    public boolean isAfaSpeaking() {
        return this.m_afaSpeaking;
    }

    @Override
    public boolean isAfaSpeakingValid() {
        return this.m_afaSpeakingValid == 1;
    }

    @Override
    public void updateAfaSpeaking(boolean bl, int n) {
        this.m_afaSpeaking = bl;
        this.m_afaSpeakingValid = n;
    }

    @Override
    public int getAudioState() {
        return this.m_AudioState;
    }

    @Override
    public boolean isAudioStateValid() {
        return this.m_AudioStateValid == 1;
    }

    @Override
    public void updateAudioRequest(int n, int n2) {
        this.m_AudioState = n;
        this.m_AudioStateValid = n2;
    }

    @Override
    public String[] getAvailableLanguages() {
        return this.m_availableLanguages;
    }

    @Override
    public boolean isAvailableLanguagesValid() {
        return this.m_availableLanguagesValid == 1;
    }

    @Override
    public void updateAvailableLanguages(String[] stringArray, int n) {
        this.m_availableLanguages = stringArray == null ? new String[0] : stringArray;
        this.m_availableLanguagesValid = n;
    }

    @Override
    public BapManeuverDescriptor[] getBapManeuverDescriptor() {
        return this.m_bapManeuverDescriptor;
    }

    @Override
    public boolean isBapManeuverDescriptorValid() {
        return this.m_bapManeuverDescriptorValid == 1;
    }

    @Override
    public void updateBapManeuverDescriptor(BapManeuverDescriptor[] bapManeuverDescriptorArray, int n) {
        this.m_bapManeuverDescriptor = bapManeuverDescriptorArray != null ? bapManeuverDescriptorArray : new BapManeuverDescriptor[0];
        this.m_bapManeuverDescriptorValid = n;
    }

    @Override
    public BapTurnToInfo[] getBapTurnToInfo() {
        return this.m_bapTurnToInfo;
    }

    @Override
    public boolean isBapTurnToInfoValid() {
        return this.m_bapTurnToInfoValid == 1;
    }

    @Override
    public void updateBapTurnToInfo(BapTurnToInfo[] bapTurnToInfoArray, int n) {
        this.m_bapTurnToInfo = bapTurnToInfoArray == null ? new BapTurnToInfo[0] : bapTurnToInfoArray;
        this.m_bapTurnToInfoValid = n;
    }

    @Override
    public int[] getCityIndices() {
        return this.m_cityIndices;
    }

    @Override
    public boolean isCityIndicesValid() {
        return this.m_cityIndicesValid == 1;
    }

    public void updateCityVignettes(int[] nArray, int n) {
        this.m_cityIndices = nArray != null ? nArray : new int[0];
        this.m_cityIndicesValid = n;
    }

    @Override
    public CountryInfo[] getCountryInfo() {
        return this.m_countryInfo;
    }

    @Override
    public boolean isCountryInfoValid() {
        return this.m_countryInfoValid == 1;
    }

    @Override
    public void updateCountryInfo(CountryInfo[] countryInfoArray, int n) {
        this.m_countryInfo = countryInfoArray != null ? countryInfoArray : new CountryInfo[0];
        this.m_countryInfoValid = n;
    }

    @Override
    public int[] getCountryIndices() {
        return this.m_countryIndices;
    }

    @Override
    public boolean isCountryIndicesValid() {
        return this.m_countryIndicesValid == 1;
    }

    public void updateCountryVignettes(int[] nArray, int n) {
        this.m_countryIndices = nArray == null ? new int[0] : nArray;
        this.m_countryIndicesValid = n;
    }

    @Override
    public DistanceToNextManeuver getDistanceToNextManeuver() {
        return this.m_distanceToNextManeuver;
    }

    @Override
    public boolean isDistanceToNextManeuverValid() {
        return this.m_distanceToNextManeuverValid == 1;
    }

    @Override
    public void updateDistanceToNextManeuver(DistanceToNextManeuver distanceToNextManeuver, int n) {
        this.m_distanceToNextManeuver = distanceToNextManeuver == null ? new DistanceToNextManeuver() : distanceToNextManeuver;
        this.m_distanceToNextManeuverValid = n;
    }

    @Override
    public NavLocation getFlagDestination() {
        return this.m_FlagDestination;
    }

    @Override
    public boolean isFlagDestinationValid() {
        return this.m_FlagDestinationValid == 1;
    }

    @Override
    public void updateDmFlagDestination(NavLocation navLocation, int n) {
        this.m_FlagDestination = navLocation;
        this.m_FlagDestinationValid = n;
    }

    @Override
    public LDListElement[] getDmLastDestinationsList() {
        return this.m_dmLastDestinationsList;
    }

    @Override
    public boolean isDmLastDestinationsListValid() {
        return this.m_dmLastDestinationsListValid == 1;
    }

    @Override
    public void updateDmLastDestinationsList(LDListElement[] lDListElementArray, int n) {
        this.m_dmLastDestinationsList = lDListElementArray != null ? lDListElementArray : new LDListElement[0];
        this.m_dmLastDestinationsListValid = n;
    }

    @Override
    public RRListElement[] getDmRecentRoutesList() {
        return this.m_dmRecentRoutesList;
    }

    @Override
    public boolean isDmRecentRoutesListValid() {
        return this.m_dmRecentRoutesListValid == 1;
    }

    @Override
    public void updateDmRecentRoutesList(RRListElement[] rRListElementArray, int n) {
        this.m_dmRecentRoutesList = rRListElementArray != null ? rRListElementArray : new RRListElement[0];
        this.m_dmRecentRoutesListValid = n;
    }

    @Override
    public NavDataBase[] getNavDataBases() {
        return this.m_navDataBases;
    }

    @Override
    public boolean isNavDataBasesValid() {
        return this.m_navDataBasesValid == 1;
    }

    @Override
    public void updateEtcAvailableNavDataBases(NavDataBase[] navDataBaseArray, int n) {
        this.m_navDataBases = navDataBaseArray != null ? navDataBaseArray : new NavDataBase[0];
        this.m_navDataBasesValid = n;
    }

    @Override
    public NavDataBase getCurrentNavDataBase() {
        return this.m_currentNavDataBase;
    }

    @Override
    public boolean isCurrentNavDataBaseValid() {
        return this.m_currentNavDataBaseValid == 1;
    }

    @Override
    public void updateEtcCurrentNavDataBase(NavDataBase navDataBase, int n) {
        this.m_currentNavDataBase = navDataBase != null ? navDataBase : new NavDataBase();
        this.m_currentNavDataBaseValid = n;
    }

    @Override
    public boolean getEtcDemoModeState() {
        return this.m_etcDemoModeState;
    }

    @Override
    public boolean isEtcDemoModeStateValid() {
        return this.m_etcDemoModeStateValid == 1;
    }

    @Override
    public void updateEtcDemoModeState(boolean bl, int n) {
        this.m_etcDemoModeState = bl;
        this.m_etcDemoModeStateValid = n;
    }

    @Override
    public long getEtcLanguageLoadProgress() {
        return this.m_etcLanguageLoadProgress;
    }

    @Override
    public boolean isEtcLanguageLoadProgressValid() {
        return this.m_etcLanguageLoadProgressValid == 1;
    }

    @Override
    public void updateEtcLanguageLoadProgress(long l, int n) {
        this.m_etcLanguageLoadProgress = l;
        this.m_etcLanguageLoadProgressValid = n;
    }

    @Override
    public int getEtcLanguageLoadStatus() {
        return this.m_etcLanguageLoadStatus;
    }

    @Override
    public boolean isEtcLanguageLoadStatusValid() {
        return this.m_etcLanguageLoadStatusValid == 1;
    }

    @Override
    public void updateEtcLanguageLoadStatus(int n, int n2) {
        this.m_etcLanguageLoadStatus = n;
        this.m_etcLanguageLoadStatusValid = n2;
    }

    @Override
    public int getEtcMetricSystem() {
        return this.m_etcMetricSystem;
    }

    @Override
    public boolean isEtcMetricSystemValid() {
        return this.m_etcMetricSystemValid == 1;
    }

    @Override
    public void updateEtcMetricSystem(int n, int n2) {
        this.m_etcMetricSystem = n;
        this.m_etcMetricSystemValid = n2;
    }

    @Override
    public NavVersionInfo getEtcVersionInfo() {
        return this.m_etcVersionInfo;
    }

    @Override
    public boolean isEtcVersionInfoValid() {
        return this.m_etcVersionInfoValid == 1;
    }

    @Override
    public void updateEtcVersionInfo(NavVersionInfo navVersionInfo, int n) {
        this.m_etcVersionInfo = navVersionInfo;
        this.m_etcVersionInfoValid = n;
    }

    @Override
    public ThesaurusHistoryEntry[] getThesaurusHistory() {
        return this.m_thesaurusHistory;
    }

    @Override
    public boolean isThesaurusHistoryValid() {
        return this.m_thesaurusHistoryValid == 1;
    }

    @Override
    public void updateLIThesaurusHistory(ThesaurusHistoryEntry[] thesaurusHistoryEntryArray, int n) {
        this.m_thesaurusHistory = thesaurusHistoryEntryArray != null ? thesaurusHistoryEntryArray : new ThesaurusHistoryEntry[0];
        this.m_thesaurusHistoryValid = n;
    }

    @Override
    public String getLanguage() {
        return this.m_language;
    }

    @Override
    public boolean isLanguageValid() {
        return this.m_languageValid == 1;
    }

    @Override
    public void updateLanguage(String string, int n) {
        this.m_language = this.m_language != null ? string : "";
        this.m_languageValid = n;
    }

    @Override
    public LICityHistoryEntry[] getCityHistory() {
        return this.m_cityHistory;
    }

    @Override
    public boolean isCityHistory() {
        return this.m_cityHistoryValid == 1;
    }

    @Override
    public void updateLiCityHistory(LICityHistoryEntry[] lICityHistoryEntryArray, int n) {
        this.m_cityHistory = lICityHistoryEntryArray != null ? lICityHistoryEntryArray : new LICityHistoryEntry[0];
        if (this.logger.traceEnabled(1)) {
            LogMessage logMessage = this.logger.makeTrace();
            logMessage.append("city history updated: ");
            ExtLoggerHelper.getInstance().appendCityHistory(logMessage, lICityHistoryEntryArray);
            logMessage.log();
        }
        this.m_cityHistoryValid = n;
    }

    @Override
    public String getCountryAbbreviation() {
        return this.m_countryAbbreviation;
    }

    @Override
    public boolean isCountryAbbreviationValid() {
        return this.m_countryAbbreviationValid == 1;
    }

    @Override
    public void updateLiCountryForCityAndStreetHistory(String string, int n) {
        this.m_countryAbbreviation = string != null ? string : "";
        if (this.logger.traceEnabled(1)) {
            this.logger.makeTrace().append("country for city/street history updated: ").append(string).log();
        }
        this.m_countryAbbreviationValid = n;
    }

    @Override
    public LIStreetHistoryEntry[] getStreetHistory() {
        return this.m_streetHistory;
    }

    @Override
    public boolean isStreetHistoryValid() {
        return this.m_streetHistoryValid == 1;
    }

    @Override
    public void updateLiStreetHistory(LIStreetHistoryEntry[] lIStreetHistoryEntryArray, int n) {
        this.m_streetHistory = lIStreetHistoryEntryArray != null ? lIStreetHistoryEntryArray : new LIStreetHistoryEntry[0];
        if (this.logger.traceEnabled(1)) {
            LogMessage logMessage = this.logger.makeTrace();
            logMessage.append("street history updated: ");
            ExtLoggerHelper.getInstance().appendStreetHistory(logMessage, lIStreetHistoryEntryArray);
            logMessage.log();
        }
        this.m_streetHistoryValid = n;
    }

    @Override
    public boolean getLispIsSpellerActive() {
        return this.m_lispIsSpellerActive;
    }

    @Override
    public boolean isLispIsSpellerActiveValid() {
        return this.m_lispIsSpellerActiveValid == 1;
    }

    @Override
    public void updateLispIsSpellerActive(boolean bl, int n) {
        this.m_lispIsSpellerActive = bl;
        this.m_lispIsSpellerActiveValid = n;
    }

    @Override
    public String[] getNavMedia() {
        return this.m_navMedia;
    }

    @Override
    public boolean isNavMediaValid() {
        return this.m_navMediaValid == 1;
    }

    @Override
    public void updateNavMedia(String[] stringArray, int n) {
        this.m_navMedia = stringArray != null ? stringArray : new String[0];
        this.m_navMediaValid = n;
    }

    @Override
    public int getNavstateOfOperation() {
        return this.m_navstateOfOperation;
    }

    @Override
    public boolean isNavstateOfOperationValid() {
        return this.m_navstateOfOperationValid == 1;
    }

    @Override
    public void updateNavstateOfOperation(int n, int n2) {
        this.m_navstateOfOperation = n;
        this.m_navstateOfOperationValid = n2;
    }

    @Override
    public ValueListStatus getPoiSubstringSearchStatus() {
        return this.m_poiSubstringSearchStatus;
    }

    @Override
    public boolean isPoiSubstringSearchStatusValid() {
        return this.m_poiSubstringSearchStatusValid == 1;
    }

    @Override
    public void updatePoiSubstringSearchStatus(ValueListStatus valueListStatus, int n) {
        this.m_poiSubstringSearchStatus = valueListStatus != null ? valueListStatus : new ValueListStatus();
        this.m_poiSubstringSearchStatusValid = n;
    }

    @Override
    public boolean isRgActive() {
        return this.m_rgActive;
    }

    @Override
    public boolean isRgActiveValid() {
        return this.m_rgActiveValid == 1;
    }

    @Override
    public void updateRgActive(boolean bl, int n) {
        this.m_rgActive = bl;
        this.m_rgActiveValid = n;
    }

    @Override
    public CalculatedRouteListElement[] getRgCalculatedRoutes() {
        return this.m_rgCalculatedRoutes;
    }

    @Override
    public boolean isRgCalculatedRoutesValid() {
        return this.m_rgCalculatedRoutesValid == 1;
    }

    @Override
    public void updateRgCalculatedRoutes(CalculatedRouteListElement[] calculatedRouteListElementArray, int n) {
        this.m_rgCalculatedRoutes = calculatedRouteListElementArray != null ? calculatedRouteListElementArray : new CalculatedRouteListElement[0];
        this.m_rgCalculatedRoutesValid = n;
    }

    @Override
    public Route getRgCurrentRoute() {
        return this.m_rgCurrentRoute;
    }

    @Override
    public boolean isRgCurrentRouteValid() {
        return this.m_rgCurrentRouteValid == 1;
    }

    @Override
    public void updateRgCurrentRoute(Route route, int n) {
        this.m_rgCurrentRoute = route != null ? route : new Route();
        this.m_rgCurrentRouteValid = n;
    }

    @Override
    public RouteOptions getRgCurrentRouteOptions() {
        return this.m_rgCurrentRouteOptions;
    }

    @Override
    public boolean isRgCurrentRouteOptionsValid() {
        return this.m_rgCurrentRouteOptionsValid == 1;
    }

    @Override
    public void updateRgCurrentRouteOptions(RouteOptions routeOptions, int n) {
        this.m_rgCurrentRouteOptions = routeOptions != null ? routeOptions : new RouteOptions();
        this.m_rgCurrentRouteOptionsValid = n;
    }

    @Override
    public NavRouteListData[] getRgDestinationInfo() {
        return this.m_rgDestinationInfo;
    }

    @Override
    public boolean isRgDestinationInfoValid() {
        return this.m_rgDestinationInfoValid == 1;
    }

    @Override
    public void updateRgDestinationInfo(NavRouteListData[] navRouteListDataArray, int n) {
        this.m_rgDestinationInfo = navRouteListDataArray != null ? navRouteListDataArray : new NavRouteListData[0];
        this.m_rgDestinationInfoValid = n;
    }

    @Override
    public NavRouteListData[] getRgDetailedStreetList() {
        return this.m_rgDetailedStreetList;
    }

    @Override
    public boolean isRgDetailedStreetListValid() {
        return this.m_rgDetailedStreetListValid == 1;
    }

    @Override
    public void updateRgDetailedStreetList(NavRouteListData[] navRouteListDataArray, int n) {
        this.m_rgDetailedStreetList = navRouteListDataArray != null ? navRouteListDataArray : new NavRouteListData[0];
        this.m_rgDetailedStreetListValid = n;
    }

    @Override
    public RgInfoForNextDestination getRgInfoForNextDestination() {
        return this.m_rgInfoForNextDestination;
    }

    @Override
    public boolean isRgInfoForNextDestinationValid() {
        return this.m_rgInfoForNextDestinationValid == 1;
    }

    @Override
    public void updateRgInfoForNextDestination(RgInfoForNextDestination rgInfoForNextDestination, int n) {
        this.m_rgInfoForNextDestination = rgInfoForNextDestination != null ? rgInfoForNextDestination : new RgInfoForNextDestination();
        this.m_rgInfoForNextDestinationValid = n;
    }

    @Override
    public NavLaneGuidanceData[] getRgLaneGuidance() {
        return this.m_rgLaneGuidance;
    }

    @Override
    public boolean isShowLaneGuidance() {
        return this.m_showLaneGuidance;
    }

    @Override
    public boolean isRgLaneGuidanceValid() {
        return this.m_rgLaneGuidanceValid == 1;
    }

    @Override
    public void updateRgLaneGuidance(NavLaneGuidanceData[] navLaneGuidanceDataArray, boolean bl, int n) {
        this.m_rgLaneGuidance = navLaneGuidanceDataArray != null ? navLaneGuidanceDataArray : new NavLaneGuidanceData[0];
        this.m_showLaneGuidance = bl;
        this.m_rgLaneGuidanceValid = n;
    }

    @Override
    public NavPoiInfo[] getRgPoiInfo() {
        return this.m_rgPoiInfo;
    }

    @Override
    public boolean isRgPoiInfoValid() {
        return this.m_rgPoiInfoValid == 1;
    }

    @Override
    public void updateRgPoiInfo(NavPoiInfo[] navPoiInfoArray, int n) {
        this.m_rgPoiInfo = navPoiInfoArray != null ? navPoiInfoArray : new NavPoiInfo[0];
        this.m_rgPoiInfoValid = n;
    }

    @Override
    public long getCalculationHorizon() {
        return this.m_calculationHorizon;
    }

    @Override
    public boolean isCalculationHorizonValid() {
        return this.m_calculationHorizonValid == 1;
    }

    @Override
    public void updateRgPoiInfoCalculationHorizon(long l, int n) {
        this.m_calculationHorizon = l;
        this.m_calculationHorizonValid = n;
    }

    @Override
    public int getRgRouteCalculationState() {
        return this.m_rgRouteCalculationState;
    }

    @Override
    public boolean isRgRouteCalculationStateValid() {
        return this.m_rgRouteCalculationStateValid == 1;
    }

    @Override
    public void updateRgRouteCalculationState(int n, int n2) {
        this.m_rgRouteCalculationState = n;
        this.m_rgRouteCalculationStateValid = n2;
    }

    @Override
    public RgRouteCostChangeInformation getRgRouteCostChangeInformation() {
        return this.m_rgRouteCostChangeInformation;
    }

    @Override
    public boolean isRgRouteCostChangeInformationValid() {
        return this.m_rgRouteCostChangeInformationValid == 1;
    }

    @Override
    public void updateRgRouteCostChangeInformation(RgRouteCostChangeInformation rgRouteCostChangeInformation, int n) {
        this.m_rgRouteCostChangeInformation = rgRouteCostChangeInformation != null ? rgRouteCostChangeInformation : new RgRouteCostChangeInformation();
        this.m_rgRouteCostChangeInformationValid = n;
    }

    @Override
    public RouteProperties getRouteProperties() {
        return this.m_routeProperties;
    }

    @Override
    public boolean isRoutePropertiesValid() {
        return this.m_routePropertiesValid == 1;
    }

    @Override
    public void updateRgRouteProperties(RouteProperties routeProperties, int n) {
        this.m_routeProperties = routeProperties != null ? routeProperties : new RouteProperties();
        this.m_routePropertiesValid = n;
    }

    @Override
    public NavRouteListData[] getRgStreetList() {
        return this.m_rgStreetList;
    }

    @Override
    public boolean isRgStreetListValid() {
        return this.m_rgStreetListValid == 1;
    }

    @Override
    public void updateRgStreetList(NavRouteListData[] navRouteListDataArray, int n) {
        this.m_rgStreetList = navRouteListDataArray != null ? navRouteListDataArray : new NavRouteListData[0];
        this.m_rgStreetListValid = n;
    }

    @Override
    public long getRgTimeAfaToDestination() {
        return this.m_rgTimeAfaToDestination;
    }

    @Override
    public boolean isRgTimeAfaToDestinationValid() {
        return this.m_rgTimeAfaToDestinationValid == 1;
    }

    @Override
    public void updateRgTimeAfaToDestination(long l, int n) {
        this.m_rgTimeAfaToDestination = l;
        this.m_rgTimeAfaToDestinationValid = n;
    }

    @Override
    public TurnListElement[] getRgTurnList() {
        return this.m_rgTurnList;
    }

    @Override
    public boolean isRgTurnListValid() {
        return this.m_rgTurnListValid == 1;
    }

    @Override
    public void updateRgTurnList(TurnListElement[] turnListElementArray, int n) {
        this.m_rgTurnList = turnListElementArray != null ? turnListElementArray : new TurnListElement[0];
        this.m_rgTurnListValid = n;
    }

    @Override
    public long getTurnListCalculationHorizon() {
        return this.m_turnListCalculationHorizon;
    }

    @Override
    public boolean isTurnListCalculationHorizonValid() {
        return this.m_turnListCalculationHorizonValid == 1;
    }

    @Override
    public void updateRgTurnListCalculationHorizon(long l, int n) {
        this.m_turnListCalculationHorizon = l;
        this.m_turnListCalculationHorizonValid = n;
    }

    @Override
    public void updateRgTurnToStreet(String string, boolean bl, int n) {
    }

    @Override
    public void updateRgUnfulfilledRouteOptions(RouteOptions routeOptions, int n) {
    }

    @Override
    public void updateRgiString(short[] sArray, int n) {
    }

    @Override
    public void updateRmPersistentRoute(Route route, int n) {
    }

    @Override
    public void updateRmRouteList(NavRmRouteListArrayData[] navRmRouteListArrayDataArray, int n) {
    }

    @Override
    public void updateRrdActive(boolean bl, int n) {
    }

    @Override
    public void updateRrdCalculationInfo(RrdCalculationInfo[] rrdCalculationInfoArray, int n) {
    }

    @Override
    public PosPosition getSoPosPosition() {
        return this.m_soPosPosition;
    }

    @Override
    public boolean isSoPosPositionValid() {
        return this.m_soPosPositionValid == 1;
    }

    @Override
    public void updateSoPosPosition(PosPosition posPosition, int n) {
        this.m_soPosPosition = posPosition != null ? posPosition : new PosPosition();
        this.m_soPosPositionValid = n;
    }

    @Override
    public NavLocation getSoPosPositionDescription() {
        return this.m_soPosPositionDescription;
    }

    @Override
    public boolean isSoPosPositionDescriptionValid() {
        return this.m_soPosPositionDescriptionValid == 1;
    }

    @Override
    public boolean isSoPosPositionDescriptionInProgressData() {
        return this.m_SoPosPositionDescriptionInProgressData;
    }

    @Override
    public void updateSoPosPositionDescription(NavLocation navLocation, boolean bl, int n) {
        this.m_soPosPositionDescription = navLocation != null ? navLocation : ASLNavigationUtilFactory.getNavigationUtilApi().getLocationWrapper().getLocation();
        this.m_soPosPositionDescriptionValid = n;
        this.m_SoPosPositionDescriptionInProgressData = bl;
    }

    @Override
    public void updateStyleDBPaths(String[] stringArray, int n) {
    }

    @Override
    public void updateTrDirectionToWaypoint(DirectionToWaypoint directionToWaypoint, int n) {
    }

    @Override
    public void updateTrMemoryUtilization(NavTraceMemoryUtilization navTraceMemoryUtilization, int n) {
    }

    @Override
    public void updateTrOperatingMode(int n, int n2) {
    }

    @Override
    public void updateTrRecordingState(int n, int n2) {
    }

    @Override
    public void updateTrTraceList(NavTraceListData[] navTraceListDataArray, int n) {
    }

    @Override
    public void asyncException(int n, String string, int n2) {
        if (this.currentCmd != null) {
            this.currentCmd.asyncException(n, string, n2);
        }
        this.handleNextCommands();
    }

    @Override
    public void updateRouteResumePossible(boolean bl, int n) {
    }

    @Override
    public void getSpellableCharactersResult(String string, String string2, int n, String string3, int n2) {
    }

    @Override
    public void lispUpdateSpellerResult(String string, int n, boolean bl, boolean bl2, String string2, int n2, int n3, boolean bl3, boolean bl4, int n4, long l) {
        if (this.currentCmd != null) {
            this.currentCmd.lispUpdateSpellerResult(string, n, bl, bl2, string2, n2, n3, bl3, bl4, l);
        }
    }

    @Override
    public void rgStartGuidanceCalculatedRouteByUIDResult(NavSegmentID navSegmentID, int n) {
    }

    @Override
    public void updatePOIsEnteringProximityRange(NavLocation[] navLocationArray, int n) {
    }

    public void updatePOIsInsideProximityRange(NavLocation[] navLocationArray, int n) {
    }

    @Override
    public void liGetSpellableCharactersResult(NavLocation navLocation, int n, String string, int n2) {
    }

    @Override
    public void setVehicleFuelTypeResult(int n, int n2) {
    }

    @Override
    public void createNavLocationOfPOIUIDResult(long l, NavLocation navLocation, int n) {
    }

    @Override
    public void updateEtcAvailablePersonalPOIDataBases(NavDataBase[] navDataBaseArray, int n) {
        HsmCacheHandler.clearCache();
    }

    @Override
    public void updatePersonalPOISearchStatus(int n, int n2) {
    }

    @Override
    public void rmRouteReplaceResult(int n, long l, int n2) {
    }

    @Override
    public void deletePersonalPOIDataBasesResult(int n) {
    }

    public static boolean isInstance() {
        return mpInstance != null;
    }

    @Override
    public void updateLiStateHistory(LIStateHistoryEntry[] lIStateHistoryEntryArray, int n) {
    }

    @Override
    public void liHistoryResult(int n) {
    }

    @Override
    public void liGetLastStateHistoryEntryResult(NavLocation navLocation, boolean bl) {
    }

    @Override
    public void rgSwitchToNextPossibleRoadResult(boolean bl) {
    }

    @Override
    public void setNavInternalDataToFactorySettingsResult(int n) {
    }

    @Override
    public void liTryMatchLocationResult(TryMatchLocationResultData[] tryMatchLocationResultDataArray) {
        if (this.currentCmd != null) {
            this.currentCmd.liTryMatchLocationResult(tryMatchLocationResultDataArray);
        }
    }

    @Override
    public void updateNavDbRegionsState(int n, String[] stringArray, int n2) {
    }

    @Override
    public void trImportTrailsResult(NavSegmentID[] navSegmentIDArray, int n) {
    }

    @Override
    public void trExportTrailsResult(int n) {
    }

    @Override
    public void updateTrInfoForNextWaypoint(NavNextWayPointInfo navNextWayPointInfo, int n) {
    }

    @Override
    public void rgStartRubberbandManipulationResult(int n) {
    }

    @Override
    public void rgGetRouteBoundingRectangleResult(NavRectangle navRectangle, int n) {
    }

    @Override
    public void rgGetLocationOnRouteResult(NavLocation navLocation, int n) {
    }

    @Override
    public void rgResult(int n) {
    }

    @Override
    public void updateRgEnhancedSignPostInfoStatus(boolean bl, int n) {
    }

    @Override
    public void updateSoPosTimeInformation(PosTimeInfo posTimeInfo, int n) {
    }

    @Override
    public void rgGetRubberBandPointPositionResult(NavLocationWgs84 navLocationWgs84, boolean bl, int n) {
    }

    @Override
    public void lispGetMatchingNVCResult(String string) {
        if (this.currentCmd != null) {
            this.currentCmd.lispGetMatchingNVCResult(string);
        }
    }

    @Override
    public void etcSetDemoModeResult(int n) {
    }

    @Override
    public void lispGetLocationFromLiValueListResult(int n, NavLocation navLocation) {
        if (this.currentCmd != null) {
            this.currentCmd.lispGetLocationFromLiValueListResult(n, navLocation);
        }
    }

    @Override
    public void poiGetXt9LDBsResult(String[] stringArray) {
        if (this.currentCmd != null) {
            this.currentCmd.poiGetXt9LDBsResult(stringArray);
        }
    }

    @Override
    public void updateRgMotorwayInfo(NavPoiInfo[] navPoiInfoArray, int n) {
    }

    @Override
    public void updateRgVirtualDestinationInfo(RgInfoForNextDestination rgInfoForNextDestination, int n) {
    }

    @Override
    public void rgTriggerRCCIUpdateResult(int n) {
    }

    @Override
    public void liGetLocationDescriptionTransformNearByResult(NavLocation navLocation) {
    }

    @Override
    public void updateRgTurnToInfo(RgTurnToInfo rgTurnToInfo, int n) {
    }

    @Override
    public void poiGetCategoryTypesFromUIdResult(int[] nArray) {
    }

    @Override
    public void etcGetPositionTimeInfoResult(PosTimeInfo posTimeInfo, int n) {
    }

    @Override
    public void updateRgPersistedRouteDataAvailable(boolean bl, int n) {
    }

    @Override
    public void liDisambiguateLocationResult(int[] nArray, NavLocation[] navLocationArray) {
    }

    @Override
    public void etcTriggerNavigationRestartResult(int n, int n2) {
    }

    @Override
    public void updateMapIntegrationProgress(int n, int n2) {
    }

    @Override
    public void updateMapIntegrationState(int n, int n2) {
    }

    @Override
    public void importRouteFromGpxFileResult(NavLocation navLocation) {
    }

    @Override
    public void rmImportToursFromGpxFileResult(int n) {
    }

    @Override
    public void updateBapManeuverState(int n, int n2) {
    }

    @Override
    public void updateRmImportToursFromGpxFileStatus(TourImportStatus tourImportStatus, int n) {
    }

    @Override
    public void updateBapManeuverInformation(BapManeuverDescriptor[] bapManeuverDescriptorArray, int n, int n2) {
    }

    @Override
    public void poiRequestExtendedInfoResult(PoiExtendedInfo poiExtendedInfo, boolean bl) {
    }

    @Override
    public void trClearRecordedTraceCacheResult() {
    }

    @Override
    public void updateProfileState(int n, int n2, int n3) {
    }

    @Override
    public void profileChanged(int n, int n2) {
    }

    @Override
    public void profileCopied(int n, int n2, int n3) {
    }

    @Override
    public void profileReset(int n, int n2) {
    }

    @Override
    public void profileResetAll(int n) {
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

