/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.framework.internal.dsiproxy.lr.mma;

import de.vw.mib.reflection.MultipleMethodAccessibleObject;
import de.vw.mib.reflection.RuntimeUtil;
import java.lang.reflect.InvocationTargetException;
import org.dsi.ifc.global.NavRectangle;
import org.dsi.ifc.navfleetservices.DSINavFleetServicesListener;
import org.dsi.ifc.navigation.BlockElement;
import org.dsi.ifc.navigation.DSIBlockingListener;

public final class LR2f1d6a8ec
extends MultipleMethodAccessibleObject {
    private int a0(int n, boolean bl, int n2) {
        int n3 = -1;
        switch (n) {
            case -1622541400: {
                if (bl) {
                    if (n2 != 1276482132) break;
                    n3 = 4;
                    break;
                }
                n3 = 4;
                break;
            }
            case -1354425422: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 1;
                    break;
                }
                n3 = 1;
                break;
            }
            case -892888460: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 0;
                    break;
                }
                n3 = 0;
                break;
            }
            case 283546287: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 3;
                    break;
                }
                n3 = 3;
                break;
            }
            case 1238159319: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 2;
                    break;
                }
                n3 = 2;
                break;
            }
        }
        return n3;
    }

    private int a1(int n, boolean bl, int n2) {
        int n3 = -1;
        switch (n) {
            case -1680536871: {
                if (bl) {
                    if (n2 != -1113314609) break;
                    n3 = 5;
                    break;
                }
                n3 = 5;
                break;
            }
            case -1622541400: {
                if (bl) {
                    if (n2 != 1276482132) break;
                    n3 = 21;
                    break;
                }
                n3 = 21;
                break;
            }
            case -1485821529: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 6;
                    break;
                }
                n3 = 6;
                break;
            }
            case -1133926610: {
                if (bl) {
                    if (n2 != -266965504) break;
                    n3 = 14;
                    break;
                }
                n3 = 14;
                break;
            }
            case -723414358: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 9;
                    break;
                }
                n3 = 9;
                break;
            }
            case -582163386: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 7;
                    break;
                }
                n3 = 7;
                break;
            }
            case -261882787: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 12;
                    break;
                }
                n3 = 12;
                break;
            }
            case -175227412: {
                if (bl) {
                    if (n2 != -266965504) break;
                    n3 = 13;
                    break;
                }
                n3 = 13;
                break;
            }
            case -102797057: {
                if (bl) {
                    if (n2 != -266965504) break;
                    n3 = 15;
                    break;
                }
                n3 = 15;
                break;
            }
            case -39742254: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 11;
                    break;
                }
                n3 = 11;
                break;
            }
            case 7643652: {
                if (bl) {
                    if (n2 != 1828738848) break;
                    n3 = 20;
                    break;
                }
                n3 = 20;
                break;
            }
            case 162850723: {
                if (bl) {
                    if (n2 != -1017431296) break;
                    n3 = 19;
                    break;
                }
                n3 = 19;
                break;
            }
            case 184201939: {
                if (bl) {
                    if (n2 != 1043255048) break;
                    n3 = 10;
                    break;
                }
                n3 = 10;
                break;
            }
            case 940414676: {
                if (bl) {
                    if (n2 != -1017431296) break;
                    n3 = 18;
                    break;
                }
                n3 = 18;
                break;
            }
            case 1495477449: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 8;
                    break;
                }
                n3 = 8;
                break;
            }
            case 2118331342: {
                if (bl) {
                    if (n2 != -266965504) break;
                    n3 = 16;
                    break;
                }
                n3 = 16;
                break;
            }
            case 2119130891: {
                if (bl) {
                    if (n2 != -1017431296) break;
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
            case -1794133779: {
                n2 = this.a0(n4, bl, n);
                break;
            }
            case -1118733212: {
                n2 = this.a1(n4, bl, n);
                break;
            }
        }
        return n2;
    }

    private Object f0(int n, Object object, Object[] objectArray) {
        switch (n) {
            case 0: {
                ((DSINavFleetServicesListener)object).setVZOTrackerStateResult(((Number)objectArray[0]).intValue());
                return null;
            }
            case 1: {
                ((DSINavFleetServicesListener)object).setVZODownloadStateResult(((Number)objectArray[0]).intValue());
                return null;
            }
            case 2: {
                ((DSINavFleetServicesListener)object).setLGITrackerStateResult(((Number)objectArray[0]).intValue());
                return null;
            }
            case 3: {
                ((DSINavFleetServicesListener)object).setLGIDownloadStateResult(((Number)objectArray[0]).intValue());
                return null;
            }
            case 4: {
                ((DSINavFleetServicesListener)object).asyncException(((Number)objectArray[0]).intValue(), (String)objectArray[1], ((Number)objectArray[2]).intValue());
                return null;
            }
            case 5: {
                ((DSIBlockingListener)object).updateListOfBlocks((BlockElement[])objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 6: {
                ((DSIBlockingListener)object).updateNaviCoreAvailableToSetBlocks(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 7: {
                ((DSIBlockingListener)object).updateMaximumNumberOfBlockedAreas(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 8: {
                ((DSIBlockingListener)object).updateMaximumNumberOfBlockedRouteSegments(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 9: {
                ((DSIBlockingListener)object).updateMaximumNumberOfBlockedRoadSegments(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 10: {
                ((DSIBlockingListener)object).updateMaximumDimensionsOfBlockedArea(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue(), ((Number)objectArray[2]).intValue());
                return null;
            }
            case 11: {
                ((DSIBlockingListener)object).updateMaximumSegmentLengthOfBlockedRouteSegment(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 12: {
                ((DSIBlockingListener)object).updateMaximumLengthOfBlockRouteBasedOnLength(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 13: {
                ((DSIBlockingListener)object).blockAreaResult(((Number)objectArray[0]).longValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 14: {
                ((DSIBlockingListener)object).blockRouteSegmentsResult(((Number)objectArray[0]).longValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 15: {
                ((DSIBlockingListener)object).blockRoadSegmentsResult(((Number)objectArray[0]).longValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 16: {
                ((DSIBlockingListener)object).blockRouteBasedOnLengthResult(((Number)objectArray[0]).longValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 17: {
                ((DSIBlockingListener)object).persistBlockResult((long[])objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 18: {
                ((DSIBlockingListener)object).deleteBlockResult((long[])objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 19: {
                ((DSIBlockingListener)object).setBlockDescriptionResult((long[])objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 20: {
                ((DSIBlockingListener)object).getBoundingRectangleOfBlocksResult((long[])objectArray[0], (NavRectangle)objectArray[1]);
                return null;
            }
            case 21: {
                ((DSIBlockingListener)object).asyncException(((Number)objectArray[0]).intValue(), (String)objectArray[1], ((Number)objectArray[2]).intValue());
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

