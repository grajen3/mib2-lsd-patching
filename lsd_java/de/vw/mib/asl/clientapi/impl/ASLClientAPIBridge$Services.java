/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.clientapi.impl;

import de.vw.mib.asl.clientapi.impl.Clock;
import de.vw.mib.asl.clientapi.list.ASLClientListFactory;
import de.vw.mib.list.HMIListRegistry;
import de.vw.mib.log4mib.ClassifiedLogger;
import de.vw.mib.timer.Invoker;

public interface ASLClientAPIBridge$Services {
    default public ASLClientListFactory getASLClientListFactory() {
    }

    default public Invoker getASLInvoker() {
    }

    default public ClassifiedLogger getClassifiedLogger() {
    }

    default public Clock getClock() {
    }

    default public HMIListRegistry getHMIListRegistry() {
    }
}

