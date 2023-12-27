/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.networking.impl;

import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.networking.ApplicationErrorStruct;

public class ApplicationErrorStructSerializer {
    public static void putOptionalApplicationErrorStruct(ISerializer iSerializer, ApplicationErrorStruct applicationErrorStruct) {
        boolean bl = applicationErrorStruct == null;
        iSerializer.putBool(bl);
        if (!bl) {
            int n = applicationErrorStruct.getApplicationID();
            iSerializer.putInt32(n);
            int n2 = applicationErrorStruct.getResult();
            iSerializer.putInt32(n2);
        }
    }

    public static void putOptionalApplicationErrorStructVarArray(ISerializer iSerializer, ApplicationErrorStruct[] applicationErrorStructArray) {
        boolean bl = applicationErrorStructArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(applicationErrorStructArray.length);
            for (int i2 = 0; i2 < applicationErrorStructArray.length; ++i2) {
                ApplicationErrorStructSerializer.putOptionalApplicationErrorStruct(iSerializer, applicationErrorStructArray[i2]);
            }
        }
    }

    public static ApplicationErrorStruct getOptionalApplicationErrorStruct(IDeserializer iDeserializer) {
        ApplicationErrorStruct applicationErrorStruct = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n;
            int n2;
            applicationErrorStruct = new ApplicationErrorStruct();
            applicationErrorStruct.applicationID = n2 = iDeserializer.getInt32();
            applicationErrorStruct.result = n = iDeserializer.getInt32();
        }
        return applicationErrorStruct;
    }

    public static ApplicationErrorStruct[] getOptionalApplicationErrorStructVarArray(IDeserializer iDeserializer) {
        ApplicationErrorStruct[] applicationErrorStructArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            applicationErrorStructArray = new ApplicationErrorStruct[n];
            for (int i2 = 0; i2 < n; ++i2) {
                applicationErrorStructArray[i2] = ApplicationErrorStructSerializer.getOptionalApplicationErrorStruct(iDeserializer);
            }
        }
        return applicationErrorStructArray;
    }
}

