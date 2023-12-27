/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.framework.internal.dsiproxy.lr.mma;

import de.vw.mib.reflection.MultipleMethodAccessibleObject;
import de.vw.mib.reflection.RuntimeUtil;
import java.lang.reflect.InvocationTargetException;
import org.dsi.ifc.kombisync2.DSIKombiSyncListener;
import org.dsi.ifc.kombisync2.DisplayIdentification;
import org.dsi.ifc.kombisync2.DisplayRequestResponse;
import org.dsi.ifc.kombisync2.DisplayStatus;
import org.dsi.ifc.kombisync2.PopupActionRequestResponse;
import org.dsi.ifc.kombisync2.PopupRegisterRequestResponse;
import org.dsi.ifc.kombisync2.PopupStatus;
import org.dsi.ifc.komogfxstreamsink.DSIKOMOGfxStreamSinkListener;

public final class LR2f29620f5
extends MultipleMethodAccessibleObject {
    private int a0(int n, boolean bl, int n2) {
        int n3 = -1;
        switch (n) {
            case -1885711132: {
                if (bl) {
                    if (n2 != 309965865) break;
                    n3 = 4;
                    break;
                }
                n3 = 4;
                break;
            }
            case -1853141228: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 8;
                    break;
                }
                n3 = 8;
                break;
            }
            case -1622541400: {
                if (bl) {
                    if (n2 != 1276482132) break;
                    n3 = 13;
                    break;
                }
                n3 = 13;
                break;
            }
            case -713946317: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 7;
                    break;
                }
                n3 = 7;
                break;
            }
            case -529743678: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 2;
                    break;
                }
                n3 = 2;
                break;
            }
            case -365977418: {
                if (bl) {
                    if (n2 != -140383835) break;
                    n3 = 11;
                    break;
                }
                n3 = 11;
                break;
            }
            case -49206214: {
                if (bl) {
                    if (n2 != -386125191) break;
                    n3 = 3;
                    break;
                }
                n3 = 3;
                break;
            }
            case -31798764: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 5;
                    break;
                }
                n3 = 5;
                break;
            }
            case 268530162: {
                if (bl) {
                    if (n2 != 75879518) break;
                    n3 = 9;
                    break;
                }
                n3 = 9;
                break;
            }
            case 595455185: {
                if (bl) {
                    if (n2 != 1149447382) break;
                    n3 = 12;
                    break;
                }
                n3 = 12;
                break;
            }
            case 1372303223: {
                if (bl) {
                    if (n2 != -1665395196) break;
                    n3 = 0;
                    break;
                }
                n3 = 0;
                break;
            }
            case 1411092308: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 6;
                    break;
                }
                n3 = 6;
                break;
            }
            case 1455365046: {
                if (bl) {
                    if (n2 != 1683920002) break;
                    n3 = 10;
                    break;
                }
                n3 = 10;
                break;
            }
            case 1660426392: {
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
            case -1635806712: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 16;
                    break;
                }
                n3 = 16;
                break;
            }
            case -1622541400: {
                if (bl) {
                    if (n2 != 1276482132) break;
                    n3 = 20;
                    break;
                }
                n3 = 20;
                break;
            }
            case -457191690: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 14;
                    break;
                }
                n3 = 14;
                break;
            }
            case 10349494: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 15;
                    break;
                }
                n3 = 15;
                break;
            }
            case 1105266788: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 19;
                    break;
                }
                n3 = 19;
                break;
            }
            case 1391825587: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 18;
                    break;
                }
                n3 = 18;
                break;
            }
            case 1859177120: {
                if (bl) {
                    if (n2 != 1687814400) break;
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
            case -1347658245: {
                n2 = this.a0(n4, bl, n);
                break;
            }
            case 1539383555: {
                n2 = this.a1(n4, bl, n);
                break;
            }
        }
        return n2;
    }

    private Object f0(int n, Object object, Object[] objectArray) {
        switch (n) {
            case 0: {
                ((DSIKombiSyncListener)object).updateKombiCommunicationState((Boolean)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 1: {
                ((DSIKombiSyncListener)object).updateKombiMessageStateDisplayStatus(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 2: {
                ((DSIKombiSyncListener)object).updateKombiMessageStatePopupStatus(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 3: {
                ((DSIKombiSyncListener)object).responseKombiDisplayStatus((DisplayStatus)objectArray[0]);
                return null;
            }
            case 4: {
                ((DSIKombiSyncListener)object).responseKombiPopupStatus((PopupStatus)objectArray[0]);
                return null;
            }
            case 5: {
                ((DSIKombiSyncListener)object).updateKombiMessageStateDisplayIdentification(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 6: {
                ((DSIKombiSyncListener)object).updateKombiMessageStateDisplayRequestResponse(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 7: {
                ((DSIKombiSyncListener)object).updateKombiMessageStatePopupActionRequest(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 8: {
                ((DSIKombiSyncListener)object).updateKombiMessageStatePopupRegisterResponse(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 9: {
                ((DSIKombiSyncListener)object).responseKombiDisplayRequestResponse((DisplayRequestResponse)objectArray[0]);
                return null;
            }
            case 10: {
                ((DSIKombiSyncListener)object).responseKombiDisplayIdentification((DisplayIdentification)objectArray[0]);
                return null;
            }
            case 11: {
                ((DSIKombiSyncListener)object).responseKombiPopupRegisterResponse((PopupRegisterRequestResponse)objectArray[0]);
                return null;
            }
            case 12: {
                ((DSIKombiSyncListener)object).responseKombiPopupActionRequest((PopupActionRequestResponse)objectArray[0]);
                return null;
            }
            case 13: {
                ((DSIKombiSyncListener)object).asyncException(((Number)objectArray[0]).intValue(), (String)objectArray[1], ((Number)objectArray[2]).intValue());
                return null;
            }
            case 14: {
                ((DSIKOMOGfxStreamSinkListener)object).updateGfxState(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 15: {
                ((DSIKOMOGfxStreamSinkListener)object).updateRequestSync(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 16: {
                ((DSIKOMOGfxStreamSinkListener)object).updateDataRate(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 17: {
                ((DSIKOMOGfxStreamSinkListener)object).setFGLayerResult(((Number)objectArray[0]).intValue());
                return null;
            }
            case 18: {
                ((DSIKOMOGfxStreamSinkListener)object).fadeInResult();
                return null;
            }
            case 19: {
                ((DSIKOMOGfxStreamSinkListener)object).fadeOutResult();
                return null;
            }
            case 20: {
                ((DSIKOMOGfxStreamSinkListener)object).asyncException(((Number)objectArray[0]).intValue(), (String)objectArray[1], ((Number)objectArray[2]).intValue());
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

