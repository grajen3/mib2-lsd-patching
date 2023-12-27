/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.kombisync;

import org.dsi.ifc.base.DSIBase;
import org.dsi.ifc.kombisync.MMIDisplayRequest;
import org.dsi.ifc.kombisync.MMIDisplayStatus;
import org.dsi.ifc.kombisync.MMIPopupRequest;
import org.dsi.ifc.kombisync.MenuState;

public interface DSIKombiSync
extends DSIBase {
    public static final String VERSION;
    public static final int ATTR_KOMBICOMMUNICATIONSTATE;
    public static final int ATTR_KOMBIMESSAGESTATEDISPLAYSTATUS;
    public static final int ATTR_KOMBIMESSAGESTATEDISPLAYREQUEST;
    public static final int ATTR_KOMBIMESSAGESTATEPOPUPSTATUS;
    public static final int FOCUS_INIT;
    public static final int FOCUS_KOMBI;
    public static final int FOCUS_MMI;
    public static final int FOCUS_MMI_ALL;
    public static final int FOCUS_HMI_ALL_BLOCKED_BUT_VIEW;
    public static final int FOCUS_KOMBI_ALL_QUIT;
    public static final int FOCUS_KOMBI_ALL_QUIT_AND_EXECUTE;
    public static final int SCREENFORMAT_INIT;
    public static final int SCREENFORMAT_SMALL;
    public static final int SCREENFORMAT_LARGE;
    public static final int SCREENFORMAT_FULLSCREEN;
    public static final int MENUSTATE_INIT;
    public static final int MENUSTATE_TEMP_NOT_AVAILABLE;
    public static final int MENUSTATE_AVAILABLE;
    public static final int MENUSTATE_NOT_EXISTING;
    public static final int MMIPOPUPSTATE_REMOVED;
    public static final int MMIPOPUPSTATE_VISIBLE;
    public static final int MMIPOPUPSTATE_HIDDEN;
    public static final int MENUCONTEXT_LEFTSIDEMENU;
    public static final int MENUCONTEXT_RIGHTSIDEMENU;
    public static final int MENUCONTEXT_PARTIALPOPUP;
    public static final int MENUCONTEXT_SECONDSTATUSLINE;
    public static final int MESSAGESTATE_UNKNOWN;
    public static final int MESSAGESTATE_OK;
    public static final int MESSAGESTATE_TIMEOUT;
    public static final int ANIMATIONSPEED_1_00;
    public static final int ANIMATIONSPEED_1_25;
    public static final int ANIMATIONSPEED_1_50;
    public static final int ANIMATIONSPEED_1_75;
    public static final int ANIMATIONSPEED_2_00;
    public static final int ANIMATIONSPEED_2_25;
    public static final int ANIMATIONSPEED_2_50;
    public static final int ANIMATIONSPEED_2_75;
    public static final int ANIMATIONSPEED_3_00;
    public static final int ANIMATIONSPEED_3_25;
    public static final int ANIMATIONSPEED_3_50;
    public static final int ANIMATIONSPEED_3_75;
    public static final int ANIMATIONSPEED_4_00;
    public static final int ANIMATIONSPEED_5_00;
    public static final int ANIMATIONSPEED_6_00;
    public static final int ANIMATIONSPEED_7_00;
    public static final int RT_SETMMIDISPLAYSTATUS;
    public static final int RT_SETMMIDISPLAYREQUEST;
    public static final int RT_SETMENUSTATE;
    public static final int RT_SETMMIPOPUPREQUEST;
    public static final int RT_SETHMIISREADY;
    public static final int RP_RESPONSEKOMBIDISPLAYREQUEST;
    public static final int RP_RESPONSEKOMBIDISPLAYSTATUS;
    public static final int RP_RESPONSEKOMBIPOPUPSTATUS;

    default public void setMMIDisplayStatus(MMIDisplayStatus mMIDisplayStatus) {
    }

    default public void setMMIDisplayRequest(MMIDisplayRequest mMIDisplayRequest) {
    }

    default public void setMenuState(MenuState menuState) {
    }

    default public void setMMIPopupRequest(MMIPopupRequest mMIPopupRequest) {
    }

    default public void setHMIIsReady(boolean bl) {
    }
}

