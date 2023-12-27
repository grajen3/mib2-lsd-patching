/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.speller.internal;

import de.vw.mib.properties.values.SpellerData;
import de.vw.mib.speller.SpellerEngine;
import de.vw.mib.speller.SpellerEngineListener;
import de.vw.mib.util.StringUtil;

public class SpellerEngineImpl
implements SpellerEngine {
    private final SpellerData upSpellerData = new SpellerData();
    private final SpellerData mySpellerData = new SpellerData();
    private final SpellerEngineListener upListener;
    private boolean upDirty;
    private boolean downDirty;
    private int config;

    SpellerEngineImpl(int n, SpellerEngineListener spellerEngineListener) {
        this.config = n;
        this.upListener = spellerEngineListener;
    }

    @Override
    public void cursorCharLeft() {
        if (this.isSupportCursorActive()) {
            int n;
            int n2 = this.mySpellerData.getCursorPosition();
            if (this.isSelectionActive()) {
                n = this.mySpellerData.getSelectionStart();
                this.resetSelection();
            } else {
                n = n2 - 1;
            }
            if (0 <= n && n2 != n) {
                this.mySpellerData.setCursorPosition(n);
                this.markDirty();
            }
        }
    }

    @Override
    public void cursorCharRight() {
        if (this.isSupportCursorActive()) {
            int n;
            int n2 = this.mySpellerData.getEnteredText().length();
            int n3 = this.mySpellerData.getCursorPosition();
            if (this.isSelectionActive()) {
                n = this.mySpellerData.getSelectionEnd();
                this.resetSelection();
            } else {
                n = n3 + 1;
            }
            if (n <= n2 && n != n3) {
                this.mySpellerData.setCursorPosition(n);
                this.markDirty();
            }
        }
    }

    @Override
    public void setCursor(int n) {
        if (this.isSupportCursorActive()) {
            int n2 = this.mySpellerData.getEnteredText().length();
            int n3 = this.mySpellerData.getCursorPosition();
            if (n != n3 && 0 <= n && n <= n2) {
                this.mySpellerData.setCursorPosition(n);
                this.markDirty();
            }
        }
    }

    @Override
    public void setSelection(int n, int n2) {
        int n3 = this.mySpellerData.getSelectionStart();
        int n4 = this.mySpellerData.getSelectionEnd();
        int n5 = this.mySpellerData.getEnteredText().length();
        if ((n = SpellerEngineImpl.clamp(n, 0, n5)) == (n2 = SpellerEngineImpl.clamp(n2, 0, n5))) {
            n2 = -1;
            n = -1;
        }
        if (n3 != n || n4 != n2) {
            this.mySpellerData.setSelectionStart(n);
            this.mySpellerData.setSelectionEnd(n2);
            this.markDirty();
        }
    }

    @Override
    public void resetSelection() {
        if (this.isSelectionActive()) {
            this.mySpellerData.resetSelection();
            this.markDirty();
        }
    }

    @Override
    public void insertText(String string) {
        int n;
        int n2;
        string = StringUtil.replaceNullByEmptyString(string);
        int n3 = string.length();
        if (this.isSelectionActive() && this.isReplaceSelectedActive()) {
            n2 = this.mySpellerData.getSelectionStart();
            n = this.mySpellerData.getSelectionEnd();
        } else if (0 < n3) {
            n2 = n = this.mySpellerData.getCursorPosition();
        } else {
            n = -1;
            n2 = -1;
        }
        if (-1 < n2) {
            String string2 = this.mySpellerData.getEnteredText();
            string2 = new StringBuffer().append(string2.substring(0, n2)).append(string).append(string2.substring(n)).toString();
            this.mySpellerData.setEnteredText(string2);
            if (this.isSupportCursorActive()) {
                this.mySpellerData.setCursorPosition(n2 + n3);
            } else {
                this.mySpellerData.setCursorPosition(string2.length());
            }
            if (this.isSelectInsertedActive()) {
                this.setSelection(n2, n2 + n3);
            } else {
                this.resetSelection();
            }
            this.markDirty();
        }
    }

    @Override
    public void deleteCharLeft() {
        int n;
        int n2;
        if (this.isSelectionActive()) {
            n2 = this.mySpellerData.getSelectionStart();
            n = this.mySpellerData.getSelectionEnd();
        } else {
            n = this.mySpellerData.getCursorPosition();
            n2 = n - 1;
        }
        if (-1 < n2) {
            String string = this.mySpellerData.getEnteredText();
            string = new StringBuffer().append(string.substring(0, n2)).append(string.substring(n)).toString();
            this.mySpellerData.setEnteredText(string);
            if (this.isSupportCursorActive()) {
                this.mySpellerData.setCursorPosition(n2);
            } else {
                this.mySpellerData.setCursorPosition(string.length());
            }
            this.resetSelection();
            this.markDirty();
        }
    }

    @Override
    public int getConfiguration() {
        return this.config;
    }

    @Override
    public void setConfiguration(int n) {
        this.config = n;
    }

    @Override
    public SpellerData getSpellerData() {
        if (this.upDirty) {
            this.upSpellerData.copyFrom(this.mySpellerData);
            this.upDirty = false;
        }
        return this.upSpellerData;
    }

    @Override
    public boolean isDataPending() {
        return this.upDirty;
    }

    private boolean isReplaceSelectedActive() {
        return 0 != (this.config & 1);
    }

    private boolean isSelectInsertedActive() {
        return 0 != (this.config & 2);
    }

    private boolean isSupportCursorActive() {
        return 0 != (this.config & 8);
    }

    private boolean isSelectionActive() {
        return this.mySpellerData.isSelectionActive();
    }

    private void markDirty() {
        if (!this.upDirty) {
            this.upDirty = true;
            this.notifyUp();
        }
        if (!this.downDirty) {
            this.downDirty = true;
            this.notifyDown();
        }
    }

    private void notifyUp() {
        this.upListener.notifySpellerDataChanged(this);
    }

    private void notifyDown() {
    }

    private static int clamp(int n, int n2, int n3) {
        n = Math.min(n, n3);
        n = Math.max(n, n2);
        return n;
    }
}

