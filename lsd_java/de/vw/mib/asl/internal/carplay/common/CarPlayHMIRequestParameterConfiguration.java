/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.carplay.common;

import org.dsi.ifc.carplay.AppStateRequest;
import org.dsi.ifc.carplay.ResourceRequest;

public class CarPlayHMIRequestParameterConfiguration {
    public final int RESOURCE_REQUEST_DEFAULT;
    public final int RESOURCE_REQUEST_HMI_MAINSCREEN;
    public final int RESOURCE_REQUEST_HMI_MAINAUDIO;
    public final int RESOURCE_REQUEST_HMI_MAINSCREEN_AND_MAINAUDIO;
    public final int RESOURCE_REQUEST_BORROW_HMI_MAINAUDIO;
    public final int RESOURCE_REQUEST_UNBORROW_HMI_MAINAUDIO;
    public final int RESOURCE_REQUEST_UNTAKE_HMI_MAINAUDIO;
    public final int RESOURCE_REQUEST_BORROW_HMI_MAINSCREEN;
    public final int RESOURCE_REQUEST_UNBORROW_HMI_MAINSCREEN;
    public final int RESOURCE_REQUEST_CARPLAY_MAINSCREEN;
    public final int RESOURCE_REQUEST_CARPLAY_MAINAUDIO;
    public final int APP_REQUEST_DEFAULT;
    public final int APP_REQUEST_HMI_PHONECALL;
    public final int APP_RELEASE_HMI_PHONECALL;
    public final int APP_REQUEST_HMI_NAV;
    public final int APP_RELEASE_HMI_NAV;
    public final int APP_REQUEST_HMI_SDS_SESSION;
    public final int APP_REQUEST_HMI_NO_SDS_SESSION;
    public final int APP_REQUEST_HMI_SDS_UNKNOWN;
    ResourceRequest[] ressourcerequest_default = null;
    AppStateRequest[] appstaterequest_default = null;
    ResourceRequest[] ressourcerequest_hmi_main_screen = new ResourceRequest[]{new ResourceRequest(2, 1, 1, 1, 1, 1)};
    ResourceRequest[] ressourcerequest_hmi_main_audio = new ResourceRequest[]{new ResourceRequest(1, 1, 1, 1, 1, 1)};
    ResourceRequest[] ressourcerequest_hmi_borrow_main_audio = new ResourceRequest[]{new ResourceRequest(1, 3, 1, 1, 1, 1)};
    ResourceRequest[] ressourcerequest_hmi_unborrow_main_audio = new ResourceRequest[]{new ResourceRequest(1, 4, 1, 0, 0, 0)};
    ResourceRequest[] ressourcerequest_hmi_untake_main_audio = new ResourceRequest[]{new ResourceRequest(1, 2, 1, 0, 0, 0)};
    ResourceRequest[] ressourcerequest_hmi_main_screen_and_audio = new ResourceRequest[]{new ResourceRequest(2, 1, 1, 1, 1, 1), new ResourceRequest(1, 1, 1, 1, 1, 1)};
    ResourceRequest[] ressourcerequest_hmi_borrow_main_screen = new ResourceRequest[]{new ResourceRequest(2, 3, 1, 1, 1, 1)};
    ResourceRequest[] ressourcerequest_hmi_unborrow_main_screen = new ResourceRequest[]{new ResourceRequest(2, 4, 1, 0, 0, 0)};
    ResourceRequest[] ressourcerequest_carplay_main_screen = new ResourceRequest[]{new ResourceRequest(2, 2, 1, 2, 1, 1)};
    ResourceRequest[] ressourcerequest_carplay_main_audio = new ResourceRequest[]{new ResourceRequest(1, 1, 1, 2, 1, 1)};
    AppStateRequest[] appstaterequest_phonecall = new AppStateRequest[]{new AppStateRequest(1, true, 2)};
    AppStateRequest[] appstaterelease_phonecall = new AppStateRequest[]{new AppStateRequest(1, false, 0)};
    AppStateRequest[] appstaterequest_nav = new AppStateRequest[]{new AppStateRequest(2, true, 0)};
    AppStateRequest[] appstaterelease_nav = new AppStateRequest[]{new AppStateRequest(2, false, 0)};
    AppStateRequest[] appstaterequest_sds = new AppStateRequest[]{new AppStateRequest(3, true, 3)};
    AppStateRequest[] appstaterequest_no_sds = new AppStateRequest[]{new AppStateRequest(3, false, 0)};
    AppStateRequest[] appstaterequest_unknown = new AppStateRequest[]{new AppStateRequest(0, true, 0)};

