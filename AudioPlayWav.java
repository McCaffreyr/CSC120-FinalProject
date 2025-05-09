import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;

/**
 * Program that plays the two audio files at the same time.
 */
public class AudioPlayWav {

    /**
     * Enables the two audio files to actually be played.
     * @throws UnsupportedAudioFileException if the audio file format is not supported
     * @throws IOException if an IO error occurs
     * @throws LineUnavailableException if a line cannot be opened due
     * @throws InterruptedException if the thread is interrupted
     */
    public static void playAudio(){
        try {
            File audioFile = new File("AudioLaughter.wav");
            File audioFile2 = new File("Audioscream.wav");

            AudioInputStream audioStream = AudioSystem.getAudioInputStream(audioFile);
            AudioInputStream audioStream2 = AudioSystem.getAudioInputStream(audioFile2);

            Clip clip = AudioSystem.getClip();
            Clip clip2 = AudioSystem.getClip();

            clip.open(audioStream);
            clip2.open(audioStream2);

            clip.start();
            clip2.start();

            // Wait for the clip to finish playing before continuing
            Thread.sleep(clip.getMicrosecondLength() / 1000);  // Convert microseconds to milliseconds

        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException | InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        playAudio();
    }
}
