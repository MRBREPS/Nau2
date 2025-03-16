package org.example;

import java.io.*;
import java.net.URL;

interface Task {
    void start();
    void stop();
}

class Task5 implements Task {
    private final String fileURL;
    private final String saveFilePath;
    private boolean running;

    public Task5(String fileURL, String saveFilePath) {
        this.fileURL = fileURL;
        this.saveFilePath = saveFilePath;
    }

    @Override
    public void start() {
        running = true;
        System.out.println("Начинается загрузка файла");
        try (BufferedInputStream in = new BufferedInputStream(new URL(fileURL).openStream());
             FileOutputStream fileOutputStream = new FileOutputStream(saveFilePath)) {
            byte[] dataBuffer = new byte[1024];
            int bytesRead;
            while ((bytesRead = in.read(dataBuffer, 0, 1024)) != -1 && running) {
                fileOutputStream.write(dataBuffer, 0, bytesRead);
            }
            System.out.println("Загрузка завершена: " + saveFilePath);
        } catch (IOException e) {
            System.err.println("Ошибка при загрузке файла: " + e.getMessage());
        }
    }

    @Override
    public void stop() {
        running = false;
        System.out.println("Загрузка остановлена");
    }
}