/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechphone.controller.contact;

import de.vw.mib.asl.api.speechengine.result.handling.ResultListHandler;
import de.vw.mib.asl.api.speechengine.result.router.ModelEventConsumer;
import de.vw.mib.asl.api.speechengine.result.router.RecognizedEventConsumer;
import de.vw.mib.asl.api.speechengine.result.service.AdditionalDataService;
import de.vw.mib.asl.internal.speechphone.communication.phone.PhoneHandler;
import de.vw.mib.asl.internal.speechphone.controller.contact.AbstractNBestController;
import de.vw.mib.asl.internal.speechphone.controller.contact.PropagatingSelectedContactHandler;
import de.vw.mib.asl.internal.speechphone.data.internal.ContactNameModel;
import de.vw.mib.asl.internal.speechphone.utils.ServiceFunctions;
import de.vw.mib.asl.internal.speechphone.utils.SpeechPhoneLogger2;
import de.vw.mib.genericevents.EventGeneric;

public class ContactNBestController
extends AbstractNBestController
implements RecognizedEventConsumer,
ModelEventConsumer {
    private final SpeechPhoneLogger2 logger;
    public static final int DIAL_CONTACT_XXX;
    public static final int DIAL_CONTACT_GARBAGE;
    private final int usecaseId;
    private final PhoneHandler phoneHandler;
    private final PropagatingSelectedContactHandler selectedContactHandler;

    public ContactNBestController(ServiceFunctions serviceFunctions, AdditionalDataService additionalDataService, ResultListHandler resultListHandler, PropagatingSelectedContactHandler propagatingSelectedContactHandler, PhoneHandler phoneHandler) {
        super(serviceFunctions, additionalDataService, resultListHandler);
        this.usecaseId = 5;
        this.phoneHandler = phoneHandler;
        this.selectedContactHandler = propagatingSelectedContactHandler;
        this.logger = serviceFunctions.createLogger("ContactNBestController");
    }

    @Override
    public int getListIdTopLevel() {
        return -2018952448;
    }

    @Override
    public int getListIdDetailLevel() {
        return -2002175232;
    }

    @Override
    public int getListIdSelectedItem() {
        return -1985398016;
    }

    @Override
    public void onEvent(EventGeneric eventGeneric) {
        if (this.phoneHandler.isPhoneAvailable(this.usecaseId)) {
            switch (eventGeneric.getReceiverEventId()) {
                default: 
            }
            super.onEvent(eventGeneric);
        }
    }

    @Override
    public void onRecognizedEvent(int n) {
        if (this.phoneHandler.isPhoneAvailable(this.usecaseId)) {
            switch (n) {
                case 1077641846: {
                    if (!this.phoneHandler.areContactsAvailable()) break;
                    this.selectedContactHandler.reset();
                    this.selectedContactHandler.getLocTypeIndexHandler().fetchLocType();
                    super.onRequestItems();
                    break;
                }
                case 1077641838: {
                    if (!this.phoneHandler.areContactsAvailable()) break;
                    this.logger.error("Something went wrong on dial contact garbage command");
                    this.serviceFunctions.sendHMIEvent(-1129760000);
                    break;
                }
                case 1077641875: {
                    this.selectedContactHandler.getLocTypeIndexHandler().fetchLocTypeIndex();
                    super.onSelectItem(0);
                    break;
                }
                case 1077641874: {
                    this.selectedContactHandler.getLocTypeIndexHandler().fetchLocTypeIndex();
                    super.onSelectItem();
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
        this.serviceFunctions.sendHMIEvent(-1465304320);
    }

    @Override
    public void notifyItemsRequested() {
        ContactNameModel contactNameModel = (ContactNameModel)this.listHandler.getSelectedItem();
        if (contactNameModel != null) {
            this.selectedContactHandler.handleOneShotResult(contactNameModel);
        }
    }

    @Override
    public void notifyItemSelected() {
        ContactNameModel contactNameModel = (ContactNameModel)this.listHandler.getSelectedItem();
        if (contactNameModel != null) {
            this.selectedContactHandler.handleNBestResult(contactNameModel);
        }
    }
}

