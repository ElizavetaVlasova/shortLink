package course.link.service;

import org.springframework.stereotype.Service;

@Service
public class LinkGenerator {
    public static final String ALPHABET = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";

    public String getRandomValue() {
        String result = "";
        for (int i = 0; i < 5; i++) {
            result +=ALPHABET.charAt((int )Math.floor(Math.random() * ALPHABET.length()));
        }
        return result;
    }
}
