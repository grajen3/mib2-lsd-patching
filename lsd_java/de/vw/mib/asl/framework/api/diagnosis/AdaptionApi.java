/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.framework.api.diagnosis;

import de.vw.mib.asl.framework.api.diagnosis.AdaptionResponse;

public interface AdaptionApi {
    public static final int SLOT_CONTEXT_OBJ;
    public static final int SLOT_NAMESPACE_INT;
    public static final int SLOT_KEY_LONG;

    default public void requestConfigManagerPersCarFuncAdap(int n, int n2) {
    }

    default public void requestCarFuncAdap(AdaptionResponse adaptionResponse) {
    }

    default public void requestConfigManagerPersCarFuncListBap(int n, int n2) {
    }

    default public void requestCarFuncListBap(AdaptionResponse adaptionResponse) {
    }

    default public void requestConfigManagerPersCarFuncListCan(int n, int n2) {
    }

    default public void requestCarFuncListCan(AdaptionResponse adaptionResponse) {
    }

    default public void requestConfigManagerPersCoding(int n, int n2) {
    }

    default public void requestCoding(AdaptionResponse adaptionResponse) {
    }

    default public void requestConfigManagerVirtualCamPos(int n, int n2) {
    }

    default public void requestVirtualCamPos(AdaptionResponse adaptionResponse) {
    }

    default public void requestConfigManagerHmiFuncBlockTbl(int n, int n2) {
    }

    default public void requestHmiFuncBlockTbl(AdaptionResponse adaptionResponse) {
    }

    default public void requestConfigManagerPersAdaptation(int n, int n2) {
    }

    default public void requestAdaptation(AdaptionResponse adaptionResponse) {
    }

    default public void requestConfigManagerPersLoadSpeedThreshold(int n, int n2) {
    }

    default public void requestLoadSpeedThreshold(AdaptionResponse adaptionResponse) {
    }

    default public void requestConfigManagerPersLoadSystemLanguages(int n, int n2) {
    }

    default public void requestLoadSystemLanguages(AdaptionResponse adaptionResponse) {
    }

    default public void requestConfigManagerPersLoadFurtherData(int n, int n2) {
    }

    default public void requestLoadFurtherData(AdaptionResponse adaptionResponse) {
    }

    default public void requestConfigManagerPersLoadEcoHmi(int n, int n2) {
    }

    default public void requestEcoHmi(AdaptionResponse adaptionResponse) {
    }

    default public void requestConfigManagerPersIdentification(int n, int n2) {
    }

    default public void requestIdentification(AdaptionResponse adaptionResponse) {
    }

    default public void requestConfigManagerPersInformation(int n, int n2) {
    }

    default public void requestInformation(AdaptionResponse adaptionResponse) {
    }

    default public void requestConfigManagerPersLoadInCarCommunication(int n, int n2) {
    }

    default public void requestInCarCommunication(AdaptionResponse adaptionResponse) {
    }

    default public void requestConfigManagerPersLoadDashboardDisplayConfig(int n, int n2) {
    }

    default public void requestDashboardDisplayConfig(AdaptionResponse adaptionResponse) {
    }

    default public void requestConfigManagerPersRegionCode(int n, int n2) {
    }

    default public void requestRegionCode(AdaptionResponse adaptionResponse) {
    }

    default public void requestAdaptationLate(AdaptionResponse adaptionResponse) {
    }
}

