package task3;
/* Консольная утилита для скачивания файлов по HTTP
         Принимает: cписок ссылок в текстовом файле
         Действие: скачивает эти файлы и кладет в указанную папку на локальном диске.
         Должен уметь качать несколько файлов одновременно (в несколько потоков, например, 3 потока) и выдерживать указанное ограничение на скорость загрузки, например, 500 килобайт в секунду*/

import com.google.common.util.concurrent.RateLimiter;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Task3 {

    public static void main(String[] args) throws Exception {
        int numberOfThreads = 3;         // по условию 3 потока
        int speedLimit = 512000;        //ограничение в 500 кб/с
        RateLimiter rateLimiter = RateLimiter.create(speedLimit);
        rateLimiter.acquire();      //принимаем ограничение на заданное кол-во действий в сек.
        BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream("input2.txt")));
        String urls = reader.readLine();      //считываем список ссылок в текст. файле
        reader.close();
        String[] urlToDownload = urls.split(" ");
        BufferedReader reader1 = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Куда сохранить файл? ");
        String pathToWrite = reader1.readLine();
        ExecutorService service = Executors.newFixedThreadPool(numberOfThreads);
        for (String url : urlToDownload) {
            service.submit(new Downloader(url, pathToWrite));
        }
        service.shutdown();
    }

}
