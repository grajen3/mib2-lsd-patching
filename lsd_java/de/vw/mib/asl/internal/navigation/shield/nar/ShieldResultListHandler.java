/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.shield.nar;

import de.vw.mib.asl.api.navigation.ILocationWrapper;
import de.vw.mib.asl.api.navigation.util.ASLNavigationUtilFactory;
import de.vw.mib.asl.framework.internal.framework.util.StringUtil;
import de.vw.mib.asl.internal.navigation.shield.nar.SearchResultComparator;
import de.vw.mib.asl.internal.navigation.shield.nar.TargetShield;
import de.vw.mib.asl.internal.navigation.shield.transformer.ShieldCollector;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Vector;
import org.dsi.ifc.global.NavLocation;
import org.dsi.ifc.global.NavLocationDescriptor;
import org.dsi.ifc.search.Country;
import org.dsi.ifc.search.Highlight;
import org.dsi.ifc.search.NavPosition;
import org.dsi.ifc.search.SearchResult;
import org.dsi.ifc.search.Suggestion;
import org.dsi.ifc.search.Token;

public class ShieldResultListHandler {
    private LinkedHashMap searchResults = new LinkedHashMap();
    private List frozenSearchResults = new Vector();
    private LinkedHashMap lastDestsLocations = new LinkedHashMap();
    private final TargetShield targetShield;
    private boolean isOnlineResultList;
    private boolean isExternalResultList;

    public ShieldResultListHandler(TargetShield targetShield) {
        this.targetShield = targetShield;
    }

    private Collection getSortedResults(Collection collection) {
        SearchResultComparator searchResultComparator = new SearchResultComparator();
        ArrayList arrayList = new ArrayList(collection);
        Collections.sort(arrayList, searchResultComparator);
        return arrayList;
    }

    public void freezeResultList() {
        ArrayList arrayList = new ArrayList(this.searchResults.values());
        this.frozenSearchResults = (List)this.getSortedResults(Collections.synchronizedList(arrayList));
    }

    public Collection getFrozenResults() {
        return this.getFrozenSearchResults();
    }

    public void setSearchResults(Vector vector, NavLocation navLocation, boolean bl) {
        this.isOnlineResultList = bl;
        this.isExternalResultList = true;
        this.searchResults.clear();
        for (int i2 = 0; i2 < vector.size(); ++i2) {
            ShieldCollector shieldCollector = this.getShieldCollectorFromPoiNavLocation((NavLocation)vector.get(i2), navLocation);
            this.searchResults.put(new Integer(shieldCollector.id), shieldCollector);
        }
        this.freezeResultList();
    }

    private ShieldCollector getShieldCollectorFromPoiNavLocation(NavLocation navLocation, NavLocation navLocation2) {
        ILocationWrapper iLocationWrapper = ASLNavigationUtilFactory.getNavigationUtilApi().getLocationWrapper(navLocation);
        float f2 = (float)((double)iLocationWrapper.getLatitude() / 1.1930464E7);
        float f3 = (float)((double)iLocationWrapper.getLongitude() / 1.1930464E7);
        NavPosition navPosition = new NavPosition(f2, f3);
        Token[] tokenArray = new Token[13];
        Highlight[] highlightArray = new Highlight[]{};
        tokenArray[9] = this.getTokenForField(5, navLocation.proprietaryData[0].data, highlightArray);
        tokenArray[10] = this.getTokenForField(11, iLocationWrapper.getPhonenumber(), highlightArray);
        int n = new Integer(navLocation.proprietaryData[1].data);
        int n2 = new Integer(navLocation.proprietaryData[2].data);
        int n3 = new Integer(navLocation.proprietaryData[4].data);
        int n4 = new Integer(navLocation.proprietaryData[5].data);
        SearchResult searchResult = new SearchResult(0, 16, n4, 1, 0, 0, n, navPosition, n3, 0L, tokenArray, new Suggestion(), new Country(), new byte[0]);
        ShieldCollector shieldCollector = new ShieldCollector(searchResult, navLocation2, navLocation, this.isOnlineResultList, n2);
        return shieldCollector;
    }

    private Token getTokenForField(int n, String string, Highlight[] highlightArray) {
        if (string.length() > 0) {
            return new Token(n, string, highlightArray);
        }
        return null;
    }

