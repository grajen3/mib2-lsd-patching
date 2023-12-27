/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.view.internal;

import de.vw.mib.hmi.utils.BitArray;
import de.vw.mib.hmi.utils.PerfectSlotHash;

public class PopupInfoResDataAccess {
    public static final int SIGNATURE;
    private static final int HEADER_ARRAY;
    private static final int POPUPINFO_PRIORITY_ARRAY;
    private static final int POPUPINFO_TIMEOUT_ARRAY;
    private static final int POPUPINFO_TIMEMIN_ARRAY;
    private static final int POPUPINFO_TIMERESTART_ARRAY;
    private static final int POPUPINFO_GLOBAL_ARRAY;
    private static final int POPUPINFO_MOVETOHOMECONTEXTBYHK_ARRAY;
    private static final int POPUPINFO_CLOSEWHENMOVETOHOMECONTEXT_ARRAY;
    private static final int POPUPINFO_CLOSEWHENSUPERSEDED_ARRAY;
    private static final int POPUPINFO_ACTIVEINUSERPERCEIVEOFFMODE_ARRAY;
    private static final int POPUPINFO_INVISIBLEINUSERPERCEIVEDOFFMODE_ARRAY;
    private static final int POPUPINFO_CLOSEONTOUCH_ARRAY;
    private static final int POPUPINFO_CLOSEONHK_ARRAY;
    private static final int POPUPINFO_CLOSEONHKEXCEPTIONS_ARRAY;
    private static final int POPUPINFO_CLOSEONPROXIMITY_ARRAY;
    private static final int POPUPINFO_FORWARDTOUCHEVENT_ARRAY;
    private static final int POPUPINFO_ACTIVEDURINGSPEECHDIALOG_ARRAY;
    private static final int POPUPINFO_SPEAKTHROUGH_ARRAY;
    private static final int POPUPINFO_STOPSSPEECH_ARRAY;
    private static final int POPUPINFO_INVISIBLEINACTIVEAREA_ARRAY;
    private static final int POPUPINFO_SHOWDURINGEXBOX_ARRAY;
    private static final int POPUPINFO_HOMECONTEXT_ARRAY;
    private static final int POPUPINFO_CONSUMEEVENTS_ARRAY;
    private static final int HOMECONTEXTLIST_ARRAY;
    private static final int EVENTLIST_ARRAY;
    private static final int HARDKEY_HK_ARRAY;
    private static final int HARDKEY_HOMECONTEXT_ARRAY;
    private static final int HARDKEY_HASH_ARRAY;
    private final Object[] resData;

    public PopupInfoResDataAccess(Object[] objectArray) {
        this.resData = objectArray;
    }

    public int getHeader_size() {
        return ((int[])this.resData[0]).length;
    }

    public int[] getHeader() {
        return (int[])this.resData[0];
    }

    public int getPopupInfo_size() {
        return ((short[])this.resData[1]).length;
    }

    public short[] getPopupInfo_Priority() {
        return (short[])this.resData[1];
    }

    public int[] getPopupInfo_TimeOut() {
        return (int[])this.resData[2];
    }

    public int[] getPopupInfo_TimeMin() {
        return (int[])this.resData[3];
    }

    public int[] getPopupInfo_TimeRestart() {
        return (int[])this.resData[4];
    }

    public BitArray newPopupInfo_Global() {
        return new BitArray((int[])this.resData[5]);
    }

    public BitArray newPopupInfo_MoveToHomeContextByHK() {
        return new BitArray((int[])this.resData[6]);
    }

    public BitArray newPopupInfo_CloseWhenMoveToHomeContext() {
        return new BitArray((int[])this.resData[7]);
    }

    public BitArray newPopupInfo_CloseWhenSuperseded() {
        return new BitArray((int[])this.resData[8]);
    }

    public BitArray newPopupInfo_ActiveInUserPerceiveOffMode() {
        return new BitArray((int[])this.resData[9]);
    }

    public BitArray newPopupInfo_InvisibleInUserPerceivedOffMode() {
        return new BitArray((int[])this.resData[10]);
    }

    public BitArray newPopupInfo_CloseOnTouch() {
        return new BitArray((int[])this.resData[11]);
    }

    public BitArray newPopupInfo_CloseOnHK() {
        return new BitArray((int[])this.resData[12]);
    }

    public short[] getPopupInfo_CloseOnHKExceptions() {
        return (short[])this.resData[13];
    }

    public BitArray newPopupInfo_CloseOnProximity() {
        return new BitArray((int[])this.resData[14]);
    }

    public BitArray newPopupInfo_ForwardTouchEvent() {
        return new BitArray((int[])this.resData[15]);
    }

    public BitArray newPopupInfo_ActiveDuringSpeechDialog() {
        return new BitArray((int[])this.resData[16]);
    }

    public BitArray newPopupInfo_SpeakThrough() {
        return new BitArray((int[])this.resData[17]);
    }

    public BitArray newPopupInfo_StopsSpeech() {
        return new BitArray((int[])this.resData[18]);
    }

    public BitArray newPopupInfo_InvisibleInactiveArea() {
        return new BitArray((int[])this.resData[19]);
    }

    public BitArray newPopupInfo_ShowDuringExBox() {
        return new BitArray((int[])this.resData[20]);
    }

    public short[] getPopupInfo_HomeContext() {
        return (short[])this.resData[21];
    }

    public short[] getPopupInfo_ConsumeEvents() {
        return (short[])this.resData[22];
    }

    public int getHomeContextList_size() {
        return ((String[])this.resData[23]).length;
    }

    public String[] getHomeContextList() {
        return (String[])this.resData[23];
    }

    public int getEventList_size() {
        return ((short[])this.resData[24]).length;
    }

    public short[] getEventList() {
        return (short[])this.resData[24];
    }

    public int getHardKey_size() {
        return ((short[])this.resData[25]).length;
    }

    public short[] getHardKey_HK() {
        return (short[])this.resData[25];
    }

    public String[] getHardKey_HomeContext() {
        return (String[])this.resData[26];
    }

    public PerfectSlotHash newHardKey_slothash() {
        return PerfectSlotHash.newSlotHash(this.resData[25], this.resData[27]);
    }
}

