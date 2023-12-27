/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.framework.internal.dsiproxy.lr.mma;

import de.vw.mib.reflection.MultipleMethodAccessibleObject;
import de.vw.mib.reflection.RuntimeUtil;
import java.lang.reflect.InvocationTargetException;
import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.swdlprogress.DSISwdlProgress;
import org.dsi.ifc.swdlselection.DSISwdlSelection;

public final class LR23bd78d37
extends MultipleMethodAccessibleObject {
    private int a0(int n, boolean bl, int n2) {
        int n3 = -1;
        switch (n) {
            case -1691079563: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 7;
                    break;
                }
                n3 = 7;
                break;
            }
            case -1387970860: {
                if (bl) {
                    if (n2 != -633848249) break;
                    n3 = 5;
                    break;
                }
                n3 = 5;
                break;
            }
            case -1321019820: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 12;
                    break;
                }
                n3 = 12;
                break;
            }
            case -1162471198: {
                if (bl) {
                    if (n2 == -904616957) {
                        n3 = 27;
                        break;
                    }
                    if (n2 == 1805755651) {
                        n3 = 28;
                        break;
                    }
                    if (n2 != -864245041) break;
                    n3 = 29;
                    break;
                }
                n3 = 27;
                break;
            }
            case -972303604: {
                if (bl) {
                    if (n2 != -633848249) break;
                    n3 = 16;
                    break;
                }
                n3 = 16;
                break;
            }
            case -948729267: {
                if (bl) {
                    if (n2 == -904616957) {
                        n3 = 30;
                        break;
                    }
                    if (n2 == 1805755651) {
                        n3 = 31;
                        break;
                    }
                    if (n2 != -864245041) break;
                    n3 = 32;
                    break;
                }
                n3 = 30;
                break;
            }
            case -942376036: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 22;
                    break;
                }
                n3 = 22;
                break;
            }
            case -407121378: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 14;
                    break;
                }
                n3 = 14;
                break;
            }
            case -230706246: {
                if (bl) {
                    if (n2 != -238538240) break;
                    n3 = 0;
                    break;
                }
                n3 = 0;
                break;
            }
            case -142901376: {
                if (bl) {
                    if (n2 != -242842362) break;
                    n3 = 9;
                    break;
                }
                n3 = 9;
                break;
            }
            case -132418525: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 10;
                    break;
                }
                n3 = 10;
                break;
            }
            case -67113821: {
                if (bl) {
                    if (n2 != -1653679357) break;
                    n3 = 2;
                    break;
                }
                n3 = 2;
                break;
            }
            case 225947237: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 21;
                    break;
                }
                n3 = 21;
                break;
            }
            case 253644014: {
                if (bl) {
                    if (n2 != -633848249) break;
                    n3 = 17;
                    break;
                }
                n3 = 17;
                break;
            }
            case 253809812: {
                if (bl) {
                    if (n2 != -633848249) break;
                    n3 = 18;
                    break;
                }
                n3 = 18;
                break;
            }
            case 267727404: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 13;
                    break;
                }
                n3 = 13;
                break;
            }
            case 364667590: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 25;
                    break;
                }
                n3 = 25;
                break;
            }
            case 403368172: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 6;
                    break;
                }
                n3 = 6;
                break;
            }
            case 913390163: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 15;
                    break;
                }
                n3 = 15;
                break;
            }
            case 1000896266: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 23;
                    break;
                }
                n3 = 23;
                break;
            }
            case 1084359672: {
                if (bl) {
                    if (n2 != -1653679357) break;
                    n3 = 26;
                    break;
                }
                n3 = 26;
                break;
            }
            case 1477745480: {
                if (bl) {
                    if (n2 != -633848249) break;
                    n3 = 4;
                    break;
                }
                n3 = 4;
                break;
            }
            case 1554936191: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 11;
                    break;
                }
                n3 = 11;
                break;
            }
            case 1722824014: {
                if (bl) {
                    if (n2 != -1653679357) break;
                    n3 = 1;
                    break;
                }
                n3 = 1;
                break;
            }
            case 1756387684: {
                if (bl) {
                    if (n2 != -633848249) break;
                    n3 = 19;
                    break;
                }
                n3 = 19;
                break;
            }
            case 1794708291: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 24;
                    break;
                }
                n3 = 24;
                break;
            }
            case 1959598243: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 3;
                    break;
                }
                n3 = 3;
                break;
            }
            case 1992078219: {
                if (bl) {
                    if (n2 != -1653679357) break;
                    n3 = 8;
                    break;
                }
                n3 = 8;
                break;
            }
            case 2092478792: {
                if (bl) {
                    if (n2 != -633848249) break;
                    n3 = 20;
                    break;
                }
                n3 = 20;
                break;
            }
        }
        return n3;
    }

    private int a1(int n, boolean bl, int n2) {
        int n3 = -1;
        switch (n) {
            case -1470182204: {
                if (bl) {
                    if (n2 != -1533790847) break;
                    n3 = 35;
                    break;
                }
                n3 = 35;
                break;
            }
            case -1162471198: {
                if (bl) {
                    if (n2 == -904616957) {
                        n3 = 36;
                        break;
                    }
                    if (n2 == 1805755651) {
                        n3 = 37;
                        break;
                    }
                    if (n2 != -864245041) break;
                    n3 = 38;
                    break;
                }
                n3 = 36;
                break;
            }
            case -948729267: {
                if (bl) {
                    if (n2 == -904616957) {
                        n3 = 39;
                        break;
                    }
                    if (n2 == 1805755651) {
                        n3 = 40;
                        break;
                    }
                    if (n2 != -864245041) break;
                    n3 = 41;
                    break;
                }
                n3 = 39;
                break;
            }
            case 3489684: {
                if (bl) {
                    if (n2 != -633848249) break;
                    n3 = 33;
                    break;
                }
                n3 = 33;
                break;
            }
            case 300924718: {
                if (bl) {
                    if (n2 != 1276482132) break;
                    n3 = 34;
                    break;
                }
                n3 = 34;
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
            case 319120921: {
                n2 = this.a1(n4, bl, n);
                break;
            }
            case 2081410575: {
                n2 = this.a0(n4, bl, n);
                break;
            }
        }
        return n2;
    }

    private Object f0(int n, Object object, Object[] objectArray) {
        switch (n) {
            case 0: {
                ((DSISwdlSelection)object).setRelease(((Number)objectArray[0]).longValue());
                return null;
            }
            case 1: {
                ((DSISwdlSelection)object).setUserSwdl((Boolean)objectArray[0]);
                return null;
            }
            case 2: {
                ((DSISwdlSelection)object).setGotFocus((Boolean)objectArray[0]);
                return null;
            }
            case 3: {
                ((DSISwdlSelection)object).getMedia();
                return null;
            }
            case 4: {
                ((DSISwdlSelection)object).storeNfsIpAddress((String)objectArray[0]);
                return null;
            }
            case 5: {
                ((DSISwdlSelection)object).storeNfsPath((String)objectArray[0]);
                return null;
            }
            case 6: {
                ((DSISwdlSelection)object).setMedium(((Number)objectArray[0]).intValue());
                return null;
            }
            case 7: {
                ((DSISwdlSelection)object).getUserDefinedAllowed();
                return null;
            }
            case 8: {
                ((DSISwdlSelection)object).setInstallationType((Boolean)objectArray[0]);
                return null;
            }
            case 9: {
                ((DSISwdlSelection)object).setTargetLanguage((short)((Number)objectArray[0]).intValue());
                return null;
            }
            case 10: {
                ((DSISwdlSelection)object).getIncompatibleDevices();
                return null;
            }
            case 11: {
                ((DSISwdlSelection)object).startDownload();
                return null;
            }
            case 12: {
                ((DSISwdlSelection)object).createCriticalUnlock();
                return null;
            }
            case 13: {
                ((DSISwdlSelection)object).startVersionUpload();
                return null;
            }
            case 14: {
                ((DSISwdlSelection)object).abortVersionUpload();
                return null;
            }
            case 15: {
                ((DSISwdlSelection)object).endVersionUpload();
                return null;
            }
            case 16: {
                ((DSISwdlSelection)object).storeCifsServer((String)objectArray[0]);
                return null;
            }
            case 17: {
                ((DSISwdlSelection)object).storeCifsPath((String)objectArray[0]);
                return null;
            }
            case 18: {
                ((DSISwdlSelection)object).storeCifsUser((String)objectArray[0]);
                return null;
            }
            case 19: {
                ((DSISwdlSelection)object).storeCifsPassword((String)objectArray[0]);
                return null;
            }
            case 20: {
                ((DSISwdlSelection)object).storeFsPath((String)objectArray[0]);
                return null;
            }
            case 21: {
                ((DSISwdlSelection)object).checkConsistency();
                return null;
            }
            case 22: {
                ((DSISwdlSelection)object).abortSetMedium();
                return null;
            }
            case 23: {
                ((DSISwdlSelection)object).abortSetRelease();
                return null;
            }
            case 24: {
                ((DSISwdlSelection)object).getFinalizeTargets();
                return null;
            }
            case 25: {
                ((DSISwdlSelection)object).setFinalizeTarget(((Number)objectArray[0]).intValue());
                return null;
            }
            case 26: {
                ((DSISwdlSelection)object).enterComponentUpdateConfirmation((Boolean)objectArray[0]);
                return null;
            }
            case 27: {
                ((DSISwdlSelection)object).setNotification((int[])objectArray[0], (DSIListener)objectArray[1]);
                return null;
            }
            case 28: {
                ((DSISwdlSelection)object).setNotification(((Number)objectArray[0]).intValue(), (DSIListener)objectArray[1]);
                return null;
            }
            case 29: {
                ((DSISwdlSelection)object).setNotification((DSIListener)objectArray[0]);
                return null;
            }
            case 30: {
                ((DSISwdlSelection)object).clearNotification((int[])objectArray[0], (DSIListener)objectArray[1]);
                return null;
            }
            case 31: {
                ((DSISwdlSelection)object).clearNotification(((Number)objectArray[0]).intValue(), (DSIListener)objectArray[1]);
                return null;
            }
        }
        return null;
    }

    private Object f1(int n, Object object, Object[] objectArray) {
        switch (n) {
            case 32: {
                ((DSISwdlSelection)object).clearNotification((DSIListener)objectArray[0]);
                return null;
            }
            case 33: {
                ((DSISwdlProgress)object).getProgressDetails((String)objectArray[0]);
                return null;
            }
            case 34: {
                ((DSISwdlProgress)object).handleUserSelection(((Number)objectArray[0]).intValue(), (String)objectArray[1], ((Number)objectArray[2]).intValue());
                return null;
            }
            case 35: {
                ((DSISwdlProgress)object).handleMediumSelection(((Number)objectArray[0]).intValue(), (String)objectArray[1], (byte)((Number)objectArray[2]).intValue(), ((Number)objectArray[3]).intValue());
                return null;
            }
            case 36: {
                ((DSISwdlProgress)object).setNotification((int[])objectArray[0], (DSIListener)objectArray[1]);
                return null;
            }
            case 37: {
                ((DSISwdlProgress)object).setNotification(((Number)objectArray[0]).intValue(), (DSIListener)objectArray[1]);
                return null;
            }
            case 38: {
                ((DSISwdlProgress)object).setNotification((DSIListener)objectArray[0]);
                return null;
            }
            case 39: {
                ((DSISwdlProgress)object).clearNotification((int[])objectArray[0], (DSIListener)objectArray[1]);
                return null;
            }
            case 40: {
                ((DSISwdlProgress)object).clearNotification(((Number)objectArray[0]).intValue(), (DSIListener)objectArray[1]);
                return null;
            }
            case 41: {
                ((DSISwdlProgress)object).clearNotification((DSIListener)objectArray[0]);
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
                case 1: {
                    return this.f1(n, object, objectArray);
                }
            }
            return null;
        }
        catch (Throwable throwable) {
            throw new InvocationTargetException(throwable);
        }
    }
}

