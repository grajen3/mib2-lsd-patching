/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.datapool.internal;

import de.vw.mib.datapool.internal.I18nLanguageBase;
import de.vw.mib.file.FileManager;
import de.vw.mib.hmi.utils.MagicNumber;
import de.vw.mib.hmi.utils.ResData;
import de.vw.mib.i18n.I18nLanguage;
import de.vw.mib.i18n.I18nTableDecoder;
import de.vw.mib.log4mib.Logger;
import de.vw.mib.log4mib.LoggerFactory;
import de.vw.mib.perf.service.PerfService;
import java.io.File;

public class I18nTableDecoderImpl
implements I18nTableDecoder {
    private final int i18nChecksum;
    private final FileManager fileManager;
    private final Logger logger;
    private final PerfService perfService;
    private String lastLoadedDeltaFilePath;
    private I18nLanguage lastLoadedDeltaLanguage;
    private String lastLoadedFullFilePath;
    private I18nLanguage lastLoadedFullLanguage;

    public I18nTableDecoderImpl(int n, FileManager fileManager, LoggerFactory loggerFactory, PerfService perfService) {
        this.logger = loggerFactory.getLogger(1024);
        this.fileManager = fileManager;
        this.i18nChecksum = n;
        this.perfService = perfService;
    }

    @Override
    public I18nLanguage loadI18nTable(File file) {
        if (file.getAbsolutePath().equals(this.lastLoadedFullFilePath)) {
            return this.lastLoadedFullLanguage;
        }
        this.lastLoadedFullLanguage = I18nLanguageBase.createFullLanguage(this.loadTable(MagicNumber.I18N, file));
        this.lastLoadedFullFilePath = file.getAbsolutePath();
        return this.lastLoadedFullLanguage;
    }

    @Override
    public I18nLanguage loadI18nDeltaTable(File file) {
        if (file.getAbsolutePath().equals(this.lastLoadedDeltaFilePath)) {
            return this.lastLoadedDeltaLanguage;
        }
        this.lastLoadedDeltaLanguage = I18nLanguageBase.createDeltaLanguage(this.loadTable(MagicNumber.I18N_DELTA, file));
        this.lastLoadedDeltaFilePath = file.getAbsolutePath();
        return this.lastLoadedDeltaLanguage;
    }

    private Object[] loadTable(MagicNumber magicNumber, File file) {
        this.perfService.performanceLogStartup(1, 2, 1);
        Object[] objectArray = ResData.loadAndCheck(this.fileManager, file, magicNumber, this.i18nChecksum, 0, this.logger, 2048);
        this.perfService.performanceLogStartup(1, 2, 2);
        return objectArray;
    }
}

