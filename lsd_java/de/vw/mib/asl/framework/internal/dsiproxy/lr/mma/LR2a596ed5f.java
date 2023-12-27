/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.framework.internal.dsiproxy.lr.mma;

import de.vw.mib.reflection.MultipleMethodAccessibleObject;
import de.vw.mib.reflection.RuntimeUtil;
import java.lang.reflect.InvocationTargetException;
import org.dsi.ifc.kombipictureserver.DSIKombiPictureServerListener;
import org.dsi.ifc.kombisync.DSIKombiSyncListener;
import org.dsi.ifc.kombisync.KombiDisplayRequest;
import org.dsi.ifc.kombisync.KombiDisplayStatus;
import org.dsi.ifc.kombisync.KombiPopupStatus;

public final class LR2a596ed5f
extends MultipleMethodAccessibleObject {
    private int a0(int n, boolean bl, int n2) {
        int n3 = -1;
        switch (n) {
            case -1885711132: {
                if (bl) {
                    if (n2 != 186005139) break;
                    n3 = 6;
                    break;
                }
                n3 = 6;
                break;
            }
            case -1622541400: {
                if (bl) {
                    if (n2 != 1276482132) break;
                    n3 = 7;
                    break;
                }
                n3 = 7;
                break;
            }
            case -1368558349: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 2;
                    break;
                }
                n3 = 2;
                break;
            }
            case -529743678: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 3;
                    break;
                }
                n3 = 3;
                break;
            }
            case -49206214: {
                if (bl) {
                    if (n2 != 1640193194) break;
                    n3 = 4;
                    break;
                }
                n3 = 4;
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
            case 1467405713: {
                if (bl) {
                    if (n2 != 1773236044) break;
                    n3 = 5;
                    break;
                }
                n3 = 5;
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
            case -2063886765: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 10;
                    break;
                }
                n3 = 10;
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
            case -1317454697: {
                if (bl) {
                    if (n2 != 1473665532) break;
                    n3 = 16;
                    break;
                }
                n3 = 16;
                break;
            }
            case -1155341103: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 12;
                    break;
                }
                n3 = 12;
                break;
            }
            case -1138012597: {
                if (bl) {
                    if (n2 != -266965504) break;
                    n3 = 13;
                    break;
                }
                n3 = 13;
                break;
            }
            case -700094538: {
                if (bl) {
                    if (n2 != -266965504) break;
                    n3 = 14;
                    break;
                }
                n3 = 14;
                break;
            }
            case -699133509: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 15;
                    break;
                }
                n3 = 15;
                break;
            }
            case 396703517: {
                if (bl) {
                    if (n2 != -883163127) break;
                    n3 = 8;
                    break;
                }
                n3 = 8;
                break;
            }
            case 1577177352: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 11;
                    break;
                }
                n3 = 11;
                break;
            }
            case 1950797184: {
                if (bl) {
                    if (n2 != -883163127) break;
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
            case -793285571: {
                n2 = this.a1(n4, bl, n);
                break;
            }
            case 2064927491: {
                n2 = this.a0(n4, bl, n);
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
                ((DSIKombiSyncListener)object).updateKombiMessageStateDisplayRequest(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 3: {
                ((DSIKombiSyncListener)object).updateKombiMessageStatePopupStatus(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 4: {
                ((DSIKombiSyncListener)object).responseKombiDisplayStatus((KombiDisplayStatus)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 5: {
                ((DSIKombiSyncListener)object).responseKombiDisplayRequest((KombiDisplayRequest)objectArray[0]);
                return null;
            }
            case 6: {
                ((DSIKombiSyncListener)object).responseKombiPopupStatus((KombiPopupStatus)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 7: {
                ((DSIKombiSyncListener)object).asyncException(((Number)objectArray[0]).intValue(), (String)objectArray[1], ((Number)objectArray[2]).intValue());
                return null;
            }
            case 8: {
                ((DSIKombiPictureServerListener)object).indicationCoverArt(((Number)objectArray[0]).longValue(), ((Number)objectArray[1]).intValue(), ((Number)objectArray[2]).intValue());
                return null;
            }
            case 9: {
                ((DSIKombiPictureServerListener)object).indicationStationArt(((Number)objectArray[0]).longValue(), ((Number)objectArray[1]).intValue(), ((Number)objectArray[2]).intValue());
                return null;
            }
            case 10: {
                ((DSIKombiPictureServerListener)object).indicationActiveCallPicture(((Number)objectArray[0]).intValue());
                return null;
            }
            case 11: {
                ((DSIKombiPictureServerListener)object).indicationActiveCallPictureInstance(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 12: {
                ((DSIKombiPictureServerListener)object).indicationDynamicIcon(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 13: {
                ((DSIKombiPictureServerListener)object).indicationInternalAddressID(((Number)objectArray[0]).longValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 14: {
                ((DSIKombiPictureServerListener)object).indicationAdbContactPicture(((Number)objectArray[0]).longValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 15: {
                ((DSIKombiPictureServerListener)object).indicationPictureStreamAbilities();
                return null;
            }
            case 16: {
                ((DSIKombiPictureServerListener)object).indicationPictureStream(((Number)objectArray[0]).intValue(), (short)((Number)objectArray[1]).intValue(), (short)((Number)objectArray[2]).intValue(), ((Number)objectArray[3]).intValue(), ((Number)objectArray[4]).intValue(), ((Number)objectArray[5]).intValue(), ((Number)objectArray[6]).intValue(), (byte[])objectArray[7]);
                return null;
            }
            case 17: {
                ((DSIKombiPictureServerListener)object).asyncException(((Number)objectArray[0]).intValue(), (String)objectArray[1], ((Number)objectArray[2]).intValue());
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

