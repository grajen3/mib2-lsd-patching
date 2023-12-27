/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechphone.controller.callstacks;

import de.vw.mib.asl.api.speechengine.result.handling.ResultListHandler;
import de.vw.mib.asl.api.speechengine.result.router.ModelEventConsumer;
import de.vw.mib.asl.api.speechengine.result.router.RecognizedEventConsumer;
import de.vw.mib.asl.internal.speechphone.communication.phone.CallstackNumberHandler;
import de.vw.mib.asl.internal.speechphone.controller.contact.AbstractNBestController;
import de.vw.mib.asl.internal.speechphone.data.internal.CallstackEntryModel;
import de.vw.mib.asl.internal.speechphone.utils.ServiceFunctions;
import de.vw.mib.asl.internal.speechphone.utils.SpeechPhoneLogger2;
import de.vw.mib.genericevents.EventGeneric;

public class CallstackNbestController
extends AbstractNBestController
implements RecognizedEventConsumer,
ModelEventConsumer {
    private final SpeechPhoneLogger2 logger;
    private final CallstackNumberHandler callstackHandler;

    public CallstackNbestController(ServiceFunctions serviceFunctions, CallstackNumberHandler callstackNumberHandler, ResultListHandler resultListHandler) {
        super(serviceFunctions, callstackNumberHandler, resultListHandler);
        this.callstackHandler = callstackNumberHandler;
        this.logger = serviceFunctions.createLogger("CallstackNbestController");
    }

    @Override
    public int getListIdTopLevel() {
        return -1968620800;
    }

    @Override
    public int getListIdDetailLevel() {
        return -1951843584;
    }

    @Override
    public int getListIdSelectedItem() {
        return -1935066368;
    }

    @Override
    public void onEvent(EventGeneric eventGeneric) {
        if (this.callstackHandler.isPhoneAvailable(this.callstackHandler.getCurrentUseCaseId())) {
            int n = eventGeneric.getReceiverEventId();
            switch (n) {
                case 1077641884: {
                    CallstackEntryModel callstackEntryModel;
                    if (this.logger.isTraceEnabled()) {
                        this.logger.trace("dial selected callstack entry");
                    }
                    if ((callstackEntryModel = (CallstackEntryModel)this.listHandler.getSelectedItem()) == null) break;
                    this.callstackHandler.triggerDialing();
                    break;
                }
                default: {
                    super.onEvent(eventGeneric);
                }
            }
        }
    }

    @Override
    public void onRecognizedEvent(int n) {
        if (this.callstackHandler.isPhoneAvailable(this.callstackHandler.getCurrentUseCaseId())) {
            switch (n) {
                case 1077641883: {
                    if (this.logger.isTraceEnabled()) {
                        this.logger.trace("callstack entry has been chosen, check whether it is a unique recognition or an nbest");
                    }
                    super.onRequestItems();
                    break;
                }
                default: {
                    super.onRecognizedEvent(n);
                }
            }
        }
    }

    @Override
    public void notifyAmbiguousItemsRequested() {
        if (this.logger.isTraceEnabled()) {
            this.logger.trace("show callstack nbest list");
        }
        this.serviceFunctions.sendHMIEvent(-861324544);
    }

    @Override
    public void notifyItemsRequested() {
        CallstackEntryModel callstackEntryModel;
        if (this.logger.isTraceEnabled()) {
            this.logger.trace("call recognized callstack item");
        }
        if (this.callstackHandler.getCurrentCallstackType() == 0) {
            this.callstackHandler.refillMixedList();
        }
        if ((callstackEntryModel = (CallstackEntryModel)this.listHandler.getSelectedItem()) != null) {
            this.callstackHandler.setLastSelectedItem(callstackEntryModel);
            this.callstackHandler.dialPreCheck();
        }
    }

    @Override
    public void notifyItemSelected() {
        CallstackEntryModel callstackEntryModel;
        if (this.logger.isTraceEnabled()) {
            this.logger.trace("call selected callstack item");
        }
        if ((callstackEntryModel = (CallstackEntryModel)this.listHandler.getSelectedItem()) != null) {
            this.callstackHandler.setLastSelectedItem(callstackEntryModel);
            this.callstackHandler.dialPreCheck();
        }
    }
}

