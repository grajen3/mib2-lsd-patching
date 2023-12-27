/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.messaging.impl;

import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.messaging.ListChangedInformation;

public class ListChangedInformationSerializer {
    public static void putOptionalListChangedInformation(ISerializer iSerializer, ListChangedInformation listChangedInformation) {
        boolean bl = listChangedInformation == null;
        iSerializer.putBool(bl);
        if (!bl) {
            int n = listChangedInformation.getReason();
            iSerializer.putInt32(n);
            int n2 = listChangedInformation.getListSize();
            iSerializer.putInt32(n2);
        }
    }

    public static void putOptionalListChangedInformationVarArray(ISerializer iSerializer, ListChangedInformation[] listChangedInformationArray) {
        boolean bl = listChangedInformationArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(listChangedInformationArray.length);
            for (int i2 = 0; i2 < listChangedInformationArray.length; ++i2) {
                ListChangedInformationSerializer.putOptionalListChangedInformation(iSerializer, listChangedInformationArray[i2]);
            }
        }
    }

    public static ListChangedInformation getOptionalListChangedInformation(IDeserializer iDeserializer) {
        ListChangedInformation listChangedInformation = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n;
            int n2;
            listChangedInformation = new ListChangedInformation();
            listChangedInformation.reason = n2 = iDeserializer.getInt32();
            listChangedInformation.listSize = n = iDeserializer.getInt32();
        }
        return listChangedInformation;
    }

    public static ListChangedInformation[] getOptionalListChangedInformationVarArray(IDeserializer iDeserializer) {
        ListChangedInformation[] listChangedInformationArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            listChangedInformationArray = new ListChangedInformation[n];
            for (int i2 = 0; i2 < n; ++i2) {
                listChangedInformationArray[i2] = ListChangedInformationSerializer.getOptionalListChangedInformation(iDeserializer);
            }
        }
        return listChangedInformationArray;
    }
}

