/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.diagnosis.mmx2app.impl;

import de.esolutions.fw.comm.asi.diagnosis.diagtypes.impl.sClientResponseErrorSerializer;
import de.esolutions.fw.comm.asi.diagnosis.diagtypes.sClientResponseError;
import de.esolutions.fw.comm.asi.diagnosis.mmx2app.MMX2SpeechDiagServiceS;
import de.esolutions.fw.comm.asi.diagnosis.mmx2app.impl.MMX2SpeechDiagServiceReplyProxy;
import de.esolutions.fw.comm.asi.diagnosis.navigation.impl.sNavCountryRegionVersionSerializer;
import de.esolutions.fw.comm.asi.diagnosis.navigation.sNavCountryRegionVersion;
import de.esolutions.fw.comm.asi.diagnosis.speech.impl.sCommandSDSSerializer;
import de.esolutions.fw.comm.asi.diagnosis.speech.sCommandSDS;
import de.esolutions.fw.comm.core.AbstractService;
import de.esolutions.fw.comm.core.CallContext;
import de.esolutions.fw.comm.core.IProxyFrontend;
import de.esolutions.fw.comm.core.ServiceInstanceID;
import de.esolutions.fw.comm.core.method.MethodException;
import de.esolutions.fw.comm.dsi.tts.impl.LanguageVoiceInfoSerializer;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.exception.SerializerException;
import org.dsi.ifc.tts.LanguageVoiceInfo;

public class MMX2SpeechDiagServiceService
extends AbstractService {
    private static final CallContext context = CallContext.getContext("STUB.asi.diagnosis.mmx2app.MMX2SpeechDiagService");
    private MMX2SpeechDiagServiceS p_MMX2SpeechDiagService;

    public MMX2SpeechDiagServiceService(int n, MMX2SpeechDiagServiceS mMX2SpeechDiagServiceS) {
        super(new ServiceInstanceID("1afa0c22-bc63-4208-9611-a0303fb2f206", n, "c3528b6d-ac3d-5343-a985-6176b647a3b5", "asi.diagnosis.mmx2app.MMX2SpeechDiagService"));
        this.p_MMX2SpeechDiagService = mMX2SpeechDiagServiceS;
    }

    @Override
    public IProxyFrontend createReplyProxy() {
        return new MMX2SpeechDiagServiceReplyProxy();
    }

    @Override
    public CallContext getCallContext() {
        return context;
    }

    @Override
    public void handleCallMethod(short s, IDeserializer iDeserializer, IProxyFrontend iProxyFrontend) {
        try {
            switch (s) {
                case 15: {
                    sClientResponseError sClientResponseError2 = sClientResponseErrorSerializer.getOptionalsClientResponseError(iDeserializer);
                    this.p_MMX2SpeechDiagService.responseErrorSpeech(sClientResponseError2, (MMX2SpeechDiagServiceReplyProxy)iProxyFrontend);
                    break;
                }
                case 2: {
                    sCommandSDS sCommandSDS2 = sCommandSDSSerializer.getOptionalsCommandSDS(iDeserializer);
                    this.p_MMX2SpeechDiagService.responseCommandSDS(sCommandSDS2, (MMX2SpeechDiagServiceReplyProxy)iProxyFrontend);
                    break;
                }
                case 13: {
                    sNavCountryRegionVersion sNavCountryRegionVersion2 = sNavCountryRegionVersionSerializer.getOptionalsNavCountryRegionVersion(iDeserializer);
                    this.p_MMX2SpeechDiagService.responseCountryRegionVersion(sNavCountryRegionVersion2, (MMX2SpeechDiagServiceReplyProxy)iProxyFrontend);
                    break;
                }
                case 14: {
                    LanguageVoiceInfo[] languageVoiceInfoArray = LanguageVoiceInfoSerializer.getOptionalLanguageVoiceInfoVarArray(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_MMX2SpeechDiagService.updateAvailableLanguages(languageVoiceInfoArray, n, (MMX2SpeechDiagServiceReplyProxy)iProxyFrontend);
                    break;
                }
                default: {
                    throw new MethodException(new StringBuffer().append("Invalid Method Id ").append(s).toString());
                }
            }
        }
        catch (SerializerException serializerException) {
            throw new MethodException(new StringBuffer().append("Deserialization failed: method=").append(s).append(", error=").append(serializerException.getMessage()).toString());
        }
    }
}

