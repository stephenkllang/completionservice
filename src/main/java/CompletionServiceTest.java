/**
 * Created by slangg on 0019, June, 19, 2016.
 * http://rdafbn.blogspot.com/2013/01/executorservice-vs-completionservice-vs.html
 */

import com.google.common.util.concurrent.*;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.*;

public class CompletionServiceTest {

    private static final int waittime = 200;
    private static final int numberOfThreadsInThePool = 5;

    private final List<String> printRequests = Arrays.asList("1", "2", "3", "4", "5", "6", "7", "8", "9", "10",
            "1", "2", "3", "4", "5", "6", "7", "8", "9", "10",
            "1", "2", "3", "4", "5", "6", "7", "8", "9", "10",
            "1", "2", "3", "4", "5", "6", "7", "8", "9", "10",
            "1", "2", "3", "4", "5", "6", "7", "8", "9", "10",
            "1", "2", "3", "4", "5", "6", "7", "8", "9", "10",
            "1", "2", "3", "4", "5", "6", "7", "8", "9", "10",
            "1", "2", "3", "4", "5", "6", "7", "8", "9", "10",
            "1", "2", "3", "4", "5", "6", "7", "8", "9", "10",
            "1", "2", "3", "4", "5", "6", "7", "8", "9", "10",
            "1", "2", "3", "4", "5", "6", "7", "8", "9", "10",
            "1", "2", "3", "4", "5", "6", "7", "8", "9", "10",
            "1", "2", "3", "4", "5", "6", "7", "8", "9", "10",
            "1", "2", "3", "4", "5", "6", "7", "8", "9", "10"
    );

    private void normalLoop() {
        for (String image : printRequests) {
            try {
                Thread.sleep(waittime);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.print(image);
        }
    }

    private void normalExecutorService() {
//        ExecutorService executor = Executors.newFixedThreadPool(numberOfThreadsInThePool);
        ListeningExecutorService executor = MoreExecutors.listeningDecorator(Executors.newFixedThreadPool(numberOfThreadsInThePool));
        try {
            Set<Future<String>> printTaskFutures = new HashSet<Future<String>>();
            for (final String printRequest : printRequests) {
//                Future<String> printer = executor.submit(new Printer(printRequest));
                ListenableFuture<String> printer = executor.submit(new Printer(printRequest));
                printTaskFutures.add(printer);
//                Futures.addCallback(printer, new FutureCallback<String>() {
//                    // we want this handler to run immediately after we push the big red button!
//                    public void onSuccess(String explosion) {
////                        walkAwayFrom(explosion);
//                    }
//
//                    public void onFailure(Throwable thrown) {
////                        battleArchNemesis(); // escaped the explosion!
//                    }
//                });
            }
            for (Future<String> future : printTaskFutures) {
                System.out.print(future.get());

            }
        } catch (Exception e) {
            Thread.currentThread().interrupt();
        } finally {
//            if (executor != null) {
                executor.shutdownNow();
//            }
        }
    }

    private void completionService() {
//        ExecutorService executor = Executors.newFixedThreadPool(numberOfThreadsInThePool);
        ListeningExecutorService executor = MoreExecutors.listeningDecorator(Executors.newFixedThreadPool(numberOfThreadsInThePool));
        ExecutorCompletionService<String> completionService = new ExecutorCompletionService<String>(executor);
        for (final String printRequest : printRequests) {
//            ListenableFuture<String> printer = completionService.submit(new Printer(printRequest));
            completionService.submit(new Printer(printRequest));
        }
        try {
            for (int t = 0, n = printRequests.size(); t < n; t++) {
                Future<String> f = completionService.take();
                System.out.print(f.get());
            }
        } catch (InterruptedException | ExecutionException e) {
            Thread.currentThread().interrupt();
        } finally {
//            if (executor != null) {
                executor.shutdownNow();
//            }
        }

    }

    private class Printer implements Callable<String> {

        private final String toPrint;

        public Printer(String toPrint) {
            this.toPrint = toPrint;
        }

        public String call() {
            try {
                Thread.sleep(waittime);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return toPrint;
        }
    }

    public static void main(String[] args) {
        System.out.println("Normal Executor Service ExecutorService");
        long start = System.currentTimeMillis();
        new CompletionServiceTest().normalExecutorService();
        System.out.println("\nExecution time : " + (System.currentTimeMillis() - start));

        System.out.println("\nCompletion Service CompletionService");
        start = System.currentTimeMillis();
        new CompletionServiceTest().completionService();
        System.out.println("\nExecution time : " + (System.currentTimeMillis() - start));

        System.out.println("\nNormal Loop");
        start = System.currentTimeMillis();
        new CompletionServiceTest().normalLoop();
        System.out.println("\nExecution time : " + (System.currentTimeMillis() - start));

    }
}