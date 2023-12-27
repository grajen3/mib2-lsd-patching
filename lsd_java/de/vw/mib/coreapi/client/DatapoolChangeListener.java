/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.coreapi.client;

import de.vw.mib.properties.values.FixFormatterFieldData;
import de.vw.mib.properties.values.LabeledIconValue;
import de.vw.mib.properties.values.SpellerData;
import org.dsi.ifc.global.ResourceLocator;

public interface DatapoolChangeListener {
    default public void onDatapoolChange(int n, boolean bl) {
    }

    default public void onDatapoolChange(int n, FixFormatterFieldData fixFormatterFieldData) {
    }

    default public void onDatapoolChange(int n, boolean[] blArray) {
    }

    default public void onDatapoolChange(int n, int n2) {
    }

    default public void onDatapoolChange(int n, int[] nArray) {
    }

    default public void onDatapoolChange(int n, LabeledIconValue labeledIconValue) {
    }

    default public void onDatapoolChange(int n, long l) {
    }

    default public void onDatapoolChange(int n, ResourceLocator resourceLocator) {
    }

    default public void onDatapoolChange(int n, SpellerData spellerData) {
    }

    default public void onDatapoolChange(int n, String string) {
    }

    default public void onDatapoolChange(int n, String[] stringArray) {
    }
}

