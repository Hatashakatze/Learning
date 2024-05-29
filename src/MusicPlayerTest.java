import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;

import static org.junit.jupiter.api.Assertions.*;

class MusicPlayerTest {

    private MusicPlayerGUI musicPlayerGUI;
    private MusicPlayer musicPlayer;
    private Song song;

    @BeforeEach
    void setUp() {
        musicPlayerGUI = new MusicPlayerGUI();
        song = new Song("src/assets/Tropic Fuse - French Fuse.mp3");
        musicPlayer = new MusicPlayer(musicPlayerGUI);
    }

    @Test
    void testLoadSong() {
        musicPlayer.loadSong(song);

        // Проверяем, что текущая песня установлена правильно
        assertEquals(song, musicPlayer.getCurrentSong());

        // Проверяем, что ползунок воспроизведения сброшен на 0
        assertEquals(0, musicPlayerGUI.getPlaybackSliderValue());

    }

    @Test
    void testLoadPlaylist() {
        File playlistFile = new File("src/assets/playlist.txt");
        musicPlayer.loadPlaylist(playlistFile);

        // Проверяем, что плейлист загружен правильно
        assertNotNull(musicPlayer.getCurrentSong());
        assertEquals("C:\\krill\\MP3MusicPlayer\\src\\assets\\Tropic Fuse - French Fuse.mp3", musicPlayer.getCurrentSong().getFilePath());

        // Проверяем, что ползунок воспроизведения сброшен на 0
        assertEquals(0, musicPlayerGUI.getPlaybackSliderValue());

        // Проверяем, что кнопки управления воспроизведением обновлены правильно
        assertTrue(musicPlayerGUI.isPauseButtonEnabled());
        assertFalse(musicPlayerGUI.isPlayButtonEnabled());

    }


}
