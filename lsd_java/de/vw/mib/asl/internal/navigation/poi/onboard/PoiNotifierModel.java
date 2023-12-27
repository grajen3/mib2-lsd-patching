/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.poi.onboard;

import de.vw.mib.asl.api.navigation.util.ASLNavigationUtilFactory;
import de.vw.mib.asl.api.navigation.util.IExtLogger;
import de.vw.mib.asl.framework.internal.framework.AbstractASLHsmTarget;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.navigation.poi.transformer.PoiConnectorDetailsCollector;
import de.vw.mib.asl.internal.navigation.poi.transformer.PoiPitStopItemCollector;
import de.vw.mib.properties.values.SpellerData;
import generated.de.vw.mib.asl.internal.ListManager;
import generated.de.vw.mib.asl.internal.navigation.poi.transformer.NavigationPOIResultSelectedDetailsCollector;

public final class PoiNotifierModel {
    private static IExtLogger LOGGER = null;

    private static IExtLogger getLogger() {
        if (LOGGER == null) {
            LOGGER = ASLNavigationUtilFactory.getNavigationUtilApi().getExtLogger(512, "PoiHsmTarget - PoiNotifierModell:");
        }
        return LOGGER;
    }

    public void notifySearchStateSearching() {
        PoiNotifierModel.getLogger().trace("notifySearchStateSearching");
        AbstractASLHsmTarget.writeIntegerToDatapool(941, 0);
    }

    void updateSearchStatus(boolean bl) {
        ServiceManager.aslPropertyManager.valueChangedInteger(2079330304, bl ? 1 : 0);
    }

    public void notifySearchStateFound() {
        PoiNotifierModel.getLogger().trace("notifySearchStateFound");
        AbstractASLHsmTarget.writeIntegerToDatapool(941, 1);
    }

    public void notifySearchStateNothingFound() {
        PoiNotifierModel.getLogger().trace("notifySearchStateNothingFound");
        AbstractASLHsmTarget.writeIntegerToDatapool(941, 2);
    }

    public void notifyToChangeStateOfMapUpdatePopup(boolean bl) {
        if (bl) {
            ServiceManager.aslPropertyManager.valueChangedBoolean(519049216, true);
        } else {
            ServiceManager.aslPropertyManager.valueChangedBoolean(519049216, false);
        }
        PoiNotifierModel.getLogger().trace(new StringBuffer().append("notifyToChangeStateOfMapUpdatePopup, NUMBERING_ACTIVE: ").append(bl ? "TRUE (disable" : "FALSE (enable").append(" map update popup for dual list view)").toString());
    }

    public void notifyCurrentSearchRadius(int n) {
        PoiNotifierModel.getLogger().trace("notifyCurrentSearchRadius");
        AbstractASLHsmTarget.writeIntegerToDatapool(938, n);
    }

    public void notifyNameFilter(String string) {
        LOGGER.trace("notifyNameFilter");
        AbstractASLHsmTarget.writeStringToDatapool(939, string);
    }

    public void notifySpellerData(SpellerData spellerData) {
        LOGGER.trace("notifySpellerData");
        AbstractASLHsmTarget.writeSpellerDataToDatapool(940, spellerData);
    }

    public void notifyPoiName(String string) {
        PoiNotifierModel.getLogger().trace("notifyPoiName");
        AbstractASLHsmTarget.writeStringToDatapool(934, string);
    }

    public void notifyShowAllAvailable() {
        LOGGER.trace("notifyShowAllAvailable");
        AbstractASLHsmTarget.writeBooleanToDatapool(943, true);
    }

    public void notifyShowAllNotAvailable() {
        LOGGER.trace("notifyShowAllNotAvailable");
        AbstractASLHsmTarget.writeBooleanToDatapool(943, false);
    }

    public void notifyClickedTmcOnMap() {
        PoiNotifierModel.getLogger().trace("notifyClickedTmcOnMap");
        AbstractASLHsmTarget.writeIntegerToDatapool(867, 4);
        AbstractASLHsmTarget.writeBooleanToDatapool(873, false);
        ServiceManager.eventDispatcher.createAndSubmitHMIEvent(94);
    }

    public void notifyClickedPoiStackOnMap() {
        PoiNotifierModel.getLogger().trace("notifyClickedPoiStackOnMap");
        AbstractASLHsmTarget.writeIntegerToDatapool(867, 2);
        AbstractASLHsmTarget.writeBooleanToDatapool(873, false);
        ServiceManager.eventDispatcher.createAndSubmitHMIEvent(94);
    }

    public void notifyResultListItemsUpdateItems(int n, Object[] objectArray) {
        PoiNotifierModel.getLogger().trace("notifyResultListItemsUpdateItems");
        ListManager.getGenericASLList(946).updateListItems(n, objectArray);
    }

