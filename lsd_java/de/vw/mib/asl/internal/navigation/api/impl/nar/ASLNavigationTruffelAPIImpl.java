/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.api.impl.nar;

import de.vw.mib.asl.api.navigation.ASLNavigationTruffelAPI;
import de.vw.mib.asl.api.navigation.startup.ASLNavigationContainer;
import de.vw.mib.asl.api.navigation.startup.ASLNavigationStartupFactory;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.navigation.shield.nar.TargetShield;
import de.vw.mib.asl.internal.navigation.slde.SldeSpellerHandler;
import java.util.Collection;
import java.util.Vector;
import org.dsi.ifc.global.NavLocation;
import org.dsi.ifc.search.SearchResult;

public class ASLNavigationTruffelAPIImpl
implements ASLNavigationTruffelAPI,
ASLNavigationContainer {
    private TargetShield shieldTarget;

    public ASLNavigationTruffelAPIImpl() {
        ASLNavigationStartupFactory.getNavigationStartupApi().registerContainer(this);
    }

    @Override
    public void resetSHIELDHousenumber() {
        TargetShield.resetSHIELDHousenumber();
    }

    @Override
    public String getShieldHouseNumber() {
        return TargetShield.housenumber;
    }

    @Override
    public boolean addNavLocationToHistory() {
        return TargetShield.addLocationToHistory;
    }

    @Override
    public NavLocation getNavLocation() {
        return TargetShield.location;
    }

    @Override
    public void setNavLocation(NavLocation navLocation) {
        TargetShield.location = navLocation;
    }

    @Override
    public SearchResult getSearchResult() {
        return TargetShield.selectedSearchResult;
    }

    @Override
    public void spellerTextChanged() {
        if (this.shieldTarget != null) {
            this.shieldTarget.spellerTextChanged();
        }
    }

    @Override
    public void createTargets() {
        this.shieldTarget = new TargetShield(ServiceManager.eventMain, -951380992, "hsmtask");
        ASLNavigationStartupFactory.getNavigationStartupApi().addTarget(4, this.shieldTarget);
        ASLNavigationStartupFactory.getNavigationStartupApi().addTarget(4, SldeSpellerHandler.getInstance());
    }

    @Override
    public void setShieldHouseNumber(String string) {
        TargetShield.setSHIELDHousenumber(string);
    }

    @Override
    public int getLastDestsGeoPos() {
        return -101;
    }

    @Override
    public void setSearchResults(Vector vector, boolean bl, NavLocation navLocation, boolean bl2) {
        if (this.shieldTarget != null) {
            this.shieldTarget.setSearchResults(vector, bl, navLocation, bl2);
        }
    }

    @Override
    public Collection getSearchResults() {
        if (this.shieldTarget != null) {
            return this.shieldTarget.getResultListHandler().getSearchResults();
        }
        return null;
    }

    @Override
    public void switchToResultMapView(boolean bl) {
        if (this.shieldTarget != null) {
            this.shieldTarget.switchToResultMapView(bl);
        }
    }

    @Override
    public void setSelectedSearchResult(NavLocation navLocation, Integer n) {
        if (this.shieldTarget != null) {
            this.shieldTarget.setSelectedSearchResultFromExternal(navLocation, n);
        }
    }

    @Override
    public boolean isWaitingForTryMatchLocationResults() {
        if (this.shieldTarget != null) {
            return this.shieldTarget.isWaitingForTryMatchLocationResults();
        }
        return false;
    }

    @Override
    public void allowReceivingEvents(boolean bl) {
        if (this.shieldTarget != null) {
            this.shieldTarget.setAllowReceivingEvents(bl);
        }
    }

    @Override
    public void stopSearch() {
        if (this.shieldTarget != null) {
            this.shieldTarget.handleCancelSearch();
        }
    }

    @Override
    public Object getSearchResult(int n) {
        if (this.shieldTarget != null) {
            return this.shieldTarget.getResultListHandler().getSearchResult(n);
        }
        return null;
    }

    @Override
    public void initXt9Finished() {
        if (this.shieldTarget != null) {
            this.shieldTarget.initXt9Finished();
        }
    }

    @Override
    public void setSearchResult(NavLocation navLocation, int n, NavLocation navLocation2, boolean bl, NavLocation navLocation3, boolean bl2) {
        if (this.shieldTarget != null) {
            this.shieldTarget.setSearchResult(navLocation, n, navLocation2, bl, navLocation3, bl2);
        }
    }
}

