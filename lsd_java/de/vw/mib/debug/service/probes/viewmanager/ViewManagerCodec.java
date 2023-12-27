/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.debug.service.probes.viewmanager;

import de.vw.mib.debugmanager.internal.AbstractProbeCodec;
import de.vw.mib.debugmanager.probes.ProbeSystemServices;
import de.vw.mib.log4mib.BinaryMessage;
import java.util.ArrayList;

public final class ViewManagerCodec
extends AbstractProbeCodec {
    public ViewManagerCodec(ProbeSystemServices probeSystemServices) {
        super(probeSystemServices);
    }

    public void encodeVisibleViewsChange(ArrayList arrayList) {
        BinaryMessage binaryMessage = this.createMessage((byte)2);
        binaryMessage.append(arrayList.size());
        for (int i2 = 0; i2 < arrayList.size(); ++i2) {
            binaryMessage.append((String)arrayList.get(i2));
        }
        binaryMessage.send();
    }

    @Override
    protected byte getCodecVersion() {
        return -4;
    }

    @Override
    protected short getConfigurationMessageType() {
        return 60;
    }

    @Override
    protected short getMessageType() {
        return 275;
    }
}

