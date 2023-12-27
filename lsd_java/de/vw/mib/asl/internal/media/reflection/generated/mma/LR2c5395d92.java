/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.media.reflection.generated.mma;

import de.vw.mib.asl.api.devicehandling.Device;
import de.vw.mib.asl.api.devicehandling.Devices;
import de.vw.mib.asl.api.devicehandling.Medium;
import de.vw.mib.asl.api.devicehandling.clients.MediaListObserver;
import de.vw.mib.asl.api.media.services.Callback;
import de.vw.mib.asl.api.media.services.SourceCallback;
import de.vw.mib.asl.api.media.services.browser.MediaEntriesCallback;
import de.vw.mib.asl.api.media.services.browser.MediaEntry;
import de.vw.mib.asl.api.media.services.browser.SpeakableElementsListener;
import de.vw.mib.asl.api.media.services.player.MediaActivationStateListener;
import de.vw.mib.asl.api.media.services.player.MediaPlaySimilarListener;
import de.vw.mib.asl.api.media.services.player.MediaPlayViewListener;
import de.vw.mib.asl.api.media.services.sources.SourceId;
import de.vw.mib.asl.api.system.factoryreset.FactoryResetCallback;
import de.vw.mib.asl.framework.api.entertainmentmanager.core.EntertainmentManagerCoreService;
import de.vw.mib.asl.framework.api.persistence2.dsi.PersonalizedAppListener;
import de.vw.mib.asl.internal.avdc.audio.browser.transformer.ExtendedListEntry;
import de.vw.mib.asl.internal.devicehandling.DeviceHandlingTarget;
import de.vw.mib.asl.internal.devicehandling.otherclients.EjectionTarget;
import de.vw.mib.asl.internal.media.browser.AbstractMediaBrowser;
import de.vw.mib.asl.internal.media.browser.BrowserPathData;
import de.vw.mib.asl.internal.media.browser.BrowserStateListener;
import de.vw.mib.asl.internal.media.browser.MediaBrowserListFetcher;
import de.vw.mib.asl.internal.media.browser.MediaBrowserListHandler;
import de.vw.mib.asl.internal.media.browser.MediaBrowserSearchHandler;
import de.vw.mib.asl.internal.media.browser.Selection;
import de.vw.mib.asl.internal.media.browser.bap.MediaBapBrowser;
import de.vw.mib.asl.internal.media.browser.bap.MediaHasBrowser;
import de.vw.mib.asl.internal.media.browser.coverflow.MediaCoverBrowser;
import de.vw.mib.asl.internal.media.browser.headunit.MediaMainBrowser;
import de.vw.mib.asl.internal.media.browser.headunit.MediaRecorderBrowser;
import de.vw.mib.asl.internal.media.browser.sds.MediaSpeechBrowser;
import de.vw.mib.asl.internal.media.common.ResponseHandler;
import de.vw.mib.asl.internal.media.controller.MediaController;
import de.vw.mib.asl.internal.media.controller.OnlineMetaDataHandler;
import de.vw.mib.asl.internal.media.controller.commands.Command;
import de.vw.mib.asl.internal.media.controller.commands.CommandCallback;
import de.vw.mib.asl.internal.media.controller.commands.CommandState;
import de.vw.mib.asl.internal.media.has.MediaHASTarget;
import de.vw.mib.asl.internal.media.playback.MediaPlayer;
import de.vw.mib.asl.internal.media.playback.MediaVideoPlayer;
import de.vw.mib.asl.internal.media.playback.PlayMode;
import de.vw.mib.asl.internal.media.recorder.MediaRecorder;
import de.vw.mib.asl.internal.media.settings.MediaSettings;
import de.vw.mib.asl.internal.media.sound.MediaAudioManager;
import de.vw.mib.asl.internal.media.sourcehandling.state.MediaCollector;
import de.vw.mib.asl.internal.media.sourcehandling.target.ISources;
import de.vw.mib.asl.internal.media.sourcehandling.target.MediaInternalSourceHandlingTarget;
import de.vw.mib.asl.internal.media.targets.TargetMediaStartup;
import de.vw.mib.asl.media.persistence.DsiMediaBaseAdapter;
import de.vw.mib.reflection.MultipleMethodAccessibleObject;
import de.vw.mib.reflection.RuntimeUtil;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
import org.dsi.ifc.global.CharacterInfo;
import org.dsi.ifc.global.ResourceLocator;
import org.dsi.ifc.media.AudioStream;
import org.dsi.ifc.media.Capabilities;
import org.dsi.ifc.media.DatabaseSpace;
import org.dsi.ifc.media.DeviceInfo;
import org.dsi.ifc.media.EntryInfo;
import org.dsi.ifc.media.ListEntry;
import org.dsi.ifc.media.MediaInfo;
import org.dsi.ifc.media.PlaybackMode;
import org.dsi.ifc.media.SearchListEntryExt;

