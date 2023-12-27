/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.spellerx;

import de.vw.mib.asl.api.navigation.ILocationWrapper;
import de.vw.mib.asl.api.navigation.NavigationConfiguration;
import de.vw.mib.asl.api.navigation.locationinput.IHnrFlags;
import de.vw.mib.asl.api.navigation.locationinput.ILocationinputResultListener;
import de.vw.mib.asl.api.navigation.locationinput.SpellerHandler;
import de.vw.mib.asl.api.navigation.spellerx.XSpellerHandlerMap;
import de.vw.mib.asl.api.navigation.util.ASLNavigationUtilFactory;
import de.vw.mib.asl.api.navigation.util.IExtLogger;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.framework.internal.framework.asl.AbstractReflectionContext;
import de.vw.mib.asl.framework.internal.framework.asl.AbstractReflectionHsmTarget;
import de.vw.mib.asl.framework.internal.framework.asl.AbstractReflectionState;
import de.vw.mib.asl.framework.internal.framework.asl.EventNameResolver;
import de.vw.mib.asl.framework.internal.framework.asl.IEvents;
import de.vw.mib.asl.internal.navigation.spellerx.SpellerContext;
import de.vw.mib.asl.internal.navigation.spellerx.SpellerField;
import de.vw.mib.asl.internal.navigation.spellerx.handler.ClickInMapInputHandler;
import de.vw.mib.asl.internal.navigation.spellerx.handler.DefaultSpellerHandler;
import de.vw.mib.asl.internal.navigation.spellerx.handler.DemoInputHandler;
import de.vw.mib.asl.internal.navigation.spellerx.handler.DestInputHandler;
import de.vw.mib.asl.internal.navigation.spellerx.handler.HomeInputHandler;
import de.vw.mib.asl.internal.navigation.spellerx.handler.MapInputHandler;
import de.vw.mib.asl.internal.navigation.spellerx.handler.MemoryInputHandler;
import de.vw.mib.asl.internal.navigation.spellerx.handler.PoiMapInputHandler;
import de.vw.mib.asl.internal.navigation.spellerx.handler.SldeInputHandler;
import de.vw.mib.asl.internal.navigation.spellerx.handler.TourModeInputHandler;
import de.vw.mib.asl.internal.navigation.spellerx.hwr.MatchTextSpellerFilterAdapter;
import de.vw.mib.asl.internal.navigation.spellerx.hwr.NumberSpellerFilterAdapter;
import de.vw.mib.asl.internal.navigation.spellerx.model.ModelListHandler;
import de.vw.mib.asl.internal.navigation.spellerx.states.StateChome;
import de.vw.mib.asl.internal.navigation.spellerx.states.StateCity;
import de.vw.mib.asl.internal.navigation.spellerx.states.StateCountry;
import de.vw.mib.asl.internal.navigation.spellerx.states.StateCrossing;
import de.vw.mib.asl.internal.navigation.spellerx.states.StateHousenumber;
import de.vw.mib.asl.internal.navigation.spellerx.states.StateMapCode;
import de.vw.mib.asl.internal.navigation.spellerx.states.StatePhoneNumber;
import de.vw.mib.asl.internal.navigation.spellerx.states.StatePlace;
import de.vw.mib.asl.internal.navigation.spellerx.states.StatePointLocationHousenumber;
import de.vw.mib.asl.internal.navigation.spellerx.states.StateProvince;
import de.vw.mib.asl.internal.navigation.spellerx.states.StateState;
import de.vw.mib.asl.internal.navigation.spellerx.states.StateStreet;
import de.vw.mib.asl.internal.navigation.spellerx.states.StateStreet1stCity;
import de.vw.mib.asl.internal.navigation.spellerx.states.StateStreet1stStreetWithBasenames;
import de.vw.mib.asl.internal.navigation.spellerx.states.StateStreet1stZipCode;
import de.vw.mib.asl.internal.navigation.spellerx.states.StateStreetDisambiguation;
import de.vw.mib.asl.internal.navigation.spellerx.states.StateStreetWithBasenames;
import de.vw.mib.asl.internal.navigation.spellerx.states.StateTop;
import de.vw.mib.asl.internal.navigation.spellerx.states.StateWard;
import de.vw.mib.asl.internal.navigation.spellerx.states.StateZipCode;
import de.vw.mib.asl.internal.navigation.util.WeakIdentityHashSet;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.GenericEvents;
import de.vw.mib.genericevents.hsm.HsmState;
import java.util.Dictionary;
import java.util.Iterator;
import java.util.Properties;
import org.dsi.ifc.global.NavLocation;
import org.dsi.ifc.navigation.LIValueList;

