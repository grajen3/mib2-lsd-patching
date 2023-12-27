/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.carparkingsystem.impl;

import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.carparkingsystem.DisplayContent;

public class DisplayContentSerializer {
    public static void putOptionalDisplayContent(ISerializer iSerializer, DisplayContent displayContent) {
        boolean bl = displayContent == null;
        iSerializer.putBool(bl);
        if (!bl) {
            int n = displayContent.getPopup();
            iSerializer.putInt32(n);
            int n2 = displayContent.getScreen();
            iSerializer.putInt32(n2);
            int n3 = displayContent.getView();
            iSerializer.putInt32(n3);
            int n4 = displayContent.getMode();
            iSerializer.putInt32(n4);
        }
    }

    public static void putOptionalDisplayContentVarArray(ISerializer iSerializer, DisplayContent[] displayContentArray) {
        boolean bl = displayContentArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(displayContentArray.length);
            for (int i2 = 0; i2 < displayContentArray.length; ++i2) {
                DisplayContentSerializer.putOptionalDisplayContent(iSerializer, displayContentArray[i2]);
            }
        }
    }

    public static DisplayContent getOptionalDisplayContent(IDeserializer iDeserializer) {
        DisplayContent displayContent = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n;
            int n2;
            int n3;
            int n4;
            displayContent = new DisplayContent();
            displayContent.popup = n4 = iDeserializer.getInt32();
            displayContent.screen = n3 = iDeserializer.getInt32();
            displayContent.view = n2 = iDeserializer.getInt32();
            displayContent.mode = n = iDeserializer.getInt32();
        }
        return displayContent;
    }

    public static DisplayContent[] getOptionalDisplayContentVarArray(IDeserializer iDeserializer) {
        DisplayContent[] displayContentArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            displayContentArray = new DisplayContent[n];
            for (int i2 = 0; i2 < n; ++i2) {
                displayContentArray[i2] = DisplayContentSerializer.getOptionalDisplayContent(iDeserializer);
            }
        }
        return displayContentArray;
    }
}

