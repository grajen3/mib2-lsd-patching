/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.framework.internal.dsiproxy.lr.mma;

import de.vw.mib.reflection.MultipleMethodAccessibleObject;
import de.vw.mib.reflection.RuntimeUtil;
import java.lang.reflect.InvocationTargetException;
import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.search.CarFunction;
import org.dsi.ifc.search.DSISearch;
import org.dsi.ifc.search.DSISearchDataProvider;
import org.dsi.ifc.search.DataSet;
import org.dsi.ifc.search.Environment;
import org.dsi.ifc.search.NavPosition;
import org.dsi.ifc.search.RadioStation;
import org.dsi.ifc.search.RawDataSet;
import org.dsi.ifc.search.SearchFilter;
import org.dsi.ifc.search.SearchQuery;
import org.dsi.ifc.search.SearchResult;

public final class LR2c9247a9c
extends MultipleMethodAccessibleObject {
    private int a0(int n, boolean bl, int n2) {
        int n3 = -1;
        switch (n) {
            case -2019897545: {
                if (bl) {
                    if (n2 != -127966309) break;
                    n3 = 19;
                    break;
                }
                n3 = 19;
                break;
            }
            case -1833044888: {
                if (bl) {
                    if (n2 != 365114342) break;
                    n3 = 13;
                    break;
                }
                n3 = 13;
                break;
            }
            case -1584531229: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 14;
                    break;
                }
                n3 = 14;
                break;
            }
            case -1526929106: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 3;
                    break;
                }
                n3 = 3;
                break;
            }
            case -1319189722: {
                if (bl) {
                    if (n2 != 3523) break;
                    n3 = 20;
                    break;
                }
                n3 = 20;
                break;
            }
            case -1309000780: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 23;
                    break;
                }
                n3 = 23;
                break;
            }
            case -1283110693: {
                if (bl) {
                    if (n2 != -238538240) break;
                    n3 = 21;
                    break;
                }
                n3 = 21;
                break;
            }
            case -1162471198: {
                if (bl) {
                    if (n2 == -904616957) {
                        n3 = 26;
                        break;
                    }
                    if (n2 == 1805755651) {
                        n3 = 27;
                        break;
                    }
                    if (n2 != -864245041) break;
                    n3 = 28;
                    break;
                }
                n3 = 26;
                break;
            }
            case -948729267: {
                if (bl) {
                    if (n2 == -904616957) {
                        n3 = 29;
                        break;
                    }
                    if (n2 == 1805755651) {
                        n3 = 30;
                        break;
                    }
                    if (n2 != -864245041) break;
                    n3 = 31;
                    break;
                }
                n3 = 29;
                break;
            }
            case -906336227: {
                if (bl) {
                    if (n2 != 365114342) break;
                    n3 = 0;
                    break;
                }
                n3 = 0;
                break;
            }
            case -874181523: {
                if (bl) {
                    if (n2 != -1172496671) break;
                    n3 = 12;
                    break;
                }
                n3 = 12;
                break;
            }
            case -836984971: {
                if (bl) {
                    if (n2 != -2121650919) break;
                    n3 = 15;
                    break;
                }
                n3 = 15;
                break;
            }
            case -655735495: {
                if (bl) {
                    if (n2 != -1166448617) break;
                    n3 = 11;
                    break;
                }
                n3 = 11;
                break;
            }
            case -366996214: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 10;
                    break;
                }
                n3 = 10;
                break;
            }
            case -320791233: {
                if (bl) {
                    if (n2 != -1287223754) break;
                    n3 = 16;
                    break;
                }
                n3 = 16;
                break;
            }
            case -283450096: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 6;
                    break;
                }
                n3 = 6;
                break;
            }
            case -143133450: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 7;
                    break;
                }
                n3 = 7;
                break;
            }
            case 177189683: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 4;
                    break;
                }
                n3 = 4;
                break;
            }
            case 263108664: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 2;
                    break;
                }
                n3 = 2;
                break;
            }
            case 375731279: {
                if (bl) {
                    if (n2 != -633848249) break;
                    n3 = 1;
                    break;
                }
                n3 = 1;
                break;
            }
            case 653522520: {
                if (bl) {
                    if (n2 != -633848249) break;
                    n3 = 9;
                    break;
                }
                n3 = 9;
                break;
            }
            case 891069167: {
                if (bl) {
                    if (n2 != -633848249) break;
                    n3 = 8;
                    break;
                }
                n3 = 8;
                break;
            }
            case 950432066: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 22;
                    break;
                }
                n3 = 22;
                break;
            }
            case 1211451291: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 5;
                    break;
                }
                n3 = 5;
                break;
            }
            case 1548593263: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 24;
                    break;
                }
                n3 = 24;
                break;
            }
            case 1591642913: {
                if (bl) {
                    if (n2 != 1407360162) break;
                    n3 = 17;
                    break;
                }
                n3 = 17;
                break;
            }
            case 1752078349: {
                if (bl) {
                    if (n2 != 400996240) break;
                    n3 = 18;
                    break;
                }
                n3 = 18;
                break;
            }
            case 1797058246: {
                if (bl) {
                    if (n2 != 686423297) break;
                    n3 = 25;
                    break;
                }
                n3 = 25;
                break;
            }
        }
        return n3;
    }

    private int a1(int n, boolean bl, int n2) {
        int n3 = -1;
        switch (n) {
            case -1162471198: {
                if (bl) {
                    if (n2 == -904616957) {
                        n3 = 38;
                        break;
                    }
                    if (n2 == 1805755651) {
                        n3 = 39;
                        break;
                    }
                    if (n2 != -864245041) break;
                    n3 = 40;
                    break;
                }
                n3 = 38;
                break;
            }
            case -948729267: {
                if (bl) {
                    if (n2 == -904616957) {
                        n3 = 41;
                        break;
                    }
                    if (n2 == 1805755651) {
                        n3 = 42;
                        break;
                    }
                    if (n2 != -864245041) break;
                    n3 = 43;
                    break;
                }
                n3 = 41;
                break;
            }
            case -705835465: {
                if (bl) {
                    if (n2 != -12576506) break;
                    n3 = 36;
                    break;
                }
                n3 = 36;
                break;
            }
            case -629226075: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 34;
                    break;
                }
                n3 = 34;
                break;
            }
            case -424329839: {
                if (bl) {
                    if (n2 != -1918090874) break;
                    n3 = 35;
                    break;
                }
                n3 = 35;
                break;
            }
            case 1206814052: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 32;
                    break;
                }
                n3 = 32;
                break;
            }
            case 1238411938: {
                if (bl) {
                    if (n2 != -995993593) break;
                    n3 = 37;
                    break;
                }
                n3 = 37;
                break;
            }
            case 1740607657: {
                if (bl) {
                    if (n2 != -1600866162) break;
                    n3 = 33;
                    break;
                }
                n3 = 33;
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
            case -1042284558: {
                n2 = this.a1(n4, bl, n);
                break;
            }
            case -1010532585: {
                n2 = this.a0(n4, bl, n);
                break;
            }
        }
        return n2;
    }

    private Object f0(int n, Object object, Object[] objectArray) {
        switch (n) {
            case 0: {
                ((DSISearch)object).search((SearchQuery)objectArray[0]);
                return null;
            }
            case 1: {
                ((DSISearch)object).setLanguage((String)objectArray[0]);
                return null;
            }
            case 2: {
                ((DSISearch)object).resetToFactorySettings();
                return null;
            }
            case 3: {
                ((DSISearch)object).profileChange(((Number)objectArray[0]).intValue());
                return null;
            }
            case 4: {
                ((DSISearch)object).profileCopy(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 5: {
                ((DSISearch)object).profileReset(((Number)objectArray[0]).intValue());
                return null;
            }
            case 6: {
                ((DSISearch)object).profileResetAll();
                return null;
            }
            case 7: {
                ((DSISearch)object).setActiveProfile(((Number)objectArray[0]).intValue());
                return null;
            }
            case 8: {
                ((DSISearch)object).createBackupFile((String)objectArray[0]);
                return null;
            }
            case 9: {
                ((DSISearch)object).importBackupFile((String)objectArray[0]);
                return null;
            }
            case 10: {
                ((DSISearch)object).requestSupportedCountries();
                return null;
            }
            case 11: {
                ((DSISearch)object).setActiveSearchCountries((String[])objectArray[0]);
                return null;
            }
            case 12: {
                ((DSISearch)object).addToHistory((SearchResult)objectArray[0]);
                return null;
            }
            case 13: {
                ((DSISearch)object).requestSuggestion((SearchQuery)objectArray[0]);
                return null;
            }
            case 14: {
                ((DSISearch)object).cancelQuery(((Number)objectArray[0]).intValue());
                return null;
            }
            case 15: {
                ((DSISearch)object).setCurrentPosition((NavPosition)objectArray[0]);
                return null;
            }
            case 16: {
                ((DSISearch)object).setRoutePoints((NavPosition[])objectArray[0]);
                return null;
            }
            case 17: {
                ((DSISearch)object).setCarFunctionStates((CarFunction[])objectArray[0]);
                return null;
            }
            case 18: {
                ((DSISearch)object).setRadioStations(((Number)objectArray[0]).intValue(), (RadioStation[])objectArray[1]);
                return null;
            }
            case 19: {
                ((DSISearch)object).setSearchFilter(((Number)objectArray[0]).intValue(), (SearchFilter)objectArray[1]);
                return null;
            }
            case 20: {
                ((DSISearch)object).prepareSources((int[])objectArray[0]);
                return null;
            }
            case 21: {
                ((DSISearch)object).removeFromHistory(((Number)objectArray[0]).longValue());
                return null;
            }
            case 22: {
                ((DSISearch)object).removeAllFromHistory();
                return null;
            }
            case 23: {
                ((DSISearch)object).removeAllFromHistoryBySource(((Number)objectArray[0]).intValue());
                return null;
            }
            case 24: {
                ((DSISearch)object).resetAutocompletion(((Number)objectArray[0]).intValue());
                return null;
            }
            case 25: {
                ((DSISearch)object).setEnvironment((Environment)objectArray[0]);
                return null;
            }
            case 26: {
                ((DSISearch)object).setNotification((int[])objectArray[0], (DSIListener)objectArray[1]);
                return null;
            }
            case 27: {
                ((DSISearch)object).setNotification(((Number)objectArray[0]).intValue(), (DSIListener)objectArray[1]);
                return null;
            }
            case 28: {
                ((DSISearch)object).setNotification((DSIListener)objectArray[0]);
                return null;
            }
            case 29: {
                ((DSISearch)object).clearNotification((int[])objectArray[0], (DSIListener)objectArray[1]);
                return null;
            }
            case 30: {
                ((DSISearch)object).clearNotification(((Number)objectArray[0]).intValue(), (DSIListener)objectArray[1]);
                return null;
            }
            case 31: {
                ((DSISearch)object).clearNotification((DSIListener)objectArray[0]);
                return null;
            }
        }
        return null;
    }

    private Object f1(int n, Object object, Object[] objectArray) {
        switch (n) {
            case 32: {
                ((DSISearchDataProvider)object).registerProviderSource(((Number)objectArray[0]).intValue());
                return null;
            }
            case 33: {
                ((DSISearchDataProvider)object).sourceDataAvailabilityChanged(((Number)objectArray[0]).intValue(), (Boolean)objectArray[1]);
                return null;
            }
            case 34: {
                ((DSISearchDataProvider)object).invalidateAllData(((Number)objectArray[0]).intValue());
                return null;
            }
            case 35: {
                ((DSISearchDataProvider)object).storeDataSets(((Number)objectArray[0]).intValue(), (DataSet[])objectArray[1], ((Number)objectArray[2]).intValue());
                return null;
            }
            case 36: {
                ((DSISearchDataProvider)object).storeRawDataSets(((Number)objectArray[0]).intValue(), (RawDataSet[])objectArray[1], ((Number)objectArray[2]).intValue());
                return null;
            }
            case 37: {
                ((DSISearchDataProvider)object).deleteDataSet(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).longValue());
                return null;
            }
            case 38: {
                ((DSISearchDataProvider)object).setNotification((int[])objectArray[0], (DSIListener)objectArray[1]);
                return null;
            }
            case 39: {
                ((DSISearchDataProvider)object).setNotification(((Number)objectArray[0]).intValue(), (DSIListener)objectArray[1]);
                return null;
            }
            case 40: {
                ((DSISearchDataProvider)object).setNotification((DSIListener)objectArray[0]);
                return null;
            }
            case 41: {
                ((DSISearchDataProvider)object).clearNotification((int[])objectArray[0], (DSIListener)objectArray[1]);
                return null;
            }
            case 42: {
                ((DSISearchDataProvider)object).clearNotification(((Number)objectArray[0]).intValue(), (DSIListener)objectArray[1]);
                return null;
            }
            case 43: {
                ((DSISearchDataProvider)object).clearNotification((DSIListener)objectArray[0]);
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

