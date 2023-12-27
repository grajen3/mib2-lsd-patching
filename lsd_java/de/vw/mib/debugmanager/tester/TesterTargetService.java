/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.debugmanager.tester;

public interface TesterTargetService {
    public static final int DATAPOOL_MONITOR_TARGET;
    public static final int DSI_MARSHALLER_TARGET;
    public static final int EVENT_DISPATCHER_TARGET;
    public static final int INFORMATION_COLLECTOR_TARGET;
    public static final int KEYPANEL_TARGET;
    public static final int TESTER_TARGET;
    public static final int TESTINTERFACE_TARGET;
    public static final int VIEW_TARGET;
    public static final int DSI_TESTER_TARGET;
    public static final int SCREEN_SHOT_TARGET;
    public static final int HMI_DUMP_TARGET;

    default public void createAndRegisterDebugTarget(int n) {
    }
}

