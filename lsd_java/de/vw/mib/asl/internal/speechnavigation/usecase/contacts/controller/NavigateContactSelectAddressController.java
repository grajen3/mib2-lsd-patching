/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechnavigation.usecase.contacts.controller;

import de.vw.mib.asl.api.speechengine.result.handling.ResultItemRowNumberHandler;
import de.vw.mib.asl.api.speechengine.result.router.ModelEventConsumer;
import de.vw.mib.asl.api.speechengine.result.router.RecognizedEventConsumer;
import de.vw.mib.asl.internal.speechnavigation.usecase.common.Framework;
import de.vw.mib.asl.internal.speechnavigation.usecase.common.lists.ApplicationListControllerBase;
import de.vw.mib.asl.internal.speechnavigation.usecase.contacts.controller.NavigateContactAddressDetailController;
import de.vw.mib.asl.internal.speechnavigation.usecase.contacts.model.Contact;
import de.vw.mib.asl.internal.speechnavigation.usecase.contacts.model.ContactAddress;
import de.vw.mib.asl.internal.speechnavigation.usecase.contacts.service.ContactAddressDataService;
import de.vw.mib.genericevents.EventGeneric;
import generated.de.vw.mib.asl.internal.ListManager;

public class NavigateContactSelectAddressController
extends ApplicationListControllerBase
implements RecognizedEventConsumer,
ModelEventConsumer {
    public static final int SHOW_MULTIPLE_ADDRESSES;
    public static final int CMD_DLG_GO_BACK;
    private final ContactAddressDataService service;

    public NavigateContactSelectAddressController(ContactAddressDataService contactAddressDataService, ResultItemRowNumberHandler resultItemRowNumberHandler) {
        super(contactAddressDataService, resultItemRowNumberHandler);
        this.service = contactAddressDataService;
    }

    public static void showAddressesByContact(Contact contact) {
        Framework.fireEvent(1778784512);
    }

    @Override
    public int getListIdTopLevel() {
        return 1745368064;
    }

    @Override
    public int getListIdSelectedItem() {
        return 1762145280;
    }

    public int getListIdSelectedContactItem() {
        return 1711813632;
    }

    @Override
    public void onRecognizedEvent(int n) {
        super.onRecognizedEvent(n);
    }

    @Override
    public void onEvent(EventGeneric eventGeneric) {
        int n = eventGeneric.getReceiverEventId();
        switch (n) {
            case 1640042: {
                Contact contact = (Contact)ListManager.getGenericASLList(this.getListIdSelectedContactItem()).getDSIObjects()[0];
                this.service.setContact(contact);
                super.onRequestItems();
                break;
            }
            case 1077142005: {
                break;
            }
            default: {
                super.onEvent(eventGeneric);
            }
        }
    }

    @Override
    public void notifyItemsRequested() {
        Framework.fireUIEvent(-502778880);
    }

    @Override
    public void notifyItemSelected() {
        Contact contact = (Contact)ListManager.getGenericASLList(this.getListIdSelectedContactItem()).getDSIObjects()[0];
        Framework.updateUIValue(1594373120, contact.contactName);
        ContactAddress contactAddress = (ContactAddress)ListManager.getGenericASLList(this.getListIdSelectedItem()).getDSIObjects()[0];
        NavigateContactAddressDetailController.showDestinationAddressDetails(contact.contactAddresses[contactAddress.addressIndex]);
    }
}

