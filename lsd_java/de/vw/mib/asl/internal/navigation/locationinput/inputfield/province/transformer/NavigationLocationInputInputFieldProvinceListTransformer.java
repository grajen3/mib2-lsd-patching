/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.locationinput.inputfield.province.transformer;

import generated.de.vw.mib.asl.internal.navigation.locationinput.inputfield.province.transformer.AbstractNavigationLocationInputInputFieldProvinceListTransformer;
import org.dsi.ifc.navigation.LIValueListElement;

public class NavigationLocationInputInputFieldProvinceListTransformer
extends AbstractNavigationLocationInputInputFieldProvinceListTransformer {
    @Override
    public String getString(int n, Object object) {
        if (n == 0) {
            return ((LIValueListElement)object).data;
        }
        throw new IllegalArgumentException();
    }
}

