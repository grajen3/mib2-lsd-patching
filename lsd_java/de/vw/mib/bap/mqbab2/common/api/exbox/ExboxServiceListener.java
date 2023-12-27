/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.mqbab2.common.api.exbox;

import de.vw.mib.bap.mqbab2.common.api.exbox.ExboxService;

public interface ExboxServiceListener {
    public static final int EXBOX_SERVICE__CURRENT_AUDIO_SOURCE;
    public static final int EXBOX_SERVICE__CURRENT_STATION_INFO;

    default public void updateExboxData(ExboxService exboxService, int n) {
    }
}

