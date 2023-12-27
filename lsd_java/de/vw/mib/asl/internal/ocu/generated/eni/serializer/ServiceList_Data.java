/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.ocu.generated.eni.serializer;

import de.vw.mib.asl.internal.ocu.generated.eni.serializer.ServiceList_ServiceState;
import de.vw.mib.asl.internal.ocu.generated.eni.serializer.ServiceList_UserSettings;
import de.vw.mib.bap.datatypes.ArrayHeader;
import de.vw.mib.bap.datatypes.BAPArrayElement;
import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.datatypes.BAPString;
import de.vw.mib.bap.stream.BitStream;

public final class ServiceList_Data
implements BAPArrayElement {
    private ArrayHeader arrayHeader;
    public static final int RECORD_ADDRESS_SERVICE_ID_SERVICE_NAME_SERVICE_VERSION_SERVICE_STATE_USER_SETTINGS_LICENSE_STATE_LICENSE_ID_PERIOD_OF_VALIDITY_DATE_OF_EXPIRY_DATE_OF_ACTIVATION;
    public static final int RECORD_ADDRESS_SERVICE_ID_USER_SETTINGS;
    public static final int RECORD_ADDRESS_POS;
    public static final int POS_MIN;
    public int pos;
    private static final int MAX_SERVICEID_LENGTH;
    public final BAPString serviceId;
    private static final int MAX_SERVICENAME_LENGTH;
    public final BAPString serviceName;
    private static final int MAX_SERVICEVERSION_LENGTH;
    public final BAPString serviceVersion;
    public ServiceList_ServiceState serviceState;
    public ServiceList_UserSettings userSettings;
    public static final int LICENSE_STATE_NOT_LICENSED;
    public static final int LICENSE_STATE_NOT_ACTIVATED;
    public static final int LICENSE_STATE_ACTIVATED;
    public static final int LICENSE_STATE_EXPIRED;
    public static final int LICENSE_STATE_TEMPORARY_OFFER;
    public static final int LICENSE_STATE_LICENSE_ERROR;
    public int licenseState;
    private static final int MAX_LICENSEID_LENGTH;
    public final BAPString licenseId;
    private static final int MAX_PERIODOFVALIDITY_LENGTH;
    public final BAPString periodOfValidity;
    private static final int MAX_DATEOFEXPIRY_LENGTH;
    public final BAPString dateOfExpiry;
    private static final int MAX_DATEOFACTIVATION_LENGTH;
    public final BAPString dateOfActivation;

    @Override
    public void setArrayHeader(ArrayHeader arrayHeader) {
        this.arrayHeader = arrayHeader;
    }

    @Override
    public ArrayHeader getArrayHeader() {
        return this.arrayHeader;
    }

    public ServiceList_Data(ArrayHeader arrayHeader) {
        this.arrayHeader = arrayHeader;
        this.serviceId = new BAPString(33);
        this.serviceName = new BAPString(34);
        this.serviceVersion = new BAPString(9);
        this.serviceState = new ServiceList_ServiceState();
        this.userSettings = new ServiceList_UserSettings();
        this.licenseId = new BAPString(33);
        this.periodOfValidity = new BAPString(18);
        this.dateOfExpiry = new BAPString(18);
        this.dateOfActivation = new BAPString(18);
        this.internalReset();
        this.customInitialization();
    }

    public ServiceList_Data(BitStream bitStream, ArrayHeader arrayHeader) {
        this(arrayHeader);
        this.deserialize(bitStream);
    }

    private void internalReset() {
        this.pos = 0;
        this.licenseState = 0;
    }

    @Override
    public void reset() {
        this.internalReset();
        this.arrayHeader.reset();
        this.serviceId.reset();
        this.serviceName.reset();
        this.serviceVersion.reset();
        this.serviceState.reset();
        this.userSettings.reset();
        this.licenseId.reset();
        this.periodOfValidity.reset();
        this.dateOfExpiry.reset();
        this.dateOfActivation.reset();
    }

    @Override
    public boolean equalTo(BAPEntity bAPEntity) {
        ServiceList_Data serviceList_Data = (ServiceList_Data)bAPEntity;
        return this.arrayHeader.equalTo(serviceList_Data.arrayHeader) && this.pos == serviceList_Data.pos && this.serviceId.equalTo(serviceList_Data.serviceId) && this.serviceName.equalTo(serviceList_Data.serviceName) && this.serviceVersion.equalTo(serviceList_Data.serviceVersion) && this.serviceState.equalTo(serviceList_Data.serviceState) && this.userSettings.equalTo(serviceList_Data.userSettings) && this.licenseState == serviceList_Data.licenseState && this.licenseId.equalTo(serviceList_Data.licenseId) && this.periodOfValidity.equalTo(serviceList_Data.periodOfValidity) && this.dateOfExpiry.equalTo(serviceList_Data.dateOfExpiry) && this.dateOfActivation.equalTo(serviceList_Data.dateOfActivation);
    }

    private void customInitialization() {
    }

    @Override
    public String toString() {
        return "ServiceList_Empty:";
    }

    @Override
    public int bitSize() {
        return 0;
    }

    @Override
    public void serialize(BitStream bitStream) {
        switch (this.arrayHeader.getSerializationRecordAddress()) {
            case 15: {
                this.arrayHeader.serializePosOfArrayElement(bitStream, this);
                break;
            }
            case 2: {
                this.arrayHeader.serializePosOfArrayElement(bitStream, this);
                this.serviceId.serialize(bitStream);
                this.userSettings.serialize(bitStream);
                break;
            }
            case 1: {
                this.arrayHeader.serializePosOfArrayElement(bitStream, this);
                this.serviceId.serialize(bitStream);
                this.serviceName.serialize(bitStream);
                this.serviceVersion.serialize(bitStream);
                this.serviceState.serialize(bitStream);
                this.userSettings.serialize(bitStream);
                bitStream.pushByte((byte)this.licenseState);
                this.licenseId.serialize(bitStream);
                this.periodOfValidity.serialize(bitStream);
                this.dateOfExpiry.serialize(bitStream);
                this.dateOfActivation.serialize(bitStream);
                break;
            }
        }
    }

    @Override
    public void deserialize(BitStream bitStream) {
        switch (this.arrayHeader.getSerializationRecordAddress()) {
            case 15: {
                this.arrayHeader.deserializePosOfArrayElement(bitStream, this);
                break;
            }
            case 2: {
                this.arrayHeader.deserializePosOfArrayElement(bitStream, this);
                this.serviceId.deserialize(bitStream);
                this.userSettings.deserialize(bitStream);
                break;
            }
            case 1: {
                this.arrayHeader.deserializePosOfArrayElement(bitStream, this);
                this.serviceId.deserialize(bitStream);
                this.serviceName.deserialize(bitStream);
                this.serviceVersion.deserialize(bitStream);
                this.serviceState.deserialize(bitStream);
                this.userSettings.deserialize(bitStream);
                this.licenseState = bitStream.popFrontByte();
                this.licenseId.deserialize(bitStream);
                this.periodOfValidity.deserialize(bitStream);
                this.dateOfExpiry.deserialize(bitStream);
                this.dateOfActivation.deserialize(bitStream);
                break;
            }
        }
    }

    @Override
    public void setPos(int n) {
        this.pos = n;
    }

    @Override
    public int getPos() {
        return this.pos;
    }
}

