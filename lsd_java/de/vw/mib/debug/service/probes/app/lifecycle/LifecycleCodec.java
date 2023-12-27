/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.debug.service.probes.app.lifecycle;

import de.vw.mib.app.framework.diag.AppDiag;
import de.vw.mib.debug.service.probes.app.AbstractAppFrameworkCodec;
import de.vw.mib.debugmanager.probes.ProbeSystemServices;
import de.vw.mib.log4mib.BinaryMessage;

public class LifecycleCodec
extends AbstractAppFrameworkCodec {
    public LifecycleCodec(ProbeSystemServices probeSystemServices) {
        super(probeSystemServices);
    }

    @Override
    protected short getConfigurationMessageType() {
        return 64;
    }

    @Override
    protected short getMessageType() {
        return 283;
    }

    @Override
    protected byte getCodecVersion() {
        return -1;
    }

    public void encodeEnterView(AppDiag appDiag, String string, String[] stringArray, String string2) {
        this.viewChange((byte)4, appDiag, string, stringArray, string2);
    }

    public void encodeLeaveView(AppDiag appDiag, String string, String[] stringArray, String string2) {
        this.viewChange((byte)5, appDiag, string, stringArray, string2);
    }

    private void viewChange(byte by, AppDiag appDiag, String string, String[] stringArray, String string2) {
        BinaryMessage binaryMessage = this.createMessage(by);
        this.writeAppData(binaryMessage, appDiag);
        binaryMessage.append(this.nomalizeString(string));
        this.appendScreenAreaPath(stringArray, binaryMessage);
        binaryMessage.append(string2);
        binaryMessage.send();
    }

    private void appendScreenAreaPath(String[] stringArray, BinaryMessage binaryMessage) {
        if (stringArray == null) {
            binaryMessage.append(-1);
        } else {
            binaryMessage.append(stringArray.length);
            for (int i2 = 0; i2 < stringArray.length; ++i2) {
                String string = stringArray[i2];
                binaryMessage.append(string == null ? "<none>" : string);
            }
        }
    }

    public void encodeLifecycleChanged(AppDiag appDiag, int n) {
        BinaryMessage binaryMessage = this.createMessage((byte)0);
        this.writeAppData(binaryMessage, appDiag);
        binaryMessage.append(n);
        binaryMessage.send();
    }

    public void encodeVisibilityChanged(AppDiag appDiag, String string, String[] stringArray, boolean bl) {
        BinaryMessage binaryMessage = this.createMessage((byte)1);
        this.writeAppData(binaryMessage, appDiag);
        binaryMessage.append(string);
        this.appendScreenAreaPath(stringArray, binaryMessage);
        binaryMessage.append(bl);
        binaryMessage.send();
    }

    public void encodeAppCreated(AppDiag appDiag) {
        BinaryMessage binaryMessage = this.createMessage((byte)2);
        this.writeAppData(binaryMessage, appDiag);
        binaryMessage.send();
    }

    public void encodeAppDisposed(AppDiag appDiag) {
        BinaryMessage binaryMessage = this.createMessage((byte)3);
        this.writeAppData(binaryMessage, appDiag);
        binaryMessage.send();
    }
}

