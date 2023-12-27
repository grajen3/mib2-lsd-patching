/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechengine.dialogsystem.util;

public class Mappings$Audio {
    public static int getAudioConnectionByPromptType(int n) {
        int n2 = 112;
        switch (n) {
            case 5: {
                n2 = 83;
                break;
            }
            case 0: {
                n2 = 112;
                break;
            }
            case 2: {
                n2 = 126;
                break;
            }
            case 4: {
                n2 = 86;
                break;
            }
            case 6: {
                n2 = 118;
                break;
            }
            case 1: {
                n2 = 114;
                break;
            }
            default: {
                n2 = -1;
            }
        }
        return n2;
    }

    public static short getSourceIdByPromptType(int n) {
        short s = -1;
        switch (n) {
            case 5: {
                s = 41;
                break;
            }
            case 4: {
                s = 51;
                break;
            }
            case 0: {
                s = 1;
                break;
            }
            case 2: {
                s = 21;
                break;
            }
            case 6: {
                s = 31;
                break;
            }
            case 1: {
                s = 21;
                break;
            }
            case 7: {
                s = -1;
                break;
            }
            default: {
                s = -1;
            }
        }
        return s;
    }
}

