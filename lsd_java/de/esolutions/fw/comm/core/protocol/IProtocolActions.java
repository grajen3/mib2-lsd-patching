/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.core.protocol;

import de.esolutions.fw.comm.core.ServiceInstanceID;
import de.esolutions.fw.util.serializer.IDeserializer;

public interface IProtocolActions {
    default public void handleCreateStub(short s, short s2, ServiceInstanceID serviceInstanceID) {
    }

    default public void handleCreateRRStub(short s, short s2, ServiceInstanceID serviceInstanceID, ServiceInstanceID serviceInstanceID2, short s3) {
    }

    default public void handleStubCreated(short s, short s2) {
    }

    default public void handleStubFailed(short s, byte by) {
    }

    default public void handleDestroyStub(short s) {
    }

    default public void handleProxyAlive(short s) {
    }

    default public void handleCallMethod(short s, short s2, IDeserializer iDeserializer) {
    }

    default public void handleRRStubCreated(short s, short s2, short s3) {
    }

    default public void handlePing() {
    }
}

