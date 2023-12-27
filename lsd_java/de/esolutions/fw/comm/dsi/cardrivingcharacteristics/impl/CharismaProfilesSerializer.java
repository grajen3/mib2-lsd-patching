/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.cardrivingcharacteristics.impl;

import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.cardrivingcharacteristics.CharismaProfiles;

public class CharismaProfilesSerializer {
    public static void putOptionalCharismaProfiles(ISerializer iSerializer, CharismaProfiles charismaProfiles) {
        boolean bl = charismaProfiles == null;
        iSerializer.putBool(bl);
        if (!bl) {
            boolean bl2 = charismaProfiles.isComfort();
            iSerializer.putBool(bl2);
            boolean bl3 = charismaProfiles.isAutonormal();
            iSerializer.putBool(bl3);
            boolean bl4 = charismaProfiles.isDynamic();
            iSerializer.putBool(bl4);
            boolean bl5 = charismaProfiles.isOffroadallroad();
            iSerializer.putBool(bl5);
            boolean bl6 = charismaProfiles.isEfficiency();
            iSerializer.putBool(bl6);
            boolean bl7 = charismaProfiles.isRacesport();
            iSerializer.putBool(bl7);
            boolean bl8 = charismaProfiles.isIndividual();
            iSerializer.putBool(bl8);
            boolean bl9 = charismaProfiles.isRange();
            iSerializer.putBool(bl9);
            boolean bl10 = charismaProfiles.isLift();
            iSerializer.putBool(bl10);
            boolean bl11 = charismaProfiles.isOffroadlevel2();
            iSerializer.putBool(bl11);
            boolean bl12 = charismaProfiles.isOffroadlevel3();
            iSerializer.putBool(bl12);
            boolean bl13 = charismaProfiles.isOffroadlevel4();
            iSerializer.putBool(bl13);
        }
    }

    public static void putOptionalCharismaProfilesVarArray(ISerializer iSerializer, CharismaProfiles[] charismaProfilesArray) {
        boolean bl = charismaProfilesArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(charismaProfilesArray.length);
            for (int i2 = 0; i2 < charismaProfilesArray.length; ++i2) {
                CharismaProfilesSerializer.putOptionalCharismaProfiles(iSerializer, charismaProfilesArray[i2]);
            }
        }
    }

    public static CharismaProfiles getOptionalCharismaProfiles(IDeserializer iDeserializer) {
        CharismaProfiles charismaProfiles = null;
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
            boolean bl10;
            boolean bl11;
            boolean bl12;
            boolean bl13;
            charismaProfiles = new CharismaProfiles();
            charismaProfiles.comfort = bl13 = iDeserializer.getBool();
            charismaProfiles.autonormal = bl12 = iDeserializer.getBool();
            charismaProfiles.dynamic = bl11 = iDeserializer.getBool();
            charismaProfiles.offroadallroad = bl10 = iDeserializer.getBool();
            charismaProfiles.efficiency = bl9 = iDeserializer.getBool();
            charismaProfiles.racesport = bl8 = iDeserializer.getBool();
            charismaProfiles.individual = bl7 = iDeserializer.getBool();
            charismaProfiles.range = bl6 = iDeserializer.getBool();
            charismaProfiles.lift = bl5 = iDeserializer.getBool();
            charismaProfiles.offroadlevel2 = bl4 = iDeserializer.getBool();
            charismaProfiles.offroadlevel3 = bl3 = iDeserializer.getBool();
            charismaProfiles.offroadlevel4 = bl2 = iDeserializer.getBool();
        }
        return charismaProfiles;
    }

    public static CharismaProfiles[] getOptionalCharismaProfilesVarArray(IDeserializer iDeserializer) {
        CharismaProfiles[] charismaProfilesArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            charismaProfilesArray = new CharismaProfiles[n];
            for (int i2 = 0; i2 < n; ++i2) {
                charismaProfilesArray[i2] = CharismaProfilesSerializer.getOptionalCharismaProfiles(iDeserializer);
            }
        }
        return charismaProfilesArray;
    }
}

