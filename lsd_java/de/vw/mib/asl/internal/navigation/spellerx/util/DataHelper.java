/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.spellerx.util;

import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.properties.values.SpellerData;

public final class DataHelper {
    private DataHelper() {
    }

    public static SpellerData setSpellerDataInput(SpellerData spellerData, String string) {
        if (null == string) {
            ServiceManager.logger.warn(16384, "character is null -> skip");
            return spellerData;
        }
        String string2 = string;
        spellerData.setCursorPosition(string2.length());
        spellerData.setEnteredText(string2);
        return spellerData;
    }

    public static SpellerData makeEmptySpellerData() {
        SpellerData spellerData = new SpellerData();
        return spellerData;
    }
}

