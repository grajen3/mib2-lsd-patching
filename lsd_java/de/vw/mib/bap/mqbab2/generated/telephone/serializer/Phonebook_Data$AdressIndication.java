/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.mqbab2.generated.telephone.serializer;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.stream.BitStream;

public final class Phonebook_Data$AdressIndication
implements BAPEntity {
    public boolean reserved_bit_7;
    public boolean reserved_bit_6;
    public boolean businessAddressIsSuitedAsNavigationDestaination;
    public boolean businessAddressAvailable;
    public boolean privateAddressIsSuitedAsNavigationDestaination;
    public boolean privateAddressAvailable;
    public boolean defaultAddressIsSuitedAsNavigationDestaination;
    public boolean defaultAddressAvailable;

    public Phonebook_Data$AdressIndication() {
        this.internalReset();
        this.customInitialization();
    }

    public Phonebook_Data$AdressIndication(BitStream bitStream) {
        this();
        this.deserialize(bitStream);
    }

    private void internalReset() {
        this.reserved_bit_7 = false;
        this.reserved_bit_6 = false;
        this.businessAddressIsSuitedAsNavigationDestaination = false;
        this.businessAddressAvailable = false;
        this.privateAddressIsSuitedAsNavigationDestaination = false;
        this.privateAddressAvailable = false;
        this.defaultAddressIsSuitedAsNavigationDestaination = false;
        this.defaultAddressAvailable = false;
    }

    @Override
    public void reset() {
        this.internalReset();
    }

    @Override
    public boolean equalTo(BAPEntity bAPEntity) {
        Phonebook_Data$AdressIndication phonebook_Data$AdressIndication = (Phonebook_Data$AdressIndication)bAPEntity;
        return this.reserved_bit_7 == phonebook_Data$AdressIndication.reserved_bit_7 && this.reserved_bit_6 == phonebook_Data$AdressIndication.reserved_bit_6 && this.businessAddressIsSuitedAsNavigationDestaination == phonebook_Data$AdressIndication.businessAddressIsSuitedAsNavigationDestaination && this.businessAddressAvailable == phonebook_Data$AdressIndication.businessAddressAvailable && this.privateAddressIsSuitedAsNavigationDestaination == phonebook_Data$AdressIndication.privateAddressIsSuitedAsNavigationDestaination && this.privateAddressAvailable == phonebook_Data$AdressIndication.privateAddressAvailable && this.defaultAddressIsSuitedAsNavigationDestaination == phonebook_Data$AdressIndication.defaultAddressIsSuitedAsNavigationDestaination && this.defaultAddressAvailable == phonebook_Data$AdressIndication.defaultAddressAvailable;
    }

    private void customInitialization() {
    }

    @Override
    public String toString() {
        return "AdressIndication:";
    }

    @Override
    public int bitSize() {
        return 0;
    }

    @Override
    public void serialize(BitStream bitStream) {
        bitStream.pushBoolean(this.reserved_bit_7);
        bitStream.pushBoolean(this.reserved_bit_6);
        bitStream.pushBoolean(this.businessAddressIsSuitedAsNavigationDestaination);
        bitStream.pushBoolean(this.businessAddressAvailable);
        bitStream.pushBoolean(this.privateAddressIsSuitedAsNavigationDestaination);
        bitStream.pushBoolean(this.privateAddressAvailable);
        bitStream.pushBoolean(this.defaultAddressIsSuitedAsNavigationDestaination);
        bitStream.pushBoolean(this.defaultAddressAvailable);
    }

    @Override
    public void deserialize(BitStream bitStream) {
    }
}

