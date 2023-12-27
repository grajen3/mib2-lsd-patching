/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.phone.api.model;

import de.vw.mib.asl.api.phone.model.PhoneNumber;
import de.vw.mib.asl.api.phone.services.contact.ContactDetail;
import de.vw.mib.asl.internal.phone.api.model.CommonContactImpl;
import de.vw.mib.asl.internal.phone.api.model.PhoneNumberImpl;
import de.vw.mib.asl.internal.phone.util.PhoneUtil;
import java.util.Arrays;
import org.dsi.ifc.global.ResourceLocator;
import org.dsi.ifc.organizer.PhoneData;

public class ContactDetailImpl
extends CommonContactImpl
implements ContactDetail {
    private final PhoneNumber[] phoneNumbers;

    public ContactDetailImpl(long l, String string, ResourceLocator resourceLocator, PhoneData[] phoneDataArray, int n) {
        super(l, string, resourceLocator, n);
        this.phoneNumbers = this.createFromPhoneDataArray(phoneDataArray);
    }

    @Override
    public int getNumberCount() {
        return this.phoneNumbers.length;
    }

    @Override
    public PhoneNumber[] getPhoneNumbers() {
        return this.phoneNumbers;
    }

    private PhoneNumber[] createFromPhoneDataArray(PhoneData[] phoneDataArray) {
        phoneDataArray = PhoneUtil.ripADBPhoneData(phoneDataArray);
        PhoneNumber[] phoneNumberArray = new PhoneNumber[phoneDataArray.length];
        for (int i2 = 0; i2 < phoneDataArray.length; ++i2) {
            phoneNumberArray[i2] = new PhoneNumberImpl(phoneDataArray[i2].getNumber(), this, phoneDataArray[i2].getNumberType());
        }
        return phoneNumberArray;
    }

    @Override
    public String toString() {
        return new StringBuffer().append("ContactDetailImpl [phoneNumbers=").append(this.phoneNumbers != null ? Arrays.asList(this.phoneNumbers) : null).append(", toString()=").append(super.toString()).append("]").toString();
    }
}

