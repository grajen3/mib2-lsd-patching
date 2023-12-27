/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechnavigation.usecase.lastdestination.service;

import de.vw.mib.asl.api.navigation.INavigationListElement;
import de.vw.mib.asl.api.speechengine.result.model.ResultItem;
import de.vw.mib.asl.api.speechengine.result.service.AdditionalDataService;
import de.vw.mib.asl.api.speechengine.result.service.AsyncCallback;
import de.vw.mib.asl.internal.speechnavigation.navi.api.adapter.memory.LastDestinationService;
import de.vw.mib.asl.internal.speechnavigation.navi.api.adapter.memory.NavigationMemoryServiceAdapter;
import de.vw.mib.asl.internal.speechnavigation.usecase.lastdestination.model.LastDestination;
import de.vw.mib.collections.ObjectArrayList;
import de.vw.mib.collections.longs.LongObjectOptHashMap;

public class LastDestinationAdditionalDataService
implements AdditionalDataService {
    private final LastDestinationService lastDestinationService = NavigationMemoryServiceAdapter.getLastDestinationService();

    @Override
    public void getDataRequest(AsyncCallback asyncCallback, ResultItem[] resultItemArray) {
        INavigationListElement[] iNavigationListElementArray = this.lastDestinationService.getLastDestinations();
        LongObjectOptHashMap longObjectOptHashMap = new LongObjectOptHashMap(iNavigationListElementArray.length);
        for (int i2 = 0; i2 < iNavigationListElementArray.length; ++i2) {
            longObjectOptHashMap.put(iNavigationListElementArray[i2].getId(), iNavigationListElementArray[i2]);
        }
        ObjectArrayList objectArrayList = new ObjectArrayList();
        for (int i3 = 0; i3 < resultItemArray.length; ++i3) {
            ResultItem resultItem = resultItemArray[i3];
            if (resultItem.isGroup()) {
                objectArrayList.add(new LastDestination(resultItem.getSize(), resultItem.getText()));
                continue;
            }
            objectArrayList.add(new LastDestination((INavigationListElement)longObjectOptHashMap.get(resultItem.getIdentifier().getObjectId())));
        }
        asyncCallback.onResponse(objectArrayList.toArray());
    }
}

