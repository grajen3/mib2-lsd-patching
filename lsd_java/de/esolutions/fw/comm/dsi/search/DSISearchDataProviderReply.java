/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.search;

public interface DSISearchDataProviderReply {
    public static final String IPL_COMM_UUID;
    public static final String IPL_COMM_INTERFACE_KEY;
    public static final String IPL_COMM_INTERFACE_VERSION;
    public static final String IPL_COMM_MODULE_VERSION;

    default public void registerProviderSourceResult(int n, int n2) {
    }

    default public void activateProviderSource(int n) {
    }

    default public void invalidateAllDataResult(int n, int n2) {
    }

    default public void provideData(int n, int n2, int n3) {
    }

    default public void storeDataSetsResult(int n, int n2) {
    }

    default public void deleteDataSetResult(int n, int n2, long l) {
    }

    default public void asyncException(int n, String string, int n2) {
    }

    default public void yyIndication(String string, String string2) {
    }
}

