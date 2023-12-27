/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.framework.internal.dsiproxy.lr.mma;

import de.vw.mib.reflection.MultipleMethodAccessibleObject;
import de.vw.mib.reflection.RuntimeUtil;
import java.lang.reflect.InvocationTargetException;
import org.dsi.ifc.exlap.DSIExlapListener;
import org.dsi.ifc.exlap.Service;
import org.dsi.ifc.filebrowser.BrowsedFileSet;
import org.dsi.ifc.filebrowser.DSIFileBrowserListener;
import org.dsi.ifc.filebrowser.Path;
import org.dsi.ifc.filebrowser.PreviewInfo;
import org.dsi.ifc.global.ResourceLocator;

public final class LR23dbd9cdd
extends MultipleMethodAccessibleObject {
    private int a0(int n, boolean bl, int n2) {
        int n3 = -1;
        switch (n) {
            case -1908594284: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 0;
                    break;
                }
                n3 = 0;
                break;
            }
            case -1622541400: {
                if (bl) {
                    if (n2 != 1276482132) break;
                    n3 = 3;
                    break;
                }
                n3 = 3;
                break;
            }
            case -1391512268: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 1;
                    break;
                }
                n3 = 1;
                break;
            }
            case -1012417805: {
                if (bl) {
                    if (n2 != -150851648) break;
                    n3 = 2;
                    break;
                }
                n3 = 2;
                break;
            }
        }
        return n3;
    }

    private int a1(int n, boolean bl, int n2) {
        int n3 = -1;
        switch (n) {
            case -1908594284: {
                if (bl) {
                    if (n2 != -327400916) break;
                    n3 = 4;
                    break;
                }
                n3 = 4;
                break;
            }
            case -1754617744: {
                if (bl) {
                    if (n2 != -327400916) break;
                    n3 = 11;
                    break;
                }
                n3 = 11;
                break;
            }
            case -1622541400: {
                if (bl) {
                    if (n2 != 1276482132) break;
                    n3 = 22;
                    break;
                }
                n3 = 22;
                break;
            }
            case -1514300148: {
                if (bl) {
                    if (n2 != 1909456715) break;
                    n3 = 17;
                    break;
                }
                n3 = 17;
                break;
            }
            case -773636305: {
                if (bl) {
                    if (n2 != 1043255048) break;
                    n3 = 14;
                    break;
                }
                n3 = 14;
                break;
            }
            case -749310608: {
                if (bl) {
                    if (n2 != -918199202) break;
                    n3 = 19;
                    break;
                }
                n3 = 19;
                break;
            }
            case -122083641: {
                if (bl) {
                    if (n2 != -918199202) break;
                    n3 = 16;
                    break;
                }
                n3 = 16;
                break;
            }
            case 86304683: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 5;
                    break;
                }
                n3 = 5;
                break;
            }
            case 156816227: {
                if (bl) {
                    if (n2 != -448335035) break;
                    n3 = 15;
                    break;
                }
                n3 = 15;
                break;
            }
            case 212599621: {
                if (bl) {
                    if (n2 != 1043255048) break;
                    n3 = 10;
                    break;
                }
                n3 = 10;
                break;
            }
            case 361729588: {
                if (bl) {
                    if (n2 != -1596423190) break;
                    n3 = 9;
                    break;
                }
                n3 = 9;
                break;
            }
            case 833170638: {
                if (bl) {
                    if (n2 != -414876240) break;
                    n3 = 8;
                    break;
                }
                n3 = 8;
                break;
            }
            case 1011680605: {
                if (bl) {
                    if (n2 != 1509154938) break;
                    n3 = 7;
                    break;
                }
                n3 = 7;
                break;
            }
            case 1231744792: {
                if (bl) {
                    if (n2 != 1043255048) break;
                    n3 = 12;
                    break;
                }
                n3 = 12;
                break;
            }
            case 1368384176: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 18;
                    break;
                }
                n3 = 18;
                break;
            }
            case 1693325875: {
                if (bl) {
                    if (n2 != -162971537) break;
                    n3 = 13;
                    break;
                }
                n3 = 13;
                break;
            }
            case 1739152641: {
                if (bl) {
                    if (n2 != -1229977572) break;
                    n3 = 20;
                    break;
                }
                n3 = 20;
                break;
            }
            case 1934853599: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 21;
                    break;
                }
                n3 = 21;
                break;
            }
            case 2076610978: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 6;
                    break;
                }
                n3 = 6;
                break;
            }
        }
        return n3;
    }

    @Override
    public int getIndex(String string, String string2, Class[] classArray) {
        int n;
        boolean bl;
        int n2 = -1;
        int n3 = RuntimeUtil.buildKey(string);
        int n4 = RuntimeUtil.buildKey(string2);
        if (classArray != null) {
            bl = true;
            n = RuntimeUtil.buildKey(classArray);
        } else {
            bl = false;
            n = 0;
        }
        switch (n3) {
            case 115819363: {
                n2 = this.a1(n4, bl, n);
                break;
            }
            case 1045488131: {
                n2 = this.a0(n4, bl, n);
                break;
            }
        }
        return n2;
    }

    private Object f0(int n, Object object, Object[] objectArray) {
        switch (n) {
            case 0: {
                ((DSIExlapListener)object).startResult(((Number)objectArray[0]).intValue());
                return null;
            }
            case 1: {
                ((DSIExlapListener)object).stopResult(((Number)objectArray[0]).intValue());
                return null;
            }
            case 2: {
                ((DSIExlapListener)object).updateAvailableServices((Service[])objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 3: {
                ((DSIExlapListener)object).asyncException(((Number)objectArray[0]).intValue(), (String)objectArray[1], ((Number)objectArray[2]).intValue());
                return null;
            }
            case 4: {
                ((DSIFileBrowserListener)object).startResult(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue(), (Path)objectArray[2]);
                return null;
            }
            case 5: {
                ((DSIFileBrowserListener)object).setFileExtensionFilterResult(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 6: {
                ((DSIFileBrowserListener)object).setFileTypeFilterResult(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 7: {
                ((DSIFileBrowserListener)object).getViewWindowResult(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue(), ((Number)objectArray[2]).intValue(), (BrowsedFileSet)objectArray[3], ((Number)objectArray[4]).intValue());
                return null;
            }
            case 8: {
                ((DSIFileBrowserListener)object).getViewWindowWithPreviewsResult(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue(), ((Number)objectArray[2]).intValue(), (BrowsedFileSet)objectArray[3], (PreviewInfo[])objectArray[4], ((Number)objectArray[5]).intValue());
                return null;
            }
            case 9: {
                ((DSIFileBrowserListener)object).getResourceLocatorWindowResult(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue(), ((Number)objectArray[2]).intValue(), (ResourceLocator[])objectArray[3], ((Number)objectArray[4]).intValue());
                return null;
            }
            case 10: {
                ((DSIFileBrowserListener)object).indicateSelectionResult(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue(), ((Number)objectArray[2]).intValue());
                return null;
            }
            case 11: {
                ((DSIFileBrowserListener)object).changeFolderResult(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue(), (Path)objectArray[2]);
                return null;
            }
            case 12: {
                ((DSIFileBrowserListener)object).getSelectedFilesResult(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue(), ((Number)objectArray[2]).intValue());
                return null;
            }
            case 13: {
                ((DSIFileBrowserListener)object).getResourceLocatorsResult(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue(), (ResourceLocator[])objectArray[2]);
                return null;
            }
            case 14: {
                ((DSIFileBrowserListener)object).getFileCountResult(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue(), ((Number)objectArray[2]).intValue());
                return null;
            }
            case 15: {
                ((DSIFileBrowserListener)object).getFileCountWithFileTypeFilterResult(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue(), ((Number)objectArray[2]).intValue(), ((Number)objectArray[3]).intValue());
                return null;
            }
            case 16: {
                ((DSIFileBrowserListener)object).spellerResult(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue(), (String)objectArray[2], (String)objectArray[3]);
                return null;
            }
            case 17: {
                ((DSIFileBrowserListener)object).setLanguageResult(((Number)objectArray[0]).intValue(), (String)objectArray[1]);
                return null;
            }
            case 18: {
                ((DSIFileBrowserListener)object).setFileTypeActiveResult(((Number)objectArray[0]).intValue());
                return null;
            }
            case 19: {
                ((DSIFileBrowserListener)object).validateSpellerCharsResult(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue(), (String)objectArray[2], (String)objectArray[3]);
                return null;
            }
            case 20: {
                ((DSIFileBrowserListener)object).createPreviewImageResult((ResourceLocator)objectArray[0], (ResourceLocator)objectArray[1], ((Number)objectArray[2]).intValue());
                return null;
            }
            case 21: {
                ((DSIFileBrowserListener)object).cancelPreviewCreationResult(((Number)objectArray[0]).intValue());
                return null;
            }
            case 22: {
                ((DSIFileBrowserListener)object).asyncException(((Number)objectArray[0]).intValue(), (String)objectArray[1], ((Number)objectArray[2]).intValue());
                return null;
            }
        }
        return null;
    }

    @Override
    public Object invoke(int n, Object object, Object[] objectArray) {
        try {
            switch (n >> 5) {
                case 0: {
                    return this.f0(n, object, objectArray);
                }
            }
            return null;
        }
        catch (Throwable throwable) {
            throw new InvocationTargetException(throwable);
        }
    }
}

