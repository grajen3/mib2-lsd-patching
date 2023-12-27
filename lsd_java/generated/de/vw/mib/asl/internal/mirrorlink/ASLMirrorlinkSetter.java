/*
 * Decompiled with CFR 0.152.
 */
package generated.de.vw.mib.asl.internal.mirrorlink;

public interface ASLMirrorlinkSetter {
    public static final int SPELLER_DELETE_CHAR;
    public static final int SPELLER_OK;
    public static final int SPELLER_CANCEL;
    public static final int SPELLER_ENTERED;
    public static final int ENTER_APP_MODE_VIEW;
    public static final int DISCONNECT_MEDIA;
    public static final int LEAVE_APP_MODE_VIEW;
    public static final int ENTER_MIRRORLINK_CONTEXT;
    public static final int LEAVE_MIRRORLINK_CONTEXT;
    public static final int SPELLER_SET_CHAR;
    public static final int SPELLER_SET_CHAR__P0_LETTER__STRING;
    public static final int SPELLER_SET_CURSORPOSITION;
    public static final int SPELLER_SET_CURSORPOSITION__P0_INDEX__INT;
    public static final int SELECT_APP_LIST;
    public static final int SELECT_APP_LIST__P0_LISTINDEX__INT;
    public static final int SELECT_DEVICE;
    public static final int SELECT_DEVICE__P0_LISTINDEX__INT;
    public static final int SELECT_OPEN_APP_LIST;
    public static final int SELECT_OPEN_APP_LIST__P0_LISTINDEX__INT;
    public static final int TOGGLE_IS_PROXIMITY_MODE_ACTIVATED;
    public static final int TOGGLE_ALLOW_APP_POPUP;
    public static final int TOGGLE_APP_MODE_CONTROLBAR_VISIBILITY;
    public static final int CLOSE_MIRRORLINK;
    public static final int CLOSE_ALL_OPEN_APPS;
    public static final int TOGGLE_MIRRORLINK_ACTIVATION;
    public static final int TOGGLE_UPSIDE_DOWN_ACTIVATION;
    public static final int TOGGLE_AUTO_SPELLER_ACTIVATION;
    public static final int SELECT_DISPLAY_ROTATION;
    public static final int SELECT_DISPLAY_ROTATION__P0_LISTENTRYNR__INT;
    public static final int SELECT_DISPLAY_ROTATION__LISTENTRYNR__C0_0;
    public static final int SELECT_DISPLAY_ROTATION__LISTENTRYNR__C1_90;
    public static final int SELECT_DISPLAY_ROTATION__LISTENTRYNR__C2_180;
    public static final int SELECT_DISPLAY_ROTATION__LISTENTRYNR__C3_270;
    public static final int SELECT_APP_NOTIFICATION_BUTTON;
    public static final int SELECT_APP_NOTIFICATION_BUTTON__P1_PRESSEDBUTTON__INT;
    public static final int SELECT_APP_NOTIFICATION_BUTTON__PRESSEDBUTTON__C0_CLOSE;
    public static final int SELECT_APP_NOTIFICATION_BUTTON__PRESSEDBUTTON__C1_ACTION1;
    public static final int SELECT_APP_NOTIFICATION_BUTTON__PRESSEDBUTTON__C2_ACTION2;
    public static final int SET_SPELLER_ALPHABET_TYPE;
    public static final int SET_SPELLER_ALPHABET_TYPE__P0_TYPE__INT;
    public static final int SET_SPELLER_ALPHABET_TYPE__TYPE__C0_ABC_QWERTY;
    public static final int SET_SPELLER_ALPHABET_TYPE__TYPE__C1_ABC_QWERTY_MATCH;
    public static final int SET_SPELLER_ALPHABET_TYPE__TYPE__C2_NUMBER;
    public static final int SET_ICON_CAPABILITY;
    public static final int SET_ICON_CAPABILITY__P0_DIMENSION_WIDTH__INT;
    public static final int SET_ICON_CAPABILITY__P1_DIMENSION_HEIGHT__INT;
    public static final int SELECT_CURRENT_AUDIOSOURCE2;
    public static final int SELECT_CURRENT_AUDIOSOURCE2__P0_LISTENTRYNR__INT;
    public static final int SELECT_CURRENT_AUDIOSOURCE2__LISTENTRYNR__C0_BLUETOOTH;
    public static final int SELECT_CURRENT_AUDIOSOURCE2__LISTENTRYNR__C1_MIRRORLINK;
    public static final int SELECT_CURRENT_AUDIOSOURCE2__LISTENTRYNR__C2_AUTO;
    public static final int SELECT_CURRENT_CONNECTIONTYPE2;
    public static final int SELECT_CURRENT_CONNECTIONTYPE2__P0_LISTENTRYNR__INT;
    public static final int SELECT_CURRENT_CONNECTIONTYPE2__LISTENTRYNR__C0_USB;
    public static final int SELECT_CURRENT_CONNECTIONTYPE2__LISTENTRYNR__C1_WLAN;
    public static final int SELECT_CURRENT_CONNECTIONTYPE2__LISTENTRYNR__C2_AUTO;
    public static final int SELECT_DISPLAY_ORIENTATION;
    public static final int SELECT_DISPLAY_ORIENTATION__P0_LISTENTRYNR__INT;
    public static final int SELECT_DISPLAY_ORIENTATION__LISTENTRYNR__C0_HORIZONTAL;
    public static final int SELECT_DISPLAY_ORIENTATION__LISTENTRYNR__C1_VERTICAL;
    public static final int TOUCH_EVENT_GESTURE;
    public static final int TOUCH_EVENT_GESTURE__P0_POSX__INT;
    public static final int TOUCH_EVENT_GESTURE__P1_POSY__INT;
    public static final int TOUCH_EVENT_GESTURE__P2_DELTAX__INT;
    public static final int TOUCH_EVENT_GESTURE__P3_DELTAY__INT;
    public static final int TOUCH_EVENT_GESTURE__P4_FINGERDISTANCE__INT;
    public static final int TOUCH_EVENT_GESTURE__P5_FINGERDISTANCECHANGE__INT;
    public static final int TOUCH_EVENT_GESTURE__P6_GESTURETYPE__INT;
    public static final int TOUCH_EVENT_GESTURE__GESTURETYPE__C0_PRESSED;
    public static final int TOUCH_EVENT_GESTURE__GESTURETYPE__C1_RELEASED;
    public static final int TOUCH_EVENT_GESTURE__GESTURETYPE__C2_CLICKED;
    public static final int TOUCH_EVENT_GESTURE__GESTURETYPE__C3_DRAGGED;
    public static final int TOUCH_EVENT_GESTURE__GESTURETYPE__C4_ZOOMED;
    public static final int TOUCH_EVENT;
    public static final int TOUCH_EVENT__P0_X__INT;
    public static final int TOUCH_EVENT__P1_Y__INT;
    public static final int TOUCH_EVENT__P2_GESTURE__INT;
    public static final int TOUCH_EVENT__GESTURE__C0_PRESSED;
    public static final int TOUCH_EVENT__GESTURE__C1_RELEASED;
    public static final int SELECT_SOFT_BUTTON;
    public static final int SELECT_SOFT_BUTTON__P0_TYPE__INT;
    public static final int SELECT_SOFT_BUTTON__TYPE__C0_SOFTKEY_DEVICE_NONE;
    public static final int SELECT_SOFT_BUTTON__TYPE__C1_SOFTKEY_DEVICE_DELETE;
    public static final int SELECT_SOFT_BUTTON__TYPE__C2_SOFTKEY_DEVICE_HOME;
    public static final int SELECT_SOFT_BUTTON__TYPE__C3_SOFTKEY_DEVICE_MENU;
    public static final int SELECT_SOFT_BUTTON__TYPE__C4_SOFTKEY_DEVICE_APPLICATION;
    public static final int SELECT_SOFT_BUTTON__TYPE__C5_SOFTKEY_DEVICE_CLEAR;
    public static final int SELECT_SOFT_BUTTON__TYPE__C6_SOFTKEY_DEVICE_BACKWARD;
    public static final int SELECT_SOFT_BUTTON__TYPE__C7_SOFTKEY_DEVICE_OK;
    public static final int SELECT_SOFT_BUTTON__TYPE__C8_SOFTKEY_DEVICE_SEARCH;
    public static final int SELECT_SOFT_BUTTON__TYPE__C9_SOFTKEY_DEVICE_PHONE_CALL;
    public static final int SELECT_SOFT_BUTTON__TYPE__C10_SOFTKEY_DEVICE_PHONE_END;
    public static final int SELECT_SOFT_BUTTON__TYPE__C11_SOFTKEY_DEVICE_SOFT_LEFT;
    public static final int SELECT_SOFT_BUTTON__TYPE__C12_SOFTKEY_DEVICE_SOFT_MIDDLE;
    public static final int SELECT_SOFT_BUTTON__TYPE__C13_SOFTKEY_DEVICE_SOFT_RIGHT;
    public static final int SELECT_SOFT_BUTTON__TYPE__C14_SOFTKEY_DEVICE_FORWARD;
    public static final int SELECT_SOFT_BUTTON__TYPE__C15_SOFTKEY_DEVICE_ZOOM_IN;
    public static final int SELECT_SOFT_BUTTON__TYPE__C16_SOFTKEY_DEVICE_ZOOM_OUT;
    public static final int SELECT_SOFT_BUTTON__P1_GESTURE__INT;
    public static final int SELECT_SOFT_BUTTON__GESTURE__C0_PRESSED;
    public static final int SELECT_SOFT_BUTTON__GESTURE__C1_RELEASED;
    public static final int SELECT_FULL_ACCESS;
}