public final class LR2c5395d92
extends MultipleMethodAccessibleObject {
    private int a0(int n, boolean bl, int n2) {
        int n3 = -1;
        switch (n) {
            case -1031000935: {
                if (bl) {
                    if (n2 != 609887824) break;
                    n3 = 3;
                    break;
                }
                n3 = 3;
                break;
            }
            case 96534342: {
                if (bl) {
                    if (n2 != -1916372039) break;
                    n3 = 0;
                    break;
                }
                n3 = 0;
                break;
            }
            case 640273037: {
                if (bl) {
                    if (n2 != 1785675212) break;
                    n3 = 1;
                    break;
                }
                n3 = 1;
                break;
            }
            case 1165841555: {
                if (bl) {
                    if (n2 != -30324290) break;
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
            case -1595941652: {
                if (bl) {
                    if (n2 != 1851074730) break;
                    n3 = 7;
                    break;
                }
                n3 = 7;
                break;
            }
            case 96534342: {
                if (bl) {
                    if (n2 != 852604612) break;
                    n3 = 4;
                    break;
                }
                n3 = 4;
                break;
            }
            case 1278959095: {
                if (bl) {
                    if (n2 != 1538383871) break;
                    n3 = 6;
                    break;
                }
                n3 = 6;
                break;
            }
            case 1559564797: {
                if (bl) {
                    if (n2 != 252699290) break;
                    n3 = 5;
                    break;
                }
                n3 = 5;
                break;
            }
        }
        return n3;
    }

    private int a2(int n, boolean bl, int n2) {
        int n3 = -1;
        switch (n) {
            case -2130821816: {
                if (bl) {
                    if (n2 != -325145337) break;
                    n3 = 31;
                    break;
                }
                n3 = 31;
                break;
            }
            case -2063871083: {
                if (bl) {
                    if (n2 != -969868154) break;
                    n3 = 62;
                    break;
                }
                n3 = 62;
                break;
            }
            case -1924972566: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 29;
                    break;
                }
                n3 = 29;
                break;
            }
            case -1915854272: {
                if (bl) {
                    if (n2 != -113987859) break;
                    n3 = 69;
                    break;
                }
                n3 = 69;
                break;
            }
            case -1831849040: {
                if (bl) {
                    if (n2 != -633848249) break;
                    n3 = 14;
                    break;
                }
                n3 = 14;
                break;
            }
            case -1826640880: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 54;
                    break;
                }
                n3 = 54;
                break;
            }
            case -1776226757: {
                if (bl) {
                    if (n2 != 1974431619) break;
                    n3 = 11;
                    break;
                }
                n3 = 11;
                break;
            }
            case -1765845337: {
                if (bl) {
                    if (n2 != 162571868) break;
                    n3 = 72;
                    break;
                }
                n3 = 72;
                break;
            }
            case -1726615305: {
                if (bl) {
                    if (n2 != -1746740954) break;
                    n3 = 13;
                    break;
                }
                n3 = 13;
                break;
            }
            case -1725569717: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 40;
                    break;
                }
                n3 = 40;
                break;
            }
            case -1691403924: {
                if (bl) {
                    if (n2 != 1783949470) break;
                    n3 = 25;
                    break;
                }
                n3 = 25;
                break;
            }
            case -1626201033: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 8;
                    break;
                }
                n3 = 8;
                break;
            }
            case -1604980789: {
                if (bl) {
                    if (n2 != -1866337497) break;
                    n3 = 42;
                    break;
                }
                n3 = 42;
                break;
            }
            case -1518674028: {
                if (bl) {
                    if (n2 != 2084990025) break;
                    n3 = 26;
                    break;
                }
                n3 = 26;
                break;
            }
            case -1449023303: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 50;
                    break;
                }
                n3 = 50;
                break;
            }
            case -1429363748: {
                if (bl) {
                    if (n2 == 17) {
                        n3 = 44;
                        break;
                    }
                    if (n2 != 1760295979) break;
                    n3 = 45;
                    break;
                }
                n3 = 44;
                break;
            }
            case -1249364743: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 74;
                    break;
                }
                n3 = 74;
                break;
            }
            case -1244771758: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 56;
                    break;
                }
                n3 = 56;
                break;
            }
            case -1213972435: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 60;
                    break;
                }
                n3 = 60;
                break;
            }
            case -983143078: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 65;
                    break;
                }
                n3 = 65;
                break;
            }
            case -939364879: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 58;
                    break;
                }
                n3 = 58;
                break;
            }
            case -924516878: {
                if (bl) {
                    if (n2 != 187837535) break;
                    n3 = 28;
                    break;
                }
                n3 = 28;
                break;
            }
            case -871447126: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 67;
                    break;
                }
                n3 = 67;
                break;
            }
            case -868700596: {
                if (bl) {
                    if (n2 != 162571868) break;
                    n3 = 73;
                    break;
                }
                n3 = 73;
                break;
            }
            case -809637503: {
                if (bl) {
                    if (n2 != -113987859) break;
                    n3 = 70;
                    break;
                }
                n3 = 70;
                break;
            }
            case -775323769: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 23;
                    break;
                }
                n3 = 23;
                break;
            }
            case -749315117: {
                if (bl) {
                    if (n2 != 2113417289) break;
                    n3 = 36;
                    break;
                }
                n3 = 36;
                break;
            }
            case -706481229: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 84;
                    break;
                }
                n3 = 84;
                break;
            }
            case -645783237: {
                if (bl) {
                    if (n2 != 1043255048) break;
                    n3 = 27;
                    break;
                }
                n3 = 27;
                break;
            }
            case -500208810: {
                if (bl) {
                    if (n2 != 443655006) break;
                    n3 = 78;
                    break;
                }
                n3 = 78;
                break;
            }
            case -462374472: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 51;
                    break;
                }
                n3 = 51;
                break;
            }
            case -402285088: {
                if (bl) {
                    if (n2 != -282811157) break;
                    n3 = 48;
                    break;
                }
                n3 = 48;
                break;
            }
            case -370139596: {
                if (bl) {
                    if (n2 != 1343187563) break;
                    n3 = 71;
                    break;
                }
                n3 = 71;
                break;
            }
            case -366275945: {
                if (bl) {
                    if (n2 != 1142324572) break;
                    n3 = 43;
                    break;
                }
                n3 = 43;
                break;
            }
            case -319924344: {
                if (bl) {
                    if (n2 != 739712016) break;
                    n3 = 17;
                    break;
                }
                n3 = 17;
                break;
            }
            case -276383550: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 52;
                    break;
                }
                n3 = 52;
                break;
            }
            case -236768260: {
                if (bl) {
                    if (n2 == 1375123541) {
                        n3 = 82;
                        break;
                    }
                    if (n2 != -1540244125) break;
                    n3 = 83;
                    break;
                }
                n3 = 82;
                break;
            }
            case -230993306: {
                if (bl) {
                    if (n2 != 975108042) break;
                    n3 = 38;
                    break;
                }
                n3 = 38;
                break;
            }
            case -189148986: {
                if (bl) {
                    if (n2 != 1276482132) break;
                    n3 = 49;
                    break;
                }
                n3 = 49;
                break;
            }
            case -167802320: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 76;
                    break;
                }
                n3 = 76;
                break;
            }
            case -167518468: {
                if (bl) {
                    if (n2 != 2019736939) break;
                    n3 = 34;
                    break;
                }
                n3 = 34;
                break;
            }
            case -121243490: {
                if (bl) {
                    if (n2 != -658959130) break;
                    n3 = 12;
                    break;
                }
                n3 = 12;
                break;
            }
            case -120617019: {
                if (bl) {
                    if (n2 != 1375123541) break;
                    n3 = 19;
                    break;
                }
                n3 = 19;
                break;
            }
            case 304220870: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 57;
                    break;
                }
                n3 = 57;
                break;
            }
            case 313356851: {
                if (bl) {
                    if (n2 != -1318471851) break;
                    n3 = 35;
                    break;
                }
                n3 = 35;
                break;
            }
            case 364591627: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 68;
                    break;
                }
                n3 = 68;
                break;
            }
            case 396276562: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 24;
                    break;
                }
                n3 = 24;
                break;
            }
            case 397149923: {
                if (bl) {
                    if (n2 != 1375123541) break;
                    n3 = 21;
                    break;
                }
                n3 = 21;
                break;
            }
            case 437084938: {
                if (bl) {
                    if (n2 != -969868154) break;
                    n3 = 64;
                    break;
                }
                n3 = 64;
                break;
            }
            case 555523148: {
                if (bl) {
                    if (n2 != 1257842368) break;
                    n3 = 15;
                    break;
                }
                n3 = 15;
                break;
            }
            case 604276475: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 75;
                    break;
                }
                n3 = 75;
                break;
            }
            case 635189896: {
                if (bl) {
                    if (n2 != 975108042) break;
                    n3 = 16;
                    break;
                }
                n3 = 16;
                break;
            }
            case 668173073: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 33;
                    break;
                }
                n3 = 33;
                break;
            }
            case 694012704: {
                if (bl) {
                    if (n2 != -969868154) break;
                    n3 = 63;
                    break;
                }
                n3 = 63;
                break;
            }
            case 905700127: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 22;
                    break;
                }
                n3 = 22;
                break;
            }
            case 1085072092: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 10;
                    break;
                }
                n3 = 10;
                break;
            }
            case 1114824027: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 18;
                    break;
                }
                n3 = 18;
                break;
            }
            case 1261822892: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 37;
                    break;
                }
                n3 = 37;
                break;
            }
            case 1270631828: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 61;
                    break;
                }
                n3 = 61;
                break;
            }
            case 1289395398: {
                if (bl) {
                    if (n2 != -2074413579) break;
                    n3 = 46;
                    break;
                }
                n3 = 46;
                break;
            }
            case 1330496874: {
                if (bl) {
                    if (n2 != 1632564441) break;
                    n3 = 32;
                    break;
                }
                n3 = 32;
                break;
            }
            case 1451197365: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 39;
                    break;
                }
                n3 = 39;
                break;
            }
            case 1460059505: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 53;
                    break;
                }
                n3 = 53;
                break;
            }
            case 1497367438: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 41;
                    break;
                }
                n3 = 41;
                break;
            }
            case 1507515148: {
                if (bl) {
                    if (n2 == -1653679357) {
                        n3 = 79;
                        break;
                    }
                    if (n2 == -1665395196) {
                        n3 = 80;
                        break;
                    }
                    if (n2 != -1432102577) break;
                    n3 = 81;
                    break;
                }
                n3 = 79;
                break;
            }
            case 1559564797: {
                if (bl) {
                    if (n2 != 252699290) break;
                    n3 = 77;
                    break;
                }
                n3 = 77;
                break;
            }
            case 1596846077: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 59;
                    break;
                }
                n3 = 59;
                break;
            }
            case 1652258057: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 20;
                    break;
                }
                n3 = 20;
                break;
            }
            case 1891874706: {
                if (bl) {
                    if (n2 != 2084990025) break;
                    n3 = 30;
                    break;
                }
                n3 = 30;
                break;
            }
            case 1935955832: {
                if (bl) {
                    if (n2 != 94264995) break;
                    n3 = 66;
                    break;
                }
                n3 = 66;
                break;
            }
            case 1965583696: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 9;
                    break;
                }
                n3 = 9;
                break;
            }
            case 2011511871: {
                if (bl) {
                    if (n2 != 162749643) break;
                    n3 = 47;
                    break;
                }
                n3 = 47;
                break;
            }
            case 2133963907: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 55;
                    break;
                }
                n3 = 55;
                break;
            }
        }
        return n3;
    }

    private int a3(int n, boolean bl, int n2) {
        int n3 = -1;
        switch (n) {
            case -2130821816: {
                if (bl) {
                    if (n2 != -325145337) break;
                    n3 = 108;
                    break;
                }
                n3 = 108;
                break;
            }
            case -2063871083: {
                if (bl) {
                    if (n2 != -969868154) break;
                    n3 = 139;
                    break;
                }
                n3 = 139;
                break;
            }
            case -1924972566: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 106;
                    break;
                }
                n3 = 106;
                break;
            }
            case -1915854272: {
                if (bl) {
                    if (n2 != -113987859) break;
                    n3 = 146;
                    break;
                }
                n3 = 146;
                break;
            }
            case -1831849040: {
                if (bl) {
                    if (n2 != -633848249) break;
                    n3 = 91;
                    break;
                }
                n3 = 91;
                break;
            }
            case -1826640880: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 131;
                    break;
                }
                n3 = 131;
                break;
            }
            case -1776226757: {
                if (bl) {
                    if (n2 != 1974431619) break;
                    n3 = 88;
                    break;
                }
                n3 = 88;
                break;
            }
            case -1765845337: {
                if (bl) {
                    if (n2 != 162571868) break;
                    n3 = 149;
                    break;
                }
                n3 = 149;
                break;
            }
            case -1726615305: {
                if (bl) {
                    if (n2 != -1746740954) break;
                    n3 = 90;
                    break;
                }
                n3 = 90;
                break;
            }
            case -1725569717: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 117;
                    break;
                }
                n3 = 117;
                break;
            }
            case -1691403924: {
                if (bl) {
                    if (n2 != 1783949470) break;
                    n3 = 102;
                    break;
                }
                n3 = 102;
                break;
            }
            case -1626201033: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 85;
                    break;
                }
                n3 = 85;
                break;
            }
            case -1604980789: {
                if (bl) {
                    if (n2 != -1866337497) break;
                    n3 = 119;
                    break;
                }
                n3 = 119;
                break;
            }
            case -1518674028: {
                if (bl) {
                    if (n2 != 2084990025) break;
                    n3 = 103;
                    break;
                }
                n3 = 103;
                break;
            }
            case -1449023303: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 127;
                    break;
                }
                n3 = 127;
                break;
            }
            case -1429363748: {
                if (bl) {
                    if (n2 == 17) {
                        n3 = 121;
                        break;
                    }
                    if (n2 != 1760295979) break;
                    n3 = 122;
                    break;
                }
                n3 = 121;
                break;
            }
            case -1249364743: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 151;
                    break;
                }
                n3 = 151;
                break;
            }
            case -1244771758: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 133;
                    break;
                }
                n3 = 133;
                break;
            }
            case -1213972435: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 137;
                    break;
                }
                n3 = 137;
                break;
            }
            case -983143078: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 142;
                    break;
                }
                n3 = 142;
                break;
            }
            case -939364879: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 135;
                    break;
                }
                n3 = 135;
                break;
            }
            case -924516878: {
                if (bl) {
                    if (n2 != 187837535) break;
                    n3 = 105;
                    break;
                }
                n3 = 105;
                break;
            }
            case -871447126: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 144;
                    break;
                }
                n3 = 144;
                break;
            }
            case -868700596: {
                if (bl) {
                    if (n2 != 162571868) break;
                    n3 = 150;
                    break;
                }
                n3 = 150;
                break;
            }
            case -809637503: {
                if (bl) {
                    if (n2 != -113987859) break;
                    n3 = 147;
                    break;
                }
                n3 = 147;
                break;
            }
            case -775323769: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 100;
                    break;
                }
                n3 = 100;
                break;
            }
            case -749315117: {
                if (bl) {
                    if (n2 != 2113417289) break;
                    n3 = 113;
                    break;
                }
                n3 = 113;
                break;
            }
            case -706481229: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 161;
                    break;
                }
                n3 = 161;
                break;
            }
            case -645783237: {
                if (bl) {
                    if (n2 != 1043255048) break;
                    n3 = 104;
                    break;
                }
                n3 = 104;
                break;
            }
            case -500208810: {
                if (bl) {
                    if (n2 != 443655006) break;
                    n3 = 155;
                    break;
                }
                n3 = 155;
                break;
            }
            case -462374472: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 128;
                    break;
                }
                n3 = 128;
                break;
            }
            case -402285088: {
                if (bl) {
                    if (n2 != -282811157) break;
                    n3 = 125;
                    break;
                }
                n3 = 125;
                break;
            }
            case -370139596: {
                if (bl) {
                    if (n2 != 1343187563) break;
                    n3 = 148;
                    break;
                }
                n3 = 148;
                break;
            }
            case -366275945: {
                if (bl) {
                    if (n2 != 1142324572) break;
                    n3 = 120;
                    break;
                }
                n3 = 120;
                break;
            }
            case -319924344: {
                if (bl) {
                    if (n2 != 739712016) break;
                    n3 = 94;
                    break;
                }
                n3 = 94;
                break;
            }
            case -276383550: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 129;
                    break;
                }
                n3 = 129;
                break;
            }
            case -236768260: {
                if (bl) {
                    if (n2 == 1375123541) {
                        n3 = 159;
                        break;
                    }
                    if (n2 != -1540244125) break;
                    n3 = 160;
                    break;
                }
                n3 = 159;
                break;
            }
            case -230993306: {
                if (bl) {
                    if (n2 != 975108042) break;
                    n3 = 115;
                    break;
                }
                n3 = 115;
                break;
            }
            case -189148986: {
                if (bl) {
                    if (n2 != 1276482132) break;
                    n3 = 126;
                    break;
                }
                n3 = 126;
                break;
            }
            case -167802320: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 153;
                    break;
                }
                n3 = 153;
                break;
            }
            case -167518468: {
                if (bl) {
                    if (n2 != 2019736939) break;
                    n3 = 111;
                    break;
                }
                n3 = 111;
                break;
            }
            case -121243490: {
                if (bl) {
                    if (n2 != -658959130) break;
                    n3 = 89;
                    break;
                }
                n3 = 89;
                break;
            }
            case -120617019: {
                if (bl) {
                    if (n2 != 1375123541) break;
                    n3 = 96;
                    break;
                }
                n3 = 96;
                break;
            }
            case 304220870: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 134;
                    break;
                }
                n3 = 134;
                break;
            }
            case 313356851: {
                if (bl) {
                    if (n2 != -1318471851) break;
                    n3 = 112;
                    break;
                }
                n3 = 112;
                break;
            }
            case 364591627: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 145;
                    break;
                }
                n3 = 145;
                break;
            }
            case 396276562: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 101;
                    break;
                }
                n3 = 101;
                break;
            }
            case 397149923: {
                if (bl) {
                    if (n2 != 1375123541) break;
                    n3 = 98;
                    break;
                }
                n3 = 98;
                break;
            }
            case 437084938: {
                if (bl) {
                    if (n2 != -969868154) break;
                    n3 = 141;
                    break;
                }
                n3 = 141;
                break;
            }
            case 555523148: {
                if (bl) {
                    if (n2 != 1257842368) break;
                    n3 = 92;
                    break;
                }
                n3 = 92;
                break;
            }
            case 604276475: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 152;
                    break;
                }
                n3 = 152;
                break;
            }
            case 635189896: {
                if (bl) {
                    if (n2 != 975108042) break;
                    n3 = 93;
                    break;
                }
                n3 = 93;
                break;
            }
            case 668173073: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 110;
                    break;
                }
                n3 = 110;
                break;
            }
            case 694012704: {
                if (bl) {
                    if (n2 != -969868154) break;
                    n3 = 140;
                    break;
                }
                n3 = 140;
                break;
            }
            case 905700127: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 99;
                    break;
                }
                n3 = 99;
                break;
            }
            case 1085072092: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 87;
                    break;
                }
                n3 = 87;
                break;
            }
            case 1114824027: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 95;
                    break;
                }
                n3 = 95;
                break;
            }
            case 1261822892: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 114;
                    break;
                }
                n3 = 114;
                break;
            }
            case 1270631828: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 138;
                    break;
                }
                n3 = 138;
                break;
            }
            case 1289395398: {
                if (bl) {
                    if (n2 != -2074413579) break;
                    n3 = 123;
                    break;
                }
                n3 = 123;
                break;
            }
            case 1330496874: {
                if (bl) {
                    if (n2 != 1632564441) break;
                    n3 = 109;
                    break;
                }
                n3 = 109;
                break;
            }
            case 1451197365: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 116;
                    break;
                }
                n3 = 116;
                break;
            }
            case 1460059505: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 130;
                    break;
                }
                n3 = 130;
                break;
            }
            case 1497367438: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 118;
                    break;
                }
                n3 = 118;
                break;
            }
            case 1507515148: {
                if (bl) {
                    if (n2 == -1653679357) {
                        n3 = 156;
                        break;
                    }
                    if (n2 == -1665395196) {
                        n3 = 157;
                        break;
                    }
                    if (n2 != -1432102577) break;
                    n3 = 158;
                    break;
                }
                n3 = 156;
                break;
            }
            case 1559564797: {
                if (bl) {
                    if (n2 != 252699290) break;
                    n3 = 154;
                    break;
                }
                n3 = 154;
                break;
            }
            case 1596846077: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 136;
                    break;
                }
                n3 = 136;
                break;
            }
            case 1652258057: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 97;
                    break;
                }
                n3 = 97;
                break;
            }
            case 1891874706: {
                if (bl) {
                    if (n2 != 2084990025) break;
                    n3 = 107;
                    break;
                }
                n3 = 107;
                break;
            }
            case 1935955832: {
                if (bl) {
                    if (n2 != 94264995) break;
                    n3 = 143;
                    break;
                }
                n3 = 143;
                break;
            }
            case 1965583696: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 86;
                    break;
                }
                n3 = 86;
                break;
            }
            case 2011511871: {
                if (bl) {
                    if (n2 != 162749643) break;
                    n3 = 124;
                    break;
                }
                n3 = 124;
                break;
            }
            case 2133963907: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 132;
                    break;
                }
                n3 = 132;
                break;
            }
        }
        return n3;
    }

    private int a4(int n, boolean bl, int n2) {
        int n3 = -1;
        switch (n) {
            case -2130821816: {
                if (bl) {
                    if (n2 != -325145337) break;
                    n3 = 188;
                    break;
                }
                n3 = 188;
                break;
            }
            case -2063871083: {
                if (bl) {
                    if (n2 != -969868154) break;
                    n3 = 164;
                    break;
                }
                n3 = 164;
                break;
            }
            case -1924972566: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 186;
                    break;
                }
                n3 = 186;
                break;
            }
            case -1915854272: {
                if (bl) {
                    if (n2 != -113987859) break;
                    n3 = 223;
                    break;
                }
                n3 = 223;
                break;
            }
            case -1831849040: {
                if (bl) {
                    if (n2 != -633848249) break;
                    n3 = 172;
                    break;
                }
                n3 = 172;
                break;
            }
            case -1826640880: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 211;
                    break;
                }
                n3 = 211;
                break;
            }
            case -1776226757: {
                if (bl) {
                    if (n2 != 1974431619) break;
                    n3 = 169;
                    break;
                }
                n3 = 169;
                break;
            }
            case -1765845337: {
                if (bl) {
                    if (n2 != 162571868) break;
                    n3 = 226;
                    break;
                }
                n3 = 226;
                break;
            }
            case -1726615305: {
                if (bl) {
                    if (n2 != -1746740954) break;
                    n3 = 171;
                    break;
                }
                n3 = 171;
                break;
            }
            case -1725569717: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 197;
                    break;
                }
                n3 = 197;
                break;
            }
            case -1691403924: {
                if (bl) {
                    if (n2 != 1783949470) break;
                    n3 = 182;
                    break;
                }
                n3 = 182;
                break;
            }
            case -1626201033: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 162;
                    break;
                }
                n3 = 162;
                break;
            }
            case -1604980789: {
                if (bl) {
                    if (n2 != -1866337497) break;
                    n3 = 199;
                    break;
                }
                n3 = 199;
                break;
            }
            case -1518674028: {
                if (bl) {
                    if (n2 != 2084990025) break;
                    n3 = 183;
                    break;
                }
                n3 = 183;
                break;
            }
            case -1449023303: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 207;
                    break;
                }
                n3 = 207;
                break;
            }
            case -1429363748: {
                if (bl) {
                    if (n2 == 17) {
                        n3 = 201;
                        break;
                    }
                    if (n2 != 1760295979) break;
                    n3 = 202;
                    break;
                }
                n3 = 201;
                break;
            }
            case -1249364743: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 228;
                    break;
                }
                n3 = 228;
                break;
            }
            case -1244771758: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 213;
                    break;
                }
                n3 = 213;
                break;
            }
            case -1213972435: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 217;
                    break;
                }
                n3 = 217;
                break;
            }
            case -983143078: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 219;
                    break;
                }
                n3 = 219;
                break;
            }
            case -939364879: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 215;
                    break;
                }
                n3 = 215;
                break;
            }
            case -924516878: {
                if (bl) {
                    if (n2 != 187837535) break;
                    n3 = 185;
                    break;
                }
                n3 = 185;
                break;
            }
            case -871447126: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 221;
                    break;
                }
                n3 = 221;
                break;
            }
            case -868700596: {
                if (bl) {
                    if (n2 != 162571868) break;
                    n3 = 227;
                    break;
                }
                n3 = 227;
                break;
            }
            case -809637503: {
                if (bl) {
                    if (n2 != -113987859) break;
                    n3 = 224;
                    break;
                }
                n3 = 224;
                break;
            }
            case -775323769: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 163;
                    break;
                }
                n3 = 163;
                break;
            }
            case -749315117: {
                if (bl) {
                    if (n2 != 2113417289) break;
                    n3 = 193;
                    break;
                }
                n3 = 193;
                break;
            }
            case -706481229: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 238;
                    break;
                }
                n3 = 238;
                break;
            }
            case -645783237: {
                if (bl) {
                    if (n2 != 1043255048) break;
                    n3 = 184;
                    break;
                }
                n3 = 184;
                break;
            }
            case -500208810: {
                if (bl) {
                    if (n2 != 443655006) break;
                    n3 = 232;
                    break;
                }
                n3 = 232;
                break;
            }
            case -462374472: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 208;
                    break;
                }
                n3 = 208;
                break;
            }
            case -402285088: {
                if (bl) {
                    if (n2 != -282811157) break;
                    n3 = 205;
                    break;
                }
                n3 = 205;
                break;
            }
            case -370139596: {
                if (bl) {
                    if (n2 != 1343187563) break;
                    n3 = 225;
                    break;
                }
                n3 = 225;
                break;
            }
            case -366275945: {
                if (bl) {
                    if (n2 != 1142324572) break;
                    n3 = 200;
                    break;
                }
                n3 = 200;
                break;
            }
            case -319924344: {
                if (bl) {
                    if (n2 != 739712016) break;
                    n3 = 175;
                    break;
                }
                n3 = 175;
                break;
            }
            case -276383550: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 209;
                    break;
                }
                n3 = 209;
                break;
            }
            case -236768260: {
                if (bl) {
                    if (n2 == 1375123541) {
                        n3 = 236;
                        break;
                    }
                    if (n2 != -1540244125) break;
                    n3 = 237;
                    break;
                }
                n3 = 236;
                break;
            }
            case -230993306: {
                if (bl) {
                    if (n2 != 975108042) break;
                    n3 = 195;
                    break;
                }
                n3 = 195;
                break;
            }
            case -189148986: {
                if (bl) {
                    if (n2 != 1276482132) break;
                    n3 = 206;
                    break;
                }
                n3 = 206;
                break;
            }
            case -167802320: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 230;
                    break;
                }
                n3 = 230;
                break;
            }
            case -167518468: {
                if (bl) {
                    if (n2 != 2019736939) break;
                    n3 = 191;
                    break;
                }
                n3 = 191;
                break;
            }
            case -121243490: {
                if (bl) {
                    if (n2 != -658959130) break;
                    n3 = 170;
                    break;
                }
                n3 = 170;
                break;
            }
            case -120617019: {
                if (bl) {
                    if (n2 != 1375123541) break;
                    n3 = 177;
                    break;
                }
                n3 = 177;
                break;
            }
            case 304220870: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 214;
                    break;
                }
                n3 = 214;
                break;
            }
            case 313356851: {
                if (bl) {
                    if (n2 != -1318471851) break;
                    n3 = 192;
                    break;
                }
                n3 = 192;
                break;
            }
            case 364591627: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 222;
                    break;
                }
                n3 = 222;
                break;
            }
            case 396276562: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 181;
                    break;
                }
                n3 = 181;
                break;
            }
            case 397149923: {
                if (bl) {
                    if (n2 != 1375123541) break;
                    n3 = 179;
                    break;
                }
                n3 = 179;
                break;
            }
            case 437084938: {
                if (bl) {
                    if (n2 != -969868154) break;
                    n3 = 166;
                    break;
                }
                n3 = 166;
                break;
            }
            case 555523148: {
                if (bl) {
                    if (n2 != 1257842368) break;
                    n3 = 173;
                    break;
                }
                n3 = 173;
                break;
            }
            case 604276475: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 229;
                    break;
                }
                n3 = 229;
                break;
            }
            case 635189896: {
                if (bl) {
                    if (n2 != 975108042) break;
                    n3 = 174;
                    break;
                }
                n3 = 174;
                break;
            }
            case 668173073: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 190;
                    break;
                }
                n3 = 190;
                break;
            }
            case 694012704: {
                if (bl) {
                    if (n2 != -969868154) break;
                    n3 = 165;
                    break;
                }
                n3 = 165;
                break;
            }
            case 905700127: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 180;
                    break;
                }
                n3 = 180;
                break;
            }
            case 1085072092: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 168;
                    break;
                }
                n3 = 168;
                break;
            }
            case 1114824027: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 176;
                    break;
                }
                n3 = 176;
                break;
            }
            case 1261822892: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 194;
                    break;
                }
                n3 = 194;
                break;
            }
            case 1270631828: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 218;
                    break;
                }
                n3 = 218;
                break;
            }
            case 1289395398: {
                if (bl) {
                    if (n2 != -2074413579) break;
                    n3 = 203;
                    break;
                }
                n3 = 203;
                break;
            }
            case 1330496874: {
                if (bl) {
                    if (n2 != 1632564441) break;
                    n3 = 189;
                    break;
                }
                n3 = 189;
                break;
            }
            case 1451197365: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 196;
                    break;
                }
                n3 = 196;
                break;
            }
            case 1460059505: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 210;
                    break;
                }
                n3 = 210;
                break;
            }
            case 1497367438: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 198;
                    break;
                }
                n3 = 198;
                break;
            }
            case 1507515148: {
                if (bl) {
                    if (n2 == -1653679357) {
                        n3 = 233;
                        break;
                    }
                    if (n2 == -1665395196) {
                        n3 = 234;
                        break;
                    }
                    if (n2 != -1432102577) break;
                    n3 = 235;
                    break;
                }
                n3 = 233;
                break;
            }
            case 1559564797: {
                if (bl) {
                    if (n2 != 252699290) break;
                    n3 = 231;
                    break;
                }
                n3 = 231;
                break;
            }
            case 1596846077: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 216;
                    break;
                }
                n3 = 216;
                break;
            }
            case 1652258057: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 178;
                    break;
                }
                n3 = 178;
                break;
            }
            case 1891874706: {
                if (bl) {
                    if (n2 != 2084990025) break;
                    n3 = 187;
                    break;
                }
                n3 = 187;
                break;
            }
            case 1935955832: {
                if (bl) {
                    if (n2 != 94264995) break;
                    n3 = 220;
                    break;
                }
                n3 = 220;
                break;
            }
            case 1965583696: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 167;
                    break;
                }
                n3 = 167;
                break;
            }
            case 2011511871: {
                if (bl) {
                    if (n2 != 162749643) break;
                    n3 = 204;
                    break;
                }
                n3 = 204;
                break;
            }
            case 2133963907: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 212;
                    break;
                }
                n3 = 212;
                break;
            }
        }
        return n3;
    }

    private int a5(int n, boolean bl, int n2) {
        int n3 = -1;
        switch (n) {
            case -2139586284: {
                if (bl) {
                    if (n2 != -824501419) break;
                    n3 = 241;
                    break;
                }
                n3 = 241;
                break;
            }
            case -2130821816: {
                if (bl) {
                    if (n2 != -325145337) break;
                    n3 = 272;
                    break;
                }
                n3 = 272;
                break;
            }
            case -2089379760: {
                if (bl) {
                    if (n2 != 975108042) break;
                    n3 = 242;
                    break;
                }
                n3 = 242;
                break;
            }
            case -2083810794: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 239;
                    break;
                }
                n3 = 239;
                break;
            }
            case -2063871083: {
                if (bl) {
                    if (n2 != -969868154) break;
                    n3 = 303;
                    break;
                }
                n3 = 303;
                break;
            }
            case -1924972566: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 270;
                    break;
                }
                n3 = 270;
                break;
            }
            case -1919329745: {
                if (bl) {
                    if (n2 != 975108042) break;
                    n3 = 243;
                    break;
                }
                n3 = 243;
                break;
            }
            case -1915854272: {
                if (bl) {
                    if (n2 != -113987859) break;
                    n3 = 310;
                    break;
                }
                n3 = 310;
                break;
            }
            case -1831849040: {
                if (bl) {
                    if (n2 != -633848249) break;
                    n3 = 255;
                    break;
                }
                n3 = 255;
                break;
            }
            case -1826640880: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 295;
                    break;
                }
                n3 = 295;
                break;
            }
            case -1776226757: {
                if (bl) {
                    if (n2 != 1974431619) break;
                    n3 = 252;
                    break;
                }
                n3 = 252;
                break;
            }
            case -1765845337: {
                if (bl) {
                    if (n2 != 162571868) break;
                    n3 = 313;
                    break;
                }
                n3 = 313;
                break;
            }
            case -1726615305: {
                if (bl) {
                    if (n2 != -1746740954) break;
                    n3 = 254;
                    break;
                }
                n3 = 254;
                break;
            }
            case -1725569717: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 281;
                    break;
                }
                n3 = 281;
                break;
            }
            case -1691403924: {
                if (bl) {
                    if (n2 != 1783949470) break;
                    n3 = 266;
                    break;
                }
                n3 = 266;
                break;
            }
            case -1626201033: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 240;
                    break;
                }
                n3 = 240;
                break;
            }
            case -1604980789: {
                if (bl) {
                    if (n2 != -1866337497) break;
                    n3 = 283;
                    break;
                }
                n3 = 283;
                break;
            }
            case -1518674028: {
                if (bl) {
                    if (n2 != 2084990025) break;
                    n3 = 267;
                    break;
                }
                n3 = 267;
                break;
            }
            case -1449023303: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 291;
                    break;
                }
                n3 = 291;
                break;
            }
            case -1429363748: {
                if (bl) {
                    if (n2 == 17) {
                        n3 = 285;
                        break;
                    }
                    if (n2 != 1760295979) break;
                    n3 = 286;
                    break;
                }
                n3 = 285;
                break;
            }
            case -1303492032: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 244;
                    break;
                }
                n3 = 244;
                break;
            }
            case -1249364743: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 315;
                    break;
                }
                n3 = 315;
                break;
            }
            case -1244771758: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 297;
                    break;
                }
                n3 = 297;
                break;
            }
            case -1213972435: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 301;
                    break;
                }
                n3 = 301;
                break;
            }
            case -983143078: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 306;
                    break;
                }
                n3 = 306;
                break;
            }
            case -939364879: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 299;
                    break;
                }
                n3 = 299;
                break;
            }
            case -924516878: {
                if (bl) {
                    if (n2 != 187837535) break;
                    n3 = 269;
                    break;
                }
                n3 = 269;
                break;
            }
            case -871447126: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 308;
                    break;
                }
                n3 = 308;
                break;
            }
            case -868700596: {
                if (bl) {
                    if (n2 != 162571868) break;
                    n3 = 314;
                    break;
                }
                n3 = 314;
                break;
            }
            case -809637503: {
                if (bl) {
                    if (n2 != -113987859) break;
                    n3 = 311;
                    break;
                }
                n3 = 311;
                break;
            }
            case -775323769: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 264;
                    break;
                }
                n3 = 264;
                break;
            }
            case -749315117: {
                if (bl) {
                    if (n2 != 2113417289) break;
                    n3 = 277;
                    break;
                }
                n3 = 277;
                break;
            }
            case -706481229: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 325;
                    break;
                }
                n3 = 325;
                break;
            }
            case -645783237: {
                if (bl) {
                    if (n2 != 1043255048) break;
                    n3 = 268;
                    break;
                }
                n3 = 268;
                break;
            }
            case -500208810: {
                if (bl) {
                    if (n2 != 443655006) break;
                    n3 = 319;
                    break;
                }
                n3 = 319;
                break;
            }
            case -462374472: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 292;
                    break;
                }
                n3 = 292;
                break;
            }
            case -402285088: {
                if (bl) {
                    if (n2 != -282811157) break;
                    n3 = 289;
                    break;
                }
                n3 = 289;
                break;
            }
            case -370139596: {
                if (bl) {
                    if (n2 != 1343187563) break;
                    n3 = 312;
                    break;
                }
                n3 = 312;
                break;
            }
            case -366275945: {
                if (bl) {
                    if (n2 != 1142324572) break;
                    n3 = 284;
                    break;
                }
                n3 = 284;
                break;
            }
            case -319924344: {
                if (bl) {
                    if (n2 != 739712016) break;
                    n3 = 258;
                    break;
                }
                n3 = 258;
                break;
            }
            case -276383550: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 293;
                    break;
                }
                n3 = 293;
                break;
            }
            case -236768260: {
                if (bl) {
                    if (n2 == 1375123541) {
                        n3 = 323;
                        break;
                    }
                    if (n2 != -1540244125) break;
                    n3 = 324;
                    break;
                }
                n3 = 323;
                break;
            }
            case -230993306: {
                if (bl) {
                    if (n2 != 975108042) break;
                    n3 = 279;
                    break;
                }
                n3 = 279;
                break;
            }
            case -189148986: {
                if (bl) {
                    if (n2 != 1276482132) break;
                    n3 = 290;
                    break;
                }
                n3 = 290;
                break;
            }
            case -167802320: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 317;
                    break;
                }
                n3 = 317;
                break;
            }
            case -167518468: {
                if (bl) {
                    if (n2 != 2019736939) break;
                    n3 = 275;
                    break;
                }
                n3 = 275;
                break;
            }
            case -121243490: {
                if (bl) {
                    if (n2 != -658959130) break;
                    n3 = 253;
                    break;
                }
                n3 = 253;
                break;
            }
            case -120617019: {
                if (bl) {
                    if (n2 != 1375123541) break;
                    n3 = 260;
                    break;
                }
                n3 = 260;
                break;
            }
            case -6742323: {
                if (bl) {
                    if (n2 != -190761050) break;
                    n3 = 245;
                    break;
                }
                n3 = 245;
                break;
            }
            case 101067189: {
                if (bl) {
                    if (n2 != 975108042) break;
                    n3 = 246;
                    break;
                }
                n3 = 246;
                break;
            }
            case 304220870: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 298;
                    break;
                }
                n3 = 298;
                break;
            }
            case 313356851: {
                if (bl) {
                    if (n2 != -1318471851) break;
                    n3 = 276;
                    break;
                }
                n3 = 276;
                break;
            }
            case 364591627: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 309;
                    break;
                }
                n3 = 309;
                break;
            }
            case 396276562: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 265;
                    break;
                }
                n3 = 265;
                break;
            }
            case 397149923: {
                if (bl) {
                    if (n2 != 1375123541) break;
                    n3 = 262;
                    break;
                }
                n3 = 262;
                break;
            }
            case 437084938: {
                if (bl) {
                    if (n2 != -969868154) break;
                    n3 = 305;
                    break;
                }
                n3 = 305;
                break;
            }
            case 555523148: {
                if (bl) {
                    if (n2 != 1257842368) break;
                    n3 = 256;
                    break;
                }
                n3 = 256;
                break;
            }
            case 604276475: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 316;
                    break;
                }
                n3 = 316;
                break;
            }
            case 635189896: {
                if (bl) {
                    if (n2 != 975108042) break;
                    n3 = 257;
                    break;
                }
                n3 = 257;
                break;
            }
            case 668173073: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 274;
                    break;
                }
                n3 = 274;
                break;
            }
            case 694012704: {
                if (bl) {
                    if (n2 != -969868154) break;
                    n3 = 304;
                    break;
                }
                n3 = 304;
                break;
            }
            case 857481202: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 247;
                    break;
                }
                n3 = 247;
                break;
            }
            case 905700127: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 263;
                    break;
                }
                n3 = 263;
                break;
            }
            case 1085072092: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 251;
                    break;
                }
                n3 = 251;
                break;
            }
            case 1106385797: {
                if (bl) {
                    if (n2 != 148318748) break;
                    n3 = 248;
                    break;
                }
                n3 = 248;
                break;
            }
            case 1114824027: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 259;
                    break;
                }
                n3 = 259;
                break;
            }
            case 1261822892: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 278;
                    break;
                }
                n3 = 278;
                break;
            }
            case 1270631828: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 302;
                    break;
                }
                n3 = 302;
                break;
            }
            case 1289395398: {
                if (bl) {
                    if (n2 != -2074413579) break;
                    n3 = 287;
                    break;
                }
                n3 = 287;
                break;
            }
            case 1330496874: {
                if (bl) {
                    if (n2 != 1632564441) break;
                    n3 = 273;
                    break;
                }
                n3 = 273;
                break;
            }
            case 1376966321: {
                if (bl) {
                    if (n2 != -652084908) break;
                    n3 = 249;
                    break;
                }
                n3 = 249;
                break;
            }
            case 1451197365: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 280;
                    break;
                }
                n3 = 280;
                break;
            }
            case 1460059505: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 294;
                    break;
                }
                n3 = 294;
                break;
            }
            case 1497367438: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 282;
                    break;
                }
                n3 = 282;
                break;
            }
            case 1507515148: {
                if (bl) {
                    if (n2 == -1653679357) {
                        n3 = 320;
                        break;
                    }
                    if (n2 == -1665395196) {
                        n3 = 321;
                        break;
                    }
                    if (n2 != -1432102577) break;
                    n3 = 322;
                    break;
                }
                n3 = 320;
                break;
            }
            case 1559564797: {
                if (bl) {
                    if (n2 != 252699290) break;
                    n3 = 318;
                    break;
                }
                n3 = 318;
                break;
            }
            case 1596846077: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 300;
                    break;
                }
                n3 = 300;
                break;
            }
            case 1652258057: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 261;
                    break;
                }
                n3 = 261;
                break;
            }
            case 1891874706: {
                if (bl) {
                    if (n2 != 2084990025) break;
                    n3 = 271;
                    break;
                }
                n3 = 271;
                break;
            }
            case 1935955832: {
                if (bl) {
                    if (n2 != 94264995) break;
                    n3 = 307;
                    break;
                }
                n3 = 307;
                break;
            }
            case 1965583696: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 250;
                    break;
                }
                n3 = 250;
                break;
            }
            case 2011511871: {
                if (bl) {
                    if (n2 != 162749643) break;
                    n3 = 288;
                    break;
                }
                n3 = 288;
                break;
            }
            case 2133963907: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 296;
                    break;
                }
                n3 = 296;
                break;
            }
        }
        return n3;
    }

    private int a6(int n, boolean bl, int n2) {
        int n3 = -1;
        switch (n) {
            case -2130821816: {
                if (bl) {
                    if (n2 != -325145337) break;
                    n3 = 349;
                    break;
                }
                n3 = 349;
                break;
            }
            case -2063871083: {
                if (bl) {
                    if (n2 != -969868154) break;
                    n3 = 380;
                    break;
                }
                n3 = 380;
                break;
            }
            case -1924972566: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 347;
                    break;
                }
                n3 = 347;
                break;
            }
            case -1915854272: {
                if (bl) {
                    if (n2 != -113987859) break;
                    n3 = 387;
                    break;
                }
                n3 = 387;
                break;
            }
            case -1831849040: {
                if (bl) {
                    if (n2 != -633848249) break;
                    n3 = 332;
                    break;
                }
                n3 = 332;
                break;
            }
            case -1826640880: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 372;
                    break;
                }
                n3 = 372;
                break;
            }
            case -1776226757: {
                if (bl) {
                    if (n2 != 1974431619) break;
                    n3 = 329;
                    break;
                }
                n3 = 329;
                break;
            }
            case -1765845337: {
                if (bl) {
                    if (n2 != 162571868) break;
                    n3 = 390;
                    break;
                }
                n3 = 390;
                break;
            }
            case -1726615305: {
                if (bl) {
                    if (n2 != -1746740954) break;
                    n3 = 331;
                    break;
                }
                n3 = 331;
                break;
            }
            case -1725569717: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 358;
                    break;
                }
                n3 = 358;
                break;
            }
            case -1691403924: {
                if (bl) {
                    if (n2 != 1783949470) break;
                    n3 = 343;
                    break;
                }
                n3 = 343;
                break;
            }
            case -1626201033: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 326;
                    break;
                }
                n3 = 326;
                break;
            }
            case -1604980789: {
                if (bl) {
                    if (n2 != -1866337497) break;
                    n3 = 360;
                    break;
                }
                n3 = 360;
                break;
            }
            case -1518674028: {
                if (bl) {
                    if (n2 != 2084990025) break;
                    n3 = 344;
                    break;
                }
                n3 = 344;
                break;
            }
            case -1449023303: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 368;
                    break;
                }
                n3 = 368;
                break;
            }
            case -1429363748: {
                if (bl) {
                    if (n2 == 17) {
                        n3 = 362;
                        break;
                    }
                    if (n2 != 1760295979) break;
                    n3 = 363;
                    break;
                }
                n3 = 362;
                break;
            }
            case -1249364743: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 392;
                    break;
                }
                n3 = 392;
                break;
            }
            case -1244771758: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 374;
                    break;
                }
                n3 = 374;
                break;
            }
            case -1213972435: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 378;
                    break;
                }
                n3 = 378;
                break;
            }
            case -983143078: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 383;
                    break;
                }
                n3 = 383;
                break;
            }
            case -939364879: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 376;
                    break;
                }
                n3 = 376;
                break;
            }
            case -924516878: {
                if (bl) {
                    if (n2 != 187837535) break;
                    n3 = 346;
                    break;
                }
                n3 = 346;
                break;
            }
            case -871447126: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 385;
                    break;
                }
                n3 = 385;
                break;
            }
            case -868700596: {
                if (bl) {
                    if (n2 != 162571868) break;
                    n3 = 391;
                    break;
                }
                n3 = 391;
                break;
            }
            case -809637503: {
                if (bl) {
                    if (n2 != -113987859) break;
                    n3 = 388;
                    break;
                }
                n3 = 388;
                break;
            }
            case -775323769: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 341;
                    break;
                }
                n3 = 341;
                break;
            }
            case -749315117: {
                if (bl) {
                    if (n2 != 2113417289) break;
                    n3 = 354;
                    break;
                }
                n3 = 354;
                break;
            }
            case -706481229: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 402;
                    break;
                }
                n3 = 402;
                break;
            }
            case -645783237: {
                if (bl) {
                    if (n2 != 1043255048) break;
                    n3 = 345;
                    break;
                }
                n3 = 345;
                break;
            }
            case -500208810: {
                if (bl) {
                    if (n2 != 443655006) break;
                    n3 = 396;
                    break;
                }
                n3 = 396;
                break;
            }
            case -462374472: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 369;
                    break;
                }
                n3 = 369;
                break;
            }
            case -402285088: {
                if (bl) {
                    if (n2 != -282811157) break;
                    n3 = 366;
                    break;
                }
                n3 = 366;
                break;
            }
            case -370139596: {
                if (bl) {
                    if (n2 != 1343187563) break;
                    n3 = 389;
                    break;
                }
                n3 = 389;
                break;
            }
            case -366275945: {
                if (bl) {
                    if (n2 != 1142324572) break;
                    n3 = 361;
                    break;
                }
                n3 = 361;
                break;
            }
            case -319924344: {
                if (bl) {
                    if (n2 != 739712016) break;
                    n3 = 335;
                    break;
                }
                n3 = 335;
                break;
            }
            case -276383550: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 370;
                    break;
                }
                n3 = 370;
                break;
            }
            case -236768260: {
                if (bl) {
                    if (n2 == 1375123541) {
                        n3 = 400;
                        break;
                    }
                    if (n2 != -1540244125) break;
                    n3 = 401;
                    break;
                }
                n3 = 400;
                break;
            }
            case -230993306: {
                if (bl) {
                    if (n2 != 975108042) break;
                    n3 = 356;
                    break;
                }
                n3 = 356;
                break;
            }
            case -189148986: {
                if (bl) {
                    if (n2 != 1276482132) break;
                    n3 = 367;
                    break;
                }
                n3 = 367;
                break;
            }
            case -167802320: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 394;
                    break;
                }
                n3 = 394;
                break;
            }
            case -167518468: {
                if (bl) {
                    if (n2 != 2019736939) break;
                    n3 = 352;
                    break;
                }
                n3 = 352;
                break;
            }
            case -121243490: {
                if (bl) {
                    if (n2 != -658959130) break;
                    n3 = 330;
                    break;
                }
                n3 = 330;
                break;
            }
            case -120617019: {
                if (bl) {
                    if (n2 != 1375123541) break;
                    n3 = 337;
                    break;
                }
                n3 = 337;
                break;
            }
            case 304220870: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 375;
                    break;
                }
                n3 = 375;
                break;
            }
            case 313356851: {
                if (bl) {
                    if (n2 != -1318471851) break;
                    n3 = 353;
                    break;
                }
                n3 = 353;
                break;
            }
            case 364591627: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 386;
                    break;
                }
                n3 = 386;
                break;
            }
            case 396276562: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 342;
                    break;
                }
                n3 = 342;
                break;
            }
            case 397149923: {
                if (bl) {
                    if (n2 != 1375123541) break;
                    n3 = 339;
                    break;
                }
                n3 = 339;
                break;
            }
            case 437084938: {
                if (bl) {
                    if (n2 != -969868154) break;
                    n3 = 382;
                    break;
                }
                n3 = 382;
                break;
            }
            case 555523148: {
                if (bl) {
                    if (n2 != 1257842368) break;
                    n3 = 333;
                    break;
                }
                n3 = 333;
                break;
            }
            case 604276475: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 393;
                    break;
                }
                n3 = 393;
                break;
            }
            case 635189896: {
                if (bl) {
                    if (n2 != 975108042) break;
                    n3 = 334;
                    break;
                }
                n3 = 334;
                break;
            }
            case 668173073: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 351;
                    break;
                }
                n3 = 351;
                break;
            }
            case 694012704: {
                if (bl) {
                    if (n2 != -969868154) break;
                    n3 = 381;
                    break;
                }
                n3 = 381;
                break;
            }
            case 905700127: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 340;
                    break;
                }
                n3 = 340;
                break;
            }
            case 1085072092: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 328;
                    break;
                }
                n3 = 328;
                break;
            }
            case 1114824027: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 336;
                    break;
                }
                n3 = 336;
                break;
            }
            case 1261822892: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 355;
                    break;
                }
                n3 = 355;
                break;
            }
            case 1270631828: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 379;
                    break;
                }
                n3 = 379;
                break;
            }
            case 1289395398: {
                if (bl) {
                    if (n2 != -2074413579) break;
                    n3 = 364;
                    break;
                }
                n3 = 364;
                break;
            }
            case 1330496874: {
                if (bl) {
                    if (n2 != 1632564441) break;
                    n3 = 350;
                    break;
                }
                n3 = 350;
                break;
            }
            case 1451197365: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 357;
                    break;
                }
                n3 = 357;
                break;
            }
            case 1460059505: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 371;
                    break;
                }
                n3 = 371;
                break;
            }
            case 1497367438: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 359;
                    break;
                }
                n3 = 359;
                break;
            }
            case 1507515148: {
                if (bl) {
                    if (n2 == -1653679357) {
                        n3 = 397;
                        break;
                    }
                    if (n2 == -1665395196) {
                        n3 = 398;
                        break;
                    }
                    if (n2 != -1432102577) break;
                    n3 = 399;
                    break;
                }
                n3 = 397;
                break;
            }
            case 1559564797: {
                if (bl) {
                    if (n2 != 252699290) break;
                    n3 = 395;
                    break;
                }
                n3 = 395;
                break;
            }
            case 1596846077: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 377;
                    break;
                }
                n3 = 377;
                break;
            }
            case 1652258057: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 338;
                    break;
                }
                n3 = 338;
                break;
            }
            case 1891874706: {
                if (bl) {
                    if (n2 != 2084990025) break;
                    n3 = 348;
                    break;
                }
                n3 = 348;
                break;
            }
            case 1935955832: {
                if (bl) {
                    if (n2 != 94264995) break;
                    n3 = 384;
                    break;
                }
                n3 = 384;
                break;
            }
            case 1965583696: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 327;
                    break;
                }
                n3 = 327;
                break;
            }
            case 2011511871: {
                if (bl) {
                    if (n2 != 162749643) break;
                    n3 = 365;
                    break;
                }
                n3 = 365;
                break;
            }
            case 2133963907: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 373;
                    break;
                }
                n3 = 373;
                break;
            }
        }
        return n3;
    }

    private int a7(int n, boolean bl, int n2) {
        int n3 = -1;
        switch (n) {
            case -2130821816: {
                if (bl) {
                    if (n2 != -325145337) break;
                    n3 = 429;
                    break;
                }
                n3 = 429;
                break;
            }
            case -2063871083: {
                if (bl) {
                    if (n2 != -969868154) break;
                    n3 = 404;
                    break;
                }
                n3 = 404;
                break;
            }
            case -1924972566: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 427;
                    break;
                }
                n3 = 427;
                break;
            }
            case -1915854272: {
                if (bl) {
                    if (n2 != -113987859) break;
                    n3 = 464;
                    break;
                }
                n3 = 464;
                break;
            }
            case -1831849040: {
                if (bl) {
                    if (n2 != -633848249) break;
                    n3 = 412;
                    break;
                }
                n3 = 412;
                break;
            }
            case -1826640880: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 452;
                    break;
                }
                n3 = 452;
                break;
            }
            case -1776226757: {
                if (bl) {
                    if (n2 != 1974431619) break;
                    n3 = 409;
                    break;
                }
                n3 = 409;
                break;
            }
            case -1765845337: {
                if (bl) {
                    if (n2 != 162571868) break;
                    n3 = 467;
                    break;
                }
                n3 = 467;
                break;
            }
            case -1726615305: {
                if (bl) {
                    if (n2 != -1746740954) break;
                    n3 = 411;
                    break;
                }
                n3 = 411;
                break;
            }
            case -1725569717: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 438;
                    break;
                }
                n3 = 438;
                break;
            }
            case -1691403924: {
                if (bl) {
                    if (n2 != 1783949470) break;
                    n3 = 423;
                    break;
                }
                n3 = 423;
                break;
            }
            case -1626201033: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 403;
                    break;
                }
                n3 = 403;
                break;
            }
            case -1604980789: {
                if (bl) {
                    if (n2 != -1866337497) break;
                    n3 = 440;
                    break;
                }
                n3 = 440;
                break;
            }
            case -1518674028: {
                if (bl) {
                    if (n2 != 2084990025) break;
                    n3 = 424;
                    break;
                }
                n3 = 424;
                break;
            }
            case -1449023303: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 448;
                    break;
                }
                n3 = 448;
                break;
            }
            case -1429363748: {
                if (bl) {
                    if (n2 == 17) {
                        n3 = 442;
                        break;
                    }
                    if (n2 != 1760295979) break;
                    n3 = 443;
                    break;
                }
                n3 = 442;
                break;
            }
            case -1249364743: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 469;
                    break;
                }
                n3 = 469;
                break;
            }
            case -1244771758: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 454;
                    break;
                }
                n3 = 454;
                break;
            }
            case -1213972435: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 458;
                    break;
                }
                n3 = 458;
                break;
            }
            case -983143078: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 460;
                    break;
                }
                n3 = 460;
                break;
            }
            case -939364879: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 456;
                    break;
                }
                n3 = 456;
                break;
            }
            case -924516878: {
                if (bl) {
                    if (n2 != 187837535) break;
                    n3 = 426;
                    break;
                }
                n3 = 426;
                break;
            }
            case -871447126: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 462;
                    break;
                }
                n3 = 462;
                break;
            }
            case -868700596: {
                if (bl) {
                    if (n2 != 162571868) break;
                    n3 = 468;
                    break;
                }
                n3 = 468;
                break;
            }
            case -809637503: {
                if (bl) {
                    if (n2 != -113987859) break;
                    n3 = 465;
                    break;
                }
                n3 = 465;
                break;
            }
            case -775323769: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 421;
                    break;
                }
                n3 = 421;
                break;
            }
            case -749315117: {
                if (bl) {
                    if (n2 != 2113417289) break;
                    n3 = 434;
                    break;
                }
                n3 = 434;
                break;
            }
            case -706481229: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 479;
                    break;
                }
                n3 = 479;
                break;
            }
            case -645783237: {
                if (bl) {
                    if (n2 != 1043255048) break;
                    n3 = 425;
                    break;
                }
                n3 = 425;
                break;
            }
            case -500208810: {
                if (bl) {
                    if (n2 != 443655006) break;
                    n3 = 473;
                    break;
                }
                n3 = 473;
                break;
            }
            case -462374472: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 449;
                    break;
                }
                n3 = 449;
                break;
            }
            case -402285088: {
                if (bl) {
                    if (n2 != -282811157) break;
                    n3 = 446;
                    break;
                }
                n3 = 446;
                break;
            }
            case -370139596: {
                if (bl) {
                    if (n2 != 1343187563) break;
                    n3 = 466;
                    break;
                }
                n3 = 466;
                break;
            }
            case -366275945: {
                if (bl) {
                    if (n2 != 1142324572) break;
                    n3 = 441;
                    break;
                }
                n3 = 441;
                break;
            }
            case -319924344: {
                if (bl) {
                    if (n2 != 739712016) break;
                    n3 = 415;
                    break;
                }
                n3 = 415;
                break;
            }
            case -276383550: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 450;
                    break;
                }
                n3 = 450;
                break;
            }
            case -236768260: {
                if (bl) {
                    if (n2 == 1375123541) {
                        n3 = 477;
                        break;
                    }
                    if (n2 != -1540244125) break;
                    n3 = 478;
                    break;
                }
                n3 = 477;
                break;
            }
            case -230993306: {
                if (bl) {
                    if (n2 != 975108042) break;
                    n3 = 436;
                    break;
                }
                n3 = 436;
                break;
            }
            case -189148986: {
                if (bl) {
                    if (n2 != 1276482132) break;
                    n3 = 447;
                    break;
                }
                n3 = 447;
                break;
            }
            case -167802320: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 471;
                    break;
                }
                n3 = 471;
                break;
            }
            case -167518468: {
                if (bl) {
                    if (n2 != 2019736939) break;
                    n3 = 432;
                    break;
                }
                n3 = 432;
                break;
            }
            case -121243490: {
                if (bl) {
                    if (n2 != -658959130) break;
                    n3 = 410;
                    break;
                }
                n3 = 410;
                break;
            }
            case -120617019: {
                if (bl) {
                    if (n2 != 1375123541) break;
                    n3 = 417;
                    break;
                }
                n3 = 417;
                break;
            }
            case 304220870: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 455;
                    break;
                }
                n3 = 455;
                break;
            }
            case 313356851: {
                if (bl) {
                    if (n2 != -1318471851) break;
                    n3 = 433;
                    break;
                }
                n3 = 433;
                break;
            }
            case 364591627: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 463;
                    break;
                }
                n3 = 463;
                break;
            }
            case 396276562: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 422;
                    break;
                }
                n3 = 422;
                break;
            }
            case 397149923: {
                if (bl) {
                    if (n2 != 1375123541) break;
                    n3 = 419;
                    break;
                }
                n3 = 419;
                break;
            }
            case 437084938: {
                if (bl) {
                    if (n2 != -969868154) break;
                    n3 = 406;
                    break;
                }
                n3 = 406;
                break;
            }
            case 555523148: {
                if (bl) {
                    if (n2 != 1257842368) break;
                    n3 = 413;
                    break;
                }
                n3 = 413;
                break;
            }
            case 604276475: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 470;
                    break;
                }
                n3 = 470;
                break;
            }
            case 635189896: {
                if (bl) {
                    if (n2 != 975108042) break;
                    n3 = 414;
                    break;
                }
                n3 = 414;
                break;
            }
            case 668173073: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 431;
                    break;
                }
                n3 = 431;
                break;
            }
            case 694012704: {
                if (bl) {
                    if (n2 != -969868154) break;
                    n3 = 405;
                    break;
                }
                n3 = 405;
                break;
            }
            case 905700127: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 420;
                    break;
                }
                n3 = 420;
                break;
            }
            case 1085072092: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 408;
                    break;
                }
                n3 = 408;
                break;
            }
            case 1114824027: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 416;
                    break;
                }
                n3 = 416;
                break;
            }
            case 1261822892: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 435;
                    break;
                }
                n3 = 435;
                break;
            }
            case 1270631828: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 459;
                    break;
                }
                n3 = 459;
                break;
            }
            case 1289395398: {
                if (bl) {
                    if (n2 != -2074413579) break;
                    n3 = 444;
                    break;
                }
                n3 = 444;
                break;
            }
            case 1330496874: {
                if (bl) {
                    if (n2 != 1632564441) break;
                    n3 = 430;
                    break;
                }
                n3 = 430;
                break;
            }
            case 1451197365: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 437;
                    break;
                }
                n3 = 437;
                break;
            }
            case 1460059505: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 451;
                    break;
                }
                n3 = 451;
                break;
            }
            case 1497367438: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 439;
                    break;
                }
                n3 = 439;
                break;
            }
            case 1507515148: {
                if (bl) {
                    if (n2 == -1653679357) {
                        n3 = 474;
                        break;
                    }
                    if (n2 == -1665395196) {
                        n3 = 475;
                        break;
                    }
                    if (n2 != -1432102577) break;
                    n3 = 476;
                    break;
                }
                n3 = 474;
                break;
            }
            case 1559564797: {
                if (bl) {
                    if (n2 != 252699290) break;
                    n3 = 472;
                    break;
                }
                n3 = 472;
                break;
            }
            case 1596846077: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 457;
                    break;
                }
                n3 = 457;
                break;
            }
            case 1652258057: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 418;
                    break;
                }
                n3 = 418;
                break;
            }
            case 1891874706: {
                if (bl) {
                    if (n2 != 2084990025) break;
                    n3 = 428;
                    break;
                }
                n3 = 428;
                break;
            }
            case 1935955832: {
                if (bl) {
                    if (n2 != 94264995) break;
                    n3 = 461;
                    break;
                }
                n3 = 461;
                break;
            }
            case 1965583696: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 407;
                    break;
                }
                n3 = 407;
                break;
            }
            case 2011511871: {
                if (bl) {
                    if (n2 != 162749643) break;
                    n3 = 445;
                    break;
                }
                n3 = 445;
                break;
            }
            case 2133963907: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 453;
                    break;
                }
                n3 = 453;
                break;
            }
        }
        return n3;
    }

    private int a8(int n, boolean bl, int n2) {
        int n3 = -1;
        switch (n) {
            case -2131944381: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 486;
                    break;
                }
                n3 = 486;
                break;
            }
            case -1977762943: {
                if (bl) {
                    if (n2 != 308362496) break;
                    n3 = 489;
                    break;
                }
                n3 = 489;
                break;
            }
            case -1901694957: {
                if (bl) {
                    if (n2 == 445196039) {
                        n3 = 501;
                        break;
                    }
                    if (n2 != 2132460221) break;
                    n3 = 502;
                    break;
                }
                n3 = 501;
                break;
            }
            case -1626201033: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 482;
                    break;
                }
                n3 = 482;
                break;
            }
            case -1511848403: {
                if (bl) {
                    if (n2 != -1432102577) break;
                    n3 = 493;
                    break;
                }
                n3 = 493;
                break;
            }
            case -1436337697: {
                if (bl) {
                    if (n2 != -1914577695) break;
                    n3 = 481;
                    break;
                }
                n3 = 481;
                break;
            }
            case -1219935195: {
                if (bl) {
                    if (n2 != 1338036665) break;
                    n3 = 495;
                    break;
                }
                n3 = 495;
                break;
            }
            case -1061270606: {
                if (bl) {
                    if (n2 != 1614557543) break;
                    n3 = 484;
                    break;
                }
                n3 = 484;
                break;
            }
            case -975136845: {
                if (bl) {
                    if (n2 != 852604612) break;
                    n3 = 506;
                    break;
                }
                n3 = 506;
                break;
            }
            case -959759320: {
                if (bl) {
                    if (n2 != 1180443371) break;
                    n3 = 488;
                    break;
                }
                n3 = 488;
                break;
            }
            case -706481229: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 517;
                    break;
                }
                n3 = 517;
                break;
            }
            case -500208810: {
                if (bl) {
                    if (n2 != 443655006) break;
                    n3 = 511;
                    break;
                }
                n3 = 511;
                break;
            }
            case -468257638: {
                if (bl) {
                    if (n2 != -48102284) break;
                    n3 = 504;
                    break;
                }
                n3 = 504;
                break;
            }
            case -277050464: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 507;
                    break;
                }
                n3 = 507;
                break;
            }
            case -236768260: {
                if (bl) {
                    if (n2 == 1375123541) {
                        n3 = 515;
                        break;
                    }
                    if (n2 != -1540244125) break;
                    n3 = 516;
                    break;
                }
                n3 = 515;
                break;
            }
            case -167802320: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 508;
                    break;
                }
                n3 = 508;
                break;
            }
            case -125422909: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 483;
                    break;
                }
                n3 = 483;
                break;
            }
            case 108404676: {
                if (bl) {
                    if (n2 != -1200638929) break;
                    n3 = 480;
                    break;
                }
                n3 = 480;
                break;
            }
            case 396276562: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 510;
                    break;
                }
                n3 = 510;
                break;
            }
            case 438663655: {
                if (bl) {
                    if (n2 != -2041716298) break;
                    n3 = 500;
                    break;
                }
                n3 = 500;
                break;
            }
            case 669703071: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 490;
                    break;
                }
                n3 = 490;
                break;
            }
            case 847248758: {
                if (bl) {
                    if (n2 != 453698624) break;
                    n3 = 503;
                    break;
                }
                n3 = 503;
                break;
            }
            case 948548509: {
                if (bl) {
                    if (n2 != 869233153) break;
                    n3 = 496;
                    break;
                }
                n3 = 496;
                break;
            }
            case 1023736811: {
                if (bl) {
                    if (n2 != 1880291129) break;
                    n3 = 505;
                    break;
                }
                n3 = 505;
                break;
            }
            case 1209439399: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 494;
                    break;
                }
                n3 = 494;
                break;
            }
            case 1507515148: {
                if (bl) {
                    if (n2 == -1653679357) {
                        n3 = 512;
                        break;
                    }
                    if (n2 == -1665395196) {
                        n3 = 513;
                        break;
                    }
                    if (n2 != -1432102577) break;
                    n3 = 514;
                    break;
                }
                n3 = 512;
                break;
            }
            case 1516872332: {
                if (bl) {
                    if (n2 != 1349230043) break;
                    n3 = 485;
                    break;
                }
                n3 = 485;
                break;
            }
            case 1536431709: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 492;
                    break;
                }
                n3 = 492;
                break;
            }
            case 1559564797: {
                if (bl) {
                    if (n2 != 252699290) break;
                    n3 = 509;
                    break;
                }
                n3 = 509;
                break;
            }
            case 1869846689: {
                if (bl) {
                    if (n2 == 852604612) {
                        n3 = 498;
                        break;
                    }
                    if (n2 != 956618429) break;
                    n3 = 499;
                    break;
                }
                n3 = 498;
                break;
            }
            case 1872229098: {
                if (bl) {
                    if (n2 != -995993593) break;
                    n3 = 491;
                    break;
                }
                n3 = 491;
                break;
            }
            case 2080292966: {
                if (bl) {
                    if (n2 != -1835783791) break;
                    n3 = 487;
                    break;
                }
                n3 = 487;
                break;
            }
            case 2081258017: {
                if (bl) {
                    if (n2 != -1210437075) break;
                    n3 = 497;
                    break;
                }
                n3 = 497;
                break;
            }
        }
        return n3;
    }

    private int a9(int n, boolean bl, int n2) {
        int n3 = -1;
        switch (n) {
            case -2110725580: {
                if (bl) {
                    if (n2 != 1276482132) break;
                    n3 = 521;
                    break;
                }
                n3 = 521;
                break;
            }
            case -1626201033: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 518;
                    break;
                }
                n3 = 518;
                break;
            }
            case -706481229: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 531;
                    break;
                }
                n3 = 531;
                break;
            }
            case -500208810: {
                if (bl) {
                    if (n2 != 443655006) break;
                    n3 = 525;
                    break;
                }
                n3 = 525;
                break;
            }
            case -236768260: {
                if (bl) {
                    if (n2 == 1375123541) {
                        n3 = 529;
                        break;
                    }
                    if (n2 != -1540244125) break;
                    n3 = 530;
                    break;
                }
                n3 = 529;
                break;
            }
            case -167802320: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 522;
                    break;
                }
                n3 = 522;
                break;
            }
            case -160621426: {
                if (bl) {
                    if (n2 != -2018418629) break;
                    n3 = 520;
                    break;
                }
                n3 = 520;
                break;
            }
            case 396276562: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 524;
                    break;
                }
                n3 = 524;
                break;
            }
            case 1507515148: {
                if (bl) {
                    if (n2 == -1653679357) {
                        n3 = 526;
                        break;
                    }
                    if (n2 == -1665395196) {
                        n3 = 527;
                        break;
                    }
                    if (n2 != -1432102577) break;
                    n3 = 528;
                    break;
                }
                n3 = 526;
                break;
            }
            case 1542579881: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 519;
                    break;
                }
                n3 = 519;
                break;
            }
            case 1559564797: {
                if (bl) {
                    if (n2 != 252699290) break;
                    n3 = 523;
                    break;
                }
                n3 = 523;
                break;
            }
        }
        return n3;
    }

    private int a10(int n, boolean bl, int n2) {
        int n3 = -1;
        switch (n) {
            case -1626201033: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 532;
                    break;
                }
                n3 = 532;
                break;
            }
            case -706481229: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 542;
                    break;
                }
                n3 = 542;
                break;
            }
            case -500208810: {
                if (bl) {
                    if (n2 != 443655006) break;
                    n3 = 536;
                    break;
                }
                n3 = 536;
                break;
            }
            case -236768260: {
                if (bl) {
                    if (n2 == 1375123541) {
                        n3 = 540;
                        break;
                    }
                    if (n2 != -1540244125) break;
                    n3 = 541;
                    break;
                }
                n3 = 540;
                break;
            }
            case -167802320: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 533;
                    break;
                }
                n3 = 533;
                break;
            }
            case 396276562: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 535;
                    break;
                }
                n3 = 535;
                break;
            }
            case 1507515148: {
                if (bl) {
                    if (n2 == -1653679357) {
                        n3 = 537;
                        break;
                    }
                    if (n2 == -1665395196) {
                        n3 = 538;
                        break;
                    }
                    if (n2 != -1432102577) break;
                    n3 = 539;
                    break;
                }
                n3 = 537;
                break;
            }
            case 1559564797: {
                if (bl) {
                    if (n2 != 252699290) break;
                    n3 = 534;
                    break;
                }
                n3 = 534;
                break;
            }
        }
        return n3;
    }

    private int a11(int n, boolean bl, int n2) {
        int n3 = -1;
        switch (n) {
            case -2132731500: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 565;
                    break;
                }
                n3 = 565;
                break;
            }
            case -2067457329: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 637;
                    break;
                }
                n3 = 637;
                break;
            }
            case -2057690647: {
                if (bl) {
                    if (n2 != -238538240) break;
                    n3 = 596;
                    break;
                }
                n3 = 596;
                break;
            }
            case -2044774323: {
                if (bl) {
                    if (n2 != 2084990025) break;
                    n3 = 604;
                    break;
                }
                n3 = 604;
                break;
            }
            case -1969693783: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 552;
                    break;
                }
                n3 = 552;
                break;
            }
            case -1962852098: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 556;
                    break;
                }
                n3 = 556;
                break;
            }
            case -1879572973: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 549;
                    break;
                }
                n3 = 549;
                break;
            }
            case -1870576717: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 625;
                    break;
                }
                n3 = 625;
                break;
            }
            case -1865966877: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 635;
                    break;
                }
                n3 = 635;
                break;
            }
            case -1850568956: {
                if (bl) {
                    if (n2 != 1846307570) break;
                    n3 = 617;
                    break;
                }
                n3 = 617;
                break;
            }
            case -1823740837: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 560;
                    break;
                }
                n3 = 560;
                break;
            }
            case -1719546808: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 607;
                    break;
                }
                n3 = 607;
                break;
            }
            case -1708671555: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 575;
                    break;
                }
                n3 = 575;
                break;
            }
            case -1701822684: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 572;
                    break;
                }
                n3 = 572;
                break;
            }
            case -1683036796: {
                if (bl) {
                    if (n2 != -238538240) break;
                    n3 = 561;
                    break;
                }
                n3 = 561;
                break;
            }
            case -1681505468: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 606;
                    break;
                }
                n3 = 606;
                break;
            }
            case -1664477897: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 590;
                    break;
                }
                n3 = 590;
                break;
            }
            case -1652632091: {
                if (bl) {
                    if (n2 != 1375123541) break;
                    n3 = 591;
                    break;
                }
                n3 = 591;
                break;
            }
            case -1627949963: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 634;
                    break;
                }
                n3 = 634;
                break;
            }
            case -1626201033: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 568;
                    break;
                }
                n3 = 568;
                break;
            }
            case -1493036932: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 548;
                    break;
                }
                n3 = 548;
                break;
            }
            case -1475115087: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 559;
                    break;
                }
                n3 = 559;
                break;
            }
            case -1425584067: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 602;
                    break;
                }
                n3 = 602;
                break;
            }
            case -1422661809: {
                if (bl) {
                    if (n2 != -1653679357) break;
                    n3 = 627;
                    break;
                }
                n3 = 627;
                break;
            }
            case -1374833898: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 628;
                    break;
                }
                n3 = 628;
                break;
            }
            case -1313172663: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 587;
                    break;
                }
                n3 = 587;
                break;
            }
            case -1281727610: {
                if (bl) {
                    if (n2 != 1920279622) break;
                    n3 = 595;
                    break;
                }
                n3 = 595;
                break;
            }
            case -1281327012: {
                if (bl) {
                    if (n2 != 767814030) break;
                    n3 = 630;
                    break;
                }
                n3 = 630;
                break;
            }
            case -1265548473: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 555;
                    break;
                }
                n3 = 555;
                break;
            }
            case -1254756057: {
                if (bl) {
                    if (n2 != -1653679357) break;
                    n3 = 622;
                    break;
                }
                n3 = 622;
                break;
            }
            case -1249364743: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 639;
                    break;
                }
                n3 = 639;
                break;
            }
            case -1203488354: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 614;
                    break;
                }
                n3 = 614;
                break;
            }
            case -1170113086: {
                if (bl) {
                    if (n2 != 975108042) break;
                    n3 = 582;
                    break;
                }
                n3 = 582;
                break;
            }
            case -1139813180: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 545;
                    break;
                }
                n3 = 545;
                break;
            }
            case -1073341927: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 612;
                    break;
                }
                n3 = 612;
                break;
            }
            case -1027777696: {
                if (bl) {
                    if (n2 != -982352613) break;
                    n3 = 593;
                    break;
                }
                n3 = 593;
                break;
            }
            case -961431896: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 546;
                    break;
                }
                n3 = 546;
                break;
            }
            case -934425950: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 566;
                    break;
                }
                n3 = 566;
                break;
            }
            case -924312628: {
                if (bl) {
                    if (n2 != 1375123541) break;
                    n3 = 601;
                    break;
                }
                n3 = 601;
                break;
            }
            case -860259766: {
                if (bl) {
                    if (n2 != -1653475738) break;
                    n3 = 589;
                    break;
                }
                n3 = 589;
                break;
            }
            case -833716573: {
                if (bl) {
                    if (n2 != 1043255048) break;
                    n3 = 543;
                    break;
                }
                n3 = 543;
                break;
            }
            case -748915899: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 567;
                    break;
                }
                n3 = 567;
                break;
            }
            case -724580166: {
                if (bl) {
                    if (n2 != -505595662) break;
                    n3 = 547;
                    break;
                }
                n3 = 547;
                break;
            }
            case -706481229: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 652;
                    break;
                }
                n3 = 652;
                break;
            }
            case -664867245: {
                if (bl) {
                    if (n2 != 1276482132) break;
                    n3 = 619;
                    break;
                }
                n3 = 619;
                break;
            }
            case -586886160: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 597;
                    break;
                }
                n3 = 597;
                break;
            }
            case -584041425: {
                if (bl) {
                    if (n2 != -1600866162) break;
                    n3 = 642;
                    break;
                }
                n3 = 642;
                break;
            }
            case -500208810: {
                if (bl) {
                    if (n2 != 443655006) break;
                    n3 = 646;
                    break;
                }
                n3 = 646;
                break;
            }
            case -444589966: {
                if (bl) {
                    if (n2 != 2084990025) break;
                    n3 = 605;
                    break;
                }
                n3 = 605;
                break;
            }
            case -384959187: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 564;
                    break;
                }
                n3 = 564;
                break;
            }
            case -321286803: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 613;
                    break;
                }
                n3 = 613;
                break;
            }
            case -319587064: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 621;
                    break;
                }
                n3 = 621;
                break;
            }
            case -277080442: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 620;
                    break;
                }
                n3 = 620;
                break;
            }
            case -236768260: {
                if (bl) {
                    if (n2 == 1375123541) {
                        n3 = 650;
                        break;
                    }
                    if (n2 != -1540244125) break;
                    n3 = 651;
                    break;
                }
                n3 = 650;
                break;
            }
            case -167802320: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 644;
                    break;
                }
                n3 = 644;
                break;
            }
            case -94230673: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 571;
                    break;
                }
                n3 = 571;
                break;
            }
            case -80783851: {
                if (bl) {
                    if (n2 != -94011602) break;
                    n3 = 550;
                    break;
                }
                n3 = 550;
                break;
            }
            case -61513375: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 557;
                    break;
                }
                n3 = 557;
                break;
            }
            case -57734934: {
                if (bl) {
                    if (n2 != -645498553) break;
                    n3 = 643;
                    break;
                }
                n3 = 643;
                break;
            }
            case -29549126: {
                if (bl) {
                    if (n2 != -22797681) break;
                    n3 = 562;
                    break;
                }
                n3 = 562;
                break;
            }
            case 26561895: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 586;
                    break;
                }
                n3 = 586;
                break;
            }
            case 37140965: {
                if (bl) {
                    if (n2 != 975108042) break;
                    n3 = 583;
                    break;
                }
                n3 = 583;
                break;
            }
            case 106440811: {
                if (bl) {
                    if (n2 != -1653679357) break;
                    n3 = 611;
                    break;
                }
                n3 = 611;
                break;
            }
            case 138912929: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 579;
                    break;
                }
                n3 = 579;
                break;
            }
            case 148231657: {
                if (bl) {
                    if (n2 != -1653679357) break;
                    n3 = 544;
                    break;
                }
                n3 = 544;
                break;
            }
            case 219130503: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 554;
                    break;
                }
                n3 = 554;
                break;
            }
            case 263108664: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 618;
                    break;
                }
                n3 = 618;
                break;
            }
            case 312162929: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 551;
                    break;
                }
                n3 = 551;
                break;
            }
            case 367323171: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 588;
                    break;
                }
                n3 = 588;
                break;
            }
            case 368205314: {
                if (bl) {
                    if (n2 != -505595662) break;
                    n3 = 592;
                    break;
                }
                n3 = 592;
                break;
            }
            case 388914961: {
                if (bl) {
                    if (n2 != 162749643) break;
                    n3 = 584;
                    break;
                }
                n3 = 584;
                break;
            }
            case 396276562: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 569;
                    break;
                }
                n3 = 569;
                break;
            }
            case 533893241: {
                if (bl) {
                    if (n2 != 133855878) break;
                    n3 = 633;
                    break;
                }
                n3 = 633;
                break;
            }
            case 539369066: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 574;
                    break;
                }
                n3 = 574;
                break;
            }
            case 542789416: {
                if (bl) {
                    if (n2 != -1653679357) break;
                    n3 = 599;
                    break;
                }
                n3 = 599;
                break;
            }
            case 583937411: {
                if (bl) {
                    if (n2 != 1375123541) break;
                    n3 = 641;
                    break;
                }
                n3 = 641;
                break;
            }
            case 634963648: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 563;
                    break;
                }
                n3 = 563;
                break;
            }
            case 652279560: {
                if (bl) {
                    if (n2 != 1375123541) break;
                    n3 = 624;
                    break;
                }
                n3 = 624;
                break;
            }
            case 689850335: {
                if (bl) {
                    if (n2 != -155224285) break;
                    n3 = 578;
                    break;
                }
                n3 = 578;
                break;
            }
            case 698225174: {
                if (bl) {
                    if (n2 != 1487157601) break;
                    n3 = 585;
                    break;
                }
                n3 = 585;
                break;
            }
            case 764991937: {
                if (bl) {
                    if (n2 != 975108042) break;
                    n3 = 608;
                    break;
                }
                n3 = 608;
                break;
            }
            case 829087639: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 616;
                    break;
                }
                n3 = 616;
                break;
            }
            case 867654975: {
                if (bl) {
                    if (n2 != 975108042) break;
                    n3 = 640;
                    break;
                }
                n3 = 640;
                break;
            }
            case 921498591: {
                if (bl) {
                    if (n2 != -1034208512) break;
                    n3 = 553;
                    break;
                }
                n3 = 553;
                break;
            }
            case 924137771: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 609;
                    break;
                }
                n3 = 609;
                break;
            }
            case 930338975: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 598;
                    break;
                }
                n3 = 598;
                break;
            }
            case 1010077888: {
                if (bl) {
                    if (n2 != 174222172) break;
                    n3 = 632;
                    break;
                }
                n3 = 632;
                break;
            }
            case 1011024547: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 626;
                    break;
                }
                n3 = 626;
                break;
            }
            case 1150584079: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 576;
                    break;
                }
                n3 = 576;
                break;
            }
            case 1176172416: {
                if (bl) {
                    if (n2 != -633848249) break;
                    n3 = 636;
                    break;
                }
                n3 = 636;
                break;
            }
            case 1197657479: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 615;
                    break;
                }
                n3 = 615;
                break;
            }
            case 1210916727: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 570;
                    break;
                }
                n3 = 570;
                break;
            }
            case 1320601168: {
                if (bl) {
                    if (n2 != -138599758) break;
                    n3 = 577;
                    break;
                }
                n3 = 577;
                break;
            }
            case 1331079461: {
                if (bl) {
                    if (n2 != -1334304661) break;
                    n3 = 581;
                    break;
                }
                n3 = 581;
                break;
            }
            case 1392042069: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 603;
                    break;
                }
                n3 = 603;
                break;
            }
            case 1408186732: {
                if (bl) {
                    if (n2 != 975108042) break;
                    n3 = 610;
                    break;
                }
                n3 = 610;
                break;
            }
            case 1478647487: {
                if (bl) {
                    if (n2 != 445532934) break;
                    n3 = 580;
                    break;
                }
                n3 = 580;
                break;
            }
            case 1503014605: {
                if (bl) {
                    if (n2 != -1717904281) break;
                    n3 = 629;
                    break;
                }
                n3 = 629;
                break;
            }
            case 1507515148: {
                if (bl) {
                    if (n2 == -1653679357) {
                        n3 = 647;
                        break;
                    }
                    if (n2 == -1665395196) {
                        n3 = 648;
                        break;
                    }
                    if (n2 != -1432102577) break;
                    n3 = 649;
                    break;
                }
                n3 = 647;
                break;
            }
            case 1539159024: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 600;
                    break;
                }
                n3 = 600;
                break;
            }
            case 1559564797: {
                if (bl) {
                    if (n2 != 252699290) break;
                    n3 = 645;
                    break;
                }
                n3 = 645;
                break;
            }
            case 1685621809: {
                if (bl) {
                    if (n2 != -1540244125) break;
                    n3 = 573;
                    break;
                }
                n3 = 573;
                break;
            }
            case 1746183311: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 638;
                    break;
                }
                n3 = 638;
                break;
            }
            case 2034801901: {
                if (bl) {
                    if (n2 != 350261563) break;
                    n3 = 594;
                    break;
                }
                n3 = 594;
                break;
            }
            case 2082863374: {
                if (bl) {
                    if (n2 != 975108042) break;
                    n3 = 631;
                    break;
                }
                n3 = 631;
                break;
            }
            case 2090842567: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 558;
                    break;
                }
                n3 = 558;
                break;
            }
            case 2108693496: {
                if (bl) {
                    if (n2 != 975108042) break;
                    n3 = 623;
                    break;
                }
                n3 = 623;
                break;
            }
        }
        return n3;
    }

    private int a12(int n, boolean bl, int n2) {
        int n3 = -1;
        switch (n) {
            case -1878898216: {
                if (bl) {
                    if (n2 != 1421144674) break;
                    n3 = 674;
                    break;
                }
                n3 = 674;
                break;
            }
            case -1747409371: {
                if (bl) {
                    if (n2 != -57104458) break;
                    n3 = 676;
                    break;
                }
                n3 = 676;
                break;
            }
            case -1708671555: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 655;
                    break;
                }
                n3 = 655;
                break;
            }
            case -1626201033: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 654;
                    break;
                }
                n3 = 654;
                break;
            }
            case -1590285076: {
                if (bl) {
                    if (n2 != -1835783791) break;
                    n3 = 662;
                    break;
                }
                n3 = 662;
                break;
            }
            case -1509174750: {
                if (bl) {
                    if (n2 != 739712016) break;
                    n3 = 663;
                    break;
                }
                n3 = 663;
                break;
            }
            case -1249364743: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 679;
                    break;
                }
                n3 = 679;
                break;
            }
            case -1112755918: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 656;
                    break;
                }
                n3 = 656;
                break;
            }
            case -860394178: {
                if (bl) {
                    if (n2 != 475506037) break;
                    n3 = 678;
                    break;
                }
                n3 = 678;
                break;
            }
            case -706481229: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 689;
                    break;
                }
                n3 = 689;
                break;
            }
            case -606166626: {
                if (bl) {
                    if (n2 != 162749643) break;
                    n3 = 666;
                    break;
                }
                n3 = 666;
                break;
            }
            case -569036218: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 673;
                    break;
                }
                n3 = 673;
                break;
            }
            case -500208810: {
                if (bl) {
                    if (n2 != 443655006) break;
                    n3 = 683;
                    break;
                }
                n3 = 683;
                break;
            }
            case -321555600: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 659;
                    break;
                }
                n3 = 659;
                break;
            }
            case -314031376: {
                if (bl) {
                    if (n2 != 1276482132) break;
                    n3 = 677;
                    break;
                }
                n3 = 677;
                break;
            }
            case -286235160: {
                if (bl) {
                    if (n2 != -1600866162) break;
                    n3 = 667;
                    break;
                }
                n3 = 667;
                break;
            }
            case -246292866: {
                if (bl) {
                    if (n2 != 975108042) break;
                    n3 = 664;
                    break;
                }
                n3 = 664;
                break;
            }
            case -236768260: {
                if (bl) {
                    if (n2 == 1375123541) {
                        n3 = 687;
                        break;
                    }
                    if (n2 != -1540244125) break;
                    n3 = 688;
                    break;
                }
                n3 = 687;
                break;
            }
            case -170892950: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 658;
                    break;
                }
                n3 = 658;
                break;
            }
            case -167802320: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 680;
                    break;
                }
                n3 = 680;
                break;
            }
            case 108404676: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 653;
                    break;
                }
                n3 = 653;
                break;
            }
            case 278131247: {
                if (bl) {
                    if (n2 != -813373144) break;
                    n3 = 670;
                    break;
                }
                n3 = 670;
                break;
            }
            case 295874896: {
                if (bl) {
                    if (n2 != -138599758) break;
                    n3 = 661;
                    break;
                }
                n3 = 661;
                break;
            }
            case 396276562: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 682;
                    break;
                }
                n3 = 682;
                break;
            }
            case 477042275: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 672;
                    break;
                }
                n3 = 672;
                break;
            }
            case 591636673: {
                if (bl) {
                    if (n2 != -266965504) break;
                    n3 = 675;
                    break;
                }
                n3 = 675;
                break;
            }
            case 691164192: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 657;
                    break;
                }
                n3 = 657;
                break;
            }
            case 1133364040: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 665;
                    break;
                }
                n3 = 665;
                break;
            }
            case 1466379549: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 671;
                    break;
                }
                n3 = 671;
                break;
            }
            case 1507515148: {
                if (bl) {
                    if (n2 == -1653679357) {
                        n3 = 684;
                        break;
                    }
                    if (n2 == -1665395196) {
                        n3 = 685;
                        break;
                    }
                    if (n2 != -1432102577) break;
                    n3 = 686;
                    break;
                }
                n3 = 684;
                break;
            }
            case 1559564797: {
                if (bl) {
                    if (n2 != 252699290) break;
                    n3 = 681;
                    break;
                }
                n3 = 681;
                break;
            }
            case 1971483491: {
                if (bl) {
                    if (n2 != 975108042) break;
                    n3 = 669;
                    break;
                }
                n3 = 669;
                break;
            }
            case 2004292500: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 660;
                    break;
                }
                n3 = 660;
                break;
            }
            case 2122146141: {
                if (bl) {
                    if (n2 != -1966435751) break;
                    n3 = 668;
                    break;
                }
                n3 = 668;
                break;
            }
        }
        return n3;
    }

    private int a13(int n, boolean bl, int n2) {
        int n3 = -1;
        switch (n) {
            case -1825927985: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 692;
                    break;
                }
                n3 = 692;
                break;
            }
            case -1711887942: {
                if (bl) {
                    if (n2 != 975108042) break;
                    n3 = 694;
                    break;
                }
                n3 = 694;
                break;
            }
            case -1626201033: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 690;
                    break;
                }
                n3 = 690;
                break;
            }
            case -706481229: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 704;
                    break;
                }
                n3 = 704;
                break;
            }
            case -500208810: {
                if (bl) {
                    if (n2 != 443655006) break;
                    n3 = 698;
                    break;
                }
                n3 = 698;
                break;
            }
            case -236768260: {
                if (bl) {
                    if (n2 == 1375123541) {
                        n3 = 702;
                        break;
                    }
                    if (n2 != -1540244125) break;
                    n3 = 703;
                    break;
                }
                n3 = 702;
                break;
            }
            case -167802320: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 695;
                    break;
                }
                n3 = 695;
                break;
            }
            case 263108664: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 691;
                    break;
                }
                n3 = 691;
                break;
            }
            case 396276562: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 697;
                    break;
                }
                n3 = 697;
                break;
            }
            case 1343823057: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 693;
                    break;
                }
                n3 = 693;
                break;
            }
            case 1507515148: {
                if (bl) {
                    if (n2 == -1653679357) {
                        n3 = 699;
                        break;
                    }
                    if (n2 == -1665395196) {
                        n3 = 700;
                        break;
                    }
                    if (n2 != -1432102577) break;
                    n3 = 701;
                    break;
                }
                n3 = 699;
                break;
            }
            case 1559564797: {
                if (bl) {
                    if (n2 != 252699290) break;
                    n3 = 696;
                    break;
                }
                n3 = 696;
                break;
            }
        }
        return n3;
    }

    private int a14(int n, boolean bl, int n2) {
        int n3 = -1;
        switch (n) {
            case -1626201033: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 705;
                    break;
                }
                n3 = 705;
                break;
            }
            case -1457159810: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 715;
                    break;
                }
                n3 = 715;
                break;
            }
            case -1385626178: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 708;
                    break;
                }
                n3 = 708;
                break;
            }
            case -1383310444: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 709;
                    break;
                }
                n3 = 709;
                break;
            }
            case -1293538934: {
                if (bl) {
                    if (n2 != -138599758) break;
                    n3 = 717;
                    break;
                }
                n3 = 717;
                break;
            }
            case -1138175597: {
                if (bl) {
                    if (n2 != 975108042) break;
                    n3 = 710;
                    break;
                }
                n3 = 710;
                break;
            }
            case -924475539: {
                if (bl) {
                    if (n2 != 975108042) break;
                    n3 = 711;
                    break;
                }
                n3 = 711;
                break;
            }
            case -741171077: {
                if (bl) {
                    if (n2 != 975108042) break;
                    n3 = 719;
                    break;
                }
                n3 = 719;
                break;
            }
            case -740145389: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 720;
                    break;
                }
                n3 = 720;
                break;
            }
            case -706481229: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 733;
                    break;
                }
                n3 = 733;
                break;
            }
            case -617733920: {
                if (bl) {
                    if (n2 != 975108042) break;
                    n3 = 718;
                    break;
                }
                n3 = 718;
                break;
            }
            case -548756573: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 722;
                    break;
                }
                n3 = 722;
                break;
            }
            case -500208810: {
                if (bl) {
                    if (n2 != 443655006) break;
                    n3 = 727;
                    break;
                }
                n3 = 727;
                break;
            }
            case -236768260: {
                if (bl) {
                    if (n2 == 1375123541) {
                        n3 = 731;
                        break;
                    }
                    if (n2 != -1540244125) break;
                    n3 = 732;
                    break;
                }
                n3 = 731;
                break;
            }
            case -198809423: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 706;
                    break;
                }
                n3 = 706;
                break;
            }
            case -167802320: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 724;
                    break;
                }
                n3 = 724;
                break;
            }
            case 133921367: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 723;
                    break;
                }
                n3 = 723;
                break;
            }
            case 364005294: {
                if (bl) {
                    if (n2 != 975108042) break;
                    n3 = 712;
                    break;
                }
                n3 = 712;
                break;
            }
            case 396276562: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 726;
                    break;
                }
                n3 = 726;
                break;
            }
            case 1066881946: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 721;
                    break;
                }
                n3 = 721;
                break;
            }
            case 1149885373: {
                if (bl) {
                    if (n2 != -1432102577) break;
                    n3 = 707;
                    break;
                }
                n3 = 707;
                break;
            }
            case 1471836691: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 713;
                    break;
                }
                n3 = 713;
                break;
            }
            case 1507515148: {
                if (bl) {
                    if (n2 == -1653679357) {
                        n3 = 728;
                        break;
                    }
                    if (n2 == -1665395196) {
                        n3 = 729;
                        break;
                    }
                    if (n2 != -1432102577) break;
                    n3 = 730;
                    break;
                }
                n3 = 728;
                break;
            }
            case 1559564797: {
                if (bl) {
                    if (n2 != 252699290) break;
                    n3 = 725;
                    break;
                }
                n3 = 725;
                break;
            }
            case 1790493601: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 716;
                    break;
                }
                n3 = 716;
                break;
            }
            case 1799994716: {
                if (bl) {
                    if (n2 != 174222172) break;
                    n3 = 714;
                    break;
                }
                n3 = 714;
                break;
            }
        }
        return n3;
    }

    private int a15(int n, boolean bl, int n2) {
        int n3 = -1;
        switch (n) {
            case -2116496698: {
                if (bl) {
                    if (n2 != 128356309) break;
                    n3 = 742;
                    break;
                }
                n3 = 742;
                break;
            }
            case -1948985068: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 741;
                    break;
                }
                n3 = 741;
                break;
            }
            case -1919218314: {
                if (bl) {
                    if (n2 != -138599758) break;
                    n3 = 740;
                    break;
                }
                n3 = 740;
                break;
            }
            case -1713021447: {
                if (bl) {
                    if (n2 != -2136568555) break;
                    n3 = 751;
                    break;
                }
                n3 = 751;
                break;
            }
            case -1626201033: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 734;
                    break;
                }
                n3 = 734;
                break;
            }
            case -1485967576: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 745;
                    break;
                }
                n3 = 745;
                break;
            }
            case -1409717032: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 737;
                    break;
                }
                n3 = 737;
                break;
            }
            case -1409717000: {
                if (bl) {
                    if (n2 != 1372686599) break;
                    n3 = 750;
                    break;
                }
                n3 = 750;
                break;
            }
            case -1310511468: {
                if (bl) {
                    if (n2 != -221409598) break;
                    n3 = 748;
                    break;
                }
                n3 = 748;
                break;
            }
            case -1249361369: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 744;
                    break;
                }
                n3 = 744;
                break;
            }
            case -706481229: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 761;
                    break;
                }
                n3 = 761;
                break;
            }
            case -500208810: {
                if (bl) {
                    if (n2 != 443655006) break;
                    n3 = 755;
                    break;
                }
                n3 = 755;
                break;
            }
            case -283046073: {
                if (bl) {
                    if (n2 != 128356309) break;
                    n3 = 743;
                    break;
                }
                n3 = 743;
                break;
            }
            case -236768260: {
                if (bl) {
                    if (n2 == 1375123541) {
                        n3 = 759;
                        break;
                    }
                    if (n2 != -1540244125) break;
                    n3 = 760;
                    break;
                }
                n3 = 759;
                break;
            }
            case -167802320: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 752;
                    break;
                }
                n3 = 752;
                break;
            }
            case -143431351: {
                if (bl) {
                    if (n2 != 174222172) break;
                    n3 = 747;
                    break;
                }
                n3 = 747;
                break;
            }
            case 209742314: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 736;
                    break;
                }
                n3 = 736;
                break;
            }
            case 263108664: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 735;
                    break;
                }
                n3 = 735;
                break;
            }
            case 396276562: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 754;
                    break;
                }
                n3 = 754;
                break;
            }
            case 695434215: {
                if (bl) {
                    if (n2 != 174222172) break;
                    n3 = 749;
                    break;
                }
                n3 = 749;
                break;
            }
            case 764106168: {
                if (bl) {
                    if (n2 != 174222172) break;
                    n3 = 738;
                    break;
                }
                n3 = 738;
                break;
            }
            case 1333175857: {
                if (bl) {
                    if (n2 != 174222172) break;
                    n3 = 746;
                    break;
                }
                n3 = 746;
                break;
            }
            case 1507515148: {
                if (bl) {
                    if (n2 == -1653679357) {
                        n3 = 756;
                        break;
                    }
                    if (n2 == -1665395196) {
                        n3 = 757;
                        break;
                    }
                    if (n2 != -1432102577) break;
                    n3 = 758;
                    break;
                }
                n3 = 756;
                break;
            }
            case 1559564797: {
                if (bl) {
                    if (n2 != 252699290) break;
                    n3 = 753;
                    break;
                }
                n3 = 753;
                break;
            }
            case 1873887308: {
                if (bl) {
                    if (n2 != 391247366) break;
                    n3 = 739;
                    break;
                }
                n3 = 739;
                break;
            }
        }
        return n3;
    }

    private int a16(int n, boolean bl, int n2) {
        int n3 = -1;
        switch (n) {
            case -2133313908: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 764;
                    break;
                }
                n3 = 764;
                break;
            }
            case -1869930249: {
                if (bl) {
                    if (n2 != -645498553) break;
                    n3 = 762;
                    break;
                }
                n3 = 762;
                break;
            }
            case -1626201033: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 763;
                    break;
                }
                n3 = 763;
                break;
            }
            case -706481229: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 777;
                    break;
                }
                n3 = 777;
                break;
            }
            case -500208810: {
                if (bl) {
                    if (n2 != 443655006) break;
                    n3 = 771;
                    break;
                }
                n3 = 771;
                break;
            }
            case -236768260: {
                if (bl) {
                    if (n2 == 1375123541) {
                        n3 = 775;
                        break;
                    }
                    if (n2 != -1540244125) break;
                    n3 = 776;
                    break;
                }
                n3 = 775;
                break;
            }
            case -167802320: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 768;
                    break;
                }
                n3 = 768;
                break;
            }
            case 251692112: {
                if (bl) {
                    if (n2 != -645498553) break;
                    n3 = 765;
                    break;
                }
                n3 = 765;
                break;
            }
            case 396276562: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 770;
                    break;
                }
                n3 = 770;
                break;
            }
            case 754400506: {
                if (bl) {
                    if (n2 != 975108042) break;
                    n3 = 767;
                    break;
                }
                n3 = 767;
                break;
            }
            case 1507515148: {
                if (bl) {
                    if (n2 == -1653679357) {
                        n3 = 772;
                        break;
                    }
                    if (n2 == -1665395196) {
                        n3 = 773;
                        break;
                    }
                    if (n2 != -1432102577) break;
                    n3 = 774;
                    break;
                }
                n3 = 772;
                break;
            }
            case 1559564797: {
                if (bl) {
                    if (n2 != 252699290) break;
                    n3 = 769;
                    break;
                }
                n3 = 769;
                break;
            }
            case 1847543159: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 766;
                    break;
                }
                n3 = 766;
                break;
            }
        }
        return n3;
    }

    private int a17(int n, boolean bl, int n2) {
        int n3 = -1;
        switch (n) {
            case -1974732855: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 787;
                    break;
                }
                n3 = 787;
                break;
            }
            case -1727877177: {
                if (bl) {
                    if (n2 != 1043255048) break;
                    n3 = 784;
                    break;
                }
                n3 = 784;
                break;
            }
            case -1526929106: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 778;
                    break;
                }
                n3 = 778;
                break;
            }
            case -1150558346: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 785;
                    break;
                }
                n3 = 785;
                break;
            }
            case -822108703: {
                if (bl) {
                    if (n2 != 1043255048) break;
                    n3 = 782;
                    break;
                }
                n3 = 782;
                break;
            }
            case -283450096: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 781;
                    break;
                }
                n3 = 781;
                break;
            }
            case 3237765: {
                if (bl) {
                    if (n2 != -1419203957) break;
                    n3 = 788;
                    break;
                }
                n3 = 788;
                break;
            }
            case 177189683: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 779;
                    break;
                }
                n3 = 779;
                break;
            }
            case 1211451291: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 780;
                    break;
                }
                n3 = 780;
                break;
            }
            case 1831631701: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 786;
                    break;
                }
                n3 = 786;
                break;
            }
            case 2056257627: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 783;
                    break;
                }
                n3 = 783;
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
            case -2086891012: {
                n2 = this.a4(n4, bl, n);
                break;
            }
            case -2062069676: {
                n2 = this.a17(n4, bl, n);
                break;
            }
            case -1796078145: {
                n2 = this.a0(n4, bl, n);
                break;
            }
            case -1669846975: {
                n2 = this.a11(n4, bl, n);
                break;
            }
            case -1497546299: {
                n2 = this.a5(n4, bl, n);
                break;
            }
            case -1420051510: {
                n2 = this.a16(n4, bl, n);
                break;
            }
            case -1243082430: {
                n2 = this.a8(n4, bl, n);
                break;
            }
            case -738529776: {
                n2 = this.a13(n4, bl, n);
                break;
            }
            case -736889144: {
                n2 = this.a7(n4, bl, n);
                break;
            }
            case -389863776: {
                n2 = this.a6(n4, bl, n);
                break;
            }
            case -66669019: {
                n2 = this.a3(n4, bl, n);
                break;
            }
            case 129702918: {
                n2 = this.a12(n4, bl, n);
                break;
            }
            case 178948302: {
                n2 = this.a2(n4, bl, n);
                break;
            }
            case 244426575: {
                n2 = this.a10(n4, bl, n);
                break;
            }
            case 415913525: {
                n2 = this.a1(n4, bl, n);
                break;
            }
            case 832230898: {
                n2 = this.a14(n4, bl, n);
                break;
            }
            case 1896252170: {
                n2 = this.a9(n4, bl, n);
                break;
            }
            case 1941806937: {
                n2 = this.a15(n4, bl, n);
                break;
            }
        }
        return n2;
    }

    private Object f0(int n, Object object, Object[] objectArray) {
        switch (n) {
            case 0: {
                ((DeviceHandlingTarget)object).eject((Medium)objectArray[0]);
                return null;
            }
            case 1: {
                ((DeviceHandlingTarget)object).dsiMediaBaseUpdateDeviceList((DeviceInfo[])objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 2: {
                ((DeviceHandlingTarget)object).dsiMediaBaseUpdateMediaList((MediaInfo[])objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 3: {
                return RuntimeUtil.valueOf(DeviceHandlingTarget.deregister((MediaListObserver)objectArray[0]));
            }
            case 4: {
                ((EjectionTarget)object).eject((SourceId)objectArray[0], (Callback)objectArray[1]);
                return null;
            }
            case 5: {
                ((EjectionTarget)object).onUpdate((Devices)objectArray[0]);
                return null;
            }
            case 6: {
                ((EjectionTarget)object).requestEject((Device)objectArray[0], (ResponseHandler)objectArray[1]);
                return null;
            }
            case 7: {
                ((EjectionTarget)object).cancelEject((Device)objectArray[0]);
                return null;
            }
            case 8: {
                return RuntimeUtil.valueOf(((MediaBapBrowser)object).getComponentId());
            }
            case 9: {
                return ((MediaBapBrowser)object).getState();
            }
            case 10: {
                ((MediaBapBrowser)object).refetch();
                return null;
            }
            case 11: {
                ((MediaBapBrowser)object).registerListFetcher((MediaBrowserListFetcher)objectArray[0]);
                return null;
            }
            case 12: {
                ((MediaBapBrowser)object).registerListHandler((MediaBrowserListHandler)objectArray[0]);
                return null;
            }
            case 13: {
                ((MediaBapBrowser)object).registerStateListener((BrowserStateListener)objectArray[0]);
                return null;
            }
            case 14: {
                ((MediaBapBrowser)object).invalidate((String)objectArray[0]);
                return null;
            }
            case 15: {
                ((MediaBapBrowser)object).rqSetBrowseMedia((MediaCollector)objectArray[0], ((Number)objectArray[1]).intValue(), (ResponseHandler)objectArray[2]);
                return null;
            }
            case 16: {
                ((MediaBapBrowser)object).rqDeactivate((ResponseHandler)objectArray[0]);
                return null;
            }
            case 17: {
                ((MediaBapBrowser)object).dsiMediaBrowserUpdateBrowseMedia(((Number)objectArray[0]).longValue(), ((Number)objectArray[1]).longValue(), ((Number)objectArray[2]).intValue());
                return null;
            }
            case 18: {
                return RuntimeUtil.valueOf(((MediaBapBrowser)object).isDeactivated());
            }
            case 19: {
                ((MediaBapBrowser)object).rqSetBrowseMode(((Number)objectArray[0]).intValue(), (ResponseHandler)objectArray[1]);
                return null;
            }
            case 20: {
                ((MediaBapBrowser)object).dsiMediaBrowserUpdateBrowseMode(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 21: {
                ((MediaBapBrowser)object).rqSetContentFilter(((Number)objectArray[0]).intValue(), (ResponseHandler)objectArray[1]);
                return null;
            }
            case 22: {
                ((MediaBapBrowser)object).dsiMediaBrowserUpdateContentFilter(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 23: {
                return RuntimeUtil.valueOf(((MediaBapBrowser)object).getDefaultContentFilterMask());
            }
            case 24: {
                ((MediaBapBrowser)object).onDevicesUpdated();
                return null;
            }
            case 25: {
                ((MediaBapBrowser)object).rqOpenFolder((ListEntry[])objectArray[0], (ResponseHandler)objectArray[1]);
                return null;
            }
            case 26: {
                ((MediaBapBrowser)object).dsiMediaBrowserUpdateBrowseFolder((ListEntry[])objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 27: {
                ((MediaBapBrowser)object).dsiMediaBrowserUpdateListSize(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue(), ((Number)objectArray[2]).intValue());
                return null;
            }
            case 28: {
                ((MediaBapBrowser)object).rqList(((Number)objectArray[0]).longValue(), ((Number)objectArray[1]).intValue(), ((Number)objectArray[2]).intValue(), ((Number)objectArray[3]).intValue(), (ResponseHandler)objectArray[4]);
                return null;
            }
            case 29: {
                return ((MediaBapBrowser)object).getListResponse();
            }
            case 30: {
                ((MediaBapBrowser)object).dsiMediaBrowserResponseList((ListEntry[])objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 31: {
                ((MediaBapBrowser)object).dsiMediaBrowserUpdateAlphabeticalIndex((CharacterInfo[])objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
        }
        return null;
    }

    private Object f1(int n, Object object, Object[] objectArray) {
        switch (n) {
            case 32: {
                ((MediaBapBrowser)object).rqListEntry(((Number)objectArray[0]).longValue(), ((Number)objectArray[1]).intValue(), (String)objectArray[2], ((Number)objectArray[3]).intValue(), (Boolean)objectArray[4], (ResponseHandler)objectArray[5]);
                return null;
            }
            case 33: {
                return ((MediaBapBrowser)object).getRequestedListEntry();
            }
            case 34: {
                ((MediaBapBrowser)object).setFocusedElement((ExtendedListEntry)objectArray[0]);
                return null;
            }
            case 35: {
                ((MediaBapBrowser)object).rqPickList((long[])objectArray[0], (ResponseHandler)objectArray[1]);
                return null;
            }
            case 36: {
                ((MediaBapBrowser)object).dsiMediaBrowserResponsePickList((ListEntry[])objectArray[0]);
                return null;
            }
            case 37: {
                return ((MediaBapBrowser)object).getRequestedPickList();
            }
            case 38: {
                ((MediaBapBrowser)object).rqFillPathData((ResponseHandler)objectArray[0]);
                return null;
            }
            case 39: {
                return ((MediaBapBrowser)object).getStandardDblPath(((Number)objectArray[0]).intValue());
            }
            case 40: {
                return ((MediaBapBrowser)object).getSelection();
            }
            case 41: {
                return ((MediaBapBrowser)object).createResetSelection();
            }
            case 42: {
                return ((MediaBapBrowser)object).createEntrySelection((PlayMode)objectArray[0], (ListEntry)objectArray[1], (Boolean)objectArray[2], (Boolean)objectArray[3]);
            }
            case 43: {
                return ((MediaBapBrowser)object).createFolderSelection((PlayMode)objectArray[0], (Boolean)objectArray[1], (Boolean)objectArray[2], (Boolean)objectArray[3]);
            }
            case 44: {
                return ((MediaBapBrowser)object).createDefaultSelection();
            }
            case 45: {
                return ((MediaBapBrowser)object).createDefaultSelection((PlayMode)objectArray[0], (Boolean)objectArray[1], (Boolean)objectArray[2]);
            }
            case 46: {
                return ((MediaBapBrowser)object).createPlaySimilarSelection((PlayMode)objectArray[0], (EntryInfo)objectArray[1]);
            }
            case 47: {
                ((MediaBapBrowser)object).rqAddSelection((Selection)objectArray[0], (ResponseHandler)objectArray[1]);
                return null;
            }
            case 48: {
                ((MediaBapBrowser)object).dsiMediaBrowserSelectionResult(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue(), (Boolean)objectArray[2], ((Number)objectArray[3]).longValue(), ((Number)objectArray[4]).longValue(), ((Number)objectArray[5]).longValue(), ((Number)objectArray[6]).longValue(), ((Number)objectArray[7]).longValue());
                return null;
            }
            case 49: {
                ((MediaBapBrowser)object).dsiMediaBrowserAsyncException(((Number)objectArray[0]).intValue(), (String)objectArray[1], ((Number)objectArray[2]).intValue());
                return null;
            }
            case 50: {
                return ((MediaBapBrowser)object).getBrowseMedia();
            }
            case 51: {
                return RuntimeUtil.valueOf(((MediaBapBrowser)object).getBrowseMode());
            }
            case 52: {
                return RuntimeUtil.valueOf(((MediaBapBrowser)object).isInContentMode());
            }
            case 53: {
                return RuntimeUtil.valueOf(((MediaBapBrowser)object).isInRawMode());
            }
            case 54: {
                return RuntimeUtil.valueOf(((MediaBapBrowser)object).getContentFilter());
            }
            case 55: {
                return ((MediaBapBrowser)object).getBrowseFolder();
            }
            case 56: {
                return RuntimeUtil.valueOf(((MediaBapBrowser)object).getListState());
            }
            case 57: {
                ((MediaBapBrowser)object).setListState(((Number)objectArray[0]).intValue());
                return null;
            }
            case 58: {
                return RuntimeUtil.valueOf(((MediaBapBrowser)object).getModeSwitchingState());
            }
            case 59: {
                ((MediaBapBrowser)object).setModeSwitchingState(((Number)objectArray[0]).intValue());
                return null;
            }
            case 60: {
                return RuntimeUtil.valueOf(((MediaBapBrowser)object).isBrowsingAvailable());
            }
            case 61: {
                ((MediaBapBrowser)object).setInitState(((Number)objectArray[0]).intValue());
                return null;
            }
            case 62: {
                return RuntimeUtil.valueOf(((MediaBapBrowser)object).getMatchingBrowseMode((MediaPlayer)objectArray[0]));
            }
            case 63: {
                return ((MediaBapBrowser)object).getMatchingBrowseFolder((MediaPlayer)objectArray[0]);
            }
        }
        return null;
    }

    private Object f2(int n, Object object, Object[] objectArray) {
        switch (n) {
            case 64: {
                return ((MediaBapBrowser)object).getMatchingBrowseEntry((MediaPlayer)objectArray[0]);
            }
            case 65: {
                return ((MediaBapBrowser)object).getPathData();
            }
            case 66: {
                return ((MediaBapBrowser)object).getListEntryPath((ListEntry[])objectArray[0], (ListEntry)objectArray[1]);
            }
            case 67: {
                return RuntimeUtil.valueOf(((MediaBapBrowser)object).getListSize());
            }
            case 68: {
                return ((MediaBapBrowser)object).getListHandler();
            }
            case 69: {
                return ((MediaBapBrowser)object).getAbsolutePathByListEntry((ListEntry)objectArray[0]);
            }
            case 70: {
                ((MediaBapBrowser)object).triggerErrorTextFor((ListEntry)objectArray[0]);
                return null;
            }
            case 71: {
                return ((MediaBapBrowser)object).getListEntryInCache(((Number)objectArray[0]).longValue(), ((Number)objectArray[1]).intValue(), ((Number)objectArray[2]).intValue(), (String)objectArray[3]);
            }
            case 72: {
                return RuntimeUtil.valueOf(((MediaBapBrowser)object).isSetupRequired((MediaCollector)objectArray[0], ((Number)objectArray[1]).intValue()));
            }
            case 73: {
                return RuntimeUtil.valueOf(((MediaBapBrowser)object).isSetBrowseMediaNeeded((MediaCollector)objectArray[0], ((Number)objectArray[1]).intValue()));
            }
            case 74: {
                return ((MediaBapBrowser)object).getDSI();
            }
            case 75: {
                return RuntimeUtil.valueOf(((MediaBapBrowser)object).getInstanceId());
            }
            case 76: {
                ((MediaBapBrowser)object).valueChangedInteger(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 77: {
                ((MediaBapBrowser)object).onUpdate((Devices)objectArray[0]);
                return null;
            }
            case 78: {
                ((MediaBapBrowser)object).rqWaitForFlag((MediaCollector)objectArray[0], ((Number)objectArray[1]).intValue(), (Boolean)objectArray[2], (ResponseHandler)objectArray[3]);
                return null;
            }
            case 79: {
                ((MediaBapBrowser)object).fireResponse((Boolean)objectArray[0]);
                return null;
            }
            case 80: {
                ((MediaBapBrowser)object).fireResponse((boolean)((Boolean)objectArray[0]), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 81: {
                ((MediaBapBrowser)object).fireResponse((boolean)((Boolean)objectArray[0]), (String)objectArray[1]);
                return null;
            }
            case 82: {
                return RuntimeUtil.valueOf(((MediaBapBrowser)object).registerForResponse(((Number)objectArray[0]).intValue(), (ResponseHandler)objectArray[1]));
            }
            case 83: {
                return RuntimeUtil.valueOf(((MediaBapBrowser)object).registerForResponse(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue(), (ResponseHandler)objectArray[2]));
            }
            case 84: {
                return RuntimeUtil.valueOf(((MediaBapBrowser)object).isRegisteredForResponse(((Number)objectArray[0]).intValue()));
            }
            case 85: {
                return RuntimeUtil.valueOf(((MediaHasBrowser)object).getComponentId());
            }
            case 86: {
                return ((MediaHasBrowser)object).getState();
            }
            case 87: {
                ((MediaHasBrowser)object).refetch();
                return null;
            }
            case 88: {
                ((MediaHasBrowser)object).registerListFetcher((MediaBrowserListFetcher)objectArray[0]);
                return null;
            }
            case 89: {
                ((MediaHasBrowser)object).registerListHandler((MediaBrowserListHandler)objectArray[0]);
                return null;
            }
            case 90: {
                ((MediaHasBrowser)object).registerStateListener((BrowserStateListener)objectArray[0]);
                return null;
            }
            case 91: {
                ((MediaHasBrowser)object).invalidate((String)objectArray[0]);
                return null;
            }
            case 92: {
                ((MediaHasBrowser)object).rqSetBrowseMedia((MediaCollector)objectArray[0], ((Number)objectArray[1]).intValue(), (ResponseHandler)objectArray[2]);
                return null;
            }
            case 93: {
                ((MediaHasBrowser)object).rqDeactivate((ResponseHandler)objectArray[0]);
                return null;
            }
            case 94: {
                ((MediaHasBrowser)object).dsiMediaBrowserUpdateBrowseMedia(((Number)objectArray[0]).longValue(), ((Number)objectArray[1]).longValue(), ((Number)objectArray[2]).intValue());
                return null;
            }
            case 95: {
                return RuntimeUtil.valueOf(((MediaHasBrowser)object).isDeactivated());
            }
        }
        return null;
    }

    private Object f3(int n, Object object, Object[] objectArray) {
        switch (n) {
            case 96: {
                ((MediaHasBrowser)object).rqSetBrowseMode(((Number)objectArray[0]).intValue(), (ResponseHandler)objectArray[1]);
                return null;
            }
            case 97: {
                ((MediaHasBrowser)object).dsiMediaBrowserUpdateBrowseMode(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 98: {
                ((MediaHasBrowser)object).rqSetContentFilter(((Number)objectArray[0]).intValue(), (ResponseHandler)objectArray[1]);
                return null;
            }
            case 99: {
                ((MediaHasBrowser)object).dsiMediaBrowserUpdateContentFilter(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 100: {
                return RuntimeUtil.valueOf(((MediaHasBrowser)object).getDefaultContentFilterMask());
            }
            case 101: {
                ((MediaHasBrowser)object).onDevicesUpdated();
                return null;
            }
            case 102: {
                ((MediaHasBrowser)object).rqOpenFolder((ListEntry[])objectArray[0], (ResponseHandler)objectArray[1]);
                return null;
            }
            case 103: {
                ((MediaHasBrowser)object).dsiMediaBrowserUpdateBrowseFolder((ListEntry[])objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 104: {
                ((MediaHasBrowser)object).dsiMediaBrowserUpdateListSize(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue(), ((Number)objectArray[2]).intValue());
                return null;
            }
            case 105: {
                ((MediaHasBrowser)object).rqList(((Number)objectArray[0]).longValue(), ((Number)objectArray[1]).intValue(), ((Number)objectArray[2]).intValue(), ((Number)objectArray[3]).intValue(), (ResponseHandler)objectArray[4]);
                return null;
            }
            case 106: {
                return ((MediaHasBrowser)object).getListResponse();
            }
            case 107: {
                ((MediaHasBrowser)object).dsiMediaBrowserResponseList((ListEntry[])objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 108: {
                ((MediaHasBrowser)object).dsiMediaBrowserUpdateAlphabeticalIndex((CharacterInfo[])objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 109: {
                ((MediaHasBrowser)object).rqListEntry(((Number)objectArray[0]).longValue(), ((Number)objectArray[1]).intValue(), (String)objectArray[2], ((Number)objectArray[3]).intValue(), (Boolean)objectArray[4], (ResponseHandler)objectArray[5]);
                return null;
            }
            case 110: {
                return ((MediaHasBrowser)object).getRequestedListEntry();
            }
            case 111: {
                ((MediaHasBrowser)object).setFocusedElement((ExtendedListEntry)objectArray[0]);
                return null;
            }
            case 112: {
                ((MediaHasBrowser)object).rqPickList((long[])objectArray[0], (ResponseHandler)objectArray[1]);
                return null;
            }
            case 113: {
                ((MediaHasBrowser)object).dsiMediaBrowserResponsePickList((ListEntry[])objectArray[0]);
                return null;
            }
            case 114: {
                return ((MediaHasBrowser)object).getRequestedPickList();
            }
            case 115: {
                ((MediaHasBrowser)object).rqFillPathData((ResponseHandler)objectArray[0]);
                return null;
            }
            case 116: {
                return ((MediaHasBrowser)object).getStandardDblPath(((Number)objectArray[0]).intValue());
            }
            case 117: {
                return ((MediaHasBrowser)object).getSelection();
            }
            case 118: {
                return ((MediaHasBrowser)object).createResetSelection();
            }
            case 119: {
                return ((MediaHasBrowser)object).createEntrySelection((PlayMode)objectArray[0], (ListEntry)objectArray[1], (Boolean)objectArray[2], (Boolean)objectArray[3]);
            }
            case 120: {
                return ((MediaHasBrowser)object).createFolderSelection((PlayMode)objectArray[0], (Boolean)objectArray[1], (Boolean)objectArray[2], (Boolean)objectArray[3]);
            }
            case 121: {
                return ((MediaHasBrowser)object).createDefaultSelection();
            }
            case 122: {
                return ((MediaHasBrowser)object).createDefaultSelection((PlayMode)objectArray[0], (Boolean)objectArray[1], (Boolean)objectArray[2]);
            }
            case 123: {
                return ((MediaHasBrowser)object).createPlaySimilarSelection((PlayMode)objectArray[0], (EntryInfo)objectArray[1]);
            }
            case 124: {
                ((MediaHasBrowser)object).rqAddSelection((Selection)objectArray[0], (ResponseHandler)objectArray[1]);
                return null;
            }
            case 125: {
                ((MediaHasBrowser)object).dsiMediaBrowserSelectionResult(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue(), (Boolean)objectArray[2], ((Number)objectArray[3]).longValue(), ((Number)objectArray[4]).longValue(), ((Number)objectArray[5]).longValue(), ((Number)objectArray[6]).longValue(), ((Number)objectArray[7]).longValue());
                return null;
            }
            case 126: {
                ((MediaHasBrowser)object).dsiMediaBrowserAsyncException(((Number)objectArray[0]).intValue(), (String)objectArray[1], ((Number)objectArray[2]).intValue());
                return null;
            }
            case 127: {
                return ((MediaHasBrowser)object).getBrowseMedia();
            }
        }
        return null;
    }

    private Object f4(int n, Object object, Object[] objectArray) {
        switch (n) {
            case 128: {
                return RuntimeUtil.valueOf(((MediaHasBrowser)object).getBrowseMode());
            }
            case 129: {
                return RuntimeUtil.valueOf(((MediaHasBrowser)object).isInContentMode());
            }
            case 130: {
                return RuntimeUtil.valueOf(((MediaHasBrowser)object).isInRawMode());
            }
            case 131: {
                return RuntimeUtil.valueOf(((MediaHasBrowser)object).getContentFilter());
            }
            case 132: {
                return ((MediaHasBrowser)object).getBrowseFolder();
            }
            case 133: {
                return RuntimeUtil.valueOf(((MediaHasBrowser)object).getListState());
            }
            case 134: {
                ((MediaHasBrowser)object).setListState(((Number)objectArray[0]).intValue());
                return null;
            }
            case 135: {
                return RuntimeUtil.valueOf(((MediaHasBrowser)object).getModeSwitchingState());
            }
            case 136: {
                ((MediaHasBrowser)object).setModeSwitchingState(((Number)objectArray[0]).intValue());
                return null;
            }
            case 137: {
                return RuntimeUtil.valueOf(((MediaHasBrowser)object).isBrowsingAvailable());
            }
            case 138: {
                ((MediaHasBrowser)object).setInitState(((Number)objectArray[0]).intValue());
                return null;
            }
            case 139: {
                return RuntimeUtil.valueOf(((MediaHasBrowser)object).getMatchingBrowseMode((MediaPlayer)objectArray[0]));
            }
            case 140: {
                return ((MediaHasBrowser)object).getMatchingBrowseFolder((MediaPlayer)objectArray[0]);
            }
            case 141: {
                return ((MediaHasBrowser)object).getMatchingBrowseEntry((MediaPlayer)objectArray[0]);
            }
            case 142: {
                return ((MediaHasBrowser)object).getPathData();
            }
            case 143: {
                return ((MediaHasBrowser)object).getListEntryPath((ListEntry[])objectArray[0], (ListEntry)objectArray[1]);
            }
            case 144: {
                return RuntimeUtil.valueOf(((MediaHasBrowser)object).getListSize());
            }
            case 145: {
                return ((MediaHasBrowser)object).getListHandler();
            }
            case 146: {
                return ((MediaHasBrowser)object).getAbsolutePathByListEntry((ListEntry)objectArray[0]);
            }
            case 147: {
                ((MediaHasBrowser)object).triggerErrorTextFor((ListEntry)objectArray[0]);
                return null;
            }
            case 148: {
                return ((MediaHasBrowser)object).getListEntryInCache(((Number)objectArray[0]).longValue(), ((Number)objectArray[1]).intValue(), ((Number)objectArray[2]).intValue(), (String)objectArray[3]);
            }
            case 149: {
                return RuntimeUtil.valueOf(((MediaHasBrowser)object).isSetupRequired((MediaCollector)objectArray[0], ((Number)objectArray[1]).intValue()));
            }
            case 150: {
                return RuntimeUtil.valueOf(((MediaHasBrowser)object).isSetBrowseMediaNeeded((MediaCollector)objectArray[0], ((Number)objectArray[1]).intValue()));
            }
            case 151: {
                return ((MediaHasBrowser)object).getDSI();
            }
            case 152: {
                return RuntimeUtil.valueOf(((MediaHasBrowser)object).getInstanceId());
            }
            case 153: {
                ((MediaHasBrowser)object).valueChangedInteger(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 154: {
                ((MediaHasBrowser)object).onUpdate((Devices)objectArray[0]);
                return null;
            }
            case 155: {
                ((MediaHasBrowser)object).rqWaitForFlag((MediaCollector)objectArray[0], ((Number)objectArray[1]).intValue(), (Boolean)objectArray[2], (ResponseHandler)objectArray[3]);
                return null;
            }
            case 156: {
                ((MediaHasBrowser)object).fireResponse((Boolean)objectArray[0]);
                return null;
            }
            case 157: {
                ((MediaHasBrowser)object).fireResponse((boolean)((Boolean)objectArray[0]), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 158: {
                ((MediaHasBrowser)object).fireResponse((boolean)((Boolean)objectArray[0]), (String)objectArray[1]);
                return null;
            }
            case 159: {
                return RuntimeUtil.valueOf(((MediaHasBrowser)object).registerForResponse(((Number)objectArray[0]).intValue(), (ResponseHandler)objectArray[1]));
            }
        }
        return null;
    }

    private Object f5(int n, Object object, Object[] objectArray) {
        switch (n) {
            case 160: {
                return RuntimeUtil.valueOf(((MediaHasBrowser)object).registerForResponse(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue(), (ResponseHandler)objectArray[2]));
            }
            case 161: {
                return RuntimeUtil.valueOf(((MediaHasBrowser)object).isRegisteredForResponse(((Number)objectArray[0]).intValue()));
            }
            case 162: {
                return RuntimeUtil.valueOf(((MediaCoverBrowser)object).getComponentId());
            }
            case 163: {
                return RuntimeUtil.valueOf(((MediaCoverBrowser)object).getDefaultContentFilterMask());
            }
            case 164: {
                return RuntimeUtil.valueOf(((MediaCoverBrowser)object).getMatchingBrowseMode((MediaPlayer)objectArray[0]));
            }
            case 165: {
                return ((MediaCoverBrowser)object).getMatchingBrowseFolder((MediaPlayer)objectArray[0]);
            }
            case 166: {
                return ((MediaCoverBrowser)object).getMatchingBrowseEntry((MediaPlayer)objectArray[0]);
            }
            case 167: {
                return ((MediaCoverBrowser)object).getState();
            }
            case 168: {
                ((MediaCoverBrowser)object).refetch();
                return null;
            }
            case 169: {
                ((MediaCoverBrowser)object).registerListFetcher((MediaBrowserListFetcher)objectArray[0]);
                return null;
            }
            case 170: {
                ((MediaCoverBrowser)object).registerListHandler((MediaBrowserListHandler)objectArray[0]);
                return null;
            }
            case 171: {
                ((MediaCoverBrowser)object).registerStateListener((BrowserStateListener)objectArray[0]);
                return null;
            }
            case 172: {
                ((MediaCoverBrowser)object).invalidate((String)objectArray[0]);
                return null;
            }
            case 173: {
                ((MediaCoverBrowser)object).rqSetBrowseMedia((MediaCollector)objectArray[0], ((Number)objectArray[1]).intValue(), (ResponseHandler)objectArray[2]);
                return null;
            }
            case 174: {
                ((MediaCoverBrowser)object).rqDeactivate((ResponseHandler)objectArray[0]);
                return null;
            }
            case 175: {
                ((MediaCoverBrowser)object).dsiMediaBrowserUpdateBrowseMedia(((Number)objectArray[0]).longValue(), ((Number)objectArray[1]).longValue(), ((Number)objectArray[2]).intValue());
                return null;
            }
            case 176: {
                return RuntimeUtil.valueOf(((MediaCoverBrowser)object).isDeactivated());
            }
            case 177: {
                ((MediaCoverBrowser)object).rqSetBrowseMode(((Number)objectArray[0]).intValue(), (ResponseHandler)objectArray[1]);
                return null;
            }
            case 178: {
                ((MediaCoverBrowser)object).dsiMediaBrowserUpdateBrowseMode(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 179: {
                ((MediaCoverBrowser)object).rqSetContentFilter(((Number)objectArray[0]).intValue(), (ResponseHandler)objectArray[1]);
                return null;
            }
            case 180: {
                ((MediaCoverBrowser)object).dsiMediaBrowserUpdateContentFilter(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 181: {
                ((MediaCoverBrowser)object).onDevicesUpdated();
                return null;
            }
            case 182: {
                ((MediaCoverBrowser)object).rqOpenFolder((ListEntry[])objectArray[0], (ResponseHandler)objectArray[1]);
                return null;
            }
            case 183: {
                ((MediaCoverBrowser)object).dsiMediaBrowserUpdateBrowseFolder((ListEntry[])objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 184: {
                ((MediaCoverBrowser)object).dsiMediaBrowserUpdateListSize(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue(), ((Number)objectArray[2]).intValue());
                return null;
            }
            case 185: {
                ((MediaCoverBrowser)object).rqList(((Number)objectArray[0]).longValue(), ((Number)objectArray[1]).intValue(), ((Number)objectArray[2]).intValue(), ((Number)objectArray[3]).intValue(), (ResponseHandler)objectArray[4]);
                return null;
            }
            case 186: {
                return ((MediaCoverBrowser)object).getListResponse();
            }
            case 187: {
                ((MediaCoverBrowser)object).dsiMediaBrowserResponseList((ListEntry[])objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 188: {
                ((MediaCoverBrowser)object).dsiMediaBrowserUpdateAlphabeticalIndex((CharacterInfo[])objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 189: {
                ((MediaCoverBrowser)object).rqListEntry(((Number)objectArray[0]).longValue(), ((Number)objectArray[1]).intValue(), (String)objectArray[2], ((Number)objectArray[3]).intValue(), (Boolean)objectArray[4], (ResponseHandler)objectArray[5]);
                return null;
            }
            case 190: {
                return ((MediaCoverBrowser)object).getRequestedListEntry();
            }
            case 191: {
                ((MediaCoverBrowser)object).setFocusedElement((ExtendedListEntry)objectArray[0]);
                return null;
            }
        }
        return null;
    }

    private Object f6(int n, Object object, Object[] objectArray) {
        switch (n) {
            case 192: {
                ((MediaCoverBrowser)object).rqPickList((long[])objectArray[0], (ResponseHandler)objectArray[1]);
                return null;
            }
            case 193: {
                ((MediaCoverBrowser)object).dsiMediaBrowserResponsePickList((ListEntry[])objectArray[0]);
                return null;
            }
            case 194: {
                return ((MediaCoverBrowser)object).getRequestedPickList();
            }
            case 195: {
                ((MediaCoverBrowser)object).rqFillPathData((ResponseHandler)objectArray[0]);
                return null;
            }
            case 196: {
                return ((MediaCoverBrowser)object).getStandardDblPath(((Number)objectArray[0]).intValue());
            }
            case 197: {
                return ((MediaCoverBrowser)object).getSelection();
            }
            case 198: {
                return ((MediaCoverBrowser)object).createResetSelection();
            }
            case 199: {
                return ((MediaCoverBrowser)object).createEntrySelection((PlayMode)objectArray[0], (ListEntry)objectArray[1], (Boolean)objectArray[2], (Boolean)objectArray[3]);
            }
            case 200: {
                return ((MediaCoverBrowser)object).createFolderSelection((PlayMode)objectArray[0], (Boolean)objectArray[1], (Boolean)objectArray[2], (Boolean)objectArray[3]);
            }
            case 201: {
                return ((MediaCoverBrowser)object).createDefaultSelection();
            }
            case 202: {
                return ((MediaCoverBrowser)object).createDefaultSelection((PlayMode)objectArray[0], (Boolean)objectArray[1], (Boolean)objectArray[2]);
            }
            case 203: {
                return ((MediaCoverBrowser)object).createPlaySimilarSelection((PlayMode)objectArray[0], (EntryInfo)objectArray[1]);
            }
            case 204: {
                ((MediaCoverBrowser)object).rqAddSelection((Selection)objectArray[0], (ResponseHandler)objectArray[1]);
                return null;
            }
            case 205: {
                ((MediaCoverBrowser)object).dsiMediaBrowserSelectionResult(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue(), (Boolean)objectArray[2], ((Number)objectArray[3]).longValue(), ((Number)objectArray[4]).longValue(), ((Number)objectArray[5]).longValue(), ((Number)objectArray[6]).longValue(), ((Number)objectArray[7]).longValue());
                return null;
            }
            case 206: {
                ((MediaCoverBrowser)object).dsiMediaBrowserAsyncException(((Number)objectArray[0]).intValue(), (String)objectArray[1], ((Number)objectArray[2]).intValue());
                return null;
            }
            case 207: {
                return ((MediaCoverBrowser)object).getBrowseMedia();
            }
            case 208: {
                return RuntimeUtil.valueOf(((MediaCoverBrowser)object).getBrowseMode());
            }
            case 209: {
                return RuntimeUtil.valueOf(((MediaCoverBrowser)object).isInContentMode());
            }
            case 210: {
                return RuntimeUtil.valueOf(((MediaCoverBrowser)object).isInRawMode());
            }
            case 211: {
                return RuntimeUtil.valueOf(((MediaCoverBrowser)object).getContentFilter());
            }
            case 212: {
                return ((MediaCoverBrowser)object).getBrowseFolder();
            }
            case 213: {
                return RuntimeUtil.valueOf(((MediaCoverBrowser)object).getListState());
            }
            case 214: {
                ((MediaCoverBrowser)object).setListState(((Number)objectArray[0]).intValue());
                return null;
            }
            case 215: {
                return RuntimeUtil.valueOf(((MediaCoverBrowser)object).getModeSwitchingState());
            }
            case 216: {
                ((MediaCoverBrowser)object).setModeSwitchingState(((Number)objectArray[0]).intValue());
                return null;
            }
            case 217: {
                return RuntimeUtil.valueOf(((MediaCoverBrowser)object).isBrowsingAvailable());
            }
            case 218: {
                ((MediaCoverBrowser)object).setInitState(((Number)objectArray[0]).intValue());
                return null;
            }
            case 219: {
                return ((MediaCoverBrowser)object).getPathData();
            }
            case 220: {
                return ((MediaCoverBrowser)object).getListEntryPath((ListEntry[])objectArray[0], (ListEntry)objectArray[1]);
            }
            case 221: {
                return RuntimeUtil.valueOf(((MediaCoverBrowser)object).getListSize());
            }
            case 222: {
                return ((MediaCoverBrowser)object).getListHandler();
            }
            case 223: {
                return ((MediaCoverBrowser)object).getAbsolutePathByListEntry((ListEntry)objectArray[0]);
            }
        }
        return null;
    }

    private Object f7(int n, Object object, Object[] objectArray) {
        switch (n) {
            case 224: {
                ((MediaCoverBrowser)object).triggerErrorTextFor((ListEntry)objectArray[0]);
                return null;
            }
            case 225: {
                return ((MediaCoverBrowser)object).getListEntryInCache(((Number)objectArray[0]).longValue(), ((Number)objectArray[1]).intValue(), ((Number)objectArray[2]).intValue(), (String)objectArray[3]);
            }
            case 226: {
                return RuntimeUtil.valueOf(((MediaCoverBrowser)object).isSetupRequired((MediaCollector)objectArray[0], ((Number)objectArray[1]).intValue()));
            }
            case 227: {
                return RuntimeUtil.valueOf(((MediaCoverBrowser)object).isSetBrowseMediaNeeded((MediaCollector)objectArray[0], ((Number)objectArray[1]).intValue()));
            }
            case 228: {
                return ((MediaCoverBrowser)object).getDSI();
            }
            case 229: {
                return RuntimeUtil.valueOf(((MediaCoverBrowser)object).getInstanceId());
            }
            case 230: {
                ((MediaCoverBrowser)object).valueChangedInteger(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 231: {
                ((MediaCoverBrowser)object).onUpdate((Devices)objectArray[0]);
                return null;
            }
            case 232: {
                ((MediaCoverBrowser)object).rqWaitForFlag((MediaCollector)objectArray[0], ((Number)objectArray[1]).intValue(), (Boolean)objectArray[2], (ResponseHandler)objectArray[3]);
                return null;
            }
            case 233: {
                ((MediaCoverBrowser)object).fireResponse((Boolean)objectArray[0]);
                return null;
            }
            case 234: {
                ((MediaCoverBrowser)object).fireResponse((boolean)((Boolean)objectArray[0]), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 235: {
                ((MediaCoverBrowser)object).fireResponse((boolean)((Boolean)objectArray[0]), (String)objectArray[1]);
                return null;
            }
            case 236: {
                return RuntimeUtil.valueOf(((MediaCoverBrowser)object).registerForResponse(((Number)objectArray[0]).intValue(), (ResponseHandler)objectArray[1]));
            }
            case 237: {
                return RuntimeUtil.valueOf(((MediaCoverBrowser)object).registerForResponse(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue(), (ResponseHandler)objectArray[2]));
            }
            case 238: {
                return RuntimeUtil.valueOf(((MediaCoverBrowser)object).isRegisteredForResponse(((Number)objectArray[0]).intValue()));
            }
            case 239: {
                ((MediaMainBrowser)object).setCursorPosition(((Number)objectArray[0]).intValue());
                return null;
            }
            case 240: {
                return RuntimeUtil.valueOf(((MediaMainBrowser)object).getComponentId());
            }
            case 241: {
                ((MediaMainBrowser)object).registerSearchHandler((MediaBrowserSearchHandler)objectArray[0]);
                return null;
            }
            case 242: {
                ((MediaMainBrowser)object).rqActivateSearchSpeller((ResponseHandler)objectArray[0]);
                return null;
            }
            case 243: {
                ((MediaMainBrowser)object).rqDeactivateSearchSpeller((ResponseHandler)objectArray[0]);
                return null;
            }
            case 244: {
                ((MediaMainBrowser)object).dsiMediaBrowserUpdateSearchSpellerState(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 245: {
                ((MediaMainBrowser)object).rqAddChar((String)objectArray[0], ((Number)objectArray[1]).intValue(), ((Number)objectArray[2]).intValue(), ((Number)objectArray[3]).intValue(), (ResponseHandler)objectArray[4]);
                return null;
            }
            case 246: {
                ((MediaMainBrowser)object).rqDeleteChar((ResponseHandler)objectArray[0]);
                return null;
            }
            case 247: {
                ((MediaMainBrowser)object).executeSearch();
                return null;
            }
            case 248: {
                ((MediaMainBrowser)object).dsiMediaBrowserUpdateSearchSize(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue(), ((Number)objectArray[2]).intValue(), ((Number)objectArray[3]).intValue(), ((Number)objectArray[4]).intValue());
                return null;
            }
            case 249: {
                ((MediaMainBrowser)object).dsiMediaBrowserResponseSearchListExt((SearchListEntryExt[])objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 250: {
                return ((MediaMainBrowser)object).getState();
            }
            case 251: {
                ((MediaMainBrowser)object).refetch();
                return null;
            }
            case 252: {
                ((MediaMainBrowser)object).registerListFetcher((MediaBrowserListFetcher)objectArray[0]);
                return null;
            }
            case 253: {
                ((MediaMainBrowser)object).registerListHandler((MediaBrowserListHandler)objectArray[0]);
                return null;
            }
            case 254: {
                ((MediaMainBrowser)object).registerStateListener((BrowserStateListener)objectArray[0]);
                return null;
            }
            case 255: {
                ((MediaMainBrowser)object).invalidate((String)objectArray[0]);
                return null;
            }
        }
        return null;
    }

    private Object f8(int n, Object object, Object[] objectArray) {
        switch (n) {
            case 256: {
                ((MediaMainBrowser)object).rqSetBrowseMedia((MediaCollector)objectArray[0], ((Number)objectArray[1]).intValue(), (ResponseHandler)objectArray[2]);
                return null;
            }
            case 257: {
                ((MediaMainBrowser)object).rqDeactivate((ResponseHandler)objectArray[0]);
                return null;
            }
            case 258: {
                ((MediaMainBrowser)object).dsiMediaBrowserUpdateBrowseMedia(((Number)objectArray[0]).longValue(), ((Number)objectArray[1]).longValue(), ((Number)objectArray[2]).intValue());
                return null;
            }
            case 259: {
                return RuntimeUtil.valueOf(((MediaMainBrowser)object).isDeactivated());
            }
            case 260: {
                ((MediaMainBrowser)object).rqSetBrowseMode(((Number)objectArray[0]).intValue(), (ResponseHandler)objectArray[1]);
                return null;
            }
            case 261: {
                ((MediaMainBrowser)object).dsiMediaBrowserUpdateBrowseMode(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 262: {
                ((MediaMainBrowser)object).rqSetContentFilter(((Number)objectArray[0]).intValue(), (ResponseHandler)objectArray[1]);
                return null;
            }
            case 263: {
                ((MediaMainBrowser)object).dsiMediaBrowserUpdateContentFilter(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 264: {
                return RuntimeUtil.valueOf(((MediaMainBrowser)object).getDefaultContentFilterMask());
            }
            case 265: {
                ((MediaMainBrowser)object).onDevicesUpdated();
                return null;
            }
            case 266: {
                ((MediaMainBrowser)object).rqOpenFolder((ListEntry[])objectArray[0], (ResponseHandler)objectArray[1]);
                return null;
            }
            case 267: {
                ((MediaMainBrowser)object).dsiMediaBrowserUpdateBrowseFolder((ListEntry[])objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 268: {
                ((MediaMainBrowser)object).dsiMediaBrowserUpdateListSize(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue(), ((Number)objectArray[2]).intValue());
                return null;
            }
            case 269: {
                ((MediaMainBrowser)object).rqList(((Number)objectArray[0]).longValue(), ((Number)objectArray[1]).intValue(), ((Number)objectArray[2]).intValue(), ((Number)objectArray[3]).intValue(), (ResponseHandler)objectArray[4]);
                return null;
            }
            case 270: {
                return ((MediaMainBrowser)object).getListResponse();
            }
            case 271: {
                ((MediaMainBrowser)object).dsiMediaBrowserResponseList((ListEntry[])objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 272: {
                ((MediaMainBrowser)object).dsiMediaBrowserUpdateAlphabeticalIndex((CharacterInfo[])objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 273: {
                ((MediaMainBrowser)object).rqListEntry(((Number)objectArray[0]).longValue(), ((Number)objectArray[1]).intValue(), (String)objectArray[2], ((Number)objectArray[3]).intValue(), (Boolean)objectArray[4], (ResponseHandler)objectArray[5]);
                return null;
            }
            case 274: {
                return ((MediaMainBrowser)object).getRequestedListEntry();
            }
            case 275: {
                ((MediaMainBrowser)object).setFocusedElement((ExtendedListEntry)objectArray[0]);
                return null;
            }
            case 276: {
                ((MediaMainBrowser)object).rqPickList((long[])objectArray[0], (ResponseHandler)objectArray[1]);
                return null;
            }
            case 277: {
                ((MediaMainBrowser)object).dsiMediaBrowserResponsePickList((ListEntry[])objectArray[0]);
                return null;
            }
            case 278: {
                return ((MediaMainBrowser)object).getRequestedPickList();
            }
            case 279: {
                ((MediaMainBrowser)object).rqFillPathData((ResponseHandler)objectArray[0]);
                return null;
            }
            case 280: {
                return ((MediaMainBrowser)object).getStandardDblPath(((Number)objectArray[0]).intValue());
            }
            case 281: {
                return ((MediaMainBrowser)object).getSelection();
            }
            case 282: {
                return ((MediaMainBrowser)object).createResetSelection();
            }
            case 283: {
                return ((MediaMainBrowser)object).createEntrySelection((PlayMode)objectArray[0], (ListEntry)objectArray[1], (Boolean)objectArray[2], (Boolean)objectArray[3]);
            }
            case 284: {
                return ((MediaMainBrowser)object).createFolderSelection((PlayMode)objectArray[0], (Boolean)objectArray[1], (Boolean)objectArray[2], (Boolean)objectArray[3]);
            }
            case 285: {
                return ((MediaMainBrowser)object).createDefaultSelection();
            }
            case 286: {
                return ((MediaMainBrowser)object).createDefaultSelection((PlayMode)objectArray[0], (Boolean)objectArray[1], (Boolean)objectArray[2]);
            }
            case 287: {
                return ((MediaMainBrowser)object).createPlaySimilarSelection((PlayMode)objectArray[0], (EntryInfo)objectArray[1]);
            }
        }
        return null;
    }

    private Object f9(int n, Object object, Object[] objectArray) {
        switch (n) {
            case 288: {
                ((MediaMainBrowser)object).rqAddSelection((Selection)objectArray[0], (ResponseHandler)objectArray[1]);
                return null;
            }
            case 289: {
                ((MediaMainBrowser)object).dsiMediaBrowserSelectionResult(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue(), (Boolean)objectArray[2], ((Number)objectArray[3]).longValue(), ((Number)objectArray[4]).longValue(), ((Number)objectArray[5]).longValue(), ((Number)objectArray[6]).longValue(), ((Number)objectArray[7]).longValue());
                return null;
            }
            case 290: {
                ((MediaMainBrowser)object).dsiMediaBrowserAsyncException(((Number)objectArray[0]).intValue(), (String)objectArray[1], ((Number)objectArray[2]).intValue());
                return null;
            }
            case 291: {
                return ((MediaMainBrowser)object).getBrowseMedia();
            }
            case 292: {
                return RuntimeUtil.valueOf(((MediaMainBrowser)object).getBrowseMode());
            }
            case 293: {
                return RuntimeUtil.valueOf(((MediaMainBrowser)object).isInContentMode());
            }
            case 294: {
                return RuntimeUtil.valueOf(((MediaMainBrowser)object).isInRawMode());
            }
            case 295: {
                return RuntimeUtil.valueOf(((MediaMainBrowser)object).getContentFilter());
            }
            case 296: {
                return ((MediaMainBrowser)object).getBrowseFolder();
            }
            case 297: {
                return RuntimeUtil.valueOf(((MediaMainBrowser)object).getListState());
            }
            case 298: {
                ((MediaMainBrowser)object).setListState(((Number)objectArray[0]).intValue());
                return null;
            }
            case 299: {
                return RuntimeUtil.valueOf(((MediaMainBrowser)object).getModeSwitchingState());
            }
            case 300: {
                ((MediaMainBrowser)object).setModeSwitchingState(((Number)objectArray[0]).intValue());
                return null;
            }
            case 301: {
                return RuntimeUtil.valueOf(((MediaMainBrowser)object).isBrowsingAvailable());
            }
            case 302: {
                ((MediaMainBrowser)object).setInitState(((Number)objectArray[0]).intValue());
                return null;
            }
            case 303: {
                return RuntimeUtil.valueOf(((MediaMainBrowser)object).getMatchingBrowseMode((MediaPlayer)objectArray[0]));
            }
            case 304: {
                return ((MediaMainBrowser)object).getMatchingBrowseFolder((MediaPlayer)objectArray[0]);
            }
            case 305: {
                return ((MediaMainBrowser)object).getMatchingBrowseEntry((MediaPlayer)objectArray[0]);
            }
            case 306: {
                return ((MediaMainBrowser)object).getPathData();
            }
            case 307: {
                return ((MediaMainBrowser)object).getListEntryPath((ListEntry[])objectArray[0], (ListEntry)objectArray[1]);
            }
            case 308: {
                return RuntimeUtil.valueOf(((MediaMainBrowser)object).getListSize());
            }
            case 309: {
                return ((MediaMainBrowser)object).getListHandler();
            }
            case 310: {
                return ((MediaMainBrowser)object).getAbsolutePathByListEntry((ListEntry)objectArray[0]);
            }
            case 311: {
                ((MediaMainBrowser)object).triggerErrorTextFor((ListEntry)objectArray[0]);
                return null;
            }
            case 312: {
                return ((MediaMainBrowser)object).getListEntryInCache(((Number)objectArray[0]).longValue(), ((Number)objectArray[1]).intValue(), ((Number)objectArray[2]).intValue(), (String)objectArray[3]);
            }
            case 313: {
                return RuntimeUtil.valueOf(((MediaMainBrowser)object).isSetupRequired((MediaCollector)objectArray[0], ((Number)objectArray[1]).intValue()));
            }
            case 314: {
                return RuntimeUtil.valueOf(((MediaMainBrowser)object).isSetBrowseMediaNeeded((MediaCollector)objectArray[0], ((Number)objectArray[1]).intValue()));
            }
            case 315: {
                return ((MediaMainBrowser)object).getDSI();
            }
            case 316: {
                return RuntimeUtil.valueOf(((MediaMainBrowser)object).getInstanceId());
            }
            case 317: {
                ((MediaMainBrowser)object).valueChangedInteger(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 318: {
                ((MediaMainBrowser)object).onUpdate((Devices)objectArray[0]);
                return null;
            }
            case 319: {
                ((MediaMainBrowser)object).rqWaitForFlag((MediaCollector)objectArray[0], ((Number)objectArray[1]).intValue(), (Boolean)objectArray[2], (ResponseHandler)objectArray[3]);
                return null;
            }
        }
        return null;
    }

    private Object f10(int n, Object object, Object[] objectArray) {
        switch (n) {
            case 320: {
                ((MediaMainBrowser)object).fireResponse((Boolean)objectArray[0]);
                return null;
            }
            case 321: {
                ((MediaMainBrowser)object).fireResponse((boolean)((Boolean)objectArray[0]), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 322: {
                ((MediaMainBrowser)object).fireResponse((boolean)((Boolean)objectArray[0]), (String)objectArray[1]);
                return null;
            }
            case 323: {
                return RuntimeUtil.valueOf(((MediaMainBrowser)object).registerForResponse(((Number)objectArray[0]).intValue(), (ResponseHandler)objectArray[1]));
            }
            case 324: {
                return RuntimeUtil.valueOf(((MediaMainBrowser)object).registerForResponse(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue(), (ResponseHandler)objectArray[2]));
            }
            case 325: {
                return RuntimeUtil.valueOf(((MediaMainBrowser)object).isRegisteredForResponse(((Number)objectArray[0]).intValue()));
            }
            case 326: {
                return RuntimeUtil.valueOf(((MediaRecorderBrowser)object).getComponentId());
            }
            case 327: {
                return ((MediaRecorderBrowser)object).getState();
            }
            case 328: {
                ((MediaRecorderBrowser)object).refetch();
                return null;
            }
            case 329: {
                ((MediaRecorderBrowser)object).registerListFetcher((MediaBrowserListFetcher)objectArray[0]);
                return null;
            }
            case 330: {
                ((MediaRecorderBrowser)object).registerListHandler((MediaBrowserListHandler)objectArray[0]);
                return null;
            }
            case 331: {
                ((MediaRecorderBrowser)object).registerStateListener((BrowserStateListener)objectArray[0]);
                return null;
            }
            case 332: {
                ((MediaRecorderBrowser)object).invalidate((String)objectArray[0]);
                return null;
            }
            case 333: {
                ((MediaRecorderBrowser)object).rqSetBrowseMedia((MediaCollector)objectArray[0], ((Number)objectArray[1]).intValue(), (ResponseHandler)objectArray[2]);
                return null;
            }
            case 334: {
                ((MediaRecorderBrowser)object).rqDeactivate((ResponseHandler)objectArray[0]);
                return null;
            }
            case 335: {
                ((MediaRecorderBrowser)object).dsiMediaBrowserUpdateBrowseMedia(((Number)objectArray[0]).longValue(), ((Number)objectArray[1]).longValue(), ((Number)objectArray[2]).intValue());
                return null;
            }
            case 336: {
                return RuntimeUtil.valueOf(((MediaRecorderBrowser)object).isDeactivated());
            }
            case 337: {
                ((MediaRecorderBrowser)object).rqSetBrowseMode(((Number)objectArray[0]).intValue(), (ResponseHandler)objectArray[1]);
                return null;
            }
            case 338: {
                ((MediaRecorderBrowser)object).dsiMediaBrowserUpdateBrowseMode(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 339: {
                ((MediaRecorderBrowser)object).rqSetContentFilter(((Number)objectArray[0]).intValue(), (ResponseHandler)objectArray[1]);
                return null;
            }
            case 340: {
                ((MediaRecorderBrowser)object).dsiMediaBrowserUpdateContentFilter(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 341: {
                return RuntimeUtil.valueOf(((MediaRecorderBrowser)object).getDefaultContentFilterMask());
            }
            case 342: {
                ((MediaRecorderBrowser)object).onDevicesUpdated();
                return null;
            }
            case 343: {
                ((MediaRecorderBrowser)object).rqOpenFolder((ListEntry[])objectArray[0], (ResponseHandler)objectArray[1]);
                return null;
            }
            case 344: {
                ((MediaRecorderBrowser)object).dsiMediaBrowserUpdateBrowseFolder((ListEntry[])objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 345: {
                ((MediaRecorderBrowser)object).dsiMediaBrowserUpdateListSize(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue(), ((Number)objectArray[2]).intValue());
                return null;
            }
            case 346: {
                ((MediaRecorderBrowser)object).rqList(((Number)objectArray[0]).longValue(), ((Number)objectArray[1]).intValue(), ((Number)objectArray[2]).intValue(), ((Number)objectArray[3]).intValue(), (ResponseHandler)objectArray[4]);
                return null;
            }
            case 347: {
                return ((MediaRecorderBrowser)object).getListResponse();
            }
            case 348: {
                ((MediaRecorderBrowser)object).dsiMediaBrowserResponseList((ListEntry[])objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 349: {
                ((MediaRecorderBrowser)object).dsiMediaBrowserUpdateAlphabeticalIndex((CharacterInfo[])objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 350: {
                ((MediaRecorderBrowser)object).rqListEntry(((Number)objectArray[0]).longValue(), ((Number)objectArray[1]).intValue(), (String)objectArray[2], ((Number)objectArray[3]).intValue(), (Boolean)objectArray[4], (ResponseHandler)objectArray[5]);
                return null;
            }
            case 351: {
                return ((MediaRecorderBrowser)object).getRequestedListEntry();
            }
        }
        return null;
    }

    private Object f11(int n, Object object, Object[] objectArray) {
        switch (n) {
            case 352: {
                ((MediaRecorderBrowser)object).setFocusedElement((ExtendedListEntry)objectArray[0]);
                return null;
            }
            case 353: {
                ((MediaRecorderBrowser)object).rqPickList((long[])objectArray[0], (ResponseHandler)objectArray[1]);
                return null;
            }
            case 354: {
                ((MediaRecorderBrowser)object).dsiMediaBrowserResponsePickList((ListEntry[])objectArray[0]);
                return null;
            }
            case 355: {
                return ((MediaRecorderBrowser)object).getRequestedPickList();
            }
            case 356: {
                ((MediaRecorderBrowser)object).rqFillPathData((ResponseHandler)objectArray[0]);
                return null;
            }
            case 357: {
                return ((MediaRecorderBrowser)object).getStandardDblPath(((Number)objectArray[0]).intValue());
            }
            case 358: {
                return ((MediaRecorderBrowser)object).getSelection();
            }
            case 359: {
                return ((MediaRecorderBrowser)object).createResetSelection();
            }
            case 360: {
                return ((MediaRecorderBrowser)object).createEntrySelection((PlayMode)objectArray[0], (ListEntry)objectArray[1], (Boolean)objectArray[2], (Boolean)objectArray[3]);
            }
            case 361: {
                return ((MediaRecorderBrowser)object).createFolderSelection((PlayMode)objectArray[0], (Boolean)objectArray[1], (Boolean)objectArray[2], (Boolean)objectArray[3]);
            }
            case 362: {
                return ((MediaRecorderBrowser)object).createDefaultSelection();
            }
            case 363: {
                return ((MediaRecorderBrowser)object).createDefaultSelection((PlayMode)objectArray[0], (Boolean)objectArray[1], (Boolean)objectArray[2]);
            }
            case 364: {
                return ((MediaRecorderBrowser)object).createPlaySimilarSelection((PlayMode)objectArray[0], (EntryInfo)objectArray[1]);
            }
            case 365: {
                ((MediaRecorderBrowser)object).rqAddSelection((Selection)objectArray[0], (ResponseHandler)objectArray[1]);
                return null;
            }
            case 366: {
                ((MediaRecorderBrowser)object).dsiMediaBrowserSelectionResult(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue(), (Boolean)objectArray[2], ((Number)objectArray[3]).longValue(), ((Number)objectArray[4]).longValue(), ((Number)objectArray[5]).longValue(), ((Number)objectArray[6]).longValue(), ((Number)objectArray[7]).longValue());
                return null;
            }
            case 367: {
                ((MediaRecorderBrowser)object).dsiMediaBrowserAsyncException(((Number)objectArray[0]).intValue(), (String)objectArray[1], ((Number)objectArray[2]).intValue());
                return null;
            }
            case 368: {
                return ((MediaRecorderBrowser)object).getBrowseMedia();
            }
            case 369: {
                return RuntimeUtil.valueOf(((MediaRecorderBrowser)object).getBrowseMode());
            }
            case 370: {
                return RuntimeUtil.valueOf(((MediaRecorderBrowser)object).isInContentMode());
            }
            case 371: {
                return RuntimeUtil.valueOf(((MediaRecorderBrowser)object).isInRawMode());
            }
            case 372: {
                return RuntimeUtil.valueOf(((MediaRecorderBrowser)object).getContentFilter());
            }
            case 373: {
                return ((MediaRecorderBrowser)object).getBrowseFolder();
            }
            case 374: {
                return RuntimeUtil.valueOf(((MediaRecorderBrowser)object).getListState());
            }
            case 375: {
                ((MediaRecorderBrowser)object).setListState(((Number)objectArray[0]).intValue());
                return null;
            }
            case 376: {
                return RuntimeUtil.valueOf(((MediaRecorderBrowser)object).getModeSwitchingState());
            }
            case 377: {
                ((MediaRecorderBrowser)object).setModeSwitchingState(((Number)objectArray[0]).intValue());
                return null;
            }
            case 378: {
                return RuntimeUtil.valueOf(((MediaRecorderBrowser)object).isBrowsingAvailable());
            }
            case 379: {
                ((MediaRecorderBrowser)object).setInitState(((Number)objectArray[0]).intValue());
                return null;
            }
            case 380: {
                return RuntimeUtil.valueOf(((MediaRecorderBrowser)object).getMatchingBrowseMode((MediaPlayer)objectArray[0]));
            }
            case 381: {
                return ((MediaRecorderBrowser)object).getMatchingBrowseFolder((MediaPlayer)objectArray[0]);
            }
            case 382: {
                return ((MediaRecorderBrowser)object).getMatchingBrowseEntry((MediaPlayer)objectArray[0]);
            }
            case 383: {
                return ((MediaRecorderBrowser)object).getPathData();
            }
        }
        return null;
    }

    private Object f12(int n, Object object, Object[] objectArray) {
        switch (n) {
            case 384: {
                return ((MediaRecorderBrowser)object).getListEntryPath((ListEntry[])objectArray[0], (ListEntry)objectArray[1]);
            }
            case 385: {
                return RuntimeUtil.valueOf(((MediaRecorderBrowser)object).getListSize());
            }
            case 386: {
                return ((MediaRecorderBrowser)object).getListHandler();
            }
            case 387: {
                return ((MediaRecorderBrowser)object).getAbsolutePathByListEntry((ListEntry)objectArray[0]);
            }
            case 388: {
                ((MediaRecorderBrowser)object).triggerErrorTextFor((ListEntry)objectArray[0]);
                return null;
            }
            case 389: {
                return ((MediaRecorderBrowser)object).getListEntryInCache(((Number)objectArray[0]).longValue(), ((Number)objectArray[1]).intValue(), ((Number)objectArray[2]).intValue(), (String)objectArray[3]);
            }
            case 390: {
                return RuntimeUtil.valueOf(((MediaRecorderBrowser)object).isSetupRequired((MediaCollector)objectArray[0], ((Number)objectArray[1]).intValue()));
            }
            case 391: {
                return RuntimeUtil.valueOf(((MediaRecorderBrowser)object).isSetBrowseMediaNeeded((MediaCollector)objectArray[0], ((Number)objectArray[1]).intValue()));
            }
            case 392: {
                return ((MediaRecorderBrowser)object).getDSI();
            }
            case 393: {
                return RuntimeUtil.valueOf(((MediaRecorderBrowser)object).getInstanceId());
            }
            case 394: {
                ((MediaRecorderBrowser)object).valueChangedInteger(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 395: {
                ((MediaRecorderBrowser)object).onUpdate((Devices)objectArray[0]);
                return null;
            }
            case 396: {
                ((MediaRecorderBrowser)object).rqWaitForFlag((MediaCollector)objectArray[0], ((Number)objectArray[1]).intValue(), (Boolean)objectArray[2], (ResponseHandler)objectArray[3]);
                return null;
            }
            case 397: {
                ((MediaRecorderBrowser)object).fireResponse((Boolean)objectArray[0]);
                return null;
            }
            case 398: {
                ((MediaRecorderBrowser)object).fireResponse((boolean)((Boolean)objectArray[0]), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 399: {
                ((MediaRecorderBrowser)object).fireResponse((boolean)((Boolean)objectArray[0]), (String)objectArray[1]);
                return null;
            }
            case 400: {
                return RuntimeUtil.valueOf(((MediaRecorderBrowser)object).registerForResponse(((Number)objectArray[0]).intValue(), (ResponseHandler)objectArray[1]));
            }
            case 401: {
                return RuntimeUtil.valueOf(((MediaRecorderBrowser)object).registerForResponse(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue(), (ResponseHandler)objectArray[2]));
            }
            case 402: {
                return RuntimeUtil.valueOf(((MediaRecorderBrowser)object).isRegisteredForResponse(((Number)objectArray[0]).intValue()));
            }
            case 403: {
                return RuntimeUtil.valueOf(((MediaSpeechBrowser)object).getComponentId());
            }
            case 404: {
                return RuntimeUtil.valueOf(((MediaSpeechBrowser)object).getMatchingBrowseMode((MediaPlayer)objectArray[0]));
            }
            case 405: {
                return ((MediaSpeechBrowser)object).getMatchingBrowseFolder((MediaPlayer)objectArray[0]);
            }
            case 406: {
                return ((MediaSpeechBrowser)object).getMatchingBrowseEntry((MediaPlayer)objectArray[0]);
            }
            case 407: {
                return ((MediaSpeechBrowser)object).getState();
            }
            case 408: {
                ((MediaSpeechBrowser)object).refetch();
                return null;
            }
            case 409: {
                ((MediaSpeechBrowser)object).registerListFetcher((MediaBrowserListFetcher)objectArray[0]);
                return null;
            }
            case 410: {
                ((MediaSpeechBrowser)object).registerListHandler((MediaBrowserListHandler)objectArray[0]);
                return null;
            }
            case 411: {
                ((MediaSpeechBrowser)object).registerStateListener((BrowserStateListener)objectArray[0]);
                return null;
            }
            case 412: {
                ((MediaSpeechBrowser)object).invalidate((String)objectArray[0]);
                return null;
            }
            case 413: {
                ((MediaSpeechBrowser)object).rqSetBrowseMedia((MediaCollector)objectArray[0], ((Number)objectArray[1]).intValue(), (ResponseHandler)objectArray[2]);
                return null;
            }
            case 414: {
                ((MediaSpeechBrowser)object).rqDeactivate((ResponseHandler)objectArray[0]);
                return null;
            }
            case 415: {
                ((MediaSpeechBrowser)object).dsiMediaBrowserUpdateBrowseMedia(((Number)objectArray[0]).longValue(), ((Number)objectArray[1]).longValue(), ((Number)objectArray[2]).intValue());
                return null;
            }
        }
        return null;
    }

    private Object f13(int n, Object object, Object[] objectArray) {
        switch (n) {
            case 416: {
                return RuntimeUtil.valueOf(((MediaSpeechBrowser)object).isDeactivated());
            }
            case 417: {
                ((MediaSpeechBrowser)object).rqSetBrowseMode(((Number)objectArray[0]).intValue(), (ResponseHandler)objectArray[1]);
                return null;
            }
            case 418: {
                ((MediaSpeechBrowser)object).dsiMediaBrowserUpdateBrowseMode(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 419: {
                ((MediaSpeechBrowser)object).rqSetContentFilter(((Number)objectArray[0]).intValue(), (ResponseHandler)objectArray[1]);
                return null;
            }
            case 420: {
                ((MediaSpeechBrowser)object).dsiMediaBrowserUpdateContentFilter(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 421: {
                return RuntimeUtil.valueOf(((MediaSpeechBrowser)object).getDefaultContentFilterMask());
            }
            case 422: {
                ((MediaSpeechBrowser)object).onDevicesUpdated();
                return null;
            }
            case 423: {
                ((MediaSpeechBrowser)object).rqOpenFolder((ListEntry[])objectArray[0], (ResponseHandler)objectArray[1]);
                return null;
            }
            case 424: {
                ((MediaSpeechBrowser)object).dsiMediaBrowserUpdateBrowseFolder((ListEntry[])objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 425: {
                ((MediaSpeechBrowser)object).dsiMediaBrowserUpdateListSize(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue(), ((Number)objectArray[2]).intValue());
                return null;
            }
            case 426: {
                ((MediaSpeechBrowser)object).rqList(((Number)objectArray[0]).longValue(), ((Number)objectArray[1]).intValue(), ((Number)objectArray[2]).intValue(), ((Number)objectArray[3]).intValue(), (ResponseHandler)objectArray[4]);
                return null;
            }
            case 427: {
                return ((MediaSpeechBrowser)object).getListResponse();
            }
            case 428: {
                ((MediaSpeechBrowser)object).dsiMediaBrowserResponseList((ListEntry[])objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 429: {
                ((MediaSpeechBrowser)object).dsiMediaBrowserUpdateAlphabeticalIndex((CharacterInfo[])objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 430: {
                ((MediaSpeechBrowser)object).rqListEntry(((Number)objectArray[0]).longValue(), ((Number)objectArray[1]).intValue(), (String)objectArray[2], ((Number)objectArray[3]).intValue(), (Boolean)objectArray[4], (ResponseHandler)objectArray[5]);
                return null;
            }
            case 431: {
                return ((MediaSpeechBrowser)object).getRequestedListEntry();
            }
            case 432: {
                ((MediaSpeechBrowser)object).setFocusedElement((ExtendedListEntry)objectArray[0]);
                return null;
            }
            case 433: {
                ((MediaSpeechBrowser)object).rqPickList((long[])objectArray[0], (ResponseHandler)objectArray[1]);
                return null;
            }
            case 434: {
                ((MediaSpeechBrowser)object).dsiMediaBrowserResponsePickList((ListEntry[])objectArray[0]);
                return null;
            }
            case 435: {
                return ((MediaSpeechBrowser)object).getRequestedPickList();
            }
            case 436: {
                ((MediaSpeechBrowser)object).rqFillPathData((ResponseHandler)objectArray[0]);
                return null;
            }
            case 437: {
                return ((MediaSpeechBrowser)object).getStandardDblPath(((Number)objectArray[0]).intValue());
            }
            case 438: {
                return ((MediaSpeechBrowser)object).getSelection();
            }
            case 439: {
                return ((MediaSpeechBrowser)object).createResetSelection();
            }
            case 440: {
                return ((MediaSpeechBrowser)object).createEntrySelection((PlayMode)objectArray[0], (ListEntry)objectArray[1], (Boolean)objectArray[2], (Boolean)objectArray[3]);
            }
            case 441: {
                return ((MediaSpeechBrowser)object).createFolderSelection((PlayMode)objectArray[0], (Boolean)objectArray[1], (Boolean)objectArray[2], (Boolean)objectArray[3]);
            }
            case 442: {
                return ((MediaSpeechBrowser)object).createDefaultSelection();
            }
            case 443: {
                return ((MediaSpeechBrowser)object).createDefaultSelection((PlayMode)objectArray[0], (Boolean)objectArray[1], (Boolean)objectArray[2]);
            }
            case 444: {
                return ((MediaSpeechBrowser)object).createPlaySimilarSelection((PlayMode)objectArray[0], (EntryInfo)objectArray[1]);
            }
            case 445: {
                ((MediaSpeechBrowser)object).rqAddSelection((Selection)objectArray[0], (ResponseHandler)objectArray[1]);
                return null;
            }
            case 446: {
                ((MediaSpeechBrowser)object).dsiMediaBrowserSelectionResult(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue(), (Boolean)objectArray[2], ((Number)objectArray[3]).longValue(), ((Number)objectArray[4]).longValue(), ((Number)objectArray[5]).longValue(), ((Number)objectArray[6]).longValue(), ((Number)objectArray[7]).longValue());
                return null;
            }
            case 447: {
                ((MediaSpeechBrowser)object).dsiMediaBrowserAsyncException(((Number)objectArray[0]).intValue(), (String)objectArray[1], ((Number)objectArray[2]).intValue());
                return null;
            }
        }
        return null;
    }

    private Object f14(int n, Object object, Object[] objectArray) {
        switch (n) {
            case 448: {
                return ((MediaSpeechBrowser)object).getBrowseMedia();
            }
            case 449: {
                return RuntimeUtil.valueOf(((MediaSpeechBrowser)object).getBrowseMode());
            }
            case 450: {
                return RuntimeUtil.valueOf(((MediaSpeechBrowser)object).isInContentMode());
            }
            case 451: {
                return RuntimeUtil.valueOf(((MediaSpeechBrowser)object).isInRawMode());
            }
            case 452: {
                return RuntimeUtil.valueOf(((MediaSpeechBrowser)object).getContentFilter());
            }
            case 453: {
                return ((MediaSpeechBrowser)object).getBrowseFolder();
            }
            case 454: {
                return RuntimeUtil.valueOf(((MediaSpeechBrowser)object).getListState());
            }
            case 455: {
                ((MediaSpeechBrowser)object).setListState(((Number)objectArray[0]).intValue());
                return null;
            }
            case 456: {
                return RuntimeUtil.valueOf(((MediaSpeechBrowser)object).getModeSwitchingState());
            }
            case 457: {
                ((MediaSpeechBrowser)object).setModeSwitchingState(((Number)objectArray[0]).intValue());
                return null;
            }
            case 458: {
                return RuntimeUtil.valueOf(((MediaSpeechBrowser)object).isBrowsingAvailable());
            }
            case 459: {
                ((MediaSpeechBrowser)object).setInitState(((Number)objectArray[0]).intValue());
                return null;
            }
            case 460: {
                return ((MediaSpeechBrowser)object).getPathData();
            }
            case 461: {
                return ((MediaSpeechBrowser)object).getListEntryPath((ListEntry[])objectArray[0], (ListEntry)objectArray[1]);
            }
            case 462: {
                return RuntimeUtil.valueOf(((MediaSpeechBrowser)object).getListSize());
            }
            case 463: {
                return ((MediaSpeechBrowser)object).getListHandler();
            }
            case 464: {
                return ((MediaSpeechBrowser)object).getAbsolutePathByListEntry((ListEntry)objectArray[0]);
            }
            case 465: {
                ((MediaSpeechBrowser)object).triggerErrorTextFor((ListEntry)objectArray[0]);
                return null;
            }
            case 466: {
                return ((MediaSpeechBrowser)object).getListEntryInCache(((Number)objectArray[0]).longValue(), ((Number)objectArray[1]).intValue(), ((Number)objectArray[2]).intValue(), (String)objectArray[3]);
            }
            case 467: {
                return RuntimeUtil.valueOf(((MediaSpeechBrowser)object).isSetupRequired((MediaCollector)objectArray[0], ((Number)objectArray[1]).intValue()));
            }
            case 468: {
                return RuntimeUtil.valueOf(((MediaSpeechBrowser)object).isSetBrowseMediaNeeded((MediaCollector)objectArray[0], ((Number)objectArray[1]).intValue()));
            }
            case 469: {
                return ((MediaSpeechBrowser)object).getDSI();
            }
            case 470: {
                return RuntimeUtil.valueOf(((MediaSpeechBrowser)object).getInstanceId());
            }
            case 471: {
                ((MediaSpeechBrowser)object).valueChangedInteger(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 472: {
                ((MediaSpeechBrowser)object).onUpdate((Devices)objectArray[0]);
                return null;
            }
            case 473: {
                ((MediaSpeechBrowser)object).rqWaitForFlag((MediaCollector)objectArray[0], ((Number)objectArray[1]).intValue(), (Boolean)objectArray[2], (ResponseHandler)objectArray[3]);
                return null;
            }
            case 474: {
                ((MediaSpeechBrowser)object).fireResponse((Boolean)objectArray[0]);
                return null;
            }
            case 475: {
                ((MediaSpeechBrowser)object).fireResponse((boolean)((Boolean)objectArray[0]), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 476: {
                ((MediaSpeechBrowser)object).fireResponse((boolean)((Boolean)objectArray[0]), (String)objectArray[1]);
                return null;
            }
            case 477: {
                return RuntimeUtil.valueOf(((MediaSpeechBrowser)object).registerForResponse(((Number)objectArray[0]).intValue(), (ResponseHandler)objectArray[1]));
            }
            case 478: {
                return RuntimeUtil.valueOf(((MediaSpeechBrowser)object).registerForResponse(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue(), (ResponseHandler)objectArray[2]));
            }
            case 479: {
                return RuntimeUtil.valueOf(((MediaSpeechBrowser)object).isRegisteredForResponse(((Number)objectArray[0]).intValue()));
            }
        }
        return null;
    }

    private Object f15(int n, Object object, Object[] objectArray) {
        switch (n) {
            case 480: {
                ((MediaController)object).reset((FactoryResetCallback)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 481: {
                ((MediaController)object).addCommand((Command)objectArray[0]);
                return null;
            }
            case 482: {
                return RuntimeUtil.valueOf(((MediaController)object).getComponentId());
            }
            case 483: {
                ((MediaController)object).removeDBLPlaySelection();
                return null;
            }
            case 484: {
                ((MediaController)object).resynchronize((AbstractMediaBrowser)objectArray[0]);
                return null;
            }
            case 485: {
                ((MediaController)object).playSimilar((Callback)objectArray[0]);
                return null;
            }
            case 486: {
                ((MediaController)object).changeSlot();
                return null;
            }
            case 487: {
                ((MediaController)object).sourcesAvailable((ISources)objectArray[0]);
                return null;
            }
            case 488: {
                return ((MediaController)object).insertActivateSourceCmd((MediaCollector)objectArray[0], (Boolean)objectArray[1]);
            }
            case 489: {
                ((MediaController)object).insertDeactivatePlayerCmd((Boolean)objectArray[0], (Boolean)objectArray[1], (CommandCallback)objectArray[2]);
                return null;
            }
            case 490: {
                ((MediaController)object).syncCoverFlow();
                return null;
            }
            case 491: {
                ((MediaController)object).activatePartitionList(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).longValue());
                return null;
            }
            case 492: {
                return RuntimeUtil.valueOf(((MediaController)object).isHeadunitFollowModeActive());
            }
            case 493: {
                ((MediaController)object).synchronizeBrowser((Boolean)objectArray[0], (String)objectArray[1]);
                return null;
            }
            case 494: {
                ((MediaController)object).resumeImport();
                return null;
            }
            case 495: {
                ((MediaController)object).addMediaPlayViewListener((MediaPlayViewListener)objectArray[0]);
                return null;
            }
            case 496: {
                ((MediaController)object).addMediaPlaySimilarListener((MediaPlaySimilarListener)objectArray[0]);
                return null;
            }
            case 497: {
                ((MediaController)object).addMediaActivationStateListener((MediaActivationStateListener)objectArray[0]);
                return null;
            }
            case 498: {
                ((MediaController)object).activateMediaSource((SourceId)objectArray[0], (Callback)objectArray[1]);
                return null;
            }
            case 499: {
                ((MediaController)object).activateMediaSource((SourceId)objectArray[0], (SourceCallback)objectArray[1]);
                return null;
            }
            case 500: {
                ((MediaController)object).activateMediaSourceByHasId(((Number)objectArray[0]).intValue(), (SourceCallback)objectArray[1]);
                return null;
            }
            case 501: {
                ((MediaController)object).playEntry((MediaEntry)objectArray[0], (Callback)objectArray[1]);
                return null;
            }
            case 502: {
                ((MediaController)object).playEntry(((Number)objectArray[0]).intValue(), (Callback)objectArray[1]);
                return null;
            }
            case 503: {
                ((MediaController)object).requestEntries((List)objectArray[0], ((Number)objectArray[1]).intValue(), (MediaEntriesCallback)objectArray[2]);
                return null;
            }
            case 504: {
                ((MediaController)object).browseDatabase((SourceId)objectArray[0], ((Number)objectArray[1]).intValue(), (Callback)objectArray[2]);
                return null;
            }
            case 505: {
                ((MediaController)object).addSpeakableElementsListener((SpeakableElementsListener)objectArray[0]);
                return null;
            }
            case 506: {
                ((MediaController)object).browseRaw((SourceId)objectArray[0], (Callback)objectArray[1]);
                return null;
            }
            case 507: {
                return RuntimeUtil.valueOf(((MediaController)object).getTimeout());
            }
            case 508: {
                ((MediaController)object).valueChangedInteger(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 509: {
                ((MediaController)object).onUpdate((Devices)objectArray[0]);
                return null;
            }
            case 510: {
                ((MediaController)object).onDevicesUpdated();
                return null;
            }
            case 511: {
                ((MediaController)object).rqWaitForFlag((MediaCollector)objectArray[0], ((Number)objectArray[1]).intValue(), (Boolean)objectArray[2], (ResponseHandler)objectArray[3]);
                return null;
            }
        }
        return null;
    }

    private Object f16(int n, Object object, Object[] objectArray) {
        switch (n) {
            case 512: {
                ((MediaController)object).fireResponse((Boolean)objectArray[0]);
                return null;
            }
            case 513: {
                ((MediaController)object).fireResponse((boolean)((Boolean)objectArray[0]), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 514: {
                ((MediaController)object).fireResponse((boolean)((Boolean)objectArray[0]), (String)objectArray[1]);
                return null;
            }
            case 515: {
                return RuntimeUtil.valueOf(((MediaController)object).registerForResponse(((Number)objectArray[0]).intValue(), (ResponseHandler)objectArray[1]));
            }
            case 516: {
                return RuntimeUtil.valueOf(((MediaController)object).registerForResponse(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue(), (ResponseHandler)objectArray[2]));
            }
            case 517: {
                return RuntimeUtil.valueOf(((MediaController)object).isRegisteredForResponse(((Number)objectArray[0]).intValue()));
            }
            case 518: {
                return RuntimeUtil.valueOf(((OnlineMetaDataHandler)object).getComponentId());
            }
            case 519: {
                ((OnlineMetaDataHandler)object).dsiMetadataServiceUpdateOnlineLookupStatus(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 520: {
                ((OnlineMetaDataHandler)object).dsiMetadataServiceResponseCoverArt(((Number)objectArray[0]).intValue(), (ResourceLocator)objectArray[1]);
                return null;
            }
            case 521: {
                ((OnlineMetaDataHandler)object).dsiMetadataServiceAsyncException(((Number)objectArray[0]).intValue(), (String)objectArray[1], ((Number)objectArray[2]).intValue());
                return null;
            }
            case 522: {
                ((OnlineMetaDataHandler)object).valueChangedInteger(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 523: {
                ((OnlineMetaDataHandler)object).onUpdate((Devices)objectArray[0]);
                return null;
            }
            case 524: {
                ((OnlineMetaDataHandler)object).onDevicesUpdated();
                return null;
            }
            case 525: {
                ((OnlineMetaDataHandler)object).rqWaitForFlag((MediaCollector)objectArray[0], ((Number)objectArray[1]).intValue(), (Boolean)objectArray[2], (ResponseHandler)objectArray[3]);
                return null;
            }
            case 526: {
                ((OnlineMetaDataHandler)object).fireResponse((Boolean)objectArray[0]);
                return null;
            }
            case 527: {
                ((OnlineMetaDataHandler)object).fireResponse((boolean)((Boolean)objectArray[0]), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 528: {
                ((OnlineMetaDataHandler)object).fireResponse((boolean)((Boolean)objectArray[0]), (String)objectArray[1]);
                return null;
            }
            case 529: {
                return RuntimeUtil.valueOf(((OnlineMetaDataHandler)object).registerForResponse(((Number)objectArray[0]).intValue(), (ResponseHandler)objectArray[1]));
            }
            case 530: {
                return RuntimeUtil.valueOf(((OnlineMetaDataHandler)object).registerForResponse(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue(), (ResponseHandler)objectArray[2]));
            }
            case 531: {
                return RuntimeUtil.valueOf(((OnlineMetaDataHandler)object).isRegisteredForResponse(((Number)objectArray[0]).intValue()));
            }
            case 532: {
                return RuntimeUtil.valueOf(((MediaHASTarget)object).getComponentId());
            }
            case 533: {
                ((MediaHASTarget)object).valueChangedInteger(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 534: {
                ((MediaHASTarget)object).onUpdate((Devices)objectArray[0]);
                return null;
            }
            case 535: {
                ((MediaHASTarget)object).onDevicesUpdated();
                return null;
            }
            case 536: {
                ((MediaHASTarget)object).rqWaitForFlag((MediaCollector)objectArray[0], ((Number)objectArray[1]).intValue(), (Boolean)objectArray[2], (ResponseHandler)objectArray[3]);
                return null;
            }
            case 537: {
                ((MediaHASTarget)object).fireResponse((Boolean)objectArray[0]);
                return null;
            }
            case 538: {
                ((MediaHASTarget)object).fireResponse((boolean)((Boolean)objectArray[0]), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 539: {
                ((MediaHASTarget)object).fireResponse((boolean)((Boolean)objectArray[0]), (String)objectArray[1]);
                return null;
            }
            case 540: {
                return RuntimeUtil.valueOf(((MediaHASTarget)object).registerForResponse(((Number)objectArray[0]).intValue(), (ResponseHandler)objectArray[1]));
            }
            case 541: {
                return RuntimeUtil.valueOf(((MediaHASTarget)object).registerForResponse(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue(), (ResponseHandler)objectArray[2]));
            }
            case 542: {
                return RuntimeUtil.valueOf(((MediaHASTarget)object).isRegisteredForResponse(((Number)objectArray[0]).intValue()));
            }
            case 543: {
                ((MediaVideoPlayer)object).dsiMediaPlayerUpdatePlayViewSize(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue(), ((Number)objectArray[2]).intValue());
                return null;
            }
        }
        return null;
    }

    private Object f17(int n, Object object, Object[] objectArray) {
        switch (n) {
            case 544: {
                ((MediaVideoPlayer)object).setDisclaimerShown((Boolean)objectArray[0]);
                return null;
            }
            case 545: {
                ((MediaVideoPlayer)object).dsiMediaPlayerIndicationDvdEvent(((Number)objectArray[0]).intValue());
                return null;
            }
            case 546: {
                ((MediaVideoPlayer)object).enqueueMenuCmd(((Number)objectArray[0]).intValue());
                return null;
            }
            case 547: {
                ((MediaVideoPlayer)object).rqExecuteMenuCmd(((Number)objectArray[0]).intValue(), (Boolean)objectArray[1], (ResponseHandler)objectArray[2]);
                return null;
            }
            case 548: {
                ((MediaVideoPlayer)object).dsiMediaPlayerUpdateCmdBlockingMask(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 549: {
                ((MediaVideoPlayer)object).dsiMediaPlayerResponseCmdBlocked(((Number)objectArray[0]).intValue());
                return null;
            }
            case 550: {
                ((MediaVideoPlayer)object).dsiMediaPlayerUpdateAudioStreamList((AudioStream[])objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 551: {
                ((MediaVideoPlayer)object).dsiMediaPlayerUpdateActiveAudioStream(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 552: {
                ((MediaVideoPlayer)object).setAudioStream(((Number)objectArray[0]).intValue());
                return null;
            }
            case 553: {
                ((MediaVideoPlayer)object).dsiMediaPlayerUpdateSubtitleList((int[])objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 554: {
                ((MediaVideoPlayer)object).setSubtitleLanguage(((Number)objectArray[0]).intValue());
                return null;
            }
            case 555: {
                ((MediaVideoPlayer)object).dsiMediaPlayerUpdateActiveSubtitle(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 556: {
                ((MediaVideoPlayer)object).dsiMediaPlayerUpdateNumVideoAngles(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 557: {
                ((MediaVideoPlayer)object).setViewAngle(((Number)objectArray[0]).intValue());
                return null;
            }
            case 558: {
                ((MediaVideoPlayer)object).dsiMediaPlayerUpdateActiveVideoAngle(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 559: {
                ((MediaVideoPlayer)object).expiredViewAngleTimer();
                return null;
            }
            case 560: {
                ((MediaVideoPlayer)object).resetViewAngleTimer();
                return null;
            }
            case 561: {
                return RuntimeUtil.valueOf(((MediaVideoPlayer)object).isPlayviewEntry(((Number)objectArray[0]).longValue()));
            }
            case 562: {
                ((MediaVideoPlayer)object).dsiMediaPlayerResponsePlayView((ListEntry[])objectArray[0], ((Number)objectArray[1]).intValue(), ((Number)objectArray[2]).intValue(), ((Number)objectArray[3]).intValue());
                return null;
            }
            case 563: {
                ((MediaVideoPlayer)object).dsiMediaBaseUpdateCustomerUpdate(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 564: {
                ((MediaVideoPlayer)object).dsiMediaBaseUpdateParentalML(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 565: {
                ((MediaVideoPlayer)object).dsiMediaPlayerTempPMLRequest(((Number)objectArray[0]).intValue());
                return null;
            }
            case 566: {
                ((MediaVideoPlayer)object).resume();
                return null;
            }
            case 567: {
                return RuntimeUtil.valueOf(((MediaVideoPlayer)object).isActive());
            }
            case 568: {
                return RuntimeUtil.valueOf(((MediaVideoPlayer)object).getComponentId());
            }
            case 569: {
                ((MediaVideoPlayer)object).onDevicesUpdated();
                return null;
            }
            case 570: {
                return ((MediaVideoPlayer)object).getPlaySelection();
            }
            case 571: {
                return ((MediaVideoPlayer)object).getPlayerState();
            }
            case 572: {
                return ((MediaVideoPlayer)object).getActiveTrack();
            }
            case 573: {
                ((MediaVideoPlayer)object).rqWaitForState(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue(), (ResponseHandler)objectArray[2]);
                return null;
            }
            case 574: {
                return ((MediaVideoPlayer)object).getActiveOrRequestedMedia();
            }
            case 575: {
                return ((MediaVideoPlayer)object).getActiveMedia();
            }
        }
        return null;
    }

    private Object f18(int n, Object object, Object[] objectArray) {
        switch (n) {
            case 576: {
                return ((MediaVideoPlayer)object).getASLActiveMedia();
            }
            case 577: {
                ((MediaVideoPlayer)object).rqMediaActivation((MediaCollector)objectArray[0], (ResponseHandler)objectArray[1]);
                return null;
            }
            case 578: {
                ((MediaVideoPlayer)object).dsiMediaPlayerUpdateActiveMedia(((Number)objectArray[0]).longValue(), ((Number)objectArray[1]).longValue(), ((Number)objectArray[2]).intValue(), ((Number)objectArray[3]).intValue(), ((Number)objectArray[4]).intValue());
                return null;
            }
            case 579: {
                return ((MediaVideoPlayer)object).getCapabilities();
            }
            case 580: {
                ((MediaVideoPlayer)object).dsiMediaPlayerUpdateCapabilities((Capabilities)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 581: {
                ((MediaVideoPlayer)object).dsiMediaPlayerUpdatePlaybackModeList((PlaybackMode[])objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 582: {
                ((MediaVideoPlayer)object).rqRestorePlaybackMode((ResponseHandler)objectArray[0]);
                return null;
            }
            case 583: {
                ((MediaVideoPlayer)object).rqRestoreDefaultPlaybackMode((ResponseHandler)objectArray[0]);
                return null;
            }
            case 584: {
                ((MediaVideoPlayer)object).rqSetDefaultPlaybackMode((Selection)objectArray[0], (ResponseHandler)objectArray[1]);
                return null;
            }
            case 585: {
                ((MediaVideoPlayer)object).rqSetPlaybackMode((PlayMode)objectArray[0], (Selection)objectArray[1], (ResponseHandler)objectArray[2]);
                return null;
            }
            case 586: {
                ((MediaVideoPlayer)object).dsiMediaPlayerUpdatePlaybackMode(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 587: {
                return ((MediaVideoPlayer)object).getPlaybackMode();
            }
            case 588: {
                return RuntimeUtil.valueOf(((MediaVideoPlayer)object).isDefaultPlaymode());
            }
            case 589: {
                ((MediaVideoPlayer)object).rqSetPlaySelection((Selection)objectArray[0], ((Number)objectArray[1]).longValue(), (Boolean)objectArray[2], (Boolean)objectArray[3], (ResponseHandler)objectArray[4]);
                return null;
            }
            case 590: {
                ((MediaVideoPlayer)object).dsiMediaPlayerResponseSetPlaySelection(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 591: {
                ((MediaVideoPlayer)object).rqSetTrackToTime(((Number)objectArray[0]).intValue(), (ResponseHandler)objectArray[1]);
                return null;
            }
            case 592: {
                ((MediaVideoPlayer)object).rqSkipTrack(((Number)objectArray[0]).intValue(), (Boolean)objectArray[1], (ResponseHandler)objectArray[2]);
                return null;
            }
            case 593: {
                ((MediaVideoPlayer)object).dsiMediaPlayerResponseDetailInfo((EntryInfo)objectArray[0]);
                return null;
            }
            case 594: {
                ((MediaVideoPlayer)object).dsiMediaPlayerResponseCoverArt(((Number)objectArray[0]).longValue(), (ResourceLocator)objectArray[1]);
                return null;
            }
            case 595: {
                ((MediaVideoPlayer)object).dsiMediaPlayerUpdatePlayPosition(((Number)objectArray[0]).longValue(), ((Number)objectArray[1]).intValue(), ((Number)objectArray[2]).intValue(), ((Number)objectArray[3]).intValue());
                return null;
            }
            case 596: {
                ((MediaVideoPlayer)object).updateNewTrack(((Number)objectArray[0]).longValue());
                return null;
            }
            case 597: {
                return RuntimeUtil.valueOf(((MediaVideoPlayer)object).getTotalTime());
            }
            case 598: {
                return RuntimeUtil.valueOf(((MediaVideoPlayer)object).getActiveTrackId());
            }
            case 599: {
                ((MediaVideoPlayer)object).setSeekCanceled((Boolean)objectArray[0]);
                return null;
            }
            case 600: {
                return RuntimeUtil.valueOf(((MediaVideoPlayer)object).isSeekCanceled());
            }
            case 601: {
                ((MediaVideoPlayer)object).rqSeek(((Number)objectArray[0]).intValue(), (ResponseHandler)objectArray[1]);
                return null;
            }
            case 602: {
                ((MediaVideoPlayer)object).abortSeek();
                return null;
            }
            case 603: {
                return RuntimeUtil.valueOf(((MediaVideoPlayer)object).isSeeking());
            }
            case 604: {
                ((MediaVideoPlayer)object).dsiMediaPlayerUpdatePlaybackContentFolder((ListEntry[])objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 605: {
                ((MediaVideoPlayer)object).dsiMediaPlayerUpdatePlaybackFolder((ListEntry[])objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 606: {
                return ((MediaVideoPlayer)object).getActiveFolderPath();
            }
            case 607: {
                return ((MediaVideoPlayer)object).getActiveAlbum();
            }
        }
        return null;
    }

    private Object f19(int n, Object object, Object[] objectArray) {
        switch (n) {
            case 608: {
                ((MediaVideoPlayer)object).rqResume((ResponseHandler)objectArray[0]);
                return null;
            }
            case 609: {
                ((MediaVideoPlayer)object).pauseIfNotOnTop();
                return null;
            }
            case 610: {
                ((MediaVideoPlayer)object).rqPause((ResponseHandler)objectArray[0]);
                return null;
            }
            case 611: {
                ((MediaVideoPlayer)object).pause((Boolean)objectArray[0]);
                return null;
            }
            case 612: {
                return RuntimeUtil.valueOf(((MediaVideoPlayer)object).isPlaying());
            }
            case 613: {
                return RuntimeUtil.valueOf(((MediaVideoPlayer)object).isPaused());
            }
            case 614: {
                ((MediaVideoPlayer)object).ripNPlay();
                return null;
            }
            case 615: {
                return RuntimeUtil.valueOf(((MediaVideoPlayer)object).getDSIPlaybackState());
            }
            case 616: {
                ((MediaVideoPlayer)object).dsiMediaPlayerUpdatePlaybackState(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 617: {
                ((MediaVideoPlayer)object).rqSetEntry(((Number)objectArray[0]).longValue(), (Boolean)objectArray[1], (ResponseHandler)objectArray[2]);
                return null;
            }
            case 618: {
                ((MediaVideoPlayer)object).resetToFactorySettings();
                return null;
            }
            case 619: {
                ((MediaVideoPlayer)object).dsiMediaPlayerAsyncException(((Number)objectArray[0]).intValue(), (String)objectArray[1], ((Number)objectArray[2]).intValue());
                return null;
            }
            case 620: {
                return RuntimeUtil.valueOf(((MediaVideoPlayer)object).getTimePos());
            }
            case 621: {
                return ((MediaVideoPlayer)object).getActiveTrackDetails();
            }
            case 622: {
                return RuntimeUtil.valueOf(((MediaVideoPlayer)object).isWaitForSkipSensible((Boolean)objectArray[0]));
            }
            case 623: {
                ((MediaVideoPlayer)object).rqRestoreVideoFormat((ResponseHandler)objectArray[0]);
                return null;
            }
            case 624: {
                ((MediaVideoPlayer)object).rqVideoFormat(((Number)objectArray[0]).intValue(), (ResponseHandler)objectArray[1]);
                return null;
            }
            case 625: {
                ((MediaVideoPlayer)object).dsiMediaPlayerUpdateVideoFormat(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 626: {
                ((MediaVideoPlayer)object).restoreVideoSize();
                return null;
            }
            case 627: {
                ((MediaVideoPlayer)object).setVideoSize((Boolean)objectArray[0]);
                return null;
            }
            case 628: {
                ((MediaVideoPlayer)object).restorePML();
                return null;
            }
            case 629: {
                ((MediaVideoPlayer)object).rqPlaySimilar((Selection)objectArray[0], (Boolean)objectArray[1], (ResponseHandler)objectArray[2]);
                return null;
            }
            case 630: {
                ((MediaVideoPlayer)object).dsiMediaPlayerResponsePlaySimilarEntry(((Number)objectArray[0]).longValue(), (Boolean)objectArray[1]);
                return null;
            }
            case 631: {
                ((MediaVideoPlayer)object).rqWaitForPlaying((ResponseHandler)objectArray[0]);
                return null;
            }
            case 632: {
                ((MediaVideoPlayer)object).removePlaymodeLSM((MediaCollector)objectArray[0]);
                return null;
            }
            case 633: {
                ((MediaVideoPlayer)object).updatePlaceHolderPaths((BrowserPathData)objectArray[0]);
                return null;
            }
            case 634: {
                ((MediaVideoPlayer)object).resetPlayDefaultAfterStop();
                return null;
            }
            case 635: {
                ((MediaVideoPlayer)object).setPlayerState(((Number)objectArray[0]).intValue());
                return null;
            }
            case 636: {
                ((MediaVideoPlayer)object).triggerBrowserSync((String)objectArray[0]);
                return null;
            }
            case 637: {
                ((MediaVideoPlayer)object).resetPlaySelectionForActiveMediaLocally();
                return null;
            }
            case 638: {
                return ((MediaVideoPlayer)object).getActiveSlot();
            }
            case 639: {
                return ((MediaVideoPlayer)object).getDSI();
            }
        }
        return null;
    }

    private Object f20(int n, Object object, Object[] objectArray) {
        switch (n) {
            case 640: {
                ((MediaVideoPlayer)object).rqRestoreLSCLanguageAsPreferred((ResponseHandler)objectArray[0]);
                return null;
            }
            case 641: {
                ((MediaVideoPlayer)object).rqFactorySettings(((Number)objectArray[0]).intValue(), (ResponseHandler)objectArray[1]);
                return null;
            }
            case 642: {
                ((MediaVideoPlayer)object).dsiMediaBaseResponseResetFactorySettings(((Number)objectArray[0]).intValue(), (Boolean)objectArray[1]);
                return null;
            }
            case 643: {
                ((MediaVideoPlayer)object).dsiMediaBaseUpdatePreferredLanguage((String)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 644: {
                ((MediaVideoPlayer)object).valueChangedInteger(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 645: {
                ((MediaVideoPlayer)object).onUpdate((Devices)objectArray[0]);
                return null;
            }
            case 646: {
                ((MediaVideoPlayer)object).rqWaitForFlag((MediaCollector)objectArray[0], ((Number)objectArray[1]).intValue(), (Boolean)objectArray[2], (ResponseHandler)objectArray[3]);
                return null;
            }
            case 647: {
                ((MediaVideoPlayer)object).fireResponse((Boolean)objectArray[0]);
                return null;
            }
            case 648: {
                ((MediaVideoPlayer)object).fireResponse((boolean)((Boolean)objectArray[0]), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 649: {
                ((MediaVideoPlayer)object).fireResponse((boolean)((Boolean)objectArray[0]), (String)objectArray[1]);
                return null;
            }
            case 650: {
                return RuntimeUtil.valueOf(((MediaVideoPlayer)object).registerForResponse(((Number)objectArray[0]).intValue(), (ResponseHandler)objectArray[1]));
            }
            case 651: {
                return RuntimeUtil.valueOf(((MediaVideoPlayer)object).registerForResponse(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue(), (ResponseHandler)objectArray[2]));
            }
            case 652: {
                return RuntimeUtil.valueOf(((MediaVideoPlayer)object).isRegisteredForResponse(((Number)objectArray[0]).intValue()));
            }
            case 653: {
                ((MediaRecorder)object).reset();
                return null;
            }
            case 654: {
                return RuntimeUtil.valueOf(((MediaRecorder)object).getComponentId());
            }
            case 655: {
                return ((MediaRecorder)object).getActiveMedia();
            }
            case 656: {
                return ((MediaRecorder)object).getRecorderState();
            }
            case 657: {
                return RuntimeUtil.valueOf(((MediaRecorder)object).getUserEncodingQuality());
            }
            case 658: {
                ((MediaRecorder)object).abortImport();
                return null;
            }
            case 659: {
                ((MediaRecorder)object).abortDelete();
                return null;
            }
            case 660: {
                ((MediaRecorder)object).setUserEncodingQuality(((Number)objectArray[0]).intValue());
                return null;
            }
            case 661: {
                ((MediaRecorder)object).rqSetActiveMedia((MediaCollector)objectArray[0], (ResponseHandler)objectArray[1]);
                return null;
            }
            case 662: {
                ((MediaRecorder)object).retrieveId((ISources)objectArray[0]);
                return null;
            }
            case 663: {
                ((MediaRecorder)object).dsiMediaRecorderUpdateActiveMedia(((Number)objectArray[0]).longValue(), ((Number)objectArray[1]).longValue(), ((Number)objectArray[2]).intValue());
                return null;
            }
            case 664: {
                ((MediaRecorder)object).rqSetEncodingQuality((ResponseHandler)objectArray[0]);
                return null;
            }
            case 665: {
                ((MediaRecorder)object).dsiMediaRecorderResponseSetEncodingQuality(((Number)objectArray[0]).intValue());
                return null;
            }
            case 666: {
                ((MediaRecorder)object).rqSetSelection((Selection)objectArray[0], (ResponseHandler)objectArray[1]);
                return null;
            }
            case 667: {
                ((MediaRecorder)object).dsiMediaRecorderResponseSetSelection(((Number)objectArray[0]).intValue(), (Boolean)objectArray[1]);
                return null;
            }
            case 668: {
                ((MediaRecorder)object).rqStartImport((Boolean)objectArray[0], (ResponseHandler)objectArray[1]);
                return null;
            }
            case 669: {
                ((MediaRecorder)object).rqStartDelete((ResponseHandler)objectArray[0]);
                return null;
            }
            case 670: {
                ((MediaRecorder)object).dsiMediaRecorderUpdateDatabaseSpace((DatabaseSpace)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 671: {
                ((MediaRecorder)object).dsiMediaRecorderUpdateImportStatus(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
        }
        return null;
    }

    private Object f21(int n, Object object, Object[] objectArray) {
        switch (n) {
            case 672: {
                ((MediaRecorder)object).onDeviceChanges();
                return null;
            }
            case 673: {
                ((MediaRecorder)object).dsiMediaRecorderUpdateDeletionStatus(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 674: {
                ((MediaRecorder)object).dsiMediaRecorderUpdateImportProgress(((Number)objectArray[0]).longValue(), (ListEntry)objectArray[1], ((Number)objectArray[2]).intValue());
                return null;
            }
            case 675: {
                ((MediaRecorder)object).dsiMediaRecorderUpdateDeletionProgress(((Number)objectArray[0]).longValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 676: {
                ((MediaRecorder)object).dsiMediaRecorderUpdateImportSummary(((Number)objectArray[0]).longValue(), ((Number)objectArray[1]).longValue(), ((Number)objectArray[2]).longValue(), ((Number)objectArray[3]).longValue(), ((Number)objectArray[4]).longValue(), ((Number)objectArray[5]).longValue(), ((Number)objectArray[6]).intValue());
                return null;
            }
            case 677: {
                ((MediaRecorder)object).dsiMediaRecorderAsyncException(((Number)objectArray[0]).intValue(), (String)objectArray[1], ((Number)objectArray[2]).intValue());
                return null;
            }
            case 678: {
                ((MediaRecorder)object).notifyFileSelectionDone((Selection)objectArray[0]);
                return null;
            }
            case 679: {
                return ((MediaRecorder)object).getDSI();
            }
            case 680: {
                ((MediaRecorder)object).valueChangedInteger(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 681: {
                ((MediaRecorder)object).onUpdate((Devices)objectArray[0]);
                return null;
            }
            case 682: {
                ((MediaRecorder)object).onDevicesUpdated();
                return null;
            }
            case 683: {
                ((MediaRecorder)object).rqWaitForFlag((MediaCollector)objectArray[0], ((Number)objectArray[1]).intValue(), (Boolean)objectArray[2], (ResponseHandler)objectArray[3]);
                return null;
            }
            case 684: {
                ((MediaRecorder)object).fireResponse((Boolean)objectArray[0]);
                return null;
            }
            case 685: {
                ((MediaRecorder)object).fireResponse((boolean)((Boolean)objectArray[0]), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 686: {
                ((MediaRecorder)object).fireResponse((boolean)((Boolean)objectArray[0]), (String)objectArray[1]);
                return null;
            }
            case 687: {
                return RuntimeUtil.valueOf(((MediaRecorder)object).registerForResponse(((Number)objectArray[0]).intValue(), (ResponseHandler)objectArray[1]));
            }
            case 688: {
                return RuntimeUtil.valueOf(((MediaRecorder)object).registerForResponse(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue(), (ResponseHandler)objectArray[2]));
            }
            case 689: {
                return RuntimeUtil.valueOf(((MediaRecorder)object).isRegisteredForResponse(((Number)objectArray[0]).intValue()));
            }
            case 690: {
                return RuntimeUtil.valueOf(((MediaSettings)object).getComponentId());
            }
            case 691: {
                ((MediaSettings)object).resetToFactorySettings();
                return null;
            }
            case 692: {
                ((MediaSettings)object).toggleIncludeSubfolder();
                return null;
            }
            case 693: {
                return RuntimeUtil.valueOf(((MediaSettings)object).getIncludeSubfolder());
            }
            case 694: {
                ((MediaSettings)object).rqIncludeSubfolder((ResponseHandler)objectArray[0]);
                return null;
            }
            case 695: {
                ((MediaSettings)object).valueChangedInteger(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 696: {
                ((MediaSettings)object).onUpdate((Devices)objectArray[0]);
                return null;
            }
            case 697: {
                ((MediaSettings)object).onDevicesUpdated();
                return null;
            }
            case 698: {
                ((MediaSettings)object).rqWaitForFlag((MediaCollector)objectArray[0], ((Number)objectArray[1]).intValue(), (Boolean)objectArray[2], (ResponseHandler)objectArray[3]);
                return null;
            }
            case 699: {
                ((MediaSettings)object).fireResponse((Boolean)objectArray[0]);
                return null;
            }
            case 700: {
                ((MediaSettings)object).fireResponse((boolean)((Boolean)objectArray[0]), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 701: {
                ((MediaSettings)object).fireResponse((boolean)((Boolean)objectArray[0]), (String)objectArray[1]);
                return null;
            }
            case 702: {
                return RuntimeUtil.valueOf(((MediaSettings)object).registerForResponse(((Number)objectArray[0]).intValue(), (ResponseHandler)objectArray[1]));
            }
            case 703: {
                return RuntimeUtil.valueOf(((MediaSettings)object).registerForResponse(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue(), (ResponseHandler)objectArray[2]));
            }
        }
        return null;
    }

    private Object f22(int n, Object object, Object[] objectArray) {
        switch (n) {
            case 704: {
                return RuntimeUtil.valueOf(((MediaSettings)object).isRegisteredForResponse(((Number)objectArray[0]).intValue()));
            }
            case 705: {
                return RuntimeUtil.valueOf(((MediaAudioManager)object).getComponentId());
            }
            case 706: {
                return RuntimeUtil.valueOf(((MediaAudioManager)object).isMediaOnTop());
            }
            case 707: {
                ((MediaAudioManager)object).requestMute((Boolean)objectArray[0], (String)objectArray[1]);
                return null;
            }
            case 708: {
                return RuntimeUtil.valueOf(((MediaAudioManager)object).isMuteActive());
            }
            case 709: {
                return RuntimeUtil.valueOf(((MediaAudioManager)object).isAudioConnectionAvailable());
            }
            case 710: {
                ((MediaAudioManager)object).rqWaitForMediaNotAudible((ResponseHandler)objectArray[0]);
                return null;
            }
            case 711: {
                ((MediaAudioManager)object).rqMute((ResponseHandler)objectArray[0]);
                return null;
            }
            case 712: {
                ((MediaAudioManager)object).rqDemute((ResponseHandler)objectArray[0]);
                return null;
            }
            case 713: {
                ((MediaAudioManager)object).unlockAllVolumeConnections();
                return null;
            }
            case 714: {
                return RuntimeUtil.valueOf(((MediaAudioManager)object).isAudioConnectionMatching((MediaCollector)objectArray[0]));
            }
            case 715: {
                return RuntimeUtil.valueOf(((MediaAudioManager)object).isStandbyActive());
            }
            case 716: {
                ((MediaAudioManager)object).resetLastRequestedConnections();
                return null;
            }
            case 717: {
                ((MediaAudioManager)object).rqAudioConnection((MediaCollector)objectArray[0], (ResponseHandler)objectArray[1]);
                return null;
            }
            case 718: {
                ((MediaAudioManager)object).rqDummyAudioConnection((ResponseHandler)objectArray[0]);
                return null;
            }
            case 719: {
                ((MediaAudioManager)object).rqMediaFadeIn((ResponseHandler)objectArray[0]);
                return null;
            }
            case 720: {
                return RuntimeUtil.valueOf(((MediaAudioManager)object).isMuteStarted());
            }
            case 721: {
                return RuntimeUtil.valueOf(((MediaAudioManager)object).isStandbyPowerSaveActive());
            }
            case 722: {
                return RuntimeUtil.valueOf(((MediaAudioManager)object).isMediaAudibleAfterDemute());
            }
            case 723: {
                return RuntimeUtil.valueOf(((MediaAudioManager)object).isMuteBeforeAmUnavailable());
            }
            case 724: {
                ((MediaAudioManager)object).valueChangedInteger(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 725: {
                ((MediaAudioManager)object).onUpdate((Devices)objectArray[0]);
                return null;
            }
            case 726: {
                ((MediaAudioManager)object).onDevicesUpdated();
                return null;
            }
            case 727: {
                ((MediaAudioManager)object).rqWaitForFlag((MediaCollector)objectArray[0], ((Number)objectArray[1]).intValue(), (Boolean)objectArray[2], (ResponseHandler)objectArray[3]);
                return null;
            }
            case 728: {
                ((MediaAudioManager)object).fireResponse((Boolean)objectArray[0]);
                return null;
            }
            case 729: {
                ((MediaAudioManager)object).fireResponse((boolean)((Boolean)objectArray[0]), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 730: {
                ((MediaAudioManager)object).fireResponse((boolean)((Boolean)objectArray[0]), (String)objectArray[1]);
                return null;
            }
            case 731: {
                return RuntimeUtil.valueOf(((MediaAudioManager)object).registerForResponse(((Number)objectArray[0]).intValue(), (ResponseHandler)objectArray[1]));
            }
            case 732: {
                return RuntimeUtil.valueOf(((MediaAudioManager)object).registerForResponse(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue(), (ResponseHandler)objectArray[2]));
            }
            case 733: {
                return RuntimeUtil.valueOf(((MediaAudioManager)object).isRegisteredForResponse(((Number)objectArray[0]).intValue()));
            }
            case 734: {
                return RuntimeUtil.valueOf(((MediaInternalSourceHandlingTarget)object).getComponentId());
            }
            case 735: {
                ((MediaInternalSourceHandlingTarget)object).resetToFactorySettings();
                return null;
            }
        }
        return null;
    }

    private Object f23(int n, Object object, Object[] objectArray) {
        switch (n) {
            case 736: {
                return RuntimeUtil.valueOf(((MediaInternalSourceHandlingTarget)object).isMediaContext());
            }
            case 737: {
                return ((MediaInternalSourceHandlingTarget)object).getSourceByID(((Number)objectArray[0]).intValue());
            }
            case 738: {
                return RuntimeUtil.valueOf(((MediaInternalSourceHandlingTarget)object).checkSource((MediaCollector)objectArray[0]));
            }
            case 739: {
                return ((MediaInternalSourceHandlingTarget)object).getCollector((SourceId)objectArray[0]);
            }
            case 740: {
                ((MediaInternalSourceHandlingTarget)object).rqRequestSourceActivation((MediaCollector)objectArray[0], (ResponseHandler)objectArray[1]);
                return null;
            }
            case 741: {
                ((MediaInternalSourceHandlingTarget)object).beginActivation();
                return null;
            }
            case 742: {
                ((MediaInternalSourceHandlingTarget)object).endActivation((MediaCollector)objectArray[0], (CommandState)objectArray[1], (Boolean)objectArray[2]);
                return null;
            }
            case 743: {
                ((MediaInternalSourceHandlingTarget)object).endDeactivation((MediaCollector)objectArray[0], (CommandState)objectArray[1], (Boolean)objectArray[2]);
                return null;
            }
            case 744: {
                return ((MediaInternalSourceHandlingTarget)object).getHDD();
            }
            case 745: {
                return RuntimeUtil.valueOf(((MediaInternalSourceHandlingTarget)object).isCancelPending());
            }
            case 746: {
                return RuntimeUtil.valueOf(((MediaInternalSourceHandlingTarget)object).isDeviceValid((MediaCollector)objectArray[0]));
            }
            case 747: {
                ((MediaInternalSourceHandlingTarget)object).setDisconnectedState((MediaCollector)objectArray[0]);
                return null;
            }
            case 748: {
                ((MediaInternalSourceHandlingTarget)object).setDisconnectedStateWithCallback((CommandCallback)objectArray[0]);
                return null;
            }
            case 749: {
                ((MediaInternalSourceHandlingTarget)object).disconnectBluetooth((MediaCollector)objectArray[0]);
                return null;
            }
            case 750: {
                return ((MediaInternalSourceHandlingTarget)object).getSourceById(((Number)objectArray[0]).longValue(), ((Number)objectArray[1]).longValue());
            }
            case 751: {
                ((MediaInternalSourceHandlingTarget)object).doRequest((EntertainmentManagerCoreService)objectArray[0]);
                return null;
            }
            case 752: {
                ((MediaInternalSourceHandlingTarget)object).valueChangedInteger(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 753: {
                ((MediaInternalSourceHandlingTarget)object).onUpdate((Devices)objectArray[0]);
                return null;
            }
            case 754: {
                ((MediaInternalSourceHandlingTarget)object).onDevicesUpdated();
                return null;
            }
            case 755: {
                ((MediaInternalSourceHandlingTarget)object).rqWaitForFlag((MediaCollector)objectArray[0], ((Number)objectArray[1]).intValue(), (Boolean)objectArray[2], (ResponseHandler)objectArray[3]);
                return null;
            }
            case 756: {
                ((MediaInternalSourceHandlingTarget)object).fireResponse((Boolean)objectArray[0]);
                return null;
            }
            case 757: {
                ((MediaInternalSourceHandlingTarget)object).fireResponse((boolean)((Boolean)objectArray[0]), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 758: {
                ((MediaInternalSourceHandlingTarget)object).fireResponse((boolean)((Boolean)objectArray[0]), (String)objectArray[1]);
                return null;
            }
            case 759: {
                return RuntimeUtil.valueOf(((MediaInternalSourceHandlingTarget)object).registerForResponse(((Number)objectArray[0]).intValue(), (ResponseHandler)objectArray[1]));
            }
            case 760: {
                return RuntimeUtil.valueOf(((MediaInternalSourceHandlingTarget)object).registerForResponse(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue(), (ResponseHandler)objectArray[2]));
            }
            case 761: {
                return RuntimeUtil.valueOf(((MediaInternalSourceHandlingTarget)object).isRegisteredForResponse(((Number)objectArray[0]).intValue()));
            }
            case 762: {
                ((TargetMediaStartup)object).registered((String)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 763: {
                return RuntimeUtil.valueOf(((TargetMediaStartup)object).getComponentId());
            }
            case 764: {
                ((TargetMediaStartup)object).registerDSI();
                return null;
            }
            case 765: {
                ((TargetMediaStartup)object).unregistered((String)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 766: {
                ((TargetMediaStartup)object).dsiStartupUpdateDomainStatusMedia(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 767: {
                ((TargetMediaStartup)object).rqPowerOn((ResponseHandler)objectArray[0]);
                return null;
            }
        }
        return null;
    }

    private Object f24(int n, Object object, Object[] objectArray) {
        switch (n) {
            case 768: {
                ((TargetMediaStartup)object).valueChangedInteger(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 769: {
                ((TargetMediaStartup)object).onUpdate((Devices)objectArray[0]);
                return null;
            }
            case 770: {
                ((TargetMediaStartup)object).onDevicesUpdated();
                return null;
            }
            case 771: {
                ((TargetMediaStartup)object).rqWaitForFlag((MediaCollector)objectArray[0], ((Number)objectArray[1]).intValue(), (Boolean)objectArray[2], (ResponseHandler)objectArray[3]);
                return null;
            }
            case 772: {
                ((TargetMediaStartup)object).fireResponse((Boolean)objectArray[0]);
                return null;
            }
            case 773: {
                ((TargetMediaStartup)object).fireResponse((boolean)((Boolean)objectArray[0]), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 774: {
                ((TargetMediaStartup)object).fireResponse((boolean)((Boolean)objectArray[0]), (String)objectArray[1]);
                return null;
            }
            case 775: {
                return RuntimeUtil.valueOf(((TargetMediaStartup)object).registerForResponse(((Number)objectArray[0]).intValue(), (ResponseHandler)objectArray[1]));
            }
            case 776: {
                return RuntimeUtil.valueOf(((TargetMediaStartup)object).registerForResponse(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue(), (ResponseHandler)objectArray[2]));
            }
            case 777: {
                return RuntimeUtil.valueOf(((TargetMediaStartup)object).isRegisteredForResponse(((Number)objectArray[0]).intValue()));
            }
            case 778: {
                ((DsiMediaBaseAdapter)object).profileChange(((Number)objectArray[0]).intValue());
                return null;
            }
            case 779: {
                ((DsiMediaBaseAdapter)object).profileCopy(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 780: {
                ((DsiMediaBaseAdapter)object).profileReset(((Number)objectArray[0]).intValue());
                return null;
            }
            case 781: {
                ((DsiMediaBaseAdapter)object).profileResetAll();
                return null;
            }
            case 782: {
                ((DsiMediaBaseAdapter)object).dsiMediaBaseUpdateProfileState(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue(), ((Number)objectArray[2]).intValue());
                return null;
            }
            case 783: {
                ((DsiMediaBaseAdapter)object).dsiMediaBaseProfileChanged(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 784: {
                ((DsiMediaBaseAdapter)object).dsiMediaBaseProfileCopied(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue(), ((Number)objectArray[2]).intValue());
                return null;
            }
            case 785: {
                ((DsiMediaBaseAdapter)object).dsiMediaBaseProfileReset(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 786: {
                ((DsiMediaBaseAdapter)object).dsiMediaBaseProfileResetAll(((Number)objectArray[0]).intValue());
                return null;
            }
            case 787: {
                return ((DsiMediaBaseAdapter)object).getDsiClass();
            }
            case 788: {
                ((DsiMediaBaseAdapter)object).init((PersonalizedAppListener)objectArray[0]);
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
                case 9: {
                    return this.f9(n, object, objectArray);
                }
                case 10: {
                    return this.f10(n, object, objectArray);
                }
                case 11: {
                    return this.f11(n, object, objectArray);
                }
                case 12: {
                    return this.f12(n, object, objectArray);
                }
                case 13: {
                    return this.f13(n, object, objectArray);
                }
                case 14: {
                    return this.f14(n, object, objectArray);
                }
                case 15: {
                    return this.f15(n, object, objectArray);
                }
                case 16: {
                    return this.f16(n, object, objectArray);
                }
                case 17: {
                    return this.f17(n, object, objectArray);
                }
                case 18: {
                    return this.f18(n, object, objectArray);
                }
                case 19: {
                    return this.f19(n, object, objectArray);
                }
                case 20: {
                    return this.f20(n, object, objectArray);
                }
                case 21: {
                    return this.f21(n, object, objectArray);
                }
                case 22: {
                    return this.f22(n, object, objectArray);
                }
                case 23: {
                    return this.f23(n, object, objectArray);
                }
                case 24: {
                    return this.f24(n, object, objectArray);
                }
            }
            return null;
        }
        catch (Throwable throwable) {
            throw new InvocationTargetException(throwable);
        }
    }
}

