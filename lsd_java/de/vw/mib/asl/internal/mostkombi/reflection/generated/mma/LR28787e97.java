/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.mostkombi.reflection.generated.mma;

import de.vw.mib.asl.internal.mostkombi.common.sequence.Sequence;
import de.vw.mib.asl.internal.mostkombi.navinfo.api.navi.asl.NavInfoService;
import de.vw.mib.asl.internal.mostkombi.streamsink.api.displaymanagement.asl.DisplayManagementService;
import de.vw.mib.asl.internal.mostkombi.streamsink.api.navimap.asl.NavigationMapService;
import de.vw.mib.asl.internal.mostkombi.streamsink.states.InitializeState;
import de.vw.mib.asl.internal.mostkombi.streamsink.states.RunningState;
import de.vw.mib.asl.internal.mostkombi.streamsink.states.WaitForServices;
import de.vw.mib.reflection.MultipleMethodAccessibleObject;
import de.vw.mib.reflection.RuntimeUtil;
import java.lang.reflect.InvocationTargetException;

public final class LR28787e97
extends MultipleMethodAccessibleObject {
    private int a0(int n, boolean bl, int n2) {
        int n3 = -1;
        switch (n) {
            case 814492819: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 1;
                    break;
                }
                n3 = 1;
                break;
            }
            case 1844972994: {
                if (bl) {
                    if (n2 != 1676164096) break;
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
            case -867518548: {
                if (bl) {
                    if (n2 != -1787145843) break;
                    n3 = 2;
                    break;
                }
                n3 = 2;
                break;
            }
            case -324189484: {
                if (bl) {
                    if (n2 != 112814951) break;
                    n3 = 6;
                    break;
                }
                n3 = 6;
                break;
            }
            case 233493981: {
                if (bl) {
                    if (n2 != 206676214) break;
                    n3 = 3;
                    break;
                }
                n3 = 3;
                break;
            }
            case 340825919: {
                if (bl) {
                    if (n2 != 1982140297) break;
                    n3 = 5;
                    break;
                }
                n3 = 5;
                break;
            }
            case 807225688: {
                if (bl) {
                    if (n2 != -1775495539) break;
                    n3 = 4;
                    break;
                }
                n3 = 4;
                break;
            }
            case 814492819: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 8;
                    break;
                }
                n3 = 8;
                break;
            }
            case 1844972994: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 7;
                    break;
                }
                n3 = 7;
                break;
            }
        }
        return n3;
    }

    private int a2(int n, boolean bl, int n2) {
        int n3 = -1;
        switch (n) {
            case -324189484: {
                if (bl) {
                    if (n2 != 112814951) break;
                    n3 = 9;
                    break;
                }
                n3 = 9;
                break;
            }
            case 814492819: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 12;
                    break;
                }
                n3 = 12;
                break;
            }
            case 1204057937: {
                if (bl) {
                    if (n2 != 2063385576) break;
                    n3 = 10;
                    break;
                }
                n3 = 10;
                break;
            }
            case 1844972994: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 11;
                    break;
                }
                n3 = 11;
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
            case -2125726464: {
                n2 = this.a2(n4, bl, n);
                break;
            }
            case -1051030449: {
                n2 = this.a0(n4, bl, n);
                break;
            }
            case 1026475054: {
                n2 = this.a1(n4, bl, n);
                break;
            }
        }
        return n2;
    }

    private Object f0(int n, Object object, Object[] objectArray) {
        switch (n) {
            case 0: {
                ((InitializeState)object).dsiKOMOGfxStreamSinkUpdateGfxState(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 1: {
                return ((InitializeState)object).getContextDelegate();
            }
            case 2: {
                return ((RunningState)object).getSequence((Sequence)objectArray[0], ((Number)objectArray[1]).intValue());
            }
            case 3: {
                ((RunningState)object).updateNavInfo((NavInfoService)objectArray[0], ((Number)objectArray[1]).intValue(), objectArray[2]);
                return null;
            }
            case 4: {
                ((RunningState)object).sequenceDone((Sequence)objectArray[0]);
                return null;
            }
            case 5: {
                return RuntimeUtil.valueOf(((RunningState)object).sequenceStepFailed((Sequence)objectArray[0], ((Number)objectArray[1]).intValue(), (String)objectArray[2]));
            }
            case 6: {
                ((RunningState)object).updateNavigationMap((NavigationMapService)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 7: {
                ((RunningState)object).dsiKOMOGfxStreamSinkUpdateGfxState(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 8: {
                return ((RunningState)object).getContextDelegate();
            }
            case 9: {
                ((WaitForServices)object).updateNavigationMap((NavigationMapService)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 10: {
                ((WaitForServices)object).updateDisplayManagement((DisplayManagementService)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 11: {
                ((WaitForServices)object).dsiKOMOGfxStreamSinkUpdateGfxState(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 12: {
                return ((WaitForServices)object).getContextDelegate();
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

