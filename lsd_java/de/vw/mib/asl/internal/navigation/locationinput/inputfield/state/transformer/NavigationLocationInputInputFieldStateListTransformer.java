/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.locationinput.inputfield.state.transformer;

import generated.de.vw.mib.asl.internal.navigation.locationinput.inputfield.state.transformer.AbstractNavigationLocationInputInputFieldStateListTransformer;
import org.dsi.ifc.navigation.LIValueListElement;

public class NavigationLocationInputInputFieldStateListTransformer
extends AbstractNavigationLocationInputInputFieldStateListTransformer {
    @Override
    public String getString(int n, Object object) {
        if (n == 0) {
            return ((LIValueListElement)object).data;
        }
        throw new IllegalArgumentException();
    }
}

