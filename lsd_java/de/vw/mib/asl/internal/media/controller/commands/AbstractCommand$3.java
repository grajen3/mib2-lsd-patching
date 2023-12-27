/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.media.controller.commands;

import de.vw.mib.asl.internal.media.controller.commands.AbstractCommand;

class AbstractCommand$3
implements Runnable {
    private final /* synthetic */ AbstractCommand this$0;

    AbstractCommand$3(AbstractCommand abstractCommand) {
        this.this$0 = abstractCommand;
    }

    @Override
    public void run() {
        this.this$0.commandTimedOut();
    }
}

