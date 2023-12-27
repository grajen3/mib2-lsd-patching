/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.debug.service.probes.hsm;

import de.vw.mib.debugmanager.internal.AbstractProbeCodec;
import de.vw.mib.debugmanager.probes.ProbeSystemServices;
import de.vw.mib.log4mib.BinaryMessage;

public final class HsmCodec
extends AbstractProbeCodec {
    public HsmCodec(ProbeSystemServices probeSystemServices) {
        super(probeSystemServices);
    }

    public void encodeGotEvent(String string, String string2, int n) {
        BinaryMessage binaryMessage = this.createMessage((byte)2);
        this.encodePayloadeventOrTrigger(binaryMessage, string, string2, n);
        binaryMessage.send();
    }

    public void encodeTrigger(String string, String string2, int n) {
        BinaryMessage binaryMessage = this.createMessage((byte)3);
        this.encodePayloadeventOrTrigger(binaryMessage, string, string2, n);
        binaryMessage.send();
    }

    private void encodePayloadeventOrTrigger(BinaryMessage binaryMessage, String string, String string2, int n) {
        binaryMessage.append(string);
        binaryMessage.append(string2);
        binaryMessage.append(n);
    }

    public BinaryMessage encodeTransition(String string, String string2, String string3) {
        BinaryMessage binaryMessage = this.createMessage((byte)4);
        binaryMessage.append(string);
        binaryMessage.append(string2);
        binaryMessage.append(string3);
        return binaryMessage;
    }

    @Override
    protected byte getCodecVersion() {
        return -2;
    }

    @Override
    protected short getConfigurationMessageType() {
        return 61;
    }

    @Override
    protected short getMessageType() {
        return 279;
    }
}

