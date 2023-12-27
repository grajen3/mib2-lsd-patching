/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.slde;

import de.vw.mib.asl.api.navigation.ASLNavigationTruffelFactory;
import de.vw.mib.asl.api.navigation.poi.ASLNavigationPoiFactory;
import de.vw.mib.asl.api.navigation.util.ASLNavigationUtilFactory;
import de.vw.mib.asl.api.navigation.util.IExtLogger;
import de.vw.mib.asl.api.navigation.util.ReloadPersistedDataListener;
import de.vw.mib.asl.framework.internal.framework.AbstractASLTarget;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.navigation.slde.SldeEvents;
import de.vw.mib.asl.internal.navigation.slde.SldeProxyModule;
import de.vw.mib.asl.internal.navigation.slde.SldeProxyModuleOnline;
import de.vw.mib.asl.internal.navigation.slde.SldeProxyModulePoi;
import de.vw.mib.asl.internal.navigation.slde.SldeProxyModuleShield;
import de.vw.mib.asl.internal.navigation.slde.SldeSpellerDsiHandler;
import de.vw.mib.asl.internal.navigation.slde.SldeSpellerHandler;
import de.vw.mib.asl.internal.navigation.slde.SpellerDataChangedListener;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.GenericEvents;
import de.vw.mib.properties.values.SpellerData;
import java.util.LinkedHashMap;
import java.util.Vector;
import org.dsi.ifc.global.NavLocation;

