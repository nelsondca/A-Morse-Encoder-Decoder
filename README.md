# A-Morse-Encoder-DecodeIndexer

@version Java 1.8.0_351

Description 
This project implements a Morse encoder/decoder application in Java. It allows users to encode text files into Morse code and decode Morse code back into text. The application provides a graphical user interface (GUI) for easy interaction.

Features:

Encode Text Files: Users can select a text file using a file chooser and encode its contents into Morse code.
Decode Morse Code: Users can input Morse code into the text area and decode it back into readable text.
Random Color Display: A colored square is displayed in the GUI, which changes color when clicked.
Clear and Quit: Buttons are provided to clear the text area and quit the application.
Java Classes:

Morse: This class contains methods to encode and decode text using Morse code. It also initializes HashMaps for character-to-Morse and Morse-to-character mappings.
MorseWindow: This class creates the GUI window for the application. It includes components for file selection, encode/decode buttons, colored square, text area for output, and clear/quit buttons.
Runner: This class contains the main method to launch the application.
Usage:

To run the application:

Compile all Java files.
Run the Runner class.
The GUI window will appear, allowing users to interact with the application.

To Run
From the console at .jar file directory:
Java –enable-preview -cp ./morse.jar ie.atu.sw.Runner
Then navigate to the application and Browse a document you would like to encode or decode and press either of these buttons displayed in the GUI. If no document or text file is selected nothing will happen and no output will be displayed. 

Features
•	Specify the text file to be translated.
o	Browse the Text file
•	The translation will be formatted to show word by word in the respective type of code.
•	On the Panel a Square with a color will be displayed press it to change the color.

Known Issues:

Encoding/Decoding Accuracy: The Morse code encoding/decoding logic may not be entirely accurate or may fail to handle edge cases, leading to incorrect results.
UI Responsiveness: The user interface may freeze or become unresponsive during certain operations, such as file loading or encoding/decoding large files.

