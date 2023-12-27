/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.widgets.interfaces;

import de.vw.mib.widgets.models.PushUpModel;

public interface PushUpHandler {
    default public void open(PushUpModel pushUpModel) {
    }

    default public void close(PushUpModel pushUpModel) {
    }

    default public void close() {
    }
}

