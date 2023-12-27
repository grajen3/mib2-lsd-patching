/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.datapool;

import de.vw.mib.datapool.ASLDatapoolObserver;
import de.vw.mib.graphics.image.Image;
import de.vw.mib.properties.values.FixFormatterFieldData;
import de.vw.mib.properties.values.LabeledIconValue;
import de.vw.mib.properties.values.SpellerData;
import org.dsi.ifc.global.ResourceLocator;

public interface ASLDatapool {
    default public boolean getBoolean(int n) {
    }

    default public boolean getBoolean(int n, boolean bl) {
    }

    default public FixFormatterFieldData getFixFormatterFieldData(int n) {
    }

    default public FixFormatterFieldData getFixFormatterFieldData(int n, FixFormatterFieldData fixFormatterFieldData) {
    }

    default public boolean[] getFlagVector(int n) {
    }

    default public boolean[] getFlagVector(int n, boolean[] blArray) {
    }

    default public float getFloat(int n) {
    }

    default public float getFloat(int n, float f2) {
    }

    default public Image[] getImageVector(int n) {
    }

    default public Image[] getImageVector(int n, Image[] imageArray) {
    }

    default public int getInteger(int n) {
    }

    default public int getInteger(int n, int n2) {
    }

    default public int[] getIntegerArray(int n) {
    }

    default public int[] getIntegerArray(int n, int[] nArray) {
    }

    default public int[] getIntegerVector(int n) {
    }

    default public int[] getIntegerVector(int n, int[] nArray) {
    }

    default public LabeledIconValue getLabeledIconValue(int n) {
    }

    default public LabeledIconValue getLabeledIconValue(int n, LabeledIconValue labeledIconValue) {
    }

    default public long getLong(int n) {
    }

    default public long getLong(int n, long l) {
    }

    default public ResourceLocator getResourceLocator(int n) {
    }

    default public ResourceLocator getResourceLocator(int n, ResourceLocator resourceLocator) {
    }

    default public SpellerData getSpellerData(int n) {
    }

    default public SpellerData getSpellerData(int n, SpellerData spellerData) {
    }

    default public String getString(int n) {
    }

    default public String getString(int n, String string) {
    }

    default public String[] getStringVector(int n) {
    }

    default public String[] getStringVector(int n, String[] stringArray) {
    }

    default public void registerObserver(int n, ASLDatapoolObserver aSLDatapoolObserver) {
    }

    default public void setBoolean(int n, boolean bl) {
    }

    default public void setFixFormatterFieldData(int n, FixFormatterFieldData fixFormatterFieldData) {
    }

    default public void setFlagVector(int n, boolean[] blArray) {
    }

    default public void setFloat(int n, float f2) {
    }

    default public void setImageVector(int n, Image[] imageArray) {
    }

    default public void setInteger(int n, int n2) {
    }

    default public void setIntegerArray(int n, int[] nArray) {
    }

    default public void setIntegerVector(int n, int[] nArray) {
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

    default public void unregisterObserver(int n, ASLDatapoolObserver aSLDatapoolObserver) {
    }
}

