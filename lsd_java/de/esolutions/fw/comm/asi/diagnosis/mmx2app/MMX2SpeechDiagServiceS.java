/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.diagnosis.mmx2app;

import de.esolutions.fw.comm.asi.diagnosis.diagtypes.sClientResponseError;
import de.esolutions.fw.comm.asi.diagnosis.mmx2app.MMX2SpeechDiagServiceReply;
import de.esolutions.fw.comm.asi.diagnosis.navigation.sNavCountryRegionVersion;
import de.esolutions.fw.comm.asi.diagnosis.speech.sCommandSDS;
import org.dsi.ifc.tts.LanguageVoiceInfo;

public interface MMX2SpeechDiagServiceS {
    default public void responseErrorSpeech(sClientResponseError sClientResponseError2, MMX2SpeechDiagServiceReply mMX2SpeechDiagServiceReply) {
    }

    default public void responseCommandSDS(sCommandSDS sCommandSDS2, MMX2SpeechDiagServiceReply mMX2SpeechDiagServiceReply) {
    }

    default public void responseCountryRegionVersion(sNavCountryRegionVersion sNavCountryRegionVersion2, MMX2SpeechDiagServiceReply mMX2SpeechDiagServiceReply) {
    }

    default public void updateAvailableLanguages(LanguageVoiceInfo[] languageVoiceInfoArray, int n, MMX2SpeechDiagServiceReply mMX2SpeechDiagServiceReply) {
    }
}

