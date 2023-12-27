/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.navigation.impl;

import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.navigation.Brand;

public class BrandSerializer {
    public static void putOptionalBrand(ISerializer iSerializer, Brand brand) {
        boolean bl = brand == null;
        iSerializer.putBool(bl);
        if (!bl) {
            int n = brand.getBrandUid();
            iSerializer.putInt32(n);
            int n2 = brand.getIconIndex();
            iSerializer.putInt32(n2);
            int n3 = brand.getSubIconIndex();
            iSerializer.putInt32(n3);
            boolean bl2 = brand.isVisible();
            iSerializer.putBool(bl2);
            boolean bl3 = brand.isPreferred();
            iSerializer.putBool(bl3);
            String string = brand.getDescription();
            iSerializer.putOptionalString(string);
        }
    }

    public static void putOptionalBrandVarArray(ISerializer iSerializer, Brand[] brandArray) {
        boolean bl = brandArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(brandArray.length);
            for (int i2 = 0; i2 < brandArray.length; ++i2) {
                BrandSerializer.putOptionalBrand(iSerializer, brandArray[i2]);
            }
        }
    }

    public static Brand getOptionalBrand(IDeserializer iDeserializer) {
        Brand brand = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            String string;
            boolean bl2;
            boolean bl3;
            int n;
            int n2;
            int n3;
            brand = new Brand();
            brand.brandUid = n3 = iDeserializer.getInt32();
            brand.iconIndex = n2 = iDeserializer.getInt32();
            brand.subIconIndex = n = iDeserializer.getInt32();
            brand.visible = bl3 = iDeserializer.getBool();
            brand.preferred = bl2 = iDeserializer.getBool();
            brand.description = string = iDeserializer.getOptionalString();
        }
        return brand;
    }

    public static Brand[] getOptionalBrandVarArray(IDeserializer iDeserializer) {
        Brand[] brandArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            brandArray = new Brand[n];
            for (int i2 = 0; i2 < n; ++i2) {
                brandArray[i2] = BrandSerializer.getOptionalBrand(iDeserializer);
            }
        }
        return brandArray;
    }
}

