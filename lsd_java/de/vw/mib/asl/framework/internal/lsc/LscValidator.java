/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.framework.internal.lsc;

import de.vw.mib.asl.framework.internal.lsc.LanguageHelper;

public class LscValidator {
    boolean isInvalidSkinIdInPersistableData(int n) {
        return n < 1;
    }

    boolean isInvalidLanguageInPersistableData(int n) {
        return n < 0 || n > LanguageHelper.getNumberOfLanguages();
    }
}

