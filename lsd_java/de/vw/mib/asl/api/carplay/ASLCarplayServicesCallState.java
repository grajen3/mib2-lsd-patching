/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.api.carplay;

public interface ASLCarplayServicesCallState {
    public static final int CALLSTATE_DISCONNECTED;
    public static final int CALLSTATE_ACTIVE;
    public static final int CALLSTATE_HOLDING;
    public static final int CALLSTATE_CONNECTING;
    public static final int CALLDIRECTION_INCOMING;
    public static final int CALLDIRECTION_OUTGOING;
    public static final int CALLDIRECTION_UNKNOWN;

    default public String getPhoneNumber() {
    }

    default public String getCallerName() {
    }

    default public int getStatus() {
    }

    default public int getDirection() {
    }

    default public String getUniqueCallID() {
    }
}

