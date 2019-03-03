package com.love2code.springdemo.entity;


import javafx.util.Pair;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Collection;
import java.util.Map;
import java.util.NavigableMap;
import java.util.TreeMap;

@Entity
@Table(name = "cargo_machine")
public class CargoMachine {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "capacity")
    private BigDecimal capacity;

    @Column(name = "price")
    private BigDecimal price;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "machine_id")
    private Collection<CapacityItem> capacityNodes;
    /**
     * Радиус -> {Угол -> Грузоподьемность}
     */
    @Transient
    private NavigableMap<BigDecimal, NavigableMap<BigDecimal, BigDecimal>> highCapacityMap;

    private CargoMachine() {
    }

    public CargoMachine(
            int id,
            String name,
            BigDecimal capacity,
            BigDecimal price,
            Collection<CapacityItem> capacityNodes) {
        this.id = id;
        this.name = name;
        this.capacity = capacity;
        this.price = price;
        this.capacityNodes = capacityNodes;
    }

    public Pair<BigDecimal, BigDecimal> convertFrom(int x, int y) {
        BigDecimal radius = BigDecimal.valueOf(Math.sqrt(Math.pow(x, 2.0) + Math.pow(y, 2.0)));
        BigDecimal sin = BigDecimal.valueOf(y).divide(radius, 5, BigDecimal.ROUND_HALF_UP);
        BigDecimal angle = BigDecimal.valueOf(Math.toDegrees(Math.asin(sin.doubleValue())));
        return new Pair<>(radius, angle);
    }

    /**
     * углы  x0 x1 x2
     * масса y0  ? y2
     */
    public boolean canPullUp(Block block, BigDecimal bottom, BigDecimal distance) {
        initHighCapacityMap();
        Pair<BigDecimal, BigDecimal> radiusAngle = convertFrom(
                distance.intValue(), bottom.add(block.getHigh()).intValue());

        BigDecimal r1 = radiusAngle.getKey();

        BigDecimal r0 = highCapacityMap.floorEntry(r1) == null
                ? highCapacityMap.ceilingEntry(r1).getKey()
                : highCapacityMap.floorEntry(r1).getKey();

        if (highCapacityMap.ceilingKey(r1) == null) {
            return false;
        }
        BigDecimal r2 = highCapacityMap.ceilingEntry(r1).getKey();

        NavigableMap<BigDecimal, BigDecimal> r0Map = highCapacityMap.floorEntry(r1) == null
                ? highCapacityMap.ceilingEntry(r1).getValue()
                : highCapacityMap.floorEntry(r1).getValue();
        NavigableMap<BigDecimal, BigDecimal> r2Map = highCapacityMap.ceilingEntry(r1).getValue();

        BigDecimal angle = radiusAngle.getValue();

        if (r0Map.ceilingEntry(angle) == null || r0Map.floorEntry(angle) == null ||
                r2Map.ceilingEntry(angle) == null || r2Map.floorEntry(angle) == null) {
            return false;
        }
        BigDecimal y0 = interpolate(r0Map.ceilingEntry(angle), angle, r0Map.floorEntry(angle));
        Pair<BigDecimal, BigDecimal> r0y0 = new Pair<>(r0, y0);
        BigDecimal y2 = interpolate(r2Map.ceilingEntry(angle), angle, r2Map.floorEntry(angle));
        Pair<BigDecimal, BigDecimal> r2y2 = new Pair<>(r2, y2);

        BigDecimal capacity = r0.equals(r2) ? y0 : interpolate(r0y0, r1, r2y2);
        return capacity.compareTo(block.getWeigh()) >= 0;
    }

    private void initHighCapacityMap() {
        if (highCapacityMap == null) {
            highCapacityMap = new TreeMap<>();
            for (CapacityItem item : capacityNodes) {
                NavigableMap<BigDecimal, BigDecimal> angleMass = highCapacityMap.computeIfAbsent(
                        item.getRadius(), k -> new TreeMap<>());
                angleMass.put(item.getAngle(), item.getMass());
            }
        }
    }

    private BigDecimal interpolate(
            Pair<BigDecimal, BigDecimal> x0y0,
            BigDecimal x1,
            Pair<BigDecimal, BigDecimal> x2y2) {
        return interpolate(x0y0.getKey(), x0y0.getValue(), x1, x2y2.getKey(), x2y2.getValue());
    }

    private BigDecimal interpolate(
            Map.Entry<BigDecimal, BigDecimal> x0y0,
            BigDecimal x1,
            Map.Entry<BigDecimal, BigDecimal> x2y2) {
        return interpolate(x0y0.getKey(), x0y0.getValue(), x1, x2y2.getKey(), x2y2.getValue());
    }

    private BigDecimal interpolate(
            BigDecimal x0,
            BigDecimal y0,
            BigDecimal x1,
            BigDecimal x2,
            BigDecimal y2) {
        //y1 = (x1-x0)*(y2-y0)/(x2-x0) + y0
        return ((x1.subtract(x0).multiply(y2.subtract(y0)))
                .divide(x2.subtract(x0), BigDecimal.ROUND_HALF_UP))
                .add(y0);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getCapacity() {
        return capacity;
    }

    public void setCapacity(BigDecimal capacity) {
        this.capacity = capacity;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Collection<CapacityItem> getCapacityNodes() {
        return capacityNodes;
    }

    public void setCapacityNodes(Collection<CapacityItem> capacityNodes) {
        this.capacityNodes = capacityNodes;
    }

    public NavigableMap<BigDecimal, NavigableMap<BigDecimal, BigDecimal>> getHighCapacityMap() {
        return highCapacityMap;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CargoMachine machine = (CargoMachine) o;

        if (id != machine.id) return false;
        if (name != null ? !name.equals(machine.name) : machine.name != null) return false;
        if (capacity != null ? !capacity.equals(machine.capacity) : machine.capacity != null) return false;
        return !(price != null ? !price.equals(machine.price) : machine.price != null);

    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (capacity != null ? capacity.hashCode() : 0);
        result = 31 * result + (price != null ? price.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "CargoMachine{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", capacity='" + capacity + '\'' +
                ", price='" + price + '\'' +
                '}';
    }
}
