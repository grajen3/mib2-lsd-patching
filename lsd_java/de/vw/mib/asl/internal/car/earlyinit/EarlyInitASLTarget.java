/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.car.earlyinit;

import de.vw.mib.asl.api.system.ASLSystemFactory;
import de.vw.mib.asl.carearly.persistence.CarEarly;
import de.vw.mib.asl.carearly.persistence.CarEarlyPersistenceServiceImpl;
import de.vw.mib.asl.framework.api.diagnosis.ASLDiagnosisFactory;
import de.vw.mib.asl.framework.api.diagnosis.AdaptionResponse;
import de.vw.mib.asl.framework.api.diagnosis.config.Access;
import de.vw.mib.asl.framework.api.diagnosis.config.CarFuncAdap;
import de.vw.mib.asl.framework.api.framework.ASLFrameworkFactory;
import de.vw.mib.asl.framework.internal.framework.AbstractASLTarget;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.car.ASLCarContainer;
import de.vw.mib.asl.internal.car.ASLCarUtil;
import de.vw.mib.asl.internal.car.diagnosis.ReadCodingAll;
import de.vw.mib.asl.internal.car.light.transformer.IntLightRGBColorTransformer;
import de.vw.mib.asl.internal.car.transformer.CarFunctionCollector;
import de.vw.mib.configuration.SkinInformationAsyncValueSetterService;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.GenericEvents;
import generated.de.vw.mib.asl.internal.ListManager;
import org.osgi.framework.ServiceReference;

