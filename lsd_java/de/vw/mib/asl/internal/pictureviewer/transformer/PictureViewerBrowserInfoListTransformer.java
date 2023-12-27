/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.pictureviewer.transformer;

import de.vw.mib.asl.internal.pictureviewer.PictureViewerHelper;
import de.vw.mib.asl.internal.pictureviewer.collector.BrowserCollector;
import generated.de.vw.mib.asl.internal.pictureviewer.transformer.AbstractPictureViewerBrowserInfoListTransformer;

public class PictureViewerBrowserInfoListTransformer
extends AbstractPictureViewerBrowserInfoListTransformer {
    @Override
    public boolean getBoolean(int n, Object object) {
        BrowserCollector browserCollector;
        if (n == 4) {
            BrowserCollector browserCollector2 = (BrowserCollector)object;
            if (browserCollector2 != null) {
                return browserCollector2.isShowErrorText();
            }
        } else if (n == 1 && (browserCollector = (BrowserCollector)object) != null) {
            return browserCollector.isActive();
        }
        return false;
    }

    @Override
    public int getInt(int n, Object object) {
        if (n == 3) {
            return 0;
        }
        if (n == 2) {
            BrowserCollector browserCollector = (BrowserCollector)object;
            return PictureViewerHelper.getElementType(browserCollector);
        }
        return 0;
    }

    @Override
    public long getLong(int n, Object object) {
        BrowserCollector browserCollector;
        if (n == 99 && null != (browserCollector = (BrowserCollector)object).getEntry()) {
            return browserCollector.getEntry().id;
        }
        return 0L;
    }

    @Override
    public String getString(int n, Object object) {
        BrowserCollector browserCollector;
        if (n == 0 && (browserCollector = (BrowserCollector)object).getEntry() != null) {
            return browserCollector.getEntry().filename;
        }
        return "";
    }
}

