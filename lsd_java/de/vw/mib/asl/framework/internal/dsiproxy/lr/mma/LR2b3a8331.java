/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.framework.internal.dsiproxy.lr.mma;

import de.vw.mib.reflection.MultipleMethodAccessibleObject;
import de.vw.mib.reflection.RuntimeUtil;
import java.lang.reflect.InvocationTargetException;
import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.ddp20.DSIDDP20;
import org.dsi.ifc.ddp20.DisplayRequest;
import org.dsi.ifc.ddp20.UpdateRequest;
import org.dsi.ifc.diagnose.DSIComponentProtection;

public final class LR2b3a8331
extends MultipleMethodAccessibleObject {
    private int a0(int n, boolean bl, int n2) {
        int n3 = -1;
        switch (n) {
            case -1162471198: {
                if (bl) {
                    if (n2 == -904616957) {
                        n3 = 1;
                        break;
                    }
                    if (n2 == 1805755651) {
                        n3 = 2;
                        break;
                    }
                    if (n2 != -864245041) break;
                    n3 = 3;
                    break;
                }
                n3 = 1;
                break;
            }
            case -948729267: {
                if (bl) {
                    if (n2 == -904616957) {
                        n3 = 4;
                        break;
                    }
                    if (n2 == 1805755651) {
                        n3 = 5;
                        break;
                    }
                    if (n2 != -864245041) break;
                    n3 = 6;
                    break;
                }
                n3 = 4;
                break;
            }
            case 1994739278: {
                if (bl) {
                    if (n2 != -1261696176) break;
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
            case -2020678466: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 10;
                    break;
                }
                n3 = 10;
                break;
            }
            case -1889813628: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 11;
                    break;
                }
                n3 = 11;
                break;
            }
            case -1358638022: {
                if (bl) {
                    if (n2 != 1043255048) break;
                    n3 = 12;
                    break;
                }
                n3 = 12;
                break;
            }
            case -1174125019: {
                if (bl) {
                    if (n2 != 1560747308) break;
                    n3 = 24;
                    break;
                }
                n3 = 24;
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
            case -823704631: {
                if (bl) {
                    if (n2 != -348311599) break;
                    n3 = 18;
                    break;
                }
                n3 = 18;
                break;
            }
            case -370816827: {
                if (bl) {
                    if (n2 != 1019311520) break;
                    n3 = 16;
                    break;
                }
                n3 = 16;
                break;
            }
            case 132279501: {
                if (bl) {
                    if (n2 != -2079747975) break;
                    n3 = 21;
                    break;
                }
                n3 = 21;
                break;
            }
            case 247065101: {
                if (bl) {
                    if (n2 != -1317504696) break;
                    n3 = 22;
                    break;
                }
                n3 = 22;
                break;
            }
            case 346441700: {
                if (bl) {
                    if (n2 != 1043255048) break;
                    n3 = 8;
                    break;
                }
                n3 = 8;
                break;
            }
            case 490754231: {
                if (bl) {
                    if (n2 != -1317504696) break;
                    n3 = 20;
                    break;
                }
                n3 = 20;
                break;
            }
            case 1121216275: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 25;
                    break;
                }
                n3 = 25;
                break;
            }
            case 1158329489: {
                if (bl) {
                    if (n2 != -348311599) break;
                    n3 = 17;
                    break;
                }
                n3 = 17;
                break;
            }
            case 1359302536: {
                if (bl) {
                    if (n2 != -2079747975) break;
                    n3 = 23;
                    break;
                }
                n3 = 23;
                break;
            }
            case 1367243283: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 9;
                    break;
                }
                n3 = 9;
                break;
            }
            case 1389556374: {
                if (bl) {
                    if (n2 != 558892593) break;
                    n3 = 7;
                    break;
                }
                n3 = 7;
                break;
            }
            case 1743101042: {
                if (bl) {
                    if (n2 != 1215091713) break;
                    n3 = 13;
                    break;
                }
                n3 = 13;
                break;
            }
            case 1796736329: {
                if (bl) {
                    if (n2 != -717954945) break;
                    n3 = 14;
                    break;
                }
                n3 = 14;
                break;
            }
            case 1984984868: {
                if (bl) {
                    if (n2 != -1210211269) break;
                    n3 = 19;
                    break;
                }
                n3 = 19;
                break;
            }
            case 2116714704: {
                if (bl) {
                    if (n2 != 1019311520) break;
                    n3 = 15;
                    break;
                }
                n3 = 15;
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
            case 1019091439: {
                n2 = this.a1(n4, bl, n);
                break;
            }
            case 1136707099: {
                n2 = this.a0(n4, bl, n);
                break;
            }
        }
        return n2;
    }

    private Object f0(int n, Object object, Object[] objectArray) {
        switch (n) {
            case 0: {
                ((DSIComponentProtection)object).authString((String)objectArray[0], ((Number)objectArray[1]).intValue(), ((Number)objectArray[2]).intValue());
                return null;
            }
            case 1: {
                ((DSIComponentProtection)object).setNotification((int[])objectArray[0], (DSIListener)objectArray[1]);
                return null;
            }
            case 2: {
                ((DSIComponentProtection)object).setNotification(((Number)objectArray[0]).intValue(), (DSIListener)objectArray[1]);
                return null;
            }
            case 3: {
                ((DSIComponentProtection)object).setNotification((DSIListener)objectArray[0]);
                return null;
            }
            case 4: {
                ((DSIComponentProtection)object).clearNotification((int[])objectArray[0], (DSIListener)objectArray[1]);
                return null;
            }
            case 5: {
                ((DSIComponentProtection)object).clearNotification(((Number)objectArray[0]).intValue(), (DSIListener)objectArray[1]);
                return null;
            }
            case 6: {
                ((DSIComponentProtection)object).clearNotification((DSIListener)objectArray[0]);
                return null;
            }
            case 7: {
                ((DSIDDP20)object).setColor(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue(), (int[])objectArray[2], (Boolean)objectArray[3]);
                return null;
            }
            case 8: {
                ((DSIDDP20)object).setHMIState(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue(), ((Number)objectArray[2]).intValue());
                return null;
            }
            case 9: {
                ((DSIDDP20)object).getDisplayStatus();
                return null;
            }
            case 10: {
                ((DSIDDP20)object).setNaviState(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 11: {
                ((DSIDDP20)object).setMediaState(((Number)objectArray[0]).intValue());
                return null;
            }
            case 12: {
                ((DSIDDP20)object).setPhoneState(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue(), ((Number)objectArray[2]).intValue());
                return null;
            }
            case 13: {
                ((DSIDDP20)object).setFrameStatus((DisplayRequest)objectArray[0]);
                return null;
            }
            case 14: {
                ((DSIDDP20)object).setFrameUpdate((UpdateRequest)objectArray[0]);
                return null;
            }
            case 15: {
                ((DSIDDP20)object).setManeuver(((Number)objectArray[0]).intValue(), (short[])objectArray[1], (Boolean)objectArray[2]);
                return null;
            }
            case 16: {
                ((DSIDDP20)object).setCompass(((Number)objectArray[0]).intValue(), (short[])objectArray[1], (Boolean)objectArray[2]);
                return null;
            }
            case 17: {
                ((DSIDDP20)object).setDistanceBar(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue(), (Boolean)objectArray[2], (Boolean)objectArray[3]);
                return null;
            }
            case 18: {
                ((DSIDDP20)object).setDeviationBar(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue(), (Boolean)objectArray[2], (Boolean)objectArray[3]);
                return null;
            }
            case 19: {
                ((DSIDDP20)object).setText(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue(), (String)objectArray[2], ((Number)objectArray[3]).intValue(), (Boolean)objectArray[4]);
                return null;
            }
            case 20: {
                ((DSIDDP20)object).setTextStyle(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue(), ((Number)objectArray[2]).intValue(), ((Number)objectArray[3]).intValue(), (Boolean)objectArray[4]);
                return null;
            }
            case 21: {
                ((DSIDDP20)object).setCursor(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue(), ((Number)objectArray[2]).intValue(), ((Number)objectArray[3]).intValue(), ((Number)objectArray[4]).intValue(), (Boolean)objectArray[5]);
                return null;
            }
            case 22: {
                ((DSIDDP20)object).setTrafficSign(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue(), ((Number)objectArray[2]).intValue(), ((Number)objectArray[3]).intValue(), (Boolean)objectArray[4]);
                return null;
            }
            case 23: {
                ((DSIDDP20)object).setLaneGuidanceHeader(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue(), ((Number)objectArray[2]).intValue(), ((Number)objectArray[3]).intValue(), ((Number)objectArray[4]).intValue(), (Boolean)objectArray[5]);
                return null;
            }
            case 24: {
                ((DSIDDP20)object).setLaneGuidanceData(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue(), ((Number)objectArray[2]).intValue(), ((Number)objectArray[3]).intValue(), (short[])objectArray[4], (Boolean)objectArray[5]);
                return null;
            }
            case 25: {
                ((DSIDDP20)object).setCodePage(((Number)objectArray[0]).intValue());
                return null;
            }
            case 26: {
                ((DSIDDP20)object).setNotification((int[])objectArray[0], (DSIListener)objectArray[1]);
                return null;
            }
            case 27: {
                ((DSIDDP20)object).setNotification(((Number)objectArray[0]).intValue(), (DSIListener)objectArray[1]);
                return null;
            }
            case 28: {
                ((DSIDDP20)object).setNotification((DSIListener)objectArray[0]);
                return null;
            }
            case 29: {
                ((DSIDDP20)object).clearNotification((int[])objectArray[0], (DSIListener)objectArray[1]);
                return null;
            }
            case 30: {
                ((DSIDDP20)object).clearNotification(((Number)objectArray[0]).intValue(), (DSIListener)objectArray[1]);
                return null;
            }
            case 31: {
                ((DSIDDP20)object).clearNotification((DSIListener)objectArray[0]);
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

