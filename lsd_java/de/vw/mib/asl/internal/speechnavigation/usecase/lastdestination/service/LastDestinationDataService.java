/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechnavigation.usecase.lastdestination.service;

import de.vw.mib.asl.api.navigation.INavigationListElement;
import de.vw.mib.asl.api.speechengine.result.service.AsyncCallback;
import de.vw.mib.asl.api.speechengine.result.service.DataService;
import de.vw.mib.asl.internal.speechnavigation.navi.api.adapter.memory.LastDestinationService;
import de.vw.mib.asl.internal.speechnavigation.navi.api.adapter.memory.NavigationMemoryServiceAdapter;
import de.vw.mib.asl.internal.speechnavigation.usecase.lastdestination.model.LastDestination;

public class LastDestinationDataService
implements DataService {
    private final LastDestinationService lastDestinationService = NavigationMemoryServiceAdapter.getLastDestinationService();

    @Override
    public void getDataRequest(AsyncCallback asyncCallback) {
        INavigationListElement[] iNavigationListElementArray = this.lastDestinationService.getLastDestinations();
        Object[] objectArray = new LastDestination[iNavigationListElementArray.length];
        for (int i2 = 0; i2 < iNavigationListElementArray.length; ++i2) {
            objectArray[i2] = new LastDestination(iNavigationListElementArray[i2]);
        }
        asyncCallback.onResponse(objectArray);
    }
}

