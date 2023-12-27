/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asia;

public interface AsiaListener {
    default public void asiaBuiltCandidates(int n) {
    }

    default public void asiaInitialized() {
    }

    default public void asiaReceivedBooleanParameter(int n, boolean bl) {
    }

    default public void asiaReceivedCandidates(String[] stringArray) {
    }

    default public void asiaReceivedErrorStatus(int n) {
    }

    default public void asiaReceivedIntParameter(int n, int n2) {
    }

    default public void asiaReceivedSegmentation(String string) {
    }

    default public void asiaReceivedSpelling(String string) {
    }

    default public void asiaReceivedStringParameter(int n, String string) {
    }

    default public void asiaReceivedTimeout() {
    }

    default public void asiaSelectedCandidate(int n) {
    }

    default public void asiaSetAdditionalWordDatabases() {
    }

    default public void asiaSetAdditionalWordDatabases(int n) {
    }

    default public void asiaSetBooleanParameter(int n) {
    }

    default public void asiaSetIntParameter(int n) {
    }

    default public void asiaSetStringParameter(int n) {
    }

    default public void asiaSetUserDatabaseState(int n, int n2) {
    }

    default public void asiaSetUserDatabaseState(int n, int n2, int n3) {
    }

    default public void asiaResponseSegmentationForTruffles(String string) {
    }
}

