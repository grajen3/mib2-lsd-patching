/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.framework.internal.dsiproxy.lr.mma;

import de.vw.mib.reflection.MultipleMethodAccessibleObject;
import de.vw.mib.reflection.RuntimeUtil;
import java.lang.reflect.InvocationTargetException;
import org.dsi.ifc.global.CharacterInfo;
import org.dsi.ifc.media.DSIMediaBrowserListener;
import org.dsi.ifc.media.DSIMediaOnlineListener;
import org.dsi.ifc.media.ListEntry;
import org.dsi.ifc.media.SearchListEntry;
import org.dsi.ifc.media.SearchListEntryExt;

public final class LR28dd3aa70
extends MultipleMethodAccessibleObject {
    private int a0(int n, boolean bl, int n2) {
        int n3 = -1;
        switch (n) {
            case -2079175651: {
                if (bl) {
                    if (n2 != 1043255048) break;
                    n3 = 4;
                    break;
                }
                n3 = 4;
                break;
            }
            case -1994189337: {
                if (bl) {
                    if (n2 != 148318748) break;
                    n3 = 10;
                    break;
                }
                n3 = 10;
                break;
            }
            case -1948472986: {
                if (bl) {
                    if (n2 != 739712016) break;
                    n3 = 2;
                    break;
                }
                n3 = 2;
                break;
            }
            case -1887776962: {
                if (bl) {
                    if (n2 != -282811157) break;
                    n3 = 8;
                    break;
                }
                n3 = 8;
                break;
            }
            case -1622541400: {
                if (bl) {
                    if (n2 != 1276482132) break;
                    n3 = 17;
                    break;
                }
                n3 = 17;
                break;
            }
            case -1448317077: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 0;
                    break;
                }
                n3 = 0;
                break;
            }
            case -761449091: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 1;
                    break;
                }
                n3 = 1;
                break;
            }
            case -464074378: {
                if (bl) {
                    if (n2 != 2084990025) break;
                    n3 = 3;
                    break;
                }
                n3 = 3;
                break;
            }
            case -344667140: {
                if (bl) {
                    if (n2 != -2071916182) break;
                    n3 = 14;
                    break;
                }
                n3 = 14;
                break;
            }
            case -32321955: {
                if (bl) {
                    if (n2 != -1600866162) break;
                    n3 = 9;
                    break;
                }
                n3 = 9;
                break;
            }
            case 315772467: {
                if (bl) {
                    if (n2 != -16961460) break;
                    n3 = 16;
                    break;
                }
                n3 = 16;
                break;
            }
            case 445077045: {
                if (bl) {
                    if (n2 != 2113417289) break;
                    n3 = 7;
                    break;
                }
                n3 = 7;
                break;
            }
            case 970706839: {
                if (bl) {
                    if (n2 != -33817689) break;
                    n3 = 11;
                    break;
                }
                n3 = 11;
                break;
            }
            case 1269369231: {
                if (bl) {
                    if (n2 != -652084908) break;
                    n3 = 15;
                    break;
                }
                n3 = 15;
                break;
            }
            case 1438986996: {
                if (bl) {
                    if (n2 != 2084990025) break;
                    n3 = 6;
                    break;
                }
                n3 = 6;
                break;
            }
            case 1572986191: {
                if (bl) {
                    if (n2 != 372504021) break;
                    n3 = 12;
                    break;
                }
                n3 = 12;
                break;
            }
            case 1612169890: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 13;
                    break;
                }
                n3 = 13;
                break;
            }
            case 1842557094: {
                if (bl) {
                    if (n2 != -325145337) break;
                    n3 = 5;
                    break;
                }
                n3 = 5;
                break;
            }
        }
        return n3;
    }

    private int a1(int n, boolean bl, int n2) {
        int n3 = -1;
        switch (n) {
            case -1622541400: {
                if (bl) {
                    if (n2 != 1276482132) break;
                    n3 = 21;
                    break;
                }
                n3 = 21;
                break;
            }
            case -1152417585: {
                if (bl) {
                    if (n2 != 1043255048) break;
                    n3 = 19;
                    break;
                }
                n3 = 19;
                break;
            }
            case -550384059: {
                if (bl) {
                    if (n2 != 1043255048) break;
                    n3 = 20;
                    break;
                }
                n3 = 20;
                break;
            }
            case 2119184925: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 18;
                    break;
                }
                n3 = 18;
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
            case -1307875978: {
                n2 = this.a1(n4, bl, n);
                break;
            }
            case -768736553: {
                n2 = this.a0(n4, bl, n);
                break;
            }
        }
        return n2;
    }

    private Object f0(int n, Object object, Object[] objectArray) {
        switch (n) {
            case 0: {
                ((DSIMediaBrowserListener)object).updateBrowseMode(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 1: {
                ((DSIMediaBrowserListener)object).updateContentFilter(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 2: {
                ((DSIMediaBrowserListener)object).updateBrowseMedia(((Number)objectArray[0]).longValue(), ((Number)objectArray[1]).longValue(), ((Number)objectArray[2]).intValue());
                return null;
            }
            case 3: {
                ((DSIMediaBrowserListener)object).updateBrowseFolder((ListEntry[])objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 4: {
                ((DSIMediaBrowserListener)object).updateListSize(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue(), ((Number)objectArray[2]).intValue());
                return null;
            }
            case 5: {
                ((DSIMediaBrowserListener)object).updateAlphabeticalIndex((CharacterInfo[])objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 6: {
                ((DSIMediaBrowserListener)object).responseList((ListEntry[])objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 7: {
                ((DSIMediaBrowserListener)object).responsePickList((ListEntry[])objectArray[0]);
                return null;
            }
            case 8: {
                ((DSIMediaBrowserListener)object).selectionResult(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue(), (Boolean)objectArray[2], ((Number)objectArray[3]).longValue(), ((Number)objectArray[4]).longValue(), ((Number)objectArray[5]).longValue(), ((Number)objectArray[6]).longValue(), ((Number)objectArray[7]).longValue());
                return null;
            }
            case 9: {
                ((DSIMediaBrowserListener)object).responseSetSearchCriteria(((Number)objectArray[0]).intValue(), (Boolean)objectArray[1]);
                return null;
            }
            case 10: {
                ((DSIMediaBrowserListener)object).updateSearchSize(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue(), ((Number)objectArray[2]).intValue(), ((Number)objectArray[3]).intValue(), ((Number)objectArray[4]).intValue());
                return null;
            }
            case 11: {
                ((DSIMediaBrowserListener)object).responseSelectSearchResult(((Number)objectArray[0]).longValue(), ((Number)objectArray[1]).longValue(), (Boolean)objectArray[2]);
                return null;
            }
            case 12: {
                ((DSIMediaBrowserListener)object).responseSetSearchString((String)objectArray[0], (Boolean)objectArray[1]);
                return null;
            }
            case 13: {
                ((DSIMediaBrowserListener)object).updateSearchSpellerState(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 14: {
                ((DSIMediaBrowserListener)object).responseSearchList((SearchListEntry[])objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 15: {
                ((DSIMediaBrowserListener)object).responseSearchListExt((SearchListEntryExt[])objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 16: {
                ((DSIMediaBrowserListener)object).responseFullyQualifiedName(((Number)objectArray[0]).longValue(), (String)objectArray[1]);
                return null;
            }
            case 17: {
                ((DSIMediaBrowserListener)object).asyncException(((Number)objectArray[0]).intValue(), (String)objectArray[1], ((Number)objectArray[2]).intValue());
                return null;
            }
            case 18: {
                ((DSIMediaOnlineListener)object).updateBufferState(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 19: {
                ((DSIMediaOnlineListener)object).updateBufferFillInfo(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue(), ((Number)objectArray[2]).intValue());
                return null;
            }
            case 20: {
                ((DSIMediaOnlineListener)object).updateAudioSettings(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue(), ((Number)objectArray[2]).intValue());
                return null;
            }
            case 21: {
                ((DSIMediaOnlineListener)object).asyncException(((Number)objectArray[0]).intValue(), (String)objectArray[1], ((Number)objectArray[2]).intValue());
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

