/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.asiainput;

public interface DSIAsiaInputReply {
    public static final String IPL_COMM_UUID;
    public static final String IPL_COMM_INTERFACE_KEY;
    public static final String IPL_COMM_INTERFACE_VERSION;
    public static final String IPL_COMM_MODULE_VERSION;

    default public void initialized(int n) {
    }

    default public void getVersionInfo(String string, String string2) {
    }

    default public void builtCandidates(int n) {
    }

    default public void getSpelling(String string) {
    }

    default public void getCandidates(String[] stringArray) {
    }

    default public void selectedCandidate(int n, int n2) {
    }

    default public void indicateErrorStatus(int n) {
    }

    default public void indicateDataInvalidated(int n) {
    }

    default public void getIntParameter(int n, int n2) {
    }

    default public void getBooleanParameter(int n, boolean bl) {
    }

    default public void setIntParameterResult(int n, int n2, int n3) {
    }

    default public void setBooleanParameterResult(int n, boolean bl, int n2) {
    }

    default public void setStringParameterResult(int n, String string, int n2) {
    }

    default public void getStringParameter(int n, String string) {
    }

    default public void setAdditionalWordDatabasesResult(int n) {
    }

    default public void setUserDatabaseStateResult(int n, int n2, int n3) {
    }

    default public void resetToFactorySettingsResult(int n) {
    }

    default public void getSegmentation(String string) {
    }

    default public void responseSegmentationForTruffles(String string) {
    }

    default public void asyncException(int n, String string, int n2) {
    }

    default public void yyIndication(String string, String string2) {
    }
}

