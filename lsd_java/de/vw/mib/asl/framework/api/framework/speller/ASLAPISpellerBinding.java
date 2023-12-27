/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.framework.api.framework.speller;

import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.properties.values.SpellerData;

public interface ASLAPISpellerBinding {
    default public boolean handleEvent(EventGeneric eventGeneric) {
    }

    default public void resetSpellerData() {
    }

    default public void initSpeller(String string) {
    }

    default public SpellerData getSpellerData() {
    }

    default public void setAvailableCharacters(String string) {
    }

    default public void setMatchCount(int n) {
    }
}

