/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.radio.usl.transformer;

import de.vw.mib.asl.internal.list.ItemTransformer;
import de.vw.mib.properties.values.FixFormatterFieldData;
import de.vw.mib.properties.values.LabeledIconValue;
import org.dsi.ifc.global.ResourceLocator;

public class RadioUSLStationListInfoTransformer
implements ItemTransformer {
    @Override
    public Object get(int n, Object object) {
        return null;
    }

    @Override
    public boolean getBoolean(int n, Object object) {
        return false;
    }

    @Override
    public FixFormatterFieldData getFixFormatterFieldData(int n, Object object) {
        return null;
    }

    @Override
    public boolean[] getFlagVector(int n, Object object) {
        return null;
    }

    @Override
    public int getInt(int n, Object object) {
        return 0;
    }

    @Override
    public int[] getIntegerVector(int n, Object object) {
        return null;
    }

    @Override
    public LabeledIconValue getLabeledIconValue(int n, Object object) {
        return null;
    }

    @Override
    public long getLong(int n, Object object) {
        return 0L;
    }

    @Override
    public ResourceLocator getResourceLocator(int n, Object object) {
        return null;
    }

    @Override
    public String getString(int n, Object object) {
        return null;
    }

    @Override
    public String[] getStringVector(int n, Object object) {
        return null;
    }

    @Override
    public int getColumnCount() {
        return 0;
    }

    @Override
    public int[] getColumnIds() {
        return null;
    }

    @Override
    public String[] getRowValuesAsStrings(Object object) {
        return null;
    }

    @Override
    public boolean isColumnIdSupported(int n) {
        return false;
    }
}

