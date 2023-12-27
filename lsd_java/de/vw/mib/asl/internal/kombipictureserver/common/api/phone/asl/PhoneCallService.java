/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.kombipictureserver.common.api.phone.asl;

import de.vw.mib.asl.internal.kombipictureserver.common.api.phone.asl.PhoneCallInfo;

public interface PhoneCallService {
    default public PhoneCallInfo[] getCallInfos() {
    }

    default public PhoneCallInfo[] getConferenceCallInfos() {
    }
}

