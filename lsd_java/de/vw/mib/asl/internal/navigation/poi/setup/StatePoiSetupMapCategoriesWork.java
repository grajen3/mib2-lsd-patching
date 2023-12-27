/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.poi.setup;

import de.vw.mib.asl.api.navigation.map.ASLNavigationMapFactory;
import de.vw.mib.asl.api.navigation.util.ASLNavigationUtilFactory;
import de.vw.mib.asl.api.navigation.util.factoryreset.FactoryResetParticipantWithCallback;
import de.vw.mib.asl.api.navigation.util.factoryreset.TargetForResetNavigation;
import de.vw.mib.asl.framework.api.dsiproxy.DSIServiceStateListener;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.navigation.caching.CacheClient;
import de.vw.mib.asl.internal.navigation.caching.IconKey;
import de.vw.mib.asl.internal.navigation.poi.setup.HsmTargetPoiSetupMapCategories;
import de.vw.mib.asl.internal.navigation.poi.setup.transformer.PoiSetupPoiListCollector;
import de.vw.mib.asl.internal.navigation.poi.setup.transformer.PoiSetupShortCutListCollector;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.hsm.AbstractHsmState;
import de.vw.mib.genericevents.hsm.Hsm;
import de.vw.mib.genericevents.hsm.HsmState;
import de.vw.mib.log4mib.LogMessage;
import generated.de.vw.mib.asl.internal.ListManager;
import java.util.ArrayList;
import java.util.Arrays;
import org.dsi.ifc.global.ResourceLocator;
import org.dsi.ifc.navigation.Category;

