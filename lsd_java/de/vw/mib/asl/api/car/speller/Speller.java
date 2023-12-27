/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.api.car.speller;

import de.vw.mib.asl.api.car.speller.SpellerDelegate;

public interface Speller {
    default public void setCursorPosition(int n) {
    }

    default public void deleteCharacterBlock() {
    }

    default public void deleteCharacter() {
    }

    default public void addCharacter(String string) {
    }

    default public void addCharacter(String string, int n, int n2, int n3) {
    }

    default public void addCharacterBlock(String string) {
    }

    default public void deleteAllCharacters() {
    }

    default public int getSpellerId() {
    }

    default public String getEnteredText() {
    }

    default public void setEnteredText(String string) {
    }

    default public void setSupportsSpellerBlocks(boolean bl) {
    }

    default public boolean getSupportsSpellerBlocks() {
    }

    default public void setDelegate(SpellerDelegate spellerDelegate) {
    }

    default public SpellerDelegate getSpellerDelegate() {
    }
}

