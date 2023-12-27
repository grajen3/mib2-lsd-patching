/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.persistence;

public interface DSIPersistenceC {
    default public void writeInt(int n, long l, int n2) {
    }

    default public void readInt(int n, long l) {
    }

    default public void readIntTimeout(int n, long l, int n2) {
    }

    default public void writeBuffer(int n, long l, byte[] byArray) {
    }

    default public void readBuffer(int n, long l) {
    }

    default public void readBufferTimeout(int n, long l, int n2) {
    }

    default public void writeString(int n, long l, String string) {
    }

    default public void readString(int n, long l) {
    }

    default public void readStringTimeout(int n, long l, int n2) {
    }

    default public void writeArray(int n, long l, int[] nArray) {
    }

    default public void readArray(int n, long l) {
    }

    default public void readArrayTimeout(int n, long l, int n2) {
    }

    default public void writeStringArray(int n, long l, String[] stringArray) {
    }

    default public void readStringArray(int n, long l) {
    }

    default public void readStringArrayTimeout(int n, long l, int n2) {
    }

    default public void enterEngineeringSession(int n) {
    }

    default public void exitEngineeringSession(int n) {
    }

    default public void getVisibleSystemLanguages() {
    }

    default public void flushSQLDatabase() {
    }

    default public void setSQLDatabaseMedium(int n) {
    }

    default public void beginTransaction(int n) {
    }

    default public void endTransaction(int n, boolean bl) {
    }

    default public void subscribe(int n, int[] nArray, long[] lArray, int n2) {
    }

    default public void unsubscribe(int n, int[] nArray, long[] lArray) {
    }

    default public void unsubscribeAll(int n) {
    }

    default public void setNotification(int[] nArray) {
    }

    default public void setNotification(int n) {
    }

    default public void setNotification() {
    }

    default public void clearNotification(int[] nArray) {
    }

    default public void clearNotification(int n) {
    }

    default public void clearNotification() {
    }

    default public void yySet(String string, String string2) {
    }
}

