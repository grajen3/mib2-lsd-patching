/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.debug.service.probes.queues;

import de.vw.mib.debugmanager.internal.AbstractProbeCodec;
import de.vw.mib.debugmanager.probes.ProbeSystemServices;
import de.vw.mib.log4mib.BinaryMessage;

public final class QueuesCodec
extends AbstractProbeCodec {
    public QueuesCodec(ProbeSystemServices probeSystemServices) {
        super(probeSystemServices);
    }

    public void encodeQueueSize(byte by, int n) {
        BinaryMessage binaryMessage = this.createMessage((byte)2);
        binaryMessage.append(by);
        binaryMessage.append(n);
        binaryMessage.send();
    }

    public void encodeStatemachineEventQueue(int n) {
        this.encodeQueueSize((byte)0, n);
    }

    public void encodeSystemEventQueue(int n) {
        this.encodeQueueSize((byte)1, n);
    }

    public void encodeViewEventQueue(int n) {
        this.encodeQueueSize((byte)2, n);
    }

    @Override
    protected byte getCodecVersion() {
        return -4;
    }

    @Override
    protected short getConfigurationMessageType() {
        return 56;
    }

    @Override
    protected short getMessageType() {
        return 276;
    }
}

