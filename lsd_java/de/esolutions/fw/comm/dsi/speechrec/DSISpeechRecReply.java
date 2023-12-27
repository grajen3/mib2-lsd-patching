/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.speechrec;

import org.dsi.ifc.speechrec.GrammarInfo;
import org.dsi.ifc.speechrec.GrammarStateInfo;
import org.dsi.ifc.speechrec.NBestList;
import org.dsi.ifc.speechrec.VDECapabilities;

public interface DSISpeechRecReply {
    public static final String IPL_COMM_UUID;
    public static final String IPL_COMM_INTERFACE_KEY;
    public static final String IPL_COMM_INTERFACE_VERSION;
    public static final String IPL_COMM_MODULE_VERSION;

    default public void responseAbort(int n) {
    }

    default public void responseDeleteProfile(int n) {
    }

    default public void responseDeleteVoiceTag(int n) {
    }

    default public void responseEnableContinuousUpdate(int n) {
    }

    default public void responseGetVersion(String string) {
    }

    default public void responseInit(int n) {
    }

    default public void responseInitVoiceTag(int n) {
    }

    default public void responseLoadGrammar(int n, GrammarInfo[] grammarInfoArray) {
    }

    default public void responseLoadProfile(int n) {
    }

    default public void responsePreloadGrammar(int n, GrammarInfo[] grammarInfoArray) {
    }

    default public void responseRecordVoiceTag(int n) {
    }

    default public void responseSetLanguage(int n) {
    }

    default public void responseShutdown(int n) {
    }

    default public void responseStartRecognition(int n) {
    }

    default public void responseUnloadGrammar(int n, GrammarInfo[] grammarInfoArray) {
    }

    default public void responseUnloadProfile(int n) {
    }

    default public void responseUnpreloadGrammar(int n, GrammarInfo[] grammarInfoArray) {
    }

    default public void responseWaitForResults(int n, NBestList nBestList) {
    }

    default public void updateAborted(boolean bl, int n) {
    }

    default public void updateAvailableLanguages(String[] stringArray, int n) {
    }

    default public void updateAvailableProfiles(int[] nArray, int n) {
    }

    default public void updateFailure(boolean bl, int n) {
    }

    default public void updateLanguage(String string, int n, int n2) {
    }

    default public void updateRecognizerState(int n, int n2) {
    }

    default public void updateAbsoluteConfidenceThreshold(int n, int n2) {
    }

    default public void responseSetMaxCommandNBestListSize(int n) {
    }

    default public void updateMaxCommandNBestListSize(int n, int n2) {
    }

    default public void responseSetMaxSlotNBestListSize(int n) {
    }

    default public void updateMaxSlotNBestListSize(int n, int n2) {
    }

    default public void responseSetConfidenceRejectThreshold(int n) {
    }

    default public void updateConfidenceRejectThreshold(int n, int n2) {
    }

    default public void responseSetUtteranceStartTimeout(int n) {
    }

    default public void updateUtteranceStartTimeout(int n, int n2) {
    }

    default public void responseSetRecognitionTimeout(int n) {
    }

    default public void updateRecognitionTimeout(int n, int n2) {
    }

    default public void responseSetUnambiguousResultThreshold(int n) {
    }

    default public void updateUnambiguousResultThreshold(int n, int n2) {
    }

    default public void responseSetUnambiguousResultRange(int n) {
    }

    default public void updateUnambiguousResultRange(int n, int n2) {
    }

    default public void responseSetFirstLevelSize(int n) {
    }

    default public void updateFirstLevelSize(int n, int n2) {
    }

    default public void responseStartPostTraining(int n) {
    }

    default public void responseStopPostTraining(int n) {
    }

    default public void responseRequestSDSAvailability(int n, int n2) {
    }

    default public void updateSDSAvailability(int n, int n2) {
    }

    default public void responseSetSpellingMode(int n) {
    }

    default public void responseDeleteLastSpellingBlock(int n, NBestList nBestList) {
    }

    default public void responseStartDialogue(int n) {
    }

    default public void responseStopDialogue(int n) {
    }

    default public void updateGrammarStatus(int n, boolean bl, int n2) {
    }

    default public void updateGrammarState(GrammarStateInfo grammarStateInfo, int n) {
    }

    default public void updateTemporaryG2PLanguageChangeActive(boolean bl, int n) {
    }

    default public void responseCheckDbPartition(int n) {
    }

    default public void responseRequestGraphemicGroupAsNBestList(int n, NBestList nBestList) {
    }

    default public void responseRequestVDECapabilities(int n, VDECapabilities vDECapabilities) {
    }

    default public void responseRestoreFactorySettings(int n) {
    }

    default public void responseSetDictionary(int n) {
    }

    default public void updateNBestList(NBestList nBestList, int n) {
    }

    default public void responseSetASRParameterConfiguration(int n) {
    }

    default public void updateASRParameterConfiguration(int[] nArray, int[] nArray2, int[] nArray3, int n) {
    }

    default public void responseDeleteLastFlexVDEPart(int n, NBestList nBestList) {
    }

    default public void responseClearFlexVDEHistory(int n) {
    }

    default public void updateVDEMediumState(int n, int n2) {
    }

    default public void updateAvailableSLMLanguages(String[] stringArray, int n) {
    }

    default public void updateOnlineCapabilities(String[] stringArray, int n) {
    }

    default public void asyncException(int n, String string, int n2) {
    }

    default public void yyIndication(String string, String string2) {
    }
}

