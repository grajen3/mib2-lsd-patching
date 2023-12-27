/*
 * Decompiled with CFR 0.152.
 */
package generated.de.vw.mib.global.datapool.internal;

import de.vw.mib.datapool.FormatterService;
import de.vw.mib.datapool.GlobalExpressionEvaluator;
import generated.de.vw.mib.global.datapool.DataConstants;
import generated.de.vw.mib.global.datapool.SkinDataPool;
import generated.de.vw.mib.global.sm.internal.activity.StatemachineHandlerBase;

public final class GlobalExpressionEvaluatorImpl
extends StatemachineHandlerBase
implements GlobalExpressionEvaluator {
    @Override
    public boolean evalBoolean(int n) {
        switch (n) {
            case 1: {
                return this.evalBoolean(54);
            }
            case 2: {
                return this.evalBoolean(67);
            }
            case 3: {
                return this.getInteger(2088828928) == 3 || this.getInteger(2088828928) == 2 || this.getInteger(2088828928) == 7 || this.getInteger(2088828928) == 5 || this.getInteger(1409810688) == 1 && this.getInteger(27172) == 10;
            }
            case 4: {
                return this.getInteger(891683072) == 0;
            }
            case 5: {
                return this.getInteger(891683072) == 3;
            }
            case 6: {
                return this.getInteger(891683072) == 2;
            }
            case 7: {
                return this.getInteger(27192) != 3 && (this.getInteger(-561905664) != 1 || !this.getBoolean(-1028980736));
            }
            case 8: {
                return this.getInteger(15599) == 1 && this.getLicValue(1571248128, 3, 0, false);
            }
            case 9: {
                return this.evalBoolean(25);
            }
            case 10: {
                return this.getInteger(0xE8E0000) == 1 && this.getLicValue(-2131750912, 3, 0, false) && (!this.getBoolean(495058944) || !this.evalBoolean(25));
            }
            case 11: {
                return false;
            }
            case 12: {
                return true;
            }
            case 13: {
                return true;
            }
            case 14: {
                return !this.getBoolean(17865);
            }
            case 15: {
                return false;
            }
            case 16: {
                return false;
            }
            case 17: {
                return !this.getBoolean(-223281152);
            }
            case 18: {
                return !this.getBoolean(530382848);
            }
            case 19: {
                return this.getLicValue(-1306503424, 3, this.getInteger(31753), 0) == 2 || this.getLicValue(-1306503424, 3, this.getInteger(31753), 0) == 3;
            }
            case 20: {
                return this.getInteger(0x820000) == 6 || this.getInteger(0x820000) == 13 || this.getInteger(0x820000) == 23 || this.getInteger(0x820000) == 18 || this.getInteger(0x820000) == 22 || this.getInteger(0x820000) == 26 && this.getInteger(18985) == 6;
            }
            case 21: {
                return this.getInteger(18985) == 2;
            }
            case 22: {
                return this.getInteger(27122) == 1;
            }
            case 23: {
                return this.getInteger(-1260191744) == 7 || this.getInteger(-1260191744) == 8 || this.getInteger(-1260191744) == 9 || this.getInteger(-1260191744) == 10 || this.getInteger(-1260191744) == 11 || this.getInteger(-1260191744) == 12 || this.getInteger(-1260191744) == 14;
            }
            case 24: {
                return this.getInteger(30050) == 0 && this.getInteger(388038912) == 1 && this.getBoolean(20665) || this.getInteger(30050) == 0 && this.getInteger(388038912) != 1 && this.getBoolean(1974468608) || this.getInteger(30050) == 1 && this.getBoolean(-1430192128) || this.getInteger(30050) == 0 && this.getBoolean(1692073984) && !this.getBoolean(17562);
            }
            case 25: {
                return this.evalBoolean(24) || this.getInteger(30050) == 0 && this.getBoolean(1692073984) && !this.getBoolean(17562);
            }
            case 26: {
                return this.evalBoolean(31) && this.evalBoolean(33) && !this.evalBoolean(32);
            }
            case 27: {
                return this.evalBoolean(31) && this.evalBoolean(33) && this.evalBoolean(32);
            }
            case 28: {
                return false;
            }
            case 29: {
                return this.evalBoolean(33) && !this.evalBoolean(31) && this.evalBoolean(32);
            }
            case 30: {
                return false;
            }
            case 31: {
                return this.evalBoolean(35);
            }
            case 32: {
                return this.evalBoolean(38);
            }
            case 33: {
                return this.evalBoolean(39) || this.evalBoolean(41);
            }
            case 34: {
                return false;
            }
            case 35: {
                return this.getBoolean(0x7A00000) && this.getBoolean(10059) && this.getBoolean(-1358495488);
            }
            case 36: {
                return false;
            }
            case 37: {
                return this.getBoolean(0x7A00000) && this.getBoolean(10059);
            }
            case 38: {
                return this.getBoolean(0x7A00000) && this.getBoolean(10059) && this.getBoolean(12357);
            }
            case 39: {
                return this.getBoolean(0x7A00000) && this.getBoolean(10059);
            }
            case 40: {
                return false;
            }
            case 41: {
                return this.getBoolean(0x7A00000) && this.getBoolean(10059);
            }
            case 42: {
                return this.getBoolean(0x7A00000) && this.getBoolean(10059);
            }
            case 43: {
                return false;
            }
            case 44: {
                return !this.evalBoolean(50);
            }
            case 45: {
                return false;
            }
            case 46: {
                return this.getInteger(0xA50000) == 1 && this.evalBoolean(38);
            }
            case 47: {
                return this.getInteger(0xA50000) == 0 && this.evalBoolean(41);
            }
            case 48: {
                return this.getInteger(0xA50000) == 1 && this.evalBoolean(38) || this.getInteger(0xA50000) == 0 && this.evalBoolean(41);
            }
            case 49: {
                return true;
            }
            case 50: {
                return !this.evalBoolean(35) && !this.evalBoolean(38);
            }
            case 51: {
                return this.evalBoolean(52) || this.evalBoolean(53);
            }
            case 52: {
                return this.evalBoolean(35) || this.evalBoolean(39);
            }
            case 53: {
                return this.evalBoolean(38) || this.evalBoolean(41);
            }
            case 54: {
                return this.evalBoolean(62) || this.evalBoolean(63) || this.evalBoolean(64) || this.evalBoolean(65);
            }
            case 55: {
                return this.evalBoolean(60) || this.evalBoolean(65) || this.evalBoolean(61);
            }
            case 56: {
                return this.evalBoolean(58);
            }
            case 57: {
                return true;
            }
            case 58: {
                return this.evalBoolean(54);
            }
            case 59: {
                return this.getLicValue(2353, 0, this.getInteger(-863240192), "").equalsIgnoreCase(DataConstants.LANG_SYSTEM_SETUP_MAIN_LANGUAGE_LIST_ISO[16]);
            }
            case 60: {
                return this.getLicValue(2353, 0, this.getInteger(-863240192), "").equalsIgnoreCase(DataConstants.LANG_SYSTEM_SETUP_MAIN_LANGUAGE_LIST_ISO[26]);
            }
            case 61: {
                return this.getLicValue(2353, 0, this.getInteger(-863240192), "").equalsIgnoreCase(DataConstants.LANG_SYSTEM_SETUP_MAIN_LANGUAGE_LIST_ISO[27]);
            }
            case 62: {
                return this.getLicValue(2353, 0, this.getInteger(-863240192), "").equalsIgnoreCase(DataConstants.LANG_SYSTEM_SETUP_MAIN_LANGUAGE_LIST_ISO[22]);
            }
            case 63: {
                return this.getLicValue(2353, 0, this.getInteger(-863240192), "").equalsIgnoreCase(DataConstants.LANG_SYSTEM_SETUP_MAIN_LANGUAGE_LIST_ISO[23]);
            }
            case 64: {
                return this.getLicValue(2353, 0, this.getInteger(-863240192), "").equalsIgnoreCase(DataConstants.LANG_SYSTEM_SETUP_MAIN_LANGUAGE_LIST_ISO[24]);
            }
            case 65: {
                return this.getLicValue(2353, 0, this.getInteger(-863240192), "").equalsIgnoreCase(DataConstants.LANG_SYSTEM_SETUP_MAIN_LANGUAGE_LIST_ISO[25]);
            }
            case 66: {
                return this.evalBoolean(60);
            }
            case 67: {
                return this.evalBoolean(59) || this.evalBoolean(62) || this.evalBoolean(63) || this.evalBoolean(64) || this.evalBoolean(65) || this.evalBoolean(60) || this.evalBoolean(61);
            }
            case 68: {
                return this.evalBoolean(59);
            }
            case 69: {
                return this.getListItemControl(2353, true).getItemCount() > 0 && (this.getLicValue(2353, 0, this.getInteger(-863240192), "").equalsIgnoreCase(DataConstants.LANG_SYSTEM_SETUP_MAIN_LANGUAGE_LIST_ISO[22]) || this.getLicValue(2353, 0, this.getInteger(-863240192), "").equalsIgnoreCase(DataConstants.LANG_SYSTEM_SETUP_MAIN_LANGUAGE_LIST_ISO[23]) || this.getLicValue(2353, 0, this.getInteger(-863240192), "").equalsIgnoreCase(DataConstants.LANG_SYSTEM_SETUP_MAIN_LANGUAGE_LIST_ISO[24]) || this.getLicValue(2353, 0, this.getInteger(-863240192), "").equalsIgnoreCase(DataConstants.LANG_SYSTEM_SETUP_MAIN_LANGUAGE_LIST_ISO[25]));
            }
            case 70: {
                return this.getInteger(18985) == 6 && this.getInteger(22132) != 0;
            }
            case 71: {
                return this.getLicValue(58, 0, 0, "").equals("") && this.getLicValue(58, 1, 0, "").equals("") && this.evalBoolean(72) && this.getInteger(2088828928) == 0 || this.getInteger(1409810688) == 6 && !this.getBoolean(-103677952) && this.getInteger(-183303936) != 0;
            }
            case 72: {
                return (this.getInteger(1409810688) == 1 || this.getInteger(1409810688) == 4) && this.getInteger(417333248) == 1;
            }
            case 73: {
                return !(this.getInteger(1409810688) != 1 && this.getInteger(1409810688) != 4 || this.getInteger(417333248) != 3 && this.getInteger(417333248) != 4);
            }
            case 74: {
                return this.getInteger(20949) != SkinDataPool.getInteger(19);
            }
        }
        throw GlobalExpressionEvaluatorImpl.illegalExpressionId(n);
    }

    @Override
    public short evalShort(int n) {
        switch (n) {
            default: 
        }
        throw GlobalExpressionEvaluatorImpl.illegalExpressionId(n);
    }

    @Override
    public int evalInt(int n) {
        switch (n) {
            case 1: {
                return this.evalBoolean(66) ? SkinDataPool.getInteger(5) : SkinDataPool.getInteger(0);
            }
            case 2: {
                return this.evalBoolean(66) ? SkinDataPool.getInteger(9) : SkinDataPool.getInteger(8);
            }
            case 3: {
                return this.evalBoolean(67) ? (!this.evalBoolean(56) && this.evalBoolean(55) ? SkinDataPool.getInteger(7) : (this.evalBoolean(56) && this.evalBoolean(55) ? 9 : (this.evalBoolean(56) && !this.evalBoolean(55) ? 8 : SkinDataPool.getInteger(6)))) : SkinDataPool.getInteger(6);
            }
            case 4: {
                return this.evalBoolean(66) ? SkinDataPool.getInteger(3) : SkinDataPool.getInteger(1);
            }
            case 5: {
                return this.evalBoolean(66) ? SkinDataPool.getInteger(4) : SkinDataPool.getInteger(2);
            }
            case 6: {
                return this.evalBoolean(67) ? (this.evalBoolean(60) ? 2 : (this.evalBoolean(61) ? 3 : (this.evalBoolean(62) || this.evalBoolean(63) || this.evalBoolean(64) || this.evalBoolean(65) ? 1 : 0))) : 0;
            }
            case 7: {
                return this.evalBoolean(58) ? 8 : 1;
            }
            case 8: {
                return !this.getBoolean(13705) ? 0 : 1;
            }
            case 9: {
                return this.getInteger(2088828928) == 3 || this.getInteger(2088828928) == 7 || this.getInteger(2088828928) == 2 || this.getInteger(2088828928) == 5 || this.getInteger(2088828928) == 6 || this.getInteger(2088828928) == 1 || this.getInteger(2088828928) == 4 || this.getInteger(1409810688) == 1 && this.getInteger(27172) == 10 || this.getInteger(1409810688) == 5 && (this.getInteger(616169472) == 6 || this.getInteger(616169472) == 5) || this.getInteger(1409810688) == 6 && (this.getInteger(-183303936) == 0 || !this.getBoolean(-103677952)) ? (this.getInteger(2088828928) == 4 || this.getInteger(2088828928) == 1 || this.getInteger(2088828928) == 6 ? 6 : (this.getInteger(1409810688) == 5 && this.getInteger(616169472) == 5 ? 10 : (this.getInteger(1409810688) == 5 && this.getInteger(616169472) == 6 ? 9 : (this.getInteger(1409810688) == 1 && this.getInteger(27172) == 10 ? 8 : (this.getInteger(1409810688) == 6 && this.getInteger(14570) == 1 && !this.getBoolean(-103677952) && this.getInteger(-183303936) != 0 ? 11 : (this.getInteger(1409810688) == 11 && this.getInteger(2088828928) == 5 || this.getInteger(1409810688) == 6 && (this.getInteger(14570) != 1 || this.getInteger(-183303936) == 0 || this.getInteger(2088828928) == 5) ? 4 : (this.getInteger(2088828928) == 5 && this.getInteger(1409810688) != 6 && this.getInteger(1409810688) != 11 ? 3 : (this.getInteger(2088828928) == 2 ? 2 : (this.getInteger(2088828928) == 7 ? 5 : (this.getInteger(2088828928) == 3 ? 1 : 0)))))))))) : (this.getInteger(1409810688) == 0 ? 7 : 0);
            }
            case 10: {
                return this.getInteger(27950) < this.getListItemControl(1096551424, true).getItemCount() ? (this.getInteger(27950) == 10 ? 9 : (this.getInteger(27950) == 9 ? 8 : (this.getInteger(27950) == 8 ? 7 : (this.getInteger(27950) == 7 ? 6 : (this.getInteger(27950) == 6 ? 5 : (this.getInteger(27950) == 5 ? 4 : (this.getInteger(27950) == 4 ? 3 : (this.getInteger(27950) == 3 ? 2 : (this.getInteger(27950) == 2 ? 1 : 0))))))))) : 0;
            }
            case 11: {
                return this.getBoolean(13543) ? 0 : 1;
            }
            case 12: {
                return this.getBoolean(22334) ? 528 : 529;
            }
            case 13: {
                return this.getBoolean(22334) ? 528 : 530;
            }
        }
        throw GlobalExpressionEvaluatorImpl.illegalExpressionId(n);
    }

    @Override
    public long evalLong(int n) {
        switch (n) {
            default: 
        }
        throw GlobalExpressionEvaluatorImpl.illegalExpressionId(n);
    }

    @Override
    public float evalFloat(int n) {
        switch (n) {
            default: 
        }
        throw GlobalExpressionEvaluatorImpl.illegalExpressionId(n);
    }

    @Override
    public double evalDouble(int n) {
        switch (n) {
            default: 
        }
        throw GlobalExpressionEvaluatorImpl.illegalExpressionId(n);
    }

    @Override
    public String evalString(int n) {
        switch (n) {
            case 1: {
                return this.getInteger(513802240) == 2 ? this.getI18nString(235) : (this.getInteger(513802240) == 1 ? this.getI18nString(238) : (this.getInteger(513802240) == 0 ? this.getI18nString(236) : ""));
            }
            case 2: {
                return this.getInteger(513802240) == 2 ? this.getI18nString(240) : (this.getInteger(513802240) == 1 ? this.getI18nString(243) : (this.getInteger(513802240) == 0 ? this.getI18nString(241) : ""));
            }
            case 3: {
                return this.getI18nString(250);
            }
            case 4: {
                return this.getI18nString(298);
            }
            case 5: {
                return this.getBoolean(-376438784) || this.getBoolean(24958) ? (this.getInteger(20949) == SkinDataPool.getInteger(10) ? this.getI18nString(1384) : (this.getInteger(20949) == SkinDataPool.getInteger(23) ? this.getI18nString(1395) : (this.getInteger(20949) == SkinDataPool.getInteger(22) ? this.getI18nString(1394) : (this.getInteger(20949) == SkinDataPool.getInteger(21) ? this.getI18nString(1393) : (this.getInteger(20949) == SkinDataPool.getInteger(20) ? this.getI18nString(1392) : (this.getInteger(20949) == SkinDataPool.getInteger(18) ? this.getI18nString(1396) : (this.getInteger(20949) == SkinDataPool.getInteger(17) ? this.getI18nString(1391) : (this.getInteger(20949) == SkinDataPool.getInteger(16) ? this.getI18nString(1390) : (this.getInteger(20949) == SkinDataPool.getInteger(15) ? this.getI18nString(1389) : (this.getInteger(20949) == SkinDataPool.getInteger(14) ? this.getI18nString(1388) : (this.getInteger(20949) == SkinDataPool.getInteger(13) ? this.getI18nString(1387) : (this.getInteger(20949) == SkinDataPool.getInteger(12) ? this.getI18nString(1386) : (this.getInteger(20949) == SkinDataPool.getInteger(11) ? this.getI18nString(1385) : ""))))))))))))) : "";
            }
            case 6: {
                return this.getInteger(2088828928) == 3 || this.getInteger(2088828928) == 7 || this.getInteger(2088828928) == 2 || this.getInteger(2088828928) == 5 || this.getInteger(1409810688) == 1 && this.getInteger(27172) == 10 ? (this.getInteger(1409810688) == 1 && this.getInteger(27172) == 10 ? this.getI18nString(2647) : (this.getInteger(2088828928) == 5 && (this.getInteger(1409810688) == 6 || this.getInteger(1409810688) == 11) ? this.getI18nString(2651) : (this.getInteger(2088828928) == 5 && this.getInteger(1409810688) != 6 && this.getInteger(1409810688) != 11 ? this.getI18nString(2650) : (this.getInteger(2088828928) == 2 ? this.getI18nString(2649) : (this.getInteger(2088828928) == 7 ? this.getI18nString(2652) : (this.getInteger(2088828928) == 3 ? this.getI18nString(2648) : "")))))) : "";
            }
            case 7: {
                return this.getInteger(1409810688) != 0 ? (this.evalBoolean(72) && this.getLicValue(58, 5, 0, "").equals("") && this.getLicValue(58, 7, 0, 0) == 0 ? "" : (this.getInteger(1409810688) == 6 && !this.getBoolean(-103677952) ? this.getString(-455213056) : (this.evalBoolean(72) && this.getLicValue(58, 5, 0, "").equals("") && this.getLicValue(58, 7, 0, 0) > 0 ? FormatterService.format(this.getI18nString(2117), Integer.toString(this.getLicValue(58, 7, 0, 0))) : (this.evalBoolean(73) ? FormatterService.format((CharSequence)this.getI18nString(6608), Integer.toString(this.getInteger(889848064)), Integer.toString(this.getInteger(-493420544))) : this.getLicValue(58, 5, 0, ""))))) : "";
            }
        }
        throw GlobalExpressionEvaluatorImpl.illegalExpressionId(n);
    }

    @Override
    public Object evalObject(int n) {
        switch (n) {
            case 1: {
                return this.evalBoolean(67) ? (this.evalBoolean(68) ? DataConstants.ALPHABET_ALPHANUMERIC_UNIASIA_ALPHABET_MAPPING_NO_CONVERSION : (this.evalBoolean(61) ? DataConstants.ALPHABET_ALPHANUMERIC_UNIASIA_ALPHABET_MAPPING_KO_KR : (this.evalBoolean(60) ? DataConstants.ALPHABET_ALPHANUMERIC_UNIASIA_ALPHABET_MAPPING_JA_JP : (this.evalBoolean(65) ? DataConstants.ALPHABET_ALPHANUMERIC_UNIASIA_ALPHABET_MAPPING_ZH_TW : (this.evalBoolean(64) || this.evalBoolean(63) || this.evalBoolean(62) ? DataConstants.ALPHABET_ALPHANUMERIC_UNIASIA_ALPHABET_MAPPING_ZH_CN : DataConstants.ALPHABET_ALPHANUMERIC_UNIASIA_ALPHABET_MAPPING_NO_CONVERSION))))) : DataConstants.ALPHABET_ALPHANUMERIC_UNIASIA_ALPHABET_MAPPING_NO_CONVERSION;
            }
        }
        throw GlobalExpressionEvaluatorImpl.illegalExpressionId(n);
    }

    private static IllegalArgumentException illegalExpressionId(int n) {
        return new IllegalArgumentException(new StringBuffer().append("Unknown expression with ID ").append(n).toString());
    }
}

