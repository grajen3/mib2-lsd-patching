/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechnavigation.usecase.onboardpoi.controller;

import de.vw.mib.asl.api.navigation.NavigationServiceException;
import de.vw.mib.asl.api.speechengine.result.router.RecognizedEventConsumer;
import de.vw.mib.asl.internal.speechnavigation.common.AppLogger;
import de.vw.mib.asl.internal.speechnavigation.usecase.common.ApplicationModalControllerBase;
import de.vw.mib.asl.internal.speechnavigation.usecase.common.Framework;
import de.vw.mib.asl.internal.speechnavigation.usecase.onboardpoi.controller.OnboardPOIEnterPOIXController;

public class OnboardPOIEnterPOIXMainController
extends ApplicationModalControllerBase
implements RecognizedEventConsumer {
    public static final int CMD_ENTER_POI_X;

    @Override
    public void onRecognizedEvent(int n) {
        switch (n) {
            case 1077141922: {
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
        OnboardPOIEnterPOIXController.enterPOIs();
    }

    @Override
    public void onActionCancelled() {
    }

    @Override
    public void onActionNotAvailable() {
        Framework.fireUIEvent(-402115584);
    }
}

