/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechphone.controller.contact;

import de.vw.mib.asl.api.speechengine.result.handling.ResultItemRowNumberHandler;
import de.vw.mib.asl.api.speechengine.result.handling.ResultListControllerBase;
import de.vw.mib.asl.api.speechengine.result.router.ModelEventConsumer;
import de.vw.mib.asl.api.speechengine.result.router.RecognizedEventConsumer;
import de.vw.mib.asl.api.speechengine.result.service.DataService;
import de.vw.mib.asl.internal.speechphone.controller.contact.CommonListHandler;
import de.vw.mib.asl.internal.speechphone.utils.ServiceFunctions;
import de.vw.mib.genericevents.EventGeneric;

public abstract class AbstractListController
extends ResultListControllerBase
implements RecognizedEventConsumer,
ModelEventConsumer {
    protected final CommonListHandler listHandler;
    protected final ServiceFunctions serviceFunctions;

    public AbstractListController(ServiceFunctions serviceFunctions, DataService dataService, ResultItemRowNumberHandler resultItemRowNumberHandler) {
        super(dataService, resultItemRowNumberHandler, serviceFunctions.aslListManager());
        this.listHandler = new CommonListHandler(serviceFunctions, this);
        this.serviceFunctions = serviceFunctions;
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
    public void notifyRowNumberRecognized(int n) {
        this.serviceFunctions.writeIntegerToDatapool(2074688256, n);
        this.serviceFunctions.sendHMIEvent(-1834403072);
    }
}

