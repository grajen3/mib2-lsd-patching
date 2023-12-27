/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.debug.service.probes.datapool;

import de.vw.mib.debugmanager.internal.AbstractProbeCodec;
import de.vw.mib.debugmanager.probes.ProbeSystemServices;
import de.vw.mib.log4mib.BinaryMessage;

public final class DatapoolCodec
extends AbstractProbeCodec {
    public DatapoolCodec(ProbeSystemServices probeSystemServices) {
        super(probeSystemServices);
    }

    public void encodeDatapoolUpdate(byte by, int n) {
        BinaryMessage binaryMessage = this.createMessage((byte)2);
        this.appendCurrentInvocation(binaryMessage);
        binaryMessage.append(by);
        binaryMessage.append(n);
        binaryMessage.send();
    }

    public void encodeDatapoolUpdate(byte by, int n, String string) {
        BinaryMessage binaryMessage = this.createMessage((byte)3);
        this.appendCurrentInvocation(binaryMessage);
        binaryMessage.append(by);
        binaryMessage.append(n);
        binaryMessage.append(string);
        binaryMessage.send();
    }

    @Override
    protected byte getCodecVersion() {
        return -6;
    }

    @Override
    protected short getConfigurationMessageType() {
        return 51;
    }

    @Override
    protected short getMessageType() {
        return 262;
    }
}

