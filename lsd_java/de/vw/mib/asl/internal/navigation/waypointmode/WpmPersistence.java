/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.waypointmode;

import de.vw.mib.asl.api.navigation.util.ASLNavigationUtilFactory;
import de.vw.mib.asl.api.navigation.util.PersistableMap;

public class WpmPersistence {
    private static final String WPM_SPLITSCREEN_ACTIVE;
    private static final boolean WPM_SPLITSCREEN_ACTIVE_DEFAULT;
    private static final String WPM_SPLITSCREEN_CONTENT_DEFAULT_MODE;
    private static final int WPM_SPLITSCREEN_CONTENT_DEFAULT_MODE_DEFAULT;
    private static final String WPM_SPLITSCREEN_CONTENT_DRIVE_RECORD_MODE;
    private static final int WPM_SPLITSCREEN_CONTENT_DRIVE_RECORD_MODE_DEFAULT;
    private static final String WPM_LAST_ACTIVE_TRACK;
    private static final int[] WPM_LAST_ACTIVE_TRACK_DEFAULT;
    private static final String EXECUTION_MODE;
    private static final int EXECUTION_MODE_DEFAULT;
    private static WpmPersistence instance;
    private PersistableMap persistableMap = ASLNavigationUtilFactory.getNavigationUtilApi().getNavigationDp().getExtendedNavPersistence().getPersistableMap("wpm");

    public static WpmPersistence getInstance() {
        return instance;
    }

    public int getExecutionMode() {
        return this.persistableMap.getInt("executionmode", 0);
    }

    public void setExecutionMode(int n) {
        this.persistableMap.setInt("executionmode", n);
    }

    public boolean isSplitActive() {
        return this.persistableMap.getBoolean("splitscreen.active", true);
    }

    public void setSplitScreenActive(boolean bl) {
        this.persistableMap.setBoolean("splitscreen.active", bl);
    }

    public int getSplitScreenContentDefaultMode() {
        return this.persistableMap.getInt("splitscreen.default.mode", 1);
    }

    public void setSplitScreenContentDefaultMode(int n) {
        this.persistableMap.setInt("splitscreen.default.mode", n);
    }

    public int getSplitScreenContentDriveRecordMode() {
        return this.persistableMap.getInt("splitscreen.drive.record.mode", 3);
    }

    public void setSplitScreenContentDriveRecordMode(int n) {
        this.persistableMap.setInt("splitscreen.drive.record.mode", n);
    }

    public int[] getLastActiveTrack() {
        return this.persistableMap.getIntArray("track.lastactive", WPM_LAST_ACTIVE_TRACK_DEFAULT);
    }

    public void setLastActiveTrack(int[] nArray) {
        this.persistableMap.setIntArray("track.lastactive", nArray);
    }

    public void clear() {
        this.persistableMap.clear();
    }

    static {
        WPM_LAST_ACTIVE_TRACK_DEFAULT = null;
        instance = new WpmPersistence();
    }
}

