/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.comm.broker.v4;

import de.esolutions.fw.comm.comm.broker.v4.InstanceID;

public interface BrokerS {
    default public void announce(InstanceID instanceID) {
    }

    default public void registerService(InstanceID instanceID, int n) {
    }

    default public void unregisterService(InstanceID instanceID, int n) {
    }

    default public void lookupService(InstanceID instanceID, int n) {
    }
}

