/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.online.tourimport.reflection.generated.mma;

import de.vw.mib.asl.internal.online.tourimport.states.TourImportStateActive;
import de.vw.mib.asl.internal.online.tourimport.states.TourImportStateActiveIdle;
import de.vw.mib.asl.internal.online.tourimport.states.TourImportStateDownloadActive;
import de.vw.mib.asl.internal.online.tourimport.states.TourImportStateExportActive;
import de.vw.mib.asl.internal.online.tourimport.states.TourImportStateNotActive;
import de.vw.mib.asl.internal.online.tourimport.states.TourImportStateParent;
import de.vw.mib.reflection.MultipleMethodAccessibleObject;
import de.vw.mib.reflection.RuntimeUtil;
import java.lang.reflect.InvocationTargetException;

public final class LR216b3dfec
extends MultipleMethodAccessibleObject {
    private int a0(int n, boolean bl, int n2) {
        int n3 = -1;
        switch (n) {
            case -593314106: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 0;
                    break;
                }
                n3 = 0;
                break;
            }
            case 88480498: {
                if (bl) {
                    if (n2 != 1276482132) break;
                    n3 = 2;
                    break;
                }
                n3 = 2;
                break;
            }
            case 472305696: {
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
            case -593314106: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 3;
                    break;
                }
                n3 = 3;
                break;
            }
            case 88480498: {
                if (bl) {
                    if (n2 != 1276482132) break;
                    n3 = 5;
                    break;
                }
                n3 = 5;
                break;
            }
            case 472305696: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 4;
                    break;
                }
                n3 = 4;
                break;
            }
        }
        return n3;
    }

    private int a2(int n, boolean bl, int n2) {
        int n3 = -1;
        switch (n) {
            case -593314106: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 6;
                    break;
                }
                n3 = 6;
                break;
            }
            case 88480498: {
                if (bl) {
                    if (n2 != 1276482132) break;
                    n3 = 8;
                    break;
                }
                n3 = 8;
                break;
            }
            case 231978026: {
                if (bl) {
                    if (n2 != -107814524) break;
                    n3 = 9;
                    break;
                }
                n3 = 9;
                break;
            }
            case 472305696: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 7;
                    break;
                }
                n3 = 7;
                break;
            }
        }
        return n3;
    }

    private int a3(int n, boolean bl, int n2) {
        int n3 = -1;
        switch (n) {
            case -593314106: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 10;
                    break;
                }
                n3 = 10;
                break;
            }
            case 88480498: {
                if (bl) {
                    if (n2 != 1276482132) break;
                    n3 = 12;
                    break;
                }
                n3 = 12;
                break;
            }
            case 472305696: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 11;
                    break;
                }
                n3 = 11;
                break;
            }
        }
        return n3;
    }

    private int a4(int n, boolean bl, int n2) {
        int n3 = -1;
        switch (n) {
            case -593314106: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 13;
                    break;
                }
                n3 = 13;
                break;
            }
            case 231978026: {
                if (bl) {
                    if (n2 != -107814524) break;
                    n3 = 15;
                    break;
                }
                n3 = 15;
                break;
            }
            case 472305696: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 14;
                    break;
                }
                n3 = 14;
                break;
            }
        }
        return n3;
    }

    private int a5(int n, boolean bl, int n2) {
        int n3 = -1;
        switch (n) {
            case 88480498: {
                if (bl) {
                    if (n2 != 1276482132) break;
                    n3 = 18;
                    break;
                }
                n3 = 18;
                break;
            }
            case 231978026: {
                if (bl) {
                    if (n2 != -107814524) break;
                    n3 = 19;
                    break;
                }
                n3 = 19;
                break;
            }
            case 472305696: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 17;
                    break;
                }
                n3 = 17;
                break;
            }
            case 815109884: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 16;
                    break;
                }
                n3 = 16;
                break;
            }
            case 1916002242: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 20;
                    break;
                }
                n3 = 20;
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
            case -1941945522: {
                n2 = this.a0(n4, bl, n);
                break;
            }
            case -1544556810: {
                n2 = this.a2(n4, bl, n);
                break;
            }
            case -1514418958: {
                n2 = this.a5(n4, bl, n);
                break;
            }
            case -1362902558: {
                n2 = this.a3(n4, bl, n);
                break;
            }
            case -30088510: {
                n2 = this.a1(n4, bl, n);
                break;
            }
            case 1241315195: {
                n2 = this.a4(n4, bl, n);
                break;
            }
        }
        return n2;
    }

    private Object f0(int n, Object object, Object[] objectArray) {
        switch (n) {
            case 0: {
                ((TourImportStateActive)object).dsiOnlineTourImportIndicateToursAvailable(((Number)objectArray[0]).intValue());
                return null;
            }
            case 1: {
                ((TourImportStateActive)object).dsiOnlineTourImportResponseTourDownload(((Number)objectArray[0]).intValue());
                return null;
            }
            case 2: {
                ((TourImportStateActive)object).dsiOnlineTourImportAsyncException(((Number)objectArray[0]).intValue(), (String)objectArray[1], ((Number)objectArray[2]).intValue());
                return null;
            }
            case 3: {
                ((TourImportStateActiveIdle)object).dsiOnlineTourImportIndicateToursAvailable(((Number)objectArray[0]).intValue());
                return null;
            }
            case 4: {
                ((TourImportStateActiveIdle)object).dsiOnlineTourImportResponseTourDownload(((Number)objectArray[0]).intValue());
                return null;
            }
            case 5: {
                ((TourImportStateActiveIdle)object).dsiOnlineTourImportAsyncException(((Number)objectArray[0]).intValue(), (String)objectArray[1], ((Number)objectArray[2]).intValue());
                return null;
            }
            case 6: {
                ((TourImportStateDownloadActive)object).dsiOnlineTourImportIndicateToursAvailable(((Number)objectArray[0]).intValue());
                return null;
            }
            case 7: {
                ((TourImportStateDownloadActive)object).dsiOnlineTourImportResponseTourDownload(((Number)objectArray[0]).intValue());
                return null;
            }
            case 8: {
                ((TourImportStateDownloadActive)object).dsiOnlineTourImportAsyncException(((Number)objectArray[0]).intValue(), (String)objectArray[1], ((Number)objectArray[2]).intValue());
                return null;
            }
            case 9: {
                ((TourImportStateDownloadActive)object).dsiOnlineTourImportIndicateTourDownloadFinished(((Number)objectArray[0]).intValue(), (String)objectArray[1], (String)objectArray[2], ((Number)objectArray[3]).intValue());
                return null;
            }
            case 10: {
                ((TourImportStateExportActive)object).dsiOnlineTourImportIndicateToursAvailable(((Number)objectArray[0]).intValue());
                return null;
            }
            case 11: {
                ((TourImportStateExportActive)object).dsiOnlineTourImportResponseTourDownload(((Number)objectArray[0]).intValue());
                return null;
            }
            case 12: {
                ((TourImportStateExportActive)object).dsiOnlineTourImportAsyncException(((Number)objectArray[0]).intValue(), (String)objectArray[1], ((Number)objectArray[2]).intValue());
                return null;
            }
            case 13: {
                ((TourImportStateNotActive)object).dsiOnlineTourImportIndicateToursAvailable(((Number)objectArray[0]).intValue());
                return null;
            }
            case 14: {
                ((TourImportStateNotActive)object).dsiOnlineTourImportResponseTourDownload(((Number)objectArray[0]).intValue());
                return null;
            }
            case 15: {
                ((TourImportStateNotActive)object).dsiOnlineTourImportIndicateTourDownloadFinished(((Number)objectArray[0]).intValue(), (String)objectArray[1], (String)objectArray[2], ((Number)objectArray[3]).intValue());
                return null;
            }
            case 16: {
                return ((TourImportStateParent)object).getTarget();
            }
            case 17: {
                ((TourImportStateParent)object).dsiOnlineTourImportResponseTourDownload(((Number)objectArray[0]).intValue());
                return null;
            }
            case 18: {
                ((TourImportStateParent)object).dsiOnlineTourImportAsyncException(((Number)objectArray[0]).intValue(), (String)objectArray[1], ((Number)objectArray[2]).intValue());
                return null;
            }
            case 19: {
                ((TourImportStateParent)object).dsiOnlineTourImportIndicateTourDownloadFinished(((Number)objectArray[0]).intValue(), (String)objectArray[1], (String)objectArray[2], ((Number)objectArray[3]).intValue());
                return null;
            }
            case 20: {
                ((TourImportStateParent)object).updateServiceStatusOnChange(((Number)objectArray[0]).intValue());
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

