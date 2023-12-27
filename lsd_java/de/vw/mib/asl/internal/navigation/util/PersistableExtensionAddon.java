/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.util;

import de.vw.mib.asl.api.navigation.util.PersistableMap;
import de.vw.mib.asl.framework.api.persistence.PersistenceInputStream;
import de.vw.mib.asl.framework.api.persistence.PersistenceOutputStream;
import de.vw.mib.asl.framework.api.persistence.SharedPersistable;
import de.vw.mib.asl.internal.navigation.util.PersistableMapImpl;
import java.util.Enumeration;
import org.dsi.ifc.global.NavLocation;
import org.dsi.ifc.map.Point;
import org.dsi.ifc.map.Rect;

public class PersistableExtensionAddon
implements PersistableMap {
    private PersistableMapImpl myData;

    public PersistableExtensionAddon(SharedPersistable sharedPersistable) {
        this.myData = new PersistableMapImpl(sharedPersistable);
    }

    public void markDirty(boolean bl) {
        this.myData.markDirty(bl);
    }

    public void writeData(PersistenceOutputStream persistenceOutputStream) {
        this.myData.writeData(persistenceOutputStream);
    }

    public void readData(PersistenceInputStream persistenceInputStream) {
        this.myData.readData(persistenceInputStream);
    }

    public void fromStreamInternal(PersistenceInputStream persistenceInputStream, short s) {
        this.readData(persistenceInputStream);
    }

    public void toStreamInternal(PersistenceOutputStream persistenceOutputStream) {
        this.writeData(persistenceOutputStream);
    }

    public void clearUnknownValues(short s) {
    }

    public short[] getSupportedVersions() {
        return new short[]{1};
    }

    public short getVersion() {
        return 1;
    }

    @Override
    public void clear() {
        this.myData.clear();
    }

    @Override
    public void setBoolean(String string, boolean bl) {
        this.myData.setBoolean(string, bl);
    }

    @Override
    public boolean getBoolean(String string, boolean bl) {
        return this.myData.getBoolean(string, bl);
    }

    @Override
    public void setInt(String string, int n) {
        this.myData.setInt(string, n);
    }

    @Override
    public int getInt(String string, int n) {
        return this.myData.getInt(string, n);
    }

    @Override
    public void setNavLocation(String string, NavLocation navLocation) {
        this.myData.setNavLocation(string, navLocation);
    }

    @Override
    public NavLocation getNavLocation(String string, NavLocation navLocation) {
        return this.myData.getNavLocation(string, navLocation);
    }

    @Override
    public void setString(String string, String string2) {
        this.myData.setString(string, string2);
    }

    @Override
    public void setIntArray(String string, int[] nArray) {
        this.myData.setIntArray(string, nArray);
    }

    @Override
    public int[] getIntArray(String string, int[] nArray) {
        return this.myData.getIntArray(string, nArray);
    }

    @Override
    public String getString(String string, String string2) {
        return this.myData.getString(string, string2);
    }

    @Override
    public void setByte(String string, byte by) {
        this.myData.setByte(string, by);
    }

    @Override
    public byte getByte(String string, byte by) {
        return this.myData.getByte(string, by);
    }

    @Override
    public void setChar(String string, char c2) {
        this.myData.setChar(string, c2);
    }

    @Override
    public char getChar(String string, char c2) {
        return this.myData.getChar(string, c2);
    }

    @Override
    public void setDouble(String string, double d2) {
        this.myData.setDouble(string, d2);
    }

    @Override
    public double getDouble(String string, double d2) {
        return this.myData.getDouble(string, d2);
    }

    @Override
    public void setFloat(String string, float f2) {
        this.myData.setFloat(string, f2);
    }

    @Override
    public float getFloat(String string, float f2) {
        return this.myData.getFloat(string, f2);
    }

    @Override
    public void setLong(String string, long l) {
        this.myData.setLong(string, l);
    }

    @Override
    public long getLong(String string, long l) {
        return this.myData.getLong(string, l);
    }

    @Override
    public void setShort(String string, short s) {
        this.myData.setShort(string, s);
    }

    @Override
    public short getShort(String string, short s) {
        return this.myData.getShort(string, s);
    }

    @Override
    public boolean hasKey(String string) {
        return this.myData.hasKey(string);
    }

    @Override
    public int getType(String string) {
        return this.myData.getType(string);
    }

    @Override
    public byte[] getByteArray(String string) {
        return this.myData.getByteArray(string);
    }

    @Override
    public void setByteArray(String string, byte[] byArray) {
        this.myData.setByteArray(string, byArray);
    }

    @Override
    public void setRect(String string, Rect rect) {
        this.myData.setRect(string, rect);
    }

    @Override
    public Rect getRect(String string, Rect rect) {
        return this.myData.getRect(string, rect);
    }

    @Override
    public void setPoint(String string, Point point) {
        this.myData.setPoint(string, point);
    }

    @Override
    public Point getPoint(String string, Point point) {
        return this.myData.getPoint(string, point);
    }

    @Override
    public PersistableMap getPersistableMap(String string) {
        return this.myData.getPersistableMap(string);
    }

    @Override
    public Enumeration keys() {
        return this.myData.keys();
    }

    public String toString() {
        return this.myData.toString();
    }

    @Override
    public void setSurviving(String string, boolean bl) {
        this.myData.setSurviving(string, bl);
    }

    @Override
    public boolean isSurviving(String string) {
        return this.myData.isSurviving(string);
    }

    @Override
    public Object removeKey(String string) {
        return this.myData.removeKey(string);
    }

    @Override
    public boolean isLoaded() {
        return false;
    }
}

