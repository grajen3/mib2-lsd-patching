/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.poi.onboard.ppoi.util;

import de.vw.mib.asl.api.navigation.util.ASLNavigationUtilFactory;
import de.vw.mib.asl.api.navigation.util.IExtLogger;
import de.vw.mib.asl.framework.internal.framework.AbstractASLHsmTarget;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import generated.de.vw.mib.asl.internal.ListManager;
import generated.de.vw.mib.asl.internal.navigation.poi.transformer.NavigationPOIResultSelectedDetailsCollector;

public final class PPoiNotifierModel {
    private static IExtLogger LOGGER = null;

    private static IExtLogger getLogger() {
        if (LOGGER == null) {
            LOGGER = ASLNavigationUtilFactory.getNavigationUtilApi().getExtLogger(512, "PoiHsmTarget - PoiNotifierModell:");
        }
        return LOGGER;
    }

    public void quitModelWaitstate() {
        PPoiNotifierModel.getLogger().trace("notifyNaviPPoiInitCategoryListFinished");
        ServiceManager.aslPropertyManager.valueChangedInteger(-537915392, 0);
    }

    public void notifySearchStateSearching() {
        PPoiNotifierModel.getLogger().trace("notifySearchStateSearching");
        AbstractASLHsmTarget.writeIntegerToDatapool(-504360960, 0);
    }

    public void notifySearchStateFound() {
        PPoiNotifierModel.getLogger().trace("notifySearchStateFound");
        AbstractASLHsmTarget.writeIntegerToDatapool(-504360960, 1);
    }

    public void notifySearchStateNothingFound() {
        PPoiNotifierModel.getLogger().trace("notifySearchStateNothingFound");
        AbstractASLHsmTarget.writeIntegerToDatapool(-504360960, 2);
    }

    public void notifyNaviPoiDataLoadFinished() {
        PPoiNotifierModel.getLogger().trace("notifyNaviPoiDataLoadFinished");
        ServiceManager.aslPropertyManager.valueChangedInteger(-487583744, 0);
    }

    public void notifyNaviPoiDataLoadFinishedLeawDetailView() {
        PPoiNotifierModel.getLogger().trace("notifyNaviPoiDataLoadFinished");
        ServiceManager.eventDispatcher.createAndSubmitHMIEvent(107);
        ServiceManager.aslPropertyManager.valueChangedInteger(2965, 0);
    }

    public void notifyCategoryGroupListItemsUpdateList(Object[] objectArray) {
        PPoiNotifierModel.getLogger().trace("notifyCategoryGroupListItemsUpdateList");
        ListManager.getGenericASLList(-521138176).updateList(objectArray);
    }

    public void notifyResultListItemsUpdateItems(int n, Object[] objectArray) {
        PPoiNotifierModel.getLogger().trace("notifyResultListItemsUpdateItems");
        ListManager.getGenericASLList(-470806528).updateListItems(n, objectArray);
    }

    public void notifyCategoryListItemsUpdateList(Object[] objectArray) {
        PPoiNotifierModel.getLogger().trace("notifyCategoryListItemsUpdateList");
        ListManager.getGenericASLList(-470806528).updateList(objectArray);
    }

    public void notifyCategoryListItemsUpdateItems(int n, Object[] objectArray) {
        PPoiNotifierModel.getLogger().trace("notifyCategoryListItemsUpdateItems");
        ListManager.getGenericASLList(-521138176).updateListItems(n, objectArray);
    }

    public void notifyPoiDetails(NavigationPOIResultSelectedDetailsCollector navigationPOIResultSelectedDetailsCollector) {
        PPoiNotifierModel.getLogger().trace("notifyPPoiDetails");
        Object[] objectArray = new NavigationPOIResultSelectedDetailsCollector[]{navigationPOIResultSelectedDetailsCollector};
        ListManager.getGenericASLList(947).updateList(objectArray);
    }
}

