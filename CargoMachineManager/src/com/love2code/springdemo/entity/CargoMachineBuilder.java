package com.love2code.springdemo.entity;

import com.love2code.springdemo.utils.XmlUtils;
import org.dom4j.Document;
import org.dom4j.Element;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class CargoMachineBuilder {

    private int id;

    private String name;

    private String capacity;

    private String price;

    private String capacityMapXml;

    public CargoMachineBuilder() {
    }

    public CargoMachineBuilder(
            CargoMachine cargoMachine) {
        this.id = cargoMachine.getId();
        this.name = cargoMachine.getName();
        this.capacity = cargoMachine.getCapacity().toString();
        this.price = cargoMachine.getPrice().toString();
        this.capacityMapXml = convertToXmlString(cargoMachine.getCapacityNodes());
    }

    private String convertToXmlString(Collection<CapacityItem> items) {
        if (items.isEmpty()) {
            return "<maps />";
        }
        return items.stream()
                .map(i -> String.format("<map r=\"%s\" angle=\"%s\" mass=\"%s\" />",
                        i.getRadius(), i.getAngle(), i.getMass()))
                .collect(Collectors.joining("\n", "<maps>", "\n\r</maps>"));
    }

    public CargoMachine build() {
        Document document = capacityMapXml == null || capacityMapXml.isEmpty()
                ? XmlUtils.parseXml("<maps />")
                : XmlUtils.parseXml(capacityMapXml);
        Element e = document.getRootElement();
        List elements = e.elements();
        List<CapacityItem> result = new ArrayList<>();
        for (Object o : elements) {
            Element element = (Element) o;
            String radiusStr = element.attributeValue("r");
            String angleStr = element.attributeValue("angle");
            String massStr = element.attributeValue("mass");
            result.add(new CapacityItem(new BigDecimal(radiusStr),
                    new BigDecimal(angleStr),
                    new BigDecimal(massStr)));
        }
        return new CargoMachine(id, name, new BigDecimal(capacity),
                new BigDecimal(price), result);
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

    public String getCapacity() {
        return capacity;
    }

    public void setCapacity(String capacity) {
        this.capacity = capacity;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getCapacityMapXml() {
        return capacityMapXml;
    }

    public void setCapacityMapXml(String capacityMapXml) {
        this.capacityMapXml = capacityMapXml;
    }
}