public class XSpellerTarget
extends AbstractReflectionHsmTarget {
    public SpellerContext ctx;
    public StateTop stateTop;
    public StateCountry stateCountry;
    public StateProvince stateProvince;
    public StateState stateState;
    public StateCity stateCity;
    public StateStreet stateStreet;
    public StateStreetWithBasenames stateStreetWithBasenames;
    public StateHousenumber stateHousenumber;
    public StateCrossing stateCrossing;
    public StateZipCode stateZip;
    public StateStreetDisambiguation stateStreetDisambiguation;
    public StatePointLocationHousenumber statePointLocationHousenumber;
    public StateStreet1stCity stateStreet1stCity;
    public StateStreet1stStreetWithBasenames stateStreet1stStreetWithBasenames;
    public StateStreet1stZipCode stateStreet1stZipCode;
    public StateWard stateWard;
    public StateChome stateChome;
    public StatePlace statePlace;
    public StatePhoneNumber statePhoneNumber;
    public StateMapCode stateMapCode;
    public ModelListHandler modelCountryList;
    public ModelListHandler modelStateList;
    public ModelListHandler modelProvinceList;
    public ModelListHandler modelCityList;
    public ModelListHandler modelStreetList;
    public ModelListHandler modelStreetWithBasenamesList;
    public ModelListHandler modelPostalcodeList;
    public ModelListHandler modelStreetDisambiguationList;
    public ModelListHandler modelCrossingList;
    public ModelListHandler modelHousenumberList;
    public ModelListHandler modelPhoneNumberList;
    public ModelListHandler modelMapcodeList;
    public ModelListHandler modelProvincePreviewList;
    public ModelListHandler modelCountryPreviewList;
    public ModelListHandler modelCityPreviewList;
    public ModelListHandler modelStreetPreviewList;
    public ModelListHandler modelCrossingPreviewList;
    public SpellerField countryField;
    public SpellerField provinceField;
    public SpellerField stateField;
    public SpellerField cityField;
    public SpellerField postalcodeField;
    public SpellerField streetField;
    public SpellerField streetWithBasenamesField;
    public SpellerField streetDisambiguationField;
    public SpellerField housenumberField;
    public SpellerField crossingField;
    public SpellerField chomeField;
    public SpellerField placeField;
    public SpellerField wardField;
    public SpellerField mapcodeField;
    public SpellerField phoneNumberField;
    public SpellerField activeField;
    private DefaultSpellerHandler defaultHandler = new DefaultSpellerHandler();
    public boolean LOCATIONINPUT_ENABLE_NAR_FEATURES = ServiceManager.configManagerDiag.getNaviLocationOptionDefaultBoolean(3);
    static IExtLogger logger;
    static WeakIdentityHashSet listeners;
    static NavLocation extCurrentLocation;
    static int[] extAvailableSelectionCriteria;
    static boolean extInputActive;
    static boolean extIsFullPostalCode;
    static boolean extHasPointLocations;
    static /* synthetic */ Class class$de$vw$mib$speller$filter$SpellerFilter;

    public XSpellerTarget(GenericEvents genericEvents, int n, String string) {
        super(genericEvents, n, string);
        this.initLists();
        this.initPreviewLists();
        this.initSpellerFields();
        this.initStates();
        this.initSpellerHandler();
        this.enableHWRModeIfNeccessary();
        this.getCurrentContext();
        this.ctx.setLocation(ASLNavigationUtilFactory.getNavigationUtilApi().getLocationWrapper().getLocation());
        this.ctx.put("spellerHandler", this.defaultHandler);
    }

    private void initSpellerHandler() {
        XSpellerHandlerMap.addHandler(2, 3, new DestInputHandler());
        XSpellerHandlerMap.addHandler(0, 3, new HomeInputHandler());
        XSpellerHandlerMap.addHandler(1, 3, new DemoInputHandler());
        XSpellerHandlerMap.addHandler(6, 3, new MemoryInputHandler());
        XSpellerHandlerMap.addHandler(4, 5, new PoiMapInputHandler());
        XSpellerHandlerMap.addHandler(7, 3, new DestInputHandler());
        XSpellerHandlerMap.addHandler(10, 3, new TourModeInputHandler());
        XSpellerHandlerMap.addHandler(5, 3, new MapInputHandler());
        XSpellerHandlerMap.addHandler(12, 3, new ClickInMapInputHandler());
        XSpellerHandlerMap.addHandler(13, 14, new SldeInputHandler());
    }

    private void initStates() {
        this.stateTop = new StateTop(this, this.hsm, "StateTop", null);
        this.stateCountry = new StateCountry(this, this.hsm, "StateCountry", (HsmState)this.stateTop);
        this.stateState = new StateState(this, this.hsm, "StateState", (HsmState)this.stateTop);
        this.stateProvince = new StateProvince(this, this.hsm, "StateProvince", (HsmState)this.stateTop);
        this.stateCity = new StateCity(this, this.hsm, "StateCity", (HsmState)this.stateTop);
        this.stateStreet = new StateStreet(this, this.hsm, "StateStreet", (HsmState)this.stateTop);
        this.stateStreetWithBasenames = new StateStreetWithBasenames(this, this.hsm, "StreetWithBasenames", (HsmState)this.stateTop);
        this.stateStreetDisambiguation = new StateStreetDisambiguation(this, this.hsm, "StateStreetDisambiguation", (HsmState)this.stateTop);
        this.stateHousenumber = new StateHousenumber(this, this.hsm, "StateHousenumber", (HsmState)this.stateTop);
        this.stateCrossing = new StateCrossing(this, this.hsm, "StateCrossing", (HsmState)this.stateTop);
        this.stateZip = new StateZipCode(this, this.hsm, "StateZipCode", (HsmState)this.stateTop);
        this.stateWard = new StateWard(this, this.hsm, "StateWard", (HsmState)this.stateTop);
        this.statePlace = new StatePlace(this, this.hsm, "StatePlace", (HsmState)this.stateTop);
        this.statePointLocationHousenumber = new StatePointLocationHousenumber(this, this.hsm, "StateHousenumberPointLocation", (HsmState)this.stateTop);
        this.stateStreet1stCity = new StateStreet1stCity(this, this.hsm, "StateStreet1stCity", (HsmState)this.stateTop);
        this.stateStreet1stStreetWithBasenames = new StateStreet1stStreetWithBasenames(this, this.hsm, "StateStreet1stWithBasenames", (HsmState)this.stateTop);
        this.stateStreet1stZipCode = new StateStreet1stZipCode(this, this.hsm, "StateStreet1stZipCode", (HsmState)this.stateTop);
        this.statePhoneNumber = new StatePhoneNumber(this, this.hsm, "StatePhoneNumber", (HsmState)this.stateTop);
        this.stateMapCode = new StateMapCode(this, this.hsm, "StateMapCode", (HsmState)this.stateTop);
    }

    private void initLists() {
        if (!ServiceManager.configManagerDiag.isFeatureFlagSet(75)) {
            this.modelMapcodeList = new ModelListHandler(this, logger, "mapcode", 3066, 142, 3063, false, false);
        }
        this.modelCountryList = new ModelListHandler(this, logger, "country", 3027, 1, 3024, false, false);
        this.modelStateList = new ModelListHandler(this, logger, "state", 3033, 138, 3030, false, false);
        this.modelProvinceList = new ModelListHandler(this, logger, "province", 3040, 138, 3036, false, false);
        this.modelCityList = new ModelListHandler(this, logger, "city", 3053, 2, 3049, false, true);
        this.modelPostalcodeList = new ModelListHandler(this, logger, "postalCode", 3046, 6, 3043, false, false);
        this.modelStreetList = new ModelListHandler(this, logger, "street", 3060, 3, 3056, false, false);
        this.modelStreetWithBasenamesList = new ModelListHandler(this, logger, "streetWithBasenames", 3441, 3, 3437, false, false);
        this.modelStreetDisambiguationList = new ModelListHandler(this, logger, "streetDisambiguation", 3066, 127, 3063, false, false);
        this.modelCrossingList = new ModelListHandler(this, logger, "crossing", 3073, 4, 3069, false, false);
        this.modelHousenumberList = new ModelListHandler(this, logger, "houseNumber", 3079, 136, 3076, false, false);
        this.modelPhoneNumberList = new ModelListHandler(this, logger, "phoneNumber", -839905280, 8, -957345792, false, true);
        if (ServiceManager.configManagerDiag.isFeatureFlagSet(75)) {
            this.modelMapcodeList = new ModelListHandler(this, logger, "mapcode", 3066, 142, 3063, false, false);
        }
    }

    private void initPreviewLists() {
        this.modelProvincePreviewList = new ModelListHandler(this, logger, "provincePreview", 3039, 138, 3036, true, false);
        this.modelCityPreviewList = new ModelListHandler(this, logger, "cityPreview", 3052, 2, 3049, true, false);
        this.modelStreetPreviewList = new ModelListHandler(this, logger, "streetPreview", 3059, 3, 3056, true, false);
        this.modelCrossingPreviewList = new ModelListHandler(this, logger, "crossingPreview", 3072, 4, 3069, true, false);
    }

    private void initSpellerFields() {
        this.countryField = new SpellerField("country", this.modelCountryList, this.modelCountryPreviewList);
        this.provinceField = new SpellerField("province", this.modelProvinceList, this.modelProvincePreviewList);
        this.cityField = new SpellerField("city", this.modelCityList, this.modelCityPreviewList);
        this.streetField = new SpellerField("street", this.modelStreetList, this.modelStreetPreviewList);
        this.streetWithBasenamesField = new SpellerField("streetWithBasenames", this.modelStreetWithBasenamesList);
        this.streetDisambiguationField = new SpellerField("streetDisambiguation", this.modelStreetDisambiguationList);
        this.crossingField = new SpellerField("crossing", this.modelCrossingList, this.modelCrossingPreviewList);
        this.housenumberField = new SpellerField("housenumber", this.modelHousenumberList);
        this.phoneNumberField = new SpellerField("phoneNumber", this.modelPhoneNumberList);
        this.mapcodeField = new SpellerField("mapcode", this.modelMapcodeList);
        this.chomeField = new SpellerField("chome");
        this.placeField = new SpellerField("place");
        this.wardField = new SpellerField("ward", this.modelStateList, this.modelCrossingPreviewList);
        if (NavigationConfiguration.LOCATIONINPUT_JPY_FEATURES_AVAILABLE) {
            this.postalcodeField = new SpellerField("postalcode", this.modelPostalcodeList, this.modelStreetPreviewList);
            this.stateField = new SpellerField("State", this.modelStateList, this.modelCrossingPreviewList);
        } else {
            this.postalcodeField = new SpellerField("postalcode", this.modelPostalcodeList);
            this.stateField = new SpellerField("State", this.modelStateList);
        }
    }

    @Override
    public AbstractReflectionState getDefaultWorkState() {
        return this.stateTop;
    }

    public void setSpellerContext(SpellerContext spellerContext) {
        this.ctx = spellerContext;
    }

    public SpellerContext getSpellerContext() {
        return this.ctx;
    }

    public void selectHandler(int n, int n2) {
        int n3 = n | n2 << 16;
        SpellerHandler spellerHandler = XSpellerHandlerMap.getHandler(n3);
        if (spellerHandler != null) {
            this.getCurrentContext().put("spellerHandler", spellerHandler);
        } else {
            this.error().append("no handler defined for copy_location:").append(n).append("->").append(n2).log();
            this.getCurrentContext().put("spellerHandler", this.defaultHandler);
        }
    }

    public static SpellerHandler getHandler(int n, int n2) {
        return XSpellerHandlerMap.getHandler(n, n2);
    }

    public static void addHandler(int n, int n2, SpellerHandler spellerHandler) {
        XSpellerHandlerMap.addHandler(n, n2, spellerHandler);
    }

    @Override
    public AbstractReflectionContext getCurrentContext() {
        if (this.ctx == null) {
            this.ctx = new SpellerContext(this);
        }
        return this.ctx;
    }

    public static void startSpeller(SpellerHandler spellerHandler) {
        EventGeneric eventGeneric = ServiceManager.mGenericEventFactory.newEvent();
        eventGeneric.setObject(0, spellerHandler);
        eventGeneric.setReceiverEventId(IEvents.EV_START_SPELLER_BY_HANDLER);
        eventGeneric.setReceiverTargetId(-1958013952);
        ServiceManager.eventMain.getEventDispatcher().sendSafe(eventGeneric);
    }

    public static void saveSpeller(SpellerHandler spellerHandler) {
        XSpellerHandlerMap.saveSpeller(spellerHandler);
    }

    public IExtLogger getLogger() {
        return logger;
    }

    private void enableHWRModeIfNeccessary() {
        if (NavigationConfiguration.LOCATIONINPUT_CHN_FEATURES_AVAILABLE) {
            if (logger.isTraceEnabled()) {
                this.trace().append("CHN Variant detected - registering speller filters").log();
            }
            this.registerMatchTextSpellerFilterAdapter();
            this.registerNumberSpellerFilterAdapter();
        } else if (logger.isTraceEnabled()) {
            this.trace().append("No CHN Variant detected - no speller filters are being registered").log();
        }
    }

    private void registerMatchTextSpellerFilterAdapter() {
        MatchTextSpellerFilterAdapter matchTextSpellerFilterAdapter = new MatchTextSpellerFilterAdapter();
        Properties properties = new Properties();
        properties.put("FilterId", String.valueOf(100));
        ServiceManager.bundleContext.registerService((class$de$vw$mib$speller$filter$SpellerFilter == null ? (class$de$vw$mib$speller$filter$SpellerFilter = XSpellerTarget.class$("de.vw.mib.speller.filter.SpellerFilter")) : class$de$vw$mib$speller$filter$SpellerFilter).getName(), (Object)matchTextSpellerFilterAdapter, (Dictionary)properties);
    }

    private void registerNumberSpellerFilterAdapter() {
        NumberSpellerFilterAdapter numberSpellerFilterAdapter = new NumberSpellerFilterAdapter();
        Properties properties = new Properties();
        properties.put("FilterId", String.valueOf(101));
        ServiceManager.bundleContext.registerService((class$de$vw$mib$speller$filter$SpellerFilter == null ? (class$de$vw$mib$speller$filter$SpellerFilter = XSpellerTarget.class$("de.vw.mib.speller.filter.SpellerFilter")) : class$de$vw$mib$speller$filter$SpellerFilter).getName(), (Object)numberSpellerFilterAdapter, (Dictionary)properties);
    }

    public void freezeAllLists() {
        if (logger.isTraceEnabled()) {
            logger.makeTrace().append("Freezing all lists called");
        }
        this.modelCountryList.freezeList();
        this.modelStateList.freezeList();
        this.modelProvinceList.freezeList();
        this.modelCityList.freezeList();
        this.modelPostalcodeList.freezeList();
        this.modelStreetList.freezeList();
        this.modelStreetWithBasenamesList.freezeList();
        this.modelStreetDisambiguationList.freezeList();
        this.modelCrossingList.freezeList();
        this.modelHousenumberList.freezeList();
        this.modelProvincePreviewList.freezeList();
        this.modelCityPreviewList.freezeList();
        this.modelStreetPreviewList.freezeList();
        this.modelCrossingPreviewList.freezeList();
        this.modelPhoneNumberList.freezeList();
        this.modelMapcodeList.freezeList();
    }

    public static NavLocation getExtCurrentLocation() {
        return extCurrentLocation;
    }

    public static int[] getExtAvailableSelectionCriteria() {
        return extAvailableSelectionCriteria;
    }

    public static boolean isExtInputActive() {
        return extInputActive;
    }

    public static boolean getExtIsFullPostalCode() {
        return extIsFullPostalCode;
    }

    public static void changeExtInterfaceList(LIValueList lIValueList, long l, IHnrFlags iHnrFlags) {
        Iterator iterator = listeners.iterator();
        while (iterator.hasNext()) {
            ILocationinputResultListener iLocationinputResultListener = (ILocationinputResultListener)iterator.next();
            try {
                iLocationinputResultListener.updateValueList(lIValueList, l, iHnrFlags);
            }
            catch (Exception exception) {
                ServiceManager.errorHandler.handleError(exception);
            }
        }
    }

    public static void changeExtInterfaceInputActive(boolean bl) {
        Iterator iterator = listeners.iterator();
        while (iterator.hasNext()) {
            ILocationinputResultListener iLocationinputResultListener = (ILocationinputResultListener)iterator.next();
            try {
                iLocationinputResultListener.updateInputActive(bl);
            }
            catch (Exception exception) {
                ServiceManager.errorHandler.handleError(exception);
            }
        }
    }

    public static void extInputHapticTakesOver() {
        Iterator iterator = listeners.iterator();
        while (iterator.hasNext()) {
            ILocationinputResultListener iLocationinputResultListener = (ILocationinputResultListener)iterator.next();
            try {
                iLocationinputResultListener.haptikTakesOwnership();
            }
            catch (Exception exception) {
                ServiceManager.errorHandler.handleError(exception);
            }
        }
    }

    public static void extInputErrorMessage(String string, int n) {
    }

    public static void changeExtLocation(NavLocation navLocation, int[] nArray, boolean bl) {
        ILocationWrapper iLocationWrapper = ASLNavigationUtilFactory.getNavigationUtilApi().getLocationWrapper(navLocation);
        if (logger.isTraceEnabled()) {
            logger.trace("XSpellerTarget: changeExtLocation");
        }
        SpellerContext.setExtInterfaceLocation(navLocation);
        extCurrentLocation = navLocation;
        extAvailableSelectionCriteria = nArray;
        extInputActive = bl;
        extIsFullPostalCode = iLocationWrapper.isFullPostalCode();
        extHasPointLocations = SpellerContext.isPointLocation;
        Iterator iterator = listeners.iterator();
        if (logger.isTraceEnabled()) {
            logger.trace("XSpellerTarget: changeExtLocation,got listener iterator");
        }
        while (iterator.hasNext()) {
            ILocationinputResultListener iLocationinputResultListener = (ILocationinputResultListener)iterator.next();
            try {
                if (logger.isTraceEnabled()) {
                    logger.trace("XSpellerTarget: changeExtLocation, updateInputActive for listener");
                }
                iLocationinputResultListener.updateInputActive(bl);
            }
            catch (Exception exception) {
                ServiceManager.errorHandler.handleError(exception);
            }
            try {
                if (logger.isTraceEnabled()) {
                    logger.trace("XSpellerTarget: changeExtLocation, updateState for listener");
                }
                iLocationinputResultListener.updateState(navLocation, nArray, bl, extIsFullPostalCode, extHasPointLocations);
            }
            catch (Exception exception) {
                ServiceManager.errorHandler.handleError(exception);
            }
        }
    }

    public static void registerListener(ILocationinputResultListener iLocationinputResultListener) {
        listeners.add(iLocationinputResultListener);
    }

    public static void unregisterListener(ILocationinputResultListener iLocationinputResultListener) {
        listeners.remove(iLocationinputResultListener);
    }

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError().initCause(classNotFoundException);
        }
    }

    static {
        EventNameResolver.putEventMap(-1089994688, "ASL_NAVIGATION_CONTROL_BAR_POI_IS_PUSH_UP_OPENED");
        EventNameResolver.putEventMap(-889126848, "ASL_NAVIGATION_RESET_ERROR_CODE");
        EventNameResolver.putEventMap(-872349632, "ASL_NAVIGATION_RESET_INFO_CODE");
        EventNameResolver.putEventMap(-972554176, "ASL_NAVIGATION_SET_GEO_COORDINATES_DIRECTION_STRINGS");
        EventNameResolver.putEventMap(-855572416, "ASL_NAVIGATION_MODEL_RESET_DONE");
        EventNameResolver.putEventMap(1493893184, "ASL_NAVIGATION_CHANGE_EXECUTION_MODE");
        EventNameResolver.putEventMap(-838795200, "ASL_NAVIGATION_START_DATABASE_VALIDATION");
        EventNameResolver.putEventMap(-389541824, "ASL_NAVIGATION_SET_CURRENT_ALTITUDE_UPDATE_ENABLED");
        EventNameResolver.putEventMap(-1341521856, "ASL_NAVIGATION_BAP_SET_DAY_NIGHT_MODE");
        EventNameResolver.putEventMap(-1324744640, "ASL_NAVIGATION_BAP_SET_ACTIVE_MAP_TYPE");
        EventNameResolver.putEventMap(-1307967424, "ASL_NAVIGATION_BAP_SET_ACTIVE_MAP_VIEW");
        EventNameResolver.putEventMap(-1291190208, "ASL_NAVIGATION_BAP_SET_ACTIVE_MAP_ORIENTATION");
        EventNameResolver.putEventMap(-1274412992, "ASL_NAVIGATION_BAP_SET_MAP_SCALE_STEPS");
        EventNameResolver.putEventMap(-1107230656, "ASL_NAVIGATION_BAP_SET_ALTERNATIVE_ROUTE_CALC_SETTING");
        EventNameResolver.putEventMap(-1090453440, "ASL_NAVIGATION_BAP_REPEAT_LAST_NAV_ANNOUNCEMENT");
        EventNameResolver.putEventMap(-1073676224, "ASL_NAVIGATION_BAP_STOP_CURRENT_ANNOUNCEMENT");
        EventNameResolver.putEventMap(-1056899008, "ASL_NAVIGATION_BAP_CONFIRM_X_URGENT_MESSAGE");
        EventNameResolver.putEventMap(-1040121792, "ASL_NAVIGATION_BAP_SET_VOICE_GUIDANCE_STATUS");
        EventNameResolver.putEventMap(-1023344576, "ASL_NAVIGATION_BAP_GET_ADDRESS_LIST_DATA");
        EventNameResolver.putEventMap(-1006567360, "ASL_NAVIGATION_BAP_GET_FAVORITE_DEST_VIEW_WINDOW");
        EventNameResolver.putEventMap(-989790144, "ASL_NAVIGATION_BAP_GET_NAV_BOOK_VIEW_WINDOW");
        EventNameResolver.putEventMap(-973012928, "ASL_NAVIGATION_BAP_NAV_BOOK_MATCH_STRING");
        EventNameResolver.putEventMap(-956235712, "ASL_NAVIGATION_BAP_NAV_BOOK_START_SPELLER");
        EventNameResolver.putEventMap(-939458496, "ASL_NAVIGATION_BAP_NAV_BOOK_STOP_SPELLER");
        EventNameResolver.putEventMap(-922681280, "ASL_NAVIGATION_BAP_START_BAP_ROUTE_GUIDANCE");
        EventNameResolver.putEventMap(-905904064, "ASL_NAVIGATION_BAP_STOP_BAP_ROUTE_GUIDANCE");
        EventNameResolver.putEventMap(-822017984, "ASL_NAVIGATION_DUALSCREEN_SET_MAP_VISIBILITY");
        EventNameResolver.putEventMap(-788463552, "ASL_NAVIGATION_DESTINPUT_CONFIRM_MAP_INPUT_OK");
        EventNameResolver.putEventMap(-771686336, "ASL_NAVIGATION_DESTINPUT_DESTINATION_ITEM_SET_AS_CURRENT_DEST");
        EventNameResolver.putEventMap(-754909120, "ASL_NAVIGATION_DESTINPUT_DISCARD");
        EventNameResolver.putEventMap(-738131904, "ASL_NAVIGATION_DESTINPUT_DISCARD_MAP_INPUT");
        EventNameResolver.putEventMap(-704577472, "ASL_NAVIGATION_DESTINPUT_INIT");
        EventNameResolver.putEventMap(-687800256, "ASL_NAVIGATION_DESTINPUT_INIT_FIELD");
        EventNameResolver.putEventMap(-284753856, "ASL_NAVIGATION_DESTINPUT_STRIP");
        EventNameResolver.putEventMap(-671023040, "ASL_NAVIGATION_DESTINPUT_INIT_MAP_INPUT");
        EventNameResolver.putEventMap(-654245824, "ASL_NAVIGATION_DESTINPUT_MOVE_DESTINATION_MARKER");
        EventNameResolver.putEventMap(-637468608, "ASL_NAVIGATION_DESTINPUT_SAVE");
        EventNameResolver.putEventMap(-620691392, "ASL_NAVIGATION_DESTINPUT_SAVE_FIELD");
        EventNameResolver.putEventMap(-603914176, "ASL_NAVIGATION_DESTINPUT_SAVE_MAP_INPUT");
        EventNameResolver.putEventMap(-587136960, "ASL_NAVIGATION_DESTINPUT_SELECT_CITY_CENTER_LIST");
        EventNameResolver.putEventMap(-570359744, "ASL_NAVIGATION_DESTINPUT_SELECT_CITY_CENTER_LIST_BY_NAME");
        EventNameResolver.putEventMap(-553582528, "ASL_NAVIGATION_DESTINPUT_SELECT_CITY_LIST");
        EventNameResolver.putEventMap(-536805312, "ASL_NAVIGATION_DESTINPUT_SELECT_CITY_LIST_BY_NAME");
        EventNameResolver.putEventMap(-503250880, "ASL_NAVIGATION_DESTINPUT_SELECT_COUNTRY_LIST");
        EventNameResolver.putEventMap(-486473664, "ASL_NAVIGATION_DESTINPUT_SELECT_COUNTRY_LIST_BY_NAME");
        EventNameResolver.putEventMap(-469696448, "ASL_NAVIGATION_DESTINPUT_SELECT_CROSSING_LIST");
        EventNameResolver.putEventMap(-452919232, "ASL_NAVIGATION_DESTINPUT_SELECT_CROSSING_LIST_BY_NAME");
        EventNameResolver.putEventMap(-436142016, "ASL_NAVIGATION_DESTINPUT_SELECT_CROSSING_LIST_DETAILS");
        EventNameResolver.putEventMap(-419364800, "ASL_NAVIGATION_DESTINPUT_SELECT_HOUSENUMBER_LIST");
        EventNameResolver.putEventMap(-402587584, "ASL_NAVIGATION_DESTINPUT_SELECT_HOUSENUMBER_LIST_BY_NAME");
        EventNameResolver.putEventMap(-385810368, "ASL_NAVIGATION_DESTINPUT_SELECT_LIST_ITEM_BY_INDEX");
        EventNameResolver.putEventMap(-369033152, "ASL_NAVIGATION_DESTINPUT_SELECT_LIST_ITEM_BY_SPEECH");
        EventNameResolver.putEventMap(-301924288, "ASL_NAVIGATION_DESTINPUT_SELECT_POSTAL_CODE_LIST");
        EventNameResolver.putEventMap(-285147072, "ASL_NAVIGATION_DESTINPUT_SELECT_POSTAL_CODE_LIST_BY_NAME");
        EventNameResolver.putEventMap(-218038208, "ASL_NAVIGATION_DESTINPUT_SELECT_STREET_DISAMBIGUATION_LIST");
        EventNameResolver.putEventMap(-201260992, "ASL_NAVIGATION_DESTINPUT_SELECT_STREET_LIST");
        EventNameResolver.putEventMap(-184483776, "ASL_NAVIGATION_DESTINPUT_SELECT_STREET_LIST_BY_NAME");
        EventNameResolver.putEventMap(-167706560, "ASL_NAVIGATION_DESTINPUT_SELECT_STREET_LIST_DETAILS");
        EventNameResolver.putEventMap(-150929344, "ASL_NAVIGATION_DESTINPUT_SET_EXTERNAL_DESTINATION_INPUT");
        EventNameResolver.putEventMap(-134152128, "ASL_NAVIGATION_DESTINPUT_SET_GEO_COORD_AS_CURRENT_DEST");
        EventNameResolver.putEventMap(-117374912, "ASL_NAVIGATION_DESTINPUT_SET_MAP_CLICK_NEW_POSITION");
        EventNameResolver.putEventMap(-100597696, "ASL_NAVIGATION_DESTINPUT_SPELLER_APPLY_STRING");
        EventNameResolver.putEventMap(-83820480, "ASL_NAVIGATION_DESTINPUT_SPELLER_DELETE_CHAR");
        EventNameResolver.putEventMap(-67043264, "ASL_NAVIGATION_DESTINPUT_SPELLER_SET_CHAR");
        EventNameResolver.putEventMap(-50266048, "ASL_NAVIGATION_DESTINPUT_SPELLER_SET_CURSOR_POSITION");
        EventNameResolver.putEventMap(-33488832, "ASL_NAVIGATION_DESTINPUT_SPELLER_SET_STRING");
        EventNameResolver.putEventMap(-1777663936, "ASL_NAVIGATION_DESTINPUT_SELECT_NOTHING");
        EventNameResolver.putEventMap(-16711616, "ASL_NAVIGATION_DESTINPUT_DESTLIST_REPLACE_FINAL_DESTINATION");
        EventNameResolver.putEventMap(131136, "ASL_NAVIGATION_DESTINPUT_DESTLIST_REPLACE_INTERMEDIATE_DESTINATION");
        EventNameResolver.putEventMap(16908352, "ASL_NAVIGATION_DESTINPUT_DESTLIST_DELETE_INTERMEDIATE_DESTINATION");
        EventNameResolver.putEventMap(0x2020040, "ASL_NAVIGATION_DESTINPUT_DESTLIST_EXCHANGE_DESTINATION_INTERMEDIATE_DESTINATION");
        EventNameResolver.putEventMap(50462784, "ASL_NAVIGATION_DESTINPUT_DESTLIST_RESTORE_DESTINATION_LIST");
        EventNameResolver.putEventMap(0x4020040, "ASL_NAVIGATION_DESTINPUT_DESTLIST_SAVE_DESTINATION_LIST");
        EventNameResolver.putEventMap(84017216, "ASL_NAVIGATION_DESTINPUT_DESTLIST_TRIM_DESTINATION_LIST");
        EventNameResolver.putEventMap(-620167104, "ASL_NAVIGATION_DESTINPUT_DESTLIST_ENTER_INT_DEST_POSITION_VIEW");
        EventNameResolver.putEventMap(-603389888, "ASL_NAVIGATION_DESTINPUT_DESTLIST_LEAVE_INT_DEST_POSITION_VIEW");
        EventNameResolver.putEventMap(1376256064, "ASL_NAVIGATION_GUIDANCE_ABORT_AND_STOP");
        EventNameResolver.putEventMap(100794432, "ASL_NAVIGATION_GUIDANCE_ABORT");
        EventNameResolver.putEventMap(-855048128, "ASL_NAVIGATION_GUIDANCE_ADJUST_POSITION");
        EventNameResolver.putEventMap(117571648, "ASL_NAVIGATION_GUIDANCE_CLEAR_CONGESTION_LIST");
        EventNameResolver.putEventMap(134348864, "ASL_NAVIGATION_GUIDANCE_CONFIRM_BLOCKING");
        EventNameResolver.putEventMap(151126080, "ASL_NAVIGATION_GUIDANCE_CONFIRM_CONGESTION");
        EventNameResolver.putEventMap(167903296, "ASL_NAVIGATION_GUIDANCE_DELETE_BLOCKINGS");
        EventNameResolver.putEventMap(184680512, "ASL_NAVIGATION_GUIDANCE_DELETE_CONGESTION");
        EventNameResolver.putEventMap(201457728, "ASL_NAVIGATION_GUIDANCE_INIT_CONGESTION");
        EventNameResolver.putEventMap(268566592, "ASL_NAVIGATION_GUIDANCE_REPEAT_LAST_ANNOUNCEMENT");
        EventNameResolver.putEventMap(285343808, "ASL_NAVIGATION_GUIDANCE_RESUME");
        EventNameResolver.putEventMap(335675456, "ASL_NAVIGATION_GUIDANCE_SELECT_BLOCKING_ABORT");
        EventNameResolver.putEventMap(352452672, "ASL_NAVIGATION_GUIDANCE_SELECT_BLOCKING_END_ABORT");
        EventNameResolver.putEventMap(369229888, "ASL_NAVIGATION_GUIDANCE_SELECT_CONGESTION_ABORT");
        EventNameResolver.putEventMap(386007104, "ASL_NAVIGATION_GUIDANCE_SELECT_BLOCKING_BEGIN");
        EventNameResolver.putEventMap(402784320, "ASL_NAVIGATION_GUIDANCE_SELECT_BLOCKING_BEGIN_FROM_DETAILS");
        EventNameResolver.putEventMap(419561536, "ASL_NAVIGATION_GUIDANCE_SELECT_BLOCKING_END");
        EventNameResolver.putEventMap(436338752, "ASL_NAVIGATION_GUIDANCE_SELECT_CONGESTION_END");
        EventNameResolver.putEventMap(453115968, "ASL_NAVIGATION_GUIDANCE_SELECT_MAIN_LIST_ITEM");
        EventNameResolver.putEventMap(469893184, "ASL_NAVIGATION_GUIDANCE_SELECT_SUB_LIST_ITEM");
        EventNameResolver.putEventMap(-569835456, "ASL_NAVIGATION_GUIDANCE_SELECT_ROUTE_PROFILE");
        EventNameResolver.putEventMap(520618048, "ASL_NAVIGATION_GUIDANCE_START__X__1");
        EventNameResolver.putEventMap(486670400, "ASL_NAVIGATION_GUIDANCE_START");
        EventNameResolver.putEventMap(503447616, "ASL_NAVIGATION_GUIDANCE_START_RECALCULATION");
        EventNameResolver.putEventMap(0x74070040, "ASL_NAVIGATION_GUIDANCE_START_TOUR_MODE_RECALCULATION");
        EventNameResolver.putEventMap(520224832, "ASL_NAVIGATION_GUIDANCE_START_DEMO");
        EventNameResolver.putEventMap(0x20020040, "ASL_NAVIGATION_GUIDANCE_START_DEMO_RECALCULATION");
        EventNameResolver.putEventMap(1963393088, "ASL_NAVIGATION_GUIDANCE_START_DEMO_TOUR_MODE_RECALCULATION");
        EventNameResolver.putEventMap(553779264, "ASL_NAVIGATION_GUIDANCE_START_DEMO_TOUR_MODE");
        EventNameResolver.putEventMap(0x22020040, "ASL_NAVIGATION_GUIDANCE_START_SELECTED_ROUTE");
        EventNameResolver.putEventMap(1590235200, "ASL_NAVIGATION_GUIDANCE_START_SELECTED_ROUTE_FOR_RUBBERBAND");
        EventNameResolver.putEventMap(587333696, "ASL_NAVIGATION_GUIDANCE_START_TOUR_MODE");
        EventNameResolver.putEventMap(986255424, "ASL_NAVIGATION_GUIDANCE_START_WPM_CALCULATE_ROUTE");
        EventNameResolver.putEventMap(1003032640, "ASL_NAVIGATION_GUIDANCE_START_WPM_REVERSE_DIRECTION");
        EventNameResolver.putEventMap(1019809856, "ASL_NAVIGATION_GUIDANCE_START_WPM_TO_NEAREST_WAY_POINT");
        EventNameResolver.putEventMap(1036587072, "ASL_NAVIGATION_GUIDANCE_START_WPM_ROUTE");
        EventNameResolver.putEventMap(0x24020040, "ASL_NAVIGATION_GUIDANCE_STOP");
        EventNameResolver.putEventMap(620888128, "ASL_NAVIGATION_GUIDANCE_STOP_CURRENT_ANNOUNCEMENT");
        EventNameResolver.putEventMap(637665344, "ASL_NAVIGATION_GUIDANCE_TOGGLE_GUIDANCE_INFO_DEST_TYPE");
        EventNameResolver.putEventMap(1090912320, "ASL_NAVIGATION_GUIDANCE_SET_CONGESTION_AHEAD_LENGTH");
        EventNameResolver.putEventMap(-536346560, "ASL_NAVIGATION_GUIDANCE_SET_CONGESTION_AHEAD_LENGTH_VALUES");
        EventNameResolver.putEventMap(671219776, "ASL_NAVIGATION_HOMEDESTINPUT_DESTINATION_ITEM_SET_AS_CURRENT_DEST");
        EventNameResolver.putEventMap(687996992, "ASL_NAVIGATION_HOMEDESTINPUT_DISCARD");
        EventNameResolver.putEventMap(704774208, "ASL_NAVIGATION_HOMEDESTINPUT_INIT");
        EventNameResolver.putEventMap(721551424, "ASL_NAVIGATION_HOMEDESTINPUT_SAVE");
        EventNameResolver.putEventMap(738328640, "ASL_NAVIGATION_HOMEDESTINPUT_SET_MEMORY");
        EventNameResolver.putEventMap(755105856, "ASL_NAVIGATION_HOMEDESTINPUT_SET_CCP");
        EventNameResolver.putEventMap(-385286080, "ASL_NAVIGATION_LOCATIONINPUT_SET_USERSELECTED_ADDRESS_INPUT_TYPE");
        EventNameResolver.putEventMap(1208614976, "ASL_NAVIGATION_LOCATIONINPUT_SET_LOCATION_INPUT_PATH");
        EventNameResolver.putEventMap(1795686464, "ASL_NAVIGATION_LOCATIONINPUT_INIT_LOCATION");
        EventNameResolver.putEventMap(1812463680, "ASL_NAVIGATION_LOCATIONINPUT_INIT_FIELD");
        EventNameResolver.putEventMap(1829240896, "ASL_NAVIGATION_LOCATIONINPUT_DELETE_FIELD");
        EventNameResolver.putEventMap(1846018112, "ASL_NAVIGATION_LOCATIONINPUT_CANCEL_FIELD");
        EventNameResolver.putEventMap(1862795328, "ASL_NAVIGATION_LOCATIONINPUT_PREPARE_RECOGNITION");
        EventNameResolver.putEventMap(1879572544, "ASL_NAVIGATION_LOCATIONINPUT_SELECT_RECOGNITION");
        EventNameResolver.putEventMap(218759232, "ASL_NAVIGATION_LOCATIONINPUT_ABORT_RECOGNITION");
        EventNameResolver.putEventMap(1913126976, "ASL_NAVIGATION_LOCATIONINPUT_COPY_LOCATION");
        EventNameResolver.putEventMap(336265280, "ASL_NAVIGATION_LOCATIONINPUT_SET_EXTERNAL_LOCATION_INPUT");
        EventNameResolver.putEventMap(46731328, "ASL_NAVIGATION_LOCATIONINPUT_SET_HWR_SPELLER_MODE_ENABLED");
        EventNameResolver.putEventMap(1204359232, "ASL_NAVIGATION_LOCATIONINPUT_START_ROUTE_CALC_FROM_DETAILVIEW");
        EventNameResolver.putEventMap(1825116224, "ASL_NAVIGATION_LOCATIONINPUT_SET_LAST_INPUT_MODE");
        EventNameResolver.putEventMap(1929904192, "ASL_NAVIGATION_LOCATIONINPUT_INPUTFIELD_SELECT_FIRST_MATCH");
        EventNameResolver.putEventMap(1946681408, "ASL_NAVIGATION_LOCATIONINPUT_INPUTFIELD_SELECT_PREVIEW");
        EventNameResolver.putEventMap(1963458624, "ASL_NAVIGATION_LOCATIONINPUT_INPUTFIELD_SELECT_MATCH");
        EventNameResolver.putEventMap(1980235840, "ASL_NAVIGATION_LOCATIONINPUT_INPUTFIELD_SELECT_NOTHING");
        EventNameResolver.putEventMap(1997013056, "ASL_NAVIGATION_LOCATIONINPUT_INPUTFIELD_FILTER_BY_ADD_CHARACTER");
        EventNameResolver.putEventMap(63508544, "ASL_NAVIGATION_LOCATIONINPUT_INPUTFIELD_FILTER_BY_ADD_CHARACTER_HWR");
        EventNameResolver.putEventMap(2013790272, "ASL_NAVIGATION_LOCATIONINPUT_INPUTFIELD_FILTER_BY_UNDO_LAST_CHARACTERS");
        EventNameResolver.putEventMap(2030567488, "ASL_NAVIGATION_LOCATIONINPUT_INPUTFIELD_FILTER_BY_CLEAR_ALL_CHARACTERS");
        EventNameResolver.putEventMap(2047344704, "ASL_NAVIGATION_LOCATIONINPUT_INPUTFIELD_FILTER_BY_SET_ALL_CHARACTERS");
        EventNameResolver.putEventMap(2064121920, "ASL_NAVIGATION_LOCATIONINPUT_INPUTFIELD_ADD_CHARACTER");
        EventNameResolver.putEventMap(2080899136, "ASL_NAVIGATION_LOCATIONINPUT_INPUTFIELD_ADD_CHARACTERS");
        EventNameResolver.putEventMap(2097676352, "ASL_NAVIGATION_LOCATIONINPUT_INPUTFIELD_UNDO_LAST_CHARACTERS");
        EventNameResolver.putEventMap(2114453568, "ASL_NAVIGATION_LOCATIONINPUT_INPUTFIELD_CLEAR_ALL_CHARACTERS");
        EventNameResolver.putEventMap(2131230784, "ASL_NAVIGATION_LOCATIONINPUT_INPUTFIELD_SET_ALL_CHARACTERS");
        EventNameResolver.putEventMap(-2146959296, "ASL_NAVIGATION_LOCATIONINPUT_INPUTFIELD_SET_CURSOR_POSITION");
        EventNameResolver.putEventMap(-2130182080, "ASL_NAVIGATION_LOCATIONINPUT_INPUTFIELD_FILTER");
        EventNameResolver.putEventMap(1393098816, "ASL_NAVIGATION_LOCATIONINPUT_INPUTFIELD_SET_MATCH_LIST_LIMIT");
        EventNameResolver.putEventMap(1858670656, "ASL_NAVIGATION_LOCATIONINPUT_INPUTFIELD_FILL_RESULT_LIST");
        EventNameResolver.putEventMap(1875447872, "ASL_NAVIGATION_LOCATIONINPUT_INPUTFIELD_RETURN_TO_DUAL_LIST");
        EventNameResolver.putEventMap(889782336, "ASL_NAVIGATION_CROSSHAIRMODE_ZOOM_IN");
        EventNameResolver.putEventMap(906559552, "ASL_NAVIGATION_CROSSHAIRMODE_ZOOM_OUT");
        EventNameResolver.putEventMap(923336768, "ASL_NAVIGATION_CROSSHAIRMODE_SET_CLICK_IN_MAP");
        EventNameResolver.putEventMap(1191772224, "ASL_NAVIGATION_CROSSHAIRMODE_SET_INIT_CLICK_IN_MAP");
        EventNameResolver.putEventMap(940113984, "ASL_NAVIGATION_CROSSHAIRMODE_SET_PERSPECTIVE");
        EventNameResolver.putEventMap(956891200, "ASL_NAVIGATION_CROSSHAIRMODE_SHOW_DETAILS");
        EventNameResolver.putEventMap(1091108928, "ASL_NAVIGATION_CROSSHAIRMODE_CONTINUE_TO_DETAIL_VIEW");
        EventNameResolver.putEventMap(-318177216, "ASL_NAVIGATION_CROSSHAIRMODE_GOTO_POI_VICINITY_SEARCH");
        EventNameResolver.putEventMap(487260224, "ASL_NAVIGATION_CROSSHAIRMODE_SET_ADDRESS_AS_CURRENT_DEST");
        EventNameResolver.putEventMap(1393229888, "ASL_NAVIGATION_CROSSHAIRMODE_RETURN_TO_DETAIL_VIEW");
        EventNameResolver.putEventMap(771883072, "ASL_NAVIGATION_MAP_SET_CONTENT");
        EventNameResolver.putEventMap(1405685824, "ASL_NAVIGATION_MAP_SWITCH_MAIN_MAP");
        EventNameResolver.putEventMap(805437504, "ASL_NAVIGATION_MAP_SETUP_LANE_GUIDANCE_TOGGLE");
        EventNameResolver.putEventMap(822214720, "ASL_NAVIGATION_MAP_SETUP_PERSPECTIVE_SET");
        EventNameResolver.putEventMap(838991936, "ASL_NAVIGATION_MAP_SETUP_SHOW_FAVORITES_TOGGLE");
        EventNameResolver.putEventMap(855769152, "ASL_NAVIGATION_MAP_SETUP_SHOW_POI_TOGGLE");
        EventNameResolver.putEventMap(872546368, "ASL_NAVIGATION_MAP_SETUP_TOGGLE_BRAND_MARKER");
        EventNameResolver.putEventMap(889323584, "ASL_NAVIGATION_MAP_SETUP_TOGGLE_AUTO_ZOOM");
        EventNameResolver.putEventMap(906100800, "ASL_NAVIGATION_MAP_SETUP_TOGGLE_MANEUVER_ZOOM");
        EventNameResolver.putEventMap(922878016, "ASL_NAVIGATION_MAP_SETUP_TOGGLE_TMC_EVENTS");
        EventNameResolver.putEventMap(-32964544, "ASL_NAVIGATION_MAP_SETUP_SHOW_SPEED_AND_FLOW_DATA");
        EventNameResolver.putEventMap(0xA0A0040, "ASL_NAVIGATION_MAP_SETUP_SET_RANGE_VIEW_TYPE");
        EventNameResolver.putEventMap(-1962213312, "ASL_NAVIGATION_MAP_SETUP_SHOW_TRAFFIC_FREE_FLOW");
        EventNameResolver.putEventMap(-1945436096, "ASL_NAVIGATION_MAP_SETUP_SHOW_TRAFFIC_CONGESTIONS");
        EventNameResolver.putEventMap(-1928658880, "ASL_NAVIGATION_MAP_SETUP_SHOW_TRAFFIC_INCIDENTS");
        EventNameResolver.putEventMap(-456650688, "ASL_NAVIGATION_MAP_SETUP_SHOW_GOOGLE_EARTH_LAYER_PLACES");
        EventNameResolver.putEventMap(-439873472, "ASL_NAVIGATION_MAP_SETUP_SHOW_GOOGLE_EARTH_LAYER_BUSINESS");
        EventNameResolver.putEventMap(-423096256, "ASL_NAVIGATION_MAP_SETUP_SHOW_GOOGLE_EARTH_LAYER_PANORAMIO");
        EventNameResolver.putEventMap(-406319040, "ASL_NAVIGATION_MAP_SETUP_SHOW_GOOGLE_EARTH_LAYER_WIKIPEDIA");
        EventNameResolver.putEventMap(1506349120, "ASL_NAVIGATION_MAP_SETUP_SET_FPK_MAP_PERSPECTIVE");
        EventNameResolver.putEventMap(1774784576, "ASL_NAVIGATION_MAP_SETUP_SET_VICS_TRAFFIC_FLOW_TYPE");
        EventNameResolver.putEventMap(956432448, "ASL_NAVIGATION_MAP_SS_SET_CURRENT_CONTENT_G");
        EventNameResolver.putEventMap(973209664, "ASL_NAVIGATION_MAP_SS_SET_CURRENT_CONTENT_NG");
        EventNameResolver.putEventMap(989986880, "ASL_NAVIGATION_MAP_SS_TOGGLE_SPLIT_SCREEN_G");
        EventNameResolver.putEventMap(1006764096, "ASL_NAVIGATION_MAP_SS_TOGGLE_SPLIT_SCREEN_NG");
        EventNameResolver.putEventMap(1023541312, "ASL_NAVIGATION_MAP_SS_SET_MANEUVER_VIEW_CONTENT");
        EventNameResolver.putEventMap(1040318528, "ASL_NAVIGATION_MAP_SS_SET_MAP_CONTENT");
        EventNameResolver.putEventMap(1057095744, "ASL_NAVIGATION_MAP_SS_MAP_ZOOM_IN");
        EventNameResolver.putEventMap(0x40020040, "ASL_NAVIGATION_MAP_SS_MAP_ZOOM_OUT");
        EventNameResolver.putEventMap(1090650176, "ASL_NAVIGATION_MAP_SS_SET_MAP_CARSUR_POSITION");
        EventNameResolver.putEventMap(0x42020040, "ASL_NAVIGATION_MAP_SS_SET_MAP_PERSPECTIVE");
        EventNameResolver.putEventMap(1124204608, "ASL_NAVIGATION_MAP_SS_TOGGLE_MAP_OVERVIEW_ZOOM");
        EventNameResolver.putEventMap(0x44020040, "ASL_NAVIGATION_MAP_SS_TOGGLE_MAP_AUTO_ZOOM");
        EventNameResolver.putEventMap(185204800, "ASL_NAVIGATION_MAP_SS_SET_RANGE_VIEW_ENABLED");
        EventNameResolver.putEventMap(403308608, "ASL_NAVIGATION_MAP_SS_ACTIVATE_COUNTRY_OVERVIEW");
        EventNameResolver.putEventMap(80285760, "ASL_NAVIGATION_MAP_SS_TWO_FINGER_ZOOMED");
        EventNameResolver.putEventMap(97062976, "ASL_NAVIGATION_MAP_SS_TWO_FINGER_DRAGGED");
        EventNameResolver.putEventMap(164171840, "ASL_NAVIGATION_MAP_SS_SET_CLICK_IN_MAP");
        EventNameResolver.putEventMap(969478208, "ASL_NAVIGATION_MAP_SS_SELECT_LIST_ELEMENT");
        EventNameResolver.putEventMap(1674121280, "ASL_NAVIGATION_MAP_VIEW_SET_DAY_NIGHT_MODE");
        EventNameResolver.putEventMap(1157759040, "ASL_NAVIGATION_MAP_VIEW_START_SEARCH_TMC_MESSAGES_ON_MAP");
        EventNameResolver.putEventMap(1174536256, "ASL_NAVIGATION_MAP_VIEW_ACTIVATE_DESTINATION_ZOOM");
        EventNameResolver.putEventMap(1191313472, "ASL_NAVIGATION_MAP_VIEW_ACTIVATE_SURROUNDING_ZOOM");
        EventNameResolver.putEventMap(1208090688, "ASL_NAVIGATION_MAP_VIEW_ACTIVATE_ALTERNATIVE_ROUTE_MAP");
        EventNameResolver.putEventMap(1086918720, "ASL_NAVIGATION_MAP_VIEW_ACTIVATE_WAYPOINT_TOUR_OVERVIEW_MAP");
        EventNameResolver.putEventMap(1224867904, "ASL_NAVIGATION_MAP_VIEW_CENTER_MAP_TO_CCP");
        EventNameResolver.putEventMap(1241645120, "ASL_NAVIGATION_MAP_VIEW_RESET_CLICKED_STATUS");
        EventNameResolver.putEventMap(1258422336, "ASL_NAVIGATION_MAP_VIEW_SET_CLICK_IN_MAIN_MAP");
        EventNameResolver.putEventMap(1275199552, "ASL_NAVIGATION_MAP_VIEW_SET_TO_OVERVIEW_ZOOM");
        EventNameResolver.putEventMap(1607012416, "ASL_NAVIGATION_MAP_VIEW_SET_ZOOM_LEVEL_SLIDER");
        EventNameResolver.putEventMap(1308753984, "ASL_NAVIGATION_MAP_VIEW_SET_SCOPE");
        EventNameResolver.putEventMap(1325531200, "ASL_NAVIGATION_MAP_VIEW_SET_CARSUR_POSITION");
        EventNameResolver.putEventMap(420151360, "ASL_NAVIGATION_MAP_VIEW_SET_HOT_POINT_POSITION");
        EventNameResolver.putEventMap(1342308416, "ASL_NAVIGATION_MAP_VIEW_TOGGLE_OVERVIEW_ZOOM");
        EventNameResolver.putEventMap(1359085632, "ASL_NAVIGATION_MAP_VIEW_TOGGLE_PREFERRED_BRANDS");
        EventNameResolver.putEventMap(1375862848, "ASL_NAVIGATION_MAP_VIEW_TOGGLE_ROCKET_ZOOM");
        EventNameResolver.putEventMap(1392640064, "ASL_NAVIGATION_MAP_VIEW_TRANSFER_CLICKED_POI_TO_POI_RESULT");
        EventNameResolver.putEventMap(1409417280, "ASL_NAVIGATION_MAP_VIEW_ZOOM_IN");
        EventNameResolver.putEventMap(1426194496, "ASL_NAVIGATION_MAP_VIEW_SELECT_TMC_FILTER_ON_MAP");
        EventNameResolver.putEventMap(1442971712, "ASL_NAVIGATION_MAP_VIEW_ZOOM_OUT");
        EventNameResolver.putEventMap(-1458962368, "ASL_NAVIGATION_MAP_VIEW_ZOOM_TO_MINIMUM_ZOOM_LEVEL");
        EventNameResolver.putEventMap(1459748928, "ASL_NAVIGATION_MAP_VIEW_SET_ZOOM_LIMIT");
        EventNameResolver.putEventMap(201982016, "ASL_NAVIGATION_MAP_VIEW_SET_RANGE_VIEW_ENABLED");
        EventNameResolver.putEventMap(420085824, "ASL_NAVIGATION_MAP_VIEW_ACTIVATE_COUNTRY_OVERVIEW");
        EventNameResolver.putEventMap(-523759552, "ASL_NAVIGATION_MAP_VIEW_TWO_FINGER_ZOOMED");
        EventNameResolver.putEventMap(-506982336, "ASL_NAVIGATION_MAP_VIEW_TWO_FINGER_DRAGGED");
        EventNameResolver.putEventMap(348721216, "ASL_NAVIGATION_MAP_VIEW_SET_CLICK_IN_DETAIL_SCREEN_MAP");
        EventNameResolver.putEventMap(1476526144, "ASL_NAVIGATION_MEMORY_ADDRESSBOOK_ACCEPT_NON_VALID_DESTINATION");
        EventNameResolver.putEventMap(1526857792, "ASL_NAVIGATION_MEMORY_CONTACT_LIST_ITEM_SELECT_LOAD_DATA_REQUEST");
        EventNameResolver.putEventMap(1543635008, "ASL_NAVIGATION_MEMORY_CONTACT_LIST_LOAD_DATA_REQUEST");
        EventNameResolver.putEventMap(1560412224, "ASL_NAVIGATION_MEMORY_CONTACT_SPELLER_DELETE_CHAR");
        EventNameResolver.putEventMap(1577189440, "ASL_NAVIGATION_MEMORY_CONTACT_SPELLER_INIT");
        EventNameResolver.putEventMap(1593966656, "ASL_NAVIGATION_MEMORY_CONTACT_SPELLER_SET_CHAR");
        EventNameResolver.putEventMap(1610743872, "ASL_NAVIGATION_MEMORY_CONTACT_SPELLER_SET_CURSOR_POSITION");
        EventNameResolver.putEventMap(1627521088, "ASL_NAVIGATION_MEMORY_CONTACT_SPELLER_SET_STRING");
        EventNameResolver.putEventMap(1644298304, "ASL_NAVIGATION_MEMORY_DELETE_ENTRY");
        EventNameResolver.putEventMap(1661075520, "ASL_NAVIGATION_MEMORY_DESTINATION_ITEM_SET_AS_CURRENT_DEST");
        EventNameResolver.putEventMap(1677852736, "ASL_NAVIGATION_MEMORY_DESTINATION_ITEM_SET_AS_HOME");
        EventNameResolver.putEventMap(1694629952, "ASL_NAVIGATION_MEMORY_DEST_MEM_LIST_ITEM_SELECT");
        EventNameResolver.putEventMap(1711407168, "ASL_NAVIGATION_MEMORY_DISCARD");
        EventNameResolver.putEventMap(1728184384, "ASL_NAVIGATION_MEMORY_DISCARD_ADDRESSBOOK_EDIT");
        EventNameResolver.putEventMap(1744961600, "ASL_NAVIGATION_MEMORY_DISCARD_ADDRESSBOOK_SPELLER");
        EventNameResolver.putEventMap(1761738816, "ASL_NAVIGATION_MEMORY_DISCARD_DEST_DETAIL_NOT_VALID");
        EventNameResolver.putEventMap(1778516032, "ASL_NAVIGATION_MEMORY_INIT");
        EventNameResolver.putEventMap(1795293248, "ASL_NAVIGATION_MEMORY_INIT_SEARCH_SPELLER");
        EventNameResolver.putEventMap(923271232, "ASL_NAVIGATION_MEMORY_LIST_ITEM_SELECTION_STATUS_REQUEST__1");
        EventNameResolver.putEventMap(1828847680, "ASL_NAVIGATION_MEMORY_NEW_CONTACT_SPELLER_INIT");
        EventNameResolver.putEventMap(-2147024832, "ASL_NAVIGATION_MEMORY_NEW_CONTACT_SPELLER_SAVE");
        EventNameResolver.putEventMap(1845624896, "ASL_NAVIGATION_MEMORY_PREPARE_DEST_MEM_SAVE");
        EventNameResolver.putEventMap(1862402112, "ASL_NAVIGATION_MEMORY_REPLACE_EXISTING_DESTINATION_MEMORY_ENTRY");
        EventNameResolver.putEventMap(1879179328, "ASL_NAVIGATION_MEMORY_RESET_FLAG_DEST_SAVING_STATE");
        EventNameResolver.putEventMap(1895956544, "ASL_NAVIGATION_MEMORY_SAVE");
        EventNameResolver.putEventMap(1912733760, "ASL_NAVIGATION_MEMORY_SAVE_ADDRESSBOOK_EDIT");
        EventNameResolver.putEventMap(1929510976, "ASL_NAVIGATION_MEMORY_SAVE_CONTACT_DATA");
        EventNameResolver.putEventMap(1946288192, "ASL_NAVIGATION_MEMORY_SAVE_CONTACT_SPELLER_NEW_CONTACT");
        EventNameResolver.putEventMap(1963065408, "ASL_NAVIGATION_MEMORY_SAVE_DEST_DETAIL_NOT_VALID");
        EventNameResolver.putEventMap(1979842624, "ASL_NAVIGATION_MEMORY_SEARCH_CONTACT_LIST_SPELLER");
        EventNameResolver.putEventMap(1996619840, "ASL_NAVIGATION_MEMORY_SEARCH_LIST_ITEM_SELECT_LOAD_DATA_REQUEST");
        EventNameResolver.putEventMap(2013397056, "ASL_NAVIGATION_MEMORY_SEARCH_SPELLER_DELETE_CHAR");
        EventNameResolver.putEventMap(2030174272, "ASL_NAVIGATION_MEMORY_SEARCH_SPELLER_SET_CHAR");
        EventNameResolver.putEventMap(2046951488, "ASL_NAVIGATION_MEMORY_SEARCH_SPELLER_SET_STRING");
        EventNameResolver.putEventMap(2063728704, "ASL_NAVIGATION_MEMORY_SELECT_ADDRESSBOOK_DEST_MEM_ITEM_SLOT_LIST_ITEM");
        EventNameResolver.putEventMap(2080505920, "ASL_NAVIGATION_MEMORY_SELECT_CONTACT_LIST_ITEM");
        EventNameResolver.putEventMap(2097283136, "ASL_NAVIGATION_MEMORY_SELECT_CONTACT_LIST_SEARCH_RESULT_LIST_LOAD_DATA_REQUEST");
        EventNameResolver.putEventMap(2114060352, "ASL_NAVIGATION_MEMORY_SELECT_DESTINATION_MEMORY_LIST_ITEM");
        EventNameResolver.putEventMap(2130837568, "ASL_NAVIGATION_MEMORY_SELECT_DEST_MEM_FILTERED_LIST_ADDRESS_ITEM_LOAD_DATA_REQUEST");
        EventNameResolver.putEventMap(-2147352512, "ASL_NAVIGATION_MEMORY_SELECT_DEST_MEM_FILTERED_LIST_ITEM");
        EventNameResolver.putEventMap(-2130575296, "ASL_NAVIGATION_MEMORY_SELECT_FLAG_DEST_MEM_LIST_ITEM");
        EventNameResolver.putEventMap(-2113798080, "ASL_NAVIGATION_MEMORY_SELECT_LAST_DEST_MEM_LIST_ITEM");
        EventNameResolver.putEventMap(-2097020864, "ASL_NAVIGATION_MEMORY_SELECT_SEARCH_LIST_ITEM");
        EventNameResolver.putEventMap(-2080243648, "ASL_NAVIGATION_MEMORY_SELECT_TOP_DEST_MEM_LIST_ITEM");
        EventNameResolver.putEventMap(1070141504, "ASL_NAVIGATION_MEMORY_SELECT_ONLINE_DEST_MEM_LIST_ITEM");
        EventNameResolver.putEventMap(0x40060040, "ASL_NAVIGATION_MEMORY_SET_FLAG_DEST_NAME");
        EventNameResolver.putEventMap(-2063466432, "ASL_NAVIGATION_MEMORY_STORE_FLAG_DEST");
        EventNameResolver.putEventMap(-2046689216, "ASL_NAVIGATION_MEMORY_TOGGLE_DESTINATION_BELONGING_TO_TOP_DEST_LIST");
        EventNameResolver.putEventMap(-2029912000, "ASL_NAVIGATION_MEMORY_UPDATE_DETAIL_NOT_VALID");
        EventNameResolver.putEventMap(214503488, "ASL_NAVIGATION_MEMORY_CONTACT_SPELLER_CLEAR_ALL_CHARS");
        EventNameResolver.putEventMap(231280704, "ASL_NAVIGATION_MEMORY_CONTACT_SPELLER_SET_CHAR_HWR");
        EventNameResolver.putEventMap(248057920, "ASL_NAVIGATION_MEMORY_SET_HWR_SPELLER_MODE_ENABLED");
        EventNameResolver.putEventMap(315166784, "ASL_NAVIGATION_MEMORY_SEARCH_SPELLER_DELETE_CHAR_HWR");
        EventNameResolver.putEventMap(331944000, "ASL_NAVIGATION_MEMORY_SEARCH_SPELLER_SET_CHAR_HWR");
        EventNameResolver.putEventMap(382275648, "ASL_NAVIGATION_MEMORY_SPELLER_CLEAR_ALL_CHARS");
        EventNameResolver.putEventMap(399052864, "ASL_NAVIGATION_MEMORY_SPELLER_SET_CHAR_HWR");
        EventNameResolver.putEventMap(415830080, "ASL_NAVIGATION_MEMORY_SPELLER_DELETE_ALL_CHARS");
        EventNameResolver.putEventMap(1456017472, "ASL_NAVIGATION_MEMORY_STOP_ROUTE_IMPORT");
        EventNameResolver.putEventMap(1841893440, "ASL_NAVIGATION_MEMORY_SPELLER_SET_CURSOR_POSITION");
        EventNameResolver.putEventMap(-2013134784, "ASL_NAVIGATION_MEMORY_SD_CANCEL_IMPORT_SD_ENTRY_LIST");
        EventNameResolver.putEventMap(-1996357568, "ASL_NAVIGATION_MEMORY_SD_CHECK_AVAILABILITY_GPS_PICS");
        EventNameResolver.putEventMap(-1979580352, "ASL_NAVIGATION_MEMORY_SD_DESELECT_ALL_IMPORT_SD_ENTRY_LIST_ENTRIES");
        EventNameResolver.putEventMap(-1962803136, "ASL_NAVIGATION_MEMORY_SD_GPS_PIC_SET_AS_CURRENT_DEST");
        EventNameResolver.putEventMap(-1946025920, "ASL_NAVIGATION_MEMORY_SD_INIT_IMPORT_SD_ENTRY_LIST");
        EventNameResolver.putEventMap(-1929248704, "ASL_NAVIGATION_MEMORY_SD_LOAD_ALL_GPS_PICS");
        EventNameResolver.putEventMap(-1912471488, "ASL_NAVIGATION_MEMORY_SD_LOAD_GPS_PIC_DETAILS_FROM_PICTURE");
        EventNameResolver.putEventMap(-1895694272, "ASL_NAVIGATION_MEMORY_SD_LOADV_CARDS");
        EventNameResolver.putEventMap(-1878917056, "ASL_NAVIGATION_MEMORY_SD_SELECT_ALL_IMPORT_SD_ENTRY_LIST_ENTRIES");
        EventNameResolver.putEventMap(-1862139840, "ASL_NAVIGATION_MEMORY_SD_SELECT_DEST_LIST_GPS_PIC");
        EventNameResolver.putEventMap(-1845362624, "ASL_NAVIGATION_MEMORY_SD_SELECT_DEST_LIST_V_CARD");
        EventNameResolver.putEventMap(-1828585408, "ASL_NAVIGATION_MEMORY_SD_SELECT_NEXT_DEST_LIST_GPS_PIC");
        EventNameResolver.putEventMap(-1811808192, "ASL_NAVIGATION_MEMORY_SD_SELECT_NEXT_DEST_LIST_V_CARD");
        EventNameResolver.putEventMap(-1795030976, "ASL_NAVIGATION_MEMORY_SD_SELECT_PREV_DEST_LIST_GPS_PIC");
        EventNameResolver.putEventMap(-1778253760, "ASL_NAVIGATION_MEMORY_SD_SELECT_PREV_DEST_LIST_V_CARD");
        EventNameResolver.putEventMap(-1761476544, "ASL_NAVIGATION_MEMORY_SD_SET_GPS_PICS_BROWSER_CURRENT_ABSOLUTE_PATH");
        EventNameResolver.putEventMap(-1744699328, "ASL_NAVIGATION_MEMORY_SD_SET_V_CARD_BROWSER_CURRENT_ABSOLUTE_PATH");
        EventNameResolver.putEventMap(-1727922112, "ASL_NAVIGATION_MEMORY_SD_SET_VCARD_USE_CASE");
        EventNameResolver.putEventMap(-1711144896, "ASL_NAVIGATION_MEMORY_SD_START_IMPORT_SD_ENTRY_LIST");
        EventNameResolver.putEventMap(-1039663040, "ASL_NAVIGATION_MEMORY_SD_RESET_FILEBROWSER_PATH_RECEIVED");
        EventNameResolver.putEventMap(-1694367680, "ASL_NAVIGATION_MEMORY_SD_START_V_CARD_IMPORT");
        EventNameResolver.putEventMap(-1677590464, "ASL_NAVIGATION_MEMORY_SD_TOGGLE_IMPORT_SD_ENTRY_LIST_ENTRY");
        EventNameResolver.putEventMap(-1660813248, "ASL_NAVIGATION_MEMORY_SD_V_CARD_SET_AS_CURRENT_DEST");
        EventNameResolver.putEventMap(-1106771904, "ASL_NAVIGATION_POI_CONTINUE_TO_DETAIL_VIEW");
        EventNameResolver.putEventMap(-1627258816, "ASL_NAVIGATION_POI_DESTINATION_ITEM_SET_AS_CURRENT_DEST");
        EventNameResolver.putEventMap(-1610481600, "ASL_NAVIGATION_POI_DETERMINE_TYPE_OF_CATEGORY");
        EventNameResolver.putEventMap(-1593704384, "ASL_NAVIGATION_POI_INIT_ALL_CATEGORY_LIST");
        EventNameResolver.putEventMap(-1576927168, "ASL_NAVIGATION_POI_INIT_SEARCH_AREA");
        EventNameResolver.putEventMap(1678311488, "ASL_NAVIGATION_POI_INIT_SEARCH_AREA_SPELLER_X");
        EventNameResolver.putEventMap(-1560149952, "ASL_NAVIGATION_POI_LOAD_TOP_POI_ITEM_FUEL_STATION");
        EventNameResolver.putEventMap(-1543372736, "ASL_NAVIGATION_POI_PIT_STOP_ITEM_LOAD");
        EventNameResolver.putEventMap(-1526595520, "ASL_NAVIGATION_POI_PREPARE_POI_LISTS");
        EventNameResolver.putEventMap(-1509818304, "ASL_NAVIGATION_POI_RESULT_SELECT_DETAILS");
        EventNameResolver.putEventMap(-1493041088, "ASL_NAVIGATION_POI_RESULT_SELECT_NEXT_DETAILS");
        EventNameResolver.putEventMap(-1476263872, "ASL_NAVIGATION_POI_RESULT_SELECT_PREV_DETAILS");
        EventNameResolver.putEventMap(-1459486656, "ASL_NAVIGATION_POI_SAVE_ADDRESS");
        EventNameResolver.putEventMap(-1442709440, "ASL_NAVIGATION_POI_SEARCH_CATEGORY_LIST_LOAD_DATA_REQUEST");
        EventNameResolver.putEventMap(-1425932224, "ASL_NAVIGATION_POI_SEARCH_CATEGORY_SELECT_ALL_ELEMENT");
        EventNameResolver.putEventMap(-1409155008, "ASL_NAVIGATION_POI_SEARCH_CATEGORY_SELECT_CATEGORY_ELEMENT");
        EventNameResolver.putEventMap(-1392377792, "ASL_NAVIGATION_POI_SEARCH_CATEGORY_SELECT_GROUP_ELEMENT");
        EventNameResolver.putEventMap(-1375600576, "ASL_NAVIGATION_POI_SEARCH_CATEGORY_SELECT_GROUP_ELEMENT_CLOSE");
        EventNameResolver.putEventMap(-1358823360, "ASL_NAVIGATION_POI_SEARCH_RESULT_DETAIL_VIEW_CLOSE");
        EventNameResolver.putEventMap(-1342046144, "ASL_NAVIGATION_POI_SEARCH_SET_NAME");
        EventNameResolver.putEventMap(-1325268928, "ASL_NAVIGATION_POI_SEARCH_SET_NAME_DEL_CHAR");
        EventNameResolver.putEventMap(-1308491712, "ASL_NAVIGATION_POI_SEARCH_SET_NAME_SET_CHAR");
        EventNameResolver.putEventMap(-1291714496, "ASL_NAVIGATION_POI_SEARCH_SET_NAME_SET_CURSOR_POSITION");
        EventNameResolver.putEventMap(-1274937280, "ASL_NAVIGATION_POI_SEARCH_SET_NAME_SET_STRING");
        EventNameResolver.putEventMap(29954112, "ASL_NAVIGATION_POI_START_POI_SEACH_WITH_CATEGORY_UID2");
        EventNameResolver.putEventMap(-1241382848, "ASL_NAVIGATION_POI_SEARCH_SPELLER_INIT");
        EventNameResolver.putEventMap(-1224605632, "ASL_NAVIGATION_POI_SEARCH_START");
        EventNameResolver.putEventMap(-1207828416, "ASL_NAVIGATION_POI_SEARCH_START_CATEGORY");
        EventNameResolver.putEventMap(-1191051200, "ASL_NAVIGATION_POI_SEARCH_START_THESAURUS");
        EventNameResolver.putEventMap(-1174273984, "ASL_NAVIGATION_POI_SEARCH_STOP");
        EventNameResolver.putEventMap(-1157496768, "ASL_NAVIGATION_POI_SEARCH_VIEW_CLOSE");
        EventNameResolver.putEventMap(-1140719552, "ASL_NAVIGATION_POI_SELECT_LIST_ELEMENT");
        EventNameResolver.putEventMap(-1123942336, "ASL_NAVIGATION_POI_SELECT_SEARCH_ELEMENT");
        EventNameResolver.putEventMap(-1107165120, "ASL_NAVIGATION_POI_SELECT_SEARCH_ELEMENT_CLOSE");
        EventNameResolver.putEventMap(-519569344, "ASL_NAVIGATION_POI_FIND_PO_IS");
        EventNameResolver.putEventMap(-502792128, "ASL_NAVIGATION_POI_CLEAR_INPUT_FIELDS");
        EventNameResolver.putEventMap(-486014912, "ASL_NAVIGATION_POI_INIT_POI_NAME_SPELLER");
        EventNameResolver.putEventMap(589888, "ASL_NAVIGATION_POI_SAVE_POI_NAME__1");
        EventNameResolver.putEventMap(-452460480, "ASL_NAVIGATION_POI_INIT_POI_CATEGORIES");
        EventNameResolver.putEventMap(-385351616, "ASL_NAVIGATION_POI_SELECT_POI_CATEGORY__1");
        EventNameResolver.putEventMap(-418906048, "ASL_NAVIGATION_POI_SELECT_ALL_GROUP_ELEMENTS");
        EventNameResolver.putEventMap(-402128832, "ASL_NAVIGATION_POI_SELECT_ALL_CATEGORY_ELEMENTS");
        EventNameResolver.putEventMap(319422528, "ASL_NAVIGATION_POI_LOAD_CHARGING_STATIONS");
        EventNameResolver.putEventMap(1762263104, "ASL_NAVIGATION_POI_WAIT_FOR_CLICKED_STACK_LOAD_FINISHED");
        EventNameResolver.putEventMap(-137883584, "ASL_NAVIGATION_POI_SEARCH_FUEL_STATIONS_PETROL");
        EventNameResolver.putEventMap(-121106368, "ASL_NAVIGATION_POI_SEARCH_FUEL_STATIONS_DIESEL");
        EventNameResolver.putEventMap(-104329152, "ASL_NAVIGATION_POI_SEARCH_FUEL_STATIONS_CNG");
        EventNameResolver.putEventMap(-87551936, "ASL_NAVIGATION_POI_SEARCH_FUEL_STATIONS_LPG");
        EventNameResolver.putEventMap(264835136, "ASL_NAVIGATION_POI_SEARCH_SET_NAME_SET_CHAR_HWR");
        EventNameResolver.putEventMap(281612352, "ASL_NAVIGATION_POI_SEARCH_SET_NAME_DEL_ALL_CHARS");
        EventNameResolver.putEventMap(298389568, "ASL_NAVIGATION_POI_SET_HWR_SPELLER_MODE_ENABLED");
        EventNameResolver.putEventMap(365498432, "ASL_NAVIGATION_POI_SET_SPELLER_MODE");
        EventNameResolver.putEventMap(633933888, "ASL_NAVIGATION_POI_NAME_SPELLER_ENTERED");
        EventNameResolver.putEventMap(1137250368, "ASL_NAVIGATION_POI_NAME_SPELLER_CANCELED");
        EventNameResolver.putEventMap(650711104, "ASL_NAVIGATION_POI_NAME_SPELLER_OK_PRESSED");
        EventNameResolver.putEventMap(667488320, "ASL_NAVIGATION_POI_SEARCH_SET_NAME_UPDATE_SEPARATORS");
        EventNameResolver.putEventMap(717819968, "ASL_NAVIGATION_POI_INIT_POI_SEARCH_BY_ONLINE_CATEGORY");
        EventNameResolver.putEventMap(734597184, "ASL_NAVIGATION_POI_INIT_ONLINE_POI_SEARCH_BY_CATEGORY");
        EventNameResolver.putEventMap(885592128, "ASL_NAVIGATION_POI_EXPAND_HWR_LIVE_SEARCH_PREVIEWLINE");
        EventNameResolver.putEventMap(1355354176, "ASL_NAVIGATION_POI_SELECT_TOP_POI");
        EventNameResolver.putEventMap(1372131392, "ASL_NAVIGATION_POI_START_POI_SEARCH");
        EventNameResolver.putEventMap(-1090387904, "ASL_NAVIGATION_POI_SETUP_CLEAR_ALL_SELECTED_CATEGORY_ELEMENTS");
        EventNameResolver.putEventMap(-1073610688, "ASL_NAVIGATION_POI_SETUP_DELETE_PERSONAL_POI_DATABASE");
        EventNameResolver.putEventMap(-1056833472, "ASL_NAVIGATION_POI_SETUP_LOAD_CATEGORY_LISTS");
        EventNameResolver.putEventMap(-1040056256, "ASL_NAVIGATION_POI_SETUP_TOGGLE_CATEGORY_ELEMENT");
        EventNameResolver.putEventMap(537526336, "ASL_NAVIGATION_POI_SETUP_SET_PREFERRED_CHARGING_SPEED");
        EventNameResolver.putEventMap(-1023279040, "ASL_NAVIGATION_ROUTEOPTIONS_ALTERNATIVE_ROUTE_CALC_TOGGLE");
        EventNameResolver.putEventMap(-989724608, "ASL_NAVIGATION_ROUTEOPTIONS_DYN_ROUTE_SET");
        EventNameResolver.putEventMap(1271468096, "ASL_NAVIGATION_ROUTEOPTIONS_SET_USE_HOV_LANES");
        EventNameResolver.putEventMap(1556680768, "ASL_NAVIGATION_ROUTEOPTIONS_SET_CONSIDER_SEASONAL_RESTRICTIONS");
        EventNameResolver.putEventMap(1573457984, "ASL_NAVIGATION_ROUTEOPTIONS_SET_CONSIDER_STATISTICAL_DATA");
        EventNameResolver.putEventMap(1388908608, "ASL_NAVIGATION_ROUTEOPTIONS_SET_CONSIDER_TRAILER");
        EventNameResolver.putEventMap(-972947392, "ASL_NAVIGATION_ROUTEOPTIONS_INIT_VIGNETTE_COUNTRY_LIST");
        EventNameResolver.putEventMap(-956170176, "ASL_NAVIGATION_ROUTEOPTIONS_ROAD_TYPES_TOGGLE");
        EventNameResolver.putEventMap(-939392960, "ASL_NAVIGATION_ROUTEOPTIONS_ROUTE_CALC_SET");
        EventNameResolver.putEventMap(-922615744, "ASL_NAVIGATION_ROUTEOPTIONS_SAVE_VIGNETTE_COUNTRY_LIST");
        EventNameResolver.putEventMap(-905838528, "ASL_NAVIGATION_ROUTEOPTIONS_TOGGLE_VIGNETTE_COUNTRY_ENTRY");
        EventNameResolver.putEventMap(-889061312, "ASL_NAVIGATION_ROUTEOPTIONS_VOICE_PROMPTS_DYN_ROUTE");
        EventNameResolver.putEventMap(-855506880, "ASL_NAVIGATION_SETUP_AUDIO_VOICE_ANNOUNCEMENTS_TYPE_SET");
        EventNameResolver.putEventMap(-838729664, "ASL_NAVIGATION_SETUP_CONTACTS_SORT_ORDER_SET");
        EventNameResolver.putEventMap(-821952448, "ASL_NAVIGATION_SETUP_DELETE_MEMORY_BLOCKINGS");
        EventNameResolver.putEventMap(-805175232, "ASL_NAVIGATION_SETUP_DELETE_MEMORY_CITIES");
        EventNameResolver.putEventMap(-788398016, "ASL_NAVIGATION_SETUP_DELETE_MEMORY_DEST_MEM");
        EventNameResolver.putEventMap(-771620800, "ASL_NAVIGATION_SETUP_DELETE_MEMORY_FLAG_DEST");
        EventNameResolver.putEventMap(-754843584, "ASL_NAVIGATION_SETUP_DELETE_MEMORY_HOME");
        EventNameResolver.putEventMap(-738066368, "ASL_NAVIGATION_SETUP_DELETE_MEMORY_LAST_DEST");
        EventNameResolver.putEventMap(935923776, "ASL_NAVIGATION_SETUP_DELETE_MEMORY_PREDICTIONS");
        EventNameResolver.putEventMap(1103695936, "ASL_NAVIGATION_SETUP_DELETE_MEMORY_ONLINE_DEST");
        EventNameResolver.putEventMap(-721289152, "ASL_NAVIGATION_SETUP_DELETE_MEMORY_TOUR_MEM");
        EventNameResolver.putEventMap(1120473152, "ASL_NAVIGATION_SETUP_DELETE_MEMORY_WAYPOINT_MEM");
        EventNameResolver.putEventMap(-704511936, "ASL_NAVIGATION_SETUP_DEMO_START_LOCATION_DISCARD");
        EventNameResolver.putEventMap(-687734720, "ASL_NAVIGATION_SETUP_DEMO_START_LOCATION_INIT");
        EventNameResolver.putEventMap(-670957504, "ASL_NAVIGATION_SETUP_DEMO_START_LOCATION_SAVE");
        EventNameResolver.putEventMap(-654180288, "ASL_NAVIGATION_SETUP_DEMO_START_LOCATION_SET_CCP");
        EventNameResolver.putEventMap(-620625856, "ASL_NAVIGATION_SETUP_GUIDANCE_DEMO_MODE_TOGGLE");
        EventNameResolver.putEventMap(-603848640, "ASL_NAVIGATION_SETUP_LOW_FUEL_WARNING");
        EventNameResolver.putEventMap(-587071424, "ASL_NAVIGATION_SETUP_NAME_REPRESENTATION_SET");
        EventNameResolver.putEventMap(-570294208, "ASL_NAVIGATION_SETUP_PREPARE_GAS_STATION_LIST");
        EventNameResolver.putEventMap(-553516992, "ASL_NAVIGATION_SETUP_ROUTE_OPTIONS_SAVE");
        EventNameResolver.putEventMap(-536739776, "ASL_NAVIGATION_SETUP_SAVE_PREFERRED_GAS_STATION_LIST_ITEMS");
        EventNameResolver.putEventMap(-503185344, "ASL_NAVIGATION_SETUP_TIME_DISPLAY_SET");
        EventNameResolver.putEventMap(-486408128, "ASL_NAVIGATION_SETUP_TOGGLE_APPROACH_SPECIAL_PLACES_HINT");
        EventNameResolver.putEventMap(550047808, "ASL_NAVIGATION_SETUP_TOGGLE_SPEED_CAMERA_WARNING");
        EventNameResolver.putEventMap(1690898496, "ASL_NAVIGATION_SETUP_SET_SPEED_CAMERA_WARNING_TYPE");
        EventNameResolver.putEventMap(-469630912, "ASL_NAVIGATION_SETUP_TOGGLE_BORDER_CROSSING_HINT");
        EventNameResolver.putEventMap(-452853696, "ASL_NAVIGATION_SETUP_TOGGLE_GAS_STATION_LIST_ITEM");
        EventNameResolver.putEventMap(-436076480, "ASL_NAVIGATION_SETUP_TOGGLE_GAS_STATION_NONE_OPTION");
        EventNameResolver.putEventMap(-419299264, "ASL_NAVIGATION_SETUP_TOGGLE_STATUS_LINE_INFORMATION");
        EventNameResolver.putEventMap(-385744832, "ASL_NAVIGATION_SETUP_TRAFFIC_SIGN_ANNOUNCEMENT_TYPE_SET");
        EventNameResolver.putEventMap(952700992, "ASL_NAVIGATION_SETUP_SET_TRAFFIC_WARNING_SIGN_DISPLAY_ENABLED");
        EventNameResolver.putEventMap(-368967616, "ASL_NAVIGATION_SETUP_VOICE_ANNOUNCEMENTS_SET");
        EventNameResolver.putEventMap(134873152, "ASL_NAVIGATION_SETUP_SET_DESTINATION_RANGE_WARNING_ENABLED");
        EventNameResolver.putEventMap(151650368, "ASL_NAVIGATION_SETUP_SET_HOME_RANGE_WARNING_ENABLED");
        EventNameResolver.putEventMap(1707675712, "ASL_NAVIGATION_SETUP_SET_WARNING_ENABLED_RAILWAY_CROSSING");
        EventNameResolver.putEventMap(1724452928, "ASL_NAVIGATION_SETUP_SET_WARNING_ENABLED_MERGING_TRAFFIC");
        EventNameResolver.putEventMap(1741230144, "ASL_NAVIGATION_SETUP_SET_WARNING_ENABLED_REDUCE_LANE");
        EventNameResolver.putEventMap(482938944, "ASL_NAVIGATION_SETUP_CANCEL_RANGE_WARNING_PRESSED");
        EventNameResolver.putEventMap(1758007360, "ASL_NAVIGATION_SETUP_RESTART_NAV_AFTER_MERGING_FINISHED");
        EventNameResolver.putEventMap(-335413184, "ASL_NAVIGATION_SPEECH_SELECT_CONTACT");
        EventNameResolver.putEventMap(-1996029888, "ASL_NAVIGATION_SPEECH_CALCULATE_CAPABILITIES");
        EventNameResolver.putEventMap(134414400, "ASL_NAVIGATION_TRAFFIC_LEAVE_CONTEXT");
        EventNameResolver.putEventMap(151191616, "ASL_NAVIGATION_TRAFFIC_SELECT_NEXT_TMC_MESSAGE_CURRENT");
        EventNameResolver.putEventMap(167968832, "ASL_NAVIGATION_TRAFFIC_SELECT_PREV_TMC_MESSAGE_CURRENT");
        EventNameResolver.putEventMap(184746048, "ASL_NAVIGATION_TRAFFIC_SELECT_TMC_MESSAGE_LIST");
        EventNameResolver.putEventMap(201523264, "ASL_NAVIGATION_TRAFFIC_SELECT_TMC_MESSAGE_LIST_ID");
        EventNameResolver.putEventMap(218300480, "ASL_NAVIGATION_TRAFFIC_SELECT_TMC_MESSAGE_ROUTE_CHANGED");
        EventNameResolver.putEventMap(235077696, "ASL_NAVIGATION_TRAFFIC_SELECT_TMC_MESSAGE_SUB_LIST_ID");
        EventNameResolver.putEventMap(251854912, "ASL_NAVIGATION_TRAFFIC_SET_TMC_MESSAGE_LIST_FILTER");
        EventNameResolver.putEventMap(268632128, "ASL_NAVIGATION_TRAFFIC_SET_TMC_MESSAGE_LIST_UPDATE");
        EventNameResolver.putEventMap(285409344, "ASL_NAVIGATION_TRAFFIC_SYNC_REENTERING_TRAFFIC_LIST_FROM_DETAIL_VIEW");
        EventNameResolver.putEventMap(302186560, "ASL_NAVIGATION_TRAFFIC_TOGGLE_ACOUSTIC_TRAFFIC_JAM_WARNING");
        EventNameResolver.putEventMap(318963776, "ASL_NAVIGATION_TRAFFIC_X_URGENT_TMC_MESSAGE_READ");
        EventNameResolver.putEventMap(-301858752, "ASL_NAVIGATION_TOURMODE_ADD_NEW_TOUR_LIST_ELEMENT");
        EventNameResolver.putEventMap(-285081536, "ASL_NAVIGATION_TOURMODE_CHECK_TOUR_LIST_NAME");
        EventNameResolver.putEventMap(-268304320, "ASL_NAVIGATION_TOURMODE_CLEAR_LAST_TOUR_LIST");
        EventNameResolver.putEventMap(-251527104, "ASL_NAVIGATION_TOURMODE_CLEAR_TOUR_LIST");
        EventNameResolver.putEventMap(-234749888, "ASL_NAVIGATION_TOURMODE_DELETE_TOUR_FROM_TOUR_MEM_LIST");
        EventNameResolver.putEventMap(-217972672, "ASL_NAVIGATION_TOURMODE_DELETE_TOUR_LIST_ELEMENT");
        EventNameResolver.putEventMap(-201195456, "ASL_NAVIGATION_TOURMODE_DISCARD");
        EventNameResolver.putEventMap(-184418240, "ASL_NAVIGATION_TOURMODE_DISCARD_TOUR_LIST_CHANGES");
        EventNameResolver.putEventMap(-167641024, "ASL_NAVIGATION_TOURMODE_INIT_TOUR_INPUT");
        EventNameResolver.putEventMap(-150863808, "ASL_NAVIGATION_TOURMODE_LOAD_DETAILS_OF_TOUR_LIST_ELEMENT");
        EventNameResolver.putEventMap(-134086592, "ASL_NAVIGATION_TOURMODE_LOAD_LAST_TOUR_LIST");
        EventNameResolver.putEventMap(-117309376, "ASL_NAVIGATION_TOURMODE_LOAD_TOUR_LIST");
        EventNameResolver.putEventMap(-100532160, "ASL_NAVIGATION_TOURMODE_LOAD_TOUR_MEM_LIST");
        EventNameResolver.putEventMap(-83754944, "ASL_NAVIGATION_TOURMODE_MOVE_TOUR_LIST_ELEMENT");
        EventNameResolver.putEventMap(-66977728, "ASL_NAVIGATION_TOURMODE_RECALC_TOUR");
        EventNameResolver.putEventMap(-50200512, "ASL_NAVIGATION_TOURMODE_REPLACE_TOUR_IN_TOUR_MEM_LIST");
        EventNameResolver.putEventMap(-33423296, "ASL_NAVIGATION_TOURMODE_SAVE");
        EventNameResolver.putEventMap(-16646080, "ASL_NAVIGATION_TOURMODE_SAVE_TOUR_LIST");
        EventNameResolver.putEventMap(1980170304, "ASL_NAVIGATION_TOURMODE_SET_EDIT_MODE");
        EventNameResolver.putEventMap(604504128, "ASL_NAVIGATION_TOURMODE_SKIP_NEXT_STOPOVER");
        EventNameResolver.putEventMap(196672, "ASL_NAVIGATION_TOURMODE_SPELLER_DELETE_CHAR");
        EventNameResolver.putEventMap(16973888, "ASL_NAVIGATION_TOURMODE_SPELLER_INIT");
        EventNameResolver.putEventMap(33751104, "ASL_NAVIGATION_TOURMODE_SPELLER_SET_CHAR");
        EventNameResolver.putEventMap(0x3030040, "ASL_NAVIGATION_TOURMODE_SPELLER_SET_CURSOR_POSITION");
        EventNameResolver.putEventMap(0x4030040, "ASL_NAVIGATION_TOURMODE_START_LAST_TOUR");
        EventNameResolver.putEventMap(84082752, "ASL_NAVIGATION_TOURMODE_START_ROUTE_CALC");
        EventNameResolver.putEventMap(100859968, "ASL_NAVIGATION_TOURMODE_START_ROUTE_CALC_DIRECT");
        EventNameResolver.putEventMap(117637184, "ASL_NAVIGATION_TOURMODE_START_TOUR_FROM_TOUR_MEM_LIST");
        EventNameResolver.putEventMap(432607296, "ASL_NAVIGATION_TOURMODE_LEAVE_TOUR_LIST");
        EventNameResolver.putEventMap(499716160, "ASL_NAVIGATION_TOURMODE_SPELLER_DELETE_ALL_CHARS");
        EventNameResolver.putEventMap(516493376, "ASL_NAVIGATION_TOURMODE_SPELLER_SET_CHAR_HWR");
        EventNameResolver.putEventMap(533270592, "ASL_NAVIGATION_TOURMODE_SET_HWR_SPELLER_MODE_ENABLED");
        EventNameResolver.putEventMap(1472794688, "ASL_NAVIGATION_TOURMODE_IMPORT_START");
        EventNameResolver.putEventMap(1489571904, "ASL_NAVIGATION_TOURMODE_IMPORT_ABORT");
        EventNameResolver.putEventMap(1791561792, "ASL_NAVIGATION_TOURMODE_IMPORT_CANCEL");
        EventNameResolver.putEventMap(335740992, "ASL_NAVIGATION_VIA_INIT_VIA_LIST");
        EventNameResolver.putEventMap(352518208, "ASL_NAVIGATION_VIA_REMOVE_VIA_SELECTED");
        EventNameResolver.putEventMap(369295424, "ASL_NAVIGATION_VIA_SELECT_VIA");
        EventNameResolver.putEventMap(-2063138752, "ASL_NAVIGATION_PNAV_CONFIRM_SELECTION");
        EventNameResolver.putEventMap(-2046361536, "ASL_NAVIGATION_PNAV_CANCEL_SELECTION");
        EventNameResolver.putEventMap(-2029584320, "ASL_NAVIGATION_PNAV_SELECT_DESTINATION");
        EventNameResolver.putEventMap(-2012807104, "ASL_NAVIGATION_PNAV_SET_TOUCH_POSITION");
        EventNameResolver.putEventMap(818483264, "ASL_NAVIGATION_PNAV_SET_PNAV_ENABLED");
        EventNameResolver.putEventMap(835260480, "ASL_NAVIGATION_PNAV_SET_PNAV_STATUS");
        EventNameResolver.putEventMap(852037696, "ASL_NAVIGATION_PNAV_SHOW_OVERVIEW_MAP");
        EventNameResolver.putEventMap(868814912, "ASL_NAVIGATION_PNAV_START_PNAV_GUIDANCE");
        EventNameResolver.putEventMap(1180185856, "EV_LOCATION_INPUT_CANCEL_INPUT");
        EventNameResolver.putEventMap(1146631424, "EV_LOCATION_INPUT_SELECT_ENTRY_VIA_ID");
        EventNameResolver.putEventMap(1213740288, "EV_LOCATION_INPUT_SELECT_ENTRY_VIA_INDEX");
        EventNameResolver.putEventMap(1163408640, "EV_LOCATION_INPUT_SELECT_NOTHING");
        EventNameResolver.putEventMap(1196963072, "EV_LOCATION_INPUT_SET_CURRENT_LOCATION");
        EventNameResolver.putEventMap(1113076992, "EV_LOCATION_INPUT_SET_INPUT");
        EventNameResolver.putEventMap(1096299776, "EV_LOCATION_INPUT_START_INPUT");
        logger = ASLNavigationUtilFactory.getNavigationUtilApi().getExtLogger(16384, "SPELLERX");
        listeners = new WeakIdentityHashSet();
        extCurrentLocation = null;
        extAvailableSelectionCriteria = new int[0];
        extInputActive = false;
        extIsFullPostalCode = false;
        extHasPointLocations = false;
    }
}

