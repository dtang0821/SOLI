import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Point3D;
import javafx.geometry.Pos;
import javafx.scene.*;
import javafx.scene.Cursor;
import javafx.scene.control.Button;
import javafx.scene.control.Slider;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.shape.Box;
import javafx.scene.shape.Sphere;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.transform.Rotate;
import javafx.scene.transform.Transform;
import javafx.scene.transform.Translate;
import javafx.stage.Stage;
import javafx.scene.paint.Color;

import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Array;
import java.text.DecimalFormat;
import java.util.ArrayList;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import static javafx.scene.text.Font.font;


//main uses javafx application
public class Main extends Application
{
    private static String tapSoundFile;
    private static String streakSoundFile;
    private static boolean isGetting = false;
    private static boolean tapChain = false;
    private static int chainCount = 1;
    private static Clip tapClip;
    private static Clip streakClip;
    private static final int SCENE_WIDTH = 1400;
    private static final int SCENE_HEIGHT = 800;
    private static String filename;
    private boolean sceneRunning = false;
    private static double totalTap=0;
    private static double sphereTap=0;
    private static double accuracyScore=100;
    private DecimalFormat df = new DecimalFormat("#.#");
    private String accuracyString;
    private static boolean timerStarted=false;
    private static double mainScore=0;
    private static double finalScore = mainScore*(1+(accuracyScore/100))*10;
    private static double eachPoint=100;
    private static boolean isMuted=false;
    private static long clipTime;
    private static boolean gameMode2Running=false;
    private static boolean gameMode3Running=false;
    private static double mainScoreFinal;
    private static double accuracyScoreFinal;
    private static double sphereTapScoreFinal;
    private static PhongMaterial material = new PhongMaterial();
    private static PhongMaterial boxmaterial1 = new PhongMaterial();
    private static PhongMaterial boxmaterial2 = new PhongMaterial();
    private static PhongMaterial playButtonmaterial = new PhongMaterial();
    private static PhongMaterial skipNextButtonmaterial = new PhongMaterial();
    private static PhongMaterial goBackButtonmaterial = new PhongMaterial();
    private static PhongMaterial loopButtonmaterial = new PhongMaterial();
    private static PhongMaterial shuffleButtonmaterial = new PhongMaterial();
    private static PhongMaterial defaultAlbummaterial = new PhongMaterial();
    private static PhongMaterial musicButtonmaterial = new PhongMaterial();
    private static PhongMaterial arrowUpmaterial = new PhongMaterial();
    private static PhongMaterial arrowDownmaterial = new PhongMaterial();
    private static PhongMaterial higlightedmusicbuttonmaterial = new PhongMaterial();
    private static PhongMaterial plusbuttonmaterial = new PhongMaterial();
    private static PhongMaterial subtractbuttonmaterial = new PhongMaterial();
    private double orgX = 0;
    private double orgY = 0;
    private static ArrayList<String>songStrings = new ArrayList<>();
    private static ArrayList<String>songStringsScroll = new ArrayList<>();
    private static ArrayList<String>albumPaths = new ArrayList<>();
    private static ArrayList<String>preSongsFile = new ArrayList<>();
    private static ArrayList<String>fullSongsFile = new ArrayList<>();
    private static ArrayList<String>albumNames = new ArrayList<>();
    private static ArrayList<String>alphabeticalSorted = new ArrayList<>();
    private static ArrayList<String>reversealphabeticalSorted = new ArrayList<>();
    private static ArrayList<String>popularitySorted = new ArrayList<>();
    private static ArrayList<String>reversepopularitySorted = new ArrayList<>();
    private static ArrayList<Box>sortButtons = new ArrayList<>();
    private static ArrayList<Text>sortText = new ArrayList<>();
    private static ArrayList<String>alphabeticalSortedAlbums = new ArrayList<>();
    private static ArrayList<String>reversealphabeticalSortedAlbums = new ArrayList<>();
    private static ArrayList<String>popularitySortedAlbums = new ArrayList<>();
    private static ArrayList<String>reversepopularitySortedAlbums = new ArrayList<>();
    private static ArrayList<String>alphabeticalSortedPRE = new ArrayList<>();
    private static ArrayList<String>reversealphabeticalSortedPRE = new ArrayList<>();
    private static ArrayList<String>popularitySortedPRE = new ArrayList<>();
    private static ArrayList<String>reversepopularitySortedPRE = new ArrayList<>();
    private static ArrayList<String>alphabeticalSortedAlbumsNames = new ArrayList<>();
    private static ArrayList<String>reversealphabeticalSortedAlbumsNames = new ArrayList<>();
    private static ArrayList<String>popularitySortedAlbumsNames = new ArrayList<>();
    private static ArrayList<String>reversepopularitySortedAlbumsNames = new ArrayList<>();
    private static ArrayList<String>playList = new ArrayList<>(15);
    private static ArrayList<String>queueList = new ArrayList<>();
    private static ArrayList<String>shuffled = new ArrayList<>();
    private static ArrayList<String>wavList = new ArrayList<>();


    private static int scrollCounter=0;
    private static int scrollCounter2=0;
    private static int musicHolder1 = 0;
    private static int musicHolder2 = 1;
    private static int musicHolder3 = 2;
    private static int musicHolder4 = 3;
    private static int musicHolder5 = 4;
    private static int musicHolder6 = 5;
    private static int musicHolder7 = 6;
    private static int musicHolder8 = 7;
    private static int musicHolder9 = 8;
    private static int musicHolder10 = 9;
    private static int musicHolder11 = 10;
    private static int musicHolder12 = 11;
    private static boolean omgPlaying=false;
    private static int scrollcountDeterminer=0;
    private static int scrollcountDeterminer2=0;
    private static Audio activeClip = null;
    private static boolean sortbuttonClicked=false;
    private static boolean isdefaultSorted=true;
    private static boolean isalphabeticalSorted=false;
    private static boolean isreversealphabeticalSorted=false;
    private static boolean ispopularitySorted=false;
    private static boolean isreversepopularitySorted=false;

    private static boolean isHighlighted1=false;
    private static boolean isHighlighted2=false;
    private static boolean isHighlighted3=false;
    private static boolean isHighlighted4=false;
    private static boolean isHighlighted5=false;
    private static boolean isHighlighted6=false;
    private static boolean isHighlighted7=false;
    private static boolean isHighlighted8=false;
    private static boolean isHighlighted9=false;
    private static boolean isHighlighted10=false;
    private static boolean isHighlighted11=false;
    private static boolean isHighlighted12=false;
    private static boolean inplayList=false;
    private static int indexCount=0;



    //3d rotating camera set up
    public static class RotateCamera extends Group {

        private final Camera camera;
        private final Rotate xRotate = new Rotate(-90, Rotate.X_AXIS);
        private final Rotate yRotate = new Rotate(0, Rotate.Y_AXIS);
        private final Rotate zRotate = new Rotate(0, Rotate.Z_AXIS);

        //initializes camera properties
        public RotateCamera() {
            buildObjects();
            camera = new PerspectiveCamera(true);
            camera.setFarClip(10000);
            camera.setNearClip(1);
            camera.setTranslateY(-2000);
            camera.getTransforms().addAll(xRotate, yRotate, zRotate);
        }

        //used for making 3d objects
        public void buildObjects() {
            try {
                Audio a = new Audio("DefaultMusic");
            }
            catch (Exception e)
            {
                System.out.println("Audio Error");
            }


            //Cupid - Fifty Fifty, Like Crazy - JIMIN, Zero - New Jeans, LOCO - ITZY,
            // Spring Day -BTS, Through The Night - IU, Thunderous - Stray Kids, SET ME FREE - Twice,
            // Vibe - TAEYANG & JIMIN, Shut Down - Blackpink, Sour Grapes - LE SSEFARIM, Anti-Romantic - TXT,
            // SOLO - JENNIE, NO PROBLEM - NAYEON & FELIX, People Pt2. - Agust D & IU
            songStrings.add("Cupid-Fifty Fifty");
            songStrings.add("Like Crazy-JIMIN");
            songStrings.add("Zero - New Jeans");
            songStrings.add("LOCO-ITZY");
            songStrings.add("Spring Day-BTS");
            songStrings.add("Through The Night-IU");
            songStrings.add("Thunderous-Stray Kids");
            songStrings.add("SET ME FREE-TWICE");
            songStrings.add("VIBE-TAEYANG & JIMIN");
            songStrings.add("Shut Down-BLACKPINK");
            songStrings.add("Sour Grapes-LE SSEFARIM");
            songStrings.add("Anti-Romantic-TXT");
            songStrings.add("SOLO-JENNIE");
            songStrings.add("NO PROBLEM-NAYEON & FELIX");
            songStrings.add("People Pt2.-Agust D & IU");

            songStringsScroll.add("Cupid-Fifty Fifty");
            songStringsScroll.add("Like Crazy-JIMIN");
            songStringsScroll.add("Zero - New Jeans");
            songStringsScroll.add("LOCO-ITZY");
            songStringsScroll.add("Spring Day-BTS");
            songStringsScroll.add("Through The Night-IU");
            songStringsScroll.add("Thunderous-Stray Kids");
            songStringsScroll.add("SET ME FREE-TWICE");
            songStringsScroll.add("VIBE-TAEYANG & JIMIN");
            songStringsScroll.add("Shut Down-BLACKPINK");
            songStringsScroll.add("Sour Grapes-LE SSEFARIM");
            songStringsScroll.add("Anti-Romantic-TXT");
            songStringsScroll.add("SOLO-JENNIE");
            songStringsScroll.add("NO PROBLEM-NAYEON & FELIX");
            songStringsScroll.add("People Pt2.-Agust D & IU");



            albumPaths.add("C:\\Users\\Dtang\\CS Projects\\zer0\\Cupid-FIFTY_FIFTY.jpg");
            albumPaths.add("C:\\Users\\Dtang\\CS Projects\\zer0\\Like_Crazy-Jimin.jpg");
            albumPaths.add("C:\\Users\\Dtang\\CS Projects\\zer0\\Zero-NewJeans.png");
            albumPaths.add("C:\\Users\\Dtang\\CS Projects\\zer0\\LOCO-ITZY.jpg");
            albumPaths.add("C:\\Users\\Dtang\\CS Projects\\zer0\\Spring_Day-BTS.png");
            albumPaths.add("C:\\Users\\Dtang\\CS Projects\\zer0\\Through_the_Night-IU.jpg");
            albumPaths.add("C:\\Users\\Dtang\\CS Projects\\zer0\\Thunderous-Stray_Kids.jpg");
            albumPaths.add("C:\\Users\\Dtang\\CS Projects\\zer0\\SET_ME_FREE-TWICE.jpg");
            albumPaths.add("C:\\Users\\Dtang\\CS Projects\\zer0\\VIBE-TAEYANG_&_JIMIN.jpg");
            albumPaths.add("C:\\Users\\Dtang\\CS Projects\\zer0\\Shut_Down-BLACKPINK.jpg");
            albumPaths.add("C:\\Users\\Dtang\\CS Projects\\zer0\\Sour_Grapes-LE SSEFARIM.jpg");
            albumPaths.add("C:\\Users\\Dtang\\CS Projects\\zer0\\Anti-Romantic-TXT.jpg");
            albumPaths.add("C:\\Users\\Dtang\\CS Projects\\zer0\\SOLO-JENNIE.jpg");
            albumPaths.add("C:\\Users\\Dtang\\CS Projects\\zer0\\NO_PROBLEM-NAYEON_&_FELIX.png");
            albumPaths.add("C:\\Users\\Dtang\\CS Projects\\zer0\\People_Pt2.-Agust_D_&_IU.jpg");

            preSongsFile.add("PRE_Cupid-FIFTY_FIFTY.wav");
            preSongsFile.add("PRE_Like_Crazy-Jimin.wav");
            preSongsFile.add("PRE_Zero_NewJeans.wav");
            preSongsFile.add("PRE_LOCO-ITZY.wav");
            preSongsFile.add("PRE_Spring_Day-BTS.wav");
            preSongsFile.add("PRE_Through_the_Night-IU.wav");
            preSongsFile.add("PRE_Thunderous-Stray_Kids.wav");
            preSongsFile.add("PRE_SET_ME_FREE-TWICE.wav");
            preSongsFile.add("PRE_VIBE-TAEYANG_&_JIMIN.wav");
            preSongsFile.add("PRE_Shut_Down-BLACKPINK.wav");
            preSongsFile.add("PRE_Sour_Grapes-LE SSEFARIM.wav");
            preSongsFile.add("PRE_Anti-Romantic-TXT.wav");
            preSongsFile.add("PRE_SOLO-JENNIE.wav");
            preSongsFile.add("PRE_NO_PROBLEM-NAYEON_&_FELIX.wav");
            preSongsFile.add("PRE_People_Pt2.-Agust_D_&_IU.wav");

            fullSongsFile.add("Cupid-FIFTY_FIFTY.wav");
            fullSongsFile.add("Like_Crazy-Jimin.wav");
            fullSongsFile.add("Zero_NewJeans.wav");
            fullSongsFile.add("LOCO-ITZY.wav");
            fullSongsFile.add("Spring_Day-BTS.wav");
            fullSongsFile.add("Through_the_Night-IU.wav");
            fullSongsFile.add("Thunderous-Stray_Kids.wav");
            fullSongsFile.add("SET_ME_FREE-TWICE.wav");
            fullSongsFile.add("VIBE-TAEYANG_&_JIMIN.wav");
            fullSongsFile.add("Shut_Down-BLACKPINK.wav");
            fullSongsFile.add("Sour_Grapes-LE SSEFARIM.wav");
            fullSongsFile.add("Anti-Romantic-TXT.wav");
            fullSongsFile.add("SOLO-JENNIE.wav");
            fullSongsFile.add("NO_PROBLEM-NAYEON_&_FELIX.wav");
            fullSongsFile.add("People_Pt2.-Agust_D_&_IU.wav");

            albumNames.add("The Beginning: Cupid");
            albumNames.add("FACE");
            albumNames.add("Zero");
            albumNames.add("CRAZY IN LOVE");
            albumNames.add("You Never Walk Alone");
            albumNames.add("Palette");
            albumNames.add("NOEASY");
            albumNames.add("READY TO BE");
            albumNames.add("VIBE");
            albumNames.add("BORN PINK");
            albumNames.add("FEARLESS");
            albumNames.add("The Chaos Chapter: FREEZE");
            albumNames.add("SOLO");
            albumNames.add("IM NAYEON");
            albumNames.add("People Pt2.");

            alphabeticalSorted.add("Cupid-Fifty Fifty");
            alphabeticalSorted.add("Like Crazy-JIMIN");
            alphabeticalSorted.add("Zero - New Jeans");
            alphabeticalSorted.add("LOCO-ITZY");
            alphabeticalSorted.add("Spring Day-BTS");
            alphabeticalSorted.add("Through The Night-IU");
            alphabeticalSorted.add("Thunderous-Stray Kids");
            alphabeticalSorted.add("SET ME FREE-TWICE");
            alphabeticalSorted.add("VIBE-TAEYANG & JIMIN");
            alphabeticalSorted.add("Shut Down-BLACKPINK");
            alphabeticalSorted.add("Sour Grapes-LE SSEFARIM");
            alphabeticalSorted.add("Anti-Romantic-TXT");
            alphabeticalSorted.add("SOLO-JENNIE");
            alphabeticalSorted.add("NO PROBLEM-NAYEON & FELIX");
            alphabeticalSorted.add("People Pt2.-Agust D & IU");

            reversealphabeticalSorted.add("Cupid-Fifty Fifty");
            reversealphabeticalSorted.add("Like Crazy-JIMIN");
            reversealphabeticalSorted.add("Zero - New Jeans");
            reversealphabeticalSorted.add("LOCO-ITZY");
            reversealphabeticalSorted.add("Spring Day-BTS");
            reversealphabeticalSorted.add("Through The Night-IU");
            reversealphabeticalSorted.add("Thunderous-Stray Kids");
            reversealphabeticalSorted.add("SET ME FREE-TWICE");
            reversealphabeticalSorted.add("VIBE-TAEYANG & JIMIN");
            reversealphabeticalSorted.add("Shut Down-BLACKPINK");
            reversealphabeticalSorted.add("Sour Grapes-LE SSEFARIM");
            reversealphabeticalSorted.add("Anti-Romantic-TXT");
            reversealphabeticalSorted.add("SOLO-JENNIE");
            reversealphabeticalSorted.add("NO PROBLEM-NAYEON & FELIX");
            reversealphabeticalSorted.add("People Pt2.-Agust D & IU");

            popularitySorted.add("Cupid-Fifty Fifty");
            popularitySorted.add("Like Crazy-JIMIN");
            popularitySorted.add("Zero - New Jeans");
            popularitySorted.add("LOCO-ITZY");
            popularitySorted.add("Spring Day-BTS");
            popularitySorted.add("Through The Night-IU");
            popularitySorted.add("Thunderous-Stray Kids");
            popularitySorted.add("SET ME FREE-TWICE");
            popularitySorted.add("VIBE-TAEYANG & JIMIN");
            popularitySorted.add("Shut Down-BLACKPINK");
            popularitySorted.add("Sour Grapes-LE SSEFARIM");
            popularitySorted.add("Anti-Romantic-TXT");
            popularitySorted.add("SOLO-JENNIE");
            popularitySorted.add("NO PROBLEM-NAYEON & FELIX");
            popularitySorted.add("People Pt2.-Agust D & IU");

            reversepopularitySorted.add("Cupid-Fifty Fifty");
            reversepopularitySorted.add("Like Crazy-JIMIN");
            reversepopularitySorted.add("Zero - New Jeans");
            reversepopularitySorted.add("LOCO-ITZY");
            reversepopularitySorted.add("Spring Day-BTS");
            reversepopularitySorted.add("Through The Night-IU");
            reversepopularitySorted.add("Thunderous-Stray Kids");
            reversepopularitySorted.add("SET ME FREE-TWICE");
            reversepopularitySorted.add("VIBE-TAEYANG & JIMIN");
            reversepopularitySorted.add("Shut Down-BLACKPINK");
            reversepopularitySorted.add("Sour Grapes-LE SSEFARIM");
            reversepopularitySorted.add("Anti-Romantic-TXT");
            reversepopularitySorted.add("SOLO-JENNIE");
            reversepopularitySorted.add("NO PROBLEM-NAYEON & FELIX");
            reversepopularitySorted.add("People Pt2.-Agust D & IU");

            playList.add(" ");
            playList.add(" ");
            playList.add(" ");
            playList.add(" ");
            playList.add(" ");
            playList.add(" ");
            playList.add(" ");
            playList.add(" ");
            playList.add(" ");
            playList.add(" ");
            playList.add(" ");
            playList.add(" ");
            playList.add(" ");
            playList.add(" ");
            playList.add(" ");

            queueList = Algorithms.shuffle(playList);



            shuffled=Algorithms.shuffle(songStrings);

//            wavList=Algorithms.fullSongList(queueList, fullSongsFile);




            alphabeticalSorted = Algorithms.sortAlphabetically(songStrings, albumNames).get(0);
            alphabeticalSortedAlbums = Algorithms.sortAlphabetically(songStrings, albumPaths).get(1);
            reversealphabeticalSorted = Algorithms.sortReverseAlphabetically(songStrings, albumNames).get(0);
            reversealphabeticalSortedAlbums = Algorithms.sortReverseAlphabetically(songStrings, albumPaths).get(1);
            popularitySorted = Algorithms.sortMostPopular(songStrings, albumNames).get(0);
            popularitySortedAlbums = Algorithms.sortMostPopular(songStrings, albumPaths).get(1);
            reversepopularitySorted = Algorithms.sortLeastPopular(songStrings, albumNames).get(0);
            reversepopularitySortedAlbums = Algorithms.sortLeastPopular(songStrings, albumPaths).get(1);
            alphabeticalSortedPRE = Algorithms.sortAlphabetically(songStrings, preSongsFile).get(1);
            reversealphabeticalSortedPRE = Algorithms.sortReverseAlphabetically(songStrings, preSongsFile).get(1);
            popularitySortedPRE = Algorithms.sortMostPopular(songStrings, preSongsFile).get(1);
            reversepopularitySortedPRE = Algorithms.sortLeastPopular(songStrings, preSongsFile).get(1);
            alphabeticalSortedAlbumsNames = Algorithms.sortAlphabetically(songStrings,albumNames).get(1);
            reversealphabeticalSortedAlbumsNames = Algorithms.sortAlphabetically(songStrings,albumNames).get(1);
            popularitySortedAlbumsNames = Algorithms.sortAlphabetically(songStrings,albumNames).get(1);
            reversepopularitySortedAlbumsNames = Algorithms.sortAlphabetically(songStrings,albumNames).get(1);













            try
            {
                Image soliImage = new Image(new FileInputStream("C:\\Users\\Dtang\\CS Projects\\zer0\\soli.png"));
                boxmaterial1.setDiffuseMap(soliImage);
            }
            catch (Exception E)
            {
                System.out.println("File Not Found");
            }
            try
            {
                Image playButtonImage = new Image(new FileInputStream("C:\\Users\\Dtang\\CS Projects\\zer0\\playButton.png"));
                playButtonmaterial.setDiffuseMap(playButtonImage);
            }
            catch (Exception E)
            {
                System.out.println("File Not Found");
            }
            try
            {
                Image skipnextImage = new Image(new FileInputStream("C:\\Users\\Dtang\\CS Projects\\zer0\\skipnextButton.png"));
                skipNextButtonmaterial.setDiffuseMap(skipnextImage);
            }
            catch (Exception E)
            {
                System.out.println("File Not Found");
            }
            try
            {
                Image gobackButtonImage = new Image(new FileInputStream("C:\\Users\\Dtang\\CS Projects\\zer0\\gobackButton.png"));
                goBackButtonmaterial.setDiffuseMap(gobackButtonImage);
            }
            catch (Exception E)
            {
                System.out.println("File Not Found");
            }
            try
            {
                Image loopButtonImage = new Image(new FileInputStream("C:\\Users\\Dtang\\CS Projects\\zer0\\loopButton.png"));
                loopButtonmaterial.setDiffuseMap(loopButtonImage);
            }
            catch (Exception E)
            {
                System.out.println("File Not Found");
            }
            try
            {
                Image shuffleButtonImage = new Image(new FileInputStream("C:\\Users\\Dtang\\CS Projects\\zer0\\shuffleButton.png"));
                shuffleButtonmaterial.setDiffuseMap(shuffleButtonImage);
            }
            catch (Exception E)
            {
                System.out.println("File Not Found");
            }
            try
            {
                Image defaultAlbumImage = new Image(new FileInputStream("C:\\Users\\Dtang\\CS Projects\\zer0\\album.png"));
                defaultAlbummaterial.setDiffuseMap(defaultAlbumImage);
            }
            catch (Exception E)
            {
                System.out.println("File Not Found");
            }
            try
            {
                Image musicButtonImage = new Image(new FileInputStream("C:\\Users\\Dtang\\CS Projects\\zer0\\musicButtons.png"));
                musicButtonmaterial.setDiffuseMap(musicButtonImage);
            }
            catch (Exception E)
            {
                System.out.println("File Not Found");
            }
            try
            {
                Image arrowUpImage = new Image(new FileInputStream("C:\\Users\\Dtang\\CS Projects\\zer0\\arrowUp.png"));
                arrowUpmaterial.setDiffuseMap(arrowUpImage);
            }
            catch (Exception E)
            {
                System.out.println("File Not Found");
            }
            try
            {
                Image arrowDownImage = new Image(new FileInputStream("C:\\Users\\Dtang\\CS Projects\\zer0\\arrowDown.png"));
                arrowDownmaterial.setDiffuseMap(arrowDownImage);
            }
            catch (Exception E)
            {
                System.out.println("File Not Found");
            }
            try
            {
                Image higlightedmusicButtonImage = new Image(new FileInputStream("C:\\Users\\Dtang\\CS Projects\\zer0\\highlightedmusicButtons.png"));
                higlightedmusicbuttonmaterial.setDiffuseMap(higlightedmusicButtonImage);
            }
            catch (Exception E)
            {
                System.out.println("File Not Found");
            }
            try
            {
                Image plusbuttonImage = new Image(new FileInputStream("C:\\Users\\Dtang\\CS Projects\\zer0\\plusButton.png"));
                plusbuttonmaterial.setDiffuseMap(plusbuttonImage);
            }
            catch (Exception E)
            {
                System.out.println("File Not Found");
            }
            try
            {
                Image subtractbuttonImage = new Image(new FileInputStream("C:\\Users\\Dtang\\CS Projects\\zer0\\subtractButton.png"));
                subtractbuttonmaterial.setDiffuseMap(subtractbuttonImage);
            }
            catch (Exception E)
            {
                System.out.println("File Not Found");
            }


            boxmaterial1.setSpecularColor(Color.valueOf("#424242"));
            boxmaterial2.setSpecularColor(Color.valueOf("#424242"));
            boxmaterial1.setDiffuseColor(Color.WHITE);
//            boxmaterial.setSpecularColor(Color.LIGHTGRAY);
            boxmaterial2.setDiffuseColor(Color.SKYBLUE);
            playButtonmaterial.setSpecularColor(Color.valueOf("#424242"));
            skipNextButtonmaterial.setSpecularColor(Color.valueOf("#424242"));
            goBackButtonmaterial.setSpecularColor(Color.valueOf("#424242"));
            loopButtonmaterial.setSpecularColor(Color.valueOf("#424242"));
            shuffleButtonmaterial.setSpecularColor(Color.valueOf("#424242"));
            defaultAlbummaterial.setSpecularColor(Color.valueOf("#424242"));
            musicButtonmaterial.setSpecularColor(Color.valueOf("#424242"));
            arrowDownmaterial.setSpecularColor(Color.valueOf("#424242"));
            arrowUpmaterial.setSpecularColor(Color.valueOf("#424242"));

            playButtonmaterial.setDiffuseColor(Color.WHITE);
            skipNextButtonmaterial.setDiffuseColor(Color.WHITE);
            goBackButtonmaterial.setDiffuseColor(Color.WHITE);
            loopButtonmaterial.setDiffuseColor(Color.WHITE);
            shuffleButtonmaterial.setDiffuseColor(Color.WHITE);
            defaultAlbummaterial.setDiffuseColor(Color.WHITE);
            musicButtonmaterial.setDiffuseColor(Color.WHITE);
            arrowDownmaterial.setDiffuseColor(Color.WHITE);
            arrowUpmaterial.setDiffuseColor(Color.WHITE);

//            Slider musicSlider = new Slider(10,100,50);
//            musicSlider.setTranslateX(-1500);
//            musicSlider.setTranslateY(-200);
//            musicSlider.setTranslateZ(-2000);

//            VBox musicGrid = new VBox();
//            musicGrid.setAlignment(Pos.CENTER_RIGHT);
//            musicGrid.setTranslateX(0);
//            musicGrid.setTranslateZ(0);
//            musicGrid.setTranslateY(-3500);
//            musicGrid.getChildren().addAll();






            Box screen1 = new Box(700,700,20);
            screen1.setTranslateX(0);
            screen1.setTranslateZ(0);
            screen1.setTranslateY(-500);
            screen1.setMaterial(boxmaterial1);

            Box screen2 = new Box(700,700,20);
            screen2.setTranslateX(0);
            screen2.setTranslateZ(0);
            screen2.setTranslateY(-3500);
            screen2.setMaterial(boxmaterial2);

            //this is the playing music screen where you can pause and play
            Box screen3 = new Box(700,700,20);
            screen3.setTranslateX(-1500);
            screen3.setTranslateZ(0);
            screen3.setTranslateY(-2000);
            screen3.setMaterial(boxmaterial2);

            Box screen4 = new Box(700,700,20);
            screen4.setTranslateX(1500);
            screen4.setTranslateZ(0);
            screen4.setTranslateY(-2000);
            screen4.setMaterial(boxmaterial2);

            Box playButton = new Box(130,130,20);
            playButton.setTranslateX(-1490);
            playButton.setTranslateZ(-150);
            playButton.setTranslateY(-2000);
            playButton.setMaterial(playButtonmaterial);

            Box skipnextButton = new Box(100,100,20);
            skipnextButton.setTranslateX(-1490);
            skipnextButton.setTranslateZ(-150);
            skipnextButton.setTranslateY(-1877.5);
            skipnextButton.setMaterial(skipNextButtonmaterial);

            Box gobackButton = new Box(100,100,20);
            gobackButton.setTranslateX(-1490);
            gobackButton.setTranslateZ(-150);
            gobackButton.setTranslateY(-2122.5);
            gobackButton.setMaterial(goBackButtonmaterial);

            Box loopButton = new Box(100,100,20);
            loopButton.setTranslateX(-1490);
            loopButton.setTranslateZ(-150);
            loopButton.setTranslateY(-1770);
            loopButton.setMaterial(loopButtonmaterial);

            Box shuffleButton = new Box(100,100,20);
            shuffleButton.setTranslateX(-1490);
            shuffleButton.setTranslateZ(-150);
            shuffleButton.setTranslateY(-2230);
            shuffleButton.setMaterial(shuffleButtonmaterial);

            Box defaultPicture = new Box(400,400,20);
            defaultPicture.setTranslateX(-1450);
            defaultPicture.setTranslateZ(130);
            defaultPicture.setTranslateY(-2000);
            defaultPicture.setMaterial(defaultAlbummaterial);

            Box musicButton1 = new Box(300,50,20);
            musicButton1.setTranslateX(-195);
            musicButton1.setTranslateZ(260);
            musicButton1.setTranslateY(-3490);
            musicButton1.setMaterial(musicButtonmaterial);

            Box musicButton2 = new Box(300,50,20);
            musicButton2.setTranslateX(-195);
            musicButton2.setTranslateZ(210);
            musicButton2.setTranslateY(-3490);
            musicButton2.setMaterial(musicButtonmaterial);

            Box musicButton3 = new Box(300,50,20);
            musicButton3.setTranslateX(-195);
            musicButton3.setTranslateZ(160);
            musicButton3.setTranslateY(-3490);
            musicButton3.setMaterial(musicButtonmaterial);

            Box musicButton4 = new Box(300,50,20);
            musicButton4.setTranslateX(-195);
            musicButton4.setTranslateZ(110);
            musicButton4.setTranslateY(-3490);
            musicButton4.setMaterial(musicButtonmaterial);

            Box musicButton5 = new Box(300,50,20);
            musicButton5.setTranslateX(-195);
            musicButton5.setTranslateZ(60);
            musicButton5.setTranslateY(-3490);
            musicButton5.setMaterial(musicButtonmaterial);

            Box musicButton6 = new Box(300,50,20);
            musicButton6.setTranslateX(-195);
            musicButton6.setTranslateZ(10);
            musicButton6.setTranslateY(-3490);
            musicButton6.setMaterial(musicButtonmaterial);

            Box musicButton7 = new Box(300,50,20);
            musicButton7.setTranslateX(-195);
            musicButton7.setTranslateZ(-40);
            musicButton7.setTranslateY(-3490);
            musicButton7.setMaterial(musicButtonmaterial);

            Box musicButton8 = new Box(300,50,20);
            musicButton8.setTranslateX(-195);
            musicButton8.setTranslateZ(-90);
            musicButton8.setTranslateY(-3490);
            musicButton8.setMaterial(musicButtonmaterial);

            Box musicButton9 = new Box(300,50,20);
            musicButton9.setTranslateX(-195);
            musicButton9.setTranslateZ(-140);
            musicButton9.setTranslateY(-3490);
            musicButton9.setMaterial(musicButtonmaterial);

            Box musicButton10 = new Box(300,50,20);
            musicButton10.setTranslateX(-195);
            musicButton10.setTranslateZ(-190);
            musicButton10.setTranslateY(-3490);
            musicButton10.setMaterial(musicButtonmaterial);

            Box musicButton11 = new Box(300,50,20);
            musicButton11.setTranslateX(-195);
            musicButton11.setTranslateZ(-240);
            musicButton11.setTranslateY(-3490);
            musicButton11.setMaterial(musicButtonmaterial);

            Box musicButton12 = new Box(300,50,20);
            musicButton12.setTranslateX(-195);
            musicButton12.setTranslateZ(-290);
            musicButton12.setTranslateY(-3490);
            musicButton12.setMaterial(musicButtonmaterial);

            Box albumPreview = new Box(370,370,20);
            albumPreview.setTranslateX(150);
            albumPreview.setTranslateZ(100);
            albumPreview.setTranslateY(-3450);
            albumPreview.setMaterial(defaultAlbummaterial);

            Box goUpArrow = new Box(60,50,20);
            goUpArrow.setTranslateX(-230);
            goUpArrow.setTranslateZ(315);
            goUpArrow.setTranslateY(-3490);
            goUpArrow.setMaterial(arrowUpmaterial);


            Box goDownArrow = new Box(60,50,20);
            goDownArrow.setTranslateX(-310);
            goDownArrow.setTranslateZ(315);
            goDownArrow.setTranslateY(-3490);
            goDownArrow.setMaterial(arrowDownmaterial);

            Box plusButton = new Box(60,50,20);
            plusButton.setTranslateX(-1490);
            plusButton.setTranslateZ(-45);
            plusButton.setTranslateY(-1755);
            plusButton.setMaterial(plusbuttonmaterial);

            Box subtractButton = new Box(60,50,20);
            subtractButton.setTranslateX(-1490);
            subtractButton.setTranslateZ(-45);
            subtractButton.setTranslateY(-1690);
            subtractButton.setMaterial(subtractbuttonmaterial);


            //FOR THE PLAYLIST
            Box goUpArrow2 = new Box(60,47,20);
            goUpArrow2.setTranslateX(1400);
            goUpArrow2.setTranslateZ(305);
            goUpArrow2.setTranslateY(-2180);
            goUpArrow2.setMaterial(arrowUpmaterial);

            Box goDownArrow2 = new Box(60,47,20);
            goDownArrow2.setTranslateX(1400);
            goDownArrow2.setTranslateZ(305);
            goDownArrow2.setTranslateY(-2260);
            goDownArrow2.setMaterial(arrowDownmaterial);

            Box sortDropButton = new Box(300,50,20);
            sortDropButton.setTranslateX(150);
            sortDropButton.setTranslateZ(-115);
            sortDropButton.setTranslateY(-3490);
            sortDropButton.setMaterial(musicButtonmaterial);

            Box alphabeticalSortButton = new Box(300,50,20);
            alphabeticalSortButton.setTranslateX(150);
            alphabeticalSortButton.setTranslateZ(-165);
            alphabeticalSortButton.setTranslateY(-3490);
            alphabeticalSortButton.setMaterial(musicButtonmaterial);

            Box reversealphabeticalSortButton = new Box(300,50,20);
            reversealphabeticalSortButton.setTranslateX(150);
            reversealphabeticalSortButton.setTranslateZ(-215);
            reversealphabeticalSortButton.setTranslateY(-3490);
            reversealphabeticalSortButton.setMaterial(musicButtonmaterial);

            Box popularitySortButton = new Box(300,50,20);
            popularitySortButton.setTranslateX(150);
            popularitySortButton.setTranslateZ(-265);
            popularitySortButton.setTranslateY(-3490);
            popularitySortButton.setMaterial(musicButtonmaterial);

            Box reversepopularitySortButton = new Box(300,50,20);
            reversepopularitySortButton.setTranslateX(150);
            reversepopularitySortButton.setTranslateZ(-315);
            reversepopularitySortButton.setTranslateY(-3490);
            reversepopularitySortButton.setMaterial(musicButtonmaterial);


            Box playlistButton1 = new Box(300,50,20);
            playlistButton1.setTranslateX(1400);
            playlistButton1.setTranslateZ(250);
            playlistButton1.setTranslateY(-2150);
            playlistButton1.setMaterial(musicButtonmaterial);

            Box playlistButton2 = new Box(300,50,20);
            playlistButton2.setTranslateX(1400);
            playlistButton2.setTranslateZ(200);
            playlistButton2.setTranslateY(-2150);
            playlistButton2.setMaterial(musicButtonmaterial);

            Box playlistButton3 = new Box(300,50,20);
            playlistButton3.setTranslateX(1400);
            playlistButton3.setTranslateZ(150);
            playlistButton3.setTranslateY(-2150);
            playlistButton3.setMaterial(musicButtonmaterial);

            Box playlistButton4 = new Box(300,50,20);
            playlistButton4.setTranslateX(1400);
            playlistButton4.setTranslateZ(100);
            playlistButton4.setTranslateY(-2150);
            playlistButton4.setMaterial(musicButtonmaterial);

            Box playlistButton5 = new Box(300,50,20);
            playlistButton5.setTranslateX(1400);
            playlistButton5.setTranslateZ(50);
            playlistButton5.setTranslateY(-2150);
            playlistButton5.setMaterial(musicButtonmaterial);

            Box playlistButton6 = new Box(300,50,20);
            playlistButton6.setTranslateX(1400);
            playlistButton6.setTranslateZ(0);
            playlistButton6.setTranslateY(-2150);
            playlistButton6.setMaterial(musicButtonmaterial);

            Box playlistButton7 = new Box(300,50,20);
            playlistButton7.setTranslateX(1400);
            playlistButton7.setTranslateZ(-50);
            playlistButton7.setTranslateY(-2150);
            playlistButton7.setMaterial(musicButtonmaterial);

            Box playlistButton8 = new Box(300,50,20);
            playlistButton8.setTranslateX(1400);
            playlistButton8.setTranslateZ(-100);
            playlistButton8.setTranslateY(-2150);
            playlistButton8.setMaterial(musicButtonmaterial);

            Box playlistButton9 = new Box(300,50,20);
            playlistButton9.setTranslateX(1400);
            playlistButton9.setTranslateZ(-150);
            playlistButton9.setTranslateY(-2150);
            playlistButton9.setMaterial(musicButtonmaterial);

            Box playlistButton10 = new Box(300,50,20);
            playlistButton10.setTranslateX(1400);
            playlistButton10.setTranslateZ(-200);
            playlistButton10.setTranslateY(-2150);
            playlistButton10.setMaterial(musicButtonmaterial);

            Box playlistButton11 = new Box(300,50,20);
            playlistButton11.setTranslateX(1400);
            playlistButton11.setTranslateZ(-250);
            playlistButton11.setTranslateY(-2150);
            playlistButton11.setMaterial(musicButtonmaterial);

            Box playlistButton12 = new Box(300,50,20);
            playlistButton12.setTranslateX(1400);
            playlistButton12.setTranslateZ(-300);
            playlistButton12.setTranslateY(-2150);
            playlistButton12.setMaterial(musicButtonmaterial);

            Box queueButton1 = new Box(300,50,20);
            queueButton1.setTranslateX(1400);
            queueButton1.setTranslateZ(250);
            queueButton1.setTranslateY(-1835);
            queueButton1.setMaterial(musicButtonmaterial);


            Box queueButton2 = new Box(300,50,20);
            queueButton2.setTranslateX(1400);
            queueButton2.setTranslateZ(200);
            queueButton2.setTranslateY(-1835);
            queueButton2.setMaterial(musicButtonmaterial);

            Box queueButton3 = new Box(300,50,20);
            queueButton3.setTranslateX(1400);
            queueButton3.setTranslateZ(150);
            queueButton3.setTranslateY(-1835);
            queueButton3.setMaterial(musicButtonmaterial);

            Box queueButton4 = new Box(300,50,20);
            queueButton4.setTranslateX(1400);
            queueButton4.setTranslateZ(100);
            queueButton4.setTranslateY(-1835);
            queueButton4.setMaterial(musicButtonmaterial);

            Box queueButton5 = new Box(300,50,20);
            queueButton5.setTranslateX(1400);
            queueButton5.setTranslateZ(50);
            queueButton5.setTranslateY(-1835);
            queueButton5.setMaterial(musicButtonmaterial);

            Box queueButton6 = new Box(300,50,20);
            queueButton6.setTranslateX(1400);
            queueButton6.setTranslateZ(0);
            queueButton6.setTranslateY(-1835);
            queueButton6.setMaterial(musicButtonmaterial);

            Box queueButton7 = new Box(300,50,20);
            queueButton7.setTranslateX(1400);
            queueButton7.setTranslateZ(-50);
            queueButton7.setTranslateY(-1835);
            queueButton7.setMaterial(musicButtonmaterial);

            Box queueButton8 = new Box(300,50,20);
            queueButton8.setTranslateX(1400);
            queueButton8.setTranslateZ(-100);
            queueButton8.setTranslateY(-1835);
            queueButton8.setMaterial(musicButtonmaterial);

            Box queueButton9 = new Box(300,50,20);
            queueButton9.setTranslateX(1400);
            queueButton9.setTranslateZ(-150);
            queueButton9.setTranslateY(-1835);
            queueButton9.setMaterial(musicButtonmaterial);

            Box queueButton10 = new Box(300,50,20);
            queueButton10.setTranslateX(1400);
            queueButton10.setTranslateZ(-200);
            queueButton10.setTranslateY(-1835);
            queueButton10.setMaterial(musicButtonmaterial);

            Box queueButton11 = new Box(300,50,20);
            queueButton11.setTranslateX(1400);
            queueButton11.setTranslateZ(-250);
            queueButton11.setTranslateY(-1835);
            queueButton11.setMaterial(musicButtonmaterial);

            Box queueButton12 = new Box(300,50,20);
            queueButton12.setTranslateX(1400);
            queueButton12.setTranslateZ(-300);
            queueButton12.setTranslateY(-1835);
            queueButton12.setMaterial(musicButtonmaterial);





            //Button Text
            Text songsTitleText = new Text("Song List");
            songsTitleText.setTranslateX(-60);
            songsTitleText.setTranslateZ(300);
            songsTitleText.setTranslateY(-3490);
            songsTitleText.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 25));

