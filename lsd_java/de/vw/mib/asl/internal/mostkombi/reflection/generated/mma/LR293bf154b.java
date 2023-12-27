/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.mostkombi.reflection.generated.mma;

import de.vw.mib.asl.internal.mostkombi.common.api.adaption.asl.AdaptationService;
import de.vw.mib.asl.internal.mostkombi.common.category.CategoryDelegate;
import de.vw.mib.asl.internal.mostkombi.common.controller.Controller;
import de.vw.mib.asl.internal.mostkombi.common.controller.ControllerDelegate;
import de.vw.mib.asl.internal.mostkombi.common.sequence.Sequence;
import de.vw.mib.asl.internal.mostkombi.common.sequence.SequenceDelegate;
import de.vw.mib.asl.internal.mostkombi.common.timer.Timer;
import de.vw.mib.asl.internal.mostkombi.kombiview.controller.KombiViewController;
import de.vw.mib.asl.internal.mostkombi.master.controller.MostKombiMasterController;
import de.vw.mib.asl.internal.mostkombi.navinfo.api.navi.asl.NavInfoService;
import de.vw.mib.asl.internal.mostkombi.navinfo.controller.NavInfoController;
import de.vw.mib.asl.internal.mostkombi.navinfo.functions.Capabilities;
import de.vw.mib.asl.internal.mostkombi.navinfo.functions.CityName;
import de.vw.mib.asl.internal.mostkombi.navinfo.functions.CurrentStreet;
import de.vw.mib.asl.internal.mostkombi.navinfo.functions.DistanceToDestination;
import de.vw.mib.asl.internal.mostkombi.navinfo.functions.DistanceToNextManeuver;
import de.vw.mib.asl.internal.mostkombi.navinfo.functions.EstimatedRemainingTripTime;
import de.vw.mib.asl.internal.mostkombi.navinfo.functions.EstimatedTimeArrival;
import de.vw.mib.asl.internal.mostkombi.navinfo.functions.RouteGuidanceMode;
import de.vw.mib.asl.internal.mostkombi.navinfo.functions.TurnToStreet;
import de.vw.mib.asl.internal.mostkombi.streamsink.api.displaymanagement.asl.DisplayManagementService;
import de.vw.mib.asl.internal.mostkombi.streamsink.api.navimap.asl.NavigationMapService;
import de.vw.mib.asl.internal.mostkombi.streamsink.controller.GfxStreamSinkController;
import de.vw.mib.asl.internal.mostkombi.streamsink.usecases.ChangeDataRate;
import de.vw.mib.asl.internal.mostkombi.streamsink.usecases.ChangeDataRateSequence;
import de.vw.mib.asl.internal.mostkombi.streamsink.usecases.MostUnlockUseCase;
import de.vw.mib.asl.internal.mostkombi.streamsink.usecases.SwitchMapFromABTToKombi;
import de.vw.mib.asl.internal.mostkombi.streamsink.usecases.SwitchMapFromABTToKombiSequence;
import de.vw.mib.asl.internal.mostkombi.streamsink.usecases.SwitchMapFromKombiToABT;
import de.vw.mib.asl.internal.mostkombi.streamsink.usecases.SwitchMapFromKombiToABTSequence;
import de.vw.mib.asl.internal.mostkombi.streamsink.usecases.SwitchToPermanentMap;
import de.vw.mib.asl.internal.mostkombi.streamsink.usecases.SwitchToPermanentMapSequence;
import de.vw.mib.reflection.MultipleMethodAccessibleObject;
import de.vw.mib.reflection.RuntimeUtil;
import java.lang.reflect.InvocationTargetException;

