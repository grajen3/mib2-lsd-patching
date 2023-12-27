/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.speechrec;

import org.dsi.ifc.base.DSIBase;
import org.dsi.ifc.speechrec.DictionaryEntry;
import org.dsi.ifc.speechrec.Grammar;
import org.dsi.ifc.speechrec.GrammarInfo;

public interface DSISpeechRec
extends DSIBase {
    public static final String VERSION;
    public static final int ATTR_LANGUAGE;
    public static final int ATTR_AVAILABLELANGUAGES;
    public static final int ATTR_ABORTED;
    public static final int ATTR_FAILURE;
    public static final int ATTR_RECOGNIZERSTATE;
    public static final int ATTR_ABSOLUTECONFIDENCETHRESHOLD;
    public static final int ATTR_MAXCOMMANDNBESTLISTSIZE;
    public static final int ATTR_MAXSLOTNBESTLISTSIZE;
    public static final int ATTR_CONFIDENCEREJECTTHRESHOLD;
    public static final int ATTR_UTTERANCESTARTTIMEOUT;
    public static final int ATTR_RECOGNITIONTIMEOUT;
    public static final int ATTR_UNAMBIGUOUSRESULTTHRESHOLD;
    public static final int ATTR_UNAMBIGUOUSRESULTRANGE;
    public static final int ATTR_FIRSTLEVELSIZE;
    public static final int ATTR_SDSAVAILABILITY;
    public static final int ATTR_TEMPORARYG2PLANGUAGECHANGEACTIVE;
    public static final int ATTR_AVAILABLEPROFILES;
    public static final int ATTR_GRAMMARSTATUS;
    public static final int ATTR_GRAMMARSTATE;
    public static final int ATTR_NBESTLIST;
    public static final int ATTR_ASRPARAMETERCONFIGURATION;
    public static final int ATTR_VDEMEDIUMSTATE;
    public static final int ATTR_AVAILABLESLMLANGUAGES;
    public static final int ATTR_ONLINECAPABILITIES;
    public static final int RT_ABORT;
    public static final int RT_DELETEVOICETAG;
    public static final int RT_INIT;
    public static final int RT_INITVOICETAG;
    public static final int RT_LOADGRAMMAR;
    public static final int RT_PRELOADGRAMMAR;
    public static final int RT_RECORDVOICETAG;
    public static final int RT_SETLANGUAGE;
    public static final int RT_SHUTDOWN;
    public static final int RT_UNLOADGRAMMAR;
    public static final int RT_WAITFORRESULTS;
    public static final int RT_UNPRELOADGRAMMAR;
    public static final int RT_STARTRECOGNITION;
    public static final int RT_SETMAXCOMMANDNBESTLISTSIZE;
    public static final int RT_SETMAXSLOTNBESTLISTSIZE;
    public static final int RT_SETRECOGNITIONTIMEOUT;
    public static final int RT_SETUNAMBIGUOUSRESULTTHRESHOLD;
    public static final int RT_SETUNAMBIGUOUSRESULTRANGE;
    public static final int RT_SETFIRSTLEVELSIZE;
    public static final int RT_STARTPOSTTRAINING;
    public static final int RT_STOPPOSTTRAINING;
    public static final int RT_REQUESTSDSAVAILABILITY;
    public static final int RT_SETSPELLINGMODE;
    public static final int RT_DELETELASTSPELLINGBLOCK;
    public static final int RT_STARTDIALOGUE;
    public static final int RT_STOPDIALOGUE;
    public static final int RT_REQUESTGRAPHEMICGROUPASNBESTLIST;
    public static final int RT_GETVERSION;
    public static final int RT_REQUESTVDECAPABILITIES;
    public static final int RT_DELETEPROFILE;
    public static final int RT_LOADPROFILE;
    public static final int RT_UNLOADPROFILE;
    public static final int RT_REQUESTRESTOREFACTORYSETTINGS;
    public static final int RT_SETDICTIONARY;
    public static final int RT_REQUESTCHECKDBPARTITION;
    public static final int RT_ENABLECONTINUOUSUPDATE;
    public static final int RT_SETASRPARAMETERCONFIGURATION;
    public static final int RT_DELETELASTFLEXVDEPART;
    public static final int RT_CLEARFLEXVDEHISTORY;
    public static final int RP_RESPONSEABORT;
    public static final int RP_RESPONSEDELETEVOICETAG;
    public static final int RP_RESPONSEINIT;
    public static final int RP_RESPONSEINITVOICETAG;
    public static final int RP_RESPONSELOADGRAMMAR;
    public static final int RP_RESPONSEPRELOADGRAMMAR;
    public static final int RP_RESPONSERECORDVOICETAG;
    public static final int RP_RESPONSESETLANGUAGE;
    public static final int RP_RESPONSESHUTDOWN;
    public static final int RP_RESPONSESTARTRECOGNITION;
    public static final int RP_RESPONSEUNLOADGRAMMAR;
    public static final int RP_RESPONSEWAITFORRESULTS;
    public static final int RP_RESPONSEUNPRELOADGRAMMAR;
    public static final int RP_RESPONSESETMAXCOMMANDNBESTLISTSIZE;
    public static final int RP_RESPONSESETMAXSLOTNBESTLISTSIZE;
    public static final int RP_RESPONSESETCONFIDENCEREJECTTHRESHOLD;
    public static final int RP_RESPONSESETRECOGNITIONTIMEOUT;
    public static final int RP_RESPONSESETUTTERANCESTARTTIMEOUT;
    public static final int RP_RESPONSESETUNAMBIGUOUSRESULTTHRESHOLD;
    public static final int RP_RESPONSESETUNAMBIGUOUSRESULTRANGE;
    public static final int RP_RESPONSESETFIRSTLEVELSIZE;
    public static final int RP_RESPONSESTARTPOSTTRAINING;
    public static final int RP_RESPONSESTOPPOSTTRAINING;
    public static final int RP_RESPONSEREQUESTSDSAVAILABILITY;
    public static final int RP_RESPONSESETSPELLINGMODE;
    public static final int RP_RESPONSEDELETELASTSPELLINGBLOCK;
    public static final int RP_RESPONSESTARTDIALOGUE;
    public static final int RP_RESPONSESTOPDIALOGUE;
    public static final int RP_RESPONSEREQUESTGRAPHEMICGROUPASNBESTLIST;
    public static final int RP_RESPONSEGETVERSION;
    public static final int RP_RESPONSEREQUESTVDECAPABILITIES;
    public static final int RP_RESPONSEDELETEPROFILE;
    public static final int RP_RESPONSELOADPROFILE;
    public static final int RP_RESPONSEUNLOADPROFILE;
    public static final int RP_RESPONSERESTOREFACTORYSETTINGS;
    public static final int RP_RESPONSESETDICTIONARY;
    public static final int RP_RESPONSECHECKDBPARTITION;
    public static final int RP_RESPONSEENABLECONTINUOUSUPDATE;
    public static final int RP_RESPONSESETASRPARAMETERCONFIGURATION;
    public static final int RP_RESPONSEDELETELASTFLEXVDEPART;
    public static final int RP_RESPONSECLEARFLEXVDEHISTORY;
    public static final int CHECKRESULT_OK;
    public static final int CHECKRESULT_NOK;
    public static final int CHECKRESULT_UNKNOWN;
    public static final int CHECKRESULT_CUSTOMER_DL;
    public static final int RESPONSE_ABORTED;
    public static final int RESPONSE_ERROR;
    public static final int RESPONSE_ERROR_AUDIO_FAILURE;
    public static final int RESPONSE_ERROR_BUSY;
    public static final int RESPONSE_ERROR_EMPTY_GRAMMAR;
    public static final int RESPONSE_ERROR_ILLEGAL_GRAMMAR;
    public static final int RESPONSE_ERROR_ILLEGAL_GRAMMAR_TYPE;
    public static final int RESPONSE_ERROR_ILLEGAL_LANGUAGE;
    public static final int RESPONSE_ERROR_ILLEGAL_VOICETAG;
    public static final int RESPONSE_ERROR_NO_GRAMMAR;
    public static final int RESPONSE_ERROR_NO_INIT;
    public static final int RESPONSE_ERROR_NO_LANGUAGE;
    public static final int RESPONSE_ERROR_NO_VOICETAGS;
    public static final int RESPONSE_ERROR_NO_OPERATION_PENDING;
    public static final int RESPONSE_ERROR_NO_POSTTRAINING;
    public static final int RESPONSE_ERROR_NO_POSTTRAINING_STARTED;
    public static final int RESPONSE_ERROR_NO_RECOGNITION_STARTED;
    public static final int RESPONSE_ERROR_OOM;
    public static final int RESPONSE_ERROR_OPERATION_NOT_ABORTABLE;
    public static final int RESPONSE_ERROR_SR_ENGINE_FAILURE;
    public static final int RESPONSE_OK;
    public static final int RESPONSE_WARNING_RECOMMEND_REPEAT;
    public static final int RESPONSE_TIMEOUT;
    public static final int RESPONSE_UTTERANCE_TOO_LOUD;
    public static final int RESPONSE_UTTERANCE_TOO_WEAK;
    public static final int RESPONSE_SIGNAL_TO_NOISE_RATIO_TOO_LOW;
    public static final int RESPONSE_NO_RECOGNITION_RESULT;
    public static final int RESPONSE_CONFIDENCE_TOO_LOW;
    public static final int RESPONSE_VOICETAG_TOO_LONG;
    public static final int RESPONSE_VOICETAG_TOO_SHORT;
    public static final int RESPONSE_VOICETAG_SIMILAR_VT_FOUND;
    public static final int RESPONSE_ERROR_GRAMMARS_PARTLY_NOT_LOADED;
    public static final int RESPONSE_ERROR_GRAMMARS_PARTLY_NOT_UNLOADED;
    public static final int RESPONSE_ERROR_ILLEGAL_SKIN_ID;
    public static final int RESPONSE_ERROR_NO_LAST_NBESTLIST;
    public static final int RESPONSE_ERROR_NOT_IN_SPELLING_MODE;
    public static final int RESPONSE_ERROR_NO_NAV_AVAILABLE;
    public static final int RESPONSE_ERROR_PROFILE_ID_INVALID;
    public static final int RESPONSE_ALL_RECOGNITIONRESULTS_FILTERED_OUT;
    public static final int RESPONSE_ERROR_NOT_IN_FLEX_VDE_MODE;
    public static final int RESPONSE_FLEX_VDE_RESULT_UNCHANGED;
    public static final int DICTIONARYTYPE_COMMON;
    public static final int DICTIONARYTYPE_ONLINE;
    public static final int GRAMMARTYPE_INVALID;
    public static final int GRAMMARTYPE_SRGS_GRAMMAR_STRING;
    public static final int GRAMMARTYPE_LIST_WORD_LIST;
    public static final int GRAMMARTYPE_LIST_ID_REF_LIST;
    public static final int GRAMMARTYPE_PRECOMPILED_ID;
    public static final int GRAMMARTYPE_LIST_SPELLING;
    public static final int GRAMMARTYPE_LAST_NBESTLIST;
    public static final int GRAMMARTYPE_LAST_NBESTLIST_WITH_GRAPHEMIC_GROUP;
    public static final int GRAMMARTYPE_LIST_COMBINED_WORD_ID_LIST;
    public static final int GRAMMARTYPE_LIST_COMBINED_WORD_PHONEME_LIST;
    public static final int GRAMMARID_UNDEFINED;
    public static final int LAST_NBESTLIST;
    public static final int SKINID_1;
    public static final int SKINID_2;
    public static final int SKINID_3;
    public static final int SDSSTATE_IDLE;
    public static final int SDSSTATE_VOICETAG_RECORDING;
    public static final int SDSSTATE_RECOGNIZING;
    public static final int SDSSTATE_RECOGNIZING_FINISHED;
    public static final int SDSSTATE_UTTERANCE_STARTED;
    public static final int SDSSTATE_UTTERANCE_FINISHED;
    public static final int SDSSTATE_ABORTED;
    public static final int SDSSTATE_TIMEOUT;
    public static final int COMMANDHIERARCHY_NONE;
    public static final int COMMANDHIERARCHY_GLOBAL;
    public static final int COMMANDHIERARCHY_GLOBAL_MEDIA;
    public static final int COMMANDHIERARCHY_ACTIVE_CONTEXT;
    public static final int COMMANDHIERARCHY_NLU;
    public static final int COMMANDHIERARCHY_UNIVERSAL;
    public static final int COMMANDHIERARCHY_SWYS;
    public static final int COMMANDHIERARCHY_DIALOGUE;
    public static final int OFFLINERECOGNITIONMODE_DISABLED;
    public static final int OFFLINERECOGNITIONMODE_RECORD;
    public static final int OFFLINERECOGNITIONMODE_PLAYBACK;
    public static final int SDSAVAILABILITY_NOT_BUILT_IN;
    public static final int SDSAVAILABILITY_INACTIVE;
    public static final int SDSAVAILABILITY_ACTIVE;
    public static final int STARTTONE_NONE;
    public static final int STARTTONE_RECOGNIZER_READY_TONE;
    public static final int STARTTONE_RECOGNIZER_DIALOGUE_START_TONE;
    public static final int ENDTONE_NONE;
    public static final int ENDTONE_UTTERANCE_FINISHED;
    public static final int SPELLINGMODE_INACTIVE;
    public static final int SPELLINGMODE_ACTIVE;
    public static final int SPELLINGMODE_PAUSED;
    public static final int GRAMMARCONTENT_ADDRESS_BOOK;
    public static final int GRAMMARCONTENT_MEDIA;
    public static final int GRAMMARCONTENT_ADDRESS_BOOK_WITH_TEL_NO;
    public static final int GRAMMARCONTENT_ADDRESS_BOOK_WITH_LOCATION;
    public static final int GRAMMARCONTENT_ADDRESS_BOOK_WITH_LOCATION_PUBLIC;
    public static final int GRAMMARCONTENT_ADDRESS_BOOK_WITH_LOCATION_PRIVATE;
    public static final int GRAMMARCONTENT_ADDRESS_BOOK_WITH_LOCATION_FAVORITES;
    public static final int GRAMMARCONTENT_ADDRESS_BOOK_WITH_MAIL;
    public static final int GRAMMARCONTENT_CALLSTACKS_ALL;
    public static final int GRAMMARCONTENT_CALLSTACKS_INCOMING;
    public static final int GRAMMARCONTENT_CALLSTACKS_OUTGOING;
    public static final int GRAMMARCONTENT_CALLSTACKS_MISSED;
    public static final int RECTMT_BARGEIN_START;
    public static final int RECTMT_BARGEIN_FINISH;
    public static final int RECTMT_REGULAR_NORMAL;
    public static final int RECTMT_REGULAR_LONG;
    public static final int RECTMT_REGULAR_PROLONG;
    public static final int GRAMMARSTATUS_AVAILABLE;
    public static final int GRAMMARSTATUS_COMPILING;
    public static final int GRAMMARSTATUS_UNAVAILABLE;
    public static final int GRAMMARSTATUS_PARTIAL_COMPILATION_FAILURE;
    public static final int GRAMMARSTATUS_COMPILATION_FAILURE;
    public static final int ASRPARAMETER_GARBAGE;
    public static final int ASRPARAMETER_AUDIOSOURCE_TIMEOUT;
    public static final int ASRPARAMETER_TIMEOUT_LSILENCE;
    public static final int ASRPARAMETER_TIMEOUT_SPEECH;
    public static final int ASRPARAMETER_TSILENCE;
    public static final int ASRPARAMETER_FIRSTPASS_DISTAPPROX;
    public static final int ASRPARAMETER_EXTRA_EVENT_ENABLE;
    public static final int ASRPARAMETER_CTX_TSILENCE_FX;
    public static final int ASRPARAMETER_CTX_TSILENCE;
    public static final int ASRPARAMETER_CTX_MAXNBEST;
    public static final int ASRPARAMETER_CTX_MAXNBEST_SECONDPASS;
    public static final int ASRPARAMETER_CTX_ACCURACY;
    public static final int ASRPARAMETER_CTX_INIT_BEAMWIDTH;
    public static final int ASRPARAMETER_CTX_WORDPENALTY;
    public static final int VDEMEDIUMSTATE_UNAVAILABLE;
    public static final int VDEMEDIUMSTATE_AVAILABLE;
    public static final int VDEMEDIUMSTATE_ERROR;

    default public void abort() {
    }

    default public void deleteProfile(int n) {
    }

    default public void deleteVoiceTag(int n) {
    }

    default public void enableContinuousUpdate(boolean bl) {
    }

    default public void getVersion() {
    }

    default public void init() {
    }

    default public void initVoiceTag(int n) {
    }

    default public void loadGrammar(Grammar[] grammarArray) {
    }

    default public void loadProfile(int n) {
    }

    default public void preloadGrammar(Grammar[] grammarArray) {
    }

    default public void recordVoiceTag() {
    }

    default public void setLanguage(String string, int n) {
    }

    default public void shutdown() {
    }

    default public void startRecognition(int n, int n2, int n3) {
    }

    default public void unloadGrammar(GrammarInfo[] grammarInfoArray) {
    }

    default public void unloadProfile(int n) {
    }

    default public void unpreloadGrammar(GrammarInfo[] grammarInfoArray) {
    }

    default public void waitForResults() {
    }

    default public void setMaxCommandNBestListSize(int n) {
    }

    default public void setMaxSlotNBestListSize(int n) {
    }

    default public void setRecognitionTimeout(int n) {
    }

    default public void setUnambiguousResultThreshold(int n) {
    }

    default public void setUnambiguousResultRange(int n) {
    }

    default public void setFirstLevelSize(int n) {
    }

    default public void startPostTraining(int n) {
    }

    default public void stopPostTraining() {
    }

    default public void requestSDSAvailability() {
    }

    default public void setSpellingMode(int n) {
    }

    default public void deleteLastSpellingBlock() {
    }

    default public void startDialogue() {
    }

    default public void stopDialogue() {
    }

    default public void requestCheckDbPartition() {
    }

    default public void requestGraphemicGroupAsNBestList(int n) {
    }

    default public void requestVDECapabilities(String string) {
    }

    default public void requestRestoreFactorySettings() {
    }

    default public void setDictionary(int n, String string, String string2, DictionaryEntry[] dictionaryEntryArray) {
    }

    default public void setASRParameterConfiguration(int[] nArray, int[] nArray2, int[] nArray3) {
    }

    default public void deleteLastFlexVDEPart() {
    }

    default public void clearFlexVDEHistory() {
    }
}

