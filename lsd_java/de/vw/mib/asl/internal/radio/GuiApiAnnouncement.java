/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.radio;

import de.vw.mib.asl.framework.internal.framework.ServiceManager;

public final class GuiApiAnnouncement {
    private GuiApiAnnouncement() {
    }

    public static void updatePtyAnnouncementActive(boolean bl) {
        if (ServiceManager.logger.isTraceEnabled(8192)) {
            ServiceManager.logger.trace(8192).append("<HmiApiAnnouncement>updatePtyAnnouncementActive:").append(bl).log();
        }
        ServiceManager.aslPropertyManager.valueChangedBoolean(1441, bl);
    }

    public static void updatePtyStationName(String string) {
        ServiceManager.aslPropertyManager.valueChangedString(1327, string);
    }

    public static void updatePtyFrequency(int n) {
        ServiceManager.aslPropertyManager.valueChangedInteger(3006, n);
    }

    public static void updateFmTAStationName(String string) {
        if (null == string) {
            string = "";
        }
        if (ServiceManager.logger.isTraceEnabled(8192)) {
            ServiceManager.logger.trace(8192).append("GuiApiAnnouncement - updateFmTAStationName( ").append(string).append(" )").log();
        }
        ServiceManager.aslPropertyManager.valueChangedString(1328, string);
    }

    public static void updateFmTAFrequency(int n) {
        if (ServiceManager.logger.isTraceEnabled(8192)) {
            ServiceManager.logger.trace(8192).append("GuiApiAnnouncement - updateFmTAFrequency( ").append(n).append(" )").log();
        }
        ServiceManager.aslPropertyManager.valueChangedInteger(3007, n);
    }

    public static void updateTaActive(boolean bl) {
        ServiceManager.aslPropertyManager.valueChangedBoolean(1448, bl);
    }

    public static void updateTASource(int n) {
        if (ServiceManager.logger.isTraceEnabled(8192)) {
            ServiceManager.logger.trace(8192).append("<HmiApiAnnouncement>updateTASource:").append(n).log();
        }
        ServiceManager.aslPropertyManager.valueChangedInteger(1424, n);
    }

    public static void updateTASourceAsFm() {
        GuiApiAnnouncement.updateTASource(0);
    }

    public static void updateTASourceAsDAB() {
        GuiApiAnnouncement.updateTASource(1);
    }

    public static void updateDABAnnouncementType(int n) {
        if (ServiceManager.logger.isTraceEnabled(8192)) {
            ServiceManager.logger.trace(8192).append("<HmiApiAnnouncement>updateDABAnnouncementType:").append(n).log();
        }
        ServiceManager.aslPropertyManager.valueChangedInteger(1326, n);
    }

    public static void updateDabAnnouncementActive(boolean bl) {
        if (ServiceManager.logger.isTraceEnabled(8192)) {
            ServiceManager.logger.trace(8192).append("<HmiApiAnnouncement>updateDabAnnouncementActive:").append(bl).log();
        }
        ServiceManager.aslPropertyManager.valueChangedBoolean(1429, bl);
    }

    public static void updateDabAnnouncementStationName(String string) {
        if (ServiceManager.logger.isTraceEnabled(8192)) {
            ServiceManager.logger.trace(8192).append("<HmiApiAnnouncement>updateDabAnnouncementStationName:").append(string).log();
        }
        ServiceManager.aslPropertyManager.valueChangedString(1325, string);
    }

    public static void updateDabAnnouncementSyncState(int n) {
        if (ServiceManager.logger.isTraceEnabled(8192)) {
            ServiceManager.logger.trace(8192).append("<HmiApiAnnouncement>CURRENT_DAB_ANNOUNCEMENT_SERVICE_STATE:").append(n).log();
        }
        ServiceManager.aslPropertyManager.valueChangedInteger(3839, n);
    }
}

