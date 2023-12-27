/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechengine.dialogmanager.interfaces;

import de.vw.mib.asl.api.speechengine.features.model.Command;

public interface CommandConsumer {
    default public void recognizedCommand(Command command) {
    }

    default public boolean isUniversal() {
    }
}

