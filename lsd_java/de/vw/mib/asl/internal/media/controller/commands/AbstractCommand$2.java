/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.media.controller.commands;

import de.vw.mib.asl.internal.media.common.ResponseHandler;
import de.vw.mib.asl.internal.media.controller.commands.AbstractCommand;

class AbstractCommand$2
extends ResponseHandler {
    private final /* synthetic */ AbstractCommand this$0;

    AbstractCommand$2(AbstractCommand abstractCommand) {
        this.this$0 = abstractCommand;
    }

    @Override
    public void handleResponse(int n, String string) {
    }

    @Override
    public boolean isValid() {
        return !this.this$0.isTerminated();
    }

    public String toString() {
        return "NO_OPERATION";
    }
}

