/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.view.internal;

import de.vw.mib.datapool.ModelDatapoolObserver;
import de.vw.mib.format.FixFormat;
import de.vw.mib.list.DynamicListDataRowItemTransformer;
import de.vw.mib.list.DynamicListManager;
import de.vw.mib.log4mib.LogMessage;
import de.vw.mib.properties.values.FixFormatterFieldData;
import de.vw.mib.properties.values.LabeledIconValue;
import de.vw.mib.view.internal.AbstractOnExternalListChangedListener;
import de.vw.mib.view.internal.AbstractViewHandler;
import de.vw.mib.view.internal.CloneData;
import de.vw.mib.view.internal.OnAppAdapterListChangedListener;
import de.vw.mib.view.internal.OnAslListChangedListener;
import de.vw.mib.widgets.AbstractTemplateList;
import org.dsi.ifc.global.ResourceLocator;

public abstract class AbstractWithServicesViewHandler
extends AbstractViewHandler {
    static final /* synthetic */ boolean $assertionsDisabled;
    static /* synthetic */ Class class$de$vw$mib$view$internal$AbstractWithServicesViewHandler;

    protected static CloneData cdOf(CloneData cloneData, CloneData cloneData2) {
        if (cloneData == CD0) {
            return cloneData2;
        }
        if (cloneData.master == cloneData2) {
            return cloneData;
        }
        String string = cloneData.widgets[0].get_name();
        String string2 = cloneData2.widgets[0].get_name();
        int n = cloneData.masterId;
        int n2 = cloneData2.masterId;
        String string3 = cloneData.master.toString();
        String string4 = cloneData2.master.toString();
        String string5 = new StringBuffer().append("`").append(string).append("\u00b4 [masterId=").append(n).append(", master=").append(string3).append("]").toString();
        String string6 = new StringBuffer().append("`").append(string2).append("\u00b4 [masterId=").append(n2).append(", master=").append(string4).append("]").toString();
        throw new RuntimeException(new StringBuffer().append("List item border crossing: Illegal access from clone of ").append(string5).append(" to clone of ").append(string6).append(".").toString());
    }

    protected final void deinitCloneWidgetAndDestroyClones(CloneData cloneData) {
        this.deinitCloneData(cloneData);
        this.destroyClones(cloneData);
    }

    private void destroyClones(CloneData cloneData) {
        while (cloneData.next != null) {
            this.deinitCloneData(cloneData.next);
            this.services.getWidgetTreeBuilder().destroyWidgetTree(this.getInternalViewId(), cloneData.next, this.uiTypes);
        }
        if (!$assertionsDisabled && cloneData.next != null) {
            throw new AssertionError();
        }
    }

    protected final FixFormat getFixFormat() {
        return this.services.getFixFormat();
    }

    protected final boolean getLicValue(Object object, DynamicListDataRowItemTransformer dynamicListDataRowItemTransformer, int n, boolean bl) {
        if (object != DynamicListManager.NOT_LOADED_ENTRY) {
            try {
                return dynamicListDataRowItemTransformer.getBoolean(n, object);
            }
            catch (IllegalArgumentException illegalArgumentException) {
                this.logMissingColumn(dynamicListDataRowItemTransformer, n);
            }
        }
        return bl;
    }

    protected final boolean[] getLicValue(Object object, DynamicListDataRowItemTransformer dynamicListDataRowItemTransformer, int n, boolean[] blArray) {
        if (object != DynamicListManager.NOT_LOADED_ENTRY) {
            try {
                return dynamicListDataRowItemTransformer.getFlagVector(n, object);
            }
            catch (IllegalArgumentException illegalArgumentException) {
                this.logMissingColumn(dynamicListDataRowItemTransformer, n);
            }
        }
        return blArray;
    }

    protected final int getLicValue(Object object, DynamicListDataRowItemTransformer dynamicListDataRowItemTransformer, int n, int n2) {
        if (object != DynamicListManager.NOT_LOADED_ENTRY) {
            try {
                return dynamicListDataRowItemTransformer.getInt(n, object);
            }
            catch (IllegalArgumentException illegalArgumentException) {
                this.logMissingColumn(dynamicListDataRowItemTransformer, n);
            }
        }
        return n2;
    }

    protected final int[] getLicValue(Object object, DynamicListDataRowItemTransformer dynamicListDataRowItemTransformer, int n, int[] nArray) {
        if (object != DynamicListManager.NOT_LOADED_ENTRY) {
            try {
                return dynamicListDataRowItemTransformer.getIntegerVector(n, object);
            }
            catch (IllegalArgumentException illegalArgumentException) {
                this.logMissingColumn(dynamicListDataRowItemTransformer, n);
            }
        }
        return nArray;
    }

    protected final long getLicValue(Object object, DynamicListDataRowItemTransformer dynamicListDataRowItemTransformer, int n, long l) {
        if (object != DynamicListManager.NOT_LOADED_ENTRY) {
            try {
                return dynamicListDataRowItemTransformer.getLong(n, object);
            }
            catch (IllegalArgumentException illegalArgumentException) {
                this.logMissingColumn(dynamicListDataRowItemTransformer, n);
            }
        }
        return l;
    }

    protected final String getLicValue(Object object, DynamicListDataRowItemTransformer dynamicListDataRowItemTransformer, int n, String string) {
        if (object != DynamicListManager.NOT_LOADED_ENTRY) {
            try {
                return dynamicListDataRowItemTransformer.getString(n, object);
            }
            catch (IllegalArgumentException illegalArgumentException) {
                this.logMissingColumn(dynamicListDataRowItemTransformer, n);
            }
        }
        return string;
    }

    protected final String[] getLicValue(Object object, DynamicListDataRowItemTransformer dynamicListDataRowItemTransformer, int n, String[] stringArray) {
        if (object != DynamicListManager.NOT_LOADED_ENTRY) {
            try {
                return dynamicListDataRowItemTransformer.getStringVector(n, object);
            }
            catch (IllegalArgumentException illegalArgumentException) {
                this.logMissingColumn(dynamicListDataRowItemTransformer, n);
            }
        }
        return stringArray;
    }

    protected final LabeledIconValue getLicValue(Object object, DynamicListDataRowItemTransformer dynamicListDataRowItemTransformer, int n, LabeledIconValue labeledIconValue) {
        if (object != DynamicListManager.NOT_LOADED_ENTRY) {
            try {
                return dynamicListDataRowItemTransformer.getLabeledIconValue(n, object);
            }
            catch (IllegalArgumentException illegalArgumentException) {
                this.logMissingColumn(dynamicListDataRowItemTransformer, n);
            }
        }
        return labeledIconValue;
    }

    protected final FixFormatterFieldData getLicValue(Object object, DynamicListDataRowItemTransformer dynamicListDataRowItemTransformer, int n, FixFormatterFieldData fixFormatterFieldData) {
        if (object != DynamicListManager.NOT_LOADED_ENTRY) {
            try {
                return dynamicListDataRowItemTransformer.getFixFormatterFieldData(n, object);
            }
            catch (IllegalArgumentException illegalArgumentException) {
                this.logMissingColumn(dynamicListDataRowItemTransformer, n);
            }
        }
        return fixFormatterFieldData;
    }

    protected final ResourceLocator getLicValue(Object object, DynamicListDataRowItemTransformer dynamicListDataRowItemTransformer, int n, ResourceLocator resourceLocator) {
        if (object != DynamicListManager.NOT_LOADED_ENTRY) {
            try {
                return dynamicListDataRowItemTransformer.getResourceLocator(n, object);
            }
            catch (IllegalArgumentException illegalArgumentException) {
                this.logMissingColumn(dynamicListDataRowItemTransformer, n);
            }
        }
        return resourceLocator;
    }

    private void logMissingColumn(DynamicListDataRowItemTransformer dynamicListDataRowItemTransformer, int n) {
        LogMessage logMessage = this.logger.warn(32);
        logMessage.append("The column with id '").append(n);
        logMessage.append("' is not supported/implemented by transformer ").append(super.getClass().getName());
        logMessage.log();
    }

    protected final AbstractOnExternalListChangedListener newOnAslListChangedListener(int n) {
        return new OnAslListChangedListener(this, n);
    }

    protected final AbstractOnExternalListChangedListener newOnAppAdapterListChangedListener(int n) {
        return new OnAppAdapterListChangedListener(this, n);
    }

    protected void attachListControl(AbstractTemplateList abstractTemplateList, boolean bl) {
        this.services.getListControlCache().attachListControl(abstractTemplateList, bl);
    }

    protected void registerObserver(int n, ModelDatapoolObserver modelDatapoolObserver, boolean bl) {
        this.services.getModelDatapool().registerObserver(n, modelDatapoolObserver, bl);
    }

    protected void registerObserver(int n, ModelDatapoolObserver modelDatapoolObserver) {
        this.services.getModelDatapool().registerObserver(n, modelDatapoolObserver);
    }

    protected void unregisterObserver(int n, ModelDatapoolObserver modelDatapoolObserver) {
        this.services.getModelDatapool().unregisterObserver(n, modelDatapoolObserver);
    }

    @Override
    public void setAnimBooleanValue(int n, int n2, boolean bl) {
        this.animationAdapters.setAnimBooleanValue(n, n2, bl);
    }

    @Override
    public boolean getAnimBooleanValue(int n, int n2) {
        return this.animationAdapters.getAnimBooleanValue(n, n2);
    }

    @Override
    public void setAnimIntValue(int n, int n2, int n3) {
        this.animationAdapters.setAnimIntValue(n, n2, n3);
    }

    @Override
    public int getAnimIntValue(int n, int n2) {
        return this.animationAdapters.getAnimIntValue(n, n2);
    }

    @Override
    public void setAnimFloatValue(int n, int n2, float f2) {
        this.animationAdapters.setAnimFloatValue(n, n2, f2);
    }

    @Override
    public float getAnimFloatValue(int n, int n2) {
        return this.animationAdapters.getAnimFloatValue(n, n2);
    }

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError().initCause(classNotFoundException);
        }
    }

    static {
        $assertionsDisabled = !(class$de$vw$mib$view$internal$AbstractWithServicesViewHandler == null ? (class$de$vw$mib$view$internal$AbstractWithServicesViewHandler = AbstractWithServicesViewHandler.class$("de.vw.mib.view.internal.AbstractWithServicesViewHandler")) : class$de$vw$mib$view$internal$AbstractWithServicesViewHandler).desiredAssertionStatus();
    }
}

