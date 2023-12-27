/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.carparkingsystem.impl;

import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.carparkingsystem.ARACurrentTrailerAngle;

public class ARACurrentTrailerAngleSerializer {
    public static void putOptionalARACurrentTrailerAngle(ISerializer iSerializer, ARACurrentTrailerAngle aRACurrentTrailerAngle) {
        boolean bl = aRACurrentTrailerAngle == null;
        iSerializer.putBool(bl);
        if (!bl) {
            int n = aRACurrentTrailerAngle.getAngle();
            iSerializer.putInt32(n);
            boolean bl2 = aRACurrentTrailerAngle.isValid();
            iSerializer.putBool(bl2);
        }
    }

    public static void putOptionalARACurrentTrailerAngleVarArray(ISerializer iSerializer, ARACurrentTrailerAngle[] aRACurrentTrailerAngleArray) {
        boolean bl = aRACurrentTrailerAngleArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(aRACurrentTrailerAngleArray.length);
            for (int i2 = 0; i2 < aRACurrentTrailerAngleArray.length; ++i2) {
                ARACurrentTrailerAngleSerializer.putOptionalARACurrentTrailerAngle(iSerializer, aRACurrentTrailerAngleArray[i2]);
            }
        }
    }

    public static ARACurrentTrailerAngle getOptionalARACurrentTrailerAngle(IDeserializer iDeserializer) {
        ARACurrentTrailerAngle aRACurrentTrailerAngle = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            boolean bl2;
            int n;
            aRACurrentTrailerAngle = new ARACurrentTrailerAngle();
            aRACurrentTrailerAngle.angle = n = iDeserializer.getInt32();
            aRACurrentTrailerAngle.valid = bl2 = iDeserializer.getBool();
        }
        return aRACurrentTrailerAngle;
    }

    public static ARACurrentTrailerAngle[] getOptionalARACurrentTrailerAngleVarArray(IDeserializer iDeserializer) {
        ARACurrentTrailerAngle[] aRACurrentTrailerAngleArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            aRACurrentTrailerAngleArray = new ARACurrentTrailerAngle[n];
            for (int i2 = 0; i2 < n; ++i2) {
                aRACurrentTrailerAngleArray[i2] = ARACurrentTrailerAngleSerializer.getOptionalARACurrentTrailerAngle(iDeserializer);
            }
        }
        return aRACurrentTrailerAngleArray;
    }
}

