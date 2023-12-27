/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.online.uota.common;

import de.vw.mib.asl.internal.online.common.uota.OnlineUotAPackage;

public interface UotAConstants {
    public static final int INVALID_VALUE;
    public static final int DEFAULT_VALUE;
    public static final int DEFAULT_SESSION_ID;
    public static final String STARTED;
    public static final String ENDED;
    public static final String FAILED;
    public static final String ERROR;
    public static final String STOPPED;
    public static final int CONFIG_PPOI;
    public static final int CONFIG_UOTA_PPOI;
    public static final int CONFIG_NAV_DATA;
    public static final int CONFIG_NAV_DATA_PPOI;
    public static final String FILTER_DSI_PPOI;
    public static final String FILTER_DSI_NAVDATA;
    public static final String FILTER_DSI_ALL;
    public static final int FILTER_HMI_ALL;
    public static final int FILTER_HMI_FAVOURITE;
    public static final int FILTER_HMI_PPOI;
    public static final int FILTER_HMI_NAVI;
    public static final int FILTER_HMI_MAIN;
    public static final int FILTER_HMI_SUB;
    public static final int FILTER_HMI_DOWNLOAD;
    public static final int FILTER_HMI_UNKNOWN;
    public static final int FILTER_COMPLETE;
    public static final OnlineUotAPackage[] EMPTY_PACKAGE_LIST;
    public static final int UOTA_PACKAGE_SELECTED_STATE_NOT_SELECTED;
    public static final int UOTA_PACKAGE_SELECTED_STATE_SELECTED;
    public static final int UOTA_PACKAGE_SELECTED_STATE_UPTODATE;
    public static final int UOTA_PACKAGE_SELECTED_STATE_ERROR;
    public static final int UOTA_DOWNLOAD_NOT_ACTIVE;
    public static final int UOTA_DOWNLOAD_ACTIVE;
    public static final int UOTA_PACKAGE_STATE_INACTIVE;
    public static final int UOTA_PACKAGE_STATE_ACTIVE;
    public static final int PACKET_NAME;
    public static final int PACKET_COUNT;
    public static final int PACKET_CURRENT;
    public static final int PACKET_SELECTED;
    public static final int SUB_PACKET_LIST;
    public static final int DOWNLOAD_PREPARE;
    public static final int DOWNLOAD_TOGGLE;
    public static final int DOWNLOAD_START;
    public static final int DOWNLOAD_CANCEL;
    public static final int DOWNLOAD_STATE;
    public static final int DOWNLOAD_PROGRESS;
    public static final int INSTALL_START;
    public static final int INSTALL_INITIATE;
    public static final int INSTALL_SUCCESS;
    public static final int INSTALL_CANCEL;
    public static final int INSTALL_ERROR;
    public static final int REFRESH_LIST;
    public static final int DOWNLOAD_RESTART;
    public static final int PACKET_SELECTED_ALL;
    public static final int PACKET_SELECTED_NON;
    public static final int PACKET_SELECTED_MAIN_PACKET;
    public static final int PACKET_SELECTED_SUB_PACKET;
    public static final int PACKET_SELECTED_FOR_DESTINATIONS;
    public static final int EV_UOTA_GUIDANCE_STARTED;
    public static final int EV_UOTA_INSTALLATION_STATUS;
    public static final int UOTA_INSTALLATION_STATUS_P0_INT;

    static {
        EMPTY_PACKAGE_LIST = new OnlineUotAPackage[0];
    }
}

