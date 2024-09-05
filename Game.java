import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class Game {

    JFrame window;
    Container con;
    JPanel titleNamePanel, startButtonPanel, mainTextPanel, choiceButtonPanel, playerPanel;
    JLabel titleNameLabel, hpLabel, hpLabelNumber, weaponLabel, weaponLabelName; 
    Font titleFont = new Font("Times New Roman", Font.PLAIN, 90);
    Font normalFont = new Font("Times New Roman", Font.PLAIN, 28);
    JButton startButton, choice1, choice2, choice3, choice4;
    JTextArea mainTextArea;
    int playerHP, MonsterHP, silverRing;
    String weapon, position;

    TitleScreenHandler tsHandler = new TitleScreenHandler();
    ButtonHandler BtHandler = new ButtonHandler();

    public static void main(String[] args) {
        new Game();
    }
    public Game(){

        window = new JFrame();
        window.setSize(800, 600);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.getContentPane().setBackground(Color.black);
        window.setLayout(null);
        window.setVisible(true);
        con = window.getContentPane();

        titleNamePanel = new JPanel();
        titleNamePanel.setBounds(100, 100, 600, 150);
        titleNamePanel.setBackground(Color.black);
        titleNameLabel = new JLabel("ADVENTURE");
        titleNameLabel.setForeground(Color.white);
        titleNameLabel.setFont(titleFont);

        startButtonPanel = new JPanel();
        startButtonPanel.setBounds(300, 400, 200, 100);
        startButtonPanel.setBackground(Color.black);

        startButton = new JButton("START");
        startButton.setBackground(Color.black);
        startButton.setForeground(Color.white);
        startButton.setFont(normalFont);
        startButton.addActionListener(tsHandler);
        startButton.setFocusPainted(false);

        titleNamePanel.add(titleNameLabel);
        startButtonPanel.add(startButton);

        con.add(titleNamePanel);
        con.add(startButtonPanel);
    }

    public void createGameScreen(){

        titleNamePanel.setVisible(false);
        startButtonPanel.setVisible(false);

        mainTextPanel = new JPanel();
        mainTextPanel.setBounds(100, 100, 600, 250);
        mainTextPanel.setBackground(Color.black);
        con.add(mainTextPanel);

        mainTextArea = new JTextArea("This is the main text area");
        mainTextArea.setBounds(100, 100, 600, 250);
        mainTextArea.setBackground(Color.black);
        mainTextArea.setForeground(Color.white);
        mainTextArea.setFont(normalFont);
        mainTextArea.setLineWrap(true);
        mainTextPanel.add(mainTextArea);

        choiceButtonPanel = new JPanel();
        choiceButtonPanel.setBounds(250, 350, 300, 150);
        choiceButtonPanel.setBackground(Color.black);
        choiceButtonPanel.setLayout(new GridLayout(4,1));
        con.add(choiceButtonPanel);

        choice1 = new JButton("choice1");
        choice1.setBackground(Color.black);
        choice1.setForeground(Color.white);
        choice1.setFont(normalFont);
        choiceButtonPanel.add(choice1);
        choice1.setFocusPainted(false);
        choice1.addActionListener(BtHandler);
        choice1.setActionCommand("c1");

        choice2 = new JButton("choice2");
        choice2.setBackground(Color.black);
        choice2.setForeground(Color.white);
        choice2.setFont(normalFont);
        choiceButtonPanel.add(choice2);
        choice2.setFocusPainted(false);
        choice2.addActionListener(BtHandler);
        choice2.setActionCommand("c2");

        choice3 = new JButton("choice3");
        choice3.setBackground(Color.black);
        choice3.setForeground(Color.white);
        choice3.setFont(normalFont);
        choiceButtonPanel.add(choice3);
        choice3.setFocusPainted(false);
        choice3.addActionListener(BtHandler);
        choice3.setActionCommand("c3");

        choice4 = new JButton("choice4");
        choice4.setBackground(Color.black);
        choice4.setForeground(Color.white);
        choice4.setFont(normalFont);
        choiceButtonPanel.add(choice4);
        choice4.setFocusPainted(false);
        choice4.addActionListener(BtHandler);
        choice4.setActionCommand("c4");

        playerPanel = new JPanel();
        playerPanel.setBounds(100, 15, 600, 50);
        playerPanel.setBackground(Color.black);
        playerPanel.setLayout(new GridLayout(1,4));
        con.add(playerPanel);
        hpLabel = new JLabel("HP :");
        hpLabel.setFont(normalFont);
        hpLabel.setForeground(Color.white);
        playerPanel.add(hpLabel);
        hpLabelNumber = new JLabel();
        hpLabelNumber.setFont(normalFont);
        hpLabelNumber.setForeground(Color.white);
        playerPanel.add(hpLabelNumber);
        weaponLabel = new JLabel("Weapon :");
        weaponLabel.setFont(normalFont);
        weaponLabel.setForeground(Color.white);
        playerPanel.add(weaponLabel);
        weaponLabelName = new JLabel();
        weaponLabelName.setFont(normalFont);
        weaponLabelName.setForeground(Color.white);
        playerPanel.add(weaponLabelName);

        playerSetup();
    }

    public void playerSetup(){
        playerHP = 15;
        MonsterHP = 20;
        weapon = "knife";
        weaponLabelName.setText(weapon);
        hpLabelNumber.setText("" + playerHP);

        townGate();
    }

    public void townGate(){
        position = "townGate";
        mainTextArea.setText("You are at the Gate of the Town. \nA Guard is standing in front of You. \n\nWhat do you do?");
        choice1.setText("Talk to the Guard");
        choice2.setText("Attack to the Guard");
        choice3.setText("Leave");
        choice4.setText("Exit");
    }

    public void talkGuard(){
        position = "talkGuard";
        mainTextArea.setText("Guard: Hello Stranger. I have never seen You Here. \nI'm Sorry but I cannot let you inside the Town.");
        choice1.setText(">");
        choice2.setText("");
        choice3.setText("");
        choice4.setText("");
    }

    public void attackGuard(){
        position = "attackGuard";
        mainTextArea.setText("Guard: Hey don't be a stupid person! \n\nThe Guard fought back and hit you Hard.\n(You receive 3 damage)");
        playerHP = playerHP - 3;
        hpLabelNumber.setText("" + playerHP);
        choice1.setText(">");
        choice2.setText("");
        choice3.setText("");
        choice4.setText("");
    }

    public void crossRoad(){
        position = "crossRoad";
        mainTextArea.setText("You are at a CrossRoad.\n If You go South, You will go back to the Town");
        choice1.setText("Go North");
        choice2.setText("Go East");
        choice3.setText("Go South");
        choice4.setText("Go West");
    }

    public void North(){
        position = "North";
        mainTextArea.setText("There is a River.\n You can Drink the Water of the River \n (You can Recover Your HP by 2)");
        playerHP = playerHP + 2;
        hpLabelNumber.setText("" + playerHP);
        choice1.setText("Go South");
        choice2.setText("");
        choice3.setText("");
        choice4.setText("");
    }

    public void East(){
        position = "East";
        mainTextArea.setText("You are walking towards the Forest and You found a Sword!\n\n(You have Obtained that Long Sword)");
        weapon = "Long Sword";
        weaponLabelName.setText(weapon);
        choice1.setText("Go West");
        choice2.setText("");
        choice3.setText("");
        choice4.setText("");
    }

    public void West(){
        position = "West";
        MonsterHP = 20;
        mainTextArea.setText("You have Found a Monster\n You have to Encounter a Monster");
        choice1.setText("Fight");
        choice2.setText("Run");
        choice3.setText("");
        choice4.setText("");
    }

    public void Fight(){
        position = "Fight";
        mainTextArea.setText("Monster HP: " + MonsterHP + "\n\nWhat do You do?");
        choice1.setText("Attack");
        choice2.setText("Run");
        choice3.setText("");
        choice4.setText("");
    }

    public void playerAttack(){
        position = "playerAttack";

        int playerDamage = 0;

        if (weapon.equals("knife")) {
            playerDamage = new java.util.Random().nextInt(3);
        }
        else if (weapon.equals("Long Sword")) {
            playerDamage = new java.util.Random().nextInt(10);
        }

        mainTextArea.setText("You attacked the Monster and Gave" + playerDamage + " Damage!");

        MonsterHP = MonsterHP - playerDamage;

        choice1.setText(">");
        choice2.setText("");
        choice3.setText("");
        choice4.setText("");
    }

    public void monsterAttack(){
        position = "monsterAttack";

        int monsterDamage = 0;

        monsterDamage = new java.util.Random().nextInt(6);

        mainTextArea.setText(("The Monster attacked on You and gave" + monsterDamage + " damage!"));

        playerHP = playerHP - monsterDamage;
        hpLabelNumber.setText("" + playerHP);

        choice1.setText(">");
        choice2.setText("");
        choice3.setText("");
        choice4.setText("");
    }

    public void win(){
        position = "win";

        mainTextArea.setText("You Defeated the Monster!\n The Monster dropped a Ring! \n\n (You Obtained a Silver Ring)");

        silverRing = 1;

        choice1.setText("Go East");
        choice2.setText("");
        choice3.setText("");
        choice4.setText("");
    }

    public void lose(){
        position = "lose";

        mainTextArea.setText("You are Dead! \n\n <GAME OVER>");

        choice1.setText("");
        choice2.setText("");
        choice3.setText("");
        choice4.setText("");
        choice1.setVisible(false);
        choice2.setVisible(false);
        choice3.setVisible(false);
        choice4.setVisible(false);
    }

    public void ending(){
        position = "ending";

        mainTextArea.setText("Guard: Oh You killed that Monster!?\n Thank You So Much. You are a True Hero! \n Welcome to Our Town! \n\n<THE END>");

        choice1.setText("");
        choice2.setText("");
        choice3.setText("");
        choice4.setText("");
        choice1.setVisible(false);
        choice2.setVisible(false);
        choice3.setVisible(false);
        choice4.setVisible(false);
    }

// ---------------------------------------------------------------------------------------------------------------------------------------------

    public class TitleScreenHandler implements ActionListener {

        public void actionPerformed(ActionEvent event){

            createGameScreen();
        }
    }

    public class ButtonHandler implements ActionListener {
        
        public void actionPerformed(ActionEvent event){

            String yourChoice = event.getActionCommand();

            switch (position) {
                case "townGate":
                switch (yourChoice) {
                    case "c1": 
                    if (silverRing==1) {
                        ending();
                    }
                    else{
                        talkGuard();
                    }
                    break;
                    case "c2": attackGuard(); break;
                    case "c3": crossRoad(); break;
                }
                break;
                case"talkGuard":
                switch (yourChoice) {
                    case"c1": townGate(); break;
                }
                break;
                case "attackGuard":
                switch(yourChoice){
                    case "c1": townGate(); break;
                }
                break;
                case "crossRoad":
                switch (yourChoice) {
                    case "c1": North(); break;
                    case "c2": East(); break;
                    case "c3": townGate(); break;
                    case "c4": West(); break;
                }
                break;
                case "North":
                switch (yourChoice) {
                    case "c1": crossRoad(); break;
                }
                break;
                case "East":
                switch (yourChoice) {
                    case "c1": crossRoad(); break;
                }
                break;
                case "West":
                switch (yourChoice) {
                    case "c1": Fight(); break;
                    case "c2": crossRoad(); break;
                }
                break;
                case "Fight":
                switch (yourChoice) {
                    case "c1": playerAttack(); break;
                    case "c2": crossRoad(); break;
                }
                break;
                case "playerAttack":
                switch (yourChoice) {
                    case "c1": 
                    if (MonsterHP<1) {
                        win();
                    }
                    else{
                        monsterAttack();
                    }
                    break;
                }
                break;
                case "monsterAttack":
                switch (yourChoice) {
                    case "c1": 
                    if (playerHP<1) {
                        lose();
                    }
                    else{
                        Fight();
                    }
                    break;
                }
                break;
                case "win":
                switch (yourChoice) {
                    case "c1": crossRoad(); break;
                }
                break;
            }

        }
    }
}