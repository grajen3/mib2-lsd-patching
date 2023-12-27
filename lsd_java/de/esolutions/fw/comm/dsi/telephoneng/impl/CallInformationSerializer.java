/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.telephoneng.impl;

import de.esolutions.fw.comm.dsi.global.impl.ResourceLocatorSerializer;
import de.esolutions.fw.comm.dsi.telephoneng.impl.CallInformationExtSerializer;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.global.ResourceLocator;
import org.dsi.ifc.telephoneng.CallInformation;
import org.dsi.ifc.telephoneng.CallInformationExt;

public class CallInformationSerializer {
    public static void putOptionalCallInformation(ISerializer iSerializer, CallInformation callInformation) {
        boolean bl = callInformation == null;
        iSerializer.putBool(bl);
        if (!bl) {
            short s = callInformation.getTelCallID();
            iSerializer.putInt16(s);
            int n = callInformation.getTelCallState();
            iSerializer.putInt32(n);
            int n2 = callInformation.getTelMpty();
            iSerializer.putInt32(n2);
            String string = callInformation.getTelRemName();
            iSerializer.putOptionalString(string);
            String string2 = callInformation.getTelRemLastName();
            iSerializer.putOptionalString(string2);
            String string3 = callInformation.getTelRemFirstName();
            iSerializer.putOptionalString(string3);
            String string4 = callInformation.getTelRemOrganization();
            iSerializer.putOptionalString(string4);
            String string5 = callInformation.getTelRemNumber();
            iSerializer.putOptionalString(string5);
            ResourceLocator resourceLocator = callInformation.getTelRemPictureId();
            ResourceLocatorSerializer.putOptionalResourceLocator(iSerializer, resourceLocator);
            short s2 = callInformation.getTelNumType();
            iSerializer.putInt16(s2);
            int n3 = callInformation.getTelCallType();
            iSerializer.putInt32(n3);
            long l = callInformation.getTelRemEntryId();
            iSerializer.putInt64(l);
            int n4 = callInformation.getTelRemNumberType();
            iSerializer.putInt32(n4);
            int n5 = callInformation.getTelCallStartingTime();
            iSerializer.putInt32(n5);
            CallInformationExt callInformationExt = callInformation.getExtendedCallInformation();
            CallInformationExtSerializer.putOptionalCallInformationExt(iSerializer, callInformationExt);
            int n6 = callInformation.getTelCallCarrier();
            iSerializer.putInt32(n6);
        }
    }

    public static void putOptionalCallInformationVarArray(ISerializer iSerializer, CallInformation[] callInformationArray) {
        boolean bl = callInformationArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(callInformationArray.length);
            for (int i2 = 0; i2 < callInformationArray.length; ++i2) {
                CallInformationSerializer.putOptionalCallInformation(iSerializer, callInformationArray[i2]);
            }
        }
    }

    public static CallInformation getOptionalCallInformation(IDeserializer iDeserializer) {
        CallInformation callInformation = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n;
            CallInformationExt callInformationExt;
            int n2;
            int n3;
            long l;
            int n4;
            short s;
            ResourceLocator resourceLocator;
            String string;
            String string2;
            String string3;
            String string4;
            String string5;
            int n5;
            int n6;
            short s2;
            callInformation = new CallInformation();
            callInformation.telCallID = s2 = iDeserializer.getInt16();
            callInformation.telCallState = n6 = iDeserializer.getInt32();
            callInformation.telMpty = n5 = iDeserializer.getInt32();
            callInformation.telRemName = string5 = iDeserializer.getOptionalString();
            callInformation.telRemLastName = string4 = iDeserializer.getOptionalString();
            callInformation.telRemFirstName = string3 = iDeserializer.getOptionalString();
            callInformation.telRemOrganization = string2 = iDeserializer.getOptionalString();
            callInformation.telRemNumber = string = iDeserializer.getOptionalString();
            callInformation.telRemPictureId = resourceLocator = ResourceLocatorSerializer.getOptionalResourceLocator(iDeserializer);
            callInformation.telNumType = s = iDeserializer.getInt16();
            callInformation.telCallType = n4 = iDeserializer.getInt32();
            callInformation.telRemEntryId = l = iDeserializer.getInt64();
            callInformation.telRemNumberType = n3 = iDeserializer.getInt32();
            callInformation.telCallStartingTime = n2 = iDeserializer.getInt32();
            callInformation.extendedCallInformation = callInformationExt = CallInformationExtSerializer.getOptionalCallInformationExt(iDeserializer);
            callInformation.telCallCarrier = n = iDeserializer.getInt32();
        }
        return callInformation;
    }

    public static CallInformation[] getOptionalCallInformationVarArray(IDeserializer iDeserializer) {
        CallInformation[] callInformationArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            callInformationArray = new CallInformation[n];
            for (int i2 = 0; i2 < n; ++i2) {
                callInformationArray[i2] = CallInformationSerializer.getOptionalCallInformation(iDeserializer);
            }
        }
        return callInformationArray;
    }
}

