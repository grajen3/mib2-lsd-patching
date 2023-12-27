/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.organizer;

public interface DSIAdbInitReply {
    public static final String IPL_COMM_UUID;
    public static final String IPL_COMM_INTERFACE_KEY;
    public static final String IPL_COMM_INTERFACE_VERSION;
    public static final String IPL_COMM_MODULE_VERSION;

    default public void updateDefaultPublicProfileVisibility(boolean bl, int n) {
    }

    default public void updateMaxLocalEntries(int n, int n2) {
    }

    default public void updateMaxPhoneEntries(int n, int n2) {
    }

    default public void updateMaxTopDestEntries(int n, int n2) {
    }

    default public void updateMaxSpeedDialEntries(int n, int n2) {
    }

    default public void updateAutoProfileAllocation(boolean bl, int n) {
    }

    default public void setDefaultPublicProfileVisibilityResult(int n) {
    }

    default public void setMaxLocalEntriesResult(int n) {
    }

    default public void setMaxPhoneEntriesResult(int n) {
    }

    default public void setMaxTopDestEntriesResult(int n) {
    }

    default public void setMaxSpeedDialEntriesResult(int n) {
    }

    default public void setNumericalSpellerEnabledResult(int n) {
    }

    default public void setAutoProfileAllocationResult(int n) {
    }

    default public void setSpeedDialTypeResult(int n) {
    }

    default public void setProfileHandlingType(int n) {
    }

    default public void setDefaultSortOrderResult(int n) {
    }

    default public void setOnlineDestinationEnabledResult(int n) {
    }

    default public void setDefaultSOSButtonResult(int n) {
    }

    default public void updateDefaultSOSButton(boolean bl, int n) {
    }

    default public void asyncException(int n, String string, int n2) {
    }

    default public void yyIndication(String string, String string2) {
    }
}

