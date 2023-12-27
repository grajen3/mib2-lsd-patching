/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.widgets.speller.asia.japan;

import de.vw.mib.graphics.math.Util;
import de.vw.mib.widgets.speller.asia.State;
import de.vw.mib.widgets.speller.asia.japan.JapanStateMachine;

class LatinState
extends State {
    public LatinState(JapanStateMachine japanStateMachine) {
        super(japanStateMachine);
    }

    @Override
    public boolean cursorLeftPressed() {
        int n = this.speller.getSelectionStart();
        int n2 = this.speller.getSelectionEnd();
        String string = this.speller.getEnteredText();
        int n3 = this.speller.getCursorPosition();
        n3 = this.speller.isSelectionDefined() && n3 == n2 ? Util.clamp(n, 0, string.length()) : Util.clamp(n3 - 1, 0, string.length());
        this.fireSpellerEvent("cursorPositionChanged", "", n3, n, n2);
        return true;
    }

    @Override
    public boolean cursorPositionChanged(int n) {
        return true;
    }

    @Override
    public boolean cursorRightPressed() {
        int n = this.speller.getSelectionStart();
        int n2 = this.speller.getSelectionEnd();
        String string = this.speller.getEnteredText();
        int n3 = this.speller.getCursorPosition();
        n3 = this.speller.isSelectionDefined() && n3 == n2 ? Util.clamp(n2, 0, string.length()) : Util.clamp(n3 + 1, 0, string.length());
        this.fireSpellerEvent("cursorPositionChanged", "", n3, n, n2);
        return true;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private void disableCapitalization() {
        if (!this.speller.isMode(256)) {
            this.speller.disablePropertyChanged();
            try {
                this.speller.set_mode(this.speller.get_mode() | 0x100);
            }
            finally {
                this.speller.enablePropertyChanged();
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private void enableCapitalization() {
        if (this.speller.isMode(256)) {
            this.speller.disablePropertyChanged();
            try {
                this.speller.set_mode(this.speller.get_mode() ^ 0x100);
            }
            finally {
                this.speller.enablePropertyChanged();
            }
        }
    }

    @Override
    public void onEnterState(State state) {
        super.onEnterState(state);
        this.disableCapitalization();
    }

    @Override
    public void onLeaveState(State state) {
        this.enableCapitalization();
        super.onLeaveState(state);
    }

    @Override
    public String toString() {
        return "Latin";
    }
}

