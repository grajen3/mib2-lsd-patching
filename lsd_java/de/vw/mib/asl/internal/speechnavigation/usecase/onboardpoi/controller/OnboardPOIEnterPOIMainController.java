/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechnavigation.usecase.onboardpoi.controller;

import de.vw.mib.asl.api.navigation.NavigationServiceException;
import de.vw.mib.asl.api.speechengine.result.router.RecognizedEventConsumer;
import de.vw.mib.asl.internal.speechnavigation.common.AppLogger;
import de.vw.mib.asl.internal.speechnavigation.usecase.common.ApplicationModalControllerBase;
import de.vw.mib.asl.internal.speechnavigation.usecase.common.Framework;
import de.vw.mib.asl.internal.speechnavigation.usecase.onboardpoi.controller.OnboardPOIEnterPOIController;

public class OnboardPOIEnterPOIMainController
extends ApplicationModalControllerBase
implements RecognizedEventConsumer {
    public static final int CMD_ENTER_POI;

    @Override
    public void onRecognizedEvent(int n) {
        switch (n) {
            case 1077141920: {
                try {
                    this.checkPrerequisites();
                }
                catch (NavigationServiceException navigationServiceException) {
                    AppLogger.info(new StringBuffer().append(super.getClass().getName()).append(", ").append(navigationServiceException.getMessage()).toString());
                    return;
                }
                this.onActionResumed();
                break;
            }
            default: {
                super.onRecognizedEvent(n);
            }
        }
    }

    @Override
    public void onActionResumed() {
        OnboardPOIEnterPOIController.enterPOIs();
    }

    @Override
    public void onActionCancelled() {
    }

    @Override
    public void onActionNotAvailable() {
        Framework.fireUIEvent(-402115584);
    }
}

