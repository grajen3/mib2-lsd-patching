/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.exboxm.state;

import de.vw.mib.asl.api.exboxm.guidance.ExboxGuidanceListener;
import de.vw.mib.asl.api.exboxm.guidance.GuidanceState;
import de.vw.mib.asl.internal.exboxm.state.ExboxOperationStateListener;
import de.vw.mib.asl.internal.exboxm.state.ExboxSpeechListener;

public interface ExboxStateService {
    default public void addExboxOperationStateListener(ExboxOperationStateListener exboxOperationStateListener) {
    }

    default public boolean isExboxOperationStateNormal() {
    }

    default public GuidanceState getExboxGuidanceState() {
    }

    default public void setGuidanceListener(ExboxGuidanceListener exboxGuidanceListener) {
    }

    default public void setSpeechListener(ExboxSpeechListener exboxSpeechListener) {
    }

    default public void setSmartphoneGuidanceState(GuidanceState guidanceState) {
    }

    default public void removeOperationStateListener(ExboxOperationStateListener exboxOperationStateListener) {
    }
}

