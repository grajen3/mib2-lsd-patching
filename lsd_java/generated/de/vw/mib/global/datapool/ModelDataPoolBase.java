/*
 * Decompiled with CFR 0.152.
 */
package generated.de.vw.mib.global.datapool;

import de.vw.mib.app.appadapter.CellValue;
import de.vw.mib.datapool.ExtendedListItemControl;
import de.vw.mib.hmi.internal.ServiceManagerCommon;
import de.vw.mib.properties.values.FixFormatterFieldData;
import de.vw.mib.properties.values.SpellerData;
import org.dsi.ifc.global.ResourceLocator;

public abstract class ModelDataPoolBase {
    private final CellValue cellValue = new CellValue();

    protected boolean getBoolean(int n) {
        return ServiceManagerCommon.modelDatapool.getBoolean(n);
    }

    protected void setBoolean(int n, boolean bl) {
        ServiceManagerCommon.modelDatapool.setBoolean(n, bl);
    }

    protected FixFormatterFieldData getFixFormatterFieldData(int n) {
        return ServiceManagerCommon.modelDatapool.getFixFormatterFieldData(n);
    }

    protected void setFixFormatterFieldData(int n, FixFormatterFieldData fixFormatterFieldData) {
        ServiceManagerCommon.modelDatapool.setFixFormatterFieldData(n, fixFormatterFieldData);
    }

    protected boolean[] getFlagVector(int n) {
        return ServiceManagerCommon.modelDatapool.getFlagVector(n);
    }

    protected void setFlagVector(int n, boolean[] blArray) {
        ServiceManagerCommon.modelDatapool.setFlagVector(n, blArray);
    }

    protected float getFloat(int n) {
        return ServiceManagerCommon.modelDatapool.getFloat(n);
    }

    protected void setFloat(int n, float f2) {
        ServiceManagerCommon.modelDatapool.setFloat(n, f2);
    }

    protected int getInteger(int n) {
        return ServiceManagerCommon.modelDatapool.getInteger(n);
    }

    protected void setInteger(int n, int n2) {
        ServiceManagerCommon.modelDatapool.setInteger(n, n2);
    }

    protected int[] getIntegerVector(int n) {
        return ServiceManagerCommon.modelDatapool.getIntegerVector(n);
    }

    protected void setIntegerVector(int n, int[] nArray) {
        ServiceManagerCommon.modelDatapool.setIntegerVector(n, nArray);
    }

    protected long getLong(int n) {
        return ServiceManagerCommon.modelDatapool.getLong(n);
    }

    protected void setLong(int n, long l) {
        ServiceManagerCommon.modelDatapool.setLong(n, l);
    }

    protected ResourceLocator getResourceLocator(int n) {
        return ServiceManagerCommon.modelDatapool.getResourceLocator(n);
    }

    protected void setResourceLocator(int n, ResourceLocator resourceLocator) {
        ServiceManagerCommon.modelDatapool.setResourceLocator(n, resourceLocator);
    }

    protected SpellerData getSpellerData(int n) {
        return ServiceManagerCommon.modelDatapool.getSpellerData(n);
    }

    protected void setSpellerData(int n, SpellerData spellerData) {
        ServiceManagerCommon.modelDatapool.setSpellerData(n, spellerData);
    }

    protected String getString(int n) {
        return ServiceManagerCommon.modelDatapool.getString(n);
    }

    protected void setString(int n, String string) {
        ServiceManagerCommon.modelDatapool.setString(n, string);
    }

    protected String[] getStringVector(int n) {
        return ServiceManagerCommon.modelDatapool.getStringVector(n);
    }

    protected void setStringVector(int n, String[] stringArray) {
        ServiceManagerCommon.modelDatapool.setStringVector(n, stringArray);
    }

    protected String getI18nString(int n) {
        return ServiceManagerCommon.i18nDatapool.getString(n);
    }

    protected String[] getI18nStrings(int n) {
        return ServiceManagerCommon.i18nDatapool.getStrings(n);
    }

    protected int getLicValue(int n, int n2, int n3, int n4) {
        return ServiceManagerCommon.dynamicListItemControlManager.getCellValue(this.cellValue.withDefaultInt(n4), n, n3, n2).asInt();
    }

    protected boolean getLicValue(int n, int n2, int n3, boolean bl) {
        return ServiceManagerCommon.dynamicListItemControlManager.getCellValue(this.cellValue.withDefaultBoolean(bl), n, n3, n2).asBoolean();
    }

    protected long getLicValue(int n, int n2, int n3, long l) {
        return ServiceManagerCommon.dynamicListItemControlManager.getCellValue(this.cellValue.withDefaultLong(l), n, n3, n2).asLong();
    }

    protected String getLicValue(int n, int n2, int n3, String string) {
        return ServiceManagerCommon.dynamicListItemControlManager.getCellValue(this.cellValue.withDefaultString(string), n, n3, n2).asString();
    }

    protected ExtendedListItemControl getListItemControl(int n, boolean bl) {
        return ServiceManagerCommon.dynamicListItemControlManager.getListItemControl(n);
    }
}

