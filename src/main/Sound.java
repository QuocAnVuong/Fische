package main;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;
import java.net.URL;

public class Sound {
    Clip clip;
    URL soundURL[] = new URL[9];
    FloatControl fc;
    int volumeScale = 3;
    float volume;

    public Sound(){
        soundURL[0] = getClass().getResource("/Sound/SonicFrontiers.wav");
        soundURL[1] = getClass().getResource("/Sound/CollectItemSoundEffect.wav");
        soundURL[2] = getClass().getResource("/Sound/FishSplashWater.wav");
        soundURL[3] = getClass().getResource("/Sound/WinningSoundEffect.wav");
        soundURL[4] = getClass().getResource("/Sound/DisappointedSE.wav");
        soundURL[5] = getClass().getResource("/Sound/cursor.wav");
        soundURL[6] = getClass().getResource("/Sound/Dice.wav");
        soundURL[7] = getClass().getResource("/Sound/steamWhistle.wav");
        soundURL[8] = getClass().getResource("/Sound/Ohno.wav");
    }
    public void setFile(int i){
        try{
            AudioInputStream ais = AudioSystem.getAudioInputStream(soundURL[i]);
            clip = AudioSystem.getClip();
            clip.open(ais);
            fc = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
            checkVolume();
        }catch (Exception e){
        }
    }
    public void play(){
        clip.start();
    }
    public void checkVolume(){
        switch (volumeScale){
            case 0:
                volume = -80f;
                break;
            case 1:
                volume = -20f;
                break;
            case 2:
                volume = -12f;
                break;
            case 3:
                volume = -5f;
                break;
            case 4:
                volume = 1f;
                break;
            case 5:
                volume = 6f;
                break;
        }
        fc.setValue(volume);
    }
    public void loop(){
        clip.loop(Clip.LOOP_CONTINUOUSLY);
    }
    public void stop(){
        clip.stop();
    }
}
