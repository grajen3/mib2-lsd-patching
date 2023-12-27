/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.widgets.speller.asia.handler;

import de.vw.mib.util.StringBuilder;
import de.vw.mib.widgets.models.AsiaSpellerModel;
import de.vw.mib.widgets.speller.asia.AsiaDatabase;
import de.vw.mib.widgets.speller.asia.AsiaDatabaseState;
import de.vw.mib.widgets.speller.asia.handler.TransferSymbolsUnconvertedHandler;

public class CursorPositionHandler
extends TransferSymbolsUnconvertedHandler {
    public static final int DIRECTION_NONE;
    public static final int DIRECTION_LEFT;
    public static final int DIRECTION_UP;
    public static final int DIRECTION_RIGHT;
    public static final int DIRECTION_DOWN;
    public static final int POSITION_NONE;
    private int direction;
    private int position;

    public CursorPositionHandler() {
        this.onReset();
    }

    public final void setDirection(int n) {
        if (this.isPosition() && !this.isDirection(n, 1)) {
            this.position = -1;
        }
        this.direction = n;
    }

    public final void setPosition(int n) {
        this.position = n;
        if (!this.isDirection(1)) {
            this.direction = 1;
        }
    }

    protected final boolean isDirection(int n) {
        return this.isDirection(this.direction, n);
    }

    protected final boolean isDirection(int n, int n2) {
        return (n & n2) == n2;
    }

    protected final boolean isPosition() {
        return this.isDirection(1) && this.position > -1;
    }

    @Override
    protected void onReset() {
        super.onReset();
        this.setDirection(1);
        this.setPosition(-1);
    }

    @Override
    protected void onStateSuccessfullyReceived(AsiaDatabaseState asiaDatabaseState, AsiaDatabase asiaDatabase) {
        AsiaSpellerModel asiaSpellerModel = this.getState().getWidget();
        int n = asiaDatabaseState.getCursorPosition();
        if (!asiaDatabaseState.hasSpelling()) {
            boolean bl = asiaSpellerModel.isSelectionDefined();
            int n2 = n;
            if (!bl) {
                if (this.isDirection(2)) {
                    n2 = Math.max(0, n2 - 1);
                } else if (this.isDirection(8)) {
                    n2 = Math.min(asiaDatabaseState.getNumberOfPhrases(), n2 + 1);
                } else if (this.isPosition()) {
                    n2 = this.position;
                }
                if (n2 != n) {
                    asiaDatabase.setCursorPosition(n2);
                    this.fireSpellerEvent("cursorPositionChanged", "", n2, n2, n2);
                }
            } else {
                boolean bl2;
                String string = asiaSpellerModel.getEnteredText();
                boolean bl3 = bl2 = string.length() > 0;
                if (bl2) {
                    n2 = this.isDirection(8) ? asiaSpellerModel.getSelectionEnd() : (this.isDirection(2) ? asiaSpellerModel.getSelectionStart() : (this.isPosition() ? this.position : 0));
                    asiaDatabase.setPhrases(string);
                    asiaDatabase.setCursorPosition(n2);
                    this.fireSpellerEvent("cursorPositionChanged", "", n2, n2, n2);
                }
            }
        } else {
            int n3;
            int n4 = n;
            boolean bl = false;
            boolean bl4 = false;
            if (this.isDirection(2)) {
                bl4 = true;
                bl = true;
            } else if (this.isDirection(8)) {
                n4 = n + asiaDatabaseState.getNumberOfSpelling();
                bl = true;
            } else if (this.isPosition() && (n3 = n + asiaDatabaseState.getNumberOfSpelling()) != this.position) {
                n4 = this.position;
                bl = true;
                boolean bl5 = bl4 = n4 == n;
            }
            if (bl) {
                super.onStateSuccessfullyReceived(asiaDatabaseState, asiaDatabase);
            }
            if (bl4 || n4 != n) {
                asiaDatabase.setCursorPosition(n4);
                this.fireSpellerEvent("cursorPositionChanged", "", n4, n4, n4);
            }
        }
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder(super.toString());
        if (this.isPosition()) {
            stringBuilder.append("[position=").append(this.position).append("]");
        } else {
            stringBuilder.append("[direction=").append(this.direction).append("]");
        }
        return stringBuilder.toString();
    }
}

