/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.api.media;

import de.vw.mib.asl.api.media.AlphabeticalScrollBarInfo;
import org.dsi.ifc.global.CharacterInfo;

public interface ASLMediaAPI {
    default public int convertHASSourceIdToAslDeviceId(int n) {
    }

    default public int getASLDeviceIdForDSIDiagnoseSystemId(int n) {
    }

    default public boolean isASLDeviceIdForDSIDiagnoseSystemIdAvailable(int n) {
    }

    default public boolean isASLDeviceIdForSpeechAvailable(int n) {
    }

    default public AlphabeticalScrollBarInfo convertCharacterInfo(CharacterInfo[] characterInfoArray) {
    }
}

