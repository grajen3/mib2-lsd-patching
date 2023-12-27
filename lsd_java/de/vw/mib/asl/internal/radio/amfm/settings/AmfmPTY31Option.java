/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.radio.amfm.settings;

import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.radio.GuiApiTunerCommon;
import de.vw.mib.asl.internal.radio.RadioData;
import de.vw.mib.asl.internal.radio.RadioUtil;
import de.vw.mib.genericevents.EventGeneric;

public final class AmfmPTY31Option {
    private AmfmPTY31Option() {
    }

    public static void reset() {
        AmfmPTY31Option.set(true);
    }

    public static void notifyHMI() {
        GuiApiTunerCommon.updateSetupPtyAnnouncement(AmfmPTY31Option.get());
    }

    public static void toggle() {
        AmfmPTY31Option.set(!AmfmPTY31Option.get());
    }

    private static void notifyFriends() {
        EventGeneric eventGeneric = ServiceManager.mGenericEventFactory.newEvent();
        eventGeneric.setBoolean(0, AmfmPTY31Option.get());
        ServiceManager.eventMain.getServiceRegister().triggerObserver(-862060544, eventGeneric);
    }

    public static void set(boolean bl) {
        RadioData.getAmfmDatabase().getSettingsPersistable().setPty31Option(bl);
        if (ServiceManager.logger.isTraceEnabled(128)) {
            ServiceManager.logger.trace(128).append(RadioUtil.LOG_PREFIX_AMFM).append("PTY31 setup option: ").append(RadioData.getAmfmDatabase().getSettingsPersistable().getPty31Option()).log();
        }
        AmfmPTY31Option.notifyHMI();
        AmfmPTY31Option.notifyFriends();
    }

    public static boolean get() {
        return RadioData.getAmfmDatabase().getSettingsPersistable().getPty31Option();
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(30);
        stringBuffer.append("PTY31 Setup Option = ");
        stringBuffer.append(AmfmPTY31Option.get());
        return stringBuffer.toString();
    }
}

