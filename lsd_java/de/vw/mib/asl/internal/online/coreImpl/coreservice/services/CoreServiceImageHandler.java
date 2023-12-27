/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.online.coreImpl.coreservice.services;

import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.online.coreImpl.coreservice.CoreServiceImplFactory;
import de.vw.mib.asl.internal.online.coreImpl.coreservice.services.CoreServiceDownloadImageCollector;
import de.vw.mib.asl.internal.online.coreImpl.coreservice.services.CoreServiceImageHandler$1;
import de.vw.mib.asl.internal.online.coreImpl.coreservice.services.CoreServiceImageInfo;
import de.vw.mib.asl.internal.online.coreInterfaces.CoreServiceFactory;
import de.vw.mib.asl.internal.online.coreInterfaces.service.CoreServiceCallback1;
import de.vw.mib.log4mib.LogMessage;
import de.vw.mib.util.Util;
import java.util.ArrayList;
import java.util.Iterator;
import org.dsi.ifc.global.ResourceLocator;

public class CoreServiceImageHandler {
    private final String _classname = super.getClass().getName();
    private ArrayList _queue;
    private CoreServiceDownloadImageCollector _currentProcessedImageCollector;
    private ArrayList _brandIconList;

    private ArrayList getImageInfoList() {
        return CoreServiceImplFactory.getPersistence().getImageInfoList();
    }

    private ArrayList getQueue() {
        if (this._queue == null) {
            this._queue = new ArrayList();
        }
        return this._queue;
    }

    private ArrayList getBrandIconList() {
        if (this._brandIconList == null) {
            this._brandIconList = new ArrayList();
        }
        return this._brandIconList;
    }

    private String generateFileNameWithURL(String string) {
        String string2 = "";
        if (!Util.isNullOrEmpty(string)) {
            string2 = (string = string.trim()).substring(string.lastIndexOf(47) + 1);
            string2 = string2.lastIndexOf(".png") > -1 ? new StringBuffer().append("/var/app/ols/providericons/").append(string2).toString() : new StringBuffer().append("/var/app/ols/providericons/").append(string2).append(".png").toString();
        }
        if (ServiceManager.logger2.isTraceEnabled(16384)) {
            LogMessage logMessage = ServiceManager.logger2.trace(16384);
            logMessage.append(this._classname).append(new StringBuffer().append(".generateFileNameWithURL(").append(string != null ? string : "NULL").append(")->").append(string2).toString()).log();
        }
        return string2;
    }

    private void processNextElementInQueue() {
        if (ServiceManager.logger2.isTraceEnabled(16384)) {
            LogMessage logMessage = ServiceManager.logger2.trace(16384);
            logMessage.append(this._classname).append(".processNextElementInQueue()").log();
        }
        if (this._currentProcessedImageCollector != null) {
            this._currentProcessedImageCollector.clear();
            this._currentProcessedImageCollector = null;
        }
        if (!this.getQueue().isEmpty()) {
            this._currentProcessedImageCollector = (CoreServiceDownloadImageCollector)this.getQueue().remove(0);
            this.requestDownloadImage(this._currentProcessedImageCollector);
        }
    }

