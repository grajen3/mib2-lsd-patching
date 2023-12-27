/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechnavigation.usecase.onboardpoi.controller;

import de.vw.mib.asl.api.speechengine.result.handling.ResultItemRowNumberHandler;
import de.vw.mib.asl.api.speechengine.result.router.ModelEventConsumer;
import de.vw.mib.asl.api.speechengine.result.router.RecognizedEventConsumer;
import de.vw.mib.asl.internal.speechnavigation.usecase.common.Framework;
import de.vw.mib.asl.internal.speechnavigation.usecase.common.lists.ApplicationListControllerBase;
import de.vw.mib.asl.internal.speechnavigation.usecase.onboardpoi.controller.OnboardPOIAddressDetailController;
import de.vw.mib.asl.internal.speechnavigation.usecase.onboardpoi.model.OnboardPOI;
import de.vw.mib.asl.internal.speechnavigation.usecase.onboardpoi.model.OnboardPOISearchCriteria;
import de.vw.mib.asl.internal.speechnavigation.usecase.onboardpoi.service.OnboardPOIDataService;
import de.vw.mib.asl.internal.speechnavigation.usecase.onboardpoi.service.POISearchStatusListener;
import de.vw.mib.genericevents.EventGeneric;
import generated.de.vw.mib.asl.internal.ListManager;

public class OnboardPOIListController
extends ApplicationListControllerBase
implements RecognizedEventConsumer,
ModelEventConsumer,
POISearchStatusListener {
    public static final int SHOW_SEARCH_POI_RESULT;
    private final OnboardPOIDataService service;
    private boolean isResultListShown = false;

    public OnboardPOIListController(OnboardPOIDataService onboardPOIDataService, ResultItemRowNumberHandler resultItemRowNumberHandler) {
        super(onboardPOIDataService, resultItemRowNumberHandler);
        this.service = onboardPOIDataService;
        this.service.registerListener(this);
    }

    public static void searchPOIsByCategory(OnboardPOISearchCriteria onboardPOISearchCriteria) {
        Framework.fireEvent(1829116160, onboardPOISearchCriteria);
    }

    @Override
    public int getListIdTopLevel() {
        return 1879585792;
    }

    @Override
    public int getListIdSelectedItem() {
        return 1997026304;
    }

    @Override
    public void onRecognizedEvent(int n) {
        super.onRecognizedEvent(n);
    }

    @Override
    public void onEvent(EventGeneric eventGeneric) {
        int n = eventGeneric.getReceiverEventId();
        switch (n) {
            case 1640045: {
                OnboardPOISearchCriteria onboardPOISearchCriteria = (OnboardPOISearchCriteria)eventGeneric.getObject(0);
                this.service.setSearchCriteria(onboardPOISearchCriteria);
                this.isResultListShown = false;
                super.onRequestItems();
                break;
            }
            case 1077142002: {
                break;
            }
            default: {
                super.onEvent(eventGeneric);
            }
        }
    }

    @Override
    public void notifyItemsRequested() {
        int n = ListManager.getGenericASLList(this.getListIdTopLevel()).getItemCount();
        if (n > 1 && !this.isResultListShown) {
            this.isResultListShown = true;
            Framework.fireUIEvent(-184011776);
        }
    }

    @Override
    public void notifyItemSelected() {
        OnboardPOI onboardPOI = (OnboardPOI)ListManager.getGenericASLList(this.getListIdSelectedItem()).getDSIObjects()[0];
        OnboardPOIAddressDetailController.showDestinationAddressDetails(onboardPOI);
    }

    @Override
    public void updateSearchStatus(int n, int n2, int n3) {
        if (n == 3 || n == 1) {
            int n4 = ListManager.getGenericASLList(this.getListIdTopLevel()).getItemCount();
            if (n4 == 0) {
                Framework.fireUIEvent(-200788992);
                return;
            }
            if (n4 == 1) {
                Framework.fireUIEvent(-184011776);
                ListManager.getGenericASLList(this.getListIdSelectedItem()).updateList(new OnboardPOI[]{(OnboardPOI)ListManager.getGenericASLList(this.getListIdTopLevel()).getDSIObjects()[0]});
                this.notifyItemSelected();
                return;
            }
        }
    }
}

