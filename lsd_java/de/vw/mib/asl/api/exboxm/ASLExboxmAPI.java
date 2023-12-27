/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.api.exboxm;

import de.vw.mib.asl.api.exboxm.audioinformation.ExboxAudioInformationService;
import de.vw.mib.asl.api.exboxm.guidance.ExboxGuidanceManager;

public interface ASLExboxmAPI {
    default public ExboxAudioInformationService getAudioInformationService() {
    }

    default public ExboxGuidanceManager getExboxGuidanceManager() {
    }
}

