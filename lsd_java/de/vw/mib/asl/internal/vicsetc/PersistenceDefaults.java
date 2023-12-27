/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.vicsetc;

public final class PersistenceDefaults {
    private static String prefectureString = "";
    private static int popupDurationTime = 0;
    private static int stationSelectMode = 0;
    private static boolean dataUploadChecked = true;
    private static boolean etcCardNotInsertedChecked = true;
    private static boolean etcCardReminderChecked = true;
    private static boolean popupEtcDrivingSupportChecked = true;
    private static boolean popupEtcTrafficAnnouncementChecked = true;
    private static boolean popupEtcTrafficInformationChecked = true;
    private static boolean tollFeeAnnouncementChecked = true;
    private static boolean tollFeePopupChecked = true;
    private static boolean vicsEventNoticeMapChecked = true;
    private static boolean vicsBeaconMessagesChecked = true;
    private static boolean vicsBeaconGraphicsChecked = true;
    private static boolean shortcutMessageChecked = false;
    private static String shortcutMessageValue = "-1";

    public static String getDefaultPrefectureString() {
        return prefectureString;
    }

    public static int getPopupDurationTime() {
        return popupDurationTime;
    }

    public static int getStationSelectMode() {
        return stationSelectMode;
    }

    public static boolean isDataUploadChecked() {
        return dataUploadChecked;
    }

    public static boolean isEtcCardNotInsertedChecked() {
        return etcCardNotInsertedChecked;
    }

    public static boolean isEtcCardReminderChecked() {
        return etcCardReminderChecked;
    }

    public static boolean isPopupEtcDrivingSupportChecked() {
        return popupEtcDrivingSupportChecked;
    }

    public static boolean isPopupEtcTrafficAnnouncementChecked() {
        return popupEtcTrafficAnnouncementChecked;
    }

    public static boolean isPopupEtcTrafficInformationChecked() {
        return popupEtcTrafficInformationChecked;
    }

    public static boolean isTollFeeAnnouncementChecked() {
        return tollFeeAnnouncementChecked;
    }

    public static boolean isTollFeePopupChecked() {
        return tollFeePopupChecked;
    }

    public static boolean isVicsEventNoticeMapChecked() {
        return vicsEventNoticeMapChecked;
    }

    public static boolean isVicsBeaconMessagesChecked() {
        return vicsBeaconMessagesChecked;
    }

    public static boolean isVicsBeaconGraphicsChecked() {
        return vicsBeaconGraphicsChecked;
    }

    public static boolean isShortcutMessageChecked() {
        return shortcutMessageChecked;
    }

    public static String getShortcutMessageValue() {
        return shortcutMessageValue;
    }
}

