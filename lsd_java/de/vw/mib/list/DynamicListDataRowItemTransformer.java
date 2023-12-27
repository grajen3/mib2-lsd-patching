/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.list;

import de.vw.mib.properties.values.FixFormatterFieldData;
import de.vw.mib.properties.values.LabeledIconValue;
import org.dsi.ifc.global.ResourceLocator;

public interface DynamicListDataRowItemTransformer {
    default public Object get(int n, Object object) {
    }

    default public boolean getBoolean(int n, Object object) {
    }

    default public FixFormatterFieldData getFixFormatterFieldData(int n, Object object) {
    }

    default public boolean[] getFlagVector(int n, Object object) {
    }

    default public int getInt(int n, Object object) {
    }

    default public int[] getIntegerVector(int n, Object object) {
    }

    default public LabeledIconValue getLabeledIconValue(int n, Object object) {
    }

    default public long getLong(int n, Object object) {
    }

    default public ResourceLocator getResourceLocator(int n, Object object) {
    }

    default public String getString(int n, Object object) {
    }

    default public String[] getStringVector(int n, Object object) {
    }
}

