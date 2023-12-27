/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechnavigation.usecase.guidance.routeinfo;

import de.vw.mib.asl.api.navigation.NavigationServiceException;
import de.vw.mib.asl.api.speechengine.result.router.RecognizedEventConsumer;
import de.vw.mib.asl.internal.speechnavigation.common.AppLogger;
import de.vw.mib.asl.internal.speechnavigation.usecase.common.Framework;
import de.vw.mib.asl.internal.speechnavigation.usecase.guidance.routeinfo.GuidanceInformationControllerBase;

public class RouteInformationController
extends GuidanceInformationControllerBase
implements RecognizedEventConsumer {
    public static final int CMD_ROUTE_INFO;
    static /* synthetic */ Class class$de$vw$mib$asl$internal$speechnavigation$usecase$guidance$GuidanceHelpController;

    @Override
    public void onRecognizedEvent(int n) {
        switch (n) {
            case 1077141874: {
                try {
                    this.checkPrerequisites();
                }
                catch (NavigationServiceException navigationServiceException) {
                    AppLogger.info(new StringBuffer().append((class$de$vw$mib$asl$internal$speechnavigation$usecase$guidance$GuidanceHelpController == null ? (class$de$vw$mib$asl$internal$speechnavigation$usecase$guidance$GuidanceHelpController = RouteInformationController.class$("de.vw.mib.asl.internal.speechnavigation.usecase.guidance.GuidanceHelpController")) : class$de$vw$mib$asl$internal$speechnavigation$usecase$guidance$GuidanceHelpController).getName()).append(navigationServiceException.getMessage()).toString());
                    return;
                }
                this.onRouteInfo();
                break;
            }
            default: {
                super.onRecognizedEvent(n);
            }
        }
    }

    private void onRouteInfo() {
        if (this.guidanceService.getGuidanceStatus() == 1) {
            this.updateRouteInfo();
            Framework.fireUIEvent(-1727515648);
        } else {
            Framework.fireUIEvent(-1660406784);
        }
    }

    @Override
    public void onActionResumed() {
        this.onRouteInfo();
    }

    @Override
    public void onActionNotAvailable() {
        Framework.fireUIEvent(-1442302976);
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

