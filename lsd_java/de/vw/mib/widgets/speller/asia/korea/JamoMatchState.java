/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.widgets.speller.asia.korea;

import de.vw.mib.properties.values.SpellerData;
import de.vw.mib.util.StringBuilder;
import de.vw.mib.widgets.log.SpellerLogger;
import de.vw.mib.widgets.speller.asia.State;
import de.vw.mib.widgets.speller.asia.korea.AbstractJamoState;
import de.vw.mib.widgets.speller.asia.korea.Jamo;
import de.vw.mib.widgets.speller.asia.korea.KoreaStateMachine;
import edu.emory.mathcs.backport.java.util.ArrayDeque;

final class JamoMatchState
extends AbstractJamoState {
    private ArrayDeque combinableCompatibilityJamosQueue;
    private int cursorPositionOnDeleted;
    private int cursorPositionOnKeyPressed;
    private String lastCombinableCompatibilityJamos;
    private boolean lastJamoSimulated;
    private String initialAvailableCharacters;
    private String initialEnteredText;
    private boolean involveCombinableCompatibiltyJamos;
    private boolean reselectCombinableJamos;

    public JamoMatchState(KoreaStateMachine koreaStateMachine) {
        super(koreaStateMachine);
    }

    @Override
    public String toString() {
        return new StringBuffer().append("JamoMatch[").append(super.toString()).append("]").toString();
    }

    @Override
    public boolean deleted() {
        if (!this.combinableCompatibilityJamosQueue.isEmpty()) {
            this.combinableCompatibilityJamosQueue.clear();
            if (this.lastCombinableCompatibilityJamos != null) {
                this.combinableCompatibilityJamosQueue.add(this.lastCombinableCompatibilityJamos);
                this.lastCombinableCompatibilityJamos = null;
                this.reselectCombinableJamos = true;
                this.cursorPositionOnDeleted = this.getWidget().get_spellerData() != null ? this.getWidget().get_spellerData().getCursorPosition() : 0;
            }
        }
        boolean bl = this.involveCombinableCompatibiltyJamos = !this.combinableCompatibilityJamosQueue.isEmpty();
        if (this.lastJamoSimulated) {
            this.getWidget().updateInputField(this.initialEnteredText, "", this.initialEnteredText.length());
            this.updateSpellerButtons(this.initialEnteredText, this.initialAvailableCharacters);
            this.lastJamoSimulated = false;
            return true;
        }
        return super.deleted();
    }

    private void fillCombinableCompatibilityJamosQueue(String string, String string2) {
        this.fillCombinableCompatibilityJamosQueue(string, null, string2);
    }

    private void fillCombinableCompatibilityJamosQueue(String string, StringBuilder stringBuilder) {
        this.fillCombinableCompatibilityJamosQueue(string, stringBuilder, null);
    }

    private void fillCombinableCompatibilityJamosQueue(String string, StringBuilder stringBuilder, String string2) {
        String string3;
        StringBuilder stringBuilder2 = new StringBuilder(string.length());
        for (int i2 = string.length() - 1; i2 >= 0; --i2) {
            String string4;
            char c2 = string.charAt(i2);
            if (!Jamo.isCombinedJamo(c2)) continue;
            String string5 = Jamo.getSingleCompatibilityJamos(c2);
            String string6 = String.valueOf(string5.charAt(0));
            if (string2 != null && string2.length() != 0 && !string2.equals(string6)) continue;
            if (stringBuilder != null && stringBuilder.length() > 0) {
                string4 = Jamo.asJamos(string6);
                if (stringBuilder.indexOf(string4) < 0) {
                    stringBuilder.replace(i2, i2 + string4.length(), string4);
                } else {
                    stringBuilder.deleteCharAt(i2);
                }
            }
            if (stringBuilder2.indexOf(string4 = String.valueOf(string5.charAt(1))) >= 0) continue;
            stringBuilder2.append(string4);
        }
        if (stringBuilder2.length() > 0 && !this.combinableCompatibilityJamosQueue.contains(string3 = stringBuilder2.toString())) {
            this.combinableCompatibilityJamosQueue.add(string3);
        }
    }

    private void disambiguateOrSimulateJamoPressed(String string, String string2, String string3, boolean bl, int n) {
        String string4 = this.getWidget().get_spellerData() != null ? this.getWidget().get_spellerData().getAvailableCharacters() : "";
        char c2 = string3.charAt(0);
        char c3 = string2.charAt(0);
        String string5 = String.valueOf(Jamo.isLeadConsonant(c2) ? Jamo.asJamo(c3, 1) : (Jamo.isVowel(c2) ? c2 : Jamo.asJamo(c3, 0)));
        if (this.initialAvailableCharacters != null && this.initialAvailableCharacters.indexOf(string5) >= 0) {
            if (this.involveCombinableCompatibiltyJamos) {
                this.handleCombinableJamos(string5);
                this.fireSpellerEvent("keyPressed", string, n, 0, 0);
            } else {
                this.handleCombinableJamos(string5);
            }
            if (bl) {
                this.fireSpellerEvent("keyPressed", string5, n + 1, 0, 0);
            } else {
                this.fireSpellerEvent("keyPressed", string5, n, 0, 0);
            }
        } else if (string4 != null && string4.indexOf(string2) >= 0) {
            String string6 = this.getWidget().get_spellerData() != null ? this.getWidget().get_spellerData().getEnteredText() : "";
            string6 = string6.concat(string3);
            this.handleCombinableJamos(string2);
            this.getWidget().updateInputField(string6, "", string6.length());
            this.updateSpellerButtons(string6, "");
            this.lastJamoSimulated = true;
        } else {
            this.stateContext.warn(SpellerLogger.getLogger()).append("Neither '").append(string3).append("' nor the disambiguated '").append(string5).append("' are part of the next valid characters! [nvc='").append(this.initialAvailableCharacters).append("']").log();
        }
    }

    private void handleCombinableJamos() {
        this.handleCombinableJamos(true);
    }

    private void handleCombinableJamos(boolean bl) {
        this.handleCombinableJamos(null, bl);
    }

    private void handleCombinableJamos(String string) {
        this.handleCombinableJamos(string, true);
    }

    private void handleCombinableJamos(String string, boolean bl) {
        if (string != null && string.length() > 0 && !this.combinableCompatibilityJamosQueue.isEmpty()) {
            this.combinableCompatibilityJamosQueue.pollLast();
            this.fillCombinableCompatibilityJamosQueue(this.initialAvailableCharacters, string);
        }
        if (!this.combinableCompatibilityJamosQueue.isEmpty()) {
            if (this.involveCombinableCompatibiltyJamos) {
                if (bl) {
                    this.lastCombinableCompatibilityJamos = (String)this.combinableCompatibilityJamosQueue.poll();
                } else {
                    this.combinableCompatibilityJamosQueue.poll();
                }
                this.involveCombinableCompatibiltyJamos = !this.combinableCompatibilityJamosQueue.isEmpty();
            } else {
                this.involveCombinableCompatibiltyJamos = true;
            }
        } else if (this.involveCombinableCompatibiltyJamos) {
            this.involveCombinableCompatibiltyJamos = false;
            this.lastCombinableCompatibilityJamos = null;
        }
    }

    @Override
    protected void onCompatibilityJamoPressed(String string, String string2, boolean bl, String string3, int n) {
        this.cursorPositionOnKeyPressed = n + string3.length();
        if (bl) {
            if (!this.combinableCompatibilityJamosQueue.isEmpty() && ((String)this.combinableCompatibilityJamosQueue.peek()).indexOf(string2) >= 0) {
                this.handleCombinableJamos(string2, false);
                this.fireSpellerEvent("keyPressed", string3, n, 0, 0);
            } else if (this.initialAvailableCharacters != null && this.initialAvailableCharacters.indexOf(string3) >= 0) {
                this.handleCombinableJamos();
                this.fireSpellerEvent("keyPressed", string3, n, 0, 0);
            } else {
                this.disambiguateOrSimulateJamoPressed(string, string2, string3, bl, n);
            }
        } else if (this.initialAvailableCharacters != null && this.initialAvailableCharacters.indexOf(string3) >= 0) {
            if (this.combinableCompatibilityJamosQueue.isEmpty()) {
                if (this.involveCombinableCompatibiltyJamos) {
                    this.fireSpellerEvent("keyPressed", string, n, 0, 0);
                }
                this.fireSpellerEvent("keyPressed", string3, n, 0, 0);
            } else {
                if (this.involveCombinableCompatibiltyJamos) {
                    this.handleCombinableJamos(string2);
                    this.fireSpellerEvent("keyPressed", string, n, 0, 0);
                } else {
                    this.handleCombinableJamos(string2);
                }
                if (this.combinableCompatibilityJamosQueue.isEmpty()) {
                    this.fireSpellerEvent("keyPressed", string3, n, 0, 0);
                } else {
                    this.fireSpellerEvent("keyPressed", string3, n, n, n + string3.length());
                }
            }
        } else if (this.initialAvailableCharacters != null && this.initialAvailableCharacters.indexOf(string2) >= 0) {
            this.handleCombinableJamos(string2);
            this.fireSpellerEvent("keyPressed", string2, n, 0, 0);
        } else {
            this.disambiguateOrSimulateJamoPressed(string, string2, string3, bl, n);
        }
    }

    @Override
    public void onEnterState(State state) {
        this.initialAvailableCharacters = this.getWidget().get_spellerData() != null ? this.getWidget().get_spellerData().getAvailableCharacters() : "";
        String string = this.initialEnteredText = this.getWidget().get_spellerData() != null ? this.getWidget().get_spellerData().getEnteredText() : "";
        if (this.combinableCompatibilityJamosQueue == null) {
            this.combinableCompatibilityJamosQueue = new ArrayDeque();
        } else if (!this.combinableCompatibilityJamosQueue.isEmpty()) {
            this.combinableCompatibilityJamosQueue.clear();
        }
        this.involveCombinableCompatibiltyJamos = false;
        this.lastCombinableCompatibilityJamos = null;
        this.cursorPositionOnDeleted = 0;
        this.cursorPositionOnKeyPressed = 0;
        this.reselectCombinableJamos = false;
        this.lastJamoSimulated = false;
        this.updateSpellerButtons(this.initialEnteredText);
    }

    @Override
    public void onLeaveState(State state) {
        if (this.initialEnteredText != null) {
            this.getWidget().updateInputField(this.initialEnteredText, "", this.initialEnteredText.length());
            this.initialEnteredText = null;
        }
        if (this.initialAvailableCharacters != null) {
            this.getWidget().updateSpellerButtons(this.initialAvailableCharacters, "");
            this.initialAvailableCharacters = null;
        }
        if (this.combinableCompatibilityJamosQueue != null && !this.combinableCompatibilityJamosQueue.isEmpty()) {
            this.combinableCompatibilityJamosQueue.clear();
        }
    }

    @Override
    protected boolean onOtherKeyPressed(String string, String string2, int n) {
        if (!this.combinableCompatibilityJamosQueue.isEmpty()) {
            if (this.involveCombinableCompatibiltyJamos) {
                this.fireSpellerEvent("keyPressed", string, n, 0, 0);
            }
            this.combinableCompatibilityJamosQueue.clear();
        }
        if (this.involveCombinableCompatibiltyJamos) {
            this.involveCombinableCompatibiltyJamos = false;
        }
        if (this.lastCombinableCompatibilityJamos != null) {
            this.lastCombinableCompatibilityJamos = null;
        }
        if (this.lastJamoSimulated) {
            this.lastJamoSimulated = false;
        }
        return false;
    }

    @Override
    public void onResumeState() {
        String string;
        String string2 = this.getWidget().get_spellerData() != null ? this.getWidget().get_spellerData().getAvailableCharacters() : "";
        String string3 = string = this.getWidget().get_spellerData() != null ? this.getWidget().get_spellerData().getEnteredText() : "";
        if (this.initialAvailableCharacters != null && !this.initialAvailableCharacters.equals(string2)) {
            this.onEnterState(this);
        } else if (this.initialEnteredText != null && !this.initialEnteredText.equals(string)) {
            this.onEnterState(this);
        } else {
            this.updateSpellerButtons(string);
        }
    }

    @Override
    protected boolean onSpacePressed(String string, String string2, int n) {
        if (this.lastJamoSimulated) {
            this.lastJamoSimulated = false;
        }
        if (!this.combinableCompatibilityJamosQueue.isEmpty()) {
            this.combinableCompatibilityJamosQueue.clear();
            if (this.lastCombinableCompatibilityJamos != null) {
                this.lastCombinableCompatibilityJamos = null;
            }
            if (this.involveCombinableCompatibiltyJamos) {
                this.involveCombinableCompatibiltyJamos = false;
                this.fireSpellerEvent("keyPressed", string, n, 0, 0);
            }
            return true;
        }
        return false;
    }

    @Override
    public void setSpellerData(SpellerData spellerData) {
        int n;
        String string = spellerData != null ? spellerData.getEnteredText() : "";
        int n2 = n = spellerData != null ? spellerData.getCursorPosition() : 0;
        if (spellerData != null) {
            if (spellerData.isSelectionActive()) {
                spellerData.setSelectionStart(0);
                spellerData.setSelectionEnd(0);
            } else if (this.reselectCombinableJamos && n < this.cursorPositionOnDeleted) {
                this.fireSpellerEvent("keyPressed", "", n, string.length() - 1, string.length());
                this.reselectCombinableJamos = false;
                this.cursorPositionOnDeleted = 0;
            }
        }
        if (this.cursorPositionOnKeyPressed > 0 && this.cursorPositionOnKeyPressed < n) {
            this.handleCombinableJamos(false);
            this.cursorPositionOnKeyPressed = n;
        }
        this.initialAvailableCharacters = spellerData != null ? spellerData.getAvailableCharacters() : null;
        String string2 = this.initialEnteredText = spellerData != null ? spellerData.getEnteredText() : null;
        if (this.lastJamoSimulated) {
            this.lastJamoSimulated = false;
        }
        this.updateSpellerButtons(string);
    }

    private void updateSpellerButtons(String string) {
        String string2 = this.getWidget().get_spellerData() != null ? this.getWidget().get_spellerData().getAvailableCharacters() : "";
        this.updateSpellerButtons(string, string2);
    }

    private void updateSpellerButtons(String string, String string2) {
        StringBuilder stringBuilder = new StringBuilder(string2);
        if (this.involveCombinableCompatibiltyJamos && !this.combinableCompatibilityJamosQueue.isEmpty()) {
            String string3 = Jamo.asJamos((String)this.combinableCompatibilityJamosQueue.peek());
            char c2 = string != null && string.length() > 0 ? string.charAt(string.length() - 1) : (char)'\u0000';
            boolean bl = false;
            for (int i2 = 0; i2 < string3.length(); ++i2) {
                char c3 = string3.charAt(i2);
                if (!Jamo.isCombinedCompatibilityJamoAvailable(c2, c3)) continue;
                if (stringBuilder.indexOf(String.valueOf(c3)) < 0) {
                    stringBuilder.append(c3);
                }
                if (bl) continue;
                bl = true;
            }
            if (bl && stringBuilder.indexOf(String.valueOf(' ')) < 0) {
                stringBuilder.append(' ');
            }
        }
        this.fillCombinableCompatibilityJamosQueue(string2, stringBuilder);
        string2 = Jamo.asCompatibilityJamos(stringBuilder.toString());
        this.getWidget().updateSpellerButtons(string2, "");
    }
}

