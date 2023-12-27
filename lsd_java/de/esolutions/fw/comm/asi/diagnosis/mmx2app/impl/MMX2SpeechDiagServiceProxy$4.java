/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.diagnosis.mmx2app.impl;

import de.esolutions.fw.comm.asi.diagnosis.mmx2app.impl.MMX2SpeechDiagServiceProxy;
import de.esolutions.fw.comm.dsi.tts.impl.LanguageVoiceInfoSerializer;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.tts.LanguageVoiceInfo;

class MMX2SpeechDiagServiceProxy$4
implements ISerializable {
    private final /* synthetic */ LanguageVoiceInfo[] val$languageVoiceInfo;
    private final /* synthetic */ int val$validFlag;
    private final /* synthetic */ MMX2SpeechDiagServiceProxy this$0;

    MMX2SpeechDiagServiceProxy$4(MMX2SpeechDiagServiceProxy mMX2SpeechDiagServiceProxy, LanguageVoiceInfo[] languageVoiceInfoArray, int n) {
        this.this$0 = mMX2SpeechDiagServiceProxy;
        this.val$languageVoiceInfo = languageVoiceInfoArray;
        this.val$validFlag = n;
    }

    @Override
    public void serialize(ISerializer iSerializer) {
        LanguageVoiceInfoSerializer.putOptionalLanguageVoiceInfoVarArray(iSerializer, this.val$languageVoiceInfo);
        iSerializer.putInt32(this.val$validFlag);
    }
}

