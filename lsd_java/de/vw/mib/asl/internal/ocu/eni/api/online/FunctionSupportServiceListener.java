/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.ocu.eni.api.online;

public interface FunctionSupportServiceListener {
    public static final int SERVICE_SUPPORTED_OPERATIONS;
    public static final int ONLINE_NETWORK_SERVICES_SUPPORTED;
    public static final int[] SERVICE_CONSTANTS;

    default public void supportedOperations(boolean bl, boolean bl2, boolean bl3) {
    }

    default public void updateOnlineNetworkServicesSupported(boolean bl) {
    }

    static {
        SERVICE_CONSTANTS = new int[]{-2041032960, -2007478528};
    }
}

