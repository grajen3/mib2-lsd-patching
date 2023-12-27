/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechengine.dialogsystem.dialog;

public final class AbstractDialog$ErrorCode {
    private final String name;
    public static final AbstractDialog$ErrorCode NO_ERROR = new AbstractDialog$ErrorCode("NO_ERROR");
    public static final AbstractDialog$ErrorCode ERROR_AUDIO = new AbstractDialog$ErrorCode("ERROR_AUDIO");
    public static final AbstractDialog$ErrorCode ERROR_KILLED = new AbstractDialog$ErrorCode("ERROR_KILLED");

    private AbstractDialog$ErrorCode(String string) {
        this.name = string;
    }

    public String toString() {
        return this.name;
    }
}

