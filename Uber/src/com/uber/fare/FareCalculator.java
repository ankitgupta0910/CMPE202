package com.uber.fare;

import com.uber.request.Request;

public interface FareCalculator {
public static final int BASEFARE=5;
public int calcualteFare(Request req);
}
