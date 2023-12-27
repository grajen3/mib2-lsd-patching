/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.map;

import org.dsi.ifc.base.DSIBase;
import org.dsi.ifc.map.Rect;

public interface DSIMapViewerGoogleCtrl
extends DSIBase {
    public static final String VERSION;
    public static final int ATTR_AVAILABLELAYERS;
    public static final int ATTR_VISIBLELAYERS;
    public static final int ATTR_AVAILABLELANGUAGES;
    public static final int ATTR_CURRENTLANGUAGE;
    public static final int ATTR_GOOGLEDATASTATUS;
    public static final int ATTR_COPYRIGHTPOSITION;
    public static final int CONNECTIONSTATE_NONE;
    public static final int CONNECTIONSTATE_CONNECTING;
    public static final int CONNECTIONSTATE_GPRS;
    public static final int CONNECTIONSTATE_UMTS;
    public static final int CONNECTIONSTATE_LAN;
    public static final int CONNECTIONSTATE_FORBIDDENROAMING;
    public static final int CONNECTIONSTATE_ROAMING;
    public static final int CONNECTIONSTATE_WIFI;
    public static final int CONNECTIONSTATE_INVALID_CONNECTIONSTATE;
    public static final int CONNECTIONSTATE_ALLOWCONNECTIONWHENPENDING;
    public static final int CONNECTIONSTATE_FORBIDCONNECTIONWHENPENDING;
    public static final int LAYERTYPE_USER_LAYER;
    public static final int LAYERTYPE_SYSTEM;
    public static final int DATACONNECTIONSTATE_DATA_CONNECTION_NEEDED_NO_DATA;
    public static final int DATACONNECTIONSTATE_DATA_CONNECTION_NEEDED_RENDERER_LOGIN;
    public static final int DATACONNECTIONSTATE_DATA_CONNECTION_NEEDED_RENDERER_NOT_RECOMMENDED;
    public static final int DATACONNECTIONSTATE_DATA_CONNECTION_NEEDED_RENDERER_RECOMMENDED;
    public static final int DATACONNECTIONSTATE_DATA_CONNECTION_NEEDED_DB_CORRUPTED;
    public static final int LABELPOSITION_UNDEFINED;
    public static final int LABELPOSITION_TOPLEFT;
    public static final int LABELPOSITION_TOP;
    public static final int LABELPOSITION_TOPRIGHT;
    public static final int LABELPOSITION_LEFT;
    public static final int LABELPOSITION_CENTER;
    public static final int LABELPOSITION_RIGHT;
    public static final int LABELPOSITION_BOTTOMLEFT;
    public static final int LABELPOSITION_BOTTOM;
    public static final int LABELPOSITION_BOTTOMRIGHT;
    public static final int LABELALIGNMENT_UNDEFINED;
    public static final int LABELALIGNMENT_LEFT;
    public static final int LABELALIGNMENT_CENTER;
    public static final int LABELALIGNMENT_RIGHT;
    public static final int RT_REQUESTCLEARCACHE;
    public static final int RT_SETLANGUAGE;
    public static final int RT_SETLAYERVISIBILITY;
    public static final int RT_SETCONNECTIONINFORMATION;
    public static final int RT_LOADKML;
    public static final int RT_SETCOPYRIGHTPOSITION;

    default public void requestClearCache() {
    }

    default public void setLanguage(String string) {
    }

    default public void setLayerVisibility(int[] nArray) {
    }

    default public void setConnectionInformation(int n) {
    }

    default public void loadKml(String[] stringArray) {
    }

    default public void setCopyrightPosition(Rect rect, int n, int n2) {
    }
}

