package org.lld.structural.proxy.mar31;

public class DisplayInterfaceImpl1 implements DisplayInterface1 {

    String file;

    public DisplayInterfaceImpl1(String file) {
        this.file = file;
    }

    @Override
    public void display() {
        System.out.println("[🌿] Displaying image from file -> " + file);
    }
}