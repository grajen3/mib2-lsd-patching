/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.radio.sdars.database;

import de.vw.mib.genericevents.EventGeneric;
import org.dsi.ifc.global.ResourceLocator;
import org.dsi.ifc.sdars.CategoryInfo;
import org.dsi.ifc.sdars.RadioText;
import org.dsi.ifc.sdars.StationInfo;

public interface IAslPoolRecord {
    default public int getUpdateCount() {
    }

    default public String getName() {
    }

    default public int getType() {
    }

    default public void enableNotificationsWithoutChange() {
    }

    default public int getInt(int n) {
    }

    default public void setNameDbType(int n) {
    }

    default public int getInt() {
    }

    default public boolean setInt(int n) {
    }

    default public boolean incInt() {
    }

    default public boolean decInt() {
    }

    default public short getShort(short s) {
    }

    default public short getShort() {
    }

    default public boolean setShort(short s) {
    }

    default public long getLong(long l) {
    }

    default public long getLong() {
    }

    default public boolean setLong(long l) {
    }

    default public boolean getBoolean(boolean bl) {
    }

    default public boolean getBoolean() {
    }

    default public boolean setBoolean(boolean bl) {
    }

    default public String getString(String string) {
    }

    default public String getString() {
    }

    default public boolean setString(String string) {
    }

    default public RadioText getRadioText() {
    }

    default public boolean setRadioText(RadioText radioText) {
    }

    default public StationInfo getChannel() {
    }

    default public boolean setChannel(StationInfo stationInfo) {
    }

    default public CategoryInfo getCategory() {
    }

    default public boolean setCategory(CategoryInfo categoryInfo) {
    }

    default public ResourceLocator getResourceLocator() {
    }

    default public boolean setResourceLocator(ResourceLocator resourceLocator) {
    }

    default public EventGeneric getEvent() {
    }

    default public boolean setEvent(EventGeneric eventGeneric) {
    }

    default public Object getObject() {
    }

    default public boolean setObject(Object object) {
    }

    default public Object[] getObjectArray() {
    }

    default public boolean setObjectArray(Object[] objectArray) {
    }

    default public void notifyUpdate() {
    }
}

