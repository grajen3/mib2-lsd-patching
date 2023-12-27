/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.api.system.content;

import de.vw.mib.asl.api.system.ASLSystemFactory;

public abstract class AbstractStageContentRequest {
    private String contentId;

    public AbstractStageContentRequest(String string) {
        if (!ASLSystemFactory.getSystemApi().getContentIdValidator().isValid(string)) {
            throw new IllegalArgumentException(new StringBuffer().append("The provided content id ").append(string).append(" is invalid.").toString());
        }
        this.contentId = string;
    }

    public final String getContentId() {
        return this.contentId;
    }

    public abstract void onSuccess() {
    }

    public abstract void onFailure() {
    }
}

