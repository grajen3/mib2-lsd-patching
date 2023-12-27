/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.phone.contacts.search.transformer;

import de.vw.mib.asl.internal.phone.ASLPhoneData;
import de.vw.mib.asl.internal.phone.util.PhoneUtil;
import generated.de.vw.mib.asl.internal.phone.contacts.search.transformer.AbstractPhoneContactsSearchSpellerResultListTransformer;
import org.dsi.ifc.organizer.DataSet;

public class PhoneContactsSearchSpellerResultListTransformer
extends AbstractPhoneContactsSearchSpellerResultListTransformer {
    @Override
    public String getString(int n, Object object) {
        DataSet dataSet = (DataSet)object;
        switch (n) {
            case 0: {
                return dataSet.getGeneralDescription1();
            }
            case 3: {
                if (ASLPhoneData.getInstance().contactsSortedByCriteria == 0) {
                    return dataSet.generalDescription2;
                }
                return dataSet.generalDescription1;
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
        return 0L;
    }

    @Override
    public boolean getBoolean(int n, Object object) {
        DataSet dataSet = (DataSet)object;
        if (object == null) {
            return false;
        }
        switch (n) {
            case 2: {
                return dataSet.phoneCount > 1;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("column: ").append(n).toString());
    }

    @Override
    public int getInt(int n, Object object) {
        DataSet dataSet = (DataSet)object;
        switch (n) {
            case 4: {
                return PhoneUtil.convertPhoneTypeDSI2ASLCombined(dataSet.getNumberType());
            }
            case 5: {
                return dataSet.getNumberType();
            }
        }
        return 0;
    }
}

