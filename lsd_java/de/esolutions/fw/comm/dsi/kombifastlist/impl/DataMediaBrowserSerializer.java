/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.kombifastlist.impl;

import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.kombifastlist.DataMediaBrowser;

public class DataMediaBrowserSerializer {
    public static void putOptionalDataMediaBrowser(ISerializer iSerializer, DataMediaBrowser dataMediaBrowser) {
        boolean bl = dataMediaBrowser == null;
        iSerializer.putBool(bl);
        if (!bl) {
            long l = dataMediaBrowser.getPos();
            iSerializer.putInt64(l);
            int n = dataMediaBrowser.getFileType();
            iSerializer.putInt32(n);
            long l2 = dataMediaBrowser.getFileState();
            iSerializer.putInt64(l2);
            String string = dataMediaBrowser.getFileName();
            iSerializer.putOptionalString(string);
        }
    }

    public static void putOptionalDataMediaBrowserVarArray(ISerializer iSerializer, DataMediaBrowser[] dataMediaBrowserArray) {
        boolean bl = dataMediaBrowserArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(dataMediaBrowserArray.length);
            for (int i2 = 0; i2 < dataMediaBrowserArray.length; ++i2) {
                DataMediaBrowserSerializer.putOptionalDataMediaBrowser(iSerializer, dataMediaBrowserArray[i2]);
            }
        }
    }

    public static DataMediaBrowser getOptionalDataMediaBrowser(IDeserializer iDeserializer) {
        DataMediaBrowser dataMediaBrowser = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            String string;
            long l;
            int n;
            long l2;
            dataMediaBrowser = new DataMediaBrowser();
            dataMediaBrowser.pos = l2 = iDeserializer.getInt64();
            dataMediaBrowser.fileType = n = iDeserializer.getInt32();
            dataMediaBrowser.fileState = l = iDeserializer.getInt64();
            dataMediaBrowser.fileName = string = iDeserializer.getOptionalString();
        }
        return dataMediaBrowser;
    }

    public static DataMediaBrowser[] getOptionalDataMediaBrowserVarArray(IDeserializer iDeserializer) {
        DataMediaBrowser[] dataMediaBrowserArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            dataMediaBrowserArray = new DataMediaBrowser[n];
            for (int i2 = 0; i2 < n; ++i2) {
                dataMediaBrowserArray[i2] = DataMediaBrowserSerializer.getOptionalDataMediaBrowser(iDeserializer);
            }
        }
        return dataMediaBrowserArray;
    }
}

