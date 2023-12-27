/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.mediacontrol.common.commands;

import de.vw.mib.asl.internal.mediacontrol.common.commands.AbstractCommand;
import de.vw.mib.asl.internal.mediacontrol.common.component.ResponseHandler;

class AbstractCommand$2
extends ResponseHandler {
    private final /* synthetic */ AbstractCommand this$0;

    AbstractCommand$2(AbstractCommand abstractCommand) {
        this.this$0 = abstractCommand;
    }

    @Override
    public void handleResponse(int n, String string) {
    }

    public String toString() {
        return "NO_OPERATION";
    }
}