    public CarPlayHMIRequestParameterConfiguration() {
        this.RESOURCE_REQUEST_DEFAULT = 0;
        this.RESOURCE_REQUEST_HMI_MAINSCREEN = 1;
        this.RESOURCE_REQUEST_HMI_MAINAUDIO = 2;
        this.RESOURCE_REQUEST_HMI_MAINSCREEN_AND_MAINAUDIO = 3;
        this.RESOURCE_REQUEST_BORROW_HMI_MAINAUDIO = 4;
        this.RESOURCE_REQUEST_UNBORROW_HMI_MAINAUDIO = 5;
        this.RESOURCE_REQUEST_UNTAKE_HMI_MAINAUDIO = 6;
        this.RESOURCE_REQUEST_BORROW_HMI_MAINSCREEN = 9;
        this.RESOURCE_REQUEST_UNBORROW_HMI_MAINSCREEN = 10;
        this.RESOURCE_REQUEST_CARPLAY_MAINSCREEN = 7;
        this.RESOURCE_REQUEST_CARPLAY_MAINAUDIO = 8;
        this.APP_REQUEST_DEFAULT = 0;
        this.APP_REQUEST_HMI_PHONECALL = 1;
        this.APP_RELEASE_HMI_PHONECALL = 7;
        this.APP_REQUEST_HMI_NAV = 2;
        this.APP_RELEASE_HMI_NAV = 6;
        this.APP_REQUEST_HMI_SDS_SESSION = 3;
        this.APP_REQUEST_HMI_NO_SDS_SESSION = 4;
        this.APP_REQUEST_HMI_SDS_UNKNOWN = 5;
    }

    public ResourceRequest[] getRessourceRequest(int n) {
        ResourceRequest[] resourceRequestArray;
        switch (n) {
            case 2: {
                resourceRequestArray = this.ressourcerequest_hmi_main_audio;
                break;
            }
            case 1: {
                resourceRequestArray = this.ressourcerequest_hmi_main_screen;
                break;
            }
            case 3: {
                resourceRequestArray = this.ressourcerequest_hmi_main_screen_and_audio;
                break;
            }
            case 4: {
                resourceRequestArray = this.ressourcerequest_hmi_borrow_main_audio;
                break;
            }
            case 5: {
                resourceRequestArray = this.ressourcerequest_hmi_unborrow_main_audio;
                break;
            }
            case 6: {
                resourceRequestArray = this.ressourcerequest_hmi_untake_main_audio;
                break;
            }
            case 8: {
                resourceRequestArray = this.ressourcerequest_carplay_main_audio;
                break;
            }
            case 7: {
                resourceRequestArray = this.ressourcerequest_carplay_main_screen;
                break;
            }
            case 9: {
                resourceRequestArray = this.ressourcerequest_hmi_borrow_main_screen;
                break;
            }
            case 10: {
                resourceRequestArray = this.ressourcerequest_hmi_unborrow_main_screen;
                break;
            }
            default: {
                resourceRequestArray = this.ressourcerequest_default;
            }
        }
        return resourceRequestArray;
    }

    public AppStateRequest[] getAppStateRequest(int n) {
        AppStateRequest[] appStateRequestArray;
        switch (n) {
            case 1: {
                appStateRequestArray = this.appstaterequest_phonecall;
                break;
            }
            case 7: {
                appStateRequestArray = this.appstaterelease_phonecall;
                break;
            }
            case 2: {
                appStateRequestArray = this.appstaterequest_nav;
                break;
            }
            case 6: {
                appStateRequestArray = this.appstaterelease_nav;
                break;
            }
            case 3: {
                appStateRequestArray = this.appstaterequest_sds;
                break;
            }
            case 4: {
                appStateRequestArray = this.appstaterequest_no_sds;
                break;
            }
            case 5: {
                appStateRequestArray = this.appstaterequest_sds;
                break;
            }
            default: {
                appStateRequestArray = this.appstaterequest_default;
            }
        }
        return appStateRequestArray;
    }

    public AppStateRequest[] getCompleteAppStateRequest(boolean bl, boolean bl2, boolean bl3) {
        AppStateRequest[] appStateRequestArray = this.getAppStateRequest(7);
        AppStateRequest[] appStateRequestArray2 = this.getAppStateRequest(6);
        AppStateRequest[] appStateRequestArray3 = this.getAppStateRequest(4);
        if (bl) {
            appStateRequestArray = this.getAppStateRequest(1);
        }
        if (bl2) {
            appStateRequestArray2 = this.getAppStateRequest(2);
        }
        if (bl3) {
            appStateRequestArray3 = this.getAppStateRequest(3);
        }
        AppStateRequest[] appStateRequestArray4 = new AppStateRequest[]{appStateRequestArray[0], appStateRequestArray2[0], appStateRequestArray3[0]};
        return appStateRequestArray4;
    }
}

