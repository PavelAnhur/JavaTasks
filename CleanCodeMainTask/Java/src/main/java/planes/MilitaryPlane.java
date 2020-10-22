package planes;

import models.MilitaryType;

import java.util.Objects;

public class MilitaryPlane extends Plane{

    private final MilitaryType militaryTypePlane;

    public MilitaryPlane(String model, int maxSpeed, int maxFlightDistance, int maxLoadCapacity, MilitaryType militaryTypePlane) {
        super(model, maxSpeed, maxFlightDistance, maxLoadCapacity);
        this.militaryTypePlane = militaryTypePlane;
    }

    public MilitaryType getMilitaryTypePlane() {
        return militaryTypePlane;
    }

    @Override
    public String toString() {
        return super.toString().replace("}",
                ", type=" + militaryTypePlane +
                '}');
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof MilitaryPlane)) return false;
        if (!super.equals(o)) return false;
        MilitaryPlane that = (MilitaryPlane) o;
        return militaryTypePlane == that.militaryTypePlane;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), militaryTypePlane);
    }
}
