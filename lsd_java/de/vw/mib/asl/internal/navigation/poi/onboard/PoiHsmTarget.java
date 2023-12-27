/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.poi.onboard;

import de.vw.mib.asl.api.navigation.poi.IPoiOnboardSearchResultListener;
import de.vw.mib.asl.framework.api.dsiproxy.DSIProxy;
import de.vw.mib.asl.framework.api.dsiproxy.DSIProxyFactory;
import de.vw.mib.asl.framework.api.dsiproxy.DSIServiceStateListener;
import de.vw.mib.asl.framework.api.framework.ASLFrameworkFactory;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.navigation.AbstractResettableAslHsmTarget;
import de.vw.mib.asl.internal.navigation.gateway.Command;
import de.vw.mib.asl.internal.navigation.gateway.command.CmdPoiSelectSelectionCriteria;
import de.vw.mib.asl.internal.navigation.gateway.command.CmdSetLiValueListWindowSize;
import de.vw.mib.asl.internal.navigation.poi.onboard.PoiAbstractHsmState;
import de.vw.mib.asl.internal.navigation.poi.onboard.PoiDatapool;
import de.vw.mib.asl.internal.navigation.poi.onboard.PoiHsmTarget$1;
import de.vw.mib.asl.internal.navigation.poi.onboard.PoiHsmTarget$2;
import de.vw.mib.asl.internal.navigation.poi.onboard.PoiNotifierModel;
import de.vw.mib.asl.internal.navigation.poi.onboard.PoiStateCategory;
import de.vw.mib.asl.internal.navigation.poi.onboard.PoiStateCategoryGroup;
import de.vw.mib.asl.internal.navigation.poi.onboard.PoiStateCategoryLevel;
import de.vw.mib.asl.internal.navigation.poi.onboard.PoiStateDetail;
import de.vw.mib.asl.internal.navigation.poi.onboard.PoiStateElementNoSurrounding;
import de.vw.mib.asl.internal.navigation.poi.onboard.PoiStateElementSurrounding;
import de.vw.mib.asl.internal.navigation.poi.onboard.PoiStateFreetextSpeller;
import de.vw.mib.asl.internal.navigation.poi.onboard.PoiStateMain;
import de.vw.mib.asl.internal.navigation.poi.onboard.PoiStateRequestTopCategories;
import de.vw.mib.asl.internal.navigation.poi.onboard.PoiStateSelectFromResultList;
import de.vw.mib.asl.internal.navigation.poi.onboard.PoiStateStartUseCase;
import de.vw.mib.asl.internal.navigation.poi.onboard.PoiStateSubElementNoSurrounding;
import de.vw.mib.asl.internal.navigation.poi.onboard.PoiStateSubElementRestore;
import de.vw.mib.asl.internal.navigation.poi.onboard.PoiStateSubElementSurrounding;
import de.vw.mib.asl.internal.navigation.util.WeakIdentityHashSet;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.GenericEvents;
import de.vw.mib.genericevents.hsm.AbstractHsmState;
import de.vw.mib.genericevents.hsm.HsmState;
import de.vw.mib.log4mib.LogMessage;
import java.util.HashMap;
import java.util.Iterator;
import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.global.NavLocation;
import org.dsi.ifc.navigation.DSINavigation;
import org.dsi.ifc.navigation.LIValueList;
import org.dsi.ifc.navigation.ValueListStatus;
import org.osgi.framework.BundleContext;
import org.osgi.util.tracker.ServiceTracker;
import org.osgi.util.tracker.ServiceTrackerCustomizer;

