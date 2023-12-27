/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.search.impl;

import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.search.Environment;

public class EnvironmentSerializer {
    public static void putOptionalEnvironment(ISerializer iSerializer, Environment environment) {
        boolean bl = environment == null;
        iSerializer.putBool(bl);
        if (!bl) {
            String string = environment.getOem();
            iSerializer.putOptionalString(string);
            String string2 = environment.getRegion();
            iSerializer.putOptionalString(string2);
            String string3 = environment.getCountryCoding();
            iSerializer.putOptionalString(string3);
            String string4 = environment.getDealer();
            iSerializer.putOptionalString(string4);
        }
    }

    public static void putOptionalEnvironmentVarArray(ISerializer iSerializer, Environment[] environmentArray) {
        boolean bl = environmentArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(environmentArray.length);
            for (int i2 = 0; i2 < environmentArray.length; ++i2) {
                EnvironmentSerializer.putOptionalEnvironment(iSerializer, environmentArray[i2]);
            }
        }
    }

    public static Environment getOptionalEnvironment(IDeserializer iDeserializer) {
        Environment environment = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            String string;
            String string2;
            String string3;
            String string4;
            environment = new Environment();
            environment.oem = string4 = iDeserializer.getOptionalString();
            environment.region = string3 = iDeserializer.getOptionalString();
            environment.countryCoding = string2 = iDeserializer.getOptionalString();
            environment.dealer = string = iDeserializer.getOptionalString();
        }
        return environment;
    }

    public static Environment[] getOptionalEnvironmentVarArray(IDeserializer iDeserializer) {
        Environment[] environmentArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            environmentArray = new Environment[n];
            for (int i2 = 0; i2 < n; ++i2) {
                environmentArray[i2] = EnvironmentSerializer.getOptionalEnvironment(iDeserializer);
            }
        }
        return environmentArray;
    }
}

