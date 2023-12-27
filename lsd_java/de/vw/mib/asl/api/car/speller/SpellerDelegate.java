/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.api.car.speller;

import de.vw.mib.asl.api.car.speller.Speller;

public interface SpellerDelegate {
    default public void enteredTextChanged(Speller speller, String string) {
    }
}

