/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.locationinput.inputfield.city.transformer;

import generated.de.vw.mib.asl.internal.navigation.locationinput.inputfield.city.transformer.AbstractNavigationLocationInputInputFieldCityPreviewListTransformer;
import org.dsi.ifc.navigation.LIValueListElement;

public class NavigationLocationInputInputFieldCityPreviewListTransformer
extends AbstractNavigationLocationInputInputFieldCityPreviewListTransformer {
    @Override
    public String getString(int n, Object object) {
        if (n == 0) {
            return ((LIValueListElement)object).data;
        }
        throw new IllegalArgumentException();
    }
}

