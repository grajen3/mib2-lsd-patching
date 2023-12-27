/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.framework.internal.dsiproxy.lr.mma;

import de.vw.mib.reflection.MultipleMethodAccessibleObject;
import de.vw.mib.reflection.RuntimeUtil;
import java.lang.reflect.InvocationTargetException;
import org.dsi.ifc.organizer.AdbEntry;
import org.dsi.ifc.organizer.DSIAdbDataResolutionListener;
import org.dsi.ifc.organizer.DSIAdbEditListener;
import org.dsi.ifc.organizer.DataSet;

public final class LR242c65405
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
            case 358331834: {
                if (bl) {
                    if (n2 != 1431703443) break;
                    n3 = 1;
                    break;
                }
                n3 = 1;
                break;
            }
            case 1441548963: {
                if (bl) {
                    if (n2 != 1431703443) break;
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
            case -2034021492: {
                if (bl) {
                    if (n2 != -1835876800) break;
                    n3 = 8;
                    break;
                }
                n3 = 8;
                break;
            }
            case -2002237177: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 13;
                    break;
                }
                n3 = 13;
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
            case -1220409513: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 12;
                    break;
                }
                n3 = 12;
                break;
            }
            case -934392081: {
                if (bl) {
                    if (n2 != 1349647600) break;
                    n3 = 11;
                    break;
                }
                n3 = 11;
                break;
            }
            case -882440343: {
                if (bl) {
                    if (n2 != 1431703443) break;
                    n3 = 9;
                    break;
                }
                n3 = 9;
                break;
            }
            case 187729876: {
                if (bl) {
                    if (n2 != 1349647600) break;
                    n3 = 10;
                    break;
                }
                n3 = 10;
                break;
            }
            case 1138999301: {
                if (bl) {
                    if (n2 != 1349647600) break;
                    n3 = 15;
                    break;
                }
                n3 = 15;
                break;
            }
            case 1202626160: {
                if (bl) {
                    if (n2 != -1665395196) break;
                    n3 = 16;
                    break;
                }
                n3 = 16;
                break;
            }
            case 1279412523: {
                if (bl) {
                    if (n2 != 1349647600) break;
                    n3 = 7;
                    break;
                }
                n3 = 7;
                break;
            }
            case 1569760414: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 14;
                    break;
                }
                n3 = 14;
                break;
            }
            case 1629892732: {
                if (bl) {
                    if (n2 != -1665395196) break;
                    n3 = 5;
                    break;
                }
                n3 = 5;
                break;
            }
            case 1765171573: {
                if (bl) {
                    if (n2 != -1665395196) break;
                    n3 = 4;
                    break;
                }
                n3 = 4;
                break;
            }
            case 1904960954: {
                if (bl) {
                    if (n2 != -1665395196) break;
                    n3 = 6;
                    break;
                }
                n3 = 6;
                break;
            }
            case 1931654371: {
                if (bl) {
                    if (n2 != -1665395196) break;
                    n3 = 3;
                    break;
                }
                n3 = 3;
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
            case -906919363: {
                n2 = this.a1(n4, bl, n);
                break;
            }
            case 316572585: {
                n2 = this.a0(n4, bl, n);
                break;
            }
        }
        return n2;
    }

    private Object f0(int n, Object object, Object[] objectArray) {
        switch (n) {
            case 0: {
                ((DSIAdbDataResolutionListener)object).resolveMailAddressResult(((Number)objectArray[0]).intValue(), (DataSet[])objectArray[1]);
                return null;
            }
            case 1: {
                ((DSIAdbDataResolutionListener)object).resolvePhoneNumbersResult(((Number)objectArray[0]).intValue(), (DataSet[])objectArray[1]);
                return null;
            }
            case 2: {
                ((DSIAdbDataResolutionListener)object).asyncException(((Number)objectArray[0]).intValue(), (String)objectArray[1], ((Number)objectArray[2]).intValue());
                return null;
            }
            case 3: {
                ((DSIAdbEditListener)object).updateNewEntryAvailable((Boolean)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 4: {
                ((DSIAdbEditListener)object).updateNewPublicProfileEntryAvailable((Boolean)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 5: {
                ((DSIAdbEditListener)object).updateNewTopDestinationEntryAvailable((Boolean)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 6: {
                ((DSIAdbEditListener)object).updateNewPublicProfileTopDestEntryAvailable((Boolean)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 7: {
                ((DSIAdbEditListener)object).insertEntryResult(((Number)objectArray[0]).intValue(), (AdbEntry)objectArray[1]);
                return null;
            }
            case 8: {
                ((DSIAdbEditListener)object).getEntriesResult(((Number)objectArray[0]).intValue(), (AdbEntry[])objectArray[1]);
                return null;
            }
            case 9: {
                ((DSIAdbEditListener)object).getEntryDataSetsResult(((Number)objectArray[0]).intValue(), (DataSet[])objectArray[1]);
                return null;
            }
            case 10: {
                ((DSIAdbEditListener)object).changeEntryResult(((Number)objectArray[0]).intValue(), (AdbEntry)objectArray[1]);
                return null;
            }
            case 11: {
                ((DSIAdbEditListener)object).copyEntryResult(((Number)objectArray[0]).intValue(), (AdbEntry)objectArray[1]);
                return null;
            }
            case 12: {
                ((DSIAdbEditListener)object).deleteEntriesResult(((Number)objectArray[0]).intValue());
                return null;
            }
            case 13: {
                ((DSIAdbEditListener)object).setSpeedDialResult(((Number)objectArray[0]).intValue());
                return null;
            }
            case 14: {
                ((DSIAdbEditListener)object).deleteSpeedDialResult(((Number)objectArray[0]).intValue());
                return null;
            }
            case 15: {
                ((DSIAdbEditListener)object).getEntryByReferenceIdResult(((Number)objectArray[0]).intValue(), (AdbEntry)objectArray[1]);
                return null;
            }
            case 16: {
                ((DSIAdbEditListener)object).updateNewOnlineDestinationEntryAvailable((Boolean)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 17: {
                ((DSIAdbEditListener)object).asyncException(((Number)objectArray[0]).intValue(), (String)objectArray[1], ((Number)objectArray[2]).intValue());
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

