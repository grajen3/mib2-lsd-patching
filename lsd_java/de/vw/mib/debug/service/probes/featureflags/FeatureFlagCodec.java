/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.debug.service.probes.featureflags;

import de.vw.mib.debugmanager.internal.AbstractProbeCodec;
import de.vw.mib.debugmanager.probes.ProbeSystemServices;
import de.vw.mib.log4mib.BinaryMessage;

public class FeatureFlagCodec
extends AbstractProbeCodec {
    public FeatureFlagCodec(ProbeSystemServices probeSystemServices) {
        super(probeSystemServices);
    }

    @Override
    protected byte getCodecVersion() {
        return -6;
    }

    public void encodeWholeFeatureFlagList(String[] stringArray, int[] nArray, boolean[] blArray) {
        BinaryMessage binaryMessage = this.createMessage((byte)2);
        binaryMessage.append(stringArray.length);
        for (int i2 = 0; i2 < stringArray.length; ++i2) {
            binaryMessage.append(stringArray[i2]);
            binaryMessage.append(nArray[i2]);
            binaryMessage.append(blArray[i2]);
        }
        binaryMessage.send();
    }

    public void encodeFeatureFlagUpdate(String string, byte by, boolean bl) {
        BinaryMessage binaryMessage = this.createMessage((byte)3);
        binaryMessage.append(string);
        binaryMessage.append(by);
        binaryMessage.append(bl);
        binaryMessage.send();
    }

    @Override
    protected short getConfigurationMessageType() {
        return 62;
    }

    @Override
    protected short getMessageType() {
        return 280;
    }
}

