/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.util.tracing.util;

public class ThreadCache$Info {
    public final int id;
    public final String entityName;
    public String msgPrefix;
    public String threadName;

    public ThreadCache$Info(int n, String string) {
        this.id = n;
        this.entityName = string;
    }
}

