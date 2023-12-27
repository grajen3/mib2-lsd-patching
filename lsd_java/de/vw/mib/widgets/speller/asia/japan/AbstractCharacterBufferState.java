/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.widgets.speller.asia.japan;

import de.vw.mib.graphics.math.Util;
import de.vw.mib.util.StringBuilder;
import de.vw.mib.widgets.speller.asia.State;
import de.vw.mib.widgets.speller.asia.japan.JapanStateMachine;

abstract class AbstractCharacterBufferState
extends State {
    private static final int INITIAL_BUFFER_SIZE;
    private final StringBuilder characterBuffer = new StringBuilder(8);

    protected AbstractCharacterBufferState(JapanStateMachine japanStateMachine) {
        super(japanStateMachine);
    }

    protected final String getCharacters() {
        return this.getCharacters(this.characterBuffer);
    }

    protected final String getCharacters(int n) {
        return this.getCharacters(this.characterBuffer, n);
    }

    protected final String getCharacters(StringBuilder stringBuilder) {
        return stringBuilder.toString();
    }

    protected final String getCharacters(StringBuilder stringBuilder, int n) {
        return stringBuilder.substring(0, Util.clamp(n, 0, this.getNumberOfCharacters(stringBuilder)));
    }

    protected final String getCharacters(StringBuilder[] stringBuilderArray, int n, int n2) {
        StringBuilder stringBuilder = new StringBuilder(this.getNumberOfCharacters(stringBuilderArray));
        for (int i2 = 0; i2 < stringBuilderArray.length; ++i2) {
            stringBuilder.append(this.getCharacters(stringBuilderArray[i2]));
        }
        n = Util.clamp(n, 0, this.getNumberOfCharacters(stringBuilder));
        n2 = Util.clamp(n2, n, this.getNumberOfCharacters(stringBuilder));
        return stringBuilder.substring(n, n2);
    }

    protected final String getLastCharacter() {
        return this.getLastCharacter(this.characterBuffer);
    }

    protected final String getLastCharacter(StringBuilder stringBuilder) {
        try {
            return stringBuilder.substring(stringBuilder.length() - 1);
        }
        catch (IndexOutOfBoundsException indexOutOfBoundsException) {
            return "";
        }
    }

    protected final String getLastCharacter(StringBuilder stringBuilder, int n) {
        try {
            return stringBuilder.substring(n - 1, n);
        }
        catch (IndexOutOfBoundsException indexOutOfBoundsException) {
            return "";
        }
    }

    protected final int getNumberOfCharacters() {
        return this.getNumberOfCharacters(this.characterBuffer);
    }

    protected final int getNumberOfCharacters(StringBuilder stringBuilder) {
        return stringBuilder.length();
    }

    protected final int getNumberOfCharacters(StringBuilder stringBuilder, int n) {
        return this.getCharacters(stringBuilder, n).length();
    }

    protected final int getNumberOfCharacters(StringBuilder[] stringBuilderArray) {
        int n = 0;
        for (int i2 = stringBuilderArray.length - 1; i2 >= 0; --i2) {
            n += this.getNumberOfCharacters(stringBuilderArray[i2]);
        }
        return n;
    }

    protected final boolean hasCharacters() {
        String string = this.getCharacters();
        return string != null && !string.equals("");
    }

    protected final boolean hasCharacters(StringBuilder stringBuilder) {
        String string = this.getCharacters(stringBuilder);
        return string != null && !string.equals("");
    }

    protected final boolean hasCharacters(StringBuilder stringBuilder, int n) {
        String string = this.getCharacters(stringBuilder, n);
        return string != null && !string.equals("");
    }

    protected final void addCharacter(String string) {
        this.addCharacter(this.characterBuffer, string);
    }

    protected final void addCharacter(StringBuilder stringBuilder, String string) {
        stringBuilder.append(string);
    }

    protected final void addCharacter(char c2) {
        this.addCharacter(String.valueOf(c2));
    }

    protected final void addCharacter(StringBuilder stringBuilder, char c2) {
        this.addCharacter(stringBuilder, String.valueOf(c2));
    }

    protected final void clearCharacters() {
        this.clearCharacters(this.characterBuffer);
    }

    protected final void clearCharacters(StringBuilder stringBuilder) {
        stringBuilder.delete(0, stringBuilder.length());
    }

    protected final boolean deleteLastCharacter() {
        return this.deleteLastCharacter(this.characterBuffer);
    }

    protected final boolean deleteLastCharacter(StringBuilder stringBuilder) {
        try {
            stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        }
        catch (IndexOutOfBoundsException indexOutOfBoundsException) {
            return false;
        }
        return true;
    }

    protected final boolean deleteLastCharacter(StringBuilder stringBuilder, int n) {
        try {
            stringBuilder.deleteCharAt(n - 1);
        }
        catch (IndexOutOfBoundsException indexOutOfBoundsException) {
            return false;
        }
        return true;
    }

    protected final void insertCharacters(int n, String string) {
        this.insertCharacters(this.characterBuffer, n, string);
    }

    protected final void insertCharacters(StringBuilder stringBuilder, int n, String string) {
        stringBuilder.insert(n, string);
    }

    protected final void setCharacters(String string) {
        this.setCharacters(this.characterBuffer, string);
    }

    protected final void setCharacters(StringBuilder stringBuilder, String string) {
        stringBuilder.insert(0, string);
        stringBuilder.setLength(string.length());
    }
}

