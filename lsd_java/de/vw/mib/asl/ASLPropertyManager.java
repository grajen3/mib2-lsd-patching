/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl;

import de.vw.mib.properties.values.FixFormatterFieldData;
import de.vw.mib.properties.values.LabeledIconValue;
import de.vw.mib.properties.values.SpellerData;
import org.dsi.ifc.global.ResourceLocator;

public interface ASLPropertyManager {
    default public void valueChangedBoolean(int n, boolean bl) {
    }

    default public void valueChangedInteger(int n, int n2) {
    }

    default public void valueChangedLong(int n, long l) {
    }

    default public void valueChangedString(int n, String string) {
    }

    default public void valueChangedFlagVector(int n, boolean[] blArray) {
    }

    default public void valueChangedStringVector(int n, String[] stringArray) {
    }

    default public void valueChangedIntegerArray(int n, int[] nArray) {
    }

    default public void valueChangedSpellerData(int n, SpellerData spellerData) {
    }

    default public void valueChangedResourceLocator(int n, ResourceLocator resourceLocator) {
    }

    default public void valueChangedLabeledIcon(int n, LabeledIconValue labeledIconValue) {
    }

    default public void valueChangedFixFormatterFieldData(int n, FixFormatterFieldData fixFormatterFieldData) {
    }
}

