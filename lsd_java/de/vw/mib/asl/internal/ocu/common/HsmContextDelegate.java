/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.ocu.common;

import de.vw.mib.asl.internal.ocu.common.api.BAPDisplayControlUnit;
import de.vw.mib.asl.internal.ocu.common.api.OCUService;
import de.vw.mib.asl.internal.ocu.common.api.OcuServiceProxy;
import de.vw.mib.log4mib.Logger;
import java.util.List;

public interface HsmContextDelegate {
    default public Logger getLogger() {
    }

    default public int getSubClassifier() {
    }

    default public BAPDisplayControlUnit getLogicalControlUnit() {
    }

    default public OcuServiceProxy getOCUServiceProxy() {
    }

    default public OCUService getOCUService() {
    }

    default public void registerObservers() {
    }

    default public void registerServiceReceiver(Object object, Class clazz, int[] nArray) {
    }

    default public void unregisterServiceReceiver(Object object, Class clazz, int[] nArray) {
    }

    default public void registerServiceProvider(Object object, Class clazz, int[] nArray) {
    }

    default public void unRegisterServiceProvider(Object object, Class clazz, int[] nArray) {
    }

    default public void registerServiceProviderListener(Object object, Class clazz, int[] nArray) {
    }

    default public void unRegisterServiceProviderListener(Object object, Class clazz, int[] nArray) {
    }

    default public List getRegisteredServiceListeners(Class clazz) {
    }
}

