/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.messages.contacts.transformer;

import org.dsi.ifc.organizer.PhoneData;

public class MessagesContactsMessageContactNumbersCollector {
    public PhoneData phoneData;
    public boolean isSelected;

    public MessagesContactsMessageContactNumbersCollector(PhoneData phoneData, boolean bl) {
        this.phoneData = phoneData;
        this.isSelected = bl;
    }
}

