/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechphone.controller.contact;

import de.vw.mib.asl.api.phone.model.PhoneNumber;
import de.vw.mib.asl.api.speechengine.slots.SlotEntry;
import de.vw.mib.asl.api.speechengine.slots.SlotUpdater;
import de.vw.mib.asl.internal.speechphone.controller.contact.AbstractSelectedContactHandler;
import de.vw.mib.asl.internal.speechphone.controller.contact.LocTypeIndexHandler;
import de.vw.mib.asl.internal.speechphone.controller.contact.SelectedNumberHandler;
import de.vw.mib.asl.internal.speechphone.data.internal.ContactNameModel;
import de.vw.mib.asl.internal.speechphone.utils.ServiceFunctions;
import de.vw.mib.asl.internal.speechphone.utils.SpeechPhoneLogger2;

public class PropagatingSelectedContactHandler
extends AbstractSelectedContactHandler {
    private final SpeechPhoneLogger2 logger;
    private SlotUpdater slotUpdater;

    public PropagatingSelectedContactHandler(ServiceFunctions serviceFunctions, LocTypeIndexHandler locTypeIndexHandler, SelectedNumberHandler selectedNumberHandler, SlotUpdater slotUpdater) {
        super(serviceFunctions, locTypeIndexHandler, selectedNumberHandler);
        this.slotUpdater = slotUpdater;
        this.logger = serviceFunctions.createLogger("PropagatingSelectedContactHandler");
    }

    @Override
    protected void notifyModel(ContactNameModel contactNameModel, int n) {
        this.updateSlot(contactNameModel);
        this.serviceFunctions.sendInternalEvent(-1719518400, n);
        if (this.logger.isTraceEnabled()) {
            this.logger.trace(new StringBuffer().append("The system event ").append(n).append(" is proposed to the numberlist controller. Switching to numberlist controller.").toString());
        }
    }

    private void updateSlot(ContactNameModel contactNameModel) {
        int n = contactNameModel.getCountOfNumbers();
        SlotEntry[] slotEntryArray = new SlotEntry[n];
        for (int i2 = 0; i2 < n; ++i2) {
            PhoneNumber phoneNumber = contactNameModel.getPhoneNumber(i2);
            String string = phoneNumber.getNumber();
            slotEntryArray[i2] = this.slotUpdater.createSlotEntry(i2, string);
        }
        this.slotUpdater.updateSlotData(35, 3, slotEntryArray);
    }

    @Override
    protected void triggerPromptDialLocType() {
        this.serviceFunctions.sendHMIEvent(-1297532160);
    }

    @Override
    protected void triggerPromptDialLocTypeIndex() {
        this.serviceFunctions.sendHMIEvent(-1280754944);
    }
}

