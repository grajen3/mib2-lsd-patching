/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.car.personal.api;

import de.vw.mib.asl.api.car.pso.PersonalizationAdapter;
import de.vw.mib.asl.api.car.pso.PersonalizationListener;
import de.vw.mib.asl.api.car.pso.PersonalizationService;
import de.vw.mib.asl.internal.car.personal.api.PersonalizationServiceDataSource;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class PersonalizationServiceImpl
implements PersonalizationService,
PersonalizationServiceDataSource {
    private static PersonalizationServiceImpl instance;
    private int currentResetState = 0;
    private List listeners = new ArrayList();
    private String activeDriverName = new String("Driver x");
    private int defaultProfileId;
    private boolean isActive;

    private PersonalizationServiceImpl() {
    }

    public static PersonalizationService getInstance() {
        if (instance == null) {
            instance = new PersonalizationServiceImpl();
        }
        return instance;
    }

    @Override
    public void addListener(PersonalizationListener personalizationListener) {
        if (!(personalizationListener instanceof PersonalizationAdapter)) {
            throw new IllegalArgumentException();
        }
        if (this.listeners.contains(personalizationListener)) {
            return;
        }
        this.listeners.add(personalizationListener);
    }

    @Override
    public void removeListener(PersonalizationListener personalizationListener) {
        this.listeners.remove(personalizationListener);
    }

    @Override
    public int getResetState() {
        return this.currentResetState;
    }

    @Override
    public String getActiveProfileName() {
        return this.activeDriverName;
    }

    @Override
    public int getActiveDefaultProfileId() {
        return this.defaultProfileId;
    }

    @Override
    public void setResetState(int n) {
        this.currentResetState = n;
        this.notifyOnReset(n);
    }

    @Override
    public void setActiveProfile(String string, int n) {
        this.activeDriverName = string;
        this.defaultProfileId = n;
        this.notifyOnProfile(string, n);
    }

    @Override
    public boolean getIsActive() {
        return this.isActive;
    }

    @Override
    public void setActive(boolean bl) {
        this.isActive = bl;
        this.notifyOnActive(bl);
    }

    private void notifyOnProfile(String string, int n) {
        Iterator iterator = this.listeners.iterator();
        while (iterator.hasNext()) {
            PersonalizationListener personalizationListener = (PersonalizationListener)iterator.next();
            personalizationListener.updateActiveProfile(string, n);
        }
    }

    private void notifyOnReset(int n) {
        Iterator iterator = this.listeners.iterator();
        while (iterator.hasNext()) {
            PersonalizationListener personalizationListener = (PersonalizationListener)iterator.next();
            personalizationListener.onResetStateChanged(n);
        }
    }

    private void notifyOnActive(boolean bl) {
        Iterator iterator = this.listeners.iterator();
        while (iterator.hasNext()) {
            PersonalizationListener personalizationListener = (PersonalizationListener)iterator.next();
            personalizationListener.updateActive(bl);
        }
    }

    public static PersonalizationServiceDataSource getInternalInstance() {
        if (instance == null) {
            instance = new PersonalizationServiceImpl();
        }
        return instance;
    }
}

