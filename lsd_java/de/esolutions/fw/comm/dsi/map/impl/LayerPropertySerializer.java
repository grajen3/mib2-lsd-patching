/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.map.impl;

import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.map.LayerProperty;

public class LayerPropertySerializer {
    public static void putOptionalLayerProperty(ISerializer iSerializer, LayerProperty layerProperty) {
        boolean bl = layerProperty == null;
        iSerializer.putBool(bl);
        if (!bl) {
            String string = layerProperty.getIconFilename();
            iSerializer.putOptionalString(string);
            String string2 = layerProperty.getText();
            iSerializer.putOptionalString(string2);
            int n = layerProperty.getUId();
            iSerializer.putInt32(n);
            int n2 = layerProperty.getParent();
            iSerializer.putInt32(n2);
            int n3 = layerProperty.getLayerType();
            iSerializer.putInt32(n3);
        }
    }

    public static void putOptionalLayerPropertyVarArray(ISerializer iSerializer, LayerProperty[] layerPropertyArray) {
        boolean bl = layerPropertyArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(layerPropertyArray.length);
            for (int i2 = 0; i2 < layerPropertyArray.length; ++i2) {
                LayerPropertySerializer.putOptionalLayerProperty(iSerializer, layerPropertyArray[i2]);
            }
        }
    }

    public static LayerProperty getOptionalLayerProperty(IDeserializer iDeserializer) {
        LayerProperty layerProperty = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n;
            int n2;
            int n3;
            String string;
            String string2;
            layerProperty = new LayerProperty();
            layerProperty.iconFilename = string2 = iDeserializer.getOptionalString();
            layerProperty.text = string = iDeserializer.getOptionalString();
            layerProperty.uId = n3 = iDeserializer.getInt32();
            layerProperty.parent = n2 = iDeserializer.getInt32();
            layerProperty.layerType = n = iDeserializer.getInt32();
        }
        return layerProperty;
    }

    public static LayerProperty[] getOptionalLayerPropertyVarArray(IDeserializer iDeserializer) {
        LayerProperty[] layerPropertyArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            layerPropertyArray = new LayerProperty[n];
            for (int i2 = 0; i2 < n; ++i2) {
                layerPropertyArray[i2] = LayerPropertySerializer.getOptionalLayerProperty(iDeserializer);
            }
        }
        return layerPropertyArray;
    }
}