    private ShieldCollector getShieldCollectorFromNavLocation(NavLocation navLocation, int n) {
        ILocationWrapper iLocationWrapper = ASLNavigationUtilFactory.getNavigationUtilApi().getLocationWrapper(navLocation);
        NavPosition navPosition = new NavPosition((float)ASLNavigationUtilFactory.getNavigationUtilApi().dsiToDecimal(iLocationWrapper.getLatitude()), (float)ASLNavigationUtilFactory.getNavigationUtilApi().dsiToDecimal(iLocationWrapper.getLongitude()));
        Token[] tokenArray = new Token[15];
        Highlight[] highlightArray = new Highlight[]{};
        tokenArray[0] = this.getTokenForField(17, iLocationWrapper.getCountry(), highlightArray);
        tokenArray[1] = this.getTokenForField(6, iLocationWrapper.getState(), highlightArray);
        tokenArray[2] = this.getTokenForField(4, iLocationWrapper.getPostalCode(), highlightArray);
        tokenArray[3] = this.getTokenForField(1, iLocationWrapper.getCity(), highlightArray);
        tokenArray[4] = this.getTokenForField(3, iLocationWrapper.getStreet(), highlightArray);
        tokenArray[5] = this.getTokenForField(7, iLocationWrapper.getHousenumber(), highlightArray);
        tokenArray[6] = this.getTokenForField(103, iLocationWrapper.getCrossing(), highlightArray);
        tokenArray[7] = this.getTokenForField(2, iLocationWrapper.getCityRefinement(), highlightArray);
        tokenArray[8] = this.getTokenForField(12, iLocationWrapper.getPoiCategory(), highlightArray);
        tokenArray[9] = this.getTokenForField(5, iLocationWrapper.getPoiName(), highlightArray);
        tokenArray[10] = this.getTokenForField(11, iLocationWrapper.getPhonenumber(), highlightArray);
        if (iLocationWrapper.getMmiInternalDataValue(1).length() > 0) {
            Token token;
            tokenArray[11] = token = new Token(22, iLocationWrapper.getMmiInternalDataValue(1), highlightArray);
        }
        tokenArray[12] = new Token(23, iLocationWrapper.getWard(), highlightArray);
        tokenArray[13] = new Token(24, iLocationWrapper.getChome(), highlightArray);
        tokenArray[14] = new Token(25, iLocationWrapper.getPlace(), highlightArray);
        int n2 = 3;
        if (iLocationWrapper.isCityCenter()) {
            n2 = 16;
        }
        int n3 = -100;
        if (iLocationWrapper.getLocationDSIType() == 2 && StringUtil.isEmpty(iLocationWrapper.getMmiInternalDataValue(3))) {
            n3 = -101;
        }
        SearchResult searchResult = new SearchResult(0, n3, n, n2, 0, 0, iLocationWrapper.getIconIndex(), navPosition, 0, 0L, tokenArray, new Suggestion(), new Country(), new byte[0]);
        if (TargetShield.logger.isTraceEnabled()) {
            TargetShield.logger.trace(new StringBuffer().append("Converted NavLocation to SearchResult is: ").append(searchResult.toString()).toString());
        }
        return new ShieldCollector(searchResult, this.targetShield.currentSearchPosition, navLocation, false, 0);
    }

    public Collection getSearchResults() {
        return this.getSortedResults(this.searchResults.values());
    }

    public SearchResult getFirstResult() {
        Object object = this.getSortedResults(this.searchResults.values()).iterator().next();
        if (object == null) {
            return null;
        }
        return ((ShieldCollector)object).res;
    }

    public void clear() {
        this.isOnlineResultList = false;
        this.isExternalResultList = false;
        this.searchResults.clear();
        this.frozenSearchResults.clear();
    }

    public void updateLastDests(NavLocation navLocation) {
        this.lastDestsLocations.put(this.getShieldCollectorFromNavLocation(navLocation, this.lastDestsLocations.size()), navLocation);
    }

    public void clearLastDests() {
        this.lastDestsLocations.clear();
    }

