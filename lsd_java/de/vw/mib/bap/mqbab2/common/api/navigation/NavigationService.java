/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.mqbab2.common.api.navigation;

import de.vw.mib.bap.mqbab2.common.api.hmi.HMIEventListener;
import de.vw.mib.bap.mqbab2.common.api.hmi.HMIEventService;
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
import java.util.Iterator;

public interface NavigationService
extends HMIEventService {
    default public void addNavigationServiceListener(NavigationServiceListener navigationServiceListener, int[] nArray) {
    }

    default public void removeNavigationServiceListener(NavigationServiceListener navigationServiceListener, int[] nArray) {
    }

    @Override
    default public void addHMIEventListener(HMIEventListener hMIEventListener, int[] nArray) {
    }

    @Override
    default public void removeHMIEventListener(HMIEventListener hMIEventListener, int[] nArray) {
    }

    default public NavigationDestinationInfo getNavigationDestinationInfo() {
    }

    default public int getKombiMapStatus() {
    }

    default public NavigationCurrentAltitude getNavigationCurrentAltitude() {
    }

    default public int getNavigationStatus() {
    }

    default public String getCurrentPositionInfo() {
    }

    default public int getRouteGuidanceState() {
    }

    default public int getNavigationOperationState() {
    }

    default public int getFavoriteDestinationsNumberOfEntries() {
    }

    default public boolean isGPSSignalAvailable() {
    }

    default public boolean isNavigationDemoModeActive() {
    }

    default public boolean isGALRouteGuidanceActive() {
    }

    default public int getActiveMapType() {
    }

    default public NavigationTimeToDestination getTimeToDestination() {
    }

    default public NavigationDistanceToDestination getDistanceToDestination() {
    }

    default public Iterator getManeuverDescriptor() {
    }

    default public NavigationStopoverInfo getStopoverInfo() {
    }

    default public NavigationDistanceToNextManeuver getDistanceToNextManeuver() {
    }

    default public int getVoiceGuidanceStatus() {
    }

    default public int getGuidanceAnnouncementActive() {
    }

    default public Iterator getLaneGuidance() {
    }

    default public boolean isSetupLaneGuidanceActive() {
    }

    default public int getActiveMapView() {
    }

    default public NavigationSupportedMapViews getSupportedMapViews() {
    }

    default public NavigationMapScale getMapScale() {
    }

    default public NavigationSupportedMapTypes getSupportedMapTypes() {
    }

    default public int getActiveMapOrientation() {
    }

    default public NavigationSupportedMapOrientations getSupportedMapOrientations() {
    }

    default public int getOnlineNavigationSystem() {
    }

    default public NavigationOnlineNavigationState getOnlineNavigationState() {
    }

    default public int getNumberOfElementsInFavoriteDestinations() {
    }

    default public Iterator getFavoriteDestinations() {
    }

    default public Iterator getWindowedFavoriteDestinations(int[] nArray) {
    }

    default public Iterator getWindowedCachedFavoriteDestinations(int[] nArray) {
    }

    default public int getTimeToDestinationTimeInfo() {
    }

    default public NavigationRemainingTravelTime getRemainingTravelTime() {
    }

    default public NavigationTurnToInfo getTurnToInfo() {
    }

    default public boolean getSuggestAlternativeRouteCalculation() {
    }

    default public int getNumberOfElementsInLastDestinations() {
    }

    default public Iterator getLastDestinations() {
    }

    default public Iterator getWindowedLastDestinations(int[] nArray) {
    }

    default public Iterator getWindowedCachedLastDestinations(int[] nArray) {
    }

    default public int getCompassInfoAngle() {
    }

    default public int getTMCSymbol() {
    }

    default public Iterator getTMCInfos() {
    }

    default public boolean isTMCSignalAvailable() {
    }

    default public boolean isVISCSignalAvailable() {
    }

    default public int getNavigationServiceState() {
    }

    default public int getKombiMapVisibility() {
    }

    default public int getMapSwitchState() {
    }

    default public int getMapVisibilityInAbt() {
    }

    default public void setMapSwitchState(int n) {
    }

    default public void setVoiceGuidanceStatus(int n) {
    }

    default public void repeatLastNavAnnouncement() {
    }

    default public void stopCurrentNavAnnouncement() {
    }

    default public void startRouteGuidance(int n, long l) {
    }

    default public void stopRouteGuidance() {
    }

    default public void setxUrgentTMCMessageToRead() {
    }

    default public void setAlternativeRouteCalcSetting(boolean bl) {
    }

    default public void setActiveMapOrientation(int n) {
    }

    default public void setMapScaleSteps(int n) {
    }

    default public void setMapScaleSteps(int n, int n2) {
    }

    default public void setActiveMapType(int n) {
    }

    default public void setActiveMapView(int n) {
    }

    default public boolean isMapTemporarilyInABT() {
    }
}

