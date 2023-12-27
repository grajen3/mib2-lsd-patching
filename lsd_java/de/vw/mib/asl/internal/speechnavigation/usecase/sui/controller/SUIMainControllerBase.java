/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechnavigation.usecase.sui.controller;

import de.vw.mib.asl.api.navigation.NavigationServiceException;
import de.vw.mib.asl.api.speechengine.result.router.RecognizedEventConsumer;
import de.vw.mib.asl.internal.speechnavigation.common.AppLogger;
import de.vw.mib.asl.internal.speechnavigation.usecase.common.ApplicationModalControllerBase;
import de.vw.mib.asl.internal.speechnavigation.usecase.common.Framework;
import de.vw.mib.asl.internal.speechnavigation.usecase.sui.controller.SUIController;
import de.vw.mib.asl.internal.speechnavigation.usecase.sui.service.SUICheckerService;

public abstract class SUIMainControllerBase
extends ApplicationModalControllerBase
implements RecognizedEventConsumer {
    protected final SUICheckerService service;
    protected boolean isGarbage = false;

    public SUIMainControllerBase(SUICheckerService sUICheckerService) {
        this.service = sUICheckerService;
    }

    @Override
    public void onRecognizedEvent(int n) {
        switch (n) {
            case 1077141945: 
            case 1077141946: 
            case 1077141947: {
                this.isGarbage = false;
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
            case 1077141949: {
                this.isGarbage = true;
                try {
                    this.checkPrerequisites();
                }
                catch (NavigationServiceException navigationServiceException) {
                    AppLogger.info(new StringBuffer().append(super.getClass().getName()).append(", ").append(navigationServiceException.getMessage()).toString());
                    return;
                }
                this.onLanguageNotSupported();
                break;
            }
            default: {
                super.onRecognizedEvent(n);
            }
        }
    }

    @Override
    protected void checkPrerequisites() {
        super.checkPrerequisites();
        this.checkLanguageSupported();
    }

    protected void checkLanguageSupported() {
        if (!this.service.getIsSUISupported()) {
            this.onLanguageNotSupported();
            throw new NavigationServiceException(" SL is not supported for current LDCs ");
        }
    }

    private void onLanguageNotSupported() {
        Framework.fireUIEvent(638137344);
    }

    @Override
    public void onActionResumed() {
        if (!this.isGarbage) {
            SUIController.navigateAsSUI();
        } else {
            this.onLanguageNotSupported();
        }
    }
}

