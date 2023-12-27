/*
 * Decompiled with CFR 0.152.
 */
package generated.de.vw.mib.global.datapool.internal;

import de.vw.mib.app.framework.AppDefinition;
import de.vw.mib.datapool.ModelDatapoolObserver;
import de.vw.mib.hmi.internal.ServiceManagerCommon;
import de.vw.mib.list.ListItemControlListener;
import generated.de.vw.mib.global.datapool.ModelDataPoolBase;
import generated.de.vw.mib.global.datapool.internal.DataPoolUpdate$AslListUpdate;

public class DataPoolUpdate
extends ModelDataPoolBase
implements ModelDatapoolObserver {
    private boolean suppressUpdate = true;

    private boolean suppressUpdate() {
        if (this.suppressUpdate && ServiceManagerCommon.startupManagerService.isDatapoolUpdatesEnabled()) {
            this.suppressUpdate = false;
        }
        return this.suppressUpdate;
    }

    public ListItemControlListener createAslListUpdate(int n) {
        return new DataPoolUpdate$AslListUpdate(this, n);
    }

    void aslListChanged(int n) {
        if (this.suppressUpdate()) {
            return;
        }
        block0 : switch (n) {
            case 58: {
                this.fireCommonEvent(null, null, -1318810295);
                break;
            }
            case 10530: {
                this.fireCommonEvent(null, null, -999846583);
                break;
            }
            case 10480: {
                this.fireCommonEvent(null, null, -932737719);
                break;
            }
            case 10462: {
                this.fireCommonEvent(null, null, -362312375);
                break;
            }
            case 10560: {
                int n2 = this.getLicValue(10560, 2, 0, 0);
                switch (n2) {
                    case 0: 
                    case 1: 
                    case 2: 
                    case 3: 
                    case 4: 
                    case 5: 
                    case 6: 
                    case 7: 
                    case 8: 
                    case 9: 
                    case 10: 
                    case 11: 
                    case 12: {
                        this.fireDiscreteEvent(null, null, -764965559);
                        break;
                    }
                }
                n2 = this.getLicValue(10560, 1, 0, 0);
                switch (n2) {
                    case 0: 
                    case 1: 
                    case 2: 
                    case 3: 
                    case 4: {
                        this.fireDiscreteEvent(null, null, -731411127);
                        break;
                    }
                }
                n2 = this.getLicValue(10560, 0, 0, -1);
                switch (n2) {
                    case 0: 
                    case 1: 
                    case 2: 
                    case 3: 
                    case 4: 
                    case 5: 
                    case 6: 
                    case 7: 
                    case 8: {
                        this.fireDiscreteEvent(null, null, -748188343);
                        break;
                    }
                }
                n2 = this.getLicValue(10560, 3, 0, 1);
                switch (n2) {
                    case 0: 
                    case 1: 
                    case 2: 
                    case 3: 
                    case 4: 
                    case 5: {
                        this.fireDiscreteEvent(null, null, -714633911);
                        break block0;
                    }
                }
                break;
            }
            case 110049: {
                this.fireCommonEvent(null, null, 1818266953);
                break;
            }
            case 332: {
                this.fireCommonEvent(null, null, 1935707465);
                break;
            }
            case 333: {
                this.fireCommonEvent(null, null, 1952484681);
                break;
            }
            case 3344: {
                this.fireCommonEvent(null, null, -1956541111);
                break;
            }
            case 5710002: {
                this.fireCommonEvent(null, null, -1620800183);
                break;
            }
            case 462: {
                this.fireCommonEvent(null, null, -94073527);
                break;
            }
            case 924: {
                int n3 = this.getLicValue(924, 2, 0, 0);
                if (n3 != 2) break;
                this.fireDiscreteEvent(null, null, 1080397129);
                break;
            }
            case 1310055: {
                this.fireCommonEvent(null, null, -1939501751);
                break;
            }
            case 1461: {
                this.fireCommonEvent(null, null, -915894967);
                break;
            }
            case 2710016: {
                this.fireCommonEvent(null, null, 275287369);
                break;
            }
        }
    }

    @Override
    public void datapoolValueChanged(int n) {
        if (this.suppressUpdate()) {
            return;
        }
        int n2 = n & 0xFF;
        block0 : switch (n2) {
            case 0: {
                if (n == 0xBA0000) {
                    this.fireCommonEvent(null, null, -496988855);
                    break;
                }
                if (n != 11264) break;
                this.fireCommonEvent(null, null, 582);
                break;
            }
            case 1: {
                if (n == 26935296) {
                    int n3 = this.getInteger(26935296);
                    switch (n3) {
                        case 1: {
                            this.fireDiscreteEvent(null, null, -1151038135);
                            break block0;
                        }
                        case 2: {
                            this.fireDiscreteEvent(null, null, -1134260919);
                            break block0;
                        }
                        case 4: {
                            this.fireDiscreteEvent(null, null, -1167815351);
                            break block0;
                        }
                        case 5: {
                            this.fireDiscreteEvent(null, null, -1184592567);
                            break block0;
                        }
                        case 6: {
                            this.fireDiscreteEvent(null, null, -1201369783);
                            break block0;
                        }
                    }
                    break;
                }
                if (n != 0x1040100) break;
                this.fireCommonEvent(null, null, -1855615671);
                break;
            }
            case 2: {
                if (n != 0x2020100) break;
                this.fireCommonEvent(null, null, -966226615);
                break;
            }
            case 5: {
                if (n != 96272384) break;
                this.fireCommonEvent(null, null, -882406071);
                break;
            }
            case 7: {
                int n4;
                if (n != 130088960 || (n4 = this.getInteger(130088960)) != 2) break;
                this.fireDiscreteEvent(null, null, 1214614857);
                break;
            }
            case 9: {
                if (n == 0x9D90000) {
                    int n5 = this.getInteger(0x9D90000);
                    switch (n5) {
                        case 1: {
                            this.fireDiscreteEvent(null, null, -1520136887);
                            break block0;
                        }
                        case 2: {
                            this.fireDiscreteEvent(null, null, -1536914103);
                            break block0;
                        }
                        case 3: {
                            this.fireDiscreteEvent(null, null, -1503359671);
                            break block0;
                        }
                    }
                    break;
                }
                if (n != 21769) break;
                this.fireCommonEvent(null, null, 1767935305);
                break;
            }
            case 10: {
                if (n != 183304192) break;
                this.fireCommonEvent(null, null, -43676343);
                break;
            }
            case 12: {
                if (n == 16652) {
                    int n6 = this.getInteger(16652);
                    switch (n6) {
                        case 0: {
                            this.fireDiscreteEvent(null, null, -379220663);
                            break block0;
                        }
                        case 1: 
                        case 2: 
                        case 3: {
                            this.fireDiscreteEvent(null, null, -362443447);
                            break block0;
                        }
                    }
                    break;
                }
                if (n == 27660) {
                    this.fireCommonEvent(null, null, -1251701431);
                    break;
                }
                if (n != 26124) break;
                this.fireCommonEvent(null, null, 443059529);
                break;
            }
            case 14: {
                if (n == 0xE8E0000) {
                    int n7 = this.getInteger(0xE8E0000);
                    if (n7 != 1) break;
                    this.fireDiscreteEvent(null, null, 1281723721);
                    break;
                }
                if (n == 19214) {
                    this.fireCommonEvent(null, null, -232637952);
                    break;
                }
                if (n != 31502) break;
                this.fireCommonEvent(null, null, 1751158089);
                break;
            }
            case 15: {
                if (n == 262995968) {
                    this.fireCommonEvent(null, null, 543788361);
                    break;
                }
                if (n != 0xFAA0000) break;
                this.fireCommonEvent(null, null, 1566936393);
                break;
            }
            case 16: {
                if (n != 278396928) break;
                this.fireCommonEvent(null, null, -1923576503);
                break;
            }
            case 19: {
                if (n != 333447168) break;
                int n8 = this.getInteger(333447168);
                switch (n8) {
                    case 0: {
                        this.fireDiscreteEvent(null, null, -697856695);
                        break block0;
                    }
                    case 1: {
                        this.fireDiscreteEvent(null, null, -681079479);
                        break block0;
                    }
                }
                break;
            }
            case 22: {
                if (n != 370934016) break;
                this.fireCommonEvent(null, null, -1016623799);
                break;
            }
            case 23: {
                if (n != 388038912) break;
                int n9 = this.getInteger(388038912);
                switch (n9) {
                    case 0: 
                    case 2: {
                        this.fireDiscreteEvent(null, null, 560303433);
                        break block0;
                    }
                    case 1: {
                        this.fireDiscreteEvent(null, null, 610635081);
                        break block0;
                    }
                }
                break;
            }
            case 28: {
                if (n != 16412) break;
                this.fireCommonEvent(null, null, 1980249088);
                break;
            }
            case 29: {
                if (n != 16413) break;
                this.fireCommonEvent(null, null, 172);
                break;
            }
            case 30: {
                boolean bl;
                if (n == 513802240) {
                    this.fireCommonEvent(null, null, -832074423);
                    break;
                }
                if (n != 22302 || !(bl = this.getBoolean(22302))) break;
                this.fireDiscreteEvent(null, null, 1415941449);
                break;
            }
            case 31: {
                if (n == 27679) {
                    int n10 = this.getInteger(27679);
                    switch (n10) {
                        case 2: {
                            this.fireDiscreteEvent(null, null, -882602679);
                            break block0;
                        }
                        case 3: {
                            this.fireDiscreteEvent(null, null, -865825463);
                            break block0;
                        }
                        case 4: {
                            this.fireDiscreteEvent(null, null, -832271031);
                            break block0;
                        }
                        case 5: {
                            this.fireDiscreteEvent(null, null, -916157111);
                            break block0;
                        }
                        case 6: {
                            this.fireDiscreteEvent(null, null, -849048247);
                            break block0;
                        }
                        case 7: {
                            this.fireDiscreteEvent(null, null, -899379895);
                            break block0;
                        }
                    }
                    break;
                }
                if (n != 23839) break;
                boolean bl = this.getBoolean(23839);
                if (bl) {
                    this.fireDiscreteEvent(null, null, -731345591);
                    break;
                }
                this.fireDiscreteEvent(null, null, -714568375);
                break;
            }
            case 32: {
                if (n == 23328) {
                    this.fireCommonEvent(null, null, -345469623);
                    break;
                }
                if (n != 25376) break;
                this.fireCommonEvent(null, null, 308841801);
                break;
            }
            case 33: {
                if (n != 554041600) break;
                this.fireCommonEvent(null, null, 560565577);
                break;
            }
            case 34: {
                if (n != 13858) break;
                int n11 = this.getInteger(13858);
                switch (n11) {
                    case 0: {
                        this.fireDiscreteEvent(null, null, -1285190327);
                        break block0;
                    }
                    case 1: {
                        this.fireDiscreteEvent(null, null, -1536848567);
                        break block0;
                    }
                    case 2: {
                        this.fireDiscreteEvent(null, null, -1436185271);
                        break block0;
                    }
                    case 3: {
                        this.fireDiscreteEvent(null, null, -1419408055);
                        break block0;
                    }
                    case 4: {
                        this.fireDiscreteEvent(null, null, -1520071351);
                        break block0;
                    }
                    case 5: {
                        this.fireDiscreteEvent(null, null, -1402630839);
                        break block0;
                    }
                    case 6: {
                        this.fireDiscreteEvent(null, null, -1503294135);
                        break block0;
                    }
                    case 7: {
                        this.fireDiscreteEvent(null, null, -1469739703);
                        break block0;
                    }
                    case 8: {
                        this.fireDiscreteEvent(null, null, -1452962487);
                        break block0;
                    }
                    case 9: {
                        this.fireDiscreteEvent(null, null, -1486516919);
                        break block0;
                    }
                    case 10: {
                        this.fireDiscreteEvent(null, null, -1369076407);
                        break block0;
                    }
                    case 11: {
                        this.fireDiscreteEvent(null, null, -1385853623);
                        break block0;
                    }
                    case 12: {
                        this.fireDiscreteEvent(null, null, -1352299191);
                        break block0;
                    }
                    case 13: {
                        this.fireDiscreteEvent(null, null, -1335521975);
                        break block0;
                    }
                    case 14: {
                        this.fireDiscreteEvent(null, null, -1318744759);
                        break block0;
                    }
                    case 15: {
                        this.fireDiscreteEvent(null, null, -1301967543);
                        break block0;
                    }
                    case 101: {
                        this.fireDiscreteEvent(null, null, -1788506807);
                        break block0;
                    }
                    case 102: {
                        this.fireDiscreteEvent(null, null, -1687843511);
                        break block0;
                    }
                    case 103: {
                        this.fireDiscreteEvent(null, null, -1671066295);
                        break block0;
                    }
                    case 104: {
                        this.fireDiscreteEvent(null, null, -1771729591);
                        break block0;
                    }
                    case 105: {
                        this.fireDiscreteEvent(null, null, -1654289079);
                        break block0;
                    }
                    case 106: {
                        this.fireDiscreteEvent(null, null, -1754952375);
                        break block0;
                    }
                    case 107: {
                        this.fireDiscreteEvent(null, null, -1721397943);
                        break block0;
                    }
                    case 108: {
                        this.fireDiscreteEvent(null, null, -1704620727);
                        break block0;
                    }
                    case 109: {
                        this.fireDiscreteEvent(null, null, -1738175159);
                        break block0;
                    }
                    case 110: {
                        this.fireDiscreteEvent(null, null, -1620734647);
                        break block0;
                    }
                    case 111: {
                        this.fireDiscreteEvent(null, null, -1637511863);
                        break block0;
                    }
                    case 112: {
                        this.fireDiscreteEvent(null, null, -1603957431);
                        break block0;
                    }
                    case 113: {
                        this.fireDiscreteEvent(null, null, -1587180215);
                        break block0;
                    }
                    case 114: {
                        this.fireDiscreteEvent(null, null, -1570402999);
                        break block0;
                    }
                    case 115: {
                        this.fireDiscreteEvent(null, null, -1553625783);
                        break block0;
                    }
                }
                break;
            }
            case 36: {
                if (n == 27172) {
                    int n12 = this.getInteger(27172);
                    switch (n12) {
                        case 2: {
                            this.fireDiscreteEvent(null, null, -1385919159);
                            break block0;
                        }
                        case 3: {
                            this.fireDiscreteEvent(null, null, -1369141943);
                            break block0;
                        }
                        case 4: {
                            this.fireDiscreteEvent(null, null, -1335587511);
                            break block0;
                        }
                        case 7: {
                            this.fireDiscreteEvent(null, null, -1419473591);
                            break block0;
                        }
                        case 8: {
                            this.fireDiscreteEvent(null, null, -1352364727);
                            break block0;
                        }
                        case 9: {
                            this.fireDiscreteEvent(null, null, -1402696375);
                            break block0;
                        }
                    }
                    break;
                }
                if (n != 616169472) break;
                int n13 = this.getInteger(616169472);
                switch (n13) {
                    case 2: {
                        this.fireDiscreteEvent(null, null, -1083929271);
                        break block0;
                    }
                    case 3: {
                        this.fireDiscreteEvent(null, null, -1067152055);
                        break block0;
                    }
                    case 4: {
                        this.fireDiscreteEvent(null, null, -1050374839);
                        break block0;
                    }
                    case 5: {
                        this.fireDiscreteEvent(null, null, -1033597623);
                        break block0;
                    }
                    case 6: {
                        this.fireDiscreteEvent(null, null, -1100706487);
                        break block0;
                    }
                }
                break;
            }
            case 37: {
                boolean bl;
                if (n == 633733120) {
                    this.fireCommonEvent(null, null, -966292151);
                    break;
                }
                if (n != 621347072 || !(bl = this.getBoolean(621347072))) break;
                this.fireDiscreteEvent(null, null, 141069641);
                break;
            }
            case 38: {
                if (n == 639238400) {
                    int n14 = this.getInteger(639238400);
                    switch (n14) {
                        case 1: {
                            this.fireDiscreteEvent(null, null, 308645193);
                            break block0;
                        }
                        case 2: {
                            this.fireDiscreteEvent(null, null, 291867977);
                            break block0;
                        }
                        case 3: {
                            this.fireDiscreteEvent(null, null, 191204681);
                            break block0;
                        }
                        case 4: {
                            this.fireDiscreteEvent(null, null, 275090761);
                            break block0;
                        }
                        case 5: {
                            this.fireDiscreteEvent(null, null, 207981897);
                            break block0;
                        }
                        case 6: {
                            this.fireDiscreteEvent(null, null, 224759113);
                            break block0;
                        }
                        case 7: {
                            this.fireDiscreteEvent(null, null, 241536329);
                            break block0;
                        }
                        case 8: {
                            this.fireDiscreteEvent(null, null, 258313545);
                            break block0;
                        }
                    }
                    break;
                }
                if (n != 651821056) break;
                this.fireCommonEvent(null, null, -211448503);
                break;
            }
            case 39: {
                int n15;
                if (n != 668991488 || (n15 = this.getInteger(668991488)) != 1) break;
                this.fireDiscreteEvent(null, null, -160985783);
                break;
            }
            case 43: {
                int n16;
                if (n != 721420544 || (n16 = this.getInteger(721420544)) != 1) break;
                this.fireDiscreteEvent(null, null, 1030065481);
                break;
            }
            case 44: {
                if (n != 25900) break;
                int n17 = this.getInteger(25900);
                switch (n17) {
                    case 0: {
                        this.fireDiscreteEvent(null, null, -546861751);
                        break block0;
                    }
                    case 1: {
                        this.fireDiscreteEvent(null, null, -530084535);
                        break block0;
                    }
                }
                break;
            }
            case 45: {
                if (n == 13869) {
                    this.fireCommonEvent(null, null, -899183287);
                    break;
                }
                if (n == 32557) {
                    int n18 = this.getInteger(32557);
                    switch (n18) {
                        case 1: 
                        case 2: 
                        case 3: {
                            this.fireDiscreteEvent(null, null, -395997879);
                            break block0;
                        }
                    }
                    break;
                }
                if (n == 756154624) {
                    this.fireCommonEvent(null, null, -530215607);
                    break;
                }
                if (n != 755106048) break;
                this.fireCommonEvent(null, null, 1835109705);
                break;
            }
            case 49: {
                if (n == 835321856) {
                    int n19 = this.getInteger(835321856);
                    switch (n19) {
                        case 2: {
                            this.fireDiscreteEvent(null, null, -446657207);
                            break block0;
                        }
                        case 3: {
                            this.fireDiscreteEvent(null, null, -463434423);
                            break block0;
                        }
                    }
                    break;
                }
                if (n != 837550080) break;
                this.fireCommonEvent(null, null, -362246839);
                break;
            }
            case 50: {
                if (n != 27698) break;
                this.fireCommonEvent(null, null, -395866807);
                break;
            }
            case 51: {
                if (n != 16179) break;
                this.fireCommonEvent(null, null, -1838838455);
                break;
            }
            case 52: {
                if (n != 10548) break;
                this.fireCommonEvent(null, null, -1083667127);
                break;
            }
            case 53: {
                if (n != 890896640) break;
                this.fireCommonEvent(null, null, -412644023);
                break;
            }
            case 55: {
                if (n != 935460864) break;
                this.fireCommonEvent(null, null, 292064585);
                break;
            }
            case 56: {
                int n20;
                if (n == 27192) {
                    int n21 = this.getInteger(27192);
                    switch (n21) {
                        case 3: {
                            this.fireDiscreteEvent(null, null, -1268478647);
                            break block0;
                        }
                        case 4: {
                            this.fireDiscreteEvent(null, null, -1285255863);
                            break block0;
                        }
                        case 5: {
                            this.fireDiscreteEvent(null, null, -1302033079);
                            break block0;
                        }
                    }
                    break;
                }
                if (n != 956170240 || (n20 = this.getInteger(956170240)) != 0) break;
                this.fireDiscreteEvent(null, null, 1666878793);
                break;
            }
            case 57: {
                if (n != 17465) break;
                boolean bl = this.getBoolean(17465);
                if (bl) {
                    this.fireDiscreteEvent(null, null, 99618816);
                    break;
                }
                this.fireDiscreteEvent(null, null, 116396032);
                break;
            }
            case 58: {
                if (n != 982188032) break;
                this.fireCommonEvent(null, null, -1872392887);
                break;
            }
            case 59: {
                if (n != 20027) break;
                this.fireCommonEvent(null, null, 1851821385);
                break;
            }
            case 60: {
                if (n != 1019281408) break;
                int n22 = this.getInteger(1019281408);
                switch (n22) {
                    case 0: {
                        this.fireDiscreteEvent(null, null, -630747831);
                        break block0;
                    }
                    case 1: {
                        this.fireDiscreteEvent(null, null, -597193399);
                        break block0;
                    }
                    case 2: {
                        this.fireDiscreteEvent(null, null, -613970615);
                        break block0;
                    }
                    case 3: {
                        this.fireDiscreteEvent(null, null, -647525047);
                        break block0;
                    }
                    case 4: {
                        this.fireDiscreteEvent(null, null, -664302263);
                        break block0;
                    }
                }
                break;
            }
            case 61: {
                if (n != 1039007744) break;
                boolean bl = this.getBoolean(1039007744);
                if (bl) {
                    this.fireDiscreteEvent(null, null, -664433335);
                    break;
                }
                this.fireDiscreteEvent(null, null, -681210551);
                break;
            }
            case 68: {
                if (n == 32068) {
                    this.fireCommonEvent(null, null, 107318601);
                    break;
                }
                if (n != 20548) break;
                this.fireCommonEvent(null, null, -1167553207);
                break;
            }
            case 70: {
                if (n == 1183055872) {
                    int n23 = this.getInteger(1183055872);
                    switch (n23) {
                        case 0: {
                            this.fireDiscreteEvent(null, null, -580416183);
                            break block0;
                        }
                        case 1: {
                            this.fireDiscreteEvent(null, null, -563638967);
                            break block0;
                        }
                    }
                    break;
                }
                if (n != 12614) break;
                boolean bl = this.getBoolean(12614);
                if (bl) {
                    this.fireDiscreteEvent(null, null, -580350647);
                    break;
                }
                this.fireDiscreteEvent(null, null, -563573431);
                break;
            }
            case 71: {
                if (n != 32583) break;
                this.fireCommonEvent(null, null, 73895241);
                break;
            }
            case 73: {
                if (n == 1239678976) {
                    this.fireCommonEvent(null, null, -848851639);
                    break;
                }
                if (n == 23881) {
                    this.fireCommonEvent(null, null, -446263991);
                    break;
                }
                if (n != 12361) break;
                this.fireCommonEvent(null, null, 444);
                break;
            }
            case 74: {
                if (n == 13642) {
                    this.fireCommonEvent(null, null, 1885375817);
                    break;
                }
                if (n == 1243021568) {
                    int n24 = this.getInteger(1243021568);
                    if (n24 != 0) break;
                    this.fireDiscreteEvent(null, null, -1604022967);
                    break;
                }
                if (n != 1250623488) break;
                this.fireCommonEvent(null, null, -731542199);
                break;
            }
            case 77: {
                if (n != 1307770880) break;
                this.fireCommonEvent(null, null, -1587573431);
                break;
            }
            case 78: {
                if (n != 1324679168) break;
                boolean bl = this.getBoolean(1324679168);
                if (bl) {
                    this.fireDiscreteEvent(null, null, 1969261897);
                    break;
                }
                this.fireDiscreteEvent(null, null, 1986039113);
                break;
            }
            case 80: {
                if (n != 1354694656) break;
                this.fireCommonEvent(null, null, -915960503);
                break;
            }
            case 83: {
                if (n == 1394278656) {
                    int n25 = this.getInteger(1394278656);
                    switch (n25) {
                        case 0: {
                            this.fireDiscreteEvent(null, null, 744852809);
                            break block0;
                        }
                        case 1: {
                            this.fireDiscreteEvent(null, null, 728075593);
                            break block0;
                        }
                        case 2: {
                            this.fireDiscreteEvent(null, null, 711298377);
                            break block0;
                        }
                        case 3: {
                            this.fireDiscreteEvent(null, null, 761630025);
                            break block0;
                        }
                    }
                    break;
                }
                if (n != 1403322368) break;
                this.fireCommonEvent(null, null, 451);
                break;
            }
            case 84: {
                if (n == 1409810688) {
                    this.fireCommonEvent(null, null, -698053303);
                    break;
                }
                if (n != 25684) break;
                this.fireCommonEvent(null, null, -194671287);
                break;
            }
            case 85: {
                if (n == 20821) {
                    this.fireCommonEvent(null, null, -714830519);
                    break;
                }
                if (n != 1436418048) break;
                boolean bl = this.getBoolean(1436418048);
                if (bl) {
                    this.fireDiscreteEvent(null, null, -328757943);
                    break;
                }
                this.fireDiscreteEvent(null, null, -311980727);
                break;
            }
            case 87: {
                if (n == 20567) {
                    boolean bl = this.getBoolean(20567);
                    if (!bl) break;
                    this.fireDiscreteEvent(null, null, 1315278153);
                    break;
                }
                if (n == 24151) {
                    int n26 = this.getInteger(24151);
                    switch (n26) {
                        case 2: {
                            this.fireDiscreteEvent(null, null, 1248169289);
                            break block0;
                        }
                        case 4: {
                            this.fireDiscreteEvent(null, null, 1231392073);
                            break block0;
                        }
                    }
                    break;
                }
                if (n != 1460601088) break;
                boolean bl = this.getBoolean(1460601088);
                if (bl) {
                    this.fireDiscreteEvent(null, null, -597324471);
                    break;
                }
                this.fireDiscreteEvent(null, null, -580547255);
                break;
            }
            case 88: {
                if (n == 32344) {
                    this.fireCommonEvent(null, null, -1202156215);
                    break;
                }
                if (n == 1486422016) {
                    this.fireCommonEvent(null, null, 996183369);
                    break;
                }
                if (n != 27480) break;
                this.fireCommonEvent(null, null, 191401289);
                break;
            }
            case 89: {
                int n27;
                if (n != 16473 || (n27 = this.getInteger(16473)) != 1) break;
                this.fireDiscreteEvent(null, null, 878742857);
                break;
            }
            case 91: {
                if (n != 1540751360) break;
                this.fireCommonEvent(null, null, 442);
                break;
            }
            case 93: {
                boolean bl;
                if (n == 1570439168) {
                    this.fireCommonEvent(null, null, -798519991);
                    break;
                }
                if (n != 1562706176 || (bl = this.getBoolean(1562706176))) break;
                this.fireDiscreteEvent(null, null, -211514039);
                break;
            }
            case 94: {
                if (n != 1591017472) break;
                this.fireCommonEvent(null, null, -1167749815);
                break;
            }
            case 98: {
                if (n == 29538) {
                    this.fireCommonEvent(null, null, -1587245751);
                    break;
                }
                if (n != 30050) break;
                int n28 = this.getInteger(30050);
                switch (n28) {
                    case 0: {
                        this.fireDiscreteEvent(null, null, -899642039);
                        break block0;
                    }
                    case 1: {
                        this.fireDiscreteEvent(null, null, -882864823);
                        break block0;
                    }
                }
                break;
            }
            case 99: {
                if (n != 18531) break;
                this.fireCommonEvent(null, null, -932934327);
                break;
            }
            case 103: {
                boolean bl;
                if (n == 1730150656) {
                    this.fireCommonEvent(null, null, -1537700535);
                    break;
                }
                if (n != 16743 || !(bl = this.getBoolean(16743))) break;
                this.fireDiscreteEvent(null, null, 1399164233);
                break;
            }
            case 104: {
                if (n != 1745027328) break;
                this.fireCommonEvent(null, null, -916091575);
                break;
            }
            case 106: {
                if (n != 14442) break;
                int n29 = this.getInteger(14442);
                switch (n29) {
                    case 0: 
                    case 1: {
                        this.fireDiscreteEvent(null, null, 10020);
                        break block0;
                    }
                }
                break;
            }
            case 107: {
                if (n != 1797128448) break;
                int n30 = this.getInteger(1797128448);
                switch (n30) {
                    case 0: {
                        this.fireDiscreteEvent(null, null, -1150775991);
                        break block0;
                    }
                    case 1: {
                        this.fireDiscreteEvent(null, null, -1117221559);
                        break block0;
                    }
                    case 2: {
                        this.fireDiscreteEvent(null, null, -1133998775);
                        break block0;
                    }
                }
                break;
            }
            case 109: {
                if (n != 1839071232) break;
                this.fireCommonEvent(null, null, -681145015);
                break;
            }
            case 112: {
                boolean bl;
                if (n != 1891106816 || (bl = this.getBoolean(1891106816))) break;
                this.fireDiscreteEvent(null, null, 1818332489);
                break;
            }
            case 113: {
                if (n != 1911750656) break;
                this.fireCommonEvent(null, null, -144405175);
                break;
            }
            case 115: {
                if (n != 29299) break;
                this.fireCommonEvent(null, null, -295203511);
                break;
            }
            case 116: {
                if (n != 1957494784) break;
                this.fireCommonEvent(null, null, -295269047);
                break;
            }
            case 117: {
                if (n == 1974468608) {
                    this.fireCommonEvent(null, null, 1298500937);
                    break;
                }
                if (n != 1975123968) break;
                int n31 = this.getInteger(1975123968);
                switch (n31) {
                    case 0: {
                        this.fireDiscreteEvent(null, null, 241732937);
                        break block0;
                    }
                    case 1: {
                        this.fireDiscreteEvent(null, null, 224955721);
                        break block0;
                    }
                }
                break;
            }
            case 118: {
                if (n != 1990393856) break;
                int n32 = this.getInteger(1990393856);
                switch (n32) {
                    case 2: {
                        this.fireDiscreteEvent(null, null, -1218146999);
                        break block0;
                    }
                    case 4: {
                        this.fireDiscreteEvent(null, null, -1234924215);
                        break block0;
                    }
                }
                break;
            }
            case 119: {
                if (n != 2010775552) break;
                this.fireCommonEvent(null, null, -983003831);
                break;
            }
            case 120: {
                if (n != 2024865792) break;
                this.fireCommonEvent(null, null, -261780151);
                break;
            }
            case 122: {
                if (n != 2048459008) break;
                this.fireCommonEvent(null, null, -1889170103);
                break;
            }
            case 124: {
                if (n != 2088828928) break;
                int n33 = this.getInteger(2088828928);
                switch (n33) {
                    case 0: {
                        this.fireDiscreteEvent(null, null, -966488759);
                        break block0;
                    }
                    case 1: 
                    case 4: {
                        this.fireDiscreteEvent(null, null, -949711543);
                        break block0;
                    }
                    case 2: 
                    case 3: 
                    case 7: {
                        this.fireDiscreteEvent(null, null, -1000043191);
                        break block0;
                    }
                    case 5: {
                        this.fireDiscreteEvent(null, null, -983265975);
                        break block0;
                    }
                }
                break;
            }
            case 125: {
                if (n == 23421) {
                    this.fireCommonEvent(null, null, -1286042295);
                    break;
                }
                if (n == 22653) {
                    this.fireCommonEvent(null, null, -462975671);
                    break;
                }
                if (n != 2110324736) break;
                this.fireCommonEvent(null, null, -446198455);
                break;
            }
            case 126: {
                if (n != 2123956224) break;
                this.fireCommonEvent(null, null, -345666231);
                break;
            }
            case 127: {
                if (n == 19327) {
                    int n34 = this.getInteger(19327);
                    switch (n34) {
                        case 0: {
                            this.fireDiscreteEvent(null, null, 91);
                            break block0;
                        }
                        case 1: {
                            this.fireDiscreteEvent(null, null, 90);
                            break block0;
                        }
                        case 2: {
                            this.fireDiscreteEvent(null, null, 92);
                            break block0;
                        }
                    }
                    break;
                }
                if (n != 18303) break;
                this.fireCommonEvent(null, null, -999781047);
                break;
            }
            case 129: {
                if (n != -2117926912) break;
                this.fireCommonEvent(null, null, -1436250807);
                break;
            }
            case 130: {
                if (n == -2102657024) {
                    int n35 = this.getInteger(-2102657024);
                    switch (n35) {
                        case 0: {
                            this.fireDiscreteEvent(null, null, -513307319);
                            break block0;
                        }
                        case 1: {
                            this.fireDiscreteEvent(null, null, -496530103);
                            break block0;
                        }
                    }
                    break;
                }
                if (n != -2104688640) break;
                this.fireCommonEvent(null, null, 446);
                break;
            }
            case 131: {
                if (n != -2086993920) break;
                this.fireCommonEvent(null, null, -1453028023);
                break;
            }
            case 132: {
                if (n != -2071265280) break;
                int n36 = this.getInteger(-2071265280);
                switch (n36) {
                    case 0: {
                        this.fireDiscreteEvent(null, null, -278557367);
                        break block0;
                    }
                    case 1: {
                        this.fireDiscreteEvent(null, null, -295334583);
                        break block0;
                    }
                }
                break;
            }
            case 133: {
                if (n != -2062876416) break;
                this.fireCommonEvent(null, null, -412775095);
                break;
            }
            case 137: {
                if (n != 11657) break;
                this.fireCommonEvent(null, null, -194736823);
                break;
            }
            case 140: {
                if (n != -1944452864) break;
                this.fireCommonEvent(null, null, -1117483703);
                break;
            }
            case 145: {
                if (n != -1860304640) break;
                boolean bl = this.getBoolean(-1860304640);
                if (bl) {
                    this.fireDiscreteEvent(null, null, -326953728);
                    break;
                }
                this.fireDiscreteEvent(null, null, -310176512);
                break;
            }
            case 146: {
                if (n == 22674) {
                    this.fireCommonEvent(null, null, 1835044169);
                    break;
                }
                if (n != 14738) break;
                this.fireCommonEvent(null, null, 1902153033);
                break;
            }
            case 147: {
                if (n != -1828650752) break;
                int n37 = this.getInteger(-1828650752);
                switch (n37) {
                    case 0: {
                        this.fireDiscreteEvent(null, null, -865759927);
                        break block0;
                    }
                    case 1: {
                        this.fireDiscreteEvent(null, null, -630878903);
                        break block0;
                    }
                    case 2: {
                        this.fireDiscreteEvent(null, null, -563770039);
                        break block0;
                    }
                    case 3: {
                        this.fireDiscreteEvent(null, null, -614101687);
                        break block0;
                    }
                    case 4: {
                        this.fireDiscreteEvent(null, null, -546992823);
                        break block0;
                    }
                }
                break;
            }
            case 148: {
                if (n != -1802698752) break;
                this.fireCommonEvent(null, null, -429552311);
                break;
            }
            case 149: {
                if (n != -1780809728) break;
                this.fireCommonEvent(null, null, -261714615);
                break;
            }
            case 152: {
                if (n != 30104) break;
                this.fireCommonEvent(null, null, 157846857);
                break;
            }
            case 154: {
                boolean bl;
                if (n == -1709506304) {
                    int n38 = this.getInteger(-1709506304);
                    switch (n38) {
                        case 0: 
                        case 1: {
                            this.fireDiscreteEvent(null, null, 1935773001);
                            break block0;
                        }
                    }
                    break;
                }
                if (n != 17562 || (bl = this.getBoolean(17562))) break;
                this.fireDiscreteEvent(null, null, -866087607);
                break;
            }
            case 155: {
                boolean bl;
                if (n != -1681391616 || !(bl = this.getBoolean(-1681391616))) break;
                this.fireDiscreteEvent(null, null, -697987767);
                break;
            }
            case 156: {
                if (n != -1663107072) break;
                this.fireCommonEvent(null, null, -1033401015);
                break;
            }
            case 157: {
                if (n == 30109) {
                    int n39 = this.getInteger(30109);
                    switch (n39) {
                        case 2: {
                            this.fireDiscreteEvent(null, null, 694521161);
                            break block0;
                        }
                        case 3: {
                            this.fireDiscreteEvent(null, null, 677743945);
                            break block0;
                        }
                        case 4: {
                            this.fireDiscreteEvent(null, null, 644189513);
                            break block0;
                        }
                        case 6: {
                            this.fireDiscreteEvent(null, null, 660966729);
                            break block0;
                        }
                    }
                    break;
                }
                if (n != 21917) break;
                this.fireCommonEvent(null, null, -630682295);
                break;
            }
            case 158: {
                boolean bl;
                if (n != 12190 || !(bl = this.getBoolean(12190))) break;
                this.fireDiscreteEvent(null, null, 509971785);
                break;
            }
            case 161: {
                int n40;
                if (n != -1592196864 || (n40 = this.getInteger(-1592196864)) != 4) break;
                this.fireDiscreteEvent(null, null, 526749001);
                break;
            }
            case 164: {
                if (n != -1530658816) break;
                this.fireCommonEvent(null, null, -815297207);
                break;
            }
            case 167: {
                if (n != -1483079680) break;
                this.fireCommonEvent(null, null, -429421239);
                break;
            }
            case 169: {
                if (n == -1449721856) {
                    this.fireCommonEvent(null, null, 174427465);
                    break;
                }
                if (n != 10665) break;
                int n41 = this.getInteger(10665);
                switch (n41) {
                    case 0: 
                    case 1: 
                    case 2: 
                    case 3: 
                    case 4: {
                        this.fireDiscreteEvent(null, null, -181577216);
                        break block0;
                    }
                }
                break;
            }
            case 172: {
                if (n != -1395916800) break;
                this.fireCommonEvent(null, null, 208178505);
                break;
            }
            case 175: {
                if (n != -1347092480) break;
                this.fireCommonEvent(null, null, 1868598601);
                break;
            }
            case 177: {
                if (n == -1309868032) {
                    this.fireCommonEvent(null, null, -865628855);
                    break;
                }
                if (n != 20401) break;
                this.fireCommonEvent(null, null, -1184527031);
                break;
            }
            case 178: {
                if (n != -1293090816) break;
                this.fireCommonEvent(null, null, -983069367);
                break;
            }
            case 181: {
                if (n == -1245773824) {
                    int n42 = this.getInteger(-1245773824);
                    switch (n42) {
                        case 1: {
                            this.fireDiscreteEvent(null, null, -127496887);
                            break block0;
                        }
                        case 2: {
                            this.fireDiscreteEvent(null, null, -43610807);
                            break block0;
                        }
                        case 3: {
                            this.fireDiscreteEvent(null, null, -93942455);
                            break block0;
                        }
                        case 4: {
                            this.fireDiscreteEvent(null, null, -77165239);
                            break block0;
                        }
                        case 5: {
                            this.fireDiscreteEvent(null, null, -60388023);
                            break block0;
                        }
                        case 6: {
                            this.fireDiscreteEvent(null, null, -26833591);
                            break block0;
                        }
                        case 7: {
                            this.fireDiscreteEvent(null, null, -110719671);
                            break block0;
                        }
                    }
                    break;
                }
                if (n != -1243086848) break;
                this.fireCommonEvent(null, null, -345535159);
                break;
            }
            case 182: {
                if (n == -1228406784) {
                    int n43 = this.getInteger(-1228406784);
                    switch (n43) {
                        case 2: {
                            this.fireDiscreteEvent(null, null, -412840631);
                            break block0;
                        }
                        case 3: {
                            this.fireDiscreteEvent(null, null, -396063415);
                            break block0;
                        }
                        case 4: {
                            this.fireDiscreteEvent(null, null, -345731767);
                            break block0;
                        }
                        case 5: {
                            this.fireDiscreteEvent(null, null, -446395063);
                            break block0;
                        }
                        case 6: {
                            this.fireDiscreteEvent(null, null, -379286199);
                            break block0;
                        }
                        case 7: {
                            this.fireDiscreteEvent(null, null, -429617847);
                            break block0;
                        }
                        case 8: {
                            this.fireDiscreteEvent(null, null, -362508983);
                            break block0;
                        }
                    }
                    break;
                }
                if (n == 14262) {
                    int n44 = this.getInteger(14262);
                    if (n44 != 1) break;
                    this.fireDiscreteEvent(null, null, 493194569);
                    break;
                }
                if (n != 11190) break;
                this.fireCommonEvent(null, null, -1150972599);
                break;
            }
            case 183: {
                if (n != -1211629568) break;
                int n45 = this.getInteger(-1211629568);
                switch (n45) {
                    case 2: {
                        this.fireDiscreteEvent(null, null, -530281143);
                        break block0;
                    }
                    case 3: {
                        this.fireDiscreteEvent(null, null, -513503927);
                        break block0;
                    }
                    case 4: {
                        this.fireDiscreteEvent(null, null, -463172279);
                        break block0;
                    }
                    case 5: {
                        this.fireDiscreteEvent(null, null, -563835575);
                        break block0;
                    }
                    case 6: {
                        this.fireDiscreteEvent(null, null, -496726711);
                        break block0;
                    }
                    case 7: {
                        this.fireDiscreteEvent(null, null, -547058359);
                        break block0;
                    }
                    case 8: {
                        this.fireDiscreteEvent(null, null, -479949495);
                        break block0;
                    }
                }
                break;
            }
            case 184: {
                if (n == 30904) {
                    this.fireCommonEvent(null, null, -379089591);
                    break;
                }
                if (n != -1197146112) break;
                this.fireCommonEvent(null, null, 1012960585);
                break;
            }
            case 185: {
                if (n != 21945) break;
                int n46 = this.getInteger(21945);
                switch (n46) {
                    case 0: {
                        this.fireDiscreteEvent(null, null, 124292425);
                        break block0;
                    }
                    case 1: {
                        this.fireDiscreteEvent(null, null, 107515209);
                        break block0;
                    }
                    case 2: 
                    case 3: {
                        this.fireDiscreteEvent(null, null, -261649079);
                        break block0;
                    }
                }
                break;
            }
            case 186: {
                if (n == -1161297920) {
                    int n47 = this.getInteger(-1161297920);
                    switch (n47) {
                        case 2: {
                            this.fireDiscreteEvent(null, null, -647721655);
                            break block0;
                        }
                        case 3: {
                            this.fireDiscreteEvent(null, null, -630944439);
                            break block0;
                        }
                        case 4: {
                            this.fireDiscreteEvent(null, null, -580612791);
                            break block0;
                        }
                        case 5: {
                            this.fireDiscreteEvent(null, null, -681276087);
                            break block0;
                        }
                        case 6: {
                            this.fireDiscreteEvent(null, null, -614167223);
                            break block0;
                        }
                        case 7: {
                            this.fireDiscreteEvent(null, null, -664498871);
                            break block0;
                        }
                        case 8: {
                            this.fireDiscreteEvent(null, null, -597390007);
                            break block0;
                        }
                    }
                    break;
                }
                if (n != -1173159680) break;
                int n48 = this.getInteger(-1173159680);
                switch (n48) {
                    case 0: 
                    case 1: 
                    case 2: {
                        this.fireDiscreteEvent(null, null, -127890103);
                        break block0;
                    }
                }
                break;
            }
            case 187: {
                if (n != 25787) break;
                int n49 = this.getInteger(25787);
                switch (n49) {
                    case 2: {
                        this.fireDiscreteEvent(null, null, -295400119);
                        break block0;
                    }
                    case 3: {
                        this.fireDiscreteEvent(null, null, -278622903);
                        break block0;
                    }
                    case 4: {
                        this.fireDiscreteEvent(null, null, -228291255);
                        break block0;
                    }
                    case 5: {
                        this.fireDiscreteEvent(null, null, -328954551);
                        break block0;
                    }
                    case 6: {
                        this.fireDiscreteEvent(null, null, -261845687);
                        break block0;
                    }
                    case 7: {
                        this.fireDiscreteEvent(null, null, -312177335);
                        break block0;
                    }
                    case 8: {
                        this.fireDiscreteEvent(null, null, -245068471);
                        break block0;
                    }
                }
                break;
            }
            case 189: {
                if (n != 28093) break;
                this.fireCommonEvent(null, null, -10056375);
                break;
            }
            case 190: {
                if (n != -1097138176) break;
                this.fireCommonEvent(null, null, -328823479);
                break;
            }
            case 196: {
                if (n != -991166464) break;
                this.fireCommonEvent(null, null, -77099703);
                break;
            }
            case 197: {
                if (n == 24773) {
                    int n50 = this.getInteger(24773);
                    switch (n50) {
                        case 0: {
                            this.fireDiscreteEvent(null, null, 358976841);
                            break block0;
                        }
                        case 1: {
                            this.fireDiscreteEvent(null, null, 375754057);
                            break block0;
                        }
                        case 2: {
                            this.fireDiscreteEvent(null, null, 342199625);
                            break block0;
                        }
                        case 3: {
                            this.fireDiscreteEvent(null, null, 1533381961);
                            break block0;
                        }
                        case 4: {
                            this.fireDiscreteEvent(null, null, 1063619913);
                            break block0;
                        }
                        case 5: {
                            this.fireDiscreteEvent(null, null, 1466273097);
                            break block0;
                        }
                    }
                    break;
                }
                if (n == 14021) {
                    int n51 = this.getInteger(14021);
                    switch (n51) {
                        case 0: {
                            this.fireDiscreteEvent(null, null, -882537143);
                            break block0;
                        }
                        case 1: 
                        case 2: 
                        case 3: {
                            this.fireDiscreteEvent(null, null, -781873847);
                            break block0;
                        }
                    }
                    break;
                }
                if (n != -989724416) break;
                this.fireCommonEvent(null, null, 1918930249);
                break;
            }
            case 198: {
                if (n != -958660608) break;
                this.fireCommonEvent(null, null, -1050178231);
                break;
            }
            case 200: {
                if (n == -939261696) {
                    this.fireCommonEvent(null, null, -110850743);
                    break;
                }
                if (n != -928776192) break;
                this.fireCommonEvent(null, null, -2107273911);
                break;
            }
            case 201: {
                if (n != 18377) break;
                this.fireCommonEvent(null, null, -815428279);
                break;
            }
            case 202: {
                if (n == -892796928) {
                    this.fireCommonEvent(null, null, -781742775);
                    break;
                }
                if (n != 32458) break;
                this.fireCommonEvent(null, null, -177959607);
                break;
            }
            case 204: {
                if (n == -863240192) {
                    this.fireCommonEvent(null, null, 1700826441);
                    break;
                }
                if (n != 31180) break;
                this.fireCommonEvent(null, null, 258510153);
                break;
            }
            case 207: {
                boolean bl;
                if (n != -821296896 || !(bl = this.getBoolean(-821296896))) break;
                this.fireDiscreteEvent(null, null, 1264946505);
                break;
            }
            case 208: {
                if (n != 28112) break;
                this.fireCommonEvent(null, null, -127627959);
                break;
            }
            case 209: {
                if (n != -787939072) break;
                int n52 = this.getInteger(-787939072);
                switch (n52) {
                    case 0: 
                    case 1: 
                    case 2: 
                    case 3: {
                        this.fireDiscreteEvent(null, null, -1486582455);
                        break block0;
                    }
                    case 4: {
                        this.fireDiscreteEvent(null, null, -1469805239);
                        break block0;
                    }
                }
                break;
            }
            case 211: {
                if (n != -741736448) break;
                this.fireCommonEvent(null, null, -899117751);
                break;
            }
            case 212: {
                if (n != 30932) break;
                this.fireCommonEvent(null, null, 6786377);
                break;
            }
            case 213: {
                if (n != 26069) break;
                this.fireCommonEvent(null, null, 23563593);
                break;
            }
            case 214: {
                if (n != -693043200) break;
                int n53 = this.getInteger(-693043200);
                switch (n53) {
                    case 0: {
                        this.fireDiscreteEvent(null, null, -228094647);
                        break block0;
                    }
                    case 1: {
                        this.fireDiscreteEvent(null, null, -211317431);
                        break block0;
                    }
                    case 2: {
                        this.fireDiscreteEvent(null, null, -194540215);
                        break block0;
                    }
                    case 3: {
                        this.fireDiscreteEvent(null, null, -244871863);
                        break block0;
                    }
                    case 7: {
                        this.fireDiscreteEvent(null, null, -177762999);
                        break block0;
                    }
                }
                break;
            }
            case 217: {
                if (n != -652345088) break;
                boolean bl = this.getBoolean(-652345088);
                if (bl) {
                    this.fireDiscreteEvent(null, null, -164800000);
                    break;
                }
                this.fireDiscreteEvent(null, null, -164800000);
                break;
            }
            case 218: {
                if (n != 29914) break;
                this.fireCommonEvent(null, null, -1553691319);
                break;
            }
            case 221: {
                if (n == -586743552) {
                    this.fireCommonEvent(null, null, -479883959);
                    break;
                }
                if (n != -570949632) break;
                this.fireCommonEvent(null, null, -1217884855);
                break;
            }
            case 222: {
                if (n != -561905664) break;
                this.fireCommonEvent(null, null, -1184395959);
                break;
            }
            case 226: {
                if (n != -500956928) break;
                this.fireCommonEvent(null, null, 1801489737);
                break;
            }
            case 228: {
                if (n != -460980224) break;
                this.fireCommonEvent(null, null, 157650249);
                break;
            }
            case 229: {
                if (n == 12005) {
                    int n54 = this.getInteger(12005);
                    switch (n54) {
                        case 2: {
                            this.fireDiscreteEvent(null, null, -781939383);
                            break block0;
                        }
                        case 3: {
                            this.fireDiscreteEvent(null, null, -765162167);
                            break block0;
                        }
                        case 4: {
                            this.fireDiscreteEvent(null, null, -731607735);
                            break block0;
                        }
                        case 5: {
                            this.fireDiscreteEvent(null, null, -815493815);
                            break block0;
                        }
                        case 6: {
                            this.fireDiscreteEvent(null, null, -748384951);
                            break block0;
                        }
                        case 7: {
                            this.fireDiscreteEvent(null, null, -798716599);
                            break block0;
                        }
                    }
                    break;
                }
                if (n != 25829) break;
                this.fireCommonEvent(null, null, -278491831);
                break;
            }
            case 230: {
                if (n == 30950) {
                    this.fireCommonEvent(null, null, 140873033);
                    break;
                }
                if (n != -422379520) break;
                this.fireCommonEvent(null, null, -798651063);
                break;
            }
            case 231: {
                if (n == -417136384) {
                    int n55 = this.getInteger(-417136384);
                    if (n55 != 2) break;
                    this.fireDiscreteEvent(null, null, 1214614857);
                    break;
                }
                if (n == -408027136) {
                    int n56 = this.getInteger(-408027136);
                    switch (n56) {
                        case 0: {
                            this.fireDiscreteEvent(null, null, 1499827529);
                            break block0;
                        }
                        case 1: {
                            this.fireDiscreteEvent(null, null, 1516604745);
                            break block0;
                        }
                    }
                    break;
                }
                if (n != 13543) break;
                this.fireCommonEvent(null, null, 174624073);
                break;
            }
            case 232: {
                if (n != 32232) break;
                this.fireCommonEvent(null, null, -479752887);
                break;
            }
            case 233: {
                if (n != -376438784) break;
                this.fireCommonEvent(null, null, -1083732663);
                break;
            }
            case 237: {
                if (n != 13805) break;
                this.fireCommonEvent(null, null, -312046263);
                break;
            }
            case 242: {
                if (n != 27122) break;
                this.fireCommonEvent(null, null, -161182391);
                break;
            }
            case 245: {
                if (n == 10997) {
                    int n57 = this.getInteger(10997);
                    switch (n57) {
                        case 0: {
                            this.fireDiscreteEvent(null, null, 1181060425);
                            break block0;
                        }
                        case 1: {
                            this.fireDiscreteEvent(null, null, 543526217);
                            break block0;
                        }
                    }
                    break;
                }
                if (n != -183303936) break;
                this.fireCommonEvent(null, null, 1650101577);
                break;
            }
            case 246: {
                if (n != -157417472) break;
                this.fireCommonEvent(null, null, -664367799);
                break;
            }
            case 247: {
                if (n != -134938624) break;
                this.fireCommonEvent(null, null, -949514935);
                break;
            }
            case 248: {
                if (n != -124059648) break;
                this.fireCommonEvent(null, null, -1201304247);
                break;
            }
            case 249: {
                if (n != 22521) break;
                this.fireCommonEvent(null, null, 392531273);
                break;
            }
            case 252: {
                if (n == -53149696) {
                    int n58 = this.getInteger(-53149696);
                    if (n58 != 1) break;
                    this.fireDiscreteEvent(null, null, -1016820407);
                    break;
                }
                if (n == -56623104) {
                    this.fireCommonEvent(null, null, 1784712521);
                    break;
                }
                if (n != -50790400) break;
                this.fireCommonEvent(null, null, -1320409600);
                break;
            }
        }
    }

    private void fireCommonEvent(AppDefinition appDefinition, AppDefinition appDefinition2, int n) {
        ServiceManagerCommon.statemachineEventDispatcher.createAndSubmitDpChangedEvent(appDefinition, appDefinition2, n);
    }

    private void fireDiscreteEvent(AppDefinition appDefinition, AppDefinition appDefinition2, int n) {
        ServiceManagerCommon.statemachineEventDispatcher.createAndSubmitDpChangedEvent(appDefinition, appDefinition2, n);
    }
}

