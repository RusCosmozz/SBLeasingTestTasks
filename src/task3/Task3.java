package task3;
/* Консольная утилита для скачивания файлов по HTTP
         Принимает: cписок ссылок в текстовом файле
         Действие: скачивает эти файлы и кладет в указанную папку на локальном диске.
         Должен уметь качать несколько файлов одновременно (в несколько потоков, например, 3 потока) и выдерживать указанное ограничение на скорость загрузки, например, 500 килобайт в секунду*/

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;

public class Task3 {
    public static void main(String[] args) throws Exception {
        int numberOfFlows = 3;
        int speedLimit = 512000;        //ограничение в 500 кб/с
        BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream("input2.txt")));
        String urls=reader.readLine();
        reader.close();
        String[] urlToDownload=urls.split(" ");
        BufferedReader reader1=new BufferedReader(new InputStreamReader(System.in));
        for (String url:urlToDownload) {
            System.out.println("Куда сохранить файл? ");
            String pathToWrite=reader1.readLine();

        }
    }


    public byte[] download(String url) throws IOException{
        URL con=new URL(url);
        HttpURLConnection httpURLConnection= (HttpURLConnection) con.openConnection();
        httpURLConnection.setRequestMethod("GET");
        httpURLConnection.connect();
        InputStream inputStream= httpURLConnection.getInputStream();
        int buffSize=inputStream.available();
        byte[] buff=new byte[buffSize];
        inputStream.read(buff);
        inputStream.close();
        return buff;
    }
}
