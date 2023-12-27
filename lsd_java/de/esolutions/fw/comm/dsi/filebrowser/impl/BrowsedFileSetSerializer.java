/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.filebrowser.impl;

import de.esolutions.fw.comm.dsi.filebrowser.impl.BrowsedFileSerializer;
import de.esolutions.fw.comm.dsi.filebrowser.impl.PathSerializer;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.filebrowser.BrowsedFile;
import org.dsi.ifc.filebrowser.BrowsedFileSet;
import org.dsi.ifc.filebrowser.Path;

public class BrowsedFileSetSerializer {
    public static void putOptionalBrowsedFileSet(ISerializer iSerializer, BrowsedFileSet browsedFileSet) {
        boolean bl = browsedFileSet == null;
        iSerializer.putBool(bl);
        if (!bl) {
            Path path = browsedFileSet.getPath();
            PathSerializer.putOptionalPath(iSerializer, path);
            BrowsedFile[] browsedFileArray = browsedFileSet.getFiles();
            BrowsedFileSerializer.putOptionalBrowsedFileVarArray(iSerializer, browsedFileArray);
        }
    }

    public static void putOptionalBrowsedFileSetVarArray(ISerializer iSerializer, BrowsedFileSet[] browsedFileSetArray) {
        boolean bl = browsedFileSetArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(browsedFileSetArray.length);
            for (int i2 = 0; i2 < browsedFileSetArray.length; ++i2) {
                BrowsedFileSetSerializer.putOptionalBrowsedFileSet(iSerializer, browsedFileSetArray[i2]);
            }
        }
    }

    public static BrowsedFileSet getOptionalBrowsedFileSet(IDeserializer iDeserializer) {
        BrowsedFileSet browsedFileSet = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            Path path;
            browsedFileSet = new BrowsedFileSet();
            browsedFileSet.path = path = PathSerializer.getOptionalPath(iDeserializer);
            BrowsedFile[] browsedFileArray = BrowsedFileSerializer.getOptionalBrowsedFileVarArray(iDeserializer);
            browsedFileSet.files = browsedFileArray;
        }
        return browsedFileSet;
    }

    public static BrowsedFileSet[] getOptionalBrowsedFileSetVarArray(IDeserializer iDeserializer) {
        BrowsedFileSet[] browsedFileSetArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            browsedFileSetArray = new BrowsedFileSet[n];
            for (int i2 = 0; i2 < n; ++i2) {
                browsedFileSetArray[i2] = BrowsedFileSetSerializer.getOptionalBrowsedFileSet(iDeserializer);
            }
        }
        return browsedFileSetArray;
    }
}

