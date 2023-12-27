/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechengine.dialogmanager.featurehandler.internal;

public final class CommandUtils {
    private CommandUtils() {
    }

    public static int grammarHierarchyToCommandMode(int n) {
        switch (n) {
            case 5: {
                return 0;
            }
            case 7: {
                return 3;
            }
            case 1: {
                return 1;
            }
        }
        return -1;
    }
}

