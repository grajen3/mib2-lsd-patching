/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.speechrec;

import org.dsi.ifc.speechrec.DictionaryEntry;
import org.dsi.ifc.speechrec.Grammar;
import org.dsi.ifc.speechrec.GrammarInfo;

public interface DSISpeechRecC {
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

    default public void setNotification(int[] nArray) {
    }

    default public void setNotification(int n) {
    }

    default public void setNotification() {
    }

    default public void clearNotification(int[] nArray) {
    }

    default public void clearNotification(int n) {
    }

    default public void clearNotification() {
    }

    default public void yySet(String string, String string2) {
    }
}

