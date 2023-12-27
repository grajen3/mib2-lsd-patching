/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.debug.service.probes.app.modelapi;

import de.vw.mib.app.framework.diag.AppDiag;
import de.vw.mib.debug.service.probes.app.AbstractAppFrameworkCodec;
import de.vw.mib.debugmanager.probes.ProbeSystemServices;
import de.vw.mib.log4mib.BinaryMessage;
import de.vw.mib.modelapi.ModelApiDownEvent;
import de.vw.mib.modelapi.ModelApiUpEvent;

public class ModelApiCodec
extends AbstractAppFrameworkCodec {
    public ModelApiCodec(ProbeSystemServices probeSystemServices) {
        super(probeSystemServices);
    }

    @Override
    protected short getConfigurationMessageType() {
        return 65;
    }

    @Override
    protected short getMessageType() {
        return 284;
    }

    @Override
    protected byte getCodecVersion() {
        return -1;
    }

    public void encodeModelApiDownCall(AppDiag appDiag, ModelApiDownEvent modelApiDownEvent, int n) {
        BinaryMessage binaryMessage = this.createMessage((byte)1);
        this.appendCurrentInvocation(binaryMessage);
        this.writeAppData(binaryMessage, appDiag);
        binaryMessage.append(modelApiDownEvent.toString());
        binaryMessage.append(n);
        binaryMessage.send();
    }

    public void encodeModelApiUnboundDownCall(AppDiag appDiag, String string) {
        BinaryMessage binaryMessage = this.createMessage((byte)3);
        this.appendCurrentInvocation(binaryMessage);
        this.writeAppData(binaryMessage, appDiag);
        binaryMessage.append(string);
        binaryMessage.send();
    }

    public void encodeModelApiUnboundUpCall(AppDiag appDiag, String string) {
        BinaryMessage binaryMessage = this.createMessage((byte)2);
        this.appendCurrentInvocation(binaryMessage);
        this.writeAppData(binaryMessage, appDiag);
        binaryMessage.append(string);
        binaryMessage.send();
    }

    public void encodeModelApiUpCall(AppDiag appDiag, ModelApiUpEvent modelApiUpEvent, int n) {
        BinaryMessage binaryMessage = this.createMessage((byte)0);
        this.appendCurrentInvocation(binaryMessage);
        this.writeAppData(binaryMessage, appDiag);
        binaryMessage.append(modelApiUpEvent.toString());
        binaryMessage.append(n);
        binaryMessage.send();
    }
}

