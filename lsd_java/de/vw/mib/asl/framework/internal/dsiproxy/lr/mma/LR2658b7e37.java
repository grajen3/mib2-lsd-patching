/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.framework.internal.dsiproxy.lr.mma;

import de.vw.mib.reflection.MultipleMethodAccessibleObject;
import de.vw.mib.reflection.RuntimeUtil;
import java.lang.reflect.InvocationTargetException;
import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.networking.DSIDataConnection;
import org.dsi.ifc.networking.DSIWLAN;
import org.dsi.ifc.networking.Profile;

public final class LR2658b7e37
extends MultipleMethodAccessibleObject {
    private int a0(int n, boolean bl, int n2) {
        int n3 = -1;
        switch (n) {
            case -1892739878: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 1;
                    break;
                }
                n3 = 1;
                break;
            }
            case -1801158810: {
                if (bl) {
                    if (n2 != -412271469) break;
                    n3 = 8;
                    break;
                }
                n3 = 8;
                break;
            }
            case -1757351524: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 4;
                    break;
                }
                n3 = 4;
                break;
            }
            case -1630726820: {
                if (bl) {
                    if (n2 != 169078964) break;
                    n3 = 3;
                    break;
                }
                n3 = 3;
                break;
            }
            case -1537131727: {
                if (bl) {
                    if (n2 != -1653679357) break;
                    n3 = 2;
                    break;
                }
                n3 = 2;
                break;
            }
            case -1162471198: {
                if (bl) {
                    if (n2 == -904616957) {
                        n3 = 11;
                        break;
                    }
                    if (n2 == 1805755651) {
                        n3 = 12;
                        break;
                    }
                    if (n2 != -864245041) break;
                    n3 = 13;
                    break;
                }
                n3 = 11;
                break;
            }
            case -948729267: {
                if (bl) {
                    if (n2 == -904616957) {
                        n3 = 14;
                        break;
                    }
                    if (n2 == 1805755651) {
                        n3 = 15;
                        break;
                    }
                    if (n2 != -864245041) break;
                    n3 = 16;
                    break;
                }
                n3 = 14;
                break;
            }
            case -868124538: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 10;
                    break;
                }
                n3 = 10;
                break;
            }
            case -611430611: {
                if (bl) {
                    if (n2 != 1043255048) break;
                    n3 = 9;
                    break;
                }
                n3 = 9;
                break;
            }
            case -405268280: {
                if (bl) {
                    if (n2 != 1865490124) break;
                    n3 = 6;
                    break;
                }
                n3 = 6;
                break;
            }
            case 643049822: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 5;
                    break;
                }
                n3 = 5;
                break;
            }
            case 1878380952: {
                if (bl) {
                    if (n2 != -412271469) break;
                    n3 = 7;
                    break;
                }
                n3 = 7;
                break;
            }
            case 1984934509: {
                if (bl) {
                    if (n2 != 1687814400) break;
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
            case -1162471198: {
                if (bl) {
                    if (n2 == -904616957) {
                        n3 = 18;
                        break;
                    }
                    if (n2 == 1805755651) {
                        n3 = 19;
                        break;
                    }
                    if (n2 != -864245041) break;
                    n3 = 20;
                    break;
                }
                n3 = 18;
                break;
            }
            case -948729267: {
                if (bl) {
                    if (n2 == -904616957) {
                        n3 = 21;
                        break;
                    }
                    if (n2 == 1805755651) {
                        n3 = 22;
                        break;
                    }
                    if (n2 != -864245041) break;
                    n3 = 23;
                    break;
                }
                n3 = 21;
                break;
            }
            case 0x15D1151D: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 17;
                    break;
                }
                n3 = 17;
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
            case -1928736541: {
                n2 = this.a1(n4, bl, n);
                break;
            }
            case 52449245: {
                n2 = this.a0(n4, bl, n);
                break;
            }
        }
        return n2;
    }

    private Object f0(int n, Object object, Object[] objectArray) {
        switch (n) {
            case 0: {
                ((DSIWLAN)object).setRole(((Number)objectArray[0]).intValue());
                return null;
            }
            case 1: {
                ((DSIWLAN)object).factoryReset();
                return null;
            }
            case 2: {
                ((DSIWLAN)object).setRFActive((Boolean)objectArray[0]);
                return null;
            }
            case 3: {
                ((DSIWLAN)object).setProfile((Profile)objectArray[0]);
                return null;
            }
            case 4: {
                ((DSIWLAN)object).requestNetworkSearch(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 5: {
                ((DSIWLAN)object).requestAbortSearch();
                return null;
            }
            case 6: {
                ((DSIWLAN)object).requestConnectNetwork((String)objectArray[0], (String)objectArray[1], (String)objectArray[2], ((Number)objectArray[3]).intValue());
                return null;
            }
            case 7: {
                ((DSIWLAN)object).requestDisconnectNetwork((String)objectArray[0], (String)objectArray[1]);
                return null;
            }
            case 8: {
                ((DSIWLAN)object).requestDeleteTrustedNetwork((String)objectArray[0], (String)objectArray[1]);
                return null;
            }
            case 9: {
                ((DSIWLAN)object).requestActivateWps(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue(), ((Number)objectArray[2]).intValue());
                return null;
            }
            case 10: {
                ((DSIWLAN)object).requestCancelWPS();
                return null;
            }
            case 11: {
                ((DSIWLAN)object).setNotification((int[])objectArray[0], (DSIListener)objectArray[1]);
                return null;
            }
            case 12: {
                ((DSIWLAN)object).setNotification(((Number)objectArray[0]).intValue(), (DSIListener)objectArray[1]);
                return null;
            }
            case 13: {
                ((DSIWLAN)object).setNotification((DSIListener)objectArray[0]);
                return null;
            }
            case 14: {
                ((DSIWLAN)object).clearNotification((int[])objectArray[0], (DSIListener)objectArray[1]);
                return null;
            }
            case 15: {
                ((DSIWLAN)object).clearNotification(((Number)objectArray[0]).intValue(), (DSIListener)objectArray[1]);
                return null;
            }
            case 16: {
                ((DSIWLAN)object).clearNotification((DSIListener)objectArray[0]);
                return null;
            }
            case 17: {
                ((DSIDataConnection)object).forceDisconnectRequest();
                return null;
            }
            case 18: {
                ((DSIDataConnection)object).setNotification((int[])objectArray[0], (DSIListener)objectArray[1]);
                return null;
            }
            case 19: {
                ((DSIDataConnection)object).setNotification(((Number)objectArray[0]).intValue(), (DSIListener)objectArray[1]);
                return null;
            }
            case 20: {
                ((DSIDataConnection)object).setNotification((DSIListener)objectArray[0]);
                return null;
            }
            case 21: {
                ((DSIDataConnection)object).clearNotification((int[])objectArray[0], (DSIListener)objectArray[1]);
                return null;
            }
            case 22: {
                ((DSIDataConnection)object).clearNotification(((Number)objectArray[0]).intValue(), (DSIListener)objectArray[1]);
                return null;
            }
            case 23: {
                ((DSIDataConnection)object).clearNotification((DSIListener)objectArray[0]);
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