public final class LR293bf154b
extends MultipleMethodAccessibleObject {
    private int a0(int n, boolean bl, int n2) {
        int n3 = -1;
        switch (n) {
            case -1302253218: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 6;
                    break;
                }
                n3 = 6;
                break;
            }
            case -867518548: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 5;
                    break;
                }
                n3 = 5;
                break;
            }
            case -220168187: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 8;
                    break;
                }
                n3 = 8;
                break;
            }
            case -136892488: {
                if (bl) {
                    if (n2 != -1691491688) break;
                    n3 = 3;
                    break;
                }
                n3 = 3;
                break;
            }
            case 196890700: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 9;
                    break;
                }
                n3 = 9;
                break;
            }
            case 339680775: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 7;
                    break;
                }
                n3 = 7;
                break;
            }
            case 598678267: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 1;
                    break;
                }
                n3 = 1;
                break;
            }
            case 815109884: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 2;
                    break;
                }
                n3 = 2;
                break;
            }
            case 871091717: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 0;
                    break;
                }
                n3 = 0;
                break;
            }
            case 1888278295: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 10;
                    break;
                }
                n3 = 10;
                break;
            }
            case 2128411881: {
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

    private int a1(int n, boolean bl, int n2) {
        int n3 = -1;
        switch (n) {
            case -1575336191: {
                if (bl) {
                    if (n2 != -151236712) break;
                    n3 = 22;
                    break;
                }
                n3 = 22;
                break;
            }
            case -1302253218: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 18;
                    break;
                }
                n3 = 18;
                break;
            }
            case -867518548: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 17;
                    break;
                }
                n3 = 17;
                break;
            }
            case -220168187: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 20;
                    break;
                }
                n3 = 20;
                break;
            }
            case -136892488: {
                if (bl) {
                    if (n2 != -1691491688) break;
                    n3 = 14;
                    break;
                }
                n3 = 14;
                break;
            }
            case 339680775: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 19;
                    break;
                }
                n3 = 19;
                break;
            }
            case 598678267: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 12;
                    break;
                }
                n3 = 12;
                break;
            }
            case 815109884: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 13;
                    break;
                }
                n3 = 13;
                break;
            }
            case 871091717: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 11;
                    break;
                }
                n3 = 11;
                break;
            }
            case 1888278295: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 21;
                    break;
                }
                n3 = 21;
                break;
            }
            case 2128411881: {
                if (bl) {
                    if (n2 == -179663976) {
                        n3 = 15;
                        break;
                    }
                    if (n2 != 1687814400) break;
                    n3 = 16;
                    break;
                }
                n3 = 15;
                break;
            }
        }
        return n3;
    }

    private int a2(int n, boolean bl, int n2) {
        int n3 = -1;
        switch (n) {
            case -1302253218: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 29;
                    break;
                }
                n3 = 29;
                break;
            }
            case -867518548: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 28;
                    break;
                }
                n3 = 28;
                break;
            }
            case -220168187: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 31;
                    break;
                }
                n3 = 31;
                break;
            }
            case -136892488: {
                if (bl) {
                    if (n2 != -1691491688) break;
                    n3 = 26;
                    break;
                }
                n3 = 26;
                break;
            }
            case 196890700: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 32;
                    break;
                }
                n3 = 32;
                break;
            }
            case 339680775: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 30;
                    break;
                }
                n3 = 30;
                break;
            }
            case 598678267: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 24;
                    break;
                }
                n3 = 24;
                break;
            }
            case 815109884: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 25;
                    break;
                }
                n3 = 25;
                break;
            }
            case 871091717: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 23;
                    break;
                }
                n3 = 23;
                break;
            }
            case 1888278295: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 33;
                    break;
                }
                n3 = 33;
                break;
            }
            case 2128411881: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 27;
                    break;
                }
                n3 = 27;
                break;
            }
        }
        return n3;
    }

    private int a3(int n, boolean bl, int n2) {
        int n3 = -1;
        switch (n) {
            case -2041652918: {
                if (bl) {
                    if (n2 != 1002294946) break;
                    n3 = 44;
                    break;
                }
                n3 = 44;
                break;
            }
            case -1916180716: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 36;
                    break;
                }
                n3 = 36;
                break;
            }
            case -1860947241: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 45;
                    break;
                }
                n3 = 45;
                break;
            }
            case -1486324100: {
                if (bl) {
                    if (n2 != -609092331) break;
                    n3 = 41;
                    break;
                }
                n3 = 41;
                break;
            }
            case -1302253218: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 35;
                    break;
                }
                n3 = 35;
                break;
            }
            case -256355189: {
                if (bl) {
                    if (n2 != 1002294946) break;
                    n3 = 42;
                    break;
                }
                n3 = 42;
                break;
            }
            case -133984053: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 37;
                    break;
                }
                n3 = 37;
                break;
            }
            case 233493981: {
                if (bl) {
                    if (n2 != 206676214) break;
                    n3 = 38;
                    break;
                }
                n3 = 38;
                break;
            }
            case 593181394: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 43;
                    break;
                }
                n3 = 43;
                break;
            }
            case 848812249: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 39;
                    break;
                }
                n3 = 39;
                break;
            }
            case 871091717: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 34;
                    break;
                }
                n3 = 34;
                break;
            }
            case 2056714545: {
                if (bl) {
                    if (n2 != -1153839224) break;
                    n3 = 40;
                    break;
                }
                n3 = 40;
                break;
            }
        }
        return n3;
    }

    private int a4(int n, boolean bl, int n2) {
        int n3 = -1;
        switch (n) {
            case -2041652918: {
                if (bl) {
                    if (n2 != 1002294946) break;
                    n3 = 55;
                    break;
                }
                n3 = 55;
                break;
            }
            case -1916180716: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 48;
                    break;
                }
                n3 = 48;
                break;
            }
            case -1860947241: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 56;
                    break;
                }
                n3 = 56;
                break;
            }
            case -1486324100: {
                if (bl) {
                    if (n2 != -609092331) break;
                    n3 = 52;
                    break;
                }
                n3 = 52;
                break;
            }
            case -1302253218: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 47;
                    break;
                }
                n3 = 47;
                break;
            }
            case -256355189: {
                if (bl) {
                    if (n2 != 1002294946) break;
                    n3 = 53;
                    break;
                }
                n3 = 53;
                break;
            }
            case -133984053: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 49;
                    break;
                }
                n3 = 49;
                break;
            }
            case 233493981: {
                if (bl) {
                    if (n2 != 206676214) break;
                    n3 = 50;
                    break;
                }
                n3 = 50;
                break;
            }
            case 593181394: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 54;
                    break;
                }
                n3 = 54;
                break;
            }
            case 639835193: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 51;
                    break;
                }
                n3 = 51;
                break;
            }
            case 871091717: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 46;
                    break;
                }
                n3 = 46;
                break;
            }
        }
        return n3;
    }

    private int a5(int n, boolean bl, int n2) {
        int n3 = -1;
        switch (n) {
            case -2041652918: {
                if (bl) {
                    if (n2 != 1002294946) break;
                    n3 = 66;
                    break;
                }
                n3 = 66;
                break;
            }
            case -1916180716: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 59;
                    break;
                }
                n3 = 59;
                break;
            }
            case -1860947241: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 67;
                    break;
                }
                n3 = 67;
                break;
            }
            case -1486324100: {
                if (bl) {
                    if (n2 != -609092331) break;
                    n3 = 63;
                    break;
                }
                n3 = 63;
                break;
            }
            case -1302253218: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 58;
                    break;
                }
                n3 = 58;
                break;
            }
            case -256355189: {
                if (bl) {
                    if (n2 != 1002294946) break;
                    n3 = 64;
                    break;
                }
                n3 = 64;
                break;
            }
            case -133984053: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 60;
                    break;
                }
                n3 = 60;
                break;
            }
            case 233493981: {
                if (bl) {
                    if (n2 != 206676214) break;
                    n3 = 61;
                    break;
                }
                n3 = 61;
                break;
            }
            case 593181394: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 65;
                    break;
                }
                n3 = 65;
                break;
            }
            case 657295293: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 62;
                    break;
                }
                n3 = 62;
                break;
            }
            case 871091717: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 57;
                    break;
                }
                n3 = 57;
                break;
            }
        }
        return n3;
    }

    private int a6(int n, boolean bl, int n2) {
        int n3 = -1;
        switch (n) {
            case -2041652918: {
                if (bl) {
                    if (n2 != 1002294946) break;
                    n3 = 76;
                    break;
                }
                n3 = 76;
                break;
            }
            case -1916180716: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 70;
                    break;
                }
                n3 = 70;
                break;
            }
            case -1860947241: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 77;
                    break;
                }
                n3 = 77;
                break;
            }
            case -1486324100: {
                if (bl) {
                    if (n2 != -609092331) break;
                    n3 = 73;
                    break;
                }
                n3 = 73;
                break;
            }
            case -1302253218: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 69;
                    break;
                }
                n3 = 69;
                break;
            }
            case -256355189: {
                if (bl) {
                    if (n2 != 1002294946) break;
                    n3 = 74;
                    break;
                }
                n3 = 74;
                break;
            }
            case -133984053: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 71;
                    break;
                }
                n3 = 71;
                break;
            }
            case 233493981: {
                if (bl) {
                    if (n2 != 206676214) break;
                    n3 = 72;
                    break;
                }
                n3 = 72;
                break;
            }
            case 593181394: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 75;
                    break;
                }
                n3 = 75;
                break;
            }
            case 871091717: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 68;
                    break;
                }
                n3 = 68;
                break;
            }
        }
        return n3;
    }

    private int a7(int n, boolean bl, int n2) {
        int n3 = -1;
        switch (n) {
            case -2041652918: {
                if (bl) {
                    if (n2 != 1002294946) break;
                    n3 = 86;
                    break;
                }
                n3 = 86;
                break;
            }
            case -1916180716: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 80;
                    break;
                }
                n3 = 80;
                break;
            }
            case -1860947241: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 87;
                    break;
                }
                n3 = 87;
                break;
            }
            case -1486324100: {
                if (bl) {
                    if (n2 != -609092331) break;
                    n3 = 83;
                    break;
                }
                n3 = 83;
                break;
            }
            case -1302253218: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 79;
                    break;
                }
                n3 = 79;
                break;
            }
            case -256355189: {
                if (bl) {
                    if (n2 != 1002294946) break;
                    n3 = 84;
                    break;
                }
                n3 = 84;
                break;
            }
            case -133984053: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 81;
                    break;
                }
                n3 = 81;
                break;
            }
            case 233493981: {
                if (bl) {
                    if (n2 != 206676214) break;
                    n3 = 82;
                    break;
                }
                n3 = 82;
                break;
            }
            case 593181394: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 85;
                    break;
                }
                n3 = 85;
                break;
            }
            case 871091717: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 78;
                    break;
                }
                n3 = 78;
                break;
            }
        }
        return n3;
    }

    private int a8(int n, boolean bl, int n2) {
        int n3 = -1;
        switch (n) {
            case -2041652918: {
                if (bl) {
                    if (n2 != 1002294946) break;
                    n3 = 96;
                    break;
                }
                n3 = 96;
                break;
            }
            case -1916180716: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 90;
                    break;
                }
                n3 = 90;
                break;
            }
            case -1860947241: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 97;
                    break;
                }
                n3 = 97;
                break;
            }
            case -1486324100: {
                if (bl) {
                    if (n2 != -609092331) break;
                    n3 = 93;
                    break;
                }
                n3 = 93;
                break;
            }
            case -1302253218: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 89;
                    break;
                }
                n3 = 89;
                break;
            }
            case -256355189: {
                if (bl) {
                    if (n2 != 1002294946) break;
                    n3 = 94;
                    break;
                }
                n3 = 94;
                break;
            }
            case -133984053: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 91;
                    break;
                }
                n3 = 91;
                break;
            }
            case 233493981: {
                if (bl) {
                    if (n2 != 206676214) break;
                    n3 = 92;
                    break;
                }
                n3 = 92;
                break;
            }
            case 593181394: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 95;
                    break;
                }
                n3 = 95;
                break;
            }
            case 871091717: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 88;
                    break;
                }
                n3 = 88;
                break;
            }
        }
        return n3;
    }

    private int a9(int n, boolean bl, int n2) {
        int n3 = -1;
        switch (n) {
            case -2041652918: {
                if (bl) {
                    if (n2 != 1002294946) break;
                    n3 = 106;
                    break;
                }
                n3 = 106;
                break;
            }
            case -1916180716: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 100;
                    break;
                }
                n3 = 100;
                break;
            }
            case -1860947241: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 107;
                    break;
                }
                n3 = 107;
                break;
            }
            case -1486324100: {
                if (bl) {
                    if (n2 != -609092331) break;
                    n3 = 103;
                    break;
                }
                n3 = 103;
                break;
            }
            case -1302253218: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 99;
                    break;
                }
                n3 = 99;
                break;
            }
            case -256355189: {
                if (bl) {
                    if (n2 != 1002294946) break;
                    n3 = 104;
                    break;
                }
                n3 = 104;
                break;
            }
            case -133984053: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 101;
                    break;
                }
                n3 = 101;
                break;
            }
            case 233493981: {
                if (bl) {
                    if (n2 != 206676214) break;
                    n3 = 102;
                    break;
                }
                n3 = 102;
                break;
            }
            case 593181394: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 105;
                    break;
                }
                n3 = 105;
                break;
            }
            case 871091717: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 98;
                    break;
                }
                n3 = 98;
                break;
            }
        }
        return n3;
    }

    private int a10(int n, boolean bl, int n2) {
        int n3 = -1;
        switch (n) {
            case -2041652918: {
                if (bl) {
                    if (n2 != 1002294946) break;
                    n3 = 117;
                    break;
                }
                n3 = 117;
                break;
            }
            case -1916180716: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 110;
                    break;
                }
                n3 = 110;
                break;
            }
            case -1860947241: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 118;
                    break;
                }
                n3 = 118;
                break;
            }
            case -1486324100: {
                if (bl) {
                    if (n2 != -609092331) break;
                    n3 = 114;
                    break;
                }
                n3 = 114;
                break;
            }
            case -1302253218: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 109;
                    break;
                }
                n3 = 109;
                break;
            }
            case -508146444: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 113;
                    break;
                }
                n3 = 113;
                break;
            }
            case -256355189: {
                if (bl) {
                    if (n2 != 1002294946) break;
                    n3 = 115;
                    break;
                }
                n3 = 115;
                break;
            }
            case -133984053: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 111;
                    break;
                }
                n3 = 111;
                break;
            }
            case 233493981: {
                if (bl) {
                    if (n2 != 206676214) break;
                    n3 = 112;
                    break;
                }
                n3 = 112;
                break;
            }
            case 593181394: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 116;
                    break;
                }
                n3 = 116;
                break;
            }
            case 871091717: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 108;
                    break;
                }
                n3 = 108;
                break;
            }
        }
        return n3;
    }

    private int a11(int n, boolean bl, int n2) {
        int n3 = -1;
        switch (n) {
            case -2041652918: {
                if (bl) {
                    if (n2 != 1002294946) break;
                    n3 = 128;
                    break;
                }
                n3 = 128;
                break;
            }
            case -1916180716: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 121;
                    break;
                }
                n3 = 121;
                break;
            }
            case -1860947241: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 129;
                    break;
                }
                n3 = 129;
                break;
            }
            case -1486324100: {
                if (bl) {
                    if (n2 != -609092331) break;
                    n3 = 125;
                    break;
                }
                n3 = 125;
                break;
            }
            case -1302253218: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 120;
                    break;
                }
                n3 = 120;
                break;
            }
            case -1098736802: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 124;
                    break;
                }
                n3 = 124;
                break;
            }
            case -256355189: {
                if (bl) {
                    if (n2 != 1002294946) break;
                    n3 = 126;
                    break;
                }
                n3 = 126;
                break;
            }
            case -133984053: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 122;
                    break;
                }
                n3 = 122;
                break;
            }
            case 233493981: {
                if (bl) {
                    if (n2 != 206676214) break;
                    n3 = 123;
                    break;
                }
                n3 = 123;
                break;
            }
            case 593181394: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 127;
                    break;
                }
                n3 = 127;
                break;
            }
            case 871091717: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 119;
                    break;
                }
                n3 = 119;
                break;
            }
        }
        return n3;
    }

    private int a12(int n, boolean bl, int n2) {
        int n3 = -1;
        switch (n) {
            case -1302253218: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 136;
                    break;
                }
                n3 = 136;
                break;
            }
            case -867518548: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 135;
                    break;
                }
                n3 = 135;
                break;
            }
            case -220168187: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 138;
                    break;
                }
                n3 = 138;
                break;
            }
            case -136892488: {
                if (bl) {
                    if (n2 != -1691491688) break;
                    n3 = 133;
                    break;
                }
                n3 = 133;
                break;
            }
            case 196890700: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 139;
                    break;
                }
                n3 = 139;
                break;
            }
            case 339680775: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 137;
                    break;
                }
                n3 = 137;
                break;
            }
            case 598678267: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 131;
                    break;
                }
                n3 = 131;
                break;
            }
            case 815109884: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 132;
                    break;
                }
                n3 = 132;
                break;
            }
            case 871091717: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 130;
                    break;
                }
                n3 = 130;
                break;
            }
            case 1888278295: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 140;
                    break;
                }
                n3 = 140;
                break;
            }
            case 2128411881: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 134;
                    break;
                }
                n3 = 134;
                break;
            }
        }
        return n3;
    }

    private int a13(int n, boolean bl, int n2) {
        int n3 = -1;
        switch (n) {
            case -2041652918: {
                if (bl) {
                    if (n2 != 1002294946) break;
                    n3 = 152;
                    break;
                }
                n3 = 152;
                break;
            }
            case -1916180716: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 143;
                    break;
                }
                n3 = 143;
                break;
            }
            case -1860947241: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 153;
                    break;
                }
                n3 = 153;
                break;
            }
            case -1486324100: {
                if (bl) {
                    if (n2 != -609092331) break;
                    n3 = 149;
                    break;
                }
                n3 = 149;
                break;
            }
            case -1302253218: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 142;
                    break;
                }
                n3 = 142;
                break;
            }
            case -867518548: {
                if (bl) {
                    if (n2 != -1787145843) break;
                    n3 = 150;
                    break;
                }
                n3 = 150;
                break;
            }
            case -256355189: {
                if (bl) {
                    if (n2 != 1002294946) break;
                    n3 = 144;
                    break;
                }
                n3 = 144;
                break;
            }
            case -133984053: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 145;
                    break;
                }
                n3 = 145;
                break;
            }
            case 340825919: {
                if (bl) {
                    if (n2 != 1982140297) break;
                    n3 = 147;
                    break;
                }
                n3 = 147;
                break;
            }
            case 593181394: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 151;
                    break;
                }
                n3 = 151;
                break;
            }
            case 666357972: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 148;
                    break;
                }
                n3 = 148;
                break;
            }
            case 807225688: {
                if (bl) {
                    if (n2 != -1775495539) break;
                    n3 = 146;
                    break;
                }
                n3 = 146;
                break;
            }
            case 871091717: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 141;
                    break;
                }
                n3 = 141;
                break;
            }
        }
        return n3;
    }

    private int a14(int n, boolean bl, int n2) {
        int n3 = -1;
        switch (n) {
            case -2041652918: {
                if (bl) {
                    if (n2 != 1002294946) break;
                    n3 = 166;
                    break;
                }
                n3 = 166;
                break;
            }
            case -1916180716: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 156;
                    break;
                }
                n3 = 156;
                break;
            }
            case -1860947241: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 167;
                    break;
                }
                n3 = 167;
                break;
            }
            case -1486324100: {
                if (bl) {
                    if (n2 != -609092331) break;
                    n3 = 162;
                    break;
                }
                n3 = 162;
                break;
            }
            case -1302253218: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 155;
                    break;
                }
                n3 = 155;
                break;
            }
            case -867518548: {
                if (bl) {
                    if (n2 != -1787145843) break;
                    n3 = 163;
                    break;
                }
                n3 = 163;
                break;
            }
            case -431910040: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 159;
                    break;
                }
                n3 = 159;
                break;
            }
            case -324189484: {
                if (bl) {
                    if (n2 != 112814951) break;
                    n3 = 160;
                    break;
                }
                n3 = 160;
                break;
            }
            case -256355189: {
                if (bl) {
                    if (n2 != 1002294946) break;
                    n3 = 164;
                    break;
                }
                n3 = 164;
                break;
            }
            case -133984053: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 157;
                    break;
                }
                n3 = 157;
                break;
            }
            case 340825919: {
                if (bl) {
                    if (n2 != 1982140297) break;
                    n3 = 168;
                    break;
                }
                n3 = 168;
                break;
            }
            case 593181394: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 165;
                    break;
                }
                n3 = 165;
                break;
            }
            case 807225688: {
                if (bl) {
                    if (n2 != -1775495539) break;
                    n3 = 158;
                    break;
                }
                n3 = 158;
                break;
            }
            case 871091717: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 154;
                    break;
                }
                n3 = 154;
                break;
            }
            case 1204057937: {
                if (bl) {
                    if (n2 != 2063385576) break;
                    n3 = 161;
                    break;
                }
                n3 = 161;
                break;
            }
            case 1638047518: {
                if (bl) {
                    if (n2 != -1540193498) break;
                    n3 = 169;
                    break;
                }
                n3 = 169;
                break;
            }
        }
        return n3;
    }

    private int a15(int n, boolean bl, int n2) {
        int n3 = -1;
        switch (n) {
            case -2041652918: {
                if (bl) {
                    if (n2 != 1002294946) break;
                    n3 = 179;
                    break;
                }
                n3 = 179;
                break;
            }
            case -1916180716: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 172;
                    break;
                }
                n3 = 172;
                break;
            }
            case -1860947241: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 180;
                    break;
                }
                n3 = 180;
                break;
            }
            case -1486324100: {
                if (bl) {
                    if (n2 != -609092331) break;
                    n3 = 175;
                    break;
                }
                n3 = 175;
                break;
            }
            case -1302253218: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 171;
                    break;
                }
                n3 = 171;
                break;
            }
            case -867518548: {
                if (bl) {
                    if (n2 != -1787145843) break;
                    n3 = 176;
                    break;
                }
                n3 = 176;
                break;
            }
            case -256355189: {
                if (bl) {
                    if (n2 != 1002294946) break;
                    n3 = 177;
                    break;
                }
                n3 = 177;
                break;
            }
            case -133984053: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 173;
                    break;
                }
                n3 = 173;
                break;
            }
            case 340825919: {
                if (bl) {
                    if (n2 != 1982140297) break;
                    n3 = 181;
                    break;
                }
                n3 = 181;
                break;
            }
            case 593181394: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 178;
                    break;
                }
                n3 = 178;
                break;
            }
            case 807225688: {
                if (bl) {
                    if (n2 != -1775495539) break;
                    n3 = 174;
                    break;
                }
                n3 = 174;
                break;
            }
            case 871091717: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 170;
                    break;
                }
                n3 = 170;
                break;
            }
        }
        return n3;
    }

    private int a16(int n, boolean bl, int n2) {
        int n3 = -1;
        switch (n) {
            case -2041652918: {
                if (bl) {
                    if (n2 != 1002294946) break;
                    n3 = 193;
                    break;
                }
                n3 = 193;
                break;
            }
            case -1916180716: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 184;
                    break;
                }
                n3 = 184;
                break;
            }
            case -1860947241: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 194;
                    break;
                }
                n3 = 194;
                break;
            }
            case -1486324100: {
                if (bl) {
                    if (n2 != -609092331) break;
                    n3 = 189;
                    break;
                }
                n3 = 189;
                break;
            }
            case -1302253218: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 183;
                    break;
                }
                n3 = 183;
                break;
            }
            case -867518548: {
                if (bl) {
                    if (n2 != -1787145843) break;
                    n3 = 190;
                    break;
                }
                n3 = 190;
                break;
            }
            case -256355189: {
                if (bl) {
                    if (n2 != 1002294946) break;
                    n3 = 191;
                    break;
                }
                n3 = 191;
                break;
            }
            case -133984053: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 185;
                    break;
                }
                n3 = 185;
                break;
            }
            case 340825919: {
                if (bl) {
                    if (n2 != 1982140297) break;
                    n3 = 187;
                    break;
                }
                n3 = 187;
                break;
            }
            case 593181394: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 192;
                    break;
                }
                n3 = 192;
                break;
            }
            case 666357972: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 188;
                    break;
                }
                n3 = 188;
                break;
            }
            case 807225688: {
                if (bl) {
                    if (n2 != -1775495539) break;
                    n3 = 186;
                    break;
                }
                n3 = 186;
                break;
            }
            case 871091717: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 182;
                    break;
                }
                n3 = 182;
                break;
            }
        }
        return n3;
    }

    private int a17(int n, boolean bl, int n2) {
        int n3 = -1;
        switch (n) {
            case -2041652918: {
                if (bl) {
                    if (n2 != 1002294946) break;
                    n3 = 209;
                    break;
                }
                n3 = 209;
                break;
            }
            case -1916180716: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 197;
                    break;
                }
                n3 = 197;
                break;
            }
            case -1860947241: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 210;
                    break;
                }
                n3 = 210;
                break;
            }
            case -1486324100: {
                if (bl) {
                    if (n2 != -609092331) break;
                    n3 = 206;
                    break;
                }
                n3 = 206;
                break;
            }
            case -1302253218: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 196;
                    break;
                }
                n3 = 196;
                break;
            }
            case -867518548: {
                if (bl) {
                    if (n2 != -1787145843) break;
                    n3 = 207;
                    break;
                }
                n3 = 207;
                break;
            }
            case -431910040: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 202;
                    break;
                }
                n3 = 202;
                break;
            }
            case -324189484: {
                if (bl) {
                    if (n2 != 112814951) break;
                    n3 = 203;
                    break;
                }
                n3 = 203;
                break;
            }
            case -256355189: {
                if (bl) {
                    if (n2 != 1002294946) break;
                    n3 = 198;
                    break;
                }
                n3 = 198;
                break;
            }
            case -133984053: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 199;
                    break;
                }
                n3 = 199;
                break;
            }
            case 209698840: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 204;
                    break;
                }
                n3 = 204;
                break;
            }
            case 340825919: {
                if (bl) {
                    if (n2 != 1982140297) break;
                    n3 = 211;
                    break;
                }
                n3 = 211;
                break;
            }
            case 593181394: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 208;
                    break;
                }
                n3 = 208;
                break;
            }
            case 807225688: {
                if (bl) {
                    if (n2 != -1775495539) break;
                    n3 = 200;
                    break;
                }
                n3 = 200;
                break;
            }
            case 871091717: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 195;
                    break;
                }
                n3 = 195;
                break;
            }
            case 1638047518: {
                if (bl) {
                    if (n2 != -1540193498) break;
                    n3 = 212;
                    break;
                }
                n3 = 212;
                break;
            }
            case 2055672959: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 205;
                    break;
                }
                n3 = 205;
                break;
            }
            case 2104300916: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 201;
                    break;
                }
                n3 = 201;
                break;
            }
        }
        return n3;
    }

    private int a18(int n, boolean bl, int n2) {
        int n3 = -1;
        switch (n) {
            case -2041652918: {
                if (bl) {
                    if (n2 != 1002294946) break;
                    n3 = 224;
                    break;
                }
                n3 = 224;
                break;
            }
            case -1916180716: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 215;
                    break;
                }
                n3 = 215;
                break;
            }
            case -1860947241: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 225;
                    break;
                }
                n3 = 225;
                break;
            }
            case -1486324100: {
                if (bl) {
                    if (n2 != -609092331) break;
                    n3 = 220;
                    break;
                }
                n3 = 220;
                break;
            }
            case -1302253218: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 214;
                    break;
                }
                n3 = 214;
                break;
            }
            case -867518548: {
                if (bl) {
                    if (n2 != -1787145843) break;
                    n3 = 221;
                    break;
                }
                n3 = 221;
                break;
            }
            case -256355189: {
                if (bl) {
                    if (n2 != 1002294946) break;
                    n3 = 222;
                    break;
                }
                n3 = 222;
                break;
            }
            case -133984053: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 216;
                    break;
                }
                n3 = 216;
                break;
            }
            case 340825919: {
                if (bl) {
                    if (n2 != 1982140297) break;
                    n3 = 218;
                    break;
                }
                n3 = 218;
                break;
            }
            case 593181394: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 223;
                    break;
                }
                n3 = 223;
                break;
            }
            case 666357972: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 219;
                    break;
                }
                n3 = 219;
                break;
            }
            case 807225688: {
                if (bl) {
                    if (n2 != -1775495539) break;
                    n3 = 217;
                    break;
                }
                n3 = 217;
                break;
            }
            case 871091717: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 213;
                    break;
                }
                n3 = 213;
                break;
            }
        }
        return n3;
    }

    private int a19(int n, boolean bl, int n2) {
        int n3 = -1;
        switch (n) {
            case -2041652918: {
                if (bl) {
                    if (n2 != 1002294946) break;
                    n3 = 241;
                    break;
                }
                n3 = 241;
                break;
            }
            case -1916180716: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 228;
                    break;
                }
                n3 = 228;
                break;
            }
            case -1860947241: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 242;
                    break;
                }
                n3 = 242;
                break;
            }
            case -1486324100: {
                if (bl) {
                    if (n2 != -609092331) break;
                    n3 = 238;
                    break;
                }
                n3 = 238;
                break;
            }
            case -1302253218: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 227;
                    break;
                }
                n3 = 227;
                break;
            }
            case -867518548: {
                if (bl) {
                    if (n2 != -1787145843) break;
                    n3 = 239;
                    break;
                }
                n3 = 239;
                break;
            }
            case -431910040: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 233;
                    break;
                }
                n3 = 233;
                break;
            }
            case -324189484: {
                if (bl) {
                    if (n2 != 112814951) break;
                    n3 = 234;
                    break;
                }
                n3 = 234;
                break;
            }
            case -256355189: {
                if (bl) {
                    if (n2 != 1002294946) break;
                    n3 = 229;
                    break;
                }
                n3 = 229;
                break;
            }
            case -133984053: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 230;
                    break;
                }
                n3 = 230;
                break;
            }
            case 209698840: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 236;
                    break;
                }
                n3 = 236;
                break;
            }
            case 340825919: {
                if (bl) {
                    if (n2 != 1982140297) break;
                    n3 = 243;
                    break;
                }
                n3 = 243;
                break;
            }
            case 593181394: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 240;
                    break;
                }
                n3 = 240;
                break;
            }
            case 807225688: {
                if (bl) {
                    if (n2 != -1775495539) break;
                    n3 = 231;
                    break;
                }
                n3 = 231;
                break;
            }
            case 871091717: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 226;
                    break;
                }
                n3 = 226;
                break;
            }
            case 1204057937: {
                if (bl) {
                    if (n2 != 2063385576) break;
                    n3 = 235;
                    break;
                }
                n3 = 235;
                break;
            }
            case 1638047518: {
                if (bl) {
                    if (n2 != -1540193498) break;
                    n3 = 244;
                    break;
                }
                n3 = 244;
                break;
            }
            case 2055672959: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 237;
                    break;
                }
                n3 = 237;
                break;
            }
            case 2104300916: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 232;
                    break;
                }
                n3 = 232;
                break;
            }
        }
        return n3;
    }

    private int a20(int n, boolean bl, int n2) {
        int n3 = -1;
        switch (n) {
            case -2041652918: {
                if (bl) {
                    if (n2 != 1002294946) break;
                    n3 = 254;
                    break;
                }
                n3 = 254;
                break;
            }
            case -1916180716: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 247;
                    break;
                }
                n3 = 247;
                break;
            }
            case -1860947241: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 255;
                    break;
                }
                n3 = 255;
                break;
            }
            case -1486324100: {
                if (bl) {
                    if (n2 != -609092331) break;
                    n3 = 250;
                    break;
                }
                n3 = 250;
                break;
            }
            case -1302253218: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 246;
                    break;
                }
                n3 = 246;
                break;
            }
            case -867518548: {
                if (bl) {
                    if (n2 != -1787145843) break;
                    n3 = 251;
                    break;
                }
                n3 = 251;
                break;
            }
            case -256355189: {
                if (bl) {
                    if (n2 != 1002294946) break;
                    n3 = 252;
                    break;
                }
                n3 = 252;
                break;
            }
            case -133984053: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 248;
                    break;
                }
                n3 = 248;
                break;
            }
            case 340825919: {
                if (bl) {
                    if (n2 != 1982140297) break;
                    n3 = 256;
                    break;
                }
                n3 = 256;
                break;
            }
            case 593181394: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 253;
                    break;
                }
                n3 = 253;
                break;
            }
            case 807225688: {
                if (bl) {
                    if (n2 != -1775495539) break;
                    n3 = 249;
                    break;
                }
                n3 = 249;
                break;
            }
            case 871091717: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 245;
                    break;
                }
                n3 = 245;
                break;
            }
        }
        return n3;
    }

    private int a21(int n, boolean bl, int n2) {
        int n3 = -1;
        switch (n) {
            case -2041652918: {
                if (bl) {
                    if (n2 != 1002294946) break;
                    n3 = 270;
                    break;
                }
                n3 = 270;
                break;
            }
            case -1963686292: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 266;
                    break;
                }
                n3 = 266;
                break;
            }
            case -1916180716: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 259;
                    break;
                }
                n3 = 259;
                break;
            }
            case -1860947241: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 271;
                    break;
                }
                n3 = 271;
                break;
            }
            case -1486324100: {
                if (bl) {
                    if (n2 != -609092331) break;
                    n3 = 267;
                    break;
                }
                n3 = 267;
                break;
            }
            case -1302253218: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 258;
                    break;
                }
                n3 = 258;
                break;
            }
            case -867518548: {
                if (bl) {
                    if (n2 != -1787145843) break;
                    n3 = 268;
                    break;
                }
                n3 = 268;
                break;
            }
            case -256355189: {
                if (bl) {
                    if (n2 != 1002294946) break;
                    n3 = 260;
                    break;
                }
                n3 = 260;
                break;
            }
            case -133984053: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 261;
                    break;
                }
                n3 = 261;
                break;
            }
            case 209698840: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 264;
                    break;
                }
                n3 = 264;
                break;
            }
            case 340825919: {
                if (bl) {
                    if (n2 != 1982140297) break;
                    n3 = 272;
                    break;
                }
                n3 = 272;
                break;
            }
            case 593181394: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 269;
                    break;
                }
                n3 = 269;
                break;
            }
            case 807225688: {
                if (bl) {
                    if (n2 != -1775495539) break;
                    n3 = 262;
                    break;
                }
                n3 = 262;
                break;
            }
            case 871091717: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 257;
                    break;
                }
                n3 = 257;
                break;
            }
            case 1204057937: {
                if (bl) {
                    if (n2 != 2063385576) break;
                    n3 = 263;
                    break;
                }
                n3 = 263;
                break;
            }
            case 1638047518: {
                if (bl) {
                    if (n2 != -1540193498) break;
                    n3 = 273;
                    break;
                }
                n3 = 273;
                break;
            }
            case 2055672959: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 265;
                    break;
                }
                n3 = 265;
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
            case -1871256313: {
                n2 = this.a8(n4, bl, n);
                break;
            }
            case -1612471155: {
                n2 = this.a6(n4, bl, n);
                break;
            }
            case -1229753613: {
                n2 = this.a10(n4, bl, n);
                break;
            }
            case -1212355381: {
                n2 = this.a5(n4, bl, n);
                break;
            }
            case -1165053213: {
                n2 = this.a2(n4, bl, n);
                break;
            }
            case -951571326: {
                n2 = this.a18(n4, bl, n);
                break;
            }
            case -932080992: {
                n2 = this.a21(n4, bl, n);
                break;
            }
            case -682170031: {
                n2 = this.a4(n4, bl, n);
                break;
            }
            case -456288181: {
                n2 = this.a9(n4, bl, n);
                break;
            }
            case -422588316: {
                n2 = this.a1(n4, bl, n);
                break;
            }
            case -234539588: {
                n2 = this.a13(n4, bl, n);
                break;
            }
            case -136535873: {
                n2 = this.a20(n4, bl, n);
                break;
            }
            case 356690787: {
                n2 = this.a19(n4, bl, n);
                break;
            }
            case 651208912: {
                n2 = this.a12(n4, bl, n);
                break;
            }
            case 737907256: {
                n2 = this.a15(n4, bl, n);
                break;
            }
            case 747407388: {
                n2 = this.a16(n4, bl, n);
                break;
            }
            case 845666973: {
                n2 = this.a14(n4, bl, n);
                break;
            }
            case 1343870390: {
                n2 = this.a11(n4, bl, n);
                break;
            }
            case 1448971121: {
                n2 = this.a3(n4, bl, n);
                break;
            }
            case 1759889315: {
                n2 = this.a0(n4, bl, n);
                break;
            }
            case 2013237655: {
                n2 = this.a7(n4, bl, n);
                break;
            }
            case 2066140413: {
                n2 = this.a17(n4, bl, n);
                break;
            }
        }
        return n2;
    }

    private Object f0(int n, Object object, Object[] objectArray) {
        switch (n) {
            case 0: {
                ((KombiViewController)object).initialize();
                return null;
            }
            case 1: {
                return ((KombiViewController)object).getLogger();
            }
            case 2: {
                return ((KombiViewController)object).getTarget();
            }
            case 3: {
                ((KombiViewController)object).setControllerDelegate((ControllerDelegate)objectArray[0]);
                return null;
            }
            case 4: {
                return ((KombiViewController)object).getCategory(((Number)objectArray[0]).intValue());
            }
            case 5: {
                return ((KombiViewController)object).getSequence(((Number)objectArray[0]).intValue());
            }
            case 6: {
                ((KombiViewController)object).uninitialize();
                return null;
            }
            case 7: {
                return ((KombiViewController)object).getController();
            }
            case 8: {
                return ((KombiViewController)object).getServiceProvider();
            }
            case 9: {
                return ((KombiViewController)object).findCategory(((Number)objectArray[0]).intValue());
            }
            case 10: {
                return ((KombiViewController)object).getDsiServiceProvider();
            }
            case 11: {
                ((MostKombiMasterController)object).initialize();
                return null;
            }
            case 12: {
                return ((MostKombiMasterController)object).getLogger();
            }
            case 13: {
                return ((MostKombiMasterController)object).getTarget();
            }
            case 14: {
                ((MostKombiMasterController)object).setControllerDelegate((ControllerDelegate)objectArray[0]);
                return null;
            }
            case 15: {
                return ((MostKombiMasterController)object).getCategory((Controller)objectArray[0], ((Number)objectArray[1]).intValue());
            }
            case 16: {
                return ((MostKombiMasterController)object).getCategory(((Number)objectArray[0]).intValue());
            }
            case 17: {
                return ((MostKombiMasterController)object).getSequence(((Number)objectArray[0]).intValue());
            }
            case 18: {
                ((MostKombiMasterController)object).uninitialize();
                return null;
            }
            case 19: {
                return ((MostKombiMasterController)object).getController();
            }
            case 20: {
                return ((MostKombiMasterController)object).getServiceProvider();
            }
            case 21: {
                return ((MostKombiMasterController)object).getDsiServiceProvider();
            }
            case 22: {
                ((MostKombiMasterController)object).addStartedKombiController((Controller)objectArray[0]);
                return null;
            }
            case 23: {
                ((NavInfoController)object).initialize();
                return null;
            }
            case 24: {
                return ((NavInfoController)object).getLogger();
            }
            case 25: {
                return ((NavInfoController)object).getTarget();
            }
            case 26: {
                ((NavInfoController)object).setControllerDelegate((ControllerDelegate)objectArray[0]);
                return null;
            }
            case 27: {
                return ((NavInfoController)object).getCategory(((Number)objectArray[0]).intValue());
            }
            case 28: {
                return ((NavInfoController)object).getSequence(((Number)objectArray[0]).intValue());
            }
            case 29: {
                ((NavInfoController)object).uninitialize();
                return null;
            }
            case 30: {
                return ((NavInfoController)object).getController();
            }
            case 31: {
                return ((NavInfoController)object).getServiceProvider();
            }
        }
        return null;
    }

    private Object f1(int n, Object object, Object[] objectArray) {
        switch (n) {
            case 32: {
                return ((NavInfoController)object).findCategory(((Number)objectArray[0]).intValue());
            }
            case 33: {
                return ((NavInfoController)object).getDsiServiceProvider();
            }
            case 34: {
                ((Capabilities)object).initialize();
                return null;
            }
            case 35: {
                ((Capabilities)object).uninitialize();
                return null;
            }
            case 36: {
                return RuntimeUtil.valueOf(((Capabilities)object).getIdentifier());
            }
            case 37: {
                ((Capabilities)object).executeSequence();
                return null;
            }
            case 38: {
                ((Capabilities)object).updateNavInfo((NavInfoService)objectArray[0], ((Number)objectArray[1]).intValue(), objectArray[2]);
                return null;
            }
            case 39: {
                ((Capabilities)object).dsiKOMONavInfoSetCapabilitiesResult(((Number)objectArray[0]).intValue());
                return null;
            }
            case 40: {
                ((Capabilities)object).updateAdaptation((AdaptationService)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 41: {
                ((Capabilities)object).setDelegate((CategoryDelegate)objectArray[0]);
                return null;
            }
            case 42: {
                ((Capabilities)object).appendToSequence((SequenceDelegate)objectArray[0]);
                return null;
            }
            case 43: {
                return RuntimeUtil.valueOf(((Capabilities)object).isPartOfOtherSequence());
            }
            case 44: {
                return RuntimeUtil.valueOf(((Capabilities)object).isPartOfSequence((SequenceDelegate)objectArray[0]));
            }
            case 45: {
                return ((Capabilities)object).getSequenceName();
            }
            case 46: {
                ((CityName)object).initialize();
                return null;
            }
            case 47: {
                ((CityName)object).uninitialize();
                return null;
            }
            case 48: {
                return RuntimeUtil.valueOf(((CityName)object).getIdentifier());
            }
            case 49: {
                ((CityName)object).executeSequence();
                return null;
            }
            case 50: {
                ((CityName)object).updateNavInfo((NavInfoService)objectArray[0], ((Number)objectArray[1]).intValue(), objectArray[2]);
                return null;
            }
            case 51: {
                ((CityName)object).dsiKOMONavInfoSetCityNameResult(((Number)objectArray[0]).intValue());
                return null;
            }
            case 52: {
                ((CityName)object).setDelegate((CategoryDelegate)objectArray[0]);
                return null;
            }
            case 53: {
                ((CityName)object).appendToSequence((SequenceDelegate)objectArray[0]);
                return null;
            }
            case 54: {
                return RuntimeUtil.valueOf(((CityName)object).isPartOfOtherSequence());
            }
            case 55: {
                return RuntimeUtil.valueOf(((CityName)object).isPartOfSequence((SequenceDelegate)objectArray[0]));
            }
            case 56: {
                return ((CityName)object).getSequenceName();
            }
            case 57: {
                ((CurrentStreet)object).initialize();
                return null;
            }
            case 58: {
                ((CurrentStreet)object).uninitialize();
                return null;
            }
            case 59: {
                return RuntimeUtil.valueOf(((CurrentStreet)object).getIdentifier());
            }
            case 60: {
                ((CurrentStreet)object).executeSequence();
                return null;
            }
            case 61: {
                ((CurrentStreet)object).updateNavInfo((NavInfoService)objectArray[0], ((Number)objectArray[1]).intValue(), objectArray[2]);
                return null;
            }
            case 62: {
                ((CurrentStreet)object).dsiKOMONavInfoSetCurrentStreetResult(((Number)objectArray[0]).intValue());
                return null;
            }
            case 63: {
                ((CurrentStreet)object).setDelegate((CategoryDelegate)objectArray[0]);
                return null;
            }
        }
        return null;
    }

    private Object f2(int n, Object object, Object[] objectArray) {
        switch (n) {
            case 64: {
                ((CurrentStreet)object).appendToSequence((SequenceDelegate)objectArray[0]);
                return null;
            }
            case 65: {
                return RuntimeUtil.valueOf(((CurrentStreet)object).isPartOfOtherSequence());
            }
            case 66: {
                return RuntimeUtil.valueOf(((CurrentStreet)object).isPartOfSequence((SequenceDelegate)objectArray[0]));
            }
            case 67: {
                return ((CurrentStreet)object).getSequenceName();
            }
            case 68: {
                ((DistanceToDestination)object).initialize();
                return null;
            }
            case 69: {
                ((DistanceToDestination)object).uninitialize();
                return null;
            }
            case 70: {
                return RuntimeUtil.valueOf(((DistanceToDestination)object).getIdentifier());
            }
            case 71: {
                ((DistanceToDestination)object).executeSequence();
                return null;
            }
            case 72: {
                ((DistanceToDestination)object).updateNavInfo((NavInfoService)objectArray[0], ((Number)objectArray[1]).intValue(), objectArray[2]);
                return null;
            }
            case 73: {
                ((DistanceToDestination)object).setDelegate((CategoryDelegate)objectArray[0]);
                return null;
            }
            case 74: {
                ((DistanceToDestination)object).appendToSequence((SequenceDelegate)objectArray[0]);
                return null;
            }
            case 75: {
                return RuntimeUtil.valueOf(((DistanceToDestination)object).isPartOfOtherSequence());
            }
            case 76: {
                return RuntimeUtil.valueOf(((DistanceToDestination)object).isPartOfSequence((SequenceDelegate)objectArray[0]));
            }
            case 77: {
                return ((DistanceToDestination)object).getSequenceName();
            }
            case 78: {
                ((DistanceToNextManeuver)object).initialize();
                return null;
            }
            case 79: {
                ((DistanceToNextManeuver)object).uninitialize();
                return null;
            }
            case 80: {
                return RuntimeUtil.valueOf(((DistanceToNextManeuver)object).getIdentifier());
            }
            case 81: {
                ((DistanceToNextManeuver)object).executeSequence();
                return null;
            }
            case 82: {
                ((DistanceToNextManeuver)object).updateNavInfo((NavInfoService)objectArray[0], ((Number)objectArray[1]).intValue(), objectArray[2]);
                return null;
            }
            case 83: {
                ((DistanceToNextManeuver)object).setDelegate((CategoryDelegate)objectArray[0]);
                return null;
            }
            case 84: {
                ((DistanceToNextManeuver)object).appendToSequence((SequenceDelegate)objectArray[0]);
                return null;
            }
            case 85: {
                return RuntimeUtil.valueOf(((DistanceToNextManeuver)object).isPartOfOtherSequence());
            }
            case 86: {
                return RuntimeUtil.valueOf(((DistanceToNextManeuver)object).isPartOfSequence((SequenceDelegate)objectArray[0]));
            }
            case 87: {
                return ((DistanceToNextManeuver)object).getSequenceName();
            }
            case 88: {
                ((EstimatedRemainingTripTime)object).initialize();
                return null;
            }
            case 89: {
                ((EstimatedRemainingTripTime)object).uninitialize();
                return null;
            }
            case 90: {
                return RuntimeUtil.valueOf(((EstimatedRemainingTripTime)object).getIdentifier());
            }
            case 91: {
                ((EstimatedRemainingTripTime)object).executeSequence();
                return null;
            }
            case 92: {
                ((EstimatedRemainingTripTime)object).updateNavInfo((NavInfoService)objectArray[0], ((Number)objectArray[1]).intValue(), objectArray[2]);
                return null;
            }
            case 93: {
                ((EstimatedRemainingTripTime)object).setDelegate((CategoryDelegate)objectArray[0]);
                return null;
            }
            case 94: {
                ((EstimatedRemainingTripTime)object).appendToSequence((SequenceDelegate)objectArray[0]);
                return null;
            }
            case 95: {
                return RuntimeUtil.valueOf(((EstimatedRemainingTripTime)object).isPartOfOtherSequence());
            }
        }
        return null;
    }

    private Object f3(int n, Object object, Object[] objectArray) {
        switch (n) {
            case 96: {
                return RuntimeUtil.valueOf(((EstimatedRemainingTripTime)object).isPartOfSequence((SequenceDelegate)objectArray[0]));
            }
            case 97: {
                return ((EstimatedRemainingTripTime)object).getSequenceName();
            }
            case 98: {
                ((EstimatedTimeArrival)object).initialize();
                return null;
            }
            case 99: {
                ((EstimatedTimeArrival)object).uninitialize();
                return null;
            }
            case 100: {
                return RuntimeUtil.valueOf(((EstimatedTimeArrival)object).getIdentifier());
            }
            case 101: {
                ((EstimatedTimeArrival)object).executeSequence();
                return null;
            }
            case 102: {
                ((EstimatedTimeArrival)object).updateNavInfo((NavInfoService)objectArray[0], ((Number)objectArray[1]).intValue(), objectArray[2]);
                return null;
            }
            case 103: {
                ((EstimatedTimeArrival)object).setDelegate((CategoryDelegate)objectArray[0]);
                return null;
            }
            case 104: {
                ((EstimatedTimeArrival)object).appendToSequence((SequenceDelegate)objectArray[0]);
                return null;
            }
            case 105: {
                return RuntimeUtil.valueOf(((EstimatedTimeArrival)object).isPartOfOtherSequence());
            }
            case 106: {
                return RuntimeUtil.valueOf(((EstimatedTimeArrival)object).isPartOfSequence((SequenceDelegate)objectArray[0]));
            }
            case 107: {
                return ((EstimatedTimeArrival)object).getSequenceName();
            }
            case 108: {
                ((RouteGuidanceMode)object).initialize();
                return null;
            }
            case 109: {
                ((RouteGuidanceMode)object).uninitialize();
                return null;
            }
            case 110: {
                return RuntimeUtil.valueOf(((RouteGuidanceMode)object).getIdentifier());
            }
            case 111: {
                ((RouteGuidanceMode)object).executeSequence();
                return null;
            }
            case 112: {
                ((RouteGuidanceMode)object).updateNavInfo((NavInfoService)objectArray[0], ((Number)objectArray[1]).intValue(), objectArray[2]);
                return null;
            }
            case 113: {
                ((RouteGuidanceMode)object).dsiKOMONavInfoSetRgSelectResult(((Number)objectArray[0]).intValue());
                return null;
            }
            case 114: {
                ((RouteGuidanceMode)object).setDelegate((CategoryDelegate)objectArray[0]);
                return null;
            }
            case 115: {
                ((RouteGuidanceMode)object).appendToSequence((SequenceDelegate)objectArray[0]);
                return null;
            }
            case 116: {
                return RuntimeUtil.valueOf(((RouteGuidanceMode)object).isPartOfOtherSequence());
            }
            case 117: {
                return RuntimeUtil.valueOf(((RouteGuidanceMode)object).isPartOfSequence((SequenceDelegate)objectArray[0]));
            }
            case 118: {
                return ((RouteGuidanceMode)object).getSequenceName();
            }
            case 119: {
                ((TurnToStreet)object).initialize();
                return null;
            }
            case 120: {
                ((TurnToStreet)object).uninitialize();
                return null;
            }
            case 121: {
                return RuntimeUtil.valueOf(((TurnToStreet)object).getIdentifier());
            }
            case 122: {
                ((TurnToStreet)object).executeSequence();
                return null;
            }
            case 123: {
                ((TurnToStreet)object).updateNavInfo((NavInfoService)objectArray[0], ((Number)objectArray[1]).intValue(), objectArray[2]);
                return null;
            }
            case 124: {
                ((TurnToStreet)object).dsiKOMONavInfoSetTurnToStreetResult(((Number)objectArray[0]).intValue());
                return null;
            }
            case 125: {
                ((TurnToStreet)object).setDelegate((CategoryDelegate)objectArray[0]);
                return null;
            }
            case 126: {
                ((TurnToStreet)object).appendToSequence((SequenceDelegate)objectArray[0]);
                return null;
            }
            case 127: {
                return RuntimeUtil.valueOf(((TurnToStreet)object).isPartOfOtherSequence());
            }
        }
        return null;
    }

    private Object f4(int n, Object object, Object[] objectArray) {
        switch (n) {
            case 128: {
                return RuntimeUtil.valueOf(((TurnToStreet)object).isPartOfSequence((SequenceDelegate)objectArray[0]));
            }
            case 129: {
                return ((TurnToStreet)object).getSequenceName();
            }
            case 130: {
                ((GfxStreamSinkController)object).initialize();
                return null;
            }
            case 131: {
                return ((GfxStreamSinkController)object).getLogger();
            }
            case 132: {
                return ((GfxStreamSinkController)object).getTarget();
            }
            case 133: {
                ((GfxStreamSinkController)object).setControllerDelegate((ControllerDelegate)objectArray[0]);
                return null;
            }
            case 134: {
                return ((GfxStreamSinkController)object).getCategory(((Number)objectArray[0]).intValue());
            }
            case 135: {
                return ((GfxStreamSinkController)object).getSequence(((Number)objectArray[0]).intValue());
            }
            case 136: {
                ((GfxStreamSinkController)object).uninitialize();
                return null;
            }
            case 137: {
                return ((GfxStreamSinkController)object).getController();
            }
            case 138: {
                return ((GfxStreamSinkController)object).getServiceProvider();
            }
            case 139: {
                return ((GfxStreamSinkController)object).findCategory(((Number)objectArray[0]).intValue());
            }
            case 140: {
                return ((GfxStreamSinkController)object).getDsiServiceProvider();
            }
            case 141: {
                ((ChangeDataRate)object).initialize();
                return null;
            }
            case 142: {
                ((ChangeDataRate)object).uninitialize();
                return null;
            }
            case 143: {
                return RuntimeUtil.valueOf(((ChangeDataRate)object).getIdentifier());
            }
            case 144: {
                ((ChangeDataRate)object).appendToSequence((SequenceDelegate)objectArray[0]);
                return null;
            }
            case 145: {
                ((ChangeDataRate)object).executeSequence();
                return null;
            }
            case 146: {
                ((ChangeDataRate)object).sequenceDone((Sequence)objectArray[0]);
                return null;
            }
            case 147: {
                return RuntimeUtil.valueOf(((ChangeDataRate)object).sequenceStepFailed((Sequence)objectArray[0], ((Number)objectArray[1]).intValue(), (String)objectArray[2]));
            }
            case 148: {
                ((ChangeDataRate)object).dsiKOMOGfxStreamSinkUpdateDataRate(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 149: {
                ((ChangeDataRate)object).setDelegate((CategoryDelegate)objectArray[0]);
                return null;
            }
            case 150: {
                return ((ChangeDataRate)object).getSequence((Sequence)objectArray[0], ((Number)objectArray[1]).intValue());
            }
            case 151: {
                return RuntimeUtil.valueOf(((ChangeDataRate)object).isPartOfOtherSequence());
            }
            case 152: {
                return RuntimeUtil.valueOf(((ChangeDataRate)object).isPartOfSequence((SequenceDelegate)objectArray[0]));
            }
            case 153: {
                return ((ChangeDataRate)object).getSequenceName();
            }
            case 154: {
                ((ChangeDataRateSequence)object).initialize();
                return null;
            }
            case 155: {
                ((ChangeDataRateSequence)object).uninitialize();
                return null;
            }
            case 156: {
                return RuntimeUtil.valueOf(((ChangeDataRateSequence)object).getIdentifier());
            }
            case 157: {
                ((ChangeDataRateSequence)object).executeSequence();
                return null;
            }
            case 158: {
                ((ChangeDataRateSequence)object).sequenceDone((Sequence)objectArray[0]);
                return null;
            }
            case 159: {
                return RuntimeUtil.valueOf(((ChangeDataRateSequence)object).getStreamSinkDataRate());
            }
        }
        return null;
    }

    private Object f5(int n, Object object, Object[] objectArray) {
        switch (n) {
            case 160: {
                ((ChangeDataRateSequence)object).updateNavigationMap((NavigationMapService)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 161: {
                ((ChangeDataRateSequence)object).updateDisplayManagement((DisplayManagementService)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 162: {
                ((ChangeDataRateSequence)object).setDelegate((CategoryDelegate)objectArray[0]);
                return null;
            }
            case 163: {
                return ((ChangeDataRateSequence)object).getSequence((Sequence)objectArray[0], ((Number)objectArray[1]).intValue());
            }
            case 164: {
                ((ChangeDataRateSequence)object).appendToSequence((SequenceDelegate)objectArray[0]);
                return null;
            }
            case 165: {
                return RuntimeUtil.valueOf(((ChangeDataRateSequence)object).isPartOfOtherSequence());
            }
            case 166: {
                return RuntimeUtil.valueOf(((ChangeDataRateSequence)object).isPartOfSequence((SequenceDelegate)objectArray[0]));
            }
            case 167: {
                return ((ChangeDataRateSequence)object).getSequenceName();
            }
            case 168: {
                return RuntimeUtil.valueOf(((ChangeDataRateSequence)object).sequenceStepFailed((Sequence)objectArray[0], ((Number)objectArray[1]).intValue(), (String)objectArray[2]));
            }
            case 169: {
                ((ChangeDataRateSequence)object).timerFired((Timer)objectArray[0]);
                return null;
            }
            case 170: {
                ((MostUnlockUseCase)object).initialize();
                return null;
            }
            case 171: {
                ((MostUnlockUseCase)object).uninitialize();
                return null;
            }
            case 172: {
                return RuntimeUtil.valueOf(((MostUnlockUseCase)object).getIdentifier());
            }
            case 173: {
                ((MostUnlockUseCase)object).executeSequence();
                return null;
            }
            case 174: {
                ((MostUnlockUseCase)object).sequenceDone((Sequence)objectArray[0]);
                return null;
            }
            case 175: {
                ((MostUnlockUseCase)object).setDelegate((CategoryDelegate)objectArray[0]);
                return null;
            }
            case 176: {
                return ((MostUnlockUseCase)object).getSequence((Sequence)objectArray[0], ((Number)objectArray[1]).intValue());
            }
            case 177: {
                ((MostUnlockUseCase)object).appendToSequence((SequenceDelegate)objectArray[0]);
                return null;
            }
            case 178: {
                return RuntimeUtil.valueOf(((MostUnlockUseCase)object).isPartOfOtherSequence());
            }
            case 179: {
                return RuntimeUtil.valueOf(((MostUnlockUseCase)object).isPartOfSequence((SequenceDelegate)objectArray[0]));
            }
            case 180: {
                return ((MostUnlockUseCase)object).getSequenceName();
            }
            case 181: {
                return RuntimeUtil.valueOf(((MostUnlockUseCase)object).sequenceStepFailed((Sequence)objectArray[0], ((Number)objectArray[1]).intValue(), (String)objectArray[2]));
            }
            case 182: {
                ((SwitchMapFromABTToKombi)object).initialize();
                return null;
            }
            case 183: {
                ((SwitchMapFromABTToKombi)object).uninitialize();
                return null;
            }
            case 184: {
                return RuntimeUtil.valueOf(((SwitchMapFromABTToKombi)object).getIdentifier());
            }
            case 185: {
                ((SwitchMapFromABTToKombi)object).executeSequence();
                return null;
            }
            case 186: {
                ((SwitchMapFromABTToKombi)object).sequenceDone((Sequence)objectArray[0]);
                return null;
            }
            case 187: {
                return RuntimeUtil.valueOf(((SwitchMapFromABTToKombi)object).sequenceStepFailed((Sequence)objectArray[0], ((Number)objectArray[1]).intValue(), (String)objectArray[2]));
            }
            case 188: {
                ((SwitchMapFromABTToKombi)object).dsiKOMOGfxStreamSinkUpdateDataRate(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 189: {
                ((SwitchMapFromABTToKombi)object).setDelegate((CategoryDelegate)objectArray[0]);
                return null;
            }
            case 190: {
                return ((SwitchMapFromABTToKombi)object).getSequence((Sequence)objectArray[0], ((Number)objectArray[1]).intValue());
            }
            case 191: {
                ((SwitchMapFromABTToKombi)object).appendToSequence((SequenceDelegate)objectArray[0]);
                return null;
            }
        }
        return null;
    }

    private Object f6(int n, Object object, Object[] objectArray) {
        switch (n) {
            case 192: {
                return RuntimeUtil.valueOf(((SwitchMapFromABTToKombi)object).isPartOfOtherSequence());
            }
            case 193: {
                return RuntimeUtil.valueOf(((SwitchMapFromABTToKombi)object).isPartOfSequence((SequenceDelegate)objectArray[0]));
            }
            case 194: {
                return ((SwitchMapFromABTToKombi)object).getSequenceName();
            }
            case 195: {
                ((SwitchMapFromABTToKombiSequence)object).initialize();
                return null;
            }
            case 196: {
                ((SwitchMapFromABTToKombiSequence)object).uninitialize();
                return null;
            }
            case 197: {
                return RuntimeUtil.valueOf(((SwitchMapFromABTToKombiSequence)object).getIdentifier());
            }
            case 198: {
                ((SwitchMapFromABTToKombiSequence)object).appendToSequence((SequenceDelegate)objectArray[0]);
                return null;
            }
            case 199: {
                ((SwitchMapFromABTToKombiSequence)object).executeSequence();
                return null;
            }
            case 200: {
                ((SwitchMapFromABTToKombiSequence)object).sequenceDone((Sequence)objectArray[0]);
                return null;
            }
            case 201: {
                ((SwitchMapFromABTToKombiSequence)object).setStreamSinkDataRate(((Number)objectArray[0]).intValue());
                return null;
            }
            case 202: {
                return RuntimeUtil.valueOf(((SwitchMapFromABTToKombiSequence)object).getStreamSinkDataRate());
            }
            case 203: {
                ((SwitchMapFromABTToKombiSequence)object).updateNavigationMap((NavigationMapService)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 204: {
                ((SwitchMapFromABTToKombiSequence)object).dsiKOMOGfxStreamSinkFadeOutResult();
                return null;
            }
            case 205: {
                ((SwitchMapFromABTToKombiSequence)object).dsiKOMOGfxStreamSinkFadeInResult();
                return null;
            }
            case 206: {
                ((SwitchMapFromABTToKombiSequence)object).setDelegate((CategoryDelegate)objectArray[0]);
                return null;
            }
            case 207: {
                return ((SwitchMapFromABTToKombiSequence)object).getSequence((Sequence)objectArray[0], ((Number)objectArray[1]).intValue());
            }
            case 208: {
                return RuntimeUtil.valueOf(((SwitchMapFromABTToKombiSequence)object).isPartOfOtherSequence());
            }
            case 209: {
                return RuntimeUtil.valueOf(((SwitchMapFromABTToKombiSequence)object).isPartOfSequence((SequenceDelegate)objectArray[0]));
            }
            case 210: {
                return ((SwitchMapFromABTToKombiSequence)object).getSequenceName();
            }
            case 211: {
                return RuntimeUtil.valueOf(((SwitchMapFromABTToKombiSequence)object).sequenceStepFailed((Sequence)objectArray[0], ((Number)objectArray[1]).intValue(), (String)objectArray[2]));
            }
            case 212: {
                ((SwitchMapFromABTToKombiSequence)object).timerFired((Timer)objectArray[0]);
                return null;
            }
            case 213: {
                ((SwitchMapFromKombiToABT)object).initialize();
                return null;
            }
            case 214: {
                ((SwitchMapFromKombiToABT)object).uninitialize();
                return null;
            }
            case 215: {
                return RuntimeUtil.valueOf(((SwitchMapFromKombiToABT)object).getIdentifier());
            }
            case 216: {
                ((SwitchMapFromKombiToABT)object).executeSequence();
                return null;
            }
            case 217: {
                ((SwitchMapFromKombiToABT)object).sequenceDone((Sequence)objectArray[0]);
                return null;
            }
            case 218: {
                return RuntimeUtil.valueOf(((SwitchMapFromKombiToABT)object).sequenceStepFailed((Sequence)objectArray[0], ((Number)objectArray[1]).intValue(), (String)objectArray[2]));
            }
            case 219: {
                ((SwitchMapFromKombiToABT)object).dsiKOMOGfxStreamSinkUpdateDataRate(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 220: {
                ((SwitchMapFromKombiToABT)object).setDelegate((CategoryDelegate)objectArray[0]);
                return null;
            }
            case 221: {
                return ((SwitchMapFromKombiToABT)object).getSequence((Sequence)objectArray[0], ((Number)objectArray[1]).intValue());
            }
            case 222: {
                ((SwitchMapFromKombiToABT)object).appendToSequence((SequenceDelegate)objectArray[0]);
                return null;
            }
            case 223: {
                return RuntimeUtil.valueOf(((SwitchMapFromKombiToABT)object).isPartOfOtherSequence());
            }
        }
        return null;
    }

    private Object f7(int n, Object object, Object[] objectArray) {
        switch (n) {
            case 224: {
                return RuntimeUtil.valueOf(((SwitchMapFromKombiToABT)object).isPartOfSequence((SequenceDelegate)objectArray[0]));
            }
            case 225: {
                return ((SwitchMapFromKombiToABT)object).getSequenceName();
            }
            case 226: {
                ((SwitchMapFromKombiToABTSequence)object).initialize();
                return null;
            }
            case 227: {
                ((SwitchMapFromKombiToABTSequence)object).uninitialize();
                return null;
            }
            case 228: {
                return RuntimeUtil.valueOf(((SwitchMapFromKombiToABTSequence)object).getIdentifier());
            }
            case 229: {
                ((SwitchMapFromKombiToABTSequence)object).appendToSequence((SequenceDelegate)objectArray[0]);
                return null;
            }
            case 230: {
                ((SwitchMapFromKombiToABTSequence)object).executeSequence();
                return null;
            }
            case 231: {
                ((SwitchMapFromKombiToABTSequence)object).sequenceDone((Sequence)objectArray[0]);
                return null;
            }
            case 232: {
                ((SwitchMapFromKombiToABTSequence)object).setStreamSinkDataRate(((Number)objectArray[0]).intValue());
                return null;
            }
            case 233: {
                return RuntimeUtil.valueOf(((SwitchMapFromKombiToABTSequence)object).getStreamSinkDataRate());
            }
            case 234: {
                ((SwitchMapFromKombiToABTSequence)object).updateNavigationMap((NavigationMapService)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 235: {
                ((SwitchMapFromKombiToABTSequence)object).updateDisplayManagement((DisplayManagementService)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 236: {
                ((SwitchMapFromKombiToABTSequence)object).dsiKOMOGfxStreamSinkFadeOutResult();
                return null;
            }
            case 237: {
                ((SwitchMapFromKombiToABTSequence)object).dsiKOMOGfxStreamSinkFadeInResult();
                return null;
            }
            case 238: {
                ((SwitchMapFromKombiToABTSequence)object).setDelegate((CategoryDelegate)objectArray[0]);
                return null;
            }
            case 239: {
                return ((SwitchMapFromKombiToABTSequence)object).getSequence((Sequence)objectArray[0], ((Number)objectArray[1]).intValue());
            }
            case 240: {
                return RuntimeUtil.valueOf(((SwitchMapFromKombiToABTSequence)object).isPartOfOtherSequence());
            }
            case 241: {
                return RuntimeUtil.valueOf(((SwitchMapFromKombiToABTSequence)object).isPartOfSequence((SequenceDelegate)objectArray[0]));
            }
            case 242: {
                return ((SwitchMapFromKombiToABTSequence)object).getSequenceName();
            }
            case 243: {
                return RuntimeUtil.valueOf(((SwitchMapFromKombiToABTSequence)object).sequenceStepFailed((Sequence)objectArray[0], ((Number)objectArray[1]).intValue(), (String)objectArray[2]));
            }
            case 244: {
                ((SwitchMapFromKombiToABTSequence)object).timerFired((Timer)objectArray[0]);
                return null;
            }
            case 245: {
                ((SwitchToPermanentMap)object).initialize();
                return null;
            }
            case 246: {
                ((SwitchToPermanentMap)object).uninitialize();
                return null;
            }
            case 247: {
                return RuntimeUtil.valueOf(((SwitchToPermanentMap)object).getIdentifier());
            }
            case 248: {
                ((SwitchToPermanentMap)object).executeSequence();
                return null;
            }
            case 249: {
                ((SwitchToPermanentMap)object).sequenceDone((Sequence)objectArray[0]);
                return null;
            }
            case 250: {
                ((SwitchToPermanentMap)object).setDelegate((CategoryDelegate)objectArray[0]);
                return null;
            }
            case 251: {
                return ((SwitchToPermanentMap)object).getSequence((Sequence)objectArray[0], ((Number)objectArray[1]).intValue());
            }
            case 252: {
                ((SwitchToPermanentMap)object).appendToSequence((SequenceDelegate)objectArray[0]);
                return null;
            }
            case 253: {
                return RuntimeUtil.valueOf(((SwitchToPermanentMap)object).isPartOfOtherSequence());
            }
            case 254: {
                return RuntimeUtil.valueOf(((SwitchToPermanentMap)object).isPartOfSequence((SequenceDelegate)objectArray[0]));
            }
            case 255: {
                return ((SwitchToPermanentMap)object).getSequenceName();
            }
        }
        return null;
    }

    private Object f8(int n, Object object, Object[] objectArray) {
        switch (n) {
            case 256: {
                return RuntimeUtil.valueOf(((SwitchToPermanentMap)object).sequenceStepFailed((Sequence)objectArray[0], ((Number)objectArray[1]).intValue(), (String)objectArray[2]));
            }
            case 257: {
                ((SwitchToPermanentMapSequence)object).initialize();
                return null;
            }
            case 258: {
                ((SwitchToPermanentMapSequence)object).uninitialize();
                return null;
            }
            case 259: {
                return RuntimeUtil.valueOf(((SwitchToPermanentMapSequence)object).getIdentifier());
            }
            case 260: {
                ((SwitchToPermanentMapSequence)object).appendToSequence((SequenceDelegate)objectArray[0]);
                return null;
            }
            case 261: {
                ((SwitchToPermanentMapSequence)object).executeSequence();
                return null;
            }
            case 262: {
                ((SwitchToPermanentMapSequence)object).sequenceDone((Sequence)objectArray[0]);
                return null;
            }
            case 263: {
                ((SwitchToPermanentMapSequence)object).updateDisplayManagement((DisplayManagementService)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 264: {
                ((SwitchToPermanentMapSequence)object).dsiKOMOGfxStreamSinkFadeOutResult();
                return null;
            }
            case 265: {
                ((SwitchToPermanentMapSequence)object).dsiKOMOGfxStreamSinkFadeInResult();
                return null;
            }
            case 266: {
                ((SwitchToPermanentMapSequence)object).dsiKOMOGfxStreamSinkSetFGLayerResult(((Number)objectArray[0]).intValue());
                return null;
            }
            case 267: {
                ((SwitchToPermanentMapSequence)object).setDelegate((CategoryDelegate)objectArray[0]);
                return null;
            }
            case 268: {
                return ((SwitchToPermanentMapSequence)object).getSequence((Sequence)objectArray[0], ((Number)objectArray[1]).intValue());
            }
            case 269: {
                return RuntimeUtil.valueOf(((SwitchToPermanentMapSequence)object).isPartOfOtherSequence());
            }
            case 270: {
                return RuntimeUtil.valueOf(((SwitchToPermanentMapSequence)object).isPartOfSequence((SequenceDelegate)objectArray[0]));
            }
            case 271: {
                return ((SwitchToPermanentMapSequence)object).getSequenceName();
            }
            case 272: {
                return RuntimeUtil.valueOf(((SwitchToPermanentMapSequence)object).sequenceStepFailed((Sequence)objectArray[0], ((Number)objectArray[1]).intValue(), (String)objectArray[2]));
            }
            case 273: {
                ((SwitchToPermanentMapSequence)object).timerFired((Timer)objectArray[0]);
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
                case 2: {
                    return this.f2(n, object, objectArray);
                }
                case 3: {
                    return this.f3(n, object, objectArray);
                }
                case 4: {
                    return this.f4(n, object, objectArray);
                }
                case 5: {
                    return this.f5(n, object, objectArray);
                }
                case 6: {
                    return this.f6(n, object, objectArray);
                }
                case 7: {
                    return this.f7(n, object, objectArray);
                }
                case 8: {
                    return this.f8(n, object, objectArray);
                }
            }
            return null;
        }
        catch (Throwable throwable) {
            throw new InvocationTargetException(throwable);
        }
    }
}

