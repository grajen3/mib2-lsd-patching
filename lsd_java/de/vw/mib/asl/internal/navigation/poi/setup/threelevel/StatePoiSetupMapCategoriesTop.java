/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.poi.setup.threelevel;

import de.vw.mib.asl.framework.api.dsiproxy.DSIProxy;
import de.vw.mib.asl.framework.api.dsiproxy.DSIProxyFactory;
import de.vw.mib.asl.framework.api.dsiproxy.DSIServiceStateListener;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.navigation.poi.setup.threelevel.HsmTargetPoiSetupMapThreeLevelCategories;
import de.vw.mib.asl.internal.navigation.poi.setup.threelevel.StatePoiSetupMapCategoriesBase;
import de.vw.mib.asl.internal.navigation.poi.setup.threelevel.category.PoiCategories4DsiAndHmi;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.hsm.Hsm;
import de.vw.mib.genericevents.hsm.HsmState;
import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.navigation.Category;
import org.dsi.ifc.navigation.DSINavigation;

public final class StatePoiSetupMapCategoriesTop
extends StatePoiSetupMapCategoriesBase
implements DSIServiceStateListener {
    private DSINavigation dsiNavigation;
    private DSIListener navigationListener;
    private static final int[] ATTRIBUTES_NAVIGATION = new int[0];
    private PoiCategories4DsiAndHmi poiCategories4DsiAndHmi;
    private boolean isServiceStateListenerAdded = false;
    static /* synthetic */ Class class$org$dsi$ifc$navigation$DSINavigation;
    static /* synthetic */ Class class$org$dsi$ifc$navigation$DSINavigationListener;

    public StatePoiSetupMapCategoriesTop(PoiCategories4DsiAndHmi poiCategories4DsiAndHmi, HsmTargetPoiSetupMapThreeLevelCategories hsmTargetPoiSetupMapThreeLevelCategories, Hsm hsm, String string, HsmState hsmState) {
        super(hsmTargetPoiSetupMapThreeLevelCategories, hsm, string, hsmState);
        this.poiCategories4DsiAndHmi = poiCategories4DsiAndHmi;
    }

    @Override
    public HsmState handle(EventGeneric eventGeneric) {
        HsmState hsmState = null;
        switch (eventGeneric.getReceiverEventId()) {
            case 2: {
                break;
            }
            case 3: {
                this.target.traceIfEnabled("Enter state StatePoiSetupMapCategoriesTop");
                break;
            }
            case 4: {
                break;
            }
            case 101001: {
                this.target.traceIfEnabled("Target POI.Setup entered NAVI_TARGET_GO_ON.");
                HsmTargetPoiSetupMapThreeLevelCategories.addObserver(this.target);
                if (!this.isServiceStateListenerAdded) {
                    this.isServiceStateListenerAdded = true;
                    ServiceManager.dsiServiceLocator.addServiceStateListener(class$org$dsi$ifc$navigation$DSINavigation == null ? (class$org$dsi$ifc$navigation$DSINavigation = StatePoiSetupMapCategoriesTop.class$("org.dsi.ifc.navigation.DSINavigation")) : class$org$dsi$ifc$navigation$DSINavigation, this);
                }
                this.target.trace("Target POI.Setup finished processing NAVI_TARGET_GO_ON.");
                break;
            }
            case 1073742529: {
                this.clearAllCategoryLevelsDataPools();
                this.requestCategoryListFromDsi();
                break;
            }
            default: {
                hsmState = this.getParent();
            }
        }
        return hsmState;
    }

    public void requestCategoryListFromDsi() {
        if (this.dsiNavigation == null) {
            this.target.warn("tried to get poi categories but dsi interface is null!");
        } else {
            this.target.traceIfEnabled("get all poi categories");
            this.dsiNavigation.lispCancelSpeller();
            this.dsiNavigation.poiSetSortOrder2(1);
            this.dsiNavigation.ehGetAllCategories(0);
        }
    }

    public void dsiNavigationEhGetAllCategoriesResult(int n, Category[] categoryArray, int n2) {
        if (this.target.isTraceEnabled()) {
            this.target.trace().append("Target POI.Setup entered DSINAVIGATION_EHGETALLCATEGORIESRESULT.").log();
        }
        if (n2 == 0) {
            this.poiCategories4DsiAndHmi.setCategories(categoryArray);
            this.target.statePoiSetupLevel1.setExpandedCategoryParent(this.poiCategories4DsiAndHmi.getCategoryTreeRoot());
            this.trans(this.target.statePoiSetupLevel1);
        } else if (this.target.isTraceEnabled()) {
            this.target.trace().append("Target POI.Setup error in message DSINAVIGATION_EHGETALLCATEGORIESRESULT.").log();
        }
    }

    public void updateAllCategoryLevelsDataPools() {
        this.target.statePoiSetupLevel3.updateLevel3CategoriesDataPool();
        this.target.statePoiSetupLevel2.updateLevel2CategoriesDataPool();
        this.target.statePoiSetupLevel1.updateLevel1CategoriesDataPool();
    }

    private void clearAllCategoryLevelsDataPools() {
        this.target.statePoiSetupLevel3.clearLevel3CategoriesDataPool();
        this.target.statePoiSetupLevel2.clearLevel2CategoriesDataPool();
        this.target.statePoiSetupLevel1.clearLevel1CategoriesDataPool();
    }

    @Override
    public void registered(String string, int n) {
        this.registerDsiStateChangeListeners(string, n);
    }

    @Override
    public void unregistered(String string, int n) {
        this.unregisterDsiStateChangeListeners(string, n);
    }

    void registerDsiStateChangeListeners(String string, int n) {
        if (string.intern() == (class$org$dsi$ifc$navigation$DSINavigation == null ? (class$org$dsi$ifc$navigation$DSINavigation = StatePoiSetupMapCategoriesTop.class$("org.dsi.ifc.navigation.DSINavigation")) : class$org$dsi$ifc$navigation$DSINavigation).getName().intern()) {
            if (this.target.isTraceEnabled()) {
                this.target.trace().append("HsmTargetPoiSetupMapCategories tries to register to ").append(string).append("...").log();
            }
            DSIProxy dSIProxy = DSIProxyFactory.getDSIProxyAPI().getDSIProxy();
            this.dsiNavigation = (DSINavigation)dSIProxy.getService(this.target, class$org$dsi$ifc$navigation$DSINavigation == null ? (class$org$dsi$ifc$navigation$DSINavigation = StatePoiSetupMapCategoriesTop.class$("org.dsi.ifc.navigation.DSINavigation")) : class$org$dsi$ifc$navigation$DSINavigation);
            this.navigationListener = dSIProxy.getAdapterFactory().createDSIListenerMethodAdapter(this.target.getHsm(), class$org$dsi$ifc$navigation$DSINavigationListener == null ? (class$org$dsi$ifc$navigation$DSINavigationListener = StatePoiSetupMapCategoriesTop.class$("org.dsi.ifc.navigation.DSINavigationListener")) : class$org$dsi$ifc$navigation$DSINavigationListener);
            dSIProxy.addResponseListener(this.target, class$org$dsi$ifc$navigation$DSINavigationListener == null ? (class$org$dsi$ifc$navigation$DSINavigationListener = StatePoiSetupMapCategoriesTop.class$("org.dsi.ifc.navigation.DSINavigationListener")) : class$org$dsi$ifc$navigation$DSINavigationListener, this.navigationListener);
            this.dsiNavigation.setNotification(ATTRIBUTES_NAVIGATION, this.navigationListener);
            if (this.target.isTraceEnabled()) {
                this.target.trace().append("HsmTargetPoiSetupMapCategories registered to ").append(string).log();
            }
        }
    }

    void unregisterDsiStateChangeListeners(String string, int n) {
        if (string.intern() == (class$org$dsi$ifc$navigation$DSINavigation == null ? (class$org$dsi$ifc$navigation$DSINavigation = StatePoiSetupMapCategoriesTop.class$("org.dsi.ifc.navigation.DSINavigation")) : class$org$dsi$ifc$navigation$DSINavigation).getName().intern()) {
            if (this.target.isTraceEnabled()) {
                this.target.trace().append("HsmTargetPoiSetupMapCategories tries to unregister from ").append(string).append("...").log();
            }
            try {
                DSIProxy dSIProxy = DSIProxyFactory.getDSIProxyAPI().getDSIProxy();
                if (dSIProxy == null) {
                    this.target.trace().append("DSIProxy was null!");
                    return;
                }
                this.unregisterDsiNavigation(string, dSIProxy);
            }
            catch (Exception exception) {
                ServiceManager.errorHandler.handleDsiError(exception);
            }
        }
    }

    private void unregisterDsiNavigation(String string, DSIProxy dSIProxy) {
        if (this.navigationListener != null) {
            dSIProxy.removeResponseListener(this.target, class$org$dsi$ifc$navigation$DSINavigationListener == null ? (class$org$dsi$ifc$navigation$DSINavigationListener = StatePoiSetupMapCategoriesTop.class$("org.dsi.ifc.navigation.DSINavigationListener")) : class$org$dsi$ifc$navigation$DSINavigationListener, this.navigationListener);
            this.navigationListener = null;
        }
        this.traceUnregisteredDone(string);
    }

    private void traceUnregisteredDone(String string) {
        if (this.target.isTraceEnabled()) {
            this.target.trace().append("HsmTargetPoiSetupMapCategories unregistered from ").append(string).log();
        }
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

