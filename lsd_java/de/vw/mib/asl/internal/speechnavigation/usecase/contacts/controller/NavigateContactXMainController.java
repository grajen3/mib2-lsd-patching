/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechnavigation.usecase.contacts.controller;

import de.vw.mib.asl.api.navigation.NavigationServiceException;
import de.vw.mib.asl.api.speechengine.result.router.RecognizedEventConsumer;
import de.vw.mib.asl.internal.speechnavigation.common.AppLogger;
import de.vw.mib.asl.internal.speechnavigation.usecase.common.Framework;
import de.vw.mib.asl.internal.speechnavigation.usecase.contacts.controller.NavigateContactModalControllerBase;
import de.vw.mib.asl.internal.speechnavigation.usecase.contacts.controller.NavigateContactXController;

public class NavigateContactXMainController
extends NavigateContactModalControllerBase
implements RecognizedEventConsumer {
    public static final int CMD_NAVIGATE_CONTACT_X;

    @Override
    public void onRecognizedEvent(int n) {
        switch (n) {
            case 1077141916: {
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
        NavigateContactXController.navigateContactX();
    }

    @Override
    public void onActionCancelled() {
    }

    @Override
    public void onActionNotAvailable() {
        Framework.fireUIEvent(-603442176);
    }
}

