/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.komogfxstreamsink;

public interface DSIKOMOGfxStreamSinkReply {
    public static final String IPL_COMM_UUID;
    public static final String IPL_COMM_INTERFACE_KEY;
    public static final String IPL_COMM_INTERFACE_VERSION;
    public static final String IPL_COMM_MODULE_VERSION;

    default public void updateGfxState(int n, int n2) {
    }

    default public void updateRequestSync(int n, int n2) {
    }

    default public void updateDataRate(int n, int n2) {
    }

    default public void setFGLayerResult(int n) {
    }

    default public void fadeInResult() {
    }

    default public void fadeOutResult() {
    }

    default public void asyncException(int n, String string, int n2) {
    }

    default public void yyIndication(String string, String string2) {
    }
}

