package com.packt.tfesenko.java12.section2.video2_2;

import java.util.List;
import java.util.Random;
import java.util.concurrent.Executor;
import java.util.concurrent.Flow;
import java.util.concurrent.Flow.Subscription;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.SubmissionPublisher;
import java.util.concurrent.TimeUnit;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class ReactiveStreamsDemo {

    public static void main(String[] args) {
        Supplier<? extends String> randomWeatherSupplier = () -> List.of("☁️", "☀️", "⛅", "🌧", "⛈️").get(new Random().nextInt(5)) + " "
                + (new Random().nextInt(90)) + "°F";
        PeriodicPublisher<String> weatherPublisher = new PeriodicPublisher<String>(ForkJoinPool.commonPool(), 10,
                randomWeatherSupplier,
                1, TimeUnit.SECONDS);

        weatherPublisher.subscribe(new AbstractSubscriber<>("Twitter Subscriber", //
                (report) -> {
                    System.out.println("Twitting " + report);
                    try {
                        TimeUnit.MILLISECONDS.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }));

        weatherPublisher.subscribe(new AbstractSubscriber<>("Persisting Subscriber", //
                (report) -> {
                    System.out.println("Saving to database: " + report);
                    try {
                        TimeUnit.MILLISECONDS.sleep(1500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }));
    }

    public static class AbstractSubscriber<T> implements Flow.Subscriber<T> {
        private Flow.Subscription subscription;
        private String name;
        private Consumer<T> consumer;

        public AbstractSubscriber(String name, Consumer<T> consumer) {
            this.name = name;
            this.consumer = consumer;
        }

        @Override
        public void onSubscribe(Subscription subscription) {
            System.out.println(name + " subscribed!");
            this.subscription = subscription;
            subscription.request(1);
        }

        @Override
        public void onNext(T item) {
            consumer.accept(item);
            subscription.request(1);
        }

        @Override
        public void onError(Throwable throwable) {
            System.err.println(name + " got an error: " + throwable.getMessage());
        }

        @Override
        public void onComplete() {
            System.out.println(name + " completed.");
        }
    };

    /**
     * Example from the JavaDoc for java.util.concurrent.SubmissionPublisher<T>
     */
    public static class PeriodicPublisher<T> extends SubmissionPublisher<T> {
        final ScheduledFuture<?> periodicTask;
        final ScheduledExecutorService scheduler;

        PeriodicPublisher(Executor executor, int maxBufferCapacity, Supplier<? extends T> supplier, long period,
                          TimeUnit unit) {
            super(executor, maxBufferCapacity);
            scheduler = new ScheduledThreadPoolExecutor(1);
            periodicTask = scheduler.scheduleAtFixedRate(() -> submit(supplier.get()), 0, period, unit);
        }

        public void close() {
            periodicTask.cancel(false);
            scheduler.shutdown();
            super.close();
        }
    }
}
