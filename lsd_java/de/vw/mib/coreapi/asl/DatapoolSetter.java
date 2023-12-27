/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.coreapi.asl;

import de.vw.mib.properties.values.FixFormatterFieldData;
import de.vw.mib.properties.values.LabeledIconValue;
import de.vw.mib.properties.values.SpellerData;
import org.dsi.ifc.global.ResourceLocator;

public interface DatapoolSetter {
    default public void setBoolean(int n, boolean bl) {
    }

    default public void setFixFormatterFieldData(int n, FixFormatterFieldData fixFormatterFieldData) {
    }

    default public void setFlagVector(int n, boolean[] blArray) {
    }

    default public void setInteger(int n, int n2) {
    }

    default public void setIntegerArray(int n, int[] nArray) {
    }

    default public void setLabeledIconValue(int n, LabeledIconValue labeledIconValue) {
    }

    default public void setLong(int n, long l) {
    }

    default public void setResourceLocator(int n, ResourceLocator resourceLocator) {
    }

    default public void setSpellerData(int n, SpellerData spellerData) {
    }

    default public void setString(int n, String string) {
    }

    default public void setStringVector(int n, String[] stringArray) {
    }
}

