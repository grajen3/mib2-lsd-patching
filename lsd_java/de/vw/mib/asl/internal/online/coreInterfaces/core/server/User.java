/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.online.coreInterfaces.core.server;

public interface User {
    default public String getUserName() {
    }

    default public void setUserName(String string) {
    }

    default public int getUserID() {
    }

    default public void setUserID(int n) {
    }

    default public boolean isMainUser() {
    }

    default public void setAsMainUser(boolean bl) {
    }

    default public int getDeviceID() {
    }

    default public void setDeviceID(int n) {
    }

    default public int getUserType() {
    }

    default public void setUserType(int n) {
    }

    default public void copyTo(User user) {
    }

    default public boolean equalsTo(User user) {
    }
}

