package org.threads.feb14.volatileKeyword;


class SharedObj {
    private volatile boolean flag;

    SharedObj() {
        flag = false;
    }

    public void setFlagTrue() {
        flag = true;
        System.out.println("Flag is true now");
    }

    public void readFlag() {
        while (!flag) {
            // do nothing
        }
        System.out.println("Reading Flag Value : true");
    }
}

class VolatileKeyWord {
    public static void main(String[] args) {
        SharedObj obj = new SharedObj();
        Thread writer = new Thread(() -> {
            try {
                Thread.sleep(4000);
                obj.setFlagTrue();
                System.out.println("Setting flag true");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        Thread reader = new Thread(() -> {
            System.out.println("Reading flag ");
            obj.readFlag();
        });

        reader.start();
        writer.start();


    }
}