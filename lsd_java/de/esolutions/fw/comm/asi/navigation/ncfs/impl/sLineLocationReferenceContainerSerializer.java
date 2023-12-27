/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.navigation.ncfs.impl;

import de.esolutions.fw.comm.asi.navigation.ncfs.impl.sOLRLocationReferenceSerializer;
import de.esolutions.fw.comm.asi.navigation.ncfs.impl.sTmcLocationReferenceSerializer;
import de.esolutions.fw.comm.asi.navigation.ncfs.sLineLocationReferenceContainer;
import de.esolutions.fw.comm.asi.navigation.ncfs.sOLRLocationReference;
import de.esolutions.fw.comm.asi.navigation.ncfs.sTmcLocationReference;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;

public class sLineLocationReferenceContainerSerializer {
    public static void putOptionalsLineLocationReferenceContainer(ISerializer iSerializer, sLineLocationReferenceContainer sLineLocationReferenceContainer2) {
        boolean bl = sLineLocationReferenceContainer2 == null;
        iSerializer.putBool(bl);
        if (!bl) {
            int n = sLineLocationReferenceContainer2.getValidLocationReference();
            iSerializer.putEnum(n);
            sOLRLocationReference sOLRLocationReference2 = sLineLocationReferenceContainer2.getOLRLocation();
            sOLRLocationReferenceSerializer.putOptionalsOLRLocationReference(iSerializer, sOLRLocationReference2);
            sTmcLocationReference sTmcLocationReference2 = sLineLocationReferenceContainer2.getTMCLocation();
            sTmcLocationReferenceSerializer.putOptionalsTmcLocationReference(iSerializer, sTmcLocationReference2);
        }
    }

    public static void putOptionalsLineLocationReferenceContainerVarArray(ISerializer iSerializer, sLineLocationReferenceContainer[] sLineLocationReferenceContainerArray) {
        boolean bl = sLineLocationReferenceContainerArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(sLineLocationReferenceContainerArray.length);
            for (int i2 = 0; i2 < sLineLocationReferenceContainerArray.length; ++i2) {
                sLineLocationReferenceContainerSerializer.putOptionalsLineLocationReferenceContainer(iSerializer, sLineLocationReferenceContainerArray[i2]);
            }
        }
    }

    public static sLineLocationReferenceContainer getOptionalsLineLocationReferenceContainer(IDeserializer iDeserializer) {
        sLineLocationReferenceContainer sLineLocationReferenceContainer2 = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            sTmcLocationReference sTmcLocationReference2;
            sOLRLocationReference sOLRLocationReference2;
            int n;
            sLineLocationReferenceContainer2 = new sLineLocationReferenceContainer();
            sLineLocationReferenceContainer2.validLocationReference = n = iDeserializer.getEnum();
            sLineLocationReferenceContainer2.OLRLocation = sOLRLocationReference2 = sOLRLocationReferenceSerializer.getOptionalsOLRLocationReference(iDeserializer);
            sLineLocationReferenceContainer2.TMCLocation = sTmcLocationReference2 = sTmcLocationReferenceSerializer.getOptionalsTmcLocationReference(iDeserializer);
        }
        return sLineLocationReferenceContainer2;
    }

    public static sLineLocationReferenceContainer[] getOptionalsLineLocationReferenceContainerVarArray(IDeserializer iDeserializer) {
        sLineLocationReferenceContainer[] sLineLocationReferenceContainerArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            sLineLocationReferenceContainerArray = new sLineLocationReferenceContainer[n];
            for (int i2 = 0; i2 < n; ++i2) {
                sLineLocationReferenceContainerArray[i2] = sLineLocationReferenceContainerSerializer.getOptionalsLineLocationReferenceContainer(iDeserializer);
            }
        }
        return sLineLocationReferenceContainerArray;
    }
}

