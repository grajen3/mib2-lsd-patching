/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.sm.internal.statemachine;

public class StatemachinesResDataAccess {
    public static final int SIGNATURE;
    private static final int HEADER_ARRAY;
    private static final int TOPSTATEMACHINES_KIND_ARRAY;
    private static final int TOPSTATEMACHINES_SSMPATHROOT_ARRAY;
    private static final int TOPSTATEMACHINES_POPUPINFO_ARRAY;
    private static final int TOPSTATEMACHINES_STATEMACHINEID_ARRAY;
    private static final int TOPSTATEMACHINES_CATEGORY_ARRAY;
    private static final int TOPSTATEMACHINES_SUBPRIORITY_ARRAY;
    private static final int TOPSTATEMACHINES_SPEECHCLIENTID_ARRAY;
    private static final int SSMPATHS_PARENT_ARRAY;
    private static final int SSMPATHS_SLOTSTATEID_ARRAY;
    private static final int SSMPATHS_SUBIDX_ARRAY;
    private static final int SUBIDS_ARRAY;
    private static final int POPUPINFOS_POPUPINFOID_ARRAY;
    private static final int POPUPINFOS_VIEWSTATEID_ARRAY;
    private static final int SUBSTATEMACHINES_ACTIVITY_ARRAY;
    private static final int SUBSTATEMACHINES_SOFFSET_ARRAY;
    private static final int SUBSTATEMACHINES_ITOFFSET_ARRAY;
    private static final int SUBSTATEMACHINES_TTOFFSET_ARRAY;
    private static final int SUBSTATEMACHINES_UTOFFSET_ARRAY;
    private static final int SUBSTATEMACHINES_ENTRYSTATE_ARRAY;
    private static final int SUBSTATEMACHINES_HISTORYCOUNT_ARRAY;
    private static final int STATES_KIND_ARRAY;
    private static final int STATES_PARENT_ARRAY;
    private static final int STATES_ITSTART_ARRAY;
    private static final int STATES_ITEND_ARRAY;
    private static final int STATES_TTSTART_ARRAY;
    private static final int STATES_TTEND_ARRAY;
    private static final int STATES_UTSTART_ARRAY;
    private static final int STATES_UTEND_ARRAY;
    private static final int STATES_EXTENSION_ARRAY;
    private static final int INTERNALS_TRIGGER_ARRAY;
    private static final int INTERNALS_FLAGS_ARRAY;
    private static final int TRIGGEREDS_TRIGGER_ARRAY;
    private static final int TRIGGEREDS_TARGET_ARRAY;
    private static final int TRIGGEREDS_FLAGS_ARRAY;
    private static final int UNTRIGGEREDS_TARGET_ARRAY;
    private static final int UNTRIGGEREDS_FLAGS_ARRAY;
    private final Object[] resData;

    public StatemachinesResDataAccess(Object[] objectArray) {
        this.resData = objectArray;
    }

    public int getHeader_size() {
        return ((int[])this.resData[0]).length;
    }

    public int[] getHeader() {
        return (int[])this.resData[0];
    }

    public int getTopStatemachines_size() {
        return ((byte[])this.resData[1]).length;
    }

    public byte[] getTopStatemachines_Kind() {
        return (byte[])this.resData[1];
    }

    public short[] getTopStatemachines_SsmPathRoot() {
        return (short[])this.resData[2];
    }

    public short[] getTopStatemachines_PopupInfo() {
        return (short[])this.resData[3];
    }

    public short[] getTopStatemachines_StatemachineId() {
        return (short[])this.resData[4];
    }

    public short[] getTopStatemachines_Category() {
        return (short[])this.resData[5];
    }

    public short[] getTopStatemachines_SubPriority() {
        return (short[])this.resData[6];
    }

    public short[] getTopStatemachines_SpeechClientId() {
        return (short[])this.resData[7];
    }

    public int getSsmPaths_size() {
        return ((short[])this.resData[8]).length;
    }

    public short[] getSsmPaths_Parent() {
        return (short[])this.resData[8];
    }

    public short[] getSsmPaths_SlotStateId() {
        return (short[])this.resData[9];
    }

    public short[] getSsmPaths_SubIdx() {
        return (short[])this.resData[10];
    }

    public int getSubIds_size() {
        return ((short[])this.resData[11]).length;
    }

    public short[] getSubIds() {
        return (short[])this.resData[11];
    }

    public int getPopupInfos_size() {
        return ((short[])this.resData[12]).length;
    }

    public short[] getPopupInfos_PopupInfoId() {
        return (short[])this.resData[12];
    }

    public short[] getPopupInfos_ViewStateId() {
        return (short[])this.resData[13];
    }

    public int getSubStatemachines_size() {
        return ((short[])this.resData[14]).length;
    }

    public short[] getSubStatemachines_Activity() {
        return (short[])this.resData[14];
    }

    public short[] getSubStatemachines_SOffset() {
        return (short[])this.resData[15];
    }

    public short[] getSubStatemachines_ItOffset() {
        return (short[])this.resData[16];
    }

    public short[] getSubStatemachines_TtOffset() {
        return (short[])this.resData[17];
    }

    public short[] getSubStatemachines_UtOffset() {
        return (short[])this.resData[18];
    }

    public short[] getSubStatemachines_EntryState() {
        return (short[])this.resData[19];
    }

    public short[] getSubStatemachines_HistoryCount() {
        return (short[])this.resData[20];
    }

    public int getStates_size() {
        return ((byte[])this.resData[21]).length;
    }

    public byte[] getStates_Kind() {
        return (byte[])this.resData[21];
    }

    public short[] getStates_Parent() {
        return (short[])this.resData[22];
    }

    public short[] getStates_ITstart() {
        return (short[])this.resData[23];
    }

    public short[] getStates_ITend() {
        return (short[])this.resData[24];
    }

    public short[] getStates_TTstart() {
        return (short[])this.resData[25];
    }

    public short[] getStates_TTend() {
        return (short[])this.resData[26];
    }

    public short[] getStates_UTstart() {
        return (short[])this.resData[27];
    }

    public short[] getStates_UTend() {
        return (short[])this.resData[28];
    }

    public short[] getStates_Extension() {
        return (short[])this.resData[29];
    }

    public int getInternals_size() {
        return ((short[])this.resData[30]).length;
    }

    public short[] getInternals_Trigger() {
        return (short[])this.resData[30];
    }

    public byte[] getInternals_Flags() {
        return (byte[])this.resData[31];
    }

    public int getTriggereds_size() {
        return ((short[])this.resData[32]).length;
    }

    public short[] getTriggereds_Trigger() {
        return (short[])this.resData[32];
    }

    public short[] getTriggereds_Target() {
        return (short[])this.resData[33];
    }

    public byte[] getTriggereds_Flags() {
        return (byte[])this.resData[34];
    }

    public int getUntriggereds_size() {
        return ((short[])this.resData[35]).length;
    }

    public short[] getUntriggereds_Target() {
        return (short[])this.resData[35];
    }

    public byte[] getUntriggereds_Flags() {
        return (byte[])this.resData[36];
    }
}

