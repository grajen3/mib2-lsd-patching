/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.widgets.speller;

import de.vw.mib.widgets.speller.Alphabet;
import de.vw.mib.widgets.speller.SpellerElement;
import de.vw.mib.widgets.speller.SpellerElementStates$SpellerElementState;

public final class SpellerElementStates {
    private SpellerElementStates$SpellerElementState[] spellerElementStates;

    public SpellerElementStates(Alphabet alphabet) {
        this(alphabet != null ? alphabet.getElementCount() : 0);
    }

    public SpellerElementStates(int n) {
        this.spellerElementStates = new SpellerElementStates$SpellerElementState[n];
    }

    public int getSize() {
        return this.spellerElementStates.length;
    }

    public boolean isAnySelectable() {
        for (int i2 = this.spellerElementStates.length - 1; i2 >= 0; --i2) {
            if (!this.spellerElementStates[i2].isEnabled()) continue;
            return true;
        }
        return false;
    }

    public void setEnabled(SpellerElement spellerElement, boolean bl) {
        this.getSpellerElementState(spellerElement).setEnabled(bl);
        if (!bl) {
            this.getSpellerElementState(spellerElement).setPressed(false);
            this.getSpellerElementState(spellerElement).setSelected(false);
        }
    }

    public boolean isEnabled(SpellerElement spellerElement) {
        return this.getSpellerElementState(spellerElement).isEnabled();
    }

    public void setPressed(SpellerElement spellerElement, boolean bl) {
        this.releaseAllPressed();
        this.getSpellerElementState(spellerElement).setPressed(bl);
    }

    public boolean isPressed(SpellerElement spellerElement) {
        return this.getSpellerElementState(spellerElement).isPressed();
    }

    public void releaseAllPressed() {
        for (int i2 = 0; i2 < this.spellerElementStates.length; ++i2) {
            if (this.spellerElementStates[i2] == null || !this.spellerElementStates[i2].isPressed()) continue;
            this.spellerElementStates[i2].setPressed(false);
        }
    }

    public void setSelected(int n, boolean bl) {
        this.releaseAllSelected();
        this.getSpellerElementState(n).setSelected(bl);
    }

    public void setSelected(SpellerElement spellerElement, boolean bl) {
        this.releaseAllSelected();
        if (bl) {
            this.getSpellerElementState(spellerElement).setSelected(bl);
        }
    }

    public boolean isSelected(SpellerElement spellerElement) {
        return this.getSpellerElementState(spellerElement).isSelected();
    }

    public void setSubSpellerAvailable(SpellerElement spellerElement, boolean bl) {
        this.getSpellerElementState(spellerElement).setSubSpellerAvailable(bl);
    }

    public boolean isSubSpellerAvailable(SpellerElement spellerElement) {
        return this.getSpellerElementState(spellerElement).isSubSpellerAvailable();
    }

    public void releaseAllSelected() {
        for (int i2 = this.spellerElementStates.length - 1; i2 >= 0; --i2) {
            if (this.spellerElementStates[i2] == null) continue;
            this.spellerElementStates[i2].setSelected(false);
        }
    }

    public void resetAll() {
        for (int i2 = this.spellerElementStates.length - 1; i2 >= 0; --i2) {
            if (this.spellerElementStates[i2] == null) continue;
            this.spellerElementStates[i2].setEnabled(false);
            this.spellerElementStates[i2].setPressed(false);
            this.spellerElementStates[i2].setSelected(false);
            this.spellerElementStates[i2].setSubSpellerAvailable(false);
        }
    }

    private SpellerElementStates$SpellerElementState getSpellerElementState(SpellerElement spellerElement) {
        int n = spellerElement.getId();
        return this.getSpellerElementState(n);
    }

    private SpellerElementStates$SpellerElementState getSpellerElementState(int n) {
        if (this.spellerElementStates[n] == null) {
            this.spellerElementStates[n] = new SpellerElementStates$SpellerElementState();
        }
        return this.spellerElementStates[n];
    }
}

