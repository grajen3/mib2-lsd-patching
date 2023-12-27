/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asia;

import de.vw.mib.asia.AsiaInputListener;
import org.dsi.ifc.asiainput.UserDefinedEntry;
import org.dsi.ifc.asiainput.WordDatabase;

public interface ASLAsiaInput {
    default public void addAsiaInputListener(AsiaInputListener asiaInputListener) {
    }

    default public void requestAddSymbol(char c2) {
    }

    default public void requestAddSymbols(String string) {
    }

    default public void requestAddUserDefinedEntry(UserDefinedEntry userDefinedEntry) {
    }

    default public void requestBuildCandidates() {
    }

    default public void requestClear() {
    }

    default public void requestClearPredictionContext() {
    }

    default public void requestGetBooleanParameter(int n) {
    }

    default public void requestGetCandidates(int n) {
    }

    default public void requestGetIntParameter(int n) {
    }

    default public void requestGetSegmentation(String string) {
    }

    default public void requestGetSpelling() {
    }

    default public void requestGetStringParameter(int n) {
    }

    default public void requestInitialize(int n) {
    }

    default public void requestRemoveAllSymbols() {
    }

    default public void removeAsiaInputListener() {
    }

    default public void requestRemoveSymbol() {
    }

    default public void requestSelectCandidate(int n) {
    }

    default public void requestSetAdditionalWordDatabases(WordDatabase[] wordDatabaseArray) {
    }

    default public void requestSetBooleanParameter(int n, boolean bl) {
    }

    default public void requestSetIntParameter(int n, int n2) {
    }

    default public void requestSetPredictionContext(String string) {
    }

    default public void requestSetStringParameter(int n, String string) {
    }

    default public void requestSetUserDatabaseState(int n, int n2) {
    }
}

