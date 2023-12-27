/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.framework.internal.dsiproxy.lr.mma;

import de.vw.mib.reflection.MultipleMethodAccessibleObject;
import de.vw.mib.reflection.RuntimeUtil;
import java.lang.reflect.InvocationTargetException;
import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.media.AudioRoute;
import org.dsi.ifc.media.CoverartInfo;
import org.dsi.ifc.media.DSIMediaRouter;
import org.dsi.ifc.media.DSIMetadataService;

public final class LR25726b958
extends MultipleMethodAccessibleObject {
    private int a0(int n, boolean bl, int n2) {
        int n3 = -1;
        switch (n) {
            case -2002836621: {
                if (bl) {
                    if (n2 != 1558156353) break;
                    n3 = 5;
                    break;
                }
                n3 = 5;
                break;
            }
            case -1162471198: {
                if (bl) {
                    if (n2 == -904616957) {
                        n3 = 6;
                        break;
                    }
                    if (n2 == 1805755651) {
                        n3 = 7;
                        break;
                    }
                    if (n2 != -864245041) break;
                    n3 = 8;
                    break;
                }
                n3 = 6;
                break;
            }
            case -948729267: {
                if (bl) {
                    if (n2 == -904616957) {
                        n3 = 9;
                        break;
                    }
                    if (n2 == 1805755651) {
                        n3 = 10;
                        break;
                    }
                    if (n2 != -864245041) break;
                    n3 = 11;
                    break;
                }
                n3 = 9;
                break;
            }
            case -946779453: {
                if (bl) {
                    if (n2 != 1383775559) break;
                    n3 = 0;
                    break;
                }
                n3 = 0;
                break;
            }
            case -669956971: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 2;
                    break;
                }
                n3 = 2;
                break;
            }
            case 1136694556: {
                if (bl) {
                    if (n2 != -448335035) break;
                    n3 = 4;
                    break;
                }
                n3 = 4;
                break;
            }
            case 1967658229: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 3;
                    break;
                }
                n3 = 3;
                break;
            }
            case 2072205724: {
                if (bl) {
                    if (n2 != 1687814400) break;
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
            case -2057742000: {
                if (bl) {
                    if (n2 != 1254902355) break;
                    n3 = 12;
                    break;
                }
                n3 = 12;
                break;
            }
            case -1225498838: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 13;
                    break;
                }
                n3 = 13;
                break;
            }
            case -1162471198: {
                if (bl) {
                    if (n2 == -904616957) {
                        n3 = 15;
                        break;
                    }
                    if (n2 == 1805755651) {
                        n3 = 16;
                        break;
                    }
                    if (n2 != -864245041) break;
                    n3 = 17;
                    break;
                }
                n3 = 15;
                break;
            }
            case -1160949435: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 14;
                    break;
                }
                n3 = 14;
                break;
            }
            case -948729267: {
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
            case -1429955944: {
                n2 = this.a0(n4, bl, n);
                break;
            }
            case -1198716975: {
                n2 = this.a1(n4, bl, n);
                break;
            }
        }
        return n2;
    }

    private Object f0(int n, Object object, Object[] objectArray) {
        switch (n) {
            case 0: {
                ((DSIMediaRouter)object).registerClient(((Number)objectArray[0]).intValue(), (String)objectArray[1], (String)objectArray[2]);
                return null;
            }
            case 1: {
                ((DSIMediaRouter)object).unregisterClient(((Number)objectArray[0]).intValue());
                return null;
            }
            case 2: {
                ((DSIMediaRouter)object).startStreaming(((Number)objectArray[0]).intValue());
                return null;
            }
            case 3: {
                ((DSIMediaRouter)object).stopStreaming(((Number)objectArray[0]).intValue());
                return null;
            }
            case 4: {
                ((DSIMediaRouter)object).requestConfiguration(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue(), ((Number)objectArray[2]).intValue(), ((Number)objectArray[3]).intValue());
                return null;
            }
            case 5: {
                ((DSIMediaRouter)object).setAudioRoutes((AudioRoute[])objectArray[0]);
                return null;
            }
            case 6: {
                ((DSIMediaRouter)object).setNotification((int[])objectArray[0], (DSIListener)objectArray[1]);
                return null;
            }
            case 7: {
                ((DSIMediaRouter)object).setNotification(((Number)objectArray[0]).intValue(), (DSIListener)objectArray[1]);
                return null;
            }
            case 8: {
                ((DSIMediaRouter)object).setNotification((DSIListener)objectArray[0]);
                return null;
            }
            case 9: {
                ((DSIMediaRouter)object).clearNotification((int[])objectArray[0], (DSIListener)objectArray[1]);
                return null;
            }
            case 10: {
                ((DSIMediaRouter)object).clearNotification(((Number)objectArray[0]).intValue(), (DSIListener)objectArray[1]);
                return null;
            }
            case 11: {
                ((DSIMediaRouter)object).clearNotification((DSIListener)objectArray[0]);
                return null;
            }
            case 12: {
                ((DSIMetadataService)object).requestCoverArt(((Number)objectArray[0]).intValue(), (CoverartInfo)objectArray[1]);
                return null;
            }
            case 13: {
                ((DSIMetadataService)object).disableOnlineLookup();
                return null;
            }
            case 14: {
                ((DSIMetadataService)object).enableOnlineLookup();
                return null;
            }
            case 15: {
                ((DSIMetadataService)object).setNotification((int[])objectArray[0], (DSIListener)objectArray[1]);
                return null;
            }
            case 16: {
                ((DSIMetadataService)object).setNotification(((Number)objectArray[0]).intValue(), (DSIListener)objectArray[1]);
                return null;
            }
            case 17: {
                ((DSIMetadataService)object).setNotification((DSIListener)objectArray[0]);
                return null;
            }
            case 18: {
                ((DSIMetadataService)object).clearNotification((int[])objectArray[0], (DSIListener)objectArray[1]);
                return null;
            }
            case 19: {
                ((DSIMetadataService)object).clearNotification(((Number)objectArray[0]).intValue(), (DSIListener)objectArray[1]);
                return null;
            }
            case 20: {
                ((DSIMetadataService)object).clearNotification((DSIListener)objectArray[0]);
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

