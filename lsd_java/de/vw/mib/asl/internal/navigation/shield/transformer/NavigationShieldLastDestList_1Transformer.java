/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.shield.transformer;

import de.vw.mib.asl.internal.navigation.shield.transformer.ShieldLastDestCollector;
import de.vw.mib.properties.values.FixFormatterFieldData;
import generated.de.vw.mib.asl.internal.navigation.shield.transformer.AbstractNavigationShieldLastDestList_1Transformer;

public class NavigationShieldLastDestList_1Transformer
extends AbstractNavigationShieldLastDestList_1Transformer {
    @Override
    public FixFormatterFieldData getFixFormatterFieldData(int n, Object object) {
        return ((ShieldLastDestCollector)object).fieldData;
    }

    @Override
    public int getInt(int n, Object object) {
        switch (n) {
            case 1: {
                return ((ShieldLastDestCollector)object).getIconId();
            }
        }
        return 0;
    }
}