            Text albumNameText = new Text("Album Name: ");
            albumNameText.setTranslateX(330);
            albumNameText.setTranslateZ(300);
            albumNameText.setTranslateY(-3490);
            albumNameText.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 25));

            Text albumContentsText = new Text("Default Album");
            albumContentsText.setFill(Color.RED);
            albumContentsText.setTranslateX(135);
            albumContentsText.setTranslateZ(300);
            albumContentsText.setTranslateY(-3490);
            albumContentsText.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 20));




            Text musicText1 = new Text(songStringsScroll.get(musicHolder1+scrollCounter));
            musicText1.setTranslateX(-60);
            musicText1.setTranslateZ(250);
            musicText1.setTranslateY(-3480);
            musicText1.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 16));


            Text musicText2 = new Text(songStringsScroll.get(musicHolder2+scrollCounter));
            musicText2.setTranslateX(-60);
            musicText2.setTranslateZ(200);
            musicText2.setTranslateY(-3480);
            musicText2.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 16));

            Text musicText3 = new Text(songStringsScroll.get(musicHolder3+scrollCounter));
            musicText3.setTranslateX(-60);
            musicText3.setTranslateZ(150);
            musicText3.setTranslateY(-3480);
            musicText3.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 16));

            Text musicText4 = new Text(songStringsScroll.get(musicHolder4+scrollCounter));
            musicText4.setTranslateX(-60);
            musicText4.setTranslateZ(100);
            musicText4.setTranslateY(-3480);
            musicText4.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 16));

            Text musicText5 = new Text(songStringsScroll.get(musicHolder5+scrollCounter));
            musicText5.setTranslateX(-60);
            musicText5.setTranslateZ(50);
            musicText5.setTranslateY(-3480);
            musicText5.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 16));

            Text musicText6 = new Text(songStringsScroll.get(musicHolder6+scrollCounter));
            musicText6.setTranslateX(-60);
            musicText6.setTranslateZ(0);
            musicText6.setTranslateY(-3480);
            musicText6.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 16));

            Text musicText7 = new Text(songStringsScroll.get(musicHolder7+scrollCounter));
            musicText7.setTranslateX(-60);
            musicText7.setTranslateZ(-50);
            musicText7.setTranslateY(-3480);
            musicText7.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 16));

            Text musicText8 = new Text(songStringsScroll.get(musicHolder8+scrollCounter));
            musicText8.setTranslateX(-60);
            musicText8.setTranslateZ(-100);
            musicText8.setTranslateY(-3480);
            musicText8.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 16));

            Text musicText9 = new Text(songStringsScroll.get(musicHolder9+scrollCounter));
            musicText9.setTranslateX(-60);
            musicText9.setTranslateZ(-150);
            musicText9.setTranslateY(-3480);
            musicText9.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 16));

            Text musicText10 = new Text(songStringsScroll.get(musicHolder10+scrollCounter));
            musicText10.setTranslateX(-60);
            musicText10.setTranslateZ(-200);
            musicText10.setTranslateY(-3480);
            musicText10.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 16));

            Text musicText11 = new Text(songStringsScroll.get(musicHolder11+scrollCounter));
            musicText11.setTranslateX(-60);
            musicText11.setTranslateZ(-250);
            musicText11.setTranslateY(-3480);
            musicText11.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 16));

            Text musicText12 = new Text(songStringsScroll.get(musicHolder12+scrollCounter));
            musicText12.setTranslateX(-60);
            musicText12.setTranslateZ(-300);
            musicText12.setTranslateY(-3480);
            musicText12.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 16));

            Text playListText1 = new Text(playList.get(0+scrollCounter2));
            playListText1.setTranslateX(1380);
            playListText1.setTranslateZ(250);
            playListText1.setTranslateY(-2010);
            playListText1.setFont(Font.font("verdana", FontWeight.EXTRA_LIGHT, FontPosture.REGULAR, 16));


            Text playListText2 = new Text(playList.get(1+scrollCounter2));
            playListText2.setTranslateX(1380);
            playListText2.setTranslateZ(200);
            playListText2.setTranslateY(-2010);
            playListText2.setFont(Font.font("verdana", FontWeight.EXTRA_LIGHT, FontPosture.REGULAR, 16));

            Text playListText3 = new Text(playList.get(2+scrollCounter2));
            playListText3.setTranslateX(1380);
            playListText3.setTranslateZ(150);
            playListText3.setTranslateY(-2010);
            playListText3.setFont(Font.font("verdana", FontWeight.EXTRA_LIGHT, FontPosture.REGULAR, 16));

            Text playListText4 = new Text(playList.get(3+scrollCounter2));
            playListText4.setTranslateX(1380);
            playListText4.setTranslateZ(100);
            playListText4.setTranslateY(-2010);
            playListText4.setFont(Font.font("verdana", FontWeight.EXTRA_LIGHT, FontPosture.REGULAR, 16));

            Text playListText5 = new Text(playList.get(4+scrollCounter2));
            playListText5.setTranslateX(1380);
            playListText5.setTranslateZ(50);
            playListText5.setTranslateY(-2010);
            playListText5.setFont(Font.font("verdana", FontWeight.EXTRA_LIGHT, FontPosture.REGULAR, 16));

            Text playListText6 = new Text(playList.get(5+scrollCounter2));
            playListText6.setTranslateX(1380);
            playListText6.setTranslateZ(0);
            playListText6.setTranslateY(-2010);
            playListText6.setFont(Font.font("verdana", FontWeight.EXTRA_LIGHT, FontPosture.REGULAR, 16));

            Text playListText7 = new Text(playList.get(6+scrollCounter2));
            playListText7.setTranslateX(1380);
            playListText7.setTranslateZ(-50);
            playListText7.setTranslateY(-2010);
            playListText7.setFont(Font.font("verdana", FontWeight.EXTRA_LIGHT, FontPosture.REGULAR, 16));

            Text playListText8 = new Text(playList.get(7+scrollCounter2));
            playListText8.setTranslateX(1380);
            playListText8.setTranslateZ(-100);
            playListText8.setTranslateY(-2010);
            playListText8.setFont(Font.font("verdana", FontWeight.EXTRA_LIGHT, FontPosture.REGULAR, 16));

            Text playListText9 = new Text(playList.get(8+scrollCounter2));
            playListText9.setTranslateX(1380);
            playListText9.setTranslateZ(-150);
            playListText9.setTranslateY(-2010);
            playListText9.setFont(Font.font("verdana", FontWeight.EXTRA_LIGHT, FontPosture.REGULAR, 16));

            Text playListText10 = new Text(playList.get(9+scrollCounter2));
            playListText10.setTranslateX(1380);
            playListText10.setTranslateZ(-200);
            playListText10.setTranslateY(-2010);
            playListText10.setFont(Font.font("verdana", FontWeight.EXTRA_LIGHT, FontPosture.REGULAR, 16));

            Text playListText11 = new Text(playList.get(10+scrollCounter2));
            playListText11.setTranslateX(1380);
            playListText11.setTranslateZ(-250);
            playListText11.setTranslateY(-2010);
            playListText11.setFont(Font.font("verdana", FontWeight.EXTRA_LIGHT, FontPosture.REGULAR, 16));

            Text playListText12 = new Text(playList.get(11+scrollCounter2));
            playListText12.setTranslateX(1380);
            playListText12.setTranslateZ(-300);
            playListText12.setTranslateY(-2010);
            playListText12.setFont(Font.font("verdana", FontWeight.EXTRA_LIGHT, FontPosture.REGULAR, 16));


            Text queueListText1 = new Text(queueList.get(0));
            queueListText1.setTranslateX(1380);
            queueListText1.setTranslateZ(250);
            queueListText1.setTranslateY(-1700);
            queueListText1.setFont(Font.font("verdana", FontWeight.EXTRA_LIGHT, FontPosture.REGULAR, 16));

            Text queueListText2 = new Text(queueList.get(1));
            queueListText2.setTranslateX(1380);
            queueListText2.setTranslateZ(200);
            queueListText2.setTranslateY(-1700);
            queueListText2.setFont(Font.font("verdana", FontWeight.EXTRA_LIGHT, FontPosture.REGULAR, 16));

            Text queueListText3 = new Text(queueList.get(2));
            queueListText3.setTranslateX(1380);
            queueListText3.setTranslateZ(150);
            queueListText3.setTranslateY(-1700);
            queueListText3.setFont(Font.font("verdana", FontWeight.EXTRA_LIGHT, FontPosture.REGULAR, 16));

            Text queueListText4 = new Text(queueList.get(3));
            queueListText4.setTranslateX(1380);
            queueListText4.setTranslateZ(100);
            queueListText4.setTranslateY(-1700);
            queueListText4.setFont(Font.font("verdana", FontWeight.EXTRA_LIGHT, FontPosture.REGULAR, 16));

            Text queueListText5 = new Text(queueList.get(4));
            queueListText5.setTranslateX(1380);
            queueListText5.setTranslateZ(50);
            queueListText5.setTranslateY(-1700);
            queueListText5.setFont(Font.font("verdana", FontWeight.EXTRA_LIGHT, FontPosture.REGULAR, 16));

            Text queueListText6 = new Text(queueList.get(5));
            queueListText6.setTranslateX(1380);
            queueListText6.setTranslateZ(0);
            queueListText6.setTranslateY(-1700);
            queueListText6.setFont(Font.font("verdana", FontWeight.EXTRA_LIGHT, FontPosture.REGULAR, 16));

            Text queueListText7 = new Text(queueList.get(6));
            queueListText7.setTranslateX(1380);
            queueListText7.setTranslateZ(-50);
            queueListText7.setTranslateY(-1700);
            queueListText7.setFont(Font.font("verdana", FontWeight.EXTRA_LIGHT, FontPosture.REGULAR, 16));

            Text queueListText8 = new Text(queueList.get(7));
            queueListText8.setTranslateX(1380);
            queueListText8.setTranslateZ(-100);
            queueListText8.setTranslateY(-1700);
            queueListText8.setFont(Font.font("verdana", FontWeight.EXTRA_LIGHT, FontPosture.REGULAR, 16));

            Text queueListText9 = new Text(queueList.get(8));
            queueListText9.setTranslateX(1380);
            queueListText9.setTranslateZ(-150);
            queueListText9.setTranslateY(-1700);
            queueListText9.setFont(Font.font("verdana", FontWeight.EXTRA_LIGHT, FontPosture.REGULAR, 16));

            Text queueListText10 = new Text(queueList.get(9));
            queueListText10.setTranslateX(1380);
            queueListText10.setTranslateZ(-200);
            queueListText10.setTranslateY(-1700);
            queueListText10.setFont(Font.font("verdana", FontWeight.EXTRA_LIGHT, FontPosture.REGULAR, 16));

            Text queueListText11 = new Text(queueList.get(10));
            queueListText11.setTranslateX(1380);
            queueListText11.setTranslateZ(-250);
            queueListText11.setTranslateY(-1700);
            queueListText11.setFont(Font.font("verdana", FontWeight.EXTRA_LIGHT, FontPosture.REGULAR, 16));

            Text queueListText12 = new Text(queueList.get(11));
            queueListText12.setTranslateX(1380);
            queueListText12.setTranslateZ(-300);
            queueListText12.setTranslateY(-1700);
            queueListText12.setFont(Font.font("verdana", FontWeight.EXTRA_LIGHT, FontPosture.REGULAR, 16));






            Text sortingText = new Text("Song Sorting:");
            sortingText.setTranslateX(290);
            sortingText.setTranslateZ(-115);
            sortingText.setTranslateY(-3470);
            sortingText.setFont(Font.font("verdana", FontWeight.EXTRA_LIGHT, FontPosture.REGULAR, 20));

            Text alphabeticalSortText = new Text("Alphabetical Sort");
            alphabeticalSortText.setTranslateX(290);
            alphabeticalSortText.setTranslateZ(-165);
            alphabeticalSortText.setTranslateY(-3480);
            alphabeticalSortText.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 20));

            Text reversealphabeticalSortText = new Text("Reverse Alphabetical Sort");
            reversealphabeticalSortText.setTranslateX(290);
            reversealphabeticalSortText.setTranslateZ(-215);
            reversealphabeticalSortText.setTranslateY(-3480);
            reversealphabeticalSortText.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 19));

            Text popularitySortText = new Text("Popularity Sort");
            popularitySortText.setTranslateX(290);
            popularitySortText.setTranslateZ(-265);
            popularitySortText.setTranslateY(-3480);
            popularitySortText.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 20));

            Text reversepopularitySortText = new Text("Reverse Popularity Sort");
            reversepopularitySortText.setTranslateX(290);
            reversepopularitySortText.setTranslateZ(-315);
            reversepopularitySortText.setTranslateY(-3480);
            reversepopularitySortText.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 20));

            Text queuetitleText = new Text("Song Queue:");
            queuetitleText.setTranslateX(1400);
            queuetitleText.setTranslateZ(290);
            queuetitleText.setTranslateY(-1690);
            queuetitleText.setFont(Font.font("verdana", FontWeight.EXTRA_LIGHT, FontPosture.REGULAR, 30));

            Text playlistText = new Text("Playlist:");
            playlistText.setTranslateX(1400);
            playlistText.setTranslateZ(290);
            playlistText.setTranslateY(-2000);
            playlistText.setFont(Font.font("verdana", FontWeight.EXTRA_LIGHT, FontPosture.REGULAR, 30));





//            Text musicText13 = new Text(songStrings.get(12));
//            musicText13.setTranslateX(-60);
//            musicText13.setTranslateZ(-350);
//            musicText13.setTranslateY(-3490);
//            musicText13.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 25));
//
//            Text musicText14 = new Text(songStrings.get(13));
//            musicText14.setTranslateX(-60);
//            musicText14.setTranslateZ(-400);
//            musicText14.setTranslateY(-3490);
//            musicText14.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 25));
//
//            Text musicText15 = new Text(songStrings.get(14));
//            musicText15.setTranslateX(-60);
//            musicText15.setTranslateZ(-450);
//            musicText15.setTranslateY(-3490);
//            musicText15.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 25));




            //box Transformation
            Transform boxTransform1 = new Rotate(90, new Point3D(1,0,0));
            Transform boxTransform2 = new Rotate(90, new Point3D(0,1,0));
            Transform boxTransform3 = new Rotate (180, new Point3D(0,0,1));
            Transform boxTransform4 = new Rotate (-90, new Point3D(0,0,1));
            Transform boxTransform5 = new Rotate (180, new Point3D(0,0,1));
            screen1.getTransforms().addAll(boxTransform1,boxTransform3);
            screen2.getTransforms().add(boxTransform1);
            screen3.getTransforms().add(boxTransform2);
            screen4.getTransforms().add(boxTransform2);
            playButton.getTransforms().addAll(boxTransform2,boxTransform4);
            plusButton.getTransforms().addAll(boxTransform2,boxTransform4);
            subtractButton.getTransforms().addAll(boxTransform2,boxTransform4);
            skipnextButton.getTransforms().addAll(boxTransform2,boxTransform4);
            gobackButton.getTransforms().addAll(boxTransform2,boxTransform4);
            loopButton.getTransforms().addAll(boxTransform2,boxTransform4);
            shuffleButton.getTransforms().addAll(boxTransform2,boxTransform4);
            defaultPicture.getTransforms().addAll(boxTransform2,boxTransform4);
            musicButton1.getTransforms().addAll(boxTransform1);
            musicButton2.getTransforms().addAll(boxTransform1);
            musicButton3.getTransforms().addAll(boxTransform1);
            musicButton4.getTransforms().addAll(boxTransform1);
            musicButton5.getTransforms().addAll(boxTransform1);
            musicButton6.getTransforms().addAll(boxTransform1);
            musicButton7.getTransforms().addAll(boxTransform1);
            musicButton8.getTransforms().addAll(boxTransform1);
            musicButton9.getTransforms().addAll(boxTransform1);
            musicButton10.getTransforms().addAll(boxTransform1);
            musicButton11.getTransforms().addAll(boxTransform1);
            musicButton12.getTransforms().addAll(boxTransform1);

            queueButton1.getTransforms().addAll(boxTransform2,boxTransform4);
            queueButton2.getTransforms().addAll(boxTransform2,boxTransform4);
            queueButton3.getTransforms().addAll(boxTransform2,boxTransform4);
            queueButton4.getTransforms().addAll(boxTransform2,boxTransform4);
            queueButton5.getTransforms().addAll(boxTransform2,boxTransform4);
            queueButton6.getTransforms().addAll(boxTransform2,boxTransform4);
            queueButton7.getTransforms().addAll(boxTransform2,boxTransform4);
            queueButton8.getTransforms().addAll(boxTransform2,boxTransform4);
            queueButton9.getTransforms().addAll(boxTransform2,boxTransform4);
            queueButton10.getTransforms().addAll(boxTransform2,boxTransform4);
            queueButton11.getTransforms().addAll(boxTransform2,boxTransform4);
            queueButton12.getTransforms().addAll(boxTransform2,boxTransform4);

            playlistButton1.getTransforms().addAll(boxTransform2,boxTransform4);
            playlistButton2.getTransforms().addAll(boxTransform2,boxTransform4);
            playlistButton3.getTransforms().addAll(boxTransform2,boxTransform4);
            playlistButton4.getTransforms().addAll(boxTransform2,boxTransform4);
            playlistButton5.getTransforms().addAll(boxTransform2,boxTransform4);
            playlistButton6.getTransforms().addAll(boxTransform2,boxTransform4);
            playlistButton7.getTransforms().addAll(boxTransform2,boxTransform4);
            playlistButton8.getTransforms().addAll(boxTransform2,boxTransform4);
            playlistButton9.getTransforms().addAll(boxTransform2,boxTransform4);
            playlistButton10.getTransforms().addAll(boxTransform2,boxTransform4);
            playlistButton11.getTransforms().addAll(boxTransform2,boxTransform4);
            playlistButton12.getTransforms().addAll(boxTransform2,boxTransform4);

            queueListText1.getTransforms().addAll(xRotate,yRotate,zRotate);
            queueListText2.getTransforms().addAll(xRotate,yRotate,zRotate);
            queueListText3.getTransforms().addAll(xRotate,yRotate,zRotate);
            queueListText4.getTransforms().addAll(xRotate,yRotate,zRotate);
            queueListText5.getTransforms().addAll(xRotate,yRotate,zRotate);
            queueListText6.getTransforms().addAll(xRotate,yRotate,zRotate);
            queueListText7.getTransforms().addAll(xRotate,yRotate,zRotate);
            queueListText8.getTransforms().addAll(xRotate,yRotate,zRotate);
            queueListText9.getTransforms().addAll(xRotate,yRotate,zRotate);
            queueListText10.getTransforms().addAll(xRotate,yRotate,zRotate);
            queueListText11.getTransforms().addAll(xRotate,yRotate,zRotate);
            queueListText12.getTransforms().addAll(xRotate,yRotate,zRotate);



            sortDropButton.getTransforms().addAll(boxTransform1);
            alphabeticalSortButton.getTransforms().addAll(boxTransform1);
            reversealphabeticalSortButton.getTransforms().addAll(boxTransform1);
            reversepopularitySortButton.getTransforms().addAll(boxTransform1);
            popularitySortButton.getTransforms().addAll(boxTransform1);


            alphabeticalSortText.getTransforms().addAll(boxTransform1,boxTransform5);
            reversealphabeticalSortText.getTransforms().addAll(boxTransform1,boxTransform5);
            popularitySortText.getTransforms().addAll(boxTransform1,boxTransform5);
            reversepopularitySortText.getTransforms().addAll(boxTransform1,boxTransform5);
            sortingText.getTransforms().addAll(boxTransform1,boxTransform5);



            goUpArrow.getTransforms().addAll(boxTransform1,boxTransform5);
            goDownArrow.getTransforms().addAll(boxTransform1,boxTransform5);
            goUpArrow2.getTransforms().addAll(boxTransform2,boxTransform4);
            goDownArrow2.getTransforms().addAll(boxTransform2,boxTransform4);


            albumPreview.getTransforms().addAll(boxTransform1,boxTransform5);
//            musicSlider.getTransforms().addAll(xRotate, yRotate, zRotate);
            musicText1.getTransforms().addAll(xRotate, yRotate, zRotate);
            musicText2.getTransforms().addAll(xRotate, yRotate, zRotate);
            musicText3.getTransforms().addAll(xRotate, yRotate, zRotate);
            musicText4.getTransforms().addAll(xRotate, yRotate, zRotate);
            musicText5.getTransforms().addAll(xRotate, yRotate, zRotate);
            musicText6.getTransforms().addAll(xRotate, yRotate, zRotate);
            musicText7.getTransforms().addAll(xRotate, yRotate, zRotate);
            musicText8.getTransforms().addAll(xRotate, yRotate, zRotate);
            musicText9.getTransforms().addAll(xRotate, yRotate, zRotate);
            musicText10.getTransforms().addAll(xRotate, yRotate, zRotate);
            musicText11.getTransforms().addAll(xRotate, yRotate, zRotate);
            musicText12.getTransforms().addAll(xRotate, yRotate, zRotate);
//            musicText13.getTransforms().addAll(xRotate, yRotate, zRotate);
//            musicText14.getTransforms().addAll(xRotate, yRotate, zRotate);
//            musicText15.getTransforms().addAll(xRotate, yRotate, zRotate);

            songsTitleText.getTransforms().addAll(xRotate, yRotate, zRotate);
            albumNameText.getTransforms().addAll(xRotate,yRotate,zRotate);
            albumContentsText.getTransforms().addAll(xRotate,yRotate,zRotate);

            queuetitleText.getTransforms().addAll(xRotate,yRotate,zRotate);
            playlistText.getTransforms().addAll(xRotate,yRotate,zRotate);

            playListText1.getTransforms().addAll(xRotate,yRotate,zRotate);
            playListText2.getTransforms().addAll(xRotate,yRotate,zRotate);
            playListText3.getTransforms().addAll(xRotate,yRotate,zRotate);
            playListText4.getTransforms().addAll(xRotate,yRotate,zRotate);
            playListText5.getTransforms().addAll(xRotate,yRotate,zRotate);
            playListText6.getTransforms().addAll(xRotate,yRotate,zRotate);
            playListText7.getTransforms().addAll(xRotate,yRotate,zRotate);
            playListText8.getTransforms().addAll(xRotate,yRotate,zRotate);
            playListText9.getTransforms().addAll(xRotate,yRotate,zRotate);
            playListText10.getTransforms().addAll(xRotate,yRotate,zRotate);
            playListText11.getTransforms().addAll(xRotate,yRotate,zRotate);
            playListText12.getTransforms().addAll(xRotate,yRotate,zRotate);




