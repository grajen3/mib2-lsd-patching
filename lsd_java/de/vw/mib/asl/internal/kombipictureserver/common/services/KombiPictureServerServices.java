/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.kombipictureserver.common.services;

import de.vw.mib.asl.internal.kombipictureserver.common.services.LoggerFacade;
import de.vw.mib.datapool.ASLDatapool;
import de.vw.mib.genericevents.Target;
import de.vw.mib.genericevents.ThreadSwitchingTarget;
import de.vw.mib.log4mib.Logger;
import de.vw.mib.timer.TimerManager;
import org.dsi.ifc.kombipictureserver.DSIKombiPictureServer;

public interface KombiPictureServerServices {
    default public LoggerFacade createLoggerFacade(Class clazz, int n) {
    }

    default public ASLDatapool getDataPool() {
    }

    default public DSIKombiPictureServer getDsiKombiPictureServer(Target target) {
    }

    default public Logger getLogger() {
    }

    default public ThreadSwitchingTarget getThreadSwitchingTarget() {
    }

    default public TimerManager getTimerManager() {
    }
}