    private boolean checkAndProcessDuplicates(CoreServiceImageInfo coreServiceImageInfo, ResourceLocator resourceLocator) {
        Object object;
        if (ServiceManager.logger2.isTraceEnabled(16384)) {
            object = ServiceManager.logger2.trace(16384);
            object.append(this._classname).append(new StringBuffer().append(".checkAndProcessDuplicates(").append(coreServiceImageInfo != null ? coreServiceImageInfo.toString() : "NULL").append(")").toString()).log();
        }
        if (coreServiceImageInfo != null && !this.getQueue().isEmpty()) {
            object = this.getQueue().listIterator();
            while (object.hasNext()) {
                CoreServiceDownloadImageCollector coreServiceDownloadImageCollector = (CoreServiceDownloadImageCollector)object.next();
                if (coreServiceDownloadImageCollector == null || !coreServiceDownloadImageCollector.getURL().equals(coreServiceImageInfo.getImageUrl()) || coreServiceDownloadImageCollector.getCategory() != coreServiceImageInfo.getCategory()) continue;
                if (!Util.isNullOrEmpty(coreServiceDownloadImageCollector.getChecksum()) && !Util.isNullOrEmpty(coreServiceImageInfo.getImageCheckSum())) {
                    if (!coreServiceDownloadImageCollector.getChecksum().equals(coreServiceImageInfo.getImageCheckSum())) continue;
                    coreServiceDownloadImageCollector.getCallback().updateImageInfo(resourceLocator);
                    object.remove();
                    continue;
                }
                if (!Util.isNullOrEmpty(coreServiceDownloadImageCollector.getChecksum()) || !Util.isNullOrEmpty(coreServiceImageInfo.getImageCheckSum())) continue;
                coreServiceDownloadImageCollector.getCallback().updateImageInfo(resourceLocator);
                object.remove();
            }
        }
        return false;
    }

    private void startCallBackTimer() {
        if (ServiceManager.logger2.isTraceEnabled(16384)) {
            LogMessage logMessage = ServiceManager.logger2.trace(16384);
            logMessage.append(this._classname).append(".startCallBackTimer()").log();
        }
        ServiceManager.aslThreadSwitch.enqueue(new CoreServiceImageHandler$1(this));
    }

    private void requestDownloadImage(CoreServiceDownloadImageCollector coreServiceDownloadImageCollector) {
        if (ServiceManager.logger2.isTraceEnabled(16384)) {
            LogMessage logMessage = ServiceManager.logger2.trace(16384);
            logMessage.append(this._classname).append(new StringBuffer().append(".requestDownloadImage(").append(coreServiceDownloadImageCollector != null ? coreServiceDownloadImageCollector.toString() : "NULL").append(")").toString()).log();
        }
        if (coreServiceDownloadImageCollector != null) {
            Object[] objectArray;
            boolean bl = false;
            String string = coreServiceDownloadImageCollector.getLocalFilePath();
            if (Util.isNullOrEmpty(string)) {
                string = this.generateFileNameWithURL(coreServiceDownloadImageCollector.getURL());
                bl = true;
            }
            if (!(Util.isNullOrEmpty(string) || Util.isNullOrEmpty(CoreServiceFactory.getExternalRegister().getRegisteredExternals()) || Util.isNullOrEmpty(objectArray = CoreServiceFactory.getExternalRegister().getExternalsWithSupportedFunction(2)))) {
                int n = objectArray.length;
                for (int i2 = 0; i2 < n; ++i2) {
                    objectArray[i2].downloadImage(coreServiceDownloadImageCollector.getServiceID(), coreServiceDownloadImageCollector.getURL(), string, bl, CoreServiceImplFactory.getExternalListener());
                }
                return;
            }
            this.startCallBackTimer();
            ServiceManager.logger2.info(16384).append(this._classname).append(".requestDownloadImage() -> ERROR").log();
        } else {
            this.startCallBackTimer();
        }
    }

    private void storeImageInfo(ResourceLocator resourceLocator) {
        Object object;
        if (ServiceManager.logger2.isTraceEnabled(16384)) {
            object = ServiceManager.logger2.trace(16384);
            object.append(this._classname).append(new StringBuffer().append(".storeImageInfo(").append(resourceLocator != null ? resourceLocator.toString() : "null").append(")").toString()).log();
        }
        if (resourceLocator != null && this._currentProcessedImageCollector != null) {
            object = new CoreServiceImageInfo(this._currentProcessedImageCollector.getURL(), this._currentProcessedImageCollector.getChecksum(), this._currentProcessedImageCollector.getLocalFilePath(), this._currentProcessedImageCollector.getCategory(), resourceLocator);
            if (!Util.isNullOrEmpty(this._currentProcessedImageCollector.getChecksum())) {
                CoreServiceImplFactory.getPersistence().addImageInfo((CoreServiceImageInfo)object);
            } else {
                this.getBrandIconList().add(object);
            }
            this.checkAndProcessDuplicates((CoreServiceImageInfo)object, resourceLocator);
        }
        this.fireCallback(resourceLocator);
    }

