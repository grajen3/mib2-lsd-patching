/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.list.impl;

import de.vw.mib.asl.internal.list.ItemTransformer;
import de.vw.mib.asl.internal.list.ItemTransformer$CL2;
import de.vw.mib.properties.values.FixFormatterFieldData;
import de.vw.mib.properties.values.LabeledIconValue;
import org.dsi.ifc.global.ResourceLocator;

public class ItemTransformerDelegate
implements ItemTransformer$CL2 {
    private final ItemTransformer transformer;
    private final int complianceLevel;

    public ItemTransformerDelegate(ItemTransformer itemTransformer) {
        this.transformer = itemTransformer;
        this.complianceLevel = itemTransformer instanceof ItemTransformer$CL2 ? ((ItemTransformer$CL2)itemTransformer).getItemTransformerComplianceLevel() : 1;
    }

    @Override
    public int getItemTransformerComplianceLevel() {
        return this.complianceLevel;
    }

    @Override
    public String[] getRowValuesAsStrings(Object object) {
        return this.transformer.getRowValuesAsStrings(object);
    }

    @Override
    public int[] getColumnIds() {
        return this.transformer.getColumnIds();
    }

    @Override
    public int getColumnCount() {
        return this.transformer.getColumnCount();
    }

    @Override
    public boolean isColumnIdSupported(int n) {
        return this.transformer.isColumnIdSupported(n);
    }

    @Override
    public Object get(int n, Object object) {
        return this.transformer.get(n, object);
    }

    @Override
    public boolean getBoolean(int n, Object object) {
        return this.transformer.getBoolean(n, object);
    }

    @Override
    public FixFormatterFieldData getFixFormatterFieldData(int n, Object object) {
        return this.transformer.getFixFormatterFieldData(n, object);
    }

    @Override
    public boolean[] getFlagVector(int n, Object object) {
        return this.transformer.getFlagVector(n, object);
    }

    @Override
    public int getInt(int n, Object object) {
        return this.transformer.getInt(n, object);
    }

    @Override
    public int[] getIntegerVector(int n, Object object) {
        return this.transformer.getIntegerVector(n, object);
    }

    @Override
    public LabeledIconValue getLabeledIconValue(int n, Object object) {
        return this.transformer.getLabeledIconValue(n, object);
    }

    @Override
    public long getLong(int n, Object object) {
        return this.transformer.getLong(n, object);
    }

    @Override
    public ResourceLocator getResourceLocator(int n, Object object) {
        return this.transformer.getResourceLocator(n, object);
    }

    @Override
    public String getString(int n, Object object) {
        return this.transformer.getString(n, object);
    }

    @Override
    public String[] getStringVector(int n, Object object) {
        return this.transformer.getStringVector(n, object);
    }
}

