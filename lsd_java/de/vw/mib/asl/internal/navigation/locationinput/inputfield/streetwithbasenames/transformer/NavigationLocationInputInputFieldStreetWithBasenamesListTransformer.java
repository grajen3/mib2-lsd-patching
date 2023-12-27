/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.locationinput.inputfield.streetwithbasenames.transformer;

import generated.de.vw.mib.asl.internal.navigation.locationinput.inputfield.streetwithbasenames.transformer.AbstractNavigationLocationInputInputFieldStreetWithBasenamesListTransformer;
import org.dsi.ifc.navigation.LIValueListElement;

public class NavigationLocationInputInputFieldStreetWithBasenamesListTransformer
extends AbstractNavigationLocationInputInputFieldStreetWithBasenamesListTransformer {
    @Override
    public boolean getBoolean(int n, Object object) {
        LIValueListElement lIValueListElement = (LIValueListElement)object;
        switch (n) {
            case 2: {
                if (lIValueListElement.extendedData == null) break;
                for (int i2 = 0; i2 < lIValueListElement.extendedData.length; ++i2) {
                    if (lIValueListElement.extendedData[i2].type != 1000) continue;
                    return true;
                }
                break;
            }
        }
        return false;
    }

    @Override
    public String getString(int n, Object object) {
        if (n == 0) {
            return ((LIValueListElement)object).data;
        }
        throw new IllegalArgumentException();
    }
}

