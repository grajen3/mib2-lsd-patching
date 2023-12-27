/*
 * Decompiled with CFR 0.152.
 */
package generated.de.vw.mib.global.datapool;

import de.vw.mib.asl.api.speechengine.features.model.Prompt;
import de.vw.mib.asl.api.speechengine.features.model.PromptReference;
import de.vw.mib.datapool.StringUtils;
import de.vw.mib.hmi.internal.ServiceManagerCommon;
import de.vw.mib.sdfeaturecollectionmanager.internal.ServiceManagerSdFeatureCollection;
import generated.de.vw.mib.global.datapool.ModelDataPoolBase;

public final class SdPromptFactory
extends ModelDataPoolBase {
    private static final PromptReference[] INITIAL_PROMPTREF_VALUE = new PromptReference[0];
    private static SdPromptFactory instance;

    public static Prompt createPrompt(int n) {
        return SdPromptFactory.getInstance().createPromptInternal(n);
    }

    private static SdPromptFactory getInstance() {
        if (instance == null) {
            instance = new SdPromptFactory();
        }
        return instance;
    }

    private SdPromptFactory() {
    }

    private Prompt createPromptInternal(int n) {
        if (n == -1) {
            return null;
        }
        PromptReference[] promptReferenceArray = INITIAL_PROMPTREF_VALUE;
        switch (n) {
            case 424: {
                promptReferenceArray = new PromptReference[]{SdPromptFactory.createPromptReference(-1457192704, this.getLicValue(4037, 6, 0, ""), null)};
                break;
            }
            case 425: {
                promptReferenceArray = new PromptReference[]{SdPromptFactory.createPromptReference(27803, this.getLicValue(465, 6, 0, ""), null)};
                break;
            }
            case 426: {
                promptReferenceArray = new PromptReference[]{SdPromptFactory.createPromptReference(18310, this.getLicValue(465, 1, 0, ""), null), SdPromptFactory.createPromptReference(27803, this.getLicValue(465, 6, 0, ""), null)};
                break;
            }
            case 427: {
                promptReferenceArray = new PromptReference[]{SdPromptFactory.createPromptReference(-2120810496, this.getLicValue(465, 2, 0, ""), null), SdPromptFactory.createPromptReference(27803, this.getLicValue(465, 6, 0, ""), null)};
                break;
            }
            case 429: {
                promptReferenceArray = new PromptReference[]{SdPromptFactory.createPromptReference(27803, this.getLicValue(465, 6, 0, ""), null)};
                break;
            }
            case 432: {
                promptReferenceArray = new PromptReference[]{SdPromptFactory.createPromptReference(10975, this.getString(10975), null)};
                break;
            }
            case 433: {
                promptReferenceArray = new PromptReference[]{SdPromptFactory.createPromptReference(10975, this.getString(10975), null)};
                break;
            }
            case 435: {
                promptReferenceArray = new PromptReference[]{SdPromptFactory.createPromptReference(-436010752, this.getString(-436010752), null)};
                break;
            }
            case 436: {
                promptReferenceArray = new PromptReference[]{SdPromptFactory.createPromptReference(-436010752, this.getString(-436010752), null)};
                break;
            }
            case 438: {
                promptReferenceArray = new PromptReference[]{SdPromptFactory.createPromptReference(-436010752, this.getString(-436010752), null)};
                break;
            }
            case 440: {
                promptReferenceArray = new PromptReference[]{SdPromptFactory.createPromptReference(-436010752, this.getString(-436010752), null)};
                break;
            }
            case 444: {
                promptReferenceArray = new PromptReference[]{SdPromptFactory.createPromptReference(15712, this.getString(15712), null)};
                break;
            }
            case 445: {
                promptReferenceArray = new PromptReference[]{SdPromptFactory.createPromptReference(15712, this.getString(15712), null)};
                break;
            }
            case 477: {
                promptReferenceArray = new PromptReference[]{SdPromptFactory.createPromptReference(-1594556416, StringUtils.convertToString(this.getLicValue(-2146946048, 8, 0, 0L)), this.getLicValue(-2146946048, 9, 0, ""))};
                break;
            }
            case 478: {
                promptReferenceArray = new PromptReference[]{SdPromptFactory.createPromptReference(-1594556416, StringUtils.convertToString(this.getLicValue(-2146946048, 8, 0, 0L)), this.getLicValue(-2146946048, 9, 0, ""))};
                break;
            }
            case 480: {
                promptReferenceArray = new PromptReference[]{SdPromptFactory.createPromptReference(-1547632640, this.getLicValue(-2146946048, 3, 0, ""), null)};
                break;
            }
            case 483: {
                promptReferenceArray = new PromptReference[]{SdPromptFactory.createPromptReference(-1547632640, this.getLicValue(-2146946048, 3, 0, ""), null), SdPromptFactory.createPromptReference(18553, this.getLicValue(-2146946048, 7, 0, ""), null), SdPromptFactory.createPromptReference(96075776, this.getLicValue(-2146946048, 5, 0, ""), null)};
                break;
            }
            case 484: {
                promptReferenceArray = new PromptReference[]{SdPromptFactory.createPromptReference(1981939968, this.getLicValue(-2146946048, 15, 0, ""), null)};
                break;
            }
            case 485: {
                promptReferenceArray = new PromptReference[]{SdPromptFactory.createPromptReference(-837615360, this.getLicValue(-2146946048, 15, 0, ""), null)};
                break;
            }
            case 559: {
                promptReferenceArray = new PromptReference[]{SdPromptFactory.createPromptReference(1526792448, this.getString(1526792448), null)};
                break;
            }
            case 564: {
                promptReferenceArray = new PromptReference[]{SdPromptFactory.createPromptReference(-1684865024, StringUtils.convertToString(this.getInteger(-1684865024)), null)};
                break;
            }
            case 566: {
                promptReferenceArray = new PromptReference[]{SdPromptFactory.createPromptReference(-1684865024, StringUtils.convertToString(this.getInteger(-1684865024)), null)};
                break;
            }
            case 579: {
                promptReferenceArray = new PromptReference[]{SdPromptFactory.createPromptReference(21385, StringUtils.convertToString(this.getLicValue(-998166016, 0, 0, 0L)), this.getLicValue(-998166016, 9, 0, "Value name 0"))};
                break;
            }
            case 580: {
                promptReferenceArray = new PromptReference[]{SdPromptFactory.createPromptReference(29264, this.getLicValue(-998166016, 9, 0, "Value name 0"), null)};
                break;
            }
            case 581: {
                promptReferenceArray = new PromptReference[]{SdPromptFactory.createPromptReference(21385, StringUtils.convertToString(this.getLicValue(-998166016, 0, 0, 0L)), this.getLicValue(-998166016, 9, 0, "Value name 0"))};
                break;
            }
            case 582: {
                promptReferenceArray = new PromptReference[]{SdPromptFactory.createPromptReference(29264, this.getLicValue(-998166016, 9, 0, "Value name 0"), null)};
                break;
            }
            case 591: {
                promptReferenceArray = new PromptReference[]{SdPromptFactory.createPromptReference(21385, StringUtils.convertToString(this.getLicValue(-998166016, 0, 0, 0L)), this.getLicValue(-998166016, 9, 0, "Value name 0"))};
                break;
            }
            case 592: {
                promptReferenceArray = new PromptReference[]{SdPromptFactory.createPromptReference(29264, this.getLicValue(-998166016, 9, 0, "Value name 0"), null)};
                break;
            }
            case 609: {
                promptReferenceArray = new PromptReference[]{SdPromptFactory.createPromptReference(246349824, StringUtils.convertToString(this.getLicValue(-897502720, 0, 0, 0L)), this.getLicValue(-897502720, 2, 0, "Value name 0"))};
                break;
            }
            case 610: {
                promptReferenceArray = new PromptReference[]{SdPromptFactory.createPromptReference(246349824, StringUtils.convertToString(this.getLicValue(-897502720, 0, 0, 0L)), this.getLicValue(-897502720, 2, 0, "Value name 0"))};
                break;
            }
            case 611: {
                promptReferenceArray = new PromptReference[]{SdPromptFactory.createPromptReference(246349824, StringUtils.convertToString(this.getLicValue(-897502720, 0, 0, 0L)), this.getLicValue(-897502720, 2, 0, "Value name 0"))};
                break;
            }
            case 612: {
                promptReferenceArray = new PromptReference[]{SdPromptFactory.createPromptReference(246349824, StringUtils.convertToString(this.getLicValue(-897502720, 0, 0, 0L)), this.getLicValue(-897502720, 2, 0, "Value name 0"))};
                break;
            }
            case 613: {
                promptReferenceArray = new PromptReference[]{SdPromptFactory.createPromptReference(21385, StringUtils.convertToString(this.getLicValue(-998166016, 0, 0, 0L)), this.getLicValue(-998166016, 9, 0, "Value name 0"))};
                break;
            }
            case 614: {
                promptReferenceArray = new PromptReference[]{SdPromptFactory.createPromptReference(29264, this.getLicValue(-998166016, 9, 0, "Value name 0"), null)};
                break;
            }
            case 640: {
                promptReferenceArray = new PromptReference[]{SdPromptFactory.createPromptReference(-1054998272, StringUtils.convertToString(this.getInteger(-1054998272)), null)};
                break;
            }
            case 661: {
                promptReferenceArray = new PromptReference[]{SdPromptFactory.createPromptReference(15369, StringUtils.convertToString(this.getInteger(15369)), null)};
                break;
            }
            case 662: {
                promptReferenceArray = new PromptReference[]{SdPromptFactory.createPromptReference(15369, StringUtils.convertToString(this.getInteger(15369)), null)};
                break;
            }
            case 665: {
                promptReferenceArray = new PromptReference[]{SdPromptFactory.createPromptReference(30665, StringUtils.convertToString(this.getLicValue(1678259200, 0, 0, 0L)), this.getLicValue(1678259200, 2, 0, ""))};
                break;
            }
            case 666: {
                promptReferenceArray = new PromptReference[]{SdPromptFactory.createPromptReference(27719, this.getI18nString(5634), null)};
                break;
            }
            case 683: {
                promptReferenceArray = new PromptReference[]{SdPromptFactory.createPromptReference(-2097610752, StringUtils.convertToString(this.getLicValue(1711813632, 4, 0, 0L)), this.getString(28094))};
                break;
            }
            case 686: {
                promptReferenceArray = new PromptReference[]{SdPromptFactory.createPromptReference(1745420544, StringUtils.convertToString(this.getInteger(1745420544)), null)};
                break;
            }
            case 696: {
                promptReferenceArray = new PromptReference[]{SdPromptFactory.createPromptReference(1745420544, StringUtils.convertToString(this.getInteger(1745420544)), null)};
                break;
            }
            case 699: {
                promptReferenceArray = new PromptReference[]{SdPromptFactory.createPromptReference(28094, this.getString(28094), null)};
                break;
            }
            case 740: {
                promptReferenceArray = new PromptReference[]{SdPromptFactory.createPromptReference(1639972864, this.getLicValue(1544041472, 1, 0, ""), null), SdPromptFactory.createPromptReference(29928, this.getLicValue(1544041472, 14, 0, ""), null), SdPromptFactory.createPromptReference(-1326710784, this.getLicValue(1544041472, 3, 0, ""), null), SdPromptFactory.createPromptReference(19701, this.getLicValue(1544041472, 2, 0, ""), null)};
                break;
            }
            case 741: {
                promptReferenceArray = new PromptReference[]{SdPromptFactory.createPromptReference(1639972864, this.getLicValue(1544041472, 1, 0, ""), null)};
                break;
            }
            case 771: {
                promptReferenceArray = new PromptReference[]{SdPromptFactory.createPromptReference(1763180800, this.getLicValue(1544041472, 12, 0, ""), null)};
                break;
            }
            case 775: {
                promptReferenceArray = new PromptReference[]{SdPromptFactory.createPromptReference(1764229376, this.getLicValue(1393046528, 2, 0, ""), null)};
                break;
            }
            case 778: {
                promptReferenceArray = new PromptReference[]{SdPromptFactory.createPromptReference(18624, ServiceManagerCommon.fixFormat.format(132, this.getString(28094)), null)};
                break;
            }
            case 783: {
                promptReferenceArray = new PromptReference[]{SdPromptFactory.createPromptReference(18549, this.getLicValue(1560818688, 4, 0, ""), null), SdPromptFactory.createPromptReference(1309344000, this.getLicValue(1560818688, 5, 0, ""), null)};
                break;
            }
            case 784: {
                promptReferenceArray = new PromptReference[]{SdPromptFactory.createPromptReference(18549, this.getLicValue(1560818688, 4, 0, ""), null), SdPromptFactory.createPromptReference(1309344000, this.getLicValue(1560818688, 5, 0, ""), null), SdPromptFactory.createPromptReference(-1331953664, this.getLicValue(1560818688, 6, 0, ""), null)};
                break;
            }
            case 785: {
                promptReferenceArray = new PromptReference[]{SdPromptFactory.createPromptReference(18549, this.getLicValue(1560818688, 4, 0, ""), null), SdPromptFactory.createPromptReference(32692, this.getLicValue(1560818688, 7, 0, ""), null), SdPromptFactory.createPromptReference(1309344000, this.getLicValue(1560818688, 5, 0, ""), null), SdPromptFactory.createPromptReference(-1331953664, this.getLicValue(1560818688, 6, 0, ""), null)};
                break;
            }
            case 786: {
                promptReferenceArray = new PromptReference[]{SdPromptFactory.createPromptReference(18549, this.getLicValue(1560818688, 4, 0, ""), null), SdPromptFactory.createPromptReference(-1030946816, this.getLicValue(1560818688, 8, 0, ""), null), SdPromptFactory.createPromptReference(1309344000, this.getLicValue(1560818688, 5, 0, ""), null), SdPromptFactory.createPromptReference(-1331953664, this.getLicValue(1560818688, 6, 0, ""), null)};
                break;
            }
            case 788: {
                promptReferenceArray = new PromptReference[]{SdPromptFactory.createPromptReference(-341114880, this.getString(-341114880), null)};
                break;
            }
            case 793: {
                promptReferenceArray = new PromptReference[]{SdPromptFactory.createPromptReference(-341114880, this.getString(-341114880), null)};
                break;
            }
            case 797: {
                promptReferenceArray = new PromptReference[]{SdPromptFactory.createPromptReference(567934976, this.getLicValue(1560818688, 0, 0, ""), null)};
                break;
            }
            case 798: {
                promptReferenceArray = new PromptReference[]{SdPromptFactory.createPromptReference(28094, this.getString(28094), null)};
                break;
            }
            case 800: {
                promptReferenceArray = new PromptReference[]{SdPromptFactory.createPromptReference(567934976, this.getLicValue(1560818688, 0, 0, ""), null)};
                break;
            }
            case 802: {
                promptReferenceArray = new PromptReference[]{SdPromptFactory.createPromptReference(1132527616, this.getLicValue(1627927552, 1, 0, ""), null)};
                break;
            }
            case 805: {
                promptReferenceArray = new PromptReference[]{SdPromptFactory.createPromptReference(28094, this.getString(28094), null)};
                break;
            }
            case 809: {
                promptReferenceArray = new PromptReference[]{SdPromptFactory.createPromptReference(1132527616, this.getLicValue(1627927552, 1, 0, ""), null)};
                break;
            }
            case 815: {
                promptReferenceArray = new PromptReference[]{SdPromptFactory.createPromptReference(718012416, this.getLicValue(-2012728320, 2, 0, ""), null), SdPromptFactory.createPromptReference(1207042048, this.getLicValue(-2012728320, 4, 0, ""), null)};
                break;
            }
            case 830: {
                promptReferenceArray = new PromptReference[]{SdPromptFactory.createPromptReference(-341114880, this.getString(-341114880), null), SdPromptFactory.createPromptReference(-308215808, this.getLicValue(2013803520, 2, 0, ""), null)};
                break;
            }
            case 876: {
                promptReferenceArray = new PromptReference[]{SdPromptFactory.createPromptReference(567934976, this.getLicValue(1560818688, 0, 0, ""), null)};
                break;
            }
            case 877: {
                promptReferenceArray = new PromptReference[]{SdPromptFactory.createPromptReference(567934976, this.getLicValue(1560818688, 0, 0, ""), null)};
                break;
            }
            case 881: {
                promptReferenceArray = new PromptReference[]{SdPromptFactory.createPromptReference(1132527616, this.getLicValue(1627927552, 1, 0, ""), null)};
                break;
            }
            case 886: {
                promptReferenceArray = new PromptReference[]{SdPromptFactory.createPromptReference(28094, this.getString(28094), null)};
                break;
            }
            case 890: {
                promptReferenceArray = new PromptReference[]{SdPromptFactory.createPromptReference(1132527616, this.getLicValue(1627927552, 1, 0, ""), null)};
                break;
            }
            case 895: {
                promptReferenceArray = new PromptReference[]{SdPromptFactory.createPromptReference(-610467840, this.getString(-610467840), null), SdPromptFactory.createPromptReference(1503330304, this.getString(1503330304), null)};
                break;
            }
            case 898: {
                promptReferenceArray = new PromptReference[]{SdPromptFactory.createPromptReference(18458, this.getString(18458), null), SdPromptFactory.createPromptReference(-490668032, this.getString(-490668032), null)};
                break;
            }
            case 972: {
                promptReferenceArray = new PromptReference[]{SdPromptFactory.createPromptReference(-492765184, this.getLicValue(2064135168, 2, 0, ""), null)};
                break;
            }
            case 973: {
                promptReferenceArray = new PromptReference[]{SdPromptFactory.createPromptReference(-492765184, this.getLicValue(2064135168, 2, 0, ""), null), SdPromptFactory.createPromptReference(0x4DD00000, this.getLicValue(2064135168, 6, 0, ""), null), SdPromptFactory.createPromptReference(16914, this.getLicValue(2064135168, 4, 0, ""), null)};
                break;
            }
            case 982: {
                promptReferenceArray = new PromptReference[]{SdPromptFactory.createPromptReference(10173, this.getLicValue(2097689600, 1, 0, ""), null)};
                break;
            }
            case 983: {
                promptReferenceArray = new PromptReference[]{SdPromptFactory.createPromptReference(10173, this.getLicValue(2097689600, 1, 0, ""), null), SdPromptFactory.createPromptReference(-322633728, this.getLicValue(2097689600, 5, 0, ""), null), SdPromptFactory.createPromptReference(24131, this.getLicValue(2097689600, 3, 0, ""), null)};
                break;
            }
            case 1023: {
                promptReferenceArray = new PromptReference[]{SdPromptFactory.createPromptReference(1639972864, this.getLicValue(1544041472, 1, 0, ""), null), SdPromptFactory.createPromptReference(29928, this.getLicValue(1544041472, 14, 0, ""), null), SdPromptFactory.createPromptReference(-1326710784, this.getLicValue(1544041472, 3, 0, ""), null), SdPromptFactory.createPromptReference(19701, this.getLicValue(1544041472, 2, 0, ""), null), SdPromptFactory.createPromptReference(-1357446912, this.getLicValue(1997026304, 2, 0, ""), null)};
                break;
            }
            case 1039: {
                promptReferenceArray = new PromptReference[]{SdPromptFactory.createPromptReference(18080, this.getLicValue(1862808576, 4, 0, ""), null)};
                break;
            }
            case 1041: {
                promptReferenceArray = new PromptReference[]{SdPromptFactory.createPromptReference(18080, this.getLicValue(1862808576, 4, 0, ""), null)};
                break;
            }
            case 1042: {
                promptReferenceArray = new PromptReference[]{SdPromptFactory.createPromptReference(18080, this.getLicValue(1862808576, 4, 0, ""), null)};
                break;
            }
            case 1044: {
                promptReferenceArray = new PromptReference[]{SdPromptFactory.createPromptReference(18080, this.getLicValue(1862808576, 4, 0, ""), null)};
                break;
            }
            case 1047: {
                promptReferenceArray = new PromptReference[]{SdPromptFactory.createPromptReference(19200, this.getLicValue(1829254144, 5, 0, ""), null)};
                break;
            }
            case 1049: {
                promptReferenceArray = new PromptReference[]{SdPromptFactory.createPromptReference(-685637376, this.getLicValue(2131244032, 2, 0, ""), null)};
                break;
            }
            case 1051: {
                promptReferenceArray = new PromptReference[]{SdPromptFactory.createPromptReference(-685637376, this.getLicValue(2131244032, 2, 0, ""), null)};
                break;
            }
            case 1101: {
                promptReferenceArray = new PromptReference[]{SdPromptFactory.createPromptReference(219283712, this.getString(219283712), null)};
                break;
            }
            case 1115: {
                promptReferenceArray = new PromptReference[]{SdPromptFactory.createPromptReference(18292, this.getLicValue(-1968620800, 2, 0, ""), null)};
                break;
            }
            case 1116: {
                promptReferenceArray = new PromptReference[]{SdPromptFactory.createPromptReference(147259392, StringUtils.convertToString(this.getLicValue(-1968620800, 0, 0, 0L)), this.getLicValue(-1968620800, 2, 0, ""))};
                break;
            }
            case 1117: {
                promptReferenceArray = new PromptReference[]{SdPromptFactory.createPromptReference(147259392, StringUtils.convertToString(this.getLicValue(-1968620800, 0, 0, 0L)), this.getLicValue(-1968620800, 2, 0, ""))};
                break;
            }
            case 1118: {
                promptReferenceArray = new PromptReference[]{SdPromptFactory.createPromptReference(147259392, StringUtils.convertToString(this.getLicValue(-1968620800, 0, 0, 0L)), this.getLicValue(-1968620800, 2, 0, ""))};
                break;
            }
            case 1119: {
                promptReferenceArray = new PromptReference[]{SdPromptFactory.createPromptReference(147259392, StringUtils.convertToString(this.getLicValue(-1968620800, 0, 0, 0L)), this.getLicValue(-1968620800, 2, 0, ""))};
                break;
            }
            case 1120: {
                promptReferenceArray = new PromptReference[]{SdPromptFactory.createPromptReference(147259392, StringUtils.convertToString(this.getLicValue(-1968620800, 0, 0, 0L)), this.getLicValue(-1968620800, 2, 0, ""))};
                break;
            }
            case 1121: {
                promptReferenceArray = new PromptReference[]{SdPromptFactory.createPromptReference(147259392, StringUtils.convertToString(this.getLicValue(-1968620800, 0, 0, 0L)), this.getLicValue(-1968620800, 2, 0, ""))};
                break;
            }
            case 1122: {
                promptReferenceArray = new PromptReference[]{SdPromptFactory.createPromptReference(147259392, StringUtils.convertToString(this.getLicValue(-1968620800, 0, 0, 0L)), this.getLicValue(-1968620800, 2, 0, ""))};
                break;
            }
            case 1123: {
                promptReferenceArray = new PromptReference[]{SdPromptFactory.createPromptReference(-1265041408, this.getLicValue(-1935066368, 2, 0, ""), null)};
                break;
            }
            case 1134: {
                promptReferenceArray = new PromptReference[]{SdPromptFactory.createPromptReference(-1278279680, StringUtils.convertToString(this.getLicValue(-1985398016, 0, 0, 0L)), this.getLicValue(-1985398016, 2, 0, ""))};
                break;
            }
            case 1135: {
                promptReferenceArray = new PromptReference[]{SdPromptFactory.createPromptReference(-1278279680, StringUtils.convertToString(this.getLicValue(-1985398016, 0, 0, 0L)), this.getLicValue(-1985398016, 2, 0, ""))};
                break;
            }
            case 1136: {
                promptReferenceArray = new PromptReference[]{SdPromptFactory.createPromptReference(-1278279680, StringUtils.convertToString(this.getLicValue(-1985398016, 0, 0, 0L)), this.getLicValue(-1985398016, 2, 0, ""))};
                break;
            }
            case 1137: {
                promptReferenceArray = new PromptReference[]{SdPromptFactory.createPromptReference(-1278279680, StringUtils.convertToString(this.getLicValue(-1985398016, 0, 0, 0L)), this.getLicValue(-1985398016, 2, 0, ""))};
                break;
            }
            case 1138: {
                promptReferenceArray = new PromptReference[]{SdPromptFactory.createPromptReference(-1278279680, StringUtils.convertToString(this.getLicValue(-1985398016, 0, 0, 0L)), this.getLicValue(-1985398016, 2, 0, ""))};
                break;
            }
            case 1139: {
                promptReferenceArray = new PromptReference[]{SdPromptFactory.createPromptReference(-1278279680, StringUtils.convertToString(this.getLicValue(-1985398016, 0, 0, 0L)), this.getLicValue(-1985398016, 2, 0, ""))};
                break;
            }
            case 1141: {
                promptReferenceArray = new PromptReference[]{SdPromptFactory.createPromptReference(-1278279680, StringUtils.convertToString(this.getLicValue(-1985398016, 0, 0, 0L)), this.getLicValue(-1985398016, 2, 0, ""))};
                break;
            }
            case 1142: {
                promptReferenceArray = new PromptReference[]{SdPromptFactory.createPromptReference(-1278279680, StringUtils.convertToString(this.getLicValue(-1985398016, 0, 0, 0L)), this.getLicValue(-1985398016, 2, 0, ""))};
                break;
            }
            case 1143: {
                promptReferenceArray = new PromptReference[]{SdPromptFactory.createPromptReference(-1278279680, StringUtils.convertToString(this.getLicValue(-1985398016, 0, 0, 0L)), this.getLicValue(-1985398016, 2, 0, ""))};
                break;
            }
            case 1144: {
                promptReferenceArray = new PromptReference[]{SdPromptFactory.createPromptReference(-1278279680, StringUtils.convertToString(this.getLicValue(-1985398016, 0, 0, 0L)), this.getLicValue(-1985398016, 2, 0, ""))};
                break;
            }
            case 1145: {
                promptReferenceArray = new PromptReference[]{SdPromptFactory.createPromptReference(-1278279680, StringUtils.convertToString(this.getLicValue(-1985398016, 0, 0, 0L)), this.getLicValue(-1985398016, 2, 0, ""))};
                break;
            }
            case 1146: {
                promptReferenceArray = new PromptReference[]{SdPromptFactory.createPromptReference(-1278279680, StringUtils.convertToString(this.getLicValue(-1985398016, 0, 0, 0L)), this.getLicValue(-1985398016, 2, 0, ""))};
                break;
            }
            case 1148: {
                promptReferenceArray = new PromptReference[]{SdPromptFactory.createPromptReference(22167, StringUtils.convertToString(this.getInteger(22167)), null)};
                break;
            }
            case 1150: {
                promptReferenceArray = new PromptReference[]{SdPromptFactory.createPromptReference(22167, StringUtils.convertToString(this.getInteger(22167)), null)};
                break;
            }
            case 1152: {
                promptReferenceArray = new PromptReference[]{SdPromptFactory.createPromptReference(22167, StringUtils.convertToString(this.getInteger(22167)), null)};
                break;
            }
            case 1154: {
                promptReferenceArray = new PromptReference[]{SdPromptFactory.createPromptReference(22167, StringUtils.convertToString(this.getInteger(22167)), null)};
                break;
            }
            case 1156: {
                promptReferenceArray = new PromptReference[]{SdPromptFactory.createPromptReference(22167, StringUtils.convertToString(this.getInteger(22167)), null)};
                break;
            }
            case 1158: {
                promptReferenceArray = new PromptReference[]{SdPromptFactory.createPromptReference(22167, StringUtils.convertToString(this.getInteger(22167)), null)};
                break;
            }
            case 1159: {
                promptReferenceArray = new PromptReference[]{SdPromptFactory.createPromptReference(22167, StringUtils.convertToString(this.getInteger(22167)), null), SdPromptFactory.createPromptReference(-1278279680, StringUtils.convertToString(this.getLicValue(-1985398016, 0, 0, 0L)), this.getLicValue(-1985398016, 2, 0, ""))};
                break;
            }
            case 1160: {
                promptReferenceArray = new PromptReference[]{SdPromptFactory.createPromptReference(22167, StringUtils.convertToString(this.getInteger(22167)), null), SdPromptFactory.createPromptReference(-1278279680, StringUtils.convertToString(this.getLicValue(-1985398016, 0, 0, 0L)), this.getLicValue(-1985398016, 2, 0, ""))};
                break;
            }
            case 1161: {
                promptReferenceArray = new PromptReference[]{SdPromptFactory.createPromptReference(22167, StringUtils.convertToString(this.getInteger(22167)), null), SdPromptFactory.createPromptReference(-1278279680, StringUtils.convertToString(this.getLicValue(-1985398016, 0, 0, 0L)), this.getLicValue(-1985398016, 2, 0, ""))};
                break;
            }
            case 1162: {
                promptReferenceArray = new PromptReference[]{SdPromptFactory.createPromptReference(22167, StringUtils.convertToString(this.getInteger(22167)), null), SdPromptFactory.createPromptReference(-1278279680, StringUtils.convertToString(this.getLicValue(-1985398016, 0, 0, 0L)), this.getLicValue(-1985398016, 2, 0, ""))};
                break;
            }
            case 1163: {
                promptReferenceArray = new PromptReference[]{SdPromptFactory.createPromptReference(22167, StringUtils.convertToString(this.getInteger(22167)), null), SdPromptFactory.createPromptReference(-1278279680, StringUtils.convertToString(this.getLicValue(-1985398016, 0, 0, 0L)), this.getLicValue(-1985398016, 2, 0, ""))};
                break;
            }
            case 1164: {
                promptReferenceArray = new PromptReference[]{SdPromptFactory.createPromptReference(22167, StringUtils.convertToString(this.getInteger(22167)), null), SdPromptFactory.createPromptReference(-1278279680, StringUtils.convertToString(this.getLicValue(-1985398016, 0, 0, 0L)), this.getLicValue(-1985398016, 2, 0, ""))};
                break;
            }
            case 1167: {
                promptReferenceArray = new PromptReference[]{SdPromptFactory.createPromptReference(22167, StringUtils.convertToString(this.getInteger(22167)), null)};
                break;
            }
            case 1169: {
                promptReferenceArray = new PromptReference[]{SdPromptFactory.createPromptReference(22167, StringUtils.convertToString(this.getInteger(22167)), null)};
                break;
            }
            case 1171: {
                promptReferenceArray = new PromptReference[]{SdPromptFactory.createPromptReference(22167, StringUtils.convertToString(this.getInteger(22167)), null)};
                break;
            }
            case 1173: {
                promptReferenceArray = new PromptReference[]{SdPromptFactory.createPromptReference(22167, StringUtils.convertToString(this.getInteger(22167)), null)};
                break;
            }
            case 1175: {
                promptReferenceArray = new PromptReference[]{SdPromptFactory.createPromptReference(22167, StringUtils.convertToString(this.getInteger(22167)), null)};
                break;
            }
            case 1177: {
                promptReferenceArray = new PromptReference[]{SdPromptFactory.createPromptReference(22167, StringUtils.convertToString(this.getInteger(22167)), null)};
                break;
            }
            case 1178: {
                promptReferenceArray = new PromptReference[]{SdPromptFactory.createPromptReference(-1278279680, StringUtils.convertToString(this.getLicValue(-1985398016, 0, 0, 0L)), this.getLicValue(-1985398016, 2, 0, ""))};
                break;
            }
            case 1179: {
                promptReferenceArray = new PromptReference[]{SdPromptFactory.createPromptReference(-1278279680, StringUtils.convertToString(this.getLicValue(-1985398016, 0, 0, 0L)), this.getLicValue(-1985398016, 2, 0, ""))};
                break;
            }
            case 1180: {
                promptReferenceArray = new PromptReference[]{SdPromptFactory.createPromptReference(-1278279680, StringUtils.convertToString(this.getLicValue(-1985398016, 0, 0, 0L)), this.getLicValue(-1985398016, 2, 0, ""))};
                break;
            }
            case 1181: {
                promptReferenceArray = new PromptReference[]{SdPromptFactory.createPromptReference(-1278279680, StringUtils.convertToString(this.getLicValue(-1985398016, 0, 0, 0L)), this.getLicValue(-1985398016, 2, 0, ""))};
                break;
            }
            case 1182: {
                promptReferenceArray = new PromptReference[]{SdPromptFactory.createPromptReference(-1278279680, StringUtils.convertToString(this.getLicValue(-1985398016, 0, 0, 0L)), this.getLicValue(-1985398016, 2, 0, ""))};
                break;
            }
            case 1183: {
                promptReferenceArray = new PromptReference[]{SdPromptFactory.createPromptReference(-1278279680, StringUtils.convertToString(this.getLicValue(-1985398016, 0, 0, 0L)), this.getLicValue(-1985398016, 2, 0, ""))};
                break;
            }
            case 1184: {
                promptReferenceArray = new PromptReference[]{SdPromptFactory.createPromptReference(-1278279680, StringUtils.convertToString(this.getLicValue(-1985398016, 0, 0, 0L)), this.getLicValue(-1985398016, 2, 0, ""))};
                break;
            }
            case 1193: {
                promptReferenceArray = new PromptReference[]{SdPromptFactory.createPromptReference(-291569664, StringUtils.convertToString(this.getLicValue(-2018952448, 0, 0, 0L)), this.getLicValue(-2018952448, 2, 0, ""))};
                break;
            }
            case 1194: {
                promptReferenceArray = new PromptReference[]{SdPromptFactory.createPromptReference(-291569664, StringUtils.convertToString(this.getLicValue(-2018952448, 0, 0, 0L)), this.getLicValue(-2018952448, 2, 0, ""))};
                break;
            }
            case 1195: {
                promptReferenceArray = new PromptReference[]{SdPromptFactory.createPromptReference(-291569664, StringUtils.convertToString(this.getLicValue(-2018952448, 0, 0, 0L)), this.getLicValue(-2018952448, 2, 0, ""))};
                break;
            }
            case 1196: {
                promptReferenceArray = new PromptReference[]{SdPromptFactory.createPromptReference(-291569664, StringUtils.convertToString(this.getLicValue(-2018952448, 0, 0, 0L)), this.getLicValue(-2018952448, 2, 0, ""))};
                break;
            }
            case 1197: {
                promptReferenceArray = new PromptReference[]{SdPromptFactory.createPromptReference(-291569664, StringUtils.convertToString(this.getLicValue(-2018952448, 0, 0, 0L)), this.getLicValue(-2018952448, 2, 0, ""))};
                break;
            }
            case 1198: {
                promptReferenceArray = new PromptReference[]{SdPromptFactory.createPromptReference(-291569664, StringUtils.convertToString(this.getLicValue(-2018952448, 0, 0, 0L)), this.getLicValue(-2018952448, 2, 0, ""))};
                break;
            }
            case 1199: {
                promptReferenceArray = new PromptReference[]{SdPromptFactory.createPromptReference(-291569664, StringUtils.convertToString(this.getLicValue(-2018952448, 0, 0, 0L)), this.getLicValue(-2018952448, 2, 0, ""))};
                break;
            }
            case 1200: {
                promptReferenceArray = new PromptReference[]{SdPromptFactory.createPromptReference(-291569664, StringUtils.convertToString(this.getLicValue(-2018952448, 0, 0, 0L)), this.getLicValue(-2018952448, 2, 0, ""))};
                break;
            }
            case 1201: {
                promptReferenceArray = new PromptReference[]{SdPromptFactory.createPromptReference(297074688, this.getLicValue(-1985398016, 2, 0, ""), null)};
                break;
            }
            case 1206: {
                promptReferenceArray = new PromptReference[]{SdPromptFactory.createPromptReference(-291569664, StringUtils.convertToString(this.getLicValue(-2018952448, 0, 0, 0L)), this.getLicValue(-2018952448, 2, 0, ""))};
                break;
            }
            case 1209: {
                promptReferenceArray = new PromptReference[]{SdPromptFactory.createPromptReference(-1278279680, StringUtils.convertToString(this.getLicValue(-1985398016, 0, 0, 0L)), this.getLicValue(-1985398016, 2, 0, ""))};
                break;
            }
            case 1210: {
                promptReferenceArray = new PromptReference[]{SdPromptFactory.createPromptReference(-1278279680, StringUtils.convertToString(this.getLicValue(-1985398016, 0, 0, 0L)), this.getLicValue(-1985398016, 2, 0, ""))};
                break;
            }
            case 1211: {
                promptReferenceArray = new PromptReference[]{SdPromptFactory.createPromptReference(-1278279680, StringUtils.convertToString(this.getLicValue(-1985398016, 0, 0, 0L)), this.getLicValue(-1985398016, 2, 0, ""))};
                break;
            }
            case 1212: {
                promptReferenceArray = new PromptReference[]{SdPromptFactory.createPromptReference(-1278279680, StringUtils.convertToString(this.getLicValue(-1985398016, 0, 0, 0L)), this.getLicValue(-1985398016, 2, 0, ""))};
                break;
            }
            case 1213: {
                promptReferenceArray = new PromptReference[]{SdPromptFactory.createPromptReference(-1278279680, StringUtils.convertToString(this.getLicValue(-1985398016, 0, 0, 0L)), this.getLicValue(-1985398016, 2, 0, ""))};
                break;
            }
            case 1214: {
                promptReferenceArray = new PromptReference[]{SdPromptFactory.createPromptReference(-1278279680, StringUtils.convertToString(this.getLicValue(-1985398016, 0, 0, 0L)), this.getLicValue(-1985398016, 2, 0, ""))};
                break;
            }
            case 1215: {
                promptReferenceArray = new PromptReference[]{SdPromptFactory.createPromptReference(-1278279680, StringUtils.convertToString(this.getLicValue(-1985398016, 0, 0, 0L)), this.getLicValue(-1985398016, 2, 0, ""))};
                break;
            }
            case 1216: {
                promptReferenceArray = new PromptReference[]{SdPromptFactory.createPromptReference(-1278279680, StringUtils.convertToString(this.getLicValue(-1985398016, 0, 0, 0L)), this.getLicValue(-1985398016, 2, 0, ""))};
                break;
            }
            case 1217: {
                promptReferenceArray = new PromptReference[]{SdPromptFactory.createPromptReference(-1278279680, StringUtils.convertToString(this.getLicValue(-1985398016, 0, 0, 0L)), this.getLicValue(-1985398016, 2, 0, ""))};
                break;
            }
            case 1218: {
                promptReferenceArray = new PromptReference[]{SdPromptFactory.createPromptReference(-1278279680, StringUtils.convertToString(this.getLicValue(-1985398016, 0, 0, 0L)), this.getLicValue(-1985398016, 2, 0, ""))};
                break;
            }
            case 1219: {
                promptReferenceArray = new PromptReference[]{SdPromptFactory.createPromptReference(-1278279680, StringUtils.convertToString(this.getLicValue(-1985398016, 0, 0, 0L)), this.getLicValue(-1985398016, 2, 0, ""))};
                break;
            }
            case 1220: {
                promptReferenceArray = new PromptReference[]{SdPromptFactory.createPromptReference(-1278279680, StringUtils.convertToString(this.getLicValue(-1985398016, 0, 0, 0L)), this.getLicValue(-1985398016, 2, 0, ""))};
                break;
            }
            case 1221: {
                promptReferenceArray = new PromptReference[]{SdPromptFactory.createPromptReference(-1278279680, StringUtils.convertToString(this.getLicValue(-1985398016, 0, 0, 0L)), this.getLicValue(-1985398016, 2, 0, ""))};
                break;
            }
            case 1222: {
                promptReferenceArray = new PromptReference[]{SdPromptFactory.createPromptReference(-1278279680, StringUtils.convertToString(this.getLicValue(-1985398016, 0, 0, 0L)), this.getLicValue(-1985398016, 2, 0, ""))};
                break;
            }
            case 1223: {
                promptReferenceArray = new PromptReference[]{SdPromptFactory.createPromptReference(-1278279680, StringUtils.convertToString(this.getLicValue(-1985398016, 0, 0, 0L)), this.getLicValue(-1985398016, 2, 0, ""))};
                break;
            }
            case 1224: {
                promptReferenceArray = new PromptReference[]{SdPromptFactory.createPromptReference(-1278279680, StringUtils.convertToString(this.getLicValue(-1985398016, 0, 0, 0L)), this.getLicValue(-1985398016, 2, 0, ""))};
                break;
            }
            case 1225: {
                promptReferenceArray = new PromptReference[]{SdPromptFactory.createPromptReference(-1278279680, StringUtils.convertToString(this.getLicValue(-1985398016, 0, 0, 0L)), this.getLicValue(-1985398016, 2, 0, ""))};
                break;
            }
            case 1226: {
                promptReferenceArray = new PromptReference[]{SdPromptFactory.createPromptReference(-1278279680, StringUtils.convertToString(this.getLicValue(-1985398016, 0, 0, 0L)), this.getLicValue(-1985398016, 2, 0, ""))};
                break;
            }
            case 1227: {
                promptReferenceArray = new PromptReference[]{SdPromptFactory.createPromptReference(-1278279680, StringUtils.convertToString(this.getLicValue(-1985398016, 0, 0, 0L)), this.getLicValue(-1985398016, 2, 0, ""))};
                break;
            }
            case 1228: {
                promptReferenceArray = new PromptReference[]{SdPromptFactory.createPromptReference(-1278279680, StringUtils.convertToString(this.getLicValue(-1985398016, 0, 0, 0L)), this.getLicValue(-1985398016, 2, 0, ""))};
                break;
            }
            case 1229: {
                promptReferenceArray = new PromptReference[]{SdPromptFactory.createPromptReference(-1278279680, StringUtils.convertToString(this.getLicValue(-1985398016, 0, 0, 0L)), this.getLicValue(-1985398016, 2, 0, ""))};
                break;
            }
            case 1235: {
                promptReferenceArray = new PromptReference[]{SdPromptFactory.createPromptReference(-1595736064, this.getString(-1595736064), null)};
                break;
            }
            case 1238: {
                promptReferenceArray = new PromptReference[]{SdPromptFactory.createPromptReference(16367, this.getString(16367), null)};
                break;
            }
            case 1242: {
                promptReferenceArray = new PromptReference[]{SdPromptFactory.createPromptReference(-1595736064, this.getString(-1595736064), null)};
                break;
            }
            case 1246: {
                promptReferenceArray = new PromptReference[]{SdPromptFactory.createPromptReference(16367, this.getString(16367), null)};
                break;
            }
            case 1247: {
                promptReferenceArray = new PromptReference[]{SdPromptFactory.createPromptReference(-1595736064, this.getString(-1595736064), null)};
                break;
            }
            case 1287: {
                promptReferenceArray = new PromptReference[]{SdPromptFactory.createPromptReference(615907328, StringUtils.convertToString(this.getInteger(615907328)), null)};
                break;
            }
            case 1288: {
                promptReferenceArray = new PromptReference[]{SdPromptFactory.createPromptReference(615907328, StringUtils.convertToString(this.getInteger(615907328)), null)};
                break;
            }
            case 1297: {
                promptReferenceArray = new PromptReference[]{SdPromptFactory.createPromptReference(1729495296, StringUtils.convertToString(this.getInteger(1729495296)), null)};
                break;
            }
            case 1298: {
                promptReferenceArray = new PromptReference[]{SdPromptFactory.createPromptReference(18596, StringUtils.convertToString(this.getLong(18596)), this.getString(227868672))};
                break;
            }
            case 1299: {
                promptReferenceArray = new PromptReference[]{SdPromptFactory.createPromptReference(18596, StringUtils.convertToString(this.getLong(18596)), this.getString(227868672)), SdPromptFactory.createPromptReference(0x77E00000, ServiceManagerCommon.fixFormat.format(138, this.getInteger(-1668415488), this.getInteger(19182)), null)};
                break;
            }
            case 1300: {
                promptReferenceArray = new PromptReference[]{SdPromptFactory.createPromptReference(18596, StringUtils.convertToString(this.getLong(18596)), this.getString(227868672)), SdPromptFactory.createPromptReference(-1126236160, ServiceManagerCommon.fixFormat.format(139, this.getInteger(-1668415488), this.getInteger(19182)), null)};
                break;
            }
            case 1301: {
                promptReferenceArray = new PromptReference[]{SdPromptFactory.createPromptReference(18596, StringUtils.convertToString(this.getLong(18596)), this.getString(227868672)), SdPromptFactory.createPromptReference(1109000448, ServiceManagerCommon.fixFormat.format(71, this.getInteger(10705), this.getInteger(25840), this.getInteger(-1668415488)), null)};
                break;
            }
            case 1302: {
                promptReferenceArray = new PromptReference[]{SdPromptFactory.createPromptReference(18596, StringUtils.convertToString(this.getLong(18596)), this.getString(227868672)), SdPromptFactory.createPromptReference(807010560, ServiceManagerCommon.fixFormat.format(72, this.getInteger(10705), this.getInteger(25840), this.getInteger(-1668415488)), null)};
                break;
            }
            case 1303: {
                promptReferenceArray = new PromptReference[]{SdPromptFactory.createPromptReference(227868672, this.getString(227868672), null)};
                break;
            }
            case 1304: {
                promptReferenceArray = new PromptReference[]{SdPromptFactory.createPromptReference(227868672, this.getString(227868672), null), SdPromptFactory.createPromptReference(0x77E00000, ServiceManagerCommon.fixFormat.format(138, this.getInteger(-1668415488), this.getInteger(19182)), null)};
                break;
            }
            case 1305: {
                promptReferenceArray = new PromptReference[]{SdPromptFactory.createPromptReference(227868672, this.getString(227868672), null), SdPromptFactory.createPromptReference(-1126236160, ServiceManagerCommon.fixFormat.format(139, this.getInteger(-1668415488), this.getInteger(19182)), null)};
                break;
            }
            case 1306: {
                promptReferenceArray = new PromptReference[]{SdPromptFactory.createPromptReference(227868672, this.getString(227868672), null), SdPromptFactory.createPromptReference(1109000448, ServiceManagerCommon.fixFormat.format(71, this.getInteger(10705), this.getInteger(25840), this.getInteger(-1668415488)), null)};
                break;
            }
            case 1307: {
                promptReferenceArray = new PromptReference[]{SdPromptFactory.createPromptReference(227868672, this.getString(227868672), null), SdPromptFactory.createPromptReference(807010560, ServiceManagerCommon.fixFormat.format(72, this.getInteger(10705), this.getInteger(25840), this.getInteger(-1668415488)), null)};
                break;
            }
            case 1309: {
                promptReferenceArray = new PromptReference[]{SdPromptFactory.createPromptReference(-539295744, this.getString(-539295744), null)};
                break;
            }
            case 1310: {
                promptReferenceArray = new PromptReference[]{SdPromptFactory.createPromptReference(1729495296, StringUtils.convertToString(this.getInteger(1729495296)), null)};
                break;
            }
            case 1316: {
                promptReferenceArray = new PromptReference[]{SdPromptFactory.createPromptReference(-323878912, StringUtils.convertToString(this.getInteger(-323878912)), null)};
                break;
            }
            case 1319: {
                promptReferenceArray = new PromptReference[]{SdPromptFactory.createPromptReference(-539295744, this.getString(-539295744), null)};
                break;
            }
            case 1336: {
                promptReferenceArray = new PromptReference[]{SdPromptFactory.createPromptReference(1659437056, StringUtils.convertToString(this.getLicValue(-1935066368, 0, 0, 0L)), this.getLicValue(-1935066368, 2, 0, ""))};
                break;
            }
            case 1337: {
                promptReferenceArray = new PromptReference[]{SdPromptFactory.createPromptReference(1659437056, StringUtils.convertToString(this.getLicValue(-1935066368, 0, 0, 0L)), this.getLicValue(-1935066368, 2, 0, ""))};
                break;
            }
            case 1338: {
                promptReferenceArray = new PromptReference[]{SdPromptFactory.createPromptReference(1659437056, StringUtils.convertToString(this.getLicValue(-1935066368, 0, 0, 0L)), this.getLicValue(-1935066368, 2, 0, ""))};
                break;
            }
            case 1339: {
                promptReferenceArray = new PromptReference[]{SdPromptFactory.createPromptReference(1659437056, StringUtils.convertToString(this.getLicValue(-1935066368, 0, 0, 0L)), this.getLicValue(-1935066368, 2, 0, ""))};
                break;
            }
            case 1340: {
                promptReferenceArray = new PromptReference[]{SdPromptFactory.createPromptReference(1659437056, StringUtils.convertToString(this.getLicValue(-1935066368, 0, 0, 0L)), this.getLicValue(-1935066368, 2, 0, ""))};
                break;
            }
            case 1341: {
                promptReferenceArray = new PromptReference[]{SdPromptFactory.createPromptReference(1659437056, StringUtils.convertToString(this.getLicValue(-1935066368, 0, 0, 0L)), this.getLicValue(-1935066368, 2, 0, ""))};
                break;
            }
            case 1342: {
                promptReferenceArray = new PromptReference[]{SdPromptFactory.createPromptReference(1659437056, StringUtils.convertToString(this.getLicValue(-1935066368, 0, 0, 0L)), this.getLicValue(-1935066368, 2, 0, ""))};
                break;
            }
            case 1362: {
                promptReferenceArray = new PromptReference[]{SdPromptFactory.createPromptReference(-1055325952, StringUtils.convertToString(this.getLicValue(-635291136, 0, 0, 0L)), this.getLicValue(-635291136, 2, 0, ""))};
                break;
            }
            case 1364: {
                promptReferenceArray = new PromptReference[]{SdPromptFactory.createPromptReference(29668, this.getLicValue(-601736704, 2, 0, ""), null)};
                break;
            }
            case 1367: {
                promptReferenceArray = new PromptReference[]{SdPromptFactory.createPromptReference(19533, StringUtils.convertToString(this.getLicValue(-752731648, 5, 0, 0L)), this.getLicValue(-752731648, 7, 0, ""))};
                break;
            }
            case 1369: {
                promptReferenceArray = new PromptReference[]{SdPromptFactory.createPromptReference(10282, this.getLicValue(-719177216, 7, 0, ""), null)};
                break;
            }
            case 1377: {
                promptReferenceArray = new PromptReference[]{SdPromptFactory.createPromptReference(19214, StringUtils.convertToString(this.getInteger(19214)), null)};
                break;
            }
            case 1378: {
                promptReferenceArray = new PromptReference[]{SdPromptFactory.createPromptReference(19214, StringUtils.convertToString(this.getInteger(19214)), null)};
                break;
            }
            case 1409: {
                promptReferenceArray = new PromptReference[]{SdPromptFactory.createPromptReference(1904803840, this.getLicValue(-584959488, 0, 0, ""), null)};
                break;
            }
            case 1415: {
                promptReferenceArray = new PromptReference[]{SdPromptFactory.createPromptReference(1588002816, this.getLicValue(-568182272, 0, 0, ""), null)};
                break;
            }
            case 1418: {
                promptReferenceArray = new PromptReference[]{SdPromptFactory.createPromptReference(13742, StringUtils.convertToString(this.getLicValue(-601736704, 0, 0, 0L)), this.getLicValue(-601736704, 2, 0, ""))};
                break;
            }
            case 1421: {
                promptReferenceArray = new PromptReference[]{SdPromptFactory.createPromptReference(1980956928, StringUtils.convertToString(this.getLicValue(-719177216, 5, 0, 0L)), this.getLicValue(-719177216, 7, 0, ""))};
                break;
            }
            case 1439: {
                promptReferenceArray = new PromptReference[]{SdPromptFactory.createPromptReference(847904768, StringUtils.convertToString(this.getLong(847904768)), this.getString(1206976512))};
                break;
            }
            default: {
                promptReferenceArray = null;
            }
        }
        return ServiceManagerSdFeatureCollection.featureFactory.createPrompt(n, promptReferenceArray);
    }

    private static PromptReference createPromptReference(int n, String string, String string2) {
        return ServiceManagerSdFeatureCollection.featureFactory.createPromptReference(new StringBuffer().append("sdsid").append(n).toString(), string, string2);
    }
}

