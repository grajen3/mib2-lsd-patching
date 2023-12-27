/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.kombifastlist;

import org.dsi.ifc.kombifastlist.ArrayHeader;

public interface DSIFastListScrollingAudioReply {
    public static final String IPL_COMM_UUID;
    public static final String IPL_COMM_INTERFACE_KEY;
    public static final String IPL_COMM_INTERFACE_VERSION;
    public static final String IPL_COMM_MODULE_VERSION;

    default public void indicationMediaBrowser(int n, int n2, int n3, int n4, long l, int n5, int n6, int n7, int n8, int n9, int n10) {
    }

    default public void indicationNotifyCommonListPUSH(boolean bl, boolean bl2) {
    }

    default public void indicationNotifyReceptionListPUSH(boolean bl, boolean bl2) {
    }

    default public void indicationNotifyCurrentListSizeAudio(boolean bl, boolean bl2) {
    }

    default public void indicationMediaBrowserJobs(int n, int n2, int n3, ArrayHeader[] arrayHeaderArray) {
    }

    default public void asyncException(int n, String string, int n2) {
    }

    default public void yyIndication(String string, String string2) {
    }
}

