/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.kombipictureserver.reflection.generated.mma;

import de.vw.mib.asl.internal.kombipictureserver.common.api.bap.audiosd.BapAudioSdService;
import de.vw.mib.asl.internal.kombipictureserver.common.api.bap.telephone.BapTelephoneService;
import de.vw.mib.asl.internal.kombipictureserver.common.api.media.asl.MediaCoverArtService;
import de.vw.mib.asl.internal.kombipictureserver.common.api.phone.asl.PhoneCallService;
import de.vw.mib.asl.internal.kombipictureserver.common.api.radio.asl.RadioStationArtService;
import de.vw.mib.asl.internal.kombipictureserver.common.api.tvtuner.asl.TvTunerStationArtService;
import de.vw.mib.asl.internal.kombipictureserver.common.category.CategoryDelegate;
import de.vw.mib.asl.internal.kombipictureserver.controller.PictureServerController;
import de.vw.mib.asl.internal.kombipictureserver.usecaces.CallPicture;
import de.vw.mib.asl.internal.kombipictureserver.usecaces.CoverArt;
import de.vw.mib.asl.internal.kombipictureserver.usecaces.StationArt;
import de.vw.mib.reflection.MultipleMethodAccessibleObject;
import de.vw.mib.reflection.RuntimeUtil;
import java.lang.reflect.InvocationTargetException;

