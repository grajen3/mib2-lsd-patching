/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.filebrowser.impl;

import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.filebrowser.BrowsedFile;

public class BrowsedFileSerializer {
    public static void putOptionalBrowsedFile(ISerializer iSerializer, BrowsedFile browsedFile) {
        boolean bl = browsedFile == null;
        iSerializer.putBool(bl);
        if (!bl) {
            long l = browsedFile.getId();
            iSerializer.putInt64(l);
            boolean bl2 = browsedFile.isSelected();
            iSerializer.putBool(bl2);
            String string = browsedFile.getFilename();
            iSerializer.putOptionalString(string);
            int n = browsedFile.getFileType();
            iSerializer.putInt32(n);
            long l2 = browsedFile.getFileSize();
            iSerializer.putInt64(l2);
        }
    }

    public static void putOptionalBrowsedFileVarArray(ISerializer iSerializer, BrowsedFile[] browsedFileArray) {
        boolean bl = browsedFileArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(browsedFileArray.length);
            for (int i2 = 0; i2 < browsedFileArray.length; ++i2) {
                BrowsedFileSerializer.putOptionalBrowsedFile(iSerializer, browsedFileArray[i2]);
            }
        }
    }

    public static BrowsedFile getOptionalBrowsedFile(IDeserializer iDeserializer) {
        BrowsedFile browsedFile = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            long l;
            int n;
            String string;
            boolean bl2;
            long l2;
            browsedFile = new BrowsedFile();
            browsedFile.id = l2 = iDeserializer.getInt64();
            browsedFile.selected = bl2 = iDeserializer.getBool();
            browsedFile.filename = string = iDeserializer.getOptionalString();
            browsedFile.fileType = n = iDeserializer.getInt32();
            browsedFile.fileSize = l = iDeserializer.getInt64();
        }
        return browsedFile;
    }

    public static BrowsedFile[] getOptionalBrowsedFileVarArray(IDeserializer iDeserializer) {
        BrowsedFile[] browsedFileArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            browsedFileArray = new BrowsedFile[n];
            for (int i2 = 0; i2 < n; ++i2) {
                browsedFileArray[i2] = BrowsedFileSerializer.getOptionalBrowsedFile(iDeserializer);
            }
        }
        return browsedFileArray;
    }
}

