/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechnavigation.usecase.homeaddress;

import de.vw.mib.asl.api.navigation.INavigationLocation;
import de.vw.mib.asl.api.navigation.NavigationServiceException;
import de.vw.mib.asl.api.speechengine.result.router.RecognizedEventConsumer;
import de.vw.mib.asl.internal.speechnavigation.common.AppLogger;
import de.vw.mib.asl.internal.speechnavigation.common.SpeechServices;
import de.vw.mib.asl.internal.speechnavigation.navi.api.adapter.guidance.GuidanceService;
import de.vw.mib.asl.internal.speechnavigation.navi.api.adapter.guidance.NavigationGuidanceServiceAdapter;
import de.vw.mib.asl.internal.speechnavigation.navi.api.adapter.memory.HomeAddressService;
import de.vw.mib.asl.internal.speechnavigation.navi.api.adapter.memory.NavigationMemoryServiceAdapter;
import de.vw.mib.asl.internal.speechnavigation.navi.api.adapter.service.NavigationService;
import de.vw.mib.asl.internal.speechnavigation.navi.api.adapter.service.NavigationServiceAdapter;
import de.vw.mib.asl.internal.speechnavigation.usecase.common.ApplicationModalControllerBase;
import de.vw.mib.asl.internal.speechnavigation.usecase.common.Framework;
import de.vw.mib.asl.internal.speechnavigation.usecase.common.actions.ActionInvoker;
import de.vw.mib.asl.internal.speechnavigation.usecase.guidance.actions.StartGuidanceAction;
import de.vw.mib.asl.internal.speechnavigation.usecase.homeaddress.HomeAddressController$1;

public class HomeAddressController
extends ApplicationModalControllerBase
implements RecognizedEventConsumer {
    public static final int CMD_HOME;
    private final HomeAddressService homeAddressService;
    private final ActionInvoker actionInvoker;
    static /* synthetic */ Class class$de$vw$mib$asl$internal$speechnavigation$usecase$homeaddress$HomeAddressController;

    public HomeAddressController() {
        this(NavigationServiceAdapter.getNavigationService(), NavigationGuidanceServiceAdapter.getGuidanceService(), NavigationMemoryServiceAdapter.getHomeAddressService(), new ActionInvoker(SpeechServices.getDialogStateService()));
    }

    public HomeAddressController(NavigationService navigationService, GuidanceService guidanceService, HomeAddressService homeAddressService, ActionInvoker actionInvoker) {
        super(navigationService, guidanceService);
        this.homeAddressService = homeAddressService;
        this.actionInvoker = actionInvoker;
    }

    @Override
    public void onRecognizedEvent(int n) {
        switch (n) {
            case 1077141832: {
                try {
                    this.checkPrerequisites();
                }
                catch (NavigationServiceException navigationServiceException) {
                    AppLogger.info(new StringBuffer().append((class$de$vw$mib$asl$internal$speechnavigation$usecase$homeaddress$HomeAddressController == null ? (class$de$vw$mib$asl$internal$speechnavigation$usecase$homeaddress$HomeAddressController = HomeAddressController.class$("de.vw.mib.asl.internal.speechnavigation.usecase.homeaddress.HomeAddressController")) : class$de$vw$mib$asl$internal$speechnavigation$usecase$homeaddress$HomeAddressController).getName()).append(", ").append(navigationServiceException.getMessage()).toString());
                    return;
                }
                this.onNavigateHome();
                break;
            }
            default: {
                super.onRecognizedEvent(n);
            }
        }
    }

    @Override
    public void onActionNotAvailable() {
        Framework.fireUIEvent(1778922496);
    }

    @Override
    public void onActionResumed() {
        this.onNavigateHome();
    }

    public void onNavigateHome() {
        INavigationLocation iNavigationLocation = this.homeAddressService.getHomeAddress();
        if (iNavigationLocation == null || !iNavigationLocation.isValid()) {
            this.notifyHomeAddressNotDefined();
            return;
        }
        if (this.guidanceService.getGuidanceStatus() == 1) {
            this.guidanceService.stopGuidance(new HomeAddressController$1(this, iNavigationLocation));
        } else {
            this.startGuidanceTo(iNavigationLocation);
        }
    }

    void startGuidanceTo(INavigationLocation iNavigationLocation) {
        this.notifyStartGuidanceToHomeSucceeded();
        this.actionInvoker.invokeWhenSdsSessionEnds(new StartGuidanceAction(this.guidanceService, iNavigationLocation));
    }

    private void notifyHomeAddressNotDefined() {
        Framework.fireUIEvent(1762145280);
    }

    private void notifyStartGuidanceToHomeSucceeded() {
        Framework.fireUIEvent(1745368064);
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

