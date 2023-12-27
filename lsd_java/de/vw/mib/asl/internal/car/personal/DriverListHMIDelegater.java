/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.car.personal;

import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.car.framework.arrays.BapArrayFactory;
import de.vw.mib.asl.internal.car.personal.BAPDataFactory;
import de.vw.mib.asl.internal.car.personal.DriverListElement;
import de.vw.mib.asl.internal.car.personal.api.PersonalizationServiceDataSource;
import de.vw.mib.bap.array.asg.ASGArrayList;
import de.vw.mib.bap.array.asg.ASGArrayListChangeNotifier;
import de.vw.mib.bap.array.asg.ASGArrayListDelegate;
import de.vw.mib.bap.array.asg.complete.ArrayListFactory;
import de.vw.mib.bap.array.requests.BAPChangedArray;
import de.vw.mib.bap.array.requests.BAPStatusArray;
import de.vw.mib.bap.datatypes.BAPArrayDataList;
import de.vw.mib.bap.datatypes.BAPArrayElement;
import generated.de.vw.mib.asl.internal.ListManager;
import org.dsi.ifc.carcomfort.DoorLockingUserListRA1;
import org.dsi.ifc.carcomfort.DoorLockingUserListUpdateInfo;

public class DriverListHMIDelegater
implements ASGArrayListChangeNotifier {
    private int totalNumListElements;
    private ASGArrayList driverProfilesList;
    private int userReference;
    private int activeUserIndex = -1;
    private String activeProfileName;
    private int activeProfileType;
    private PersonalizationServiceDataSource psoApiService;
    private static final int HIGH_LEVEL_RETRY_NUMBER_OF_RETRIES;
    private static final long HIGH_LEVEL_RETRY_RETRY_TIME;

    public DriverListHMIDelegater(ASGArrayListDelegate aSGArrayListDelegate, PersonalizationServiceDataSource personalizationServiceDataSource) {
        this.psoApiService = personalizationServiceDataSource;
        BAPDataFactory bAPDataFactory = new BAPDataFactory();
        this.driverProfilesList = new ArrayListFactory().createCompleteArrayList(aSGArrayListDelegate, this, bAPDataFactory, 1, 0, true, 4, 0);
    }

    public void updateDoorLockingUserListUpdateInfo(DoorLockingUserListUpdateInfo doorLockingUserListUpdateInfo) {
        BAPChangedArray bAPChangedArray = BapArrayFactory.getInstance().getBAPArrayConverter().convertChangedArrayUpdateInfo(doorLockingUserListUpdateInfo.startElement, doorLockingUserListUpdateInfo.getNumOfElements(), doorLockingUserListUpdateInfo.getArrayContent(), doorLockingUserListUpdateInfo.getRecordContent(), false);
        this.driverProfilesList.changedArray(bAPChangedArray);
    }

    public void updateDoorLockingUserListTotalNumberOfElements(int n) {
        this.totalNumListElements = n;
    }

    public void responseDoorLockingUserListRA1(DoorLockingUserListUpdateInfo doorLockingUserListUpdateInfo, DoorLockingUserListRA1[] doorLockingUserListRA1Array) {
        BAPStatusArray bAPStatusArray = this.convertToStatusArrayHeader(doorLockingUserListUpdateInfo);
        int n = doorLockingUserListRA1Array.length;
        for (int i2 = 0; i2 < n; ++i2) {
            bAPStatusArray.getArrayData().add(new DriverListElement(bAPStatusArray.getArrayHeader(), doorLockingUserListRA1Array[i2]));
        }
        this.driverProfilesList.statusArray(bAPStatusArray);
    }

    public void updateDoorLockingActiveUser(int n) {
        BAPArrayElement[] bAPArrayElementArray = this.driverProfilesList.getAllElements().toArray();
        if (bAPArrayElementArray.length <= 0 || this.driverProfilesList.isLoading()) {
            this.userReference = n;
            return;
        }
        boolean bl = false;
        for (int i2 = 0; i2 < bAPArrayElementArray.length; ++i2) {
            ((DriverListElement)bAPArrayElementArray[i2]).isActive = false;
            if (((DriverListElement)bAPArrayElementArray[i2]).getPos() != n) continue;
            ((DriverListElement)bAPArrayElementArray[i2]).isActive = true;
            this.activeUserIndex = i2;
            this.activeProfileName = ((DriverListElement)bAPArrayElementArray[i2]).userProfileName;
            this.activeProfileType = ((DriverListElement)bAPArrayElementArray[i2]).userType;
            bl = true;
        }
        this.userReference = n;
        if (!bl) {
            // empty if block
        }
        this.informHMI(this.driverProfilesList);
    }

    private BAPStatusArray convertToStatusArrayHeader(DoorLockingUserListUpdateInfo doorLockingUserListUpdateInfo) {
        return BapArrayFactory.getInstance().getBAPArrayConverter().convertStatusArrayResponse(doorLockingUserListUpdateInfo.getStartElement(), doorLockingUserListUpdateInfo.getNumOfElements(), doorLockingUserListUpdateInfo.getArrayContent(), doorLockingUserListUpdateInfo.getRecordContent(), doorLockingUserListUpdateInfo.getTransactionID(), doorLockingUserListUpdateInfo.getAsgID(), this.totalNumListElements);
    }

    public void renameUserProfile(int n, String string) {
        int n2 = this.getIndexOfProfilePosition(n);
        DriverListElement driverListElement = (DriverListElement)this.driverProfilesList.get(n2);
        driverListElement.userProfileName = string;
        driverListElement.userType = 0;
        this.driverProfilesList.modifyArrayElement(driverListElement, 1);
    }

    public void renameUserProfile(String string) {
        DriverListElement driverListElement = (DriverListElement)this.driverProfilesList.get(this.activeUserIndex);
        driverListElement.userProfileName = string;
        driverListElement.userType = 0;
        this.driverProfilesList.modifyArrayElement(driverListElement, 1);
    }

    private int getIndexOfProfilePosition(int n) {
        BAPArrayDataList bAPArrayDataList = this.driverProfilesList.getAllElements();
        BAPArrayElement[] bAPArrayElementArray = bAPArrayDataList.toArray();
        int n2 = 0;
        boolean bl = false;
        for (int i2 = 0; i2 < bAPArrayElementArray.length; ++i2) {
            if (((DriverListElement)bAPArrayElementArray[i2]).getPos() != n) continue;
            n2 = i2;
            bl = true;
        }
        if (!bl) {
            throw new IllegalArgumentException();
        }
        return n2;
    }

    @Override
    public void elementsInserted(ASGArrayList aSGArrayList, int n, BAPArrayDataList bAPArrayDataList) {
        this.updateDoorLockingActiveUser(this.userReference);
    }

    @Override
    public void elementsDeleted(ASGArrayList aSGArrayList, int n, BAPArrayDataList bAPArrayDataList) {
        this.updateDoorLockingActiveUser(this.userReference);
    }

    @Override
    public void elementsUpdated(ASGArrayList aSGArrayList, int n, BAPArrayDataList bAPArrayDataList) {
        this.updateDoorLockingActiveUser(this.userReference);
    }

    @Override
    public void reloaded(ASGArrayList aSGArrayList) {
        if (aSGArrayList.isLoading()) {
            return;
        }
        this.updateDoorLockingActiveUser(this.userReference);
    }

    private void informHMI(ASGArrayList aSGArrayList) {
        this.psoApiService.setActiveProfile(this.activeProfileName, this.activeProfileType);
        ServiceManager.aslPropertyManager.valueChangedString(10448, this.activeProfileName);
        ServiceManager.aslPropertyManager.valueChangedInteger(10767, this.activeUserIndex);
        ServiceManager.aslPropertyManager.valueChangedInteger(10769, this.activeProfileType);
        ListManager.getGenericASLList(10449).updateList(aSGArrayList.getAllElements().toArray());
    }
}

