/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechphone.controller.callstacks;

import de.vw.mib.asl.api.speechengine.result.handling.ResultItemRowNumberHandler;
import de.vw.mib.asl.api.speechengine.result.router.ModelEventConsumer;
import de.vw.mib.asl.api.speechengine.result.router.RecognizedEventConsumer;
import de.vw.mib.asl.internal.speechphone.communication.phone.CallstackNumberHandler;
import de.vw.mib.asl.internal.speechphone.controller.contact.AbstractListController;
import de.vw.mib.asl.internal.speechphone.data.internal.CallstackEntryModel;
import de.vw.mib.asl.internal.speechphone.utils.ServiceFunctions;
import de.vw.mib.asl.internal.speechphone.utils.SpeechPhoneLogger2;
import de.vw.mib.genericevents.EventGeneric;

public class CallstackListController
extends AbstractListController
implements RecognizedEventConsumer,
ModelEventConsumer {
    private final SpeechPhoneLogger2 logger;
    private final CallstackNumberHandler callstackHandler;

    public CallstackListController(ServiceFunctions serviceFunctions, CallstackNumberHandler callstackNumberHandler, ResultItemRowNumberHandler resultItemRowNumberHandler) {
        super(serviceFunctions, callstackNumberHandler, resultItemRowNumberHandler);
        this.callstackHandler = callstackNumberHandler;
        this.logger = serviceFunctions.createLogger("CallstackListController");
    }

    private void setCurrentCallstackType(int n) {
        if (this.logger.isTraceEnabled()) {
            this.logger.trace(new StringBuffer().append("Setting current callstack type to ").append(CallstackNumberHandler.CALLSTACKTYPE_TEXTS[n]).append(".").toString());
        }
        this.callstackHandler.setCurrentCallstackType(n);
        int n2 = n == 1 ? 1 : (n == 2 ? 2 : (n == 3 ? 3 : 0));
        this.serviceFunctions.writeIntegerToDatapool(-1817625856, n2);
    }

    private void setCurrentCallstackViewType() {
        if (this.logger.isTraceEnabled()) {
            this.logger.trace(new StringBuffer().append("Setting current callstack view type to ").append(CallstackNumberHandler.CALLSTACKTYPE_TEXTS[this.callstackHandler.getCurrentCallstackType()]).append(".").toString());
        }
        int n = this.callstackHandler.getCurrentCallstackType() == 1 ? 1 : (this.callstackHandler.getCurrentCallstackType() == 2 ? 2 : (this.callstackHandler.getCurrentCallstackType() == 3 ? 3 : 0));
        this.serviceFunctions.writeIntegerToDatapool(-1633076480, n);
    }

    @Override
    public int getListIdTopLevel() {
        if (this.callstackHandler.getCurrentCallstackType() == 1) {
            return -1750516992;
        }
        if (this.callstackHandler.getCurrentCallstackType() == 2) {
            return -1733739776;
        }
        if (this.callstackHandler.getCurrentCallstackType() == 3) {
            return -1716962560;
        }
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
                    this.callstackHandler.triggerDialing();
                    break;
                }
                case 1077641839: {
                    this.onRecognizedEvent(1870805824);
                    break;
                }
                case 1077641848: {
                    this.onRecognizedEvent(2021800768);
                    break;
                }
                case 1077641849: {
                    this.onRecognizedEvent(2038577984);
                    break;
                }
                case 1077641850: {
                    this.onRecognizedEvent(2055355200);
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
        boolean bl = true;
        switch (n) {
            case 1077641839: {
                this.setCurrentCallstackType(0);
                break;
            }
            case 1077641848: {
                this.setCurrentCallstackType(1);
                break;
            }
            case 1077641849: {
                this.setCurrentCallstackType(2);
                break;
            }
            case 1077641850: {
                this.setCurrentCallstackType(3);
                break;
            }
            case 1077641887: {
                super.onRequestItems();
                bl = false;
                if (this.logger.isTraceEnabled()) {
                    this.logger.trace(new StringBuffer().append("enter ").append(CallstackNumberHandler.CALLSTACKTYPE_TEXTS[this.callstackHandler.getCurrentCallstackType()]).append(" again").toString());
                }
                if (this.callstackHandler.getCurrentCallstackType() == 1) {
                    this.serviceFunctions.sendHMIEvent(-961987840);
                    break;
                }
                if (this.callstackHandler.getCurrentCallstackType() == 2) {
                    this.serviceFunctions.sendHMIEvent(-945210624);
                    break;
                }
                if (this.callstackHandler.getCurrentCallstackType() == 3) {
                    this.serviceFunctions.sendHMIEvent(-928433408);
                    break;
                }
                this.serviceFunctions.sendHMIEvent(-978765056);
                break;
            }
            default: {
                bl = false;
                super.onRecognizedEvent(n);
            }
        }
        if (bl && this.callstackHandler.isPhoneAvailable(this.callstackHandler.getCurrentUseCaseId())) {
            if (this.callstackHandler.isCurrentCallstackEmpty()) {
                if (this.logger.isTraceEnabled()) {
                    this.logger.trace(new StringBuffer().append("Callstack ").append(CallstackNumberHandler.CALLSTACKTYPE_TEXTS[this.callstackHandler.getCurrentCallstackType()]).append(" is empty.").toString());
                }
                this.serviceFunctions.sendHMIEvent(-911656192);
            } else if (this.callstackHandler.isCurrentCallstackCompiling()) {
                if (this.logger.isTraceEnabled()) {
                    this.logger.trace(new StringBuffer().append("Callstack ").append(CallstackNumberHandler.CALLSTACKTYPE_TEXTS[this.callstackHandler.getCurrentCallstackType()]).append(" is compiling.").toString());
                }
                this.serviceFunctions.sendHMIEvent(-894878976);
            } else {
                super.onRequestItems();
                this.setCurrentCallstackViewType();
                if (this.callstackHandler.getCurrentCallstackType() == 1) {
                    if (this.logger.isTraceEnabled()) {
                        this.logger.trace("Opening missed calls.");
                    }
                    this.serviceFunctions.sendHMIEvent(-1951843584);
                } else if (this.callstackHandler.getCurrentCallstackType() == 2) {
                    if (this.logger.isTraceEnabled()) {
                        this.logger.trace("Opening dialed numbers.");
                    }
                    this.serviceFunctions.sendHMIEvent(-1935066368);
                } else if (this.callstackHandler.getCurrentCallstackType() == 3) {
                    if (this.logger.isTraceEnabled()) {
                        this.logger.trace("Opening accepted calls.");
                    }
                    this.serviceFunctions.sendHMIEvent(-1918289152);
                } else {
                    if (this.logger.isTraceEnabled()) {
                        this.logger.trace("Opening mixed callstack.");
                    }
                    this.serviceFunctions.sendHMIEvent(-2069284096);
                }
            }
        }
    }

    @Override
    public void notifyItemSelected() {
        CallstackEntryModel callstackEntryModel = (CallstackEntryModel)this.listHandler.getSelectedItem();
        this.callstackHandler.setLastSelectedItem(callstackEntryModel);
        if (callstackEntryModel != null) {
            if (callstackEntryModel.isKnownNumber()) {
                if (this.logger.isTraceEnabled()) {
                    this.logger.trace(new StringBuffer().append("Selected item from ").append(CallstackNumberHandler.CALLSTACKTYPE_TEXTS[this.callstackHandler.getCurrentCallstackType()]).append(" will be prepared for dialing.").toString());
                }
                this.callstackHandler.dialPreCheck();
            } else {
                if (this.logger.isTraceEnabled()) {
                    this.logger.trace(new StringBuffer().append("Selected item from ").append(CallstackNumberHandler.CALLSTACKTYPE_TEXTS[this.callstackHandler.getCurrentCallstackType()]).append(" is unknown number.").toString());
                }
                this.serviceFunctions.sendHMIEvent(-878101760);
            }
        }
    }

    @Override
    public void notifyItemsRequested() {
        if (this.logger.isTraceEnabled()) {
            this.logger.trace(new StringBuffer().append("Filling callstack getters according to current callstack ").append(CallstackNumberHandler.CALLSTACKTYPE_TEXTS[this.callstackHandler.getCurrentCallstackType()]).append(".").toString());
        }
        this.serviceFunctions.writeBooleanToDatapool(-1683408128, this.callstackHandler.isCurrentCallstackContainingNames());
        this.serviceFunctions.writeBooleanToDatapool(-1649853696, this.callstackHandler.isCurrentCallstackContainingKnownNumbers());
        this.serviceFunctions.writeStringToDatapool(-1784071424, this.callstackHandler.getCurrentCallstackFirstFoundContactNameOrNumber());
    }
}

