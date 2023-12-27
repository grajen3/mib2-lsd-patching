/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.debug.service.probes.app;

import de.vw.mib.app.framework.diag.AppDiag;
import de.vw.mib.debugmanager.internal.AbstractProbeCodec;
import de.vw.mib.debugmanager.probes.ProbeSystemServices;
import de.vw.mib.log4mib.BinaryMessage;

public abstract class AbstractAppFrameworkCodec
extends AbstractProbeCodec {
    public AbstractAppFrameworkCodec(ProbeSystemServices probeSystemServices) {
        super(probeSystemServices);
    }

    protected String nomalizeString(String string) {
        return string == null ? "null" : string;
    }

    protected void writeAppData(BinaryMessage binaryMessage, AppDiag appDiag) {
        binaryMessage.append(this.nomalizeString(appDiag.getAppAdapterClass()));
        binaryMessage.append(appDiag.getAppInstanceId());
        binaryMessage.append(this.nomalizeString(appDiag.getAppInstanceName()));
        binaryMessage.append(this.nomalizeString(appDiag.getAppName()));
    }
}

