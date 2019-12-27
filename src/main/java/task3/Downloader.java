package task3;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class Downloader implements Runnable {

    private String url;

    private String pathToWrite;

    public Downloader(String url, String pathToWrite) {
        this.url = url;
        this.pathToWrite = pathToWrite;
    }

    public void run() {
        URL url = null;
        try (BufferedInputStream in = new BufferedInputStream(new URL(this.url).openStream());
             FileOutputStream fileOutputStream= new FileOutputStream(pathToWrite)) {
            byte[] dataBuffer = new byte[1024];
            int bytesRead;
            while ((bytesRead = in.read(dataBuffer, 0, 1024)) != -1) {
                fileOutputStream.write(dataBuffer, 0, bytesRead);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
        /*try {
         *//*   url = new URL(this.url);
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            httpURLConnection.setRequestMethod("GET");
            httpURLConnection.connect();
            InputStream inputStream = httpURLConnection.getInputStream();
            byte[] buff = new byte[inputStream.available()];
            inputStream.read(buff);
            inputStream.close();
            char[] chars = new char[buff.length];
            for (int i = 0; i < buff.length; i++) {
                chars[i] = (char) buff[i];
            }
            File file = new File(pathToWrite);
            FileWriter fileWriter = new FileWriter(file);
            fileWriter.write(chars);
            fileWriter.close();*//*
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }*/


}
