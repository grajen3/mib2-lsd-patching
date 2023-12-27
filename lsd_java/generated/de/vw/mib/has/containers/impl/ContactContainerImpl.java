/*
 * Decompiled with CFR 0.152.
 */
package generated.de.vw.mib.has.containers.impl;

import generated.de.vw.mib.has.containers.AddressContainer;
import generated.de.vw.mib.has.containers.ContactContainer;
import generated.de.vw.mib.has.containers.impl.AbstractContainer;

public class ContactContainerImpl
extends AbstractContainer
implements ContactContainer {
    private static final byte ELEMENT_TELEPHONE_NUMBER;
    private static final byte ELEMENT_NAME;
    private static final byte ELEMENT_SURNAME;
    private static final byte ELEMENT_ADDRESS;
    private String attrTelephoneNumber;
    private String attrName;
    private String attrSurname;
    private AddressContainer attrAddress;

    @Override
    public int getContainerId() {
        return 8;
    }

    @Override
    public boolean isValid() {
        return true;
    }

    @Override
    public String getTelephoneNumber() {
        return this.attrTelephoneNumber;
    }

    @Override
    public String getName() {
        return this.attrName;
    }

    @Override
    public String getSurname() {
        return this.attrSurname;
    }

    @Override
    public AddressContainer getAddress() {
        return this.attrAddress;
    }

    @Override
    public boolean isTelephoneNumberSet() {
        return this._isElementSet((byte)0);
    }

    @Override
    public boolean isNameSet() {
        return this._isElementSet((byte)1);
    }

    @Override
    public boolean isSurnameSet() {
        return this._isElementSet((byte)2);
    }

    @Override
    public boolean isAddressSet() {
        return this._isElementSet((byte)3);
    }

    @Override
    public void setTelephoneNumber(String string) {
        this.attrTelephoneNumber = string;
        this._setElement((byte)0, null != string);
    }

    @Override
    public void setName(String string) {
        this.attrName = string;
        this._setElement((byte)1, null != string);
    }

    @Override
    public void setSurname(String string) {
        this.attrSurname = string;
        this._setElement((byte)2, null != string);
    }

    @Override
    public void setAddress(AddressContainer addressContainer) {
        this.attrAddress = addressContainer;
        this._setElement((byte)3, null != addressContainer);
        if (null != addressContainer) {
            addressContainer.setElementId(34);
        }
    }

    @Override
    public void unsetTelephoneNumber() {
        this.attrTelephoneNumber = null;
        this._setElement((byte)0, false);
    }

    @Override
    public void unsetName() {
        this.attrName = null;
        this._setElement((byte)1, false);
    }

    @Override
    public void unsetSurname() {
        this.attrSurname = null;
        this._setElement((byte)2, false);
    }

    @Override
    public void unsetAddress() {
        this.attrAddress = null;
        this._setElement((byte)3, false);
    }
}

