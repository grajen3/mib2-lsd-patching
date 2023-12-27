/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechnavigation.usecase.onboardpoi.controller;

import de.vw.mib.asl.api.speechengine.result.handling.ResultItemHandler;
import de.vw.mib.asl.api.speechengine.result.handling.ResultListHandler;
import de.vw.mib.asl.api.speechengine.result.router.ModelEventConsumer;
import de.vw.mib.asl.api.speechengine.result.router.RecognizedEventConsumer;
import de.vw.mib.asl.api.speechengine.result.service.AdditionalDataService;
import de.vw.mib.asl.internal.speechnavigation.navi.api.adapter.guidance.GuidanceService;
import de.vw.mib.asl.internal.speechnavigation.navi.api.adapter.guidance.NavigationGuidanceServiceAdapter;
import de.vw.mib.asl.internal.speechnavigation.usecase.common.Framework;
import de.vw.mib.asl.internal.speechnavigation.usecase.common.lists.ApplicationNBestListControllerBase;
import de.vw.mib.asl.internal.speechnavigation.usecase.onboardpoi.controller.OnboardPOIListController;
import de.vw.mib.asl.internal.speechnavigation.usecase.onboardpoi.model.OnboardPOICategory;
import de.vw.mib.asl.internal.speechnavigation.usecase.onboardpoi.model.OnboardPOISearchCriteria;
import de.vw.mib.collections.ints.IntIntMap;
import de.vw.mib.collections.ints.IntIntOptHashMap;
import de.vw.mib.genericevents.EventGeneric;
import generated.de.vw.mib.asl.internal.ListManager;

public class OnboardPOIEnterPOIXController
extends ApplicationNBestListControllerBase
implements RecognizedEventConsumer,
ModelEventConsumer {
    public static final int RESUME_CMD_ENTER_POI_X;
    public static final int SUI_ONBOARD_POI_SELECT_ITEM;
    private final ResultItemHandler lastRecognizedResult;
    private final GuidanceService guidanceService;
    private final IntIntMap tagToSearchingTerm;
    private int searchArea;

    public OnboardPOIEnterPOIXController(AdditionalDataService additionalDataService, ResultListHandler resultListHandler, ResultItemHandler resultItemHandler) {
        super(additionalDataService, resultListHandler);
        this.lastRecognizedResult = resultItemHandler;
        this.guidanceService = NavigationGuidanceServiceAdapter.getGuidanceService();
        this.tagToSearchingTerm = new IntIntOptHashMap(5);
        this.tagToSearchingTerm.put(0, 5);
        this.tagToSearchingTerm.put(1, 0);
        this.tagToSearchingTerm.put(2, 1);
        this.tagToSearchingTerm.put(3, 2);
        this.tagToSearchingTerm.put(4, 3);
    }

    public static void enterPOIs() {
        Framework.fireEvent(1812338944);
    }

    public static void selectPOICategory(OnboardPOICategory onboardPOICategory) {
        Framework.fireEvent(1896225024, onboardPOICategory);
    }

    @Override
    public int getListIdTopLevel() {
        return 1829254144;
    }

    @Override
    public int getListIdDetailLevel() {
        return 1846031360;
    }

    @Override
    public int getListIdSelectedItem() {
        return 1862808576;
    }

    @Override
    public void onEvent(EventGeneric eventGeneric) {
        int n = eventGeneric.getReceiverEventId();
        switch (n) {
            case 1640044: {
                this.searchArea = this.getSearchArea();
                Framework.updateUIValue(1913140224, this.searchArea);
                super.onRequestItems();
                break;
            }
            case 1640049: {
                this.searchArea = 5;
                Framework.updateUIValue(1913140224, 5);
                OnboardPOICategory onboardPOICategory = (OnboardPOICategory)eventGeneric.getObject(0);
                ListManager.getGenericASLList(this.getListIdSelectedItem()).updateList(new OnboardPOICategory[]{onboardPOICategory});
                this.notifyItemSelected();
                break;
            }
            default: {
                super.onEvent(eventGeneric);
            }
        }
    }

    @Override
    public void onRecognizedEvent(int n) {
        switch (n) {
            default: 
        }
        super.onRecognizedEvent(n);
    }

    @Override
    public void notifyAmbiguousItemsRequested() {
        Framework.fireUIEvent(-351783936);
    }

    @Override
    public void notifyItemsRequested() {
        this.notifyItemSelected();
    }

    @Override
    public void notifyGroupExpanded(int n) {
        if (n >= 0 && n < ListManager.getGenericASLList(this.getListIdTopLevel()).getDSIObjects().length) {
            OnboardPOICategory onboardPOICategory = (OnboardPOICategory)ListManager.getGenericASLList(this.getListIdTopLevel()).getDSIObjects()[n];
            Framework.updateUIValue(1594373120, onboardPOICategory.title);
        }
        super.notifyGroupExpanded(n);
    }

    @Override
    public void notifyItemSelected() {
        OnboardPOICategory onboardPOICategory = (OnboardPOICategory)ListManager.getGenericASLList(this.getListIdSelectedItem()).getDSIObjects()[0];
        Framework.updateUIValue(1594373120, onboardPOICategory.title);
        Framework.updateUIValue(1980249088, this.searchArea);
        if (this.searchArea == 5) {
            this.searchArea = this.guidanceService.isGuidanceActive() ? 3 : 0;
        } else if (this.searchArea == 0) {
            this.searchArea = 0;
        }
        Framework.updateUIValue(1913140224, this.searchArea);
        if (!this.guidanceService.isGuidanceActive()) {
            if (this.searchArea == 1 || this.searchArea == 2 || this.searchArea == 3) {
                Framework.fireUIEvent(-217566208);
                this.searchArea = 0;
                Framework.updateUIValue(1913140224, this.searchArea);
            }
        } else if (this.guidanceService.isGuidanceActive() && !this.guidanceService.isStopoverDefined() && this.searchArea == 2) {
            Framework.fireUIEvent(-217566208);
            this.searchArea = 3;
            Framework.updateUIValue(1913140224, this.searchArea);
        }
        Framework.fireUIEvent(1728656384);
        OnboardPOIListController.searchPOIsByCategory(new OnboardPOISearchCriteria(onboardPOICategory, this.searchArea));
    }

    private int getSearchArea() {
        try {
            int n = Integer.parseInt(this.lastRecognizedResult.getResultItem().getTag());
            if (this.tagToSearchingTerm.containsKey(n)) {
                return this.tagToSearchingTerm.get(n);
            }
            return 5;
        }
        catch (Exception exception) {
            return 5;
        }
    }
}