    public void factoryReset() {
        this.getBrandIconList().clear();
        this.getQueue().clear();
        if (this._currentProcessedImageCollector != null) {
            this._currentProcessedImageCollector.clear();
            this._currentProcessedImageCollector = null;
        }
    }

    public String getPathIfValid(String string, String string2, int n) {
        LogMessage logMessage;
        block5: {
            block4: {
                if (ServiceManager.logger2.isTraceEnabled(16384)) {
                    logMessage = ServiceManager.logger2.trace(16384);
                    logMessage.append(this._classname).append(new StringBuffer().append(".getPathIfValid(").append(string != null ? string : "null").append(", ").append(string2 != null ? string2 : "null").append(", ").append(n).append(" )").toString()).log();
                }
                logMessage = null;
                if (Util.isNullOrEmpty(string2)) break block4;
                if (this.getImageInfoList().isEmpty()) break block5;
                Iterator iterator = this.getImageInfoList().iterator();
                while (iterator.hasNext()) {
                    CoreServiceImageInfo coreServiceImageInfo = (CoreServiceImageInfo)iterator.next();
                    if (Util.isNullOrEmpty(string) || !coreServiceImageInfo.getImageUrl().equals(string) || coreServiceImageInfo.getCategory() != n || Util.isNullOrEmpty(coreServiceImageInfo.getImageCheckSum()) || !coreServiceImageInfo.getImageCheckSum().equals(string2) || Util.isNullOrEmpty(coreServiceImageInfo.getFilePath())) continue;
                    return coreServiceImageInfo.getFilePath();
                }
                break block5;
            }
            if (!this.getBrandIconList().isEmpty()) {
                Iterator iterator = this.getBrandIconList().iterator();
                while (iterator.hasNext()) {
                    CoreServiceImageInfo coreServiceImageInfo = (CoreServiceImageInfo)iterator.next();
                    if (Util.isNullOrEmpty(string) || !coreServiceImageInfo.getImageUrl().equals(string) || coreServiceImageInfo.getCategory() != n) continue;
                    return coreServiceImageInfo.getFilePath();
                }
            }
        }
        return logMessage;
    }

    public void downloadImage(CoreServiceCallback1 coreServiceCallback1, String string, String string2, int n, boolean bl, String string3) {
        Object object;
        if (ServiceManager.logger2.isTraceEnabled(16384)) {
            object = ServiceManager.logger2.trace(16384);
            object.append(this._classname).append(new StringBuffer().append(".downloadImage(").append(coreServiceCallback1 != null ? "callback" : "null").append(", ").append(!Util.isNullOrEmpty(string) ? string : "null").append(", ").append(string2 != null ? string2 : "null").append(", ").append(n).append(", ").append(bl).append(", ").append(!Util.isNullOrEmpty(string3) ? string3 : "null").append(" )").toString()).log();
        }
        if (((CoreServiceDownloadImageCollector)(object = new CoreServiceDownloadImageCollector(coreServiceCallback1, string, string2, n, string3))).isValid()) {
            String string4 = this.getPathIfValid(string, string2, n);
            if (!Util.isNullOrEmpty(string4)) {
                ((CoreServiceDownloadImageCollector)object).setLocalFilePath(string4);
            }
            if (this._currentProcessedImageCollector == null) {
                this._currentProcessedImageCollector = new CoreServiceDownloadImageCollector((CoreServiceDownloadImageCollector)object);
                if (this._currentProcessedImageCollector.isLocalFilePathExists() || bl) {
                    this.requestDownloadImage(this._currentProcessedImageCollector);
                } else {
                    this.fireCallback(null);
                }
            } else {
                this.getQueue().add(new CoreServiceDownloadImageCollector((CoreServiceDownloadImageCollector)object));
                if (ServiceManager.logger2.isTraceEnabled(16384)) {
                    LogMessage logMessage = ServiceManager.logger2.trace(16384);
                    logMessage.append(this._classname).append(".downloadImage() -> added in the queue").log();
                }
            }
            ((CoreServiceDownloadImageCollector)object).clear();
            object = null;
        } else {
            ServiceManager.logger2.info(16384).append(this._classname).append("Either Callback is NULL or URL is NULL").log();
            this.startCallBackTimer();
        }
    }

