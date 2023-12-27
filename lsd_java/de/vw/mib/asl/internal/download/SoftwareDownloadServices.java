/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.download;

import de.vw.mib.asl.ASLPropertyManager;
import de.vw.mib.asl.framework.api.dsiproxy.DSIProxy;
import de.vw.mib.asl.internal.impl.download.PropagatingDownloadStateService;
import de.vw.mib.configuration.ConfigurationManagerDiag;
import de.vw.mib.genericevents.GenericEvents;
import de.vw.mib.log4mib.Logger;

public interface SoftwareDownloadServices {
    default public DSIProxy getDsiProxy() {
    }

    default public PropagatingDownloadStateService getDownloadStateService() {
    }

    default public ConfigurationManagerDiag getConfigManagerDiag() {
    }

    default public GenericEvents getGenericEvents() {
    }

    default public ASLPropertyManager getPropertyManager() {
    }

    default public Logger getLogger() {
    }
}

