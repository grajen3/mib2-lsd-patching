/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.navigation.impl;

import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.navigation.Category;

public class CategorySerializer {
    public static void putOptionalCategory(ISerializer iSerializer, Category category) {
        boolean bl = category == null;
        iSerializer.putBool(bl);
        if (!bl) {
            int n = category.getCategoryUid();
            iSerializer.putInt32(n);
            int n2 = category.getIconIndex();
            iSerializer.putInt32(n2);
            int n3 = category.getSubIconIndex();
            iSerializer.putInt32(n3);
            boolean bl2 = category.isParent();
            iSerializer.putBool(bl2);
            boolean bl3 = category.isVisible();
            iSerializer.putBool(bl3);
            boolean bl4 = category.isAudible();
            iSerializer.putBool(bl4);
            boolean bl5 = category.isPersonal();
            iSerializer.putBool(bl5);
            boolean bl6 = category.isMonitored();
            iSerializer.putBool(bl6);
            String string = category.getDescription();
            iSerializer.putOptionalString(string);
            int n4 = category.getAdditionalFlags();
            iSerializer.putInt32(n4);
            int n5 = category.getParentId();
            iSerializer.putInt32(n5);
        }
    }

    public static void putOptionalCategoryVarArray(ISerializer iSerializer, Category[] categoryArray) {
        boolean bl = categoryArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(categoryArray.length);
            for (int i2 = 0; i2 < categoryArray.length; ++i2) {
                CategorySerializer.putOptionalCategory(iSerializer, categoryArray[i2]);
            }
        }
    }

    public static Category getOptionalCategory(IDeserializer iDeserializer) {
        Category category = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n;
            int n2;
            String string;
            boolean bl2;
            boolean bl3;
            boolean bl4;
            boolean bl5;
            boolean bl6;
            int n3;
            int n4;
            int n5;
            category = new Category();
            category.categoryUid = n5 = iDeserializer.getInt32();
            category.iconIndex = n4 = iDeserializer.getInt32();
            category.subIconIndex = n3 = iDeserializer.getInt32();
            category.parent = bl6 = iDeserializer.getBool();
            category.visible = bl5 = iDeserializer.getBool();
            category.audible = bl4 = iDeserializer.getBool();
            category.personal = bl3 = iDeserializer.getBool();
            category.monitored = bl2 = iDeserializer.getBool();
            category.description = string = iDeserializer.getOptionalString();
            category.additionalFlags = n2 = iDeserializer.getInt32();
            category.parentId = n = iDeserializer.getInt32();
        }
        return category;
    }

    public static Category[] getOptionalCategoryVarArray(IDeserializer iDeserializer) {
        Category[] categoryArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            categoryArray = new Category[n];
            for (int i2 = 0; i2 < n; ++i2) {
                categoryArray[i2] = CategorySerializer.getOptionalCategory(iDeserializer);
            }
        }
        return categoryArray;
    }
}

