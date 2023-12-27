/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.system.util;

import de.vw.mib.asl.ASLPropertyManager;
import de.vw.mib.asl.internal.system.SystemServices;
import de.vw.mib.asl.internal.system.has.SystemHasBridge;
import de.vw.mib.asl.internal.system.util.VersionNumberUpdater$1;
import de.vw.mib.configuration.ConfigurationManagerDiag;
import de.vw.mib.configuration.NvListener;
import de.vw.mib.threads.AsyncServiceFactory;

public class VersionNumberUpdater {
    private final ASLPropertyManager propertyManager;
    private final ConfigurationManagerDiag configurationManager;
    private final SystemHasBridge systemHasBridge;
    private final AsyncServiceFactory asyncServiceFactory;

    public VersionNumberUpdater(SystemServices systemServices) {
        this.propertyManager = systemServices.getPropertyManager();
        this.configurationManager = systemServices.getConfigManagerDiag();
        this.systemHasBridge = systemServices.getSystemHasBridge();
        this.asyncServiceFactory = systemServices.getAsyncServiceFactory();
    }

    public void run() {
        NvListener nvListener = this.createConfigurationManagerListener(this.asyncServiceFactory);
        this.configurationManager.addNvListener(nvListener, 3);
        this.updateVersionInformation();
    }

    void updateVersionInformation() {
        this.propertyManager.valueChangedString(1620, this.configurationManager.getSkinBuildHmiSoftwareVersion());
        this.propertyManager.valueChangedString(1621, this.configurationManager.getSkinEditorVersion());
        this.propertyManager.valueChangedString(1623, this.configurationManager.getSkinModelVersion());
        this.propertyManager.valueChangedString(1625, this.configurationManager.getSkinShortVersion());
        this.propertyManager.valueChangedString(1609, this.configurationManager.getHmiSoftwareVersion());
        this.propertyManager.valueChangedString(1626, this.configurationManager.getHmiSoftwareCgRunVersion());
        this.propertyManager.valueChangedString(1638, this.configurationManager.getTranslationDate());
        this.propertyManager.valueChangedString(1608, this.configurationManager.getHmiSoftwareBaseVersion());
        this.systemHasBridge.setPropertySoftwareRevision(this.configurationManager.getHmiSoftwareBaseVersion());
    }

    private NvListener createConfigurationManagerListener(AsyncServiceFactory asyncServiceFactory) {
        NvListener nvListener = new VersionNumberUpdater$1(this);
        nvListener = (NvListener)asyncServiceFactory.create(nvListener);
        return nvListener;
    }
}