public class SldeProxyTarget
extends AbstractASLTarget
implements SpellerDataChangedListener,
ReloadPersistedDataListener {
    private SldeSpellerHandler spellerHandler = SldeSpellerHandler.getInstance();
    private SldeSpellerDsiHandler spellerDsiHandler;
    private int currentSearchMode = -1;
    private LinkedHashMap proxyModules;
    private SldeProxyModule activeProxyModule;
    private IExtLogger logger = ASLNavigationUtilFactory.getNavigationUtilApi().getExtLogger(16384, "SldeProxy");

    public SldeProxyTarget(GenericEvents genericEvents, int n, String string) {
        super(genericEvents, n, string);
        this.spellerDsiHandler = new SldeSpellerDsiHandler(genericEvents, n);
        this.spellerHandler.addSpellerTextChangedListener(this);
        this.proxyModules = new LinkedHashMap();
        SldeProxyModuleShield sldeProxyModuleShield = new SldeProxyModuleShield();
        SldeProxyModulePoi sldeProxyModulePoi = new SldeProxyModulePoi();
        SldeProxyModuleOnline sldeProxyModuleOnline = new SldeProxyModuleOnline();
        this.proxyModules.put(new Integer(0), sldeProxyModuleShield);
        this.proxyModules.put(new Integer(3), sldeProxyModuleShield);
        this.proxyModules.put(new Integer(1), sldeProxyModulePoi);
        this.proxyModules.put(new Integer(2), sldeProxyModuleOnline);
        this.proxyModules.put(new Integer(4), sldeProxyModuleOnline);
        ASLNavigationUtilFactory.getNavigationUtilApi().getNavigationDp().addReloadPersistedDataListener(this);
    }

    @Override
    public void gotEvent(EventGeneric eventGeneric) {
        switch (eventGeneric.getReceiverEventId()) {
            case 101003: {
                this.handleTargetPrepareOn();
                break;
            }
            case 1074841946: {
                this.handleSetupSlde(eventGeneric);
                break;
            }
            case 1074841928: {
                this.spellerDsiHandler.handleHwrSpellerModeEnabled(eventGeneric);
                break;
            }
            case 1074841941: {
                this.handleSwitchToMapResultView();
                break;
            }
            case 1074841926: {
                this.handleCancelSearch();
                break;
            }
            case 1074841940: {
                this.handleRequestNextPage();
                break;
            }
            case 1074841892: {
                this.handleListSelectById(eventGeneric);
                break;
            }
            case 1074841947: {
                this.handleReturnToDualList();
                break;
            }
            case 3484001: {
                this.handleExternalResultResolved(eventGeneric);
                break;
            }
            case 1074841963: {
                this.handleShowSLDESpellerHelp(eventGeneric);
                break;
            }
        }
    }

    private void handleTargetPrepareOn() {
        SldeEvents.addObservers(this);
        this.setSldeHelpValueToModel();
    }

    private void setSldeHelpValueToModel() {
        boolean bl = ASLNavigationUtilFactory.getNavigationUtilApi().getNavigationDp().getPersonalNaviPersistence().isShowSldeHelp();
        ServiceManager.aslPropertyManager.valueChangedBoolean(-1041231872, bl);
    }

    private void handleShowSLDESpellerHelp(EventGeneric eventGeneric) {
        boolean bl = eventGeneric.getBoolean(0);
        this.printTrace(new StringBuffer().append("handleShowSLDESpellerHelp with parameter: ").append(bl).toString());
        if (!bl) {
            ServiceManager.aslPropertyManager.valueChangedBoolean(-1041231872, false);
            ASLNavigationUtilFactory.getNavigationUtilApi().getNavigationDp().getPersonalNaviPersistence().setShowSldeHelp(false);
        } else {
            ServiceManager.aslPropertyManager.valueChangedBoolean(-1041231872, true);
            ASLNavigationUtilFactory.getNavigationUtilApi().getNavigationDp().getPersonalNaviPersistence().setShowSldeHelp(true);
        }
    }

    private void handleReturnToDualList() {
        this.printTrace("handleReturnToDualList");
        this.activeProxyModule.handleReturnToDualList();
    }

    private void handleExternalResultResolved(EventGeneric eventGeneric) {
        Integer n = (Integer)eventGeneric.getObject(1663644928);
        NavLocation navLocation = (NavLocation)eventGeneric.getObject(1646867712);
        ASLNavigationTruffelFactory.getNavigationTruffelApi().setSelectedSearchResult(navLocation, n);
    }

    private void handleCancelSearch() {
        this.printTrace(new StringBuffer().append("cancelSearch for searchmode ").append(this.currentSearchMode).toString());
        this.activeProxyModule.handleCancelSearch();
    }

    private void handleListSelectById(EventGeneric eventGeneric) {
        this.printTrace(new StringBuffer().append("handleListSelectById for searchmode ").append(this.currentSearchMode).toString());
        this.activeProxyModule.handleListSelectById(eventGeneric);
    }

    private void handleRequestNextPage() {
        this.printTrace(new StringBuffer().append("handleRequestNextPage current mode: ").append(this.currentSearchMode).toString());
        this.activeProxyModule.handleRequestNextPage();
    }

    private void handleSwitchToMapResultView() {
        this.printTrace(new StringBuffer().append("handleSwitchToMapResultView current mode: ").append(this.currentSearchMode).toString());
        this.setMapDisabled();
        this.activeProxyModule.handleSwitchToMapResultView();
    }

    private void handleSetupSlde(EventGeneric eventGeneric) {
        int n = eventGeneric.getInt(0);
        int n2 = eventGeneric.getInt(1);
        this.printTrace(new StringBuffer().append("setupSlde for type ").append(n).append(" with configuration=").append(n2).toString());
        if (this.activeProxyModule != null) {
            if (this.currentSearchMode != n || n2 == 0 || n2 == 1 || n2 == 3 || n2 == 4 || n2 == 5) {
                this.activeProxyModule.stopSearch();
            }
            this.activeProxyModule.allowReceivingEvents(false);
        }
        this.currentSearchMode = n;
        this.activeProxyModule = (SldeProxyModule)this.proxyModules.get(new Integer(n));
        this.activeProxyModule.allowReceivingEvents(true);
        switch (n2) {
            case 0: {
                this.spellerHandler.clearSpellerData();
                this.clearResultList();
                break;
            }
            case 2: {
                break;
            }
            case 1: {
                this.clearResultList();
                break;
            }
            case 3: {
                this.clearResultList();
                break;
            }
            case 4: {
                this.spellerHandler.clearSpellerData();
                this.clearResultList();
                break;
            }
            case 5: {
                this.spellerHandler.clearSpellerData();
                this.clearResultList();
                break;
            }
        }
        this.activeProxyModule.setupSlde(eventGeneric);
        ServiceManager.aslPropertyManager.valueChangedInteger(-1829761024, n);
    }

    private void setMapDisabled() {
        this.printTrace("setMapEnabled");
        ServiceManager.aslPropertyManager.valueChangedBoolean(-84996096, false);
        ServiceManager.aslPropertyManager.valueChangedBoolean(519049216, false);
    }

    void clearResultList() {
        this.printTrace("clearResultList");
        ASLNavigationTruffelFactory.getNavigationTruffelApi().setSearchResults(new Vector(), true, ASLNavigationUtilFactory.getNavigationUtilApi().getNavGateway().getSoPosPositionDescription(), false);
    }

    @Override
    public void spellerDataChanged(SpellerData spellerData) {
    }

    @Override
    public void spellerTextChanged(SpellerData spellerData) {
        this.printTrace("spellerTextChanged");
        this.activeProxyModule.spellerTextChanged(spellerData);
    }

    @Override
    public void initXt9Finished() {
        if (this.activeProxyModule != null) {
            this.activeProxyModule.initXt9Finished();
        } else {
            ASLNavigationPoiFactory.getNavigationPoiApi().initXt9Finished();
        }
    }

    private void printTrace(String string) {
        if (this.logger.isTraceEnabled()) {
            this.logger.makeTrace().append(string).log();
        }
    }

    @Override
    public void reloadPersistedData() {
        this.setSldeHelpValueToModel();
    }
}

