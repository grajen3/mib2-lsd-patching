/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.dynamicresourcedata.internal;

import de.vw.mib.dynamicresourcedata.DynamicResourceData;
import de.vw.mib.dynamicresourcedata.DynamicResourceDataDescription;
import de.vw.mib.dynamicresourcedata.DynamicResourceDataFactory;
import de.vw.mib.dynamicresourcedata.internal.DynamicResourceDataDescriptionImpl;
import de.vw.mib.dynamicresourcedata.internal.NullDynamicResourceData;
import de.vw.mib.file.FileManager;
import de.vw.mib.log4mib.LoggerFactory;
import java.io.File;
import java.io.IOException;

public class DynamicResourceDataFactoryImpl
implements DynamicResourceDataFactory {
    private final FileManager fileManager;
    private final LoggerFactory loggerFactory;
    private DynamicResourceData imageCache = null;
    private DynamicResourceData colorCache = null;

    DynamicResourceDataFactoryImpl(LoggerFactory loggerFactory, FileManager fileManager) {
        this.loggerFactory = loggerFactory;
        this.fileManager = fileManager;
    }

    @Override
    public DynamicResourceDataDescription newDynamicResourceData(String string, String string2) {
        try {
            if (this.imageCache == null) {
                this.imageCache = this.createResourceCache(string, "images");
            }
        }
        catch (IOException iOException) {
            this.imageCache = new NullDynamicResourceData();
        }
        if (this.colorCache == null) {
            this.colorCache = new NullDynamicResourceData();
        }
        return this.createDynamicResourceData(string, string2);
    }

    private DynamicResourceDataDescription createDynamicResourceData(String string, String string2) {
        Object[] objectArray = this.fileManager.readDataFromObjectSwapperFile(this.getFile(string, string2));
        return new DynamicResourceDataDescriptionImpl(string2, this.loggerFactory.getLogger(2048), objectArray, this.imageCache, this.colorCache);
    }

    private File getFile(String string, String string2) {
        StringBuffer stringBuffer = new StringBuffer(256);
        stringBuffer.append("mapping_");
        stringBuffer.append(string2);
        stringBuffer.append(".res");
        return new File(string, stringBuffer.toString());
    }

    private DynamicResourceData createResourceCache(String string, String string2) {
        DynamicResourceDataDescription dynamicResourceDataDescription = this.createDynamicResourceData(string, string2);
        dynamicResourceDataDescription.input("id");
        dynamicResourceDataDescription.output("value", -1);
        return dynamicResourceDataDescription.create();
    }
}

