/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechnavigation.usecase.guidance.routeinfo;

import de.vw.mib.asl.api.navigation.NavigationServiceException;
import de.vw.mib.asl.api.speechengine.result.router.RecognizedEventConsumer;
import de.vw.mib.asl.internal.speechnavigation.common.AppLogger;
import de.vw.mib.asl.internal.speechnavigation.usecase.common.Framework;
import de.vw.mib.asl.internal.speechnavigation.usecase.guidance.routeinfo.GuidanceInformationControllerBase;

public class DistanceToDestinationController
extends GuidanceInformationControllerBase
implements RecognizedEventConsumer {
    public static final int CMD_DTD;
    static /* synthetic */ Class class$de$vw$mib$asl$internal$speechnavigation$usecase$guidance$GuidanceHelpController;

    @Override
    public void onRecognizedEvent(int n) {
        switch (n) {
            case 1077141876: {
                try {
                    this.checkPrerequisites();
                }
                catch (NavigationServiceException navigationServiceException) {
                    AppLogger.info(new StringBuffer().append((class$de$vw$mib$asl$internal$speechnavigation$usecase$guidance$GuidanceHelpController == null ? (class$de$vw$mib$asl$internal$speechnavigation$usecase$guidance$GuidanceHelpController = DistanceToDestinationController.class$("de.vw.mib.asl.internal.speechnavigation.usecase.guidance.GuidanceHelpController")) : class$de$vw$mib$asl$internal$speechnavigation$usecase$guidance$GuidanceHelpController).getName()).append(navigationServiceException.getMessage()).toString());
                    return;
                }
                this.onDistanceToDestination();
                break;
            }
            default: {
                super.onRecognizedEvent(n);
            }
        }
    }

    private void onDistanceToDestination() {
        if (this.guidanceService.getGuidanceStatus() == 1) {
            this.updateRouteInfo();
            Framework.fireUIEvent(-1693961216);
        } else {
            Framework.fireUIEvent(-1626852352);
        }
    }

    @Override
    public void onActionResumed() {
        this.onDistanceToDestination();
    }

    @Override
    public void onActionNotAvailable() {
        Framework.fireUIEvent(-1408748544);
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