public class EarlyInitASLTarget
extends AbstractASLTarget
implements AdaptionResponse {
    private CarFuncAdap configManPersCarFuncAdapImpl;
    static /* synthetic */ Class class$de$vw$mib$configuration$SkinInformationAsyncValueSetterService;

    public EarlyInitASLTarget(GenericEvents genericEvents, int n, String string) {
        super(genericEvents, n, string);
    }

    public EarlyInitASLTarget(GenericEvents genericEvents, int n) {
        super(genericEvents, n);
    }

    public EarlyInitASLTarget(GenericEvents genericEvents, String string) {
        super(genericEvents, string);
    }

    @Override
    public int getSubClassifier() {
        return 1;
    }

    @Override
    public int getDefaultTargetId() {
        return -2125524480;
    }

    @Override
    public void gotEvent(EventGeneric eventGeneric) {
        switch (eventGeneric.getReceiverEventId()) {
            case 106: {
                if (this.isTraceEnabled()) {
                    this.trace().append("Car.EarlyInit PowerOn").log();
                }
                this.initAll();
                break;
            }
        }
    }

    private void initAll() {
        this.informHMIColorToFramework();
        this.initViewOption();
        this.readCodingAll();
        this.informLastCarViewIdsToModel();
        this.informLastPQViewtoModel();
    }

    private void readCodingAll() {
        new ReadCodingAll(ASLDiagnosisFactory.getDiagnosisApi(), this.getTextLogger());
    }

    private void informLastCarViewIdsToModel() {
        try {
            CarEarly carEarly = CarEarlyPersistenceServiceImpl.getInstance().loadCarEarly();
            EarlyInitASLTarget.writeIntegerToDatapool(10896, carEarly.getLastMainViewId());
            EarlyInitASLTarget.writeIntegerToDatapool(10897, carEarly.getLastSubViewId());
        }
        catch (Exception exception) {
            this.error(new StringBuffer().append("fail to read last car view IDs from persistence!").append(exception.getMessage()).toString());
        }
    }

    private void informLastPQViewtoModel() {
        try {
            CarEarly carEarly = CarEarlyPersistenceServiceImpl.getInstance().loadCarEarly();
            EarlyInitASLTarget.writeIntegerToDatapool(10895, carEarly.getLastPqView());
        }
        catch (Exception exception) {
            this.error(new StringBuffer().append("fail to read last PQ View from persistence!").append(exception.getMessage()).toString());
        }
    }

    private SkinInformationAsyncValueSetterService getSkinInformationAsyncValueSetterService() {
        ServiceReference serviceReference = ServiceManager.bundleContext.getServiceReference((class$de$vw$mib$configuration$SkinInformationAsyncValueSetterService == null ? (class$de$vw$mib$configuration$SkinInformationAsyncValueSetterService = EarlyInitASLTarget.class$("de.vw.mib.configuration.SkinInformationAsyncValueSetterService")) : class$de$vw$mib$configuration$SkinInformationAsyncValueSetterService).getName());
        return (SkinInformationAsyncValueSetterService)ServiceManager.bundleContext.getService(serviceReference);
    }

    private void informHMIColorToFramework() {
        Object object;
        int n = 0;
        try {
            object = CarEarlyPersistenceServiceImpl.getInstance().loadCarEarly();
            n = object.getAmbienceLightColor();
        }
        catch (Exception exception) {
            this.error(new StringBuffer().append("fail to read ambiencelight color from persistence!").append(exception.getMessage()).toString());
        }
        object = IntLightRGBColorTransformer.transformToRGBArray(n);
        try {
            this.getSkinInformationAsyncValueSetterService().setIntLightAmbientLightColor((int)object[0], (int)object[1], (int)object[2]);
        }
        catch (Exception exception) {
            this.warn(new StringBuffer().append("fail to call SkinInformationAsyncValueSetterService with new color ").append(n).append("  ").append(exception.getMessage()).toString());
        }
    }

    private void initViewOption() {
        int n;
        for (n = ASLCarContainer.collector.length - 1; n >= 0; --n) {
            ASLCarContainer.collector[n] = new CarFunctionCollector(false, 6);
        }
        for (n = ASLCarContainer.functionExistent.length - 1; n >= 0; --n) {
            ASLCarContainer.functionExistent[n] = false;
        }
        for (n = ASLCarContainer.getInstance().getMenuCodingLength() - 1; n >= 0; --n) {
            ASLCarContainer.getInstance().setMenuCoding(n, false);
        }
        ASLCarContainer.functionExistent[19] = true;
        ASLCarContainer.functionExistent[112] = true;
        ASLCarContainer.collector[112] = new CarFunctionCollector(true, 0);
        ListManager.getGenericASLList(10126).updateList(ASLCarContainer.collector);
        ServiceManager.aslPropertyManager.valueChangedBoolean(10122, false);
        ServiceManager.aslPropertyManager.valueChangedBoolean(10123, false);
        this.info().append("CAR: requesting diagnostic ...").log();
        ServiceManager.adaptionApi.requestCarFuncAdap(this);
    }

    private void evaluatingMenuOperation(CarFuncAdap carFuncAdap) {
        this.configManPersCarFuncAdapImpl = carFuncAdap;
        ServiceManager.aslPropertyManager.valueChangedBoolean(10120, this.configManPersCarFuncAdapImpl.getBoolean(360));
        ServiceManager.aslPropertyManager.valueChangedBoolean(10116, this.configManPersCarFuncAdapImpl.getBoolean(240));
        ServiceManager.aslPropertyManager.valueChangedBoolean(10119, this.configManPersCarFuncAdapImpl.getBoolean(240));
        ServiceManager.aslPropertyManager.valueChangedBoolean(10118, this.configManPersCarFuncAdapImpl.getBoolean(240));
        ServiceManager.aslPropertyManager.valueChangedBoolean(10117, this.configManPersCarFuncAdapImpl.getBoolean(240));
        ServiceManager.aslPropertyManager.valueChangedBoolean(10165, this.configManPersCarFuncAdapImpl.getBoolean(200));
        ServiceManager.aslPropertyManager.valueChangedBoolean(10275, this.configManPersCarFuncAdapImpl.getBoolean(275));
        ServiceManager.aslPropertyManager.valueChangedBoolean(10132, true);
        EarlyInitASLTarget.writeIntegerToDatapool(10277, 0);
        this.info().append("EARLY INIT: BC is coded? ").append(this.configManPersCarFuncAdapImpl.getBoolean(240)).log();
        this.info().append("CAR: diagnostic ... Done! ").log();
        if (ServiceManager.configManagerDiag.isFeatureFlagSet(394)) {
            ServiceManager.aslPropertyManager.valueChangedBoolean(10359, true);
        } else if (ASLSystemFactory.getSystemApi().getFeatureFlagValuePHEV()) {
            ServiceManager.aslPropertyManager.valueChangedBoolean(10359, true);
        } else if (ASLSystemFactory.getSystemApi().getFeatureFlagValueBEV()) {
            ServiceManager.aslPropertyManager.valueChangedBoolean(10359, false);
        }
        this.info().append("EARLY_INIT: PrimaryEngine: ").append(ASLSystemFactory.getSystemApi().getPrimaryEngineType()).append(" SecondaryEngine: ").append(ASLSystemFactory.getSystemApi().getSecondaryEngineType()).log();
        ASLCarUtil.evaluatePrimaryEngineType(ASLSystemFactory.getSystemApi().getPrimaryEngineType());
        ASLCarUtil.evaluateSecondaryEngineType(ASLSystemFactory.getSystemApi().getSecondaryEngineType());
    }

    @Override
    public void onSuccess(Access access) {
        this.evaluatingMenuOperation((CarFuncAdap)access);
    }

    @Override
    public void onError() {
        if (this.isTraceEnabled()) {
            ASLFrameworkFactory.getASLFrameworkAPI().getASLLogger().error(1, "EarlyInitASLTarget: Error requesting car function adapter");
        }
    }

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError().initCause(classNotFoundException);
        }
    }
}

