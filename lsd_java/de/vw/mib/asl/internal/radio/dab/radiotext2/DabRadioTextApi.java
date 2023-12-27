/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.radio.dab.radiotext2;

import de.vw.mib.asl.api.radio.ASLRadioTargetIds;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.radio.RadioData;
import de.vw.mib.asl.internal.radio.dab.radiotext2.DabRadioTextTarget;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.GenericEventException;
import de.vw.mib.genericevents.GenericEvents;
import org.dsi.ifc.radio.ComponentInfo;
import org.dsi.ifc.radio.DABRadioText;
import org.dsi.ifc.radio.DABRadioTextPlusInfo;
import org.dsi.ifc.radio.ServiceInfo;

public final class DabRadioTextApi {
    private static final char SPACE;
    private static final char LINE_FEED;
    private static final char END_OF_HEADLINE;
    private static final char CARRIAGE_RETURN;
    private static final char WORD_BREAK;
    private static DabRadioTextTarget mController;

    public static void dabActivated() {
        DabRadioTextApi.trigger(6);
    }

    public static void dabDeactivated() {
        DabRadioTextApi.trigger(7);
    }

    public static void signalLost() {
        DabRadioTextApi.trigger(-1517944576);
    }

    public static void signalAvailable() {
        DabRadioTextApi.trigger(-1501167360);
    }

    public static void newProgram(long l) {
        if (mController.isTraceEnabled()) {
            mController.trace(new StringBuffer().append("+++ RT newProgram: ").append(RadioData.getDabDatabase().mPersistable.getCurrentService()).toString());
        }
        DabRadioTextApi.mController.mRadioText.clearAndUpdateRT();
        EventGeneric eventGeneric = ServiceManager.mGenericEventFactory.newEvent();
        eventGeneric.setReceiverEventId(-1484390144);
        eventGeneric.setLong(0, l);
        DabRadioTextApi.send(eventGeneric);
    }

    public static void update(DABRadioText dABRadioText) {
        if (dABRadioText != null && dABRadioText.text != null) {
            if (DabRadioTextApi.isItforCurrentServiceorComponent(dABRadioText)) {
                dABRadioText.text = dABRadioText.text.trim();
                dABRadioText.text = DabRadioTextApi.handleSpecialCharAndSpaces(dABRadioText.text);
                if (dABRadioText.text.length() > 0) {
                    DabRadioTextApi.mController.mRadioText.setRadioText(dABRadioText);
                } else {
                    DabRadioTextApi.zeroTextWarning();
                }
            }
        } else {
            DabRadioTextApi.zeroTextWarning();
        }
    }

    private static void zeroTextWarning() {
        if (mController.isTraceEnabled()) {
            mController.trace("+++ RTPLUS: Got a ZERO Radio Text Plus from South!");
        }
    }

    public static void update(DABRadioTextPlusInfo dABRadioTextPlusInfo) {
        if (DabRadioTextApi.isItforCurrentServiceorComponent(dABRadioTextPlusInfo)) {
            DabRadioTextApi.mController.mRadioText.setRadioTextPlus(dABRadioTextPlusInfo.getTags(), dABRadioTextPlusInfo.getContent());
            if (DabRadioTextApi.mController.mSyncAvailable) {
                mController.stopTimer(193396992);
            } else {
                mController.retriggerOrStartTimer(193396992, (long)0, false);
            }
        }
    }

    private static void trigger(int n) {
        if (mController != null) {
            try {
                mController.triggerMe(n);
            }
            catch (GenericEventException genericEventException) {
                // empty catch block
            }
        }
    }

    private static void send(EventGeneric eventGeneric) {
        if (mController != null) {
            try {
                eventGeneric.setSenderTargetId(ASLRadioTargetIds.ASL_RADIO_HSMTARGET_DAB);
                eventGeneric.setReceiverTargetId(mController.getTargetId());
                mController.send(eventGeneric);
            }
            catch (GenericEventException genericEventException) {
                // empty catch block
            }
        }
    }

    public static void initializeModule(GenericEvents genericEvents, String string) {
        if (mController == null) {
            mController = new DabRadioTextTarget(genericEvents, string);
        }
    }

    private static String handleSpecialCharAndSpaces(String string) {
        char[] cArray;
        int n;
        String string2 = "";
        if (string != null && (n = (cArray = string.toCharArray()).length) > 0) {
            char[] cArray2 = new char[n];
            int n2 = 0;
            int n3 = 0;
            int n4 = 0;
            block4: while (n2 < n) {
                char c2 = cArray[n2++];
                switch (c2) {
                    case '\n': 
                    case '\u000b': 
                    case ' ': {
                        if (n4 >= 4) continue block4;
                        cArray2[n3++] = 32;
                        ++n4;
                        continue block4;
                    }
                    case '\r': 
                    case '\u001f': {
                        continue block4;
                    }
                }
                if (n4 > 0) {
                    n4 = 0;
                }
                cArray2[n3++] = c2;
            }
            string2 = new String(cArray2, 0, n3);
        }
        return string2;
    }

    public static boolean isItforCurrentServiceorComponent(DABRadioText dABRadioText) {
        boolean bl = false;
        if (null != dABRadioText) {
            ComponentInfo componentInfo = RadioData.getDabDatabase().mTunerState.getCurrentComponent();
            if (null != componentInfo) {
                if (dABRadioText.sCIDI == componentInfo.sCIDI && (long)dABRadioText.sID == componentInfo.sID && dABRadioText.ensID == componentInfo.ensID) {
                    bl = true;
                }
            } else {
                ServiceInfo serviceInfo = RadioData.getDabDatabase().mTunerState.getCurrentService();
                if (null != serviceInfo && (long)dABRadioText.sID == serviceInfo.sID && dABRadioText.ensID == serviceInfo.ensID) {
                    bl = true;
                }
            }
            if (!bl && mController.isTraceEnabled()) {
                mController.trace("+++ RTPLUS: Wrong ServiceID or Component ID");
            }
        }
        return bl;
    }

    public static boolean isItforCurrentServiceorComponent(DABRadioTextPlusInfo dABRadioTextPlusInfo) {
        boolean bl = false;
        if (null != dABRadioTextPlusInfo) {
            ComponentInfo componentInfo = RadioData.getDabDatabase().mTunerState.getCurrentComponent();
            if (null != componentInfo) {
                if (dABRadioTextPlusInfo.sCIDI == componentInfo.sCIDI && (long)dABRadioTextPlusInfo.sID == componentInfo.sID && dABRadioTextPlusInfo.ensID == componentInfo.ensID) {
                    bl = true;
                }
            } else {
                ServiceInfo serviceInfo = RadioData.getDabDatabase().mTunerState.getCurrentService();
                if (null != serviceInfo && (long)dABRadioTextPlusInfo.sID == serviceInfo.sID && dABRadioTextPlusInfo.ensID == serviceInfo.ensID) {
                    bl = true;
                }
            }
            if (!bl && mController.isTraceEnabled()) {
                mController.trace("+++ RTPLUS: Wrong ServiceID or Component ID");
            }
        }
        return bl;
    }
}

