/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.phone.bap.contacts.transformer;

import generated.de.vw.mib.asl.internal.phone.bap.contacts.transformer.AbstractPhoneBAPContactsContactsTransformer;
import org.dsi.ifc.organizer.DataSet;

public class PhoneBAPContactsContactsTransformer
extends AbstractPhoneBAPContactsContactsTransformer {
    @Override
    public int getInt(int n, Object object) {
        DataSet dataSet = (DataSet)object;
        switch (n) {
            case 3: {
                return dataSet.getEntryPosition();
            }
            case 5: {
                return dataSet.getEntryType();
            }
            case 0: {
                return dataSet.getVoiceTagId() == -1 ? 0 : 1;
            }
            case 6: {
                return dataSet.getPhoneCount();
            }
            case 2: {
                int n2 = 0;
                if (dataSet.probNavigable == 1) {
                    n2 += 16;
                }
                if (dataSet.probNavigable == 2) {
                    n2 += 4;
                }
                if (dataSet.navigable == 1) {
                    n2 += 32;
                }
                if (dataSet.navigable == 2) {
                    n2 += 8;
                }
                return n2;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("column: ").append(n).toString());
    }

    @Override
    public String getString(int n, Object object) {
        DataSet dataSet = (DataSet)object;
        switch (n) {
            case 4: {
                return dataSet.getGeneralDescription1();
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("column: ").append(n).toString());
    }

    @Override
    public long getLong(int n, Object object) {
        DataSet dataSet = (DataSet)object;
        switch (n) {
            case 1: {
                return dataSet.getEntryId();
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("column: ").append(n).toString());
    }
}

