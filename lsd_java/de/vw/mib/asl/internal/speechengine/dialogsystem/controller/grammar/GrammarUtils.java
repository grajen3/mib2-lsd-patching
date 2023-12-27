/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechengine.dialogsystem.controller.grammar;

public final class GrammarUtils {
    private GrammarUtils() {
    }

    public static int commandModeToGrammarHierarchy(int n) {
        switch (n) {
            case 0: {
                return 5;
            }
            case 3: {
                return 7;
            }
            case 1: 
            case 2: {
                return 1;
            }
        }
        return 0;
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

