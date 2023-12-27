/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.framework.internal.startupv7r.reflection.generated.mma;

import de.vw.mib.asl.framework.internal.startupv7r.AslTargetStartup;
import de.vw.mib.event.StartupEvent;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.reflection.MultipleMethodAccessibleObject;
import de.vw.mib.reflection.RuntimeUtil;
import java.lang.reflect.InvocationTargetException;
import org.osgi.framework.ServiceEvent;

public final class LR2a8b6419c
extends MultipleMethodAccessibleObject {
    private int a0(int n, boolean bl, int n2) {
        int n3 = -1;
        switch (n) {
            case -1869930249: {
                if (bl) {
                    if (n2 != -645498553) break;
                    n3 = 0;
                    break;
                }
                n3 = 0;
                break;
            }
            case -1764372590: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 6;
                    break;
                }
                n3 = 6;
                break;
            }
            case -1521605226: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 4;
                    break;
                }
                n3 = 4;
                break;
            }
            case -1299566412: {
                if (bl) {
                    if (n2 != -2011293283) break;
                    n3 = 1;
                    break;
                }
                n3 = 1;
                break;
            }
            case -1078684458: {
                if (bl) {
                    if (n2 != -504091551) break;
                    n3 = 9;
                    break;
                }
                n3 = 9;
                break;
            }
            case -941544533: {
                if (bl) {
                    if (n2 != 941556127) break;
                    n3 = 11;
                    break;
                }
                n3 = 11;
                break;
            }
            case -881416589: {
                if (bl) {
                    if (n2 != -830048105) break;
                    n3 = 3;
                    break;
                }
                n3 = 3;
                break;
            }
            case 251692112: {
                if (bl) {
                    if (n2 != -645498553) break;
                    n3 = 2;
                    break;
                }
                n3 = 2;
                break;
            }
            case 1254550314: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 8;
                    break;
                }
                n3 = 8;
                break;
            }
            case 1265783107: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 7;
                    break;
                }
                n3 = 7;
                break;
            }
            case 1282842378: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 10;
                    break;
                }
                n3 = 10;
                break;
            }
            case 1993821299: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 5;
                    break;
                }
                n3 = 5;
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
            case -1464450660: {
                n2 = this.a0(n4, bl, n);
                break;
            }
        }
        return n2;
    }

    private Object f0(int n, Object object, Object[] objectArray) {
        switch (n) {
            case 0: {
                ((AslTargetStartup)object).registered((String)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 1: {
                ((AslTargetStartup)object).serviceChanged((ServiceEvent)objectArray[0]);
                return null;
            }
            case 2: {
                ((AslTargetStartup)object).unregistered((String)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 3: {
                ((AslTargetStartup)object).consumeEvent((StartupEvent)objectArray[0]);
                return null;
            }
            case 4: {
                ((AslTargetStartup)object).updateStateToHmi(((Number)objectArray[0]).intValue());
                return null;
            }
            case 5: {
                ((AslTargetStartup)object).triggerLamContextToPlay();
                return null;
            }
            case 6: {
                ((AslTargetStartup)object).triggerMeSafe(((Number)objectArray[0]).intValue());
                return null;
            }
            case 7: {
                ((AslTargetStartup)object).switchToMenu();
                return null;
            }
            case 8: {
                ((AslTargetStartup)object).performSystemReboot();
                return null;
            }
            case 9: {
                ((AslTargetStartup)object).showErrorPopup((Throwable)objectArray[0]);
                return null;
            }
            case 10: {
                return ((AslTargetStartup)object).getPersistableEarlyData();
            }
            case 11: {
                return RuntimeUtil.valueOf(((AslTargetStartup)object).sendSafeLocal((EventGeneric)objectArray[0]));
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

