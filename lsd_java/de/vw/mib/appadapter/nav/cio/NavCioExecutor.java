/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.appadapter.nav.cio;

import de.vw.mib.appadapter.nav.NavAdapter;
import de.vw.mib.asl.api.navigation.ASLNavigationAPI;
import de.vw.mib.asl.api.navigation.ASLNavigationFactory;
import de.vw.mib.asl.api.navigation.INavServiceStateListener;
import de.vw.mib.asl.api.navigation.NavigationServiceException;
import de.vw.mib.asl.api.navigation.memory.NavigationMemoryListenerAdapter;
import de.vw.mib.asl.api.navigation.memory.NavigationMemoryService;
import de.vw.mib.asl.api.navigation.splitscreen.NavigationSplitscreenListenerAdapter;
import de.vw.mib.asl.api.navigation.splitscreen.NavigationSplitscreenService;
import de.vw.mib.cio.CioActionParameters;
import de.vw.mib.cio.CioExecutor;
import de.vw.mib.cio.CioIntent;
import de.vw.mib.cio.ContentInformationObject;
import generated.de.vw.mib.appadapter.nav.HomeAddressInputModelApiCallback;
import generated.de.vw.mib.appadapter.nav.ShowNavViewModelApiCallback;

public class NavCioExecutor
extends NavigationMemoryListenerAdapter
implements CioExecutor,
INavServiceStateListener {
    private static final int SET_HOME_ADDRESS_TO_CCP;
    private static final int SHOW_HOME_ADDRESS_INPUT;
    private static final int SHOW_NAV_VIEW;
    private static final int MENU_ACTION_NAV;
    private static final int MENU_ACTION_TRAFFIC;
    private static final String RETURN_PARAM_NAME_SUCCESS;
    private static final String RETURN_PARAM_NAME_FAILURE;
    private static final String RETURN_PARAM_NAME_CANCEL;
    private static final String ENTRY_MODE;
    private static final String TRAFFIC;
    private static final String NAVIGATION;
    private static final String COMPASS;
    private static final String POSITION;
    private static final String WPM;
    private static final String MANEUVER;
    private static final String PNAV;
    private static final int SET_CURRENT_CONTENT_SS_VALUE_COMPASS;
    private static final int SET_CURRENT_CONTENT_SS_VALUE_GPS;
    private static final int SET_CURRENT_CONTENT_SS_VALUE_MANUVERVIEW;
    private static final int SET_CURRENT_CONTENT_SS_VALUE_PNAV;
    private static int SET_CURRENT_CONTENT_SS_VALUE_PARAM;
    private CioActionParameters returnParams;
    private ASLNavigationAPI navapi;
    private NavigationMemoryService naviMemoryService;
    private NavigationSplitscreenService naviSplitscreenService;
    private NavigationSplitscreenListenerAdapter naviSplitscreenListenerAdapter;
    private ContentInformationObject cioSetHomeAddressToCCP;
    private ContentInformationObject cioShowHomeAddressInput;
    static /* synthetic */ Class class$generated$de$vw$mib$appadapter$nav$HomeAddressInputModelApiCallback;
    static /* synthetic */ Class class$generated$de$vw$mib$appadapter$nav$ShowNavViewModelApiCallback;

    @Override
    public void execute(ContentInformationObject contentInformationObject, CioActionParameters cioActionParameters) {
        this.returnParams = cioActionParameters;
        switch (contentInformationObject.getActionId()) {
            case 0: {
                if (this.naviMemoryService != null) {
                    this.naviMemoryService.setHomeAddressToCcp();
                    break;
                }
                try {
                    this.naviMemoryService = this.navapi.getNavigationMemoryService(this);
                }
                catch (NavigationServiceException navigationServiceException) {
                    this.updateHomeAddressSetToCcpDone(false);
                }
                if (this.naviMemoryService == null) break;
                this.naviMemoryService.setHomeAddressToCcp();
                break;
            }
            case 1: {
                HomeAddressInputModelApiCallback homeAddressInputModelApiCallback = (HomeAddressInputModelApiCallback)NavAdapter.getSystemServices().createModelApiClient(class$generated$de$vw$mib$appadapter$nav$HomeAddressInputModelApiCallback == null ? (class$generated$de$vw$mib$appadapter$nav$HomeAddressInputModelApiCallback = NavCioExecutor.class$("generated.de.vw.mib.appadapter.nav.HomeAddressInputModelApiCallback")) : class$generated$de$vw$mib$appadapter$nav$HomeAddressInputModelApiCallback);
                homeAddressInputModelApiCallback._on_appNavHomeAddressInputSetupWizardRequest();
                break;
            }
            case 2: {
                this.updateModelCurrentView(cioActionParameters);
                break;
            }
            case 3: {
                this.updateModelCurrentView("Navigation");
                break;
            }
            case 4: {
                this.updateModelCurrentView("Traffic");
                break;
            }
        }
    }

    @Override
    public boolean onCioIntentRegistration(ContentInformationObject contentInformationObject) {
        switch (contentInformationObject.getActionId()) {
            case 0: {
                this.registerASLNavigationAPI();
                this.cioSetHomeAddressToCCP = contentInformationObject;
                contentInformationObject.setAvailable(this.navapi.getNavigationServiceState() == 100);
                return false;
            }
            case 1: {
                this.registerASLNavigationAPI();
                this.cioShowHomeAddressInput = contentInformationObject;
                contentInformationObject.setAvailable(this.navapi.getNavigationServiceState() == 100);
                return false;
            }
            case 2: {
                this.registerASLNavigationAPI();
                return false;
            }
        }
        return false;
    }

    public void updateShowNavView(boolean bl) {
        ShowNavViewModelApiCallback showNavViewModelApiCallback = (ShowNavViewModelApiCallback)NavAdapter.getSystemServices().createModelApiClient(class$generated$de$vw$mib$appadapter$nav$ShowNavViewModelApiCallback == null ? (class$generated$de$vw$mib$appadapter$nav$ShowNavViewModelApiCallback = NavCioExecutor.class$("generated.de.vw.mib.appadapter.nav.ShowNavViewModelApiCallback")) : class$generated$de$vw$mib$appadapter$nav$ShowNavViewModelApiCallback);
        if (bl) {
            showNavViewModelApiCallback._update_getNavView("0");
        } else {
            showNavViewModelApiCallback._update_getNavView("1");
        }
    }

    private void updateModelCurrentView(String string) {
        ShowNavViewModelApiCallback showNavViewModelApiCallback = (ShowNavViewModelApiCallback)NavAdapter.getSystemServices().createModelApiClient(class$generated$de$vw$mib$appadapter$nav$ShowNavViewModelApiCallback == null ? (class$generated$de$vw$mib$appadapter$nav$ShowNavViewModelApiCallback = NavCioExecutor.class$("generated.de.vw.mib.appadapter.nav.ShowNavViewModelApiCallback")) : class$generated$de$vw$mib$appadapter$nav$ShowNavViewModelApiCallback);
        if (string != null && string.equalsIgnoreCase("Traffic")) {
            showNavViewModelApiCallback._update_getNavView("1");
        } else if (string != null && string.equalsIgnoreCase("Navigation")) {
            showNavViewModelApiCallback._update_getNavView("2");
        } else {
            showNavViewModelApiCallback._update_getNavView("0");
        }
        this.switchToNavigationApp();
    }

    private void updateModelCurrentView(CioActionParameters cioActionParameters) {
        String string = cioActionParameters.getString("EntryMode");
        ShowNavViewModelApiCallback showNavViewModelApiCallback = (ShowNavViewModelApiCallback)NavAdapter.getSystemServices().createModelApiClient(class$generated$de$vw$mib$appadapter$nav$ShowNavViewModelApiCallback == null ? (class$generated$de$vw$mib$appadapter$nav$ShowNavViewModelApiCallback = NavCioExecutor.class$("generated.de.vw.mib.appadapter.nav.ShowNavViewModelApiCallback")) : class$generated$de$vw$mib$appadapter$nav$ShowNavViewModelApiCallback);
        if (string != null && string.equalsIgnoreCase("Traffic")) {
            showNavViewModelApiCallback._update_getNavView("1");
        } else if (string != null && string.equalsIgnoreCase("Navigation")) {
            showNavViewModelApiCallback._update_getNavView("2");
        } else if (string != null && string.equalsIgnoreCase("Compass")) {
            showNavViewModelApiCallback._update_getNavView("2");
            SET_CURRENT_CONTENT_SS_VALUE_PARAM = 1;
            this.setCurrentSplitscreenContent();
        } else if (string != null && string.equalsIgnoreCase("Position")) {
            showNavViewModelApiCallback._update_getNavView("2");
            SET_CURRENT_CONTENT_SS_VALUE_PARAM = 2;
            this.setCurrentSplitscreenContent();
        } else if (string != null && string.equalsIgnoreCase("WPM")) {
            showNavViewModelApiCallback._update_getNavView("2");
        } else if (string != null && string.equalsIgnoreCase("Maneuver")) {
            showNavViewModelApiCallback._update_getNavView("2");
            SET_CURRENT_CONTENT_SS_VALUE_PARAM = 5;
            this.setCurrentSplitscreenContent();
        } else if (string != null && string.equalsIgnoreCase("PNAV")) {
            showNavViewModelApiCallback._update_getNavView("2");
            SET_CURRENT_CONTENT_SS_VALUE_PARAM = 5;
            this.setCurrentSplitscreenContent();
        } else {
            showNavViewModelApiCallback._update_getNavView("0");
        }
        this.switchToNavigationApp();
    }

    private void switchToNavigationApp() {
        CioIntent cioIntent = NavAdapter.getSystemServices().getCioDictionary().getCioIntent("ShowContent", "HMI_NAVI");
        NavAdapter.getSystemServices().getCioDispatcher().dispatch(cioIntent);
    }

    private void setCurrentSplitscreenContent() {
        if (this.naviSplitscreenService != null) {
            this.naviSplitscreenService.setSplitScreenContent(SET_CURRENT_CONTENT_SS_VALUE_PARAM);
        } else {
            try {
                if (this.naviSplitscreenListenerAdapter != null) {
                    this.naviSplitscreenService = this.navapi.getNavigationSplitscreenService(this.naviSplitscreenListenerAdapter);
                } else {
                    this.naviSplitscreenListenerAdapter = new NavigationSplitscreenListenerAdapter();
                    this.naviSplitscreenService = this.navapi.getNavigationSplitscreenService(this.naviSplitscreenListenerAdapter);
                }
            }
            catch (NavigationServiceException navigationServiceException) {
                // empty catch block
            }
            if (this.naviSplitscreenService != null) {
                this.naviSplitscreenService.setSplitScreenContent(SET_CURRENT_CONTENT_SS_VALUE_PARAM);
            }
        }
    }

    @Override
    public void updateHomeAddressSetToCcpDone(boolean bl) {
        if (bl) {
            this.dispatchReturnCIO("Callback_Success");
        } else {
            this.dispatchReturnCIO("Callback_Failure");
        }
    }

    public void returnFromInput(int n) {
        switch (n) {
            case 0: {
                this.dispatchReturnCIO("Callback_Success");
                break;
            }
            case 1: {
                this.dispatchReturnCIO("Callback_Failure");
                break;
            }
            case 2: {
                this.dispatchReturnCIO("Callback_Cancel");
                break;
            }
        }
    }

    private void dispatchReturnCIO(String string) {
        NavAdapter.getSystemServices().getCioDispatcher().dispatch(this.returnParams.getCioIntent(string));
    }

    private void registerASLNavigationAPI() {
        if (this.navapi == null) {
            this.navapi = ASLNavigationFactory.getNavigationApi();
            this.navapi.registerNavServiceStateListener(this);
        }
    }

    @Override
    public void navServiceStateChanged() {
        if (this.cioSetHomeAddressToCCP != null) {
            this.cioSetHomeAddressToCCP.setAvailable(this.navapi.getNavigationServiceState() == 100);
        }
        if (this.cioShowHomeAddressInput != null) {
            this.cioShowHomeAddressInput.setAvailable(this.navapi.getNavigationServiceState() == 100);
        }
    }

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError().initCause(classNotFoundException);
        }
    }

    static {
        SET_CURRENT_CONTENT_SS_VALUE_PARAM = 1;
    }
}

