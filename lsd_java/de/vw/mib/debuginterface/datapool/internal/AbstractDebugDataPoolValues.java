/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.debuginterface.datapool.internal;

import de.vw.mib.app.appadapter.CellValue;
import de.vw.mib.datapool.DynamicListItemControlManager;
import de.vw.mib.datapool.I18nDatapool;
import de.vw.mib.graphics.image.Image;
import de.vw.mib.properties.values.FixFormatterFieldData;
import de.vw.mib.properties.values.LabeledIconValue;
import de.vw.mib.skin.SkinImagePool;
import org.dsi.ifc.global.ResourceLocator;

public abstract class AbstractDebugDataPoolValues {
    private final SkinImagePool skinImagePool;
    private final I18nDatapool i18nDatapool;
    private final DynamicListItemControlManager dynamicListItemControlManager;
    private final CellValue cellValue = new CellValue();

    protected AbstractDebugDataPoolValues(SkinImagePool skinImagePool, I18nDatapool i18nDatapool, DynamicListItemControlManager dynamicListItemControlManager) {
        this.skinImagePool = skinImagePool;
        this.i18nDatapool = i18nDatapool;
        this.dynamicListItemControlManager = dynamicListItemControlManager;
    }

    public abstract String getValue(int n) {
    }

    protected String asString(int n) {
        return new StringBuffer().append("").append(n).toString();
    }

    protected String asString(boolean bl) {
        return new StringBuffer().append("").append(bl).toString();
    }

    protected String asString(long l) {
        return new StringBuffer().append("").append(l).toString();
    }

    protected String asString(float f2) {
        return new StringBuffer().append("").append(f2).toString();
    }

    protected String asString(double d2) {
        return new StringBuffer().append("").append(d2).toString();
    }

    protected String asString(Object object) {
        return new StringBuffer().append("").append(object).toString();
    }

    protected Image getImage(int n) {
        return this.skinImagePool.getImage(n);
    }

    protected Image[] getImageArray(int n) {
        return this.skinImagePool.getImageArray(n);
    }

    protected String getI18nString(int n) {
        return this.i18nDatapool.getString(n);
    }

    protected String[] getI18nStrings(int n) {
        return this.i18nDatapool.getStrings(n);
    }

    protected int getLicValue(int n, int n2, int n3, int n4) {
        return this.dynamicListItemControlManager.getCellValue(this.cellValue.withDefaultInt(n4), n, n2, n3).asInt();
    }

    protected int[] getLicValue(int n, int n2, int n3, int[] nArray) {
        return (int[])this.dynamicListItemControlManager.getCellValue(this.cellValue.withDefaultObject(nArray), n, n2, n3).asObject();
    }

    protected boolean getLicValue(int n, int n2, int n3, boolean bl) {
        return this.dynamicListItemControlManager.getCellValue(this.cellValue.withDefaultBoolean(bl), n, n2, n3).asBoolean();
    }

    protected boolean[] getLicValue(int n, int n2, int n3, boolean[] blArray) {
        return (boolean[])this.dynamicListItemControlManager.getCellValue(this.cellValue.withDefaultObject(blArray), n, n2, n3).asObject();
    }

    protected long getLicValue(int n, int n2, int n3, long l) {
        return this.dynamicListItemControlManager.getCellValue(this.cellValue.withDefaultLong(l), n, n2, n3).asLong();
    }

    protected String getLicValue(int n, int n2, int n3, String string) {
        return this.dynamicListItemControlManager.getCellValue(this.cellValue.withDefaultString(string), n, n2, n3).asString();
    }

    protected String[] getLicValue(int n, int n2, int n3, String[] stringArray) {
        return (String[])this.dynamicListItemControlManager.getCellValue(this.cellValue.withDefaultObject(stringArray), n, n2, n3).asObject();
    }

    protected FixFormatterFieldData getLicValue(int n, int n2, int n3, FixFormatterFieldData fixFormatterFieldData) {
        return (FixFormatterFieldData)this.dynamicListItemControlManager.getCellValue(this.cellValue.withDefaultObject(fixFormatterFieldData), n, n2, n3).asObject();
    }

    protected LabeledIconValue getLicValue(int n, int n2, int n3, LabeledIconValue labeledIconValue) {
        return (LabeledIconValue)this.dynamicListItemControlManager.getCellValue(this.cellValue.withDefaultObject(labeledIconValue), n, n2, n3).asObject();
    }

    protected ResourceLocator getLicValue(int n, int n2, int n3, ResourceLocator resourceLocator) {
        return (ResourceLocator)this.dynamicListItemControlManager.getCellValue(this.cellValue.withDefaultObject(resourceLocator), n, n2, n3).asObject();
    }
}

