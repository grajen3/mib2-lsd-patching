/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.messages.transformer;

import generated.de.vw.mib.asl.internal.messages.transformer.AbstractMessagesExtractedNumbersTransformer;
import org.dsi.ifc.global.ResourceLocator;
import org.dsi.ifc.organizer.DataSet;

public class MessagesExtractedNumbersTransformer
extends AbstractMessagesExtractedNumbersTransformer {
    @Override
    public String getString(int n, Object object) {
        DataSet dataSet = (DataSet)object;
        switch (n) {
            case 1: {
                return dataSet.getGeneralDescription1();
            }
            case 4: {
                return dataSet.getGeneralDescription2();
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("column: ").append(n).toString());
    }

    @Override
    public boolean getBoolean(int n, Object object) {
        DataSet dataSet = (DataSet)object;
        switch (n) {
            case 5: {
                return dataSet.getEntryId() != 0L;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("column: ").append(n).toString());
    }

    @Override
    public int getInt(int n, Object object) {
        switch (n) {
            case 6: {
                return 0;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("column: ").append(n).toString());
    }

    @Override
    public long getLong(int n, Object object) {
        DataSet dataSet = (DataSet)object;
        switch (n) {
            case 2: {
                return (int)dataSet.getEntryId();
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("column: ").append(n).toString());
    }

    @Override
    public ResourceLocator getResourceLocator(int n, Object object) {
        DataSet dataSet = (DataSet)object;
        switch (n) {
            case 3: {
                return dataSet.getContactPicture();
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("column: ").append(n).toString());
    }
}

