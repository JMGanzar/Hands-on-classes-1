package demoapp.service;

import org.springframework.stereotype.Service;

@Service
public class SquareService {

    public boolean isSquare(int base, int numberToCheck) {
        return Math.pow(base, 2) == numberToCheck;
    }
}