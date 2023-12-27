/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.api.navigation.util;

public interface IDebugFlags {
    default public boolean getAPIDebugFlag(int n) {
    }

    default public void setAPIDebugFlag(int n, boolean bl) {
    }

    default public void setASLDebugFlag(String string, boolean bl) {
    }

    default public boolean getASLDebugFlag(String string) {
    }

    default public void initNavDebugFlags() {
    }
}

