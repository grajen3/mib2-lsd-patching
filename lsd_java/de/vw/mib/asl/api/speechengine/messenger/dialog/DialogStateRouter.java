/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.api.speechengine.messenger.dialog;

import de.vw.mib.asl.api.speechengine.messenger.dialog.DialogStateBitField;
import de.vw.mib.asl.api.speechengine.messenger.dialog.DialogStateConsumer;

public interface DialogStateRouter {
    default public void register(DialogStateConsumer dialogStateConsumer) {
    }

    default public void unregister(DialogStateConsumer dialogStateConsumer) {
    }

    default public DialogStateBitField getDialogState() {
    }
}

