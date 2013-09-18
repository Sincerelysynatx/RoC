/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sincerelysmarty.RoC.Client;

/**
 *
 * @author 5002394184
 */
public class Packet {

    public static class Packet0LoginRequest {
    }

    public static class Packet1LoginAnswer {
        boolean accepted = false;
    }

    public static class Packet2Message {

        String message;
    }
}
