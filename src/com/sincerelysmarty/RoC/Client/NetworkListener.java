/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sincerelysmarty.RoC.Client;

import com.esotericsoftware.kryonet.Connection;
import com.esotericsoftware.kryonet.Listener;
import com.esotericsoftware.minlog.Log;
import com.sincerelysmarty.RoC.Client.Packet.*;

/**
 *
 * @author 5002394184
 */
public class NetworkListener extends Listener {

    public void connected(Connection arg0) {
        Log.info("[Server] Someone is trying to connect");
    }

    public void disconnected(Connection arg0) {
        Log.info("[Server] Someone is trying to disconnect");
    }

    public void received(Connection c, Object o) {
        if (o instanceof Packet0LoginRequest) {
            Packet1LoginAnswer loginAnswer = new Packet.Packet1LoginAnswer();
            loginAnswer.accepted = true;
            c.sendTCP(o);
        }
        if (o instanceof Packet2Message) {
            String message = ((Packet2Message) o).message;
            Log.info(message);
        }
    }
}