/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.impl.homebutton;

import de.vw.mib.asl.ASLPropertyManager;
import de.vw.mib.asl.api.homescreen.HomeScreenPages;
import de.vw.mib.asl.api.homescreen.HomeScreenPages$Page;
import de.vw.mib.asl.api.system.input.UserInteractionLockService;
import de.vw.mib.asl.internal.homebutton.HomeButtonServices;
import de.vw.mib.asl.internal.impl.homebutton.AbstractHomeButtonTarget;
import de.vw.mib.asl.internal.impl.homebutton.HomeButtonMainTarget$1;
import de.vw.mib.cio.CioDictionary;
import de.vw.mib.cio.CioDispatcher;
import de.vw.mib.cio.CioIntent;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.ServiceRegister;

public class HomeButtonMainTarget
extends AbstractHomeButtonTarget {
    private final ServiceRegister serviceRegister;
    private final CioDictionary cioDictionary;
    private final CioDispatcher cioDispatcher;
    private final HomeScreenPages homeScreenPages;
    private final ASLPropertyManager aslPropertyManager;
    private final UserInteractionLockService lockService;

    public HomeButtonMainTarget(HomeButtonServices homeButtonServices) {
        super(homeButtonServices.getGenericEvents(), homeButtonServices.getLogger(), -1002563072);
        this.serviceRegister = homeButtonServices.getServiceRegister();
        this.cioDictionary = homeButtonServices.getCioDictionary();
        this.cioDispatcher = homeButtonServices.getCioDispatcher();
        this.lockService = homeButtonServices.getUserInteractionLockService();
        this.homeScreenPages = homeButtonServices.getHomeScreenPages();
        this.aslPropertyManager = homeButtonServices.getAslPropertyManager();
        this.homeScreenPages.addPageListener(new HomeButtonMainTarget$1(this));
    }

    public void registerEvents() {
        this.serviceRegister.addObserver(-1070578112, this.getTargetId());
    }

    @Override
    public void gotEvent(EventGeneric eventGeneric) {
        if (eventGeneric.getReceiverEventId() == -1070578112) {
            this.processHomeButtonPressed();
            this.lockService.onUserInteraction();
        }
    }

    void setButtonState(HomeScreenPages$Page homeScreenPages$Page) {
        int n = this.toButtonState(homeScreenPages$Page);
        this.aslPropertyManager.valueChangedInteger(-766032384, n);
    }

    private int toButtonState(HomeScreenPages$Page homeScreenPages$Page) {
        if (homeScreenPages$Page == HomeScreenPages$Page.LEFT) {
            return 2;
        }
        if (homeScreenPages$Page == HomeScreenPages$Page.RIGHT) {
            return 3;
        }
        if (homeScreenPages$Page == HomeScreenPages$Page.NON) {
            return 0;
        }
        throw new IllegalArgumentException(new StringBuffer().append("Unable to convert Page >").append(homeScreenPages$Page).append("< to a button state!").toString());
    }

    private void processHomeButtonPressed() {
        HomeScreenPages$Page homeScreenPages$Page = this.homeScreenPages.getActivePage();
        if (homeScreenPages$Page == HomeScreenPages$Page.NON) {
            this.showHomeScreen();
            this.showPage(HomeScreenPages$Page.LEFT);
        } else if (homeScreenPages$Page == HomeScreenPages$Page.LEFT) {
            this.showPage(HomeScreenPages$Page.RIGHT);
        } else if (homeScreenPages$Page == HomeScreenPages$Page.RIGHT) {
            this.showPage(HomeScreenPages$Page.LEFT);
        }
    }

    private void showPage(HomeScreenPages$Page homeScreenPages$Page) {
        this.homeScreenPages.activatePage(homeScreenPages$Page);
    }

    private void showHomeScreen() {
        CioIntent cioIntent = this.cioDictionary.getCioIntent("ShowContent", "HMI_HOMESCREEN");
        this.cioDispatcher.dispatch(cioIntent);
    }
}

