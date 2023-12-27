/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.phone;

import de.vw.mib.asl.api.phone.services.contact.ContactDetail;
import de.vw.mib.asl.api.phone.services.contact.ContactDetailsResponse;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.phone.HsmPhoneGetEntryHelper$Task;
import de.vw.mib.asl.internal.phone.api.model.ContactDetailImpl;
import org.dsi.ifc.organizer.AdbEntry;

final class HsmPhoneGetEntryHelper$ServiceTask
extends HsmPhoneGetEntryHelper$Task {
    ContactDetailsResponse response;

    HsmPhoneGetEntryHelper$ServiceTask(ContactDetailsResponse contactDetailsResponse, int n, int n2, long[] lArray) {
        super(n, n2, lArray);
        this.response = contactDetailsResponse;
    }

    @Override
    void callback(boolean bl, AdbEntry[] adbEntryArray) {
        try {
            if (bl) {
                ContactDetail[] contactDetailArray = new ContactDetail[adbEntryArray.length];
                for (int i2 = 0; i2 < adbEntryArray.length; ++i2) {
                    contactDetailArray[i2] = new ContactDetailImpl(adbEntryArray[i2].getEntryId(), adbEntryArray[i2].getCombinedName(), adbEntryArray[i2].getPersonalData().getContactPicture(), adbEntryArray[i2].phoneData, adbEntryArray[i2].entryType);
                }
                this.response.response(contactDetailArray);
            } else {
                this.response.response(null);
            }
        }
        catch (Exception exception) {
            ServiceManager.logger.error(4).append("callback exception, response.toString(): ").append(this.response.toString()).attachThrowable(exception).log();
        }
    }
}

