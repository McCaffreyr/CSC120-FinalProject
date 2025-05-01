import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;

public class AudioPlayWav {
    public static void main(String[] args) {
        try {
            // Specify the path to the WAV file
            File audioFile = new File("AudioLaughter.wav");
            File audioFile2 = new File("Audioscream.wav");


            // Create an AudioInputStream from the file
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(audioFile);
            AudioInputStream audioStream2 = AudioSystem.getAudioInputStream(audioFile2);


            // Get a Clip object that can play the audio
            Clip clip = AudioSystem.getClip();
            Clip clip2 = AudioSystem.getClip();


            // Open the clip with the audio stream
            clip.open(audioStream);
            clip2.open(audioStream2);

            // Start playing the audio
            clip.start();
            clip2.start();

            // Optionally, wait for the clip to finish playing before exiting
            Thread.sleep(clip.getMicrosecondLength() / 1000);  // Convert microseconds to milliseconds

        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
