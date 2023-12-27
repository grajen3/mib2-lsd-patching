/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.diagnose;

public interface DSIDiagnoseSystemReply {
    public static final String IPL_COMM_UUID;
    public static final String IPL_COMM_INTERFACE_KEY;
    public static final String IPL_COMM_INTERFACE_VERSION;
    public static final String IPL_COMM_MODULE_VERSION;

    default public void updateDiagnosticValueChanged(int n, long l, int n2) {
    }

    default public void requestRoutine(int n, int n2, int n3, int[] nArray) {
    }

    default public void requestActuatorTest(int n, int n2, int n3, int n4, int[] nArray) {
    }

    default public void asyncException(int n, String string, int n2) {
    }

    default public void yyIndication(String string, String string2) {
    }
}

