/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.ddp20.impl;

import de.esolutions.fw.comm.dsi.ddp20.impl.ProjectInfoSerializer;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.ddp20.ProjectInfo;
import org.dsi.ifc.ddp20.VersionInfo;

public class VersionInfoSerializer {
    public static void putOptionalVersionInfo(ISerializer iSerializer, VersionInfo versionInfo) {
        boolean bl = versionInfo == null;
        iSerializer.putBool(bl);
        if (!bl) {
            int n = versionInfo.getIdent();
            iSerializer.putInt32(n);
            int n2 = versionInfo.getManufacturer();
            iSerializer.putInt32(n2);
            String string = versionInfo.getSwInfo();
            iSerializer.putOptionalString(string);
            ProjectInfo projectInfo = versionInfo.getProjectInfo();
            ProjectInfoSerializer.putOptionalProjectInfo(iSerializer, projectInfo);
            int n3 = versionInfo.getProtocolVersion();
            iSerializer.putInt32(n3);
            int n4 = versionInfo.getCharacterVersion();
            iSerializer.putInt32(n4);
            int n5 = versionInfo.getSymbolVersion();
            iSerializer.putInt32(n5);
            int n6 = versionInfo.getFrameVersion();
            iSerializer.putInt32(n6);
            int n7 = versionInfo.getBitmapVersion();
            iSerializer.putInt32(n7);
            int n8 = versionInfo.getDisplayInfo();
            iSerializer.putInt32(n8);
            boolean bl2 = versionInfo.isWindowCaching();
            iSerializer.putBool(bl2);
            int n9 = versionInfo.getNumEntriesMenu();
            iSerializer.putInt32(n9);
            int n10 = versionInfo.getNumEntriesSubmenu();
            iSerializer.putInt32(n10);
            int n11 = versionInfo.getNumEntriesPopup();
            iSerializer.putInt32(n11);
            int n12 = versionInfo.getNumLaneGuidanceBoxes();
            iSerializer.putInt32(n12);
            int n13 = versionInfo.getNumFrameIDs();
            iSerializer.putInt32(n13);
            int[] nArray = versionInfo.getFrameIDs();
            iSerializer.putOptionalInt32VarArray(nArray);
        }
    }

    public static void putOptionalVersionInfoVarArray(ISerializer iSerializer, VersionInfo[] versionInfoArray) {
        boolean bl = versionInfoArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(versionInfoArray.length);
            for (int i2 = 0; i2 < versionInfoArray.length; ++i2) {
                VersionInfoSerializer.putOptionalVersionInfo(iSerializer, versionInfoArray[i2]);
            }
        }
    }

    public static VersionInfo getOptionalVersionInfo(IDeserializer iDeserializer) {
        VersionInfo versionInfo = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n;
            int n2;
            int n3;
            int n4;
            int n5;
            boolean bl2;
            int n6;
            int n7;
            int n8;
            int n9;
            int n10;
            int n11;
            ProjectInfo projectInfo;
            String string;
            int n12;
            int n13;
            versionInfo = new VersionInfo();
            versionInfo.ident = n13 = iDeserializer.getInt32();
            versionInfo.manufacturer = n12 = iDeserializer.getInt32();
            versionInfo.swInfo = string = iDeserializer.getOptionalString();
            versionInfo.projectInfo = projectInfo = ProjectInfoSerializer.getOptionalProjectInfo(iDeserializer);
            versionInfo.protocolVersion = n11 = iDeserializer.getInt32();
            versionInfo.characterVersion = n10 = iDeserializer.getInt32();
            versionInfo.symbolVersion = n9 = iDeserializer.getInt32();
            versionInfo.frameVersion = n8 = iDeserializer.getInt32();
            versionInfo.bitmapVersion = n7 = iDeserializer.getInt32();
            versionInfo.displayInfo = n6 = iDeserializer.getInt32();
            versionInfo.windowCaching = bl2 = iDeserializer.getBool();
            versionInfo.numEntriesMenu = n5 = iDeserializer.getInt32();
            versionInfo.numEntriesSubmenu = n4 = iDeserializer.getInt32();
            versionInfo.numEntriesPopup = n3 = iDeserializer.getInt32();
            versionInfo.numLaneGuidanceBoxes = n2 = iDeserializer.getInt32();
            versionInfo.numFrameIDs = n = iDeserializer.getInt32();
            int[] nArray = iDeserializer.getOptionalInt32VarArray();
            versionInfo.frameIDs = nArray;
        }
        return versionInfo;
    }

    public static VersionInfo[] getOptionalVersionInfoVarArray(IDeserializer iDeserializer) {
        VersionInfo[] versionInfoArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            versionInfoArray = new VersionInfo[n];
            for (int i2 = 0; i2 < n; ++i2) {
                versionInfoArray[i2] = VersionInfoSerializer.getOptionalVersionInfo(iDeserializer);
            }
        }
        return versionInfoArray;
    }
}

