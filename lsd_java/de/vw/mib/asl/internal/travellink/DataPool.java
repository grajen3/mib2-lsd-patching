/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.travellink;

import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import java.lang.ref.Reference;
import java.lang.ref.SoftReference;
import org.dsi.ifc.travellink.GenericPropertyContainer;

public final class DataPool {
    private Reference[] objectArray = new Reference[60];

    public void put(int n, GenericPropertyContainer[] genericPropertyContainerArray) {
        try {
            if (ServiceManager.logger2.isTraceEnabled(2)) {
                if (genericPropertyContainerArray == null) {
                    ServiceManager.logger2.warn(2).append("DataPool - put() - requestTypeId = ").append(n).append(", genericPropertyContainerArray == null ").log();
                } else {
                    ServiceManager.logger2.trace(2).append("DataPool - put() - requestTypeId = ").append(n).append(", genericPropertyContainerArray.length = ").append(genericPropertyContainerArray.length).log();
                }
            }
            if (null != this.objectArray && n >= 0 && n < this.objectArray.length) {
                this.objectArray[n] = genericPropertyContainerArray == null ? new SoftReference(new GenericPropertyContainer[0]) : new SoftReference(genericPropertyContainerArray);
            }
        }
        catch (Exception exception) {
            ServiceManager.errorHandler.handleError(exception);
        }
    }

    public GenericPropertyContainer[] get(int n) {
        try {
            if (null != this.objectArray && n >= 0 && n < this.objectArray.length) {
                Object object;
                Reference reference = this.objectArray[n];
                if (null != reference && null != (object = reference.get())) {
                    return (GenericPropertyContainer[])object;
                }
                return null;
            }
            if (ServiceManager.logger2.isTraceEnabled(2)) {
                ServiceManager.logger2.trace(2).append("Datapool : get : returns null. ").log();
            }
            return null;
        }
        catch (Exception exception) {
            ServiceManager.errorHandler.handleError(exception);
            return null;
        }
    }

    public void clear() {
        try {
            if (null != this.objectArray) {
                for (int i2 = 0; i2 < this.objectArray.length; ++i2) {
                    Reference reference = this.objectArray[i2];
                    if (null != reference) {
                        reference.clear();
                    }
                    this.objectArray[i2] = null;
                }
            }
        }
        catch (Exception exception) {
            ServiceManager.errorHandler.handleError(exception);
        }
    }

    public void clear(int n) {
        try {
            if (null != this.objectArray && n >= 0 && n < this.objectArray.length) {
                Reference reference = this.objectArray[n];
                if (null != reference) {
                    reference.clear();
                }
                this.objectArray[n] = null;
            }
        }
        catch (Exception exception) {
            ServiceManager.errorHandler.handleError(exception);
        }
    }
}

