/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.online.coreInterfaces.core.server;

import de.vw.mib.asl.internal.online.coreInterfaces.core.server.Service;

public interface Application {
    default public String getApplicationID() {
    }

    default public void setApplicationID(String string) {
    }

    default public void setDeviceID(int n) {
    }

    default public int getDeviceID() {
    }

    default public void setApplicationState(int n) {
    }

    default public int getApplicationState() {
    }

    default public boolean isApplicationDeactivated() {
    }

    default public void deactivateApplication(boolean bl) {
    }

    default public boolean isApplicationInvisible() {
    }

    default public void setApplicationInvisible(boolean bl) {
    }

    default public boolean isDeactivationBlocked() {
    }

    default public void setDeactivationBlocked(boolean bl) {
    }

    default public Service[] getServiceList() {
    }

    default public void setServiceList(Service[] serviceArray) {
    }

    default public void addService(Service service) {
    }

    default public Service getServiceWithID(String string) {
    }

    default public boolean isServiceExists(Service service, String string) {
    }

    default public void copyTo(Application application) {
    }
}

