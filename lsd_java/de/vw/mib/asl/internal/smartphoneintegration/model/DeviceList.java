/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.smartphoneintegration.model;

import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.list.impl.GenericASLList;
import de.vw.mib.asl.internal.smartphoneintegration.common.SmartPhoneIntegrationGlobalProperyAccessor;
import de.vw.mib.asl.internal.smartphoneintegration.model.AbstractListHandler;
import de.vw.mib.asl.internal.smartphoneintegration.transformer.SmartPhoneIntegrationDeviceListCollector;
import java.util.ArrayList;
import java.util.Iterator;
import org.dsi.ifc.smartphoneintegration.Device;

public class DeviceList
extends AbstractListHandler {
    private final String _classname;

    public DeviceList() {
        super(1231498240);
        this._classname = "SmartPhoneIntegration.DeviceList";
        this.clear();
    }

    @Override
    public void reseted() {
    }

    @Override
    protected void activated(int n) {
    }

    @Override
    protected void deactivated(int n) {
    }

    public int getIndex(int n) {
        if (this.getList().getSize() > 0) {
            GenericASLList genericASLList = this.getList();
            for (int i2 = 0; i2 < genericASLList.getItemCount(); ++i2) {
                SmartPhoneIntegrationDeviceListCollector smartPhoneIntegrationDeviceListCollector;
                Object object = genericASLList.getRowItem(i2);
                if (!genericASLList.isValidItem(object) || (smartPhoneIntegrationDeviceListCollector = (SmartPhoneIntegrationDeviceListCollector)object) == null || smartPhoneIntegrationDeviceListCollector.getDeviceID() != n) continue;
                return i2;
            }
        }
        return -1;
    }

    public SmartPhoneIntegrationDeviceListCollector getDeviceCollector(int n) {
        Object object;
        Object object2;
        if (ServiceManager.logger2.isTraceEnabled(1024)) {
            object2 = ServiceManager.logger2.trace(1024);
            object2.append("SmartPhoneIntegration.DeviceList").append(".getDeviceCollector(").append(n).append(new StringBuffer().append(") Listsize:").append(this.getList().getSize()).toString()).log();
        }
        if (n > -1 && this.getList().getSize() > n && (object2 = this.getList()).isValidItem(object = object2.getRowItem(n))) {
            return (SmartPhoneIntegrationDeviceListCollector)object;
        }
        return null;
    }

    public SmartPhoneIntegrationDeviceListCollector getActivatedElement() {
        int n = this.getList().getActivatedIndex();
        if (n > -1) {
            return this.getDeviceCollector(n);
        }
        return null;
    }

    public void updateDeviceList() {
        Object object;
        ArrayList arrayList = SmartPhoneIntegrationGlobalProperyAccessor.getInstance().getHmiDevicelist();
        Object[] objectArray = new SmartPhoneIntegrationDeviceListCollector[arrayList.size()];
        Iterator iterator = arrayList.iterator();
        int n = 0;
        while (iterator.hasNext()) {
            object = (Device)iterator.next();
            objectArray[n++] = new SmartPhoneIntegrationDeviceListCollector((Device)object);
        }
        this.getList().updateList(objectArray);
        if (ServiceManager.logger2.isTraceEnabled(1024)) {
            object = ServiceManager.logger2.trace(1024);
            object.append("SmartPhoneIntegration.DeviceList").append(".updateDeviceList(").log();
        }
    }
}

