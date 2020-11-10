package ru.netology.domain;

public class Smartphone extends Product {
private String producer;

    public Smartphone(int id, String name, int price, String producer) {
        super(id, name, price);
        this.producer = producer;
    }

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }

    @Override
    public boolean matches(String search) {
        if (super.matches(search)) {
            return true;
        }
        if (this.producer.equalsIgnoreCase(search)) {
            return true;
        }
        return false;
    }
}
