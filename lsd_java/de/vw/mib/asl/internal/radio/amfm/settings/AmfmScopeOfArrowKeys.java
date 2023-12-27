/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.radio.amfm.settings;

import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.radio.GuiApiTunerCommon;
import de.vw.mib.asl.internal.radio.RadioData;
import de.vw.mib.asl.internal.radio.RadioUtil;

public final class AmfmScopeOfArrowKeys {
    private AmfmScopeOfArrowKeys() {
    }

    public static void reset() {
        if (ServiceManager.configManagerDiag.isFeatureFlagSet(2)) {
            AmfmScopeOfArrowKeys.set(0);
        } else {
            AmfmScopeOfArrowKeys.set(1);
        }
    }

    public static void notifyHMI() {
        GuiApiTunerCommon.updateScopeOfArrowKeys(AmfmScopeOfArrowKeys.get());
    }

    public static void set(int n) {
        RadioData.getAmfmDatabase().getSettingsPersistable().setScopeOfArrowKeysOption(n);
        if (ServiceManager.logger.isTraceEnabled(128)) {
            ServiceManager.logger.trace(128).append(RadioUtil.LOG_PREFIX_AMFM).append(AmfmScopeOfArrowKeys.getString()).log();
        }
        AmfmScopeOfArrowKeys.notifyHMI();
    }

    public static int get() {
        return RadioData.getAmfmDatabase().getSettingsPersistable().getScopeOfArrowKeysOption();
    }

    private static String getString() {
        StringBuffer stringBuffer = new StringBuffer(30);
        stringBuffer.append("ScopeOfArrowKeys = ");
        if (AmfmScopeOfArrowKeys.get() == 1) {
            stringBuffer.append("Station");
        } else {
            stringBuffer.append("Preset");
        }
        return stringBuffer.toString();
    }

    public String toString() {
        return AmfmScopeOfArrowKeys.getString();
    }
}

