/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.diagnosis.mmx2app.impl;

import de.esolutions.fw.comm.asi.diagnosis.diagtypes.sClientResponseError;
import de.esolutions.fw.comm.asi.diagnosis.mmx2app.MMX2SpeechDiagService;
import de.esolutions.fw.comm.asi.diagnosis.mmx2app.MMX2SpeechDiagServiceC;
import de.esolutions.fw.comm.asi.diagnosis.mmx2app.MMX2SpeechDiagServiceReply;
import de.esolutions.fw.comm.asi.diagnosis.mmx2app.impl.MMX2SpeechDiagServiceProxy$1;
import de.esolutions.fw.comm.asi.diagnosis.mmx2app.impl.MMX2SpeechDiagServiceProxy$2;
import de.esolutions.fw.comm.asi.diagnosis.mmx2app.impl.MMX2SpeechDiagServiceProxy$3;
import de.esolutions.fw.comm.asi.diagnosis.mmx2app.impl.MMX2SpeechDiagServiceProxy$4;
import de.esolutions.fw.comm.asi.diagnosis.mmx2app.impl.MMX2SpeechDiagServiceReplyService;
import de.esolutions.fw.comm.asi.diagnosis.navigation.sNavCountryRegionVersion;
import de.esolutions.fw.comm.asi.diagnosis.speech.sCommandSDS;
import de.esolutions.fw.comm.core.CallContext;
import de.esolutions.fw.comm.core.Proxy;
import de.esolutions.fw.comm.core.ServiceInstanceID;
import org.dsi.ifc.tts.LanguageVoiceInfo;

public class MMX2SpeechDiagServiceProxy
implements MMX2SpeechDiagService,
MMX2SpeechDiagServiceC {
    private static final CallContext context = CallContext.getContext("PROXY.asi.diagnosis.mmx2app.MMX2SpeechDiagService");
    private Proxy proxy;

    public MMX2SpeechDiagServiceProxy(int n, MMX2SpeechDiagServiceReply mMX2SpeechDiagServiceReply) {
        ServiceInstanceID serviceInstanceID = new ServiceInstanceID("1afa0c22-bc63-4208-9611-a0303fb2f206", n, "c3528b6d-ac3d-5343-a985-6176b647a3b5", "asi.diagnosis.mmx2app.MMX2SpeechDiagService");
        MMX2SpeechDiagServiceReplyService mMX2SpeechDiagServiceReplyService = new MMX2SpeechDiagServiceReplyService(mMX2SpeechDiagServiceReply);
        this.proxy = new Proxy(serviceInstanceID, mMX2SpeechDiagServiceReplyService, context);
    }

    public Proxy getProxy() {
        return this.proxy;
    }

    @Override
    public void responseErrorSpeech(sClientResponseError sClientResponseError2) {
        MMX2SpeechDiagServiceProxy$1 mMX2SpeechDiagServiceProxy$1 = new MMX2SpeechDiagServiceProxy$1(this, sClientResponseError2);
        this.proxy.remoteCallMethod((short)15, mMX2SpeechDiagServiceProxy$1);
    }

    @Override
    public void responseCommandSDS(sCommandSDS sCommandSDS2) {
        MMX2SpeechDiagServiceProxy$2 mMX2SpeechDiagServiceProxy$2 = new MMX2SpeechDiagServiceProxy$2(this, sCommandSDS2);
        this.proxy.remoteCallMethod((short)2, mMX2SpeechDiagServiceProxy$2);
    }

    @Override
    public void responseCountryRegionVersion(sNavCountryRegionVersion sNavCountryRegionVersion2) {
        MMX2SpeechDiagServiceProxy$3 mMX2SpeechDiagServiceProxy$3 = new MMX2SpeechDiagServiceProxy$3(this, sNavCountryRegionVersion2);
        this.proxy.remoteCallMethod((short)13, mMX2SpeechDiagServiceProxy$3);
    }

    @Override
    public void updateAvailableLanguages(LanguageVoiceInfo[] languageVoiceInfoArray, int n) {
        MMX2SpeechDiagServiceProxy$4 mMX2SpeechDiagServiceProxy$4 = new MMX2SpeechDiagServiceProxy$4(this, languageVoiceInfoArray, n);
        this.proxy.remoteCallMethod((short)14, mMX2SpeechDiagServiceProxy$4);
    }
}

