/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.pictureviewer;

import de.vw.mib.asl.internal.pictureviewer.collector.BrowserCollector;
import org.dsi.ifc.filebrowser.BrowsedFile;

public final class PictureViewerHelper {
    private PictureViewerHelper() {
    }

    public static String[] concat(String[] stringArray, String[] stringArray2) {
        String[] stringArray3 = new String[stringArray.length + stringArray2.length];
        System.arraycopy((Object)stringArray, 0, (Object)stringArray3, 0, stringArray.length);
        System.arraycopy((Object)stringArray2, 0, (Object)stringArray3, stringArray.length, stringArray2.length);
        return stringArray3;
    }

    public static int getHMISourceIdFromFileBrowserSourceId(int n) {
        int n2 = 0;
        switch (n) {
            case 0: {
                n2 = 1;
                break;
            }
            case 3: {
                n2 = 3;
                break;
            }
            case 1: {
                n2 = 2;
                break;
            }
            case 2: {
                n2 = 6;
                break;
            }
            case 4: {
                n2 = 7;
                break;
            }
            default: {
                n2 = 0;
            }
        }
        return n2;
    }

    public static int getHMIAvailableBrowsingSourceIdFromFileBrowserSourceId(int n) {
        int n2 = 0;
        switch (n) {
            case 0: {
                n2 = 1;
                break;
            }
            case 1: {
                n2 = 2;
                break;
            }
            case 2: {
                n2 = 6;
                break;
            }
            case 3: {
                n2 = 3;
                break;
            }
            case 4: {
                n2 = 7;
                break;
            }
            default: {
                n2 = 0;
            }
        }
        return n2;
    }

    public static int getFileBrowserSourceIdFromHMISourceId(int n) {
        int n2 = -1;
        switch (n) {
            case 1: {
                n2 = 0;
                break;
            }
            case 3: {
                n2 = 3;
                break;
            }
            case 7: {
                n2 = 4;
                break;
            }
            case 2: {
                n2 = 1;
                break;
            }
            case 6: {
                n2 = 2;
                break;
            }
            default: {
                n2 = -1;
            }
        }
        return n2;
    }

    public static boolean isPictureFile(BrowserCollector browserCollector) {
        return browserCollector != null && PictureViewerHelper.isPictureFile(browserCollector.getEntry());
    }

    private static boolean isPictureFile(BrowsedFile browsedFile) {
        return PictureViewerHelper.getElementType(browsedFile) == 1;
    }

    public static int getElementType(BrowserCollector browserCollector) {
        return browserCollector != null ? PictureViewerHelper.getElementType(browserCollector.getEntry()) : 0;
    }

    private static int getElementType(BrowsedFile browsedFile) {
        int n = 0;
        if (browsedFile != null) {
            n = browsedFile.getFileType() == 2 || browsedFile.getFileType() == 6 ? 1 : 2;
        }
        return n;
    }
}

