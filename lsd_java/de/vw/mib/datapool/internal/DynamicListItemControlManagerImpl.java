/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.datapool.internal;

import de.vw.mib.app.appadapter.CellValue;
import de.vw.mib.collections.ints.IntObjectMap;
import de.vw.mib.collections.ints.IntObjectOptHashMap;
import de.vw.mib.datapool.DynamicListItemControlManager;
import de.vw.mib.datapool.ExtendedListItemControl;
import de.vw.mib.datapool.internal.DynamicListItemControl;
import de.vw.mib.datapool.internal.NilListItemControl;
import de.vw.mib.hmi.internal.ServiceManagerCommon;
import de.vw.mib.list.DynamicListData;
import de.vw.mib.log4mib.Logger;

public class DynamicListItemControlManagerImpl
implements DynamicListItemControlManager {
    private final Logger logger = ServiceManagerCommon.loggerFactory.getLogger(8);
    private final IntObjectMap listItemControls = new IntObjectOptHashMap();

    @Override
    public CellValue getCellValue(CellValue cellValue, int n, int n2, int n3) {
        ExtendedListItemControl extendedListItemControl = this.getListItemControl(n);
        Object object = extendedListItemControl.getRowItem(n2);
        return extendedListItemControl.getCellValue(cellValue, object, n2, n3);
    }

    @Override
    public ExtendedListItemControl getListItemControl(int n) {
        ExtendedListItemControl extendedListItemControl = (ExtendedListItemControl)this.listItemControls.get(n);
        if (extendedListItemControl == null) {
            extendedListItemControl = this.createDynamicListItemControl(n);
            this.listItemControls.put(n, extendedListItemControl);
        }
        return extendedListItemControl;
    }

    ExtendedListItemControl createDynamicListItemControl(int n) {
        try {
            DynamicListData dynamicListData = ServiceManagerCommon.dynamicListManager.getDynamicList(n);
            DynamicListItemControl dynamicListItemControl = new DynamicListItemControl(dynamicListData);
            if (this.logger.isTraceEnabled(64)) {
                this.logger.trace(64).append("new dynamic ListItemControl created: ").append(n).append(": ").append(dynamicListItemControl).append(" - ").append(dynamicListData).log();
            }
            return dynamicListItemControl;
        }
        catch (RuntimeException runtimeException) {
            this.logger.warn(64).append("Dynamic list with id '").append(n).append("' not available or implemented!").log();
            return NilListItemControl.instance();
        }
    }
}

