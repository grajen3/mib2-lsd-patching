/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.diagnosis.mmx2app.impl;

import de.esolutions.fw.comm.asi.diagnosis.mmx2app.impl.MMX2SpeechDiagServiceProxy;
import de.esolutions.fw.comm.asi.diagnosis.speech.impl.sCommandSDSSerializer;
import de.esolutions.fw.comm.asi.diagnosis.speech.sCommandSDS;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;

class MMX2SpeechDiagServiceProxy$2
implements ISerializable {
    private final /* synthetic */ sCommandSDS val$command;
    private final /* synthetic */ MMX2SpeechDiagServiceProxy this$0;

    MMX2SpeechDiagServiceProxy$2(MMX2SpeechDiagServiceProxy mMX2SpeechDiagServiceProxy, sCommandSDS sCommandSDS2) {
        this.this$0 = mMX2SpeechDiagServiceProxy;
        this.val$command = sCommandSDS2;
    }

    @Override
    public void serialize(ISerializer iSerializer) {
        sCommandSDSSerializer.putOptionalsCommandSDS(iSerializer, this.val$command);
    }
}

