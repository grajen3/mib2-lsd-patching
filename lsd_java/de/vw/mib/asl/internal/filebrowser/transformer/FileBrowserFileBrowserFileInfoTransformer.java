/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.filebrowser.transformer;

import de.vw.mib.asl.internal.filebrowser.FileBrowserListCollector;
import generated.de.vw.mib.asl.internal.filebrowser.transformer.AbstractFileBrowserFileBrowserFileInfoTransformer;
import org.dsi.ifc.global.ResourceLocator;

public class FileBrowserFileBrowserFileInfoTransformer
extends AbstractFileBrowserFileBrowserFileInfoTransformer {
    @Override
    public String getString(int n, Object object) {
        if (n == 0) {
            FileBrowserListCollector fileBrowserListCollector = (FileBrowserListCollector)object;
            if (null != fileBrowserListCollector.listEntry) {
                return fileBrowserListCollector.listEntry.filename;
            }
            if (null != fileBrowserListCollector.mediaInfo) {
                return fileBrowserListCollector.mediaInfo.name;
            }
        }
        return "";
    }

    @Override
    public int getInt(int n, Object object) {
        if (n == 1) {
            FileBrowserListCollector fileBrowserListCollector = (FileBrowserListCollector)object;
            if (fileBrowserListCollector.listEntry != null) {
                switch (fileBrowserListCollector.listEntry.fileType) {
                    case 3: {
                        return 0;
                    }
                    case 1: {
                        return 4;
                    }
                    case 6: {
                        return 4;
                    }
                    case 2: {
                        return 4;
                    }
                    case 7: {
                        return 5;
                    }
                }
            } else if (fileBrowserListCollector.mediaInfo != null) {
                return 0;
            }
        }
        return 1;
    }

    @Override
    public ResourceLocator getResourceLocator(int n, Object object) {
        if (n == 2) {
            FileBrowserListCollector fileBrowserListCollector = (FileBrowserListCollector)object;
            if (3 == fileBrowserListCollector.listEntry.fileType) {
                return null;
            }
            return fileBrowserListCollector.resourceLocator;
        }
        return null;
    }

    @Override
    public long getLong(int n, Object object) {
        if (99 == n) {
            FileBrowserListCollector fileBrowserListCollector = (FileBrowserListCollector)object;
            return fileBrowserListCollector.listEntry.id;
        }
        return 0L;
    }
}

