package org.lld.structural.proxy.mar31;

public class DisplayProxy1 implements DisplayInterface1 {
    DisplayInterfaceImpl1 disp;
    String file;

    public DisplayProxy1(String file) {
        this.file = file;
        disp = null;
    }

    public static void main(String[] args) {
        DisplayInterface1 disp = new DisplayProxy1("abc.jpg");
        disp.display();
    }

    @Override
    public void display() {
        if (disp == null) disp = new DisplayInterfaceImpl1(file);
        disp.display();
    }
}