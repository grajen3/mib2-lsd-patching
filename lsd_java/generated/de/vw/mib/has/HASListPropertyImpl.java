/*
 * Decompiled with CFR 0.152.
 */
package generated.de.vw.mib.has;

import de.vw.mib.has.HASDatapool;
import de.vw.mib.has.HASListProperty;
import generated.de.vw.mib.has.containers.ListStateContainer;

class HASListPropertyImpl
implements HASListProperty {
    private final int listId;
    private final String name;
    private final int actionId;
    private final int propertyId;
    private final ListStateContainer stateContainer;
    private final HASDatapool datapool;

    HASListPropertyImpl(int n, String string, int n2, int n3, ListStateContainer listStateContainer, HASDatapool hASDatapool) {
        this.listId = n;
        this.name = string;
        this.actionId = n2;
        this.propertyId = n3;
        this.stateContainer = listStateContainer;
        this.datapool = hASDatapool;
    }

    @Override
    public int getListId() {
        return this.listId;
    }

    @Override
    public String getListName() {
        return this.name;
    }

    @Override
    public int getActionId() {
        return this.actionId;
    }

    @Override
    public int getPropertyId() {
        return this.propertyId;
    }

    @Override
    public int getPageSize() {
        return this.stateContainer.getPageSize();
    }

    @Override
    public void setPageSize(int n) {
        this.stateContainer.setPageSize(n);
    }

    @Override
    public void setListSize(int n) {
        this.stateContainer.setListSize(n);
    }

    @Override
    public void setModCount(int n) {
        this.stateContainer.setModCount(n);
    }

    @Override
    public int getState() {
        return this.stateContainer.getState();
    }

    @Override
    public void setState(int n) {
        this.stateContainer.setState(n);
    }

    @Override
    public void update() {
        this.datapool.updateProperty(this.propertyId, this.stateContainer);
    }
}

