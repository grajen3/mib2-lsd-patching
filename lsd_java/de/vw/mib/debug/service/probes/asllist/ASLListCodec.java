/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.debug.service.probes.asllist;

import de.vw.mib.debugmanager.internal.AbstractProbeCodec;
import de.vw.mib.debugmanager.probes.ProbeSystemServices;
import de.vw.mib.log4mib.BinaryMessage;

public final class ASLListCodec
extends AbstractProbeCodec {
    public ASLListCodec(ProbeSystemServices probeSystemServices) {
        super(probeSystemServices);
    }

    public void encodeListUpdate(int n, int n2, String[] stringArray, int n3) {
        BinaryMessage binaryMessage = this.createMessage((byte)3);
        this.appendCurrentInvocation(binaryMessage);
        binaryMessage.append(n);
        binaryMessage.append(n2);
        if (stringArray == null) {
            binaryMessage.append(0);
        } else {
            int n4 = stringArray.length;
            binaryMessage.append(n4);
            for (int i2 = 0; i2 < n4; ++i2) {
                binaryMessage.append(stringArray[i2]);
            }
        }
        binaryMessage.append(n3);
        binaryMessage.send();
    }

    @Override
    protected byte getCodecVersion() {
        return -6;
    }

    @Override
    protected short getConfigurationMessageType() {
        return 50;
    }

    @Override
    protected short getMessageType() {
        return 261;
    }
}

