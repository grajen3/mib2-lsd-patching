/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.tmc;

import org.dsi.ifc.base.DSIBase;

public interface DSITmcOnRoute
extends DSIBase {
    public static final String VERSION;
    public static final int TMCWARNINGMODE_OFF;
    public static final int TMCWARNINGMODE_CONGESTION_ACOUSTICAL_ONLY;
    public static final int TMCWARNINGMODE_CONGESTION_VISUAL_ONLY;
    public static final int TMCWARNINGMODE_CONGESTION_ACOUSTIC_AND_VISUAL;
    public static final int BLOCKREQUESTRESULTCODE_OK;
    public static final int BLOCKREQUESTRESULTCODE_FAILED;
    public static final int NAVICOREAVAILABLETOCHANGEBLOCKINGS_READY;
    public static final int NAVICOREAVAILABLETOCHANGEBLOCKINGS_BUSY;
    public static final int FLOWSEVERITY_UNKNOWN;
    public static final int FLOWSEVERITY_FREE_FLOW;
    public static final int FLOWSEVERITY_HEAVY_TRAFFIC;
    public static final int FLOWSEVERITY_SLOW_TRAFFIC;
    public static final int FLOWSEVERITY_QUEUING_TRAFFIC;
    public static final int FLOWSEVERITY_QUEUING_STATIONARY;
    public static final int FLOWSEVERITY_NO_TRAFFIC_FLOW;
    public static final int ATTR_TMCMESSAGESAHEAD;
    public static final int ATTR_URGENTMESSAGES;
    public static final int ATTR_TMCMESSAGESAHEADCALCULATIONHORIZON;
    public static final int ATTR_NAVICOREAVAILABLETOCHANGETMCBLOCKINGS;
    public static final int ATTR_CURRENTLYBLOCKEDTMCMESSAGES;
    public static final int ATTR_SPEEDANDFLOWAHEAD;
    public static final int RT_GETTMCMESSAGE;
    public static final int RT_SETTMCWARNINGMODE;
    public static final int RT_BLOCKTMCMESSAGES;
    public static final int RT_UNBLOCKALLTMCMESSAGES;
    public static final int RT_UNBLOCKTMCMESSAGES;
    public static final int RP_TMCMESSAGE;
    public static final int RP_SETTMCWARNINGMODERESULT;
    public static final int RP_UNBLOCKTMCMESSAGESRESULT;
    public static final int RP_UNBLOCKALLTMCMESSAGESRESULT;
    public static final int RP_BLOCKTMCMESSAGESRESULT;
    public static final int IN_INDICATETRAFFICEVENTNOTICEMAP;

    default public void getTmcMessage(int n) {
    }

    default public void setTmcWarningMode(int n) {
    }

    default public void blockTMCMessages(long[] lArray, boolean bl) {
    }

    default public void unblockTMCMessages(long[] lArray) {
    }

    default public void unblockAllTMCMessages() {
    }
}