//            musicSlider.getTransforms().addAll(boxTransform2,boxTransform4);

            sortButtons.add(alphabeticalSortButton);
            sortButtons.add(reversealphabeticalSortButton);
            sortButtons.add(popularitySortButton);
            sortButtons.add(reversepopularitySortButton);


            sortText.add(sortingText);
            sortText.add(alphabeticalSortText);
            sortText.add(reversealphabeticalSortText);
            sortText.add(popularitySortText);
            sortText.add(reversepopularitySortText);






            Group boxes = new Group();
            //can add more boxes here
            boxes.getChildren().addAll(queueListText1,queueListText2,queueListText3,queueListText4,queueListText5,queueListText6,queueListText7,queueListText8,queueListText9,queueListText10,queueListText11,queueListText12);
            boxes.getChildren().addAll(playListText1,playListText2,playListText3,playListText4,playListText5,playListText6,playListText7,playListText8,playListText9,playListText10,playListText11,playListText12);
            boxes.getChildren().addAll(plusButton,subtractButton);
            boxes.getChildren().addAll(playlistButton1,playlistButton2,playlistButton3,playlistButton4,playlistButton5,playlistButton6,playlistButton7,playlistButton8,playlistButton9,playlistButton10,playlistButton11,playlistButton12);
            boxes.getChildren().addAll(goUpArrow2,goDownArrow2);
            boxes.getChildren().addAll(queuetitleText,playlistText);
            boxes.getChildren().addAll(queueButton1,queueButton2,queueButton3,queueButton4,queueButton5,queueButton6,queueButton7,queueButton8,queueButton9,queueButton10,queueButton11,queueButton12);
            boxes.getChildren().addAll(sortButtons);
            boxes.getChildren().addAll(sortText);
            boxes.getChildren().addAll(screen1,screen2,screen3,screen4,playButton,gobackButton,skipnextButton,loopButton,shuffleButton,defaultPicture,musicButton1,songsTitleText,albumPreview,albumNameText, albumContentsText,musicButton2,musicButton3,musicButton4,musicButton5,musicButton6,musicButton7,musicButton8,musicButton9,musicButton10,musicButton11,musicButton12,goUpArrow,goDownArrow,musicText1,musicText2,musicText3,musicText4,musicText5,musicText6,musicText7,musicText8,musicText9,musicText10,musicText11,musicText12,sortDropButton);
            this.getChildren().add(boxes);

            //dummy audio is default
            try
            {
                Audio a = new Audio("DefaultMusic");

            }
            catch(Exception e)
            {
                System.out.println("File Not Found");
            }


            //events
            albumPreview.setOnMouseClicked(event -> {
                if(isHighlighted1)
                {
                    if(isdefaultSorted&&(playList.contains(songStrings.get(musicHolder1+scrollCounter)))==false)
                    {
                        if (indexCount < 15) {
                            playList.set(indexCount, songStrings.get(musicHolder1+scrollCounter));
                            indexCount++;
                            queueList = Algorithms.shuffle(playList);
                            queueListText1.setText(queueList.get(musicHolder1 + scrollCounter2));
                            queueListText2.setText(queueList.get(musicHolder2 + scrollCounter2));
                            queueListText3.setText(queueList.get(musicHolder3 + scrollCounter2));
                            queueListText4.setText(queueList.get(musicHolder4 + scrollCounter2));
                            queueListText5.setText(queueList.get(musicHolder5 + scrollCounter2));
                            queueListText6.setText(queueList.get(musicHolder6 + scrollCounter2));
                            queueListText7.setText(queueList.get(musicHolder7 + scrollCounter2));
                            queueListText8.setText(queueList.get(musicHolder8 + scrollCounter2));
                            queueListText9.setText(queueList.get(musicHolder9 + scrollCounter2));
                            queueListText10.setText(queueList.get(musicHolder10 + scrollCounter2));
                            queueListText11.setText(queueList.get(musicHolder11 + scrollCounter2));
                            queueListText12.setText(queueList.get(musicHolder12 + scrollCounter2));
                            playListText1.setText(playList.get(musicHolder1 + scrollCounter2));
                            playListText2.setText(playList.get(musicHolder2 + scrollCounter2));
                            playListText3.setText(playList.get(musicHolder3 + scrollCounter2));
                            playListText4.setText(playList.get(musicHolder4 + scrollCounter2));
                            playListText5.setText(playList.get(musicHolder5 + scrollCounter2));
                            playListText6.setText(playList.get(musicHolder6 + scrollCounter2));
                            playListText7.setText(playList.get(musicHolder7 + scrollCounter2));
                            playListText8.setText(playList.get(musicHolder8 + scrollCounter2));
                            playListText9.setText(playList.get(musicHolder9 + scrollCounter2));
                            playListText10.setText(playList.get(musicHolder10 + scrollCounter2));
                            playListText11.setText(playList.get(musicHolder11 + scrollCounter2));
                            playListText12.setText(playList.get(musicHolder12 + scrollCounter2));
                        }
                    }
                    if(isalphabeticalSorted&&(playList.contains(alphabeticalSorted.get(musicHolder1+scrollCounter)))==false)
                    {
                        if (indexCount < 15) {
                            playList.set(indexCount, alphabeticalSorted.get(musicHolder1+scrollCounter));
                            indexCount++;
                            queueList = Algorithms.shuffle(playList);
                            queueListText1.setText(queueList.get(musicHolder1 + scrollCounter2));
                            queueListText2.setText(queueList.get(musicHolder2 + scrollCounter2));
                            queueListText3.setText(queueList.get(musicHolder3 + scrollCounter2));
                            queueListText4.setText(queueList.get(musicHolder4 + scrollCounter2));
                            queueListText5.setText(queueList.get(musicHolder5 + scrollCounter2));
                            queueListText6.setText(queueList.get(musicHolder6 + scrollCounter2));
                            queueListText7.setText(queueList.get(musicHolder7 + scrollCounter2));
                            queueListText8.setText(queueList.get(musicHolder8 + scrollCounter2));
                            queueListText9.setText(queueList.get(musicHolder9 + scrollCounter2));
                            queueListText10.setText(queueList.get(musicHolder10 + scrollCounter2));
                            queueListText11.setText(queueList.get(musicHolder11 + scrollCounter2));
                            queueListText12.setText(queueList.get(musicHolder12 + scrollCounter2));
                            playListText1.setText(playList.get(musicHolder1 + scrollCounter2));
                            playListText2.setText(playList.get(musicHolder2 + scrollCounter2));
                            playListText3.setText(playList.get(musicHolder3 + scrollCounter2));
                            playListText4.setText(playList.get(musicHolder4 + scrollCounter2));
                            playListText5.setText(playList.get(musicHolder5 + scrollCounter2));
                            playListText6.setText(playList.get(musicHolder6 + scrollCounter2));
                            playListText7.setText(playList.get(musicHolder7 + scrollCounter2));
                            playListText8.setText(playList.get(musicHolder8 + scrollCounter2));
                            playListText9.setText(playList.get(musicHolder9 + scrollCounter2));
                            playListText10.setText(playList.get(musicHolder10 + scrollCounter2));
                            playListText11.setText(playList.get(musicHolder11 + scrollCounter2));
                            playListText12.setText(playList.get(musicHolder12 + scrollCounter2));
                        }
                    }
                    if(isreversealphabeticalSorted&&(playList.contains(reversealphabeticalSorted.get(musicHolder1+scrollCounter)))==false)
                    {
                        if (indexCount < 15) {
                            playList.set(indexCount, reversealphabeticalSorted.get(musicHolder1+scrollCounter));
                            indexCount++;
                            queueList = Algorithms.shuffle(playList);
                            queueListText1.setText(queueList.get(musicHolder1 + scrollCounter2));
                            queueListText2.setText(queueList.get(musicHolder2 + scrollCounter2));
                            queueListText3.setText(queueList.get(musicHolder3 + scrollCounter2));
                            queueListText4.setText(queueList.get(musicHolder4 + scrollCounter2));
                            queueListText5.setText(queueList.get(musicHolder5 + scrollCounter2));
                            queueListText6.setText(queueList.get(musicHolder6 + scrollCounter2));
                            queueListText7.setText(queueList.get(musicHolder7 + scrollCounter2));
                            queueListText8.setText(queueList.get(musicHolder8 + scrollCounter2));
                            queueListText9.setText(queueList.get(musicHolder9 + scrollCounter2));
                            queueListText10.setText(queueList.get(musicHolder10 + scrollCounter2));
                            queueListText11.setText(queueList.get(musicHolder11 + scrollCounter2));
                            queueListText12.setText(queueList.get(musicHolder12 + scrollCounter2));
                            playListText1.setText(playList.get(musicHolder1 + scrollCounter2));
                            playListText2.setText(playList.get(musicHolder2 + scrollCounter2));
                            playListText3.setText(playList.get(musicHolder3 + scrollCounter2));
                            playListText4.setText(playList.get(musicHolder4 + scrollCounter2));
                            playListText5.setText(playList.get(musicHolder5 + scrollCounter2));
                            playListText6.setText(playList.get(musicHolder6 + scrollCounter2));
                            playListText7.setText(playList.get(musicHolder7 + scrollCounter2));
                            playListText8.setText(playList.get(musicHolder8 + scrollCounter2));
                            playListText9.setText(playList.get(musicHolder9 + scrollCounter2));
                            playListText10.setText(playList.get(musicHolder10 + scrollCounter2));
                            playListText11.setText(playList.get(musicHolder11 + scrollCounter2));
                            playListText12.setText(playList.get(musicHolder12 + scrollCounter2));
                        }
                    }
                    if(ispopularitySorted&&(playList.contains(popularitySorted.get(musicHolder1+scrollCounter)))==false)
                    {
                        if (indexCount < 15) {
                            playList.set(indexCount, popularitySorted.get(musicHolder1+scrollCounter));
                            indexCount++;
                            queueList = Algorithms.shuffle(playList);
                            queueListText1.setText(queueList.get(musicHolder1 + scrollCounter2));
                            queueListText2.setText(queueList.get(musicHolder2 + scrollCounter2));
                            queueListText3.setText(queueList.get(musicHolder3 + scrollCounter2));
                            queueListText4.setText(queueList.get(musicHolder4 + scrollCounter2));
                            queueListText5.setText(queueList.get(musicHolder5 + scrollCounter2));
                            queueListText6.setText(queueList.get(musicHolder6 + scrollCounter2));
                            queueListText7.setText(queueList.get(musicHolder7 + scrollCounter2));
                            queueListText8.setText(queueList.get(musicHolder8 + scrollCounter2));
                            queueListText9.setText(queueList.get(musicHolder9 + scrollCounter2));
                            queueListText10.setText(queueList.get(musicHolder10 + scrollCounter2));
                            queueListText11.setText(queueList.get(musicHolder11 + scrollCounter2));
                            queueListText12.setText(queueList.get(musicHolder12 + scrollCounter2));
                            playListText1.setText(playList.get(musicHolder1 + scrollCounter2));
                            playListText2.setText(playList.get(musicHolder2 + scrollCounter2));
                            playListText3.setText(playList.get(musicHolder3 + scrollCounter2));
                            playListText4.setText(playList.get(musicHolder4 + scrollCounter2));
                            playListText5.setText(playList.get(musicHolder5 + scrollCounter2));
                            playListText6.setText(playList.get(musicHolder6 + scrollCounter2));
                            playListText7.setText(playList.get(musicHolder7 + scrollCounter2));
                            playListText8.setText(playList.get(musicHolder8 + scrollCounter2));
                            playListText9.setText(playList.get(musicHolder9 + scrollCounter2));
                            playListText10.setText(playList.get(musicHolder10 + scrollCounter2));
                            playListText11.setText(playList.get(musicHolder11 + scrollCounter2));
                            playListText12.setText(playList.get(musicHolder12 + scrollCounter2));
                        }
                    }
                    if(isreversepopularitySorted&&(playList.contains(reversepopularitySorted.get(musicHolder1+scrollCounter)))==false)
                    {
                        if (indexCount < 15) {
                            playList.set(indexCount, reversepopularitySorted.get(musicHolder1+scrollCounter));
                            indexCount++;
                            queueList = Algorithms.shuffle(playList);
                            queueListText1.setText(queueList.get(musicHolder1 + scrollCounter2));
                            queueListText2.setText(queueList.get(musicHolder2 + scrollCounter2));
                            queueListText3.setText(queueList.get(musicHolder3 + scrollCounter2));
                            queueListText4.setText(queueList.get(musicHolder4 + scrollCounter2));
                            queueListText5.setText(queueList.get(musicHolder5 + scrollCounter2));
                            queueListText6.setText(queueList.get(musicHolder6 + scrollCounter2));
                            queueListText7.setText(queueList.get(musicHolder7 + scrollCounter2));
                            queueListText8.setText(queueList.get(musicHolder8 + scrollCounter2));
                            queueListText9.setText(queueList.get(musicHolder9 + scrollCounter2));
                            queueListText10.setText(queueList.get(musicHolder10 + scrollCounter2));
                            queueListText11.setText(queueList.get(musicHolder11 + scrollCounter2));
                            queueListText12.setText(queueList.get(musicHolder12 + scrollCounter2));
                            playListText1.setText(playList.get(musicHolder1 + scrollCounter2));
                            playListText2.setText(playList.get(musicHolder2 + scrollCounter2));
                            playListText3.setText(playList.get(musicHolder3 + scrollCounter2));
                            playListText4.setText(playList.get(musicHolder4 + scrollCounter2));
                            playListText5.setText(playList.get(musicHolder5 + scrollCounter2));
                            playListText6.setText(playList.get(musicHolder6 + scrollCounter2));
                            playListText7.setText(playList.get(musicHolder7 + scrollCounter2));
                            playListText8.setText(playList.get(musicHolder8 + scrollCounter2));
                            playListText9.setText(playList.get(musicHolder9 + scrollCounter2));
                            playListText10.setText(playList.get(musicHolder10 + scrollCounter2));
                            playListText11.setText(playList.get(musicHolder11 + scrollCounter2));
                            playListText12.setText(playList.get(musicHolder12 + scrollCounter2));
                        }
                    }
                }
                if(isHighlighted2)
                {
                    if(isdefaultSorted&&(playList.contains(songStrings.get(musicHolder2+scrollCounter)))==false)
                    {
                        if (indexCount < 15) {
                            playList.set(indexCount, songStrings.get(musicHolder2+scrollCounter));
                            indexCount++;
                            queueList = Algorithms.shuffle(playList);
                            queueListText1.setText(queueList.get(musicHolder1 + scrollCounter2));
                            queueListText2.setText(queueList.get(musicHolder2 + scrollCounter2));
                            queueListText3.setText(queueList.get(musicHolder3 + scrollCounter2));
                            queueListText4.setText(queueList.get(musicHolder4 + scrollCounter2));
                            queueListText5.setText(queueList.get(musicHolder5 + scrollCounter2));
                            queueListText6.setText(queueList.get(musicHolder6 + scrollCounter2));
                            queueListText7.setText(queueList.get(musicHolder7 + scrollCounter2));
                            queueListText8.setText(queueList.get(musicHolder8 + scrollCounter2));
                            queueListText9.setText(queueList.get(musicHolder9 + scrollCounter2));
                            queueListText10.setText(queueList.get(musicHolder10 + scrollCounter2));
                            queueListText11.setText(queueList.get(musicHolder11 + scrollCounter2));
                            queueListText12.setText(queueList.get(musicHolder12 + scrollCounter2));
                            playListText1.setText(playList.get(musicHolder1 + scrollCounter2));
                            playListText2.setText(playList.get(musicHolder2 + scrollCounter2));
                            playListText3.setText(playList.get(musicHolder3 + scrollCounter2));
                            playListText4.setText(playList.get(musicHolder4 + scrollCounter2));
                            playListText5.setText(playList.get(musicHolder5 + scrollCounter2));
                            playListText6.setText(playList.get(musicHolder6 + scrollCounter2));
                            playListText7.setText(playList.get(musicHolder7 + scrollCounter2));
                            playListText8.setText(playList.get(musicHolder8 + scrollCounter2));
                            playListText9.setText(playList.get(musicHolder9 + scrollCounter2));
                            playListText10.setText(playList.get(musicHolder10 + scrollCounter2));
                            playListText11.setText(playList.get(musicHolder11 + scrollCounter2));
                            playListText12.setText(playList.get(musicHolder12 + scrollCounter2));
                        }
                    }
                    if(isalphabeticalSorted&&(playList.contains(alphabeticalSorted.get(musicHolder2+scrollCounter)))==false)
                    {
                        if (indexCount < 15) {
                            playList.set(indexCount, alphabeticalSorted.get(musicHolder2+scrollCounter));
                            indexCount++;
                            queueList = Algorithms.shuffle(playList);
                            queueListText1.setText(queueList.get(musicHolder1 + scrollCounter2));
                            queueListText2.setText(queueList.get(musicHolder2 + scrollCounter2));
                            queueListText3.setText(queueList.get(musicHolder3 + scrollCounter2));
                            queueListText4.setText(queueList.get(musicHolder4 + scrollCounter2));
                            queueListText5.setText(queueList.get(musicHolder5 + scrollCounter2));
                            queueListText6.setText(queueList.get(musicHolder6 + scrollCounter2));
                            queueListText7.setText(queueList.get(musicHolder7 + scrollCounter2));
                            queueListText8.setText(queueList.get(musicHolder8 + scrollCounter2));
                            queueListText9.setText(queueList.get(musicHolder9 + scrollCounter2));
                            queueListText10.setText(queueList.get(musicHolder10 + scrollCounter2));
                            queueListText11.setText(queueList.get(musicHolder11 + scrollCounter2));
                            queueListText12.setText(queueList.get(musicHolder12 + scrollCounter2));
                            playListText1.setText(playList.get(musicHolder1 + scrollCounter2));
                            playListText2.setText(playList.get(musicHolder2 + scrollCounter2));
                            playListText3.setText(playList.get(musicHolder3 + scrollCounter2));
                            playListText4.setText(playList.get(musicHolder4 + scrollCounter2));
                            playListText5.setText(playList.get(musicHolder5 + scrollCounter2));
                            playListText6.setText(playList.get(musicHolder6 + scrollCounter2));
                            playListText7.setText(playList.get(musicHolder7 + scrollCounter2));
                            playListText8.setText(playList.get(musicHolder8 + scrollCounter2));
                            playListText9.setText(playList.get(musicHolder9 + scrollCounter2));
                            playListText10.setText(playList.get(musicHolder10 + scrollCounter2));
                            playListText11.setText(playList.get(musicHolder11 + scrollCounter2));
                            playListText12.setText(playList.get(musicHolder12 + scrollCounter2));
                        }
                    }
                    if(isreversealphabeticalSorted&&(playList.contains(reversealphabeticalSorted.get(musicHolder2+scrollCounter)))==false)
                    {
                        if (indexCount < 15) {
                            playList.set(indexCount, reversealphabeticalSorted.get(musicHolder2+scrollCounter));
                            indexCount++;
                            queueList = Algorithms.shuffle(playList);
                            queueListText1.setText(queueList.get(musicHolder1 + scrollCounter2));
                            queueListText2.setText(queueList.get(musicHolder2 + scrollCounter2));
                            queueListText3.setText(queueList.get(musicHolder3 + scrollCounter2));
                            queueListText4.setText(queueList.get(musicHolder4 + scrollCounter2));
                            queueListText5.setText(queueList.get(musicHolder5 + scrollCounter2));
                            queueListText6.setText(queueList.get(musicHolder6 + scrollCounter2));
                            queueListText7.setText(queueList.get(musicHolder7 + scrollCounter2));
                            queueListText8.setText(queueList.get(musicHolder8 + scrollCounter2));
                            queueListText9.setText(queueList.get(musicHolder9 + scrollCounter2));
                            queueListText10.setText(queueList.get(musicHolder10 + scrollCounter2));
                            queueListText11.setText(queueList.get(musicHolder11 + scrollCounter2));
                            queueListText12.setText(queueList.get(musicHolder12 + scrollCounter2));
                            playListText1.setText(playList.get(musicHolder1 + scrollCounter2));
                            playListText2.setText(playList.get(musicHolder2 + scrollCounter2));
                            playListText3.setText(playList.get(musicHolder3 + scrollCounter2));
                            playListText4.setText(playList.get(musicHolder4 + scrollCounter2));
                            playListText5.setText(playList.get(musicHolder5 + scrollCounter2));
                            playListText6.setText(playList.get(musicHolder6 + scrollCounter2));
                            playListText7.setText(playList.get(musicHolder7 + scrollCounter2));
                            playListText8.setText(playList.get(musicHolder8 + scrollCounter2));
                            playListText9.setText(playList.get(musicHolder9 + scrollCounter2));
                            playListText10.setText(playList.get(musicHolder10 + scrollCounter2));
                            playListText11.setText(playList.get(musicHolder11 + scrollCounter2));
                            playListText12.setText(playList.get(musicHolder12 + scrollCounter2));
                        }
                    }
                    if(ispopularitySorted&&(playList.contains(popularitySorted.get(musicHolder2+scrollCounter)))==false)
                    {
                        if (indexCount < 15) {
                            playList.set(indexCount, popularitySorted.get(musicHolder2+scrollCounter));
                            indexCount++;
                            queueList = Algorithms.shuffle(playList);
                            queueListText1.setText(queueList.get(musicHolder1 + scrollCounter2));
                            queueListText2.setText(queueList.get(musicHolder2 + scrollCounter2));
                            queueListText3.setText(queueList.get(musicHolder3 + scrollCounter2));
                            queueListText4.setText(queueList.get(musicHolder4 + scrollCounter2));
                            queueListText5.setText(queueList.get(musicHolder5 + scrollCounter2));
                            queueListText6.setText(queueList.get(musicHolder6 + scrollCounter2));
                            queueListText7.setText(queueList.get(musicHolder7 + scrollCounter2));
                            queueListText8.setText(queueList.get(musicHolder8 + scrollCounter2));
                            queueListText9.setText(queueList.get(musicHolder9 + scrollCounter2));
                            queueListText10.setText(queueList.get(musicHolder10 + scrollCounter2));
                            queueListText11.setText(queueList.get(musicHolder11 + scrollCounter2));
                            queueListText12.setText(queueList.get(musicHolder12 + scrollCounter2));
                            playListText1.setText(playList.get(musicHolder1 + scrollCounter2));
                            playListText2.setText(playList.get(musicHolder2 + scrollCounter2));
                            playListText3.setText(playList.get(musicHolder3 + scrollCounter2));
                            playListText4.setText(playList.get(musicHolder4 + scrollCounter2));
                            playListText5.setText(playList.get(musicHolder5 + scrollCounter2));
                            playListText6.setText(playList.get(musicHolder6 + scrollCounter2));
                            playListText7.setText(playList.get(musicHolder7 + scrollCounter2));
                            playListText8.setText(playList.get(musicHolder8 + scrollCounter2));
                            playListText9.setText(playList.get(musicHolder9 + scrollCounter2));
                            playListText10.setText(playList.get(musicHolder10 + scrollCounter2));
                            playListText11.setText(playList.get(musicHolder11 + scrollCounter2));
                            playListText12.setText(playList.get(musicHolder12 + scrollCounter2));
                        }
                    }
                    if(isreversepopularitySorted&&(playList.contains(reversepopularitySorted.get(musicHolder2+scrollCounter)))==false)
                    {
                        if (indexCount < 15) {
                            playList.set(indexCount, reversepopularitySorted.get(musicHolder2+scrollCounter));
                            indexCount++;
                            queueList = Algorithms.shuffle(playList);
                            queueListText1.setText(queueList.get(musicHolder1 + scrollCounter2));
                            queueListText2.setText(queueList.get(musicHolder2 + scrollCounter2));
                            queueListText3.setText(queueList.get(musicHolder3 + scrollCounter2));
                            queueListText4.setText(queueList.get(musicHolder4 + scrollCounter2));
                            queueListText5.setText(queueList.get(musicHolder5 + scrollCounter2));
                            queueListText6.setText(queueList.get(musicHolder6 + scrollCounter2));
                            queueListText7.setText(queueList.get(musicHolder7 + scrollCounter2));
                            queueListText8.setText(queueList.get(musicHolder8 + scrollCounter2));
                            queueListText9.setText(queueList.get(musicHolder9 + scrollCounter2));
                            queueListText10.setText(queueList.get(musicHolder10 + scrollCounter2));
                            queueListText11.setText(queueList.get(musicHolder11 + scrollCounter2));
                            queueListText12.setText(queueList.get(musicHolder12 + scrollCounter2));
                            playListText1.setText(playList.get(musicHolder1 + scrollCounter2));
                            playListText2.setText(playList.get(musicHolder2 + scrollCounter2));
                            playListText3.setText(playList.get(musicHolder3 + scrollCounter2));
                            playListText4.setText(playList.get(musicHolder4 + scrollCounter2));
                            playListText5.setText(playList.get(musicHolder5 + scrollCounter2));
                            playListText6.setText(playList.get(musicHolder6 + scrollCounter2));
                            playListText7.setText(playList.get(musicHolder7 + scrollCounter2));
                            playListText8.setText(playList.get(musicHolder8 + scrollCounter2));
                            playListText9.setText(playList.get(musicHolder9 + scrollCounter2));
                            playListText10.setText(playList.get(musicHolder10 + scrollCounter2));
                            playListText11.setText(playList.get(musicHolder11 + scrollCounter2));
                            playListText12.setText(playList.get(musicHolder12 + scrollCounter2));
                        }
                    }
                }
                if(isHighlighted3)
                {
                    if(isdefaultSorted&&(playList.contains(songStrings.get(musicHolder3+scrollCounter)))==false)
                    {
                        if (indexCount < 15) {
                            playList.set(indexCount, songStrings.get(musicHolder3+scrollCounter));
                            indexCount++;
                            queueList = Algorithms.shuffle(playList);
                            queueListText1.setText(queueList.get(musicHolder1 + scrollCounter2));
                            queueListText2.setText(queueList.get(musicHolder2 + scrollCounter2));
                            queueListText3.setText(queueList.get(musicHolder3 + scrollCounter2));
                            queueListText4.setText(queueList.get(musicHolder4 + scrollCounter2));
                            queueListText5.setText(queueList.get(musicHolder5 + scrollCounter2));
                            queueListText6.setText(queueList.get(musicHolder6 + scrollCounter2));
                            queueListText7.setText(queueList.get(musicHolder7 + scrollCounter2));
                            queueListText8.setText(queueList.get(musicHolder8 + scrollCounter2));
                            queueListText9.setText(queueList.get(musicHolder9 + scrollCounter2));
                            queueListText10.setText(queueList.get(musicHolder10 + scrollCounter2));
                            queueListText11.setText(queueList.get(musicHolder11 + scrollCounter2));
                            queueListText12.setText(queueList.get(musicHolder12 + scrollCounter2));
                            playListText1.setText(playList.get(musicHolder1 + scrollCounter2));
                            playListText2.setText(playList.get(musicHolder2 + scrollCounter2));
                            playListText3.setText(playList.get(musicHolder3 + scrollCounter2));
                            playListText4.setText(playList.get(musicHolder4 + scrollCounter2));
                            playListText5.setText(playList.get(musicHolder5 + scrollCounter2));
                            playListText6.setText(playList.get(musicHolder6 + scrollCounter2));
                            playListText7.setText(playList.get(musicHolder7 + scrollCounter2));
                            playListText8.setText(playList.get(musicHolder8 + scrollCounter2));
                            playListText9.setText(playList.get(musicHolder9 + scrollCounter2));
                            playListText10.setText(playList.get(musicHolder10 + scrollCounter2));
                            playListText11.setText(playList.get(musicHolder11 + scrollCounter2));
                            playListText12.setText(playList.get(musicHolder12 + scrollCounter2));
                        }
                    }
                    if(isalphabeticalSorted&&(playList.contains(alphabeticalSorted.get(musicHolder3+scrollCounter)))==false)
                    {
                        if (indexCount < 15) {
                            playList.set(indexCount, alphabeticalSorted.get(musicHolder3+scrollCounter));
                            indexCount++;
                            queueList = Algorithms.shuffle(playList);
                            queueListText1.setText(queueList.get(musicHolder1 + scrollCounter2));
                            queueListText2.setText(queueList.get(musicHolder2 + scrollCounter2));
                            queueListText3.setText(queueList.get(musicHolder3 + scrollCounter2));
                            queueListText4.setText(queueList.get(musicHolder4 + scrollCounter2));
                            queueListText5.setText(queueList.get(musicHolder5 + scrollCounter2));
                            queueListText6.setText(queueList.get(musicHolder6 + scrollCounter2));
                            queueListText7.setText(queueList.get(musicHolder7 + scrollCounter2));
                            queueListText8.setText(queueList.get(musicHolder8 + scrollCounter2));
                            queueListText9.setText(queueList.get(musicHolder9 + scrollCounter2));
                            queueListText10.setText(queueList.get(musicHolder10 + scrollCounter2));
                            queueListText11.setText(queueList.get(musicHolder11 + scrollCounter2));
                            queueListText12.setText(queueList.get(musicHolder12 + scrollCounter2));
                            playListText1.setText(playList.get(musicHolder1 + scrollCounter2));
                            playListText2.setText(playList.get(musicHolder2 + scrollCounter2));
                            playListText3.setText(playList.get(musicHolder3 + scrollCounter2));
                            playListText4.setText(playList.get(musicHolder4 + scrollCounter2));
                            playListText5.setText(playList.get(musicHolder5 + scrollCounter2));
                            playListText6.setText(playList.get(musicHolder6 + scrollCounter2));
                            playListText7.setText(playList.get(musicHolder7 + scrollCounter2));
                            playListText8.setText(playList.get(musicHolder8 + scrollCounter2));
                            playListText9.setText(playList.get(musicHolder9 + scrollCounter2));
                            playListText10.setText(playList.get(musicHolder10 + scrollCounter2));
                            playListText11.setText(playList.get(musicHolder11 + scrollCounter2));
                            playListText12.setText(playList.get(musicHolder12 + scrollCounter2));
                        }
                    }
                    if(isreversealphabeticalSorted&&(playList.contains(reversealphabeticalSorted.get(musicHolder3+scrollCounter)))==false)
                    {
                        if (indexCount < 15) {
                            playList.set(indexCount, reversealphabeticalSorted.get(musicHolder3+scrollCounter));
                            indexCount++;
                            queueList = Algorithms.shuffle(playList);
                            queueListText1.setText(queueList.get(musicHolder1 + scrollCounter2));
                            queueListText2.setText(queueList.get(musicHolder2 + scrollCounter2));
                            queueListText3.setText(queueList.get(musicHolder3 + scrollCounter2));
                            queueListText4.setText(queueList.get(musicHolder4 + scrollCounter2));
                            queueListText5.setText(queueList.get(musicHolder5 + scrollCounter2));
                            queueListText6.setText(queueList.get(musicHolder6 + scrollCounter2));
                            queueListText7.setText(queueList.get(musicHolder7 + scrollCounter2));
                            queueListText8.setText(queueList.get(musicHolder8 + scrollCounter2));
                            queueListText9.setText(queueList.get(musicHolder9 + scrollCounter2));
                            queueListText10.setText(queueList.get(musicHolder10 + scrollCounter2));
                            queueListText11.setText(queueList.get(musicHolder11 + scrollCounter2));
                            queueListText12.setText(queueList.get(musicHolder12 + scrollCounter2));
                            playListText1.setText(playList.get(musicHolder1 + scrollCounter2));
                            playListText2.setText(playList.get(musicHolder2 + scrollCounter2));
                            playListText3.setText(playList.get(musicHolder3 + scrollCounter2));
                            playListText4.setText(playList.get(musicHolder4 + scrollCounter2));
                            playListText5.setText(playList.get(musicHolder5 + scrollCounter2));
                            playListText6.setText(playList.get(musicHolder6 + scrollCounter2));
                            playListText7.setText(playList.get(musicHolder7 + scrollCounter2));
                            playListText8.setText(playList.get(musicHolder8 + scrollCounter2));
                            playListText9.setText(playList.get(musicHolder9 + scrollCounter2));
                            playListText10.setText(playList.get(musicHolder10 + scrollCounter2));
                            playListText11.setText(playList.get(musicHolder11 + scrollCounter2));
                            playListText12.setText(playList.get(musicHolder12 + scrollCounter2));
                        }
                    }
                    if(ispopularitySorted&&(playList.contains(popularitySorted.get(musicHolder3+scrollCounter)))==false)
                    {
                        if (indexCount < 15) {
                            playList.set(indexCount, popularitySorted.get(musicHolder3+scrollCounter));
                            indexCount++;
                            queueList = Algorithms.shuffle(playList);
                            queueListText1.setText(queueList.get(musicHolder1 + scrollCounter2));
                            queueListText2.setText(queueList.get(musicHolder2 + scrollCounter2));
                            queueListText3.setText(queueList.get(musicHolder3 + scrollCounter2));
                            queueListText4.setText(queueList.get(musicHolder4 + scrollCounter2));
                            queueListText5.setText(queueList.get(musicHolder5 + scrollCounter2));
                            queueListText6.setText(queueList.get(musicHolder6 + scrollCounter2));
                            queueListText7.setText(queueList.get(musicHolder7 + scrollCounter2));
                            queueListText8.setText(queueList.get(musicHolder8 + scrollCounter2));
                            queueListText9.setText(queueList.get(musicHolder9 + scrollCounter2));
                            queueListText10.setText(queueList.get(musicHolder10 + scrollCounter2));
                            queueListText11.setText(queueList.get(musicHolder11 + scrollCounter2));
                            queueListText12.setText(queueList.get(musicHolder12 + scrollCounter2));
                            playListText1.setText(playList.get(musicHolder1 + scrollCounter2));
                            playListText2.setText(playList.get(musicHolder2 + scrollCounter2));
                            playListText3.setText(playList.get(musicHolder3 + scrollCounter2));
                            playListText4.setText(playList.get(musicHolder4 + scrollCounter2));
                            playListText5.setText(playList.get(musicHolder5 + scrollCounter2));
                            playListText6.setText(playList.get(musicHolder6 + scrollCounter2));
                            playListText7.setText(playList.get(musicHolder7 + scrollCounter2));
                            playListText8.setText(playList.get(musicHolder8 + scrollCounter2));
                            playListText9.setText(playList.get(musicHolder9 + scrollCounter2));
                            playListText10.setText(playList.get(musicHolder10 + scrollCounter2));
                            playListText11.setText(playList.get(musicHolder11 + scrollCounter2));
                            playListText12.setText(playList.get(musicHolder12 + scrollCounter2));
                        }
                    }
                    if(isreversepopularitySorted&&(playList.contains(reversepopularitySorted.get(musicHolder3+scrollCounter)))==false)
                    {
                        if (indexCount < 15) {
                            playList.set(indexCount, reversepopularitySorted.get(musicHolder3+scrollCounter));
                            indexCount++;
                            queueList = Algorithms.shuffle(playList);
                            queueListText1.setText(queueList.get(musicHolder1 + scrollCounter2));
                            queueListText2.setText(queueList.get(musicHolder2 + scrollCounter2));
                            queueListText3.setText(queueList.get(musicHolder3 + scrollCounter2));
                            queueListText4.setText(queueList.get(musicHolder4 + scrollCounter2));
                            queueListText5.setText(queueList.get(musicHolder5 + scrollCounter2));
                            queueListText6.setText(queueList.get(musicHolder6 + scrollCounter2));
                            queueListText7.setText(queueList.get(musicHolder7 + scrollCounter2));
                            queueListText8.setText(queueList.get(musicHolder8 + scrollCounter2));
                            queueListText9.setText(queueList.get(musicHolder9 + scrollCounter2));
                            queueListText10.setText(queueList.get(musicHolder10 + scrollCounter2));
                            queueListText11.setText(queueList.get(musicHolder11 + scrollCounter2));
                            queueListText12.setText(queueList.get(musicHolder12 + scrollCounter2));
                            playListText1.setText(playList.get(musicHolder1 + scrollCounter2));
                            playListText2.setText(playList.get(musicHolder2 + scrollCounter2));
                            playListText3.setText(playList.get(musicHolder3 + scrollCounter2));
                            playListText4.setText(playList.get(musicHolder4 + scrollCounter2));
                            playListText5.setText(playList.get(musicHolder5 + scrollCounter2));
                            playListText6.setText(playList.get(musicHolder6 + scrollCounter2));
                            playListText7.setText(playList.get(musicHolder7 + scrollCounter2));
                            playListText8.setText(playList.get(musicHolder8 + scrollCounter2));
                            playListText9.setText(playList.get(musicHolder9 + scrollCounter2));
                            playListText10.setText(playList.get(musicHolder10 + scrollCounter2));
                            playListText11.setText(playList.get(musicHolder11 + scrollCounter2));
                            playListText12.setText(playList.get(musicHolder12 + scrollCounter2));
                        }
                    }
                }
                if(isHighlighted4)
                {
                    if(isdefaultSorted&&(playList.contains(songStrings.get(musicHolder4+scrollCounter)))==false)
                    {
                        if (indexCount < 15) {
                            playList.set(indexCount, songStrings.get(musicHolder4+scrollCounter));
                            indexCount++;
                            queueList = Algorithms.shuffle(playList);
                            queueListText1.setText(queueList.get(musicHolder1 + scrollCounter2));
                            queueListText2.setText(queueList.get(musicHolder2 + scrollCounter2));
                            queueListText3.setText(queueList.get(musicHolder3 + scrollCounter2));
                            queueListText4.setText(queueList.get(musicHolder4 + scrollCounter2));
                            queueListText5.setText(queueList.get(musicHolder5 + scrollCounter2));
                            queueListText6.setText(queueList.get(musicHolder6 + scrollCounter2));
                            queueListText7.setText(queueList.get(musicHolder7 + scrollCounter2));
                            queueListText8.setText(queueList.get(musicHolder8 + scrollCounter2));
                            queueListText9.setText(queueList.get(musicHolder9 + scrollCounter2));
                            queueListText10.setText(queueList.get(musicHolder10 + scrollCounter2));
                            queueListText11.setText(queueList.get(musicHolder11 + scrollCounter2));
                            queueListText12.setText(queueList.get(musicHolder12 + scrollCounter2));
                            playListText1.setText(playList.get(musicHolder1 + scrollCounter2));
                            playListText2.setText(playList.get(musicHolder2 + scrollCounter2));
                            playListText3.setText(playList.get(musicHolder3 + scrollCounter2));
                            playListText4.setText(playList.get(musicHolder4 + scrollCounter2));
                            playListText5.setText(playList.get(musicHolder5 + scrollCounter2));
                            playListText6.setText(playList.get(musicHolder6 + scrollCounter2));
                            playListText7.setText(playList.get(musicHolder7 + scrollCounter2));
                            playListText8.setText(playList.get(musicHolder8 + scrollCounter2));
                            playListText9.setText(playList.get(musicHolder9 + scrollCounter2));
                            playListText10.setText(playList.get(musicHolder10 + scrollCounter2));
                            playListText11.setText(playList.get(musicHolder11 + scrollCounter2));
                            playListText12.setText(playList.get(musicHolder12 + scrollCounter2));
                        }
                    }
                    if(isalphabeticalSorted&&(playList.contains(alphabeticalSorted.get(musicHolder4+scrollCounter)))==false)
                    {
                        if (indexCount < 15) {
                            playList.set(indexCount, alphabeticalSorted.get(musicHolder4+scrollCounter));
                            indexCount++;
                            queueList = Algorithms.shuffle(playList);
                            queueListText1.setText(queueList.get(musicHolder1 + scrollCounter2));
                            queueListText2.setText(queueList.get(musicHolder2 + scrollCounter2));
                            queueListText3.setText(queueList.get(musicHolder3 + scrollCounter2));
                            queueListText4.setText(queueList.get(musicHolder4 + scrollCounter2));
                            queueListText5.setText(queueList.get(musicHolder5 + scrollCounter2));
                            queueListText6.setText(queueList.get(musicHolder6 + scrollCounter2));
                            queueListText7.setText(queueList.get(musicHolder7 + scrollCounter2));
                            queueListText8.setText(queueList.get(musicHolder8 + scrollCounter2));
                            queueListText9.setText(queueList.get(musicHolder9 + scrollCounter2));
                            queueListText10.setText(queueList.get(musicHolder10 + scrollCounter2));
                            queueListText11.setText(queueList.get(musicHolder11 + scrollCounter2));
                            queueListText12.setText(queueList.get(musicHolder12 + scrollCounter2));
                            playListText1.setText(playList.get(musicHolder1 + scrollCounter2));
                            playListText2.setText(playList.get(musicHolder2 + scrollCounter2));
                            playListText3.setText(playList.get(musicHolder3 + scrollCounter2));
                            playListText4.setText(playList.get(musicHolder4 + scrollCounter2));
                            playListText5.setText(playList.get(musicHolder5 + scrollCounter2));
                            playListText6.setText(playList.get(musicHolder6 + scrollCounter2));
                            playListText7.setText(playList.get(musicHolder7 + scrollCounter2));
                            playListText8.setText(playList.get(musicHolder8 + scrollCounter2));
                            playListText9.setText(playList.get(musicHolder9 + scrollCounter2));
                            playListText10.setText(playList.get(musicHolder10 + scrollCounter2));
                            playListText11.setText(playList.get(musicHolder11 + scrollCounter2));
                            playListText12.setText(playList.get(musicHolder12 + scrollCounter2));
                        }
                    }
                    if(isreversealphabeticalSorted&&(playList.contains(reversealphabeticalSorted.get(musicHolder4+scrollCounter)))==false)
                    {
                        if (indexCount < 15) {
                            playList.set(indexCount, reversealphabeticalSorted.get(musicHolder4+scrollCounter));
                            indexCount++;
                            queueList = Algorithms.shuffle(playList);
                            queueListText1.setText(queueList.get(musicHolder1 + scrollCounter2));
                            queueListText2.setText(queueList.get(musicHolder2 + scrollCounter2));
                            queueListText3.setText(queueList.get(musicHolder3 + scrollCounter2));
                            queueListText4.setText(queueList.get(musicHolder4 + scrollCounter2));
                            queueListText5.setText(queueList.get(musicHolder5 + scrollCounter2));
                            queueListText6.setText(queueList.get(musicHolder6 + scrollCounter2));
                            queueListText7.setText(queueList.get(musicHolder7 + scrollCounter2));
                            queueListText8.setText(queueList.get(musicHolder8 + scrollCounter2));
                            queueListText9.setText(queueList.get(musicHolder9 + scrollCounter2));
                            queueListText10.setText(queueList.get(musicHolder10 + scrollCounter2));
                            queueListText11.setText(queueList.get(musicHolder11 + scrollCounter2));
                            queueListText12.setText(queueList.get(musicHolder12 + scrollCounter2));
                            playListText1.setText(playList.get(musicHolder1 + scrollCounter2));
                            playListText2.setText(playList.get(musicHolder2 + scrollCounter2));
                            playListText3.setText(playList.get(musicHolder3 + scrollCounter2));
                            playListText4.setText(playList.get(musicHolder4 + scrollCounter2));
                            playListText5.setText(playList.get(musicHolder5 + scrollCounter2));
                            playListText6.setText(playList.get(musicHolder6 + scrollCounter2));
                            playListText7.setText(playList.get(musicHolder7 + scrollCounter2));
                            playListText8.setText(playList.get(musicHolder8 + scrollCounter2));
                            playListText9.setText(playList.get(musicHolder9 + scrollCounter2));
                            playListText10.setText(playList.get(musicHolder10 + scrollCounter2));
                            playListText11.setText(playList.get(musicHolder11 + scrollCounter2));
                            playListText12.setText(playList.get(musicHolder12 + scrollCounter2));
                        }
                    }
                    if(ispopularitySorted&&(playList.contains(popularitySorted.get(musicHolder4+scrollCounter)))==false)
                    {
                        if (indexCount < 15) {
                            playList.set(indexCount, popularitySorted.get(musicHolder4+scrollCounter));
                            indexCount++;
                            queueList = Algorithms.shuffle(playList);
                            queueListText1.setText(queueList.get(musicHolder1 + scrollCounter2));
                            queueListText2.setText(queueList.get(musicHolder2 + scrollCounter2));
                            queueListText3.setText(queueList.get(musicHolder3 + scrollCounter2));
                            queueListText4.setText(queueList.get(musicHolder4 + scrollCounter2));
                            queueListText5.setText(queueList.get(musicHolder5 + scrollCounter2));
                            queueListText6.setText(queueList.get(musicHolder6 + scrollCounter2));
                            queueListText7.setText(queueList.get(musicHolder7 + scrollCounter2));
                            queueListText8.setText(queueList.get(musicHolder8 + scrollCounter2));
                            queueListText9.setText(queueList.get(musicHolder9 + scrollCounter2));
                            queueListText10.setText(queueList.get(musicHolder10 + scrollCounter2));
                            queueListText11.setText(queueList.get(musicHolder11 + scrollCounter2));
                            queueListText12.setText(queueList.get(musicHolder12 + scrollCounter2));
                            playListText1.setText(playList.get(musicHolder1 + scrollCounter2));
                            playListText2.setText(playList.get(musicHolder2 + scrollCounter2));
                            playListText3.setText(playList.get(musicHolder3 + scrollCounter2));
                            playListText4.setText(playList.get(musicHolder4 + scrollCounter2));
                            playListText5.setText(playList.get(musicHolder5 + scrollCounter2));
                            playListText6.setText(playList.get(musicHolder6 + scrollCounter2));
                            playListText7.setText(playList.get(musicHolder7 + scrollCounter2));
                            playListText8.setText(playList.get(musicHolder8 + scrollCounter2));
                            playListText9.setText(playList.get(musicHolder9 + scrollCounter2));
                            playListText10.setText(playList.get(musicHolder10 + scrollCounter2));
                            playListText11.setText(playList.get(musicHolder11 + scrollCounter2));
                            playListText12.setText(playList.get(musicHolder12 + scrollCounter2));
                        }
                    }
                    if(isreversepopularitySorted&&(playList.contains(reversepopularitySorted.get(musicHolder4+scrollCounter)))==false)
                    {
                        if (indexCount < 15) {
                            playList.set(indexCount, reversepopularitySorted.get(musicHolder4+scrollCounter));
                            indexCount++;
                            queueList = Algorithms.shuffle(playList);
                            queueListText1.setText(queueList.get(musicHolder1 + scrollCounter2));
                            queueListText2.setText(queueList.get(musicHolder2 + scrollCounter2));
                            queueListText3.setText(queueList.get(musicHolder3 + scrollCounter2));
                            queueListText4.setText(queueList.get(musicHolder4 + scrollCounter2));
                            queueListText5.setText(queueList.get(musicHolder5 + scrollCounter2));
                            queueListText6.setText(queueList.get(musicHolder6 + scrollCounter2));
                            queueListText7.setText(queueList.get(musicHolder7 + scrollCounter2));
                            queueListText8.setText(queueList.get(musicHolder8 + scrollCounter2));
                            queueListText9.setText(queueList.get(musicHolder9 + scrollCounter2));
                            queueListText10.setText(queueList.get(musicHolder10 + scrollCounter2));
                            queueListText11.setText(queueList.get(musicHolder11 + scrollCounter2));
                            queueListText12.setText(queueList.get(musicHolder12 + scrollCounter2));
                            playListText1.setText(playList.get(musicHolder1 + scrollCounter2));
                            playListText2.setText(playList.get(musicHolder2 + scrollCounter2));
                            playListText3.setText(playList.get(musicHolder3 + scrollCounter2));
                            playListText4.setText(playList.get(musicHolder4 + scrollCounter2));
                            playListText5.setText(playList.get(musicHolder5 + scrollCounter2));
                            playListText6.setText(playList.get(musicHolder6 + scrollCounter2));
                            playListText7.setText(playList.get(musicHolder7 + scrollCounter2));
                            playListText8.setText(playList.get(musicHolder8 + scrollCounter2));
                            playListText9.setText(playList.get(musicHolder9 + scrollCounter2));
                            playListText10.setText(playList.get(musicHolder10 + scrollCounter2));
                            playListText11.setText(playList.get(musicHolder11 + scrollCounter2));
                            playListText12.setText(playList.get(musicHolder12 + scrollCounter2));
                        }
                    }
                }
                if(isHighlighted5)
                {
                    if(isdefaultSorted&&(playList.contains(songStrings.get(musicHolder5+scrollCounter)))==false)
                    {
                        if (indexCount < 15) {
                            playList.set(indexCount, songStrings.get(musicHolder5+scrollCounter));
                            indexCount++;
                            queueList = Algorithms.shuffle(playList);
                            queueListText1.setText(queueList.get(musicHolder1 + scrollCounter2));
                            queueListText2.setText(queueList.get(musicHolder2 + scrollCounter2));
                            queueListText3.setText(queueList.get(musicHolder3 + scrollCounter2));
                            queueListText4.setText(queueList.get(musicHolder4 + scrollCounter2));
                            queueListText5.setText(queueList.get(musicHolder5 + scrollCounter2));
                            queueListText6.setText(queueList.get(musicHolder6 + scrollCounter2));
                            queueListText7.setText(queueList.get(musicHolder7 + scrollCounter2));
                            queueListText8.setText(queueList.get(musicHolder8 + scrollCounter2));
                            queueListText9.setText(queueList.get(musicHolder9 + scrollCounter2));
                            queueListText10.setText(queueList.get(musicHolder10 + scrollCounter2));
                            queueListText11.setText(queueList.get(musicHolder11 + scrollCounter2));
                            queueListText12.setText(queueList.get(musicHolder12 + scrollCounter2));
                            playListText1.setText(playList.get(musicHolder1 + scrollCounter2));
                            playListText2.setText(playList.get(musicHolder2 + scrollCounter2));
                            playListText3.setText(playList.get(musicHolder3 + scrollCounter2));
                            playListText4.setText(playList.get(musicHolder4 + scrollCounter2));
                            playListText5.setText(playList.get(musicHolder5 + scrollCounter2));
                            playListText6.setText(playList.get(musicHolder6 + scrollCounter2));
                            playListText7.setText(playList.get(musicHolder7 + scrollCounter2));
                            playListText8.setText(playList.get(musicHolder8 + scrollCounter2));
                            playListText9.setText(playList.get(musicHolder9 + scrollCounter2));
                            playListText10.setText(playList.get(musicHolder10 + scrollCounter2));
                            playListText11.setText(playList.get(musicHolder11 + scrollCounter2));
                            playListText12.setText(playList.get(musicHolder12 + scrollCounter2));
                        }
                    }
                    if(isalphabeticalSorted&&(playList.contains(alphabeticalSorted.get(musicHolder5+scrollCounter)))==false)
                    {
                        if (indexCount < 15) {
                            playList.set(indexCount, alphabeticalSorted.get(musicHolder5+scrollCounter));
                            indexCount++;
                            queueList = Algorithms.shuffle(playList);
                            queueListText1.setText(queueList.get(musicHolder1 + scrollCounter2));
                            queueListText2.setText(queueList.get(musicHolder2 + scrollCounter2));
                            queueListText3.setText(queueList.get(musicHolder3 + scrollCounter2));
                            queueListText4.setText(queueList.get(musicHolder4 + scrollCounter2));
                            queueListText5.setText(queueList.get(musicHolder5 + scrollCounter2));
                            queueListText6.setText(queueList.get(musicHolder6 + scrollCounter2));
                            queueListText7.setText(queueList.get(musicHolder7 + scrollCounter2));
                            queueListText8.setText(queueList.get(musicHolder8 + scrollCounter2));
                            queueListText9.setText(queueList.get(musicHolder9 + scrollCounter2));
                            queueListText10.setText(queueList.get(musicHolder10 + scrollCounter2));
                            queueListText11.setText(queueList.get(musicHolder11 + scrollCounter2));
                            queueListText12.setText(queueList.get(musicHolder12 + scrollCounter2));
                            playListText1.setText(playList.get(musicHolder1 + scrollCounter2));
                            playListText2.setText(playList.get(musicHolder2 + scrollCounter2));
                            playListText3.setText(playList.get(musicHolder3 + scrollCounter2));
                            playListText4.setText(playList.get(musicHolder4 + scrollCounter2));
                            playListText5.setText(playList.get(musicHolder5 + scrollCounter2));
                            playListText6.setText(playList.get(musicHolder6 + scrollCounter2));
                            playListText7.setText(playList.get(musicHolder7 + scrollCounter2));
                            playListText8.setText(playList.get(musicHolder8 + scrollCounter2));
                            playListText9.setText(playList.get(musicHolder9 + scrollCounter2));
                            playListText10.setText(playList.get(musicHolder10 + scrollCounter2));
                            playListText11.setText(playList.get(musicHolder11 + scrollCounter2));
                            playListText12.setText(playList.get(musicHolder12 + scrollCounter2));
                        }
                    }
                    if(isreversealphabeticalSorted&&(playList.contains(reversealphabeticalSorted.get(musicHolder5+scrollCounter)))==false)
                    {
                        if (indexCount < 15) {
                            playList.set(indexCount, reversealphabeticalSorted.get(musicHolder5+scrollCounter));
                            indexCount++;
                            queueList = Algorithms.shuffle(playList);
                            queueListText1.setText(queueList.get(musicHolder1 + scrollCounter2));
                            queueListText2.setText(queueList.get(musicHolder2 + scrollCounter2));
                            queueListText3.setText(queueList.get(musicHolder3 + scrollCounter2));
                            queueListText4.setText(queueList.get(musicHolder4 + scrollCounter2));
                            queueListText5.setText(queueList.get(musicHolder5 + scrollCounter2));
                            queueListText6.setText(queueList.get(musicHolder6 + scrollCounter2));
                            queueListText7.setText(queueList.get(musicHolder7 + scrollCounter2));
                            queueListText8.setText(queueList.get(musicHolder8 + scrollCounter2));
                            queueListText9.setText(queueList.get(musicHolder9 + scrollCounter2));
                            queueListText10.setText(queueList.get(musicHolder10 + scrollCounter2));
                            queueListText11.setText(queueList.get(musicHolder11 + scrollCounter2));
                            queueListText12.setText(queueList.get(musicHolder12 + scrollCounter2));
                            playListText1.setText(playList.get(musicHolder1 + scrollCounter2));
                            playListText2.setText(playList.get(musicHolder2 + scrollCounter2));
                            playListText3.setText(playList.get(musicHolder3 + scrollCounter2));
                            playListText4.setText(playList.get(musicHolder4 + scrollCounter2));
                            playListText5.setText(playList.get(musicHolder5 + scrollCounter2));
                            playListText6.setText(playList.get(musicHolder6 + scrollCounter2));
                            playListText7.setText(playList.get(musicHolder7 + scrollCounter2));
                            playListText8.setText(playList.get(musicHolder8 + scrollCounter2));
                            playListText9.setText(playList.get(musicHolder9 + scrollCounter2));
                            playListText10.setText(playList.get(musicHolder10 + scrollCounter2));
                            playListText11.setText(playList.get(musicHolder11 + scrollCounter2));
                            playListText12.setText(playList.get(musicHolder12 + scrollCounter2));
                        }
                    }
                    if(ispopularitySorted&&(playList.contains(popularitySorted.get(musicHolder5+scrollCounter)))==false)
                    {
                        if (indexCount < 15) {
                            playList.set(indexCount, popularitySorted.get(musicHolder5+scrollCounter));
                            indexCount++;
                            queueList = Algorithms.shuffle(playList);
                            queueListText1.setText(queueList.get(musicHolder1 + scrollCounter2));
                            queueListText2.setText(queueList.get(musicHolder2 + scrollCounter2));
                            queueListText3.setText(queueList.get(musicHolder3 + scrollCounter2));
                            queueListText4.setText(queueList.get(musicHolder4 + scrollCounter2));
                            queueListText5.setText(queueList.get(musicHolder5 + scrollCounter2));
                            queueListText6.setText(queueList.get(musicHolder6 + scrollCounter2));
                            queueListText7.setText(queueList.get(musicHolder7 + scrollCounter2));
                            queueListText8.setText(queueList.get(musicHolder8 + scrollCounter2));
                            queueListText9.setText(queueList.get(musicHolder9 + scrollCounter2));
                            queueListText10.setText(queueList.get(musicHolder10 + scrollCounter2));
                            queueListText11.setText(queueList.get(musicHolder11 + scrollCounter2));
                            queueListText12.setText(queueList.get(musicHolder12 + scrollCounter2));
                            playListText1.setText(playList.get(musicHolder1 + scrollCounter2));
                            playListText2.setText(playList.get(musicHolder2 + scrollCounter2));
                            playListText3.setText(playList.get(musicHolder3 + scrollCounter2));
                            playListText4.setText(playList.get(musicHolder4 + scrollCounter2));
                            playListText5.setText(playList.get(musicHolder5 + scrollCounter2));
                            playListText6.setText(playList.get(musicHolder6 + scrollCounter2));
                            playListText7.setText(playList.get(musicHolder7 + scrollCounter2));
                            playListText8.setText(playList.get(musicHolder8 + scrollCounter2));
                            playListText9.setText(playList.get(musicHolder9 + scrollCounter2));
                            playListText10.setText(playList.get(musicHolder10 + scrollCounter2));
                            playListText11.setText(playList.get(musicHolder11 + scrollCounter2));
                            playListText12.setText(playList.get(musicHolder12 + scrollCounter2));
                        }
                    }
                    if(isreversepopularitySorted&&(playList.contains(reversepopularitySorted.get(musicHolder5+scrollCounter)))==false)
                    {
                        if (indexCount < 15) {
                            playList.set(indexCount, reversepopularitySorted.get(musicHolder5+scrollCounter));
                            indexCount++;
                            queueList = Algorithms.shuffle(playList);
                            queueListText1.setText(queueList.get(musicHolder1 + scrollCounter2));
                            queueListText2.setText(queueList.get(musicHolder2 + scrollCounter2));
                            queueListText3.setText(queueList.get(musicHolder3 + scrollCounter2));
                            queueListText4.setText(queueList.get(musicHolder4 + scrollCounter2));
                            queueListText5.setText(queueList.get(musicHolder5 + scrollCounter2));
                            queueListText6.setText(queueList.get(musicHolder6 + scrollCounter2));
                            queueListText7.setText(queueList.get(musicHolder7 + scrollCounter2));
                            queueListText8.setText(queueList.get(musicHolder8 + scrollCounter2));
                            queueListText9.setText(queueList.get(musicHolder9 + scrollCounter2));
                            queueListText10.setText(queueList.get(musicHolder10 + scrollCounter2));
                            queueListText11.setText(queueList.get(musicHolder11 + scrollCounter2));
                            queueListText12.setText(queueList.get(musicHolder12 + scrollCounter2));
                            playListText1.setText(playList.get(musicHolder1 + scrollCounter2));
                            playListText2.setText(playList.get(musicHolder2 + scrollCounter2));
                            playListText3.setText(playList.get(musicHolder3 + scrollCounter2));
                            playListText4.setText(playList.get(musicHolder4 + scrollCounter2));
                            playListText5.setText(playList.get(musicHolder5 + scrollCounter2));
                            playListText6.setText(playList.get(musicHolder6 + scrollCounter2));
                            playListText7.setText(playList.get(musicHolder7 + scrollCounter2));
                            playListText8.setText(playList.get(musicHolder8 + scrollCounter2));
                            playListText9.setText(playList.get(musicHolder9 + scrollCounter2));
                            playListText10.setText(playList.get(musicHolder10 + scrollCounter2));
                            playListText11.setText(playList.get(musicHolder11 + scrollCounter2));
                            playListText12.setText(playList.get(musicHolder12 + scrollCounter2));
                        }
                    }
                }
                if(isHighlighted6)
                {
                    if(isdefaultSorted&&(playList.contains(songStrings.get(musicHolder6+scrollCounter)))==false)
                    {
                        if (indexCount < 15) {
                            playList.set(indexCount, songStrings.get(musicHolder6+scrollCounter));
                            indexCount++;
                            queueList = Algorithms.shuffle(playList);
                            queueListText1.setText(queueList.get(musicHolder1 + scrollCounter2));
                            queueListText2.setText(queueList.get(musicHolder2 + scrollCounter2));
                            queueListText3.setText(queueList.get(musicHolder3 + scrollCounter2));
                            queueListText4.setText(queueList.get(musicHolder4 + scrollCounter2));
                            queueListText5.setText(queueList.get(musicHolder5 + scrollCounter2));
                            queueListText6.setText(queueList.get(musicHolder6 + scrollCounter2));
                            queueListText7.setText(queueList.get(musicHolder7 + scrollCounter2));
                            queueListText8.setText(queueList.get(musicHolder8 + scrollCounter2));
                            queueListText9.setText(queueList.get(musicHolder9 + scrollCounter2));
                            queueListText10.setText(queueList.get(musicHolder10 + scrollCounter2));
                            queueListText11.setText(queueList.get(musicHolder11 + scrollCounter2));
                            queueListText12.setText(queueList.get(musicHolder12 + scrollCounter2));
                            playListText1.setText(playList.get(musicHolder1 + scrollCounter2));
                            playListText2.setText(playList.get(musicHolder2 + scrollCounter2));
                            playListText3.setText(playList.get(musicHolder3 + scrollCounter2));
                            playListText4.setText(playList.get(musicHolder4 + scrollCounter2));
                            playListText5.setText(playList.get(musicHolder5 + scrollCounter2));
                            playListText6.setText(playList.get(musicHolder6 + scrollCounter2));
                            playListText7.setText(playList.get(musicHolder7 + scrollCounter2));
                            playListText8.setText(playList.get(musicHolder8 + scrollCounter2));
                            playListText9.setText(playList.get(musicHolder9 + scrollCounter2));
                            playListText10.setText(playList.get(musicHolder10 + scrollCounter2));
                            playListText11.setText(playList.get(musicHolder11 + scrollCounter2));
                            playListText12.setText(playList.get(musicHolder12 + scrollCounter2));
                        }
                    }
                    if(isalphabeticalSorted&&(playList.contains(alphabeticalSorted.get(musicHolder6+scrollCounter)))==false)
                    {
                        if (indexCount < 15) {
                            playList.set(indexCount, alphabeticalSorted.get(musicHolder6+scrollCounter));
                            indexCount++;
                            queueList = Algorithms.shuffle(playList);
                            queueListText1.setText(queueList.get(musicHolder1 + scrollCounter2));
                            queueListText2.setText(queueList.get(musicHolder2 + scrollCounter2));
                            queueListText3.setText(queueList.get(musicHolder3 + scrollCounter2));
                            queueListText4.setText(queueList.get(musicHolder4 + scrollCounter2));
                            queueListText5.setText(queueList.get(musicHolder5 + scrollCounter2));
                            queueListText6.setText(queueList.get(musicHolder6 + scrollCounter2));
                            queueListText7.setText(queueList.get(musicHolder7 + scrollCounter2));
                            queueListText8.setText(queueList.get(musicHolder8 + scrollCounter2));
                            queueListText9.setText(queueList.get(musicHolder9 + scrollCounter2));
                            queueListText10.setText(queueList.get(musicHolder10 + scrollCounter2));
                            queueListText11.setText(queueList.get(musicHolder11 + scrollCounter2));
                            queueListText12.setText(queueList.get(musicHolder12 + scrollCounter2));
                            playListText1.setText(playList.get(musicHolder1 + scrollCounter2));
                            playListText2.setText(playList.get(musicHolder2 + scrollCounter2));
                            playListText3.setText(playList.get(musicHolder3 + scrollCounter2));
                            playListText4.setText(playList.get(musicHolder4 + scrollCounter2));
                            playListText5.setText(playList.get(musicHolder5 + scrollCounter2));
                            playListText6.setText(playList.get(musicHolder6 + scrollCounter2));
                            playListText7.setText(playList.get(musicHolder7 + scrollCounter2));
                            playListText8.setText(playList.get(musicHolder8 + scrollCounter2));
                            playListText9.setText(playList.get(musicHolder9 + scrollCounter2));
                            playListText10.setText(playList.get(musicHolder10 + scrollCounter2));
                            playListText11.setText(playList.get(musicHolder11 + scrollCounter2));
                            playListText12.setText(playList.get(musicHolder12 + scrollCounter2));
                        }
                    }
                    if(isreversealphabeticalSorted&&(playList.contains(reversealphabeticalSorted.get(musicHolder6+scrollCounter)))==false)
                    {
                        if (indexCount < 15) {
                            playList.set(indexCount, reversealphabeticalSorted.get(musicHolder6+scrollCounter));
                            indexCount++;
                            queueList = Algorithms.shuffle(playList);
                            queueListText1.setText(queueList.get(musicHolder1 + scrollCounter2));
                            queueListText2.setText(queueList.get(musicHolder2 + scrollCounter2));
                            queueListText3.setText(queueList.get(musicHolder3 + scrollCounter2));
                            queueListText4.setText(queueList.get(musicHolder4 + scrollCounter2));
                            queueListText5.setText(queueList.get(musicHolder5 + scrollCounter2));
                            queueListText6.setText(queueList.get(musicHolder6 + scrollCounter2));
                            queueListText7.setText(queueList.get(musicHolder7 + scrollCounter2));
                            queueListText8.setText(queueList.get(musicHolder8 + scrollCounter2));
                            queueListText9.setText(queueList.get(musicHolder9 + scrollCounter2));
                            queueListText10.setText(queueList.get(musicHolder10 + scrollCounter2));
                            queueListText11.setText(queueList.get(musicHolder11 + scrollCounter2));
                            queueListText12.setText(queueList.get(musicHolder12 + scrollCounter2));
                            playListText1.setText(playList.get(musicHolder1 + scrollCounter2));
                            playListText2.setText(playList.get(musicHolder2 + scrollCounter2));
                            playListText3.setText(playList.get(musicHolder3 + scrollCounter2));
                            playListText4.setText(playList.get(musicHolder4 + scrollCounter2));
                            playListText5.setText(playList.get(musicHolder5 + scrollCounter2));
                            playListText6.setText(playList.get(musicHolder6 + scrollCounter2));
                            playListText7.setText(playList.get(musicHolder7 + scrollCounter2));
                            playListText8.setText(playList.get(musicHolder8 + scrollCounter2));
                            playListText9.setText(playList.get(musicHolder9 + scrollCounter2));
                            playListText10.setText(playList.get(musicHolder10 + scrollCounter2));
                            playListText11.setText(playList.get(musicHolder11 + scrollCounter2));
                            playListText12.setText(playList.get(musicHolder12 + scrollCounter2));
                        }
                    }
                    if(ispopularitySorted&&(playList.contains(popularitySorted.get(musicHolder6+scrollCounter)))==false)
                    {
                        if (indexCount < 15) {
                            playList.set(indexCount, popularitySorted.get(musicHolder6+scrollCounter));
                            indexCount++;
                            queueList = Algorithms.shuffle(playList);
                            queueListText1.setText(queueList.get(musicHolder1 + scrollCounter2));
                            queueListText2.setText(queueList.get(musicHolder2 + scrollCounter2));
                            queueListText3.setText(queueList.get(musicHolder3 + scrollCounter2));
                            queueListText4.setText(queueList.get(musicHolder4 + scrollCounter2));
                            queueListText5.setText(queueList.get(musicHolder5 + scrollCounter2));
                            queueListText6.setText(queueList.get(musicHolder6 + scrollCounter2));
                            queueListText7.setText(queueList.get(musicHolder7 + scrollCounter2));
                            queueListText8.setText(queueList.get(musicHolder8 + scrollCounter2));
                            queueListText9.setText(queueList.get(musicHolder9 + scrollCounter2));
                            queueListText10.setText(queueList.get(musicHolder10 + scrollCounter2));
                            queueListText11.setText(queueList.get(musicHolder11 + scrollCounter2));
                            queueListText12.setText(queueList.get(musicHolder12 + scrollCounter2));
                            playListText1.setText(playList.get(musicHolder1 + scrollCounter2));
                            playListText2.setText(playList.get(musicHolder2 + scrollCounter2));
                            playListText3.setText(playList.get(musicHolder3 + scrollCounter2));
                            playListText4.setText(playList.get(musicHolder4 + scrollCounter2));
                            playListText5.setText(playList.get(musicHolder5 + scrollCounter2));
                            playListText6.setText(playList.get(musicHolder6 + scrollCounter2));
                            playListText7.setText(playList.get(musicHolder7 + scrollCounter2));
                            playListText8.setText(playList.get(musicHolder8 + scrollCounter2));
                            playListText9.setText(playList.get(musicHolder9 + scrollCounter2));
                            playListText10.setText(playList.get(musicHolder10 + scrollCounter2));
                            playListText11.setText(playList.get(musicHolder11 + scrollCounter2));
                            playListText12.setText(playList.get(musicHolder12 + scrollCounter2));
                        }
                    }
                    if(isreversepopularitySorted&&(playList.contains(reversepopularitySorted.get(musicHolder6+scrollCounter)))==false)
                    {
                        if (indexCount < 15) {
                            playList.set(indexCount, reversepopularitySorted.get(musicHolder6+scrollCounter));
                            indexCount++;
                            queueList = Algorithms.shuffle(playList);
                            queueListText1.setText(queueList.get(musicHolder1 + scrollCounter2));
                            queueListText2.setText(queueList.get(musicHolder2 + scrollCounter2));
                            queueListText3.setText(queueList.get(musicHolder3 + scrollCounter2));
                            queueListText4.setText(queueList.get(musicHolder4 + scrollCounter2));
                            queueListText5.setText(queueList.get(musicHolder5 + scrollCounter2));
                            queueListText6.setText(queueList.get(musicHolder6 + scrollCounter2));
                            queueListText7.setText(queueList.get(musicHolder7 + scrollCounter2));
                            queueListText8.setText(queueList.get(musicHolder8 + scrollCounter2));
                            queueListText9.setText(queueList.get(musicHolder9 + scrollCounter2));
                            queueListText10.setText(queueList.get(musicHolder10 + scrollCounter2));
                            queueListText11.setText(queueList.get(musicHolder11 + scrollCounter2));
                            queueListText12.setText(queueList.get(musicHolder12 + scrollCounter2));
                            playListText1.setText(playList.get(musicHolder1 + scrollCounter2));
                            playListText2.setText(playList.get(musicHolder2 + scrollCounter2));
                            playListText3.setText(playList.get(musicHolder3 + scrollCounter2));
                            playListText4.setText(playList.get(musicHolder4 + scrollCounter2));
                            playListText5.setText(playList.get(musicHolder5 + scrollCounter2));
                            playListText6.setText(playList.get(musicHolder6 + scrollCounter2));
                            playListText7.setText(playList.get(musicHolder7 + scrollCounter2));
                            playListText8.setText(playList.get(musicHolder8 + scrollCounter2));
                            playListText9.setText(playList.get(musicHolder9 + scrollCounter2));
                            playListText10.setText(playList.get(musicHolder10 + scrollCounter2));
                            playListText11.setText(playList.get(musicHolder11 + scrollCounter2));
                            playListText12.setText(playList.get(musicHolder12 + scrollCounter2));
                        }
                    }
                }
                if(isHighlighted7)
                {
                    if(isdefaultSorted&&(playList.contains(songStrings.get(musicHolder7+scrollCounter)))==false)
                    {
                        if (indexCount < 15) {
                            playList.set(indexCount, songStrings.get(musicHolder7+scrollCounter));
                            indexCount++;
                            queueList = Algorithms.shuffle(playList);
                            queueListText1.setText(queueList.get(musicHolder1 + scrollCounter2));
                            queueListText2.setText(queueList.get(musicHolder2 + scrollCounter2));
                            queueListText3.setText(queueList.get(musicHolder3 + scrollCounter2));
                            queueListText4.setText(queueList.get(musicHolder4 + scrollCounter2));
                            queueListText5.setText(queueList.get(musicHolder5 + scrollCounter2));
                            queueListText6.setText(queueList.get(musicHolder6 + scrollCounter2));
                            queueListText7.setText(queueList.get(musicHolder7 + scrollCounter2));
                            queueListText8.setText(queueList.get(musicHolder8 + scrollCounter2));
                            queueListText9.setText(queueList.get(musicHolder9 + scrollCounter2));
                            queueListText10.setText(queueList.get(musicHolder10 + scrollCounter2));
                            queueListText11.setText(queueList.get(musicHolder11 + scrollCounter2));
                            queueListText12.setText(queueList.get(musicHolder12 + scrollCounter2));
                            playListText1.setText(playList.get(musicHolder1 + scrollCounter2));
                            playListText2.setText(playList.get(musicHolder2 + scrollCounter2));
                            playListText3.setText(playList.get(musicHolder3 + scrollCounter2));
                            playListText4.setText(playList.get(musicHolder4 + scrollCounter2));
                            playListText5.setText(playList.get(musicHolder5 + scrollCounter2));
                            playListText6.setText(playList.get(musicHolder6 + scrollCounter2));
                            playListText7.setText(playList.get(musicHolder7 + scrollCounter2));
                            playListText8.setText(playList.get(musicHolder8 + scrollCounter2));
                            playListText9.setText(playList.get(musicHolder9 + scrollCounter2));
                            playListText10.setText(playList.get(musicHolder10 + scrollCounter2));
                            playListText11.setText(playList.get(musicHolder11 + scrollCounter2));
                            playListText12.setText(playList.get(musicHolder12 + scrollCounter2));
                        }
                    }
                    if(isalphabeticalSorted&&(playList.contains(alphabeticalSorted.get(musicHolder7+scrollCounter)))==false)
                    {
                        if (indexCount < 15) {
                            playList.set(indexCount, alphabeticalSorted.get(musicHolder7+scrollCounter));
                            indexCount++;
                            queueList = Algorithms.shuffle(playList);
                            queueListText1.setText(queueList.get(musicHolder1 + scrollCounter2));
                            queueListText2.setText(queueList.get(musicHolder2 + scrollCounter2));
                            queueListText3.setText(queueList.get(musicHolder3 + scrollCounter2));
                            queueListText4.setText(queueList.get(musicHolder4 + scrollCounter2));
                            queueListText5.setText(queueList.get(musicHolder5 + scrollCounter2));
                            queueListText6.setText(queueList.get(musicHolder6 + scrollCounter2));
                            queueListText7.setText(queueList.get(musicHolder7 + scrollCounter2));
                            queueListText8.setText(queueList.get(musicHolder8 + scrollCounter2));
                            queueListText9.setText(queueList.get(musicHolder9 + scrollCounter2));
                            queueListText10.setText(queueList.get(musicHolder10 + scrollCounter2));
                            queueListText11.setText(queueList.get(musicHolder11 + scrollCounter2));
                            queueListText12.setText(queueList.get(musicHolder12 + scrollCounter2));
                            playListText1.setText(playList.get(musicHolder1 + scrollCounter2));
                            playListText2.setText(playList.get(musicHolder2 + scrollCounter2));
                            playListText3.setText(playList.get(musicHolder3 + scrollCounter2));
                            playListText4.setText(playList.get(musicHolder4 + scrollCounter2));
                            playListText5.setText(playList.get(musicHolder5 + scrollCounter2));
                            playListText6.setText(playList.get(musicHolder6 + scrollCounter2));
                            playListText7.setText(playList.get(musicHolder7 + scrollCounter2));
                            playListText8.setText(playList.get(musicHolder8 + scrollCounter2));
                            playListText9.setText(playList.get(musicHolder9 + scrollCounter2));
                            playListText10.setText(playList.get(musicHolder10 + scrollCounter2));
                            playListText11.setText(playList.get(musicHolder11 + scrollCounter2));
                            playListText12.setText(playList.get(musicHolder12 + scrollCounter2));
                        }
                    }
                    if(isreversealphabeticalSorted&&(playList.contains(reversealphabeticalSorted.get(musicHolder7+scrollCounter)))==false)
                    {
                        if (indexCount < 15) {
                            playList.set(indexCount, reversealphabeticalSorted.get(musicHolder7+scrollCounter));
                            indexCount++;
                            queueList = Algorithms.shuffle(playList);
                            queueListText1.setText(queueList.get(musicHolder1 + scrollCounter2));
                            queueListText2.setText(queueList.get(musicHolder2 + scrollCounter2));
                            queueListText3.setText(queueList.get(musicHolder3 + scrollCounter2));
                            queueListText4.setText(queueList.get(musicHolder4 + scrollCounter2));
                            queueListText5.setText(queueList.get(musicHolder5 + scrollCounter2));
                            queueListText6.setText(queueList.get(musicHolder6 + scrollCounter2));
                            queueListText7.setText(queueList.get(musicHolder7 + scrollCounter2));
                            queueListText8.setText(queueList.get(musicHolder8 + scrollCounter2));
                            queueListText9.setText(queueList.get(musicHolder9 + scrollCounter2));
                            queueListText10.setText(queueList.get(musicHolder10 + scrollCounter2));
                            queueListText11.setText(queueList.get(musicHolder11 + scrollCounter2));
                            queueListText12.setText(queueList.get(musicHolder12 + scrollCounter2));
                            playListText1.setText(playList.get(musicHolder1 + scrollCounter2));
                            playListText2.setText(playList.get(musicHolder2 + scrollCounter2));
                            playListText3.setText(playList.get(musicHolder3 + scrollCounter2));
                            playListText4.setText(playList.get(musicHolder4 + scrollCounter2));
                            playListText5.setText(playList.get(musicHolder5 + scrollCounter2));
                            playListText6.setText(playList.get(musicHolder6 + scrollCounter2));
                            playListText7.setText(playList.get(musicHolder7 + scrollCounter2));
                            playListText8.setText(playList.get(musicHolder8 + scrollCounter2));
                            playListText9.setText(playList.get(musicHolder9 + scrollCounter2));
                            playListText10.setText(playList.get(musicHolder10 + scrollCounter2));
                            playListText11.setText(playList.get(musicHolder11 + scrollCounter2));
                            playListText12.setText(playList.get(musicHolder12 + scrollCounter2));
                        }
                    }
                    if(ispopularitySorted&&(playList.contains(popularitySorted.get(musicHolder7+scrollCounter)))==false)
                    {
                        if (indexCount < 15) {
                            playList.set(indexCount, popularitySorted.get(musicHolder7+scrollCounter));
                            indexCount++;
                            queueList = Algorithms.shuffle(playList);
                            queueListText1.setText(queueList.get(musicHolder1 + scrollCounter2));
                            queueListText2.setText(queueList.get(musicHolder2 + scrollCounter2));
                            queueListText3.setText(queueList.get(musicHolder3 + scrollCounter2));
                            queueListText4.setText(queueList.get(musicHolder4 + scrollCounter2));
                            queueListText5.setText(queueList.get(musicHolder5 + scrollCounter2));
                            queueListText6.setText(queueList.get(musicHolder6 + scrollCounter2));
                            queueListText7.setText(queueList.get(musicHolder7 + scrollCounter2));
                            queueListText8.setText(queueList.get(musicHolder8 + scrollCounter2));
                            queueListText9.setText(queueList.get(musicHolder9 + scrollCounter2));
                            queueListText10.setText(queueList.get(musicHolder10 + scrollCounter2));
                            queueListText11.setText(queueList.get(musicHolder11 + scrollCounter2));
                            queueListText12.setText(queueList.get(musicHolder12 + scrollCounter2));
                            playListText1.setText(playList.get(musicHolder1 + scrollCounter2));
                            playListText2.setText(playList.get(musicHolder2 + scrollCounter2));
                            playListText3.setText(playList.get(musicHolder3 + scrollCounter2));
                            playListText4.setText(playList.get(musicHolder4 + scrollCounter2));
                            playListText5.setText(playList.get(musicHolder5 + scrollCounter2));
                            playListText6.setText(playList.get(musicHolder6 + scrollCounter2));
                            playListText7.setText(playList.get(musicHolder7 + scrollCounter2));
                            playListText8.setText(playList.get(musicHolder8 + scrollCounter2));
                            playListText9.setText(playList.get(musicHolder9 + scrollCounter2));
                            playListText10.setText(playList.get(musicHolder10 + scrollCounter2));
                            playListText11.setText(playList.get(musicHolder11 + scrollCounter2));
                            playListText12.setText(playList.get(musicHolder12 + scrollCounter2));
                        }
                    }
                    if(isreversepopularitySorted&&(playList.contains(reversepopularitySorted.get(musicHolder7+scrollCounter)))==false)
                    {
                        if (indexCount < 15) {
                            playList.set(indexCount, reversepopularitySorted.get(musicHolder7+scrollCounter));
                            indexCount++;
                            queueList = Algorithms.shuffle(playList);
                            queueListText1.setText(queueList.get(musicHolder1 + scrollCounter2));
                            queueListText2.setText(queueList.get(musicHolder2 + scrollCounter2));
                            queueListText3.setText(queueList.get(musicHolder3 + scrollCounter2));
                            queueListText4.setText(queueList.get(musicHolder4 + scrollCounter2));
                            queueListText5.setText(queueList.get(musicHolder5 + scrollCounter2));
                            queueListText6.setText(queueList.get(musicHolder6 + scrollCounter2));
                            queueListText7.setText(queueList.get(musicHolder7 + scrollCounter2));
                            queueListText8.setText(queueList.get(musicHolder8 + scrollCounter2));
                            queueListText9.setText(queueList.get(musicHolder9 + scrollCounter2));
                            queueListText10.setText(queueList.get(musicHolder10 + scrollCounter2));
                            queueListText11.setText(queueList.get(musicHolder11 + scrollCounter2));
                            queueListText12.setText(queueList.get(musicHolder12 + scrollCounter2));
                            playListText1.setText(playList.get(musicHolder1 + scrollCounter2));
                            playListText2.setText(playList.get(musicHolder2 + scrollCounter2));
                            playListText3.setText(playList.get(musicHolder3 + scrollCounter2));
                            playListText4.setText(playList.get(musicHolder4 + scrollCounter2));
                            playListText5.setText(playList.get(musicHolder5 + scrollCounter2));
                            playListText6.setText(playList.get(musicHolder6 + scrollCounter2));
                            playListText7.setText(playList.get(musicHolder7 + scrollCounter2));
                            playListText8.setText(playList.get(musicHolder8 + scrollCounter2));
                            playListText9.setText(playList.get(musicHolder9 + scrollCounter2));
                            playListText10.setText(playList.get(musicHolder10 + scrollCounter2));
                            playListText11.setText(playList.get(musicHolder11 + scrollCounter2));
                            playListText12.setText(playList.get(musicHolder12 + scrollCounter2));
                        }
                    }
                }
                if(isHighlighted8)
                {
                    if(isdefaultSorted&&(playList.contains(songStrings.get(musicHolder8+scrollCounter)))==false)
                    {
                        if (indexCount < 15) {
                            playList.set(indexCount, songStrings.get(musicHolder8+scrollCounter));
                            indexCount++;
                            queueList = Algorithms.shuffle(playList);
                            queueListText1.setText(queueList.get(musicHolder1 + scrollCounter2));
                            queueListText2.setText(queueList.get(musicHolder2 + scrollCounter2));
                            queueListText3.setText(queueList.get(musicHolder3 + scrollCounter2));
                            queueListText4.setText(queueList.get(musicHolder4 + scrollCounter2));
                            queueListText5.setText(queueList.get(musicHolder5 + scrollCounter2));
                            queueListText6.setText(queueList.get(musicHolder6 + scrollCounter2));
                            queueListText7.setText(queueList.get(musicHolder7 + scrollCounter2));
                            queueListText8.setText(queueList.get(musicHolder8 + scrollCounter2));
                            queueListText9.setText(queueList.get(musicHolder9 + scrollCounter2));
                            queueListText10.setText(queueList.get(musicHolder10 + scrollCounter2));
                            queueListText11.setText(queueList.get(musicHolder11 + scrollCounter2));
                            queueListText12.setText(queueList.get(musicHolder12 + scrollCounter2));
                            playListText1.setText(playList.get(musicHolder1 + scrollCounter2));
                            playListText2.setText(playList.get(musicHolder2 + scrollCounter2));
                            playListText3.setText(playList.get(musicHolder3 + scrollCounter2));
                            playListText4.setText(playList.get(musicHolder4 + scrollCounter2));
                            playListText5.setText(playList.get(musicHolder5 + scrollCounter2));
                            playListText6.setText(playList.get(musicHolder6 + scrollCounter2));
                            playListText7.setText(playList.get(musicHolder7 + scrollCounter2));
                            playListText8.setText(playList.get(musicHolder8 + scrollCounter2));
                            playListText9.setText(playList.get(musicHolder9 + scrollCounter2));
                            playListText10.setText(playList.get(musicHolder10 + scrollCounter2));
                            playListText11.setText(playList.get(musicHolder11 + scrollCounter2));
                            playListText12.setText(playList.get(musicHolder12 + scrollCounter2));
                        }
                    }
                    if(isalphabeticalSorted&&(playList.contains(alphabeticalSorted.get(musicHolder8+scrollCounter)))==false)
                    {
                        if (indexCount < 15) {
                            playList.set(indexCount, alphabeticalSorted.get(musicHolder8+scrollCounter));
                            indexCount++;
                            queueList = Algorithms.shuffle(playList);
                            queueListText1.setText(queueList.get(musicHolder1 + scrollCounter2));
                            queueListText2.setText(queueList.get(musicHolder2 + scrollCounter2));
                            queueListText3.setText(queueList.get(musicHolder3 + scrollCounter2));
                            queueListText4.setText(queueList.get(musicHolder4 + scrollCounter2));
                            queueListText5.setText(queueList.get(musicHolder5 + scrollCounter2));
                            queueListText6.setText(queueList.get(musicHolder6 + scrollCounter2));
                            queueListText7.setText(queueList.get(musicHolder7 + scrollCounter2));
                            queueListText8.setText(queueList.get(musicHolder8 + scrollCounter2));
                            queueListText9.setText(queueList.get(musicHolder9 + scrollCounter2));
                            queueListText10.setText(queueList.get(musicHolder10 + scrollCounter2));
                            queueListText11.setText(queueList.get(musicHolder11 + scrollCounter2));
                            queueListText12.setText(queueList.get(musicHolder12 + scrollCounter2));
                            playListText1.setText(playList.get(musicHolder1 + scrollCounter2));
                            playListText2.setText(playList.get(musicHolder2 + scrollCounter2));
                            playListText3.setText(playList.get(musicHolder3 + scrollCounter2));
                            playListText4.setText(playList.get(musicHolder4 + scrollCounter2));
                            playListText5.setText(playList.get(musicHolder5 + scrollCounter2));
                            playListText6.setText(playList.get(musicHolder6 + scrollCounter2));
                            playListText7.setText(playList.get(musicHolder7 + scrollCounter2));
                            playListText8.setText(playList.get(musicHolder8 + scrollCounter2));
                            playListText9.setText(playList.get(musicHolder9 + scrollCounter2));
                            playListText10.setText(playList.get(musicHolder10 + scrollCounter2));
                            playListText11.setText(playList.get(musicHolder11 + scrollCounter2));
                            playListText12.setText(playList.get(musicHolder12 + scrollCounter2));
                        }
                    }
                    if(isreversealphabeticalSorted&&(playList.contains(reversealphabeticalSorted.get(musicHolder8+scrollCounter)))==false)
                    {
                        if (indexCount < 15) {
                            playList.set(indexCount, reversealphabeticalSorted.get(musicHolder8+scrollCounter));
                            indexCount++;
                            queueList = Algorithms.shuffle(playList);
                            queueListText1.setText(queueList.get(musicHolder1 + scrollCounter2));
                            queueListText2.setText(queueList.get(musicHolder2 + scrollCounter2));
                            queueListText3.setText(queueList.get(musicHolder3 + scrollCounter2));
                            queueListText4.setText(queueList.get(musicHolder4 + scrollCounter2));
                            queueListText5.setText(queueList.get(musicHolder5 + scrollCounter2));
                            queueListText6.setText(queueList.get(musicHolder6 + scrollCounter2));
                            queueListText7.setText(queueList.get(musicHolder7 + scrollCounter2));
                            queueListText8.setText(queueList.get(musicHolder8 + scrollCounter2));
                            queueListText9.setText(queueList.get(musicHolder9 + scrollCounter2));
                            queueListText10.setText(queueList.get(musicHolder10 + scrollCounter2));
                            queueListText11.setText(queueList.get(musicHolder11 + scrollCounter2));
                            queueListText12.setText(queueList.get(musicHolder12 + scrollCounter2));
                            playListText1.setText(playList.get(musicHolder1 + scrollCounter2));
                            playListText2.setText(playList.get(musicHolder2 + scrollCounter2));
                            playListText3.setText(playList.get(musicHolder3 + scrollCounter2));
                            playListText4.setText(playList.get(musicHolder4 + scrollCounter2));
                            playListText5.setText(playList.get(musicHolder5 + scrollCounter2));
                            playListText6.setText(playList.get(musicHolder6 + scrollCounter2));
                            playListText7.setText(playList.get(musicHolder7 + scrollCounter2));
                            playListText8.setText(playList.get(musicHolder8 + scrollCounter2));
                            playListText9.setText(playList.get(musicHolder9 + scrollCounter2));
                            playListText10.setText(playList.get(musicHolder10 + scrollCounter2));
                            playListText11.setText(playList.get(musicHolder11 + scrollCounter2));
                            playListText12.setText(playList.get(musicHolder12 + scrollCounter2));
                        }
                    }
                    if(ispopularitySorted&&(playList.contains(popularitySorted.get(musicHolder8+scrollCounter)))==false)
                    {
                        if (indexCount < 15) {
                            playList.set(indexCount, popularitySorted.get(musicHolder8+scrollCounter));
                            indexCount++;
                            queueList = Algorithms.shuffle(playList);
                            queueListText1.setText(queueList.get(musicHolder1 + scrollCounter2));
                            queueListText2.setText(queueList.get(musicHolder2 + scrollCounter2));
                            queueListText3.setText(queueList.get(musicHolder3 + scrollCounter2));
                            queueListText4.setText(queueList.get(musicHolder4 + scrollCounter2));
                            queueListText5.setText(queueList.get(musicHolder5 + scrollCounter2));
                            queueListText6.setText(queueList.get(musicHolder6 + scrollCounter2));
                            queueListText7.setText(queueList.get(musicHolder7 + scrollCounter2));
                            queueListText8.setText(queueList.get(musicHolder8 + scrollCounter2));
                            queueListText9.setText(queueList.get(musicHolder9 + scrollCounter2));
                            queueListText10.setText(queueList.get(musicHolder10 + scrollCounter2));
                            queueListText11.setText(queueList.get(musicHolder11 + scrollCounter2));
                            queueListText12.setText(queueList.get(musicHolder12 + scrollCounter2));
                            playListText1.setText(playList.get(musicHolder1 + scrollCounter2));
                            playListText2.setText(playList.get(musicHolder2 + scrollCounter2));
                            playListText3.setText(playList.get(musicHolder3 + scrollCounter2));
                            playListText4.setText(playList.get(musicHolder4 + scrollCounter2));
                            playListText5.setText(playList.get(musicHolder5 + scrollCounter2));
                            playListText6.setText(playList.get(musicHolder6 + scrollCounter2));
                            playListText7.setText(playList.get(musicHolder7 + scrollCounter2));
                            playListText8.setText(playList.get(musicHolder8 + scrollCounter2));
                            playListText9.setText(playList.get(musicHolder9 + scrollCounter2));
                            playListText10.setText(playList.get(musicHolder10 + scrollCounter2));
                            playListText11.setText(playList.get(musicHolder11 + scrollCounter2));
                            playListText12.setText(playList.get(musicHolder12 + scrollCounter2));
                        }
                    }
                    if(isreversepopularitySorted&&(playList.contains(reversepopularitySorted.get(musicHolder8+scrollCounter)))==false)
                    {
                        if (indexCount < 15) {
                            playList.set(indexCount, reversepopularitySorted.get(musicHolder8+scrollCounter));
                            indexCount++;
                            queueList = Algorithms.shuffle(playList);
                            queueListText1.setText(queueList.get(musicHolder1 + scrollCounter2));
                            queueListText2.setText(queueList.get(musicHolder2 + scrollCounter2));
                            queueListText3.setText(queueList.get(musicHolder3 + scrollCounter2));
                            queueListText4.setText(queueList.get(musicHolder4 + scrollCounter2));
                            queueListText5.setText(queueList.get(musicHolder5 + scrollCounter2));
                            queueListText6.setText(queueList.get(musicHolder6 + scrollCounter2));
                            queueListText7.setText(queueList.get(musicHolder7 + scrollCounter2));
                            queueListText8.setText(queueList.get(musicHolder8 + scrollCounter2));
                            queueListText9.setText(queueList.get(musicHolder9 + scrollCounter2));
                            queueListText10.setText(queueList.get(musicHolder10 + scrollCounter2));
                            queueListText11.setText(queueList.get(musicHolder11 + scrollCounter2));
                            queueListText12.setText(queueList.get(musicHolder12 + scrollCounter2));
                            playListText1.setText(playList.get(musicHolder1 + scrollCounter2));
                            playListText2.setText(playList.get(musicHolder2 + scrollCounter2));
                            playListText3.setText(playList.get(musicHolder3 + scrollCounter2));
                            playListText4.setText(playList.get(musicHolder4 + scrollCounter2));
                            playListText5.setText(playList.get(musicHolder5 + scrollCounter2));
                            playListText6.setText(playList.get(musicHolder6 + scrollCounter2));
                            playListText7.setText(playList.get(musicHolder7 + scrollCounter2));
                            playListText8.setText(playList.get(musicHolder8 + scrollCounter2));
                            playListText9.setText(playList.get(musicHolder9 + scrollCounter2));
                            playListText10.setText(playList.get(musicHolder10 + scrollCounter2));
                            playListText11.setText(playList.get(musicHolder11 + scrollCounter2));
                            playListText12.setText(playList.get(musicHolder12 + scrollCounter2));
                        }
                    }
                }
                if(isHighlighted9)
                {
                    if(isdefaultSorted&&(playList.contains(songStrings.get(musicHolder9+scrollCounter)))==false)
                    {
                        if (indexCount < 15) {
                            playList.set(indexCount, songStrings.get(musicHolder9+scrollCounter));
                            indexCount++;
                            queueList = Algorithms.shuffle(playList);
                            queueListText1.setText(queueList.get(musicHolder1 + scrollCounter2));
                            queueListText2.setText(queueList.get(musicHolder2 + scrollCounter2));
                            queueListText3.setText(queueList.get(musicHolder3 + scrollCounter2));
                            queueListText4.setText(queueList.get(musicHolder4 + scrollCounter2));
                            queueListText5.setText(queueList.get(musicHolder5 + scrollCounter2));
                            queueListText6.setText(queueList.get(musicHolder6 + scrollCounter2));
                            queueListText7.setText(queueList.get(musicHolder7 + scrollCounter2));
                            queueListText8.setText(queueList.get(musicHolder8 + scrollCounter2));
                            queueListText9.setText(queueList.get(musicHolder9 + scrollCounter2));
                            queueListText10.setText(queueList.get(musicHolder10 + scrollCounter2));
                            queueListText11.setText(queueList.get(musicHolder11 + scrollCounter2));
                            queueListText12.setText(queueList.get(musicHolder12 + scrollCounter2));
                            playListText1.setText(playList.get(musicHolder1 + scrollCounter2));
                            playListText2.setText(playList.get(musicHolder2 + scrollCounter2));
                            playListText3.setText(playList.get(musicHolder3 + scrollCounter2));
                            playListText4.setText(playList.get(musicHolder4 + scrollCounter2));
                            playListText5.setText(playList.get(musicHolder5 + scrollCounter2));
                            playListText6.setText(playList.get(musicHolder6 + scrollCounter2));
                            playListText7.setText(playList.get(musicHolder7 + scrollCounter2));
                            playListText8.setText(playList.get(musicHolder8 + scrollCounter2));
                            playListText9.setText(playList.get(musicHolder9 + scrollCounter2));
                            playListText10.setText(playList.get(musicHolder10 + scrollCounter2));
                            playListText11.setText(playList.get(musicHolder11 + scrollCounter2));
                            playListText12.setText(playList.get(musicHolder12 + scrollCounter2));
                        }
                    }
                    if(isalphabeticalSorted&&(playList.contains(alphabeticalSorted.get(musicHolder9+scrollCounter)))==false)
                    {
                        if (indexCount < 15) {
                            playList.set(indexCount, alphabeticalSorted.get(musicHolder9+scrollCounter));
                            indexCount++;
                            queueList = Algorithms.shuffle(playList);
                            queueListText1.setText(queueList.get(musicHolder1 + scrollCounter2));
                            queueListText2.setText(queueList.get(musicHolder2 + scrollCounter2));
                            queueListText3.setText(queueList.get(musicHolder3 + scrollCounter2));
                            queueListText4.setText(queueList.get(musicHolder4 + scrollCounter2));
                            queueListText5.setText(queueList.get(musicHolder5 + scrollCounter2));
                            queueListText6.setText(queueList.get(musicHolder6 + scrollCounter2));
                            queueListText7.setText(queueList.get(musicHolder7 + scrollCounter2));
                            queueListText8.setText(queueList.get(musicHolder8 + scrollCounter2));
                            queueListText9.setText(queueList.get(musicHolder9 + scrollCounter2));
                            queueListText10.setText(queueList.get(musicHolder10 + scrollCounter2));
                            queueListText11.setText(queueList.get(musicHolder11 + scrollCounter2));
                            queueListText12.setText(queueList.get(musicHolder12 + scrollCounter2));
                            playListText1.setText(playList.get(musicHolder1 + scrollCounter2));
                            playListText2.setText(playList.get(musicHolder2 + scrollCounter2));
                            playListText3.setText(playList.get(musicHolder3 + scrollCounter2));
                            playListText4.setText(playList.get(musicHolder4 + scrollCounter2));
                            playListText5.setText(playList.get(musicHolder5 + scrollCounter2));
                            playListText6.setText(playList.get(musicHolder6 + scrollCounter2));
                            playListText7.setText(playList.get(musicHolder7 + scrollCounter2));
                            playListText8.setText(playList.get(musicHolder8 + scrollCounter2));
                            playListText9.setText(playList.get(musicHolder9 + scrollCounter2));
                            playListText10.setText(playList.get(musicHolder10 + scrollCounter2));
                            playListText11.setText(playList.get(musicHolder11 + scrollCounter2));
                            playListText12.setText(playList.get(musicHolder12 + scrollCounter2));
                        }
                    }
                    if(isreversealphabeticalSorted&&(playList.contains(reversealphabeticalSorted.get(musicHolder9+scrollCounter)))==false)
                    {
                        if (indexCount < 15) {
                            playList.set(indexCount, reversealphabeticalSorted.get(musicHolder9+scrollCounter));
                            indexCount++;
                            queueList = Algorithms.shuffle(playList);
                            queueListText1.setText(queueList.get(musicHolder1 + scrollCounter2));
                            queueListText2.setText(queueList.get(musicHolder2 + scrollCounter2));
                            queueListText3.setText(queueList.get(musicHolder3 + scrollCounter2));
                            queueListText4.setText(queueList.get(musicHolder4 + scrollCounter2));
                            queueListText5.setText(queueList.get(musicHolder5 + scrollCounter2));
                            queueListText6.setText(queueList.get(musicHolder6 + scrollCounter2));
                            queueListText7.setText(queueList.get(musicHolder7 + scrollCounter2));
                            queueListText8.setText(queueList.get(musicHolder8 + scrollCounter2));
                            queueListText9.setText(queueList.get(musicHolder9 + scrollCounter2));
                            queueListText10.setText(queueList.get(musicHolder10 + scrollCounter2));
                            queueListText11.setText(queueList.get(musicHolder11 + scrollCounter2));
                            queueListText12.setText(queueList.get(musicHolder12 + scrollCounter2));
                            playListText1.setText(playList.get(musicHolder1 + scrollCounter2));
                            playListText2.setText(playList.get(musicHolder2 + scrollCounter2));
                            playListText3.setText(playList.get(musicHolder3 + scrollCounter2));
                            playListText4.setText(playList.get(musicHolder4 + scrollCounter2));
                            playListText5.setText(playList.get(musicHolder5 + scrollCounter2));
                            playListText6.setText(playList.get(musicHolder6 + scrollCounter2));
                            playListText7.setText(playList.get(musicHolder7 + scrollCounter2));
                            playListText8.setText(playList.get(musicHolder8 + scrollCounter2));
                            playListText9.setText(playList.get(musicHolder9 + scrollCounter2));
                            playListText10.setText(playList.get(musicHolder10 + scrollCounter2));
                            playListText11.setText(playList.get(musicHolder11 + scrollCounter2));
                            playListText12.setText(playList.get(musicHolder12 + scrollCounter2));
                        }
                    }
                    if(ispopularitySorted&&(playList.contains(popularitySorted.get(musicHolder9+scrollCounter)))==false)
                    {
                        if (indexCount < 15) {
                            playList.set(indexCount, popularitySorted.get(musicHolder9+scrollCounter));
                            indexCount++;
                            queueList = Algorithms.shuffle(playList);
                            queueListText1.setText(queueList.get(musicHolder1 + scrollCounter2));
                            queueListText2.setText(queueList.get(musicHolder2 + scrollCounter2));
                            queueListText3.setText(queueList.get(musicHolder3 + scrollCounter2));
                            queueListText4.setText(queueList.get(musicHolder4 + scrollCounter2));
                            queueListText5.setText(queueList.get(musicHolder5 + scrollCounter2));
                            queueListText6.setText(queueList.get(musicHolder6 + scrollCounter2));
                            queueListText7.setText(queueList.get(musicHolder7 + scrollCounter2));
                            queueListText8.setText(queueList.get(musicHolder8 + scrollCounter2));
                            queueListText9.setText(queueList.get(musicHolder9 + scrollCounter2));
                            queueListText10.setText(queueList.get(musicHolder10 + scrollCounter2));
                            queueListText11.setText(queueList.get(musicHolder11 + scrollCounter2));
                            queueListText12.setText(queueList.get(musicHolder12 + scrollCounter2));
                            playListText1.setText(playList.get(musicHolder1 + scrollCounter2));
                            playListText2.setText(playList.get(musicHolder2 + scrollCounter2));
                            playListText3.setText(playList.get(musicHolder3 + scrollCounter2));
                            playListText4.setText(playList.get(musicHolder4 + scrollCounter2));
                            playListText5.setText(playList.get(musicHolder5 + scrollCounter2));
                            playListText6.setText(playList.get(musicHolder6 + scrollCounter2));
                            playListText7.setText(playList.get(musicHolder7 + scrollCounter2));
                            playListText8.setText(playList.get(musicHolder8 + scrollCounter2));
                            playListText9.setText(playList.get(musicHolder9 + scrollCounter2));
                            playListText10.setText(playList.get(musicHolder10 + scrollCounter2));
                            playListText11.setText(playList.get(musicHolder11 + scrollCounter2));
                            playListText12.setText(playList.get(musicHolder12 + scrollCounter2));
                        }
                    }
                    if(isreversepopularitySorted&&(playList.contains(reversepopularitySorted.get(musicHolder9+scrollCounter)))==false)
                    {
                        if (indexCount < 15) {
                            playList.set(indexCount, reversepopularitySorted.get(musicHolder9+scrollCounter));
                            indexCount++;
                            queueList = Algorithms.shuffle(playList);
                            queueListText1.setText(queueList.get(musicHolder1 + scrollCounter2));
                            queueListText2.setText(queueList.get(musicHolder2 + scrollCounter2));
                            queueListText3.setText(queueList.get(musicHolder3 + scrollCounter2));
                            queueListText4.setText(queueList.get(musicHolder4 + scrollCounter2));
                            queueListText5.setText(queueList.get(musicHolder5 + scrollCounter2));
                            queueListText6.setText(queueList.get(musicHolder6 + scrollCounter2));
                            queueListText7.setText(queueList.get(musicHolder7 + scrollCounter2));
                            queueListText8.setText(queueList.get(musicHolder8 + scrollCounter2));
                            queueListText9.setText(queueList.get(musicHolder9 + scrollCounter2));
                            queueListText10.setText(queueList.get(musicHolder10 + scrollCounter2));
                            queueListText11.setText(queueList.get(musicHolder11 + scrollCounter2));
                            queueListText12.setText(queueList.get(musicHolder12 + scrollCounter2));
                            playListText1.setText(playList.get(musicHolder1 + scrollCounter2));
                            playListText2.setText(playList.get(musicHolder2 + scrollCounter2));
                            playListText3.setText(playList.get(musicHolder3 + scrollCounter2));
                            playListText4.setText(playList.get(musicHolder4 + scrollCounter2));
                            playListText5.setText(playList.get(musicHolder5 + scrollCounter2));
                            playListText6.setText(playList.get(musicHolder6 + scrollCounter2));
                            playListText7.setText(playList.get(musicHolder7 + scrollCounter2));
                            playListText8.setText(playList.get(musicHolder8 + scrollCounter2));
                            playListText9.setText(playList.get(musicHolder9 + scrollCounter2));
                            playListText10.setText(playList.get(musicHolder10 + scrollCounter2));
                            playListText11.setText(playList.get(musicHolder11 + scrollCounter2));
                            playListText12.setText(playList.get(musicHolder12 + scrollCounter2));
                        }
                    }
                }
                if(isHighlighted10)
                {
                    if(isdefaultSorted&&(playList.contains(songStrings.get(musicHolder10+scrollCounter)))==false)
                    {
                        if (indexCount < 15) {
                            playList.set(indexCount, songStrings.get(musicHolder10+scrollCounter));
                            indexCount++;
                            queueList = Algorithms.shuffle(playList);
                            queueListText1.setText(queueList.get(musicHolder1 + scrollCounter2));
                            queueListText2.setText(queueList.get(musicHolder2 + scrollCounter2));
                            queueListText3.setText(queueList.get(musicHolder3 + scrollCounter2));
                            queueListText4.setText(queueList.get(musicHolder4 + scrollCounter2));
                            queueListText5.setText(queueList.get(musicHolder5 + scrollCounter2));
                            queueListText6.setText(queueList.get(musicHolder6 + scrollCounter2));
                            queueListText7.setText(queueList.get(musicHolder7 + scrollCounter2));
                            queueListText8.setText(queueList.get(musicHolder8 + scrollCounter2));
                            queueListText9.setText(queueList.get(musicHolder9 + scrollCounter2));
                            queueListText10.setText(queueList.get(musicHolder10 + scrollCounter2));
                            queueListText11.setText(queueList.get(musicHolder11 + scrollCounter2));
                            queueListText12.setText(queueList.get(musicHolder12 + scrollCounter2));
                            playListText1.setText(playList.get(musicHolder1 + scrollCounter2));
                            playListText2.setText(playList.get(musicHolder2 + scrollCounter2));
                            playListText3.setText(playList.get(musicHolder3 + scrollCounter2));
                            playListText4.setText(playList.get(musicHolder4 + scrollCounter2));
                            playListText5.setText(playList.get(musicHolder5 + scrollCounter2));
                            playListText6.setText(playList.get(musicHolder6 + scrollCounter2));
                            playListText7.setText(playList.get(musicHolder7 + scrollCounter2));
                            playListText8.setText(playList.get(musicHolder8 + scrollCounter2));
                            playListText9.setText(playList.get(musicHolder9 + scrollCounter2));
                            playListText10.setText(playList.get(musicHolder10 + scrollCounter2));
                            playListText11.setText(playList.get(musicHolder11 + scrollCounter2));
                            playListText12.setText(playList.get(musicHolder12 + scrollCounter2));
                        }
                    }
                    if(isalphabeticalSorted&&(playList.contains(alphabeticalSorted.get(musicHolder10+scrollCounter)))==false)
                    {
                        if (indexCount < 15) {
                            playList.set(indexCount, alphabeticalSorted.get(musicHolder10+scrollCounter));
                            indexCount++;
                            queueList = Algorithms.shuffle(playList);
                            queueListText1.setText(queueList.get(musicHolder1 + scrollCounter2));
                            queueListText2.setText(queueList.get(musicHolder2 + scrollCounter2));
                            queueListText3.setText(queueList.get(musicHolder3 + scrollCounter2));
                            queueListText4.setText(queueList.get(musicHolder4 + scrollCounter2));
                            queueListText5.setText(queueList.get(musicHolder5 + scrollCounter2));
                            queueListText6.setText(queueList.get(musicHolder6 + scrollCounter2));
                            queueListText7.setText(queueList.get(musicHolder7 + scrollCounter2));
                            queueListText8.setText(queueList.get(musicHolder8 + scrollCounter2));
                            queueListText9.setText(queueList.get(musicHolder9 + scrollCounter2));
                            queueListText10.setText(queueList.get(musicHolder10 + scrollCounter2));
                            queueListText11.setText(queueList.get(musicHolder11 + scrollCounter2));
                            queueListText12.setText(queueList.get(musicHolder12 + scrollCounter2));
                            playListText1.setText(playList.get(musicHolder1 + scrollCounter2));
                            playListText2.setText(playList.get(musicHolder2 + scrollCounter2));
                            playListText3.setText(playList.get(musicHolder3 + scrollCounter2));
                            playListText4.setText(playList.get(musicHolder4 + scrollCounter2));
                            playListText5.setText(playList.get(musicHolder5 + scrollCounter2));
                            playListText6.setText(playList.get(musicHolder6 + scrollCounter2));
                            playListText7.setText(playList.get(musicHolder7 + scrollCounter2));
                            playListText8.setText(playList.get(musicHolder8 + scrollCounter2));
                            playListText9.setText(playList.get(musicHolder9 + scrollCounter2));
                            playListText10.setText(playList.get(musicHolder10 + scrollCounter2));
                            playListText11.setText(playList.get(musicHolder11 + scrollCounter2));
                            playListText12.setText(playList.get(musicHolder12 + scrollCounter2));
                        }
                    }
                    if(isreversealphabeticalSorted&&(playList.contains(reversealphabeticalSorted.get(musicHolder10+scrollCounter)))==false)
                    {
                        if (indexCount < 15) {
                            playList.set(indexCount, reversealphabeticalSorted.get(musicHolder10+scrollCounter));
                            indexCount++;
                            queueList = Algorithms.shuffle(playList);
                            queueListText1.setText(queueList.get(musicHolder1 + scrollCounter2));
                            queueListText2.setText(queueList.get(musicHolder2 + scrollCounter2));
                            queueListText3.setText(queueList.get(musicHolder3 + scrollCounter2));
                            queueListText4.setText(queueList.get(musicHolder4 + scrollCounter2));
                            queueListText5.setText(queueList.get(musicHolder5 + scrollCounter2));
                            queueListText6.setText(queueList.get(musicHolder6 + scrollCounter2));
                            queueListText7.setText(queueList.get(musicHolder7 + scrollCounter2));
                            queueListText8.setText(queueList.get(musicHolder8 + scrollCounter2));
                            queueListText9.setText(queueList.get(musicHolder9 + scrollCounter2));
                            queueListText10.setText(queueList.get(musicHolder10 + scrollCounter2));
                            queueListText11.setText(queueList.get(musicHolder11 + scrollCounter2));
                            queueListText12.setText(queueList.get(musicHolder12 + scrollCounter2));
                            playListText1.setText(playList.get(musicHolder1 + scrollCounter2));
                            playListText2.setText(playList.get(musicHolder2 + scrollCounter2));
                            playListText3.setText(playList.get(musicHolder3 + scrollCounter2));
                            playListText4.setText(playList.get(musicHolder4 + scrollCounter2));
                            playListText5.setText(playList.get(musicHolder5 + scrollCounter2));
                            playListText6.setText(playList.get(musicHolder6 + scrollCounter2));
                            playListText7.setText(playList.get(musicHolder7 + scrollCounter2));
                            playListText8.setText(playList.get(musicHolder8 + scrollCounter2));
                            playListText9.setText(playList.get(musicHolder9 + scrollCounter2));
                            playListText10.setText(playList.get(musicHolder10 + scrollCounter2));
                            playListText11.setText(playList.get(musicHolder11 + scrollCounter2));
                            playListText12.setText(playList.get(musicHolder12 + scrollCounter2));
                        }
                    }
                    if(ispopularitySorted&&(playList.contains(popularitySorted.get(musicHolder10+scrollCounter)))==false)
                    {
                        if (indexCount < 15) {
                            playList.set(indexCount, popularitySorted.get(musicHolder10+scrollCounter));
                            indexCount++;
                            queueList = Algorithms.shuffle(playList);
                            queueListText1.setText(queueList.get(musicHolder1 + scrollCounter2));
                            queueListText2.setText(queueList.get(musicHolder2 + scrollCounter2));
                            queueListText3.setText(queueList.get(musicHolder3 + scrollCounter2));
                            queueListText4.setText(queueList.get(musicHolder4 + scrollCounter2));
                            queueListText5.setText(queueList.get(musicHolder5 + scrollCounter2));
                            queueListText6.setText(queueList.get(musicHolder6 + scrollCounter2));
                            queueListText7.setText(queueList.get(musicHolder7 + scrollCounter2));
                            queueListText8.setText(queueList.get(musicHolder8 + scrollCounter2));
                            queueListText9.setText(queueList.get(musicHolder9 + scrollCounter2));
                            queueListText10.setText(queueList.get(musicHolder10 + scrollCounter2));
                            queueListText11.setText(queueList.get(musicHolder11 + scrollCounter2));
                            queueListText12.setText(queueList.get(musicHolder12 + scrollCounter2));
                            playListText1.setText(playList.get(musicHolder1 + scrollCounter2));
                            playListText2.setText(playList.get(musicHolder2 + scrollCounter2));
                            playListText3.setText(playList.get(musicHolder3 + scrollCounter2));
                            playListText4.setText(playList.get(musicHolder4 + scrollCounter2));
                            playListText5.setText(playList.get(musicHolder5 + scrollCounter2));
                            playListText6.setText(playList.get(musicHolder6 + scrollCounter2));
                            playListText7.setText(playList.get(musicHolder7 + scrollCounter2));
                            playListText8.setText(playList.get(musicHolder8 + scrollCounter2));
                            playListText9.setText(playList.get(musicHolder9 + scrollCounter2));
                            playListText10.setText(playList.get(musicHolder10 + scrollCounter2));
                            playListText11.setText(playList.get(musicHolder11 + scrollCounter2));
                            playListText12.setText(playList.get(musicHolder12 + scrollCounter2));
                        }
                    }
                    if(isreversepopularitySorted&&(playList.contains(reversepopularitySorted.get(musicHolder10+scrollCounter)))==false)
                    {
                        if (indexCount < 15) {
                            playList.set(indexCount, reversepopularitySorted.get(musicHolder10+scrollCounter));
                            indexCount++;
                            queueList = Algorithms.shuffle(playList);
                            queueListText1.setText(queueList.get(musicHolder1 + scrollCounter2));
                            queueListText2.setText(queueList.get(musicHolder2 + scrollCounter2));
                            queueListText3.setText(queueList.get(musicHolder3 + scrollCounter2));
                            queueListText4.setText(queueList.get(musicHolder4 + scrollCounter2));
                            queueListText5.setText(queueList.get(musicHolder5 + scrollCounter2));
                            queueListText6.setText(queueList.get(musicHolder6 + scrollCounter2));
                            queueListText7.setText(queueList.get(musicHolder7 + scrollCounter2));
                            queueListText8.setText(queueList.get(musicHolder8 + scrollCounter2));
                            queueListText9.setText(queueList.get(musicHolder9 + scrollCounter2));
                            queueListText10.setText(queueList.get(musicHolder10 + scrollCounter2));
                            queueListText11.setText(queueList.get(musicHolder11 + scrollCounter2));
                            queueListText12.setText(queueList.get(musicHolder12 + scrollCounter2));
                            playListText1.setText(playList.get(musicHolder1 + scrollCounter2));
                            playListText2.setText(playList.get(musicHolder2 + scrollCounter2));
                            playListText3.setText(playList.get(musicHolder3 + scrollCounter2));
                            playListText4.setText(playList.get(musicHolder4 + scrollCounter2));
                            playListText5.setText(playList.get(musicHolder5 + scrollCounter2));
                            playListText6.setText(playList.get(musicHolder6 + scrollCounter2));
                            playListText7.setText(playList.get(musicHolder7 + scrollCounter2));
                            playListText8.setText(playList.get(musicHolder8 + scrollCounter2));
                            playListText9.setText(playList.get(musicHolder9 + scrollCounter2));
                            playListText10.setText(playList.get(musicHolder10 + scrollCounter2));
                            playListText11.setText(playList.get(musicHolder11 + scrollCounter2));
                            playListText12.setText(playList.get(musicHolder12 + scrollCounter2));
                        }
                    }
                }
                if(isHighlighted11)
                {
                    if(isdefaultSorted&&(playList.contains(songStrings.get(musicHolder11+scrollCounter)))==false)
                    {
                        if (indexCount < 15) {
                            playList.set(indexCount, songStrings.get(musicHolder11+scrollCounter));
                            indexCount++;
                            queueList = Algorithms.shuffle(playList);
                            queueListText1.setText(queueList.get(musicHolder1 + scrollCounter2));
                            queueListText2.setText(queueList.get(musicHolder2 + scrollCounter2));
                            queueListText3.setText(queueList.get(musicHolder3 + scrollCounter2));
                            queueListText4.setText(queueList.get(musicHolder4 + scrollCounter2));
                            queueListText5.setText(queueList.get(musicHolder5 + scrollCounter2));
                            queueListText6.setText(queueList.get(musicHolder6 + scrollCounter2));
                            queueListText7.setText(queueList.get(musicHolder7 + scrollCounter2));
                            queueListText8.setText(queueList.get(musicHolder8 + scrollCounter2));
                            queueListText9.setText(queueList.get(musicHolder9 + scrollCounter2));
                            queueListText10.setText(queueList.get(musicHolder10 + scrollCounter2));
                            queueListText11.setText(queueList.get(musicHolder11 + scrollCounter2));
                            queueListText12.setText(queueList.get(musicHolder12 + scrollCounter2));
                            playListText1.setText(playList.get(musicHolder1 + scrollCounter2));
                            playListText2.setText(playList.get(musicHolder2 + scrollCounter2));
                            playListText3.setText(playList.get(musicHolder3 + scrollCounter2));
                            playListText4.setText(playList.get(musicHolder4 + scrollCounter2));
                            playListText5.setText(playList.get(musicHolder5 + scrollCounter2));
                            playListText6.setText(playList.get(musicHolder6 + scrollCounter2));
                            playListText7.setText(playList.get(musicHolder7 + scrollCounter2));
                            playListText8.setText(playList.get(musicHolder8 + scrollCounter2));
                            playListText9.setText(playList.get(musicHolder9 + scrollCounter2));
                            playListText10.setText(playList.get(musicHolder10 + scrollCounter2));
                            playListText11.setText(playList.get(musicHolder11 + scrollCounter2));
                            playListText12.setText(playList.get(musicHolder12 + scrollCounter2));
                        }
                    }
                    if(isalphabeticalSorted&&(playList.contains(alphabeticalSorted.get(musicHolder11+scrollCounter)))==false)
                    {
                        if (indexCount < 15) {
                            playList.set(indexCount, alphabeticalSorted.get(musicHolder11+scrollCounter));
                            indexCount++;
                            queueList = Algorithms.shuffle(playList);
                            queueListText1.setText(queueList.get(musicHolder1 + scrollCounter2));
                            queueListText2.setText(queueList.get(musicHolder2 + scrollCounter2));
                            queueListText3.setText(queueList.get(musicHolder3 + scrollCounter2));
                            queueListText4.setText(queueList.get(musicHolder4 + scrollCounter2));
                            queueListText5.setText(queueList.get(musicHolder5 + scrollCounter2));
                            queueListText6.setText(queueList.get(musicHolder6 + scrollCounter2));
                            queueListText7.setText(queueList.get(musicHolder7 + scrollCounter2));
                            queueListText8.setText(queueList.get(musicHolder8 + scrollCounter2));
                            queueListText9.setText(queueList.get(musicHolder9 + scrollCounter2));
                            queueListText10.setText(queueList.get(musicHolder10 + scrollCounter2));
                            queueListText11.setText(queueList.get(musicHolder11 + scrollCounter2));
                            queueListText12.setText(queueList.get(musicHolder12 + scrollCounter2));
                            playListText1.setText(playList.get(musicHolder1 + scrollCounter2));
                            playListText2.setText(playList.get(musicHolder2 + scrollCounter2));
                            playListText3.setText(playList.get(musicHolder3 + scrollCounter2));
                            playListText4.setText(playList.get(musicHolder4 + scrollCounter2));
                            playListText5.setText(playList.get(musicHolder5 + scrollCounter2));
                            playListText6.setText(playList.get(musicHolder6 + scrollCounter2));
                            playListText7.setText(playList.get(musicHolder7 + scrollCounter2));
                            playListText8.setText(playList.get(musicHolder8 + scrollCounter2));
                            playListText9.setText(playList.get(musicHolder9 + scrollCounter2));
                            playListText10.setText(playList.get(musicHolder10 + scrollCounter2));
                            playListText11.setText(playList.get(musicHolder11 + scrollCounter2));
                            playListText12.setText(playList.get(musicHolder12 + scrollCounter2));
                        }
                    }
                    if(isreversealphabeticalSorted&&(playList.contains(reversealphabeticalSorted.get(musicHolder11+scrollCounter)))==false)
                    {
                        if (indexCount < 15) {
                            playList.set(indexCount, reversealphabeticalSorted.get(musicHolder11+scrollCounter));
                            indexCount++;
                            queueList = Algorithms.shuffle(playList);
                            queueListText1.setText(queueList.get(musicHolder1 + scrollCounter2));
                            queueListText2.setText(queueList.get(musicHolder2 + scrollCounter2));
                            queueListText3.setText(queueList.get(musicHolder3 + scrollCounter2));
                            queueListText4.setText(queueList.get(musicHolder4 + scrollCounter2));
                            queueListText5.setText(queueList.get(musicHolder5 + scrollCounter2));
                            queueListText6.setText(queueList.get(musicHolder6 + scrollCounter2));
                            queueListText7.setText(queueList.get(musicHolder7 + scrollCounter2));
                            queueListText8.setText(queueList.get(musicHolder8 + scrollCounter2));
                            queueListText9.setText(queueList.get(musicHolder9 + scrollCounter2));
                            queueListText10.setText(queueList.get(musicHolder10 + scrollCounter2));
                            queueListText11.setText(queueList.get(musicHolder11 + scrollCounter2));
                            queueListText12.setText(queueList.get(musicHolder12 + scrollCounter2));
                            playListText1.setText(playList.get(musicHolder1 + scrollCounter2));
                            playListText2.setText(playList.get(musicHolder2 + scrollCounter2));
                            playListText3.setText(playList.get(musicHolder3 + scrollCounter2));
                            playListText4.setText(playList.get(musicHolder4 + scrollCounter2));
                            playListText5.setText(playList.get(musicHolder5 + scrollCounter2));
                            playListText6.setText(playList.get(musicHolder6 + scrollCounter2));
                            playListText7.setText(playList.get(musicHolder7 + scrollCounter2));
                            playListText8.setText(playList.get(musicHolder8 + scrollCounter2));
                            playListText9.setText(playList.get(musicHolder9 + scrollCounter2));
                            playListText10.setText(playList.get(musicHolder10 + scrollCounter2));
                            playListText11.setText(playList.get(musicHolder11 + scrollCounter2));
                            playListText12.setText(playList.get(musicHolder12 + scrollCounter2));
                        }
                    }
                    if(ispopularitySorted&&(playList.contains(popularitySorted.get(musicHolder11+scrollCounter)))==false)
                    {
                        if (indexCount < 15) {
                            playList.set(indexCount, popularitySorted.get(musicHolder11+scrollCounter));
                            indexCount++;
                            queueList = Algorithms.shuffle(playList);
                            queueListText1.setText(queueList.get(musicHolder1 + scrollCounter2));
                            queueListText2.setText(queueList.get(musicHolder2 + scrollCounter2));
                            queueListText3.setText(queueList.get(musicHolder3 + scrollCounter2));
                            queueListText4.setText(queueList.get(musicHolder4 + scrollCounter2));
                            queueListText5.setText(queueList.get(musicHolder5 + scrollCounter2));
                            queueListText6.setText(queueList.get(musicHolder6 + scrollCounter2));
                            queueListText7.setText(queueList.get(musicHolder7 + scrollCounter2));
                            queueListText8.setText(queueList.get(musicHolder8 + scrollCounter2));
                            queueListText9.setText(queueList.get(musicHolder9 + scrollCounter2));
                            queueListText10.setText(queueList.get(musicHolder10 + scrollCounter2));
                            queueListText11.setText(queueList.get(musicHolder11 + scrollCounter2));
                            queueListText12.setText(queueList.get(musicHolder12 + scrollCounter2));
                            playListText1.setText(playList.get(musicHolder1 + scrollCounter2));
                            playListText2.setText(playList.get(musicHolder2 + scrollCounter2));
                            playListText3.setText(playList.get(musicHolder3 + scrollCounter2));
                            playListText4.setText(playList.get(musicHolder4 + scrollCounter2));
                            playListText5.setText(playList.get(musicHolder5 + scrollCounter2));
                            playListText6.setText(playList.get(musicHolder6 + scrollCounter2));
                            playListText7.setText(playList.get(musicHolder7 + scrollCounter2));
                            playListText8.setText(playList.get(musicHolder8 + scrollCounter2));
                            playListText9.setText(playList.get(musicHolder9 + scrollCounter2));
                            playListText10.setText(playList.get(musicHolder10 + scrollCounter2));
                            playListText11.setText(playList.get(musicHolder11 + scrollCounter2));
                            playListText12.setText(playList.get(musicHolder12 + scrollCounter2));
                        }
                    }
                    if(isreversepopularitySorted&&(playList.contains(reversepopularitySorted.get(musicHolder11+scrollCounter)))==false)
                    {
                        if (indexCount < 15) {
                            playList.set(indexCount, reversepopularitySorted.get(musicHolder11+scrollCounter));
                            indexCount++;
                            queueList = Algorithms.shuffle(playList);
                            queueListText1.setText(queueList.get(musicHolder1 + scrollCounter2));
                            queueListText2.setText(queueList.get(musicHolder2 + scrollCounter2));
                            queueListText3.setText(queueList.get(musicHolder3 + scrollCounter2));
                            queueListText4.setText(queueList.get(musicHolder4 + scrollCounter2));
                            queueListText5.setText(queueList.get(musicHolder5 + scrollCounter2));
                            queueListText6.setText(queueList.get(musicHolder6 + scrollCounter2));
                            queueListText7.setText(queueList.get(musicHolder7 + scrollCounter2));
                            queueListText8.setText(queueList.get(musicHolder8 + scrollCounter2));
                            queueListText9.setText(queueList.get(musicHolder9 + scrollCounter2));
                            queueListText10.setText(queueList.get(musicHolder10 + scrollCounter2));
                            queueListText11.setText(queueList.get(musicHolder11 + scrollCounter2));
                            queueListText12.setText(queueList.get(musicHolder12 + scrollCounter2));
                            playListText1.setText(playList.get(musicHolder1 + scrollCounter2));
                            playListText2.setText(playList.get(musicHolder2 + scrollCounter2));
                            playListText3.setText(playList.get(musicHolder3 + scrollCounter2));
                            playListText4.setText(playList.get(musicHolder4 + scrollCounter2));
                            playListText5.setText(playList.get(musicHolder5 + scrollCounter2));
                            playListText6.setText(playList.get(musicHolder6 + scrollCounter2));
                            playListText7.setText(playList.get(musicHolder7 + scrollCounter2));
                            playListText8.setText(playList.get(musicHolder8 + scrollCounter2));
                            playListText9.setText(playList.get(musicHolder9 + scrollCounter2));
                            playListText10.setText(playList.get(musicHolder10 + scrollCounter2));
                            playListText11.setText(playList.get(musicHolder11 + scrollCounter2));
                            playListText12.setText(playList.get(musicHolder12 + scrollCounter2));
                        }
                    }
                }
                if(isHighlighted12) {
                    if (isdefaultSorted && (playList.contains(songStrings.get(musicHolder12 + scrollCounter))) == false) {
                        if (indexCount < 15) {
                            playList.set(indexCount, songStrings.get(musicHolder12 + scrollCounter));
                            indexCount++;
                            queueList = Algorithms.shuffle(playList);
                            queueListText1.setText(queueList.get(musicHolder1 + scrollCounter2));
                            queueListText2.setText(queueList.get(musicHolder2 + scrollCounter2));
                            queueListText3.setText(queueList.get(musicHolder3 + scrollCounter2));
                            queueListText4.setText(queueList.get(musicHolder4 + scrollCounter2));
                            queueListText5.setText(queueList.get(musicHolder5 + scrollCounter2));
                            queueListText6.setText(queueList.get(musicHolder6 + scrollCounter2));
                            queueListText7.setText(queueList.get(musicHolder7 + scrollCounter2));
                            queueListText8.setText(queueList.get(musicHolder8 + scrollCounter2));
                            queueListText9.setText(queueList.get(musicHolder9 + scrollCounter2));
                            queueListText10.setText(queueList.get(musicHolder10 + scrollCounter2));
                            queueListText11.setText(queueList.get(musicHolder11 + scrollCounter2));
                            queueListText12.setText(queueList.get(musicHolder12 + scrollCounter2));
                            playListText1.setText(playList.get(musicHolder1 + scrollCounter2));
                            playListText2.setText(playList.get(musicHolder2 + scrollCounter2));
                            playListText3.setText(playList.get(musicHolder3 + scrollCounter2));
                            playListText4.setText(playList.get(musicHolder4 + scrollCounter2));
                            playListText5.setText(playList.get(musicHolder5 + scrollCounter2));
                            playListText6.setText(playList.get(musicHolder6 + scrollCounter2));
                            playListText7.setText(playList.get(musicHolder7 + scrollCounter2));
                            playListText8.setText(playList.get(musicHolder8 + scrollCounter2));
                            playListText9.setText(playList.get(musicHolder9 + scrollCounter2));
                            playListText10.setText(playList.get(musicHolder10 + scrollCounter2));
                            playListText11.setText(playList.get(musicHolder11 + scrollCounter2));
                            playListText12.setText(playList.get(musicHolder12 + scrollCounter2));
                        }
                    }
                    if (isalphabeticalSorted && (playList.contains(alphabeticalSorted.get(musicHolder12 + scrollCounter))) == false) {
                        if (indexCount < 15) {
                            playList.set(indexCount, alphabeticalSorted.get(musicHolder12 + scrollCounter));
                            indexCount++;
                            queueList = Algorithms.shuffle(playList);
                            queueListText1.setText(queueList.get(musicHolder1 + scrollCounter2));
                            queueListText2.setText(queueList.get(musicHolder2 + scrollCounter2));
                            queueListText3.setText(queueList.get(musicHolder3 + scrollCounter2));
                            queueListText4.setText(queueList.get(musicHolder4 + scrollCounter2));
                            queueListText5.setText(queueList.get(musicHolder5 + scrollCounter2));
                            queueListText6.setText(queueList.get(musicHolder6 + scrollCounter2));
                            queueListText7.setText(queueList.get(musicHolder7 + scrollCounter2));
                            queueListText8.setText(queueList.get(musicHolder8 + scrollCounter2));
                            queueListText9.setText(queueList.get(musicHolder9 + scrollCounter2));
                            queueListText10.setText(queueList.get(musicHolder10 + scrollCounter2));
                            queueListText11.setText(queueList.get(musicHolder11 + scrollCounter2));
                            queueListText12.setText(queueList.get(musicHolder12 + scrollCounter2));
                            playListText1.setText(playList.get(musicHolder1 + scrollCounter2));
                            playListText2.setText(playList.get(musicHolder2 + scrollCounter2));
                            playListText3.setText(playList.get(musicHolder3 + scrollCounter2));
                            playListText4.setText(playList.get(musicHolder4 + scrollCounter2));
                            playListText5.setText(playList.get(musicHolder5 + scrollCounter2));
                            playListText6.setText(playList.get(musicHolder6 + scrollCounter2));
                            playListText7.setText(playList.get(musicHolder7 + scrollCounter2));
                            playListText8.setText(playList.get(musicHolder8 + scrollCounter2));
                            playListText9.setText(playList.get(musicHolder9 + scrollCounter2));
                            playListText10.setText(playList.get(musicHolder10 + scrollCounter2));
                            playListText11.setText(playList.get(musicHolder11 + scrollCounter2));
                            playListText12.setText(playList.get(musicHolder12 + scrollCounter2));
                        }
                    }
                    if (isreversealphabeticalSorted && (playList.contains(reversealphabeticalSorted.get(musicHolder12 + scrollCounter))) == false) {
                        if (indexCount < 15) {
                            playList.set(indexCount, reversealphabeticalSorted.get(musicHolder12 + scrollCounter));
                            indexCount++;
                            queueList = Algorithms.shuffle(playList);
                            queueListText1.setText(queueList.get(musicHolder1 + scrollCounter2));
                            queueListText2.setText(queueList.get(musicHolder2 + scrollCounter2));
                            queueListText3.setText(queueList.get(musicHolder3 + scrollCounter2));
                            queueListText4.setText(queueList.get(musicHolder4 + scrollCounter2));
                            queueListText5.setText(queueList.get(musicHolder5 + scrollCounter2));
                            queueListText6.setText(queueList.get(musicHolder6 + scrollCounter2));
                            queueListText7.setText(queueList.get(musicHolder7 + scrollCounter2));
                            queueListText8.setText(queueList.get(musicHolder8 + scrollCounter2));
                            queueListText9.setText(queueList.get(musicHolder9 + scrollCounter2));
                            queueListText10.setText(queueList.get(musicHolder10 + scrollCounter2));
                            queueListText11.setText(queueList.get(musicHolder11 + scrollCounter2));
                            queueListText12.setText(queueList.get(musicHolder12 + scrollCounter2));
                            playListText1.setText(playList.get(musicHolder1 + scrollCounter2));
                            playListText2.setText(playList.get(musicHolder2 + scrollCounter2));
                            playListText3.setText(playList.get(musicHolder3 + scrollCounter2));
                            playListText4.setText(playList.get(musicHolder4 + scrollCounter2));
                            playListText5.setText(playList.get(musicHolder5 + scrollCounter2));
                            playListText6.setText(playList.get(musicHolder6 + scrollCounter2));
                            playListText7.setText(playList.get(musicHolder7 + scrollCounter2));
                            playListText8.setText(playList.get(musicHolder8 + scrollCounter2));
                            playListText9.setText(playList.get(musicHolder9 + scrollCounter2));
                            playListText10.setText(playList.get(musicHolder10 + scrollCounter2));
                            playListText11.setText(playList.get(musicHolder11 + scrollCounter2));
                            playListText12.setText(playList.get(musicHolder12 + scrollCounter2));
                        }
                    }
                    if (ispopularitySorted && (playList.contains(popularitySorted.get(musicHolder12 + scrollCounter))) == false) {
                        if (indexCount < 15) {
                            playList.set(indexCount, popularitySorted.get(musicHolder12 + scrollCounter));
                            indexCount++;
                            queueList = Algorithms.shuffle(playList);
                            queueListText1.setText(queueList.get(musicHolder1 + scrollCounter2));
                            queueListText2.setText(queueList.get(musicHolder2 + scrollCounter2));
                            queueListText3.setText(queueList.get(musicHolder3 + scrollCounter2));
                            queueListText4.setText(queueList.get(musicHolder4 + scrollCounter2));
                            queueListText5.setText(queueList.get(musicHolder5 + scrollCounter2));
                            queueListText6.setText(queueList.get(musicHolder6 + scrollCounter2));
                            queueListText7.setText(queueList.get(musicHolder7 + scrollCounter2));
                            queueListText8.setText(queueList.get(musicHolder8 + scrollCounter2));
                            queueListText9.setText(queueList.get(musicHolder9 + scrollCounter2));
                            queueListText10.setText(queueList.get(musicHolder10 + scrollCounter2));
                            queueListText11.setText(queueList.get(musicHolder11 + scrollCounter2));
                            queueListText12.setText(queueList.get(musicHolder12 + scrollCounter2));
                            playListText1.setText(playList.get(musicHolder1 + scrollCounter2));
                            playListText2.setText(playList.get(musicHolder2 + scrollCounter2));
                            playListText3.setText(playList.get(musicHolder3 + scrollCounter2));
                            playListText4.setText(playList.get(musicHolder4 + scrollCounter2));
                            playListText5.setText(playList.get(musicHolder5 + scrollCounter2));
                            playListText6.setText(playList.get(musicHolder6 + scrollCounter2));
                            playListText7.setText(playList.get(musicHolder7 + scrollCounter2));
                            playListText8.setText(playList.get(musicHolder8 + scrollCounter2));
                            playListText9.setText(playList.get(musicHolder9 + scrollCounter2));
                            playListText10.setText(playList.get(musicHolder10 + scrollCounter2));
                            playListText11.setText(playList.get(musicHolder11 + scrollCounter2));
                            playListText12.setText(playList.get(musicHolder12 + scrollCounter2));
                        }
                    }
                    if (isreversepopularitySorted && (playList.contains(reversepopularitySorted.get(musicHolder12 + scrollCounter))) == false) {
                        if (indexCount < 15) {
                            playList.set(indexCount, reversepopularitySorted.get(musicHolder12 + scrollCounter));
                            indexCount++;
                            queueList = Algorithms.shuffle(playList);
                            queueListText1.setText(queueList.get(musicHolder1 + scrollCounter2));
                            queueListText2.setText(queueList.get(musicHolder2 + scrollCounter2));
                            queueListText3.setText(queueList.get(musicHolder3 + scrollCounter2));
                            queueListText4.setText(queueList.get(musicHolder4 + scrollCounter2));
                            queueListText5.setText(queueList.get(musicHolder5 + scrollCounter2));
                            queueListText6.setText(queueList.get(musicHolder6 + scrollCounter2));
                            queueListText7.setText(queueList.get(musicHolder7 + scrollCounter2));
                            queueListText8.setText(queueList.get(musicHolder8 + scrollCounter2));
                            queueListText9.setText(queueList.get(musicHolder9 + scrollCounter2));
                            queueListText10.setText(queueList.get(musicHolder10 + scrollCounter2));
                            queueListText11.setText(queueList.get(musicHolder11 + scrollCounter2));
                            queueListText12.setText(queueList.get(musicHolder12 + scrollCounter2));
                            playListText1.setText(playList.get(musicHolder1 + scrollCounter2));
                            playListText2.setText(playList.get(musicHolder2 + scrollCounter2));
                            playListText3.setText(playList.get(musicHolder3 + scrollCounter2));
                            playListText4.setText(playList.get(musicHolder4 + scrollCounter2));
                            playListText5.setText(playList.get(musicHolder5 + scrollCounter2));
                            playListText6.setText(playList.get(musicHolder6 + scrollCounter2));
                            playListText7.setText(playList.get(musicHolder7 + scrollCounter2));
                            playListText8.setText(playList.get(musicHolder8 + scrollCounter2));
                            playListText9.setText(playList.get(musicHolder9 + scrollCounter2));
                            playListText10.setText(playList.get(musicHolder10 + scrollCounter2));
                            playListText11.setText(playList.get(musicHolder11 + scrollCounter2));
                            playListText12.setText(playList.get(musicHolder12 + scrollCounter2));
                        }
                    }
                    playListText1.setText(playList.get(musicHolder1 + scrollCounter2));
                    playListText2.setText(playList.get(musicHolder2 + scrollCounter2));
                    playListText3.setText(playList.get(musicHolder3 + scrollCounter2));
                    playListText4.setText(playList.get(musicHolder4 + scrollCounter2));
                    playListText5.setText(playList.get(musicHolder5 + scrollCounter2));
                    playListText6.setText(playList.get(musicHolder6 + scrollCounter2));
                    playListText7.setText(playList.get(musicHolder7 + scrollCounter2));
                    playListText8.setText(playList.get(musicHolder8 + scrollCounter2));
                    playListText9.setText(playList.get(musicHolder9 + scrollCounter2));
                    playListText10.setText(playList.get(musicHolder10 + scrollCounter2));
                    playListText11.setText(playList.get(musicHolder11 + scrollCounter2));
                    playListText12.setText(playList.get(musicHolder12 + scrollCounter2));
                }
            });
            plusButton.setOnMouseClicked(event -> {
                activeClip.setGain(activeClip.getGain() + 0.1);
                if (activeClip.getGain() > 1.0) {
                    activeClip.setGain(1.0);  // limit the gain to 1.0
                }
                activeClip.setdB((float) (Math.log(activeClip.getGain()) / Math.log(10.0) * 20.0));
                activeClip.getGainControl().setValue(activeClip.getdB());
            });

            subtractButton.setOnMouseClicked(event -> {
                activeClip.setGain(activeClip.getGain() - 0.1);
                if (activeClip.getGain() < 0.0) {
                    activeClip.setGain(0.0);  // limit the gain to 1.0
                }
                activeClip.setdB((float) (Math.log(activeClip.getGain()) / Math.log(10.0) * 20.0));
                activeClip.getGainControl().setValue(activeClip.getdB());
            });

            shuffleButton.setOnMouseClicked(event-> {
                queueList=Algorithms.shuffle(playList);
            });
            sortDropButton.setOnMouseClicked(event-> {
                isdefaultSorted=true;
                isalphabeticalSorted=false;
                isreversealphabeticalSorted=false;
                ispopularitySorted=false;
                isreversepopularitySorted=false;

                musicText1.setText(songStringsScroll.get(musicHolder1+scrollCounter));
                musicText2.setText(songStringsScroll.get(musicHolder2+scrollCounter));
                musicText3.setText(songStringsScroll.get(musicHolder3+scrollCounter));
                musicText4.setText(songStringsScroll.get(musicHolder4+scrollCounter));
                musicText5.setText(songStringsScroll.get(musicHolder5+scrollCounter));
                musicText6.setText(songStringsScroll.get(musicHolder6+scrollCounter));
                musicText7.setText(songStringsScroll.get(musicHolder7+scrollCounter));
                musicText8.setText(songStringsScroll.get(musicHolder8+scrollCounter));
                musicText9.setText(songStringsScroll.get(musicHolder9+scrollCounter));
                musicText10.setText(songStringsScroll.get(musicHolder10+scrollCounter));
                musicText11.setText(songStringsScroll.get(musicHolder11+scrollCounter));
                musicText12.setText(songStringsScroll.get(musicHolder12+scrollCounter));
            });

            alphabeticalSortButton.setOnMouseClicked(event-> {
                isdefaultSorted=false;
                isalphabeticalSorted=true;
                isreversealphabeticalSorted=false;
                ispopularitySorted=false;
                isreversepopularitySorted=false;
                musicText1.setText(alphabeticalSorted.get(musicHolder1+scrollCounter));
                musicText2.setText(alphabeticalSorted.get(musicHolder2+scrollCounter));
                musicText3.setText(alphabeticalSorted.get(musicHolder3+scrollCounter));
                musicText4.setText(alphabeticalSorted.get(musicHolder4+scrollCounter));
                musicText5.setText(alphabeticalSorted.get(musicHolder5+scrollCounter));
                musicText6.setText(alphabeticalSorted.get(musicHolder6+scrollCounter));
                musicText7.setText(alphabeticalSorted.get(musicHolder7+scrollCounter));
                musicText8.setText(alphabeticalSorted.get(musicHolder8+scrollCounter));
                musicText9.setText(alphabeticalSorted.get(musicHolder9+scrollCounter));
                musicText10.setText(alphabeticalSorted.get(musicHolder10+scrollCounter));
                musicText11.setText(alphabeticalSorted.get(musicHolder11+scrollCounter));
                musicText12.setText(alphabeticalSorted.get(musicHolder12+scrollCounter));
            });

            reversealphabeticalSortButton.setOnMouseClicked(event-> {
                isdefaultSorted=false;
                isalphabeticalSorted=false;
                isreversealphabeticalSorted=true;
                ispopularitySorted=false;
                isreversepopularitySorted=false;
                musicText1.setText(reversealphabeticalSorted.get(musicHolder1+scrollCounter));
                musicText2.setText(reversealphabeticalSorted.get(musicHolder2+scrollCounter));
                musicText3.setText(reversealphabeticalSorted.get(musicHolder3+scrollCounter));
                musicText4.setText(reversealphabeticalSorted.get(musicHolder4+scrollCounter));
                musicText5.setText(reversealphabeticalSorted.get(musicHolder5+scrollCounter));
                musicText6.setText(reversealphabeticalSorted.get(musicHolder6+scrollCounter));
                musicText7.setText(reversealphabeticalSorted.get(musicHolder7+scrollCounter));
                musicText8.setText(reversealphabeticalSorted.get(musicHolder8+scrollCounter));
                musicText9.setText(reversealphabeticalSorted.get(musicHolder9+scrollCounter));
                musicText10.setText(reversealphabeticalSorted.get(musicHolder10+scrollCounter));
                musicText11.setText(reversealphabeticalSorted.get(musicHolder11+scrollCounter));
                musicText12.setText(reversealphabeticalSorted.get(musicHolder12+scrollCounter));
            });

            popularitySortButton.setOnMouseClicked(event-> {
                isdefaultSorted=false;
                isalphabeticalSorted=false;
                isreversealphabeticalSorted=false;
                ispopularitySorted=true;
                isreversepopularitySorted=false;
                musicText1.setText(popularitySorted.get(musicHolder1+scrollCounter));
                musicText2.setText(popularitySorted.get(musicHolder2+scrollCounter));
                musicText3.setText(popularitySorted.get(musicHolder3+scrollCounter));
                musicText4.setText(popularitySorted.get(musicHolder4+scrollCounter));
                musicText5.setText(popularitySorted.get(musicHolder5+scrollCounter));
                musicText6.setText(popularitySorted.get(musicHolder6+scrollCounter));
                musicText7.setText(popularitySorted.get(musicHolder7+scrollCounter));
                musicText8.setText(popularitySorted.get(musicHolder8+scrollCounter));
                musicText9.setText(popularitySorted.get(musicHolder9+scrollCounter));
                musicText10.setText(popularitySorted.get(musicHolder10+scrollCounter));
                musicText11.setText(popularitySorted.get(musicHolder11+scrollCounter));
                musicText12.setText(popularitySorted.get(musicHolder12+scrollCounter));
            });

            reversepopularitySortButton.setOnMouseClicked(event-> {
                isdefaultSorted=false;
                isalphabeticalSorted=false;
                isreversealphabeticalSorted=false;
                ispopularitySorted=false;
                isreversepopularitySorted=true;
                musicText1.setText(reversepopularitySorted.get(musicHolder1+scrollCounter));
                musicText2.setText(reversepopularitySorted.get(musicHolder2+scrollCounter));
                musicText3.setText(reversepopularitySorted.get(musicHolder3+scrollCounter));
                musicText4.setText(reversepopularitySorted.get(musicHolder4+scrollCounter));
                musicText5.setText(reversepopularitySorted.get(musicHolder5+scrollCounter));
                musicText6.setText(reversepopularitySorted.get(musicHolder6+scrollCounter));
                musicText7.setText(reversepopularitySorted.get(musicHolder7+scrollCounter));
                musicText8.setText(reversepopularitySorted.get(musicHolder8+scrollCounter));
                musicText9.setText(reversepopularitySorted.get(musicHolder9+scrollCounter));
                musicText10.setText(reversepopularitySorted.get(musicHolder10+scrollCounter));
                musicText11.setText(reversepopularitySorted.get(musicHolder11+scrollCounter));
                musicText12.setText(reversepopularitySorted.get(musicHolder12+scrollCounter));
            });


            goDownArrow.setOnMouseClicked(event -> {
                scrollcountDeterminer--;
                if((musicHolder12+scrollCounter<14 && isdefaultSorted))
                {
                    scrollCounter++;
                    musicText1.setText(songStringsScroll.get(musicHolder1+scrollCounter));
                    musicText2.setText(songStringsScroll.get(musicHolder2+scrollCounter));
                    musicText3.setText(songStringsScroll.get(musicHolder3+scrollCounter));
                    musicText4.setText(songStringsScroll.get(musicHolder4+scrollCounter));
                    musicText5.setText(songStringsScroll.get(musicHolder5+scrollCounter));
                    musicText6.setText(songStringsScroll.get(musicHolder6+scrollCounter));
                    musicText7.setText(songStringsScroll.get(musicHolder7+scrollCounter));
                    musicText8.setText(songStringsScroll.get(musicHolder8+scrollCounter));
                    musicText9.setText(songStringsScroll.get(musicHolder9+scrollCounter));
                    musicText10.setText(songStringsScroll.get(musicHolder10+scrollCounter));
                    musicText11.setText(songStringsScroll.get(musicHolder11+scrollCounter));
                    musicText12.setText(songStringsScroll.get(musicHolder12+scrollCounter));

                }
                if((musicHolder12+scrollCounter<14 && isalphabeticalSorted))
                {
                    scrollCounter++;
                    musicText1.setText(alphabeticalSorted.get(musicHolder1+scrollCounter));
                    musicText2.setText(alphabeticalSorted.get(musicHolder2+scrollCounter));
                    musicText3.setText(alphabeticalSorted.get(musicHolder3+scrollCounter));
                    musicText4.setText(alphabeticalSorted.get(musicHolder4+scrollCounter));
                    musicText5.setText(alphabeticalSorted.get(musicHolder5+scrollCounter));
                    musicText6.setText(alphabeticalSorted.get(musicHolder6+scrollCounter));
                    musicText7.setText(alphabeticalSorted.get(musicHolder7+scrollCounter));
                    musicText8.setText(alphabeticalSorted.get(musicHolder8+scrollCounter));
                    musicText9.setText(alphabeticalSorted.get(musicHolder9+scrollCounter));
                    musicText10.setText(alphabeticalSorted.get(musicHolder10+scrollCounter));
                    musicText11.setText(alphabeticalSorted.get(musicHolder11+scrollCounter));
                    musicText12.setText(alphabeticalSorted.get(musicHolder12+scrollCounter));

                }
                if((musicHolder12+scrollCounter<14 && isreversealphabeticalSorted))
                {
                    scrollCounter++;
                    musicText1.setText(reversealphabeticalSorted.get(musicHolder1+scrollCounter));
                    musicText2.setText(reversealphabeticalSorted.get(musicHolder2+scrollCounter));
                    musicText3.setText(reversealphabeticalSorted.get(musicHolder3+scrollCounter));
                    musicText4.setText(reversealphabeticalSorted.get(musicHolder4+scrollCounter));
                    musicText5.setText(reversealphabeticalSorted.get(musicHolder5+scrollCounter));
                    musicText6.setText(reversealphabeticalSorted.get(musicHolder6+scrollCounter));
                    musicText7.setText(reversealphabeticalSorted.get(musicHolder7+scrollCounter));
                    musicText8.setText(reversealphabeticalSorted.get(musicHolder8+scrollCounter));
                    musicText9.setText(reversealphabeticalSorted.get(musicHolder9+scrollCounter));
                    musicText10.setText(reversealphabeticalSorted.get(musicHolder10+scrollCounter));
                    musicText11.setText(reversealphabeticalSorted.get(musicHolder11+scrollCounter));
                    musicText12.setText(reversealphabeticalSorted.get(musicHolder12+scrollCounter));

                }
                if((musicHolder12+scrollCounter<14 && ispopularitySorted))
                {
                    scrollCounter++;
                    musicText1.setText(popularitySorted.get(musicHolder1+scrollCounter));
                    musicText2.setText(popularitySorted.get(musicHolder2+scrollCounter));
                    musicText3.setText(popularitySorted.get(musicHolder3+scrollCounter));
                    musicText4.setText(popularitySorted.get(musicHolder4+scrollCounter));
                    musicText5.setText(popularitySorted.get(musicHolder5+scrollCounter));
                    musicText6.setText(popularitySorted.get(musicHolder6+scrollCounter));
                    musicText7.setText(popularitySorted.get(musicHolder7+scrollCounter));
                    musicText8.setText(popularitySorted.get(musicHolder8+scrollCounter));
                    musicText9.setText(popularitySorted.get(musicHolder9+scrollCounter));
                    musicText10.setText(popularitySorted.get(musicHolder10+scrollCounter));
                    musicText11.setText(popularitySorted.get(musicHolder11+scrollCounter));
                    musicText12.setText(popularitySorted.get(musicHolder12+scrollCounter));

                }
                if((musicHolder12+scrollCounter<14 && isreversepopularitySorted))
                {
                    scrollCounter++;
                    musicText1.setText(reversepopularitySorted.get(musicHolder1+scrollCounter));
                    musicText2.setText(reversepopularitySorted.get(musicHolder2+scrollCounter));
                    musicText3.setText(reversepopularitySorted.get(musicHolder3+scrollCounter));
                    musicText4.setText(reversepopularitySorted.get(musicHolder4+scrollCounter));
                    musicText5.setText(reversepopularitySorted.get(musicHolder5+scrollCounter));
                    musicText6.setText(reversepopularitySorted.get(musicHolder6+scrollCounter));
                    musicText7.setText(reversepopularitySorted.get(musicHolder7+scrollCounter));
                    musicText8.setText(reversepopularitySorted.get(musicHolder8+scrollCounter));
                    musicText9.setText(reversepopularitySorted.get(musicHolder9+scrollCounter));
                    musicText10.setText(reversepopularitySorted.get(musicHolder10+scrollCounter));
                    musicText11.setText(reversepopularitySorted.get(musicHolder11+scrollCounter));
                    musicText12.setText(reversepopularitySorted.get(musicHolder12+scrollCounter));

                }

            });

            goUpArrow.setOnMouseClicked(event -> {
                scrollcountDeterminer++;
                if((musicHolder1+scrollCounter>0 && isdefaultSorted))
                {
                    scrollCounter--;
                    musicText1.setText(songStringsScroll.get(musicHolder1+scrollCounter));
                    musicText2.setText(songStringsScroll.get(musicHolder2+scrollCounter));
                    musicText3.setText(songStringsScroll.get(musicHolder3+scrollCounter));
                    musicText4.setText(songStringsScroll.get(musicHolder4+scrollCounter));
                    musicText5.setText(songStringsScroll.get(musicHolder5+scrollCounter));
                    musicText6.setText(songStringsScroll.get(musicHolder6+scrollCounter));
                    musicText7.setText(songStringsScroll.get(musicHolder7+scrollCounter));
                    musicText8.setText(songStringsScroll.get(musicHolder8+scrollCounter));
                    musicText9.setText(songStringsScroll.get(musicHolder9+scrollCounter));
                    musicText10.setText(songStringsScroll.get(musicHolder10+scrollCounter));
                    musicText11.setText(songStringsScroll.get(musicHolder11+scrollCounter));
                    musicText12.setText(songStringsScroll.get(musicHolder12+scrollCounter));

                }
                if((musicHolder1+scrollCounter>0 && isalphabeticalSorted))
                {
                    scrollCounter--;
                    musicText1.setText(alphabeticalSorted.get(musicHolder1+scrollCounter));
                    musicText2.setText(alphabeticalSorted.get(musicHolder2+scrollCounter));
                    musicText3.setText(alphabeticalSorted.get(musicHolder3+scrollCounter));
                    musicText4.setText(alphabeticalSorted.get(musicHolder4+scrollCounter));
                    musicText5.setText(alphabeticalSorted.get(musicHolder5+scrollCounter));
                    musicText6.setText(alphabeticalSorted.get(musicHolder6+scrollCounter));
                    musicText7.setText(alphabeticalSorted.get(musicHolder7+scrollCounter));
                    musicText8.setText(alphabeticalSorted.get(musicHolder8+scrollCounter));
                    musicText9.setText(alphabeticalSorted.get(musicHolder9+scrollCounter));
                    musicText10.setText(alphabeticalSorted.get(musicHolder10+scrollCounter));
                    musicText11.setText(alphabeticalSorted.get(musicHolder11+scrollCounter));
                    musicText12.setText(alphabeticalSorted.get(musicHolder12+scrollCounter));

                }
                if((musicHolder1+scrollCounter>0 && isreversealphabeticalSorted))
                {
                    scrollCounter--;
                    musicText1.setText(reversealphabeticalSorted.get(musicHolder1+scrollCounter));
                    musicText2.setText(reversealphabeticalSorted.get(musicHolder2+scrollCounter));
                    musicText3.setText(reversealphabeticalSorted.get(musicHolder3+scrollCounter));
                    musicText4.setText(reversealphabeticalSorted.get(musicHolder4+scrollCounter));
                    musicText5.setText(reversealphabeticalSorted.get(musicHolder5+scrollCounter));
                    musicText6.setText(reversealphabeticalSorted.get(musicHolder6+scrollCounter));
                    musicText7.setText(reversealphabeticalSorted.get(musicHolder7+scrollCounter));
                    musicText8.setText(reversealphabeticalSorted.get(musicHolder8+scrollCounter));
                    musicText9.setText(reversealphabeticalSorted.get(musicHolder9+scrollCounter));
                    musicText10.setText(reversealphabeticalSorted.get(musicHolder10+scrollCounter));
                    musicText11.setText(reversealphabeticalSorted.get(musicHolder11+scrollCounter));
                    musicText12.setText(reversealphabeticalSorted.get(musicHolder12+scrollCounter));

                }
                if((musicHolder1+scrollCounter>0 && ispopularitySorted))
                {
                    scrollCounter--;
                    musicText1.setText(popularitySorted.get(musicHolder1+scrollCounter));
                    musicText2.setText(popularitySorted.get(musicHolder2+scrollCounter));
                    musicText3.setText(popularitySorted.get(musicHolder3+scrollCounter));
                    musicText4.setText(popularitySorted.get(musicHolder4+scrollCounter));
                    musicText5.setText(popularitySorted.get(musicHolder5+scrollCounter));
                    musicText6.setText(popularitySorted.get(musicHolder6+scrollCounter));
                    musicText7.setText(popularitySorted.get(musicHolder7+scrollCounter));
                    musicText8.setText(popularitySorted.get(musicHolder8+scrollCounter));
                    musicText9.setText(popularitySorted.get(musicHolder9+scrollCounter));
                    musicText10.setText(popularitySorted.get(musicHolder10+scrollCounter));
                    musicText11.setText(popularitySorted.get(musicHolder11+scrollCounter));
                    musicText12.setText(popularitySorted.get(musicHolder12+scrollCounter));

                }
                if((musicHolder1+scrollCounter>0&& isreversepopularitySorted))
                {
                    scrollCounter--;
                    musicText1.setText(reversepopularitySorted.get(musicHolder1+scrollCounter));
                    musicText2.setText(reversepopularitySorted.get(musicHolder2+scrollCounter));
                    musicText3.setText(reversepopularitySorted.get(musicHolder3+scrollCounter));
                    musicText4.setText(reversepopularitySorted.get(musicHolder4+scrollCounter));
                    musicText5.setText(reversepopularitySorted.get(musicHolder5+scrollCounter));
                    musicText6.setText(reversepopularitySorted.get(musicHolder6+scrollCounter));
                    musicText7.setText(reversepopularitySorted.get(musicHolder7+scrollCounter));
                    musicText8.setText(reversepopularitySorted.get(musicHolder8+scrollCounter));
                    musicText9.setText(reversepopularitySorted.get(musicHolder9+scrollCounter));
                    musicText10.setText(reversepopularitySorted.get(musicHolder10+scrollCounter));
                    musicText11.setText(reversepopularitySorted.get(musicHolder11+scrollCounter));
                    musicText12.setText(reversepopularitySorted.get(musicHolder12+scrollCounter));

                }
            });


            goUpArrow2.setOnMouseClicked(event -> {
                scrollcountDeterminer2++;
                if (musicHolder1 + scrollCounter2 > 0)
                {
                    scrollCounter2--;
                    playListText1.setText(playList.get(musicHolder1 + scrollCounter2));
                    playListText2.setText(playList.get(musicHolder2 + scrollCounter2));
                    playListText3.setText(playList.get(musicHolder3 + scrollCounter2));
                    playListText4.setText(playList.get(musicHolder4 + scrollCounter2));
                    playListText5.setText(playList.get(musicHolder5 + scrollCounter2));
                    playListText6.setText(playList.get(musicHolder6 + scrollCounter2));
                    playListText7.setText(playList.get(musicHolder7 + scrollCounter2));
                    playListText8.setText(playList.get(musicHolder8 + scrollCounter2));
                    playListText9.setText(playList.get(musicHolder9 + scrollCounter2));
                    playListText10.setText(playList.get(musicHolder10 + scrollCounter2));
                    playListText11.setText(playList.get(musicHolder11 + scrollCounter2));
                    playListText12.setText(playList.get(musicHolder12 + scrollCounter2));

                }
            });
            goDownArrow2.setOnMouseClicked(event -> {
                scrollcountDeterminer2--;
                if(musicHolder12+scrollCounter2<14) {
                    scrollCounter2++;
                    playListText1.setText(playList.get(musicHolder1 + scrollCounter2));
                    playListText2.setText(playList.get(musicHolder2 + scrollCounter2));
                    playListText3.setText(playList.get(musicHolder3 + scrollCounter2));
                    playListText4.setText(playList.get(musicHolder4 + scrollCounter2));
                    playListText5.setText(playList.get(musicHolder5 + scrollCounter2));
                    playListText6.setText(playList.get(musicHolder6 + scrollCounter2));
                    playListText7.setText(playList.get(musicHolder7 + scrollCounter2));
                    playListText8.setText(playList.get(musicHolder8 + scrollCounter2));
                    playListText9.setText(playList.get(musicHolder9 + scrollCounter2));
                    playListText10.setText(playList.get(musicHolder10 + scrollCounter2));
                    playListText11.setText(playList.get(musicHolder11 + scrollCounter2));
                    playListText12.setText(playList.get(musicHolder12 + scrollCounter2));
                }

            });


            musicButton1.setOnMouseClicked(event-> {
                isHighlighted1=true;
                isHighlighted2=false;
                isHighlighted3=false;
                isHighlighted4=false;
                isHighlighted5=false;
                isHighlighted6=false;
                isHighlighted7=false;
                isHighlighted8=false;
                isHighlighted9=false;
                isHighlighted10=false;
                isHighlighted11=false;
                isHighlighted12=false;


//                if(scrollcountDeterminer==0)
//                {
//                    musicText1.setFill(Color.RED);
//                    musicButton1.setMaterial(higlightedmusicbuttonmaterial);
//                }
//                if(scrollcountDeterminer>0)
//                {
//                    musicText1.setFill(Color.BLACK);
//                    musicButton1.setMaterial(musicButtonmaterial);
//                }
                if(albumNames.get(musicHolder1+scrollCounter).equals("The Beginning: Cupid")||albumNames.get(musicHolder1+scrollCounter).equals("You Never Walk Alone"))
                {
                    albumContentsText.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 14));
                }
                else
                {
                    albumContentsText.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 20));
                }

                if(isdefaultSorted)
                {
                    albumContentsText.setText(albumNames.get(musicHolder1+scrollCounter));
                }
                if(isalphabeticalSorted)
                {
                    albumContentsText.setText(alphabeticalSortedAlbumsNames.get(musicHolder1+scrollCounter));
                }
                if(isreversealphabeticalSorted)
                {
                    albumContentsText.setText(reversepopularitySortedAlbumsNames.get(musicHolder1+scrollCounter));
                }
                if(ispopularitySorted)
                {
                    albumContentsText.setText(popularitySortedAlbumsNames.get(musicHolder1+scrollCounter));
                }
                if(isreversepopularitySorted)
                {
                    albumContentsText.setText(reversepopularitySortedAlbumsNames.get(musicHolder1+scrollCounter));
                }

                musicText1.setFill(Color.RED);
                musicText2.setFill(Color.BLACK);
                musicText3.setFill(Color.BLACK);
                musicText4.setFill(Color.BLACK);
                musicText5.setFill(Color.BLACK);
                musicText6.setFill(Color.BLACK);
                musicText7.setFill(Color.BLACK);
                musicText8.setFill(Color.BLACK);
                musicText9.setFill(Color.BLACK);
                musicText10.setFill(Color.BLACK);
                musicText11.setFill(Color.BLACK);
                musicText12.setFill(Color.BLACK);
                musicButton1.setMaterial(higlightedmusicbuttonmaterial);
                musicButton2.setMaterial(musicButtonmaterial);
                musicButton3.setMaterial(musicButtonmaterial);
                musicButton4.setMaterial(musicButtonmaterial);
                musicButton5.setMaterial(musicButtonmaterial);
                musicButton6.setMaterial(musicButtonmaterial);
                musicButton7.setMaterial(musicButtonmaterial);
                musicButton8.setMaterial(musicButtonmaterial);
                musicButton9.setMaterial(musicButtonmaterial);
                musicButton10.setMaterial(musicButtonmaterial);
                musicButton11.setMaterial(musicButtonmaterial);
                musicButton12.setMaterial(musicButtonmaterial);



                try
                {
                    if(isdefaultSorted)
                    {
                        Image defaultAlbumImage = new Image(new FileInputStream(albumPaths.get(musicHolder1+scrollCounter)));
                        defaultAlbummaterial.setDiffuseMap(defaultAlbumImage);
                    }
                    if(isalphabeticalSorted)
                    {
                        Image defaultAlbumImage = new Image(new FileInputStream(alphabeticalSortedAlbums.get(musicHolder1+scrollCounter)));
                        defaultAlbummaterial.setDiffuseMap(defaultAlbumImage);
                    }
                    if(isreversealphabeticalSorted)
                    {
                        Image defaultAlbumImage = new Image(new FileInputStream(reversealphabeticalSortedAlbums.get(musicHolder1+scrollCounter)));
                        defaultAlbummaterial.setDiffuseMap(defaultAlbumImage);
                    }
                    if(ispopularitySorted)
                    {
                        Image defaultAlbumImage = new Image(new FileInputStream(popularitySortedAlbums.get(musicHolder1+scrollCounter)));
                        defaultAlbummaterial.setDiffuseMap(defaultAlbumImage);
                    }
                    if(isreversepopularitySorted)
                    {
                        Image defaultAlbumImage = new Image(new FileInputStream(reversepopularitySortedAlbums.get(musicHolder1+scrollCounter)));
                        defaultAlbummaterial.setDiffuseMap(defaultAlbumImage);
                    }
                }
                catch (Exception E)
                {
                    System.out.println("File Not Found");
                }
                try
                {
                    if(isdefaultSorted)
                    {
                        if (activeClip != null) {
                            activeClip.stop();
                        }
                        activeClip = new Audio((preSongsFile.get(musicHolder1+scrollCounter)));
                        activeClip.play();
                    }
                    if(isalphabeticalSorted)
                    {
                        if (activeClip != null) {
                            activeClip.stop();
                        }
                        activeClip = new Audio((alphabeticalSortedPRE.get(musicHolder1+scrollCounter)));
                        activeClip.play();
                    }
                    if(isreversealphabeticalSorted)
                    {
                        if (activeClip != null) {
                            activeClip.stop();
                        }
                        activeClip = new Audio((reversealphabeticalSortedPRE.get(musicHolder1+scrollCounter)));
                        activeClip.play();
                    }
                    if(ispopularitySorted)
                    {
                        if (activeClip != null) {
                            activeClip.stop();
                        }
                        activeClip = new Audio((popularitySortedPRE.get(musicHolder1+scrollCounter)));
                        activeClip.play();
                    }
                    if(isreversepopularitySorted)
                    {
                        if (activeClip != null) {
                            activeClip.stop();
                        }
                        activeClip = new Audio((reversepopularitySortedPRE.get(musicHolder1+scrollCounter)));
                        activeClip.play();
                    }
                }
                catch(Exception E)
                {
                    System.out.println("ERROR: Audio");
                }



            });

            musicButton2.setOnMouseClicked(event-> {
                isHighlighted1=false;
                isHighlighted3=false;
                isHighlighted4=false;
                isHighlighted5=false;
                isHighlighted6=false;
                isHighlighted7=false;
                isHighlighted8=false;
                isHighlighted9=false;
                isHighlighted10=false;
                isHighlighted11=false;
                isHighlighted12=false;
                isHighlighted2=true;
                if(albumNames.get(musicHolder2+scrollCounter).equals("You Never Walk Alone"))
                {
                    albumContentsText.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 14));
                }
                else {
                    albumContentsText.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 20));
                }

                if(isdefaultSorted)
                {
                    albumContentsText.setText(albumNames.get(musicHolder2+scrollCounter));
                }
                if(isalphabeticalSorted)
                {
                    albumContentsText.setText(alphabeticalSortedAlbumsNames.get(musicHolder2+scrollCounter));
                }
                if(isreversealphabeticalSorted)
                {
                    albumContentsText.setText(reversepopularitySortedAlbumsNames.get(musicHolder2+scrollCounter));
                }
                if(ispopularitySorted)
                {
                    albumContentsText.setText(popularitySortedAlbumsNames.get(musicHolder2+scrollCounter));
                }
                if(isreversepopularitySorted)
                {
                    albumContentsText.setText(reversepopularitySortedAlbumsNames.get(musicHolder2+scrollCounter));
                }
                musicText1.setFill(Color.BLACK);
                musicText3.setFill(Color.BLACK);
                musicText4.setFill(Color.BLACK);
                musicText5.setFill(Color.BLACK);
                musicText6.setFill(Color.BLACK);
                musicText7.setFill(Color.BLACK);
                musicText8.setFill(Color.BLACK);
                musicText9.setFill(Color.BLACK);
                musicText10.setFill(Color.BLACK);
                musicText11.setFill(Color.BLACK);
                musicText12.setFill(Color.BLACK);
                musicButton1.setMaterial(musicButtonmaterial);
                musicButton3.setMaterial(musicButtonmaterial);
                musicButton4.setMaterial(musicButtonmaterial);
                musicButton5.setMaterial(musicButtonmaterial);
                musicButton6.setMaterial(musicButtonmaterial);
                musicButton7.setMaterial(musicButtonmaterial);
                musicButton8.setMaterial(musicButtonmaterial);
                musicButton9.setMaterial(musicButtonmaterial);
                musicButton10.setMaterial(musicButtonmaterial);
                musicButton11.setMaterial(musicButtonmaterial);
                musicButton12.setMaterial(musicButtonmaterial);
                musicText2.setFill(Color.RED);
                musicButton2.setMaterial(higlightedmusicbuttonmaterial);
                try
                {
                    if(isdefaultSorted)
                    {
                        Image defaultAlbumImage = new Image(new FileInputStream(albumPaths.get(musicHolder2+scrollCounter)));
                        defaultAlbummaterial.setDiffuseMap(defaultAlbumImage);
                    }
                    if(isalphabeticalSorted)
                    {
                        Image defaultAlbumImage = new Image(new FileInputStream(alphabeticalSortedAlbums.get(musicHolder2+scrollCounter)));
                        defaultAlbummaterial.setDiffuseMap(defaultAlbumImage);
                    }
                    if(isreversealphabeticalSorted)
                    {
                        Image defaultAlbumImage = new Image(new FileInputStream(reversealphabeticalSortedAlbums.get(musicHolder2+scrollCounter)));
                        defaultAlbummaterial.setDiffuseMap(defaultAlbumImage);
                    }
                    if(ispopularitySorted)
                    {
                        Image defaultAlbumImage = new Image(new FileInputStream(popularitySortedAlbums.get(musicHolder2+scrollCounter)));
                        defaultAlbummaterial.setDiffuseMap(defaultAlbumImage);
                    }
                    if(isreversepopularitySorted)
                    {
                        Image defaultAlbumImage = new Image(new FileInputStream(reversepopularitySortedAlbums.get(musicHolder2+scrollCounter)));
                        defaultAlbummaterial.setDiffuseMap(defaultAlbumImage);
                    }

                }
                catch (Exception E)
                {
                    System.out.println("File Not Found");
                }
                try
                {
                    if(isdefaultSorted)
                    {
                        if (activeClip != null) {
                            activeClip.stop();
                        }
                        activeClip = new Audio((preSongsFile.get(musicHolder2+scrollCounter)));
                        activeClip.play();
                    }
                    if(isalphabeticalSorted)
                    {
                        if (activeClip != null) {
                            activeClip.stop();
                        }
                        activeClip = new Audio((alphabeticalSortedPRE.get(musicHolder2+scrollCounter)));
                        activeClip.play();
                    }
                    if(isreversealphabeticalSorted)
                    {
                        if (activeClip != null) {
                            activeClip.stop();
                        }
                        activeClip = new Audio((reversealphabeticalSortedPRE.get(musicHolder2+scrollCounter)));
                        activeClip.play();
                    }
                    if(ispopularitySorted)
                    {
                        if (activeClip != null) {
                            activeClip.stop();
                        }
                        activeClip = new Audio((popularitySortedPRE.get(musicHolder2+scrollCounter)));
                        activeClip.play();
                    }
                    if(isreversepopularitySorted)
                    {
                        if (activeClip != null) {
                            activeClip.stop();
                        }
                        activeClip = new Audio((reversepopularitySortedPRE.get(musicHolder2+scrollCounter)));
                        activeClip.play();
                    }
                }
                catch(Exception E)
                {
                    System.out.println("ERROR: Audio");
                }
            });

            musicButton3.setOnMouseClicked(event-> {
                isHighlighted1=false;
                isHighlighted2=false;
                isHighlighted3=true;
                isHighlighted4=false;
                isHighlighted5=false;
                isHighlighted6=false;
                isHighlighted7=false;
                isHighlighted8=false;
                isHighlighted9=false;
                isHighlighted10=false;
                isHighlighted11=false;
                isHighlighted12=false;
                if(albumNames.get(musicHolder3+scrollCounter).equals("You Never Walk Alone"))
                {
                    albumContentsText.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 14));
                }
                else{
                    albumContentsText.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 20));
                }

                if(isdefaultSorted)
                {
                    albumContentsText.setText(albumNames.get(musicHolder3+scrollCounter));
                }
                if(isalphabeticalSorted)
                {
                    albumContentsText.setText(alphabeticalSortedAlbumsNames.get(musicHolder3+scrollCounter));
                }
                if(isreversealphabeticalSorted)
                {
                    albumContentsText.setText(reversepopularitySortedAlbumsNames.get(musicHolder3+scrollCounter));
                }
                if(ispopularitySorted)
                {
                    albumContentsText.setText(popularitySortedAlbumsNames.get(musicHolder3+scrollCounter));
                }
                if(isreversepopularitySorted)
                {
                    albumContentsText.setText(reversepopularitySortedAlbumsNames.get(musicHolder3+scrollCounter));
                }
                musicText1.setFill(Color.BLACK);
                musicText2.setFill(Color.BLACK);
                musicText4.setFill(Color.BLACK);
                musicText5.setFill(Color.BLACK);
                musicText6.setFill(Color.BLACK);
                musicText7.setFill(Color.BLACK);
                musicText8.setFill(Color.BLACK);
                musicText9.setFill(Color.BLACK);
                musicText10.setFill(Color.BLACK);
                musicText11.setFill(Color.BLACK);
                musicText12.setFill(Color.BLACK);
                musicButton1.setMaterial(musicButtonmaterial);
                musicButton2.setMaterial(musicButtonmaterial);
                musicButton4.setMaterial(musicButtonmaterial);
                musicButton5.setMaterial(musicButtonmaterial);
                musicButton6.setMaterial(musicButtonmaterial);
                musicButton7.setMaterial(musicButtonmaterial);
                musicButton8.setMaterial(musicButtonmaterial);
                musicButton9.setMaterial(musicButtonmaterial);
                musicButton10.setMaterial(musicButtonmaterial);
                musicButton11.setMaterial(musicButtonmaterial);
                musicButton12.setMaterial(musicButtonmaterial);
                musicText3.setFill(Color.RED);
                musicButton3.setMaterial(higlightedmusicbuttonmaterial);
                try
                {
                    if(isdefaultSorted)
                    {
                        Image defaultAlbumImage = new Image(new FileInputStream(albumPaths.get(musicHolder3+scrollCounter)));
                        defaultAlbummaterial.setDiffuseMap(defaultAlbumImage);
                    }
                    if(isalphabeticalSorted)
                    {
                        Image defaultAlbumImage = new Image(new FileInputStream(alphabeticalSortedAlbums.get(musicHolder3+scrollCounter)));
                        defaultAlbummaterial.setDiffuseMap(defaultAlbumImage);
                    }
                    if(isreversealphabeticalSorted)
                    {
                        Image defaultAlbumImage = new Image(new FileInputStream(reversealphabeticalSortedAlbums.get(musicHolder3+scrollCounter)));
                        defaultAlbummaterial.setDiffuseMap(defaultAlbumImage);
                    }
                    if(ispopularitySorted)
                    {
                        Image defaultAlbumImage = new Image(new FileInputStream(popularitySortedAlbums.get(musicHolder3+scrollCounter)));
                        defaultAlbummaterial.setDiffuseMap(defaultAlbumImage);
                    }
                    if(isreversepopularitySorted)
                    {
                        Image defaultAlbumImage = new Image(new FileInputStream(reversepopularitySortedAlbums.get(musicHolder3+scrollCounter)));
                        defaultAlbummaterial.setDiffuseMap(defaultAlbumImage);
                    }

                }
                catch (Exception E)
                {
                    System.out.println("File Not Found");
                }
                try
                {
                    if(isdefaultSorted)
                    {
                        if (activeClip != null) {
                            activeClip.stop();
                        }
                        activeClip = new Audio((preSongsFile.get(musicHolder3+scrollCounter)));
                        activeClip.play();
                    }
                    if(isalphabeticalSorted)
                    {
                        if (activeClip != null) {
                            activeClip.stop();
                        }
                        activeClip = new Audio((alphabeticalSortedPRE.get(musicHolder3+scrollCounter)));
                        activeClip.play();
                    }
                    if(isreversealphabeticalSorted)
                    {
                        if (activeClip != null) {
                            activeClip.stop();
                        }
                        activeClip = new Audio((reversealphabeticalSortedPRE.get(musicHolder3+scrollCounter)));
                        activeClip.play();
                    }
                    if(ispopularitySorted)
                    {
                        if (activeClip != null) {
                            activeClip.stop();
                        }
                        activeClip = new Audio((popularitySortedPRE.get(musicHolder3+scrollCounter)));
                        activeClip.play();
                    }
                    if(isreversepopularitySorted)
                    {
                        if (activeClip != null) {
                            activeClip.stop();
                        }
                        activeClip = new Audio((reversepopularitySortedPRE.get(musicHolder3+scrollCounter)));
                        activeClip.play();
                    }
                }
                catch(Exception E)
                {
                    System.out.println("ERROR: Audio");
                }
            });

            musicButton4.setOnMouseClicked(event-> {
                isHighlighted1=false;
                isHighlighted2=false;
                isHighlighted3=false;
                isHighlighted4=true;
                isHighlighted5=false;
                isHighlighted6=false;
                isHighlighted7=false;
                isHighlighted8=false;
                isHighlighted9=false;
                isHighlighted10=false;
                isHighlighted11=false;
                isHighlighted12=false;
                if(albumNames.get(musicHolder4+scrollCounter).equals("You Never Walk Alone"))
                {
                    albumContentsText.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 14));
                }
                else {
                    albumContentsText.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 20));
                }
                if(isdefaultSorted)
                {
                    albumContentsText.setText(albumNames.get(musicHolder4+scrollCounter));
                }
                if(isalphabeticalSorted)
                {
                    albumContentsText.setText(alphabeticalSortedAlbumsNames.get(musicHolder4+scrollCounter));
                }
                if(isreversealphabeticalSorted)
                {
                    albumContentsText.setText(reversepopularitySortedAlbumsNames.get(musicHolder4+scrollCounter));
                }
                if(ispopularitySorted)
                {
                    albumContentsText.setText(popularitySortedAlbumsNames.get(musicHolder4+scrollCounter));
                }
                if(isreversepopularitySorted)
                {
                    albumContentsText.setText(reversepopularitySortedAlbumsNames.get(musicHolder4+scrollCounter));
                }
                musicText1.setFill(Color.BLACK);
                musicText2.setFill(Color.BLACK);
                musicText3.setFill(Color.BLACK);
                musicText5.setFill(Color.BLACK);
                musicText6.setFill(Color.BLACK);
                musicText7.setFill(Color.BLACK);
                musicText8.setFill(Color.BLACK);
                musicText9.setFill(Color.BLACK);
                musicText10.setFill(Color.BLACK);
                musicText11.setFill(Color.BLACK);
                musicText12.setFill(Color.BLACK);
                musicButton1.setMaterial(musicButtonmaterial);
                musicButton2.setMaterial(musicButtonmaterial);
                musicButton3.setMaterial(musicButtonmaterial);
                musicButton5.setMaterial(musicButtonmaterial);
                musicButton6.setMaterial(musicButtonmaterial);
                musicButton7.setMaterial(musicButtonmaterial);
                musicButton8.setMaterial(musicButtonmaterial);
                musicButton9.setMaterial(musicButtonmaterial);
                musicButton10.setMaterial(musicButtonmaterial);
                musicButton11.setMaterial(musicButtonmaterial);
                musicButton12.setMaterial(musicButtonmaterial);
                musicText4.setFill(Color.RED);
                musicButton4.setMaterial(higlightedmusicbuttonmaterial);
                try
                {
                    if(isdefaultSorted)
                    {
                        Image defaultAlbumImage = new Image(new FileInputStream(albumPaths.get(musicHolder4+scrollCounter)));
                        defaultAlbummaterial.setDiffuseMap(defaultAlbumImage);
                    }
                    if(isalphabeticalSorted)
                    {
                        Image defaultAlbumImage = new Image(new FileInputStream(alphabeticalSortedAlbums.get(musicHolder4+scrollCounter)));
                        defaultAlbummaterial.setDiffuseMap(defaultAlbumImage);
                    }
                    if(isreversealphabeticalSorted)
                    {
                        Image defaultAlbumImage = new Image(new FileInputStream(reversealphabeticalSortedAlbums.get(musicHolder4+scrollCounter)));
                        defaultAlbummaterial.setDiffuseMap(defaultAlbumImage);
                    }
                    if(ispopularitySorted)
                    {
                        Image defaultAlbumImage = new Image(new FileInputStream(popularitySortedAlbums.get(musicHolder4+scrollCounter)));
                        defaultAlbummaterial.setDiffuseMap(defaultAlbumImage);
                    }
                    if(isreversepopularitySorted)
                    {
                        Image defaultAlbumImage = new Image(new FileInputStream(reversepopularitySortedAlbums.get(musicHolder4+scrollCounter)));
                        defaultAlbummaterial.setDiffuseMap(defaultAlbumImage);
                    }

                }
                catch (Exception E)
                {
                    System.out.println("File Not Found");
                }
                try
                {
                    if(isdefaultSorted)
                    {
                        if (activeClip != null) {
                            activeClip.stop();
                        }
                        activeClip = new Audio((preSongsFile.get(musicHolder4+scrollCounter)));
                        activeClip.play();
                    }
                    if(isalphabeticalSorted)
                    {
                        if (activeClip != null) {
                            activeClip.stop();
                        }
                        activeClip = new Audio((alphabeticalSortedPRE.get(musicHolder4+scrollCounter)));
                        activeClip.play();
                    }
                    if(isreversealphabeticalSorted)
                    {
                        if (activeClip != null) {
                            activeClip.stop();
                        }
                        activeClip = new Audio((reversealphabeticalSortedPRE.get(musicHolder4+scrollCounter)));
                        activeClip.play();
                    }
                    if(ispopularitySorted)
                    {
                        if (activeClip != null) {
                            activeClip.stop();
                        }
                        activeClip = new Audio((popularitySortedPRE.get(musicHolder4+scrollCounter)));
                        activeClip.play();
                    }
                    if(isreversepopularitySorted)
                    {
                        if (activeClip != null) {
                            activeClip.stop();
                        }
                        activeClip = new Audio((reversepopularitySortedPRE.get(musicHolder4+scrollCounter)));
                        activeClip.play();
                    }
                }
                catch(Exception E)
                {
                    System.out.println("ERROR: Audio");
                }
            });

            musicButton5.setOnMouseClicked(event-> {
                isHighlighted1=false;
                isHighlighted2=false;
                isHighlighted3=false;
                isHighlighted4=false;
                isHighlighted5=true;
                isHighlighted6=false;
                isHighlighted7=false;
                isHighlighted8=false;
                isHighlighted9=false;
                isHighlighted10=false;
                isHighlighted11=false;
                isHighlighted12=false;
                if(albumNames.get(musicHolder5+scrollCounter).equals("You Never Walk Alone"))
                {
                    albumContentsText.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 14));
                }
                else
                {
                    albumContentsText.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 16));
                }
                if(isdefaultSorted)
                {
                    albumContentsText.setText(albumNames.get(musicHolder5+scrollCounter));
                }
                if(isalphabeticalSorted)
                {
                    albumContentsText.setText(alphabeticalSortedAlbumsNames.get(musicHolder5+scrollCounter));
                }
                if(isreversealphabeticalSorted)
                {
                    albumContentsText.setText(reversepopularitySortedAlbumsNames.get(musicHolder5+scrollCounter));
                }
                if(ispopularitySorted)
                {
                    albumContentsText.setText(popularitySortedAlbumsNames.get(musicHolder5+scrollCounter));
                }
                if(isreversepopularitySorted)
                {
                    albumContentsText.setText(reversepopularitySortedAlbumsNames.get(musicHolder5+scrollCounter));
                }
                musicText5.setFill(Color.RED);
                musicButton5.setMaterial(higlightedmusicbuttonmaterial);
                musicText1.setFill(Color.BLACK);
                musicText2.setFill(Color.BLACK);
                musicText3.setFill(Color.BLACK);
                musicText4.setFill(Color.BLACK);
                musicText6.setFill(Color.BLACK);
                musicText7.setFill(Color.BLACK);
                musicText8.setFill(Color.BLACK);
                musicText9.setFill(Color.BLACK);
                musicText10.setFill(Color.BLACK);
                musicText11.setFill(Color.BLACK);
                musicText12.setFill(Color.BLACK);
                musicButton1.setMaterial(musicButtonmaterial);
                musicButton2.setMaterial(musicButtonmaterial);
                musicButton3.setMaterial(musicButtonmaterial);
                musicButton4.setMaterial(musicButtonmaterial);
                musicButton6.setMaterial(musicButtonmaterial);
                musicButton7.setMaterial(musicButtonmaterial);
                musicButton8.setMaterial(musicButtonmaterial);
                musicButton9.setMaterial(musicButtonmaterial);
                musicButton10.setMaterial(musicButtonmaterial);
                musicButton11.setMaterial(musicButtonmaterial);
                musicButton12.setMaterial(musicButtonmaterial);
                try
                {
                    if(isdefaultSorted)
                    {
                        Image defaultAlbumImage = new Image(new FileInputStream(albumPaths.get(musicHolder5+scrollCounter)));
                        defaultAlbummaterial.setDiffuseMap(defaultAlbumImage);
                    }
                    if(isalphabeticalSorted)
                    {
                        Image defaultAlbumImage = new Image(new FileInputStream(alphabeticalSortedAlbums.get(musicHolder5+scrollCounter)));
                        defaultAlbummaterial.setDiffuseMap(defaultAlbumImage);
                    }
                    if(isreversealphabeticalSorted)
                    {
                        Image defaultAlbumImage = new Image(new FileInputStream(reversealphabeticalSortedAlbums.get(musicHolder5+scrollCounter)));
                        defaultAlbummaterial.setDiffuseMap(defaultAlbumImage);
                    }
                    if(ispopularitySorted)
                    {
                        Image defaultAlbumImage = new Image(new FileInputStream(popularitySortedAlbums.get(musicHolder5+scrollCounter)));
                        defaultAlbummaterial.setDiffuseMap(defaultAlbumImage);
                    }
                    if(isreversepopularitySorted)
                    {
                        Image defaultAlbumImage = new Image(new FileInputStream(reversepopularitySortedAlbums.get(musicHolder5+scrollCounter)));
                        defaultAlbummaterial.setDiffuseMap(defaultAlbumImage);
                    }

                }
                catch (Exception E)
                {
                    System.out.println("File Not Found");
                }
                try
                {
                    if(isdefaultSorted)
                    {
                        if (activeClip != null) {
                            activeClip.stop();
                        }
                        activeClip = new Audio((preSongsFile.get(musicHolder5+scrollCounter)));
                        activeClip.play();
                    }
                    if(isalphabeticalSorted)
                    {
                        if (activeClip != null) {
                            activeClip.stop();
                        }
                        activeClip = new Audio((alphabeticalSortedPRE.get(musicHolder5+scrollCounter)));
                        activeClip.play();
                    }
                    if(isreversealphabeticalSorted)
                    {
                        if (activeClip != null) {
                            activeClip.stop();
                        }
                        activeClip = new Audio((reversealphabeticalSortedPRE.get(musicHolder5+scrollCounter)));
                        activeClip.play();
                    }
                    if(ispopularitySorted)
                    {
                        if (activeClip != null) {
                            activeClip.stop();
                        }
                        activeClip = new Audio((popularitySortedPRE.get(musicHolder5+scrollCounter)));
                        activeClip.play();
                    }
                    if(isreversepopularitySorted)
                    {
                        if (activeClip != null) {
                            activeClip.stop();
                        }
                        activeClip = new Audio((reversepopularitySortedPRE.get(musicHolder5+scrollCounter)));
                        activeClip.play();
                    }
                }
                catch(Exception E)
                {
                    System.out.println("ERROR: Audio");
                }
            });

            musicButton6.setOnMouseClicked(event-> {
                isHighlighted1=false;
                isHighlighted2=false;
                isHighlighted3=false;
                isHighlighted4=false;
                isHighlighted5=false;
                isHighlighted6=true;
                isHighlighted7=false;
                isHighlighted8=false;
                isHighlighted9=false;
                isHighlighted10=false;
                isHighlighted11=false;
                isHighlighted12=false;
                albumContentsText.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 20));
                if(isdefaultSorted)
                {
                    albumContentsText.setText(albumNames.get(musicHolder6+scrollCounter));
                }
                if(isalphabeticalSorted)
                {
                    albumContentsText.setText(alphabeticalSortedAlbumsNames.get(musicHolder6+scrollCounter));
                }
                if(isreversealphabeticalSorted)
                {
                    albumContentsText.setText(reversepopularitySortedAlbumsNames.get(musicHolder6+scrollCounter));
                }
                if(ispopularitySorted)
                {
                    albumContentsText.setText(popularitySortedAlbumsNames.get(musicHolder6+scrollCounter));
                }
                if(isreversepopularitySorted)
                {
                    albumContentsText.setText(reversepopularitySortedAlbumsNames.get(musicHolder6+scrollCounter));
                }
                musicText6.setFill(Color.RED);
                musicButton6.setMaterial(higlightedmusicbuttonmaterial);
                musicText1.setFill(Color.BLACK);
                musicText2.setFill(Color.BLACK);
                musicText3.setFill(Color.BLACK);
                musicText4.setFill(Color.BLACK);
                musicText5.setFill(Color.BLACK);
                musicText7.setFill(Color.BLACK);
                musicText8.setFill(Color.BLACK);
                musicText9.setFill(Color.BLACK);
                musicText10.setFill(Color.BLACK);
                musicText11.setFill(Color.BLACK);
                musicText12.setFill(Color.BLACK);
                musicButton1.setMaterial(musicButtonmaterial);
                musicButton2.setMaterial(musicButtonmaterial);
                musicButton3.setMaterial(musicButtonmaterial);
                musicButton4.setMaterial(musicButtonmaterial);
                musicButton5.setMaterial(musicButtonmaterial);
                musicButton7.setMaterial(musicButtonmaterial);
                musicButton8.setMaterial(musicButtonmaterial);
                musicButton9.setMaterial(musicButtonmaterial);
                musicButton10.setMaterial(musicButtonmaterial);
                musicButton11.setMaterial(musicButtonmaterial);
                musicButton12.setMaterial(musicButtonmaterial);
                try
                {
                    if(isdefaultSorted)
                    {
                        Image defaultAlbumImage = new Image(new FileInputStream(albumPaths.get(musicHolder6+scrollCounter)));
                        defaultAlbummaterial.setDiffuseMap(defaultAlbumImage);
                    }
                    if(isalphabeticalSorted)
                    {
                        Image defaultAlbumImage = new Image(new FileInputStream(alphabeticalSortedAlbums.get(musicHolder6+scrollCounter)));
                        defaultAlbummaterial.setDiffuseMap(defaultAlbumImage);
                    }
                    if(isreversealphabeticalSorted)
                    {
                        Image defaultAlbumImage = new Image(new FileInputStream(reversealphabeticalSortedAlbums.get(musicHolder6+scrollCounter)));
                        defaultAlbummaterial.setDiffuseMap(defaultAlbumImage);
                    }
                    if(ispopularitySorted)
                    {
                        Image defaultAlbumImage = new Image(new FileInputStream(popularitySortedAlbums.get(musicHolder6+scrollCounter)));
                        defaultAlbummaterial.setDiffuseMap(defaultAlbumImage);
                    }
                    if(isreversepopularitySorted)
                    {
                        Image defaultAlbumImage = new Image(new FileInputStream(reversepopularitySortedAlbums.get(musicHolder6+scrollCounter)));
                        defaultAlbummaterial.setDiffuseMap(defaultAlbumImage);
                    }

                }
                catch (Exception E)
                {
                    System.out.println("File Not Found");
                }
                try
                {
                    if(isdefaultSorted)
                    {
                        if (activeClip != null) {
                            activeClip.stop();
                        }
                        activeClip = new Audio((preSongsFile.get(musicHolder6+scrollCounter)));
                        activeClip.play();
                    }
                    if(isalphabeticalSorted)
                    {
                        if (activeClip != null) {
                            activeClip.stop();
                        }
                        activeClip = new Audio((alphabeticalSortedPRE.get(musicHolder6+scrollCounter)));
                        activeClip.play();
                    }
                    if(isreversealphabeticalSorted)
                    {
                        if (activeClip != null) {
                            activeClip.stop();
                        }
                        activeClip = new Audio((reversealphabeticalSortedPRE.get(musicHolder6+scrollCounter)));
                        activeClip.play();
                    }
                    if(ispopularitySorted)
                    {
                        if (activeClip != null) {
                            activeClip.stop();
                        }
                        activeClip = new Audio((popularitySortedPRE.get(musicHolder6+scrollCounter)));
                        activeClip.play();
                    }
                    if(isreversepopularitySorted)
                    {
                        if (activeClip != null) {
                            activeClip.stop();
                        }
                        activeClip = new Audio((reversepopularitySortedPRE.get(musicHolder6+scrollCounter)));
                        activeClip.play();
                    }
                }
                catch(Exception E)
                {
                    System.out.println("ERROR: Audio");
                }
            });

            musicButton7.setOnMouseClicked(event-> {
                isHighlighted1=false;
                isHighlighted2=false;
                isHighlighted3=false;
                isHighlighted4=false;
                isHighlighted5=false;
                isHighlighted6=false;
                isHighlighted7=true;
                isHighlighted8=false;
                isHighlighted9=false;
                isHighlighted10=false;
                isHighlighted11=false;
                isHighlighted12=false;
                albumContentsText.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 20));
                if(isdefaultSorted)
                {
                    albumContentsText.setText(albumNames.get(musicHolder7+scrollCounter));
                }
                if(isalphabeticalSorted)
                {
                    albumContentsText.setText(alphabeticalSortedAlbumsNames.get(musicHolder7+scrollCounter));
                }
                if(isreversealphabeticalSorted)
                {
                    albumContentsText.setText(reversepopularitySortedAlbumsNames.get(musicHolder7+scrollCounter));
                }
                if(ispopularitySorted)
                {
                    albumContentsText.setText(popularitySortedAlbumsNames.get(musicHolder7+scrollCounter));
                }
                if(isreversepopularitySorted)
                {
                    albumContentsText.setText(reversepopularitySortedAlbumsNames.get(musicHolder7+scrollCounter));
                }
                musicText1.setFill(Color.BLACK);
                musicText2.setFill(Color.BLACK);
                musicText3.setFill(Color.BLACK);
                musicText4.setFill(Color.BLACK);
                musicText5.setFill(Color.BLACK);
                musicText6.setFill(Color.BLACK);
                musicText8.setFill(Color.BLACK);
                musicText9.setFill(Color.BLACK);
                musicText10.setFill(Color.BLACK);
                musicText11.setFill(Color.BLACK);
                musicText12.setFill(Color.BLACK);
                musicButton1.setMaterial(musicButtonmaterial);
                musicButton2.setMaterial(musicButtonmaterial);
                musicButton3.setMaterial(musicButtonmaterial);
                musicButton4.setMaterial(musicButtonmaterial);
                musicButton5.setMaterial(musicButtonmaterial);
                musicButton6.setMaterial(musicButtonmaterial);
                musicButton8.setMaterial(musicButtonmaterial);
                musicButton9.setMaterial(musicButtonmaterial);
                musicButton10.setMaterial(musicButtonmaterial);
                musicButton11.setMaterial(musicButtonmaterial);
                musicButton12.setMaterial(musicButtonmaterial);
                musicText7.setFill(Color.RED);
                musicButton7.setMaterial(higlightedmusicbuttonmaterial);
                try
                {
                    if(isdefaultSorted)
                    {
                        Image defaultAlbumImage = new Image(new FileInputStream(albumPaths.get(musicHolder7+scrollCounter)));
                        defaultAlbummaterial.setDiffuseMap(defaultAlbumImage);
                    }
                    if(isalphabeticalSorted)
                    {
                        Image defaultAlbumImage = new Image(new FileInputStream(alphabeticalSortedAlbums.get(musicHolder7+scrollCounter)));
                        defaultAlbummaterial.setDiffuseMap(defaultAlbumImage);
                    }
                    if(isreversealphabeticalSorted)
                    {
                        Image defaultAlbumImage = new Image(new FileInputStream(reversealphabeticalSortedAlbums.get(musicHolder7+scrollCounter)));
                        defaultAlbummaterial.setDiffuseMap(defaultAlbumImage);
                    }
                    if(ispopularitySorted)
                    {
                        Image defaultAlbumImage = new Image(new FileInputStream(popularitySortedAlbums.get(musicHolder7+scrollCounter)));
                        defaultAlbummaterial.setDiffuseMap(defaultAlbumImage);
                    }
                    if(isreversepopularitySorted)
                    {
                        Image defaultAlbumImage = new Image(new FileInputStream(reversepopularitySortedAlbums.get(musicHolder7+scrollCounter)));
                        defaultAlbummaterial.setDiffuseMap(defaultAlbumImage);
                    }

                }
                catch (Exception E)
                {
                    System.out.println("File Not Found");
                }
                try
                {
                    if(isdefaultSorted)
                    {
                        if (activeClip != null) {
                            activeClip.stop();
                        }
                        activeClip = new Audio((preSongsFile.get(musicHolder7+scrollCounter)));
                        activeClip.play();
                    }
                    if(isalphabeticalSorted)
                    {
                        if (activeClip != null) {
                            activeClip.stop();
                        }
                        activeClip = new Audio((alphabeticalSortedPRE.get(musicHolder7+scrollCounter)));
                        activeClip.play();
                    }
                    if(isreversealphabeticalSorted)
                    {
                        if (activeClip != null) {
                            activeClip.stop();
                        }
                        activeClip = new Audio((reversealphabeticalSortedPRE.get(musicHolder7+scrollCounter)));
                        activeClip.play();
                    }
                    if(ispopularitySorted)
                    {
                        if (activeClip != null) {
                            activeClip.stop();
                        }
                        activeClip = new Audio((popularitySortedPRE.get(musicHolder7+scrollCounter)));
                        activeClip.play();
                    }
                    if(isreversepopularitySorted)
                    {
                        if (activeClip != null) {
                            activeClip.stop();
                        }
                        activeClip = new Audio((reversepopularitySortedPRE.get(musicHolder7+scrollCounter)));
                        activeClip.play();
                    }
                }
                catch(Exception E)
                {
                    System.out.println("ERROR: Audio");
                }
            });

            musicButton8.setOnMouseClicked(event-> {
                isHighlighted1=false;
                isHighlighted2=false;
                isHighlighted3=false;
                isHighlighted4=false;
                isHighlighted5=false;
                isHighlighted6=false;
                isHighlighted7=false;
                isHighlighted8=true;
                isHighlighted9=false;
                isHighlighted10=false;
                isHighlighted11=false;
                isHighlighted12=false;
                albumContentsText.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 20));
                if(isdefaultSorted)
                {
                    albumContentsText.setText(albumNames.get(musicHolder8+scrollCounter));
                }
                if(isalphabeticalSorted)
                {
                    albumContentsText.setText(alphabeticalSortedAlbumsNames.get(musicHolder8+scrollCounter));
                }
                if(isreversealphabeticalSorted)
                {
                    albumContentsText.setText(reversepopularitySortedAlbumsNames.get(musicHolder8+scrollCounter));
                }
                if(ispopularitySorted)
                {
                    albumContentsText.setText(popularitySortedAlbumsNames.get(musicHolder8+scrollCounter));
                }
                if(isreversepopularitySorted)
                {
                    albumContentsText.setText(reversepopularitySortedAlbumsNames.get(musicHolder8+scrollCounter));
                }
                musicText1.setFill(Color.BLACK);
                musicText2.setFill(Color.BLACK);
                musicText3.setFill(Color.BLACK);
                musicText4.setFill(Color.BLACK);
                musicText5.setFill(Color.BLACK);
                musicText6.setFill(Color.BLACK);
                musicText7.setFill(Color.BLACK);
                musicText9.setFill(Color.BLACK);
                musicText10.setFill(Color.BLACK);
                musicText11.setFill(Color.BLACK);
                musicText12.setFill(Color.BLACK);
                musicButton1.setMaterial(musicButtonmaterial);
                musicButton2.setMaterial(musicButtonmaterial);
                musicButton3.setMaterial(musicButtonmaterial);
                musicButton4.setMaterial(musicButtonmaterial);
                musicButton5.setMaterial(musicButtonmaterial);
                musicButton6.setMaterial(musicButtonmaterial);
                musicButton7.setMaterial(musicButtonmaterial);
                musicButton9.setMaterial(musicButtonmaterial);
                musicButton10.setMaterial(musicButtonmaterial);
                musicButton11.setMaterial(musicButtonmaterial);
                musicButton12.setMaterial(musicButtonmaterial);
                musicText8.setFill(Color.RED);
                musicButton8.setMaterial(higlightedmusicbuttonmaterial);

                try
                {
                    if(isdefaultSorted)
                    {
                        Image defaultAlbumImage = new Image(new FileInputStream(albumPaths.get(musicHolder8+scrollCounter)));
                        defaultAlbummaterial.setDiffuseMap(defaultAlbumImage);
                    }
                    if(isalphabeticalSorted)
                    {
                        Image defaultAlbumImage = new Image(new FileInputStream(alphabeticalSortedAlbums.get(musicHolder8+scrollCounter)));
                        defaultAlbummaterial.setDiffuseMap(defaultAlbumImage);
                    }
                    if(isreversealphabeticalSorted)
                    {
                        Image defaultAlbumImage = new Image(new FileInputStream(reversealphabeticalSortedAlbums.get(musicHolder8+scrollCounter)));
                        defaultAlbummaterial.setDiffuseMap(defaultAlbumImage);
                    }
                    if(ispopularitySorted)
                    {
                        Image defaultAlbumImage = new Image(new FileInputStream(popularitySortedAlbums.get(musicHolder8+scrollCounter)));
                        defaultAlbummaterial.setDiffuseMap(defaultAlbumImage);
                    }
                    if(isreversepopularitySorted)
                    {
                        Image defaultAlbumImage = new Image(new FileInputStream(reversepopularitySortedAlbums.get(musicHolder8+scrollCounter)));
                        defaultAlbummaterial.setDiffuseMap(defaultAlbumImage);
                    }

                }
                catch (Exception E)
                {
                    System.out.println("File Not Found");
                }
                try
                {
                    if(isdefaultSorted)
                    {
                        if (activeClip != null) {
                            activeClip.stop();
                        }
                        activeClip = new Audio((preSongsFile.get(musicHolder8+scrollCounter)));
                        activeClip.play();
                    }
                    if(isalphabeticalSorted)
                    {
                        if (activeClip != null) {
                            activeClip.stop();
                        }
                        activeClip = new Audio((alphabeticalSortedPRE.get(musicHolder8+scrollCounter)));
                        activeClip.play();
                    }
                    if(isreversealphabeticalSorted)
                    {
                        if (activeClip != null) {
                            activeClip.stop();
                        }
                        activeClip = new Audio((reversealphabeticalSortedPRE.get(musicHolder8+scrollCounter)));
                        activeClip.play();
                    }
                    if(ispopularitySorted)
                    {
                        if (activeClip != null) {
                            activeClip.stop();
                        }
                        activeClip = new Audio((popularitySortedPRE.get(musicHolder8+scrollCounter)));
                        activeClip.play();
                    }
                    if(isreversepopularitySorted)
                    {
                        if (activeClip != null) {
                            activeClip.stop();
                        }
                        activeClip = new Audio((reversepopularitySortedPRE.get(musicHolder8+scrollCounter)));
                        activeClip.play();
                    }
                }
                catch(Exception E)
                {
                    System.out.println("ERROR: Audio");
                }
            });

            musicButton9.setOnMouseClicked(event-> {
                isHighlighted1=false;
                isHighlighted2=false;
                isHighlighted3=false;
                isHighlighted4=false;
                isHighlighted5=false;
                isHighlighted6=false;
                isHighlighted7=false;
                isHighlighted8=false;
                isHighlighted9=true;
                isHighlighted10=false;
                isHighlighted11=false;
                isHighlighted12=false;
                if(albumNames.get(musicHolder9+scrollCounter).equals("The Chaos Chapter: FREEZE"))
                {
                    albumContentsText.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 12));
                }
                else {
                    albumContentsText.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 20));
                }
                if(isdefaultSorted)
                {
                    albumContentsText.setText(albumNames.get(musicHolder9+scrollCounter));
                }
                if(isalphabeticalSorted)
                {
                    albumContentsText.setText(alphabeticalSortedAlbumsNames.get(musicHolder9+scrollCounter));
                }
                if(isreversealphabeticalSorted)
                {
                    albumContentsText.setText(reversepopularitySortedAlbumsNames.get(musicHolder9+scrollCounter));
                }
                if(ispopularitySorted)
                {
                    albumContentsText.setText(popularitySortedAlbumsNames.get(musicHolder9+scrollCounter));
                }
                if(isreversepopularitySorted)
                {
                    albumContentsText.setText(reversepopularitySortedAlbumsNames.get(musicHolder9+scrollCounter));
                }
                musicText1.setFill(Color.BLACK);
                musicText2.setFill(Color.BLACK);
                musicText3.setFill(Color.BLACK);
                musicText4.setFill(Color.BLACK);
                musicText5.setFill(Color.BLACK);
                musicText6.setFill(Color.BLACK);
                musicText7.setFill(Color.BLACK);
                musicText8.setFill(Color.BLACK);
                musicText10.setFill(Color.BLACK);
                musicText11.setFill(Color.BLACK);
                musicText12.setFill(Color.BLACK);
                musicButton1.setMaterial(musicButtonmaterial);
                musicButton2.setMaterial(musicButtonmaterial);
                musicButton3.setMaterial(musicButtonmaterial);
                musicButton4.setMaterial(musicButtonmaterial);
                musicButton5.setMaterial(musicButtonmaterial);
                musicButton6.setMaterial(musicButtonmaterial);
                musicButton7.setMaterial(musicButtonmaterial);
                musicButton8.setMaterial(musicButtonmaterial);
                musicButton10.setMaterial(musicButtonmaterial);
                musicButton11.setMaterial(musicButtonmaterial);
                musicButton12.setMaterial(musicButtonmaterial);
                musicText9.setFill(Color.RED);
                musicButton9.setMaterial(higlightedmusicbuttonmaterial);
                try
                {
                    if(isdefaultSorted)
                    {
                        Image defaultAlbumImage = new Image(new FileInputStream(albumPaths.get(musicHolder9+scrollCounter)));
                        defaultAlbummaterial.setDiffuseMap(defaultAlbumImage);
                    }
                    if(isalphabeticalSorted)
                    {
                        Image defaultAlbumImage = new Image(new FileInputStream(alphabeticalSortedAlbums.get(musicHolder9+scrollCounter)));
                        defaultAlbummaterial.setDiffuseMap(defaultAlbumImage);
                    }
                    if(isreversealphabeticalSorted)
                    {
                        Image defaultAlbumImage = new Image(new FileInputStream(reversealphabeticalSortedAlbums.get(musicHolder9+scrollCounter)));
                        defaultAlbummaterial.setDiffuseMap(defaultAlbumImage);
                    }
                    if(ispopularitySorted)
                    {
                        Image defaultAlbumImage = new Image(new FileInputStream(popularitySortedAlbums.get(musicHolder9+scrollCounter)));
                        defaultAlbummaterial.setDiffuseMap(defaultAlbumImage);
                    }
                    if(isreversepopularitySorted)
                    {
                        Image defaultAlbumImage = new Image(new FileInputStream(reversepopularitySortedAlbums.get(musicHolder9+scrollCounter)));
                        defaultAlbummaterial.setDiffuseMap(defaultAlbumImage);
                    }

                }
                catch (Exception E)
                {
                    System.out.println("File Not Found");
                }
                try
                {
                    if(isdefaultSorted)
                    {
                        if (activeClip != null) {
                            activeClip.stop();
                        }
                        activeClip = new Audio((preSongsFile.get(musicHolder9+scrollCounter)));
                        activeClip.play();
                    }
                    if(isalphabeticalSorted)
                    {
                        if (activeClip != null) {
                            activeClip.stop();
                        }
                        activeClip = new Audio((alphabeticalSortedPRE.get(musicHolder9+scrollCounter)));
                        activeClip.play();
                    }
                    if(isreversealphabeticalSorted)
                    {
                        if (activeClip != null) {
                            activeClip.stop();
                        }
                        activeClip = new Audio((reversealphabeticalSortedPRE.get(musicHolder9+scrollCounter)));
                        activeClip.play();
                    }
                    if(ispopularitySorted)
                    {
                        if (activeClip != null) {
                            activeClip.stop();
                        }
                        activeClip = new Audio((popularitySortedPRE.get(musicHolder9+scrollCounter)));
                        activeClip.play();
                    }
                    if(isreversepopularitySorted)
                    {
                        if (activeClip != null) {
                            activeClip.stop();
                        }
                        activeClip = new Audio((reversepopularitySortedPRE.get(musicHolder9+scrollCounter)));
                        activeClip.play();
                    }
                }
                catch(Exception E)
                {
                    System.out.println("ERROR: Audio");
                }
            });

            musicButton10.setOnMouseClicked(event-> {
                isHighlighted1=false;
                isHighlighted2=false;
                isHighlighted3=false;
                isHighlighted4=false;
                isHighlighted5=false;
                isHighlighted6=false;
                isHighlighted7=false;
                isHighlighted8=false;
                isHighlighted9=false;
                isHighlighted10=true;
                isHighlighted11=false;
                isHighlighted12=false;
                if(albumNames.get(musicHolder10+scrollCounter).equals("The Chaos Chapter: FREEZE"))
                {
                    albumContentsText.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 12));
                }
                else {
                    albumContentsText.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 20));
                }
                if(isdefaultSorted)
                {
                    albumContentsText.setText(albumNames.get(musicHolder10+scrollCounter));
                }
                if(isalphabeticalSorted)
                {
                    albumContentsText.setText(alphabeticalSortedAlbumsNames.get(musicHolder10+scrollCounter));
                }
                if(isreversealphabeticalSorted)
                {
                    albumContentsText.setText(reversepopularitySortedAlbumsNames.get(musicHolder10+scrollCounter));
                }
                if(ispopularitySorted)
                {
                    albumContentsText.setText(popularitySortedAlbumsNames.get(musicHolder10+scrollCounter));
                }
                if(isreversepopularitySorted)
                {
                    albumContentsText.setText(reversepopularitySortedAlbumsNames.get(musicHolder10+scrollCounter));
                }
                musicText10.setFill(Color.RED);
                musicButton10.setMaterial(higlightedmusicbuttonmaterial);
                musicText1.setFill(Color.BLACK);
                musicText2.setFill(Color.BLACK);
                musicText3.setFill(Color.BLACK);
                musicText4.setFill(Color.BLACK);
                musicText5.setFill(Color.BLACK);
                musicText6.setFill(Color.BLACK);
                musicText7.setFill(Color.BLACK);
                musicText8.setFill(Color.BLACK);
                musicText9.setFill(Color.BLACK);
                musicText11.setFill(Color.BLACK);
                musicText12.setFill(Color.BLACK);
                musicButton1.setMaterial(musicButtonmaterial);
                musicButton2.setMaterial(musicButtonmaterial);
                musicButton3.setMaterial(musicButtonmaterial);
                musicButton4.setMaterial(musicButtonmaterial);
                musicButton5.setMaterial(musicButtonmaterial);
                musicButton6.setMaterial(musicButtonmaterial);
                musicButton7.setMaterial(musicButtonmaterial);
                musicButton8.setMaterial(musicButtonmaterial);
                musicButton9.setMaterial(musicButtonmaterial);
                musicButton11.setMaterial(musicButtonmaterial);
                musicButton12.setMaterial(musicButtonmaterial);
                try
                {
                    if(isdefaultSorted)
                    {
                        Image defaultAlbumImage = new Image(new FileInputStream(albumPaths.get(musicHolder10+scrollCounter)));
                        defaultAlbummaterial.setDiffuseMap(defaultAlbumImage);
                    }
                    if(isalphabeticalSorted)
                    {
                        Image defaultAlbumImage = new Image(new FileInputStream(alphabeticalSortedAlbums.get(musicHolder10+scrollCounter)));
                        defaultAlbummaterial.setDiffuseMap(defaultAlbumImage);
                    }
                    if(isreversealphabeticalSorted)
                    {
                        Image defaultAlbumImage = new Image(new FileInputStream(reversealphabeticalSortedAlbums.get(musicHolder10+scrollCounter)));
                        defaultAlbummaterial.setDiffuseMap(defaultAlbumImage);
                    }
                    if(ispopularitySorted)
                    {
                        Image defaultAlbumImage = new Image(new FileInputStream(popularitySortedAlbums.get(musicHolder10+scrollCounter)));
                        defaultAlbummaterial.setDiffuseMap(defaultAlbumImage);
                    }
                    if(isreversepopularitySorted)
                    {
                        Image defaultAlbumImage = new Image(new FileInputStream(reversepopularitySortedAlbums.get(musicHolder10+scrollCounter)));
                        defaultAlbummaterial.setDiffuseMap(defaultAlbumImage);
                    }

                }
                catch (Exception E)
                {
                    System.out.println("File Not Found");
                }
                try
                {
                    if(isdefaultSorted)
                    {
                        if (activeClip != null) {
                            activeClip.stop();
                        }
                        activeClip = new Audio((preSongsFile.get(musicHolder10+scrollCounter)));
                        activeClip.play();
                    }
                    if(isalphabeticalSorted)
                    {
                        if (activeClip != null) {
                            activeClip.stop();
                        }
                        activeClip = new Audio((alphabeticalSortedPRE.get(musicHolder10+scrollCounter)));
                        activeClip.play();
                    }
                    if(isreversealphabeticalSorted)
                    {
                        if (activeClip != null) {
                            activeClip.stop();
                        }
                        activeClip = new Audio((reversealphabeticalSortedPRE.get(musicHolder10+scrollCounter)));
                        activeClip.play();
                    }
                    if(ispopularitySorted)
                    {
                        if (activeClip != null) {
                            activeClip.stop();
                        }
                        activeClip = new Audio((popularitySortedPRE.get(musicHolder10+scrollCounter)));
                        activeClip.play();
                    }
                    if(isreversepopularitySorted)
                    {
                        if (activeClip != null) {
                            activeClip.stop();
                        }
                        activeClip = new Audio((reversepopularitySortedPRE.get(musicHolder10+scrollCounter)));
                        activeClip.play();
                    }
                }
                catch(Exception E)
                {
                    System.out.println("ERROR: Audio");
                }
            });

            musicButton11.setOnMouseClicked(event-> {
                isHighlighted1=false;
                isHighlighted2=false;
                isHighlighted3=false;
                isHighlighted4=false;
                isHighlighted5=false;
                isHighlighted6=false;
                isHighlighted7=false;
                isHighlighted8=false;
                isHighlighted9=false;
                isHighlighted10=false;
                isHighlighted11=true;
                isHighlighted12=false;
                if(albumNames.get(musicHolder11+scrollCounter).equals("The Chaos Chapter: FREEZE"))
                {
                    albumContentsText.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 12));
                }
                else
                {
                    albumContentsText.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 20));
                }
                if(isdefaultSorted)
                {
                    albumContentsText.setText(albumNames.get(musicHolder11+scrollCounter));
                }
                if(isalphabeticalSorted)
                {
                    albumContentsText.setText(alphabeticalSortedAlbumsNames.get(musicHolder11+scrollCounter));
                }
                if(isreversealphabeticalSorted)
                {
                    albumContentsText.setText(reversepopularitySortedAlbumsNames.get(musicHolder11+scrollCounter));
                }
                if(ispopularitySorted)
                {
                    albumContentsText.setText(popularitySortedAlbumsNames.get(musicHolder11+scrollCounter));
                }
                if(isreversepopularitySorted)
                {
                    albumContentsText.setText(reversepopularitySortedAlbumsNames.get(musicHolder11+scrollCounter));
                }
                musicText11.setFill(Color.RED);
                musicButton11.setMaterial(higlightedmusicbuttonmaterial);
                musicText1.setFill(Color.BLACK);
                musicText2.setFill(Color.BLACK);
                musicText3.setFill(Color.BLACK);
                musicText4.setFill(Color.BLACK);
                musicText5.setFill(Color.BLACK);
                musicText6.setFill(Color.BLACK);
                musicText7.setFill(Color.BLACK);
                musicText8.setFill(Color.BLACK);
                musicText9.setFill(Color.BLACK);
                musicText10.setFill(Color.BLACK);
                musicText12.setFill(Color.BLACK);
                musicButton1.setMaterial(musicButtonmaterial);
                musicButton2.setMaterial(musicButtonmaterial);
                musicButton3.setMaterial(musicButtonmaterial);
                musicButton4.setMaterial(musicButtonmaterial);
                musicButton5.setMaterial(musicButtonmaterial);
                musicButton6.setMaterial(musicButtonmaterial);
                musicButton7.setMaterial(musicButtonmaterial);
                musicButton8.setMaterial(musicButtonmaterial);
                musicButton9.setMaterial(musicButtonmaterial);
                musicButton10.setMaterial(musicButtonmaterial);
                musicButton12.setMaterial(musicButtonmaterial);
                try
                {
                    if(isdefaultSorted)
                    {
                        Image defaultAlbumImage = new Image(new FileInputStream(albumPaths.get(musicHolder11+scrollCounter)));
                        defaultAlbummaterial.setDiffuseMap(defaultAlbumImage);
                    }
                    if(isalphabeticalSorted)
                    {
                        Image defaultAlbumImage = new Image(new FileInputStream(alphabeticalSortedAlbums.get(musicHolder11+scrollCounter)));
                        defaultAlbummaterial.setDiffuseMap(defaultAlbumImage);
                    }
                    if(isreversealphabeticalSorted)
                    {
                        Image defaultAlbumImage = new Image(new FileInputStream(reversealphabeticalSortedAlbums.get(musicHolder11+scrollCounter)));
                        defaultAlbummaterial.setDiffuseMap(defaultAlbumImage);
                    }
                    if(ispopularitySorted)
                    {
                        Image defaultAlbumImage = new Image(new FileInputStream(popularitySortedAlbums.get(musicHolder11+scrollCounter)));
                        defaultAlbummaterial.setDiffuseMap(defaultAlbumImage);
                    }
                    if(isreversepopularitySorted)
                    {
                        Image defaultAlbumImage = new Image(new FileInputStream(reversepopularitySortedAlbums.get(musicHolder11+scrollCounter)));
                        defaultAlbummaterial.setDiffuseMap(defaultAlbumImage);
                    }

                }
                catch (Exception E)
                {
                    System.out.println("File Not Found");
                }
                try
                {
                    if(isdefaultSorted)
                    {
                        if (activeClip != null) {
                            activeClip.stop();
                        }
                        activeClip = new Audio((preSongsFile.get(musicHolder11+scrollCounter)));
                        activeClip.play();
                    }
                    if(isalphabeticalSorted)
                    {
                        if (activeClip != null) {
                            activeClip.stop();
                        }
                        activeClip = new Audio((alphabeticalSortedPRE.get(musicHolder11+scrollCounter)));
                        activeClip.play();
                    }
                    if(isreversealphabeticalSorted)
                    {
                        if (activeClip != null) {
                            activeClip.stop();
                        }
                        activeClip = new Audio((reversealphabeticalSortedPRE.get(musicHolder11+scrollCounter)));
                        activeClip.play();
                    }
                    if(ispopularitySorted)
                    {
                        if (activeClip != null) {
                            activeClip.stop();
                        }
                        activeClip = new Audio((popularitySortedPRE.get(musicHolder11+scrollCounter)));
                        activeClip.play();
                    }
                    if(isreversepopularitySorted)
                    {
                        if (activeClip != null) {
                            activeClip.stop();
                        }
                        activeClip = new Audio((reversepopularitySortedPRE.get(musicHolder11+scrollCounter)));
                        activeClip.play();
                    }
                }
                catch(Exception E)
                {
                    System.out.println("ERROR: Audio");
                }
            });

            musicButton12.setOnMouseClicked(event-> {
                isHighlighted1=false;
                isHighlighted2=false;
                isHighlighted3=false;
                isHighlighted4=false;
                isHighlighted5=false;
                isHighlighted6=false;
                isHighlighted7=false;
                isHighlighted8=false;
                isHighlighted9=false;
                isHighlighted10=false;
                isHighlighted11=false;
                isHighlighted12=true;
                if(albumNames.get(musicHolder12+scrollCounter).equals("The Chaos Chapter: FREEZE"))
                {
                    albumContentsText.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 12));
                }
                else {
                    albumContentsText.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 20));
                }
                if(isdefaultSorted)
                {
                    albumContentsText.setText(albumNames.get(musicHolder12+scrollCounter));
                }
                if(isalphabeticalSorted)
                {
                    albumContentsText.setText(alphabeticalSortedAlbumsNames.get(musicHolder12+scrollCounter));
                }
                if(isreversealphabeticalSorted)
                {
                    albumContentsText.setText(reversepopularitySortedAlbumsNames.get(musicHolder12+scrollCounter));
                }
                if(ispopularitySorted)
                {
                    albumContentsText.setText(popularitySortedAlbumsNames.get(musicHolder12+scrollCounter));
                }
                if(isreversepopularitySorted)
                {
                    albumContentsText.setText(reversepopularitySortedAlbumsNames.get(musicHolder12+scrollCounter));
                }
                musicText12.setFill(Color.RED);
                musicButton12.setMaterial(higlightedmusicbuttonmaterial);
                musicText1.setFill(Color.BLACK);
                musicText2.setFill(Color.BLACK);
                musicText3.setFill(Color.BLACK);
                musicText4.setFill(Color.BLACK);
                musicText5.setFill(Color.BLACK);
                musicText6.setFill(Color.BLACK);
                musicText7.setFill(Color.BLACK);
                musicText8.setFill(Color.BLACK);
                musicText9.setFill(Color.BLACK);
                musicText10.setFill(Color.BLACK);
                musicText11.setFill(Color.BLACK);
                musicButton1.setMaterial(musicButtonmaterial);
                musicButton2.setMaterial(musicButtonmaterial);
                musicButton3.setMaterial(musicButtonmaterial);
                musicButton4.setMaterial(musicButtonmaterial);
                musicButton5.setMaterial(musicButtonmaterial);
                musicButton6.setMaterial(musicButtonmaterial);
                musicButton7.setMaterial(musicButtonmaterial);
                musicButton8.setMaterial(musicButtonmaterial);
                musicButton9.setMaterial(musicButtonmaterial);
                musicButton10.setMaterial(musicButtonmaterial);
                musicButton11.setMaterial(musicButtonmaterial);
                try
                {
                    if(isdefaultSorted)
                    {
                        Image defaultAlbumImage = new Image(new FileInputStream(albumPaths.get(musicHolder12+scrollCounter)));
                        defaultAlbummaterial.setDiffuseMap(defaultAlbumImage);
                    }
                    if(isalphabeticalSorted)
                    {
                        Image defaultAlbumImage = new Image(new FileInputStream(alphabeticalSortedAlbums.get(musicHolder12+scrollCounter)));
                        defaultAlbummaterial.setDiffuseMap(defaultAlbumImage);
                    }
                    if(isreversealphabeticalSorted)
                    {
                        Image defaultAlbumImage = new Image(new FileInputStream(reversealphabeticalSortedAlbums.get(musicHolder12+scrollCounter)));
                        defaultAlbummaterial.setDiffuseMap(defaultAlbumImage);
                    }
                    if(ispopularitySorted)
                    {
                        Image defaultAlbumImage = new Image(new FileInputStream(popularitySortedAlbums.get(musicHolder12+scrollCounter)));
                        defaultAlbummaterial.setDiffuseMap(defaultAlbumImage);
                    }
                    if(isreversepopularitySorted)
                    {
                        Image defaultAlbumImage = new Image(new FileInputStream(reversepopularitySortedAlbums.get(musicHolder12+scrollCounter)));
                        defaultAlbummaterial.setDiffuseMap(defaultAlbumImage);
                    }

                }
                catch (Exception E)
                {
                    System.out.println("File Not Found");
                }
                try
                {
                    if(isdefaultSorted)
                    {
                        if (activeClip != null) {
                            activeClip.stop();
                        }
                        activeClip = new Audio((preSongsFile.get(musicHolder12+scrollCounter)));
                        activeClip.play();
                    }
                    if(isalphabeticalSorted)
                    {
                        if (activeClip != null) {
                            activeClip.stop();
                        }
                        activeClip = new Audio((alphabeticalSortedPRE.get(musicHolder12+scrollCounter)));
                        activeClip.play();
                    }
                    if(isreversealphabeticalSorted)
                    {
                        if (activeClip != null) {
                            activeClip.stop();
                        }
                        activeClip = new Audio((reversealphabeticalSortedPRE.get(musicHolder12+scrollCounter)));
                        activeClip.play();
                    }
                    if(ispopularitySorted)
                    {
                        if (activeClip != null) {
                            activeClip.stop();
                        }
                        activeClip = new Audio((popularitySortedPRE.get(musicHolder12+scrollCounter)));
                        activeClip.play();
                    }
                    if(isreversepopularitySorted)
                    {
                        if (activeClip != null) {
                            activeClip.stop();
                        }
                        activeClip = new Audio((reversepopularitySortedPRE.get(musicHolder12+scrollCounter)));
                        activeClip.play();
                    }
                }
                catch(Exception E)
                {
                    System.out.println("ERROR: Audio");
                }
            });




            screen1.setOnMouseClicked(event-> {
                try {
                    if (activeClip != null) {
                        activeClip.stop();
                    }
                    activeClip = new Audio("Music-OMG.wav");
                    activeClip.play();
                } catch (Exception E) {
                    System.out.println("ERROR: Audio");
                }

            });




        }
    }


    public static void main(String[] args) throws UnsupportedAudioFileException, IOException, LineUnavailableException
    {
        //MAIN STUFF
        launch(args);






    }

    //stage properties go here
    @Override
    public void start(Stage primaryStage) throws Exception {

        final Rotate xRotate = new Rotate(-90, Rotate.X_AXIS);
        final Rotate yRotate = new Rotate(0, Rotate.Y_AXIS);
        final Rotate zRotate = new Rotate(0, Rotate.Z_AXIS);

        Robot r = new Robot();





        RotateCamera rotateCamera = new RotateCamera();


        //light
//        PointLight pointLight = new PointLight();
//        pointLight.getTransforms().add(new Translate(0,0,0));
//        rotateCamera.getTransforms().setAll(pointLight.getTransforms());

        //image
        Image soliImage = new Image(new FileInputStream("C:\\Users\\Dtang\\CS Projects\\zer0\\soli.png"));
        ImageView imageView = new ImageView(soliImage);
        Group imageRoot = new Group(imageView);
        imageView.setFocusTraversable(true);

        //background Image
        Image spaceBackgroundImage = new Image(new FileInputStream("C:\\Users\\Dtang\\CS Projects\\zer0\\spaceBackground.webp"));
        ImageView spaceBackgroundImageView = new ImageView(spaceBackgroundImage);
        Group spaceBackgroundImageRoot = new Group(spaceBackgroundImageView);
        spaceBackgroundImageView.setFocusTraversable(true);
        spaceBackgroundImageView.getTransforms().add(new Translate(-spaceBackgroundImage.getWidth()/2,-spaceBackgroundImage.getHeight(),800));


        //weird group thing used to take group elements and add them
        Group root= new Group();
        Group game1Group = new Group();
        game1Group.getChildren().addAll(rotateCamera,imageRoot,spaceBackgroundImageRoot);
        root.getChildren().add(game1Group);




        Scene scene = new Scene(root,SCENE_WIDTH, SCENE_HEIGHT,true, SceneAntialiasing.BALANCED);
        scene.setFill(Color.BLACK);

        //stage holds scene
        primaryStage.setFullScreen(true);
        scene.setCamera(rotateCamera.camera);
        primaryStage.setScene(scene);
        scene.getCursor();
        scene.setCursor(Cursor.CROSSHAIR);
        primaryStage.show();








        //rotating options
        scene.setOnKeyPressed((KeyEvent e) -> {
            System.out.println(rotateCamera.getTranslateY());
            KeyCode code = e.getCode();
            switch (code) {
                case W:
                    rotateCamera.translateZProperty().set(rotateCamera.getTranslateZ() + 10);
                    break;
                case S:
                    rotateCamera.translateZProperty().set(rotateCamera.getTranslateZ() - 10);
                    break;
                case A:
                    rotateCamera.translateXProperty().set(rotateCamera.getTranslateX() + 10);
                    break;
                case D:
                    rotateCamera.translateXProperty().set(rotateCamera.getTranslateX() - 10);
                    break;
                case LEFT:
                    rotateCamera.yRotate.setAngle(rotateCamera.yRotate.getAngle() - 10);
                    break;
                case RIGHT:
                    rotateCamera.yRotate.setAngle(rotateCamera.yRotate.getAngle() + 10);
                    break;
                case UP:
                    rotateCamera.xRotate.setAngle(rotateCamera.xRotate.getAngle() + 10);
                    break;
                case DOWN:
                    rotateCamera.xRotate.setAngle(rotateCamera.xRotate.getAngle() - 10);
                    break;
                case Q:
                    rotateCamera.xRotate.setAngle(-90);
                    rotateCamera.yRotate.setAngle(0);
                    rotateCamera.zRotate.setAngle(0);
                    rotateCamera.setTranslateX(0);
                    rotateCamera.setTranslateY(0);
                    rotateCamera.setTranslateZ(0);
                    break;
                case R:
                    r.mouseMove(800,400);
                    break;
//                case SPACE:
//                    try
//                    {
//                        Audio a = new Audio("Default Music");
//                        a.pause();
//                    }
//                    catch(Exception b)
//                    {
//                        System.out.println("Error Audio");
//                    }
//                    break;
            }
        });



//        360 mouse movement I'm not sure how to keep the crosshair in the center so I'll just comment this out for now
//        scene.setOnMouseMoved(event -> {
//            double changeInX = event.getSceneX() - orgX;
//            double changeInY = event.getSceneY() - orgY;
//            if (changeInX > 0) {
//                rotateCamera.yRotate.setAngle(rotateCamera.yRotate.getAngle() - 0.5);
//            }
//            else if (changeInX < 0) {
//                rotateCamera.yRotate.setAngle(rotateCamera.yRotate.getAngle() + 0.5);
//            }
//            if (changeInY > 0) {
//                rotateCamera.xRotate.setAngle(rotateCamera.xRotate.getAngle() - 0.5);
//            }
//            else if (changeInY < 0) {
//                rotateCamera.xRotate.setAngle(rotateCamera.xRotate.getAngle() + 0.5);
//            }
//
//            orgX = event.getSceneX();
//            orgY = event.getSceneY();
//            r.mouseMove(800,400);
//
//        });

//        scene.setOnMouseMoved(event -> {
//            double changeInX = event.getSceneX() - orgX;
//            double changeInY = event.getSceneY() - orgY;
//            if (changeInX > 0) {
//                rotateCamera.yRotate.setAngle(rotateCamera.yRotate.getAngle() - 0.5);
//            }
//            else if (changeInX < 0) {
//                rotateCamera.yRotate.setAngle(rotateCamera.yRotate.getAngle() + 0.5);
//            }
//            if (changeInY > 0) {
//                rotateCamera.xRotate.setAngle(rotateCamera.xRotate.getAngle() - 0.5);
//            }
//            else if (changeInY < 0) {
//                rotateCamera.xRotate.setAngle(rotateCamera.xRotate.getAngle() + 0.5);
//            }
//
//            orgX = event.getSceneX();
//            orgY = event.getSceneY();
//
//        });


    }



}