    public void downloadImage(CoreServiceCallback1 coreServiceCallback1, String string, String string2, int n, int n2, boolean bl) {
        Object object;
        if (ServiceManager.logger2.isTraceEnabled(16384)) {
            object = ServiceManager.logger2.trace(16384);
            object.append(this._classname).append(new StringBuffer().append(".downloadImage(").append(coreServiceCallback1 != null ? "callback" : "null").append(", ").append(string != null ? string : "null").append(", ").append(string2 != null ? string2 : "null").append(", ").append(n).append(", ").append(bl).append(" )").toString()).log();
        }
        if (((CoreServiceDownloadImageCollector)(object = new CoreServiceDownloadImageCollector(coreServiceCallback1, string, string2, n))).isValid()) {
            String string3 = this.getPathIfValid(string, string2, n);
            if (!Util.isNullOrEmpty(string3)) {
                ((CoreServiceDownloadImageCollector)object).setLocalFilePath(string3);
            }
            if (this._currentProcessedImageCollector == null) {
                this._currentProcessedImageCollector = new CoreServiceDownloadImageCollector((CoreServiceDownloadImageCollector)object);
                if (this._currentProcessedImageCollector.isLocalFilePathExists() || bl) {
                    this.requestDownloadImage(this._currentProcessedImageCollector);
                } else {
                    this.fireCallback(null);
                }
            } else {
                this.getQueue().add(new CoreServiceDownloadImageCollector((CoreServiceDownloadImageCollector)object));
                if (ServiceManager.logger2.isTraceEnabled(16384)) {
                    LogMessage logMessage = ServiceManager.logger2.trace(16384);
                    logMessage.append(this._classname).append(".downloadImage() -> added in the queue").log();
                }
            }
            ((CoreServiceDownloadImageCollector)object).clear();
            object = null;
        } else {
            ServiceManager.logger2.info(16384).append(this._classname).append("Either Callback is NULL or URL is NULL").log();
            this.startCallBackTimer();
        }
    }

    public void downloadImageResponse(String string, String string2, String string3, ResourceLocator resourceLocator, int n) {
        if (ServiceManager.logger2.isTraceEnabled(16384)) {
            LogMessage logMessage = ServiceManager.logger2.trace(16384);
            logMessage.append(this._classname).append(new StringBuffer().append(".downloadImageResponse(").append(string != null ? string : "null").append(", ").append(string2 != null ? string2 : "null").append(", ").append(string3 != null ? string3 : "null").append(", ").append(n).append(")").toString()).log();
        }
        if (resourceLocator == null) {
            this.fireCallback(null);
            return;
        }
        switch (n) {
            case 0: {
                this._currentProcessedImageCollector.setLocalFilePath(string3);
                this.storeImageInfo(resourceLocator);
                break;
            }
            case 40: 
            case 41: 
            case 42: 
            case 43: 
            case 44: 
            case 45: 
            case 46: 
            case 47: 
            case 48: 
            case 49: {
                this.fireCallback(null);
                break;
            }
        }
    }

