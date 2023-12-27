/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechnavigation.usecase.onboardpoi.service;

import de.vw.mib.asl.api.navigation.poi.onboard.IOnboardPoiListElement;
import de.vw.mib.asl.api.speechengine.result.service.AsyncCallback;
import de.vw.mib.asl.internal.speechnavigation.navi.api.adapter.onboardpoi.listener.SearchPOIListener;
import de.vw.mib.asl.internal.speechnavigation.usecase.onboardpoi.model.OnboardPOI;
import de.vw.mib.asl.internal.speechnavigation.usecase.onboardpoi.service.OnboardPOIDataService;
import de.vw.mib.asl.internal.speechnavigation.usecase.onboardpoi.service.POISearchStatusListener;
import java.util.Iterator;

class OnboardPOIDataService$1
implements SearchPOIListener {
    private final /* synthetic */ AsyncCallback val$asynccallback;
    private final /* synthetic */ OnboardPOIDataService this$0;

    OnboardPOIDataService$1(OnboardPOIDataService onboardPOIDataService, AsyncCallback asyncCallback) {
        this.this$0 = onboardPOIDataService;
        this.val$asynccallback = asyncCallback;
    }

    @Override
    public void updateSearchStatus(int n, int n2, int n3, int n4) {
        Iterator iterator = this.this$0.poiSearchStatusListeners.iterator();
        while (iterator.hasNext()) {
            POISearchStatusListener pOISearchStatusListener = (POISearchStatusListener)iterator.next();
            pOISearchStatusListener.updateSearchStatus(n == 1 ? 1 : n2, n3, n4);
        }
    }

    @Override
    public void updatePOIs(IOnboardPoiListElement[] iOnboardPoiListElementArray) {
        int n = this.this$0.poiResultList.size();
        for (int i2 = 0; i2 < iOnboardPoiListElementArray.length; ++i2) {
            IOnboardPoiListElement iOnboardPoiListElement = iOnboardPoiListElementArray[i2];
            if (iOnboardPoiListElement == null) continue;
            OnboardPOI onboardPOI = new OnboardPOI(n + i2, iOnboardPoiListElement);
            this.this$0.poiResultList.add(onboardPOI);
        }
        this.val$asynccallback.onResponse(this.this$0.poiResultList.toArray());
    }
}