public final class LR2e714a90d
extends MultipleMethodAccessibleObject {
    private int a0(int n, boolean bl, int n2) {
        int n3 = -1;
        switch (n) {
            case -867518548: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 4;
                    break;
                }
                n3 = 4;
                break;
            }
            case -220168187: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 7;
                    break;
                }
                n3 = 7;
                break;
            }
            case 196890700: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 5;
                    break;
                }
                n3 = 5;
                break;
            }
            case 339680775: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 6;
                    break;
                }
                n3 = 6;
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
                    n3 = 8;
                    break;
                }
                n3 = 8;
                break;
            }
            case 2128411881: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 3;
                    break;
                }
                n3 = 3;
                break;
            }
        }
        return n3;
    }

    private int a1(int n, boolean bl, int n2) {
        int n3 = -1;
        switch (n) {
            case -1916180716: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 10;
                    break;
                }
                n3 = 10;
                break;
            }
            case -1860947241: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 17;
                    break;
                }
                n3 = 17;
                break;
            }
            case -1486324100: {
                if (bl) {
                    if (n2 != -1916012388) break;
                    n3 = 16;
                    break;
                }
                n3 = 16;
                break;
            }
            case -1470674488: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 15;
                    break;
                }
                n3 = 15;
                break;
            }
            case -1459419951: {
                if (bl) {
                    if (n2 != -1606045667) break;
                    n3 = 14;
                    break;
                }
                n3 = 14;
                break;
            }
            case -1302253218: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 12;
                    break;
                }
                n3 = 12;
                break;
            }
            case -133984053: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 11;
                    break;
                }
                n3 = 11;
                break;
            }
            case 871091717: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 9;
                    break;
                }
                n3 = 9;
                break;
            }
            case 1134160533: {
                if (bl) {
                    if (n2 != 1080605906) break;
                    n3 = 13;
                    break;
                }
                n3 = 13;
                break;
            }
        }
        return n3;
    }

    private int a2(int n, boolean bl, int n2) {
        int n3 = -1;
        switch (n) {
            case -1916180716: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 19;
                    break;
                }
                n3 = 19;
                break;
            }
            case -1860947241: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 26;
                    break;
                }
                n3 = 26;
                break;
            }
            case -1486324100: {
                if (bl) {
                    if (n2 != -1916012388) break;
                    n3 = 25;
                    break;
                }
                n3 = 25;
                break;
            }
            case -1302253218: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 21;
                    break;
                }
                n3 = 21;
                break;
            }
            case -133984053: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 20;
                    break;
                }
                n3 = 20;
                break;
            }
            case 201520988: {
                if (bl) {
                    if (n2 != 1191080732) break;
                    n3 = 23;
                    break;
                }
                n3 = 23;
                break;
            }
            case 333057940: {
                if (bl) {
                    if (n2 != 544042381) break;
                    n3 = 24;
                    break;
                }
                n3 = 24;
                break;
            }
            case 871091717: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 18;
                    break;
                }
                n3 = 18;
                break;
            }
            case 1141693448: {
                if (bl) {
                    if (n2 != -883163127) break;
                    n3 = 22;
                    break;
                }
                n3 = 22;
                break;
            }
        }
        return n3;
    }

    private int a3(int n, boolean bl, int n2) {
        int n3 = -1;
        switch (n) {
            case -1916180716: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 28;
                    break;
                }
                n3 = 28;
                break;
            }
            case -1860947241: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 35;
                    break;
                }
                n3 = 35;
                break;
            }
            case -1652295309: {
                if (bl) {
                    if (n2 != -1150805945) break;
                    n3 = 32;
                    break;
                }
                n3 = 32;
                break;
            }
            case -1486324100: {
                if (bl) {
                    if (n2 != -1916012388) break;
                    n3 = 34;
                    break;
                }
                n3 = 34;
                break;
            }
            case -133984053: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 29;
                    break;
                }
                n3 = 29;
                break;
            }
            case 333057940: {
                if (bl) {
                    if (n2 != 544042381) break;
                    n3 = 30;
                    break;
                }
                n3 = 30;
                break;
            }
            case 626582443: {
                if (bl) {
                    if (n2 != -883163127) break;
                    n3 = 31;
                    break;
                }
                n3 = 31;
                break;
            }
            case 646524246: {
                if (bl) {
                    if (n2 != -1794137738) break;
                    n3 = 33;
                    break;
                }
                n3 = 33;
                break;
            }
            case 871091717: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 27;
                    break;
                }
                n3 = 27;
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
            case -1960570872: {
                n2 = this.a0(n4, bl, n);
                break;
            }
            case -1336013349: {
                n2 = this.a1(n4, bl, n);
                break;
            }
            case -742941509: {
                n2 = this.a2(n4, bl, n);
                break;
            }
            case 1968587678: {
                n2 = this.a3(n4, bl, n);
                break;
            }
        }
        return n2;
    }

    private Object f0(int n, Object object, Object[] objectArray) {
        switch (n) {
            case 0: {
                ((PictureServerController)object).initialize();
                return null;
            }
            case 1: {
                return ((PictureServerController)object).getLogger();
            }
            case 2: {
                return ((PictureServerController)object).getTarget();
            }
            case 3: {
                return ((PictureServerController)object).getCategory(((Number)objectArray[0]).intValue());
            }
            case 4: {
                return ((PictureServerController)object).getSequence(((Number)objectArray[0]).intValue());
            }
            case 5: {
                return ((PictureServerController)object).findCategory(((Number)objectArray[0]).intValue());
            }
            case 6: {
                return ((PictureServerController)object).getController();
            }
            case 7: {
                return ((PictureServerController)object).getServiceProvider();
            }
            case 8: {
                return ((PictureServerController)object).getDsiServiceProvider();
            }
            case 9: {
                ((CallPicture)object).initialize();
                return null;
            }
            case 10: {
                return RuntimeUtil.valueOf(((CallPicture)object).getIdentifier());
            }
            case 11: {
                ((CallPicture)object).executeSequence();
                return null;
            }
            case 12: {
                ((CallPicture)object).uninitialize();
                return null;
            }
            case 13: {
                ((CallPicture)object).updatePhonceCall((PhoneCallService)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 14: {
                ((CallPicture)object).updateBapTelephone((BapTelephoneService)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 15: {
                ((CallPicture)object).dsiKombiPictureServerIndicationActiveCallPicture(((Number)objectArray[0]).intValue());
                return null;
            }
            case 16: {
                ((CallPicture)object).setDelegate((CategoryDelegate)objectArray[0]);
                return null;
            }
            case 17: {
                return ((CallPicture)object).getSequenceName();
            }
            case 18: {
                ((CoverArt)object).initialize();
                return null;
            }
            case 19: {
                return RuntimeUtil.valueOf(((CoverArt)object).getIdentifier());
            }
            case 20: {
                ((CoverArt)object).executeSequence();
                return null;
            }
            case 21: {
                ((CoverArt)object).uninitialize();
                return null;
            }
            case 22: {
                ((CoverArt)object).dsiKombiPictureServerIndicationCoverArt(((Number)objectArray[0]).longValue(), ((Number)objectArray[1]).intValue(), ((Number)objectArray[2]).intValue());
                return null;
            }
            case 23: {
                ((CoverArt)object).updateMediaCoverArt((MediaCoverArtService)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 24: {
                ((CoverArt)object).updateBapAudioSd((BapAudioSdService)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 25: {
                ((CoverArt)object).setDelegate((CategoryDelegate)objectArray[0]);
                return null;
            }
            case 26: {
                return ((CoverArt)object).getSequenceName();
            }
            case 27: {
                ((StationArt)object).initialize();
                return null;
            }
            case 28: {
                return RuntimeUtil.valueOf(((StationArt)object).getIdentifier());
            }
            case 29: {
                ((StationArt)object).executeSequence();
                return null;
            }
            case 30: {
                ((StationArt)object).updateBapAudioSd((BapAudioSdService)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 31: {
                ((StationArt)object).dsiKombiPictureServerIndicationStationArt(((Number)objectArray[0]).longValue(), ((Number)objectArray[1]).intValue(), ((Number)objectArray[2]).intValue());
                return null;
            }
        }
        return null;
    }

    private Object f1(int n, Object object, Object[] objectArray) {
        switch (n) {
            case 32: {
                ((StationArt)object).updateTvTunerStationArt((TvTunerStationArtService)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 33: {
                ((StationArt)object).updateRadioStationArt((RadioStationArtService)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 34: {
                ((StationArt)object).setDelegate((CategoryDelegate)objectArray[0]);
                return null;
            }
            case 35: {
                return ((StationArt)object).getSequenceName();
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

