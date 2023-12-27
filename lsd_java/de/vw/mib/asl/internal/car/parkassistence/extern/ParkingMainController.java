/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.car.parkassistence.extern;

import de.vw.mib.asl.api.car.parking.ParkingServiceListener;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.car.framework.services.ServiceFactory;
import de.vw.mib.asl.internal.car.parkassistence.extern.ASLAPICarParkingAdapter;
import de.vw.mib.asl.internal.car.parkassistence.extern.ParkingPropertyMappings;
import de.vw.mib.asl.internal.car.parkassistence.extern.datapool.ParkingAdaptationDelegate;
import de.vw.mib.asl.internal.car.parkassistence.extern.datapool.ParkingAdaptationService;
import de.vw.mib.genericevents.AbstractTarget;
import generated.de.vw.mib.asl.internal.ListManager;
import generated.de.vw.mib.asl.internal.car.parkassistence.transformer.CarParkAssistenceDisplayContentCollector;

public class ParkingMainController
implements ParkingAdaptationDelegate {
    private AbstractTarget aslApiCarParkingAdapter;
    static /* synthetic */ Class class$de$vw$mib$asl$api$car$parking$ParkingServiceListener;

    public ParkingMainController(ASLAPICarParkingAdapter aSLAPICarParkingAdapter) {
        this.aslApiCarParkingAdapter = aSLAPICarParkingAdapter;
    }

    private ParkingServiceListener getParkingServiceListener() {
        return (ParkingServiceListener)ServiceFactory.getInstance().getServiceProviderRegistry().getServiceListener(class$de$vw$mib$asl$api$car$parking$ParkingServiceListener == null ? (class$de$vw$mib$asl$api$car$parking$ParkingServiceListener = ParkingMainController.class$("de.vw.mib.asl.api.car.parking.ParkingServiceListener")) : class$de$vw$mib$asl$api$car$parking$ParkingServiceListener);
    }

    @Override
    public void updateAdaptation(ParkingAdaptationService parkingAdaptationService, int n) {
        if (ParkingPropertyMappings.getBoolPropertyMappings().containsKey(n)) {
            int n2 = ParkingPropertyMappings.getBoolPropertyMappings().get(n);
            boolean bl = parkingAdaptationService.getBoolPropertyValue(n);
            boolean bl2 = parkingAdaptationService.getBoolPropertyValue(n2);
            if (bl2 != bl) {
                ServiceManager.aslPropertyManager.valueChangedBoolean(ParkingPropertyMappings.getBoolPropertyMappings().get(n), bl);
            }
        } else if (ParkingPropertyMappings.getIntPropertyMappings().containsKey(n)) {
            int n3;
            int n4 = parkingAdaptationService.getIntPropertyValue(n);
            if (n4 != (n3 = parkingAdaptationService.getIntPropertyValue(ParkingPropertyMappings.getIntPropertyMappings().get(n)))) {
                ServiceManager.aslPropertyManager.valueChangedInteger(ParkingPropertyMappings.getIntPropertyMappings().get(n), n4);
            }
        } else if (ParkingPropertyMappings.getArrayPropertyMappings().containsKey(n)) {
            int[] nArray;
            int[] nArray2 = parkingAdaptationService.getArrayPropertyValue(n);
            if (!nArray2.equals(nArray = parkingAdaptationService.getArrayPropertyValue(ParkingPropertyMappings.getArrayPropertyMappings().get(n)))) {
                ServiceManager.aslPropertyManager.valueChangedIntegerArray(ParkingPropertyMappings.getArrayPropertyMappings().get(n), nArray2);
            }
        } else if (ParkingPropertyMappings.getListPropertyMappings().containsKey(n)) {
            Object[] objectArray = parkingAdaptationService.getListPropertyValue(n);
            Object[] objectArray2 = parkingAdaptationService.getListPropertyValue(ParkingPropertyMappings.getListPropertyMappings().get(n));
            int n5 = ParkingPropertyMappings.getListPropertyMappings().get(n);
        }
    }

    public void closeParking() {
        int n = ListManager.getGenericASLList(10560).getSize();
        Object[] objectArray = new Object[n];
        ListManager.getGenericASLList(10560).toArray(0, objectArray);
        CarParkAssistenceDisplayContentCollector carParkAssistenceDisplayContentCollector = (CarParkAssistenceDisplayContentCollector)objectArray[0];
        carParkAssistenceDisplayContentCollector.car_parkassistence_display_content_system = 0;
        ListManager.getGenericASLList(10560).updateList(new CarParkAssistenceDisplayContentCollector[]{carParkAssistenceDisplayContentCollector});
    }

    public void requestParkingContent() {
        int n = ListManager.getGenericASLList(10560).getSize();
        Object[] objectArray = new Object[n];
        ListManager.getGenericASLList(10560).toArray(0, objectArray);
        CarParkAssistenceDisplayContentCollector carParkAssistenceDisplayContentCollector = (CarParkAssistenceDisplayContentCollector)objectArray[0];
        carParkAssistenceDisplayContentCollector.car_parkassistence_display_content_system = 1;
        ListManager.getGenericASLList(10560).updateList(new CarParkAssistenceDisplayContentCollector[]{carParkAssistenceDisplayContentCollector});
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