public final class PoiHsmTarget
extends AbstractResettableAslHsmTarget
implements DSIServiceStateListener {
    static WeakIdentityHashSet listeners = new WeakIdentityHashSet();
    private static final int[] ATTRIBUTES_NAVIGATION = new int[]{62, 11, 91, 52};
    EventGeneric blockedGoOnEvent = null;
    private DSINavigation dsiNavigation;
    private DSIListener dsiNavigationListener;
    protected final PoiNotifierModel notifierModel;
    private int lastLiValueWindowSize = -1;
    final HsmState stateMain = new PoiStateMain(this, this.hsm, "stateMain", this.getWorkStateParent());
    final HsmState statePoiStartUseCase = new PoiStateStartUseCase(this, this.hsm, "statePoiStartUseCase", this.stateMain);
    final HsmState statePoiCategoryLevel = new PoiStateCategoryLevel(this, this.hsm, "statePoiCategoryLevel", this.stateMain);
    final HsmState statePoiCategoryGroup = new PoiStateCategoryGroup(this, this.hsm, "statePoiCategoryGroup", this.statePoiCategoryLevel);
    final HsmState statePoiCategory = new PoiStateCategory(this, this.hsm, "statePoiCategory", this.statePoiCategoryLevel);
    final PoiStateElementSurrounding statePoiElementSurrounding = new PoiStateElementSurrounding(this, this.hsm, "statePoiElementSurrounding", this.stateMain);
    final HsmState statePoiElementNoSurrounding = new PoiStateElementNoSurrounding(this, this.hsm, "statePoiElementNoSurrounding", this.stateMain);
    final HsmState statePoiSubElementSurrounding = new PoiStateSubElementSurrounding(this, this.hsm, "statePoiSubElementSurrounding", this.stateMain);
    final HsmState statePoiSubElementNoSurrounding = new PoiStateSubElementNoSurrounding(this, this.hsm, "statePoiSubElementNoSurrounding", this.stateMain);
    final HsmState statePoiSubElementRestore = new PoiStateSubElementRestore(this, this.hsm, "statePoiSubElementRestore", this.stateMain);
    final HsmState statePoiSelectFromResultList = new PoiStateSelectFromResultList(this, this.hsm, "statePoiSelectFromResultList", this.stateMain);
    final HsmState statePoiTopCategories = new PoiStateRequestTopCategories(this, this.hsm, "statePoiTopCategories", this.stateMain);
    final HsmState statePoiDetail = new PoiStateDetail(this, this.hsm, "statePoiDetail", this.stateMain);
    final HsmState statePoiFreetextSpeller = new PoiStateFreetextSpeller(this, this.hsm, "statePoiFreetextSpeller", this.stateMain);
    static /* synthetic */ Class class$org$dsi$ifc$navigation$DSINavigation;
    static /* synthetic */ Class class$org$dsi$ifc$navigation$DSINavigationListener;
    static /* synthetic */ Class class$de$vw$mib$asl$api$speechengine$SpeechEngine;

    public static void registerPoiOnboardSearchResultListener(IPoiOnboardSearchResultListener iPoiOnboardSearchResultListener) {
        listeners.add(iPoiOnboardSearchResultListener);
    }

    public static void unregisterPoiOnboardSearchResultListener(IPoiOnboardSearchResultListener iPoiOnboardSearchResultListener) {
        listeners.remove(iPoiOnboardSearchResultListener);
    }

    public static void handleOnboardPoiStatusResult(ValueListStatus valueListStatus) {
        Iterator iterator = listeners.iterator();
        while (iterator.hasNext()) {
            IPoiOnboardSearchResultListener iPoiOnboardSearchResultListener = (IPoiOnboardSearchResultListener)iterator.next();
            iPoiOnboardSearchResultListener.updateOnboardPoiStatus(valueListStatus);
        }
    }

    public static void handleOnboardValueList(LIValueList lIValueList, int n) {
        Iterator iterator = listeners.iterator();
        while (iterator.hasNext()) {
            IPoiOnboardSearchResultListener iPoiOnboardSearchResultListener = (IPoiOnboardSearchResultListener)iterator.next();
            iPoiOnboardSearchResultListener.liValueListBlock(lIValueList, n);
        }
    }

    public static void handleOnboardPoiResult(NavLocation navLocation) {
        Iterator iterator = listeners.iterator();
        while (iterator.hasNext()) {
            IPoiOnboardSearchResultListener iPoiOnboardSearchResultListener = (IPoiOnboardSearchResultListener)iterator.next();
            iPoiOnboardSearchResultListener.resolvePoiResult(navLocation);
        }
    }

    public PoiHsmTarget(GenericEvents genericEvents, int n, String string) {
        super(genericEvents, n, string);
        this.notifierModel = new PoiNotifierModel();
        this.notifierModel.notifySearchStateFound();
    }

    @Override
    protected HsmState getDefaultState() {
        return this.stateMain;
    }

    @Override
    public int getSubClassifier() {
        return 512;
    }

    public LogMessage makeTrace(AbstractHsmState abstractHsmState) {
        String string = "";
        if (abstractHsmState != null) {
            string = super.getClass().toString();
            string = string.substring(string.lastIndexOf(46) + 1);
        }
        return this.trace().append("[PoiHsmTarget]  State:").append(string).append("  - ");
    }

    public LogMessage makeError(AbstractHsmState abstractHsmState) {
        String string = "";
        if (abstractHsmState != null) {
            string = super.getClass().toString();
            string = string.substring(string.lastIndexOf(46) + 1);
        }
        return this.error().append("[PoiHsmTarget]  State:").append(string).append("  - ");
    }

    public void myTrace(AbstractHsmState abstractHsmState, String string) {
        if (!this.getTextLogger().isTraceEnabled(this.getSubClassifier())) {
            return;
        }
        String string2 = "";
        if (abstractHsmState != null) {
            string2 = super.getClass().toString();
            string2 = string2.substring(string2.lastIndexOf(46) + 1);
        }
        this.trace().append("[PoiHsmTarget]  State:").append(string2).append("  - ").append(string).log();
    }

    public void myError(AbstractHsmState abstractHsmState, String string) {
        if (!this.getTextLogger().isTraceEnabled(this.getSubClassifier())) {
            return;
        }
        String string2 = "";
        if (abstractHsmState != null) {
            string2 = super.getClass().toString();
            string2 = string2.substring(string2.lastIndexOf(46) + 1);
        }
        this.error().append("[PoiHsmTarget]  State:").append(string2).append("  - ").append(string).log();
    }

    public void myCmdTrace(AbstractHsmState abstractHsmState, Command command) {
        if (!this.getTextLogger().isTraceEnabled(this.getSubClassifier())) {
            return;
        }
        String string = "";
        String string2 = "";
        if (abstractHsmState != null) {
            string = super.getClass().toString();
            string = string.substring(string.lastIndexOf(46) + 1);
            string2 = super.getClass().toString();
            string2 = string2.substring(string.lastIndexOf(46) + 1);
        }
        this.trace().append("[PoiHsmTarget]  State:").append(string).append("  - handleCommand ").append(string2).append("  (").append(command.getElapsedTimeInMs()).append("ms)").log();
    }

    void transAfterCallback(HsmState hsmState) {
        try {
            if (this.getTextLogger().isTraceEnabled(this.getSubClassifier())) {
                this.trace().append("transitioning to state '").append(hsmState.getName()).append("'").log();
            }
            EventGeneric eventGeneric = ServiceManager.mGenericEventFactory.newEvent(-1803026176);
            eventGeneric.setObject(0, hsmState);
            this.triggerMe(eventGeneric, -1803026176);
        }
        catch (Exception exception) {
            this.error("cannot transition to new state");
            this.error(exception.toString());
        }
    }

    public void handleLIResult(AbstractHsmState abstractHsmState, int n) {
        switch (n) {
            case 0: {
                this.myTrace(abstractHsmState, "LIResult - Navi is operable");
                break;
            }
            case 1: {
                this.myError(abstractHsmState, "LIResult - Database not operable!");
                break;
            }
            case 2: {
                this.myError(abstractHsmState, "LIResult - Navi error!");
                break;
            }
            default: {
                this.myError(abstractHsmState, "LIResult - unknown error!");
            }
        }
    }

    public boolean selectCriterionInPOIValueList(PoiAbstractHsmState poiAbstractHsmState, LIValueList lIValueList, int n) {
        this.makeTrace(poiAbstractHsmState).append("selectCriterionInPOIValueList: criterion=").append(n).append("; liValueList= ").append(lIValueList).log();
        boolean bl = false;
        LIValueList lIValueList2 = lIValueList;
        int n2 = -1;
        boolean bl2 = false;
        if (lIValueList2 != null && lIValueList2.list != null) {
            if (this.getTextLogger().isTraceEnabled(this.getSubClassifier())) {
                this.makeTrace(poiAbstractHsmState).append("Length of LIValueList:").append(lIValueList2.list.length).log();
            }
            for (n2 = 0; n2 < lIValueList2.list.length; ++n2) {
                if (lIValueList2.list[n2] != null) {
                    if (lIValueList2.list[n2].criteriaNumber != n) continue;
                    bl2 = true;
                    break;
                }
                if (!this.getTextLogger().isTraceEnabled(this.getSubClassifier())) continue;
                this.makeError(poiAbstractHsmState).append("LIValueList.list[").append(n2).append("] = null!").log();
            }
        } else {
            this.myError(null, "LIValueList == null!");
        }
        if (bl2) {
            new CmdPoiSelectSelectionCriteria(poiAbstractHsmState, n2).execute();
            bl = true;
        } else {
            this.statePoiElementSurrounding.setWaitWithCancelSpeller(false);
            if (this.getTextLogger().isTraceEnabled(this.getSubClassifier())) {
                this.makeTrace(poiAbstractHsmState).append("Selection criterion ").append(n).append(" not available!").log();
            }
        }
        return bl;
    }

    public void clearAllModelData() {
        ((PoiStateCategoryGroup)this.statePoiCategoryGroup).clearModelData();
        ((PoiStateCategory)this.statePoiCategory).clearModelData();
        this.statePoiElementSurrounding.clearModelData();
        ((PoiStateSubElementSurrounding)this.statePoiSubElementSurrounding).clearModelData();
        ((PoiStateDetail)this.statePoiDetail).clearModelData();
        this.notifierModel.notifyNameFilter(PoiDatapool.getInstance().getEnteredName());
        this.notifierModel.notifySpellerData(PoiDatapool.getInstance().getSpellerData());
        this.notifierModel.notifyShowAllAvailable();
        PoiStateElementSurrounding.setListSelectionIndex(0);
    }

    @Override
    public void registered(String string, int n) {
        if (string.equals((class$org$dsi$ifc$navigation$DSINavigation == null ? (class$org$dsi$ifc$navigation$DSINavigation = PoiHsmTarget.class$("org.dsi.ifc.navigation.DSINavigation")) : class$org$dsi$ifc$navigation$DSINavigation).getName()) && !this.isFirstStartupDone) {
            this.initDSINavigation();
            this.initSpeechEngine();
            this.isFirstStartupDone = true;
        }
    }

    private void initDSINavigation() {
        DSIProxy dSIProxy = DSIProxyFactory.getDSIProxyAPI().getDSIProxy();
        this.myTrace(null, "DSI_NAVIGATION service registered");
        this.dsiNavigation = (DSINavigation)dSIProxy.getService(this, class$org$dsi$ifc$navigation$DSINavigation == null ? (class$org$dsi$ifc$navigation$DSINavigation = PoiHsmTarget.class$("org.dsi.ifc.navigation.DSINavigation")) : class$org$dsi$ifc$navigation$DSINavigation);
        this.dsiNavigationListener = dSIProxy.getAdapterFactory().createDSIListenerMethodAdapter(this.getHsm(), class$org$dsi$ifc$navigation$DSINavigationListener == null ? (class$org$dsi$ifc$navigation$DSINavigationListener = PoiHsmTarget.class$("org.dsi.ifc.navigation.DSINavigationListener")) : class$org$dsi$ifc$navigation$DSINavigationListener);
        this.dsiNavigation.setNotification(ATTRIBUTES_NAVIGATION, this.dsiNavigationListener);
    }

    private void initSpeechEngine() {
        BundleContext bundleContext = ASLFrameworkFactory.getASLFrameworkAPI().getServices().getBundleContext();
        PoiHsmTarget$1 poiHsmTarget$1 = new PoiHsmTarget$1(this);
        ServiceTracker serviceTracker = new ServiceTracker(bundleContext, (class$de$vw$mib$asl$api$speechengine$SpeechEngine == null ? (class$de$vw$mib$asl$api$speechengine$SpeechEngine = PoiHsmTarget.class$("de.vw.mib.asl.api.speechengine.SpeechEngine")) : class$de$vw$mib$asl$api$speechengine$SpeechEngine).getName(), (ServiceTrackerCustomizer)new PoiHsmTarget$2(this, bundleContext, poiHsmTarget$1));
        serviceTracker.open();
    }

    @Override
    public void unregistered(String string, int n) {
        if (string.intern() == (class$org$dsi$ifc$navigation$DSINavigation == null ? (class$org$dsi$ifc$navigation$DSINavigation = PoiHsmTarget.class$("org.dsi.ifc.navigation.DSINavigation")) : class$org$dsi$ifc$navigation$DSINavigation).getName().intern()) {
            this.dsiNavigationListener = null;
            this.traceUnregisteredDone(string);
        }
    }

    private void traceUnregisteredDone(String string) {
        if (this.isTraceEnabled()) {
            this.trace().append("PoiHsmTarget unregistered from ").append(string).log();
        }
    }

    public DSINavigation getDsiNavigation() {
        return this.dsiNavigation;
    }

    public void setSortOrder(boolean bl) {
        if (bl) {
            this.myTrace(null, "POISORTORDER_NATURAL");
            this.getDsiNavigation().poiSetSortOrder2(0);
        } else {
            this.myTrace(null, "POISORTORDER_ALPHABETICALLY");
            this.getDsiNavigation().poiSetSortOrder2(1);
        }
    }

    public void initXt9OnboardFinished() {
        ((PoiStateMain)this.stateMain).initXt9OnboardFinished();
    }

    public void setLiValueListWindowSize(PoiAbstractHsmState poiAbstractHsmState, int n, boolean bl) {
        if (this.getTextLogger().isTraceEnabled(this.getSubClassifier())) {
            this.makeTrace(poiAbstractHsmState).append("setLiValueListWindowSize:").append(n).append(" init:").append(bl ? "true" : "false").log();
        }
        if (bl || this.lastLiValueWindowSize != n) {
            this.lastLiValueWindowSize = n;
            new CmdSetLiValueListWindowSize(poiAbstractHsmState, n).execute();
        }
    }

    @Override
    public void reset(HashMap hashMap) {
        if (this.isDsiInHashMap(hashMap, (class$org$dsi$ifc$navigation$DSINavigation == null ? (class$org$dsi$ifc$navigation$DSINavigation = PoiHsmTarget.class$("org.dsi.ifc.navigation.DSINavigation")) : class$org$dsi$ifc$navigation$DSINavigation).getName(), 0)) {
            if (this.isTraceEnabled()) {
                this.trace("PoiHsmTarget: resetting values after DSI restart");
            }
            this.resetHsmToState(this.getDefaultState());
            this.initLocalVariables();
            this.initDSINavigation();
        } else if (this.isTraceEnabled()) {
            this.trace("PoiHsmTarget: no reset necessary because restarted DSI(s) is/are not used in target");
        }
    }

    private void initLocalVariables() {
        this.lastLiValueWindowSize = -1;
    }

    public int getLastLiValueWindowSize() {
        return this.lastLiValueWindowSize;
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

