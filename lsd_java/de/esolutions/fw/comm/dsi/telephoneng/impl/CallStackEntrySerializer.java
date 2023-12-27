/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.telephoneng.impl;

import de.esolutions.fw.comm.dsi.global.impl.ResourceLocatorSerializer;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.global.ResourceLocator;
import org.dsi.ifc.telephoneng.CallStackEntry;

public class CallStackEntrySerializer {
    public static void putOptionalCallStackEntry(ISerializer iSerializer, CallStackEntry callStackEntry) {
        boolean bl = callStackEntry == null;
        iSerializer.putBool(bl);
        if (!bl) {
            int n = callStackEntry.getClEntryID();
            iSerializer.putInt32(n);
            String string = callStackEntry.getClNumber();
            iSerializer.putOptionalString(string);
            String string2 = callStackEntry.getClName();
            iSerializer.putOptionalString(string2);
            String string3 = callStackEntry.getLastName();
            iSerializer.putOptionalString(string3);
            String string4 = callStackEntry.getFirstName();
            iSerializer.putOptionalString(string4);
            String string5 = callStackEntry.getOrganization();
            iSerializer.putOptionalString(string5);
            int n2 = callStackEntry.getClEntryOrigin();
            iSerializer.putInt32(n2);
            int n3 = callStackEntry.getClEntryType();
            iSerializer.putInt32(n3);
            short s = callStackEntry.getClYear();
            iSerializer.putInt16(s);
            short s2 = callStackEntry.getClMonth();
            iSerializer.putInt16(s2);
            short s3 = callStackEntry.getClDay();
            iSerializer.putInt16(s3);
            short s4 = callStackEntry.getClHour();
            iSerializer.putInt16(s4);
            short s5 = callStackEntry.getClMinute();
            iSerializer.putInt16(s5);
            short s6 = callStackEntry.getClSecond();
            iSerializer.putInt16(s6);
            ResourceLocator resourceLocator = callStackEntry.getAdbPictureID();
            ResourceLocatorSerializer.putOptionalResourceLocator(iSerializer, resourceLocator);
            long l = callStackEntry.getAdbEntryID();
            iSerializer.putInt64(l);
            int n4 = callStackEntry.getAdbPhoneDataIndex();
            iSerializer.putInt32(n4);
            int n5 = callStackEntry.getAdbPhoneDataCount();
            iSerializer.putInt32(n5);
            int n6 = callStackEntry.getNewMissedCallAttempts();
            iSerializer.putInt32(n6);
            int n7 = callStackEntry.getAdbNumberType();
            iSerializer.putInt32(n7);
        }
    }

    public static void putOptionalCallStackEntryVarArray(ISerializer iSerializer, CallStackEntry[] callStackEntryArray) {
        boolean bl = callStackEntryArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(callStackEntryArray.length);
            for (int i2 = 0; i2 < callStackEntryArray.length; ++i2) {
                CallStackEntrySerializer.putOptionalCallStackEntry(iSerializer, callStackEntryArray[i2]);
            }
        }
    }

    public static CallStackEntry getOptionalCallStackEntry(IDeserializer iDeserializer) {
        CallStackEntry callStackEntry = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n;
            int n2;
            int n3;
            int n4;
            long l;
            ResourceLocator resourceLocator;
            short s;
            short s2;
            short s3;
            short s4;
            short s5;
            short s6;
            int n5;
            int n6;
            String string;
            String string2;
            String string3;
            String string4;
            String string5;
            int n7;
            callStackEntry = new CallStackEntry();
            callStackEntry.clEntryID = n7 = iDeserializer.getInt32();
            callStackEntry.clNumber = string5 = iDeserializer.getOptionalString();
            callStackEntry.clName = string4 = iDeserializer.getOptionalString();
            callStackEntry.lastName = string3 = iDeserializer.getOptionalString();
            callStackEntry.firstName = string2 = iDeserializer.getOptionalString();
            callStackEntry.organization = string = iDeserializer.getOptionalString();
            callStackEntry.clEntryOrigin = n6 = iDeserializer.getInt32();
            callStackEntry.clEntryType = n5 = iDeserializer.getInt32();
            callStackEntry.clYear = s6 = iDeserializer.getInt16();
            callStackEntry.clMonth = s5 = iDeserializer.getInt16();
            callStackEntry.clDay = s4 = iDeserializer.getInt16();
            callStackEntry.clHour = s3 = iDeserializer.getInt16();
            callStackEntry.clMinute = s2 = iDeserializer.getInt16();
            callStackEntry.clSecond = s = iDeserializer.getInt16();
            callStackEntry.adbPictureID = resourceLocator = ResourceLocatorSerializer.getOptionalResourceLocator(iDeserializer);
            callStackEntry.adbEntryID = l = iDeserializer.getInt64();
            callStackEntry.adbPhoneDataIndex = n4 = iDeserializer.getInt32();
            callStackEntry.adbPhoneDataCount = n3 = iDeserializer.getInt32();
            callStackEntry.newMissedCallAttempts = n2 = iDeserializer.getInt32();
            callStackEntry.adbNumberType = n = iDeserializer.getInt32();
        }
        return callStackEntry;
    }

    public static CallStackEntry[] getOptionalCallStackEntryVarArray(IDeserializer iDeserializer) {
        CallStackEntry[] callStackEntryArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            callStackEntryArray = new CallStackEntry[n];
            for (int i2 = 0; i2 < n; ++i2) {
                callStackEntryArray[i2] = CallStackEntrySerializer.getOptionalCallStackEntry(iDeserializer);
            }
        }
        return callStackEntryArray;
    }
}

