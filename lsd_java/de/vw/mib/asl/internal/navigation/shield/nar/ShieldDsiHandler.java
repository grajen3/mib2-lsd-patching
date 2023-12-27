/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.shield.nar;

import de.vw.mib.asl.api.navigation.util.ASLNavigationUtilFactory;
import de.vw.mib.asl.api.navigation.util.IExtLogger;
import de.vw.mib.asl.framework.api.diagnosis.config.Coding;
import de.vw.mib.asl.framework.api.dsiproxy.DSIProxy;
import de.vw.mib.asl.framework.api.dsiproxy.DSIProxyFactory;
import de.vw.mib.asl.framework.api.dsiproxy.DSIServiceStateListener;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.navigation.gateway.AbstractResettableNavGatewayTarget;
import de.vw.mib.asl.internal.navigation.gateway.command.CmdDmLastDestinationsDeleteAll;
import de.vw.mib.asl.internal.navigation.gateway.command.CmdDmLastDestinationsGet;
import de.vw.mib.asl.internal.navigation.gateway.command.CmdSetCurrentLD;
import de.vw.mib.asl.internal.navigation.shield.nar.ShieldDsiHandler$1;
import de.vw.mib.asl.internal.navigation.shield.nar.ShieldDsiHandler$2;
import de.vw.mib.asl.internal.navigation.shield.nar.TargetShield;
import de.vw.mib.collections.ints.IntObjectOptHashMap;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.GenericEventException;
import de.vw.mib.genericevents.GenericEvents;
import java.util.ArrayList;
import java.util.HashMap;
import org.dsi.ifc.asiainput.DSIAsiaInput;
import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.global.NavLocation;
import org.dsi.ifc.navigation.DSINavigation;
import org.dsi.ifc.navigation.DSINavigationListener;
import org.dsi.ifc.navigation.LDListElement;
import org.dsi.ifc.search.Country;
import org.dsi.ifc.search.DSISearch;
import org.dsi.ifc.search.Environment;
import org.dsi.ifc.search.NavPosition;
import org.dsi.ifc.search.SearchQuery;
import org.dsi.ifc.search.SearchResult;

