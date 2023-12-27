/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.shield.transformer;

import de.vw.mib.asl.api.navigation.util.ASLNavigationUtilFactory;
import de.vw.mib.asl.api.online.ASLOnlineFactory;
import de.vw.mib.asl.framework.internal.framework.util.StringUtil;
import de.vw.mib.asl.internal.navigation.caching.CacheClient;
import de.vw.mib.asl.internal.navigation.caching.IconKey;
import de.vw.mib.asl.internal.navigation.shield.transformer.ShieldCollector$ShieldOnlineResultIconListener;
import de.vw.mib.properties.values.FixFormatterFieldData;
import org.dsi.ifc.global.NavLocation;
import org.dsi.ifc.global.ResourceLocator;
import org.dsi.ifc.search.SearchResult;
import org.dsi.ifc.search.Token;

public class ShieldCollector
implements CacheClient {
    public int id;
    public FixFormatterFieldData fieldData;
    public float lat;
    public float lon;
    public int directionArrowIndex;
    public SearchResult res;
    public NavLocation searchLocation;
    public NavLocation navLocation;
    public NavLocation fakeNavLocation;
    public String nearString;
    public boolean isOnlineResult;
    public int subIconIndex;
    public ResourceLocator resourceLocator;

    public ShieldCollector(SearchResult searchResult, NavLocation navLocation, NavLocation navLocation2, boolean bl, int n) {
        Token[] tokenArray = searchResult.getTokens();
        this.nearString = "";
        for (int i2 = 0; i2 < tokenArray.length; ++i2) {
            if (null == tokenArray[i2] || tokenArray[i2].wordType != 80) continue;
            this.nearString = tokenArray[i2].token;
            break;
        }
        this.res = searchResult;
        this.navLocation = navLocation2;
        this.id = searchResult.getListPosition();
        this.fieldData = ASLNavigationUtilFactory.getNavigationUtilApi().prepareFixFormatterFieldData(searchResult);
        this.lat = searchResult.position.lat;
        this.lon = searchResult.position.lon;
        this.searchLocation = ASLNavigationUtilFactory.getNavigationUtilApi().cloneLocation(navLocation);
        this.isOnlineResult = bl;
        this.subIconIndex = n;
        if (navLocation != null) {
            this.recalculatedDirection();
        }
        this.requestIcon(searchResult, navLocation2, bl, n);
    }

    public void requestOnlineIcon() {
        if (this.isOnlineResult && this.fakeNavLocation != null) {
            this.requestIcon(this.res, this.fakeNavLocation, this.isOnlineResult, this.subIconIndex);
        }
    }

    private void requestIcon(SearchResult searchResult, NavLocation navLocation, boolean bl, int n) {
        if (bl) {
            if (!StringUtil.isEmpty(navLocation.proprietaryData[9].data)) {
                ShieldCollector$ShieldOnlineResultIconListener shieldCollector$ShieldOnlineResultIconListener = new ShieldCollector$ShieldOnlineResultIconListener(this, this, this.id);
                String string = ASLOnlineFactory.getOnlineCoreServices().getServiceIDWithNumericServiceID(4);
                ResourceLocator resourceLocator = ASLOnlineFactory.getOnlineCoreServices().getOnlineImage(0, string, 3, navLocation.proprietaryData[9].data, null, shieldCollector$ShieldOnlineResultIconListener);
                if (resourceLocator != null) {
                    this.resourceLocator = resourceLocator;
                }
            }
        } else {
            this.resourceLocator = searchResult.entryType == 2 ? ASLNavigationUtilFactory.getNavigationUtilApi().getCacheHandler().resourceIdForPOIIconFromRawData(0, searchResult.getPoiType(), 0, this, this) : ASLNavigationUtilFactory.getNavigationUtilApi().getCacheHandler().resourceIdForPOIIcon(searchResult.iconID, n, 0, this, this);
        }
    }

    public void recalculatedDirection() {
        this.directionArrowIndex = ASLNavigationUtilFactory.getNavigationUtilApi().getNaviHelper().calculateDirectionIndex(this.searchLocation.getLongitude(), this.searchLocation.getLatitude(), ASLNavigationUtilFactory.getNavigationUtilApi().decimalToDsi(this.lon), ASLNavigationUtilFactory.getNavigationUtilApi().decimalToDsi(this.lat), ASLNavigationUtilFactory.getNavigationUtilApi().getNavGateway().getSoPosPosition().getDirectionAngle());
    }

    public int getIconId() {
        switch (this.res.getSource()) {
            case -101: {
                return 5;
            }
            case 4: {
                if (this.res.getEntryType() == 2) {
                    return 9;
                }
                return 8;
            }
        }
        if (this.res.getSource() == -100) {
            switch (this.res.entryType) {
                case 16: {
                    return 0;
                }
                case 2: {
                    return 6;
                }
            }
            return 0;
        }
        if (this.res.getSource() == 16) {
            switch (this.res.entryType) {
                case 16: {
                    return 1;
                }
                case 4: {
                    return 2;
                }
                case 32: {
                    return 3;
                }
                case 64: {
                    return 7;
                }
                case 2: {
                    return 4;
                }
            }
        }
        return 2;
    }

    public int getSourceOfEntry() {
        return this.res.source;
    }

    public SearchResult getSearchResult() {
        return this.res;
    }

    @Override
    public void handleIconCacheUpdate(IconKey iconKey, ResourceLocator resourceLocator, Object object) {
        if (resourceLocator != null) {
            this.resourceLocator = resourceLocator;
        }
    }

    @Override
    public ResourceLocator getDefaultIcon() {
        return null;
    }
}

