/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.debug.service.probes.app.cio;

import de.vw.mib.app.framework.assembly.CioIntentClassData;
import de.vw.mib.cio.CioActionParameters;
import de.vw.mib.cio.framework.diag.CioIntentDiag;
import de.vw.mib.debug.service.probes.app.AbstractAppFrameworkCodec;
import de.vw.mib.debugmanager.probes.ProbeSystemServices;
import de.vw.mib.log4mib.BinaryMessage;

public class CioCodec
extends AbstractAppFrameworkCodec {
    private static final String EMPTY;

    public CioCodec(ProbeSystemServices probeSystemServices) {
        super(probeSystemServices);
    }

    @Override
    protected short getConfigurationMessageType() {
        return 63;
    }

    @Override
    protected short getMessageType() {
        return 282;
    }

    @Override
    protected byte getCodecVersion() {
        return -1;
    }

    public void sendCioRegistered(CioIntentClassData cioIntentClassData, CioIntentDiag cioIntentDiag) {
        BinaryMessage binaryMessage = this.createMessage((byte)3);
        this.writeCioData(binaryMessage, cioIntentClassData, cioIntentDiag, cioIntentDiag.getPayload());
        binaryMessage.send();
    }

    public void sendCioChanged(CioIntentClassData cioIntentClassData, CioIntentDiag cioIntentDiag) {
        BinaryMessage binaryMessage = this.createMessage((byte)4);
        this.writeCioData(binaryMessage, cioIntentClassData, cioIntentDiag, cioIntentDiag.getPayload());
        binaryMessage.send();
    }

    public void sendCioExecute(CioIntentClassData cioIntentClassData, CioIntentDiag cioIntentDiag, CioActionParameters cioActionParameters) {
        BinaryMessage binaryMessage = this.createMessage((byte)5);
        this.writeCioData(binaryMessage, cioIntentClassData, cioIntentDiag, cioActionParameters);
        if (null == cioActionParameters) {
            binaryMessage.append("EMPTY");
        } else {
            binaryMessage.append(cioActionParameters.toString());
        }
        binaryMessage.send();
    }

    public void sendCioUnregistered(CioIntentClassData cioIntentClassData, CioIntentDiag cioIntentDiag) {
        BinaryMessage binaryMessage = this.createMessage((byte)6);
        this.writeCioData(binaryMessage, cioIntentClassData, cioIntentDiag, cioIntentDiag.getPayload());
        binaryMessage.send();
    }

    private void writeCioData(BinaryMessage binaryMessage, CioIntentClassData cioIntentClassData, CioIntentDiag cioIntentDiag, CioActionParameters cioActionParameters) {
        binaryMessage.append(this.nomalizeString(cioIntentDiag.getAppName()));
        binaryMessage.append(this.nomalizeString(cioIntentDiag.getAppInstanceName()));
        binaryMessage.append(this.nomalizeString(cioIntentDiag.getCioExecutor()));
        binaryMessage.append(this.nomalizeString(cioIntentDiag.getCioIntentClass()));
        binaryMessage.append(this.nomalizeString(cioIntentDiag.getCioIntentName()));
        binaryMessage.append(cioIntentDiag.getCioIntentId());
        binaryMessage.append(this.nomalizeString(cioIntentDiag.getUsage()));
        binaryMessage.append(cioIntentDiag.getVisualizationId());
        binaryMessage.append(cioIntentDiag.isAvailable());
    }
}

