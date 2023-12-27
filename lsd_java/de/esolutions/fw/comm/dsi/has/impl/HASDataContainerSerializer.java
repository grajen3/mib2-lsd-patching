/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.has.impl;

import de.esolutions.fw.comm.dsi.has.impl.HASDataElementSerializer;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.has.HASDataContainer;
import org.dsi.ifc.has.HASDataElement;

public class HASDataContainerSerializer {
    public static void putOptionalHASDataContainer(ISerializer iSerializer, HASDataContainer hASDataContainer) {
        boolean bl = hASDataContainer == null;
        iSerializer.putBool(bl);
        if (!bl) {
            int n = hASDataContainer.getContainerId();
            iSerializer.putInt32(n);
            int n2 = hASDataContainer.getHierarchyId();
            iSerializer.putInt32(n2);
            int n3 = hASDataContainer.getParentId();
            iSerializer.putInt32(n3);
            HASDataElement[] hASDataElementArray = hASDataContainer.getDataElements();
            HASDataElementSerializer.putOptionalHASDataElementVarArray(iSerializer, hASDataElementArray);
            int n4 = hASDataContainer.getElementId();
            iSerializer.putInt32(n4);
        }
    }

    public static void putOptionalHASDataContainerVarArray(ISerializer iSerializer, HASDataContainer[] hASDataContainerArray) {
        boolean bl = hASDataContainerArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(hASDataContainerArray.length);
            for (int i2 = 0; i2 < hASDataContainerArray.length; ++i2) {
                HASDataContainerSerializer.putOptionalHASDataContainer(iSerializer, hASDataContainerArray[i2]);
            }
        }
    }

    public static HASDataContainer getOptionalHASDataContainer(IDeserializer iDeserializer) {
        HASDataContainer hASDataContainer = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n;
            int n2;
            int n3;
            int n4;
            hASDataContainer = new HASDataContainer();
            hASDataContainer.containerId = n4 = iDeserializer.getInt32();
            hASDataContainer.hierarchyId = n3 = iDeserializer.getInt32();
            hASDataContainer.parentId = n2 = iDeserializer.getInt32();
            HASDataElement[] hASDataElementArray = HASDataElementSerializer.getOptionalHASDataElementVarArray(iDeserializer);
            hASDataContainer.dataElements = hASDataElementArray;
            hASDataContainer.elementId = n = iDeserializer.getInt32();
        }
        return hASDataContainer;
    }

    public static HASDataContainer[] getOptionalHASDataContainerVarArray(IDeserializer iDeserializer) {
        HASDataContainer[] hASDataContainerArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            hASDataContainerArray = new HASDataContainer[n];
            for (int i2 = 0; i2 < n; ++i2) {
                hASDataContainerArray[i2] = HASDataContainerSerializer.getOptionalHASDataContainer(iDeserializer);
            }
        }
        return hASDataContainerArray;
    }
}

