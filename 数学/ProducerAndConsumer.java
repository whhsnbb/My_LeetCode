import java.util.LinkedList;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class ProducerAndConsumer{
    private int MAX_LEN = 10;
    private LinkedList<Integer> list = new LinkedList<>();
    private ReentrantLock lock = new ReentrantLock();
    private Condition empty = lock.newCondition();
    private Condition full = lock.newCondition();

    public static void main(String[] args) {
        ProducerAndConsumer producerAndConsumer = new ProducerAndConsumer();
        Producer producer = producerAndConsumer.new Producer();
        Consumer consumer = producerAndConsumer.new Consumer();
        new Thread(producer).start();
        new Thread(consumer).start();
    }

    class Producer implements Runnable {
        @Override
        public void run() {
            while (true) {
                lock.lock();
                    while(list.size() == MAX_LEN){
                        try {
                            full.await();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                    list.addLast(1);
                    System.out.println("生产者生产了一个产品，剩余产品数量："+list.size());
                    full.signalAll();
                    empty.signalAll();
                    lock.unlock();
            }
        }
    }

    class Consumer implements Runnable{

        @Override
        public void run() {
            while(true){
                lock.lock();
                    while(list.isEmpty()){
                        try {
                            empty.await();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                    list.pollLast();
                    System.out.println("消费者消费了一个产品，剩余产品数量："+list.size());
                    empty.signalAll();
                    full.signalAll();

                    lock.unlock();
            }
        }
    }
}
