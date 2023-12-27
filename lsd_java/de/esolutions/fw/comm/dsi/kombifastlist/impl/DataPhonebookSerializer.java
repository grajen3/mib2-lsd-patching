/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.kombifastlist.impl;

import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.kombifastlist.DataPhonebook;

public class DataPhonebookSerializer {
    public static void putOptionalDataPhonebook(ISerializer iSerializer, DataPhonebook dataPhonebook) {
        boolean bl = dataPhonebook == null;
        iSerializer.putBool(bl);
        if (!bl) {
            int n = dataPhonebook.getPos();
            iSerializer.putInt32(n);
            String string = dataPhonebook.getPbName();
            iSerializer.putOptionalString(string);
            int n2 = dataPhonebook.getStoragePb();
            iSerializer.putInt32(n2);
            int n3 = dataPhonebook.getAnyVoiceTag();
            iSerializer.putInt32(n3);
            int n4 = dataPhonebook.getTelNumberQuantity();
            iSerializer.putInt32(n4);
            String string2 = dataPhonebook.getTelNumber01();
            iSerializer.putOptionalString(string2);
            String string3 = dataPhonebook.getTelNumber02();
            iSerializer.putOptionalString(string3);
            String string4 = dataPhonebook.getTelNumber03();
            iSerializer.putOptionalString(string4);
            String string5 = dataPhonebook.getTelNumber04();
            iSerializer.putOptionalString(string5);
            String string6 = dataPhonebook.getTelNumber05();
            iSerializer.putOptionalString(string6);
            String string7 = dataPhonebook.getTelNumber06();
            iSerializer.putOptionalString(string7);
            String string8 = dataPhonebook.getTelNumber07();
            iSerializer.putOptionalString(string8);
            String string9 = dataPhonebook.getTelNumber08();
            iSerializer.putOptionalString(string9);
            String string10 = dataPhonebook.getTelNumber09();
            iSerializer.putOptionalString(string10);
            String string11 = dataPhonebook.getTelNumber10();
            iSerializer.putOptionalString(string11);
            int n5 = dataPhonebook.getVoiceTag01();
            iSerializer.putInt32(n5);
            int n6 = dataPhonebook.getVoiceTag02();
            iSerializer.putInt32(n6);
            int n7 = dataPhonebook.getVoiceTag03();
            iSerializer.putInt32(n7);
            int n8 = dataPhonebook.getVoiceTag04();
            iSerializer.putInt32(n8);
            int n9 = dataPhonebook.getVoiceTag05();
            iSerializer.putInt32(n9);
            int n10 = dataPhonebook.getVoiceTag06();
            iSerializer.putInt32(n10);
            int n11 = dataPhonebook.getVoiceTag07();
            iSerializer.putInt32(n11);
            int n12 = dataPhonebook.getVoiceTag08();
            iSerializer.putInt32(n12);
            int n13 = dataPhonebook.getVoiceTag09();
            iSerializer.putInt32(n13);
            int n14 = dataPhonebook.getVoiceTag10();
            iSerializer.putInt32(n14);
            int n15 = dataPhonebook.getReserve01();
            iSerializer.putInt32(n15);
            int n16 = dataPhonebook.getReserve02();
            iSerializer.putInt32(n16);
            int n17 = dataPhonebook.getReserve03();
            iSerializer.putInt32(n17);
            int n18 = dataPhonebook.getReserve04();
            iSerializer.putInt32(n18);
            int n19 = dataPhonebook.getReserve05();
            iSerializer.putInt32(n19);
            int n20 = dataPhonebook.getReserve06();
            iSerializer.putInt32(n20);
            int n21 = dataPhonebook.getReserve07();
            iSerializer.putInt32(n21);
            int n22 = dataPhonebook.getReserve08();
            iSerializer.putInt32(n22);
            int n23 = dataPhonebook.getReserve09();
            iSerializer.putInt32(n23);
            int n24 = dataPhonebook.getReserve10();
            iSerializer.putInt32(n24);
            int n25 = dataPhonebook.getNumberType01();
            iSerializer.putInt32(n25);
            int n26 = dataPhonebook.getNumberType02();
            iSerializer.putInt32(n26);
            int n27 = dataPhonebook.getNumberType03();
            iSerializer.putInt32(n27);
            int n28 = dataPhonebook.getNumberType04();
            iSerializer.putInt32(n28);
            int n29 = dataPhonebook.getNumberType05();
            iSerializer.putInt32(n29);
            int n30 = dataPhonebook.getNumberType06();
            iSerializer.putInt32(n30);
            int n31 = dataPhonebook.getNumberType07();
            iSerializer.putInt32(n31);
            int n32 = dataPhonebook.getNumberType08();
            iSerializer.putInt32(n32);
            int n33 = dataPhonebook.getNumberType09();
            iSerializer.putInt32(n33);
            int n34 = dataPhonebook.getNumberType10();
            iSerializer.putInt32(n34);
            int n35 = dataPhonebook.getAdressIndication();
            iSerializer.putInt32(n35);
        }
    }

