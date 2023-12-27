/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechnavigation.usecase.common;

import de.vw.mib.asl.api.navigation.NavigationServiceException;
import de.vw.mib.asl.internal.speechnavigation.navi.api.adapter.service.NavigationService;
import de.vw.mib.asl.internal.speechnavigation.navi.api.adapter.service.NavigationServiceAdapter;
import de.vw.mib.asl.internal.speechnavigation.usecase.common.ApplicationErrorHandler;
import de.vw.mib.asl.internal.speechnavigation.usecase.common.Framework;

public abstract class ApplicationErrorHandlerBase
implements ApplicationErrorHandler {
    protected final NavigationService navigationService;

    public ApplicationErrorHandlerBase() {
        this.navigationService = NavigationServiceAdapter.getNavigationService();
    }

    public ApplicationErrorHandlerBase(NavigationService navigationService) {
        this.navigationService = navigationService;
    }

    protected void checkNaviServiceAvailable() {
        if (!this.navigationService.isNavigationServiceAvailable()) {
            this.onActionNotAvailable();
            throw new NavigationServiceException(" navigation service not available");
        }
    }

    @Override
    public void onActionFailed() {
        Framework.fireUIEvent(2097689600);
    }
}

