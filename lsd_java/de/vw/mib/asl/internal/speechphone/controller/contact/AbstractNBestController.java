/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechphone.controller.contact;

import de.vw.mib.asl.api.speechengine.result.handling.ResultListHandler;
import de.vw.mib.asl.api.speechengine.result.handling.ResultListNBestControllerBase;
import de.vw.mib.asl.api.speechengine.result.router.ModelEventConsumer;
import de.vw.mib.asl.api.speechengine.result.router.RecognizedEventConsumer;
import de.vw.mib.asl.api.speechengine.result.service.AdditionalDataService;
import de.vw.mib.asl.internal.speechphone.controller.contact.CommonListHandler;
import de.vw.mib.asl.internal.speechphone.utils.ServiceFunctions;
import de.vw.mib.asl.internal.speechphone.utils.SpeechPhoneLogger2;
import de.vw.mib.genericevents.EventGeneric;

public abstract class AbstractNBestController
extends ResultListNBestControllerBase
implements ModelEventConsumer,
RecognizedEventConsumer {
    private final SpeechPhoneLogger2 logger;
    protected final CommonListHandler listHandler;
    protected final ServiceFunctions serviceFunctions;

    public AbstractNBestController(ServiceFunctions serviceFunctions, AdditionalDataService additionalDataService, ResultListHandler resultListHandler) {
        super(additionalDataService, resultListHandler, serviceFunctions.aslListManager());
        this.listHandler = new CommonListHandler(serviceFunctions, this);
        this.serviceFunctions = serviceFunctions;
        this.logger = serviceFunctions.createLogger("AbstractNBestController");
    }

    @Override
    public void onRecognizedEvent(int n) {
        switch (n) {
            case 1077641871: {
                super.onSelectItem();
                break;
            }
            case 1077641868: {
                super.onSelectItem(0);
                break;
            }
            case 1077641869: {
                this.serviceFunctions.sendHMIEvent(-1565967616);
                break;
            }
            default: {
                this.listHandler.onRecognizedEvent(n);
            }
        }
    }

    @Override
    public void onEvent(EventGeneric eventGeneric) {
        switch (eventGeneric.getReceiverEventId()) {
            case 1077641873: {
                int n = eventGeneric.getInt(0);
                super.onSelectSubItem(n);
                break;
            }
            default: {
                this.listHandler.onEvent(eventGeneric);
            }
        }
    }

    private void storeGroupNameToSelectedItem(int n) {
        Object[] objectArray = this.serviceFunctions.getListObjects(this.getListIdTopLevel());
        if (objectArray != null) {
            if (n >= 0 && n < objectArray.length) {
                if (!this.serviceFunctions.updateList(this.getListIdSelectedItem(), new Object[]{objectArray[n]})) {
                    this.logger.error("ASL list for selected item was null.");
                }
            } else {
                this.logger.error("Group index out of range.");
            }
        } else {
            this.logger.error("Toplevel object list was null or empty.");
        }
    }

    @Override
    public void notifyGroupExpanded(int n) {
        this.storeGroupNameToSelectedItem(n);
        this.serviceFunctions.writeIntegerToDatapool(-1867957504, n);
        this.serviceFunctions.sendHMIEvent(-1599522048);
    }

    @Override
    public void notifyGroupCollapsed(int n) {
        this.storeGroupNameToSelectedItem(n);
        this.serviceFunctions.writeIntegerToDatapool(-1867957504, -1);
        this.serviceFunctions.sendHMIEvent(-1582744832);
    }

    @Override
    public void notifyRowNumberRecognized(int n) {
        this.serviceFunctions.writeIntegerToDatapool(2074688256, n);
        this.serviceFunctions.sendHMIEvent(-1834403072);
    }
}

