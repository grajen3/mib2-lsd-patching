/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.phone.contacts.transformer;

import de.vw.mib.asl.internal.phone.ASLPhoneData;
import de.vw.mib.asl.internal.phone.util.PhoneUtil;
import generated.de.vw.mib.asl.internal.phone.contacts.transformer.AbstractPhoneContactsContactsTransformer;
import org.dsi.ifc.global.ResourceLocator;
import org.dsi.ifc.organizer.DataSet;

public class PhoneContactsContactsTransformer
extends AbstractPhoneContactsContactsTransformer {
    @Override
    public boolean getBoolean(int n, Object object) {
        DataSet dataSet = (DataSet)object;
        if (object == null) {
            return false;
        }
        switch (n) {
            case 8: {
                return dataSet.phoneCount > 1;
            }
            case 7: {
                return dataSet.phoneCount == 5;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("column: ").append(n).toString());
    }

    @Override
    public String getString(int n, Object object) {
        DataSet dataSet = (DataSet)object;
        switch (n) {
            case 0: 
            case 1: 
            case 4: {
                if (ASLPhoneData.getInstance().contactsSortedByCriteria == 0) {
                    return dataSet.generalDescription2;
                }
                return dataSet.generalDescription1;
            }
            case 5: {
                if (ASLPhoneData.getInstance().contactsSortedByCriteria == 0) {
                    return dataSet.generalDescription1;
                }
                return dataSet.generalDescription2;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("column: ").append(n).toString());
    }

    @Override
    public long getLong(int n, Object object) {
        DataSet dataSet = (DataSet)object;
        switch (n) {
            case 2: {
                return (int)dataSet.entryId;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("column: ").append(n).toString());
    }

    @Override
    public ResourceLocator getResourceLocator(int n, Object object) {
        DataSet dataSet = (DataSet)object;
        switch (n) {
            case 6: {
                return dataSet.contactPicture;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("column: ").append(n).toString());
    }

    @Override
    public int getInt(int n, Object object) {
        DataSet dataSet = (DataSet)object;
        switch (n) {
            case 9: {
                return PhoneUtil.convertPhoneTypeDSI2ASLCombined(dataSet.getNumberType());
            }
            case 10: {
                return dataSet.getNumberType();
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("column: ").append(n).toString());
    }
}

