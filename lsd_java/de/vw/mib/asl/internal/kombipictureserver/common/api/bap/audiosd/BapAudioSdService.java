/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.kombipictureserver.common.api.bap.audiosd;

import de.vw.mib.asl.internal.kombipictureserver.common.api.bap.audiosd.BapAudioSdActiveSource;
import de.vw.mib.asl.internal.kombipictureserver.common.api.bap.audiosd.BapAudioSdCurrentStationHandle;

public interface BapAudioSdService {
    default public BapAudioSdActiveSource getActiveSource() {
    }

    default public BapAudioSdCurrentStationHandle getCurrentStationHandle() {
    }
}

