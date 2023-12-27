/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.api.media;

public final class AlphabeticalScrollBarInfo {
    private final String[] characters;
    private final int[] indices;

    public AlphabeticalScrollBarInfo() {
        this.characters = new String[0];
        this.indices = new int[0];
    }

    public AlphabeticalScrollBarInfo(String[] stringArray, int[] nArray) {
        this.characters = stringArray;
        this.indices = nArray;
    }

    public String[] getCharacters() {
        return this.characters;
    }

    public int[] getIndices() {
        return this.indices;
    }
}

