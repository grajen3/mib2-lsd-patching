/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.framework.internal.dsiproxy.lr.mma;

import de.vw.mib.reflection.MultipleMethodAccessibleObject;
import de.vw.mib.reflection.RuntimeUtil;
import java.lang.reflect.InvocationTargetException;
import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.global.ResourceLocator;
import org.dsi.ifc.kombipictureserver.DSIKombiPictureServer;
import org.dsi.ifc.kombisync.DSIKombiSync;
import org.dsi.ifc.kombisync.MMIDisplayRequest;
import org.dsi.ifc.kombisync.MMIDisplayStatus;
import org.dsi.ifc.kombisync.MMIPopupRequest;
import org.dsi.ifc.kombisync.MenuState;

public final class LR215cd67bf
extends MultipleMethodAccessibleObject {
    private int a0(int n, boolean bl, int n2) {
        int n3 = -1;
        switch (n) {
            case -2050285854: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 0;
                    break;
                }
                n3 = 0;
                break;
            }
            case -1796674356: {
                if (bl) {
                    if (n2 != 986525984) break;
                    n3 = 5;
                    break;
                }
                n3 = 5;
                break;
            }
            case -1684244978: {
                if (bl) {
                    if (n2 != 1916861332) break;
                    n3 = 3;
                    break;
                }
                n3 = 3;
                break;
            }
            case -1162471198: {
                if (bl) {
                    if (n2 == -904616957) {
                        n3 = 10;
                        break;
                    }
                    if (n2 == 1805755651) {
                        n3 = 11;
                        break;
                    }
                    if (n2 != -864245041) break;
                    n3 = 12;
                    break;
                }
                n3 = 10;
                break;
            }
            case -1085225533: {
                if (bl) {
                    if (n2 != 1776832904) break;
                    n3 = 4;
                    break;
                }
                n3 = 4;
                break;
            }
            case -948729267: {
                if (bl) {
                    if (n2 == -904616957) {
                        n3 = 13;
                        break;
                    }
                    if (n2 == 1805755651) {
                        n3 = 14;
                        break;
                    }
                    if (n2 != -864245041) break;
                    n3 = 15;
                    break;
                }
                n3 = 13;
                break;
            }
            case -758370810: {
                if (bl) {
                    if (n2 != -883163127) break;
                    n3 = 7;
                    break;
                }
                n3 = 7;
                break;
            }
            case -320452751: {
                if (bl) {
                    if (n2 != -166296696) break;
                    n3 = 6;
                    break;
                }
                n3 = 6;
                break;
            }
            case 189790845: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 8;
                    break;
                }
                n3 = 8;
                break;
            }
            case 267541029: {
                if (bl) {
                    if (n2 != -1453520460) break;
                    n3 = 2;
                    break;
                }
                n3 = 2;
                break;
            }
            case 832940290: {
                if (bl) {
                    if (n2 != -1453520460) break;
                    n3 = 1;
                    break;
                }
                n3 = 1;
                break;
            }
            case 836579794: {
                if (bl) {
                    if (n2 != -1245520798) break;
                    n3 = 9;
                    break;
                }
                n3 = 9;
                break;
            }
        }
        return n3;
    }

    private int a1(int n, boolean bl, int n2) {
        int n3 = -1;
        switch (n) {
            case -1981032958: {
                if (bl) {
                    if (n2 != 151219309) break;
                    n3 = 17;
                    break;
                }
                n3 = 17;
                break;
            }
            case -1162471198: {
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
            case -948729267: {
                if (bl) {
                    if (n2 == -904616957) {
                        n3 = 24;
                        break;
                    }
                    if (n2 == 1805755651) {
                        n3 = 25;
                        break;
                    }
                    if (n2 != -864245041) break;
                    n3 = 26;
                    break;
                }
                n3 = 24;
                break;
            }
            case 1537701: {
                if (bl) {
                    if (n2 != 2127803989) break;
                    n3 = 19;
                    break;
                }
                n3 = 19;
                break;
            }
            case 30916447: {
                if (bl) {
                    if (n2 != 2018880248) break;
                    n3 = 20;
                    break;
                }
                n3 = 20;
                break;
            }
            case 1710318793: {
                if (bl) {
                    if (n2 != -1562872078) break;
                    n3 = 18;
                    break;
                }
                n3 = 18;
                break;
            }
            case 1889356396: {
                if (bl) {
                    if (n2 != -1653679357) break;
                    n3 = 16;
                    break;
                }
                n3 = 16;
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
            case -484804759: {
                n2 = this.a0(n4, bl, n);
                break;
            }
            case 835550255: {
                n2 = this.a1(n4, bl, n);
                break;
            }
        }
        return n2;
    }

    private Object f0(int n, Object object, Object[] objectArray) {
        switch (n) {
            case 0: {
                ((DSIKombiPictureServer)object).setKombiHmiReady();
                return null;
            }
            case 1: {
                ((DSIKombiPictureServer)object).responseCoverArt(((Number)objectArray[0]).longValue(), ((Number)objectArray[1]).intValue(), ((Number)objectArray[2]).intValue(), ((Number)objectArray[3]).intValue(), (ResourceLocator)objectArray[4]);
                return null;
            }
            case 2: {
                ((DSIKombiPictureServer)object).responseStationArt(((Number)objectArray[0]).longValue(), ((Number)objectArray[1]).intValue(), ((Number)objectArray[2]).intValue(), ((Number)objectArray[3]).intValue(), (ResourceLocator)objectArray[4]);
                return null;
            }
            case 3: {
                ((DSIKombiPictureServer)object).responseActiveCallPicture(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue(), (ResourceLocator)objectArray[2]);
                return null;
            }
            case 4: {
                ((DSIKombiPictureServer)object).responseActiveCallPictureInstance(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue(), ((Number)objectArray[2]).intValue(), (ResourceLocator)objectArray[3]);
                return null;
            }
            case 5: {
                ((DSIKombiPictureServer)object).responseDynamicIcon(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue(), (Boolean)objectArray[2], (ResourceLocator)objectArray[3]);
                return null;
            }
            case 6: {
                ((DSIKombiPictureServer)object).responseAdbContactPicture(((Number)objectArray[0]).longValue(), ((Number)objectArray[1]).intValue(), ((Number)objectArray[2]).intValue(), (ResourceLocator)objectArray[3]);
                return null;
            }
            case 7: {
                ((DSIKombiPictureServer)object).responseInternalAddressID(((Number)objectArray[0]).longValue(), ((Number)objectArray[1]).intValue(), ((Number)objectArray[2]).intValue());
                return null;
            }
            case 8: {
                ((DSIKombiPictureServer)object).responsePictureServerAbilities(((Number)objectArray[0]).intValue());
                return null;
            }
            case 9: {
                ((DSIKombiPictureServer)object).responsePictureStream(((Number)objectArray[0]).intValue(), (short)((Number)objectArray[1]).intValue(), (short)((Number)objectArray[2]).intValue(), ((Number)objectArray[3]).intValue(), ((Number)objectArray[4]).intValue(), (byte[])objectArray[5]);
                return null;
            }
            case 10: {
                ((DSIKombiPictureServer)object).setNotification((int[])objectArray[0], (DSIListener)objectArray[1]);
                return null;
            }
            case 11: {
                ((DSIKombiPictureServer)object).setNotification(((Number)objectArray[0]).intValue(), (DSIListener)objectArray[1]);
                return null;
            }
            case 12: {
                ((DSIKombiPictureServer)object).setNotification((DSIListener)objectArray[0]);
                return null;
            }
            case 13: {
                ((DSIKombiPictureServer)object).clearNotification((int[])objectArray[0], (DSIListener)objectArray[1]);
                return null;
            }
            case 14: {
                ((DSIKombiPictureServer)object).clearNotification(((Number)objectArray[0]).intValue(), (DSIListener)objectArray[1]);
                return null;
            }
            case 15: {
                ((DSIKombiPictureServer)object).clearNotification((DSIListener)objectArray[0]);
                return null;
            }
            case 16: {
                ((DSIKombiSync)object).setHMIIsReady((Boolean)objectArray[0]);
                return null;
            }
            case 17: {
                ((DSIKombiSync)object).setMMIDisplayStatus((MMIDisplayStatus)objectArray[0]);
                return null;
            }
            case 18: {
                ((DSIKombiSync)object).setMMIDisplayRequest((MMIDisplayRequest)objectArray[0]);
                return null;
            }
            case 19: {
                ((DSIKombiSync)object).setMenuState((MenuState)objectArray[0]);
                return null;
            }
            case 20: {
                ((DSIKombiSync)object).setMMIPopupRequest((MMIPopupRequest)objectArray[0]);
                return null;
            }
            case 21: {
                ((DSIKombiSync)object).setNotification((int[])objectArray[0], (DSIListener)objectArray[1]);
                return null;
            }
            case 22: {
                ((DSIKombiSync)object).setNotification(((Number)objectArray[0]).intValue(), (DSIListener)objectArray[1]);
                return null;
            }
            case 23: {
                ((DSIKombiSync)object).setNotification((DSIListener)objectArray[0]);
                return null;
            }
            case 24: {
                ((DSIKombiSync)object).clearNotification((int[])objectArray[0], (DSIListener)objectArray[1]);
                return null;
            }
            case 25: {
                ((DSIKombiSync)object).clearNotification(((Number)objectArray[0]).intValue(), (DSIListener)objectArray[1]);
                return null;
            }
            case 26: {
                ((DSIKombiSync)object).clearNotification((DSIListener)objectArray[0]);
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