    public void fireCallback(ResourceLocator resourceLocator) {
        if (ServiceManager.logger2.isTraceEnabled(16384)) {
            LogMessage logMessage = ServiceManager.logger2.trace(16384);
            logMessage.append(this._classname).append(new StringBuffer().append(".fireCallback(").append(resourceLocator != null ? resourceLocator.toString() : "null").append(")").toString()).log();
        }
        if (this._currentProcessedImageCollector != null) {
            this._currentProcessedImageCollector.getCallback().updateImageInfo(resourceLocator);
        }
        this.processNextElementInQueue();
    }

    public ResourceLocator checkIfImageExists(String string, String string2, int n) {
        LogMessage logMessage;
        if (ServiceManager.logger2.isTraceEnabled(16384)) {
            logMessage = ServiceManager.logger2.trace(16384);
            logMessage.append(this._classname).append(new StringBuffer().append(".checkIfImageExists(").append(string != null ? string : "null").append(", ").append(string2 != null ? string2 : "null").append(", ").append(n).append(" )").toString()).log();
        }
        logMessage = null;
        if (!Util.isNullOrEmpty(string2)) {
            Object object;
            if (ServiceManager.logger2.isTraceEnabled(16384)) {
                object = ServiceManager.logger2.trace(16384);
                object.append(this._classname).append(".checkIfImageExists()-> checking for provider logo").log();
            }
            if (!this.getImageInfoList().isEmpty()) {
                object = this.getImageInfoList().iterator();
                while (object.hasNext()) {
                    CoreServiceImageInfo coreServiceImageInfo = (CoreServiceImageInfo)object.next();
                    if (Util.isNullOrEmpty(string) || !coreServiceImageInfo.getImageUrl().equals(string) || coreServiceImageInfo.getCategory() != n || Util.isNullOrEmpty(coreServiceImageInfo.getImageCheckSum()) || !coreServiceImageInfo.getImageCheckSum().equals(string2) || coreServiceImageInfo.getResourceLocator() == null) continue;
                    if (ServiceManager.logger2.isTraceEnabled(16384)) {
                        LogMessage logMessage2 = ServiceManager.logger2.trace(16384);
                        logMessage2.append(this._classname).append(".checkIfImageExists()-> Provider Logo exists internally").log();
                    }
                    return coreServiceImageInfo.getResourceLocator();
                }
            } else if (ServiceManager.logger2.isTraceEnabled(16384)) {
                object = ServiceManager.logger2.trace(16384);
                object.append(this._classname).append(".checkIfImageExists()-> provider logo Internal list is empty").log();
            }
        } else {
            Object object;
            if (ServiceManager.logger2.isTraceEnabled(16384)) {
                object = ServiceManager.logger2.trace(16384);
                object.append(this._classname).append(".checkIfImageExists()-> checking for brand icon").log();
            }
            if (!this.getBrandIconList().isEmpty()) {
                object = this.getBrandIconList().iterator();
                while (object.hasNext()) {
                    CoreServiceImageInfo coreServiceImageInfo = (CoreServiceImageInfo)object.next();
                    if (Util.isNullOrEmpty(string) || !coreServiceImageInfo.getImageUrl().equals(string) || coreServiceImageInfo.getCategory() != n || coreServiceImageInfo.getResourceLocator() == null) continue;
                    if (ServiceManager.logger2.isTraceEnabled(16384)) {
                        LogMessage logMessage3 = ServiceManager.logger2.trace(16384);
                        logMessage3.append(this._classname).append(".checkIfImageExists()-> Brand Icon exists internally").log();
                    }
                    return coreServiceImageInfo.getResourceLocator();
                }
            } else if (ServiceManager.logger2.isTraceEnabled(16384)) {
                object = ServiceManager.logger2.trace(16384);
                object.append(this._classname).append(".checkIfImageExists()-> Brand icon Internal list is empty").log();
            }
        }
        return logMessage;
    }
}

