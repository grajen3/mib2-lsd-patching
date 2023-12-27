/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechphone.controller.contact;

import de.vw.mib.asl.api.phone.model.PhoneNumber;
import de.vw.mib.asl.api.speechengine.dialogmanager.DialogBackstack;
import de.vw.mib.asl.api.speechengine.result.handling.ResultItemHandler;
import de.vw.mib.asl.api.speechengine.result.handling.ResultItemRowNumberHandler;
import de.vw.mib.asl.api.speechengine.result.router.ModelEventConsumer;
import de.vw.mib.asl.api.speechengine.result.router.RecognizedEventConsumer;
import de.vw.mib.asl.internal.speechphone.controller.contact.AbstractListController;
import de.vw.mib.asl.internal.speechphone.controller.contact.ImmediateSelectedContactHandler;
import de.vw.mib.asl.internal.speechphone.controller.contact.NumberListController$1;
import de.vw.mib.asl.internal.speechphone.data.internal.ContactNameModel;
import de.vw.mib.asl.internal.speechphone.service.NumberDataService;
import de.vw.mib.asl.internal.speechphone.utils.ServiceFunctions;
import de.vw.mib.genericevents.EventGeneric;

public class NumberListController
extends AbstractListController
implements RecognizedEventConsumer,
ModelEventConsumer {
    public static final int SHOW_NUMBER_LIST;
    final ImmediateSelectedContactHandler selectedContactHandler;
    private boolean normalBackBehaviour = true;
    private final DialogBackstack dialogBackstack;
    private final ResultItemHandler resultItemHandler;
    private final NumberDataService service;

    public NumberListController(ServiceFunctions serviceFunctions, NumberDataService numberDataService, ResultItemRowNumberHandler resultItemRowNumberHandler, ImmediateSelectedContactHandler immediateSelectedContactHandler, DialogBackstack dialogBackstack, ResultItemHandler resultItemHandler) {
        super(serviceFunctions, numberDataService, resultItemRowNumberHandler);
        this.service = numberDataService;
        this.dialogBackstack = dialogBackstack;
        this.resultItemHandler = resultItemHandler;
        this.selectedContactHandler = immediateSelectedContactHandler;
    }

    @Override
    public int getListIdTopLevel() {
        return -1918289152;
    }

    @Override
    public int getListIdSelectedItem() {
        return -1851180288;
    }

    @Override
    public void onEvent(EventGeneric eventGeneric) {
        int n = eventGeneric.getReceiverEventId();
        switch (n) {
            case 1077641881: {
                this.normalBackBehaviour = true;
                this.selectedContactHandler.fetchSystemEvent(eventGeneric);
                this.service.setLocTypeFirst(this.selectedContactHandler.getLocTypeIndexHandler().getLoctype());
                super.onRequestItems();
                break;
            }
            default: {
                super.onEvent(eventGeneric);
            }
        }
    }

    @Override
    public void onRecognizedEvent(int n) {
        switch (n) {
            case 1077641868: {
                this.serviceFunctions.sendHMIEvent(-1448527104);
                break;
            }
            case 1077641869: {
                this.serviceFunctions.sendHMIEvent(-1565967616);
                break;
            }
            case 1077641876: {
                int n2 = (int)this.resultItemHandler.getResultItem().getIdentifier().getObjectId();
                ContactNameModel contactNameModel = this.serviceFunctions.getSelectedContact();
                if (contactNameModel == null) break;
                this.selectedContactHandler.getSelectedNumberHandler().selectNumber(contactNameModel, n2);
                this.serviceFunctions.sendHMIEvent(-1448527104);
                break;
            }
            case 1077641877: {
                if (this.normalBackBehaviour) {
                    this.normalBackBehaviour = false;
                    this.dialogBackstack.push(new NumberListController$1(this));
                }
                this.selectedContactHandler.getLocTypeIndexHandler().fetchLocTypeIndex();
                ContactNameModel contactNameModel = this.serviceFunctions.getSelectedContact();
                if (contactNameModel == null) break;
                this.selectedContactHandler.handleContactHasMultipleNumbers(contactNameModel);
                break;
            }
            default: {
                super.onRecognizedEvent(n);
            }
        }
    }

    @Override
    public void notifyItemsRequested() {
        this.selectedContactHandler.fireStoredSystemEvent();
    }

    @Override
    public void notifyItemSelected() {
        PhoneNumber phoneNumber = (PhoneNumber)this.listHandler.getSelectedItem();
        if (phoneNumber != null) {
            this.selectedContactHandler.getSelectedNumberHandler().setNumberToCall(phoneNumber);
        }
        this.serviceFunctions.sendHMIEvent(-1448527104);
    }
}

