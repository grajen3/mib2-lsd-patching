/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.system.transformer;

public class LanguageUpdateDataCollector {
    public String language;
    public boolean additionalSpellerFlag;

    public LanguageUpdateDataCollector() {
        this.language = "";
        this.additionalSpellerFlag = false;
    }

    public LanguageUpdateDataCollector(String string, boolean bl) {
        this.language = string;
        this.additionalSpellerFlag = bl;
    }
}

