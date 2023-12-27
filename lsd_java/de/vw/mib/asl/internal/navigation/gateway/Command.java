/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.gateway;

import de.vw.mib.asl.api.navigation.util.ASLNavigationUtilFactory;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.navigation.gateway.INavGateway;
import de.vw.mib.asl.internal.navigation.gateway.command.NavGatewayListener;
import java.util.Hashtable;
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

public abstract class Command
implements DSINavigationListener {
    private Hashtable blindArguments;
    public static int GENERIC_CMD_RETRY_COUNT = 3;
    private int answerSum;
    private long timeStarted;
    private long timeFinished;
    protected NavGatewayListener l;
    public final long timeCreated;
    public final long timeOut;
    public int asyncException_errorCode;
    public String asyncException_errorMsg = "";
    public int asyncException_requestType;
    public String commonErrorString = "";
    public int retryCount = 0;
    public final int finalAnswerSum;
    public int req_type;
    private boolean onFinishCalled = false;

    public void setBlindArgument(String string, Object object) {
        if (this.blindArguments == null) {
            this.blindArguments = new Hashtable();
        }
        this.blindArguments.put(string, object);
    }

    public Object getBlindArgument(String string) {
        if (this.blindArguments != null) {
            return this.blindArguments.get(string);
        }
        return null;
    }

    @Override
    public void updateBapManeuverInformation(BapManeuverDescriptor[] bapManeuverDescriptorArray, int n, int n2) {
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
    public void etcTriggerNavigationRestartResult(int n, int n2) {
    }

    @Override
    public void updateMapIntegrationProgress(int n, int n2) {
    }

    @Override
    public void updateMapIntegrationState(int n, int n2) {
    }

    @Override
    public void lispRequestNVCListResult(int n, String string, int n2) {
    }

    @Override
    public void triggerEventAudioMessageResult(int n) {
    }

    @Override
    public void updateRgPersistedRouteDataAvailable(boolean bl, int n) {
    }

    @Override
    public void etcGetPositionTimeInfoResult(PosTimeInfo posTimeInfo, int n) {
    }

    public void getSpellableCharactersResult(String string, String string2, int n, String string3, int n2) {
        ServiceManager.logger.warn(16384).append("unexpected getSpellableCharactersResult answers in ").append(super.getClass().getName()).log();
    }

    @Override
    public void lispUpdateSpellerResult(String string, int n, boolean bl, boolean bl2, String string2, int n2, int n3, boolean bl3, boolean bl4, int n4, long l) {
        ServiceManager.logger.warn(16384).append("unexpected lispUpdateSpellerResult answers in ").append(super.getClass().getName()).log();
    }

    @Override
    public void rgStartGuidanceCalculatedRouteByUIDResult(NavSegmentID navSegmentID, int n) {
        ServiceManager.logger.warn(16384).append("unexpected rgStartGuidanceCalculatedRouteByUIDResult answers in ").append(super.getClass().getName());
    }

    public void setStartTime() {
        this.setTimeStarted(ServiceManager.timerManager.getSystemTimeMillis());
    }

    public void setFinishTime() {
        this.timeFinished = ServiceManager.timerManager.getSystemTimeMillis();
    }

    public long getElapsedTimeInMs() {
        return this.timeFinished - this.getTimeStarted();
    }

    public void checkAnswerSum(int n) {
        this.answerSum -= n;
        if (this.answerSum <= 0) {
            if (this.answerSum < 0) {
                ServiceManager.logger.warn(16384).append("unexpected ").append(n).append(" answers in ").append(super.getClass().getName()).append(" ").append(this.answerSum);
                ASLNavigationUtilFactory.getNavigationUtilApi().getNaviHelper().resetNaviContext(new StringBuffer().append("unexpected ").append(n).append(" answers in ").append(super.getClass().getName()).append(" ").append(this.answerSum).append(" asyncException=").append(this.asyncException_errorCode).append(", ").append(this.asyncException_errorMsg != null ? this.asyncException_errorMsg : "").append(" ").append(this.commonErrorString).toString());
            }
            this.handleFinish();
        }
    }

    public boolean hasTimeoutOccured() {
        return Math.abs(ServiceManager.timerManager.getSystemTimeMillis() - this.getTimeStarted()) > this.timeOut;
    }

    private void handleFinish() {
        this._onFinish();
        ASLNavigationUtilFactory.getNavigationUtilApi().getNavGateway().handleNextCommands();
    }

    public boolean isFinished() {
        if (this.hasTimeoutOccured()) {
            this.answerSum = -2;
            this.asyncException_errorCode = -2;
            this.asyncException_errorMsg = "timeout occured";
        }
        return this.answerSum <= 0;
    }

    public int getAnswerSum() {
        return this.answerSum;
    }

    public void reset() {
        this.answerSum = this.finalAnswerSum;
        this.asyncException_errorCode = 0;
        this.asyncException_errorMsg = "";
        this.asyncException_requestType = 0;
        this.setTimeStarted(ServiceManager.timerManager.getSystemTimeMillis());
    }

    public Command(int n, int n2, NavGatewayListener navGatewayListener) {
        this.req_type = n;
        this.finalAnswerSum = n2;
        this.answerSum = n2;
        this.l = navGatewayListener;
        this.timeCreated = ServiceManager.timerManager.getSystemTimeMillis();
        this.timeOut = 0;
    }

    public Command(int n, int n2, NavGatewayListener navGatewayListener, long l) {
        this.req_type = n;
        this.finalAnswerSum = n2;
        this.answerSum = n2;
        this.l = navGatewayListener;
        this.timeCreated = ServiceManager.timerManager.getSystemTimeMillis();
        this.timeOut = l;
    }

    protected abstract void execute(INavGateway iNavGateway) {
    }

    public void execute() {
        INavGateway iNavGateway = ASLNavigationUtilFactory.getNavigationUtilApi().getNavGateway();
        iNavGateway.pushCommand(this);
    }

    protected abstract void onFinish() {
    }

    public final void _onFinish() {
        if (!this.onFinishCalled) {
            this.onFinishCalled = true;
            this.setFinishTime();
            this.onFinish();
        }
    }

    @Override
    public void createExportFileResult(int n, boolean bl) {
        ServiceManager.logger.warn(16384).append("unexpected createExportFileResult answers in ").append(super.getClass().getName()).log();
    }

    @Override
    public void dmLastDestinationsGetResult(long l, NavLocation navLocation) {
        ServiceManager.logger.warn(16384).append("unexpected dmLastDestinationsGetResult answers in ").append(super.getClass().getName()).log();
    }

    @Override
    public void dmRecentRoutesGetResult(long l, Route route) {
        ServiceManager.logger.warn(16384).append("unexpected dmRecentRoutesGetResult answers in ").append(super.getClass().getName()).log();
    }

    @Override
    public void dmResult(long l, long l2) {
        ServiceManager.logger.warn(16384).append("unexpected dmResult answers in ").append(super.getClass().getName()).log();
    }

    @Override
    public void ehGetAllBrandsOfCategoryResult(int n, int n2, Brand[] brandArray, int n3) {
        ServiceManager.logger.warn(16384).append("unexpected ehGetAllBrandsOfCategoryResult answers in ").append(super.getClass().getName()).log();
    }

    @Override
    public void ehGetAllCategoriesResult(int n, Category[] categoryArray, int n2) {
        ServiceManager.logger.warn(16384).append("unexpected ehGetAllCategoriesResult answers in ").append(super.getClass().getName()).log();
    }

    @Override
    public void ehResult(int n, int n2) {
        ServiceManager.logger.warn(16384).append("unexpected ehResult answers in ").append(super.getClass().getName()).log();
    }

    @Override
    public void etcGetCountryAbbreviationResult(String string, long l) {
        ServiceManager.logger.warn(16384).append("unexpected etcGetCountryAbbreviationResult answers in ").append(super.getClass().getName()).log();
    }

    @Override
    public void etcSensorDataReplayGuidance(boolean bl) {
        ServiceManager.logger.warn(16384).append("unexpected etcSensorDataReplayGuidance answers in ").append(super.getClass().getName()).log();
    }

    @Override
    public void etcSensorDataReplayRoute(Route route) {
        ServiceManager.logger.warn(16384).append("unexpected etcSensorDataReplayRoute answers in ").append(super.getClass().getName()).log();
    }

    @Override
    public void importFileResult(int n, boolean bl) {
        ServiceManager.logger.warn(16384).append("unexpected importFileResult answers in ").append(super.getClass().getName()).log();
    }

    @Override
    public void languageSpellableCharactersResult(String string) {
        ServiceManager.logger.warn(16384).append("unexpected languageSpellableCharactersResult answers in ").append(super.getClass().getName()).log();
    }

    @Override
    public void liCurrentState(NavLocation navLocation, int[] nArray, int[] nArray2, long l) {
        ServiceManager.logger.warn(16384).append("unexpected liCurrentState answers in ").append(super.getClass().getName()).log();
    }

    @Override
    public void liGetLastCityHistoryEntryResult(NavLocation navLocation, boolean bl) {
        ServiceManager.logger.warn(16384).append("unexpected liGetLastCityHistoryEntryResult answers in ").append(super.getClass().getName()).log();
    }

    @Override
    public void liGetLastStreetHistoryEntryResult(NavLocation navLocation, boolean bl) {
        ServiceManager.logger.warn(16384).append("unexpected liGetLastStreetHistoryEntryResult answers in ").append(super.getClass().getName()).log();
    }

    @Override
    public void liGetLocationDescriptionTransformResult(NavLocation navLocation) {
        ServiceManager.logger.warn(16384).append("unexpected liGetLocationDescriptionTransformResult answers in ").append(super.getClass().getName());
    }

    @Override
    public void liGetStateResult(LISpellerData lISpellerData) {
        ServiceManager.logger.warn(16384).append("unexpected liGetStateResult answers in ").append(super.getClass().getName()).log();
    }

    @Override
    public void liGetViaPointListResult(int n, ViaPointListElement[] viaPointListElementArray, int n2, int n3) {
        ServiceManager.logger.warn(16384).append("unexpected liGetViaPointListResult answers in ").append(super.getClass().getName()).log();
    }

    @Override
    public void liLastCityAndStreetHistoryResult(long l) {
        ServiceManager.logger.warn(16384).append("unexpected liLastCityAndStreetHistoryResult answers in ").append(super.getClass().getName()).log();
    }

    @Override
    public void liResult(long l) {
        ServiceManager.logger.warn(16384).append("unexpected liResult answers in ").append(super.getClass().getName()).log();
    }

    @Override
    public void liSelectViaPointResult(NavLocation navLocation, int n) {
        ServiceManager.logger.warn(16384).append("unexpected liSelectViaPointResult answers in ").append(super.getClass().getName()).log();
    }

    @Override
    public void liSetCountryForCityAndStreetHistoryResult(int n) {
        ServiceManager.logger.warn(16384).append("unexpected liSetCountryForCityAndStreetHistoryResult answers in ").append(super.getClass().getName()).log();
    }

    public void lispUpdateSpellerResult(String string, int n, boolean bl, boolean bl2, String string2, int n2, int n3, boolean bl3, boolean bl4, long l) {
        ServiceManager.logger.warn(16384).append("unexpected lispUpdateSpellerResult answers in ").append(super.getClass().getName()).log();
    }

    @Override
    public void liStripLocationResult(NavLocation navLocation) {
        ServiceManager.logger.warn(16384).append("unexpected liStripLocationResult answers in ").append(super.getClass().getName()).log();
    }

    @Override
    public void liThesaurusHistoryAddResult(int n, int n2) {
        ServiceManager.logger.warn(16384).append("unexpected liThesaurusHistoryAddResult answers in ").append(super.getClass().getName()).log();
    }

    @Override
    public void liThesaurusHistoryDeleteAllResult(int n) {
        ServiceManager.logger.warn(16384).append("unexpected liThesaurusHistoryDeleteAllResult answers in ").append(super.getClass().getName()).log();
    }

    @Override
    public void liThesaurusHistoryDeleteResult(int n, int n2) {
        ServiceManager.logger.warn(16384).append("unexpected liThesaurusHistoryDeleteResult answers in ").append(super.getClass().getName()).log();
    }

    @Override
    public void liThesaurusHistoryGetEntryResult(ThesaurusHistoryEntry thesaurusHistoryEntry, int n) {
        ServiceManager.logger.warn(16384).append("unexpected liThesaurusHistoryGetEntryResult answers in ").append(super.getClass().getName()).log();
    }

    @Override
    public void liTryBestMatchResult(TryBestMatchResultData[] tryBestMatchResultDataArray) {
        ServiceManager.logger.warn(16384).append("unexpected liTryBestMatchResult answers in ").append(super.getClass().getName()).log();
    }

    @Override
    public void liValueList(LIValueList lIValueList, long l) {
        ServiceManager.logger.warn(16384).append("unexpected liValueList answers in ").append(super.getClass().getName()).log();
    }

    @Override
    public void liValueListFileStatus(int n, int n2, String string) {
        ServiceManager.logger.warn(16384).append("unexpected liValueListFileStatus answers in ").append(super.getClass().getName()).log();
    }

    @Override
    public void liValueListOutputMethod(int n) {
        ServiceManager.logger.warn(16384).append("unexpected liValueListOutputMethod answers in ").append(super.getClass().getName()).log();
    }

    @Override
    public void locationToStreamResult(boolean bl, byte[] byArray) {
        ServiceManager.logger.warn(16384).append("unexpected locationToStreamResult answers in ").append(super.getClass().getName()).log();
    }

    @Override
    public void poiValueList(LIValueList lIValueList, long l) {
        ServiceManager.logger.warn(16384).append("unexpected poiValueList answers in ").append(super.getClass().getName()).log();
    }

    @Override
    public void requestCountryInfoResult(CountryInfo countryInfo, int n) {
        ServiceManager.logger.warn(16384).append("unexpected requestCountryInfoResult answers in ").append(super.getClass().getName()).log();
    }

    @Override
    public void responseAudioTrigger(int n) {
        ServiceManager.logger.warn(16384).append("unexpected responseAudioTrigger answers in ").append(super.getClass().getName()).log();
    }

    @Override
    public void rgException(int n) {
        ServiceManager.logger.warn(16384).append("unexpected rgException answers in ").append(super.getClass().getName()).log();
    }

    @Override
    public void rgNotPossible(int n) {
        ServiceManager.logger.warn(16384).append("unexpected rgNotPossible answers in ").append(super.getClass().getName()).log();
    }

    @Override
    public void rgSetRouteGuidanceModeResult() {
        ServiceManager.logger.warn(16384).append("unexpected rgSetRouteGuidanceModeResult answers in ").append(super.getClass().getName()).log();
    }

    @Override
    public void rgStartGuidanceCalculatedRouteResult(int n) {
        ServiceManager.logger.warn(16384).append("unexpected rgStartGuidanceCalculatedRouteResult answers in ").append(super.getClass().getName()).log();
    }

    @Override
    public void rmMakeRoutePersistentResult(long l) {
        ServiceManager.logger.warn(16384).append("unexpected rmMakeRoutePersistentResult answers in ").append(super.getClass().getName()).log();
    }

    @Override
    public void rmRouteAddResult(int n, long l) {
        ServiceManager.logger.warn(16384).append("unexpected rmRouteAddResult answers in ").append(super.getClass().getName()).log();
    }

    @Override
    public void rmRouteDeleteAllResult(int n) {
        ServiceManager.logger.warn(16384).append("unexpected rmRouteDeleteAllResult answers in ").append(super.getClass().getName()).log();
    }

    @Override
    public void rmRouteDeleteResult(int n) {
        ServiceManager.logger.warn(16384).append("unexpected rmRouteDeleteResult answers in ").append(super.getClass().getName()).log();
    }

    @Override
    public void rmRouteGetResult(int n, Route route) {
        ServiceManager.logger.warn(16384).append("unexpected rmRouteGetResult answers in ").append(super.getClass().getName()).log();
    }

    @Override
    public void rmRouteRenameResult(int n) {
        ServiceManager.logger.warn(16384).append("unexpected rmRouteRenameResult answers in ").append(super.getClass().getName()).log();
    }

    @Override
    public void setRemainingRangeOfVehicleResult(int n) {
        ServiceManager.logger.warn(16384).append("unexpected setRemainingRangeOfVehicleResult answers in ").append(super.getClass().getName()).log();
    }

    @Override
    public void setTrailerStatusResult(int n) {
        ServiceManager.logger.warn(16384).append("unexpected setTrailerStatusResult answers in ").append(super.getClass().getName()).log();
    }

    @Override
    public void setUserDefinedPOIsResult(int n) {
        ServiceManager.logger.warn(16384).append("unexpected setUserDefinedPOIsResult answers in ").append(super.getClass().getName()).log();
    }

    @Override
    public void setVehicleConsumptionInfoResult(int n) {
        ServiceManager.logger.warn(16384).append("unexpected setVehicleConsumptionInfoResult answers in ").append(super.getClass().getName()).log();
    }

    @Override
    public void soPosPositionDescriptionVehicleResult(NavLocation navLocation) {
        ServiceManager.logger.warn(16384).append("unexpected soPosPositionDescriptionVehicleResult answers in ").append(super.getClass().getName()).log();
    }

    @Override
    public void streamToLocationResult(boolean bl, NavLocation navLocation) {
        ServiceManager.logger.warn(16384).append("unexpected streamToLocationResult answers in ").append(super.getClass().getName()).log();
    }

    @Override
    public void translateRouteResult(Route route) {
        ServiceManager.logger.warn(16384).append("unexpected translateRouteResult answers in ").append(super.getClass().getName()).log();
    }

    @Override
    public void trDeleteAllTracesResult(int n, int n2) {
        ServiceManager.logger.warn(16384).append("unexpected trDeleteAllTracesResult answers in ").append(super.getClass().getName()).log();
    }

    @Override
    public void trDeleteTraceResult(int n, int n2) {
        ServiceManager.logger.warn(16384).append("unexpected trDeleteTraceResult answers in ").append(super.getClass().getName()).log();
    }

    @Override
    public void trRenameTraceResult(int n, int n2) {
        ServiceManager.logger.warn(16384).append("unexpected trRenameTraceResult answers in ").append(super.getClass().getName()).log();
    }

    @Override
    public void trStartTraceRecordingResult(int n, long l, int n2) {
        ServiceManager.logger.warn(16384).append("unexpected trStartTraceRecordingResult answers in ").append(super.getClass().getName()).log();
    }

    @Override
    public void trStopTraceRecordingResult(int n, long l, int n2) {
        ServiceManager.logger.warn(16384).append("unexpected trStopTraceRecordingResult answers in ").append(super.getClass().getName()).log();
    }

    @Override
    public void trStoreTraceResult(int n, NavSegmentID navSegmentID, int n2) {
        ServiceManager.logger.warn(16384).append("unexpected trStoreTraceResult answers in ").append(super.getClass().getName()).log();
    }

    @Override
    public void updateAfaMode(int n, int n2) {
    }

    @Override
    public void updateAfaSpeaking(boolean bl, int n) {
    }

    @Override
    public void updateAudioRequest(int n, int n2) {
    }

    @Override
    public void updateAvailableLanguages(String[] stringArray, int n) {
    }

    @Override
    public void updateBapManeuverDescriptor(BapManeuverDescriptor[] bapManeuverDescriptorArray, int n) {
    }

    @Override
    public void updateBapTurnToInfo(BapTurnToInfo[] bapTurnToInfoArray, int n) {
    }

    public void updateCityVignettes(int[] nArray, int n) {
    }

    @Override
    public void updateCountryInfo(CountryInfo[] countryInfoArray, int n) {
    }

    public void updateCountryVignettes(int[] nArray, int n) {
    }

    @Override
    public void updateDistanceToNextManeuver(DistanceToNextManeuver distanceToNextManeuver, int n) {
    }

    @Override
    public void updateDmFlagDestination(NavLocation navLocation, int n) {
    }

    @Override
    public void updateDmLastDestinationsList(LDListElement[] lDListElementArray, int n) {
    }

    @Override
    public void updateDmRecentRoutesList(RRListElement[] rRListElementArray, int n) {
    }

    @Override
    public void updateEtcAvailableNavDataBases(NavDataBase[] navDataBaseArray, int n) {
    }

    @Override
    public void updateEtcCurrentNavDataBase(NavDataBase navDataBase, int n) {
    }

    @Override
    public void updateEtcDemoModeState(boolean bl, int n) {
    }

    @Override
    public void updateEtcLanguageLoadProgress(long l, int n) {
    }

    @Override
    public void updateEtcLanguageLoadStatus(int n, int n2) {
    }

    @Override
    public void updateEtcMetricSystem(int n, int n2) {
    }

    @Override
    public void updateEtcVersionInfo(NavVersionInfo navVersionInfo, int n) {
    }

    @Override
    public void updateLanguage(String string, int n) {
    }

    @Override
    public void updateLiCityHistory(LICityHistoryEntry[] lICityHistoryEntryArray, int n) {
    }

    @Override
    public void updateLiCountryForCityAndStreetHistory(String string, int n) {
    }

    @Override
    public void updateLispIsSpellerActive(boolean bl, int n) {
    }

    @Override
    public void updateLiStreetHistory(LIStreetHistoryEntry[] lIStreetHistoryEntryArray, int n) {
    }

    @Override
    public void updateLIThesaurusHistory(ThesaurusHistoryEntry[] thesaurusHistoryEntryArray, int n) {
    }

    @Override
    public void updateNavMedia(String[] stringArray, int n) {
    }

    @Override
    public void updateNavstateOfOperation(int n, int n2) {
    }

    @Override
    public void updatePoiSubstringSearchStatus(ValueListStatus valueListStatus, int n) {
    }

    @Override
    public void updateRgActive(boolean bl, int n) {
    }

    @Override
    public void updateRgCalculatedRoutes(CalculatedRouteListElement[] calculatedRouteListElementArray, int n) {
    }

    @Override
    public void updateRgCurrentRoute(Route route, int n) {
    }

    @Override
    public void updateRgCurrentRouteOptions(RouteOptions routeOptions, int n) {
    }

    @Override
    public void updateRgDestinationInfo(NavRouteListData[] navRouteListDataArray, int n) {
    }

    @Override
    public void updateRgDetailedStreetList(NavRouteListData[] navRouteListDataArray, int n) {
    }

    @Override
    public void updateRgInfoForNextDestination(RgInfoForNextDestination rgInfoForNextDestination, int n) {
    }

    @Override
    public void updateRgiString(short[] sArray, int n) {
    }

    @Override
    public void updateRgLaneGuidance(NavLaneGuidanceData[] navLaneGuidanceDataArray, boolean bl, int n) {
    }

    @Override
    public void updateRgPoiInfo(NavPoiInfo[] navPoiInfoArray, int n) {
    }

    @Override
    public void updateRgPoiInfoCalculationHorizon(long l, int n) {
    }

    @Override
    public void updateRgRouteCalculationState(int n, int n2) {
    }

    @Override
    public void updateRgRouteCostChangeInformation(RgRouteCostChangeInformation rgRouteCostChangeInformation, int n) {
    }

    @Override
    public void updateRgRouteProperties(RouteProperties routeProperties, int n) {
    }

    @Override
    public void updateRgStreetList(NavRouteListData[] navRouteListDataArray, int n) {
    }

    @Override
    public void updateRgTimeAfaToDestination(long l, int n) {
    }

    @Override
    public void updateRgTurnList(TurnListElement[] turnListElementArray, int n) {
    }

    @Override
    public void updateRgTurnListCalculationHorizon(long l, int n) {
    }

    @Override
    public void updateRgTurnToStreet(String string, boolean bl, int n) {
    }

    @Override
    public void updateRgUnfulfilledRouteOptions(RouteOptions routeOptions, int n) {
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
    public void updateSoPosPosition(PosPosition posPosition, int n) {
    }

    @Override
    public void updateSoPosPositionDescription(NavLocation navLocation, boolean bl, int n) {
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
        if (n2 == this.req_type) {
            this.asyncException_errorCode = n;
            this.asyncException_errorMsg = string;
            this.asyncException_requestType = n2;
            this.answerSum = -1;
            this.checkAnswerSum(0);
        }
    }

    @Override
    public void updateRouteResumePossible(boolean bl, int n) {
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

    public long getTimeStarted() {
        return this.timeStarted;
    }

    public void setTimeStarted(long l) {
        this.timeStarted = l;
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
    }

    @Override
    public void updateNavDbRegionsState(int n, String[] stringArray, int n2) {
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
    }

    @Override
    public void etcSetDemoModeResult(int n) {
    }

    @Override
    public void lispGetLocationFromLiValueListResult(int n, NavLocation navLocation) {
    }

    @Override
    public void trImportTrailsResult(NavSegmentID[] navSegmentIDArray, int n) {
    }

    @Override
    public void liGetLocationDescriptionTransformNearByResult(NavLocation navLocation) {
    }

    @Override
    public void poiGetXt9LDBsResult(String[] stringArray) {
    }

    @Override
    public void rgTriggerRCCIUpdateResult(int n) {
    }

    @Override
    public void updateRgMotorwayInfo(NavPoiInfo[] navPoiInfoArray, int n) {
    }

    @Override
    public void updateRgTurnToInfo(RgTurnToInfo rgTurnToInfo, int n) {
    }

    @Override
    public void updateRgVirtualDestinationInfo(RgInfoForNextDestination rgInfoForNextDestination, int n) {
    }

    @Override
    public void poiGetCategoryTypesFromUIdResult(int[] nArray) {
    }

    @Override
    public void liDisambiguateLocationResult(int[] nArray, NavLocation[] navLocationArray) {
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
}

