/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.api.messages.services.detail;

import de.vw.mib.asl.api.messages.services.detail.MessageKey;
import de.vw.mib.asl.api.messages.services.detail.MessageResponse;

public interface MessageDetailService {
    default public void requestMessage(int n, String string, MessageResponse messageResponse) {
    }

    default public void requestMessage(MessageKey messageKey, MessageResponse messageResponse) {
    }
}

