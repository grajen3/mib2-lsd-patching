/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechnavigation.usecase.contacts.controller;

import de.vw.mib.asl.api.speechengine.result.handling.ResultListHandler;
import de.vw.mib.asl.api.speechengine.result.router.ModelEventConsumer;
import de.vw.mib.asl.api.speechengine.result.router.RecognizedEventConsumer;
import de.vw.mib.asl.api.speechengine.result.service.AdditionalDataService;
import de.vw.mib.asl.internal.speechnavigation.usecase.common.Framework;
import de.vw.mib.asl.internal.speechnavigation.usecase.common.lists.ApplicationNBestListControllerBase;
import de.vw.mib.asl.internal.speechnavigation.usecase.contacts.controller.NavigateContactAddressDetailController;
import de.vw.mib.asl.internal.speechnavigation.usecase.contacts.controller.NavigateContactSelectAddressController;
import de.vw.mib.asl.internal.speechnavigation.usecase.contacts.model.Contact;
import de.vw.mib.asl.internal.speechnavigation.usecase.contacts.model.ContactAddress;
import de.vw.mib.genericevents.EventGeneric;
import generated.de.vw.mib.asl.internal.ListManager;

public class NavigateContactXController
extends ApplicationNBestListControllerBase
implements RecognizedEventConsumer,
ModelEventConsumer {
    public static final int RESUME_CMD_NAVIGATE_CONTACT_X;
    public static final int SUI_CONTACTS_SELECT_ITEM;

    public NavigateContactXController(AdditionalDataService additionalDataService, ResultListHandler resultListHandler) {
        super(additionalDataService, resultListHandler);
    }

    public static void navigateContactX() {
        Framework.fireEvent(1745230080);
    }

    public static void selectContact(Contact contact) {
        Framework.fireEvent(1913002240, contact);
    }

    @Override
    public int getListIdTopLevel() {
        return 1678259200;
    }

    @Override
    public int getListIdDetailLevel() {
        return 1695036416;
    }

    @Override
    public int getListIdSelectedItem() {
        return 1711813632;
    }

    public int getListIdSelectedAddressItem() {
        return 1762145280;
    }

    @Override
    public void onEvent(EventGeneric eventGeneric) {
        int n = eventGeneric.getReceiverEventId();
        switch (n) {
            case 1640040: {
                super.onRequestItems();
                break;
            }
            case 1640050: {
                Contact contact = (Contact)eventGeneric.getObject(0);
                ListManager.getGenericASLList(this.getListIdSelectedItem()).updateList(new Contact[]{contact});
                this.notifyItemSelected();
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
            default: 
        }
        super.onRecognizedEvent(n);
    }

    @Override
    public void notifyAmbiguousItemsRequested() {
        if (ListManager.getGenericASLList(this.getListIdTopLevel()).getItemCount() < 1) {
            this.onActionFailed();
            return;
        }
        Contact contact = (Contact)ListManager.getGenericASLList(this.getListIdTopLevel()).getDSIObjects()[0];
        ListManager.getGenericASLList(this.getListIdSelectedItem()).updateList(new Contact[]{contact});
        Framework.fireUIEvent(-569887744);
    }

    @Override
    public void notifyItemsRequested() {
        this.notifyItemSelected();
    }

    @Override
    public void notifyGroupExpanded(int n) {
        if (n >= 0 && n < ListManager.getGenericASLList(this.getListIdTopLevel()).getDSIObjects().length) {
            Contact contact = (Contact)ListManager.getGenericASLList(this.getListIdTopLevel()).getDSIObjects()[n];
            Framework.updateUIValue(1594373120, contact.contactName);
        }
        super.notifyGroupExpanded(n);
    }

    @Override
    public void notifyItemSelected() {
        if (ListManager.getGenericASLList(this.getListIdSelectedItem()).getItemCount() != 1) {
            this.onActionFailed();
            return;
        }
        Contact contact = (Contact)ListManager.getGenericASLList(this.getListIdSelectedItem()).getDSIObjects()[0];
        Framework.updateUIValue(1594373120, contact.contactName);
        super.notifyItemSelected();
        if (!contact.hasAddresses()) {
            Framework.fireUIEvent(-519556096);
        } else if (contact.hasSingleAddress()) {
            ListManager.getGenericASLList(this.getListIdSelectedAddressItem()).updateList(new ContactAddress[]{contact.getFirstAddress()});
            NavigateContactAddressDetailController.showDestinationAddressDetails(contact.getFirstAddress());
        } else if (contact.hasMultipleAddresses()) {
            NavigateContactSelectAddressController.showAddressesByContact(contact);
        }
    }
}

