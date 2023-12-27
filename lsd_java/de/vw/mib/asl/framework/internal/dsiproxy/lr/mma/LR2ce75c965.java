/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.framework.internal.dsiproxy.lr.mma;

import de.vw.mib.reflection.MultipleMethodAccessibleObject;
import de.vw.mib.reflection.RuntimeUtil;
import java.lang.reflect.InvocationTargetException;
import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.exlap.DSIExlap;
import org.dsi.ifc.filebrowser.BrowsedFile;
import org.dsi.ifc.filebrowser.BrowsedFileSet;
import org.dsi.ifc.filebrowser.DSIFileBrowser;
import org.dsi.ifc.filebrowser.Path;
import org.dsi.ifc.global.ResourceLocator;

public final class LR2ce75c965
extends MultipleMethodAccessibleObject {
    private int a0(int n, boolean bl, int n2) {
        int n3 = -1;
        switch (n) {
            case -1162471198: {
                if (bl) {
                    if (n2 == -904616957) {
                        n3 = 2;
                        break;
                    }
                    if (n2 == 1805755651) {
                        n3 = 3;
                        break;
                    }
                    if (n2 != -864245041) break;
                    n3 = 4;
                    break;
                }
                n3 = 2;
                break;
            }
            case -948729267: {
                if (bl) {
                    if (n2 == -904616957) {
                        n3 = 5;
                        break;
                    }
                    if (n2 == 1805755651) {
                        n3 = 6;
                        break;
                    }
                    if (n2 != -864245041) break;
                    n3 = 7;
                    break;
                }
                n3 = 5;
                break;
            }
            case 3541623: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 1;
                    break;
                }
                n3 = 1;
                break;
            }
            case 109758167: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 0;
                    break;
                }
                n3 = 0;
                break;
            }
        }
        return n3;
    }

    private int a1(int n, boolean bl, int n2) {
        int n3 = -1;
        switch (n) {
            case -2142640248: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 24;
                    break;
                }
                n3 = 24;
                break;
            }
            case -2110971017: {
                if (bl) {
                    if (n2 != 1043255048) break;
                    n3 = 17;
                    break;
                }
                n3 = 17;
                break;
            }
            case -2055639712: {
                if (bl) {
                    if (n2 != 1043255048) break;
                    n3 = 14;
                    break;
                }
                n3 = 14;
                break;
            }
            case -2009758477: {
                if (bl) {
                    if (n2 != -1653679357) break;
                    n3 = 28;
                    break;
                }
                n3 = 28;
                break;
            }
            case -1861299867: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 13;
                    break;
                }
                n3 = 13;
                break;
            }
            case -1855295460: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 26;
                    break;
                }
                n3 = 26;
                break;
            }
            case -1672924902: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 30;
                    break;
                }
                n3 = 30;
                break;
            }
            case -1625277039: {
                if (bl) {
                    if (n2 != 1043255048) break;
                    n3 = 15;
                    break;
                }
                n3 = 15;
                break;
            }
            case -1398933849: {
                if (bl) {
                    if (n2 != 173545954) break;
                    n3 = 22;
                    break;
                }
                n3 = 22;
                break;
            }
            case -1368892746: {
                if (bl) {
                    if (n2 != 473957947) break;
                    n3 = 19;
                    break;
                }
                n3 = 19;
                break;
            }
            case -1351881550: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 20;
                    break;
                }
                n3 = 20;
                break;
            }
            case -1162471198: {
                if (bl) {
                    if (n2 == -904616957) {
                        n3 = 33;
                        break;
                    }
                    if (n2 == 1805755651) {
                        n3 = 34;
                        break;
                    }
                    if (n2 != -864245041) break;
                    n3 = 35;
                    break;
                }
                n3 = 33;
                break;
            }
            case -1025394714: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 21;
                    break;
                }
                n3 = 21;
                break;
            }
            case -948729267: {
                if (bl) {
                    if (n2 == -904616957) {
                        n3 = 36;
                        break;
                    }
                    if (n2 == 1805755651) {
                        n3 = 37;
                        break;
                    }
                    if (n2 != -864245041) break;
                    n3 = 38;
                    break;
                }
                n3 = 36;
                break;
            }
            case -469263693: {
                if (bl) {
                    if (n2 != -110289656) break;
                    n3 = 23;
                    break;
                }
                n3 = 23;
                break;
            }
            case -176577089: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 11;
                    break;
                }
                n3 = 11;
                break;
            }
            case 3541623: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 9;
                    break;
                }
                n3 = 9;
                break;
            }
            case 109758167: {
                if (bl) {
                    if (n2 != -1028498785) break;
                    n3 = 8;
                    break;
                }
                n3 = 8;
                break;
            }
            case 315359067: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 18;
                    break;
                }
                n3 = 18;
                break;
            }
            case 375731279: {
                if (bl) {
                    if (n2 != -633848249) break;
                    n3 = 10;
                    break;
                }
                n3 = 10;
                break;
            }
            case 562231138: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 32;
                    break;
                }
                n3 = 32;
                break;
            }
            case 608784388: {
                if (bl) {
                    if (n2 != -1830296352) break;
                    n3 = 31;
                    break;
                }
                n3 = 31;
                break;
            }
            case 652563142: {
                if (bl) {
                    if (n2 != 742346682) break;
                    n3 = 16;
                    break;
                }
                n3 = 16;
                break;
            }
            case 1002000360: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 27;
                    break;
                }
                n3 = 27;
                break;
            }
            case 1027908142: {
                if (bl) {
                    if (n2 != -785441950) break;
                    n3 = 12;
                    break;
                }
                n3 = 12;
                break;
            }
            case 1500192691: {
                if (bl) {
                    if (n2 != 1909456715) break;
                    n3 = 29;
                    break;
                }
                n3 = 29;
                break;
            }
            case 2058454718: {
                if (bl) {
                    if (n2 != 1909456715) break;
                    n3 = 25;
                    break;
                }
                n3 = 25;
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
            case 177279791: {
                n2 = this.a0(n4, bl, n);
                break;
            }
            case 785306767: {
                n2 = this.a1(n4, bl, n);
                break;
            }
        }
        return n2;
    }

    private Object f0(int n, Object object, Object[] objectArray) {
        switch (n) {
            case 0: {
                ((DSIExlap)object).start();
                return null;
            }
            case 1: {
                ((DSIExlap)object).stop();
                return null;
            }
            case 2: {
                ((DSIExlap)object).setNotification((int[])objectArray[0], (DSIListener)objectArray[1]);
                return null;
            }
            case 3: {
                ((DSIExlap)object).setNotification(((Number)objectArray[0]).intValue(), (DSIListener)objectArray[1]);
                return null;
            }
            case 4: {
                ((DSIExlap)object).setNotification((DSIListener)objectArray[0]);
                return null;
            }
            case 5: {
                ((DSIExlap)object).clearNotification((int[])objectArray[0], (DSIListener)objectArray[1]);
                return null;
            }
            case 6: {
                ((DSIExlap)object).clearNotification(((Number)objectArray[0]).intValue(), (DSIListener)objectArray[1]);
                return null;
            }
            case 7: {
                ((DSIExlap)object).clearNotification((DSIListener)objectArray[0]);
                return null;
            }
            case 8: {
                ((DSIFileBrowser)object).start((Path)objectArray[0]);
                return null;
            }
            case 9: {
                ((DSIFileBrowser)object).stop(((Number)objectArray[0]).intValue());
                return null;
            }
            case 10: {
                ((DSIFileBrowser)object).setLanguage((String)objectArray[0]);
                return null;
            }
            case 11: {
                ((DSIFileBrowser)object).setSelection(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 12: {
                ((DSIFileBrowser)object).setFileExtensionFilter(((Number)objectArray[0]).intValue(), (String[])objectArray[1]);
                return null;
            }
            case 13: {
                ((DSIFileBrowser)object).setFileTypeFilter(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 14: {
                ((DSIFileBrowser)object).getViewWindow(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue(), ((Number)objectArray[2]).intValue());
                return null;
            }
            case 15: {
                ((DSIFileBrowser)object).getViewWindowWithPreviews(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue(), ((Number)objectArray[2]).intValue());
                return null;
            }
            case 16: {
                ((DSIFileBrowser)object).getViewWindowFromFile(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue(), (BrowsedFile)objectArray[2], ((Number)objectArray[3]).intValue());
                return null;
            }
            case 17: {
                ((DSIFileBrowser)object).getResourceLocatorWindow(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue(), ((Number)objectArray[2]).intValue());
                return null;
            }
            case 18: {
                ((DSIFileBrowser)object).getSelectedFiles(((Number)objectArray[0]).intValue());
                return null;
            }
            case 19: {
                ((DSIFileBrowser)object).getResourceLocators(((Number)objectArray[0]).intValue(), (BrowsedFileSet)objectArray[1]);
                return null;
            }
            case 20: {
                ((DSIFileBrowser)object).getFileCount(((Number)objectArray[0]).intValue());
                return null;
            }
            case 21: {
                ((DSIFileBrowser)object).getFileCountWithFileTypeFilter(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 22: {
                ((DSIFileBrowser)object).setSelectionSingle(((Number)objectArray[0]).intValue(), (BrowsedFile)objectArray[1], (Boolean)objectArray[2]);
                return null;
            }
            case 23: {
                ((DSIFileBrowser)object).changeFolder(((Number)objectArray[0]).intValue(), (Path)objectArray[1]);
                return null;
            }
            case 24: {
                ((DSIFileBrowser)object).startSpeller(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 25: {
                ((DSIFileBrowser)object).addSpellerChars(((Number)objectArray[0]).intValue(), (String)objectArray[1]);
                return null;
            }
            case 26: {
                ((DSIFileBrowser)object).removeSpellerChar(((Number)objectArray[0]).intValue());
                return null;
            }
            case 27: {
                ((DSIFileBrowser)object).stopSpeller(((Number)objectArray[0]).intValue());
                return null;
            }
            case 28: {
                ((DSIFileBrowser)object).setFileTypeActive((Boolean)objectArray[0]);
                return null;
            }
            case 29: {
                ((DSIFileBrowser)object).validateSpellerChars(((Number)objectArray[0]).intValue(), (String)objectArray[1]);
                return null;
            }
            case 30: {
                ((DSIFileBrowser)object).deleteAllPreviewFiles();
                return null;
            }
            case 31: {
                ((DSIFileBrowser)object).createPreviewImage((ResourceLocator)objectArray[0], ((Number)objectArray[1]).intValue(), ((Number)objectArray[2]).intValue());
                return null;
            }
        }
        return null;
    }

    private Object f1(int n, Object object, Object[] objectArray) {
        switch (n) {
            case 32: {
                ((DSIFileBrowser)object).cancelPreviewCreation();
                return null;
            }
            case 33: {
                ((DSIFileBrowser)object).setNotification((int[])objectArray[0], (DSIListener)objectArray[1]);
                return null;
            }
            case 34: {
                ((DSIFileBrowser)object).setNotification(((Number)objectArray[0]).intValue(), (DSIListener)objectArray[1]);
                return null;
            }
            case 35: {
                ((DSIFileBrowser)object).setNotification((DSIListener)objectArray[0]);
                return null;
            }
            case 36: {
                ((DSIFileBrowser)object).clearNotification((int[])objectArray[0], (DSIListener)objectArray[1]);
                return null;
            }
            case 37: {
                ((DSIFileBrowser)object).clearNotification(((Number)objectArray[0]).intValue(), (DSIListener)objectArray[1]);
                return null;
            }
            case 38: {
                ((DSIFileBrowser)object).clearNotification((DSIListener)objectArray[0]);
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
                case 1: {
                    return this.f1(n, object, objectArray);
                }
            }
            return null;
        }
        catch (Throwable throwable) {
            throw new InvocationTargetException(throwable);
        }
    }
}

