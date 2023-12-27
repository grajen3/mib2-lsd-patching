/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.infotainmentrecorder;

import org.dsi.ifc.base.DSIBase;

public interface DSIInfotainmentRecorder
extends DSIBase {
    public static final String VERSION;
    public static final int RT_LOGPANELNAME;
    public static final int RT_LOGKEYEVENT;
    public static final int RT_BACKUPTRIGGER;
    public static final int RT_ENABLETRIGGER;
    public static final int RT_LOGINIT;
    public static final int ATTR_ENABLEDTRIGGERS;
    public static final int TTRIGGERTYPES_IRC_EXCEPTION_TRIGGER;
    public static final int TTRIGGERTYPES_IRC_HOTKEY_TRIGGER;
    public static final int TTRIGGERTYPES_IRC_RESET_TRIGGER;
    public static final int TTRIGGERTYPES_SYSTEM_DRIVE_ERROR;
    public static final int TTRIGGERTYPES_SYSTEM_DRIVE_READERROR;
    public static final int TTRIGGERTYPES_SYSTEM_HDD_DEFECT;
    public static final int TTRIGGERTYPES_SYSTEM_HDD_PRESURE;
    public static final int TTRIGGERTYPES_SYSTEM_OVER_HEAT;
    public static final int TTRIGGERTYPES_TEL_PHONE_NOT_FUNCTIONAL;
    public static final int TTRIGGERTYPES_TEL_PHONE_TEMPERATURE_OFF;
    public static final int TTRIGGERTYPES_TEL_SECCO_BLOCKED;
    public static final int TTRIGGERTYPES_TEMP_SYSTEM_CD_DRIVE_DAMAGED;
    public static final int TTRIGGERTYPES_TEMP_SYSTEM_CD_DRIVE_TEMPHIGH;
    public static final int TTRIGGERTYPES_TEMP_SYSTEM_CD_DRIVE_TEMPLOW;
    public static final int TTRIGGERTYPES_TEMP_SYSTEM_DVD_DRIVE_DAMAGED;
    public static final int TTRIGGERTYPES_TEMP_SYSTEM_DVD_DRIVE_TEMPHIGH;
    public static final int TTRIGGERTYPES_TEMP_SYSTEM_DVD_DRIVE_TEMPLOW;
    public static final int TTRIGGERTYPES_TEMP_SYSTEM_TEMP;
    public static final int TTRIGGERTYPES_UNUSED;

    default public void logPanelName(String string) {
    }

    default public void logKeyEvent(int n, int n2, int n3) {
    }

    default public void backupTrigger(int n) {
    }

    default public void enableTrigger(boolean bl, int n) {
    }

    default public void logInit() {
    }
}

