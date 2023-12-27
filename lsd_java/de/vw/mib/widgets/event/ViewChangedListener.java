/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.widgets.event;

import de.vw.mib.widgets.View;

public interface ViewChangedListener {
    default public void viewCovered() {
    }

    default public void viewUncovered() {
    }

    default public void viewInited(View view) {
    }

    default public void viewEntered(View view) {
    }

    default public void viewLeft(View view) {
    }
}

