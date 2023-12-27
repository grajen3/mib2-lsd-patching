/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.widgets.speller.asia;

import de.vw.mib.graphics.math.Util;
import de.vw.mib.util.StringBuilder;
import de.vw.mib.widgets.speller.asia.AsiaPhraseBuffer;
import de.vw.mib.widgets.speller.asia.AsiaSymbolBuffer;

public class DefaultAsiaPhraseSymbolBuffer
implements AsiaPhraseBuffer,
AsiaSymbolBuffer {
    private static final int INITIAL_BUFFER_SIZE;
    private StringBuilder phraseBuffer = new StringBuilder(128);
    private int phraseBufferCursorPosition;
    private int phraseBufferPredictionContextStart = this.phraseBufferCursorPosition = this.phraseBuffer.length();
    private StringBuilder symbolBuffer = new StringBuilder(128);

    public DefaultAsiaPhraseSymbolBuffer() {
        this(128);
    }

    protected DefaultAsiaPhraseSymbolBuffer(int n) {
    }

    @Override
    public void addPhrase(String string) {
        if (string != null && string.length() > 0) {
            this.phraseBuffer.insert(this.phraseBufferCursorPosition, string);
            this.phraseBufferCursorPosition += string.length();
            if (string.length() == 1 && Character.isSpaceChar(string.charAt(0))) {
                this.phraseBufferPredictionContextStart = this.phraseBufferCursorPosition;
            }
        }
    }

    @Override
    public int getCursorPosition() {
        return this.phraseBufferCursorPosition;
    }

    @Override
    public int getNumberOfPhrases() {
        return this.phraseBuffer.length();
    }

    @Override
    public String getPhrases() {
        return this.phraseBuffer.toString();
    }

    @Override
    public String getPredictionContext() {
        int n = this.phraseBufferPredictionContextStart;
        int n2 = Math.min(this.phraseBufferCursorPosition, this.phraseBuffer.length());
        return n <= n2 ? this.phraseBuffer.substring(n, n2) : "";
    }

    @Override
    public void removeAllPhrases() {
        this.phraseBuffer.clear();
        this.phraseBufferPredictionContextStart = this.phraseBufferCursorPosition = 0;
    }

    @Override
    public void removePhrase() {
        if (this.phraseBufferCursorPosition > 0) {
            this.phraseBufferCursorPosition = Util.clamp(this.phraseBufferCursorPosition - 1, 0, this.phraseBuffer.length() - 1);
            this.phraseBuffer.deleteCharAt(this.phraseBufferCursorPosition);
            if (this.phraseBufferCursorPosition < this.phraseBufferPredictionContextStart) {
                this.phraseBufferPredictionContextStart = this.phraseBufferCursorPosition;
            }
        }
    }

    @Override
    public void setCursorPosition(int n) {
        this.phraseBufferPredictionContextStart = this.phraseBufferCursorPosition = Util.clamp(n, 0, this.phraseBuffer.length());
    }

    @Override
    public void setPhrases(String string) {
        if (!this.phraseBuffer.toString().equals(string)) {
            int n;
            this.removeAllPhrases();
            if (string != null && (n = string.length()) > 0) {
                this.addPhrase(string);
                this.setCursorPosition(n);
            }
        }
    }

    @Override
    public void addSymbol(char c2) {
        this.symbolBuffer.append(c2);
        this.phraseBufferPredictionContextStart = this.phraseBufferCursorPosition;
    }

    @Override
    public void addSymbols(String string) {
        this.symbolBuffer.append(string);
        this.phraseBufferPredictionContextStart = this.phraseBufferCursorPosition;
    }

    @Override
    public int getNumberOfSymbols() {
        return this.symbolBuffer.length();
    }

    @Override
    public String getSymbols() {
        return this.symbolBuffer.toString();
    }

    @Override
    public void removeAllSymbols() {
        this.symbolBuffer.clear();
    }

    @Override
    public void removeSymbol() {
        if (this.symbolBuffer.length() > 0) {
            this.symbolBuffer.deleteCharAt(this.symbolBuffer.length() - 1);
        }
    }

    @Override
    public void setSymbols(String string) {
        if (!this.symbolBuffer.toString().equals(string)) {
            this.removeAllSymbols();
            if (string != null && string.length() > 0) {
                this.addSymbols(string);
            }
        }
    }
}

