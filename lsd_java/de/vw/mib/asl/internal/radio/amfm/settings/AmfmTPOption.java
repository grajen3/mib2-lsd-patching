/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.radio.amfm.settings;

import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.radio.GuiApiTunerCommon;
import de.vw.mib.asl.internal.radio.RadioCodingAdapter;
import de.vw.mib.asl.internal.radio.RadioData;
import de.vw.mib.asl.internal.radio.RadioUtil;
import de.vw.mib.asl.internal.radio.amfm.settings.AmfmRDSOption;
import de.vw.mib.genericevents.EventGeneric;

public final class AmfmTPOption {
    private AmfmTPOption() {
    }

    public static void reset() {
        AmfmTPOption.set(false);
        AmfmTPOption.setTpOnBeforeRdsOff(false);
    }

    public static void notifyHMI(boolean bl) {
        GuiApiTunerCommon.updateTpOption(bl);
    }

    public static void toggle() {
        AmfmTPOption.set(!AmfmTPOption.get());
    }

    public static void notifyFriends(boolean bl) {
        if (RadioCodingAdapter.isHongKongVariant()) {
            bl = false;
        }
        if (null != ServiceManager.eventMain) {
            EventGeneric eventGeneric = ServiceManager.eventMain.getEventFactory().newEvent();
            eventGeneric.setBoolean(0, bl);
            ServiceManager.eventMain.getServiceRegister().triggerObserver(1268973568, eventGeneric);
        }
    }

    public static void set(boolean bl) {
        if (RadioCodingAdapter.isHongKongVariant()) {
            bl = false;
        }
        RadioData.getAmfmDatabase().getSettingsPersistable().setTPOption(bl);
        if (AmfmRDSOption.get()) {
            AmfmTPOption.setTpOnBeforeRdsOff(AmfmTPOption.get());
        }
        if (ServiceManager.logger.isTraceEnabled(128)) {
            ServiceManager.logger.trace(128).append(RadioUtil.LOG_PREFIX_AMFM).append("TP setup option: ").append(bl);
        }
        AmfmTPOption.notifyHMI(bl);
        AmfmTPOption.notifyFriends(bl);
    }

    public static boolean get() {
        return RadioData.getAmfmDatabase().getSettingsPersistable().getTPOption();
    }

    public static boolean getTpOnBeforeRdsOff() {
        if (RadioCodingAdapter.isHongKongVariant()) {
            return false;
        }
        return RadioData.getAmfmDatabase().getSettingsPersistable().getTpOnBeforeRdsOff();
    }

    public static void setTpOnBeforeRdsOff(boolean bl) {
        if (RadioCodingAdapter.isHongKongVariant()) {
            bl = false;
        }
        RadioData.getAmfmDatabase().getSettingsPersistable().setTpOnBeforeRdsOff(bl);
    }
}

