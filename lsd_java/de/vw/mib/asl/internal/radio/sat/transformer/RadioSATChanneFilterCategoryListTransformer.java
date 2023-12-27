/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.radio.sat.transformer;

import de.vw.mib.asl.internal.radio.sdars.helper.SatDb;
import generated.de.vw.mib.asl.internal.radio.sat.transformer.AbstractRadioSATChanneFilterCategoryListTransformer;
import org.dsi.ifc.sdars.CategoryInfo;

public class RadioSATChanneFilterCategoryListTransformer
extends AbstractRadioSATChanneFilterCategoryListTransformer {
    @Override
    public String getString(int n, Object object) {
        String string;
        CategoryInfo categoryInfo = (CategoryInfo)object;
        switch (n) {
            case 1: {
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
    public int getInt(int n, Object object) {
        int n2;
        CategoryInfo categoryInfo = (CategoryInfo)object;
        switch (n) {
            case 3: {
                n2 = SatDb.getInstance().getFilterListApi().getCategoryStatus(categoryInfo.categoryNumber);
                break;
            }
            default: {
                n2 = 0;
            }
        }
        return n2;
    }
}

