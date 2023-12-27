/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.speechrec.impl;

import de.esolutions.fw.comm.core.AbstractReplyService;
import de.esolutions.fw.comm.core.CallContext;
import de.esolutions.fw.comm.core.IProxyFrontend;
import de.esolutions.fw.comm.core.ServiceInstanceID;
import de.esolutions.fw.comm.core.method.MethodException;
import de.esolutions.fw.comm.dsi.speechrec.DSISpeechRecReply;
import de.esolutions.fw.comm.dsi.speechrec.impl.GrammarInfoSerializer;
import de.esolutions.fw.comm.dsi.speechrec.impl.GrammarStateInfoSerializer;
import de.esolutions.fw.comm.dsi.speechrec.impl.NBestListSerializer;
import de.esolutions.fw.comm.dsi.speechrec.impl.VDECapabilitiesSerializer;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.exception.SerializerException;
import org.dsi.ifc.speechrec.GrammarInfo;
import org.dsi.ifc.speechrec.GrammarStateInfo;
import org.dsi.ifc.speechrec.NBestList;
import org.dsi.ifc.speechrec.VDECapabilities;

public class DSISpeechRecReplyService
extends AbstractReplyService {
    private static final CallContext context = CallContext.getContext("STUB.dsi.speechrec.DSISpeechRec");
    private static int dynamicHandle = 0;
    private DSISpeechRecReply p_DSISpeechRecReply;

    public DSISpeechRecReplyService(DSISpeechRecReply dSISpeechRecReply) {
        super(new ServiceInstanceID("79eee404-4c40-56c5-8364-199e1f7288f9", DSISpeechRecReplyService.nextDynamicHandle(), "16e45b2a-c0be-56b6-af24-bf8bb01263ef", "dsi.speechrec.DSISpeechRec"));
        this.p_DSISpeechRecReply = dSISpeechRecReply;
    }

    private static synchronized int nextDynamicHandle() {
        int n = ++dynamicHandle;
        return n;
    }

    @Override
    public CallContext getCallContext() {
        return context;
    }

    @Override
    public void handleCallMethod(short s, IDeserializer iDeserializer, IProxyFrontend iProxyFrontend) {
        try {
            switch (s) {
                case 45: {
                    int n = iDeserializer.getInt32();
                    this.p_DSISpeechRecReply.responseAbort(n);
                    break;
                }
                case 47: {
                    int n = iDeserializer.getInt32();
                    this.p_DSISpeechRecReply.responseDeleteProfile(n);
                    break;
                }
                case 48: {
                    int n = iDeserializer.getInt32();
                    this.p_DSISpeechRecReply.responseDeleteVoiceTag(n);
                    break;
                }
                case 106: {
                    int n = iDeserializer.getInt32();
                    this.p_DSISpeechRecReply.responseEnableContinuousUpdate(n);
                    break;
                }
                case 49: {
                    String string = iDeserializer.getOptionalString();
                    this.p_DSISpeechRecReply.responseGetVersion(string);
                    break;
                }
                case 50: {
                    int n = iDeserializer.getInt32();
                    this.p_DSISpeechRecReply.responseInit(n);
                    break;
                }
                case 51: {
                    int n = iDeserializer.getInt32();
                    this.p_DSISpeechRecReply.responseInitVoiceTag(n);
                    break;
                }
                case 52: {
                    int n = iDeserializer.getInt32();
                    GrammarInfo[] grammarInfoArray = GrammarInfoSerializer.getOptionalGrammarInfoVarArray(iDeserializer);
                    this.p_DSISpeechRecReply.responseLoadGrammar(n, grammarInfoArray);
                    break;
                }
                case 53: {
                    int n = iDeserializer.getInt32();
                    this.p_DSISpeechRecReply.responseLoadProfile(n);
                    break;
                }
                case 54: {
                    int n = iDeserializer.getInt32();
                    GrammarInfo[] grammarInfoArray = GrammarInfoSerializer.getOptionalGrammarInfoVarArray(iDeserializer);
                    this.p_DSISpeechRecReply.responsePreloadGrammar(n, grammarInfoArray);
                    break;
                }
                case 55: {
                    int n = iDeserializer.getInt32();
                    this.p_DSISpeechRecReply.responseRecordVoiceTag(n);
                    break;
                }
                case 62: {
                    int n = iDeserializer.getInt32();
                    this.p_DSISpeechRecReply.responseSetLanguage(n);
                    break;
                }
                case 70: {
                    int n = iDeserializer.getInt32();
                    this.p_DSISpeechRecReply.responseShutdown(n);
                    break;
                }
                case 73: {
                    int n = iDeserializer.getInt32();
                    this.p_DSISpeechRecReply.responseStartRecognition(n);
                    break;
                }
                case 76: {
                    int n = iDeserializer.getInt32();
                    GrammarInfo[] grammarInfoArray = GrammarInfoSerializer.getOptionalGrammarInfoVarArray(iDeserializer);
                    this.p_DSISpeechRecReply.responseUnloadGrammar(n, grammarInfoArray);
                    break;
                }
                case 77: {
                    int n = iDeserializer.getInt32();
                    this.p_DSISpeechRecReply.responseUnloadProfile(n);
                    break;
                }
                case 78: {
                    int n = iDeserializer.getInt32();
                    GrammarInfo[] grammarInfoArray = GrammarInfoSerializer.getOptionalGrammarInfoVarArray(iDeserializer);
                    this.p_DSISpeechRecReply.responseUnpreloadGrammar(n, grammarInfoArray);
                    break;
                }
                case 79: {
                    int n = iDeserializer.getInt32();
                    NBestList nBestList = NBestListSerializer.getOptionalNBestList(iDeserializer);
                    this.p_DSISpeechRecReply.responseWaitForResults(n, nBestList);
                    break;
                }
                case 80: {
                    boolean bl = iDeserializer.getBool();
                    int n = iDeserializer.getInt32();
                    this.p_DSISpeechRecReply.updateAborted(bl, n);
                    break;
                }
                case 82: {
                    String[] stringArray = iDeserializer.getOptionalStringVarArray();
                    int n = iDeserializer.getInt32();
                    this.p_DSISpeechRecReply.updateAvailableLanguages(stringArray, n);
                    break;
                }
                case 83: {
                    int[] nArray = iDeserializer.getOptionalInt32VarArray();
                    int n = iDeserializer.getInt32();
                    this.p_DSISpeechRecReply.updateAvailableProfiles(nArray, n);
                    break;
                }
                case 85: {
                    boolean bl = iDeserializer.getBool();
                    int n = iDeserializer.getInt32();
                    this.p_DSISpeechRecReply.updateFailure(bl, n);
                    break;
                }
                case 89: {
                    String string = iDeserializer.getOptionalString();
                    int n = iDeserializer.getInt32();
                    int n2 = iDeserializer.getInt32();
                    this.p_DSISpeechRecReply.updateLanguage(string, n, n2);
                    break;
                }
                case 93: {
                    int n = iDeserializer.getInt32();
                    int n3 = iDeserializer.getInt32();
                    this.p_DSISpeechRecReply.updateRecognizerState(n, n3);
                    break;
                }
                case 81: {
                    int n = iDeserializer.getInt32();
                    int n4 = iDeserializer.getInt32();
                    this.p_DSISpeechRecReply.updateAbsoluteConfidenceThreshold(n, n4);
                    break;
                }
                case 63: {
                    int n = iDeserializer.getInt32();
                    this.p_DSISpeechRecReply.responseSetMaxCommandNBestListSize(n);
                    break;
                }
                case 90: {
                    int n = iDeserializer.getInt32();
                    int n5 = iDeserializer.getInt32();
                    this.p_DSISpeechRecReply.updateMaxCommandNBestListSize(n, n5);
                    break;
                }
                case 64: {
                    int n = iDeserializer.getInt32();
                    this.p_DSISpeechRecReply.responseSetMaxSlotNBestListSize(n);
                    break;
                }
                case 91: {
                    int n = iDeserializer.getInt32();
                    int n6 = iDeserializer.getInt32();
                    this.p_DSISpeechRecReply.updateMaxSlotNBestListSize(n, n6);
                    break;
                }
                case 60: {
                    int n = iDeserializer.getInt32();
                    this.p_DSISpeechRecReply.responseSetConfidenceRejectThreshold(n);
                    break;
                }
                case 84: {
                    int n = iDeserializer.getInt32();
                    int n7 = iDeserializer.getInt32();
                    this.p_DSISpeechRecReply.updateConfidenceRejectThreshold(n, n7);
                    break;
                }
                case 69: {
                    int n = iDeserializer.getInt32();
                    this.p_DSISpeechRecReply.responseSetUtteranceStartTimeout(n);
                    break;
                }
                case 98: {
                    int n = iDeserializer.getInt32();
                    int n8 = iDeserializer.getInt32();
                    this.p_DSISpeechRecReply.updateUtteranceStartTimeout(n, n8);
                    break;
                }
                case 65: {
                    int n = iDeserializer.getInt32();
                    this.p_DSISpeechRecReply.responseSetRecognitionTimeout(n);
                    break;
                }
                case 92: {
                    int n = iDeserializer.getInt32();
                    int n9 = iDeserializer.getInt32();
                    this.p_DSISpeechRecReply.updateRecognitionTimeout(n, n9);
                    break;
                }
                case 68: {
                    int n = iDeserializer.getInt32();
                    this.p_DSISpeechRecReply.responseSetUnambiguousResultThreshold(n);
                    break;
                }
                case 97: {
                    int n = iDeserializer.getInt32();
                    int n10 = iDeserializer.getInt32();
                    this.p_DSISpeechRecReply.updateUnambiguousResultThreshold(n, n10);
                    break;
                }
                case 67: {
                    int n = iDeserializer.getInt32();
                    this.p_DSISpeechRecReply.responseSetUnambiguousResultRange(n);
                    break;
                }
                case 96: {
                    int n = iDeserializer.getInt32();
                    int n11 = iDeserializer.getInt32();
                    this.p_DSISpeechRecReply.updateUnambiguousResultRange(n, n11);
                    break;
                }
                case 61: {
                    int n = iDeserializer.getInt32();
                    this.p_DSISpeechRecReply.responseSetFirstLevelSize(n);
                    break;
                }
                case 86: {
                    int n = iDeserializer.getInt32();
                    int n12 = iDeserializer.getInt32();
                    this.p_DSISpeechRecReply.updateFirstLevelSize(n, n12);
                    break;
                }
                case 72: {
                    int n = iDeserializer.getInt32();
                    this.p_DSISpeechRecReply.responseStartPostTraining(n);
                    break;
                }
                case 75: {
                    int n = iDeserializer.getInt32();
                    this.p_DSISpeechRecReply.responseStopPostTraining(n);
                    break;
                }
                case 57: {
                    int n = iDeserializer.getInt32();
                    int n13 = iDeserializer.getInt32();
                    this.p_DSISpeechRecReply.responseRequestSDSAvailability(n, n13);
                    break;
                }
                case 94: {
                    int n = iDeserializer.getInt32();
                    int n14 = iDeserializer.getInt32();
                    this.p_DSISpeechRecReply.updateSDSAvailability(n, n14);
                    break;
                }
                case 66: {
                    int n = iDeserializer.getInt32();
                    this.p_DSISpeechRecReply.responseSetSpellingMode(n);
                    break;
                }
                case 46: {
                    int n = iDeserializer.getInt32();
                    NBestList nBestList = NBestListSerializer.getOptionalNBestList(iDeserializer);
                    this.p_DSISpeechRecReply.responseDeleteLastSpellingBlock(n, nBestList);
                    break;
                }
                case 71: {
                    int n = iDeserializer.getInt32();
                    this.p_DSISpeechRecReply.responseStartDialogue(n);
                    break;
                }
                case 74: {
                    int n = iDeserializer.getInt32();
                    this.p_DSISpeechRecReply.responseStopDialogue(n);
                    break;
                }
                case 88: {
                    int n = iDeserializer.getInt32();
                    boolean bl = iDeserializer.getBool();
                    int n15 = iDeserializer.getInt32();
                    this.p_DSISpeechRecReply.updateGrammarStatus(n, bl, n15);
                    break;
                }
                case 112: {
                    GrammarStateInfo grammarStateInfo = GrammarStateInfoSerializer.getOptionalGrammarStateInfo(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSISpeechRecReply.updateGrammarState(grammarStateInfo, n);
                    break;
                }
                case 95: {
                    boolean bl = iDeserializer.getBool();
                    int n = iDeserializer.getInt32();
                    this.p_DSISpeechRecReply.updateTemporaryG2PLanguageChangeActive(bl, n);
                    break;
                }
                case 105: {
                    int n = iDeserializer.getInt32();
                    this.p_DSISpeechRecReply.responseCheckDbPartition(n);
                    break;
                }
                case 56: {
                    int n = iDeserializer.getInt32();
                    NBestList nBestList = NBestListSerializer.getOptionalNBestList(iDeserializer);
                    this.p_DSISpeechRecReply.responseRequestGraphemicGroupAsNBestList(n, nBestList);
                    break;
                }
                case 117: {
                    int n = iDeserializer.getInt32();
                    VDECapabilities vDECapabilities = VDECapabilitiesSerializer.getOptionalVDECapabilities(iDeserializer);
                    this.p_DSISpeechRecReply.responseRequestVDECapabilities(n, vDECapabilities);
                    break;
                }
                case 59: {
                    int n = iDeserializer.getInt32();
                    this.p_DSISpeechRecReply.responseRestoreFactorySettings(n);
                    break;
                }
                case 101: {
                    int n = iDeserializer.getInt32();
                    this.p_DSISpeechRecReply.responseSetDictionary(n);
                    break;
                }
                case 107: {
                    NBestList nBestList = NBestListSerializer.getOptionalNBestList(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSISpeechRecReply.updateNBestList(nBestList, n);
                    break;
                }
                case 109: {
                    int n = iDeserializer.getInt32();
                    this.p_DSISpeechRecReply.responseSetASRParameterConfiguration(n);
                    break;
                }
                case 111: {
                    int[] nArray = iDeserializer.getOptionalInt32VarArray();
                    int[] nArray2 = iDeserializer.getOptionalInt32VarArray();
                    int[] nArray3 = iDeserializer.getOptionalInt32VarArray();
                    int n = iDeserializer.getInt32();
                    this.p_DSISpeechRecReply.updateASRParameterConfiguration(nArray, nArray2, nArray3, n);
                    break;
                }
                case 116: {
                    int n = iDeserializer.getInt32();
                    NBestList nBestList = NBestListSerializer.getOptionalNBestList(iDeserializer);
                    this.p_DSISpeechRecReply.responseDeleteLastFlexVDEPart(n, nBestList);
                    break;
                }
                case 115: {
                    int n = iDeserializer.getInt32();
                    this.p_DSISpeechRecReply.responseClearFlexVDEHistory(n);
                    break;
                }
                case 118: {
                    int n = iDeserializer.getInt32();
                    int n16 = iDeserializer.getInt32();
                    this.p_DSISpeechRecReply.updateVDEMediumState(n, n16);
                    break;
                }
                case 119: {
                    String[] stringArray = iDeserializer.getOptionalStringVarArray();
                    int n = iDeserializer.getInt32();
                    this.p_DSISpeechRecReply.updateAvailableSLMLanguages(stringArray, n);
                    break;
                }
                case 121: {
                    String[] stringArray = iDeserializer.getOptionalStringVarArray();
                    int n = iDeserializer.getInt32();
                    this.p_DSISpeechRecReply.updateOnlineCapabilities(stringArray, n);
                    break;
                }
                case 44: {
                    int n = iDeserializer.getInt32();
                    String string = iDeserializer.getOptionalString();
                    int n17 = iDeserializer.getInt32();
                    this.p_DSISpeechRecReply.asyncException(n, string, n17);
                    break;
                }
                case 99: {
                    String string = iDeserializer.getOptionalString();
                    String string2 = iDeserializer.getOptionalString();
                    this.p_DSISpeechRecReply.yyIndication(string, string2);
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

