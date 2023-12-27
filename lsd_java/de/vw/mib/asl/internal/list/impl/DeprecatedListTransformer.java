/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.list.impl;

import de.vw.mib.asl.internal.list.ItemTransformer;
import de.vw.mib.properties.values.FixFormatterFieldData;
import de.vw.mib.properties.values.LabeledIconValue;
import org.dsi.ifc.global.ResourceLocator;

public final class DeprecatedListTransformer
implements ItemTransformer {
    private static final int[] EMPTY_INT_ARRAY = new int[0];
    private static final String[] EMPTY_STRING_ARRAY = new String[0];
    public static final DeprecatedListTransformer INSTANCE = new DeprecatedListTransformer();

    private DeprecatedListTransformer() {
    }

    @Override
    public int getColumnCount() {
        return 0;
    }

    @Override
    public int[] getColumnIds() {
        return EMPTY_INT_ARRAY;
    }

    @Override
    public String[] getRowValuesAsStrings(Object object) {
        return EMPTY_STRING_ARRAY;
    }

    @Override
    public boolean isColumnIdSupported(int n) {
        return false;
    }

    @Override
    public Object get(int n, Object object) {
        return null;
    }

    @Override
    public boolean getBoolean(int n, Object object) {
        return false;
    }

    @Override
    public int getInt(int n, Object object) {
        return 0;
    }

    @Override
    public String getString(int n, Object object) {
        return "";
    }

    @Override
    public boolean[] getFlagVector(int n, Object object) {
        return null;
    }

    @Override
    public int[] getIntegerVector(int n, Object object) {
        return null;
    }

    @Override
    public String[] getStringVector(int n, Object object) {
        return null;
    }

    @Override
    public ResourceLocator getResourceLocator(int n, Object object) {
        return null;
    }

    @Override
    public long getLong(int n, Object object) {
        return 0L;
    }

    @Override
    public LabeledIconValue getLabeledIconValue(int n, Object object) {
        return null;
    }

    @Override
    public FixFormatterFieldData getFixFormatterFieldData(int n, Object object) {
        return null;
    }
}

