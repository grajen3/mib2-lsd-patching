/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.view.internal;

import de.vw.mib.configuration.ConfigurationManager;
import de.vw.mib.file.FileManager;
import de.vw.mib.hmi.utils.MagicNumber;
import de.vw.mib.hmi.utils.ResData;
import de.vw.mib.log4mib.Logger;
import de.vw.mib.log4mib.LoggerFactory;
import de.vw.mib.lsctng.SkinUpdateFailException;
import de.vw.mib.perf.service.PerfService;
import de.vw.mib.skin.SkinResourceUpdater;
import de.vw.mib.view.internal.View2ViewAnimations;
import de.vw.mib.view.internal.View2ViewAnimationsResDataAccess;
import java.io.File;
import java.io.IOException;

public class View2ViewAnimationsUpdaterImpl
implements SkinResourceUpdater {
    public static final String RES_FILE = new StringBuffer().append("view").append(File.separator).append("v2vanims.res").toString();
    private static final int SIGNATURE;
    private static final int LOGGER_CONTEXT;
    private static final int LOGGER_CLASSIFIER;
    private final View2ViewAnimations view2ViewAnimations;
    private final ConfigurationManager configurationManager;
    private final PerfService perfService;
    private final FileManager fileManager;
    private final Logger logger;
    private final int checksum;

    public View2ViewAnimationsUpdaterImpl(View2ViewAnimations view2ViewAnimations, int n, ConfigurationManager configurationManager, FileManager fileManager, PerfService perfService, LoggerFactory loggerFactory) {
        this.view2ViewAnimations = view2ViewAnimations;
        this.configurationManager = configurationManager;
        this.checksum = n;
        this.perfService = perfService;
        this.fileManager = fileManager;
        this.logger = loggerFactory.getLogger(1024);
    }

    @Override
    public void onSkinChanged(int n) {
        try {
            this.updateView2ViewAnimationsData(n);
        }
        catch (IOException iOException) {
            throw new SkinUpdateFailException(new StringBuffer().append("Update animation data '").append(RES_FILE).append("' for skin ").append(n).append(" failed. Cause: ").append(iOException.getMessage()).toString(), iOException);
        }
    }

    private void updateView2ViewAnimationsData(int n) {
        this.logger.normal(4096).append("Update skin [id=").append(n).append("] resources: ").append("animation data ").log();
        File file = ResData.getSkinResFile(this.configurationManager, n, RES_FILE);
        View2ViewAnimationsResDataAccess view2ViewAnimationsResDataAccess = this.load(file);
        this.update(view2ViewAnimationsResDataAccess);
    }

    private View2ViewAnimationsResDataAccess load(File file) {
        this.performanceLog(2, 1);
        Object[] objectArray = ResData.loadAndCheck(this.fileManager, file, MagicNumber.V2VANIMS_RES, this.checksum, -1760351773, this.logger, 4096);
        View2ViewAnimationsResDataAccess view2ViewAnimationsResDataAccess = new View2ViewAnimationsResDataAccess(objectArray);
        this.performanceLog(2, 2);
        return view2ViewAnimationsResDataAccess;
    }

    private void update(View2ViewAnimationsResDataAccess view2ViewAnimationsResDataAccess) {
        this.performanceLog(1, 1);
        this.view2ViewAnimations.updateData(view2ViewAnimationsResDataAccess);
        this.performanceLog(1, 2);
    }

    private void performanceLog(int n, int n2) {
        this.perfService.performanceLogStartup(4, n, n2);
    }
}

