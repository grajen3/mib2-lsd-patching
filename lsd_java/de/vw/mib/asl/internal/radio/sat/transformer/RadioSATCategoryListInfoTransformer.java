/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.radio.sat.transformer;

import generated.de.vw.mib.asl.internal.radio.sat.transformer.AbstractRadioSATCategoryListInfoTransformer;
import org.dsi.ifc.sdars.CategoryInfo;

public class RadioSATCategoryListInfoTransformer
extends AbstractRadioSATCategoryListInfoTransformer {
    @Override
    public boolean getBoolean(int n, Object object) {
        return false;
    }

    @Override
    public String getString(int n, Object object) {
        String string;
        CategoryInfo categoryInfo = (CategoryInfo)object;
        switch (n) {
            case 0: {
                string = categoryInfo.getFullLabel();
                break;
            }
            default: {
                string = "";
            }
        }
        return string;
    }

    @Override
    public long getLong(int n, Object object) {
        long l;
        CategoryInfo categoryInfo = (CategoryInfo)object;
        switch (n) {
            case 1: {
                l = categoryInfo.getCategoryNumber();
                break;
            }
            default: {
                l = 0L;
            }
        }
        return l;
    }
}

