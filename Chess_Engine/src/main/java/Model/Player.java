/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author Asus
 */
public class Player {

    private String username;
    private String sound;
    private int soundVl;
    private String theme;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getSound() {
        return sound;
    }

    public void setSound(String sound) {
        this.sound = sound;
    }

    public int getSoundVl() {
        return soundVl;
    }

    public void setSoundVl(int soundVl) {
        this.soundVl = soundVl;
    }

    public String getTheme() {
        return theme;
    }

    public void setTheme(String theme) {
        this.theme = theme;
    }

    public Player() {

    }

    public Player(String username, String sound, int soundVl, String theme) {
        this.username = username;
        this.sound = sound;
        this.soundVl = soundVl;
        this.theme = theme;
    }

    public Player(String sound, int soundVl, String theme) {

        this.sound = sound;
        this.soundVl = soundVl;
        this.theme = theme;
    }

    public Player getPlayer() {
        Player tmp = new Player();
        tmp = this;
        return tmp;
    }

    @Override
    public String toString() {
        return "Player{" + "username=" + username + ", sound=" + sound + ", soundVl=" + soundVl + ", theme=" + theme + '}';
    }

   
}
