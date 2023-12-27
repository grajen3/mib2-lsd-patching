/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.clientapi.list.impl;

import de.vw.mib.list.HMIListDataFactory;
import de.vw.mib.log4mib.ClassifiedLogger;
import de.vw.mib.threads.MIBInvoker;
import de.vw.mib.timer.TimerManager;

interface Services {
    default public HMIListDataFactory getFactory() {
    }

    default public ClassifiedLogger getLogger() {
    }

    default public TimerManager getTimerManager() {
    }

    default public MIBInvoker getASLInvoker() {
    }
}

