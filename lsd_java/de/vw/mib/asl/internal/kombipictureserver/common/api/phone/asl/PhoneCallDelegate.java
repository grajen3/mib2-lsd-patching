/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.kombipictureserver.common.api.phone.asl;

import de.vw.mib.asl.internal.kombipictureserver.common.api.phone.asl.PhoneCallService;

public interface PhoneCallDelegate {
    public static final int PHONE_CALL_INFOS;
    public static final int PHONE_CALL_CONFERENCE_INFOS;
    public static final int[] PHONE_CALL_PROPERTIES;

    default public void updatePhonceCall(PhoneCallService phoneCallService, int n) {
    }

    static {
        PHONE_CALL_PROPERTIES = new int[]{1158, 1160};
    }
}

