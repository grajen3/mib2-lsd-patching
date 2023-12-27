/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechengine.dialogsystem.nbest;

import de.vw.mib.asl.internal.speechengine.dialogsystem.adapter.handler.AsyncExceptionHandler;
import de.vw.mib.asl.internal.speechengine.dialogsystem.adapter.handler.GroupItemRequestHandler;
import de.vw.mib.asl.internal.speechengine.dialogsystem.controller.asr.AsrController;
import de.vw.mib.asl.internal.speechengine.dialogsystem.nbest.SubItemRequestCallback;
import de.vw.mib.asl.internal.speechengine.task.AbstractTask;
import de.vw.mib.log4mib.Logger;
import org.dsi.ifc.speechrec.NBestList;

public class RequestGraphemicGroupSubItems
extends AbstractTask
implements GroupItemRequestHandler,
AsyncExceptionHandler {
    private final AsrController asr;
    private final SubItemRequestCallback callback;
    private int graphemicGroupIndex;
    static /* synthetic */ Class class$de$vw$mib$asl$internal$speechengine$dialogsystem$adapter$handler$GroupItemRequestHandler;
    static /* synthetic */ Class class$de$vw$mib$asl$internal$speechengine$dialogsystem$adapter$handler$AsyncExceptionHandler;

    public RequestGraphemicGroupSubItems(Logger logger, AsrController asrController, SubItemRequestCallback subItemRequestCallback, int n) {
        super(logger);
        this.asr = asrController;
        this.callback = subItemRequestCallback;
        this.graphemicGroupIndex = n;
    }

    @Override
    public void execute() {
        this.asr.getHandlerRegistry().addHandler(class$de$vw$mib$asl$internal$speechengine$dialogsystem$adapter$handler$GroupItemRequestHandler == null ? (class$de$vw$mib$asl$internal$speechengine$dialogsystem$adapter$handler$GroupItemRequestHandler = RequestGraphemicGroupSubItems.class$("de.vw.mib.asl.internal.speechengine.dialogsystem.adapter.handler.GroupItemRequestHandler")) : class$de$vw$mib$asl$internal$speechengine$dialogsystem$adapter$handler$GroupItemRequestHandler, this);
        this.asr.getHandlerRegistry().addHandler(class$de$vw$mib$asl$internal$speechengine$dialogsystem$adapter$handler$AsyncExceptionHandler == null ? (class$de$vw$mib$asl$internal$speechengine$dialogsystem$adapter$handler$AsyncExceptionHandler = RequestGraphemicGroupSubItems.class$("de.vw.mib.asl.internal.speechengine.dialogsystem.adapter.handler.AsyncExceptionHandler")) : class$de$vw$mib$asl$internal$speechengine$dialogsystem$adapter$handler$AsyncExceptionHandler, this);
        this.asr.getSpeechRec().requestGraphemicGroupAsNBestList(this.graphemicGroupIndex);
    }

    @Override
    public void terminate() {
        this.asr.getHandlerRegistry().removeHandler(class$de$vw$mib$asl$internal$speechengine$dialogsystem$adapter$handler$GroupItemRequestHandler == null ? (class$de$vw$mib$asl$internal$speechengine$dialogsystem$adapter$handler$GroupItemRequestHandler = RequestGraphemicGroupSubItems.class$("de.vw.mib.asl.internal.speechengine.dialogsystem.adapter.handler.GroupItemRequestHandler")) : class$de$vw$mib$asl$internal$speechengine$dialogsystem$adapter$handler$GroupItemRequestHandler, this);
        this.asr.getHandlerRegistry().removeHandler(class$de$vw$mib$asl$internal$speechengine$dialogsystem$adapter$handler$AsyncExceptionHandler == null ? (class$de$vw$mib$asl$internal$speechengine$dialogsystem$adapter$handler$AsyncExceptionHandler = RequestGraphemicGroupSubItems.class$("de.vw.mib.asl.internal.speechengine.dialogsystem.adapter.handler.AsyncExceptionHandler")) : class$de$vw$mib$asl$internal$speechengine$dialogsystem$adapter$handler$AsyncExceptionHandler, this);
    }

    @Override
    public void abort() {
    }

    @Override
    public void responseRequestGraphemicGroupAsNBestList(int n, NBestList nBestList) {
        this.terminate();
        this.notifyFinishedSuccessful();
        this.callback.getSubItemsResponse(n, nBestList);
    }

    @Override
    public void asyncException(int n, String string, int n2) {
        if (n2 == 1031) {
            this.callback.getSubItemsResponse(300, null);
        }
    }

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError().initCause(classNotFoundException);
        }
    }
}

