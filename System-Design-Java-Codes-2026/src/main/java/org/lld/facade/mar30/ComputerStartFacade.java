package org.lld.facade.mar30;

class HDD {
    void spin() {
        System.out.println("HDD spinning");
    }
}

class CPU {
    void init() {
        System.out.println("CPU is live");
    }
}

class RAM {
    void init() {
        System.out.println("RAM is live");
    }
}

class BIOS {
    void activate(CPU cpu, RAM ram) {
        System.out.println("Bios activated");
        ram.init();
        cpu.init();
    }
}

class Display {
    void display() {
        System.out.println("Display coming up");
    }
}

public class ComputerStartFacade {
    HDD hdd;
    CPU cpu;
    RAM ram;
    BIOS bios;
    Display display;

    public ComputerStartFacade() {
        hdd = new HDD();
        cpu = new CPU();
        ram = new RAM();
        bios = new BIOS();
        display = new Display();
    }

    void StartComp() {
        hdd.spin();
        bios.activate(cpu, ram);
        display.display();
    }

}