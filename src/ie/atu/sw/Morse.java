package ie.atu.sw;
import java.util.HashMap;

public class Morse {
	
	private HashMap<Character, String> encodeMap;
	private HashMap<String, Character> decodeMap;
	
	public Morse() {
		fillencodeMap();
		filldecodeMap();
	}
	
	// first we create the HashMap and then it adds each key-value pair to the map
		// using the "put" method.
	
	public void fillencodeMap() {
		encodeMap = new HashMap<Character, String>();
		encodeMap.put('A', ".-");
		encodeMap.put('B', "-...");
		encodeMap.put('C', "-.-.");
		encodeMap.put('D', "-..");
		encodeMap.put('E', ".");
		encodeMap.put('F', "..-.");
		encodeMap.put('G', "--.");
		encodeMap.put('H', "....");
		encodeMap.put('I', "..");
		encodeMap.put('J', ".---");
		encodeMap.put('K', "-.-");
		encodeMap.put('L', ".-..");
		encodeMap.put('M', "--");
		encodeMap.put('N', "-.");
		encodeMap.put('O', "---");
		encodeMap.put('P', ".--.");
		encodeMap.put('Q', "--.-");
		encodeMap.put('R', ".-.");
		encodeMap.put('S', "...");
		encodeMap.put('T', "-");
		encodeMap.put('U', "..-");
		encodeMap.put('V', "...-");
		encodeMap.put('W', ".--");
		encodeMap.put('X', "-..-");
		encodeMap.put('Y', "-.--");
		encodeMap.put('Z', "--..");
		encodeMap.put('1', ".----");
		encodeMap.put('2', "..---");
		encodeMap.put('3', "...--");
		encodeMap.put('4', "....-");
		encodeMap.put('5', ".....");
		encodeMap.put('6', "-....");
		encodeMap.put('7', "--...");
		encodeMap.put('8', "---..");
		encodeMap.put('9', "----.");
		encodeMap.put('0', "-----");
		encodeMap.put('.', ".-.-.-");
        encodeMap.put(',', "--..--");
        encodeMap.put('?', "..--..");
        encodeMap.put('\'', ".----.");
        encodeMap.put('!', "-.-.--");
        encodeMap.put('/', "-..-.");
        encodeMap.put('(', "-.--.");
        encodeMap.put(')', "-.--.-");
        encodeMap.put('&', ".-...");
        encodeMap.put(':', "---...");
        encodeMap.put(';', "-.-.-.");
        encodeMap.put('=', "-...-");
        encodeMap.put('+', ".-.-.");
        encodeMap.put('-', "-....-");
        encodeMap.put('_', "..--.-");
        encodeMap.put('"', ".-..-.");
        encodeMap.put('$', "...-..-");
        encodeMap.put('@', ".--.-.");
        
		
	}
	
	public void filldecodeMap() {
		decodeMap = new HashMap<String, Character>();
		decodeMap.put(".-",'A');
		decodeMap.put("-...",'B');
		decodeMap.put("-.-.",'C');
		decodeMap.put("-..",'D');
		decodeMap.put(".",'E');
		decodeMap.put("..-.",'F');
		decodeMap.put("--.",'G');
		decodeMap.put("....",'H');
		decodeMap.put("..",'I');
		decodeMap.put(".---",'J');
		decodeMap.put("-.-",'K');
		decodeMap.put(".-..",'L');
		decodeMap.put("--",'M');
		decodeMap.put("-.",'N');
		decodeMap.put("---",'O');
		decodeMap.put(".--.",'P');
		decodeMap.put("--.-",'Q');
		decodeMap.put(".-.",'R');
		decodeMap.put("...",'S');
		decodeMap.put("-",'T');
		decodeMap.put("..-",'U');
		decodeMap.put("...-",'V');
		decodeMap.put(".--",'W');
		decodeMap.put("-..-",'X');
		decodeMap.put("-.--",'Y');
		decodeMap.put("--..",'Z');
		decodeMap.put(".----",'1');
		decodeMap.put("..---",'2');
		decodeMap.put("...--",'3');
		decodeMap.put("....-",'4');
		decodeMap.put(".....",'5');
		decodeMap.put("-....",'6');
		decodeMap.put("--...",'7');
		decodeMap.put("---..",'8');
		decodeMap.put("----.",'9');
		decodeMap.put("-----",'0');
		decodeMap.put(".-.-.-",'.');
		decodeMap.put("--..--",',');
		decodeMap.put("..--..",',');
        decodeMap.put(".----.",'\'');
		decodeMap.put("-.-.--",'!');
		decodeMap.put("-..-.",'/');
		decodeMap.put("-.--.",'(');
		decodeMap.put("-.--.-",')');
		decodeMap.put(".-...",'&');
		decodeMap.put("---...",':');
		decodeMap.put("-.-.-.",';');
		decodeMap.put("-...-",'=');
		decodeMap.put(".-.-.",'+');
		decodeMap.put("-....-",'-');
		decodeMap.put("..--.-",'_');
		decodeMap.put(".-..-.",'"');
		decodeMap.put("...-..-",'$');
		decodeMap.put(".--.-.",'@');
		
	}
	
	public String decode(String encode) {
	    // Split the encoded string into individual characters.
	    String[] encodedChars = encode.split(" ");

	    // Initialize an empty string to store the decoded result.
	    StringBuilder decoded = new StringBuilder();

	    // Iterate over each encoded character.
	    for (String encoded : encodedChars) {
	        // If the encoded character is a forward slash, replace it with a space in the decoded string.
	        if (encoded.equals("/")) {
	            decoded.append(" ");
	        }
	        // Otherwise, look up the corresponding decoded character in a decoder map and add it to the result.
	        else {
	            Character decodedChar = decodeMap.get(encoded);
	            decoded.append(decodedChar);
	        }
	    }

	    // Convert the decoded string builder to a regular string and return it.
	    return decoded.toString();
	}
	
	public String encodeString(String decode) {
		
	    StringBuilder encoded = new StringBuilder();
	    
	    for (char c : decode.toUpperCase().toCharArray()) {// if the character is a space, append "/" to the encoded string; 

	    	 // otherwise, append the character's encoded value (or an empty string if there is no encoded value)
	    	
	        encoded.append(c == ' ' ? "/" : encodeMap.getOrDefault(c, ""));
	        
	        encoded.append(" ");// append a space after each encoded character
	    }
	    
	    return encoded.toString();// convert the StringBuilder object to a string and return it

	}
		
	
		// This method iterates through each word in the input string, checking if its empty
				// using the is empty method if the word is not in the map the method adds a
				// slash
	
	
	
}

