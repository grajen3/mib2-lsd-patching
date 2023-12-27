/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asia;

public interface AsiaInputListener {
    default public void builtCandidates(int n) {
    }

    default public void indicateDataInvalidated(int n) {
    }

    default public void indicateErrorStatus(int n) {
    }

    default public void indicateTimeout() {
    }

    default public void initialized() {
    }

    default public void receivedBooleanParameter(int n, boolean bl) {
    }

    default public void receivedCandidates(String[] stringArray) {
    }

    default public void receivedIntParameter(int n, int n2) {
    }

    default public void receivedSegmentation(String string) {
    }

    default public void receivedSpelling(String string) {
    }

    default public void receivedStringParameter(int n, String string) {
    }

    default public void selectedCandidate(int n) {
    }

    default public void setAdditionalWordDatabasesResult() {
    }

    default public void setBooleanParameterResult(int n) {
    }

    default public void setIntParameterResult(int n) {
    }

    default public void setStringParameterResult(int n) {
    }

    default public void setUserDatabaseStateResult(int n, int n2) {
    }
}

