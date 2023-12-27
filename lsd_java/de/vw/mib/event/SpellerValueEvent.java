/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.event;

import de.vw.mib.event.HMIEvent;

public interface SpellerValueEvent
extends HMIEvent {
    default public int getCursorPosition() {
    }

    default public String getPressedChar() {
    }

    default public int getSelectionStart() {
    }

    default public int getSelectionEnd() {
    }
}

