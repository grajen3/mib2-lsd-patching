/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechtuner.communication.dialogstate;

import de.vw.mib.asl.api.speechengine.messenger.dialog.DialogStateConsumer;
import de.vw.mib.asl.api.speechengine.messenger.dialog.DialogStateRouter;

public class DialogStateHandler
implements DialogStateConsumer {
    private int dialogState;

    public DialogStateHandler(DialogStateRouter dialogStateRouter) {
        dialogStateRouter.register(this);
        this.dialogState = 3;
    }

    @Override
    public void onDialogStateChanged(int n) {
        if (n == 2 || n == 3) {
            this.dialogState = n;
        }
    }

    public boolean isDialogActive() {
        return this.dialogState == 2;
    }
}

