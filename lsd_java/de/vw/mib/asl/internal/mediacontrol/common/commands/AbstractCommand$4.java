/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.mediacontrol.common.commands;

import de.vw.mib.asl.internal.mediacontrol.common.commands.AbstractCommand;
import de.vw.mib.asl.internal.mediacontrol.common.commands.Command;
import de.vw.mib.asl.internal.mediacontrol.common.commands.CommandStateListener;
import de.vw.mib.asl.internal.mediacontrol.common.component.ResponseHandler;

class AbstractCommand$4
implements CommandStateListener {
    private ResponseHandler mHandler;
    private final /* synthetic */ ResponseHandler val$responseHandler;
    private final /* synthetic */ AbstractCommand this$0;

    AbstractCommand$4(AbstractCommand abstractCommand, ResponseHandler responseHandler) {
        this.this$0 = abstractCommand;
        this.val$responseHandler = responseHandler;
        this.mHandler = this.val$responseHandler;
    }

    @Override
    public void notifyCommandStateChanged(Command command) {
        if (command.isTerminated()) {
            command.exit();
            this.this$0.mExecutedSubCommand = null;
            AbstractCommand.access$000(this.this$0).resume();
            if (command.isCompleted()) {
                this.mHandler.handleResponse(1, null);
            } else if (command.isAbortedByTimeout()) {
                this.mHandler.handleResponse(2, "subcommand timeout");
            } else if (command.isAbortedByError()) {
                this.mHandler.handleResponse(2, "subcommand error");
            } else if (command.isAbortedByCall()) {
                this.mHandler.handleResponse(-1, "subcommand aborted");
            }
        }
    }
}