    public static void putOptionalDataPhonebookVarArray(ISerializer iSerializer, DataPhonebook[] dataPhonebookArray) {
        boolean bl = dataPhonebookArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(dataPhonebookArray.length);
            for (int i2 = 0; i2 < dataPhonebookArray.length; ++i2) {
                DataPhonebookSerializer.putOptionalDataPhonebook(iSerializer, dataPhonebookArray[i2]);
            }
        }
    }

    public static DataPhonebook getOptionalDataPhonebook(IDeserializer iDeserializer) {
        DataPhonebook dataPhonebook = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n;
            int n2;
            int n3;
            int n4;
            int n5;
            int n6;
            int n7;
            int n8;
            int n9;
            int n10;
            int n11;
            int n12;
            int n13;
            int n14;
            int n15;
            int n16;
            int n17;
            int n18;
            int n19;
            int n20;
            int n21;
            int n22;
            int n23;
            int n24;
            int n25;
            int n26;
            int n27;
            int n28;
            int n29;
            int n30;
            int n31;
            String string;
            String string2;
            String string3;
            String string4;
            String string5;
            String string6;
            String string7;
            String string8;
            String string9;
            String string10;
            int n32;
            int n33;
            int n34;
            String string11;
            int n35;
            dataPhonebook = new DataPhonebook();
            dataPhonebook.pos = n35 = iDeserializer.getInt32();
            dataPhonebook.pbName = string11 = iDeserializer.getOptionalString();
            dataPhonebook.storagePb = n34 = iDeserializer.getInt32();
            dataPhonebook.anyVoiceTag = n33 = iDeserializer.getInt32();
            dataPhonebook.telNumberQuantity = n32 = iDeserializer.getInt32();
            dataPhonebook.telNumber01 = string10 = iDeserializer.getOptionalString();
            dataPhonebook.telNumber02 = string9 = iDeserializer.getOptionalString();
            dataPhonebook.telNumber03 = string8 = iDeserializer.getOptionalString();
            dataPhonebook.telNumber04 = string7 = iDeserializer.getOptionalString();
            dataPhonebook.telNumber05 = string6 = iDeserializer.getOptionalString();
            dataPhonebook.telNumber06 = string5 = iDeserializer.getOptionalString();
            dataPhonebook.telNumber07 = string4 = iDeserializer.getOptionalString();
            dataPhonebook.telNumber08 = string3 = iDeserializer.getOptionalString();
            dataPhonebook.telNumber09 = string2 = iDeserializer.getOptionalString();
            dataPhonebook.telNumber10 = string = iDeserializer.getOptionalString();
            dataPhonebook.voiceTag01 = n31 = iDeserializer.getInt32();
            dataPhonebook.voiceTag02 = n30 = iDeserializer.getInt32();
            dataPhonebook.voiceTag03 = n29 = iDeserializer.getInt32();
            dataPhonebook.voiceTag04 = n28 = iDeserializer.getInt32();
            dataPhonebook.voiceTag05 = n27 = iDeserializer.getInt32();
            dataPhonebook.voiceTag06 = n26 = iDeserializer.getInt32();
            dataPhonebook.voiceTag07 = n25 = iDeserializer.getInt32();
            dataPhonebook.voiceTag08 = n24 = iDeserializer.getInt32();
            dataPhonebook.voiceTag09 = n23 = iDeserializer.getInt32();
            dataPhonebook.voiceTag10 = n22 = iDeserializer.getInt32();
            dataPhonebook.reserve01 = n21 = iDeserializer.getInt32();
            dataPhonebook.reserve02 = n20 = iDeserializer.getInt32();
            dataPhonebook.reserve03 = n19 = iDeserializer.getInt32();
            dataPhonebook.reserve04 = n18 = iDeserializer.getInt32();
            dataPhonebook.reserve05 = n17 = iDeserializer.getInt32();
            dataPhonebook.reserve06 = n16 = iDeserializer.getInt32();
            dataPhonebook.reserve07 = n15 = iDeserializer.getInt32();
            dataPhonebook.reserve08 = n14 = iDeserializer.getInt32();
            dataPhonebook.reserve09 = n13 = iDeserializer.getInt32();
            dataPhonebook.reserve10 = n12 = iDeserializer.getInt32();
            dataPhonebook.numberType01 = n11 = iDeserializer.getInt32();
            dataPhonebook.numberType02 = n10 = iDeserializer.getInt32();
            dataPhonebook.numberType03 = n9 = iDeserializer.getInt32();
            dataPhonebook.numberType04 = n8 = iDeserializer.getInt32();
            dataPhonebook.numberType05 = n7 = iDeserializer.getInt32();
            dataPhonebook.numberType06 = n6 = iDeserializer.getInt32();
            dataPhonebook.numberType07 = n5 = iDeserializer.getInt32();
            dataPhonebook.numberType08 = n4 = iDeserializer.getInt32();
            dataPhonebook.numberType09 = n3 = iDeserializer.getInt32();
            dataPhonebook.numberType10 = n2 = iDeserializer.getInt32();
            dataPhonebook.adressIndication = n = iDeserializer.getInt32();
        }
        return dataPhonebook;
    }

    public static DataPhonebook[] getOptionalDataPhonebookVarArray(IDeserializer iDeserializer) {
        DataPhonebook[] dataPhonebookArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            dataPhonebookArray = new DataPhonebook[n];
            for (int i2 = 0; i2 < n; ++i2) {
                dataPhonebookArray[i2] = DataPhonebookSerializer.getOptionalDataPhonebook(iDeserializer);
            }
        }
        return dataPhonebookArray;
    }
}

