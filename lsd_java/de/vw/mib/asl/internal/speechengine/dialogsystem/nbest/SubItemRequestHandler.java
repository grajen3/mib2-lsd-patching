/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechengine.dialogsystem.nbest;

import de.vw.mib.asl.internal.speechengine.dialogsystem.controller.asr.AsrController;
import de.vw.mib.asl.internal.speechengine.dialogsystem.nbest.RequestGraphemicGroupSubItems;
import de.vw.mib.asl.internal.speechengine.dialogsystem.nbest.SubItemRequest;
import de.vw.mib.asl.internal.speechengine.dialogsystem.nbest.SubItemRequestCallback;
import de.vw.mib.asl.internal.speechengine.task.TaskInvokerIgnoringErrors;
import de.vw.mib.log4mib.Logger;

public class SubItemRequestHandler
implements SubItemRequest {
    private static final String TRACE_PREFIX;
    private static int TRACE_CLASS;
    private final Logger logger;
    private final AsrController asr;
    private final TaskInvokerIgnoringErrors taskInvoker;
    private boolean isDialogActive = true;

    public SubItemRequestHandler(Logger logger, AsrController asrController) {
        this.logger = logger;
        this.asr = asrController;
        this.taskInvoker = new TaskInvokerIgnoringErrors(TRACE_CLASS, this.logger, "SubItemRequest-TaskInvoker");
    }

    @Override
    public void getSubItems(int n, SubItemRequestCallback subItemRequestCallback) {
        if (this.logger.isTraceEnabled(TRACE_CLASS)) {
            this.logger.trace(TRACE_CLASS, new StringBuffer("[SubItemRequestHandler]: ").append("getSubItems( ").append(n).append("  )").toString());
        }
        if (subItemRequestCallback == null) {
            this.logger.error(TRACE_CLASS, "SubItemRequestCallback instance was null. Will discarding request. ");
            return;
        }
        if (!this.isDialogActive) {
            subItemRequestCallback.getSubItemsResponse(114, null);
            this.logger.error(TRACE_CLASS, "No dialog active. Will return null. ");
        } else if (n < 0) {
            subItemRequestCallback.getSubItemsResponse(300, null);
            this.logger.error(TRACE_CLASS, "Negative group-index. Will return null. ");
        } else {
            RequestGraphemicGroupSubItems requestGraphemicGroupSubItems = new RequestGraphemicGroupSubItems(this.logger, this.asr, subItemRequestCallback, n);
            this.taskInvoker.add(requestGraphemicGroupSubItems);
            this.taskInvoker.invoke();
        }
    }

    static {
        TRACE_CLASS = 512;
    }
}

