/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.framework.internal.dsiproxy.lr.mma;

import de.vw.mib.reflection.MultipleMethodAccessibleObject;
import de.vw.mib.reflection.RuntimeUtil;
import java.lang.reflect.InvocationTargetException;
import org.dsi.ifc.map.DSIMapViewerZoomEngineListener;
import org.dsi.ifc.media.DSIMediaBaseListener;
import org.dsi.ifc.media.DeviceInfo;
import org.dsi.ifc.media.MediaInfo;

public final class LR2f2fc18b1
extends MultipleMethodAccessibleObject {
    private int a0(int n, boolean bl, int n2) {
        int n3 = -1;
        switch (n) {
            case -1622541400: {
                if (bl) {
                    if (n2 != 1276482132) break;
                    n3 = 14;
                    break;
                }
                n3 = 14;
                break;
            }
            case -1527985454: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 5;
                    break;
                }
                n3 = 5;
                break;
            }
            case -1520022462: {
                if (bl) {
                    if (n2 != 1043255048) break;
                    n3 = 4;
                    break;
                }
                n3 = 4;
                break;
            }
            case -1288385402: {
                if (bl) {
                    if (n2 != -645498553) break;
                    n3 = 10;
                    break;
                }
                n3 = 10;
                break;
            }
            case -949240242: {
                if (bl) {
                    if (n2 != -30324290) break;
                    n3 = 7;
                    break;
                }
                n3 = 7;
                break;
            }
            case -502753230: {
                if (bl) {
                    if (n2 != 1785675212) break;
                    n3 = 8;
                    break;
                }
                n3 = 8;
                break;
            }
            case -283450096: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 1;
                    break;
                }
                n3 = 1;
                break;
            }
            case -90180800: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 3;
                    break;
                }
                n3 = 3;
                break;
            }
            case 241276486: {
                if (bl) {
                    if (n2 != 1043255048) break;
                    n3 = 2;
                    break;
                }
                n3 = 2;
                break;
            }
            case 268535717: {
                if (bl) {
                    if (n2 != -645498553) break;
                    n3 = 6;
                    break;
                }
                n3 = 6;
                break;
            }
            case 345913829: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 9;
                    break;
                }
                n3 = 9;
                break;
            }
            case 1211451291: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 0;
                    break;
                }
                n3 = 0;
                break;
            }
            case 1656142420: {
                if (bl) {
                    if (n2 != -1600866162) break;
                    n3 = 12;
                    break;
                }
                n3 = 12;
                break;
            }
            case 1852361120: {
                if (bl) {
                    if (n2 != 245876531) break;
                    n3 = 13;
                    break;
                }
                n3 = 13;
                break;
            }
            case 2138505431: {
                if (bl) {
                    if (n2 != -645498553) break;
                    n3 = 11;
                    break;
                }
                n3 = 11;
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
                    n3 = 19;
                    break;
                }
                n3 = 19;
                break;
            }
            case -1231288021: {
                if (bl) {
                    if (n2 != -1665395196) break;
                    n3 = 15;
                    break;
                }
                n3 = 15;
                break;
            }
            case -739932358: {
                if (bl) {
                    if (n2 != -797832442) break;
                    n3 = 17;
                    break;
                }
                n3 = 17;
                break;
            }
            case 1760648424: {
                if (bl) {
                    if (n2 != -1665395196) break;
                    n3 = 16;
                    break;
                }
                n3 = 16;
                break;
            }
            case 1979096072: {
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
            case -2098953654: {
                n2 = this.a1(n4, bl, n);
                break;
            }
            case 133514868: {
                n2 = this.a0(n4, bl, n);
                break;
            }
        }
        return n2;
    }

    private Object f0(int n, Object object, Object[] objectArray) {
        switch (n) {
            case 0: {
                ((DSIMediaBaseListener)object).profileReset(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 1: {
                ((DSIMediaBaseListener)object).profileResetAll(((Number)objectArray[0]).intValue());
                return null;
            }
            case 2: {
                ((DSIMediaBaseListener)object).updateProfileState(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue(), ((Number)objectArray[2]).intValue());
                return null;
            }
            case 3: {
                ((DSIMediaBaseListener)object).profileChanged(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 4: {
                ((DSIMediaBaseListener)object).profileCopied(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue(), ((Number)objectArray[2]).intValue());
                return null;
            }
            case 5: {
                ((DSIMediaBaseListener)object).updateParentalML(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 6: {
                ((DSIMediaBaseListener)object).updatePreferredLanguage((String)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 7: {
                ((DSIMediaBaseListener)object).updateMediaList((MediaInfo[])objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 8: {
                ((DSIMediaBaseListener)object).updateDeviceList((DeviceInfo[])objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 9: {
                ((DSIMediaBaseListener)object).updateCustomerUpdate(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 10: {
                ((DSIMediaBaseListener)object).updateApplicationVersion((String)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 11: {
                ((DSIMediaBaseListener)object).updateMetadataDBVersion((String)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 12: {
                ((DSIMediaBaseListener)object).responseResetFactorySettings(((Number)objectArray[0]).intValue(), (Boolean)objectArray[1]);
                return null;
            }
            case 13: {
                ((DSIMediaBaseListener)object).launchAppResult(((Number)objectArray[0]).longValue(), ((Number)objectArray[1]).longValue(), (String)objectArray[2], (Boolean)objectArray[3]);
                return null;
            }
            case 14: {
                ((DSIMediaBaseListener)object).asyncException(((Number)objectArray[0]).intValue(), (String)objectArray[1], ((Number)objectArray[2]).intValue());
                return null;
            }
            case 15: {
                ((DSIMapViewerZoomEngineListener)object).updateAutoZoomEnabled((Boolean)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 16: {
                ((DSIMapViewerZoomEngineListener)object).updateManoeuvreZoomEnabled((Boolean)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 17: {
                ((DSIMapViewerZoomEngineListener)object).updateRecommendedZoom(((Number)objectArray[0]).floatValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 18: {
                ((DSIMapViewerZoomEngineListener)object).updateZoomEngineState(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 19: {
                ((DSIMapViewerZoomEngineListener)object).asyncException(((Number)objectArray[0]).intValue(), (String)objectArray[1], ((Number)objectArray[2]).intValue());
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

