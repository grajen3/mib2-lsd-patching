/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.poi.onboard;

import de.vw.mib.asl.api.navigation.ILocationWrapper;
import de.vw.mib.asl.api.navigation.util.ASLNavigationUtilFactory;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.navigation.util.LocationWrapper;
import de.vw.mib.properties.values.SpellerData;
import java.util.Hashtable;

public final class PoiDatapool {
    private static final PoiDatapool INSTANCE = new PoiDatapool();
    static final int DISTANCE_CORRECTION_THRESHOLD;
    static final int USECASE_UNDEFINED;
    static final int USECASE_POI_STACK;
    static final int USECASE_ADMINISTRAVIVE_SEARCH_SINGLE_POI_FROM_MAP;
    static final int USECASE_SURROUNDING_SEARCH_TOP_POIS;
    static final int USECASE_SURROUNDING_SEARCH_FUEL_WARNING_PETROL;
    static final int USECASE_SURROUNDING_SEARCH_FUEL_WARNING_DIESEL;
    static final int USECASE_SURROUNDING_SEARCH_FUEL_WARNING_CNG;
    static final int USECASE_SURROUNDING_SEARCH_FUEL_WARNING_LPG;
    static final int USECASE_SURROUNDING_SEARCH_CHARGING_STATIONS_ALONG_ROUTE;
    static final int USECASE_SURROUNDING_SEARCH_CHARGING_STATIONS_AROUND_CCP;
    static final int USECASE_SURROUNDING_SEARCH;
    static final int USECASE_SURROUNDING_SEARCH_ALONG_ROUTE;
    static final int USECASE_SURROUNDING_SEARCH_BATTERY_WARNING;
    static final int USECASE_SURROUNDING_SEARCH_THESAURUS_ALONG_ROUTE;
    static final int USECASE_SURROUNDING_HYBRID_SEARCH;
    static final int USECASE_SURROUNDING_HYBRID_SEARCH_ALONG_ROUTE;
    static final int USECASE_SURROUNDING_BY_UID_SEARCH;
    static final int USECASE_SURROUNDING_BY_UID_SEARCH_ALONG_ROUTE;
    public static final int USECASE_POI_ADMINISTRATIVE_HYBRID_LIVE_SEARCH;
    public static final int USECASE_SURROUNDING_SEARCH_TOGGLED_TO_ONLINE;
    public static final int USECASE_ADMINISTRATIVE_HYBRID_SEARCH;
    private boolean poiActiveFlag = false;
    private int currentUseCase = -1;
    private int referenceDirection = 0;
    private int remainingBatteryRange = 0;
    private int remainingBatteryRangeFixed = 0;
    private ILocationWrapper ccp = new LocationWrapper();
    private SpellerData spellerData = new SpellerData();
    private String enteredName = "";
    private String filterName = "";
    private String filterNameWithSeparators;
    private String selectedCategoryName = "";
    private int filterCategoryUid = -1;
    private int selectedCategoryUid = -1;
    private int openedCategoryGroupUid = -1;
    private int categoryUidForUidSearch = -1;
    private int lastSearchArea = 1;
    private boolean topPoisActive = false;
    private int mode = 0;
    private boolean isHwrActive = false;
    private ILocationWrapper referenceLocation = ASLNavigationUtilFactory.getNavigationUtilApi().getLocationWrapper();
    private int lastSelectedTopPoiUid = -1;
    private int[] topPoiCategoryUids = new int[]{-1, -1, -1};
    private Hashtable topPoiCategoryNames = new Hashtable();
    private boolean updateModel;
    private ILocationWrapper areaLocation;
    private String[] xt9Databases;
    private String freetextSpellerPreviousInputString = "";
    private final boolean specialSpellerHandlingNeeded = this.checkIfSpecialSpellerHandlingNeeded();

    private PoiDatapool() {
    }

    public static PoiDatapool getInstance() {
        return INSTANCE;
    }

    boolean isPoiActiveFlag() {
        return this.poiActiveFlag;
    }

    void setPoiActiveFlag(boolean bl) {
        this.poiActiveFlag = bl;
    }

    public int getCurrentUseCase() {
        return this.currentUseCase;
    }

    public void setCurrentUseCase(int n) {
        this.currentUseCase = n;
    }

    ILocationWrapper getReferenceLocation() {
        return this.referenceLocation;
    }

    void setReferenceLocation(ILocationWrapper iLocationWrapper) {
        this.referenceLocation = iLocationWrapper;
    }

    int getReferenceDirection() {
        return this.referenceDirection;
    }

    void setReferenceDirection(int n) {
        this.referenceDirection = n;
    }

    ILocationWrapper getAreaLocation() {
        return this.areaLocation;
    }

    void setAreaLocation(ILocationWrapper iLocationWrapper) {
        this.areaLocation = iLocationWrapper;
    }

