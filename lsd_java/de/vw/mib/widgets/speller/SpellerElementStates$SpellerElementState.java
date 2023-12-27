/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.widgets.speller;

import de.vw.mib.util.StringBuilder;

final class SpellerElementStates$SpellerElementState {
    private boolean enabled;
    private boolean pressed;
    private boolean selected;
    private boolean subSpellerAvailable;

    public boolean isEnabled() {
        return this.enabled;
    }

    public void setEnabled(boolean bl) {
        this.enabled = bl;
    }

    public boolean isPressed() {
        return this.pressed;
    }

    public void setPressed(boolean bl) {
        this.pressed = bl;
    }

    public boolean isSelected() {
        return this.selected;
    }

    public void setSelected(boolean bl) {
        this.selected = bl;
    }

    public boolean isSubSpellerAvailable() {
        return this.subSpellerAvailable;
    }

    public void setSubSpellerAvailable(boolean bl) {
        this.subSpellerAvailable = bl;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("SpellerElementState").append("[");
        stringBuilder.append("enabled=").append(this.enabled).append(", ");
        stringBuilder.append("pressed=").append(this.pressed).append(", ");
        stringBuilder.append("selected=").append(this.selected).append(", ");
        stringBuilder.append("subSpellerAvailable=").append(this.subSpellerAvailable).append("'");
        stringBuilder.append("]");
        return stringBuilder.toString();
    }
}

