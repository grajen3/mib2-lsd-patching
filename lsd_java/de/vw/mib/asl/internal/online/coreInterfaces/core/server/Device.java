/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.online.coreInterfaces.core.server;

import de.vw.mib.asl.internal.online.coreInterfaces.core.server.Service;
import de.vw.mib.asl.internal.online.coreInterfaces.core.server.User;

public interface Device {
    default public int getDeviceID() {
    }

    default public String getDeviceName() {
    }

    default public boolean isMainDevice() {
    }

    default public void setServiceList(Service[] serviceArray) {
    }

    default public void addService(Service service) {
    }

    default public Service[] getServiceList() {
    }

    default public boolean checkIfServiceAvailable(Service service) {
    }

    default public Service getServiceWithID(String string) {
    }

    default public void setUserList(User[] userArray) {
    }

    default public void addUser(User user) {
    }

    default public User[] getUserList() {
    }

    default public boolean checkIfUserAvailable(User user) {
    }

    default public User getUserWithID(int n) {
    }

    default public void setDeviceType(int n) {
    }

    default public int getDeviceType() {
    }

    default public void copyTo(Device device) {
    }
}

