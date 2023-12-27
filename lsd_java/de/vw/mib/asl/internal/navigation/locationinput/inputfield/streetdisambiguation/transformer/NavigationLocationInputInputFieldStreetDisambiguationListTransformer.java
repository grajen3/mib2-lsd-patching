/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.locationinput.inputfield.streetdisambiguation.transformer;

import generated.de.vw.mib.asl.internal.navigation.locationinput.inputfield.streetdisambiguation.transformer.AbstractNavigationLocationInputInputFieldStreetDisambiguationListTransformer;
import org.dsi.ifc.navigation.LIExtData;
import org.dsi.ifc.navigation.LIValueListElement;

public class NavigationLocationInputInputFieldStreetDisambiguationListTransformer
extends AbstractNavigationLocationInputInputFieldStreetDisambiguationListTransformer {
    @Override
    public String getString(int n, Object object) {
        if (n == 0) {
            return ((LIValueListElement)object).data;
        }
        if (n == 1) {
            LIExtData[] lIExtDataArray = ((LIValueListElement)object).extendedData;
            if (lIExtDataArray != null && lIExtDataArray.length > 0) {
                for (int i2 = 0; i2 < lIExtDataArray.length; ++i2) {
                    if (lIExtDataArray[i2].type != 13) continue;
                    return lIExtDataArray[i2].getData();
                }
            }
            return "";
        }
        throw new IllegalArgumentException();
    }
}

