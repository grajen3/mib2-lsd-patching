/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.api.navigation.data;

import de.vw.mib.asl.api.navigation.data.ASLNavigationDataContainer;
import de.vw.mib.asl.api.navigation.data.ASLNavigationDataList;
import java.util.Enumeration;
import java.util.Map;

public interface ASLNavigationDataMap
extends ASLNavigationDataContainer,
Map {
    default public boolean containsKey(String string) {
    }

    default public Object removeKey(String string) {
    }

    default public Enumeration keys() {
    }

    default public ASLNavigationDataMap getASLNavigationMap(String string) {
    }

    default public ASLNavigationDataList getASLNavigationList(String string) {
    }

    default public void setBoolean(String string, boolean bl) {
    }

    default public boolean getBoolean(String string) {
    }

    default public void setInt(String string, int n) {
    }

    default public int getInt(String string) {
    }

    default public void setIntArray(String string, int[] nArray) {
    }

    default public int[] getIntArray(String string) {
    }

    default public void setString(String string, String string2) {
    }

    default public String getString(String string) {
    }

    default public byte[] getByteArray(String string) {
    }

    default public void setByteArray(String string, byte[] byArray) {
    }

    default public void setByte(String string, byte by) {
    }

    default public byte getByte(String string) {
    }

    default public void setChar(String string, char c2) {
    }

    default public char getChar(String string) {
    }

    default public void setDouble(String string, double d2) {
    }

    default public double getDouble(String string) {
    }

    default public void setFloat(String string, float f2) {
    }

    default public float getFloat(String string) {
    }

    default public void setLong(String string, long l) {
    }

    default public long getLong(String string) {
    }

    default public void setShort(String string, short s) {
    }

    default public short getShort(String string) {
    }

    default public void setObject(String string, Object object) {
    }

    default public Object getObject(String string) {
    }
}

