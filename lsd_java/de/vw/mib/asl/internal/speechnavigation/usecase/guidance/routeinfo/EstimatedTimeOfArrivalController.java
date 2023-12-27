/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechnavigation.usecase.guidance.routeinfo;

import de.vw.mib.asl.api.navigation.NavigationServiceException;
import de.vw.mib.asl.api.speechengine.result.router.RecognizedEventConsumer;
import de.vw.mib.asl.internal.speechnavigation.common.AppLogger;
import de.vw.mib.asl.internal.speechnavigation.usecase.common.Framework;
import de.vw.mib.asl.internal.speechnavigation.usecase.guidance.routeinfo.GuidanceInformationControllerBase;

public class EstimatedTimeOfArrivalController
extends GuidanceInformationControllerBase
implements RecognizedEventConsumer {
    public static final int CMD_ETA;
    static /* synthetic */ Class class$de$vw$mib$asl$internal$speechnavigation$usecase$guidance$GuidanceHelpController;

    @Override
    public void onRecognizedEvent(int n) {
        switch (n) {
            case 1077141875: {
                try {
                    this.checkPrerequisites();
                }
                catch (NavigationServiceException navigationServiceException) {
                    AppLogger.info(new StringBuffer().append((class$de$vw$mib$asl$internal$speechnavigation$usecase$guidance$GuidanceHelpController == null ? (class$de$vw$mib$asl$internal$speechnavigation$usecase$guidance$GuidanceHelpController = EstimatedTimeOfArrivalController.class$("de.vw.mib.asl.internal.speechnavigation.usecase.guidance.GuidanceHelpController")) : class$de$vw$mib$asl$internal$speechnavigation$usecase$guidance$GuidanceHelpController).getName()).append(navigationServiceException.getMessage()).toString());
                    return;
                }
                this.onEstimatedTimeOfArrival();
                break;
            }
            default: {
                super.onRecognizedEvent(n);
            }
        }
    }

    private void onEstimatedTimeOfArrival() {
        if (this.guidanceService.getGuidanceStatus() == 1) {
            this.updateRouteInfo();
            Framework.fireUIEvent(-1710738432);
        } else {
            Framework.fireUIEvent(-1643629568);
        }
    }

    @Override
    public void onActionResumed() {
        this.onEstimatedTimeOfArrival();
    }

    @Override
    public void onActionNotAvailable() {
        Framework.fireUIEvent(-1425525760);
    }

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError().initCause(classNotFoundException);
        }
    }
}

