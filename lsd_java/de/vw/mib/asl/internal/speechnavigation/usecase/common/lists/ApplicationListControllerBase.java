/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechnavigation.usecase.common.lists;

import de.vw.mib.asl.api.speechengine.result.handling.ResultItemRowNumberHandler;
import de.vw.mib.asl.api.speechengine.result.handling.ResultListControllerBase;
import de.vw.mib.asl.api.speechengine.result.router.ModelEventConsumer;
import de.vw.mib.asl.api.speechengine.result.router.RecognizedEventConsumer;
import de.vw.mib.asl.api.speechengine.result.service.DataService;
import de.vw.mib.asl.internal.speechnavigation.usecase.common.ApplicationErrorHandler;
import de.vw.mib.asl.internal.speechnavigation.usecase.common.Framework;
import de.vw.mib.asl.internal.speechnavigation.usecase.common.lists.GenericListHandler;
import de.vw.mib.genericevents.EventGeneric;

public abstract class ApplicationListControllerBase
extends ResultListControllerBase
implements ApplicationErrorHandler,
RecognizedEventConsumer,
ModelEventConsumer {
    private final GenericListHandler listHandler = new GenericListHandler(this);

    protected ApplicationListControllerBase(DataService dataService, ResultItemRowNumberHandler resultItemRowNumberHandler) {
        super(dataService, resultItemRowNumberHandler);
    }

    @Override
    public void onActionFailed() {
        Framework.fireUIEvent(2097689600);
    }

    @Override
    public void onActionNotAvailable() {
    }

    @Override
    public void onEvent(EventGeneric eventGeneric) {
        this.listHandler.onEvent(eventGeneric);
    }

    @Override
    public void onRecognizedEvent(int n) {
        this.listHandler.onRecognizedEvent(n);
    }

    @Override
    public void notifyItemSelected() {
        Framework.fireUIEvent(1997026304);
    }

    @Override
    public void notifyRowNumberRecognized(int n) {
        Framework.updateUIValue(1577595904, n);
        Framework.updateUIValue(1376269312, n - 1);
    }
}

