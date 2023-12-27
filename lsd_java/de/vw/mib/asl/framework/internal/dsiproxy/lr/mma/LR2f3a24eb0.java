/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.framework.internal.dsiproxy.lr.mma;

import de.vw.mib.reflection.MultipleMethodAccessibleObject;
import de.vw.mib.reflection.RuntimeUtil;
import java.lang.reflect.InvocationTargetException;
import org.dsi.ifc.organizer.AdbEntry;
import org.dsi.ifc.organizer.DSIAdbUserProfileListener;
import org.dsi.ifc.organizer.DSIAdbVCardExchangeListener;
import org.dsi.ifc.organizer.DownloadInfo;
import org.dsi.ifc.organizer.EntryMeter;
import org.dsi.ifc.organizer.ProfileInfo;

public final class LR2f3a24eb0
extends MultipleMethodAccessibleObject {
    private int a0(int n, boolean bl, int n2) {
        int n3 = -1;
        switch (n) {
            case -2115808760: {
                if (bl) {
                    if (n2 != -633848249) break;
                    n3 = 6;
                    break;
                }
                n3 = 6;
                break;
            }
            case -1958301749: {
                if (bl) {
                    if (n2 != 1339506559) break;
                    n3 = 3;
                    break;
                }
                n3 = 3;
                break;
            }
            case -1905535577: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 11;
                    break;
                }
                n3 = 11;
                break;
            }
            case -1895711915: {
                if (bl) {
                    if (n2 != -1665395196) break;
                    n3 = 18;
                    break;
                }
                n3 = 18;
                break;
            }
            case -1622541400: {
                if (bl) {
                    if (n2 != 1276482132) break;
                    n3 = 19;
                    break;
                }
                n3 = 19;
                break;
            }
            case -1548952818: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 15;
                    break;
                }
                n3 = 15;
                break;
            }
            case -1466162299: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 14;
                    break;
                }
                n3 = 14;
                break;
            }
            case -1212797640: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 7;
                    break;
                }
                n3 = 7;
                break;
            }
            case -1064042791: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 17;
                    break;
                }
                n3 = 17;
                break;
            }
            case -962351133: {
                if (bl) {
                    if (n2 != 156256360) break;
                    n3 = 0;
                    break;
                }
                n3 = 0;
                break;
            }
            case -747541569: {
                if (bl) {
                    if (n2 != -1665395196) break;
                    n3 = 1;
                    break;
                }
                n3 = 1;
                break;
            }
            case -577828570: {
                if (bl) {
                    if (n2 != 1339506559) break;
                    n3 = 4;
                    break;
                }
                n3 = 4;
                break;
            }
            case -577824946: {
                if (bl) {
                    if (n2 != 1339506559) break;
                    n3 = 2;
                    break;
                }
                n3 = 2;
                break;
            }
            case -415306245: {
                if (bl) {
                    if (n2 != 1043255048) break;
                    n3 = 16;
                    break;
                }
                n3 = 16;
                break;
            }
            case -114124988: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 10;
                    break;
                }
                n3 = 10;
                break;
            }
            case -31823595: {
                if (bl) {
                    if (n2 != 1043255048) break;
                    n3 = 5;
                    break;
                }
                n3 = 5;
                break;
            }
            case -1819462: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 12;
                    break;
                }
                n3 = 12;
                break;
            }
            case 394730793: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 8;
                    break;
                }
                n3 = 8;
                break;
            }
            case 721338533: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 9;
                    break;
                }
                n3 = 9;
                break;
            }
            case 1098455977: {
                if (bl) {
                    if (n2 != 1589440996) break;
                    n3 = 13;
                    break;
                }
                n3 = 13;
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
                    n3 = 28;
                    break;
                }
                n3 = 28;
                break;
            }
            case -1297427981: {
                if (bl) {
                    if (n2 != -448335035) break;
                    n3 = 22;
                    break;
                }
                n3 = 22;
                break;
            }
            case 303281750: {
                if (bl) {
                    if (n2 != 1339506559) break;
                    n3 = 21;
                    break;
                }
                n3 = 21;
                break;
            }
            case 512546341: {
                if (bl) {
                    if (n2 != -1835876800) break;
                    n3 = 26;
                    break;
                }
                n3 = 26;
                break;
            }
            case 558359172: {
                if (bl) {
                    if (n2 != -448335035) break;
                    n3 = 23;
                    break;
                }
                n3 = 23;
                break;
            }
            case 955428503: {
                if (bl) {
                    if (n2 != 148318748) break;
                    n3 = 24;
                    break;
                }
                n3 = 24;
                break;
            }
            case 1034471335: {
                if (bl) {
                    if (n2 != 1339506559) break;
                    n3 = 20;
                    break;
                }
                n3 = 20;
                break;
            }
            case 1648533988: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 27;
                    break;
                }
                n3 = 27;
                break;
            }
            case 1771550780: {
                if (bl) {
                    if (n2 != -1550975126) break;
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
            case -1309149304: {
                n2 = this.a1(n4, bl, n);
                break;
            }
            case 986417789: {
                n2 = this.a0(n4, bl, n);
                break;
            }
        }
        return n2;
    }

    private Object f0(int n, Object object, Object[] objectArray) {
        switch (n) {
            case 0: {
                ((DSIAdbUserProfileListener)object).updateProfileInfo((ProfileInfo[])objectArray[0], ((Number)objectArray[1]).intValue(), ((Number)objectArray[2]).intValue());
                return null;
            }
            case 1: {
                ((DSIAdbUserProfileListener)object).updateDeviceConnected((Boolean)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 2: {
                ((DSIAdbUserProfileListener)object).updateDownloadCountSim((DownloadInfo)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 3: {
                ((DSIAdbUserProfileListener)object).updateDownloadCountMe((DownloadInfo)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 4: {
                ((DSIAdbUserProfileListener)object).updateDownloadCountOpp((DownloadInfo)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 5: {
                ((DSIAdbUserProfileListener)object).updateDownloadState(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue(), ((Number)objectArray[2]).intValue());
                return null;
            }
            case 6: {
                ((DSIAdbUserProfileListener)object).newDeviceConnected((String)objectArray[0]);
                return null;
            }
            case 7: {
                ((DSIAdbUserProfileListener)object).downloadToProfileResult(((Number)objectArray[0]).intValue());
                return null;
            }
            case 8: {
                ((DSIAdbUserProfileListener)object).restartDownloadResult(((Number)objectArray[0]).intValue());
                return null;
            }
            case 9: {
                ((DSIAdbUserProfileListener)object).profileDeleted(((Number)objectArray[0]).intValue());
                return null;
            }
            case 10: {
                ((DSIAdbUserProfileListener)object).setProfileNameResult(((Number)objectArray[0]).intValue());
                return null;
            }
            case 11: {
                ((DSIAdbUserProfileListener)object).deleteProfilesResult(((Number)objectArray[0]).intValue());
                return null;
            }
            case 12: {
                ((DSIAdbUserProfileListener)object).commonEntryCountResult(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 13: {
                ((DSIAdbUserProfileListener)object).entryMeterResult(((Number)objectArray[0]).intValue(), (EntryMeter[])objectArray[1]);
                return null;
            }
            case 14: {
                ((DSIAdbUserProfileListener)object).setPairingCodeResult(((Number)objectArray[0]).intValue());
                return null;
            }
            case 15: {
                ((DSIAdbUserProfileListener)object).setHomeIdResult(((Number)objectArray[0]).intValue());
                return null;
            }
            case 16: {
                ((DSIAdbUserProfileListener)object).updateDownloadState2ndPhone(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue(), ((Number)objectArray[2]).intValue());
                return null;
            }
            case 17: {
                ((DSIAdbUserProfileListener)object).setSOSButtonResult(((Number)objectArray[0]).intValue());
                return null;
            }
            case 18: {
                ((DSIAdbUserProfileListener)object).updateSOSButton((Boolean)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 19: {
                ((DSIAdbUserProfileListener)object).asyncException(((Number)objectArray[0]).intValue(), (String)objectArray[1], ((Number)objectArray[2]).intValue());
                return null;
            }
            case 20: {
                ((DSIAdbVCardExchangeListener)object).updateExportCount((DownloadInfo)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 21: {
                ((DSIAdbVCardExchangeListener)object).updateImportCount((DownloadInfo)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 22: {
                ((DSIAdbVCardExchangeListener)object).importVCardResult(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue(), ((Number)objectArray[2]).intValue(), ((Number)objectArray[3]).intValue());
                return null;
            }
            case 23: {
                ((DSIAdbVCardExchangeListener)object).exportVCardResult(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue(), ((Number)objectArray[2]).intValue(), ((Number)objectArray[3]).intValue());
                return null;
            }
            case 24: {
                ((DSIAdbVCardExchangeListener)object).exportSpellerVCardResult(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue(), ((Number)objectArray[2]).intValue(), ((Number)objectArray[3]).intValue(), ((Number)objectArray[4]).intValue());
                return null;
            }
            case 25: {
                ((DSIAdbVCardExchangeListener)object).createVCardResult(((Number)objectArray[0]).intValue(), (long[])objectArray[1], ((Number)objectArray[2]).intValue(), (String)objectArray[3]);
                return null;
            }
            case 26: {
                ((DSIAdbVCardExchangeListener)object).parseVCardResult(((Number)objectArray[0]).intValue(), (AdbEntry[])objectArray[1]);
                return null;
            }
            case 27: {
                ((DSIAdbVCardExchangeListener)object).responseAbort(((Number)objectArray[0]).intValue());
                return null;
            }
            case 28: {
                ((DSIAdbVCardExchangeListener)object).asyncException(((Number)objectArray[0]).intValue(), (String)objectArray[1], ((Number)objectArray[2]).intValue());
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