    public void notifyResultListItemsUpdateList(Object[] objectArray) {
        PoiNotifierModel.getLogger().trace("notifyResultListItemsUpdateList");
        ListManager.getGenericASLList(946).updateList(objectArray);
    }

    public void notifySubResultListItemsUpdateItems(int n, Object[] objectArray) {
        LOGGER.trace("notifySubResultListItemsUpdateItems");
        ListManager.getGenericASLList(948).updateListItems(n, objectArray);
    }

    public void notifySubResultListItemsUpdateList(Object[] objectArray) {
        LOGGER.trace("notifySubResultListItemsUpdateList");
        ListManager.getGenericASLList(948).updateList(objectArray);
    }

    public void notifyNaviPoiDataLoadFinished() {
        PoiNotifierModel.getLogger().trace("notifyNaviPoiDataLoadFinished");
        ServiceManager.eventDispatcher.createAndSubmitHMIEvent(107);
        ServiceManager.aslPropertyManager.valueChangedInteger(2965, 0);
        ServiceManager.aslPropertyManager.valueChangedInteger(3722, 0);
    }

    public void notifyCategoryListItemsUpdateItems(int n, Object[] objectArray) {
        LOGGER.trace("notifyCategoryListItemsUpdateItems");
        ListManager.getGenericASLList(949).updateListItems(n, objectArray);
    }

    public void notifyCategoryListItemsUpdateList(Object[] objectArray) {
        LOGGER.trace("notifyCategoryListItemsUpdateList");
        ListManager.getGenericASLList(949).updateList(objectArray);
    }

    public void notifyCategoryGroupListItemsUpdateList(Object[] objectArray) {
        LOGGER.trace("notifyCategoryGroupListItemsUpdateList");
        ListManager.getGenericASLList(937).updateList(objectArray);
    }

    public void notifyCategoryOpenedIndex(int n) {
        LOGGER.trace("notifyCategoryOpenedIndex");
        ServiceManager.aslPropertyManager.valueChangedInteger(931, n);
    }

    public void notifyNoPpoiInstalledPopup() {
        LOGGER.trace("notifyNoPpoiInstalledPopup");
        ServiceManager.eventDispatcher.createAndSubmitHMIEvent(527);
    }

    public void notifyPoiDetails(NavigationPOIResultSelectedDetailsCollector navigationPOIResultSelectedDetailsCollector) {
        PoiNotifierModel.getLogger().trace("notifyPoiDetails");
        Object[] objectArray = new NavigationPOIResultSelectedDetailsCollector[]{navigationPOIResultSelectedDetailsCollector};
        ListManager.getGenericASLList(947).updateList(objectArray);
    }

    public void notifyPoiConnectorDetails(PoiConnectorDetailsCollector[] poiConnectorDetailsCollectorArray) {
        PoiNotifierModel.getLogger().trace("notifyPoiConnectorDetails");
        ListManager.getGenericASLList(334499840).updateList(poiConnectorDetailsCollectorArray);
    }

    public void notifySpellerCharacterEntered(boolean bl) {
        LOGGER.trace("notifySpellerCharacterEntered");
        ServiceManager.aslPropertyManager.valueChangedBoolean(3187, bl);
    }

    public void notifySearchAreaSelected(int n) {
        LOGGER.trace("notifySearchAreaSelected");
        ServiceManager.aslPropertyManager.valueChangedInteger(944, n);
    }

    public void notifySelectedCategoryName(String string) {
        LOGGER.trace("notifySearchAreaSelected");
        ServiceManager.aslPropertyManager.valueChangedString(3152, string);
    }

    public void notifyEnteredName(String string) {
        LOGGER.trace("notifyEnteredName");
        ServiceManager.aslPropertyManager.valueChangedString(3151, string);
    }

    public static void notifyDynamicPoiCategory(int n) {
        PoiNotifierModel.getLogger().trace(new StringBuffer().append("notifyDynamicPoiCategory( ").append(n).append(" )").toString());
        ServiceManager.aslPropertyManager.valueChangedInteger(686821376, n);
    }

    public void notifyTopPoiCategoriesUpdateList(PoiPitStopItemCollector[] poiPitStopItemCollectorArray) {
        PoiNotifierModel.getLogger().trace("notifyTopPoiCategoriesUpdateList");
        ListManager.getGenericASLList(950).updateList(poiPitStopItemCollectorArray);
    }

    public void notifyTopPoiCategoriesUpdateItems(int n, PoiPitStopItemCollector[] poiPitStopItemCollectorArray) {
        PoiNotifierModel.getLogger().trace("notifyTopPoiCategoriesUpdateList");
        ListManager.getGenericASLList(950).updateListItems(n, poiPitStopItemCollectorArray);
    }

    public void notifySearchTypeSurrounding(boolean bl) {
        PoiNotifierModel.getLogger().trace("notifySearchTypeSurrounding");
        ServiceManager.aslPropertyManager.valueChangedBoolean(1760563200, bl);
    }
}