public final class StatePoiSetupMapCategoriesWork
extends AbstractHsmState
implements CacheClient,
DSIServiceStateListener,
TargetForResetNavigation {
    private final HsmTargetPoiSetupMapCategories poiSetupTarget;
    private PoiSetupPoiListCollector[] hmiCategoryArray = new PoiSetupPoiListCollector[0];
    private PoiSetupShortCutListCollector[] hmiShortCutArray = new PoiSetupShortCutListCollector[0];
    private ArrayList hmiShortCutList = new ArrayList(10);
    private int[] dsiCategories = new int[0];
    private boolean[] dsiCategoriesToShow = new boolean[0];
    private int[] dsiVisibleCategoryUIds = new int[0];
    private boolean isServiceStateListenerAdded = false;
    private FactoryResetParticipantWithCallback navigationResetParticipant;
    static /* synthetic */ Class class$org$dsi$ifc$navigation$DSINavigation;

    public StatePoiSetupMapCategoriesWork(HsmTargetPoiSetupMapCategories hsmTargetPoiSetupMapCategories, Hsm hsm, String string, HsmState hsmState) {
        super(hsm, string, hsmState);
        this.poiSetupTarget = hsmTargetPoiSetupMapCategories;
    }

    @Override
    public HsmState handle(EventGeneric eventGeneric) {
        HsmState hsmState = null;
        switch (eventGeneric.getReceiverEventId()) {
            case 2: {
                if (this.poiSetupTarget.isTraceEnabled()) {
                    this.poiSetupTarget.trace().append("HSM_ENTRY").log();
                }
                if (this.navigationResetParticipant != null) break;
                this.navigationResetParticipant = ASLNavigationUtilFactory.getNavigationUtilApi().createFactoryResetParticipantForNavigationDomainAndAddToService(this);
                break;
            }
            case 3: {
                if (!this.poiSetupTarget.isTraceEnabled()) break;
                this.poiSetupTarget.trace().append("Target POI.Setup entered HSM_START.").log();
                break;
            }
            case 4: {
                HsmTargetPoiSetupMapCategories.removeObserver(this.poiSetupTarget);
                if (this.navigationResetParticipant == null) break;
                ASLNavigationUtilFactory.getNavigationUtilApi().removeNavigationResetParticipantFromService(this.navigationResetParticipant);
                this.navigationResetParticipant = null;
                break;
            }
            case 101001: {
                this.poiSetupTarget.trace("Target POI.Setup entered NAVI_TARGET_GO_ON.");
                HsmTargetPoiSetupMapCategories.addObserver(this.poiSetupTarget);
                if (!this.isServiceStateListenerAdded) {
                    this.isServiceStateListenerAdded = true;
                    ServiceManager.dsiServiceLocator.addServiceStateListener(class$org$dsi$ifc$navigation$DSINavigation == null ? (class$org$dsi$ifc$navigation$DSINavigation = StatePoiSetupMapCategoriesWork.class$("org.dsi.ifc.navigation.DSINavigation")) : class$org$dsi$ifc$navigation$DSINavigation, this);
                }
                this.poiSetupTarget.trace("Target POI.Setup finished processing NAVI_TARGET_GO_ON.");
                break;
            }
            case 1073742530: {
                if (this.poiSetupTarget.isTraceEnabled()) {
                    this.poiSetupTarget.trace().append("Target POI.Setup entered ASL_NAVIGATION_POI_SETUP_TOGGLE_CATEGORY_ELEMENT.").log();
                }
                this.toggleCategoryElement(eventGeneric);
                break;
            }
            case 1073742527: {
                if (this.poiSetupTarget.isTraceEnabled()) {
                    this.poiSetupTarget.trace().append("Target POI.Setup entered ASL_NAVIGATION_POI_SETUP_CLEAR_ALL_SELECTED_CATEGORY_ELEMENTS.").log();
                }
                this.disableAllPois();
                break;
            }
            case 1073742529: {
                if (this.poiSetupTarget.isTraceEnabled()) {
                    this.poiSetupTarget.trace().append("Target POI.Setup entered ASL_NAVIGATION_POI_SETUP_LOAD_CATEGORY_LISTS.").log();
                }
                this.requestCategoryListFromDsi();
                break;
            }
            case 3499026: {
                this.handleEhSetCategoryVisibilityResult(eventGeneric);
                break;
            }
            default: {
                if (this.poiSetupTarget.isTraceEnabled()) {
                    this.poiSetupTarget.trace().append("Target POI.Setup entered DEFAULT event with ID:").append(eventGeneric.getReceiverEventId()).log();
                }
                hsmState = this.myParent;
            }
        }
        return hsmState;
    }

    private void handleEhSetCategoryVisibilityResult(EventGeneric eventGeneric) {
        this.dsiVisibleCategoryUIds = (int[])eventGeneric.getObject(0);
        Arrays.sort(this.dsiVisibleCategoryUIds);
        this.syncCategoryVisibilities();
        this.setHmiDatapoolLists();
        this.dsiNavigationEhResult(0, 0);
    }

    private void requestCategoryListFromDsi() {
        this.poiSetupTarget.dsiNavigation.poiSetSortOrder2(1);
        this.poiSetupTarget.dsiNavigation.ehGetAllCategories(0);
    }

    public void dsiNavigationEhResult(int n, int n2) {
        if (this.poiSetupTarget.isTraceEnabled()) {
            this.poiSetupTarget.trace(new StringBuffer().append("dsiNavigationEhResult(): mapStyleType=").append(n).append(", resultCode=").append(n2).toString());
        }
    }

    public void dsiNavigationEhGetAllCategoriesResult(int n, Category[] categoryArray, int n2) {
        if (this.poiSetupTarget.isTraceEnabled()) {
            this.poiSetupTarget.trace().append("Target POI.Setup entered DSINAVIGATION_EHGETALLCATEGORIESRESULT.").log();
        }
        if (n2 != 0) {
            if (this.poiSetupTarget.isTraceEnabled()) {
                this.poiSetupTarget.trace().append("Target POI.Setup error in message DSINAVIGATION_EHGETALLCATEGORIESRESULT.").log();
            }
            return;
        }
        this.hmiCategoryArray = new PoiSetupPoiListCollector[categoryArray.length];
        this.dsiCategories = new int[categoryArray.length];
        this.dsiCategoriesToShow = new boolean[categoryArray.length];
        this.hmiShortCutList.clear();
        boolean bl = false;
        int n3 = 0;
        for (int i2 = 0; i2 < categoryArray.length; ++i2) {
            Category category = categoryArray[i2];
            ResourceLocator resourceLocator = ASLNavigationUtilFactory.getNavigationUtilApi().getCacheHandler().resourceIdForPOIIcon(category.iconIndex, category.subIconIndex, 0, this, new Integer(category.categoryUid));
            boolean bl2 = this.isCategoryVisible(category.getCategoryUid());
            this.hmiCategoryArray[i2] = new PoiSetupPoiListCollector(bl2, resourceLocator, category.getDescription(), category.getCategoryUid());
            this.dsiCategories[i2] = category.categoryUid;
            this.dsiCategoriesToShow[i2] = bl2;
            if (!bl2) continue;
            if (n3 >= 10) {
                this.poiSetupTarget.trace("The maximum number of activated categories was bigger then: ", 10);
                this.poiSetupTarget.trace("Deactivating/Setting invisicible the category: ", category.description);
                bl = true;
                this.dsiCategoriesToShow[i2] = false;
                this.hmiCategoryArray[i2].selected = false;
                continue;
            }
            ++n3;
            this.hmiShortCutList.add(new PoiSetupShortCutListCollector(i2, resourceLocator));
        }
        this.hmiShortCutArray = (PoiSetupShortCutListCollector[])this.hmiShortCutList.toArray(new PoiSetupShortCutListCollector[this.hmiShortCutList.size()]);
        this.setHmiDatapoolLists();
        if (bl) {
            this.updateDsi();
        }
    }

    @Override
    public ResourceLocator getDefaultIcon() {
        return null;
    }

    @Override
    public void handleIconCacheUpdate(IconKey iconKey, ResourceLocator resourceLocator, Object object) {
        int n = (Integer)object;
        int n2 = -1;
        PoiSetupPoiListCollector poiSetupPoiListCollector = null;
        for (int i2 = 0; i2 < this.hmiCategoryArray.length; ++i2) {
            if (this.hmiCategoryArray[i2].uniqueId != n) continue;
            poiSetupPoiListCollector = this.hmiCategoryArray[i2];
            n2 = i2;
            break;
        }
        PoiSetupShortCutListCollector poiSetupShortCutListCollector = null;
        int n3 = -1;
        if (n2 != -1) {
            for (int i3 = 0; i3 < this.hmiShortCutArray.length; ++i3) {
                if (this.hmiShortCutArray[i3].index != n2) continue;
                poiSetupShortCutListCollector = this.hmiShortCutArray[i3];
                n3 = i3;
            }
        }
        if (this.poiSetupTarget.isTraceEnabled()) {
            LogMessage logMessage = this.poiSetupTarget.trace();
            logMessage.append("Target POI.Setup entered handleIconCacheUpdate with categoryId: ").append(n);
            if (resourceLocator != null) {
                logMessage.append(" ResourceLocator: ").append(resourceLocator.toString()).append(" Index: ").append(n2);
                logMessage.append(" ShortCut-Index: ").append(n3);
            }
            logMessage.log();
        }
        if (poiSetupPoiListCollector != null) {
            poiSetupPoiListCollector.icon = resourceLocator;
            ListManager.getGenericASLList(953).updateListItem(n2, poiSetupPoiListCollector);
        }
        if (poiSetupShortCutListCollector != null) {
            poiSetupShortCutListCollector.icon = resourceLocator;
            ListManager.getGenericASLList(954).updateListItem(n3, poiSetupShortCutListCollector);
        }
    }

    private void updateDsi() {
        ASLNavigationMapFactory.getNavigationMapApi().sendEvMapMainEhSetCategoryVisibility(this.dsiCategories, this.dsiCategoriesToShow);
    }

    private void setHmiDatapoolLists() {
        if (this.poiSetupTarget.isTraceEnabled()) {
            int n;
            LogMessage logMessage = this.poiSetupTarget.trace();
            logMessage.append("StatePoiSetupWork#setHmiDatapoolLists: \n");
            logMessage.append("Category List: \n");
            for (n = 0; n < this.hmiCategoryArray.length; ++n) {
                logMessage.append(this.hmiCategoryArray[n].toString());
                logMessage.append("\n");
            }
            logMessage.append("ShortCut List: \n");
            for (n = 0; n < this.hmiShortCutArray.length; ++n) {
                logMessage.append(this.hmiShortCutArray[n].toString());
                logMessage.append("\n");
            }
            logMessage.log();
        }
        ListManager.getGenericASLList(953).updateList(this.hmiCategoryArray);
        ListManager.getGenericASLList(954).updateList(this.hmiShortCutArray);
    }

    private void disableAllPois() {
        for (int i2 = 0; i2 < this.dsiCategoriesToShow.length; ++i2) {
            this.dsiCategoriesToShow[i2] = false;
            this.hmiCategoryArray[i2].selected = false;
        }
        this.hmiShortCutList.clear();
        this.hmiShortCutArray = new PoiSetupShortCutListCollector[0];
        this.setHmiDatapoolLists();
        this.updateDsi();
    }

    private void selectDefaultCategoryVisibility() {
        int[] nArray = ServiceManager.configManagerDiag.getNaviCommonOptionDefaultVisiblePoiCategories();
        Arrays.sort(nArray);
        for (int i2 = 0; i2 < this.dsiCategoriesToShow.length; ++i2) {
            if (Arrays.binarySearch(nArray, this.dsiCategories[i2]) >= 0) {
                this.dsiCategoriesToShow[i2] = true;
                this.hmiCategoryArray[i2].selected = true;
                continue;
            }
            this.dsiCategoriesToShow[i2] = false;
            this.hmiCategoryArray[i2].selected = false;
        }
        this.refreshShortcutList(this.hmiCategoryArray);
        this.setHmiDatapoolLists();
        this.updateDsi();
    }

    private void toggleCategoryElement(EventGeneric eventGeneric) {
        int n = eventGeneric.getInt(0);
        PoiSetupPoiListCollector poiSetupPoiListCollector = this.hmiCategoryArray[n];
        boolean bl = poiSetupPoiListCollector.selected;
        this.dsiCategoriesToShow[n] = !bl;
        boolean bl2 = poiSetupPoiListCollector.selected = !bl;
        if (bl) {
            for (int i2 = 0; i2 < this.hmiShortCutArray.length; ++i2) {
                PoiSetupShortCutListCollector poiSetupShortCutListCollector = this.hmiShortCutArray[i2];
                if (poiSetupShortCutListCollector.index != n) continue;
                this.hmiShortCutList.remove(poiSetupShortCutListCollector);
                this.hmiShortCutArray = (PoiSetupShortCutListCollector[])this.hmiShortCutList.toArray(new PoiSetupShortCutListCollector[this.hmiShortCutList.size()]);
                break;
            }
        } else {
            this.refreshShortcutList(this.hmiCategoryArray);
        }
        this.setHmiDatapoolLists();
        this.updateDsi();
    }

    private void refreshShortcutList(PoiSetupPoiListCollector[] poiSetupPoiListCollectorArray) {
        this.hmiShortCutList = new ArrayList(10);
        for (int i2 = 0; i2 < poiSetupPoiListCollectorArray.length; ++i2) {
            PoiSetupPoiListCollector poiSetupPoiListCollector = poiSetupPoiListCollectorArray[i2];
            if (!poiSetupPoiListCollector.selected) continue;
            this.hmiShortCutList.add(new PoiSetupShortCutListCollector(i2, poiSetupPoiListCollector.icon));
        }
        this.hmiShortCutArray = (PoiSetupShortCutListCollector[])this.hmiShortCutList.toArray(new PoiSetupShortCutListCollector[this.hmiShortCutList.size()]);
    }

    private boolean isCategoryVisible(int n) {
        if (this.dsiVisibleCategoryUIds != null && this.dsiVisibleCategoryUIds.length > 0) {
            int n2 = Arrays.binarySearch(this.dsiVisibleCategoryUIds, n);
            return n2 >= 0;
        }
        return false;
    }

    private void syncCategoryVisibilities() {
        if (this.hmiCategoryArray != null && this.dsiCategoriesToShow != null) {
            for (int i2 = 0; i2 < this.hmiCategoryArray.length; ++i2) {
                boolean bl;
                PoiSetupPoiListCollector poiSetupPoiListCollector = this.hmiCategoryArray[i2];
                poiSetupPoiListCollector.selected = bl = this.isCategoryVisible(poiSetupPoiListCollector.uniqueId);
                this.dsiCategoriesToShow[i2] = bl;
            }
        }
    }

    @Override
    public void registered(String string, int n) {
        this.poiSetupTarget.registerDsiStateChangeListeners(string, n);
    }

    @Override
    public void unregistered(String string, int n) {
        this.poiSetupTarget.unregisterDsiStateChangeListeners(string, n);
    }

    @Override
    public void handleNavigationSettingsReset() {
        this.navigationResetParticipant.notifyResetDone();
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

