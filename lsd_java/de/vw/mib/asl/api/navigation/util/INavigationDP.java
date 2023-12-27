/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.api.navigation.util;

import de.vw.mib.asl.api.navigation.util.IPersistableExtension;
import de.vw.mib.asl.api.navigation.util.IPersonalNaviPersistence;
import de.vw.mib.asl.api.navigation.util.ReloadPersistedDataListener;
import org.dsi.ifc.global.NavLocation;
import org.dsi.ifc.navigation.Route;

public interface INavigationDP {
    default public boolean isWpmClusterShowmaneuver() {
    }

    default public void setWpmClusterShowmaneuver(boolean bl) {
    }

    default public void addReloadPersistedDataListener(ReloadPersistedDataListener reloadPersistedDataListener) {
    }

    default public void removeReloadPersistedDataListener(ReloadPersistedDataListener reloadPersistedDataListener) {
    }

    default public NavLocation getCrosshairLocation() {
    }

    default public Route getCurrentRoute() {
    }

    default public NavLocation getClickInMapLocation() {
    }

    default public NavLocation getDefaultLocation() {
    }

    default public NavLocation getDemoLocation() {
    }

    default public NavLocation getDestInputLocation() {
    }

    default public IPersistableExtension getExtendedNavPersistence() {
    }

    default public NavLocation getExternalLocationInputLocation() {
    }

    default public NavLocation getMapInputLocation() {
    }

    default public NavLocation getMemoryLocation() {
    }

    default public NavLocation getWpmLocation() {
    }

    default public void setWpmLocation(NavLocation navLocation) {
    }

    default public NavLocation getPOILocation() {
    }

    default public int getPoiSearchArea() {
    }

    default public NavLocation getPoiSearchLocation() {
    }

    default public int[] getPreferredBrandUids() {
    }

    default public boolean getRGIsActive() {
    }

    default public NavLocation getRouteInfoLocation() {
    }

    default public NavLocation getSpellerLocation() {
    }

    default public NavLocation getTourmodeLocation() {
    }

    default public Route getTourmodeRoute() {
    }

    default public boolean isMemoryLocationTopDest() {
    }

    default public boolean isSaveCorrectedAddressToEntry() {
    }

    default public boolean isTopPoisHaveBeenLoadedSuccessfully() {
    }

    default public void loadPersistables() {
    }

    default public void setClickInMapLocation(NavLocation navLocation) {
    }

    default public void setCrosshairLocation(NavLocation navLocation) {
    }

    default public void setCurrentRoute(Route route) {
    }

    default public void setDefaultLocation(NavLocation navLocation) {
    }

    default public void setDemoLocation(NavLocation navLocation) {
    }

    default public void setDestInputLocation(NavLocation navLocation) {
    }

    default public void setDestInputLocation(NavLocation navLocation, boolean bl) {
    }

    default public void setExternalLocationInputLocation(NavLocation navLocation) {
    }

    default public void setMapInputLocation(NavLocation navLocation) {
    }

    default public void setMemoryLocation(NavLocation navLocation) {
    }

    default public void setMemoryLocationIsTopDest(boolean bl) {
    }

    default public void setPOILocation(NavLocation navLocation) {
    }

    default public void setPoiSearchArea(int n) {
    }

    default public void setPoiSearchLocation(NavLocation navLocation) {
    }

    default public void setPreferredBrandUids(int[] nArray) {
    }

    default public void setRouteInfoLocation(NavLocation navLocation) {
    }

    default public void setSaveCorrectedAddressToEntry(boolean bl) {
    }

    default public void setSpellerLocation(NavLocation navLocation) {
    }

    default public void setTopPoisHaveBeenLoadedSuccessfully(boolean bl) {
    }

    default public void setTourmodeLocation(NavLocation navLocation) {
    }

    default public void setTourmodeRoute(Route route) {
    }

    default public void setGuidanceType(int n) {
    }

    default public int getGuidanceType() {
    }

    default public boolean isWpmActive() {
    }

    default public void setWpmActive(boolean bl) {
    }

    default public void setWpmMode(int n) {
    }

    default public int getWpmMode() {
    }

    default public IPersonalNaviPersistence getPersonalNaviPersistence() {
    }

    default public boolean isPNavActive() {
    }

    default public void setPNavActive(boolean bl) {
    }

    default public int getLastClamp15OffTime() {
    }

    default public void setLastClamp15OffTime(int n) {
    }

    default public void reloadPersonalNaviPersistence() {
    }

    default public void setOnlineToursAvailable(int n) {
    }

    default public int getOnlineToursAvailable() {
    }

    default public void storeVisibleLocationIDs(int[][] nArray) {
    }

    default public int[][] getVisibleLocationIDs() {
    }

    default public String getPoiJpnCategory() {
    }

    default public void setPoiJpnCategory(String string) {
    }

    default public String getInvalidDestMemLocationAddressParts() {
    }

    default public void setInvalidDestMemLocationAddressParts(String string) {
    }

    default public NavLocation getDetailViewLocation() {
    }

    default public NavLocation getGuidanceInfoLocation() {
    }

    default public NavLocation getTopOfLastDestLocation() {
    }

    default public void setDetailViewLocation(NavLocation navLocation) {
    }

    default public void setGuidanceInfoLocation(NavLocation navLocation) {
    }

    default public void setTopOfLastDestLocation(NavLocation navLocation) {
    }

    default public NavLocation getSldeVicinityLocation() {
    }

    default public void setSldeVicinityLocation(NavLocation navLocation) {
    }

    default public boolean getClamp15On() {
    }

    default public void setClamp15On(boolean bl) {
    }

    default public void setMapExternalConfigured(boolean bl) {
    }

    default public boolean isMapExternalConfigured() {
    }
}

