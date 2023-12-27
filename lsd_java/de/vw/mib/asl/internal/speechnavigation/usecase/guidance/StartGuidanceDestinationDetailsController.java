/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechnavigation.usecase.guidance;

import de.vw.mib.asl.api.navigation.INavigationLocation;
import de.vw.mib.asl.internal.speechnavigation.usecase.common.Framework;
import de.vw.mib.asl.internal.speechnavigation.usecase.guidance.destination.details.DestinationDetailController;
import de.vw.mib.genericevents.EventGeneric;

public class StartGuidanceDestinationDetailsController
extends DestinationDetailController {
    public static final int SHOW_DESTINATION_ADDRESS_DETAILS;

    @Override
    public void onEvent(EventGeneric eventGeneric) {
        int n = eventGeneric.getReceiverEventId();
        switch (n) {
            case 1077141889: {
                this.destinationDetail = (INavigationLocation)eventGeneric.getObject(0);
                this.onShowDestinationAddressDetails((INavigationLocation)eventGeneric.getObject(0));
                break;
            }
            default: {
                super.onEvent(eventGeneric);
            }
        }
    }

    public static void showAddressDetailView(INavigationLocation iNavigationLocation) {
        Framework.fireEvent(-2115947712, iNavigationLocation);
    }

    private void onShowDestinationAddressDetails(INavigationLocation iNavigationLocation) {
        this.showDestinationAddressDetails(iNavigationLocation, 1577595904);
    }

    @Override
    protected void onReEnterAddressCommand() {
        this.destinationInputListener.onReEnterAddress(false);
    }
}

