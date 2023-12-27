/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.telephoneng.impl;

import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.telephoneng.EmergencyNumbers;

public class EmergencyNumbersSerializer {
    public static void putOptionalEmergencyNumbers(ISerializer iSerializer, EmergencyNumbers emergencyNumbers) {
        boolean bl = emergencyNumbers == null;
        iSerializer.putBool(bl);
        if (!bl) {
            String string = emergencyNumbers.getMainEmergencyNumber();
            iSerializer.putOptionalString(string);
            String[] stringArray = emergencyNumbers.getAdditionalEmergencyNumber();
            iSerializer.putOptionalStringVarArray(stringArray);
        }
    }

    public static void putOptionalEmergencyNumbersVarArray(ISerializer iSerializer, EmergencyNumbers[] emergencyNumbersArray) {
        boolean bl = emergencyNumbersArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(emergencyNumbersArray.length);
            for (int i2 = 0; i2 < emergencyNumbersArray.length; ++i2) {
                EmergencyNumbersSerializer.putOptionalEmergencyNumbers(iSerializer, emergencyNumbersArray[i2]);
            }
        }
    }

    public static EmergencyNumbers getOptionalEmergencyNumbers(IDeserializer iDeserializer) {
        EmergencyNumbers emergencyNumbers = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            String string;
            emergencyNumbers = new EmergencyNumbers();
            emergencyNumbers.mainEmergencyNumber = string = iDeserializer.getOptionalString();
            String[] stringArray = iDeserializer.getOptionalStringVarArray();
            emergencyNumbers.additionalEmergencyNumber = stringArray;
        }
        return emergencyNumbers;
    }

    public static EmergencyNumbers[] getOptionalEmergencyNumbersVarArray(IDeserializer iDeserializer) {
        EmergencyNumbers[] emergencyNumbersArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            emergencyNumbersArray = new EmergencyNumbers[n];
            for (int i2 = 0; i2 < n; ++i2) {
                emergencyNumbersArray[i2] = EmergencyNumbersSerializer.getOptionalEmergencyNumbers(iDeserializer);
            }
        }
        return emergencyNumbersArray;
    }
}

