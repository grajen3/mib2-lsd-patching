/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechnavigation.usecase.guidance.destination.details;

import de.vw.mib.asl.api.navigation.INavigationLocation;
import de.vw.mib.asl.internal.speechnavigation.common.AppLogger;
import de.vw.mib.asl.internal.speechnavigation.navi.api.adapter.map.listener.MapServiceListener;
import de.vw.mib.asl.internal.speechnavigation.usecase.guidance.destination.details.DestinationDetailController;

class DestinationDetailController$2
implements MapServiceListener {
    private final /* synthetic */ DestinationDetailController this$0;

    DestinationDetailController$2(DestinationDetailController destinationDetailController) {
        this.this$0 = destinationDetailController;
    }

    @Override
    public void showAddressOnMapResponse(int n, INavigationLocation iNavigationLocation) {
        if (n == 1) {
            AppLogger.error(new StringBuffer().append(super.getClass().getName()).append(", cannot refresh the map, however don't fail and show MAP with its current content.").toString());
        }
    }
}

