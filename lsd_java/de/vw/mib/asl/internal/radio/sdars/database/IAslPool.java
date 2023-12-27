/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.radio.sdars.database;

import de.vw.mib.asl.internal.radio.sdars.database.IAslPoolListener;
import de.vw.mib.asl.internal.radio.sdars.database.IAslPoolRecord;
import de.vw.mib.genericevents.EventGeneric;
import org.dsi.ifc.global.ResourceLocator;
import org.dsi.ifc.sdars.CategoryInfo;
import org.dsi.ifc.sdars.RadioText;
import org.dsi.ifc.sdars.StationInfo;

public interface IAslPool {
    default public void addListener(int n, IAslPoolListener iAslPoolListener) {
    }

    default public void addListener(int n, IAslPoolListener iAslPoolListener, boolean bl) {
    }

    default public void addListener(int[] nArray, IAslPoolListener iAslPoolListener) {
    }

    default public void addListener(int n, int n2, int n3) {
    }

    default public void addListener(int n, int n2, int n3, boolean bl) {
    }

    default public void removeListener(int n, IAslPoolListener iAslPoolListener) {
    }

    default public void removeListener(int[] nArray, IAslPoolListener iAslPoolListener) {
    }

    default public void removeListener(int n, int n2, int n3) {
    }

    default public IAslPoolRecord registerRecord(int n, int n2, String string) {
    }

    default public String getTypeName(int n) {
    }

    default public void enableNotificationsWithoutChange(int n) {
    }

    default public void setNameDbType(int n, int n2) {
    }

    default public void copy(int n, int n2) {
    }

    default public int getInt(int n, int n2) {
    }

    default public int getInt(int n) {
    }

    default public boolean setInt(int n, int n2) {
    }

    default public boolean incInt(int n) {
    }

    default public boolean decInt(int n) {
    }

    default public short getShort(int n, short s) {
    }

    default public short getShort(int n) {
    }

    default public boolean setShort(int n, short s) {
    }

    default public long getLong(int n, long l) {
    }

    default public long getLong(int n) {
    }

    default public boolean setLong(int n, long l) {
    }

    default public boolean getBoolean(int n, boolean bl) {
    }

    default public boolean getBoolean(int n) {
    }

    default public boolean setBoolean(int n, boolean bl) {
    }

    default public String getString(int n, String string) {
    }

    default public String getString(int n) {
    }

    default public boolean setString(int n, String string) {
    }

    default public RadioText getRadioText(int n) {
    }

    default public boolean setRadioText(int n, RadioText radioText) {
    }

    default public StationInfo getChannel(int n) {
    }

    default public boolean setChannel(int n, StationInfo stationInfo) {
    }

    default public CategoryInfo getCategory(int n) {
    }

    default public boolean setCategory(int n, CategoryInfo categoryInfo) {
    }

    default public ResourceLocator getResourceLocator(int n) {
    }

    default public boolean setResourceLocator(int n, ResourceLocator resourceLocator) {
    }

    default public EventGeneric getEvent(int n) {
    }

    default public boolean setEvent(int n, EventGeneric eventGeneric) {
    }

    default public Object getObject(int n) {
    }

    default public boolean setObject(int n, Object object) {
    }

    default public Object[] getObjectArray(int n) {
    }

    default public boolean setObjectArray(int n, Object[] objectArray) {
    }

    default public void notifyUpdate(int n) {
    }
}

