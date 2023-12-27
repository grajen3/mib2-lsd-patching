/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.asiainput;

import org.dsi.ifc.asiainput.UserDefinedEntry;
import org.dsi.ifc.asiainput.WordDatabase;

public interface DSIAsiaInputC {
    default public void initialize(int n) {
    }

    default public void addSymbol(char c2) {
    }

    default public void addSymbols(String string) {
    }

    default public void removeSymbol() {
    }

    default public void removeAllSymbols() {
    }

    default public void clear() {
    }

    default public void buildCandidates() {
    }

    default public void getSpelling() {
    }

    default public void getCandidates(int n) {
    }

    default public void selectCandidate(int n) {
    }

    default public void setBooleanParameter(int n, boolean bl) {
    }

    default public void setIntParameter(int n, int n2) {
    }

    default public void getBooleanParameter(int n) {
    }

    default public void getIntParameter(int n) {
    }

    default public void getVersionInfo() {
    }

    default public void setStringParameter(int n, String string) {
    }

    default public void getStringParameter(int n) {
    }

    default public void setPredictionContext(String string) {
    }

    default public void clearPredictionContext() {
    }

    default public void addUserDefinedEntry(UserDefinedEntry userDefinedEntry) {
    }

    default public void setAdditionalWordDatabases(WordDatabase[] wordDatabaseArray) {
    }

    default public void setUserDatabaseState(int n, int n2) {
    }

    default public void resetToFactorySettings() {
    }

    default public void getSegmentation(String string) {
    }

    default public void requestSegmentationForTruffles(String string) {
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

