package com.love2code.springdemo.entity;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "machine_capacity")
public class CapacityItem {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "radius")
    private BigDecimal radius;

    @Column(name = "angle")
    private BigDecimal angle;

    @Column(name = "mass")
    private BigDecimal mass;

    // FK machineId

    public CapacityItem() {
    }

    public CapacityItem(
            BigDecimal radius,
            BigDecimal angle,
            BigDecimal mass) {
        this.radius = radius;
        this.angle = angle;
        this.mass = mass;
    }

    public BigDecimal getRadius() {
        return radius;
    }

    public void setRadius(BigDecimal radius) {
        this.radius = radius;
    }

    public BigDecimal getAngle() {
        return angle;
    }

    public void setAngle(BigDecimal angle) {
        this.angle = angle;
    }

    public BigDecimal getMass() {
        return mass;
    }

    public void setMass(BigDecimal mass) {
        this.mass = mass;
    }
}
