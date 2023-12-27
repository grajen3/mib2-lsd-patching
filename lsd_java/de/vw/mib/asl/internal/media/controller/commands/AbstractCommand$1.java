/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.media.controller.commands;

import de.vw.mib.asl.internal.media.common.ResponseHandler;
import de.vw.mib.asl.internal.media.controller.commands.AbstractCommand;

class AbstractCommand$1
extends ResponseHandler {
    private final /* synthetic */ AbstractCommand this$0;

    AbstractCommand$1(AbstractCommand abstractCommand) {
        this.this$0 = abstractCommand;
    }

    @Override
    public void handleResponse(int n, String string) {
        switch (n) {
            case -1: {
                this.this$0.commandAborted(string, true);
                break;
            }
            case 2: {
                this.this$0.commandFailed(string);
                break;
            }
            case 1: {
                if (this.this$0.isTraceEnabled()) {
                    this.this$0.trace(string);
                }
                this.this$0.nextStep();
                break;
            }
        }
    }

    public String toString() {
        return this.this$0.getCommandStr(true, true, false, false);
    }

    @Override
    public boolean isValid() {
        return !this.this$0.isTerminated();
    }
}

