/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.locationinput.inputfield.crossing.transformer;

import generated.de.vw.mib.asl.internal.navigation.locationinput.inputfield.crossing.transformer.AbstractNavigationLocationInputInputFieldCrossingListTransformer;
import org.dsi.ifc.navigation.LIExtData;
import org.dsi.ifc.navigation.LIValueListElement;

public class NavigationLocationInputInputFieldCrossingListTransformer
extends AbstractNavigationLocationInputInputFieldCrossingListTransformer {
    @Override
    public String getString(int n, Object object) {
        if (n == 0) {
            return ((LIValueListElement)object).data;
        }
        if (n == 1) {
            LIValueListElement lIValueListElement = (LIValueListElement)object;
            if (lIValueListElement.extendedData != null) {
                for (int i2 = 0; i2 < lIValueListElement.extendedData.length; ++i2) {
                    LIExtData lIExtData = lIValueListElement.getExtendedData()[i2];
                    if (lIExtData.type != 13) continue;
                    return lIExtData.data;
                }
            }
            return "";
        }
        throw new IllegalArgumentException();
    }
}

