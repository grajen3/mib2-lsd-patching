/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.poi.onboard;

import de.vw.mib.asl.api.navigation.locationinput.IStartupState;
import de.vw.mib.asl.api.navigation.util.ASLNavigationUtilFactory;
import de.vw.mib.asl.internal.navigation.poi.onboard.PoiStateRequestTopCategories;
import org.dsi.ifc.global.NavLocation;

class PoiStateRequestTopCategories$2
implements IStartupState {
    private final /* synthetic */ NavLocation val$resolvedLocation;
    private final /* synthetic */ int[] val$usefulRefinementCriteria;
    private final /* synthetic */ PoiStateRequestTopCategories this$0;

    PoiStateRequestTopCategories$2(PoiStateRequestTopCategories poiStateRequestTopCategories, NavLocation navLocation, int[] nArray) {
        this.this$0 = poiStateRequestTopCategories;
        this.val$resolvedLocation = navLocation;
        this.val$usefulRefinementCriteria = nArray;
    }

    @Override
    public boolean isInputActive() {
        return false;
    }

    @Override
    public boolean isFullPostalCode() {
        return ASLNavigationUtilFactory.getNavigationUtilApi().getLocationWrapper(this.val$resolvedLocation).isFullPostalCode();
    }

    @Override
    public boolean hasPointLocations() {
        return PoiStateRequestTopCategories.access$000(this.this$0, this.val$usefulRefinementCriteria);
    }

    @Override
    public NavLocation getNavLocation() {
        return this.val$resolvedLocation;
    }

    @Override
    public int[] getAvailableSelectionCriteria() {
        return this.val$usefulRefinementCriteria;
    }
}