public class ShieldDsiHandler
extends AbstractResettableNavGatewayTarget
implements DSIServiceStateListener {
    private int matchingMode = 0;
    private Environment environment = null;
    private IntObjectOptHashMap countryCodingMap = new IntObjectOptHashMap();
    private int lastQueryId = 0;
    static IExtLogger logger = ASLNavigationUtilFactory.getNavigationUtilApi().getExtLogger(16384, "ShieldDsiHandler");
    private DSISearch dsiSearch;
    private DSIListener dsiSearchListener;
    private DSINavigation dsiNavigation;
    private DSINavigationListener dsiNavigationListener;
    private DSIAsiaInput dsiAsiaInput;
    private DSIListener dsiAsiaInputListener;
    private boolean isHigh = ServiceManager.configManagerDiag.isFeatureFlagSet(70);
    private boolean isChnEnabled = ServiceManager.configManagerDiag.getNaviLocationOptionDefaultBoolean(1);
    private boolean isJapan = ServiceManager.configManagerDiag.isFeatureFlagSet(75);
    private boolean isDsiAsiaInputAvaliable = this.isJapan && this.isHigh;
    private TargetShield shieldTarget;
    private ArrayList asianLanguages = new ShieldDsiHandler$1(this);
    private ArrayList wordSegmentationSupportedLanguages = new ShieldDsiHandler$2(this);
    static /* synthetic */ Class class$org$dsi$ifc$search$DSISearch;
    static /* synthetic */ Class class$org$dsi$ifc$navigation$DSINavigation;
    static /* synthetic */ Class class$org$dsi$ifc$asiainput$DSIAsiaInput;
    static /* synthetic */ Class class$org$dsi$ifc$navigation$DSINavigationListener;
    static /* synthetic */ Class class$org$dsi$ifc$search$DSISearchListener;
    static /* synthetic */ Class class$org$dsi$ifc$asiainput$DSIAsiaInputListener;

    public ShieldDsiHandler(GenericEvents genericEvents, int n, String string, TargetShield targetShield) {
        super(genericEvents, n, string);
        this.shieldTarget = targetShield;
        ServiceManager.dsiServiceLocator.addServiceStateListener(class$org$dsi$ifc$search$DSISearch == null ? (class$org$dsi$ifc$search$DSISearch = ShieldDsiHandler.class$("org.dsi.ifc.search.DSISearch")) : class$org$dsi$ifc$search$DSISearch, this);
        ServiceManager.dsiServiceLocator.addServiceStateListener(class$org$dsi$ifc$navigation$DSINavigation == null ? (class$org$dsi$ifc$navigation$DSINavigation = ShieldDsiHandler.class$("org.dsi.ifc.navigation.DSINavigation")) : class$org$dsi$ifc$navigation$DSINavigation, this);
        if (this.isDsiAsiaInputAvaliable) {
            ServiceManager.dsiServiceLocator.addServiceStateListener(class$org$dsi$ifc$asiainput$DSIAsiaInput == null ? (class$org$dsi$ifc$asiainput$DSIAsiaInput = ShieldDsiHandler.class$("org.dsi.ifc.asiainput.DSIAsiaInput")) : class$org$dsi$ifc$asiainput$DSIAsiaInput, this);
        }
        this.fillCountryCodingMap();
    }

    private void extractEnvironment() {
        if (this.getEnvironment() == null) {
            this.error("Trying to get Coding for truffels");
            try {
                ServiceManager.adaptionApi.requestConfigManagerPersCoding(this.getTargetId(), 20526336);
            }
            catch (GenericEventException genericEventException) {
                this.error("Something went wrong, coding could not be accessed.");
            }
        }
    }

    private void getCountryCoding(EventGeneric eventGeneric) {
        ShieldDsiHandler.printTrace(new StringBuffer("Got event for coding!! "));
        Coding coding = (Coding)eventGeneric.getObject(1);
        int n = 0;
        if (coding == null) {
            ShieldDsiHandler.printTrace(new StringBuffer("Coding is null"));
            this.error("Recieved coding was null. Setting empty environment");
        } else {
            if (coding.contains(5)) {
                n = coding.getValue(5);
            }
            ShieldDsiHandler.printTrace(new StringBuffer("CountryCoding is ").append(n));
        }
        Environment environment = null;
        environment = (Environment)this.countryCodingMap.get(n);
        if (environment == null) {
            this.error("No environment found in coding. Setting empty environment!");
            this.setEnvironment(new Environment());
        } else {
            this.setEnvironment(environment);
        }
    }

    private String getOem() {
        boolean bl = ServiceManager.configManagerDiag.isFeatureFlagSet(360);
        boolean bl2 = ServiceManager.configManagerDiag.isFeatureFlagSet(353);
        boolean bl3 = ServiceManager.configManagerDiag.isFeatureFlagSet(432);
        String string = "VW";
        if (bl) {
            ShieldDsiHandler.printTrace(new StringBuffer("getOem: SK"));
            string = "SK";
        } else if (bl2) {
            ShieldDsiHandler.printTrace(new StringBuffer("getOem: SE"));
            string = "SE";
        } else if (bl3) {
            ShieldDsiHandler.printTrace(new StringBuffer("getOem: VW"));
            string = "VW";
        } else {
            ShieldDsiHandler.printTrace(new StringBuffer("getOem: Error getting OEM. Feature Flags not set correctly."));
        }
        return string;
    }

    private void fillCountryCodingMap() {
        String string = "ER";
        String string2 = "NAR";
        String string3 = "";
        String string4 = this.getOem();
        this.countryCodingMap.put(1, new Environment(string4, "ER", "eu", ""));
        this.countryCodingMap.put(7, new Environment(string4, "ER", "asia", ""));
        this.countryCodingMap.put(8, new Environment(string4, "ER", "aus", ""));
        this.countryCodingMap.put(14, new Environment(string4, "ER", "india", ""));
        this.countryCodingMap.put(15, new Environment(string4, "ER", "il", ""));
        this.countryCodingMap.put(12, new Environment(string4, "ER", "meast", ""));
        this.countryCodingMap.put(3, new Environment(string4, "ER", "msa", ""));
        this.countryCodingMap.put(17, new Environment(string4, "ER", "msa2", ""));
        this.countryCodingMap.put(10, new Environment(string4, "ER", "neast", ""));
        this.countryCodingMap.put(9, new Environment(string4, "ER", "za", ""));
        this.countryCodingMap.put(5, new Environment(string4, "CN", "china", "import"));
        this.countryCodingMap.put(18, new Environment(string4, "CN", "china", "shanghai"));
        this.countryCodingMap.put(19, new Environment(string4, "CN", "china", "faw"));
        this.countryCodingMap.put(2, new Environment(string4, "NAR", "nar", ""));
        this.countryCodingMap.put(6, new Environment(string4, "JP", "japan", ""));
        this.countryCodingMap.put(4, new Environment(string4, "KR", "korea", ""));
        this.countryCodingMap.put(16, new Environment(string4, "TW", "taiwan", ""));
    }

    @Override
    public void gotEvent(EventGeneric eventGeneric) {
        switch (eventGeneric.getReceiverEventId()) {
            case 101003: {
                this.addObserver(20526336);
                break;
            }
            case 3488001: {
                this.getCountryCoding(eventGeneric);
                this.configureDsiSearch();
                break;
            }
        }
    }

    @Override
    public void registered(String string, int n) {
        if (string.intern() == (class$org$dsi$ifc$search$DSISearch == null ? (class$org$dsi$ifc$search$DSISearch = ShieldDsiHandler.class$("org.dsi.ifc.search.DSISearch")) : class$org$dsi$ifc$search$DSISearch).getName().intern() && !this.isFirstStartupDone) {
            this.initDSISearch();
        }
        if (string.intern() == (class$org$dsi$ifc$navigation$DSINavigation == null ? (class$org$dsi$ifc$navigation$DSINavigation = ShieldDsiHandler.class$("org.dsi.ifc.navigation.DSINavigation")) : class$org$dsi$ifc$navigation$DSINavigation).getName().intern() && !this.isFirstStartupDone) {
            this.initDSINavigation();
        }
        if (this.isDsiAsiaInputAvaliable && string.intern() == (class$org$dsi$ifc$asiainput$DSIAsiaInput == null ? (class$org$dsi$ifc$asiainput$DSIAsiaInput = ShieldDsiHandler.class$("org.dsi.ifc.asiainput.DSIAsiaInput")) : class$org$dsi$ifc$asiainput$DSIAsiaInput).getName().intern() && !this.isFirstStartupDone) {
            this.initDSIAsiaInput();
        }
        if (null != this.dsiSearch && null != this.dsiNavigation) {
            if (this.isDsiAsiaInputAvaliable) {
                if (null != this.dsiAsiaInput) {
                    this.isFirstStartupDone = true;
                }
            } else {
                this.isFirstStartupDone = true;
            }
        }
    }

    private void initDSINavigation() {
        DSIProxy dSIProxy = DSIProxyFactory.getDSIProxyAPI().getDSIProxy();
        this.dsiNavigation = (DSINavigation)dSIProxy.getService(this, class$org$dsi$ifc$navigation$DSINavigation == null ? (class$org$dsi$ifc$navigation$DSINavigation = ShieldDsiHandler.class$("org.dsi.ifc.navigation.DSINavigation")) : class$org$dsi$ifc$navigation$DSINavigation);
        this.dsiNavigationListener = (DSINavigationListener)ServiceManager.dsiServiceLocator.getAdapterFactory().createDSIListenerMethodAdapter(this, class$org$dsi$ifc$navigation$DSINavigationListener == null ? (class$org$dsi$ifc$navigation$DSINavigationListener = ShieldDsiHandler.class$("org.dsi.ifc.navigation.DSINavigationListener")) : class$org$dsi$ifc$navigation$DSINavigationListener);
        dSIProxy.addResponseListener(this, class$org$dsi$ifc$navigation$DSINavigationListener == null ? (class$org$dsi$ifc$navigation$DSINavigationListener = ShieldDsiHandler.class$("org.dsi.ifc.navigation.DSINavigationListener")) : class$org$dsi$ifc$navigation$DSINavigationListener, this.dsiNavigationListener);
        this.dsiNavigation.setNotification(new int[]{8}, (DSIListener)this.dsiNavigationListener);
    }

    private void initDSISearch() {
        DSIProxy dSIProxy = DSIProxyFactory.getDSIProxyAPI().getDSIProxy();
        this.dsiSearch = (DSISearch)dSIProxy.getService(this, class$org$dsi$ifc$search$DSISearch == null ? (class$org$dsi$ifc$search$DSISearch = ShieldDsiHandler.class$("org.dsi.ifc.search.DSISearch")) : class$org$dsi$ifc$search$DSISearch);
        this.dsiSearchListener = ServiceManager.dsiServiceLocator.getAdapterFactory().createDSIListenerMethodAdapter(this, class$org$dsi$ifc$search$DSISearchListener == null ? (class$org$dsi$ifc$search$DSISearchListener = ShieldDsiHandler.class$("org.dsi.ifc.search.DSISearchListener")) : class$org$dsi$ifc$search$DSISearchListener);
        dSIProxy.addResponseListener(this, class$org$dsi$ifc$search$DSISearchListener == null ? (class$org$dsi$ifc$search$DSISearchListener = ShieldDsiHandler.class$("org.dsi.ifc.search.DSISearchListener")) : class$org$dsi$ifc$search$DSISearchListener, this.dsiSearchListener);
        this.dsiSearch.setNotification(new int[]{1}, this.dsiSearchListener);
    }

    private void initDSIAsiaInput() {
        DSIProxy dSIProxy = DSIProxyFactory.getDSIProxyAPI().getDSIProxy();
        this.dsiAsiaInput = (DSIAsiaInput)dSIProxy.getService(this, class$org$dsi$ifc$asiainput$DSIAsiaInput == null ? (class$org$dsi$ifc$asiainput$DSIAsiaInput = ShieldDsiHandler.class$("org.dsi.ifc.asiainput.DSIAsiaInput")) : class$org$dsi$ifc$asiainput$DSIAsiaInput);
        this.dsiAsiaInputListener = ServiceManager.dsiServiceLocator.getAdapterFactory().createDSIListenerMethodAdapter(this, class$org$dsi$ifc$asiainput$DSIAsiaInputListener == null ? (class$org$dsi$ifc$asiainput$DSIAsiaInputListener = ShieldDsiHandler.class$("org.dsi.ifc.asiainput.DSIAsiaInputListener")) : class$org$dsi$ifc$asiainput$DSIAsiaInputListener);
        dSIProxy.addResponseListener(this, class$org$dsi$ifc$asiainput$DSIAsiaInputListener == null ? (class$org$dsi$ifc$asiainput$DSIAsiaInputListener = ShieldDsiHandler.class$("org.dsi.ifc.asiainput.DSIAsiaInputListener")) : class$org$dsi$ifc$asiainput$DSIAsiaInputListener, this.dsiAsiaInputListener);
    }

    @Override
    public void unregistered(String string, int n) {
        if (this.isTraceEnabled()) {
            this.trace().append("TargetShield tries to unregister from ").append(string).append("...").log();
        }
        try {
            DSIProxy dSIProxy = DSIProxyFactory.getDSIProxyAPI().getDSIProxy();
            if (dSIProxy == null) {
                this.trace().append("DSIProxy was null!");
                return;
            }
            if (string.intern() == (class$org$dsi$ifc$search$DSISearch == null ? (class$org$dsi$ifc$search$DSISearch = ShieldDsiHandler.class$("org.dsi.ifc.search.DSISearch")) : class$org$dsi$ifc$search$DSISearch).getName().intern()) {
                this.unregisterDsiSearch(string, dSIProxy);
            }
            if (string.intern() == (class$org$dsi$ifc$navigation$DSINavigation == null ? (class$org$dsi$ifc$navigation$DSINavigation = ShieldDsiHandler.class$("org.dsi.ifc.navigation.DSINavigation")) : class$org$dsi$ifc$navigation$DSINavigation).getName().intern()) {
                this.unregisterDsiNavigation(string, dSIProxy);
            }
            if (this.isDsiAsiaInputAvaliable && string.intern() == (class$org$dsi$ifc$asiainput$DSIAsiaInput == null ? (class$org$dsi$ifc$asiainput$DSIAsiaInput = ShieldDsiHandler.class$("org.dsi.ifc.asiainput.DSIAsiaInput")) : class$org$dsi$ifc$asiainput$DSIAsiaInput).getName().intern()) {
                this.unregisterDsiAsiaInput(string, dSIProxy);
            }
        }
        catch (Exception exception) {
            ShieldDsiHandler.printTrace(new StringBuffer("TargetShield uregistered event: Exception removing listeners from proxy."));
            ServiceManager.errorHandler.handleDsiError(exception);
        }
    }

    private void unregisterDsiSearch(String string, DSIProxy dSIProxy) {
        if (this.dsiSearchListener != null) {
            dSIProxy.removeResponseListener(this, class$org$dsi$ifc$search$DSISearchListener == null ? (class$org$dsi$ifc$search$DSISearchListener = ShieldDsiHandler.class$("org.dsi.ifc.search.DSISearchListener")) : class$org$dsi$ifc$search$DSISearchListener, this.dsiSearchListener);
            this.dsiSearchListener = null;
        }
        this.traceUnregisteredDone(string);
    }

    private void unregisterDsiNavigation(String string, DSIProxy dSIProxy) {
        if (this.dsiNavigationListener != null) {
            dSIProxy.removeResponseListener(this, class$org$dsi$ifc$navigation$DSINavigationListener == null ? (class$org$dsi$ifc$navigation$DSINavigationListener = ShieldDsiHandler.class$("org.dsi.ifc.navigation.DSINavigationListener")) : class$org$dsi$ifc$navigation$DSINavigationListener, this.dsiNavigationListener);
            this.traceUnregisteredDone(string);
        }
        this.traceUnregisteredDone(string);
    }

    private void unregisterDsiAsiaInput(String string, DSIProxy dSIProxy) {
        if (this.dsiAsiaInputListener != null) {
            dSIProxy.removeResponseListener(this, class$org$dsi$ifc$asiainput$DSIAsiaInputListener == null ? (class$org$dsi$ifc$asiainput$DSIAsiaInputListener = ShieldDsiHandler.class$("org.dsi.ifc.asiainput.DSIAsiaInputListener")) : class$org$dsi$ifc$asiainput$DSIAsiaInputListener, this.dsiAsiaInputListener);
            this.traceUnregisteredDone(string);
        }
        this.traceUnregisteredDone(string);
    }

    private void traceUnregisteredDone(String string) {
        if (this.isTraceEnabled()) {
            this.trace().append("TargetShield unregistered from ").append(string).log();
        }
    }

    public void dsiSearchSearchResult(int n, SearchResult searchResult) {
        if (searchResult.queryId == this.lastQueryId) {
            this.shieldTarget.handleSearchResultReceived(searchResult);
        }
    }

    public void dsiSearchUpdateSearchIsActive(int n, boolean bl, int n2) {
        if (n == this.lastQueryId) {
            ShieldDsiHandler.printTrace(new StringBuffer(new StringBuffer().append("UPDATE:n For latest search (queryId=").append(n).append(") SearchIsActive = ").toString()).append(bl));
            this.shieldTarget.handleSearchIsActive(bl);
        } else {
            ShieldDsiHandler.printTrace(new StringBuffer(new StringBuffer().append("UPDATE: For old search (queryId=").append(n).append(") SearchIsActive = ").toString()).append(bl));
        }
    }

    public void dsiSearchCancelQueryResult(int n, int n2) {
        this.shieldTarget.handleCancelQueryResult(n, n2);
    }

    public void dsiSearchSetCurrentPositionResult(int n) {
        this.shieldTarget.handleSetCurrentPositionResult(n);
    }

    @Override
    public void handleCommandCmdSetCurrentLD(CmdSetCurrentLD cmdSetCurrentLD) {
        this.shieldTarget.handleLiCurrentState(cmdSetCurrentLD.liCurrentState_availableSelectionCriteria, cmdSetCurrentLD.liCurrentState_usefulRefinementCriteria, cmdSetCurrentLD.liCurrentState_liCurrentLD);
    }

    public void dsiSearchRequestSupportedCountriesResult(int n, Country[] countryArray) {
        if (this.dsiSearch != null) {
            String[] stringArray = new String[countryArray.length];
            for (int i2 = 0; i2 < countryArray.length; ++i2) {
                stringArray[i2] = countryArray[i2].code;
            }
            this.dsiSearch.setActiveSearchCountries(stringArray);
        }
    }

    public void dsiSearchSetActiveSearchCountriesResult(int n) {
        this.shieldTarget.handleCountriesSet();
    }

    public void dsiNavigationUpdateDmLastDestinationsList(LDListElement[] lDListElementArray, int n) {
        this.shieldTarget.handleLastDestinationsUpdate(lDListElementArray);
    }

    @Override
    public void handleCommandCmdDmLastDestinationsGet(CmdDmLastDestinationsGet cmdDmLastDestinationsGet) {
        if (cmdDmLastDestinationsGet.dmLastDestinationsGetResult_resultCode != 0L) {
            logger.makeError().append(new StringBuffer().append("dsiNavigationDmLastDestinationsGetResult: ResultCode is: ").append(cmdDmLastDestinationsGet.dmLastDestinationsGetResult_resultCode).toString()).log();
            return;
        }
        this.shieldTarget.handleLastDestionationUpdate(cmdDmLastDestinationsGet.dmLastDestinationsGetResult_destination);
    }

    /*
     * Enabled aggressive block sorting
     */
    public void startQuery(String string) {
        if (null == this.dsiSearch) return;
        if (!this.isDsiAsiaInputAvaliable) {
            SearchQuery searchQuery = this.createNewQueryUsingNeedle(string);
            this.dsiSearch.search(searchQuery);
            return;
        }
        if (null == this.dsiAsiaInput) {
            logger.makeError().append("startQuery: dsiAsiaInput is null! ").log();
            return;
        }
        String string2 = ASLNavigationUtilFactory.getNavigationUtilApi().getLanguage();
        if (this.wordSegmentationSupportedLanguages.contains(string2)) {
            this.dsiAsiaInput.requestSegmentationForTruffles(string);
            return;
        }
        SearchQuery searchQuery = this.createNewQueryUsingNeedle(string);
        this.dsiSearch.search(searchQuery);
    }

    public SearchQuery createNewQueryUsingNeedle(String string) {
        int n = this.isChnEnabled && this.isHigh ? 50 : 25;
        SearchQuery searchQuery = new SearchQuery(++this.lastQueryId, new int[]{4, 16}, string, null, 0, n, true, 2, this.matchingMode, null);
        return searchQuery;
    }

    public void setCurrentPosition(NavPosition navPosition) {
        if (this.dsiSearch != null) {
            this.dsiSearch.setCurrentPosition(navPosition);
        }
    }

    public void cancelQuery() {
        if (this.dsiSearch != null) {
            this.dsiSearch.cancelQuery(this.lastQueryId);
        }
    }

    public void configureDsiSearch() {
        if (this.dsiSearch != null) {
            if (this.environment != null) {
                this.dsiSearch.setEnvironment(this.environment);
            } else {
                this.extractEnvironment();
            }
        }
    }

    public void dsiAsiaInputResponseSegmentationForTruffles(String string) {
        SearchQuery searchQuery = this.createNewQueryUsingNeedle(string);
        this.dsiSearch.search(searchQuery);
    }

    public void dsiSearchSetEnvironmentResult(int n) {
        this.dsiSearch.prepareSources(new int[]{4, 16});
    }

    public void dsiSearchPrepareSourcesResult(int n) {
        String string = ASLNavigationUtilFactory.getNavigationUtilApi().getLanguage();
        this.matchingMode = this.asianLanguages.contains(string) ? 1 : 0;
        this.dsiSearch.setLanguage(string);
    }

    public void dsiSearchSetLanguageResult(int n) {
        this.dsiSearch.setActiveProfile(0);
    }

    public void dsiSearchSetActiveProfileResult(int n) {
        this.dsiSearch.requestSupportedCountries();
    }

    public void dmLastDestionsGet(long l) {
        new CmdDmLastDestinationsGet(this, l).execute();
    }

    public void liSetCurrentLd(NavLocation navLocation) {
        new CmdSetCurrentLD(this, navLocation).execute();
    }

    public void resetSettingsForNavi() {
        if (this.dsiSearch != null) {
            this.dsiSearch.removeAllFromHistory();
        }
    }

    public void resetSettingsForFullFactoryReset() {
        new CmdDmLastDestinationsDeleteAll(this).execute();
    }

    static void printTrace(StringBuffer stringBuffer) {
        if (logger.isTraceEnabled()) {
            logger.makeTrace().append(stringBuffer.toString()).log();
        }
    }

    public void setEnvironment(Environment environment) {
        this.environment = environment;
    }

    public Environment getEnvironment() {
        return this.environment;
    }

    @Override
    public void reset(HashMap hashMap) {
        boolean bl = this.isDsiInHashMap(hashMap, (class$org$dsi$ifc$search$DSISearch == null ? (class$org$dsi$ifc$search$DSISearch = ShieldDsiHandler.class$("org.dsi.ifc.search.DSISearch")) : class$org$dsi$ifc$search$DSISearch).getName(), 0);
        boolean bl2 = this.isDsiInHashMap(hashMap, (class$org$dsi$ifc$navigation$DSINavigation == null ? (class$org$dsi$ifc$navigation$DSINavigation = ShieldDsiHandler.class$("org.dsi.ifc.navigation.DSINavigation")) : class$org$dsi$ifc$navigation$DSINavigation).getName(), 0);
        boolean bl3 = this.isDsiInHashMap(hashMap, (class$org$dsi$ifc$asiainput$DSIAsiaInput == null ? (class$org$dsi$ifc$asiainput$DSIAsiaInput = ShieldDsiHandler.class$("org.dsi.ifc.asiainput.DSIAsiaInput")) : class$org$dsi$ifc$asiainput$DSIAsiaInput).getName(), 0);
        if (bl || bl2 || bl3) {
            if (this.isTraceEnabled()) {
                this.trace("ShieldDsiHandler: resetting values after DSI restart");
            }
            if (bl) {
                this.initLocalVariables();
                this.initDSISearch();
                this.configureDsiSearch();
            }
            if (bl2) {
                this.initDSINavigation();
            }
            if (bl3) {
                this.initDSIAsiaInput();
            }
        } else if (this.isTraceEnabled()) {
            this.trace("ShieldDsiHandler: no reset necessary because restarted DSI(s) is/are not used in target");
        }
    }

    private void initLocalVariables() {
        this.environment = null;
        this.lastQueryId = 0;
    }

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError().initCause(classNotFoundException);
        }
    }
}

