/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.online.coreImpl;

import de.vw.mib.asl.api.online.ASLOnlineApplicationLicenseStatusCallBack;
import de.vw.mib.asl.api.online.ASLOnlineCoreServices;
import de.vw.mib.asl.api.online.ASLOnlineCoreServicesCallbackVersion4;
import de.vw.mib.asl.api.online.ASLOnlineServiceAvailabilityListener;
import de.vw.mib.asl.api.online.ASLOnlineServiceCallback;
import de.vw.mib.asl.api.online.ASLOnlineServiceCallback1;
import de.vw.mib.asl.api.online.ASLOnlineServiceIdentifier;
import de.vw.mib.asl.api.online.ASLOnlineServiceListener;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.online.coreImpl.corecommon.CoreServiceMappingTable;
import de.vw.mib.asl.internal.online.coreImpl.coreservice.CoreServiceImplFactory;
import de.vw.mib.asl.internal.online.coreImpl.coreservice.callback.CoreServiceAvailabilityListener;
import de.vw.mib.asl.internal.online.coreImpl.coreservice.callback.CoreServiceCallback1Impl;
import de.vw.mib.asl.internal.online.coreImpl.coreservice.callback.CoreServiceCallbackImpl;
import de.vw.mib.asl.internal.online.coreImpl.coreservice.callback.CoreServiceStatusListenerImpl;
import de.vw.mib.asl.internal.online.coreInterfaces.service.CoreServiceCallback1;
import de.vw.mib.util.Util;
import org.dsi.ifc.global.ResourceLocator;

