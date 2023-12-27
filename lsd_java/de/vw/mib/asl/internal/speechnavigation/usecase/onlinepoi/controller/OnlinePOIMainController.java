/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechnavigation.usecase.onlinepoi.controller;

import de.vw.mib.asl.api.navigation.NavigationServiceException;
import de.vw.mib.asl.api.online.ASLOnlineServiceCallback;
import de.vw.mib.asl.api.online.ASLOnlineServiceIdentifier;
import de.vw.mib.asl.api.speechengine.result.router.ModelEventConsumer;
import de.vw.mib.asl.api.speechengine.result.router.RecognizedEventConsumer;
import de.vw.mib.asl.framework.api.framework.ASLFrameworkFactory;
import de.vw.mib.asl.internal.speechnavigation.common.AppLogger;
import de.vw.mib.asl.internal.speechnavigation.usecase.common.ApplicationModalControllerBase;
import de.vw.mib.asl.internal.speechnavigation.usecase.common.Framework;
import de.vw.mib.asl.internal.speechnavigation.usecase.onlinepoi.model.OnlinePOI;
import de.vw.mib.asl.internal.speechnavigation.usecase.onlinepoi.service.OnlinePOIHandler;
import de.vw.mib.asl.internal.speechnavigation.usecase.onlinepoi.service.OnlinePOIListUpdateListener;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.GenericEventException;
import de.vw.mib.genericevents.GenericEvents;
import org.dsi.ifc.global.ResourceLocator;

