/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.phone.contacts.search.transformer;

import de.vw.mib.asl.internal.phone.ASLPhoneData;
import de.vw.mib.asl.internal.phone.util.PhoneUtil;
import generated.de.vw.mib.asl.internal.phone.contacts.search.transformer.AbstractPhoneContactsSearchSpellerPreviewListTransformer;
import org.dsi.ifc.organizer.DataSet;

public class PhoneContactsSearchSpellerPreviewListTransformer
extends AbstractPhoneContactsSearchSpellerPreviewListTransformer {
    @Override
    public String getString(int n, Object object) {
        DataSet dataSet = (DataSet)object;
        switch (n) {
            case 1: {
                return dataSet.getGeneralDescription1();
            }
            case 4: {
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
            case 2: {
                return dataSet.getEntryId();
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("column: ").append(n).toString());
    }

    @Override
    public boolean getBoolean(int n, Object object) {
        DataSet dataSet = (DataSet)object;
        if (object == null) {
            return false;
        }
        switch (n) {
            case 5: {
                return dataSet.phoneCount > 1;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("column: ").append(n).toString());
    }

    @Override
    public int getInt(int n, Object object) {
        DataSet dataSet = (DataSet)object;
        switch (n) {
            case 3: {
                return PhoneUtil.convertPhoneTypeDSI2ASLCombined(dataSet.getNumberType());
            }
            case 6: {
                return dataSet.getNumberType();
            }
        }
        return 0;
    }
}