    int getRemainingBatteryRange() {
        return this.remainingBatteryRange;
    }

    void setRemainingBatteryRange(int n) {
        this.remainingBatteryRange = n;
    }

    int getRemainingBatteryRangeFixed() {
        return this.remainingBatteryRangeFixed;
    }

    void setRemainingBatteryRangeFixed(int n) {
        this.remainingBatteryRangeFixed = n;
    }

    ILocationWrapper getCcp() {
        return this.ccp;
    }

    void setCcp(ILocationWrapper iLocationWrapper) {
        this.ccp = iLocationWrapper;
    }

    SpellerData getSpellerData() {
        return this.spellerData;
    }

    void setSpellerData(SpellerData spellerData) {
        this.spellerData = spellerData;
    }

    public String getEnteredName() {
        return this.enteredName;
    }

    void setEnteredName(String string) {
        this.enteredName = string;
    }

    public String getFilterName() {
        return this.filterName;
    }

    void setFilterName(String string) {
        this.filterName = string;
    }

    String getFilterNameWithSeparators() {
        return this.filterNameWithSeparators;
    }

    void setFilterNameWithSeparators(String string) {
        this.filterNameWithSeparators = string;
    }

    String getSelectedCategoryName() {
        return this.selectedCategoryName;
    }

    void setSelectedCategoryName(String string) {
        this.selectedCategoryName = string;
    }

    int getFilterCategoryUid() {
        return this.filterCategoryUid;
    }

    public void setFilterCategoryUid(int n) {
        this.filterCategoryUid = n;
    }

    int getSelectedCategoryUid() {
        return this.selectedCategoryUid;
    }

    void setSelectedCategoryUid(int n) {
        this.selectedCategoryUid = n;
    }

    int getOpenedCategoryGroupUid() {
        return this.openedCategoryGroupUid;
    }

    void setOpenedCategoryGroupUid(int n) {
        this.openedCategoryGroupUid = n;
    }

    int getLastSearchArea() {
        return this.lastSearchArea;
    }

    void setLastSearchArea(int n) {
        this.lastSearchArea = n;
    }

    boolean isTopPoisActive() {
        return this.topPoisActive;
    }

    void setTopPoisActive(boolean bl) {
        this.topPoisActive = bl;
    }

    int getCategoryUidForUidSearch() {
        return this.categoryUidForUidSearch;
    }

    void setCategoryUidForUidSearch(int n) {
        this.categoryUidForUidSearch = n;
    }

    boolean isHwrActive() {
        return this.isHwrActive;
    }

    void setHwrActive(boolean bl) {
        this.isHwrActive = bl;
    }

    int getFreetextSpellerMode() {
        return this.mode;
    }

    void setFreetextSpellerMode(int n) {
        this.mode = n;
    }

    String[] getXt9Databases() {
        return this.xt9Databases;
    }

    void setXt9Databases(String[] stringArray) {
        this.xt9Databases = stringArray;
    }

    int getLastSelectedTopPoiUid() {
        return this.lastSelectedTopPoiUid;
    }

    void setLastSelectedTopPoiUid(int n) {
        this.lastSelectedTopPoiUid = n;
    }

    int getTopPoiCategoryUid(int n) {
        if (n >= 0 && n < this.topPoiCategoryUids.length) {
            return this.topPoiCategoryUids[n];
        }
        return -1;
    }

    public long[] getTopPoiCategoryUids() {
        long[] lArray = new long[this.topPoiCategoryUids.length];
        for (int i2 = 0; i2 < this.topPoiCategoryUids.length; ++i2) {
            lArray[i2] = this.topPoiCategoryUids[i2];
        }
        return lArray;
    }

    void setTopPoiCategoryUids(int[] nArray) {
        this.topPoiCategoryUids = nArray;
    }

    String getTopPoiCategoryName(int n) {
        String string = (String)this.topPoiCategoryNames.get(new Integer(n));
        if (null != string) {
            return string;
        }
        return "";
    }

    void setTopPoiCategoryName(int n, String string) {
        this.topPoiCategoryNames.put(new Integer(n), string);
    }

    public void setUpdateModel(boolean bl) {
        this.updateModel = bl;
    }

    public boolean isUpdateModel() {
        return this.updateModel;
    }

    public String getFreetextSpellerPreviousInputString() {
        return this.freetextSpellerPreviousInputString;
    }

    public void setFreetextSpellerPreviousInputString(String string) {
        this.freetextSpellerPreviousInputString = string == null ? "" : string;
    }

    private boolean checkIfSpecialSpellerHandlingNeeded() {
        String string = ServiceManager.configManagerDiag.getPureVariant();
        return true == string.startsWith("HIGH2GP_EU") || true == string.startsWith("HIGH2_EU");
    }

    public boolean isSpecialSpellerHandlingNeeded() {
        return this.specialSpellerHandlingNeeded;
    }
}

