/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.util.api.impl;

import de.vw.mib.asl.api.navigation.util.ISpellerDataHelper;
import de.vw.mib.asl.internal.navigation.util.SpellerDataHelper;
import de.vw.mib.properties.values.SpellerData;

public class ISpellerDataHelperImpl
implements ISpellerDataHelper {
    @Override
    public void deleteChar(SpellerData spellerData) {
        SpellerDataHelper.deleteChar(spellerData);
    }

    @Override
    public void addChar(SpellerData spellerData, String string) {
        SpellerDataHelper.addChar(spellerData, string);
    }

    @Override
    public void selectAll(SpellerData spellerData) {
        SpellerDataHelper.selectAll(spellerData);
    }

    @Override
    public void deselectAll(SpellerData spellerData) {
        SpellerDataHelper.deselectAll(spellerData);
    }

    @Override
    public void clear(SpellerData spellerData) {
        SpellerDataHelper.clear(spellerData);
    }
}

