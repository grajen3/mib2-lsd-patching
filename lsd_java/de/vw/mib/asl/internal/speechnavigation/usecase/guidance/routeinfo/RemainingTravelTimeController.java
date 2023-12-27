/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechnavigation.usecase.guidance.routeinfo;

import de.vw.mib.asl.api.navigation.NavigationServiceException;
import de.vw.mib.asl.api.speechengine.result.router.RecognizedEventConsumer;
import de.vw.mib.asl.internal.speechnavigation.common.AppLogger;
import de.vw.mib.asl.internal.speechnavigation.usecase.common.Framework;
import de.vw.mib.asl.internal.speechnavigation.usecase.guidance.routeinfo.GuidanceInformationControllerBase;

public class RemainingTravelTimeController
extends GuidanceInformationControllerBase
implements RecognizedEventConsumer {
    public static final int CMD_RTT;
    static /* synthetic */ Class class$de$vw$mib$asl$internal$speechnavigation$usecase$guidance$GuidanceHelpController;

    @Override
    public void onRecognizedEvent(int n) {
        switch (n) {
            case 1077141877: {
                try {
                    this.checkPrerequisites();
                }
                catch (NavigationServiceException navigationServiceException) {
                    AppLogger.info(new StringBuffer().append((class$de$vw$mib$asl$internal$speechnavigation$usecase$guidance$GuidanceHelpController == null ? (class$de$vw$mib$asl$internal$speechnavigation$usecase$guidance$GuidanceHelpController = RemainingTravelTimeController.class$("de.vw.mib.asl.internal.speechnavigation.usecase.guidance.GuidanceHelpController")) : class$de$vw$mib$asl$internal$speechnavigation$usecase$guidance$GuidanceHelpController).getName()).append(navigationServiceException.getMessage()).toString());
                    return;
                }
                this.onRemainingTravelTime();
                break;
            }
            default: {
                super.onRecognizedEvent(n);
            }
        }
    }

    private void onRemainingTravelTime() {
        if (this.guidanceService.getGuidanceStatus() == 1) {
            this.updateRouteInfo();
            Framework.fireUIEvent(-1677184000);
        } else {
            Framework.fireUIEvent(-1610075136);
        }
    }

    @Override
    public void onActionResumed() {
        this.onRemainingTravelTime();
    }

    @Override
    public void onActionNotAvailable() {
        Framework.fireUIEvent(-1391971328);
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

