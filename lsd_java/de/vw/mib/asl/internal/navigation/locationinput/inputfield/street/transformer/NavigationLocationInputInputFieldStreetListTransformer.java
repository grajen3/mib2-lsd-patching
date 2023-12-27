/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.locationinput.inputfield.street.transformer;

import generated.de.vw.mib.asl.internal.navigation.locationinput.inputfield.street.transformer.AbstractNavigationLocationInputInputFieldStreetListTransformer;
import org.dsi.ifc.navigation.LIValueListElement;

public class NavigationLocationInputInputFieldStreetListTransformer
extends AbstractNavigationLocationInputInputFieldStreetListTransformer {
    @Override
    public String getString(int n, Object object) {
        if (n == 0) {
            return ((LIValueListElement)object).data;
        }
        throw new IllegalArgumentException();
    }

    @Override
    public boolean getBoolean(int n, Object object) {
        return false;
    }
}

