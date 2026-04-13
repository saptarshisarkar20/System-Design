package org.lld.behavioral.observer;

import java.util.ArrayList;
import java.util.List;

interface ISubscriber {
    void update();
}

interface IChannel {
    void subscribe(ISubscriber sub);

    void unsubscribe(ISubscriber sub);

    void notifyAllSubs();
}

class Subscriber implements ISubscriber {
    Channel channel;
    String name;

    public Subscriber(String name, Channel channel) {
        this.channel = channel;
        this.name = name;
    }

    @Override
    public void update() {
        channel.getVideo();
    }
}


class Channel implements IChannel {

    List<ISubscriber> subscriberList;
    String name;
    String lastestVid;

    public Channel(String name) {
        this.name = name;
        subscriberList = new ArrayList<>();
    }

    @Override
    public void subscribe(ISubscriber sub) {
        subscriberList.add(sub);
    }

    @Override
    public void unsubscribe(ISubscriber sub) {
        subscriberList.remove(sub);
    }

    @Override
    public void notifyAllSubs() {
        for (ISubscriber sub : subscriberList) {
            sub.update();
        }
    }

    void uploadVid(String lastestVid) {
        this.name = name;
        this.lastestVid = lastestVid;
        System.out.println("Latest vid updated = " + name);
        notifyAllSubs();
        System.out.println("All subs notified");
    }

    String getVideo() {
        System.out.println("Latest vid = " + lastestVid);
        return lastestVid;
    }

}

public class YouTube {
    public static void main(String[] args) {
        // Create a channel and subscribers
        Channel channel = new Channel("CoderArmy");

        Subscriber subs1 = new Subscriber("Varun", channel);
        Subscriber subs2 = new Subscriber("Tarun", channel);

        // Varun and Tarun subscribe to CoderArmy
        channel.subscribe(subs1);
        channel.subscribe(subs2);

        // Upload a video: both Varun and Tarun are notified
        channel.uploadVid("Observer Pattern Tutorial");

        // Varun unsubscribes; Tarun remains subscribed
        channel.unsubscribe(subs1);

        // Upload another video: only Tarun is notified
        channel.uploadVid("Decorator Pattern Tutorial");
    }
}