    public void addSearchResult(SearchResult searchResult, NavLocation navLocation) {
        this.isOnlineResultList = false;
        this.isExternalResultList = false;
        int n = ASLNavigationUtilFactory.getNavigationUtilApi().getNaviHelper().decimalToDsi(searchResult.position.lat);
        int n2 = ASLNavigationUtilFactory.getNavigationUtilApi().getNaviHelper().decimalToDsi(searchResult.position.lon);
        NavLocation navLocation2 = ASLNavigationUtilFactory.getNavigationUtilApi().getLocationWrapper(n, n2).getLocation();
        navLocation2.positionValid = true;
        navLocation2.proprietaryData = new NavLocationDescriptor[]{new NavLocationDescriptor(), new NavLocationDescriptor(), new NavLocationDescriptor(), new NavLocationDescriptor(), new NavLocationDescriptor(), new NavLocationDescriptor(), new NavLocationDescriptor(), new NavLocationDescriptor(), new NavLocationDescriptor()};
        navLocation2.proprietaryData[8].selectionCriterion = 0;
        navLocation2.proprietaryData[8].data = new Integer(this.targetShield.getTargetId()).toString();
        ShieldCollector shieldCollector = new ShieldCollector(searchResult, navLocation, navLocation2, false, 0);
        this.searchResults.put(new Integer(searchResult.getListPosition()), shieldCollector);
    }

    public List getFrozenSearchResults() {
        return this.frozenSearchResults;
    }

    public boolean isNextPageAvailable() {
        return this.frozenSearchResults.size() > 0 && this.searchResults.size() > this.frozenSearchResults.size();
    }

    public NavLocation getLastDest(ShieldCollector shieldCollector) {
        return (NavLocation)this.lastDestsLocations.get(shieldCollector);
    }

    public ShieldCollector getSearchResult(int n) {
        return (ShieldCollector)this.searchResults.get(new Integer(n));
    }

    public Collection getLastDests() {
        return this.getSortedResults(this.lastDestsLocations.keySet());
    }

    public boolean isOnlineResultList() {
        return this.isOnlineResultList;
    }

    public boolean isExternalResultList() {
        return this.isExternalResultList;
    }

    public void setExternalResultList(boolean bl) {
        this.isExternalResultList = bl;
    }

    public Collection getSubList(int n, int n2) {
        if (n < 0 || n2 < 0 || n > this.getFrozenResults().size() || n2 > this.getFrozenResults().size()) {
            TargetShield.printTrace("handleAllSearchResultsResolved: Error getting sublist. sublist start/end out of resultlist. Setting flags for the first entries.");
            n2 = this.getFrozenResults().size();
            if (n2 > 5) {
                n2 = 5;
            }
            return this.getFrozenSearchResults().subList(0, n2);
        }
        return this.getFrozenSearchResults().subList(n, n2);
    }

    public void setSearchResult(NavLocation navLocation, int n, NavLocation navLocation2, NavLocation navLocation3, boolean bl) {
        this.isOnlineResultList = bl;
        this.isExternalResultList = true;
        if (n == 0) {
            this.searchResults.clear();
        }
        ShieldCollector shieldCollector = this.getShieldCollectorFromNavLocation(navLocation2, n);
        this.adaptCollector(navLocation, shieldCollector);
        this.searchResults.put(new Integer(shieldCollector.id), shieldCollector);
        this.freezeResultList();
    }

    private void adaptCollector(NavLocation navLocation, ShieldCollector shieldCollector) {
        NavPosition navPosition;
        shieldCollector.fakeNavLocation = navLocation;
        shieldCollector.isOnlineResult = this.isOnlineResultList;
        SearchResult searchResult = shieldCollector.getSearchResult();
        searchResult.source = 16;
        searchResult.entryType = 2;
        Token[] tokenArray = searchResult.tokens;
        Highlight[] highlightArray = new Highlight[]{};
        tokenArray[9] = this.getTokenForField(5, navLocation.proprietaryData[0].data, highlightArray);
        ILocationWrapper iLocationWrapper = ASLNavigationUtilFactory.getNavigationUtilApi().getLocationWrapper(navLocation);
        tokenArray[10] = this.getTokenForField(11, iLocationWrapper.getPhonenumber(), highlightArray);
        float f2 = (float)((double)iLocationWrapper.getLatitude() / 1.1930464E7);
        float f3 = (float)((double)iLocationWrapper.getLongitude() / 1.1930464E7);
        searchResult.position = navPosition = new NavPosition(f2, f3);
        searchResult.iconID = new Integer(navLocation.proprietaryData[1].data);
        searchResult.distanceMeters = new Integer(navLocation.proprietaryData[4].data);
        shieldCollector.subIconIndex = new Integer(navLocation.proprietaryData[2].data);
        shieldCollector.fieldData = ASLNavigationUtilFactory.getNavigationUtilApi().prepareFixFormatterFieldData(searchResult);
        shieldCollector.requestOnlineIcon();
    }
}