public class ASLOnlineCoreServicesImpl
implements ASLOnlineCoreServices {
    private final String _classname = super.getClass().getName();

    @Override
    public void registerForServiceUpdate(String string, ASLOnlineServiceListener aSLOnlineServiceListener) {
        if (aSLOnlineServiceListener != null) {
            if (!Util.isNullOrEmpty(string)) {
                CoreServiceImplFactory.getCoreServiceController().addServiceForUpdate(string, aSLOnlineServiceListener);
            } else {
                ServiceManager.logger2.info(16384).append(this._classname).append(new StringBuffer().append(".registerForServiceUpdate( Service ID = ").append(Util.isNullOrEmpty(string) ? "NULL" : string).append(" can not be registered )").toString()).log();
            }
        }
    }

    @Override
    public void unRegisterForServiceUpdate(String string, ASLOnlineServiceListener aSLOnlineServiceListener) {
        if (!Util.isNullOrEmpty(string)) {
            CoreServiceImplFactory.getCoreServiceController().removeServiceFromUpdate(string, aSLOnlineServiceListener);
        } else {
            ServiceManager.logger2.info(16384).append(this._classname).append(new StringBuffer().append(".unRegisterForServiceUpdate( Service ID = ").append(Util.isNullOrEmpty(string) ? "NULL" : string).append("  can not be unregistered )").toString()).log();
        }
    }

    @Override
    public int getOnlineServicesAvailabilityStatus() {
        CoreServiceImplFactory.getCoreServiceController().handleOnlineServicesStatus();
        return CoreServiceImplFactory.getCoreServiceController().getOnlineServicesStatus();
    }

    @Override
    public void registerForOnlineServicesAvailabilityStatus(ASLOnlineServiceAvailabilityListener aSLOnlineServiceAvailabilityListener) {
        if (aSLOnlineServiceAvailabilityListener != null) {
            CoreServiceAvailabilityListener coreServiceAvailabilityListener = new CoreServiceAvailabilityListener(aSLOnlineServiceAvailabilityListener);
            CoreServiceImplFactory.getCoreServiceController().registerListener(coreServiceAvailabilityListener);
        }
    }

    @Override
    public String getServiceIDWithNumericServiceID(int n, int n2) {
        return CoreServiceMappingTable.getServiceIDWithModelID(n, n2);
    }

    @Override
    public String getServiceIDWithNumericServiceID(int n) {
        return CoreServiceMappingTable.getServiceIDWithModelID(n);
    }

    @Override
    public String getServiceIDWithIdentifier(String string) {
        return Util.isNullOrEmpty(string) ? "" : CoreServiceMappingTable.getServiceIDWithServiceName(string);
    }

    @Override
    public void checkOnlineServiceStatus(String string, ASLOnlineServiceListener aSLOnlineServiceListener) {
        if (aSLOnlineServiceListener != null) {
            CoreServiceStatusListenerImpl coreServiceStatusListenerImpl = new CoreServiceStatusListenerImpl(aSLOnlineServiceListener);
            CoreServiceImplFactory.getStatusHandler().handleServiceStatusCheck(coreServiceStatusListenerImpl, string);
        }
    }

    @Override
    public boolean isOCUService(String string) {
        return CoreServiceImplFactory.getCoreServiceController().isOCUService(string);
    }

    @Override
    public boolean isServiceAvailable(String string) {
        return CoreServiceImplFactory.getCoreServiceController().isServiceAvailable(string);
    }

    @Override
    public ResourceLocator getOnlineImage(int n, String string, int n2, String string2, String string3, ASLOnlineServiceCallback1 aSLOnlineServiceCallback1) {
        ResourceLocator resourceLocator = CoreServiceImplFactory.getLogoHandler().checkIfImageExists(string2, string3, n2);
        if (resourceLocator != null) {
            return resourceLocator;
        }
        if (aSLOnlineServiceCallback1 != null) {
            CoreServiceCallback1Impl coreServiceCallback1Impl = new CoreServiceCallback1Impl(aSLOnlineServiceCallback1);
            CoreServiceImplFactory.getLogoHandler().downloadImage((CoreServiceCallback1)coreServiceCallback1Impl, string2, string3, n2, CoreServiceImplFactory.getCoreServiceController().isServiceInUsableState(string), string);
            return null;
        }
        ServiceManager.logger2.warn(16384).append(this._classname).append(".getOnlineImage( CALLBACK = NULL )").log();
        return null;
    }

    @Override
    public void getServiceURL(String string, ASLOnlineServiceCallback1 aSLOnlineServiceCallback1) {
        if (aSLOnlineServiceCallback1 != null) {
            CoreServiceCallback1Impl coreServiceCallback1Impl = new CoreServiceCallback1Impl(aSLOnlineServiceCallback1);
            CoreServiceImplFactory.getURLHandler().handleURLInfo(coreServiceCallback1Impl, string);
        }
    }

    @Override
    public boolean getSetCustomerDownloadIndicationStatus(boolean bl, int n, boolean bl2) {
        switch (n) {
            case 1: {
                if (!bl2) {
                    return CoreServiceImplFactory.getPersistence().isDownloadIndicationStatus();
                }
                CoreServiceImplFactory.getPersistence().setDownloadIndicationStatus(bl);
                break;
            }
            case 2: {
                if (!bl2) {
                    return CoreServiceImplFactory.getPersistence().isDownloadLaterStatus();
                }
                CoreServiceImplFactory.getPersistence().setDownloadLaterStatus(bl);
                break;
            }
            case 3: {
                if (!bl2) {
                    return CoreServiceImplFactory.getPersistence().isDownloadDestinationIndicationStatus();
                }
                CoreServiceImplFactory.getPersistence().setDownloadDestinationIndicationStatus(bl);
                break;
            }
            case 4: {
                if (!bl2) {
                    return CoreServiceImplFactory.getPersistence().isDownloadDestinationLaterStatus();
                }
                CoreServiceImplFactory.getPersistence().setDownloadDestinationLaterStatus(bl);
                break;
            }
        }
        return false;
    }

    @Override
    public void checkOnlineServiceStatus(ASLOnlineServiceIdentifier aSLOnlineServiceIdentifier, ASLOnlineServiceCallback aSLOnlineServiceCallback) {
        if (aSLOnlineServiceCallback != null) {
            CoreServiceCallbackImpl coreServiceCallbackImpl = new CoreServiceCallbackImpl(aSLOnlineServiceCallback);
            String string = !Util.isNullOrEmpty(aSLOnlineServiceIdentifier.getServiceidentifier()) ? CoreServiceMappingTable.getServiceIDWithServiceName(aSLOnlineServiceIdentifier.getServiceidentifier()) : aSLOnlineServiceIdentifier.getServiceID();
            CoreServiceImplFactory.getStatusHandler().handleServiceStatusCheck(coreServiceCallbackImpl, string);
        }
    }

    @Override
    public boolean isServiceConfigured(ASLOnlineServiceIdentifier aSLOnlineServiceIdentifier) {
        String string = !Util.isNullOrEmpty(aSLOnlineServiceIdentifier.getServiceidentifier()) ? CoreServiceMappingTable.getServiceIDWithServiceName(aSLOnlineServiceIdentifier.getServiceidentifier()) : aSLOnlineServiceIdentifier.getServiceID();
        return this.isServiceAvailable(string);
    }

    @Override
    public boolean isOCUService(ASLOnlineServiceIdentifier aSLOnlineServiceIdentifier) {
        String string = !Util.isNullOrEmpty(aSLOnlineServiceIdentifier.getServiceidentifier()) ? CoreServiceMappingTable.getServiceIDWithServiceName(aSLOnlineServiceIdentifier.getServiceidentifier()) : aSLOnlineServiceIdentifier.getServiceID();
        return this.isOCUService(string);
    }

    @Override
    public ResourceLocator getOnlineImage(ASLOnlineServiceIdentifier aSLOnlineServiceIdentifier, int n, String string, String string2, ASLOnlineServiceCallback aSLOnlineServiceCallback) {
        ResourceLocator resourceLocator = CoreServiceImplFactory.getLogoHandler().checkIfImageExists(string, string2, n);
        if (resourceLocator != null) {
            return resourceLocator;
        }
        if (aSLOnlineServiceCallback != null) {
            CoreServiceCallback1Impl coreServiceCallback1Impl = new CoreServiceCallback1Impl(aSLOnlineServiceCallback);
            String string3 = !Util.isNullOrEmpty(aSLOnlineServiceIdentifier.getServiceidentifier()) ? CoreServiceMappingTable.getServiceIDWithServiceName(aSLOnlineServiceIdentifier.getServiceidentifier()) : aSLOnlineServiceIdentifier.getServiceID();
            CoreServiceImplFactory.getLogoHandler().downloadImage((CoreServiceCallback1)coreServiceCallback1Impl, string, string2, n, CoreServiceImplFactory.getCoreServiceController().isServiceInUsableState(string3), string3);
            return null;
        }
        ServiceManager.logger2.warn(16384).append(this._classname).append(".getOnlineImage( CALLBACK = NULL )").log();
        return null;
    }

    @Override
    public void getServiceURL(ASLOnlineServiceIdentifier aSLOnlineServiceIdentifier, ASLOnlineServiceCallback aSLOnlineServiceCallback) {
        if (aSLOnlineServiceCallback != null) {
            CoreServiceCallback1Impl coreServiceCallback1Impl = new CoreServiceCallback1Impl(aSLOnlineServiceCallback);
            String string = !Util.isNullOrEmpty(aSLOnlineServiceIdentifier.getServiceidentifier()) ? CoreServiceMappingTable.getServiceIDWithServiceName(aSLOnlineServiceIdentifier.getServiceidentifier()) : aSLOnlineServiceIdentifier.getServiceID();
            CoreServiceImplFactory.getURLHandler().handleURLInfo(coreServiceCallback1Impl, string);
        }
    }

    @Override
    public int getApplicationState(int n) {
        throw new RuntimeException("METHOD NOT SUPPORTED ANYMORE");
    }

    @Override
    public void applicationCodingValueChanged(int n, boolean bl) {
        throw new RuntimeException("METHOD NOT SUPPORTED ANYMORE");
    }

    @Override
    public void applicationRegistration(int n, boolean bl) {
        throw new RuntimeException("METHOD NOT SUPPORTED ANYMORE");
    }

    @Override
    public void getApplicationServiceURLs(ASLOnlineCoreServicesCallbackVersion4 aSLOnlineCoreServicesCallbackVersion4, int n) {
        throw new RuntimeException("METHOD NOT SUPPORTED ANYMORE");
    }

    @Override
    public void checkOnlineApplicationAuthenticationLicense(ASLOnlineApplicationLicenseStatusCallBack aSLOnlineApplicationLicenseStatusCallBack, int n) {
        throw new RuntimeException("METHOD NOT SUPPORTED ANYMORE");
    }

    @Override
    public boolean isBackEndConnectionAvailable() {
        throw new RuntimeException("METHOD NOT SUPPORTED ANYMORE");
    }

    @Override
    public ResourceLocator getOnlineImage(ASLOnlineCoreServicesCallbackVersion4 aSLOnlineCoreServicesCallbackVersion4, int n, int n2, String string, String string2) {
        throw new RuntimeException("METHOD NOT SUPPORTED ANYMORE");
    }
}

