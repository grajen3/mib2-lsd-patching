/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechnavigation.usecase.guidance;

import de.vw.mib.asl.api.navigation.INavigationLocation;
import de.vw.mib.asl.api.speechengine.result.router.ModelEventConsumer;
import de.vw.mib.asl.api.speechengine.result.router.RecognizedEventConsumer;
import de.vw.mib.asl.internal.speechnavigation.usecase.common.Framework;
import de.vw.mib.asl.internal.speechnavigation.usecase.guidance.actions.AddNextStopOverAction;
import de.vw.mib.asl.internal.speechnavigation.usecase.guidance.actions.StartGuidanceAction;
import de.vw.mib.asl.internal.speechnavigation.usecase.guidance.destination.details.DestinationDetailController;
import de.vw.mib.genericevents.EventGeneric;

public class StartGuidanceCheckStopoverController
extends DestinationDetailController
implements RecognizedEventConsumer,
ModelEventConsumer {
    public static final int CHECK_STOPOVER_BEFORE_START_GUIDANCE;

    @Override
    public void onEvent(EventGeneric eventGeneric) {
        int n = eventGeneric.getReceiverEventId();
        switch (n) {
            case 1077141896: {
                this.destinationDetail = (INavigationLocation)eventGeneric.getObject(0);
                this.onShowDestinationAddressDetails(this.destinationDetail);
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
            case 1077141890: 
            case 1077141892: {
                this.onStartGuidanceAddStopoverCommand();
                break;
            }
            case 1077141891: 
            case 1077141893: 
            case 1077141894: {
                this.onStartGuidanceDirectlyCommand();
                break;
            }
            case 1077141895: {
                this.onAbortStartGuidanceDirectly();
                break;
            }
            default: {
                super.onRecognizedEvent(n);
            }
        }
    }

    @Override
    public void onActionNotAvailable() {
    }

    public static void startGuidance(INavigationLocation iNavigationLocation) {
        Framework.fireEvent(-1998507200, iNavigationLocation);
    }

    private void onShowDestinationAddressDetails(INavigationLocation iNavigationLocation) {
        if (this.guidanceService.getGuidanceStatus() == 1) {
            if (this.guidanceService.canAddStopover()) {
                super.showDestinationAddressDetails(iNavigationLocation, -1089981440);
            } else {
                super.showDestinationAddressDetails(iNavigationLocation, -1073204224);
            }
        } else {
            Framework.fireUIEvent(-1056427008);
            this.actionInvoker.invokeWhenSdsSessionEnds(new StartGuidanceAction(this.guidanceService, iNavigationLocation));
        }
    }

    private void onStartGuidanceDirectlyCommand() {
        Framework.fireUIEvent(-1123535872);
        this.actionInvoker.invokeWhenSdsSessionEnds(new StartGuidanceAction(this.guidanceService, this.destinationDetail));
    }

    private void onStartGuidanceAddStopoverCommand() {
        Framework.fireUIEvent(-1140313088);
        this.actionInvoker.invokeWhenSdsSessionEnds(new AddNextStopOverAction(this.guidanceService, this.destinationDetail));
    }

    private void onAbortStartGuidanceDirectly() {
        Framework.fireUIEvent(-1106758656);
    }
}

