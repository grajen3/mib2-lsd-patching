/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.routeoptions.transformer;

import org.dsi.ifc.navigation.LIValueListElement;

public class VignetteCountryListCollector
implements Cloneable {
    public String countryName;
    public int countryID;
    public boolean isCountrySelected;

    public VignetteCountryListCollector(String string, int n, boolean bl) {
        this.countryName = string;
        this.countryID = n;
        this.isCountrySelected = bl;
    }

    public VignetteCountryListCollector(LIValueListElement lIValueListElement) {
        this.countryName = lIValueListElement.data;
        this.countryID = lIValueListElement.listIndex;
        this.isCountrySelected = false;
    }
}

