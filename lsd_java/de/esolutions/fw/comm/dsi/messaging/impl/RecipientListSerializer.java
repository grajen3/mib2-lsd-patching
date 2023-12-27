/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.messaging.impl;

import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.messaging.RecipientList;

public class RecipientListSerializer {
    public static void putOptionalRecipientList(ISerializer iSerializer, RecipientList recipientList) {
        boolean bl = recipientList == null;
        iSerializer.putBool(bl);
        if (!bl) {
            String[] stringArray = recipientList.getTo();
            iSerializer.putOptionalStringVarArray(stringArray);
            String[] stringArray2 = recipientList.getCc();
            iSerializer.putOptionalStringVarArray(stringArray2);
            String[] stringArray3 = recipientList.getBcc();
            iSerializer.putOptionalStringVarArray(stringArray3);
        }
    }

    public static void putOptionalRecipientListVarArray(ISerializer iSerializer, RecipientList[] recipientListArray) {
        boolean bl = recipientListArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(recipientListArray.length);
            for (int i2 = 0; i2 < recipientListArray.length; ++i2) {
                RecipientListSerializer.putOptionalRecipientList(iSerializer, recipientListArray[i2]);
            }
        }
    }

    public static RecipientList getOptionalRecipientList(IDeserializer iDeserializer) {
        RecipientList recipientList = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            recipientList = new RecipientList();
            String[] stringArray = iDeserializer.getOptionalStringVarArray();
            recipientList.to = stringArray;
            String[] stringArray2 = iDeserializer.getOptionalStringVarArray();
            recipientList.cc = stringArray2;
            String[] stringArray3 = iDeserializer.getOptionalStringVarArray();
            recipientList.bcc = stringArray3;
        }
        return recipientList;
    }

    public static RecipientList[] getOptionalRecipientListVarArray(IDeserializer iDeserializer) {
        RecipientList[] recipientListArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            recipientListArray = new RecipientList[n];
            for (int i2 = 0; i2 < n; ++i2) {
                recipientListArray[i2] = RecipientListSerializer.getOptionalRecipientList(iDeserializer);
            }
        }
        return recipientListArray;
    }
}

