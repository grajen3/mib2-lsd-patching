/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.framework.internal.diagnosis.config;

import de.vw.mib.asl.framework.internal.diagnosis.config.AccessImpl;

public abstract class AccessLanguage
extends AccessImpl {
    protected static final int LANGUAGE_LENGTH;

    public AccessLanguage(byte[] byArray, int[] nArray, int n, long l) {
        super(byArray, nArray, n, l);
    }

    public boolean isValidLanguage(byte[] byArray) {
        if (byArray == null) {
            return false;
        }
        if (byArray.length != 5) {
            return false;
        }
        if (97 > byArray[0] || byArray[0] > 122) {
            return false;
        }
        if (97 > byArray[1] || byArray[1] > 122) {
            return false;
        }
        if (byArray[2] != 95) {
            return false;
        }
        if (65 > byArray[3] || byArray[3] > 90) {
            return false;
        }
        return 65 <= byArray[4] && byArray[4] <= 90;
    }
}

