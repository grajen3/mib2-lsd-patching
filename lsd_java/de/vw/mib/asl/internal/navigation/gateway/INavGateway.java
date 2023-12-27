/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.gateway;

import de.vw.mib.asl.internal.navigation.gateway.Command;
import de.vw.mib.genericevents.GenericEvents;
import org.dsi.ifc.global.NavLocation;
import org.dsi.ifc.navigation.BapManeuverDescriptor;
import org.dsi.ifc.navigation.BapTurnToInfo;
import org.dsi.ifc.navigation.CalculatedRouteListElement;
import org.dsi.ifc.navigation.CountryInfo;
import org.dsi.ifc.navigation.DSINavigation;
import org.dsi.ifc.navigation.DistanceToNextManeuver;
import org.dsi.ifc.navigation.LDListElement;
import org.dsi.ifc.navigation.LICityHistoryEntry;
import org.dsi.ifc.navigation.LIStreetHistoryEntry;
import org.dsi.ifc.navigation.NavDataBase;
import org.dsi.ifc.navigation.NavLaneGuidanceData;
import org.dsi.ifc.navigation.NavPoiInfo;
import org.dsi.ifc.navigation.NavRouteListData;
import org.dsi.ifc.navigation.NavVersionInfo;
import org.dsi.ifc.navigation.PosPosition;
import org.dsi.ifc.navigation.RRListElement;
import org.dsi.ifc.navigation.RgInfoForNextDestination;
import org.dsi.ifc.navigation.RgRouteCostChangeInformation;
import org.dsi.ifc.navigation.Route;
import org.dsi.ifc.navigation.RouteOptions;
import org.dsi.ifc.navigation.RouteProperties;
import org.dsi.ifc.navigation.ThesaurusHistoryEntry;
import org.dsi.ifc.navigation.TurnListElement;
import org.dsi.ifc.navigation.ValueListStatus;

public interface INavGateway {
    default public DSINavigation getDsiNavigation() {
    }

    default public GenericEvents getMainObject() {
    }

    default public int getAfaMode() {
    }

    default public boolean isAfaModeValid() {
    }

    default public boolean isAfaSpeaking() {
    }

    default public boolean isAfaSpeakingValid() {
    }

    default public int getAudioState() {
    }

    default public boolean isAudioStateValid() {
    }

    default public String[] getAvailableLanguages() {
    }

    default public boolean isAvailableLanguagesValid() {
    }

    default public BapManeuverDescriptor[] getBapManeuverDescriptor() {
    }

    default public boolean isBapManeuverDescriptorValid() {
    }

    default public BapTurnToInfo[] getBapTurnToInfo() {
    }

    default public boolean isBapTurnToInfoValid() {
    }

    default public int[] getCityIndices() {
    }

    default public boolean isCityIndicesValid() {
    }

    default public CountryInfo[] getCountryInfo() {
    }

    default public boolean isCountryInfoValid() {
    }

    default public int[] getCountryIndices() {
    }

    default public boolean isCountryIndicesValid() {
    }

    default public DistanceToNextManeuver getDistanceToNextManeuver() {
    }

    default public boolean isDistanceToNextManeuverValid() {
    }

    default public NavLocation getFlagDestination() {
    }

    default public boolean isFlagDestinationValid() {
    }

    default public LDListElement[] getDmLastDestinationsList() {
    }

    default public boolean isDmLastDestinationsListValid() {
    }

    default public RRListElement[] getDmRecentRoutesList() {
    }

    default public boolean isDmRecentRoutesListValid() {
    }

    default public NavDataBase[] getNavDataBases() {
    }

    default public boolean isNavDataBasesValid() {
    }

    default public NavDataBase getCurrentNavDataBase() {
    }

    default public boolean isCurrentNavDataBaseValid() {
    }

    default public boolean getEtcDemoModeState() {
    }

    default public boolean isEtcDemoModeStateValid() {
    }

    default public long getEtcLanguageLoadProgress() {
    }

    default public boolean isEtcLanguageLoadProgressValid() {
    }

    default public int getEtcLanguageLoadStatus() {
    }

    default public boolean isEtcLanguageLoadStatusValid() {
    }

    default public int getEtcMetricSystem() {
    }

    default public boolean isEtcMetricSystemValid() {
    }

    default public NavVersionInfo getEtcVersionInfo() {
    }

