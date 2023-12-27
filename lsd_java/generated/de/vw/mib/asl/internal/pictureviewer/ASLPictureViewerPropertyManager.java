/*
 * Decompiled with CFR 0.152.
 */
package generated.de.vw.mib.asl.internal.pictureviewer;

import org.dsi.ifc.global.ResourceLocator;

public interface ASLPictureViewerPropertyManager {
    public static final int AVAILABLE_BROWSING_SOURCES__AVAILABLE_BROWSING_SOURCES__ID;
    public static final int AVAILABLE_BROWSING_SOURCES__AVAILABLE_BROWSING_SOURCES__ID__DEFAULT_VALUE;
    public static final int AVAILABLE_BROWSING_SOURCES__AVAILABLE_BROWSING_SOURCES__ID__C0_PICTURE_SOURCE_NO_SOURCE;
    public static final int AVAILABLE_BROWSING_SOURCES__AVAILABLE_BROWSING_SOURCES__ID__C1_PICTURE_SOURCE_CD;
    public static final int AVAILABLE_BROWSING_SOURCES__AVAILABLE_BROWSING_SOURCES__ID__C2_PICTURE_SOURCE_SD_CARD;
    public static final int AVAILABLE_BROWSING_SOURCES__AVAILABLE_BROWSING_SOURCES__ID__C3_PICTURE_SOURCE_USB;
    public static final int AVAILABLE_BROWSING_SOURCES__AVAILABLE_BROWSING_SOURCES__ID__C4_PICTURE_SOURCE_IPOD;
    public static final int AVAILABLE_BROWSING_SOURCES__AVAILABLE_BROWSING_SOURCES__ID__C5_PICTURE_SOURCE_BT_DEVICE;
    public static final int AVAILABLE_BROWSING_SOURCES__AVAILABLE_BROWSING_SOURCES__ID__C6_PICTURE_SOURCE_SD_CARD_2;
    public static final int AVAILABLE_BROWSING_SOURCES__AVAILABLE_BROWSING_SOURCES__ID__C7_PICTURE_SOURCE_USB_2;
    public static final int AVAILABLE_BROWSING_SOURCES__AVAILABLE_BROWSING_SOURCES__ID__C8_PICTURE_SOURCE_SD_CARD_NAV;
    public static final int AVAILABLE_BROWSING_SOURCES__AVAILABLE_BROWSING_SOURCES__ID__C9_PICTURE_SOURCE_SD_CARD_2_NAV;
    public static final int AVAILABLE_BROWSING_SOURCES__AVAILABLE_BROWSING_SOURCES__IS_ACTIVE;
    public static final boolean AVAILABLE_BROWSING_SOURCES__AVAILABLE_BROWSING_SOURCES__IS_ACTIVE__DEFAULT_VALUE;
    public static final int AVAILABLE_BROWSING_SOURCES__AVAILABLE_BROWSING_SOURCES__IS_ENABLED;
    public static final boolean AVAILABLE_BROWSING_SOURCES__AVAILABLE_BROWSING_SOURCES__IS_ENABLED__DEFAULT_VALUE;
    public static final int AVAILABLE_BROWSING_SOURCES__AVAILABLE_BROWSING_SOURCES__SOURCE_NAME;
    public static final String AVAILABLE_BROWSING_SOURCES__AVAILABLE_BROWSING_SOURCES__SOURCE_NAME__DEFAULT_VALUE;
    public static final int AVAILABLE_PICTURE_SOURCES__AVAILABLE_PICTURE_SOURCES__ID;
    public static final int AVAILABLE_PICTURE_SOURCES__AVAILABLE_PICTURE_SOURCES__ID__DEFAULT_VALUE;
    public static final int AVAILABLE_PICTURE_SOURCES__AVAILABLE_PICTURE_SOURCES__ID__C0_PICTURE_SOURCE_NO_SOURCE;
    public static final int AVAILABLE_PICTURE_SOURCES__AVAILABLE_PICTURE_SOURCES__ID__C1_PICTURE_SOURCE_CD;
    public static final int AVAILABLE_PICTURE_SOURCES__AVAILABLE_PICTURE_SOURCES__ID__C2_PICTURE_SOURCE_SD_CARD;
    public static final int AVAILABLE_PICTURE_SOURCES__AVAILABLE_PICTURE_SOURCES__ID__C3_PICTURE_SOURCE_USB;
    public static final int AVAILABLE_PICTURE_SOURCES__AVAILABLE_PICTURE_SOURCES__ID__C4_PICTURE_SOURCE_IPOD;
    public static final int AVAILABLE_PICTURE_SOURCES__AVAILABLE_PICTURE_SOURCES__ID__C5_PICTURE_SOURCE_BT_DEVICE;
    public static final int AVAILABLE_PICTURE_SOURCES__AVAILABLE_PICTURE_SOURCES__ID__C6_PICTURE_SOURCE_SD_CARD_2;
    public static final int AVAILABLE_PICTURE_SOURCES__AVAILABLE_PICTURE_SOURCES__ID__C7_PICTURE_SOURCE_USB_2;
    public static final int AVAILABLE_PICTURE_SOURCES__AVAILABLE_PICTURE_SOURCES__ID__C8_PICTURE_SOURCE_SD_CARD_NAV;
    public static final int AVAILABLE_PICTURE_SOURCES__AVAILABLE_PICTURE_SOURCES__ID__C9_PICTURE_SOURCE_SD_CARD_2_NAV;
    public static final int AVAILABLE_PICTURE_SOURCES__AVAILABLE_PICTURE_SOURCES__IS_ACTIVE;
    public static final boolean AVAILABLE_PICTURE_SOURCES__AVAILABLE_PICTURE_SOURCES__IS_ACTIVE__DEFAULT_VALUE;
    public static final int AVAILABLE_PICTURE_SOURCES__AVAILABLE_PICTURE_SOURCES__IS_ENABLED;
    public static final boolean AVAILABLE_PICTURE_SOURCES__AVAILABLE_PICTURE_SOURCES__IS_ENABLED__DEFAULT_VALUE;
    public static final int AVAILABLE_PICTURE_SOURCES__AVAILABLE_PICTURE_SOURCES__SOURCE_NAME;
    public static final String AVAILABLE_PICTURE_SOURCES__AVAILABLE_PICTURE_SOURCES__SOURCE_NAME__DEFAULT_VALUE;
    public static final int BROWSER_INFO_LIST__BROWSER_INFO_LIST__NAME;
    public static final String BROWSER_INFO_LIST__BROWSER_INFO_LIST__NAME__DEFAULT_VALUE;
    public static final int BROWSER_INFO_LIST__BROWSER_INFO_LIST__IS_ACTIVE;
    public static final boolean BROWSER_INFO_LIST__BROWSER_INFO_LIST__IS_ACTIVE__DEFAULT_VALUE;
    public static final int BROWSER_INFO_LIST__BROWSER_INFO_LIST__TYPE;
    public static final int BROWSER_INFO_LIST__BROWSER_INFO_LIST__TYPE__DEFAULT_VALUE;
    public static final int BROWSER_INFO_LIST__BROWSER_INFO_LIST__TYPE__C0_ELEMENT_TYPE_UNKNOWN;
    public static final int BROWSER_INFO_LIST__BROWSER_INFO_LIST__TYPE__C1_ELEMENT_TYPE_FILE;
    public static final int BROWSER_INFO_LIST__BROWSER_INFO_LIST__TYPE__C2_ELEMENT_TYPE_FOLDER;
    public static final int BROWSER_INFO_LIST__BROWSER_INFO_LIST__FILE_STATE;
    public static final int BROWSER_INFO_LIST__BROWSER_INFO_LIST__FILE_STATE__DEFAULT_VALUE;
    public static final int BROWSER_INFO_LIST__BROWSER_INFO_LIST__FILE_STATE__C0_OK;
    public static final int BROWSER_INFO_LIST__BROWSER_INFO_LIST__FILE_STATE__C1_LOADING;
    public static final int BROWSER_INFO_LIST__BROWSER_INFO_LIST__FILE_STATE__C2_ERRONEOUS;
    public static final int BROWSER_INFO_LIST__BROWSER_INFO_LIST__FILE_STATE__C3_UNSUPPORTED_FORMAT;
    public static final int BROWSER_INFO_LIST__BROWSER_INFO_LIST__SHOW_FILE_ERROR_TEXT;
    public static final boolean BROWSER_INFO_LIST__BROWSER_INFO_LIST__SHOW_FILE_ERROR_TEXT__DEFAULT_VALUE;
    public static final int ACTIVE_DEFAULT_ZOOM_LEVEL;
    public static final int ACTIVE_DEFAULT_ZOOM_LEVEL__DEFAULT_VALUE;
    public static final int ACTIVE_DEFAULT_ZOOM_LEVEL__C0_ZOOM_TO_FIT;
    public static final int ACTIVE_DEFAULT_ZOOM_LEVEL__C1_ZOOM_FILL_DISPLAY;
    public static final int ACTIVE_DEFAULT_ZOOM_LEVEL__C2_ZOOM_PLUS;
    public static final int BROWSER_STATE;
    public static final int BROWSER_STATE__DEFAULT_VALUE;
    public static final int BROWSER_STATE__C0_READY;
    public static final int BROWSER_STATE__C1_LOADING;
    public static final int BROWSER_STATE__C2_NO_FILES;
    public static final int BROWSER_STATE__C3_PREPARING;
    public static final int CURRENT_BROWSING_SOURCE;
    public static final int CURRENT_BROWSING_SOURCE__DEFAULT_VALUE;
    public static final int CURRENT_BROWSING_SOURCE__C0_PICTURE_SOURCE_NO_SOURCE;
    public static final int CURRENT_BROWSING_SOURCE__C1_PICTURE_SOURCE_CD;
    public static final int CURRENT_BROWSING_SOURCE__C2_PICTURE_SOURCE_SD_CARD;
    public static final int CURRENT_BROWSING_SOURCE__C3_PICTURE_SOURCE_USB;
    public static final int CURRENT_BROWSING_SOURCE__C4_PICTURE_SOURCE_IPOD;
    public static final int CURRENT_BROWSING_SOURCE__C5_PICTURE_SOURCE_BT_DEVICE;
    public static final int CURRENT_BROWSING_SOURCE__C6_PICTURE_SOURCE_SD_CARD_2;
    public static final int CURRENT_BROWSING_SOURCE__C7_PICTURE_SOURCE_USB_2;
    public static final int CURRENT_PICTURE;
    public static final ResourceLocator CURRENT_PICTURE__DEFAULT_VALUE;
    public static final int CURRENT_PICTURE_CONTAINS_GEO_COORDINATES;
    public static final boolean CURRENT_PICTURE_CONTAINS_GEO_COORDINATES__DEFAULT_VALUE;
    public static final int CURRENT_PICTURE_SOURCE;
    public static final int CURRENT_PICTURE_SOURCE__DEFAULT_VALUE;
    public static final int CURRENT_PICTURE_SOURCE__C0_PICTURE_SOURCE_NO_SOURCE;
    public static final int CURRENT_PICTURE_SOURCE__C1_PICTURE_SOURCE_CD;
    public static final int CURRENT_PICTURE_SOURCE__C2_PICTURE_SOURCE_SD_CARD;
    public static final int CURRENT_PICTURE_SOURCE__C3_PICTURE_SOURCE_USB;
    public static final int CURRENT_PICTURE_SOURCE__C4_PICTURE_SOURCE_IPOD;
    public static final int CURRENT_PICTURE_SOURCE__C5_PICTURE_SOURCE_BT_DEVICE;
    public static final int CURRENT_PICTURE_SOURCE__C6_PICTURE_SOURCE_SD_CARD_2;
    public static final int CURRENT_PICTURE_SOURCE__C7_PICTURE_SOURCE_USB_2;
    public static final int DISPLAYED_FOLDER_LEVEL;
    public static final int DISPLAYED_FOLDER_LEVEL__DEFAULT_VALUE;
    public static final int DISPLAYED_FOLDER_NAME;
    public static final String DISPLAYED_FOLDER_NAME__DEFAULT_VALUE;
    public static final int INDEX_OF_ACTIVE_BROWSER_INFO_LIST_ITEM;
    public static final int INDEX_OF_ACTIVE_BROWSER_INFO_LIST_ITEM__DEFAULT_VALUE;
    public static final int INDEX_OF_PARENT_ELEMENT;
    public static final int INDEX_OF_PARENT_ELEMENT__DEFAULT_VALUE;
    public static final int OPEN_BROWSER_AFTER_SOURCE_CHANGE;
    public static final boolean OPEN_BROWSER_AFTER_SOURCE_CHANGE__DEFAULT_VALUE;
    public static final int PICTURE_LOADING_STATE;
    public static final int PICTURE_LOADING_STATE__DEFAULT_VALUE;
    public static final int PICTURE_LOADING_STATE__C0_LOADING;
    public static final int PICTURE_LOADING_STATE__C1_READY;
    public static final int PICTURE_LOADING_STATE__C2_ERROR;
    public static final int SLIDE_SHOW_MODE;
    public static final int SLIDE_SHOW_MODE__DEFAULT_VALUE;
    public static final int SLIDE_SHOW_MODE__C0_SLIDESHOW_PLAY;
    public static final int SLIDE_SHOW_MODE__C1_SLIDESHOW_PAUSE;
    public static final int SLIDE_SHOW_REPEAT_STATE;
    public static final boolean SLIDE_SHOW_REPEAT_STATE__DEFAULT_VALUE;
    public static final int SLIDE_SHOW_TIMER;
    public static final int SLIDE_SHOW_TIMER__DEFAULT_VALUE;
    public static final int SLIDE_SHOW_TIMER__C0_SLIDESHOW_TIME_VERY_SHORT;
    public static final int SLIDE_SHOW_TIMER__C1_SLIDESHOW_TIME_SHORT;
    public static final int SLIDE_SHOW_TIMER__C2_SLIDESHOW_TIME_MEDIUM;
    public static final int SLIDE_SHOW_TIMER__C3_SLIDESHOW_TIME_LONG;
    public static final int SLIDE_SHOW_TIMER__C4_SLIDESHOW_TIME_VERY_LONG;
    public static final int PICTURE_DISPLAYED;
    public static final boolean PICTURE_DISPLAYED__DEFAULT_VALUE;

    static {
        CURRENT_PICTURE__DEFAULT_VALUE = null;
    }
}
