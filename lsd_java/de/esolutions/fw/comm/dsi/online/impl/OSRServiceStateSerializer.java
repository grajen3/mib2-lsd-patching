/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.online.impl;

import de.esolutions.fw.comm.dsi.online.impl.OSRServiceListEntrySerializer;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.online.OSRServiceListEntry;
import org.dsi.ifc.online.OSRServiceState;

public class OSRServiceStateSerializer {
    public static void putOptionalOSRServiceState(ISerializer iSerializer, OSRServiceState oSRServiceState) {
        boolean bl = oSRServiceState == null;
        iSerializer.putBool(bl);
        if (!bl) {
            String string = oSRServiceState.getServiceID();
            iSerializer.putOptionalString(string);
            String string2 = oSRServiceState.getSymbolicName();
            iSerializer.putOptionalString(string2);
            int n = oSRServiceState.getErrorCode();
            iSerializer.putInt32(n);
            int n2 = oSRServiceState.getPrivacyConflict();
            iSerializer.putInt32(n2);
            OSRServiceListEntry oSRServiceListEntry = oSRServiceState.getServiceListEntry();
            OSRServiceListEntrySerializer.putOptionalOSRServiceListEntry(iSerializer, oSRServiceListEntry);
            String[] stringArray = oSRServiceState.getOnlineserviceassignments();
            iSerializer.putOptionalStringVarArray(stringArray);
        }
    }

    public static void putOptionalOSRServiceStateVarArray(ISerializer iSerializer, OSRServiceState[] oSRServiceStateArray) {
        boolean bl = oSRServiceStateArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(oSRServiceStateArray.length);
            for (int i2 = 0; i2 < oSRServiceStateArray.length; ++i2) {
                OSRServiceStateSerializer.putOptionalOSRServiceState(iSerializer, oSRServiceStateArray[i2]);
            }
        }
    }

    public static OSRServiceState getOptionalOSRServiceState(IDeserializer iDeserializer) {
        OSRServiceState oSRServiceState = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            OSRServiceListEntry oSRServiceListEntry;
            int n;
            int n2;
            String string;
            String string2;
            oSRServiceState = new OSRServiceState();
            oSRServiceState.serviceID = string2 = iDeserializer.getOptionalString();
            oSRServiceState.symbolicName = string = iDeserializer.getOptionalString();
            oSRServiceState.errorCode = n2 = iDeserializer.getInt32();
            oSRServiceState.privacyConflict = n = iDeserializer.getInt32();
            oSRServiceState.serviceListEntry = oSRServiceListEntry = OSRServiceListEntrySerializer.getOptionalOSRServiceListEntry(iDeserializer);
            String[] stringArray = iDeserializer.getOptionalStringVarArray();
            oSRServiceState.onlineserviceassignments = stringArray;
        }
        return oSRServiceState;
    }

    public static OSRServiceState[] getOptionalOSRServiceStateVarArray(IDeserializer iDeserializer) {
        OSRServiceState[] oSRServiceStateArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            oSRServiceStateArray = new OSRServiceState[n];
            for (int i2 = 0; i2 < n; ++i2) {
                oSRServiceStateArray[i2] = OSRServiceStateSerializer.getOptionalOSRServiceState(iDeserializer);
            }
        }
        return oSRServiceStateArray;
    }
}

