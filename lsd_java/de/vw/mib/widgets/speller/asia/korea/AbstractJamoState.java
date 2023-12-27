/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.widgets.speller.asia.korea;

import de.vw.mib.widgets.speller.asia.State;
import de.vw.mib.widgets.speller.asia.korea.Jamo;
import de.vw.mib.widgets.speller.asia.korea.KoreaStateMachine;

abstract class AbstractJamoState
extends State {
    protected AbstractJamoState(KoreaStateMachine koreaStateMachine) {
        super(koreaStateMachine);
    }

    @Override
    public String toString() {
        return new StringBuffer().append("AbstractJamo[").append(super.toString()).append("]").toString();
    }

    @Override
    public final boolean keyPressed() {
        String string;
        String string2 = this.stateContext.getLastEnteredCharacter();
        String string3 = this.getWidget().get_spellerData() != null && this.getWidget().get_spellerData().getEnteredText() != null ? this.getWidget().get_spellerData().getEnteredText() : "";
        int n = this.getWidget().get_spellerData() != null ? this.getWidget().get_spellerData().getCursorPosition() : 0;
        String string4 = string = string3.length() > 0 && n > 0 ? string3.substring(Math.min(n - 1, string3.length()), Math.min(n, string3.length())) : "";
        if (Jamo.isCompatibilityJamo(string2)) {
            String string5 = "";
            String string6 = "";
            boolean bl = false;
            if (string3.length() <= 0 && n <= 0) {
                string5 = Jamo.asJamos(string2);
                string6 = string5.substring(Math.max(0, string5.length() - string2.length()));
            }
            if (string.length() > 0 && Jamo.isJamos(string)) {
                char c2;
                char c3 = Jamo.asCompatibilityJamo(string.charAt(0));
                if (Jamo.isCombinedCompatibilityJamoAvailable(c3, c2 = string2.charAt(0))) {
                    char c4 = Jamo.getCombinedCompatibilityJamo(c3, c2);
                    string5 = Jamo.asJamos(string3.substring(0, Math.max(0, n - string.length())).concat(String.valueOf(c4)));
                    string6 = string5.substring(Math.max(0, string5.length() - 1));
                    n -= string6.length();
                    bl = true;
                } else {
                    string5 = Jamo.asJamos(string3.substring(0, n).concat(string2));
                    string6 = string5.substring(Math.max(0, string5.length() - string2.length()));
                }
            } else {
                string6 = Jamo.asJamos(string2);
            }
            this.onCompatibilityJamoPressed(string, string2, bl, string6, n);
            return true;
        }
        if (Character.isSpaceChar(string2.charAt(0))) {
            return this.onSpacePressed(string, string2, n) ? true : super.keyPressed();
        }
        return this.onOtherKeyPressed(string, string2, n) ? true : super.keyPressed();
    }

    protected void onCompatibilityJamoPressed(String string, String string2, boolean bl, String string3, int n) {
    }

    protected boolean onOtherKeyPressed(String string, String string2, int n) {
        return false;
    }

    protected boolean onSpacePressed(String string, String string2, int n) {
        return false;
    }
}

