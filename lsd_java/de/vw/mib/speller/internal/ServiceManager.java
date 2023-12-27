/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.speller.internal;

import de.vw.mib.log4mib.Logger;
import de.vw.mib.log4mib.LoggerFactory;
import de.vw.mib.speller.SpellerController;
import de.vw.mib.speller.hwr.HWRManager;
import de.vw.mib.threads.AsyncServiceFactory;

final class ServiceManager {
    static LoggerFactory loggerFactory;
    static Logger logger;
    static HWRManager hwrManager;
    static AsyncServiceFactory asyncServiceFactoryMain;
    static AsyncServiceFactory asyncServiceFactoryHSM;
    static SpellerController spellerController;

    private ServiceManager() {
    }
}

