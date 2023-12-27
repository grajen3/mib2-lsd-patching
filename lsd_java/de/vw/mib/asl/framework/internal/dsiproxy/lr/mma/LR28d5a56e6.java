/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.framework.internal.dsiproxy.lr.mma;

import de.vw.mib.reflection.MultipleMethodAccessibleObject;
import de.vw.mib.reflection.RuntimeUtil;
import java.lang.reflect.InvocationTargetException;
import org.dsi.ifc.browser.Bookmark;
import org.dsi.ifc.browser.DSIBrowserBoardbookListener;
import org.dsi.ifc.browser.DSIBrowserBookmarkListener;
import org.dsi.ifc.browser.ImportReport;
import org.dsi.ifc.browser.PathInfo;
import org.dsi.ifc.browser.SearchHit;

public final class LR28d5a56e6
extends MultipleMethodAccessibleObject {
    private int a0(int n, boolean bl, int n2) {
        int n3 = -1;
        switch (n) {
            case -1622541400: {
                if (bl) {
                    if (n2 != 1276482132) break;
                    n3 = 2;
                    break;
                }
                n3 = 2;
                break;
            }
            case -435171990: {
                if (bl) {
                    if (n2 != -921385051) break;
                    n3 = 0;
                    break;
                }
                n3 = 0;
                break;
            }
            case 247210509: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 1;
                    break;
                }
                n3 = 1;
                break;
            }
        }
        return n3;
    }

    private int a1(int n, boolean bl, int n2) {
        int n3 = -1;
        switch (n) {
            case -1979042462: {
                if (bl) {
                    if (n2 != 1860576317) break;
                    n3 = 12;
                    break;
                }
                n3 = 12;
                break;
            }
            case -1713083254: {
                if (bl) {
                    if (n2 != -56816085) break;
                    n3 = 13;
                    break;
                }
                n3 = 13;
                break;
            }
            case -1622541400: {
                if (bl) {
                    if (n2 != 1276482132) break;
                    n3 = 16;
                    break;
                }
                n3 = 16;
                break;
            }
            case -1523909614: {
                if (bl) {
                    if (n2 != 1453558626) break;
                    n3 = 6;
                    break;
                }
                n3 = 6;
                break;
            }
            case -351169135: {
                if (bl) {
                    if (n2 != 1860576317) break;
                    n3 = 14;
                    break;
                }
                n3 = 14;
                break;
            }
            case 307810876: {
                if (bl) {
                    if (n2 != 1043255048) break;
                    n3 = 15;
                    break;
                }
                n3 = 15;
                break;
            }
            case 537866857: {
                if (bl) {
                    if (n2 != 1453558626) break;
                    n3 = 5;
                    break;
                }
                n3 = 5;
                break;
            }
            case 745776060: {
                if (bl) {
                    if (n2 != 1453558626) break;
                    n3 = 8;
                    break;
                }
                n3 = 8;
                break;
            }
            case 1305771633: {
                if (bl) {
                    if (n2 != -1322319048) break;
                    n3 = 3;
                    break;
                }
                n3 = 3;
                break;
            }
            case 1500505854: {
                if (bl) {
                    if (n2 != -645498553) break;
                    n3 = 10;
                    break;
                }
                n3 = 10;
                break;
            }
            case 1534381211: {
                if (bl) {
                    if (n2 != -1818193356) break;
                    n3 = 11;
                    break;
                }
                n3 = 11;
                break;
            }
            case 1655416307: {
                if (bl) {
                    if (n2 != 1453558626) break;
                    n3 = 7;
                    break;
                }
                n3 = 7;
                break;
            }
            case 1744523992: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 4;
                    break;
                }
                n3 = 4;
                break;
            }
            case 1792014827: {
                if (bl) {
                    if (n2 != -645498553) break;
                    n3 = 9;
                    break;
                }
                n3 = 9;
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
            case 167956350: {
                n2 = this.a0(n4, bl, n);
                break;
            }
            case 407796057: {
                n2 = this.a1(n4, bl, n);
                break;
            }
        }
        return n2;
    }

    private Object f0(int n, Object object, Object[] objectArray) {
        switch (n) {
            case 0: {
                ((DSIBrowserBoardbookListener)object).indicateSearchResults((String)objectArray[0], ((Number)objectArray[1]).intValue(), (SearchHit[])objectArray[2], ((Number)objectArray[3]).intValue());
                return null;
            }
            case 1: {
                ((DSIBrowserBoardbookListener)object).updateBoardbookStatus(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 2: {
                ((DSIBrowserBoardbookListener)object).asyncException(((Number)objectArray[0]).intValue(), (String)objectArray[1], ((Number)objectArray[2]).intValue());
                return null;
            }
            case 3: {
                ((DSIBrowserBookmarkListener)object).listBookmarksResult((String)objectArray[0], (Bookmark[])objectArray[1], ((Number)objectArray[2]).intValue());
                return null;
            }
            case 4: {
                ((DSIBrowserBookmarkListener)object).bookmarkListInvalid();
                return null;
            }
            case 5: {
                ((DSIBrowserBookmarkListener)object).addBookmarkResult((Bookmark)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 6: {
                ((DSIBrowserBookmarkListener)object).editBookmarkResult((Bookmark)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 7: {
                ((DSIBrowserBookmarkListener)object).deleteBookmarkResult((Bookmark)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 8: {
                ((DSIBrowserBookmarkListener)object).createFolderResult((Bookmark)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 9: {
                ((DSIBrowserBookmarkListener)object).deleteFolderResult((String)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 10: {
                ((DSIBrowserBookmarkListener)object).renameFolderResult((String)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 11: {
                ((DSIBrowserBookmarkListener)object).exportBookmarksResult((PathInfo)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 12: {
                ((DSIBrowserBookmarkListener)object).updateExportBookmarksProgress((PathInfo)objectArray[0], ((Number)objectArray[1]).intValue(), ((Number)objectArray[2]).intValue());
                return null;
            }
            case 13: {
                ((DSIBrowserBookmarkListener)object).importBookmarksResult((PathInfo)objectArray[0], (ImportReport)objectArray[1], ((Number)objectArray[2]).intValue());
                return null;
            }
            case 14: {
                ((DSIBrowserBookmarkListener)object).updateImportBookmarksProgress((PathInfo)objectArray[0], ((Number)objectArray[1]).intValue(), ((Number)objectArray[2]).intValue());
                return null;
            }
            case 15: {
                ((DSIBrowserBookmarkListener)object).getQuotaInformationResult(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue(), ((Number)objectArray[2]).intValue());
                return null;
            }
            case 16: {
                ((DSIBrowserBookmarkListener)object).asyncException(((Number)objectArray[0]).intValue(), (String)objectArray[1], ((Number)objectArray[2]).intValue());
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

