/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.carseat.impl;

import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.carseat.MassageProgs;

public class MassageProgsSerializer {
    public static void putOptionalMassageProgs(ISerializer iSerializer, MassageProgs massageProgs) {
        boolean bl = massageProgs == null;
        iSerializer.putBool(bl);
        if (!bl) {
            boolean bl2 = massageProgs.isProgram1Exist();
            iSerializer.putBool(bl2);
            boolean bl3 = massageProgs.isProgram2Exist();
            iSerializer.putBool(bl3);
            boolean bl4 = massageProgs.isProgram3Exist();
            iSerializer.putBool(bl4);
            boolean bl5 = massageProgs.isProgram4Exist();
            iSerializer.putBool(bl5);
            boolean bl6 = massageProgs.isProgram5Exist();
            iSerializer.putBool(bl6);
            boolean bl7 = massageProgs.isProgram6Exist();
            iSerializer.putBool(bl7);
            boolean bl8 = massageProgs.isProgram7Exist();
            iSerializer.putBool(bl8);
            boolean bl9 = massageProgs.isProgram8Exist();
            iSerializer.putBool(bl9);
        }
    }

    public static void putOptionalMassageProgsVarArray(ISerializer iSerializer, MassageProgs[] massageProgsArray) {
        boolean bl = massageProgsArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(massageProgsArray.length);
            for (int i2 = 0; i2 < massageProgsArray.length; ++i2) {
                MassageProgsSerializer.putOptionalMassageProgs(iSerializer, massageProgsArray[i2]);
            }
        }
    }

    public static MassageProgs getOptionalMassageProgs(IDeserializer iDeserializer) {
        MassageProgs massageProgs = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            boolean bl2;
            boolean bl3;
            boolean bl4;
            boolean bl5;
            boolean bl6;
            boolean bl7;
            boolean bl8;
            boolean bl9;
            massageProgs = new MassageProgs();
            massageProgs.program1Exist = bl9 = iDeserializer.getBool();
            massageProgs.program2Exist = bl8 = iDeserializer.getBool();
            massageProgs.program3Exist = bl7 = iDeserializer.getBool();
            massageProgs.program4Exist = bl6 = iDeserializer.getBool();
            massageProgs.program5Exist = bl5 = iDeserializer.getBool();
            massageProgs.program6Exist = bl4 = iDeserializer.getBool();
            massageProgs.program7Exist = bl3 = iDeserializer.getBool();
            massageProgs.program8Exist = bl2 = iDeserializer.getBool();
        }
        return massageProgs;
    }

    public static MassageProgs[] getOptionalMassageProgsVarArray(IDeserializer iDeserializer) {
        MassageProgs[] massageProgsArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            massageProgsArray = new MassageProgs[n];
            for (int i2 = 0; i2 < n; ++i2) {
                massageProgsArray[i2] = MassageProgsSerializer.getOptionalMassageProgs(iDeserializer);
            }
        }
        return massageProgsArray;
    }
}

