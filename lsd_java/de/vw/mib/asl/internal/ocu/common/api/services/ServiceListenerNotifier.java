/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.ocu.common.api.services;

import de.vw.mib.asl.internal.ocu.common.api.services.ServiceNotifier;

public interface ServiceListenerNotifier {
    default public void notifyServiceListener(Class clazz, ServiceNotifier serviceNotifier) {
    }
}

