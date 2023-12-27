/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.telephone.impl;

import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.telephone.ServiceNumbers;

public class ServiceNumbersSerializer {
    public static void putOptionalServiceNumbers(ISerializer iSerializer, ServiceNumbers serviceNumbers) {
        boolean bl = serviceNumbers == null;
        iSerializer.putBool(bl);
        if (!bl) {
            String string = serviceNumbers.getInfonumber();
            iSerializer.putOptionalString(string);
            String string2 = serviceNumbers.getInfonumberRoaming();
            iSerializer.putOptionalString(string2);
            String string3 = serviceNumbers.getBreakdownNumber();
            iSerializer.putOptionalString(string3);
            String string4 = serviceNumbers.getBreakdownNumberRoaming();
            iSerializer.putOptionalString(string4);
        }
    }

    public static void putOptionalServiceNumbersVarArray(ISerializer iSerializer, ServiceNumbers[] serviceNumbersArray) {
        boolean bl = serviceNumbersArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(serviceNumbersArray.length);
            for (int i2 = 0; i2 < serviceNumbersArray.length; ++i2) {
                ServiceNumbersSerializer.putOptionalServiceNumbers(iSerializer, serviceNumbersArray[i2]);
            }
        }
    }

    public static ServiceNumbers getOptionalServiceNumbers(IDeserializer iDeserializer) {
        ServiceNumbers serviceNumbers = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            String string;
            String string2;
            String string3;
            String string4;
            serviceNumbers = new ServiceNumbers();
            serviceNumbers.infonumber = string4 = iDeserializer.getOptionalString();
            serviceNumbers.infonumberRoaming = string3 = iDeserializer.getOptionalString();
            serviceNumbers.breakdownNumber = string2 = iDeserializer.getOptionalString();
            serviceNumbers.breakdownNumberRoaming = string = iDeserializer.getOptionalString();
        }
        return serviceNumbers;
    }

    public static ServiceNumbers[] getOptionalServiceNumbersVarArray(IDeserializer iDeserializer) {
        ServiceNumbers[] serviceNumbersArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            serviceNumbersArray = new ServiceNumbers[n];
            for (int i2 = 0; i2 < n; ++i2) {
                serviceNumbersArray[i2] = ServiceNumbersSerializer.getOptionalServiceNumbers(iDeserializer);
            }
        }
        return serviceNumbersArray;
    }
}

