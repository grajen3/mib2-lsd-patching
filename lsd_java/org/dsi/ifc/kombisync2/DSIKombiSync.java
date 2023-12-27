/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.kombisync2;

import org.dsi.ifc.base.DSIBase;
import org.dsi.ifc.kombisync2.DisplayIdentification;
import org.dsi.ifc.kombisync2.DisplayRequestResponse;
import org.dsi.ifc.kombisync2.DisplayStatus;
import org.dsi.ifc.kombisync2.MenuState;
import org.dsi.ifc.kombisync2.PopupActionRequestResponse;
import org.dsi.ifc.kombisync2.PopupRegisterRequestResponse;
import org.dsi.ifc.kombisync2.PopupStatus;

public interface DSIKombiSync
extends DSIBase {
    public static final String VERSION;
    public static final int ATTR_KOMBICOMMUNICATIONSTATE;
    public static final int ATTR_KOMBIMESSAGESTATEDISPLAYIDENTIFICATION;
    public static final int ATTR_KOMBIMESSAGESTATEDISPLAYREQUESTRESPONSE;
    public static final int ATTR_KOMBIMESSAGESTATEDISPLAYSTATUS;
    public static final int ATTR_KOMBIMESSAGESTATEPOPUPACTIONREQUEST;
    public static final int ATTR_KOMBIMESSAGESTATEPOPUPREGISTERRESPONSE;
    public static final int ATTR_KOMBIMESSAGESTATEPOPUPSTATUS;
    public static final int DISPLAYSTATUS_ALL_INVALID;
    public static final int DISPLAYSTATUS_USER_STAGE;
    public static final int DISPLAYSTATUS_LVDS_DM_ACTIVE;
    public static final int DISPLAYSTATUS_LVDS_HMI_ACTIVE;
    public static final int DISPLAYSTATUS_LVDS_PROTOCOL_DM_OK;
    public static final int DISPLAYSTATUS_LVDS_PROTOCOL_HMI_OK;
    public static final int DISPLAYSTATUS_SYNC_PROTOCOL_OK;
    public static final int DISPLAYSTATUS_SLOW_DOWN;
    public static final int DISPLAYSTATUS_LEFT_FLAP;
    public static final int DISPLAYSTATUS_RIGHT_FLAP;
    public static final int DISPLAYSTATUS_KDK_VISIBLE;
    public static final int DISPLAYSTATUS_NAV_BARGRAPH;
    public static final int DISPLAYSTATUS_2ND_STATUSLINE;
    public static final int DISPLAYSTATUS_REDUCED_SCREEN;
    public static final int DISPLAYSTATUS_EARLY_RVC;
    public static final int POPUPSTATUS_RVC_POSSIBLE;
    public static final int POPUPSTATUS_SDS_POSSIBLE;
    public static final int POPUPSTATUS_WITHOUT_FOLDER;
    public static final int POPUPSTATUS_BACKGROUND_QUITT_ALLOWED;
    public static final int REQRESPINFORMATION_LASTMODE;
    public static final int REQRESPINFORMATION_REQUEST;
    public static final int REQRESPINFORMATION_RESPONSE;
    public static final int REQRESPINFORMATION_RETRY_REQUEST;
    public static final int POPUPSTATE_RESET;
    public static final int POPUPSTATE_SET;
    public static final int POPUPSTATE_QUIT;
    public static final int POPUPSTATE_IDLE;
    public static final int POPUPSTATE_RESETRETR;
    public static final int POPUPSTATE_SETRETR;
    public static final int POPUPSTATE_QUITRETR;
    public static final int POPUPID_NO_POPUP;
    public static final int POPUPCONTEXT_NO_CONTEXT;
    public static final int POPUPCONTEXT_NAV;
    public static final int POPUPCONTEXT_MEDIA;
    public static final int POPUPCONTEXT_PHONE;
    public static final int POPUPCONTEXT_NOT_USED;
    public static final int POPUPCONTEXT_SETTINGS;
    public static final int POPUPCONTEXT_APPS;
    public static final int POPUPCONTEXT_CONNECT;
    public static final int POPUPCONTEXT_CAR;
    public static final int POPUPTYPE_INIT;
    public static final int POPUPTYPE_FULL_SCREEN;
    public static final int POPUPTYPE_PARTIAL_SCREEN;
    public static final int POPUPTYPE_RVC;
    public static final int POPUPTYPE_DRIVE_SELECT;
    public static final int POPUPTYPE_ACTIVE_CALL;
    public static final int POPUPTYPE_POWERBL;
    public static final int POPUPTYPE_NOT_USED;
    public static final int POPUPTYPE_FLAP_LEFT;
    public static final int POPUPTYPE_FLAP_RIGHT;
    public static final int POPUPFLAPLEFT_NO_FLAP;
    public static final int POPUPFLAPLEFT_BC;
    public static final int POPUPFLAPLEFT_CAR;
    public static final int POPUPFLAPLEFT_OPS;
    public static final int POPUPFLAPLEFT_D_LIST;
    public static final int POPUPFLAPLEFT_PICTURE;
    public static final int POPUPFLAPRIGHT_NO_FLAP;
    public static final int POPUPFLAPRIGHT_KDK;
    public static final int KBIINTERNALSTATE_INIT;
    public static final int KBIINTERNALSTATE_STARTUP_BLACK;
    public static final int KBIINTERNALSTATE_STARTUP_LOGO;
    public static final int KBIINTERNALSTATE_IN_SYNC;
    public static final int KBIINTERNALSTATE_SINGLE;
    public static final int KBIINTERNALSTATE_SHUTDOWN;
    public static final int KBIINTERNALSTATE_OFF;
    public static final int KBIINTERNALSTATE_SYNC_LOST;
    public static final int KBIINTERNALSTATE_SWDL;
    public static final int ZRINTERNALSTATE_INIT;
    public static final int ZRINTERNALSTATE_STARTUP_BLACK;
    public static final int ZRINTERNALSTATE_NORMAL_MODE;
    public static final int ZRINTERNALSTATE_MMI_STANDALONE;
    public static final int ZRINTERNALSTATE_SHUTDOWN;
    public static final int ZRINTERNALSTATE_OFF;
    public static final int ZRINTERNALSTATE_RECOVERY;
    public static final int ZRINTERNALSTATE_SWDL;
    public static final int ZRINTERNALSTATE_OVERRUN;
    public static final int STYLE_INIT;
    public static final int STYLE_1;
    public static final int STYLE_2;
    public static final int STYLE_3;
    public static final int STYLE_4;
    public static final int STYLE_5;
    public static final int FOCUS_INIT;
    public static final int FOCUS_KOMBI;
    public static final int FOCUS_MMI;
    public static final int SCREENFORMAT_INIT;
    public static final int SCREENFORMAT_SMALL;
    public static final int SCREENFORMAT_LARGE;
    public static final int SCREENFORMAT_SMALL_USER;
    public static final int SCREENFORMAT_LARGE_USER;
    public static final int SCREENFORMAT_SMALL_LOCK;
    public static final int SCREENFORMAT_LARGE_LOCK;
    public static final int MENUSTATE_INIT;
    public static final int MENUSTATE_TEMP_NOT_AVAILABLE;
    public static final int MENUSTATE_AVAILABLE;
    public static final int MENUSTATE_NOT_EXISTING;
    public static final int MMIPOPUPSTATE_REMOVED;
    public static final int MMIPOPUPSTATE_VISIBLE;
    public static final int MMIPOPUPSTATE_HIDDEN;
    public static final int MENUCONTEXT_RIGHTSIDEMENU;
    public static final int MENUCONTEXT_LEFTSIDEMENU;
    public static final int MENUCONTEXT_SECONDSTATUSLINE;
    public static final int MENUCONTEXT_SDS_TAB;
    public static final int MENUCONTEXTSTATE_INIT;
    public static final int MENUCONTEXTSTATE_CLOSED;
    public static final int MENUCONTEXTSTATE_OPENED;
    public static final int MESSAGESTATE_UNKNOWN;
    public static final int MESSAGESTATE_OK;
    public static final int MESSAGESTATE_TIMEOUT;
    public static final int RT_SETMMIDISPLAYIDENTIFICATION;
    public static final int RT_SETMMIDISPLAYREQUESTRESPONSE;
    public static final int RT_SETMMIDISPLAYSTATUS;
    public static final int RT_SETMMIPOPUPACTIONRESPONSE;
    public static final int RT_SETMMIPOPUPREGISTERREQUEST;
    public static final int RT_SETMMIPOPUPSTATUS;
    public static final int RT_SETMENUSTATE;
    public static final int RT_SETHMIISREADY;
    public static final int RP_RESPONSEKOMBIDISPLAYIDENTIFICATION;
    public static final int RP_RESPONSEKOMBIDISPLAYREQUESTRESPONSE;
    public static final int RP_RESPONSEKOMBIDISPLAYSTATUS;
    public static final int RP_RESPONSEKOMBIPOPUPACTIONREQUEST;
    public static final int RP_RESPONSEKOMBIPOPUPREGISTERRESPONSE;
    public static final int RP_RESPONSEKOMBIPOPUPSTATUS;

    default public void setMMIDisplayRequestResponse(DisplayRequestResponse displayRequestResponse) {
    }

    default public void setMMIDisplayStatus(DisplayStatus displayStatus) {
    }

    default public void setMenuState(MenuState menuState) {
    }

    default public void setMMIPopupRegisterRequest(PopupRegisterRequestResponse popupRegisterRequestResponse) {
    }

    default public void setMMIPopupActionResponse(PopupActionRequestResponse popupActionRequestResponse) {
    }

    default public void setMMIPopupStatus(PopupStatus popupStatus) {
    }

    default public void setMMIDisplayIdentification(DisplayIdentification displayIdentification) {
    }

    default public void setHMIIsReady(boolean bl) {
    }
}

