/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.phone.bap.contacts.transformer;

import generated.de.vw.mib.asl.internal.phone.bap.contacts.transformer.AbstractPhoneBAPContactsContactDetailsTransformer;
import org.dsi.ifc.organizer.AdbEntry;

public class PhoneBAPContactsContactDetailsTransformer
extends AbstractPhoneBAPContactsContactDetailsTransformer {
    @Override
    public boolean getBoolean(int n, Object object) {
        AdbEntry adbEntry = (AdbEntry)object;
        switch (n) {
            case 1: {
                return adbEntry.getVoiceTagId() != -1;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("column: ").append(n).toString());
    }

    @Override
    public int getInt(int n, Object object) {
        AdbEntry adbEntry = (AdbEntry)object;
        switch (n) {
            case 3: {
                return adbEntry.getPreferredNumberIdx() == 0 ? adbEntry.getPhoneData()[0].getNumberType() : adbEntry.getPhoneData()[0].getNumberType() + 1;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("column: ").append(n).toString());
    }

    @Override
    public String getString(int n, Object object) {
        AdbEntry adbEntry = (AdbEntry)object;
        switch (n) {
            case 2: {
                return adbEntry.getPhoneData()[0].getNumber();
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("column: ").append(n).toString());
    }

    @Override
    public long getLong(int n, Object object) {
        AdbEntry adbEntry = (AdbEntry)object;
        switch (n) {
            case 0: {
                return adbEntry.getEntryId();
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("column: ").append(n).toString());
    }
}

