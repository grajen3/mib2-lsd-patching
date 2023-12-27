/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.poi.transformer;

import de.vw.mib.asl.api.navigation.ILocationWrapper;
import de.vw.mib.asl.api.navigation.util.ASLNavigationUtilFactory;
import de.vw.mib.properties.values.FixFormatterFieldData;
import org.dsi.ifc.global.NavLocation;
import org.dsi.ifc.global.ResourceLocator;

public class PoiResultListCollector {
    public ResourceLocator resourceLocator;
    public String poiName;
    public boolean hasSubListItem;
    public int distance;
    public int directionIndex;
    public boolean insideRange;
    public int iconIndex;
    public int subIconIndex;
    public int latitude;
    public int longitude;
    public int listIndex;
    public NavLocation poiNavLocation;
    public FixFormatterFieldData fieldData;

    public PoiResultListCollector(ResourceLocator resourceLocator, String string, boolean bl, int n, int n2, boolean bl2, int n3) {
        this.resourceLocator = resourceLocator;
        this.poiName = string;
        this.hasSubListItem = bl;
        this.distance = n;
        this.directionIndex = n2;
        this.insideRange = bl2;
        this.listIndex = n3;
    }

    public PoiResultListCollector(int n, int n2, ResourceLocator resourceLocator, String string, boolean bl, int n3, int n4, boolean bl2, int n5, int n6, int n7) {
        this.subIconIndex = n2;
        this.iconIndex = n;
        this.resourceLocator = resourceLocator;
        this.poiName = string;
        this.hasSubListItem = bl;
        this.distance = n3;
        this.directionIndex = n4;
        this.insideRange = bl2;
        this.latitude = n5;
        this.longitude = n6;
        this.listIndex = n7;
    }

    public void updateListItemWithMorePoiDetails(NavLocation navLocation) {
        this.poiNavLocation = navLocation;
        ILocationWrapper iLocationWrapper = ASLNavigationUtilFactory.getNavigationUtilApi().getLocationWrapper(navLocation);
        this.fieldData = ASLNavigationUtilFactory.getNavigationUtilApi().getLocationFormatter().prepareFixFormatterFieldData(iLocationWrapper, this.poiName, iLocationWrapper.getPhonenumber());
    }
}