public class OnlinePOIMainController
extends ApplicationModalControllerBase
implements RecognizedEventConsumer,
ModelEventConsumer,
OnlinePOIListUpdateListener,
ASLOnlineServiceCallback {
    private final String logPrefix;
    public static final int CMD_ENTER_POI_ONLINE;
    public static final int CMD_ENTER_POI_ONLINE_X;
    private final OnlinePOIHandler service;
    private boolean onlineGeneralReady = false;
    private boolean dialog = false;

    public OnlinePOIMainController(OnlinePOIHandler onlinePOIHandler) {
        this.logPrefix = "[SN][OnlinePOI][OnlinePOIMainController] ";
        this.service = onlinePOIHandler;
        onlinePOIHandler.registerListener(this);
    }

    private void tryToOpenOnlineWizard() {
        AppLogger.trace("[SN][OnlinePOI][OnlinePOIMainController] Trying to open the online wizard if necessary.");
        GenericEvents genericEvents = ASLFrameworkFactory.getASLFrameworkAPI().getServices().getGenericEvents();
        try {
            EventGeneric eventGeneric = genericEvents.getEventFactory().newEvent(171854080);
            eventGeneric.setInt(0, 0);
            genericEvents.getEventDispatcher().send(eventGeneric);
        }
        catch (GenericEventException genericEventException) {
            AppLogger.error("Triggering the online wizard via generic event failed.");
        }
    }

    private void doOnlineChecks() {
        if (!this.service.isServiceReady()) {
            this.onGeneralProblem();
            AppLogger.trace("[SN][OnlinePOI][OnlinePOIMainController] Navi services not ready.");
            throw new NavigationServiceException("navigation service for online POI search via SDS is not ready");
        }
        if (!this.service.isOnlineFeatureNotSupported()) {
            this.onSolveableProblem();
            AppLogger.trace("[SN][OnlinePOI][OnlinePOIMainController] Online services do not support this feature.");
            throw new NavigationServiceException("online poi search via SDS is not available (by backend or settings)");
        }
        this.service.checkIsOnlineServiceReady(this);
    }

    @Override
    protected void checkPrerequisites() {
        AppLogger.trace("[SN][OnlinePOI][OnlinePOIMainController] Doing some checks before starting the use case.");
        super.checkPrerequisites();
        this.doOnlineChecks();
    }

    @Override
    public void onEvent(EventGeneric eventGeneric) {
        int n = eventGeneric.getReceiverEventId();
        switch (n) {
            case 4800009: {
                if (this.onlineGeneralReady) break;
                this.onlineGeneralReady = eventGeneric.getBoolean(0);
                AppLogger.trace(new StringBuffer().append("[SN][OnlinePOI][OnlinePOIMainController] Received online service status notification: ").append(this.onlineGeneralReady).toString());
                break;
            }
            default: {
                AppLogger.warn(new StringBuffer().append("[SN][OnlinePOI][OnlinePOIMainController] received but discarded generic event with id ").append(n).append(".").toString());
            }
        }
    }

    @Override
    public void onRecognizedEvent(int n) {
        switch (n) {
            case 1077141936: {
                AppLogger.trace("[SN][OnlinePOI][OnlinePOIMainController] Received request for online POI search dialog.");
                this.dialog = true;
                try {
                    this.checkPrerequisites();
                    break;
                }
                catch (NavigationServiceException navigationServiceException) {
                    AppLogger.info(new StringBuffer().append(super.getClass().getName()).append(", ").append(navigationServiceException.getMessage()).toString());
                    return;
                }
            }
            case 1077141938: {
                AppLogger.trace("[SN][OnlinePOI][OnlinePOIMainController] Received request for online POI search oneshot.");
                this.dialog = false;
                try {
                    this.checkPrerequisites();
                    break;
                }
                catch (NavigationServiceException navigationServiceException) {
                    AppLogger.info(new StringBuffer().append(super.getClass().getName()).append(", ").append(navigationServiceException.getMessage()).toString());
                    return;
                }
            }
            default: {
                super.onRecognizedEvent(n);
            }
        }
    }

    @Override
    public void onActionResumed() {
        if (this.dialog) {
            AppLogger.trace("[SN][OnlinePOI][OnlinePOIMainController] Online POI search prechecks were successful, start dialog use case.");
            Framework.fireEvent(1963333888);
        } else if (this.navCheckDone) {
            AppLogger.trace("[SN][OnlinePOI][OnlinePOIMainController] Nav checks were successful but contained user input, do online checks now.");
            try {
                this.doOnlineChecks();
            }
            catch (NavigationServiceException navigationServiceException) {
                AppLogger.trace("[SN][OnlinePOI][OnlinePOIMainController] Online checks after nav check failed.");
            }
        } else {
            AppLogger.trace("[SN][OnlinePOI][OnlinePOIMainController] Online POI search prechecks were successful, start oneshot use case.");
            Framework.fireEvent(1996888320);
        }
    }

    @Override
    public void onActionCancelled() {
    }

    @Override
    public void onActionNotAvailable() {
        this.onGeneralProblem();
    }

    public void onSolveableProblem() {
        Framework.fireUIEvent(487142400);
    }

    public void onGeneralProblem() {
        Framework.fireUIEvent(218706944);
    }

    @Override
    public void onError(int n) {
        if (this.service.isUseCaseActive() && !this.service.isSearchActive()) {
            this.onGeneralProblem();
        }
    }

    @Override
    public void onNewDataReceived(OnlinePOI[] onlinePOIArray) {
    }

    @Override
    public void checkOnlineServiceStatusResponse(ASLOnlineServiceIdentifier aSLOnlineServiceIdentifier, int n) {
        if (aSLOnlineServiceIdentifier.getServiceidentifier().equals("poi-search")) {
            AppLogger.trace("[SN][OnlinePOI][OnlinePOIMainController] Received status from online services.");
            if (n == 0) {
                AppLogger.trace("[SN][OnlinePOI][OnlinePOIMainController] Everything is ok, start use case.");
                this.service.startUseCase();
                if (this.navCheckDone) {
                    AppLogger.trace("[SN][OnlinePOI][OnlinePOIMainController] Start dialog use case after nav check handling.");
                    Framework.fireEvent(1980111104);
                } else {
                    AppLogger.trace("[SN][OnlinePOI][OnlinePOIMainController] Start dialog or direct input use case.");
                    this.onActionResumed();
                }
            } else if (n == 2) {
                AppLogger.trace("[SN][OnlinePOI][OnlinePOIMainController] User has deactivated the POI Voice Search online service in setup.");
                this.onSolveableProblem();
            } else {
                AppLogger.trace("[SN][OnlinePOI][OnlinePOIMainController] Online services report a problem.");
                this.onGeneralProblem();
            }
        }
    }

    @Override
    public void getServiceURLResponse(ASLOnlineServiceIdentifier aSLOnlineServiceIdentifier, String string) {
    }

    @Override
    public void updateImageInfo(ResourceLocator resourceLocator) {
    }
}

