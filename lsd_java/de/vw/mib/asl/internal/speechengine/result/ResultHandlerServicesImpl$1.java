/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechengine.result;

import de.vw.mib.asl.api.speechengine.result.ResultHandler;
import de.vw.mib.asl.api.speechengine.result.handling.ResultControllerRouter;
import de.vw.mib.asl.api.speechengine.result.handling.ResultItemHandler;
import de.vw.mib.asl.api.speechengine.result.handling.ResultItemRowNumberHandler;
import de.vw.mib.asl.api.speechengine.result.handling.ResultListHandler;
import de.vw.mib.asl.api.speechengine.result.handling.ResultSession;
import de.vw.mib.asl.api.speechengine.result.router.RecognizedResultConsumer;
import de.vw.mib.asl.internal.speechengine.result.ResultHandlerServicesImpl;

class ResultHandlerServicesImpl$1
implements ResultHandler {
    private final /* synthetic */ ResultSession val$session;
    private final /* synthetic */ RecognizedResultConsumer val$controllerRegistry;
    private final /* synthetic */ ResultListHandler val$resultListHandler;
    private final /* synthetic */ ResultItemHandler val$resultItemHandler;
    private final /* synthetic */ ResultHandlerServicesImpl this$0;

    ResultHandlerServicesImpl$1(ResultHandlerServicesImpl resultHandlerServicesImpl, ResultSession resultSession, RecognizedResultConsumer recognizedResultConsumer, ResultListHandler resultListHandler, ResultItemHandler resultItemHandler) {
        this.this$0 = resultHandlerServicesImpl;
        this.val$session = resultSession;
        this.val$controllerRegistry = recognizedResultConsumer;
        this.val$resultListHandler = resultListHandler;
        this.val$resultItemHandler = resultItemHandler;
    }

    @Override
    public ResultSession getResultSession() {
        return this.val$session;
    }

    @Override
    public ResultControllerRouter getResultControllerRegistry() {
        return (ResultControllerRouter)this.val$controllerRegistry;
    }

    @Override
    public ResultListHandler getResultListHandler() {
        return this.val$resultListHandler;
    }

    @Override
    public ResultItemRowNumberHandler getResultItemRowNumberHandler() {
        return this.val$resultListHandler;
    }

    @Override
    public ResultItemHandler getResultItemHandler() {
        return this.val$resultItemHandler;
    }
}