    default public boolean isEtcVersionInfoValid() {
    }

    default public ThesaurusHistoryEntry[] getThesaurusHistory() {
    }

    default public boolean isThesaurusHistoryValid() {
    }

    default public String getLanguage() {
    }

    default public boolean isLanguageValid() {
    }

    default public LICityHistoryEntry[] getCityHistory() {
    }

    default public boolean isCityHistory() {
    }

    default public String getCountryAbbreviation() {
    }

    default public boolean isCountryAbbreviationValid() {
    }

    default public LIStreetHistoryEntry[] getStreetHistory() {
    }

    default public boolean isStreetHistoryValid() {
    }

    default public boolean getLispIsSpellerActive() {
    }

    default public boolean isLispIsSpellerActiveValid() {
    }

    default public String[] getNavMedia() {
    }

    default public boolean isNavMediaValid() {
    }

    default public int getNavstateOfOperation() {
    }

    default public boolean isNavstateOfOperationValid() {
    }

    default public ValueListStatus getPoiSubstringSearchStatus() {
    }

    default public boolean isPoiSubstringSearchStatusValid() {
    }

    default public boolean isRgActive() {
    }

    default public boolean isRgActiveValid() {
    }

    default public CalculatedRouteListElement[] getRgCalculatedRoutes() {
    }

    default public boolean isRgCalculatedRoutesValid() {
    }

    default public Route getRgCurrentRoute() {
    }

    default public boolean isRgCurrentRouteValid() {
    }

    default public RouteOptions getRgCurrentRouteOptions() {
    }

    default public boolean isRgCurrentRouteOptionsValid() {
    }

    default public NavRouteListData[] getRgDestinationInfo() {
    }

    default public boolean isRgDestinationInfoValid() {
    }

    default public NavRouteListData[] getRgDetailedStreetList() {
    }

    default public boolean isRgDetailedStreetListValid() {
    }

    default public RgInfoForNextDestination getRgInfoForNextDestination() {
    }

    default public boolean isRgInfoForNextDestinationValid() {
    }

    default public NavLaneGuidanceData[] getRgLaneGuidance() {
    }

    default public boolean isShowLaneGuidance() {
    }

    default public boolean isRgLaneGuidanceValid() {
    }

    default public NavPoiInfo[] getRgPoiInfo() {
    }

    default public boolean isRgPoiInfoValid() {
    }

    default public long getCalculationHorizon() {
    }

    default public boolean isCalculationHorizonValid() {
    }

    default public int getRgRouteCalculationState() {
    }

    default public boolean isRgRouteCalculationStateValid() {
    }

    default public RgRouteCostChangeInformation getRgRouteCostChangeInformation() {
    }

    default public boolean isRgRouteCostChangeInformationValid() {
    }

    default public RouteProperties getRouteProperties() {
    }

    default public boolean isRoutePropertiesValid() {
    }

    default public NavRouteListData[] getRgStreetList() {
    }

    default public boolean isRgStreetListValid() {
    }

    default public long getRgTimeAfaToDestination() {
    }

    default public boolean isRgTimeAfaToDestinationValid() {
    }

    default public TurnListElement[] getRgTurnList() {
    }

    default public boolean isRgTurnListValid() {
    }

    default public long getTurnListCalculationHorizon() {
    }

    default public boolean isTurnListCalculationHorizonValid() {
    }

    default public PosPosition getSoPosPosition() {
    }

    default public boolean isSoPosPositionValid() {
    }

    default public NavLocation getSoPosPositionDescription() {
    }

    default public boolean isSoPosPositionDescriptionValid() {
    }

    default public boolean isSoPosPositionDescriptionInProgressData() {
    }

    default public void getSpellableCharactersResult(String string, String string2, int n, String string3, int n2) {
    }

    default public void updateLiCityHistory(LICityHistoryEntry[] lICityHistoryEntryArray, int n) {
    }

    default public void updateLiStreetHistory(LIStreetHistoryEntry[] lIStreetHistoryEntryArray, int n) {
    }

    default public void updateLiCountryForCityAndStreetHistory(String string, int n) {
    }

    default public void handleNextCommands() {
    }

    default public void pushCommand(Command command) {
    }

    default public void updateNavstateOfOperation(int n, int n2) {
    }

    default public void setNotification() {
    }
}

