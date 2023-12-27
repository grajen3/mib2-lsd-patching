/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.browser;

import org.dsi.ifc.browser.SearchHit;

public interface DSIBrowserBoardbookReply {
    public static final String IPL_COMM_UUID;
    public static final String IPL_COMM_INTERFACE_KEY;
    public static final String IPL_COMM_INTERFACE_VERSION;
    public static final String IPL_COMM_MODULE_VERSION;

    default public void indicateSearchResults(String string, int n, SearchHit[] searchHitArray, int n2) {
    }

    default public void updateBoardbookStatus(int n, int n2) {
    }

    default public void asyncException(int n, String string, int n2) {
    }

    default public void yyIndication(String string, String string2) {
    }
}

