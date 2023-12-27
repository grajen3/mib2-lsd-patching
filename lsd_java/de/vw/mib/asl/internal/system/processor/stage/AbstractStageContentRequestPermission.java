/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.system.processor.stage;

import de.vw.mib.asl.api.system.ASLSystemFactory;

public abstract class AbstractStageContentRequestPermission {
    private String affectedContentId;
    private String refuseMessage;

    public AbstractStageContentRequestPermission(String string, String string2) {
        if (!ASLSystemFactory.getSystemApi().getContentIdValidator().isValid(string)) {
            throw new IllegalArgumentException(new StringBuffer().append("The provided content id ").append(string).append(" is invalid.").toString());
        }
        if (string2 == null || string2.equals("")) {
            throw new IllegalArgumentException("The provided refuse message must not be null or empty.");
        }
        this.affectedContentId = string;
        this.refuseMessage = string2;
    }

    public final boolean doIsGranted(String string) {
        if (!this.isAffected(string)) {
            return true;
        }
        return this.isGranted();
    }

    public final String getRefuseMessage() {
        return this.refuseMessage;
    }

    protected abstract boolean isGranted() {
    }

    private boolean isAffected(String string) {
        return this.affectedContentId.equals(string);
    }
}

