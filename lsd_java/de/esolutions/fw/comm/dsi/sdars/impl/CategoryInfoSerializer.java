/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.sdars.impl;

import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.sdars.CategoryInfo;

public class CategoryInfoSerializer {
    public static void putOptionalCategoryInfo(ISerializer iSerializer, CategoryInfo categoryInfo) {
        boolean bl = categoryInfo == null;
        iSerializer.putBool(bl);
        if (!bl) {
            short s = categoryInfo.getCategoryNumber();
            iSerializer.putInt16(s);
            String string = categoryInfo.getShortLabel();
            iSerializer.putOptionalString(string);
            String string2 = categoryInfo.getFullLabel();
            iSerializer.putOptionalString(string2);
        }
    }

    public static void putOptionalCategoryInfoVarArray(ISerializer iSerializer, CategoryInfo[] categoryInfoArray) {
        boolean bl = categoryInfoArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(categoryInfoArray.length);
            for (int i2 = 0; i2 < categoryInfoArray.length; ++i2) {
                CategoryInfoSerializer.putOptionalCategoryInfo(iSerializer, categoryInfoArray[i2]);
            }
        }
    }

    public static CategoryInfo getOptionalCategoryInfo(IDeserializer iDeserializer) {
        CategoryInfo categoryInfo = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            String string;
            String string2;
            short s;
            categoryInfo = new CategoryInfo();
            categoryInfo.categoryNumber = s = iDeserializer.getInt16();
            categoryInfo.shortLabel = string2 = iDeserializer.getOptionalString();
            categoryInfo.fullLabel = string = iDeserializer.getOptionalString();
        }
        return categoryInfo;
    }

    public static CategoryInfo[] getOptionalCategoryInfoVarArray(IDeserializer iDeserializer) {
        CategoryInfo[] categoryInfoArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            categoryInfoArray = new CategoryInfo[n];
            for (int i2 = 0; i2 < n; ++i2) {
                categoryInfoArray[i2] = CategoryInfoSerializer.getOptionalCategoryInfo(iDeserializer);
            }
        }
        return categoryInfoArray;
    }
}

