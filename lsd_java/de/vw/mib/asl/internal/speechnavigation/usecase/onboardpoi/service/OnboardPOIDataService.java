/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechnavigation.usecase.onboardpoi.service;

import de.vw.mib.asl.api.speechengine.result.service.AsyncCallback;
import de.vw.mib.asl.api.speechengine.result.service.DataService;
import de.vw.mib.asl.internal.speechnavigation.navi.api.adapter.onboardpoi.NavigationOnboardPOIServiceAdapter;
import de.vw.mib.asl.internal.speechnavigation.navi.api.adapter.onboardpoi.OnboardPOIService;
import de.vw.mib.asl.internal.speechnavigation.usecase.onboardpoi.model.OnboardPOICategory;
import de.vw.mib.asl.internal.speechnavigation.usecase.onboardpoi.model.OnboardPOISearchCriteria;
import de.vw.mib.asl.internal.speechnavigation.usecase.onboardpoi.service.OnboardPOIDataService$1;
import de.vw.mib.asl.internal.speechnavigation.usecase.onboardpoi.service.POISearchStatusListener;
import de.vw.mib.collections.ObjectArrayList;

public class OnboardPOIDataService
implements DataService {
    private final OnboardPOIService poiNaviService;
    private OnboardPOICategory poiSearchCategory;
    private int poiSearchArea;
    ObjectArrayList poiSearchStatusListeners = new ObjectArrayList(1);
    ObjectArrayList poiResultList = new ObjectArrayList(10);

    public OnboardPOIDataService() {
        this.poiNaviService = NavigationOnboardPOIServiceAdapter.getService();
    }

    public void registerListener(POISearchStatusListener pOISearchStatusListener) {
        this.poiSearchStatusListeners.add(pOISearchStatusListener);
    }

    public void unregisterListener(POISearchStatusListener pOISearchStatusListener) {
        this.poiSearchStatusListeners.removeValue(pOISearchStatusListener);
    }

    public void setSearchCriteria(OnboardPOISearchCriteria onboardPOISearchCriteria) {
        this.poiSearchCategory = onboardPOISearchCriteria.category;
        this.poiSearchArea = onboardPOISearchCriteria.area;
    }

    @Override
    public void getDataRequest(AsyncCallback asyncCallback) {
        this.poiResultList.clear();
        this.poiNaviService.startSearch(new OnboardPOIDataService$1(this, asyncCallback), this.poiSearchCategory.objectId, this.poiSearchArea);
    }
}

