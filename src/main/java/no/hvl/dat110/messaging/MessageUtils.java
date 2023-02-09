package no.hvl.dat110.messaging;

import java.util.Arrays;

import no.hvl.dat110.TODO;

public class MessageUtils {
// A constant to store the size of each segment to be sent in the network
	public static final int SEGMENTSIZE = 128;

// Port and host information for the messaging process	
	public static int MESSAGINGPORT = 8080;
	public static String MESSAGINGHOST = "localhost";
// Encapsulate method to convert the message into segments
	public static byte[] encapsulate(Message message) throws Exception{
		// Check if the message object is null, throw an exception if it is
		if(message == null){
			throw new UnsupportedOperationException(TODO.method());
		}
		
		byte[] segment = null;
		byte[] data;
		
		// Get the message data from the message object
	data = message.getData();
// Check if the data obtained from the message object is null, throw an exception if it is	
		if (data == null) {
			throw new UnsupportedOperationException(TODO.method());
		}
		// Create a byte array of the size of the segment
		segment = new byte[SEGMENTSIZE];
		// Store the length of the message data at the first index of the segment
		segment[0] = (byte) data.length;
		// Copy the message data into the segment
		for (int i = 1; i <= data.length; i++) {
			segment[i] = data[i-1];
		}
			
		
		return segment;
		
	}
// Decapsulate method to convert the segments back into the message
	public static Message decapsulate(byte[] segment) throws Exception {
		// Check if the segment array is null, throw an exception if it is
		if( segment = = null) {
			throw new UnsupportedOperationException(TODO.method());
			
		}

		Message message = null;
		// Get the length of the message data from the first index of the segment
		
		int length = segment[0];
		// Create a byte array to store the message data
		
		byte[] data = new byte[length];
		// Copy the message data from the segment into the data array
		for (int i = 1; i < length + 1; i++) {
			data[i-1] = segment[i];
		}
		// Create a message object using the message data
		message = new Message(data);
		return message;
	}
}
