/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.comm.broker.v4;

import de.esolutions.fw.comm.comm.broker.v4.InstanceID;

public interface Broker {
    public static final String IPL_COMM_UUID;
    public static final String IPL_COMM_INTERFACE_KEY;
    public static final String IPL_COMM_INTERFACE_VERSION;
    public static final String IPL_COMM_MODULE_VERSION;

    default public void announce(InstanceID instanceID) {
    }

    default public void registerService(InstanceID instanceID, int n) {
    }

    default public void unregisterService(InstanceID instanceID, int n) {
    }

    default public void lookupService(InstanceID instanceID, int n) {
    }
}

