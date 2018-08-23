package com.bw.fit.system.socket.handler;

import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.WebSocketMessage;
import org.springframework.web.socket.WebSocketSession;

public class IMSocketHandler implements WebSocketHandler {

	@Override
	public void afterConnectionClosed(WebSocketSession arg0, CloseStatus arg1)
			throws Exception {
		// TODO Auto-generated method stub
		System.out.println("1");
	}

	@Override
	public void afterConnectionEstablished(WebSocketSession arg0)
			throws Exception {
		// TODO Auto-generated method stub
		System.out.println("2");
		
	}

	@Override
	public void handleMessage(WebSocketSession arg0, WebSocketMessage<?> arg1)
			throws Exception {
		// TODO Auto-generated method stub
		System.out.println("3");
		
	}

	@Override
	public void handleTransportError(WebSocketSession arg0, Throwable arg1)
			throws Exception {
		// TODO Auto-generated method stub
		System.out.println("4");
		
	}

	@Override
	public boolean supportsPartialMessages() {
		// TODO Auto-generated method stub
		System.out.println("5");
		return false;
	}

}
