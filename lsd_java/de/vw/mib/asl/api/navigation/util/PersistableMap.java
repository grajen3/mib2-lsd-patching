/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.api.navigation.util;

import java.util.Enumeration;
import org.dsi.ifc.global.NavLocation;
import org.dsi.ifc.map.Point;
import org.dsi.ifc.map.Rect;

public interface PersistableMap {
    default public void clear() {
    }

    default public void setSurviving(String string, boolean bl) {
    }

    default public boolean isSurviving(String string) {
    }

    default public boolean hasKey(String string) {
    }

    default public int getType(String string) {
    }

    default public void setBoolean(String string, boolean bl) {
    }

    default public boolean getBoolean(String string, boolean bl) {
    }

    default public void setInt(String string, int n) {
    }

    default public int getInt(String string, int n) {
    }

    default public void setIntArray(String string, int[] nArray) {
    }

    default public int[] getIntArray(String string, int[] nArray) {
    }

    default public void setNavLocation(String string, NavLocation navLocation) {
    }

    default public NavLocation getNavLocation(String string, NavLocation navLocation) {
    }

    default public void setString(String string, String string2) {
    }

    default public String getString(String string, String string2) {
    }

    default public byte[] getByteArray(String string) {
    }

    default public void setByteArray(String string, byte[] byArray) {
    }

    default public void setByte(String string, byte by) {
    }

    default public byte getByte(String string, byte by) {
    }

    default public void setChar(String string, char c2) {
    }

    default public char getChar(String string, char c2) {
    }

    default public void setDouble(String string, double d2) {
    }

    default public double getDouble(String string, double d2) {
    }

    default public boolean isLoaded() {
    }

    default public void setFloat(String string, float f2) {
    }

    default public float getFloat(String string, float f2) {
    }

    default public void setLong(String string, long l) {
    }

    default public long getLong(String string, long l) {
    }

    default public void setShort(String string, short s) {
    }

    default public short getShort(String string, short s) {
    }

    default public void setRect(String string, Rect rect) {
    }

    default public Rect getRect(String string, Rect rect) {
    }

    default public void setPoint(String string, Point point) {
    }

    default public Point getPoint(String string, Point point) {
    }

    default public PersistableMap getPersistableMap(String string) {
    }

    default public Object removeKey(String string) {
    }

    default public Enumeration keys() {
    }
}

