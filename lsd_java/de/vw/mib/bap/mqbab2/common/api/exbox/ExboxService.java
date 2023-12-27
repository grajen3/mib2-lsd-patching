/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.mqbab2.common.api.exbox;

import de.vw.mib.bap.mqbab2.common.api.exbox.ExboxServiceListener;
import de.vw.mib.bap.mqbab2.common.api.exbox.datatypes.ExboxCurrentStationInfo;

public interface ExboxService {
    public static final int EXBOX_SERVICE__CURRENT_AUDIO_SOURCE__NO_SOURCE_ACTIVE;
    public static final int EXBOX_SERVICE__CURRENT_AUDIO_SOURCE__DIGITAL_MULTIMEDIA_BROADCASTING;
    public static final int EXBOX_SERVICE__CURRENT_AUDIO_SOURCE__BLUETOOTH_STREAM;
    public static final int EXBOX_SERVICE__CURRENT_AUDIO_SOURCE__BLUETOOTH_REMOTE_CONTROL_PROTOCOL;

    default public void addExboxServiceListener(ExboxServiceListener exboxServiceListener, int[] nArray) {
    }

    default public void removeExboxServiceListener(ExboxServiceListener exboxServiceListener, int[] nArray) {
    }

    default public int getExboxActiveSource() {
    }

    default public ExboxCurrentStationInfo getExboxCurrentStationInfo() {
    }
}

