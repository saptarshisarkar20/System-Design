package org.threads.feb12.resolveDeadLock;

class Pen {
    public synchronized void writeOnPaperWithPen(Paper paper) {
        System.out.println(Thread.currentThread().getName() + " > started to write on Paper with Pen");
        paper.finishWriting();
    }

    public synchronized void finishWriting() {
        System.out.println(Thread.currentThread().getName() + " | finish using pen");
    }
}

class Paper {
    public synchronized void writeWithPenOnPaper(Pen pen) {
        System.out.println(Thread.currentThread().getName() + " > started to write with Pen on Paper");
        pen.finishWriting();
    }

    public synchronized void finishWriting() {
        System.out.println(Thread.currentThread().getName() + " | finish using paper");
    }
}

class Task1 implements Runnable {
    private Pen pen;
    private Paper paper;

    Task1(Pen pen, Paper paper) {
        this.pen = pen;
        this.paper = paper;
    }

    @Override
    public void run() {
        synchronized (paper) {
            pen.writeOnPaperWithPen(paper);
        }
    }
}

class Task2 implements Runnable {
    private Pen pen;
    private Paper paper;

    Task2(Pen pen, Paper paper) {
        this.pen = pen;
        this.paper = paper;
    }

    @Override
    public void run() {
        synchronized (pen) {
            paper.writeWithPenOnPaper(pen);
        }
    }
}

class ResolvedDeadLockExample {
    public static void main(String[] args) {

        Pen pen = new Pen();
        Paper paper = new Paper();

        Thread t1 = new Thread(new Task1(pen, paper), "THREAD - 1");
        Thread t2 = new Thread(new Task2(pen, paper), "THREAD - 2");

        t1.start();
        t2.start();

    }


}