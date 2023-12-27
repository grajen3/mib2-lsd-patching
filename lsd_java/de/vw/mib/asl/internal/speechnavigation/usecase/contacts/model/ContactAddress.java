/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechnavigation.usecase.contacts.model;

import de.vw.mib.asl.api.navigation.memory.INavigationContactAddress;
import de.vw.mib.asl.internal.speechnavigation.usecase.guidance.destination.details.formatters.AddressFormatter;
import de.vw.mib.asl.internal.speechnavigation.usecase.guidance.destination.details.formatters.AddressFormatterImpl;

public class ContactAddress {
    private final AddressFormatter addressFormatter = new AddressFormatterImpl();
    public int addressIndex = -1;
    public long contactId = -1L;
    public INavigationContactAddress address = null;

    public ContactAddress() {
    }

    public ContactAddress(int n, long l, INavigationContactAddress iNavigationContactAddress) {
        this.addressIndex = n;
        this.contactId = l;
        this.address = iNavigationContactAddress;
    }

    public String toShortString() {
        if (this.address != null) {
            return this.addressFormatter.toShortAddressString(this.address);
        }
        return "no address";
    }

    public String toLongString() {
        if (this.address != null) {
            return this.addressFormatter.toLongAddressString(this.address);
        }
        return "no address";
    }
}

