package org.lld.behavioral.mediator;

import java.util.ArrayList;
import java.util.List;

interface IMediator {
    void registerCollege(Colleague c);

    void send(String from, String msg);

    void sendPrivate(String from, String to, String msg);
}

abstract class Colleague {
    IMediator mediator;

    Colleague(IMediator mediator) {
        this.mediator = mediator;
        mediator.registerCollege(this);
    }

    abstract String getName();

    abstract void send(String msg);

    abstract void sendPrivate(String to, String msg);

    abstract void receive(String from, String msg);
}

class Pair {
    String muter;
    String muted;

    Pair(String muter, String muted) {
        this.muter = muter;
        this.muted = muted;
    }

    String getMuter() {
        return muter;
    }

    void setMuter(String muter) {
        this.muter = muter;
    }

    String getMuted() {
        return muted;
    }

    void setMuted(String muted) {
        this.muted = muted;
    }
}

class ChatMediator implements IMediator {
    List<Colleague> colleagues;
    List<Pair> mutes;

    public ChatMediator() {
        this.colleagues = new ArrayList<>();
        this.mutes = new ArrayList<>();
    }

    void mute(String muter, String muted) {
        mutes.add(new Pair(muter, muted));
        System.out.println(muter + " muted 🔕 " + muted);
    }


    @Override
    public void registerCollege(Colleague c) {
        colleagues.add(c);
    }

    @Override
    public void send(String from, String msg) {
        System.out.println(from + " -> Sending Msg... " + msg);
        colleagues.stream()
                .filter(c -> !c.getName().equals(from)) // exclude me
                .filter(c -> mutes.stream()
                        .noneMatch(m -> m.getMuter().equals(c.getName())
                                && m.getMuted().equals(from))) // exclude muted)
                .forEach(c -> c.receive(from, msg));
    }

    @Override
    public void sendPrivate(String from, String to, String msg) {
        System.out.println(from + " -> " + to + " | Sending Private Msg... " + msg);

        colleagues.stream()
                .filter(c -> c.getName().equals(to)) // find receiver
                .findFirst()
                .ifPresent(c -> {
                    boolean isMuted = mutes.stream()
                            .anyMatch(p -> from.equals(p.getMuted())
                                    && to.equals(p.getMuter()));
                    if (isMuted) {
                        System.out.println("\n[Message is muted]\n");
                        return;
                    }
                    c.receive(from, msg);
                });
    }
}

class User extends Colleague {
    private String name;

    public User(String n, IMediator m) {
        super(m);
        name = n;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void send(String msg) {
        mediator.send(name, msg);
    }

    @Override
    public void sendPrivate(String to, String msg) {
        mediator.sendPrivate(name, to, msg);
    }

    @Override
    public void receive(String from, String msg) {
        System.out.println("    " + name + " got from " + from + ": " + msg);
    }
}


public class MediatorPattern {
    public static void main(String[] args) {
        ChatMediator chatRoom = new ChatMediator();

        User user1 = new User("Rohan", chatRoom);
        User user2 = new User("Neha", chatRoom);
        User user3 = new User("Mohan", chatRoom);

        // Rohan mutes Mohan
        chatRoom.mute("Rohan", "Mohan");

        // broadcast from Rohan
        user1.send("Hello Everyone!");

        // private from Mohan to Neha
        user3.sendPrivate("Neha", "Hey Neha!");
    }
}