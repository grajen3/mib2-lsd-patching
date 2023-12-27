/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.organizer.impl;

import de.esolutions.fw.comm.dsi.global.impl.ResourceLocatorSerializer;
import de.esolutions.fw.comm.dsi.organizer.impl.HighlightSerializer;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.global.ResourceLocator;
import org.dsi.ifc.organizer.DataSet;
import org.dsi.ifc.organizer.Highlight;

public class DataSetSerializer {
    public static void putOptionalDataSet(ISerializer iSerializer, DataSet dataSet) {
        boolean bl = dataSet == null;
        iSerializer.putBool(bl);
        if (!bl) {
            long l = dataSet.getEntryId();
            iSerializer.putInt64(l);
            int n = dataSet.getEntryPosition();
            iSerializer.putInt32(n);
            int n2 = dataSet.getEntryType();
            iSerializer.putInt32(n2);
            String string = dataSet.getGeneralDescription1();
            iSerializer.putOptionalString(string);
            String string2 = dataSet.getGeneralDescription2();
            iSerializer.putOptionalString(string2);
            int n3 = dataSet.getVoiceTagId();
            iSerializer.putInt32(n3);
            int n4 = dataSet.getPhoneCount();
            iSerializer.putInt32(n4);
            int n5 = dataSet.getProbNavigable();
            iSerializer.putInt32(n5);
            int n6 = dataSet.getNavigable();
            iSerializer.putInt32(n6);
            int n7 = dataSet.getTopDestination();
            iSerializer.putInt32(n7);
            ResourceLocator resourceLocator = dataSet.getContactPicture();
            ResourceLocatorSerializer.putOptionalResourceLocator(iSerializer, resourceLocator);
            int n8 = dataSet.getWebAddressCount();
            iSerializer.putInt32(n8);
            int n9 = dataSet.getEmailCount();
            iSerializer.putInt32(n9);
            int n10 = dataSet.getNumberType();
            iSerializer.putInt32(n10);
            Highlight[] highlightArray = dataSet.getHighlight();
            HighlightSerializer.putOptionalHighlightVarArray(iSerializer, highlightArray);
        }
    }

    public static void putOptionalDataSetVarArray(ISerializer iSerializer, DataSet[] dataSetArray) {
        boolean bl = dataSetArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(dataSetArray.length);
            for (int i2 = 0; i2 < dataSetArray.length; ++i2) {
                DataSetSerializer.putOptionalDataSet(iSerializer, dataSetArray[i2]);
            }
        }
    }

    public static DataSet getOptionalDataSet(IDeserializer iDeserializer) {
        DataSet dataSet = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n;
            int n2;
            int n3;
            ResourceLocator resourceLocator;
            int n4;
            int n5;
            int n6;
            int n7;
            int n8;
            String string;
            String string2;
            int n9;
            int n10;
            long l;
            dataSet = new DataSet();
            dataSet.entryId = l = iDeserializer.getInt64();
            dataSet.entryPosition = n10 = iDeserializer.getInt32();
            dataSet.entryType = n9 = iDeserializer.getInt32();
            dataSet.generalDescription1 = string2 = iDeserializer.getOptionalString();
            dataSet.generalDescription2 = string = iDeserializer.getOptionalString();
            dataSet.voiceTagId = n8 = iDeserializer.getInt32();
            dataSet.phoneCount = n7 = iDeserializer.getInt32();
            dataSet.probNavigable = n6 = iDeserializer.getInt32();
            dataSet.navigable = n5 = iDeserializer.getInt32();
            dataSet.topDestination = n4 = iDeserializer.getInt32();
            dataSet.contactPicture = resourceLocator = ResourceLocatorSerializer.getOptionalResourceLocator(iDeserializer);
            dataSet.webAddressCount = n3 = iDeserializer.getInt32();
            dataSet.emailCount = n2 = iDeserializer.getInt32();
            dataSet.numberType = n = iDeserializer.getInt32();
            Highlight[] highlightArray = HighlightSerializer.getOptionalHighlightVarArray(iDeserializer);
            dataSet.highlight = highlightArray;
        }
        return dataSet;
    }

    public static DataSet[] getOptionalDataSetVarArray(IDeserializer iDeserializer) {
        DataSet[] dataSetArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            dataSetArray = new DataSet[n];
            for (int i2 = 0; i2 < n; ++i2) {
                dataSetArray[i2] = DataSetSerializer.getOptionalDataSet(iDeserializer);
            }
        }
        return dataSetArray;
    }
}

